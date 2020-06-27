package com.zszdevelop.planman.base;

import android.text.TextUtils;

import com.zszdevelop.planman.bean.BaseUser;
import com.zszdevelop.planman.bean.BodyData;
import com.zszdevelop.planman.config.Config;
import com.zszdevelop.planman.config.UserConfig;
import com.zszdevelop.planman.utils.SharedPreferencesUtil;

public class Helper {


    private static Helper helper = null;
    private BaseUser baseUser;
    private BodyData bodyData;

    public BodyData getBodyData() {
        return bodyData;
    }

    public void setBodyData(BodyData bodyData) {
        this.bodyData = bodyData;
    }

    public BaseUser getBaseUser() {
        return baseUser;
    }

    public void setBaseUser(BaseUser baseUser) {
        this.baseUser = baseUser;
    }

    public static Helper getInstance() {
        if (helper == null) {
            helper = new Helper();
        }
        return helper;

    }



    /**
     * 判断用户是否已经登录的状态。默认返回false。
     *
     * @return true/false
     */
    public static final boolean getLoginStatus() {
        int user_id = SharedPreferencesUtil.getInstance().getInt(UserConfig.USER_ID);
        String auth_token = SharedPreferencesUtil.getInstance().getString(UserConfig.AUTH_TOKEN);
       Boolean isLogin =  SharedPreferencesUtil.getInstance().getBoolean(Config.IS_LOGIN, false);

//        String user_id = SharedPreferencesUtil.getString(UserConfig.USER_ID);
        if (user_id == 0 || TextUtils.isEmpty(auth_token) || !isLogin) {
            return false;
        } else {
            return true;
        }
    }

    public static final int getUserId() {
        //int user_id = SharedPreferencesUtil.getInstance().getInt(UserConfig.USER_ID);
        int user_id = 10001;

    return  user_id;}

    public static final String getToken() {
        //String token = SharedPreferencesUtil.getInstance().getString(UserConfig.AUTH_TOKEN);
       String token = "aaa";

    return  token;}

}
