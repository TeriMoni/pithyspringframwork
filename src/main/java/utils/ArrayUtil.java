package utils;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @Autor: bin.liu
 * @Desciption: ���鹤����
 * @Date: Created in 14:56 2017/9/5
 */
public class ArrayUtil {

    /**
     * �ж������Ƿ�ǿ�
     * @param array
     * @return
     */
    public static boolean isNotEmpty(Object[] array){
        return !ArrayUtils.isEmpty(array);
    }

    /**
     * �ж������Ƿ�Ϊ��
     * @param array
     * @return
     */
    public static boolean isEmpty(Object[] array){
        return  ArrayUtils.isEmpty(array);
    }
}
