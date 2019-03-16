<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% 
	String basePath = request.getScheme()+"://"+
   			request.getServerName()+":"+
			request.getServerPort()+
   			request.getContextPath()+"/"; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Alter</title>
<link rel="stylesheet" href="css/bootstrap.min.css" media="screen" />
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css"
	media="screen">
</head>
<body style="width: 100%; margin: 0;">

	<div class="container">
		<div class="row clearfix">

			<div class="col-md-12 column">
				<table
					style="margin-left: auto; margin-right: auto; margin-top: 10px;">
					<h3 class="text-center"
						style="border: 5px solid #a1a1a1; padding: 10px 40px; background: #dad7dd; width: 100%; border-radius: 25px;">
						企业员工活动列表</h3>
				</table>
				<!--<h2 style="width: 100%">-->
				<!--Tittle-->
				<!--</h2>-->
				<div class="form-group container" style="">
					<button id="newButton" type="button"
						class="btn btn-sm btn-primary col-sm-3" data-toggle="modal"
						data-target="#insertModal" style="width: 80px; margin-left: 5px;">新建
					</button>
					<div class="col-sm-3" style="float: right">
						<input class="form-control col-sm-4" type="text"
							placeholder="请输入查询活动的内容" id="LikeName" />
					</div>
					<button type="submit" style="float: right"
						class=" btn btn-default col-sm-1" id="LikeSearch">查询</button>
				</div>


				<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog"
					data-backdrop="static" aria-labelledby="deleteModalLabel"
					aria-hidden="true" style="margin-top: 100px">
					<div class="modal-dialog" style="width: 350px;">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title model-text1" id="deleteModalLabel">
									<B>删除</B>
								</h4>
							</div>
							<div class="modal-body">
								确定删除活动编号为 <span class="selectId"
									style="color: red; font-weight: bold;"></span> 的出差记录吗？
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-danger"
									data-dismiss="modal" id="delete-ok">确定</button>
								<button type="button" class="btn btn-info" data-dismiss="modal"
									id="delete-cancel">取消</button>
							</div>
						</div>
					</div>
				</div>

				<div class="modal fade" id="editModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel"></h4>
							</div>
							<div class="modal-body" style="height: 200px;">
								<div class="form-group">
									<div class="row">
										<label for="alter" class="col-sm-4  control-label ">活动内容：</label>
										<div class="col-sm-8 col-sm-pull-2">
											<textarea class="form-control" id="alter" type="alter"></textarea>
										</div>
									</div>
									<div class="row" style="margin-top: 2px; padding-right: 5px;">
										<label for="dtp_input1" class="col-md-2 control-label"
											style="margin-top: 26px;">开始日期:</label>
										<div class="input-group date form_date col-md-5" data-date=""
											data-date-format="yyyy mm dd" data-link-field="dtp_input1"
											data-link-format="yyyy-mm-dd" style="margin-top: 20px;">
											<input class="form-control" size="16" type="text" value=""
												readonly id="Btime"> <span class="input-group-addon"><span
												class="glyphicon glyphicon-remove"></span></span> <span
												class="input-group-addon"><span
												class="glyphicon glyphicon-calendar"></span></span>
										</div>
										<input type="hidden" id="dtp_input1" value="" /><br />
									</div>
									<div class="row" style="margin-top: 2px; padding-right: 5px;">
										<label for="dtp_input2" class="col-md-2 control-label"
											style="margin-top: 26px;">结束日期:</label>
										<div class="input-group date form_date col-md-5" data-date=""
											data-date-format="yyyy mm dd" data-link-field="dtp_input2"
											data-link-format="yyyy-mm-dd" style="margin-top: 20px;">
											<input class="form-control" size="16" type="text" value=""
												readonly id="Etime"> <span class="input-group-addon"><span
												class="glyphicon glyphicon-remove"></span></span> <span
												class="input-group-addon"><span
												class="glyphicon glyphicon-calendar"></span></span>
										</div>
										<input type="hidden" id="dtp_input2" value="" /><br />
									</div>
								</div>

							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button id="editStaff" type="button" class="btn btn-primary"
									data-dismiss="modal">提交更改</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->


				<div class="modal fade" id="insertModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel2" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel2"></h4>
							</div>
							<div class="modal-body" style="height: 300px;">
								<div class="form-group">
									<div class="row">
										<label for="alter2" class="col-sm-4  control-label ">活动内容：</label>
										<div class="col-sm-8 col-sm-pull-2">
											<textarea class="form-control" id="alter2" type="alter"></textarea>
										</div>
									</div>
									<div class="row" style="margin-top: 26px; padding-right: 5px;">
										<label for="dtp_input3" class="col-md-2 control-label">开始日期:</label>
										<div class="input-group date form_date col-md-5" data-date=""
											data-date-format="yyyy mm dd" data-link-field="dtp_input2"
											data-link-format="yyyy-mm-dd">
											<input class="form-control" size="16" type="text" value=""
												readonly id="Btime2"> <span
												class="input-group-addon"><span
												class="glyphicon glyphicon-remove"></span></span> <span
												class="input-group-addon"><span
												class="glyphicon glyphicon-calendar"></span></span>
										</div>
										<input type="hidden" id="dtp_input3" value="" />
									</div>
									<div class="row" style="margin-top: 26px; padding-right: 5px;">
										<label for="dtp_input4" class="col-md-2 control-label">结束日期:</label>
										<div class="input-group date form_date col-md-5" data-date=""
											data-date-format="yyyy mm dd" data-link-field="dtp_input4"
											data-link-format="yyyy-mm-dd">
											<input class="form-control" size="16" type="text" value=""
												readonly id="Etime2"> <span
												class="input-group-addon"><span
												class="glyphicon glyphicon-remove"></span></span> <span
												class="input-group-addon"><span
												class="glyphicon glyphicon-calendar"></span></span>
										</div>
										<input type="hidden" id="dtp_input4" value="" />

									</div>
									<div class="row" style="margin-top: 26px; padding-right: 0px;">
										<label for="StaffId" class="col-sm-2 control-label"
											style="padding-right: 0;">员工编号：</label>
										<div class="input-group col-sm-5 ">
											<input class="form-control col-sm-4 " id="StaffId"
												type="StaffId" />
										</div>
									</div>
									<!--<div class="row" style="margin-top: 26px; padding-right: 0px;">-->
									<!--<label for="AgrId" class="col-sm-2 control-label" style="padding-right: 0;">合同编号：</label>-->
									<!--<div class="input-group col-sm-5 ">-->
									<!--<input class="form-control col-sm-4 " id="AgrId" type="AgrId" />-->
									<!--</div>-->
									<!--</div>-->
								</div>

							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button id="insertAgr" type="button" class="btn btn-primary"
									data-dismiss="modal">提交更改</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->


				<table class="table table-hover table-condensed">
					<thead>
						<tr>
							<th class="text-center">活动编号</th>
							<th class="text-center">员工姓名</th>
							<th class="text-center">开始时间</th>
							<th class="text-center">结束时间</th>
							<th class="text-center">活动内容</th>
							<th id="option" class="text-center">操作</th>
						</tr>
					</thead>
					<tbody id="myTable"></tbody>
				</table>

				<div class="text-center">
					<ul class="pagination" id="line">
					</ul>
				</div>
			</div>
		</div>

	</div>
<!-- 显示员工信息的表格模板 -->
 <script id="template" type="application/html">
	<tr>
	<td class="text-center"></td>
	<td class="text-center"></td>
	<td class="text-center"></td>
	<td class="text-center"></td>
	<td class="text-center"></td>
	<td>
		<table style="margin-left:auto; margin-right:auto;" >
			<tr>
				<td><button type="button" class="myEdit btn btn-success btn-sm"
					data-toggle="modal" data-target="#editModal">编辑</button></td>
				<td><button type="button" class="myDelete btn btn-danger btn-sm" style="margin-left:5px;"
					data-toggle="modal" data-target="#deleteModal">删除</button></td>
			</tr>
		</table>
	</td>
</tr>
</script>

	<script src="js/cookie.js"></script>
	<script src="common/js/jquery-3.1.1.min.js" charset="utf-8"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-datetimepicker.js"></script>
	<script src="js/locales/bootstrap-datetimepicker.fr.js"></script>
	<script type="text/javascript">
		$(document).ready(lod);
		//点击查询按钮后重新加载lod方法
		$(function(){
			$('#LikeSearch').click(lod);
		});
		
		function lod(){
			//记录当前操作的是哪条出差记录
			var alter_id;
			 //获取当前用户的权限值	
		 	var power = ${power};
			//获取模糊查询的关键字
	 		var name = $('#LikeName').val();
	 		//获取内容显示表格主体tbody对象
	 		var $tbody = $('#myTable');
	 		//每次加载之前，先将表格的数据清空
	 		$tbody.empty();
	 		//Datetimepicker.js用法详解见：https://blog.csdn.net/WuLex/article/details/80426288
	 		$('.form_date').datetimepicker({
				language : 'fr',
				weekStart : 1,
				todayBtn : 1,
				autoclose : 1,
				todayHighlight : 1,
				startView : 2,
				minView : 2,
				forceParse : 0
			});
	 		//发送请求获取页面数据
	 		$.ajax({
	 			type:"POST",
	 			url:"Alter/page",
	 			contentType:"application/x-www-form-urlencoded;charset=utf-8",
	 			dataType:"json",
	 			timeout:500,
	 			data:{
	 				//模糊查询的关键字
	 				name:name
	 			},
	 			success:function(data){
	 				
	 				//获取符合要求的所有员工出差信息集合
	 				var alters = data["alters"];
	 				
	 				//判断当前用户的权限，如果是普通用户需要隐藏按钮新建和操作选项
	 				if(power!=2){
	 					$('#newButton').hide();
	 					$('#option').hide();
	 				}
	 				for(var i=0;i<alters.length;i++){
	 					//给表格主体增加内容，显示员工信息
	 					//1.获取员工信息显示模板
	 					var $template = $($('#template').html()).clone();
	 					$template.children('td').eq(0).text(alters[i].alterId);
	 					$template.children('td').eq(1).text(alters[i].staff.name);
	 					$template.children('td').eq(2).text(alters[i].alter_btime);
	 					$template.children('td').eq(3).text(alters[i].alter_etime);
	 					$template.children('td').eq(4).text(alters[i].alter_content);
		 				//获取第八个td中所有为button的元素
	 					var $btns = $template.children('td').eq(5).find('button');
	 					if(power!=2){
	 						$btns.hide();
	 					}
	 					//给编辑和删除按钮增加一个属性为对应出差id
	 					$btns.eq(0).attr("altId",alters[i].alterId);
	 					$btns.eq(1).attr("altId",alters[i].alterId);
	 					//给表格主体追加上出差信息
	 					$tbody.append($template);
	 				};
	 				//新增出差信息
	 				$('#insertAgr').click(function(){
	 					var alter_content = $('#alter2').val();
	 					var alter_btime = $('#Btime2').val();
	 					var alter_etime = $('#Etime2').val();
	 					var p_id = $('#StaffId').val();
	 					var d1 = new Date(alter_btime.replace(/\-/g,"\/"));
	 					var d2 = new Date(alter_etime.replace(/\-/g,"\/"));
	 					if(alter_content==""){
	 						alert("出差内容不能为空");
	 						return false;
	 					}
	 					if(alter_btime==""||alter_etime==""){
	 						alert("开始时间或结束时间不能为空");
	 						return false;
	 						
	 					}
	 					if(d1>d2){
	 						alert("开始时间不能大于结束时间");
	 						return false;
	 					}
	 					$.ajax({
 		 					type:"POST",
 		 					async:false,
 		 					url:"Alter/insert",
 		 					contentType:"application/x-www-form-urlencoded;charset=utf-8",
 		 					dataType:"json",
 		 					timeout:500,
 		 					data:{
 		 						alter_content:alter_content,
 		 						alter_btime:alter_btime,
 		 						alter_etime:alter_etime,
 		 						p_id:p_id
 		 					},
 		 					success:function(data){
 		 						location.reload();
 		 					},
 		 					error:function(data){
 		 						alert("插入失败");
 		 					}
 		 					
 		 				});
	 				});
	 				
	 				//编辑出差信息，点击提交按钮
	 				$('#editStaff').click(function(){
	 					var alter_content = $('#alter').val();
	 					var alter_btime = $('#Btime').val();
	 					var alter_etime = $('#Etime').val();
	 					var d1 = new Date(alter_btime.replace(/\-/g,"\/"));
	 					var d2 = new Date(alter_etime.replace(/\-/g,"\/"));
	 					if(alter_content==""){
	 						alert("出差内容不能为空");
	 						return false;
	 					}
	 					if(alter_btime==""||alter_etime==""){
	 						alert("开始时间或结束时间不能为空");
	 						return false;
	 						
	 					}
	 					if(d1>d2){
	 						alert("开始时间不能大于结束时间");
	 						return false;
	 					}
 		 				$.ajax({
 		 					type:"POST",
 		 					async:false,
 		 					url:"Alter/update",
 		 					contentType:"application/x-www-form-urlencoded;charset=utf-8",
 		 					dataType:"json",
 		 					timeout:500,
 		 					data:{
 		 						alter_content:alter_content,
 		 						alter_btime:alter_btime,
 		 						alter_etime:alter_etime,
 		 						alter_id:alter_id
 		 					},
 		 					success:function(data){
 		 						location.reload();
 		 					},
 		 					error:function(data){
 		 						alert("更新失败");
 		 					}
 		 					
 		 				});
	 		 		});
	 				//删除出差信息，点击确认按钮
	 				$('#delete-ok').click(function(){
	 					$.ajax({
	 						type:"POST",
	 						url:"Alter/delete",
	 						contentType:"application/x-www-form-urlencoded;charset=utf-8",
	 						dataType:"json",
	 						timeout:500,
	 						data:{
	 							alter_id:alter_id
	 						},
	 						success:function(data){
	 							location.reload();
	 						},
	 						error:function(data){
	 							alert("删除失败");
	 						}
	 						
	 					});
	 				});
	 				
	 			 	//点击新增按钮，将弹框添加一条提示信息
	 			 	$('#newButton').click(function () {
	 					$('#myModalLabel2').html("新增出差信息");
	 				});
	 			 	//点击编辑按钮，将弹框添加一条提示信息，并获取当前出差信息id
	 			 	$('.myEdit').click(function () {
	 			 		alter_id = $(this).attr('altId');
	 					$('#myModalLabel').html("编辑出差信息");
	 				});
	 			 	//点击删除按钮，获取当前出差信息id
	 			 	$('.myDelete').click(function(){
	 			 		alter_id = $(this).attr('altId');
	 			 		$('.selectId').html(alter_id);
	 				});
	 			 	
	 			},
	 			error:function(data){
	 				alert("查看失败");
	 			}
	 		});
		}
	</script>


</body>
</html>