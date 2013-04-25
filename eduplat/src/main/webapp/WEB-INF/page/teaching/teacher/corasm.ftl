<#include "../header.ftl">

<script type="text/javascript">
	function releaseAsm(asmId){
		$.get("releaseAsm", {asmId:asmId},
		function(data){
			$('#edu-alert').text(data);
		});
	}
	function deleteAsm(asmId){
		$.get("deleteAsm", {asmId:asmId},
		function(data){
			$('#edu-alert').text(data);
		});
	}
</script>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span3">
			<h2><i class="icon-home"></i>在线学习</h2>
			<ul class="nav nav-pills nav-stacked">
			  <li class=""><a href="currcor?corId=${corId}"><i class="icon-book"></i> 当前课程</a></li>
			  <li class=""><a href="corstu?corId=${corId}"><i class="icon-user"></i> 本班学生</a></li>
			  <li class=""><a href="corcwr?corId=${corId}"><i class="icon-facetime-video"></i> 课件</a></li>
			  <li class="active"><a href="corasm?corId=${corId}"><i class="icon-list"></i> 作业</a></li>
			  <li class=""><a href="#"><i class="icon-certificate"></i> 成绩统计</a></li>
			</ul>
		</div>
		<div class="span9">
			<section id="my_curstu">
				<ul class="breadcrumb">
				  <li><a href="index">财经人</a> <span class="divider">/</span></li>
				  <li class="active">作业</li>
				</ul>
				<div id="edu-alert" class="alert alert-success">课外作业是对课堂教学的有效延伸，是知识的巩固和深化，是学生课外学习的重手段。</div>
				<p class="page-cnt-opeator"><a class="btn btn-info" href="createAsm?corId=${corId}">布置作业</a></p>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>名称</th>
							<th>所在章节</th>
							<th>章节名称</th>
							<th>类型</th>
							<th>截至时间</th>
							<th>操作</th>
							<th>学生作答情况</th>
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
									<td>
										<#if e.assStatus==2>
											<a href="#" onclick="deleteAsm('${e.asmId}');">删除</a>
											<a href="#" onclick="releaseAsm('${e.asmId}');">发布</a>
										<#else>
											<span class="label label-info">已发布</span>
										</#if>
										<a href="reviewAsm?asmId=${e.asmId}">共享</a>
										<a href="reviewAsm?asmId=ef0002b13dd43434013dd43483c20000">预览</a>
									</td>
									<td><a href="viewSam?asmId=${e.asmId}">查看</a></td>
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
