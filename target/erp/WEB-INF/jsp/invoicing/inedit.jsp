<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加进销记录</title>
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
                        <h5>添加进销记录</h5>
                    </div>
                    <div class="ibox-content">
                        <form method="post" action="/invocing/doAddOrEdit" class="form-horizontal">
                            <div class="form-group">
	                            <div class="form-group">
	                                <label class="col-sm-3 control-label">记录类型</label>
	                                 <div class="col-sm-3 m-b-xs">
		                                <div data-toggle="buttons" class="btn-group">
		                                    <label class="btn btn-white <c:if test="${invoicing.status==1}">active</c:if>  radio" val="1">
		                                        <input type="radio" id="option1" <c:if test="${invoicing.status==1}">readonly="readonly"</c:if>  name="status" value="1">采购</label>
		                                    <label class="btn btn-white <c:if test="${invoicing.status==2}">active</c:if>  radio" val="2">
		                                        <input type="radio" id="option2" <c:if test="${invoicing.status==2}">readonly="readonly"</c:if>  name="status" value="2">销售</label>
		                                    <label class="btn btn-white <c:if test="${invoicing.status==3}">active</c:if>  radio" val="3" <c:if test="${invoicing.status==3}">readonly="readonly"</c:if>>
		                                        <input type="radio" id="option3"   name="status" value="3">结余</label>
		                                </div>
		                            </div>
		                            
		                            <label class="col-sm-1 control-label">销售人</label>
	                                <div class="col-sm-2">
	                                   <input type="text" name="saler" id="saler"  value="${invoicing.saler}" class="form-control" placeholder="销售人员" readonly="readonly">
	                                </div>
	                                
	                            </div>
                                <div class="hr-line-dashed"></div>
                            
                            	<input type="hidden" name="id" id="id" value="${invoicing.id}">
                            	<input type="hidden" name="productId" id="productId" value="${invoicing.productId}">
                                <label class="col-sm-3 control-label">商品名称</label>
                                <div class="col-sm-2">
                                    <input type="text" name="productName" id="productName"  value="${invoicing.productName}"    class="form-control" placeholder="请输入名称" required="required">
                                    
                                   <div id="select">
	                                  
                                    </div>
                                </div>
                                <label class="col-sm-1 control-label">商品编码</label>
                                <div class="col-sm-2">
                                    <input type="text" name="productCode" id="productCode"  value="${invoicing.productCode}"    class="form-control" placeholder="商品编码"  readonly="readonly">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label" id="tnum">销售/采购数量</label>
                                <div class="col-sm-2">
                                    <input type="number" name="num" id="num"  value="${invoicing.num}" class="form-control" placeholder="请输入数量" required="required">
                                </div>
                                
                                <label class="col-sm-1 control-label">单价</label>
                                <div class="col-sm-2">
                                    <input type="text" name="price" id="price"  value="${invoicing.price}"    class="form-control" placeholder="请输入单价"  readonly="readonly" >
                                </div>
                                
                                <label class="col-sm-1 control-label">总价</label>
                                <div class="col-sm-2">
                                    <input type="number" name="totalPrice" id="totalPrice"  value="${invoicing.totalPrice}" class="form-control" placeholder="请输入总价">
                                </div>
                            </div>
                            
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label" id="tcompany">销售/采购单位</label>
                                <div class="col-sm-2">
                                    <input type="text" name="company" id="company"  value="${invoicing.company}" class="form-control" placeholder="请输入 销售/采购单位">
                                </div>
                                
                                <label class="col-sm-1 control-label">是否发货</label>
                                <div class="col-sm-2">
                                    <input type="radio" id="ship1" name="isShip" <c:if test="${invoicing.isShip==1}"> checked="checked"  </c:if>  value="1">已发货</label>
                                    <input type="radio" id="ship2" name="isShip" <c:if test="${invoicing.isShip==0}"> checked="checked"  </c:if> value="0">未发货</label>
                                </div>
                                
                            </div>
                            
                            
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label" id="tnum">创建时间</label>
                                <div class="col-sm-3">
                                    <input type="date" name="createDate" id="createDate" value='<fmt:formatDate value="${invoicing.createDate }" type="date"  pattern="yyyy-MM-dd"/>' class="form-control" 
                                     <c:if test="${invoicing.createDate !=null }">readonly="readonly"</c:if>  required="required">
                                </div>
                                
                                <label class="col-sm-1 control-label">是否打款</label>
                                <div class="col-sm-2">
                                    <input type="radio" id="pay1" name="isPay" <c:if test="${invoicing.isPay==1}"> checked="checked"  </c:if> value="1">已打款
                                    <input type="radio" id="pay2" name="isPay" <c:if test="${invoicing.isPay==0}"> checked="checked"  </c:if> value="0">未打款
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
        	if($("#id").val()!=""){
    			$("#company").attr("readonly",true);
    		}
        	$(".radio").click(function(){
        		if($(this).attr("val")==2){
        			$("#price").attr("readonly",false);
        			$("#saler").attr("readonly",false);
        			$("#tnum").html("销售数量");
        			$("#tcompany").html("销售单位");
        			$("#company").attr("placeholder","请输入销售单位");
        		}else if($(this).attr("val")==1){
        			$("#saler").val("");
        			$("#price").attr("readonly",false);
        			$("#saler").attr("readonly",true);
        			$("#tnum").html("采购数量");
        			$("#tcompany").html("采购单位");
        			$("#company").attr("placeholder","请输入 采购单位");
        		}
        		if($(this).attr("val")==3){
        			$("#tcompany").html("结余月份");
        			$("#saler").val("");
        			$("#price").attr("readonly",false);
        			$("#saler").attr("readonly",true);
        			$("#tnum").html("结余数量");
        			$("#company").attr("placeholder","请输入 月份");
        		}
        	})
        	
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
        		    		content += "onclick='selectOK(\""+list[i].name+"\",\""+list[i].code+"\",\""+list[i].price+"\","+list[i].id+")'";
        		    		content += "value='option' name='name'> "+list[i].name+"　　　"+list[i].code+"<i></i></label></div>";
        		    		$("#select").html(content);
        		    	}
        		    }
        		});
        	})
        })
        
        function selectOK(name,code,price,id){
			$("#productName").val(name);
			$("#productCode").val(code);
			$("#productId").val(id);
			$("#price").val(price);
			$("#select").html("");        
		}
        
        $("#num").bind("input propertychange" ,function(e){
        	var num = parseFloat($("#num").val());
        	var price = parseFloat($("#price").val());
        	if(price!=""){
        		$("#totalPrice").val(num*price)
        	}
        })
        
        $("#price").bind("input propertychange" ,function(e){
        	var num = parseFloat($("#num").val());
        	var price = parseFloat($("#price").val());
        	if(num!=null){
        		$("#totalPrice").val(num*price)
        	}
        })
        
        
        
     </script>
</body>
</html>