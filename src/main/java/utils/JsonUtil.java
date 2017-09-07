package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @Autor: bin.liu
 * @Desciption: json工具类
 * @Date: Created in 13:29 2017/9/7
 */
public class JsonUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    /**
     * 对象转json
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String toJson(T obj){
        String json;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            json = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            LOGGER.error("convert pojo to json error !",e);
            throw new RuntimeException(e);
        }
        return json;
    }

    /**
     * json转对象
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String json,Class<T> type){
        T pojo;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            pojo = objectMapper.readValue(json,type);
        } catch (IOException e) {
            LOGGER.error("convert json to pojo error !",e);
            throw new RuntimeException(e);
        }
        return pojo;
    }
}
