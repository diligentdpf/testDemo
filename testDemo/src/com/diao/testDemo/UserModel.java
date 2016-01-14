package com.diao.testDemo;



public class UserModel  {

    private static final long serialVersionUID = -1855097564840559048L;
    /** 用户ID */
    private long userId;
    /** 性别1是男0是女 */
    private int userSex;
    /** 联系方式 */
    private String phone;
    /** 妮称 */
    private String userAlias;
    /** 图片ID */
    private long pictureId;
    /** 用户可用积分 */
    private int userIntegral;
    /** 用户真实姓名 */
    private String realName;
    /** 用户的登录密码 */
    private String password;
    /** 年龄 */
    private int age;
    /** 国家id */
    private long countryId;
    /** 省/州id */
    private long provinceId;
    /** 城市Id */
    private long cityId;
    /** 码表Id */
    private long codeTableId;
    /** 积分集合 */
    /** 登录方式（验证码登录，密码登录 **/
    private int loginFlag;
    /** 登录验证码 **/
    private String verifyCode;
    /** 活动收藏数 **/
    private int activityColletCount;
    /** 足迹收藏数 **/
    private int trackCollectCount;
    /** 不同种状态的订单数量 **/
    private int serviceCollectCount;
    private int wiatPayOrdersCount;
    private int paidOrdersCount;
    private int conductOrdersCount;
    private int waitCommentOrdersCount;
    private int refundOrdersCount;
    /** 未读信息数量 */
    private int letterCount;
    /** 头像链接 */
    private String pictureURL;
    /**省名*/
    private String provinceName;
    /**城市名*/
    private String cityName;
    /** 手机唯一标识 */
    private String  phoneIMEI;
    /** 推荐人Id */
    private long recommandId;
    

    public String getPhoneIMEI() {
		return phoneIMEI;
	}

	public void setPhoneIMEI(String phoneIMEI) {
		this.phoneIMEI = phoneIMEI;
	}

	public long getRecommandId() {
		return recommandId;
	}

	public void setRecommandId(long recommandId) {
		this.recommandId = recommandId;
	}

	public int getActivityColletCount() {
        return activityColletCount;
    }

    public void setActivityColletCount(int activityColletCount) {
        this.activityColletCount = activityColletCount;
    }

    public int getTrackCollectCount() {
        return trackCollectCount;
    }

    public void setTrackCollectCount(int trackCollectCount) {
        this.trackCollectCount = trackCollectCount;
    }

    public int getServiceCollectCount() {
        return serviceCollectCount;
    }

    public void setServiceCollectCount(int serviceCollectCount) {
        this.serviceCollectCount = serviceCollectCount;
    }

    public int getWiatPayOrdersCount() {
        return wiatPayOrdersCount;
    }

    public void setWiatPayOrdersCount(int wiatPayOrdersCount) {
        this.wiatPayOrdersCount = wiatPayOrdersCount;
    }

    public int getPaidOrdersCount() {
        return paidOrdersCount;
    }

    public void setPaidOrdersCount(int paidOrdersCount) {
        this.paidOrdersCount = paidOrdersCount;
    }

    public int getConductOrdersCount() {
        return conductOrdersCount;
    }

    public void setConductOrdersCount(int conductOrdersCount) {
        this.conductOrdersCount = conductOrdersCount;
    }

    public int getWaitCommentOrdersCount() {
        return waitCommentOrdersCount;
    }

    public void setWaitCommentOrdersCount(int waitCommentOrdersCount) {
        this.waitCommentOrdersCount = waitCommentOrdersCount;
    }

    public int getRefundOrdersCount() {
        return refundOrdersCount;
    }

    public void setRefundOrdersCount(int refundOrdersCount) {
        this.refundOrdersCount = refundOrdersCount;
    }

    public int getLetterCount() {
        return letterCount;
    }

    public void setLetterCount(int letterCount) {
        this.letterCount = letterCount;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public int getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(int loginFlag) {
        this.loginFlag = loginFlag;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias == null ? null : userAlias.trim();
    }

    public long getPictureId() {
        return pictureId;
    }

    public void setPictureId(long pictureId) {
        this.pictureId = pictureId;
    }

    public int getUserIntegral() {
        return userIntegral;
    }

    public void setUserIntegral(int userIntegral) {
        this.userIntegral = userIntegral;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(long provinceId) {
        this.provinceId = provinceId;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public long getCodeTableId() {
        return codeTableId;
    }

    public void setCodeTableId(long codeTableId) {
        this.codeTableId = codeTableId;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }
    
    public String getProvinceName() {
      return provinceName;
    }

    public void setProvinceName(String provinceName) {
      this.provinceName = provinceName;
    }

    public String getCityName() {
      return cityName;
    }

    public void setCityName(String cityName) {
      this.cityName = cityName;
    }

    @Override
    public String toString() {
      return "UserModel [userId=" + userId + ", userSex=" + userSex + ", phone=" + phone
          + ", userAlias=" + userAlias + ", pictureId=" + pictureId + ", userIntegral="
          + userIntegral + ", realName=" + realName + ", password=" + password + ", age=" + age
          + ", countryId=" + countryId + ", provinceId=" + provinceId + ", cityId=" + cityId
          + ", codeTableId=" + codeTableId + ", loginFlag="
          + loginFlag + ", verifyCode=" + verifyCode + ", activityColletCount="
          + activityColletCount + ", trackCollectCount=" + trackCollectCount
          + ", serviceCollectCount=" + serviceCollectCount + ", wiatPayOrdersCount="
          + wiatPayOrdersCount + ", paidOrdersCount=" + paidOrdersCount + ", conductOrdersCount="
          + conductOrdersCount + ", waitCommentOrdersCount=" + waitCommentOrdersCount
          + ", refundOrdersCount=" + refundOrdersCount + ", letterCount=" + letterCount
          + ", pictureURL=" + pictureURL + ", provinceName=" + provinceName + ", cityName="
          + cityName + "]";
    }

}
