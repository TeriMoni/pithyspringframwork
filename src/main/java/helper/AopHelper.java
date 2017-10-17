package helper;

import annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proxy.AspectProxy;
import proxy.Proxy;
import proxy.ProxyManager;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * @Autor: bin.liu
 * @Desciption: aop帮助类
 * @Date: Created in 11:44 2017/10/17
 */
public class AopHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(AopHelper.class);

    static {
        try {
            Map<Class<?>,Set<Class<?>>> proxyMap = createProxyMap();
            Map<Class<?>,List<Proxy>> targetMap = createTargetMap(proxyMap);
            for (Map.Entry<Class<?>,List<Proxy>> targetEntry:targetMap.entrySet()) {
                Class<?> targetClass= targetEntry.getKey();
                List<Proxy> proxyList = targetEntry.getValue();
                Object proxy = ProxyManager.createProxy(targetClass,proxyList);
                BeanHelper.setBenMap(targetClass,proxy);
            }
        }catch (Exception e){
            LOGGER.error("init aop failure !",e);
        }
    }

    /**
     * 创建带有Aspect注解的类集合
     * @param aspect
     * @return
     * @throws Exception
     */
    private static Set<Class<?>> createTargetClassSet(Aspect aspect) throws Exception{
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        Class<? extends Annotation> annotation = aspect.value();
        if(null != annotation && annotation.isAnnotationPresent(Aspect.class)){
            classSet.addAll(ClassHelper.getClassSetByAnnotation(annotation));
        }
        return classSet;
    }

    /**
     * 创建代理类与目标类的映射集合
     * @return
     * @throws Exception
     */
    private static Map<Class<?>,Set<Class<?>>> createProxyMap() throws Exception{
        Map<Class<?>,Set<Class<?>>> proxyMap = new HashMap<Class<?>,Set<Class<?>>>();
        Set<Class<?>> proxyClassSet = ClassHelper.getClassSetBySuper(AspectProxy.class);
        for (Class<?> proxyClass: proxyClassSet) {
            if(proxyClass.isAnnotationPresent(Aspect.class)){
                Aspect aspect = proxyClass.getAnnotation(Aspect.class);
                Set<Class<?>> classSet = createTargetClassSet(aspect);
                proxyMap.put(proxyClass,classSet);
            }
        }
        return proxyMap;
    }

    private static Map<Class<?>,List<Proxy>> createTargetMap(Map<Class<?>,Set<Class<?>>> proxyMap) throws Exception{
        Map<Class<?>,List<Proxy>> targetMap = new HashMap<Class<?>,List<Proxy>>();
        for (Map.Entry<Class<?>,Set<Class<?>>> proxyEntry :proxyMap.entrySet()) {
            Class<?> proxyClass= proxyEntry.getKey();
            Set<Class<?>> targetClassSet = proxyEntry.getValue();
            for (Class<?> targetClass: targetClassSet) {
                Proxy proxy = (Proxy) proxyClass.newInstance();
                if(targetMap.containsKey(targetClass)){
                    targetMap.get(targetClass).add(proxy);
                }else{
                    List<Proxy> proxyList = new ArrayList<Proxy>();
                    proxyList.add(proxy);
                    targetMap.put(proxyClass,proxyList);
                }
            }
        }
        return targetMap;
    }
}
