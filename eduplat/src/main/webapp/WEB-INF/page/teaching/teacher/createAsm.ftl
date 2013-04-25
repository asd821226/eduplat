<#include "../header.ftl">

<script type="text/javascript">

	function getQustmps(queCnt, queType){
		var queCntEle = $(queCnt);
		var chpId = $("#chpId").val();
		var bokId = $("#bokId").val();
		var url = "getQustmpList?bokId="+bokId+"&chpId="+chpId+"&queType="+queType;
		$.getJSON(url, function(data){
			queCntEle.empty();
			for(var i=0; i<data.length; i++){
				queCntEle.append("<p><label class='checkbox'><input type='checkbox' value='"+data[i].id+"' /> "+data[i].content+"</label></p>");
			}
		});
	};
	
	function getChpsByBokId(){
		var bokId = $('#bokId').val();
	    var url = "getChpsByBokId?bokId="+bokId;
	    var chpId = $('#chpId');
		$.getJSON(url, function(data){
			chpId.empty();
			for(var i=0; i<data.length; i++){
				if(i==0){
					chpId.append("<option value='"+data[i].id+"' selected='selected'>"+data[i].name+"</option>");
				}else{
					chpId.append("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
				}
			}
		});
	}

	$(function($) {
		//var chpId = '402880e53d95fcad013d95fcbd0a000a';
		//var bokId = '402880e53d95fb80013d95fb8ed30001';
		getChpsByBokId();
	});

</script>

</script>

<div class="container secondary">
	<div class="row">
		<div class="span1 offset1">
			<a href="#" class="back-button big"></a>
		</div>
		<div class="span10">
			<div class="page-profile-title">
				<span>布置作业</span>
			</div>
			<form class="form-horizontal" action="insertAsm" method="post">
				<input type="hidden" name="bokId" id="bokId" value="${bokId!''}" />
				<input type="hidden" name="corId" id="corId" value="${corId!''}" />
				<div class="control-group">
					<label class="control-label" for="inputName">作业名称</label>
					<div class="controls">
						<input type="text" name="name" id="inputName" placeholder="作业名称"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputChp">选择章节</label>
					<div class="controls">
						<select name="chpId" id="chpId">
						</select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputAssType">作业类型</label>
					<div class="controls">
						<select name="assType">
						  <option>1</option>
						</select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputEndDate">失效日期</label>
					<div class="controls" id="inputEndDate">
					  <div id="datetimepicker1" class="input-append date">
					    <input data-format="dd/MM/yyyy hh:mm:ss" type="text" name="tendDate"></input>
					    <span class="add-on"><i data-time-icon="icon-time" data-date-icon="icon-calendar"></i></span>
					  </div>
					<script type="text/javascript">
					  $(function() {
					    $('#datetimepicker1').datetimepicker({
					      language: 'pt-BR'
					    });
					  });
					</script>
					</div>
				  </div>
				<div class="control-group">
					<label class="control-label" for="inputPassword">题型选择：</label>
					<div class="controls">
						<table class="table">
							<tbody>
								<tr>
									<td><label class="checkbox"><input type="checkbox" name="qt_check_0" /><span class="label label-info">单选题</span></label></td>
									<td>
										<div class="input-prepend input-append">
										  <span class="add-on">共</span>
										  <input class="span1" id="" type="text" name="qt_num_0" />
										  <span class="add-on">题</span>
										</div>
										<div class="input-prepend input-append">
										  <span class="add-on">每题</span>
										  <input class="span1" id="" type="text" name="qt_score_0" />
										  <span class="add-on">分</span>
										</div>
									</td>
									<td>
										<td></td>
									</td>
								</tr>
								<tr>
									<td><label class="checkbox"><input type="checkbox" name="qt_check_1" /><span class="label label-info">多选题</span></label></td>
									<td>
										<div class="input-prepend input-append">
										  <span class="add-on">共</span>
										  <input class="span1" id="" type="text" name="qt_num_1" />
										  <span class="add-on">题</span>
										</div>
										<div class="input-prepend input-append">
										  <span class="add-on">每题</span>
										  <input class="span1" id="" type="text" name="qt_score_1" />
										  <span class="add-on">分</span>
										</div>
									</td>
									<td>
										<td></td>
									</td>
								</tr>
								<tr>
									<td><label class="checkbox"><input type="checkbox" name="qt_check_2" /><span class="label label-info">问答题</span></label></td>
									<td>
										<div class="input-prepend input-append">
										  <span class="add-on">共</span>
										  <input class="span1" id="" type="text" name="qt_num_2" />
										  <span class="add-on">题</span>
										</div>
										<div class="input-prepend input-append">
										  <span class="add-on">每题</span>
										  <input class="span1" id="" type="text" name="qt_score_2" />
										  <span class="add-on">分</span>
										</div>
									</td>
									<td>
										<td></td>
									</td>
								</tr>
								<tr>
									<td><label class="checkbox"><input type="checkbox" name="qt_check_3" /><span class="label label-info">辨析题</span></label></td>
									<td>
										<div class="input-prepend input-append">
										  <span class="add-on">共</span>
										  <input class="span1" id="" type="text" name="qt_num_3" />
										  <span class="add-on">题</span>
										</div>
										<div class="input-prepend input-append">
										  <span class="add-on">每题</span>
										  <input class="span1" id="" type="text" name="qt_score_3" />
										  <span class="add-on">分</span>
										</div>
									</td>
									<td>
										<td></td>
									</td>
								</tr>
								<tr>
									<td><label class="checkbox"><input type="checkbox" name="qt_check_4" onclick="getQustmps('#queCnt4', 4);" /><span class="label label-info">计算题</span></label></td>
									<td>
										<div class="input-prepend input-append">
										  <span class="add-on">共</span>
										  <input class="span1" id="" type="text" name="qt_num_4" />
										  <span class="add-on">题</span>
										</div>
										<div class="input-prepend input-append">
										  <span class="add-on">每题</span>
										  <input class="span1" id="" type="text" name="qt_score_4" />
										  <span class="add-on">分</span>
										</div>
									</td>
									<td>
										<td><a href="#queModal4" role="button" class="btn" data-toggle="modal">指定范围</a></td>
									</td>
								</tr>
								<tr>
									<td><label class="checkbox"><input type="checkbox" name="qt_check_5" onclick="getQustmps('#queCnt5', 5);" /><span class="label label-info">图表题</span></label></td>
									<td>
										<div class="input-prepend input-append">
										  <span class="add-on">共</span>
										  <input class="span1" id="" type="text" name="qt_num_5" />
										  <span class="add-on">题</span>
										</div>
										<div class="input-prepend input-append">
										  <span class="add-on">每题</span>
										  <input class="span1" id="" type="text" name="qt_score_5" />
										  <span class="add-on">分</span>
										</div>
									</td>
									<td>
										<td><a href="#queModal5" role="button" class="btn" data-toggle="modal">指定范围</a></td>
									</td>
								</tr>
								<tr>
									<td><label class="checkbox"><input type="checkbox" name="qt_check_6" onclick="getQustmps('#queCnt6', 6);" /><span class="label label-info">分录题</span></label></td>
									<td>
										<div class="input-prepend input-append">
										  <span class="add-on">共</span>
										  <input class="span1" id="" type="text" name="qt_num_6" />
										  <span class="add-on">题</span>
										</div>
										<div class="input-prepend input-append">
										  <span class="add-on">每题</span>
										  <input class="span1" id="" type="text" name="qt_score_6" />
										  <span class="add-on">分</span>
										</div>
									</td>
									<td>
										<td><a href="#queModal6" role="button" class="btn" data-toggle="modal">指定范围</a> | <a href="#queModal7" role="button" class="btn" data-toggle="modal">按业务点</a></td>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<button class="btn btn-primary">布置完成</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<!-- 计算题Modal -->
<div id="queModal4" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="queModal4" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="queModal4">【计算题】指定范围</h3>
  </div>
  <div class="modal-body" id="queCnt4">
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
  </div>
</div>

<!-- 图表题Modal -->
<div id="queModal5" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="queModal5" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="queModal5">【图表题】指定范围</h3>
  </div>
  <div class="modal-body" id="queCnt5">
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
  </div>
</div>

<!-- 分录题Modal -->
<div id="queModal6" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="queModal6" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="queModal6">【分录题】指定范围</h3>
  </div>
  <div class="modal-body" id="queCnt6">
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
  </div>
</div>

<!-- 分录题-按业务点Modal -->
<div id="queModal7" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="queModal7" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="queModal7">【分录题】按业务点</h3>
  </div>
  <div class="modal-body">
    <p>One fine body…</p>
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
  </div>
</div>

<#include "../footer.ftl">



