### spring&hibernate
- 拷贝jar包
   - hibernate的libs文件夹中的require目录下
   - Spring核心包和依赖包
   - mysql驱动包，连接池包
- hibernate映射文件
    - 映射daomain和数据库表 daomain.hbm.xml
    - 在resource目录下创建hibernate.properties包括连接数据库的信息
    - 配置applicationContext.xml文件,连接池、SessionFactory
    
### spring&struts2
- 拷贝jar包
    - struts2空项目lib目录下的jar包，还有一个struts2和Spring桥梁jar包struts2-spring-plugin-2.3.24.jar，还有servlet-api.jar
- 编写Action
- 在web.xml文件中配置前端控制器，还需要在Tomcat启动时候也就启动Spring容器，配置一个监听器，同时修改监听器的默认加载资源路径到classpath路径下的applicaContext.xml
- 配置Struts2.xml文件,把action的创建权利交给Spring容器
    

    
