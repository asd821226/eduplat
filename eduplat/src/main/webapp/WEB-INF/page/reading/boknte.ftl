<#include "header.ftl">

<script type="text/javascript">
	function bokNte(){
		$.post("createNte", $("#nte_form").serialize(),
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
						<h3>${e.chpName!'--'} / 【${e.pageNo}】</h3>
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
			    	<li><a href="#">首页</a></li>
			    	<li><a href="#">上一页</a></li>
		        </#if>
		        <#if page.hasNextPage()>
		        	<li><a href="#">下一页</a></li>
			    	<li><a href="#">尾页</a></li>
		        </#if>
			</ul>
			</#if>
			<form id="nte_form" method="post" action="createNte">
				<input type="hidden" name="bokId" value="${bokId}" />
				<div class="control-group">
					<label class="control-label" for="inputChpName">章节：</label>
					<div class="controls">
						<input type="text" class="span4" name="chpName" id="inputChpName" placeholder="章节">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputPageNo">页码：</label>
					<div class="controls">
						<input type="text" name="pageNo" id="inputPageNo" placeholder="页码">
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
						<button type="button" onclick="bokNte();" class="btn btn-primary">提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<#include "footer.ftl">
