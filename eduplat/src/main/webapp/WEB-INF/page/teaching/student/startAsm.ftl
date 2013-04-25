<#include "../header.ftl">

<div class="container secondary">
	<div class="row">
		<div class="span1 offset1">
			<a href="#" class="back-button big"></a>
		</div>
		<div class="span10">
			<div class="page-profile-title">
				<span>卷子内容</span>
			</div>
			<div class="">
				<div class="row-fluid">
				<form method="post" action="submitAss">
					<input type="hidden" name="asmId" value="${asmId!'0'}">
					<p>${testpaper!'暂无该卷子'}</p>
					<p><input type="submit" class="btn btn-primary" value="交卷" /></p>
				</form>
				</div>
			</div>
		</div>
	</div>
</div>

<#include "../footer.ftl">