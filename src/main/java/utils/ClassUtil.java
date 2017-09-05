package utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @Autor: bin.liu
 * @Desciption: �����������
 * @Date: Created in 10:22 2017/9/5
 */
public class ClassUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassUtil.class);

    /**
     * ��ȡ�������
     * @return ClassLoader �������
     */
    public static ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * ������
     * @param className ����
     * @param isInitialized ��ʼ��״̬
     * @return
     */
    public static Class<?> loadClass(String className,boolean isInitialized){
        Class<?> cls;
        try {
            cls = Class.forName(className,isInitialized,getClassLoader());
        } catch (ClassNotFoundException e) {
            LOGGER.error("load class failure",e);
            throw new RuntimeException(e);
        }
        return cls;
    }

    /**
     * ��ȡָ�������µ������༯��
     * @param packageName ����
     * @return
     */
    public static Set<Class<?>> getClassSet(String packageName){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        try {
            Enumeration<URL> urls = getClassLoader().getResources(packageName.replaceAll(".", "/"));
            while (urls.hasMoreElements()){
                URL url = urls.nextElement();
                if(url != null){
                    //��ȡЭ������
                    String protocol = url.getProtocol();
                    if("file".equals(protocol)){
                        String packagePath = url.getPath().replaceAll("%20","");
                        addClass(classSet,packagePath,packageName);
                    }else if("jar".equals(protocol)){
                        JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
                        if(jarURLConnection != null){
                            JarFile jarFile = jarURLConnection.getJarFile();
                            if(jarFile != null){
                                Enumeration<JarEntry> jarEntries = jarFile.entries();
                                while (jarEntries.hasMoreElements()){
                                    JarEntry jarEntry = jarEntries.nextElement();
                                    String jarEntryName = jarEntry.getName();
                                    if(jarEntryName.endsWith(".class")){
                                        String className = jarEntryName.substring(0,jarEntryName.lastIndexOf(".")).replaceAll("/",".");
                                        addClass(classSet,className);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
           LOGGER.error("get class set failure",e);
           throw new RuntimeException(e);
        }
        return classSet;
    }

    /**
     * ���������set ����
     * @param classSet �༯��
     * @param className ����
     */
    private static void addClass(Set<Class<?>> classSet, String className) {
        Class<?> cls = loadClass(className,false);
        classSet.add(cls);
    }

    /**
     * ���ļ���ʽ��ȡָ�������µ�������
     * @param classSet �༯��
     * @param packagePath ����·��
     * @param packageName ����
     */
    private static void addClass(Set<Class<?>> classSet, String packagePath, String packageName) {
        File[] files = new File(packagePath).listFiles(new FileFilter() {
            public boolean accept(File file) {
                return (file.isFile() && file.getName().endsWith(".class") || file.isDirectory());
            }
        });
        //ѭ������file�����ļ�
        for (File file: files) {
            String fileName =  file.getName();
            if(file.isFile()){
                String className = fileName.substring(0,fileName.lastIndexOf("."));
                if(StringUtils.isNotEmpty(packageName)){
                    //ƴ������
                    className = packageName + "." + className;
                    addClass(classSet,className);
                }
            }else{
                //����������ļ��У�ѭ���ݹ���������
                String subPackagePath = fileName;
                if(StringUtils.isNotEmpty(packagePath)){
                    subPackagePath = packagePath + "/" + subPackagePath;
                }
                String subPackageName = fileName;
                if(StringUtils.isNotEmpty(packageName)){
                    subPackageName = packageName + "." + subPackageName;
                }
                addClass(classSet,subPackagePath,subPackageName);
            }
        }
    }
}
