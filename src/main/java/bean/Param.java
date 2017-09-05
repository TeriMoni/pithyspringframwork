package bean;

import utils.CastUtil;

import java.util.Map;

/**
 * @Autor: bin.liu
 * @Desciption: ��װ���������
 * @Date: Created in 17:16 2017/9/5
 */
public class Param {

    private Map<String,Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    /**
     * ���ݲ�������long����
     * @param name
     * @return
     */
    public long getLong(String name){
        return CastUtil.castLong(paramMap.get(name));
    }

    /**
     * ���ݲ�������ȡStirng����
     * @param name
     * @return
     */
    public String getString(String name){
        return CastUtil.castString(paramMap.get(name));
    }

    /**
     * ��ȡ�����������
     * @return
     */
    public Map<String,Object> getMap(){
        return  paramMap;
    }

}
