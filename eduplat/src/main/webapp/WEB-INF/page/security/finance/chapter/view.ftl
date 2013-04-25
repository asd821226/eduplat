<#assign shiro=JspTaglibs["/WEB-INF/taglib/shiro.tld"] />
<script>
	$(document).ready(function(){
		$(".close").click(
			function () {
				$(this).parent().fadeTo(400, 0, function () {
					$(this).slideUp(400);
				});
				return false;
			}
		);
		$("#selectAll").click(function(){
			var checks = $("#chapter_list tbody").find("input[type='checkbox'][id!='selectAll']");
			checks.attr('checked', $(this).is(':checked'));
			checks.click();
		});
	});
	
	function search(page){
		var param = $.form.getParameters("#search_form",true);
		param["page.size"] = $("#size").val();
		param["page.page"] = page || 0;
		$.maskLoad({
			url:'finance/chapter/view',
			param:param,
			target:'#main_content'
		});
	}
</script>
<div id="chapter_panel">
	
	<div class="panel_title">
	 	<span class="user24_icon">章节管理</span>
	</div>
	
	<div class="panel_content">
	  <#if message?has_content>
	  	  <div class="notification information">
	  	  	<a href="#" class="close"><img src="resources/images/icons/16/close.png" title="关闭信息" alt="关闭"></a>
	  	  	${message}
	  	  </div>
  	  </#if>
	  <form id="delete_form" action="finance/chapter/delete" method="post">
		  <table width="100%" id="chapter_list">
		    	<thead>
		        	<tr>
		        		<th>
		        			<div style="width:15px;height:15px;margin:0 auto;">
		        				<input type="checkbox" id="selectAll" class="checker"/>
		        			</div>
		        		</th>
		            	<th>
		                	名称
		            	</th>
		                <th>
		                	序号
		            	</th>
		                <th>
		                	图书ID
		            	</th>
		            	<th>
		            		操作
		            	</th>
		            </tr>
		        </thead>
		        <tbody>
		        	<#list page.content as e>
		            	<tr>
		            		<td>
		            			<div style="width:15px;height:15px;margin:0 auto;">
		            				<input type="checkbox" name="ids" value="${e.id}" class="checker"/>
		            			</div>
		            		</td>
		                	<td>
		                    	${e.name!""}
		                    </td>
		                    <td>
		                    	${e.chpOrder!""}
		                    </td>
		                    <td>
		                    	${e.fkBookId!""}
		                    </td>
		                    <td align="center">
		                    	<@shiro.hasPermission name="chapter:read">
		                    		<a href="finance/chapter/read?id=${e.id}" icon="user24_icon"  width="610" target="dialog" dialogId="update_chapter" modal="true" title="修改学生/${e.name}" class="operat edit16_icon">
		                    	</@shiro.hasPermission>
		                    </td>
		                </tr>
		            </#list>
		        </tbody>
		    </table>
		</form>
	</div>
	<div class="panel_footer">
		<@shiro.hasPermission name="chapter:save">
			<a href="finance/chapter/read" icon="user24_icon" width="610" target="dialog" dialogId="create_chapter" modal="true" title="添加用户">
				<span class="button left">添 加</span>
			</a>
		</@shiro.hasPermission>
		<@shiro.hasPermission name="chapter:delete">
	    	<a href="javascript:$.form.submitMaskForm('#delete_form',{maskEl:'#chapter_panel',target:'#main_content',promptMsg:'确定要删除吗?'})" title="删除选中用户">
	    		<span class="button left">删 除</span>
	    	</a>
	    </@shiro.hasPermission>
	    <a href="#search_chapter_dailog" width="610" icon="user24_icon" target="dialog" dialogId="search_dailog" title="查询学生列表">
	    	<span class="button left">查 询</span>
	    </a>
	</div>
	
	<#if page.totalElements gt 0>
		<div class="panel_pagging">
		 	<div class="page_bar">
		    	每页显示:<input type="text" size="2" id="size" name="size" class="text_input_small" value="${page.size}"/> 共有${page.totalPages}页/${page.totalElements}条记录
		    </div>
		    <div class="page_bar">
		    	<#if page.hasPreviousPage()>
			    	<a href="javascript:search(0)">
			        	首页
			        </a>
			        <a href="javascript:search(${page.number - 1})">
			        	上一页
			        </a>
		        </#if>
		        <#if page.hasNextPage()>
			        <a href="javascript:search(${page.number + 1})">
			        	下一页
			        </a>
			        <a href="javascript:search(${page.totalPages - 1})">
			        	尾页
			        </a>
		        </#if>
		    </div>
		</div>
	</#if>
</div>