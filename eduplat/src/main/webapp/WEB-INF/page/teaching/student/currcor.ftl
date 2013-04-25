<#include "../header.ftl">

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span3">
			<h2><i class="icon-home"></i>在线学习</h2>
			<ul class="nav nav-pills nav-stacked">
			  <li class="active"><a href="currcor?corId=${cor.id}"><i class="icon-book"></i> 当前课程</a></li>
			  <li class=""><a href="corcwr?corId=${cor.id}"><i class="icon-facetime-video"></i> 课件</a></li>
			  <li class=""><a href="corasm?corId=${cor.id}"><i class="icon-list"></i> 作业</a></li>
			</ul>
		</div>
		<div class="span6">
			<ul class="breadcrumb">
			  <li><a href="index">财经人</a> <span class="divider">/</span></li>
			  <li class="active">当前课程</li>
			</ul>
			<div class="course-summary">
				<div class="course-info">
					<img src="${cor.bokPic!'../../resources/img/convert-blank.jpg'}" alt="${cor.corName}" />
					<div class="info-status">
						<h1>${cor.corName}</h1>
						<div class="extra-info">
							<p>授课教师：${cor.tecName}</p>
							<p>失效日期：${cor.endDate}</p>
							<p>来自：${cor.tecSchool!'暂无'}</p>
						</div>
						<p class="brief">课程简介。。。。。。</p>
					</div>
					<div class="tip-join-course-num">
						<p><strong>${cor.stuNum!'0'}</strong><br><span>已学习</span></p>
					</div>
				</div>
			</div>
			<table class="table table-hover">
			  <thead>
				<tr>
				  <th>课程目录</th>
				  <th>页数</th>
				</tr>
			  </thead>
			  <tbody>
				<tr>
				  <td>1</td>
				  <td>Mark</td>
				</tr>
			  </tbody>
			</table>
		</div>
	</div>
</div>

<#include "../footer.ftl">
