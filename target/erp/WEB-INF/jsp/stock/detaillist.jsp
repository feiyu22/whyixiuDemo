<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>剩余库存详细列表</title>

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="/hadmin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/hadmin/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <!-- Data Tables -->
    <link href="/hadmin/css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">

    <link href="/hadmin/css/animate.css" rel="stylesheet">
    <link href="/hadmin/css/style.css?v=4.1.0" rel="stylesheet">
<style type="text/css">
.vertical-center{
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
</style>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>库存详细列表</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
<!--                     <form id="search_form" name="search_form" action="/invocing/list"> -->
<!--                     	<div class="row"> -->
<!-- 							<div class="col-sm-3 m-b-xs"> -->
<%-- 								<input type="date" id="beginDate" name="beginDate" value="${vo.beginDate}"  --%>
<!-- 									class="form-control layer-date"> -->
<!-- 							</div> -->
<!-- 							<div class="col-sm-3 m-b-xs"> -->
<%-- 								<input type="date" id="endDate" name="endDate" class="form-control" placeholder="结束日期" value="${vo.endDate}"> --%>
<!-- 							</div> -->
							
<!--                             <div class="col-sm-1"> -->
<!--                             	<button type="submit" class="btn  btn-primary">搜索</button>  -->
<!--                             </div> -->
<!--                             <div class="col-sm-1"> -->
<!--                             	<button type="button" class="btn glyphicon glyphicon-file"  id="exp">导出</button>  -->
<!--                             </div> -->
<!--                         </div> -->
<!--                         </form> -->
                    
                        <table class="table table-bordered table-hover table-striped dataTables-example">
                            <thead>
                                <tr>
                                	<th class="col-sm-1 text-center">序号</th>
                                	<th class="col-sm-3 text-center">产品名称（产品编码）</th>
                                    <th class="col-sm-2 text-center">采购公司</th>
                                    <th class="col-sm-1 text-center">数量</th>
                                    <th class="col-sm-1 text-center">单价</th>
                                    <th class="col-sm-2 text-center">条形码</th>
                                    <th class="col-sm-2 text-center">采购时间</th>
<!--                                     <th class="col-sm-1 text-center">操作</th> -->
                                </tr>
                            </thead>
                            <tbody>
	                           <c:forEach items="${list }" var="sto" varStatus="sta">
	                           	 <tr class="gradeA">
	                                   <td>${sta.index+1 }</td>
	                                   <td>${sto.name}（${sto.code }）</td>
	                                   <td>${sto.company}  </td>
	                                   <td class="center"><h4>${sto.num }</h4></td>
	                                   <td class="center">${sto.price }</td>
	                                   <td class="center">${sto.barcode }</td>
	                                   <td>
	                                   	<fmt:formatDate value="${sto.createDate }" pattern="yyyy-MM-dd" type="date"/> 
	                                   </td>
<!-- 	                                   <td class="center">  -->
<%-- 		                                   <a class="btn btn-warning btn-xs tab_del" href="/invocing/toAddOrEdit?id=${inv.id }">修改</a> --%>
<!-- 	                                   </td> -->
	                               </tr>
	                           </c:forEach>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 全局js -->
    <script src="/hadmin/js/jquery.min.js?v=2.1.4"></script>
    <script src="/hadmin/js/bootstrap.min.js?v=3.3.6"></script>



    <script src="/hadmin/js/plugins/jeditable/jquery.jeditable.js"></script>

    <!-- Data Tables -->
    <script src="/hadmin/js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="/hadmin/js/plugins/dataTables/dataTables.bootstrap.js"></script>

    <!-- 自定义js -->
    <script src="/hadmin/js/content.js?v=1.0.0"></script>


    <!-- Page-Level Scripts -->
    <script>
        $(document).ready(function () {
            $('.dataTables-example').dataTable();
        });
    </script>
</body>

</html>
