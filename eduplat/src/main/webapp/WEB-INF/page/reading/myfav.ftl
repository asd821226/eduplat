<#include "header.ftl">

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span3">
			<h2><i class="icon-home"></i>我的书苑</h2>
			<ul class="nav nav-pills nav-stacked">
			  <li class="active"><a href="myfav"><i class="icon-book"></i> 我的收藏</a></li>
			  <li class=""><a href="mycmt"><i class="icon-user"></i> 我的书评</a></li>
			  <li class=""><a href="mynte"><i class="icon-facetime-video"></i> 我的笔记</a></li>
			  <li class=""><a href="myrep"><i class="icon-list"></i> 我的回应</a></li>
			</ul>
		</div>
		<div class="span9">
			<ul class="breadcrumb">
			  <li><a href="index">悦读书苑</a> <span class="divider">/</span></li>
			  <li class="active">我的收藏</li>
			</ul>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>图书名称</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<#if page.content??>
						<#list page.content as e>
							<tr>
								<td>${e.fkBookId!'--'}</td>
								<td><a href="deleteFav?favId=${e.id!'0'}">删除</a></td>
							</tr>
						</#list>
					</#if>
				</tbody>
			</table>
			<#if page.totalElements gt 0>
			<p class="text-info">共有<strong>${page.totalPages}</strong>页/<strong>${page.totalElements}</strong>条记录</p>
			<ul class="pager">
				<#if page.hasPreviousPage()>
			    	<li><a href="myfav?page.page=0">首页</a></li>
			    	<li><a href="myfav?page.page=${page.number - 1}">上一页</a></li>
		        </#if>
		        <#if page.hasNextPage()>
		        	<li><a href="myfav?page.page=${page.number + 1}">下一页</a></li>
			    	<li><a href="myfav?page.page=${page.totalPages - 1}">尾页</a></li>
		        </#if>
			</ul>
			</#if>
		</div>
	</div>
</div>
 
<#include "footer.ftl">