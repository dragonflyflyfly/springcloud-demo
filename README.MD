一、项目结构   
springcloud-demo:聚合工程   
    weather-eureka  注册中心(服务注册与服务发现)    
    weather-city-server  城市服务(城市编号和城市名)   
    weather-data-server  天气数据服务(根据城市编号和名称查询天气信息)   
    weather-collection-server  天气收集服务(从第三方获取天气数据信息，缓存到redis)    
    weather-report-server  天气预报服务  
    
二、运行项目    
0.先在hosts中配置:127.0.0.1 discovery   
1.启动redis   
2.依次启动各微服务
启动微服务  
启动注册中心：weather-eureka-server  
启动城市服务：weather-city-server-6001    
启动城市服务：weather-city-server-6002  
启动天气采集服务：weather-collection-server(8002端口)  
启动天气数据服务：weather-data-server(      
启动天气预报服务：weather-report-server  
3.服务自测  
注册中心  
    http://discovery:8761  
城市服务  
    http://discovery:6001/cities  
    http://discovery:6001/city/cityId/101280101   
    http://discovery:6001/city/cityName/广州  
    http://discovery:6002/cities  
    http://discovery:6002/city/cityId/101280101   
    http://discovery:6002/city/cityName/广州  
天气采集服务  
    在redis客户端中查看数据是否进行了保存  
天气数据服务  
    http://discovery:8001/weather/cityId/101280101  
    http://discovery:8001/weather/cityName/广州  
天气预报服务  
    http://discovery:8003/report/cityId/101280101    

4.启动API gateway网关微服务，并通过网关访问各微服务(网关代理测试)  
    weather-api-gateway(6677端口)  
城市服务  
    http://discovery:6677/city/cities  
    http://discovery:6677/city/city/cityId/101280101  
    http://discovery:6677/city/city/cityName/广州    
天气数据服务  
    http://discovery:6677/data/weather/cityId/101280101    
    http://discovery:6677/data/weather/cityName/广州  
天气预报服务  
    http://discovery:6677/report/report/cityId/101280101    
       
三、遗留问题  
Eureka不注销关闭的应用实例  
ObjectMapper实例  
    
