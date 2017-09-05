package utils;

import org.apache.commons.lang3.StringUtils;

/**
 * ����ת��������
 * Created by bin.liu on 2017/9/4.
 */
public class CastUtil {


    /**
     * תΪString��
     * @param obj
     * @return
     */
    public static String castString(Object obj) {
        return CastUtil.castString(obj, "");
    }


    /**
     * תΪString�ͣ��ṩĬ��ֵ��
     * @param obj
     * @param defaultValue
     * @return
     */
    public static String castString(Object obj, String defaultValue) {
        return obj != null ? String.valueOf(obj) : defaultValue;
    }


    /**
     * תΪdouble��
     * @param obj
     * @return
     */
    public static double castDouble(Object obj) {
        return castDouble(obj, 0d);
    }


    /**
     * תΪdouble�ͣ��ṩĬ��ֵ��
     * @param obj
     * @param defaultValue
     * @return
     */
    public static double castDouble(Object obj, Double defaultValue) {
        double doubleValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtils.isNotEmpty(strValue)) {
                try {
                    doubleValue = Double.parseDouble(strValue);
                } catch (NumberFormatException e) {
                    defaultValue = defaultValue;
                }

            }
        }
        return doubleValue;
    }


    /**
     * תΪlong��
     * @param obj
     * @return
     */
    public static long castLong(Object obj) {
        return castLong(obj, 0);
    }


    /**
     * תΪlong�ͣ��ṩĬ��ֵ��
     * @param obj
     * @param defaultValue
     * @return
     */
    public static long castLong(Object obj, long defaultValue) {
        long longValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtils.isNotEmpty(strValue)) {
                try {
                    longValue = Long.parseLong(strValue);
                }catch (NumberFormatException e){
                    longValue=defaultValue;
                }

            }
        }
        return longValue;
    }


    /**
     * תΪint��
     * @param obj
     * @return
     */
    public static int castInt(Object obj){
        return castInt(obj,0);
    }

    /**
     * תΪint��(�ṩĬֵ)
     * @param obj
     * @param defaultValue
     * @return
     */
    public static int castInt(Object obj,int defaultValue){
        int intValue=defaultValue;
        if (obj!=null){
            String strValue=castString(obj);
            if(StringUtils.isNotEmpty(strValue)){
                try {
                    intValue=Integer.parseInt(strValue);
                }catch (NumberFormatException e){
                    intValue=defaultValue;
                }

            }
        }
        return intValue;
    }


    /**
     * תΪboolean��
     * @param obj
     * @return
     */
    public static boolean castBoolean(Object obj){
        return castBoolean(obj,false);
    }

    /**
     * תΪboolean��(�ṩĬ��ֵ)
     * @param obj
     * @param defaultValue
     * @return
     */
    public static boolean castBoolean(Object obj,boolean defaultValue){
        boolean booleanValue=defaultValue;
        if(obj!=null){
            booleanValue=Boolean.parseBoolean(castString(obj));
        }
        return booleanValue;
    }
}
