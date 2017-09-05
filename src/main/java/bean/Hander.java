package bean;

import java.lang.reflect.Method;

/**
 * @Autor: bin.liu
 * @Desciption: ��װAction��Ϣ
 * @Date: Created in 16:32 2017/9/5
 */
public class Hander {

    /**
     * Controller ��
     */
    private Class<?> controllerClass;

    /**
     * Action ����
     */
    private Method actionMethod;

    public Hander(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }

    public void setControllerClass(Class<?> controllerClass) {
        this.controllerClass = controllerClass;
    }

    public void setActionMethod(Method actionMethod) {
        this.actionMethod = actionMethod;
    }
}
