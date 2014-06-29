package com.encodingset.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.encodingset.bean.F_Fields_GlobalBean;
import com.encodingset.bean.LocalFieldBean;
import com.encodingset.dao.DaoFactory;
import com.encodingset.util.PKGenerator;
import com.encodingset.util.Page;
import com.encodingset.util.PageTool;


/**     
 * 项目名称：EncodingSet   
 * 类名称：LocalFieldAction   
 * 类描述：本地字段管理action 
 * 创建人：tangqianfeng   
 * 创建时间：2014-1-8 上午09:57:35   
 * 修改人：lijie   
 * 修改时间：2014-1-8 上午09:57:35   
 * 修改备注：   
 * @version V1.0 
 * 
 */ 
@Controller
@RequestMapping("/localfield")
public class LocalFieldAction {
	
	/**
	 * 显示
	 * @param request
	 * @return
	 */
	@RequestMapping("/fieldseek")
	public String fieldShow(HttpServletRequest request){
		String fieldnameIndex = request.getParameter("fieldNameIndex");
		String fieldDescriptionIndex = request.getParameter("fieldDescriptionIndex");
		String pageNumber = request.getParameter("pageNumber");
		if(fieldnameIndex == null){
			fieldnameIndex = "";
		}
		if(fieldDescriptionIndex == null){
			fieldDescriptionIndex = "";
		}
		if(pageNumber == null){
			pageNumber = "1";
		}
		List<LocalFieldBean> list = DaoFactory.getInstance().getLocalFieldDao().getList(fieldnameIndex, fieldDescriptionIndex, Integer.parseInt(pageNumber));
		request.setAttribute("list", list);
		//分页栏
		int totalCount = DaoFactory.getInstance().getLocalFieldDao().getCount(fieldnameIndex, fieldDescriptionIndex);
		Page page = new Page(Integer.parseInt(pageNumber), totalCount);
        PageTool pt = new PageTool();
        String pageTools = pt.getPageStringForJsSeek(page);
        request.setAttribute("page", pageTools);
		return "ajaxlocalfield";
	}
	
	/**
	 *增加 
	 */
	@RequestMapping("/fieldadd")
	public String fieldAdd4GetGlobalInfo(HttpServletRequest request){
		List<F_Fields_GlobalBean> f_Fields_GlobalList = DaoFactory.getInstance().getLocalFieldDao().getF_Fields_Global("null");
		request.setAttribute("f_Fields_GlobalList", f_Fields_GlobalList);
		return "local_filed_edit";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/fieldreset")
	public String fieldReset(HttpServletRequest request){
		Long fields_Local_ID = Long.parseLong(request.getParameter("fields_Local_ID"));
		//全局字段 下拉单
		List<F_Fields_GlobalBean> f_Fields_GlobalList = DaoFactory.getInstance().getLocalFieldDao().getF_Fields_Global("null");
		request.setAttribute("f_Fields_GlobalList", f_Fields_GlobalList);
		//本地字段映射集
		LocalFieldBean localFieldBean = DaoFactory.getInstance().getLocalFieldDao().getLocalFieldById(fields_Local_ID);
		request.setAttribute("localFieldBean", localFieldBean);
		return "local_filed_edit";
	}
	
	
	/**
	 *筛选 
	 */
	@RequestMapping("/fieldscreen")
	public String fieldScreen4GetGlobalInfo(HttpServletRequest request){
		String screenIndex = request.getParameter("screenIndex").toUpperCase();
		List<F_Fields_GlobalBean> f_Fields_GlobalList = DaoFactory.getInstance().getLocalFieldDao().getF_Fields_Global(screenIndex);
		request.setAttribute("f_Fields_GlobalList", f_Fields_GlobalList);
		return "screen";
	}
	
	/**
	 * 提交
	 * @param request
	 * @return
	 */
	@RequestMapping("/fieldsubmit")
	public void fieldAddSubmit(HttpServletRequest request,HttpServletResponse response){
		LocalFieldBean bean = new LocalFieldBean();
		bean.setFields_Local_ID(Long.parseLong(request.getParameter("fields_Local_ID")));
		bean.setIs_Tran(request.getParameter("is_Tran"));
		bean.setRegex(request.getParameter("regex"));
		bean.setData_Type(request.getParameter("data_Type"));
		bean.setField_Description(request.getParameter("field_Description"));
		bean.setField_Name(request.getParameter("field_Name"));
		bean.setFields_Global_ID(request.getParameter("fields_Global_ID"));
		if(bean.getFields_Local_ID()!=0){
			try {
				response.getWriter().print(DaoFactory.getInstance().getLocalFieldDao().updateLocalField(bean));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			try {
				bean.setFields_Local_ID(PKGenerator.getInstance().generateKey());
				response.getWriter().print(DaoFactory.getInstance().getLocalFieldDao().addLocalField(bean));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 删除
	 * @param request
	 * @param response
	 */
	@RequestMapping("/fielddelete")
	public void fieldDelete(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("fields_Local_ID");
		try {
			response.getWriter().print(DaoFactory.getInstance().getLocalFieldDao().deleteLocalField(Long.parseLong(id)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

