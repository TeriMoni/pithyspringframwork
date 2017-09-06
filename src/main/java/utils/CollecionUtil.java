package utils;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @Autor: bin.liu
 * @Desciption: ���Ϲ�����
 * @Date: Created in 15:47 2017/9/5
 */
public class CollecionUtil {

    /**
     * �ж�map���ϲ�Ϊ��
     * @param map
     * @return
     */
    public static boolean isNotEmpty(Map<Class<?>,Object> map){
        return map.size() == 0 ? false : true;
    }

    /**
     * �ж�map�����Ƿ�Ϊ��
     * @param map
     * @return
     */
    public static boolean isEmpty(Map<Class<?>,Object> map){
        return map.size() == 0 ? true : false;
    }

    /**
     * �ж�set��ϲ�Ϊ��
     * @param set
     * @return
     */
    public static boolean isNotEmpty(Set<Class<?>> set){
        return set.size() == 0 ? false : true;
    }

    /**
     * �ж�set���Ϊ��
     * @param set
     * @return
     */
    public static boolean isEmpty(Set<Class<?>> set){
        return set.size() == 0 ? false : true;
    }
}
