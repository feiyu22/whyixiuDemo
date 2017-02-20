<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加产品</title>
	<link rel="shortcut icon" href="favicon.ico"> 
    <link href="/hadmin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/hadmin/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="/hadmin/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="/hadmin/css/animate.css" rel="stylesheet">
    <link href="/hadmin/css/style.css?v=4.1.0" rel="stylesheet">
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>编辑计划</h5>
                    </div>
                    <div class="ibox-content">
                        <form method="post" action="/purchase/doAddOrEdit" class="form-horizontal">
                            <div class="form-group">
                            	<input type="hidden" name="id" value="${purchase.id}">
                            	<input type="hidden" name="productId" id="productId" value="${purchase.productId}">
                                <label class="col-sm-3 control-label">商品名称</label>
                                <div class="col-sm-2">
                                    <input type="text" name="productName" id="productName"  value="${purchase.productName}"  required="required"   class="form-control" placeholder="请输入名称">
                                    
                                   <div id="select">
	                                  
                                    </div>
                                </div>
                                
                                <label class="col-sm-2 control-label">商品编码</label>
                                <div class="col-sm-2">
                                    <input type="text" name="productCode" id="productCode"  value="${purchase.productCode}"  required="required"  class="form-control" placeholder="商品编码"  readonly="readonly">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">采购数量</label>
                                <div class="col-sm-2">
                                    <input type="number" name="num" id="num"  value="${purchase.num}" class="form-control" required="required" placeholder="请输入采购数量">
                                </div>
                                
                                <label class="col-sm-2 control-label">到货数量</label>
                                <div class="col-sm-2">
                                    <input type="number" name="receiveNum" id="receiveNum"  value="${purchase.receiveNum}" class="form-control" required="required" placeholder="请输入到货数量">
                                </div>
                            </div>
                            
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">采购公司</label>
                                <div class="col-sm-4">
                                    <input type="text" name="company" id="company"  value="${purchase.company}" class="form-control" placeholder="采购公司">
                                </div>
                            </div>

                            
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-5">
                                    <button class="btn btn-primary" type="submit">保存内容</button>
                                    <button class="btn btn-white" type="button" onclick="JavaScript:history.back(-1);">取消</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
	</div>
	<script src="/hadmin/js/jquery.min.js?v=2.1.4"></script>
    <script src="/hadmin/js/bootstrap.min.js?v=3.3.6"></script>
	 <!-- iCheck -->
    <script src="/hadmin/js/plugins/iCheck/icheck.min.js"></script>
	<script>
        $(document).ready(function () {
        	$("#productName").bind("input propertychange" ,function(e){
        		var str=$("#productName").val();
        		$.ajax({
        		    type:'POST',
        		    url: '/product/ajax' ,
        		    data: {"str":str} ,
        		    success: function(data){
        		    	var list = eval(data);
        		    	var i ;
        		    	var content = "";
        		    	for(i=0;i<list.length;i++){
        		    		content += "<div class='radio i-checks'><label><input type='radio' ";
        		    		content += "onclick='selectOK(\""+list[i].name+"\",\""+list[i].code+"\","+list[i].id+")'";
        		    		content += "value='option' name='name'> "+list[i].name+"　　　"+list[i].code+"<i></i></label></div>";
        		    		$("#select").html(content);
        		    	}
        		    }
        		});
        	})
        })
        
        function selectOK(name,code,id){
			$("#productName").val(name);
			$("#productCode").val(code);
			$("#productId").val(id);
			$("#select").html("");        
		}
     </script>
</body>
</html>