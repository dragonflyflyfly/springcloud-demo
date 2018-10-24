一、项目说明  
该项目来源于慕课网《从天气项目看 Spring Cloud 微服务治理》，网址为https://coding.imooc.com/class/177.html。  
代码是我自己实现的，与原代码不完全一样。  

该项目主要用于学习SpringCloud的基本使用，包括以下内容： 
●Eureka服务注册和服务发现  
●RestTemplate调用微服务，并使用Ribbon客户端负载均衡    
●Feign调用微服务(默认Ribbon负载均衡)  
●Hystrix熔断机制  
●SpringCloud Config统一配置管理   
●SpringCloud Bus自动刷新配置  
●

天气数据来源于第三方的天气服务，访问地址如下：  
http://wthrcdn.etouch.cn/weather_mini?citykey=101280102  
http://wthrcdn.etouch.cn/weather_mini?city=广州    

二、项目结构   
springcloud-demo: 聚合工程   
    weather-eureka-server  注册中心(服务发现与注册)    
    weather-city-server  城市服务(城市编号和城市名)   
    weather-collection-server  天气收集服务(从第三方获取天气数据信息，缓存到redis)    
    weather-data-server  天气数据服务(根据城市编号和名称查询天气信息,从redis中读取数据)   
    weather-report-server  天气预报服务  
    weather-api-gateway 服务网关  
    weather-config-server 统一配置中心  
    weather-user-server 用户服务  
    
三、运行项目   
0.【说明】  
如果不通过网关直接访问微服务，则将weather-report-server项目中的report.js和则将weather-report-server项目中的report.js和report.html两个文件中的url修改为直接访问的url(文件内有说明)。  
否则，改为网关访问的url即可(文件内有说明)。    
1.先在hosts中配置:  
    127.0.0.1 discovery   
    127.0.0.1 config-server    
    127.0.0.1 gateway
2.启动redis   
3.依次启动各微服务,并进行服务自测   
启动注册中心：weather-eureka-server(8761端口)  
    http://discovery:8761  
启动配置服务：weather-config-server(8888端口)  
    http://discovery:8888/weather/dev  
    http://discovery:8888/weather-dev.yml  
启动用户服务：weather-user-server(8081端口)  
    http://discovery:8081/user/1     
启动城市服务：weather-city-server-6001   
    http://discovery:6001/cities  
    http://discovery:6001/city/cityId/101280101   
    http://discovery:6001/city/cityName/广州  
启动城市服务：weather-city-server-6002  
    http://discovery:6002/cities  
    http://discovery:6002/city/cityId/101280101   
    http://discovery:6002/city/cityName/广州  
启动天气采集服务：weather-collection-server(8002端口)   
    在redis客户端中查看数据是否进行了保存  
启动天气数据服务：weather-data-server (8001端口)   
    http://discovery:8001/weather/cityId/101280101  
    http://discovery:8001/weather/cityName/广州  
启动天气预报服务：weather-report-server (8003端口)     
    http://discovery:8003/report/cityId/101280101  
    http://discovery:8003/report/user/1  

3.测试使用网关访问各微服务  
需先将report.js和report.html中的url改为使用网关场景的url。          
然后启动网关微服务：weather-api-gateway(6677端口)  
用户服务  
    http://gateway:6677/user/user/1  
城市服务  
    http://gateway:6677/city/cities  
    http://gateway:6677/city/city/cityId/101280101  
    http://gateway:6677/city/city/cityName/广州    
天气数据服务  
    http://gateway:6677/data/weather/cityId/101280101    
    http://gateway:6677/data/weather/cityName/广州  
天气预报服务  
    http://gateway:6677/report/report/cityId/101280101  
    http://gateway:6677/report/report/user/1  


  

