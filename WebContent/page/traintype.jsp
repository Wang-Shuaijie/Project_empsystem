<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>TrainType</title>
<link rel="stylesheet" href="css/bootstrap.min.css" media="screen"/>
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" media="screen">
</head>
<body style="width: 100%; margin: 0;">

<div class="container">
    <div class="row clearfix">

        <div class="col-md-12 column">
            <table style="margin-left:auto; margin-right:auto; margin-top:10px;">
                <h3 class="text-center"
                    style="border:5px solid #a1a1a1;padding:10px 40px;background:#dad7dd;width:100%;border-radius:25px;">
                    内部培训列表
                </h3>
            </table>
            <div class="form-group container" style="">
                <button id="newButton" type="button" class="btn btn-sm btn-primary col-sm-3"
                        data-toggle="modal"
                        data-target="#insertModal" style="width:80px; margin-left:5px;">新建
                </button>
                <div class="col-sm-3" style="float: right">
                    <input class="form-control col-sm-4" type="text" id="LikeName" placeholder="请输入查询培训的名称"/>
                </div>
                <button type="submit" style="float: right" class=" btn btn-default col-sm-1" id="LikeSearch">查询</button>
            </div>

            <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" data-backdrop="static"
            aria-labelledby="deleteModalLabel" aria-hidden="true" style="margin-top:100px">
            <div class="modal-dialog" style="width:350px;">
            <div class="modal-content">
            <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title model-text1" id="deleteModalLabel"><B>删除</B></h4>
            </div>
            <div class="modal-body">
            确定要ID为 <span class="selectId" style="color:red;font-weight:bold;"></span> 的培训项目吗？
            </div>
            <div class="modal-footer">
            <button type="button" class="btn btn-danger" data-dismiss="modal"
            id="delete-ok">确定</button>
            <button type="button" class="btn btn-info" data-dismiss="modal"
            id="delete-cancel">取消</button>
            </div>
            </div>
            </div>
            </div>

            <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"
                                    aria-hidden="true">×
                            </button>
                            <h4 class="modal-title" id="myModalLabel">

                            </h4>
                        </div>
                        <div class="modal-body" style="height: 200px;">
                            <div class="form-group">
                                <div class="row">
                                    <label for="typename" class="col-sm-4  control-label ">培训名称：</label>
                                    <div class="col-sm-8 col-sm-pull-2">
                                        <textarea class="form-control" id="typename" type="typename"></textarea>
                                    </div>
                                </div>
                                <div class="row" style="margin-top: 26px; padding-right: 5px;">
                                    <label for="typeinfo" class="col-sm-4  control-label ">培训内容：</label>
                                    <div class="col-sm-8 col-sm-pull-2">
                                        <textarea class="form-control" id="typeinfo" type="typeinfo"></textarea>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default"
                                    data-dismiss="modal">关闭
                            </button>
                            <button id="editStaff" type="button" class="btn btn-primary" data-dismiss="modal">
                                提交更改
                            </button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->


            <div class="modal fade" id="insertModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"
                                    aria-hidden="true">×
                            </button>
                            <h4 class="modal-title" id="myModalLabel2">

                            </h4>
                        </div>
                        <div class="modal-body" style="height: 270px;">
                            <div class="form-group">
                                <div class="row">
                                    <label for="typename2" class="col-sm-4  control-label ">培训名称：</label>
                                    <div class="col-sm-8 col-sm-pull-2">
                                        <textarea class="form-control" id="typename2" type="typename2"></textarea>
                                    </div>
                                </div>
                                <div class="row" style="margin-top: 26px; padding-right: 5px;">
                                    <label for="typeinfo2" class="col-sm-4  control-label ">培训内容：</label>
                                    <div class="col-sm-8 col-sm-pull-2">
                                        <textarea class="form-control" id="typeinfo2" type="typeinfo2"></textarea>
                                    </div>
                                </div>
                                
                            </div>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default"
                                    data-dismiss="modal">关闭
                            </button>
                            <button id="insertAgr" type="button" class="btn btn-primary" data-dismiss="modal">
                                提交更改
                            </button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->

            <table class="table table-hover table-condensed">
                <thead>
                <tr>
                    <th class="text-center">培训编号</th>
                    <th class="text-center">培训名称</th>
                    <th class="text-center">培训内容</th>
                    <th id="option" class="text-center">操作</th>
                </tr>
                </thead>
                <tbody id="myTable">
                
                </tbody>
            </table>
           
            <div class="text-center">
                <ul class="pagination" id="line">
                
                </ul>
            </div>
        </div>
    </div>

</div>
<script id="template" type="application/html">
	<tr>
	<td class="text-center"></td>
	<td class="text-center"></td>
	<td class="text-center"></td>
	<td>
	<table style="margin-left:auto; margin-right:auto;">
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
			//记录当前操作的是哪条培训类型
			var type_code;
			 //获取当前用户的权限值	
		 	var power = ${power};
			//获取模糊查询的关键字
	 		var name = $('#LikeName').val();
	 		//获取内容显示表格主体tbody对象
	 		var $tbody = $('#myTable');
	 		//每次加载之前，先将表格的数据清空
	 		$tbody.empty();
	 		//发送请求获取页面数据
	 		$.ajax({
	 			type:"POST",
	 			url:"TrainType/page",
	 			contentType:"application/x-www-form-urlencoded;charset=utf-8",
	 			dataType:"json",
	 			timeout:500,
	 			data:{
	 				//模糊查询的关键字
	 				name:name
	 			},
	 			success:function(data){
	 				
	 				//获取符合要求的所有员工培训信息集合
	 				var types = data["types"];
	 				
	 				//判断当前用户的权限，如果是普通用户需要隐藏按钮新建和操作选项
	 				if(power!=2){
	 					$('#newButton').hide();
	 					$('#option').hide();
	 				}
	 				for(var i=0;i<types.length;i++){
	 					//给表格主体增加内容，显示员工信息
	 					//1.获取员工信息显示模板
	 					var $template = $($('#template').html()).clone();
	 					$template.children('td').eq(0).text(types[i].type_code);
	 					$template.children('td').eq(1).text(types[i].type_name);
	 					$template.children('td').eq(2).text(types[i].type_info);
		 				//获取第八个td中所有为button的元素
	 					var $btns = $template.children('td').eq(3).find('button');
	 					if(power!=2){
	 						$btns.hide();
	 					}
	 					//给编辑和删除按钮增加一个属性为对应出差id
	 					$btns.eq(0).attr("typeid",types[i].type_code);
	 					$btns.eq(1).attr("typeid",types[i].type_code);
	 					//给表格主体追加上培训信息
	 					$tbody.append($template);
	 				};
	 				//新增培训信息
	 				$('#insertAgr').click(function(){
	 					var type_name = $('#typename2').val();
	 					var type_info = $('#typeinfo2').val();
	 					if(type_name==""){
	 						alert("培训类型名不能为空");
	 						return false;
	 					}
	 					if(type_info==""){
	 						alert("培训内容不能为空");
	 						return false;
	 						
	 					}
	 					$.ajax({
 		 					type:"POST",
 		 					async:false,
 		 					url:"TrainType/insert",
 		 					contentType:"application/x-www-form-urlencoded;charset=utf-8",
 		 					dataType:"json",
 		 					timeout:500,
 		 					data:{
 		 						type_name:type_name,
 		 						type_info:type_info
 		 					},
 		 					success:function(data){
	 		 						location.reload();
 		 					},
 		 					error:function(data){
 		 						alert("插入失败");
 		 					}
 		 					
 		 				});
	 				});
	 				
	 				//编辑培训信息，点击提交按钮
	 				$('#editStaff').click(function(){
	 					var type_name = $('#typename').val();
	 					var type_info = $('#typeinfo').val();
	 					if(type_name==""){
	 						alert("培训类型名不能为空");
	 						return false;
	 					}
	 					if(type_info==""){
	 						alert("培训内容不能为空");
	 						return false;
	 						
	 					}
 		 				$.ajax({
 		 					type:"POST",
 		 					async:false,
 		 					url:"TrainType/update",
 		 					contentType:"application/x-www-form-urlencoded;charset=utf-8",
 		 					dataType:"json",
 		 					timeout:500,
 		 					data:{
 		 						type_name:type_name,
 		 						type_info:type_info,
 		 						type_code:type_code
 		 					},
 		 					success:function(data){
 		 						location.reload();
 		 					},
 		 					error:function(data){
 		 						alert("更新失败");
 		 					}
 		 					
 		 				});
	 		 		});
	 				//删除培训信息，点击确认按钮
	 				$('#delete-ok').click(function(){
	 					$.ajax({
	 						type:"POST",
	 						url:"TrainType/delete",
	 						contentType:"application/x-www-form-urlencoded;charset=utf-8",
	 						dataType:"json",
	 						timeout:500,
	 						data:{
	 							type_code:type_code
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
	 					$('#myModalLabel2').html("新增培训类型信息");
	 				});
	 			 	//点击编辑按钮，将弹框添加一条提示信息，并获取当前培训id
	 			 	$('.myEdit').click(function () {
	 			 		type_code = parseInt($(this).attr('typeid'));
	 					$('#myModalLabel').html("编辑培训类型信息");
	 				});
	 			 	//点击删除按钮，获取当前培训id
	 			 	$('.myDelete').click(function(){
	 			 		type_code = parseInt($(this).attr('typeid'));
	 			 		$('.selectId').html(type_code);
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
