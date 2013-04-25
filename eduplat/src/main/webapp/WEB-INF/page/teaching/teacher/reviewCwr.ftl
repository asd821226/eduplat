<#include "../header.ftl">

<div class="container">
	<div class="row">
		<div class="span3">
		</div>
		<div class="span9">
			<section id="my_reviewCwr">
				<div id="myCarousel" class="carousel slide">
				  <!-- Carousel items -->
				  <div class="carousel-inner">
				    <#list imgs as img>
				    	<#if img_index==0>
				    		<div class="active item"><img src="${img!'null.png'}" /></div>
				    	<#else>
							<div class="item"><img src="${img!'null.png'}" /></div>
				    	</#if>
					</#list>
				  </div>
				  <!-- Carousel nav -->
				  <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
				  <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
				</div>
			</section>
		</div>
	</div>
</div>

<#include "../footer.ftl">