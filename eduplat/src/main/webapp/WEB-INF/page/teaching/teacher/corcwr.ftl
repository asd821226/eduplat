<#include "../header.ftl">

<script type="text/javascript" src="../../resources/scripts/jquery.upload.js"></script>
<script type="text/javascript">
	function uploadCwr(corId, chpId){
		$.upload({
	        url: 'uploadCwr', 
	        fileName: 'cwrFile', 
	        params: {corId: corId, chpId: chpId},
	        dataType: 'text',
	        onSend: function() {
	           return true;
	        },
	        onComplate: function(data) {
	           $('#edu-alert').text(data);
	        }
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
			  <li class="active"><a href="corcwr?corId=${corId}"><i class="icon-facetime-video"></i> 课件</a></li>
			  <li class=""><a href="corasm?corId=${corId}"><i class="icon-list"></i> 作业</a></li>
			  <li class=""><a href="#"><i class="icon-certificate"></i> 成绩统计</a></li>
			</ul>
		</div>
		<div class="span9">
			<ul class="breadcrumb">
			  <li><a href="index">财经人</a> <span class="divider">/</span></li>
			  <li class="active">课件</li>
			</ul>
			<div id="edu-alert" class="alert alert-success">许多老师把课件应用于课堂，优化了课堂教学，提高了课堂质量。</div>
			<div id="edu-upload" class="alert alert-info" style="display:none;">
				<form name="uploadform" method="post" action="uploadCwr" enctype="multipart/form-data">
					<input id="corId" type="hidden" name="corId"/><input id="chpId" type="hidden" name="chpId"/>
					<input class="input-large" type="file" placeholder="请选择文件" name="cwrFile" />
					<button type="button" class="btn" onclick="uploadCwr();">上传</button>
			    </form>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>名称</th>
						<th>所在章节</th>
						<th>章节名称</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<#if page.content??>
						<#list page.content as e>
							<tr>
								<td>${e.cwrName!'--'}</td>
								<td>第${e.chpOrder!'0'}章</td>
								<td>${e.chpName!'--'}</td>
								<td><a href="readCwr?corId=${e.corId}&chpId=${e.chpId}">制作</a>
								 &nbsp;<a href="#" onclick="uploadCwr('${e.corId}','${e.chpId}');">上传</a>
								 &nbsp;<a href="reviewCwr?cwrId=${e.cwrId}">浏览</a>
								 &nbsp;<a href="shareCwr?corId=${e.corId}&chpId=${e.chpId}&cwrId=${e.cwrId}">共享</a>
								 &nbsp;<a href="downloadCwr?corId=${e.corId}&chpId=${e.chpId}">下载</a></td>
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

