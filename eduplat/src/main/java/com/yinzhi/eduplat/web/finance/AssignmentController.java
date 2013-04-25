package com.yinzhi.eduplat.web.finance;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.exitsoft.orm.core.PropertyFilter;
import org.exitsoft.orm.core.PropertyFilters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yinzhi.eduplat.entity.finance.Assignment;
import com.yinzhi.eduplat.service.finance.FinanceManager;

/**
 * Assignment Controller
 * @author 黄清泉
 * @date 2013-3-13
 */
@Controller
@RequestMapping("/security/finance/assignment")
public class AssignmentController {

	@Autowired
	private FinanceManager financeManager;
	
	/**
	 * 获取Assignment列表
	 * 
	 * @param pageRequest 分页实体信息
	 * @param request HttpServlet请求
	 * 
	 * @return {@link Page}
	 */
	@RequestMapping("view")
	public Page<Assignment> view(
			@PageableDefaults(sort = { "id" }, sortDir = Direction.DESC) Pageable pageable,
			HttpServletRequest request) {
		
		List<PropertyFilter> filters = PropertyFilters.build(request);
		
		return financeManager.searchAssignmentPage(pageable, filters);
	}
	
}
