package proxy;

/**
 * @Autor: bin.liu
 * @Desciption: ����ӿ�
 * @Date: Created in 11:58 2017/10/12
 */
public interface Proxy {

    /**
     *  ִ����ʽ����
     * @param ProxyChain
     * @return
     * @throws Throwable
     */
    Object doProxy(ProxyChain ProxyChain) throws Throwable;
}
