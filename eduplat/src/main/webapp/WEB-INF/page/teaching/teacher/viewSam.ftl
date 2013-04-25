<#include "../header.ftl">

<div class="container secondary">
	<div class="row">
		<div class="span1 offset1">
			<a href="#" class="back-button big"></a>
		</div>
		<div class="span10">
			<div class="page-profile-title">
				<span>学生作答情况</span>
			</div>
			<div class="page-profile-table">
				<div class="row-fluid">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>学号</th>
								<th>姓名</th>
								<th>状态</th>
								<th>成绩</th>
								<th>作答时间</th>
								<th>完成时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<#if page.content??>
								<#list page.content as e>
									<tr>
										<td>${e.stuNo!'--'}</td>
										<td>${e.stuName!'--'}</td>
										<td>--</td>
										<td>${e.asmScore!'0'}</td>
										<td>--</td>
										<td>--</td>
										<#if e.assId??>
											<td><a href="readSam?assId=${e.assId!'0'}">考卷回顾</a> | <a href="#">调整成绩</a></td>
										<#else>
											<td><span class="label label-warning">未作答</span></td>
										</#if>
									</tr>
								</#list>
							</#if>
						</tbody>
					</table>
					<#if page.totalElements gt 0>
					<p class="text-info">共有<strong>${page.totalPages}</strong>页/<strong>${page.totalElements}</strong>条记录</p>
					<ul class="pager">
						<#if page.hasPreviousPage()>
					    	<li><a href="#">首页</a></li>
					    	<li><a href="#">上一页</a></li>
				        </#if>
				        <#if page.hasNextPage()>
				        	<li><a href="#">下一页</a></li>
					    	<li><a href="#">尾页</a></li>
				        </#if>
					</ul>
					</#if>
				</div>
			</div>
		</div>
	</div>
</div>

<#include "../footer.ftl">
