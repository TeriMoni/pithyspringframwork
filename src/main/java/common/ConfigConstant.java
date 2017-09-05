package common;

/**
 * 常量接口
 * Created by bin.liu on 2017/9/4.
 */
public interface ConfigConstant {

    String CONFIG_FILE = "pithy.properties";            //配置文件名称
    String JDBC_DRIVER = "pithy.framework.jdbc.driver"; //jdbc 驱动
    String JDBC_URL = "pithy.framework.jdbc.url";   // jdbc url
    String JDBC_USERNAME = "pithy.framework.jdbc.username"; //jdbc 用户名
    String JDBC_PASSWORD = "pithy.framework.jdbc.password"; // jdbc 密码
    String APP_BASE_PACKAGE = "pithy.framework.app.base_package"; // 项目打包包名
    String APP_JSP_PATH = "pithy.framework.app.jsp_path"; //视图jsp页面存放路径
    String APP_RESOURCE_PATH = "pithy.framework.app.resource_path"; //img,css,js 等资源存放路径

}
