<#include "../header.ftl">

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span3">
			<h2><i class="icon-home"></i>在线学习</h2>
			<ul class="nav nav-pills nav-stacked">
			  <li class=""><a href="currcor?corId=${corId}"><i class="icon-book"></i> 当前课程</a></li>
			  <li class=""><a href="corcwr?corId=${corId}"><i class="icon-facetime-video"></i> 课件</a></li>
			  <li class="active"><a href="corasm?corId=${corId}"><i class="icon-list"></i> 作业</a></li>
			</ul>
		</div>
		<div class="span9">
			<section id="my_curstu">
				<ul class="breadcrumb">
				  <li><a href="index">财经人</a> <span class="divider">/</span></li>
				  <li class="active">作业</li>
				</ul>
				<div id="edu-alert" class="alert alert-success">课外作业是对课堂教学的有效延伸，是知识的巩固和深化，是学生课外学习的重手段。</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>名称</th>
							<th>所在章节</th>
							<th>章节名称</th>
							<th>类型</th>
							<th>截至时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<#if page.content??>
							<#list page.content as e>
								<tr>
									<td>${e.asmName}</td>
									<td>第${e.chpOrder!'0'}章</td>
									<td>${e.chpName}</td>
									<td>${e.asmType!'0'}</td>
									<td>${e.endDate}</td>
									<td><a href="startAsm?asmId=${e.asmId}">开始作答</a>  <a href="readAss?asmId=${e.asmId}">考卷回顾</a></td>
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
			</section>
		</div>
	</div>
</div>

<#include "../footer.ftl">
