package proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @Autor: bin.liu
 * @Desciption: 代理管理类
 * @Date: Created in 10:32 2017/10/13
 */
public class ProxyManager {

    private static ProxyManager instance = null;

    public ProxyManager() {
    }

    public static ProxyManager getInstance(){
        if(instance == null){
            instance = new ProxyManager();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(final Class<?> targetClass, final List<Proxy> proxyList){
        return (T) Enhancer.create(targetClass, new MethodInterceptor() {
            @Override
            public Object intercept(Object targetObject, Method targetMethod, Object[] methodParams, MethodProxy methodProxy) throws Throwable {
                return new ProxyChain(targetClass,targetObject,targetMethod,methodProxy,methodParams,proxyList).doProxyChain();
            }
        });
    }
}
