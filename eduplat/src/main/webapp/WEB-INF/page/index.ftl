<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <title>学秩网</title>
    <meta charset="utf-8">
    <link href="resources/styles/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="resources/styles/bootstrap-responsive.min.css" rel="stylesheet">
	<script type="text/javascript">
		function reloadValidateCode() {
			$("#validateCodeImg").attr("src","/eduplat/validateCode?date = " + new Date() + Math.floor(Math.random()*24));
		}
	</script>
	<style type="text/css">
		body{font-family:"微软雅黑","Arial Narrow",HELVETICA;background:#fff;}
		.t-content{text-indent: 2em;word-spacing: 30px;padding:0px 0px 0px 5px;}
		.t-bg{background-image: url(resources/img/home_bg.jpg);height:220px;}
		.footer{text-align:center;margin:45px;}
	</style>
  </head>
  <body>
	<div class="container">
		<div class="row">
			<div class="span10 offset1">
				<div class="navbar">
					<div class="navbar-inner">
						<div class="container">
							<a class="brand" href="#">学秩网</a>
							<div class="nav nav-pills pull-right">
								<ul class="nav">
									<li><a href="#">关于</a></li>
									<li><a href="#">联系我们</a></li>
									<li><a href="#">帮助</a></li>
									<li><a href="login">登录</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span10 offset1">
				<div class="hero-unit t-bg">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span10 offset1">
				<div class="row-fluid">
					<div class="span4">
						<div class="thumbnail">
							<a href="teaching/index"><img src="resources/img/t-c1.png" /></a>
							<p class="t-content">财经人能够培养学生良好的信息素养，把信息技术作为支持终身学习和合作学习的手段，为适应信息社会的学习、工作和生活打下必要的基础。</p>
						</div>
					</div>
					<div class="span4">
						<div class="thumbnail">
							<a href="reading/index"><img src="resources/img/t-c2.png" /></a>
							<p class="t-content">财经人能够培养学生良好的信息素养，把信息技术作为支持终身学习和合作学习的手段，为适应信息社会的学习、工作和生活打下必要的基础。</p>
						</div>
					</div>
					<div class="span4">
						<div class="thumbnail">
							<img src="resources/img/t-c3.png" />
							<p class="t-content">财经人能够培养学生良好的信息素养，把信息技术作为支持终身学习和合作学习的手段，为适应信息社会的学习、工作和生活打下必要的基础。</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer class="footer">© Company 2013</footer>
    <script src="resources/scripts/jquery-1.9.1.js"></script>
    <script src="resources/scripts/bootstrap.min.js"></script>
  </body>
</html>