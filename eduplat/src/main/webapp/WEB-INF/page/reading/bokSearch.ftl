<#include "header.ftl">

<div class="container">
	<div class="row">
		<div class="span8 offset1">
			<div class="form-search">
				<form action="bokSearch" method="post">
				  <div class="input-append">
				    <input type="text" class="span5" name="keyword" />
				    <button type="submit" class="btn">搜索</button>
				  </div>
				</form>
			</div>
			<div class="search_result">
				<div class="result_br"><span>搜索结果1-15 共17621</span></div>
				<div class="result_ls">
					<#if page.content??>
						<#list page.content as e>
						<div class="result_it">
							<div class="it_img"><img src="http://localhost:8080/eduimg/resources/imgs/book01.jpg" /></div>
							<div class="it_info">
								<div class="it_cnt">
									<p class="cnt_title"><a href="bokinfo?bokId=${e.id}">${e.name}</a></p>
									<p class="cnt_author">${e.author} / ${e.publisherName} / ${e.publishDate} / ${e.price}元</p>
									<p><span class="bigstar20"></span><strong class="rating_num">8.5</strong>(79人评价)</p>						
								</div>
								<div class="it_opt">
									<div class="opt_left"><span><a href="#"><i class="icon-thumbs-up"></i></a></span></div>
									<div class="opt_right"><span><a href="#"><i class="icon-heart"></i></a></span></div>
								</div>
							</div>
						</div>
						</#list>
					</#if>
				</div>
				<#if page.totalElements gt 0>
				<p class="text-info">共有<strong>${page.totalPages}</strong>页/<strong>${page.totalElements}</strong>条记录</p>
				<ul class="pager">
					<#if page.hasPreviousPage()>
				    	<li><a href="mycmt?page.page=0">首页</a></li>
				    	<li><a href="mycmt?page.page=${page.number - 1}">上一页</a></li>
			        </#if>
			        <#if page.hasNextPage()>
			        	<li><a href="mycmt?page.page=${page.number + 1}">下一页</a></li>
				    	<li><a href="mycmt?page.page=${page.totalPages - 1}">尾页</a></li>
			        </#if>
				</ul>
				</#if>
			</div>
		</div>
		<div class="span3">
			<img src="../resources/img/t1.jpg">
			<h2><i class="icon-home"></i>推荐书籍</h2>
		</div>
	</div>
</div>

<#include "footer.ftl">
