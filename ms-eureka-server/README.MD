一、Eureka单点  
1.引入依赖  
<dependency>  
	<groupId>org.springframework.cloud</groupId>  
	<artifactId>spring-cloud-starter-eureka-server</artifactId>  
</dependency>  

2.在启动类上添加@EnableEurekaServer注解  

3.配置  
<pre>
<code>
server:
  port: 8761 #指定该Eureka实例的端口  
eureka:  
  instance:  
    hostname: discovery	#指定该Eureka实例的主机名  
  client:  
    registerWithEureka:	false   
    fetchRegistry: false  
    serviceUrl:  
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/  
</code>
</pre>		  
4.访问http://discovery:8761/  
========================================================================  	
二、Eureka高可用  
先在hosts文件中进行主机映射：  127.0.0.1	peer1	peer2  
然后修改配置(registerWithEureka和fetchRegistry两项默认为true)： 
<pre>
<code>
spring:  
  profiles: peer1 #指定profile=peer1  
server:  
  port:	8761  
eureka:  
  instance:  
    hostname: peer1 #指定当profile=peer1时，主机名  
  client:  
    serviceUrl:  
      defaultZone: http://peer2:8762/eureka/ #将自己注册到peer2这个Eureka上面去 

spring:
  profiles: peer2
server:
  port:	8762
eureka:
  instance:
    hostname: peer2
  client:
    serviceUrl:
      defaultZone: http://peer2:8762/eureka/ #将自己注册到peer2这个Eureka上面去  
</code>
</pre>  


