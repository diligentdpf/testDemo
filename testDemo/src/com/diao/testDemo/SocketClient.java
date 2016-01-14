package com.diao.testDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    private Socket socket;

    public SocketClient() {
        try {
            socket = new Socket("192.168.1.142", 8001);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // * 该线程用于接收服务端发送过来的信息
    public class ServerHandler implements Runnable {
        // @Override
        public void run() {
            try {
                InputStreamReader isr = new InputStreamReader(socket.getInputStream(), "UTF-8");
                BufferedReader br = new BufferedReader(isr);
                while (true) {
                    System.out.println(new String(br.readLine().getBytes("utf-8"), "UTF-8"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 定义方法inputNickName()，用于输入昵称
    public void inputNickName(Scanner scan) throws Exception {
        String nickName = null;
        PrintWriter pw =
                new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
        BufferedReader br =
                new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        while (true) {
            System.out.println("请输入昵称:");
            nickName = new String(scan.nextLine().getBytes("utf-8"), "UTF-8");
            System.out.println(nickName);
            if (nickName.trim().equals("")) {
                System.out.println("昵称不能为空！");
            } else {
                pw.println(nickName);
                String pass = br.readLine();
                if (pass != null && pass.equals("yzy")) {
                    System.out.println("昵称已经被占用！");
                } else {
                    System.out.println("亲爱的" + nickName + ", 你好.");
                    break;
                }
            }
        }
    }

    public void start() {
        try {
            Scanner scan = new Scanner(System.in);
            inputNickName(scan);
            ServerHandler handler = new ServerHandler();
            Thread ct = new Thread(handler);
            ct.setDaemon(true);
            ct.start();
            PrintWriter pw =
                    new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
            while (true) {
                String str = scan.nextLine();
                str = new String(str.getBytes("utf-8"), "utf-8");
                System.out.println(str);
                pw.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        SocketClient client = new SocketClient();
        client.start();
        // Scanner sc = new Scanner(System.in);
        // System.out.println("请输入：");
        // String str = sc.nextLine();
        // System.out.println(str);
        // byte[] b = str.getBytes("utf-8");
        // System.out.println(new String(b, "utf-8"));

    }
}
