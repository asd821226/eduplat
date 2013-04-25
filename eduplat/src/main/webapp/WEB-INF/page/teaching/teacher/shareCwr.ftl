<#include "../header.ftl">

</script>

<div class="container secondary">
	<div class="row">
		<div class="span1 offset1">
			<a href="#" class="back-button big"></a>
		</div>
		<div class="span10">
			<div class="page-profile-title">
				<span>共享课件</span>
			</div>
			<form id="srh_form" method="post" action="saveShareCwr">
				<input type="hidden" name="corId" value="${cwrId}" id="cwrId" />
				<input type="hidden" name="chpId" value="${chpId}" id="chpId" />
				<#if cors??>
					<h3>请选择要共享的班级：</h3>
					<#list cors as e>
					<label class="checkbox">
				      <input type="checkbox" name="corIds" value="${e.id}"> ${e.name}
				    </label>
				    </#list>
					<button type="submit" class="btn btn-primary">提交</button>
				<#else>
					<p class="muted">暂无可共享的班级</p>				
				</#if>
			</form>
		</div>
	</div>
</div>

<#include "../footer.ftl">