<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String basePath = request.getScheme()+"://"+
    				request.getServerName()+":"+
					request.getServerPort()+
    				request.getContextPath()+"/"; 
%>
<!DOCTYPE HTML>
<html>
  <head>
  	<base href="<%=basePath %>">
    <title>首页</title>
	  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
	  <script src="js/cookie.js"></script>
	  <script src="common/js/jquery-3.1.1.min.js"></script>
	  <script src="js/bootstrap.min.js"></script>

 <script type="text/javascript">
	  	//当选择部门后触发事件，根据选择的部门名查找所有的职位
	  	function check1(){
	  		var dept_name = $('#department').val();
	  		$.ajax({
	  			type:"POST",
	  			url:"Staff/findPosition",
	  			contentType:"application/x-www-form-urlencoded;charset=utf-8",
	  			dataType:"json",
	  			timeout:500,
	  			data:{
	  				dept_name:dept_name
	  			},
	  			success:function(data){
	  				//每次先清空之前的下拉框内容
	  				$('#position').empty();
	  				var posis = data["posis"];
	  				for(var i=0;i<posis.length;i++){
	  					var options = $('<option></option>');
	  					$(options).val(posis[i].pos_name);
	  					$(options).text(posis[i].pos_name);
	  					$('#position').append($(options));
	  				}
	  			}
	  		});
	  	}
	  </script>
	  <script type="text/javascript">
	  	//用来记录当前操作的员工Id
	  	var staffId ;
	    //获取当前用户的权限值	
	 	var power = ${power};
		//定义一个比变量用来标识用户点击提交的时候是新增还是编辑
		 var newOrEdit;
	 	/* 
		  当 DOM（文档对象模型） 已经加载，并且页面（包括图像）已经完全呈现时，会发生 ready 事件。
		由于该事件在文档就绪后发生，因此把所有其他的 jQuery 事件和函数置于该事件中是非常好的做法。
		ready() 函数规定当 ready 事件发生时执行的代码。
		ready() 函数仅能用于当前文档，因此无需选择器。
		允许使用以下三种语法：
		$(document).ready(function)
		$().ready(function)
		$(function)
		  */
		  //页面加载后调用lod方法
	  	$(document).ready(lod);
	  //点击查询按钮，根据关键字进行模糊查询,重新加载页面即可
	  	$(function(){
			$('#LikeSearch').click(lod);
	  	});
	 	function lod(){
	 		//获取模糊查询的关键字
	 		var name = $('#LikeName').val();
	 		//获取内容显示表格主体tbody对象
	 		var $tbody = $('#myTable');
	 		//每次加载之前，先将表格的数据清空
	 		$tbody.empty();
	 		//发送请求获取页面数据
	 		$.ajax({
	 			type:"POST",
	 			url:"Staff/page",
	 			contentType:"application/x-www-form-urlencoded;charset=utf-8",
	 			dataType:"json",
	 			timeout:500,
	 			data:{
	 				//模糊查询的关键字
	 				name:name
	 			},
	 			success:function(data){
	 				//获取符合要求的所有员工信息集合
	 				var list = data["staffs"];
	 				//获取所有部门的集合
	 				var depts = data["depts"];
	 				//判断当前用户的权限，如果是普通用户需要隐藏按钮新建和操作选项
	 				if(power!=2){
	 					$('#newButton').hide();
	 					$('#option').hide();
	 				}
	 				for(var i=0;i<depts.length;i++){
	 					/* 
	 					$("<option></option>")是获取option这个标签，
	 					text("")是给标签添加内容，也就是选择框显示的值，
	 					val("")是给标签value属性赋值，就是传递的值
	 					*/
	 					var options = $("<option></option>");
	 					$(options).val(depts[i].dept_name);
	 					$(options).text(depts[i].dept_name);
	 					//将option标签追加到select标签下
	 					$('#department').append($(options));
	 				}
	 				for(var i=0;i<list.length;i++){
	 					//给表格主体增加内容，显示员工信息
	 					//1.获取员工信息显示模板
	 					var $template = $($('#template').html()).clone();
	 					$template.children('td').eq(0).text(list[i].id);
	 					$template.children('td').eq(1).text(list[i].name);
	 					$template.children('td').eq(2).text(list[i].sex);
	 					$template.children('td').eq(3).text(list[i].degree);
	 					$template.children('td').eq(4).text(list[i].department.dept_name);
	 					$template.children('td').eq(5).text(list[i].position.pos_name);
	 					$template.children('td').eq(6).text(list[i].state);
		 				//获取第八个td中所有为button的元素
	 					var $btns = $template.children('td').eq(7).find('button');
	 					if(power!=2){
	 						$btns.hide();
	 					}
	 					//给编辑和删除按钮增加一个属性为对应员工id
	 					$btns.eq(0).attr("sid",list[i].id);
	 					$btns.eq(1).attr("sid",list[i].id);
	 					//给表格主体追加上员工信息
	 					$tbody.append($template);
	 				};
	 				//点击编辑按钮，将弹框添加一条提示信息
	 			 	$('.myEdit').click(function () {
	 					$('#myModalLabel').html("编辑员工信息");
	 					newOrEdit = 1;
	 				});
	 				//新建和编辑员工信息，点击提交按钮
	 				$('#editStaff').click(function(){
	 					var name = $('#name').val();
	 					var sex = $('#sex').val();
	 					var degree = $('#degree').val();
	 					var dept_name = $('#department').val();
	 					var pos_name = $('#position').val();
	 					var state = $('#state').val();
	 					var username = $('#username').val();
	 					var password = $('#password').val();
	 					if(newOrEdit==1){
	 		 				$.ajax({
	 		 					type:"POST",
	 		 					async:false,
	 		 					url:"Staff/update",
	 		 					contentType:"application/x-www-form-urlencoded;charset=utf-8",
	 		 					dataType:"json",
	 		 					timeout:500,
	 		 					data:{
	 		 						staffId:staffId,
	 		 						name:name,
	 		 						sex:sex,
	 		 						degree:degree,
	 		 						dept_name:dept_name,
	 		 						pos_name:pos_name,
	 		 						state:state,
	 		 						username:username,
	 		 						password:password
	 		 					},
	 		 					success:function(data){
	 		 						location.reload();
	 		 					},
	 		 					error:function(data){
	 		 						alert("更新失败");
	 		 					}
	 		 					
	 		 				});
	 		 			}
	 		 			if(newOrEdit==2){
	 		 				$.ajax({
	 		 					type:"POST",
	 		 					async:false,
	 		 					url:"Staff/insert",
	 		 					contentType:"application/x-www-form-urlencoded;charset=utf-8",
	 		 					dataType:"json",
	 		 					timeout:500,
	 		 					data:{
	 		 						name:name,
	 		 						sex:sex,
	 		 						degree:degree,
	 		 						dept_name:dept_name,
	 		 						pos_name:pos_name,
	 		 						state:state,
	 		 						username:username,
	 		 						password:password
	 		 					},
	 		 					success:function(data){
	 		 						location.reload();
	 		 					},
	 		 					error:function(data){
	 		 						alert("插入失败");
	 		 					}
	 		 					
	 		 				});
	 		 			}
	 		 			
	 		 		});
	 				//删除员工信息，点击确认按钮
	 				$('#delete-ok').click(function(){
	 					$.ajax({
	 						type:"POST",
	 						url:"Staff/delete",
	 						contentType:"application/x-www-form-urlencoded;charset=utf-8",
	 						dataType:"json",
	 						timeout:500,
	 						data:{
	 							staffId:staffId
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
	 					$('#myModalLabel').html("新增员工信息");
	 					newOrEdit = 2;
	 				});
	 			 	//点击编辑按钮，将弹框添加一条提示信息，并获取当前员工id
	 			 	$('.myEdit').click(function () {
	 			 		staffId = parseInt($(this).attr('sid'));
	 					$('#myModalLabel').html("编辑员工信息");
	 					newOrEdit = 1;
	 				});
	 			 	//点击删除按钮，获取当前员工id
	 			 	$('.myDelete').click(function(){
	 					staffId = parseInt($(this).attr('sid'));
	 			 		$('.selectId').html(staffId);
	 				});
	 			 	
	 			},
	 			error:function(data){
	 				alert("查看失败");
	 			}
	 		});
	 		
	 	}	 	
	  </script>
  </head>
  <body style="width: 100%; margin: 0;">
	
  <div class="container">
	  <div class="row clearfix">

		  <div class="col-md-12 column">
			  <table style="margin-left:auto; margin-right:auto; margin-top:10px;">
				  <h3 class="text-center"
					  style="border:5px solid #a1a1a1;padding:10px 40px;background:#dad7dd;width:100%;border-radius:25px;">
					  企业员工信息基本列表
				  </h3>
			  </table>
			  <!--<h2 style="width: 100%">-->
				  <!--Tittle-->
			  <!--</h2>-->
			  <div class="form-group container" style="">
			  	<!-- 
			  	关于Bootstrap 按钮的一些详解
			  	http://www.runoob.com/bootstrap/bootstrap-buttons.html 
			  	
			  	-->
				  <button id="newButton" type="button" class="btn btn-sm btn-primary col-sm-3"
						  data-toggle="modal"
						  data-target="#editModal" style="width:80px; margin-left:5px;">新建
				  </button>
				  <div class="col-sm-3" style="float: right">
					  <input class="form-control col-sm-4" type="text" id="LikeName" placeholder="请输入查询员工的姓名"/>
				  </div>
				  <button id="LikeSearch" type="submit" style="float: right" class=" btn btn-default col-sm-1">查询</button>
			  </div>

			  <!-- 点击删除按钮 弹出的对话框，上面显示需要删除的员工id,确认、取消按钮 -->
			  <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" data-backdrop="static"
				   aria-labelledby="deleteModalLabel" aria-hidden="true" style="margin-top:100px">
				  <div class="modal-dialog" style="width:350px;">
					  <div class="modal-content">
						  <div class="modal-header">
							  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							  <h4 class="modal-title model-text1" id="deleteModalLabel"><B>删除</B></h4>
						  </div>
						  <div class="modal-body">
							  确定要开除ID为 <span class="selectId" style="color:red;font-weight:bold;"></span> 的职工吗？
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

			  <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				  <div class="modal-dialog">
					  <div class="modal-content">
						  <div class="modal-header">
							  <button type="button" class="close" data-dismiss="modal"
									  aria-hidden="true">×
							  </button>
							  <!-- 根据是新建还是编辑添加不同信息 -->
							  <h4 class="modal-title" id="myModalLabel">

							  </h4>
						  </div>
						  <div class="modal-body" style="height: 200px;">
							  <div class="form-group">
								  <label for="name" class="col-sm-2 col-lg-pull-2 control-label">姓名：</label>
								  <div class="col-sm-4">
									  <input class="form-control" id="name" type="name" />
								  </div>
								  <label class="col-sm-2 col-lg-pull-2 control-label">性别：</label>
								  <div class="col-sm-4">
									  <select id="sex" name="sex" class="selectpicker show-tick form-control">
										  <option value="男">男</option>
										  <option value="女">女</option>
									  </select>
								  </div>
								  <label class="col-sm-2 col-lg-pull-2 control-label">学历：</label>
								  <div class="col-sm-4">
									  <select id="degree" name="degree" class="selectpicker show-tick form-control">
										  <option value="博士">博士</option>
										  <option value="研究生">研究生</option>
										  <option value="本科">本科</option>
										  <option value="专科">专科</option>
										  <option ></option>
									  </select>
								  </div>
								  <label class="col-sm-2 col-lg-pull-2 control-label">部门：</label>
								  <div class="col-sm-4">
									  <select id="department" name="department" class="selectpicker show-tick form-control" onchange="check1()">
									  	  <option value="请选择">请选择</option>
										  <!-- <option value="董事局">董事局</option>
										  <option value="管理部">管理部</option>
										  <option value="财务部">财务部</option>
										  <option value="技术部">技术部</option>
										  <option value="人事部">人事部</option>
										  <option value="后勤部">后勤部</option> -->
									  </select>
								  </div>
								  <label class="col-sm-2 col-lg-pull-2 control-label">职位：</label>
								  <div class="col-sm-4">
									  <select id="position" name="position" class="selectpicker show-tick form-control">
										   <option value="请选择">请选择</option>
										  <!-- <option value="董事长">董事长</option>
										  <option value="董事">董事</option>
										  <option value="CEO">CEO</option>
										  <option value="总监">总监</option>
										  <option value="经理">经理</option>
										  <option value="职员">职员</option> -->
									  </select>
								  </div>
								  <label class="col-sm-2 col-lg-pull-2 control-label">状态：</label>
								  <div class="col-sm-4">
									  <select id="state" name="state" class="selectpicker show-tick form-control">
										  <option value="在职">在职</option>
										  <option value="离职">离职</option>
									  </select>
								  </div>
								  <label for="username" class="col-sm-2 col-lg-pull-2 control-label">账号：</label>
								  <div class="col-sm-4">
									  <input class="form-control" id="username" type="username" />
								  </div>
								  <label for="password" class="col-sm-2 col-lg-pull-2 control-label">密码：</label>
								  <div class="col-sm-4">
									  <input class="form-control" id="password" type="password" />
								  </div>
								 <!--  <label>
									  <input type="checkbox" id="check" > 是否赋予管理员权限
								  </label> -->
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



			  <table class="table table-hover table-condensed">
				  <thead>
				  <tr>
					  <th class="text-center">编号</th>
					  <th class="text-center">姓名</th>
					  <th class="text-center">性别</th>
					  <th class="text-center">学历</th>
					  <th class="text-center">部门</th>
					  <th class="text-center">职位</th>
					  <th class="text-center">状态</th>
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
  </body>
</html>
