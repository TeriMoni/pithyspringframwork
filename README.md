# pithyspringframwork
spithy web框架
模仿mvc模式,写的web应用框架,持续不断更新中

1.部署注意事项
<1>可以使用maven的jar插件打成maven依赖,注意修改jar包名称后缀为版本号，
<dependency>
      <groupId>org.pithy</groupId>
      <artifactId>pithy-springframwork</artifactId>
      <version>1.0-SNAPSHOT</version>
</dependency>
<2>如果使用idea的maven执行war文件，启动命令tomcat:run-war 编译时生成的资源文件目录是
WEB_002dINF 而不是WEB-INF,在返回视图文件是会出现错误，google了下是由于jar包冲突，暂时未解决
推荐使用tomcat-server 部署到本地的tomcat，可以正常运行。

