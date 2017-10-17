import helper.*;
import utils.ClassUtil;

/**
 * @Autor: bin.liu
 * @Desciption: ����helper�࣬�����ʼ�����
 * @Date: Created in 17:04 2017/9/5
 */
public final class HelpLoader {
    public static void init(){
        Class<?>[] classList = {ClassHelper.class, BeanHelper.class, AopHelper.class, IocHelper.class, ControllerHelper.class};
        for (Class<?> cls: classList) {
            ClassUtil.loadClass(cls.getName(),false);
        }
    }
}
