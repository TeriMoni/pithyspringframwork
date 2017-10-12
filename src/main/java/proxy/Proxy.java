package proxy;

/**
 * @Autor: bin.liu
 * @Desciption: 代理接口
 * @Date: Created in 11:58 2017/10/12
 */
public interface Proxy {

    /**
     *  执行链式代理
     * @param ProxyChain
     * @return
     * @throws Throwable
     */
    Object doProxy(ProxyChain ProxyChain) throws Throwable;
}
