<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>产品列表</title>

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="/hadmin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/hadmin/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <!-- Data Tables -->
    <link href="/hadmin/css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">

    <link href="/hadmin/css/animate.css" rel="stylesheet">
    <link href="/hadmin/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>产品列表</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <table class="table table-bordered table-hover table-striped dataTables-example">
                            <thead>
                                <tr>
                                	<th class="col-sm-1 text-center">序号</th>
                                    <th class="col-sm-3 text-center">产品名称</th>
                                    <th class="col-sm-3 text-center">产品编码</th>
                                    <th class="col-sm-3 text-center">采购价格</th>
                                    <th class="col-sm-2 text-center">操作</th>
                                </tr>
                            </thead>
                            <tbody>
	                           <c:forEach items="${list }" var="pro" varStatus="sta">
	                           	 <tr class="gradeA">
	                                   <td>${sta.index+1 }</td>
	                                   <td>${pro.name }</td>
	                                   <td>${pro.code }</td>
	                                   <td class="center">${pro.price }</td>
	                                   <td class="center"> 
		                                   <a class="btn btn-warning btn-sm tab_del" href="/product/toAddOrEdit?id=${pro.id }">修改</a>
		                                   <a class="btn btn-danger btn-sm ">删除</a>
	                                   </td>
	                               </tr>
	                           </c:forEach>
                            </tbody>
                            <tfoot>
<!--                                 <tr> -->
<!--                                     <th>渲染引擎</th> -->
<!--                                     <th>浏览器</th> -->
<!--                                     <th>平台</th> -->
<!--                                     <th>引擎版本</th> -->
<!--                                     <th>CSS等级</th> -->
<!--                                 </tr> -->
                            </tfoot>
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
//             /* Init DataTables */
//             var oTable = $('#editable').dataTable();
//             /* Apply the jEditable handlers to the table */
//             oTable.$('td').editable('../example_ajax.php', {
//                 "callback": function (sValue, y) {
//                     var aPos = oTable.fnGetPosition(this);
//                     oTable.fnUpdate(sValue, aPos[0], aPos[1]);
//                 },
//                 "submitdata": function (value, settings) {
//                     return {
//                         "row_id": this.parentNode.getAttribute('id'),
//                         "column": oTable.fnGetPosition(this)[2]
//                     };
//                 },
//                 "width": "90%",
//                 "height": "100%"
//             });
        });

//         function fnClickAddRow() {
//             $('#editable').dataTable().fnAddData([
//                 "Custom row",
//                 "New row",
//                 "New row",
//                 "New row",
//                 "New row"]);
//         }
    </script>

    
    

</body>

</html>
