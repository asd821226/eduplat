package com.yinzhi.eduplat.web.foundation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.exitsoft.orm.core.PropertyFilters;
import org.exitsoft.orm.core.PropertyFilter;
import com.yinzhi.eduplat.common.SystemVariableUtils;
import com.yinzhi.eduplat.common.enumeration.SystemDictionaryCode;
import com.yinzhi.eduplat.entity.foundation.DataDictionary;
import com.yinzhi.eduplat.service.foundation.SystemDictionaryManager;
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
 * 数据字典管理Controller
 * 
 * @author vincent
 *
 */
@Controller
@RequestMapping("/security/foundation/data-dictionary")
public class DataDictionaryController {
	
	@Autowired
	private SystemDictionaryManager systemDictionaryManager;
	
	/**
	 * 获取数据字典列表
	 * 
	 * @param pageRequest 分页实体信息
	 * @param request HttpServlet请求
	 * 
	 * @return {@link Page}
	 */
	@RequestMapping("view")
	public Page<DataDictionary> view(
			@PageableDefaults(sort = { "id" }, sortDir = Direction.DESC) Pageable pageable,
			HttpServletRequest request) {
		
		List<PropertyFilter> filters = PropertyFilters.build(request);
		
		request.setAttribute("valueTypes", SystemVariableUtils.getDataDictionariesByCategoryCode(SystemDictionaryCode.ValueType));
		request.setAttribute("categoriesList", systemDictionaryManager.getAllDictionaryCategories());
		
		return systemDictionaryManager.searchDataDictionaryPage(pageable, filters);
	}
	
	/**
	 * 
	 * 保存数据字典,保存成功后重定向到:security/foundation/data-dictionary/view
	 * 
	 * @param entity 实体信息
	 * @param categoryId 所对应的字典类别id
	 * @param redirectAttributes spring mvc 重定向属性
	 * 
	 * @return String
	 * 
	 */
	@RequestMapping("save")
	public String save(@ModelAttribute("entity") DataDictionary entity,String categoryId,RedirectAttributes redirectAttributes) {
		
		if (StringUtils.isEmpty(categoryId)) {
			entity.setCategory(null);
		} else {
			entity.setCategory(systemDictionaryManager.getDictionaryCategory(categoryId));
		}
		
		systemDictionaryManager.saveDataDictionary(entity);
		redirectAttributes.addFlashAttribute("message", "保存成功");
		
		return "redirect:/security/foundation/data-dictionary/view";
	}
	
	/**
	 * 
	 * 读取数据字典,返回security/foundation/data-dictionary/read.ftl页面
	 * 
	 * @param model Spring mvc的Model接口，主要是将model的属性返回到页面中
	 * 
	 * @return String
	 * 
	 */
	@RequestMapping("read")
	public String read(Model model) {
		
		model.addAttribute("valueTypes", SystemVariableUtils.getDataDictionariesByCategoryCode(SystemDictionaryCode.ValueType));
		model.addAttribute("categoriesList", systemDictionaryManager.getAllDictionaryCategories());
		
		return "/security/foundation/data-dictionary/read";
		
	}
	
	/**
	 * 通过主键id集合删除数据字典,删除成功后重定向到:foundation/data-dictionary/view
	 * 
	 * @param ids 主键id集合
	 * @param redirectAttributes spring mvc 重定向属性
	 * 
	 * @return String
	 */
	@RequestMapping("delete")
	public String delete(@RequestParam("ids")List<String> ids,RedirectAttributes redirectAttributes) {
		systemDictionaryManager.deleteDataDictionary(ids);
		redirectAttributes.addFlashAttribute("message", "删除" + ids.size() + "条信息成功");
		return "redirect:/security/foundation/data-dictionary/view";
	}
	
	/**
	 * 绑定实体数据，如果存在id时获取后从数据库获取记录，进入到相对的C后在将数据库获取的记录填充到相应的参数中
	 * 
	 * @param id 主键ID
	 * 
	 */
	@ModelAttribute("entity")
	public DataDictionary bindingModel(@RequestParam(value = "id", required = false)String id) {
		
		DataDictionary dataDictionary = new DataDictionary();
		
		if (StringUtils.isNotEmpty(id)) {
			dataDictionary = systemDictionaryManager.getDataDictionary(id);
		}
		
		return dataDictionary;
	}
	
}
