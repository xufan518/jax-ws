package com.rvho.server.ws;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import com.rvho.server.entity.PersonEntity;

/**
 * WebService接口
 */
@WebService(name = "HelloWS", targetNamespace = "http://www.tmp.com/ws/hello")
public interface HelloWService {
	/**
	 * 返回字符串
	 * 
	 * @return
	 */
	String index();

	/**
	 * 两个整数相加
	 * 
	 * @param x
	 * @param y
	 * @return 相加后的值
	 */
	Integer add(Integer x, Integer y);

	/**
	 * 返回当前时间
	 * 
	 * @return
	 */
	Date now();
	
	public String rengt(String str) ;
	
	/** 
	35.     * 获取复杂类型 
	36.     * @param name 用户姓名 
	37.     * @param age 用户年龄 
	38.     * @return 返回用户类 
	39.     */  
	 PersonEntity getPerson(String name, Integer age);  

	 public String beanToJson(String name, Integer age) ;
	 
	 public List<PersonEntity> listPerson(String name, Integer age);
	
}