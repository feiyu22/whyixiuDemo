<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出入库操作</title>
	<link rel="shortcut icon" href="favicon.ico"> 
    <link href="/hadmin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/hadmin/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="/hadmin/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="/hadmin/css/animate.css" rel="stylesheet">
    <link href="/hadmin/css/style.css?v=4.1.0" rel="stylesheet">
</head>
<style>
.cover {
position:fixed; top: 0px; right:0px; bottom:0px;filter: alpha(opacity=60); background-color: #777;
z-index: 1002; left: 0px; display:none;
opacity:0.5; -moz-opacity:0.5;
}
</style>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>出库操作</h5>
                    </div>
                    <div class="ibox-content form-horizontal">
                            <div class="form-group ">
	                            
	                            	<label class="col-sm-3 control-label">条形码</label>
	                                <div class="col-sm-3">
	                                   <input type="text" id="serchCode" class="form-control" placeholder="条形码">
	                                </div>
	                            
	                                <label class="col-sm-1 control-label">操作类型</label>
	                                 <div class="col-sm-3 m-b-xs">
		                                <div data-toggle="buttons" class="btn-group">
		                                    <label class="btn btn-white  radio " val="1" id="add">
		                                        <input type="radio" id="option1"   name="status" value="1">入库</label>
		                                    <label class="btn btn-white  radio active" val="2" id="export">
		                                        	<input type="radio" id="option2" name="status" value="2">出库</label>
		                                </div>
		                            </div>
	                                
	                            </div>
<!--                             <div class="hr-line-dashed stock"></div> -->
<!--                             <form name="add" method="post" action="doAddOrEdit"> -->
<!-- 	                            <div class="form-group"> -->
<!-- 	                                <label class="col-sm-2 control-label">名　　称</label> -->
<!-- 	                                <div class="col-sm-2"> -->
<!-- 	                                    <input type="text" name="name" id="name" class="form-control" placeholder="请输入名称" required="required"> -->
<!-- 	                                   <div id="select"> -->
<!-- 	                                    </div> -->
<!-- 	                                </div> -->
<!-- 	                                <label class="col-sm-1 control-label">编码</label> -->
<!-- 	                                <div class="col-sm-2"> -->
<!-- 	                                    <input type="text" name="code" id="code" class="form-control" placeholder="商品编码"  readonly="readonly"> -->
<!-- 	                                </div> -->
<!-- 	                                <label class="col-sm-1 control-label">条形码</label> -->
<!-- 	                                <div class="col-sm-3"> -->
<!-- 	                                    <input type="text" name="barcode" id="barcode" class="form-control" placeholder="商品条码" required="required" readonly="readonly"> -->
<!-- 	                                </div> -->
<!-- 	                            </div> -->
<!-- 	                            <div class="form-group"> -->
<!-- 	                            	<label class="col-sm-2 control-label">采购单位</label> -->
<!-- 	                                <div class="col-sm-2"> -->
<!-- 	                                    <input type="text" name="company" id="company" class="form-control" placeholder="请输入采购单位"> -->
<!-- 	                                   <div id="select"> -->
<!-- 	                                    </div> -->
<!-- 	                                </div> -->
<!-- 	                                <label class="col-sm-1 control-label">单价</label> -->
<!-- 	                                <div class="col-sm-2"> -->
<!-- 	                                    <input type="text" name="price" id="price" class="form-control" placeholder="单价"> -->
<!-- 	                                   <div id="select"> -->
<!-- 	                                    </div> -->
<!-- 	                                </div> -->
<!-- 	                            </div> -->
<!-- 	                        </form> -->
                            <div class="hr-line-dashed stock"></div>
                            
                            
                            
                            
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-5">
                                    <button class="btn btn-primary" type="button" onclick="submit()">保存内容</button>
                                    <button class="btn btn-white" type="button" onclick="JavaScript:history.back(-1);">取消</button>
                                </div>
                            </div>
                    </div>
                </div>
            </div>
        </div>
        <iframe name='default' style='display:none;'></iframe> 
        <div id="cover" class="cover"></div>
	</div>
	<script src="/hadmin/js/jquery.min.js?v=2.1.4"></script>
    <script src="/hadmin/js/bootstrap.min.js?v=3.3.6"></script>
	 <!-- iCheck -->
    <script src="/hadmin/js/plugins/iCheck/icheck.min.js"></script>
	<script>
        $(document).ready(function () {
        	$("#serchCode").focus();
        	var list=[];
        	document.onkeydown=function(event){
                 var e = event || window.event || arguments.callee.caller.arguments[0];
                  if(document.getElementById('serchCode').value.length!=0&&e && e.keyCode==13&&($("#serchCode").is(":focus"))){ // enter 键
                	  if($.inArray($("#serchCode").val(), list)=='-1'){
	                	  list.push($("#serchCode").val());
	                	  
	                	  $.ajax({
	              		    type:'POST',
	              		    url: '/stock/ajax' ,
	              		    data: {"barcode":$("#serchCode").val()} ,
	              		    success: function(data){
	              		    		var stock = eval('(' + data + ')');
	              		    		if(stock.code=='301'){
	              		    			alert("该库存商品已出库或条码错误");
	              		    			$("#serchCode").val("");
	              		    		}else{
	              		    			$(".stock:last").after("<form name ='add' method ='post' id='"+$("#serchCode").val()+"' action ='doExitus' target='"+$("#serchCode").val()+"'> <div class ='form-group'> "
              			              		+ "<label class ='col-sm-2 control-label'>名　　称</label> <div class ='col-sm-2'> "
              			            		+ "<input type ='text' name ='name' id ='name' class ='form-control' placeholder ='请输入名称' "
              			            		+ "required ='required' value='"+stock.name+"' readonly ='readonly'> <div id ='select' > </div> </div > <label class ='col-sm-1 control-label'> "
              			            		+ "编码 </label> <div class ='col-sm-2'> <input type ='text' name ='code' id ='code' value='"+stock.code+"'"
              			            		+ "class ='form-control' placeholder ='请输入编码' readonly ='readonly'> </div> <label class ='col-sm-1 "
              			            		+ "control-label' >条形码</label > <div class ='col-sm-3' > <input type ='text' name ='barcode' value='"+stock.barcode+"'"
              			            		+ "id ='barcode' class ='form-control' placeholder ='请输入条形码' readonly ='readonly' > </div> </div> "
              			            		+ "<div class ='form-group' > <label class ='col-sm-2 control-label' readonly ='readonly'>采购单位 </label >"
              			            		+ " <div class ='col-sm-2' readonly ='readonly'> <input type ='text' name ='company' id ='company'value='"+stock.company+"' class ='form-control'"
              			            		+ " placeholder ='采购单位' > <div id ='select'> </div> </div> <label class ='col-sm-1 control-label'>"
              			            		+ " 单价</label > <div class ='col-sm-2'> <input type ='text' name ='price' id ='price' class = "
              			            		+ "'form-control' value='-"+stock.price+"' placeholder ='请输入单价' readonly ='readonly'> <div id ='select'> </div> </div> </div> </form >"
              			            		+ "<div class='hr-line-dashed stock'></div>"
              			            		+"<iframe name='"+$("#serchCode").val()+"' style='display:none;'></iframe>  ");
          			                	  $("#serchCode").val("");
	              		    		}
	              		    	}
	              			});
	                	  
// 	                	  $("input[name='barcode']:last").val( $("#serchCode").val());
	                	  
// 	                	  $("input[name='barcode']:last").val( $("#serchCode").val());
// 	                	  $("input[name='barcode']:last").val( $("#serchCode").val());
                	 }else{
                		 alert("请勿重复扫码");
                	 }
                	  
                 }
             }; 
        	
             //条码输入框失去焦点
//              $("#serchCode").blur(function(){
//             	 if($("input[name='barcode']:last").val()==''){
//             		 $("form[name='add']:last").toggle();
//             	 }
//              });
             
//              $("#serchCode").focus(function(){
//             	 if($("input[name='barcode']:last").val()==''){
//             		 $("form[name='add']:last").toggle();
//             	 }
//              });
        	
        	//跳转出库操作
        	$("#add").click(function(){
        		window.location.href="/stock/toAddOrEdit";
        	});
        	
        })
        
		function submit() {
			$("#cover").show();
			var i = 0
			var formIds = [];
			$("input[name='barcode']").each(function() {
				formIds.push($(this).val());
			});
			
			for (var i=0;i<formIds.length;i++){
				if(formIds[i]!=''){
					document.getElementById(formIds[i]).submit();
				}
			}
// 			sleep(2000); 
			alert("操作成功");
			window.location.href="/stock/redirct";
		}

		function sleep(d) {
			for (var t = Date.now(); Date.now() - t <= d;);
		}
	</script>
</body>
</html>