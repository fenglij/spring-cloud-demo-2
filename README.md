# spring-cloud-demo-2
spring cloud demo(基于springcloud 2021.0.4, springboot 2.7.4)
集成组件：
1. nacos 注册中心
2. nacos 集中配置中心
3. Feign 声明式服务调用
4. Admin 应用监控
5. 添加核心业务依赖 core-service
6. 添加 spring cloud gateway
7. 添加 zipkin
8. 移除config集中配置中心
9. 移除eureka 注册中心
10. 移除Hystrix 熔断器
11. redis
12. mysql
13. swagger2
14. 美团CAT

即将集成
1. 阿里巴巴 Sentinel 哨兵

备注
1. nacos(V2.1.1)使用源码编译部署 <br>
  git地址：https://github.com/alibaba/nacos.git <br>
  官方文档地址：https://nacos.io/zh-cn/docs/quick-start.html <br>
  控制台：http://${IP地址}:8848/nacos/#/login
2. CAT使用war包部署tomcat，服务端版本：3.1.0 <br>
  Linux环境： <br>
    新增目录 /data/appdatas/cat  新增文件 client.xml(server id 配置为服务端内网IP)，新增文件 datasources.xml(数据库配置为具体连接信息) <br>
    新增目录 /data/applogs/cat <br>
    启动tomcat <br>
    服务端配置 访问：http://服务器地址:8080/cat/s/config?op=serverConfigUpdate，配置server id 为服务端内网IP，保存 <br>
    客户端路由 访问：http://1.117.200.16:8080/cat/s/config?op=routerConfigUpdate，配置server id 为服务端内网IP，保存 <br>
  Window环境： <br>
    目录位置和tomcat盘符一致 <br>
  注意： <br>
    CAT默认使用5.X版本MySQL，如果使用8.X版本MySQL，需要将${TOMCAT_HOME}/webapps/cat/WEB-INF/lib 和 ${TOMCAT_HOME}/webapps/cat-home/WEB-INF/lib 目录下5.X版本驱动包置换为8.X     版本驱动包
    
