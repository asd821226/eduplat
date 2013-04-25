<#include "../header.ftl">

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span3">
			<h2><i class="icon-home"></i>在线学习</h2>
			<ul class="nav nav-pills nav-stacked">
			  <li class=""><a href="currcor?corId=${corId}"><i class="icon-book"></i> 当前课程</a></li>
			  <li class="active"><a href="corstu?corId=${corId}"><i class="icon-user"></i> 本班学生</a></li>
			  <li class=""><a href="corcwr?corId=${corId}"><i class="icon-facetime-video"></i> 课件</a></li>
			  <li class=""><a href="corasm?corId=${corId}"><i class="icon-list"></i> 作业</a></li>
			  <li class=""><a href="#"><i class="icon-certificate"></i> 成绩统计</a></li>
			</ul>
		</div>
		<div class="span9">
			<ul class="breadcrumb">
			  <li><a href="index">财经人</a> <span class="divider">/</span></li>
			  <li class="active">本班学生</li>
			</ul>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>学号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>手机号码</th>
						<th>所在城市</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<#if page.content??>
						<#list page.content as e>
							<tr>
								<td>${e.stuNo}</td>
								<td>${e.name}</td>
								<td>${e.sex}</td>
								<td>${e.telephone}</td>
								<td>${e.city}</td>
								<td><a href="stuinfo?stuId=${e.id}">详细</a></td>
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

<#include "../footer.ftl">
