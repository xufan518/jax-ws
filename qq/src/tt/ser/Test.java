package tt.ser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.rvho.server.entity.PersonEntity;

public class Test {

	public static void aa(String wsdl,String ns,String method,String param){
		 //拼接SOAP  
		StringBuffer soapRequestData = new StringBuffer("");  
		soapRequestData.append("<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">");  
		soapRequestData.append("<soap:Body>");  
		soapRequestData.append("<ns1:"+method+" xmlns:ns1=\""+ns+"\">");  
		soapRequestData.append(param);  
		soapRequestData.append("</ns1:"+method+">");  
		soapRequestData.append("</soap:Body></soap:Envelope>");  
		

		CloseableHttpClient httpClient = HttpClients.createDefault();
		  HttpPost post = new HttpPost(wsdl);
		  post.setHeader("Content-Type","text/xml; charset=utf-8");  
		  RequestConfig config = RequestConfig.custom()
		    .setConnectionRequestTimeout(10000).setConnectTimeout(10000)
		    .setSocketTimeout(10000).build();
		  CloseableHttpResponse response = null;
		  try {
		   List formparams = new ArrayList();
		   formparams.add(new BasicNameValuePair("user", "zhang"));
		   formparams.add(new BasicNameValuePair("address", "广州"));
		   post.setEntity(new StringEntity(soapRequestData.toString(), "UTF-8"));
		   post.setConfig(config);
		   response = httpClient.execute(post);
		   HttpEntity entity = response.getEntity();
		   String content = EntityUtils.toString(entity);
		   System.out.println("content:" + content);
		   EntityUtils.consume(entity);
		  } catch (ClientProtocolException e) {
		   e.printStackTrace();
		  } catch (IOException e) {
		   e.printStackTrace();
		  } finally {
		   try {
		    response.close();
		   } catch (IOException e) {
		    e.printStackTrace();
		   }
		  }
	}
	
	public static void main(String[] arg){
		List<PersonEntity> lists = new ArrayList<PersonEntity>();
	      PersonEntity person = new PersonEntity();  
	      person.setAge(12);  
	      person.setName("11111111");  
	      lists.add(person);
	      person = new PersonEntity();  
	      person.setAge(22);  
	      person.setName("2222222");  
	      lists.add(person);
	      person = new PersonEntity();  
	      person.setAge(33);  
	      person.setName("3333333333");  
	      lists.add(person);
	     System.out.println(JSON.toJSONString(lists));
		String wsdl = "http://127.0.0.1:8080/qq/services/hello?wsdl";
		aa(wsdl,"http://www.tmp.com/ws/hello","index","");
		aa(wsdl,"http://www.tmp.com/ws/hello","add","<arg0>12</arg0><arg1>35</arg1>");
		aa(wsdl,"http://www.tmp.com/ws/hello","rengt","<arg0>"+JSON.toJSONString(lists)+"</arg0>");
		aa(wsdl,"http://www.tmp.com/ws/hello","getPerson","<arg0>{asdfsdf:\"wesdfsdf\"}</arg0><arg1>35</arg1>");
		aa(wsdl,"http://www.tmp.com/ws/hello","beanToJson","<arg0>sdfsdfsdf</arg0><arg1>35</arg1>");
		aa(wsdl,"http://www.tmp.com/ws/hello","listPerson","<arg0>sdfsdfsdf</arg0><arg1>35</arg1>");
	}

}
