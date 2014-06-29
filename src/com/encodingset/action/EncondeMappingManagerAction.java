package com.encodingset.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.encodingset.bean.EncodeMapShowBean;
import com.encodingset.bean.F_Local_XXXBean;
import com.encodingset.dao.DaoFactory;
import com.encodingset.util.Page;
import com.encodingset.util.PageTool;

/**     
 * 项目名称：EncodingSet   
 * 类名称：EncondeMappingManagerAction   
 * 类描述：编码映射action类  
 * 创建人：tangqianfeng   
 * 创建时间：2014-1-8 上午09:58:41   
 * 修改人：lijie   
 * 修改时间：2014-1-8 上午09:58:41   
 * 修改备注：   
 * @version V1.0 
 * 
 */ 
@Controller
@RequestMapping("/encode")
public class EncondeMappingManagerAction {
	/**
	 * 处理ajax查询请求
	 * @param request
	 * @return ajax请求的视图
	 */
	@RequestMapping("/encodeseek")
	public String encodeShow(HttpServletRequest request){
		String encodetable = request.getParameter("encodetable");
		String encodenameIndex1 = request.getParameter("encodenameIndex1");
		String encodenameIndex2 = request.getParameter("encodenameIndex2");
		String pageNumber = request.getParameter("pageNumber");
		if(encodetable == null){
			return null;
		}
		if(encodenameIndex1 == null){
			encodenameIndex1 = "";
		}
		if(encodenameIndex2 == null){
			encodenameIndex2 = "";
		}
		if(pageNumber == null){
			pageNumber = "1";
		}
		List<EncodeMapShowBean> list = DaoFactory.getInstance().getEncodeMapDao().getList(encodetable, encodenameIndex1,encodenameIndex2, Integer.parseInt(pageNumber));
		request.setAttribute("list", list);
		//分页栏
		int totalCount = DaoFactory.getInstance().getEncodeMapDao().getCount(encodetable, encodenameIndex1,encodenameIndex2);
		Page page = new Page(Integer.parseInt(pageNumber), totalCount);
        PageTool pt = new PageTool();
        String pageTools = pt.getPageStringForJsSeek(page);
        request.setAttribute("page", pageTools);
		return "ajaxmap";
	}
	
	/**
	 * 映射的修改、添加
	 * @param request
	 * @param resp
	 */
	@RequestMapping("/encodeset")
	public void encodeSet(HttpServletRequest request,HttpServletResponse resp){	
		String myIndex = request.getParameter("myIndex");
		String fields_local_id = request.getParameter("fields_local_id");
		String code_mark = request.getParameter("code_mark");
		String code_Val_Local = request.getParameter("code_Val_Local");
		String encodetable = request.getParameter("encodetable");
		String oldValue = request.getParameter("oldvalue");
		if(myIndex!=null && !"null".equals(myIndex)){
			try {
				resp.getWriter().print(DaoFactory.getInstance().getEncodeMapDao().encodingUpdate(code_Val_Local, code_mark,encodetable.replaceAll("Global", "Local"), oldValue));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			try {
				F_Local_XXXBean f_Local_xxx = new F_Local_XXXBean();
				f_Local_xxx.setFields_local_id(fields_local_id);
				f_Local_xxx.setCode_mark(code_mark);
				f_Local_xxx.setCode_Val_Local(code_Val_Local);
				resp.getWriter().print(DaoFactory.getInstance().getEncodeMapDao().encodingAdd(f_Local_xxx,encodetable.replaceAll("Global", "Local")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 映射的刪除
	 * @param request
	 * @param resp
	 */
	@RequestMapping("/encodedel")
	public void encodeDel(HttpServletRequest request,HttpServletResponse resp){
		String code_mark = request.getParameter("code_mark");		
		String encodetable = request.getParameter("encodetable");
		String oldValue = request.getParameter("oldvalue");
		try {
			resp.getWriter().print(DaoFactory.getInstance().getEncodeMapDao().encodingDel(code_mark,encodetable.replaceAll("Global", "Local"), oldValue));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

