package bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Autor: bin.liu
 * @Desciption: 视图层对象
 * @Date: Created in 17:34 2017/9/5
 */
public class View {

    /**
     *视图路径
     */
    private String path;

    /**
     * 视图数据
     */
    private Map<String,Object> model;

    public View(String path) {
        this.path = path;
        model = new HashMap<String,Object>();
    }

    public View addModel(String key,Object value){
        model.put(key,value);
        return this;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
