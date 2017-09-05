package bean;

import utils.CastUtil;

import java.util.Map;

/**
 * @Autor: bin.liu
 * @Desciption: 封装请求参数类
 * @Date: Created in 17:16 2017/9/5
 */
public class Param {

    private Map<String,Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    /**
     * 根据参数名获long类型
     * @param name
     * @return
     */
    public long getLong(String name){
        return CastUtil.castLong(paramMap.get(name));
    }

    /**
     * 根据参数名获取Stirng类型
     * @param name
     * @return
     */
    public String getString(String name){
        return CastUtil.castString(paramMap.get(name));
    }

    /**
     * 获取所有请求参数
     * @return
     */
    public Map<String,Object> getMap(){
        return  paramMap;
    }

}
