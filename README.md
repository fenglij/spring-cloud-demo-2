# spring-cloud-demo-2
spring cloud demo(基于springcloud 2.0.1)
集成组件：
1. Eureka 注册中心
2. Config 集中配置中心
3. Hystrix 熔断
4. Feign 声明式服务调用
5. Admin 应用监控
6. Hystrix board 整合
7. 添加核心业务依赖 core-service
8. 添加 spring cloud gateway
9. 添加 zipkin

# Hystrix board 使用：<br>
地址栏输入：<br>
http://localhost:8030/hystrix<br>
在Hystrix Dashboard下输入：<br>
http://localhost:8000/actuator/hystrix.stream<br>
点击：Monitor Stream 进入界面
