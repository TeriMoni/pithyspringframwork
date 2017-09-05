package helper;

import common.ConfigConstant;
import utils.PropsUtil;

import java.util.Properties;

/**
 * �����ļ�������
 * Created by bin.liu on 2017/9/4.
 */
public class ConfigerHelper {

    private  static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    /**
     * ��ȡjdbc����
     * @return String
     */
    public static String  getJdbcDriver(){
        return  PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_DRIVER);
    }

    /**
     * ��ȡjdbc���ӵ�ַ
     * @return String
     */
    public static String getJdbcUrl(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_URL);
    }

    /**
     * ��ȡjdbc�û���
     * @return String
     */
    public static String getJdbcUsername(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_USERNAME);
    }

    /**
     * ��ȡjdbc ����
     * @return String
     */
    public static String getJdbcPassword(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_PASSWORD);
    }

    /**
     * ��ȡӦ�û�������
     * @return String
     */
    public static String getAppBasePackage(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_BASE_PACKAGE);
    }

    /**
     * ��ȡӦ��jsp·��,�ṩĬ��ֵ
     * @return String
     */
    public static String getAppJspPath(){
        return  PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_JSP_PATH,"/WEB-INF/view/");
    }

    /**
     * ��ȡӦ�þ�̬��Դ·��
     * @return
     */
    public static String getAppResourcePath(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_RESOURCE_PATH,"/resource/");
    }
}
