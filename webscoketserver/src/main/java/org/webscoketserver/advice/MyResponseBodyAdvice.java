package org.webscoketserver.advice;


import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.webscoketserver.model.Message;


/**
 * Copyright: Copyright (c) 2018 DianZheng
 * 
 * @ClassName: DZResponseBodyAdvice.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: yemegn
 * @date: 2018年8月28日 下午5:40:27
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年8月28日
 *        yemeng v1.0.0 修改原因
 */
@SuppressWarnings("rawtypes")
@ControllerAdvice(annotations = RestController.class)
public class MyResponseBodyAdvice implements ResponseBodyAdvice {

//	private final static Logger logger = LoggerFactory.getLogger(ResponseBodyAdvice.class);

	@Override
	public boolean supports(MethodParameter methodParameter, Class aClass) {
		aClass = StringHttpMessageConverter.class;
		return true;
	}

	@Override
	public String beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
		/*
		 * if (methodParameter.getMethod().isAnnotationPresent(SecurityResponse.
		 * class)) { //获取注解配置的包含和去除字段 SecurityResponse serializedField =
		 * methodParameter.getMethodAnnotation(SecurityResponse.class);
		 * //出参是否需要加密 encode = serializedField.outEncode(); } if (encode) {
		 * logger.info("对方法method :【" + methodParameter.getMethod().getName() +
		 * "】返回数据进行加密"); ObjectMapper objectMapper = new ObjectMapper(); try {
		 * String result =
		 * objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body
		 * ); return DESHelper.encrypt(result); } catch (Exception e) {
		 * logger.error("对方法method :【" + methodParameter.getMethod().getName() +
		 * "】返回数据进行解密出现异常："+e.getMessage()); } }
		 */
		/*
		 * ObjectMapper objectMapper = new ObjectMapper(); try {
		 * ServletServerHttpRequest request =
		 * (ServletServerHttpRequest)serverHttpRequest; HttpSession session =
		 * request.getServletRequest().getSession(); String key = (String)
		 * session.getAttribute(GlobalConstant.SESSION_AES_KEY);
		 * if(StringUtils.isBlank(key)){ key =
		 * UUID.randomUUID().toString().replace("-", "");
		 * session.setAttribute(GlobalConstant.SESSION_AES_KEY, key); }
		 * logger.info("sessionId:{}的加密key：{}", session.getId(),key); String
		 * result =
		 * objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body
		 * ); return AesUtil.aesEncrypt(result, key); } catch (Exception e) {
		 * logger.error("对方法method :【" + methodParameter.getMethod().getName() +
		 * "】返回数据进行解密出现异常："+e.getMessage(),e); }
		 */
		mediaType = MediaType.parseMediaType("text/pain;charset=UTF-8");
		serverHttpResponse.getHeaders().setContentType(mediaType);
		System.out.println(serverHttpResponse.getHeaders());
		System.out.println(body);
		return "dsasd";
	}

	/*// 声明要捕获的异常
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JSONObject defultExcepitonHandler(HttpServletRequest request, Exception e){
		logger.error("Method：{}:{}： 全局异常处理：{}", request.getMethod(), request.getServletPath(), e.getMessage(), e);
		String reqParam = null;
		try {
			reqParam = HttpUtil.readData(request);
			logger.error("reqParam:{}",reqParam);
			logger.error("pathInfo:{}", request.getPathInfo());
			StringBuffer buffer = new StringBuffer();
			Enumeration<String> enu=request.getParameterNames();
			buffer.append("[");
			while(enu.hasMoreElements()){
				String key  = enu.nextElement();
				buffer.append( String.format("%s=%s",  key ,request.getParameter(key))).append(",");
			}
			buffer.append("]");
			logger.error("ParameterNames:"+ buffer.toString());
		} catch (Exception e1) {
			logger.error("处理异常请求时，打印日志无法解析参数，与业务无关");
		}
		return JsonUtil.getFailJsonObject("服务器数据处理异常！");
	}*/
	

}