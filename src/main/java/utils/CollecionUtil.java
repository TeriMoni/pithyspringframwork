package utils;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @Autor: bin.liu
 * @Desciption: 集合工具类
 * @Date: Created in 15:47 2017/9/5
 */
public class CollecionUtil {

    /**
     * 判断map集合不为空
     * @param map
     * @return
     */
    public static boolean isNotEmpty(Map<Class<?>,Object> map){
        return map.size() == 0 ? false : true;
    }

    /**
     * 判断map集合是否为空
     * @param map
     * @return
     */
    public static boolean isEmpty(Map<Class<?>,Object> map){
        return map.size() == 0 ? true : false;
    }

    /**
     * 判断set结合不为空
     * @param set
     * @return
     */
    public static boolean isNotEmpty(Set<Class<?>> set){
        return set.size() == 0 ? false : true;
    }

    /**
     * 判断set结合为空
     * @param set
     * @return
     */
    public static boolean isEmpty(Set<Class<?>> set){
        return set.size() == 0 ? false : true;
    }
}
