package com.encodingset.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.encodingset.util.AESTool;

/**     
 * 项目名称：EncodingSet   
 * 类名称：LoginAction   
 * 类描述：   
 * 创建人：lijie   
 * 创建时间：2014-1-23 上午11:20:14   
 * 修改人：lijie   
 * 修改时间：2014-1-23 上午11:20:14   
 * 修改备注：   
 * @version V1.0 
 * 
 */ 
@Controller
@RequestMapping("/login")
public class LoginAction {
	
	/**
	 * 登录验证
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/loginCheck")
	public String loginCheck(HttpServletRequest request,HttpServletResponse response){
		String role = request.getParameter("role");
		String name = role;		
		String passwrod = request.getParameter("userPW").trim();		
		String url = "../index";		
		String UserName = null;
		String PassWord = null;
		if(role.equals("Administrators")){			
			InputStream fileIn = LoginAction.class.getResourceAsStream("/Administrators.properties");
			File file = AESTool.decryptFile(fileIn, null,AESTool.key);		
			Properties prop = new Properties();  	          
	        try {  
	            prop.load(new FileInputStream(file));  
	            Enumeration en = prop.propertyNames();
	            while (en.hasMoreElements()) {
		            String key = (String) en.nextElement();
		            String Property = prop.getProperty (key);
		            System.out.println("loginaction2："+key+"="+Property);
	            }	
	            UserName = prop.getProperty("name");
				PassWord = prop.getProperty("password");	              
	        } catch(IOException e) {  
	            e.printStackTrace();  
	        } 			
			if(UserName.equals(name) && PassWord.equals(passwrod)){
				url = "AU_Manage";
				request.getSession().setAttribute("user", UserName);
			}else{
				request.setAttribute("message", "提示信息：密码错误！");
			}			
		}
		if(role.equals("ImplementUser")){		
			InputStream fileIn = LoginAction.class.getResourceAsStream("/ImplementUser");
			File file = AESTool.decryptFile(fileIn, null,AESTool.key);			
			Properties prop = new Properties();  	          
	        try {  
	            prop.load(new FileInputStream(file));  
	            UserName = prop.getProperty("name");
				PassWord = prop.getProperty("password");	              
	        } catch(IOException e) {  
	            e.printStackTrace();  
	        } 	
			if(UserName.equals(name) && PassWord.equals(passwrod)){
				url = "IU_Manage";
				request.getSession().setAttribute("user", UserName);
			}else{
				request.setAttribute("message", "提示信息：密码错误！");
			}		
		}
		return url;
	}	
	
	/**
	 * 退出
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response){
		request.getSession().removeAttribute("user");		
		return  "../index";
	}	
	
	
	public static void main(String[] args) {
		System.out.println(LoginAction.class.getResource("/Administrators").toString());
	}
}

