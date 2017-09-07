package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Autor: bin.liu
 * @Desciption: ������������
 * @Date: Created in 13:12 2017/9/7
 */
public class StreamUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(StreamUtil.class);

    /**
     * ���������ж�ȡ�ַ���
     * @param is
     * @return
     */
    public static String  getString(InputStream is){
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;//��ȡһ��
            while((line = reader.readLine()) != null){
                sb.append(line);
            }
        } catch (IOException e) {
           LOGGER.error("read stream error !",e);
           throw new RuntimeException(e);
        }
        return sb.toString();
    }

}
