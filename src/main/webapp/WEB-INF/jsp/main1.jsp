<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="renderer" content="webkit">
    <title>武汉易修</title>
    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="/hadmin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/hadmin/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="/hadmin/css/animate.css" rel="stylesheet">
    <link href="/hadmin/css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
    <div id="wrapper">
        <!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                                    <span class="block m-t-xs" style="font-size:22px;">
                                        <i class="fa fa-area-chart"></i>
                                        <strong class="font-bold">武汉易修</strong>
                                    </span>
                                </span>
                            </a>
                        </div>
                        <div class="logo-element">
                        </div>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa fa-bar-chart-o"></i>
                            <span class="nav-label">进销存</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
<!--                             <LI> -->
<!--                                 <A CLASS="J_MENUITEM" HREF="#">数据统计</A> -->
<!--                             </LI> -->
                            <li>
                                <a class="J_menuItem" href="/invocing/list">进销记录</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="/invocing/toAddOrEdit">添加记录</a>
                            </li>
                        </ul>
                    </li>
                    <li class="line dk"></li>
                    <li>
                        <a href="#"><i class="fa fa-edit"></i> <span class="nav-label">采购计划</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="/purchase/list">计划列表</a>
                            </li>
                            <li><a class="J_menuItem" href="/purchase/toAddOrEdit">录入计划</a>
                            </li>
                        </ul>
                    </li>
                    <li class="line dk"></li>
                    <li>
                        <a href="#"><i class="glyphicon glyphicon-th"></i> <span class="nav-label">库存管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="/stock/list">剩余库存</a>
                            </li>
                            <li><a class="J_menuItem" href="/stock/toAddOrEdit">入库操作</a>
                            </li>
                            <li><a class="J_menuItem" href="/stock/exitus">出库操作</a>
                            </li>
                            <li><a class="J_menuItem" href="/stock/allList">操作记录</a>
                            </li>
                        </ul>
                    </li>
                    <li class="line dk"></li>
                    <li>
                        <a href="#"><i class="fa fa-desktop"></i> <span class="nav-label">商品管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="/product/list">商品列表</a>
                            </li>
                            <li><a class="J_menuItem" href="/product/toAddOrEdit">添加商品</a>
                            </li>
                        </ul>
                    </li>
                    <li class="line dk"></li>
                </ul>
            </div>
        </nav>
        <!--左侧导航结束-->
        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-info " href="#"><i class="fa fa-bars"></i> </a>
	                    <div class="form-group">
	                
	                    </div>
                    </div>
                    <ul class="nav navbar-top-links navbar-right">
                        <li class="dropdown">
                            <a class="count-info" href="/user/logout">
                                <i class="fa fa-close"></i>退出系统
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="row J_mainContent" id="content-main">
                <iframe id="J_iframe" width="100%" height="100%" src="/hadmin/index_v1.html?v=4.0" frameborder="0" data-id="index_v1.html" seamless></iframe>
            </div>
        </div>
        <!--右侧部分结束-->
    </div>

    <!-- 全局js -->
    <script src="/hadmin/js/jquery.min.js?v=2.1.4"></script>
    <script src="/hadmin/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="/hadmin/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="/hadmin/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="/hadmin/js/plugins/layer/layer.min.js"></script>

    <!-- 自定义js -->
    <script src="/hadmin/js/hAdmin.js?v=4.1.0"></script>
    <script type="text/javascript" src="/hadmin/js/index.js"></script>

    <!-- 第三方插件 -->
    <script src="/hadmin/js/plugins/pace/pace.min.js"></script>
</body>

</html>
