package com.rvho.server.ws.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import com.alibaba.fastjson.JSON;
import com.rvho.server.entity.PersonEntity;
import com.rvho.server.ws.HelloWService;

@WebService(
		endpointInterface = "com.rvho.server.ws.HelloWService",
		portName = "HelloWSPort",
		serviceName = "HelloWSService",
		targetNamespace = "http://www.tmp.com/ws/hello")
public class HelloWServiceImpl implements HelloWService {
	public String index() {
		return "hello";
	}

	public Integer add(Integer x, Integer y) {
		return x + y;
	}

	public Date now() {
		return new Date();
	}
	
	public String rengt(String str) {
		List<PersonEntity> lists = JSON.parseArray(str, PersonEntity.class);
		for(PersonEntity o :lists){
			System.out.println("age:"+o.getAge()+"----name:"+o.getName());
		}
	//	PersonEntity p = JSON.parseObject(str, PersonEntity.class);
		 String jsonString = JSON.toJSONString(lists); 
	        System.out.println(jsonString);
		System.out.println("------sdfsdf----"+str+"------");
		return str;
	}
	
	public PersonEntity getPerson(String name, Integer age) {  
		      PersonEntity person = new PersonEntity();  
		      person.setAge(age);  
	        person.setName(name);  
	          
	      return person;  
    }  

	public String beanToJson(String name, Integer age) {
		  PersonEntity person = new PersonEntity();  
	      person.setAge(age);  
        person.setName(name);  
        String jsonString = JSON.toJSONString(person); 
        System.out.println(jsonString);

		return jsonString;
	}
	
	public List<PersonEntity> listPerson(String name, Integer age) { 
		List<PersonEntity> lists = new ArrayList<PersonEntity>();
	      PersonEntity person = new PersonEntity();  
	      person.setAge(age);  
	      person.setName(name);  
	      lists.add(person);
	      person = new PersonEntity();  
	      person.setAge(age);  
	      person.setName(name);  
	      lists.add(person);
	      person = new PersonEntity();  
	      person.setAge(age);  
	      person.setName(name);  
	      lists.add(person);
    return lists;  
}  
	
}