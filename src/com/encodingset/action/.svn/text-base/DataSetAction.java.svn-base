package com.encodingset.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.encodingset.bean.DataSetBean;
import com.encodingset.bean.DatasetLocalFieldBean;
import com.encodingset.bean.F_Fields_GlobalBean;
import com.encodingset.bean.LocalFieldBean;
import com.encodingset.dao.DaoFactory;
import com.encodingset.util.PKGenerator;
import com.encodingset.util.Page;
import com.encodingset.util.PageTool;

/**
 *      项目名称：EncodingSet   类名称：DataSetAction   类描述：数据集管理action   创建人：lijie  
 * 创建时间：2014-1-8 上午09:59:09   修改人：lijie   修改时间：2014-1-8 上午09:59:09   修改备注：  
 * 
 * @version V1.0   
 */
@Controller
@RequestMapping("/dataset")
public class DataSetAction {
	/**
	 * 获取全部数据集Map
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/tree")
	public String datasetTree(HttpServletRequest request) {
		Map<String, List<DataSetBean>> map = DaoFactory.getInstance()
				.getDataSetDao().getTree();
		request.setAttribute("datasetMap", map);
		return "dataset_tree";
	}

	/**
	 * 获取dataSet_ID对应的本地字段数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/showFL")
	public String showFL(HttpServletRequest request) {
		String dataSet_id = request.getParameter("dataSet_ID");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		List<DatasetLocalFieldBean> list = DaoFactory.getInstance()
				.getDataSetDao().getFLList(Long.parseLong(dataSet_id));
		request.setAttribute("DSLFlist", list);
		request.setAttribute("name", name);
		request.setAttribute("description", description);
		return "dataset_filed";
	}

	/**
	 * 获取DatasetType
	 * 
	 * @param request
	 * @return 直接返回dataset_edit，DatasetType前台已绑定
	 */
	@RequestMapping("/showDatasetType")
	public String showDatasetType(HttpServletRequest request) {
		return "dataset_edit";
	}

	/**
	 * 数据集的添加与修改
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/datasetSubmit")
	public void datasetSubmit(HttpServletRequest request,
			HttpServletResponse response) {
		DataSetBean bean = new DataSetBean();
		bean.setDataset_ID(Long.parseLong(request.getParameter("dataset_ID")));
		bean.setDataset_Name(request.getParameter("dataset_Name"));
		bean
				.setDataset_Description(request
						.getParameter("dataset_Description"));
		bean.setDataset_Type(request.getParameter("dataset_Type"));
		if (bean.getDataset_ID() != 0) {
			try {
				response.getWriter().print(
						DaoFactory.getInstance().getDataSetDao().updateDataset(
								bean));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				bean.setDataset_ID(PKGenerator.getInstance().generateKey());
				response.getWriter().print(
						DaoFactory.getInstance().getDataSetDao().addDataset(
								bean));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 删除dataset_ID对应的数据集
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/datasetdelete")
	public void datasetDelete(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("dataset_ID");
		try {
			response.getWriter().print(
					DaoFactory.getInstance().getDataSetDao().deleteDataset(
							Long.parseLong(id)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询dataSet_ID对应的数据集字段和本地字段
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/showDatasetFiled")
	public String showDatasetFiled(HttpServletRequest request) {
		String dataSet_id = request.getParameter("dataSet_ID");
		String pageNumber = request.getParameter("pageNumber");
		String fieldnameIndex = request.getParameter("fieldnameIndex");
		String fieldDescriptionIndex = request
				.getParameter("fieldDescriptionIndex");
		if (fieldnameIndex == null) {
			fieldnameIndex = "";
		}
		if (fieldDescriptionIndex == null) {
			fieldDescriptionIndex = "";
		}
		if (pageNumber == null) {
			pageNumber = "1";
		}
		List<LocalFieldBean> list1 = DaoFactory.getInstance().getDataSetDao()
				.getList(fieldnameIndex, fieldDescriptionIndex,
						Integer.parseInt(pageNumber),
						Long.parseLong(dataSet_id));
		request.setAttribute("FLList", list1);
		// 分页栏
		int totalCount = DaoFactory.getInstance().getDataSetDao().getCount(
				fieldnameIndex, fieldDescriptionIndex,
				Long.parseLong(dataSet_id));
		Page page = new Page(Integer.parseInt(pageNumber), totalCount);
		PageTool pt = new PageTool();
		String pageTools = pt.getPageStringForJsSeek(page);
		request.setAttribute("page", pageTools);
		List<DatasetLocalFieldBean> list2 = DaoFactory.getInstance()
				.getDataSetDao().getFLList(Long.parseLong(dataSet_id));
		request.setAttribute("DSLFlist1", list2);
		request.setAttribute("fieldnameIndex", fieldnameIndex);
		request.setAttribute("fieldDescriptionIndex", fieldDescriptionIndex);
		return "dataset_filed_edit";
	}

	/**
	 *查询数据集
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/showDataset")
	public String showDataset(HttpServletRequest request) {
		String dataSet_id = request.getParameter("dataSet_ID");
		DataSetBean dataSetBean = DaoFactory.getInstance().getDataSetDao()
				.getDataset(Long.parseLong(dataSet_id));
		request.setAttribute("datasetBean", dataSetBean);
		return "dataset_edit";
	}

	/**
	 * 显示本地字段
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/fieldShow")
	public String fieldShow(HttpServletRequest request) {
		String pageNumber = request.getParameter("pageNumber");
		String dataSet_id = request.getParameter("dataSet_ID");
		String fieldnameIndex = request.getParameter("fieldNameIndex");
		String fieldDescriptionIndex = request
				.getParameter("fieldDescriptionIndex");
		if (fieldnameIndex == null) {
			fieldnameIndex = "";
		}
		if (fieldDescriptionIndex == null) {
			fieldDescriptionIndex = "";
		}
		if (pageNumber == null) {
			pageNumber = "1";
		}
		List<LocalFieldBean> list = DaoFactory.getInstance().getDataSetDao()
				.getList(fieldnameIndex, fieldDescriptionIndex,
						Integer.parseInt(pageNumber),
						Long.parseLong(dataSet_id));
		request.setAttribute("FLList", list);
		// 分页栏
		int totalCount = DaoFactory.getInstance().getDataSetDao().getCount(
				fieldnameIndex, fieldDescriptionIndex,
				Long.parseLong(dataSet_id));
		Page page = new Page(Integer.parseInt(pageNumber), totalCount);
		PageTool pt = new PageTool();
		String pageTools = pt.getPageStringForJsSeek(page);
		request.setAttribute("page", pageTools);
		return "local_filed_show";
	}

	/**
	 * 增加本地字段
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/fieldadd")
	public String fieldadd(HttpServletRequest request) {
		List<F_Fields_GlobalBean> f_Fields_GlobalList = DaoFactory
				.getInstance().getDataSetDao().getF_Fields_Global("null");
		request.setAttribute("f_Fields_GlobalList", f_Fields_GlobalList);
		return "local_filed_edit";
	}

	/**
	 * 修改本地字段
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/fieldreset")
	public String fieldReset(HttpServletRequest request) {
		Long fields_Local_ID = Long.parseLong(request
				.getParameter("fields_Local_ID"));
		// 全局字段 下拉单
		List<F_Fields_GlobalBean> f_Fields_GlobalList = DaoFactory
				.getInstance().getDataSetDao().getF_Fields_Global("null");
		request.setAttribute("f_Fields_GlobalList", f_Fields_GlobalList);
		// 本地字段映射集
		LocalFieldBean localFieldBean = DaoFactory.getInstance()
				.getDataSetDao().getLocalFieldById(fields_Local_ID);
		request.setAttribute("localFieldBean", localFieldBean);
		return "local_filed_edit";
	}

	/**
	 * 筛选全局字段
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/fieldscreen")
	public String fieldscreen(HttpServletRequest request) {
		String screenIndex = request.getParameter("screenIndex").toUpperCase();
		List<F_Fields_GlobalBean> f_Fields_GlobalList = DaoFactory
				.getInstance().getDataSetDao().getF_Fields_Global(screenIndex);
		request.setAttribute("f_Fields_GlobalList", f_Fields_GlobalList);
		return "screen";
	}

	/**
	 * 添加或修改本地字段
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/fieldsubmit")
	public void fieldAddSubmit(HttpServletRequest request,
			HttpServletResponse response) {
		LocalFieldBean bean = new LocalFieldBean();
		bean.setFields_Local_ID(Long.parseLong(request
				.getParameter("fields_Local_ID")));
		bean.setIs_Tran(request.getParameter("is_Tran"));
		bean.setRegex(request.getParameter("regex"));
		bean.setData_Type(request.getParameter("data_Type"));
		bean.setField_Description(request.getParameter("field_Description"));
		bean.setField_Name(request.getParameter("field_Name"));
		bean.setFields_Global_ID(request.getParameter("fields_Global_ID"));
		if (bean.getFields_Local_ID() != 0) {
			try {
				response.getWriter().print(
						DaoFactory.getInstance().getDataSetDao()
								.updateLocalField(bean));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				bean
						.setFields_Local_ID(PKGenerator.getInstance()
								.generateKey());
				response.getWriter().print(
						DaoFactory.getInstance().getDataSetDao().addLocalField(
								bean));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 删除本地字段
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/fielddelete")
	public void fieldDelete(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("fields_Local_ID");
		try {
			response.getWriter().print(
					DaoFactory.getInstance().getDataSetDao().deleteLocalField(
							Long.parseLong(id)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *添加数据集字段关系
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/addRef")
	public void addRef(HttpServletRequest request, HttpServletResponse response) {
		String dataSet_ID = request.getParameter("dataSet_ID");
		String[] arr = request.getParameterValues("arr");
		try {
			response.getWriter().print(
					DaoFactory.getInstance().getDataSetDao().addRef(
							Long.parseLong(dataSet_ID), arr));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *修改数据集字段关系
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/updateRef")
	public void updateRef(HttpServletRequest request,
			HttpServletResponse response) {
		String refId = request.getParameter("refId");
		String is_Req = request.getParameter("is_Req");
		try {
			response.getWriter().print(
					DaoFactory.getInstance().getDataSetDao().updateRef(
							Long.parseLong(refId), is_Req));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *删除数据集字段关系
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/delRef")
	public void delRef(HttpServletRequest request, HttpServletResponse response) {
		String refId = request.getParameter("refId");
		try {
			response.getWriter().print(
					DaoFactory.getInstance().getDataSetDao().delRef(
							Long.parseLong(refId)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
