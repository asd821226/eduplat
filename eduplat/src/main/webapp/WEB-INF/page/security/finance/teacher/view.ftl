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
			var checks = $("#teacher_list tbody").find("input[type='checkbox'][id!='selectAll']");
			checks.attr('checked', $(this).is(':checked'));
			checks.click();
		});
	});
	
	function search(page){
		var param = $.form.getParameters("#search_form",true);
		param["page.size"] = $("#size").val();
		param["page.page"] = page || 0;
		$.maskLoad({
			url:'finance/teacher/view',
			param:param,
			target:'#main_content'
		});
	}
</script>
<div id="teacher_panel">
	
	<div class="panel_title">
	 	<span class="user24_icon">教师管理</span>
	</div>
	
	<div class="panel_content">
	  <#if message?has_content>
	  	  <div class="notification information">
	  	  	<a href="#" class="close"><img src="resources/images/icons/16/close.png" title="关闭信息" alt="关闭"></a>
	  	  	${message}
	  	  </div>
  	  </#if>
	  <form id="delete_form" action="finance/teacher/delete" method="post">
		  <table width="100%" id="teacher_list">
		    	<thead>
		        	<tr>
		        		<th>
		        			<div style="width:15px;height:15px;margin:0 auto;">
		        				<input type="checkbox" id="selectAll" class="checker"/>
		        			</div>
		        		</th>
		            	<th>
		                	姓名
		            	</th>
		                <th>
		                	性别
		            	</th>
		                <th>
		                	城市
		            	</th>
		                <th>
		                	生日
		            	</th>
		                <th>
		                	照片
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
		                    	${e.sex!""}
		                    </td>
		                    <td>
		                    	${e.city!""}
		                    </td>
		                    <td>
		                    	${e.birthday!""}
		                    </td>
		                    <td>
		                    	${e.photo!""}
		                    </td>
		                    <td align="center">
		                    	<@shiro.hasPermission name="teacher:read">
		                    		<a href="finance/teacher/read?id=${e.id}" icon="user24_icon"  width="610" target="dialog" dialogId="update_teacher" modal="true" title="修改学生/${e.name}" class="operat edit16_icon">
		                    	</@shiro.hasPermission>
		                    </td>
		                </tr>
		            </#list>
		        </tbody>
		    </table>
		</form>
	</div>
	<div class="panel_footer">
		<@shiro.hasPermission name="teacher:save">
			<a href="finance/teacher/read" icon="user24_icon" width="610" target="dialog" dialogId="create_teacher" modal="true" title="添加用户">
				<span class="button left">添 加</span>
			</a>
		</@shiro.hasPermission>
		<@shiro.hasPermission name="teacher:delete">
	    	<a href="javascript:$.form.submitMaskForm('#delete_form',{maskEl:'#teacher_panel',target:'#main_content',promptMsg:'确定要删除吗?'})" title="删除选中用户">
	    		<span class="button left">删 除</span>
	    	</a>
	    </@shiro.hasPermission>
	    <a href="#search_teacher_dailog" width="610" icon="user24_icon" target="dialog" dialogId="search_dailog" title="查询学生列表">
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