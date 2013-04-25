<#include "../header.ftl">

<div class="container secondary">
	<div class="row">
		<div class="span1 offset1">
			<a href="#" class="back-button big"></a>
		</div>
		<div class="span10">
			<div class="h">
				<div class="ap">
					<ul class="tl">
						<li><a href="#">综合排序</a></li>
						<li>/</li>
						<li><a href="coring" class="selected">在修课程</a></li>
						<li>/</li>
						<li><a href="cored">已修课程</a></li>
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

<#include "../footer.ftl">
