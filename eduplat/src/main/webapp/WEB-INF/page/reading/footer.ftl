  </div>
  <footer class="footer">
    <p>&copy Company 上海银秩信息有限公司  2013</p>
  </footer>
  <script type="text/javascript">
	$(function(){
		$("#mw-top").css("top",window.screen.availHeight-200+"px");
		$(window).scroll(function() {		
			if($(window).scrollTop() >= 100){
				$('#mw-top .nw').fadeIn(300);
			}else{    
				$('#mw-top .nw').fadeOut(300);
			}  
		});
		$('#mw-top .jn').click(function(){
			$("#mw-top .jn").css("display","none");
			$("#mw-top .ky").fadeIn(300);
			
		});
		$('#mw-top .nui-btn-close').click(function(){
			$("#mw-top .ky").css("display","none");
			$("#mw-top .jn").fadeIn(300);
		});
	});
  </script>
  <div id="mw-top" class="pz">
	<div class="mw nw">
		<div class="nui-btn2">
			<span class="nui-btn-icon nw-bg"><img src="../resources/img/ht-1.png" alt="置顶" title="置顶" /></span>
		</div>
	</div>
	<div class="mw rh">
		<div class="nui-btn2">
			<span class="nui-btn-icon rh-bg"><img src="../resources/img/ht-2.png" alt="拓扑图" title="拓扑图" /></span>
		</div>
	</div>
	<div class="mw jn">
		<div class="nui-btn2">
			<span class="nui-btn-icon jn-bg"><img src="../resources/img/ht-3.png" alt="返回" title="返回" /></span>
		</div>
	</div>
	<div class="mw ky">
		<div class="nui-btn">
			<span class="nui-btn-icon ky-bg-1"><a href="../teaching/student/index"><img src="../resources/img/ht-4.png" alt="财经人" title="财经人" /></a></span>
		</div>
		<div class="nui-btn">
			<span class="nui-btn-icon ky-bg-2"><img src="../resources/img/ht-5.png" alt="悦读书苑" title="悦读书苑" /></span>
		</div>
		<div class="nui-btn">
			<span class="nui-btn-icon ky-bg-3"><img src="../resources/img/ht-6.png" alt="学秩社区" title="学秩社区" /></span>
		</div>
		<div class="nui-btn">
			<span class="nui-btn-icon nui-btn-close ky-bg-4"><img src="../resources/img/ht-7.png" alt="关闭" title="关闭" /></span>
		</div>
	</div>
</div>
  <script src="../resources/scripts/bootstrap.min.js"></script>
  <script src="../resources/scripts/bootstrap-datetimepicker.min.js"></script>
  </body>
</html>