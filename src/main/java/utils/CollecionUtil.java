package utils;

import java.util.Collection;
import java.util.Map;

/**
 * @Autor: bin.liu
 * @Desciption: ���Ϲ�����
 * @Date: Created in 15:47 2017/9/5
 */
public class CollecionUtil {

    /**
     * �жϼ��ϲ�Ϊ��
     * @param map
     * @return
     */
    public static boolean isNotEmpty(Map<Class<?>,Object> map){
        return map.size() == 0 ? false : true;
    }

    /**
     * �жϼ����Ƿ�Ϊ��
     * @param map
     * @return
     */
    public static boolean isEmpty(Map<Class<?>,Object> map){
        return map.size() == 0 ? true : false;
    }
}
