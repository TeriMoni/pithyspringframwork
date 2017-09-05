package helper;

import common.ConfigConstant;
import utils.PropsUtil;

import java.util.Properties;

/**
 * 配置文件工具类
 * Created by bin.liu on 2017/9/4.
 */
public class ConfigerHelper {

    private  static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    /**
     * 获取jdbc驱动
     * @return String
     */
    public static String  getJdbcDriver(){
        return  PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_DRIVER);
    }

    /**
     * 获取jdbc连接地址
     * @return String
     */
    public static String getJdbcUrl(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_URL);
    }

    /**
     * 获取jdbc用户名
     * @return String
     */
    public static String getJdbcUsername(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_USERNAME);
    }

    /**
     * 获取jdbc 密码
     * @return String
     */
    public static String getJdbcPassword(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_PASSWORD);
    }

    /**
     * 获取应用基础包名
     * @return String
     */
    public static String getAppBasePackage(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_BASE_PACKAGE);
    }

    /**
     * 获取应用jsp路径,提供默认值
     * @return String
     */
    public static String getAppJspPath(){
        return  PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_JSP_PATH,"/WEB-INF/view/");
    }

    /**
     * 获取应用静态资源路径
     * @return
     */
    public static String getAppResourcePath(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_RESOURCE_PATH,"/resource/");
    }
}
