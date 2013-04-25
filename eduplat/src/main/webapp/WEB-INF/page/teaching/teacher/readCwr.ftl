<#include "../header.ftl">

<script type="text/javascript">
	var setting = {
		view: {
			selectedMulti: false
		},
		check: {
			enable: true
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			onCheck: getChpSelected
		}
	};
	function getChpList(){
		var bokId = $('bokId').value;
		var chpId = $('chpId').value;
		$.ajax({
			type:"GET",
			url:"getChpList?bokId=402880e53d95fb80013d95fb8eba0000&chpId=402880e53d95fcad013d95fcbd0a000a",
			success: function(data){
				var zNodes = $.parseJSON(data);
				$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			}
		})
	};
	function getChpSelected(){
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		var ids = "";
		nodes = zTree.getChangeCheckedNodes();
		for (var i=0, l=nodes.length; i<l; i++) {
			ids = ids + nodes[i].id + ",";
		}
		$('nodeIds').attr('value', ids);
	};
</script>

<div class="container secondary">
	<div class="row">
		<div class="span1 offset1">
			<a href="#" class="back-button big"></a>
		</div>
		<div class="span10">
			<div class="page-profile-title">
				<span>制作课件</span>
			</div>
			<form id="cwr_form" method="post" action="insertCwr">
			<input type="hidden" name="nodeIds" id="nodeIds" />
			<input type="hidden" name="bokId" value="${bokId}" id="bokId" />
			<input type="hidden" name="corId" value="${corId}" id="corId" />
			<input type="hidden" name="chpId" value="${chpId}" id="chpId" />
			<div class="row-fluid">
				<div class="span4">
					<button class="btn btn-link" type="button" onclick="getChpList();">章节</button>
					<div class="zTreeDemoBackground">
						<ul id="treeDemo" class="ztree"></ul>
					</div>
				</div>
				<div class="span8">
					<p>请选择一个模板：</p>
					<div class="row-fluid">
			            <ul class="thumbnails">
			              <li>
							<div class="thumbnail">
						        <img src="../../resources/img/pptbg/thumb_template_1.jpg" class="img-polaroid" alt="1st image description" />
						        <div class="caption">
						        	<label class="radio"><input type="radio" name="tmpId" value="ppt_template_1" checked /> Check me out</label>
						        </div>
					        </div>
					      </li>
					      <li>
					        <div class="thumbnail">
						        <img src="../../resources/img/pptbg/thumb_template_2.jpg" class="img-polaroid" alt="2nd image description" />
						    	<div class="caption">
						        	<label class="radio"><input type="radio" name="tmpId" value="ppt_template_2" /> Check me out</label>
						        </div>
					        </div>
					      </li>
					      <li>
					        <div class="thumbnail">
						        <img src="../../resources/img/pptbg/thumb_template_3.jpg" class="img-polaroid" alt="3rd image description" />
						        <div class="caption">
						        	<label class="radio"><input type="radio" name="tmpId" value="ppt_template_3" /> Check me out</label>
						        </div>
					        </div>
					      </li>
					      <li>
					        <div class="thumbnail">
						        <img src="../../resources/img/pptbg/thumb_template_4.jpg" class="img-polaroid" alt="4th image description" />
						        <div class="caption">
						        	<label class="radio"><input type="radio" name="tmpId" value="ppt_template_4" /> Check me out</label>
						        </div>
					        </div>
					      </li>
					      <li>
						    <div class="thumbnail">
						        <img src="../../resources/img/pptbg/thumb_template_5.jpg" class="img-polaroid" alt="5th image description" />
						    	<div class="caption">
						        	<label class="radio"><input type="radio" name="tmpId" value="ppt_template_5" /> Check me out</label>
						        </div>
					        </div>
					      </li>
					   	</ul>
					  </div>
					</div>
				</div>
			<button type="submit" class="btn btn-primary">提交</button>
			</div>
			</form>
		</div>
	</div>
</div>

<#include "../footer.ftl">