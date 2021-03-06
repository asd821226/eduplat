package com.yinzhi.eduplat.web.account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.exitsoft.orm.core.PropertyFilters;
import org.exitsoft.orm.core.PropertyFilter;
import com.yinzhi.eduplat.common.SystemVariableUtils;
import com.yinzhi.eduplat.common.enumeration.SystemDictionaryCode;
import com.yinzhi.eduplat.entity.account.Resource;
import com.yinzhi.eduplat.service.account.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 资源管理Controller
 * 
 * @author vincent
 *
 */
@Controller
@RequestMapping("/security/account/resource")
public class ResourceController {

	@Autowired
	private AccountManager accountManager;
	
	/**
	 * 获取资源列表
	 * 
	 * @param pageRequest 分页实体信息
	 * @param request HttpServlet请求
	 * 
	 * @return {@link Page}
	 */
	@RequestMapping("view")
	public Page<Resource> view(
			@PageableDefaults(sort = {"id"},sortDir=Direction.DESC)Pageable pageable,
			HttpServletRequest request) {
		
		List<PropertyFilter> filters = PropertyFilters.build(request);
		
		request.setAttribute("resourceType", SystemVariableUtils.getDataDictionariesByCategoryCode(SystemDictionaryCode.ResourceType));
		request.setAttribute("resourcesList", accountManager.getAllResources());
		
		return accountManager.searchResourcePage(pageable, filters);
	}
	
	/**
	 * 
	 * 保存资源,保存成功后重定向到:security/account/resource/view
	 * 
	 * @param entity 实体信息
	 * @param parentId 所对应的父类id
	 * @param redirectAttributes spring mvc 重定向属性
	 * 
	 * @return String
	 */
	@RequestMapping("save")
	public String save(@ModelAttribute("entity") Resource entity,String parentId,RedirectAttributes redirectAttributes) {
		
		if (StringUtils.isEmpty(parentId)) {
			entity.setParent(null);
		} else {
			entity.setParent(accountManager.getResource(parentId));
		}
		
		accountManager.saveResource(entity);
		redirectAttributes.addFlashAttribute("message", "保存成功");
		return "redirect:/security/account/resource/view";
	}
	
	/**
	 * 
	 * 读取资源信息,返回security/account/resource/read.ftl页面
	 * 
	 * @param model Spring mvc的Model接口，主要是将model的属性返回到页面中
	 * 
	 * @return String
	 */
	@RequestMapping("read")
	public String read(@RequestParam(value = "id", required = false)String id,Model model) {
		
		model.addAttribute("resourceType", SystemVariableUtils.getDataDictionariesByCategoryCode(SystemDictionaryCode.ResourceType));

		if (StringUtils.isEmpty(id)) {
			model.addAttribute("resourcesList", accountManager.getAllResources());
		} else {
			model.addAttribute("resourcesList", accountManager.getAllResources(id));
		}
		
		return "security/account/resource/read";
	}
	
	/**
	 * 通过主键id集合删除资源,删除成功后重定向到:security/account/resource/view
	 * 
	 * @param ids 主键id集合
	 * @param redirectAttributes spring mvc 重定向属性
	 * 
	 * @return String
	 */
	@RequestMapping("delete")
	public String delete(@RequestParam("ids")List<String> ids,RedirectAttributes redirectAttributes) {
		accountManager.deleteResources(ids);
		redirectAttributes.addFlashAttribute("message", "删除" + ids.size() + "条信息成功");
		return "redirect:/security/account/resource/view";
	}
	
	/**
	 * 绑定实体数据，如果存在id时获取后从数据库获取记录，进入到相对的C后在将数据库获取的记录填充到相应的参数中
	 * 
	 * @param id 主键ID
	 * 
	 */
	@ModelAttribute("entity")
	public Resource bindingModel(@RequestParam(value = "id", required = false)String id) {
		
		Resource resource = new Resource();
		
		if (StringUtils.isNotEmpty(id)) {
			resource = accountManager.getResource(id);
		}
		
		return resource;
	}
}
