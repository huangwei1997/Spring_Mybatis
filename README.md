# Spring_Mybatis
Spring整合Mybatis案例

  整合问题及其解决方案：
        
        问题一：传统方式是在service层直接通过mybatis对象完成数据库的操作，业务层和mapper层的耦合性非常高。
        
        解决一：使用SpringIOC技术将service层与mapper进行解耦

        方案一：直接从spring容器对象中获取mapper接口对象---->Spring容器还要管理SqlSession对象----->Spring容器中管理SqlSessionFactory----->Spring容器中管理DataSource对象

        问题二：如果在Servlet层中直接new创建业务层对象，虽然可以正常使用，但是会造成Servlet层和业务层的耦合性较高，不易于后期的迭代升级。

        解决二：使用SpringIOC将Servlet层和service层进行解耦

         实现二：将Service对象配置成bean,交由Spring容器管理，在Servlet中通过Spring容器对象获取业务层对象   

        问题三：目前，我们实现的登录代码如果放在高并发环境，会发现Spring容器对象在一个线程中会被创建两次，这样造成在高并发环境中占据的内存过高，

        解决三：①在Service层中我们使用Spring容器对象获取Mapper接口对象，Mapper接口对象本身就在Spring容器中，但是我们把Service也配置成为bean了，于是我们可以使用依赖注入。直接在Spring的配置文件中通过依赖注入将Mapper对象注入给Service对象
                      ②使用init方法，将获取userService对象的动作放到服务器启动时完成

        问题四：Spring容器对象获取代码中的路径在init方法中的耦合性较高

        解决四：将Spring容器相关路径信息配置到web.xml中

        实现四：在web.xml中配置全局参数表明Spring路径，配置Spring监听器
