package proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @Autor: bin.liu
 * @Desciption: 代理切面模板方法类(钩子方法)
 * @Date: Created in 16:12 2017/10/13
 */
public abstract class AspectProxy implements Proxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(AspectProxy.class);

    public void begain(){
    }

    @Override
    public final Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;
        Class<?> cls = proxyChain.getTargetClass();
        Method method = proxyChain.getTargetMethod();
        Object[] params = proxyChain.getMethodParams();
        begain();
        try {
            if (filter(cls, method, params)) {
                before(cls,method,params);
                result = doProxy(proxyChain);
                after(cls,method,params);
            }else{
                result = doProxy(proxyChain);
            }
        }catch (Throwable e){
            LOGGER.error("do proxy chain error",e);
            error(cls,method,params,e);
        }finally {
            end();
        }
        return result;
    }

    public boolean filter(Class<?> cls, Method method, Object[] params) throws Throwable{
        return true;
    }

    public void before(Class<?> cls, Method method,Object[] params) throws Throwable{
    }

    public void after(Class<?> cls, Method method,Object[] params) throws Throwable{
    }

    public void error(Class<?> cls, Method method,Object[] params,Throwable e) throws Throwable{
    }

    public void end(){
    }
}
