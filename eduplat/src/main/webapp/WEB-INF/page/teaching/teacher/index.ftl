<#include "../header.ftl">

<script type="text/javascript">
jQuery(function($){
	$('#demo1').slideBox({
		hideBottomBar : true//隐藏底栏
	});
});
</script>

<div class="container">
	<div class="row">
		<div class="span9">
			<div class="hottitle"><strong class="fl">热点关注：</strong><ul><li><a class="color_red" href="#">李开复对话陈士骏活动报名火热开展！</a> <a class="color_black" href="#">李开复对话硅谷教父视频精华版</a> </li><li><a href="#">手机频道全新上线</a> </li></ul></div>
			<section id="my_coring">
				<div class="h"><span>在教班级</span> <div class="ap"><a href="coring">更多</a></div></div>
				<div class="c">
					<div class="row-fluid">
						<#if coringList??>
							<#list coringList as coring>
							<div class="pack pack_album">
								<div class="pic">
									<div class="inner"><img width="132" class="pack_listImg quic" src="${coring.corPic!'../../resources/img/convert-blank.jpg'}"></div>
								</div>
								<div class="txt">
									<h6 class="caption">
										<#if coring.corStatus=2>
											<a href="currcor?corId=${coring.id}" title="${coring.name!'班级暂未命名'}">${coring.name!'班级暂未命名'}</a>
										<#else>
											<span>未指定教材</span>
										</#if>
									</h6>
									<ul class="info">
										<li><i class="icon-user"></i>${coring.stuSize!'1,000'} <i class="icon-play-circle"></i>${coring.cwrSize!'15'} <i class="icon-tasks"></i>${coring.cwrSize!'97'} </li>
									</ul>
								</div>
							</div>
							</#list>
						</#if>
					</div>
				</div>
				<hr />
				<div class="h"><span>已教班级</span> <div class="ap"><a href="cored">更多</a></div></div>
				<div class="c">
					<div class="row-fluid">
						<#if coredList??>
							<#list coredList as cored>
							<div class="pack pack_album">
								<div class="pic">
									<div class="inner"><img width="132" class="pack_listImg quic" src="${cored.corPic!'../../resources/img/convert-blank.jpg'}"></div>
								</div>
								<div class="txt">
									<h6 class="caption">
										<#if cored.corStatus=2>
											<a href="currcor?corId=${cored.id}" title="${cored.name!'班级暂未命名'}">${cored.name!'班级暂未命名'}</a>
										<#else>
											<span>未指定教材</span>
										</#if>
									</h6>
									<ul class="info">
										<li><i class="icon-user"></i>${cored.stuSize!'0'} <i class="icon-play-circle"></i>${cored.cwrSize!'0'} <i class="icon-tasks"></i>${cored.cwrSize!'0'} </li>
									</ul>
								</div>
							</div>
							</#list>
						</#if>
					</div>
				</div>
		</div>
		<div class="span3">
			<div id="demo1" class="slideBox">
			  <ul class="items">
			    <li><a href="go/to/your/url.html" title="这里是测试标题一"><img src="../../resources/img/t1.jpg"></a></li>
			    <li><a href="go/to/your/url.html" title="这里是测试标题二"><img src="../../resources/img/t2.jpg"></a></li>
			    <li><a href="go/to/your/url.html" title="这里是测试标题三"><img src="../../resources/img/t3.jpg"></a></li>
			    <li><a href="go/to/your/url.html" title="这里是测试标题四"><img src="../../resources/img/t4.jpg"></a></li>
			    <li><a href="go/to/your/url.html" title="这里是测试标题五"><img src="../../resources/img/t5.jpg"></a></li>
			  </ul>
			</div>	
			<h2 class="thumb_title">推荐书籍</h2>
		</div>
	</div>
</div>

<#include "../footer.ftl">