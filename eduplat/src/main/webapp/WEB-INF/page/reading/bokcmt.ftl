<#include "header.ftl">

<script type="text/javascript">
	function bokCmt(){
		$.post("createCmt", $("#cmt_form").serialize(),
			function(data){
				window.location.reload();
			}
		);
	}
</script>
<div class="container secondary">
	<div class="row">
		<div class="span1 offset1">
			<a href="#" class="back-button big"></a>
		</div>
		<div class="span10">
			<div class="page-profile-title">
				<span>${bokId!'--'}</span>
			</div>
			<#if page.content??>
				<#list page.content as e>
				<div class="tlst">
					<div class="nlst">
						<h3><a href="bokrep?cmtId=${e.id}">${e.title!'--'}</a></h3>
					</div>
					<div class="clst">
						<div class="review-short">${e.content!'--'}</div>
						<div class="pl">
		                    <span class="fleft">
		                        <span>${e.createTime!'0000-00-00 00:00'} &nbsp; &nbsp;</span>
		                    </span>
	                    </div>
					</div>
				</div>
				</#list>
			</#if>
			<#if page.totalElements gt 0>
			<p class="text-info">共有<strong>${page.totalPages}</strong>页/<strong>${page.totalElements}</strong>条记录</p>
			<ul class="pager">
				<#if page.hasPreviousPage()>
			    	<li><a href="bokcmt?page.page=0">首页</a></li>
			    	<li><a href="bokcmt?page.page=${page.number - 1}">上一页</a></li>
		        </#if>
		        <#if page.hasNextPage()>
		        	<li><a href="bokcmt?page.page=${page.number + 1}">下一页</a></li>
			    	<li><a href="bokcmt?page.page=${page.totalPages - 1}">尾页</a></li>
		        </#if>
			</ul>
			</#if>
			<form id="cmt_form" method="post" action="createCmt">
				<input type="hidden" name="bokId" value="${bokId}" />
				<div class="control-group">
					<label class="control-label" for="inputTitle">标题：</label>
					<div class="controls">
						<input type="text" class="span4" name="title" id="inputTitle" placeholder="标题">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputContent">内容：</label>
					<div class="controls">
						<textarea rows="3" style="width:420px;height:150px;" name="content"></textarea>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<button type="button" onclick="bokCmt();" class="btn btn-primary">提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<#include "footer.ftl">
