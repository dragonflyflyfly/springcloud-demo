/**
 * report页面下拉框事件
 * auther:waylau.com
 */
$(function(){
	$("#selectCityId").change(function(){
		var cityId = $("#selectCityId").val();
		//直接访问天气预报微服务
		var url = '/report/cityId/'+ cityId;

        //使用网关访问天气预报微服务
		//var url = '/report/report/cityId/'+ cityId;

		window.location.href = url;
	})
});