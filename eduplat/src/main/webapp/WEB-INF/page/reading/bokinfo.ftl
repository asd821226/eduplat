<#include "header.ftl">

<script src="../resources/scripts/jquery.raty.js"></script>
<script type="text/javascript">
	$(function() {
		$('#opt_stars').raty({
			hintList:['很差', '较差', '还行', '推荐', '力荐'],
			path:'../resources/img/',
			onClick: function(score) {
				$('#opt_stars').fadeOut(300);
				var bokId = $('#bokId').text();
				$.getJSON("updateStar?bokId="+bokId+"&score="+score, function(data){
		  			updateStarInfo(data);
				});
			}
		});
		getBokstar();
	});
	function getBokstar(){
		var bokId = $('#bokId').text();
		$.getJSON("bokstar?bokId="+bokId, function(data){
  			updateStarInfo(data);
		});
	}
	
	function updateStarInfo(data){
		var stars = data.stars;
		var stars1 = data.stars1;
		var stars2 = data.stars2;
		var stars3 = data.stars3;
		var stars4 = data.stars4;
		var num = stars+stars1+stars2+stars3+stars4;
		var total = stars+stars1*2+stars2*3+stars3*4+stars4*5;
		var per = forDight(total/num,1);
		$('.rating_num').text(per);
		$('#rating_no').text(num);
		//更新评分信息
		var bigStar = 10*per-(10*per)%5;
		if(bigStar==0){
			$('#big_star').attr('class','bigstar00');
		}else{
			$('#big_star').attr('class','bigstar'+bigStar);
		}
		$('#star_wid').attr('style','width:'+forDight((60*stars)/num,0)+'px');
		$('#star_per').text(forDight((100*stars)/num,1)+'%');
		$('#star_wid1').attr('style','width:'+forDight((60*stars1)/num,0)+'px');
		$('#star_per1').text(forDight((100*stars1)/num,1)+'%');
		$('#star_wid2').attr('style','width:'+forDight((60*stars2)/num,0)+'px');
		$('#star_per2').text(forDight((100*stars2)/num,1)+'%');
		$('#star_wid3').attr('style','width:'+forDight((60*stars3)/num,0)+'px');
		$('#star_per3').text(forDight((100*stars3)/num,1)+'%');
		$('#star_wid4').attr('style','width:'+forDight((60*stars4)/num,0)+'px');
		$('#star_per4').text(forDight((100*stars4)/num,1)+'%');
		$('#opt_stars').fadeIn(300);
	}
	function forDight(dight,how){  
        dight = Math.round(dight*Math.pow(10,how))/Math.pow(10,how);  
        return dight;  
    } 
</script>

<div class="container secondary">
	<div class="row">
		<div class="span1 offset1">
			<a href="#" class="back-button big"></a>
		</div>
		<div class="span10">
			<div class="page-profile-title">
				<span>${book.name}</span><span id="bokId">${book.id}</span>
			</div>
			<div class="subject_wrap">
				<div class="subject">
					<ul id="box5" class="subject_box">
						<li>
							<div class="box_pic">
								<a class="nbg" href="#" title="错身而过的街道">
									<img src="http://localhost:8080/eduimg/resources/imgs/book01.jpg" title="点击看大图" alt="错身而过的街道" />
								</a>
							</div>
						</li>
						<li>
							<div class="box_info">
								<p><span class="pl">作者:</span>${book.author}</p>
								<p><span class="pl">出版社:</span>${book.publisherName}</p>
								<p><span class="pl">出版年份:</span>${book.publishYear}</p>
								<p><span class="pl">页数:</span>${book.pageNum}</p>
								<p><span class="pl">定价:</span>${book.price}元</p>
								<p><span class="pl">装帧:</span>${book.bokType}</p>
								<p><span class="pl">ISBN:</span>${book.isbn}</p>
							</div>
						</li>
						<li>
							<div class="box_rate">
								<p><span id="big_star" class="bigstar20"></span><strong class="rating_num">8.5</strong></p>
								<p>(<a href="bokcmt?bokId=${book.id}"><span id="rating_no">22</span>人评价</a>)</p>
								<p><span class="stars5 starstop" title="力荐"></span><div id="star_wid4" class="power" style="width:54px"></div><span id="star_per4">40.9%</span></p>
								<p><span class="stars4 starstop" title="推荐"></span><div id="star_wid3" class="power" style="width:42px"></div><span id="star_per3">31.8%</span></p>
								<p><span class="stars3 starstop" title="还行"></span><div id="star_wid2" class="power" style="width:30px"></div><span id="star_per2">22.7%</span></p>
								<p><span class="stars2 starstop" title="较差"></span><div id="star_wid1" class="power" style="width:6px"></div><span id="star_per1">4.5%</span></p>
								<p><span class="stars1 starstop" title="很差"></span><div id="star_wid" class="power" style="width:0px"></div><span id="star_per">0.0%</span></p>
							</div>
						</li>
					</ul>
					<div class="subject_opt2">
						<span><a href="createFav?bokId=${book.id}"><i class="icon-heart"></i></a></span><span><a href="createRem?bokId=${book.id}"><i class="icon-thumbs-up"></i></a></span><span class="opt_cmt">评价：<em id="opt_stars"></em></span>
					</div>
				</div>
				<div class="subject_info">
					<h3>内容简介</h3>
					<div class="sub_cnt">
						<p>${book.bokInfo!'暂无'}</p>
					</div>
					<h3>作者简介</h3>
					<div class="sub_cnt">
						<p>${book.authorInfo!'暂无'}</p>
					</div>
					<h3>目录</h3>
					<div class="sub_cnt">
						<p>${book.bokDir!'暂无'}</p>
					</div>
					<h3>常用的标签（共85个）</h3>
					<div class="sub_cnt">
						<p><span class="cnt_tag"><a href="#">三国</a>(291)</span><span class="cnt_tag"><a href="#">三国</a>(291)</span><span class="cnt_tag"><a href="#">三国</a>(291)</span><span class="cnt_tag"><a href="#">三国</a>(291)</span><span class="cnt_tag"><a href="#">三国</a>(291)</span></p>
					</div>
					<h3>书评......</h3>
					<p><a href="bokcmt?bokId=${book.id}">查看更多</a></p>
					<h3>笔记......</h3>
					<p><a href="boknte?bokId=${book.id}">查看更多</a></p>
				</div>
			</div>
		</div>
	</div>
</div>

<#include "footer.ftl">
