package com.encodingset.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.encodingset.dao.DaoFactory;
import com.encodingset.dao.imp4oracle.JDBCInfoDaoImp4Oracle;
import com.encodingset.util.AESTool;

/**     
 * 项目名称：EncodingSet   
 * 类名称：InfoAction   
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
@RequestMapping("/info")
public class InfoAction {
	
	/**
	 *  修改密码
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/editPW")
	public void editPW(HttpServletRequest request,HttpServletResponse response){
		String role = request.getParameter("role");
		String oldPW = request.getParameter("oldPW").trim();				
		String newPW = request.getParameter("newPW").trim();
		System.out.println(role+oldPW+newPW);
		String PassWord = null;
		String path = JDBCInfoDaoImp4Oracle.class.getResource("/").getPath();
		System.out.println("path="+path);
		String websiteURL = (path.replace("/build/classes", "").replace("%20"," ")+role+".properties").replaceFirst("/", "");
		System.out.println("修改websiteURL="+websiteURL);	
		if(role.equals("Administrators")){			
			InputStream fileIn;
			try {
				fileIn = new FileInputStream(websiteURL);
				File file = AESTool.decryptFile(fileIn, null,AESTool.key);			
				Properties prop = new Properties();  	          
		        try {  
		            prop.load(new FileInputStream(file));  
					PassWord = prop.getProperty("password");	
					System.out.println("修改时读取原密码="+PassWord);
		        } catch(IOException e) {  
		            e.printStackTrace();  
		        } 	
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					
			if(PassWord.equals(oldPW)){
				try {
					response.getWriter().print(DaoFactory.getInstance().getInfoDao().editPW(role, newPW));
				} catch (IOException e) {					
					e.printStackTrace();
				}			
			}else{
				try {
					response.getWriter().print("-2");
				} catch (IOException e) {				
					e.printStackTrace();
				}
			}			
		}
		if(role.equals("ImplementUser")){		
			InputStream fileIn = InfoAction.class.getResourceAsStream("/ImplementUser.properties");
			File file = AESTool.decryptFile(fileIn, null,AESTool.key);			
			Properties prop = new Properties();  	          
			 try {  
		            prop.load(new FileInputStream(file));  
					PassWord = prop.getProperty("password");				
		        } catch(IOException e) {  
		            e.printStackTrace();  
		        } 			
				if(PassWord.equals(oldPW)){
					try {
						response.getWriter().print(DaoFactory.getInstance().getInfoDao().editPW(role, newPW));
					} catch (IOException e) {					
						e.printStackTrace();
					}		
				}else{
					try {
						response.getWriter().print("-2");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}		
		}	
	}	

}

