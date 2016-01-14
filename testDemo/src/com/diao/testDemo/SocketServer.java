package com.diao.testDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class SocketServer {
    private ServerSocket serverSocket = null;
    private Map<String, PrintWriter> allOut;
    private ExecutorService threadPool;

    public SocketServer() {
        try {
            serverSocket = new ServerSocket(8001);
            allOut = new HashMap<String, PrintWriter>();
            threadPool = Executors.newFixedThreadPool(40);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 将输出流存入共享集合，与下面两个方法互斥，保证同步安全
    public synchronized void addOut(String nickName, PrintWriter out) {
        allOut.put(nickName, out);
    }

    // 将给定输出流从共享集合删除
    public synchronized void removeOut(String nickName) {
        allOut.remove(nickName);
    }

    private synchronized void sendMessage(String message) throws UnsupportedEncodingException {
        byte[] b = message.getBytes("utf-8");
        message = new String(b, "UTF-8");
        for (PrintWriter o : allOut.values()) {
            o.println(message);
        }
    }

    public synchronized void sendMessageToOne(String nickName, String message)
            throws UnsupportedEncodingException {
        byte[] b = message.getBytes("utf-8");
        message = new String(b, "UTF-8");
        PrintWriter out = allOut.get(nickName);
        if (out != null) {
            out.println(message);
        }
    }

    public void start() {
        try {
            while (true) {
                System.out.println("等待连接...");
                Socket socket = serverSocket.accept();
                System.out.println("客户端已连接...");
                ClientHandler handler = new ClientHandler(socket);
                threadPool.execute(handler);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class ClientHandler implements Runnable {
        private Socket socket;
        private String nickName;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        // 重写RUN方法
        public void run() {
            PrintWriter pw = null;
            try {
                OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
                pw = new PrintWriter(osw, true);
                nickName = getNickName();
                addOut(nickName, pw);
                Thread.sleep(100);
                sendMessage(" " + nickName + " 已上线");
                InputStream in = socket.getInputStream();
                InputStreamReader isw = new InputStreamReader(in, "UTF-8");
                BufferedReader br = new BufferedReader(isw);
                String message = null;
                while ((message = br.readLine()) != null) {
                    System.out.println(message);
                    if (message.startsWith("\\")) {
                        int index = message.indexOf(":");
                        if (index > 0) {
                            String name = message.substring(1, index);
                            String info = message.substring(index + 1, message.length());
                            info = nickName + "[私信] ： " + info;
                            sendMessageToOne(name, info);
                            continue;
                        }
                    }
                    sendMessage(nickName + "[广播信息] ：" + message);
                }
            } catch (UnsupportedEncodingException ee) {
                System.out.println("消息在转化编码时发生异常！");
                ee.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                removeOut(nickName);
                try {
                    sendMessage(nickName + "已下线");
                } catch (UnsupportedEncodingException e1) {
                    System.out.println("消息在转化编码时发生异常！");
                    e1.printStackTrace();
                }
                System.out.println("当前在线人数：" + allOut.size());
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private String getNickName() throws Exception {
            try {
                OutputStream out = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
                PrintWriter pw = new PrintWriter(osw, true);
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader br = new BufferedReader(isr);
                String nickName = br.readLine();
                while (true) {
                    if (nickName.trim().equals("")) {
                        pw.println("用户名不合法");
                    }
                    if (allOut.containsKey(nickName)) {
                        pw.println("yzy");
                    } else {
                        pw.println("可以使用");
                        return nickName;
                    }
                    nickName = br.readLine();
                }
            } catch (Exception e) {
                throw e;
            }
        }

    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer();
        server.start();
    }

}
