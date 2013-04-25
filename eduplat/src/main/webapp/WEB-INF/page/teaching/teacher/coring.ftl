<#include "../header.ftl">

<div class="container secondary">
	<div class="row">
		<div class="span1 offset1">
			<a href="#" class="back-button big"></a>
		</div>
		<div class="span10">
			<div class="h">
				<span><a href="#cwrModel" role="button" data-toggle="modal">创建班级&gt;&gt;</a></span>
				<div class="ap">
					<ul class="tl">
						<li><a href="#">综合排序</a></li>
						<li>/</li>
						<li><a href="coring" class="selected">在教班级</a></li>
						<li>/</li>
						<li><a href="cored">已教班级</a></li>
					</ul>
				</div>
			</div>
			<div class="c">
				<div class="row-fluid">
					<#if page.content??>
						<#list page.content as e>
						<div class="pack pack_album">
							<div class="pic">
								<div class="inner"><img width="132" class="pack_listImg quic" src="${e.bokPic!'../../resources/img/convert-blank.jpg'}"></div>
							</div>
							<div class="txt">
								<h6 class="caption">
									<#if e.corStatus=2>
										<a href="currcor?corId=${e.id}" title="${e.name!'班级暂未命名'}">${e.name!'班级暂未命名'}</a>
									<#else>
										<span>未指定教材</span>
									</#if>
								</h6>
							</div>
						</div>
						</#list>
					</#if>
				</div>
			</div>
			<div class="row-fluid">
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

<!-- Modal -->
<div id="cwrModel" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="cwrModalLabel" aria-hidden="true">
  <div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	<h3 id="cwrModalLabel">创建班级</h3>
  </div>
  <div class="modal-body">
	<form id="cor_form" method="post" action="insertCor" class="form-horizontal">
	  <div class="control-group">
		<label class="control-label" for="inputName">名称</label>
		<div class="controls">
		  <input type="text" name="name" id="inputName" placeholder="名称">
		</div>
	  </div>
	  <div class="control-group">
		<label class="control-label" for="inputBokKind">课程性质</label>
		<div class="controls" id="inputBokKind">
		  <select name="bokKind">
			<option>0</option>
			<option>1</option>
		  </select>
		</div>
	  </div>
	  <div class="control-group">
		<label class="control-label" for="inputBokType">课程类型</label>
		<div class="controls" id="inputBokType">
		  <select name="bokType">
			<option>0</option>
			<option>1</option>
		  </select>
		</div>
	  </div>
	  <div class="control-group">
		<label class="control-label" for="inputEndDate">失效日期</label>
		<div class="controls" id="inputEndDate">
		  <div id="datetimepicker1" class="input-append date">
		    <input data-format="dd/MM/yyyy hh:mm:ss" type="text" name="tendDate"></input>
		    <span class="add-on"><i data-time-icon="icon-time" data-date-icon="icon-calendar"></i></span>
		  </div>
		<script type="text/javascript">
		  $(function() {
		    $('#datetimepicker1').datetimepicker({
		      language: 'pt-BR'
		    });
		  });
		</script>
		</div>
	  </div>
	  <div class="control-group">
	    <div class="controls">
	      <button type="submit" class="btn btn-primary">提交</button>
	    </div>
	  </div>
	</form>
  </div>
  <div class="modal-footer">
	<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
  </div>
</div>

<#include "../footer.ftl">
