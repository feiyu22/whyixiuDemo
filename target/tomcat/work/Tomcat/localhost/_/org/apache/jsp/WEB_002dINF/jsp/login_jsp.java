/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-02-20 03:46:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\t\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1,maximum-scale=1.0\" />\r\n");
      out.write("<title>武汉易修</title>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css\" />\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("html,body {\r\n");
      out.write("\theight: 100%;\r\n");
      out.write("}\r\n");
      out.write(".box {\r\n");
      out.write("\tfilter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#6699FF', endColorstr='#6699FF'); /*  IE */\r\n");
      out.write("\tbackground-image:linear-gradient(bottom, #6699FF 0%, #6699FF 100%);\r\n");
      out.write("\tbackground-image:-o-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);\r\n");
      out.write("\tbackground-image:-moz-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);\r\n");
      out.write("\tbackground-image:-webkit-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);\r\n");
      out.write("\tbackground-image:-ms-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);\r\n");
      out.write("\t\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 100%;\r\n");
      out.write("}\r\n");
      out.write(".login-box {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\tmax-width:500px;\r\n");
      out.write("\theight: 400px;\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\ttop: 50%;\r\n");
      out.write("\r\n");
      out.write("\tmargin-top: -200px;\r\n");
      out.write("\t/*设置负值，为要定位子盒子的一半高度*/\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("@media screen and (min-width:500px){\r\n");
      out.write("\t.login-box {\r\n");
      out.write("\t\tleft: 50%;\r\n");
      out.write("\t\t/*设置负值，为要定位子盒子的一半宽度*/\r\n");
      out.write("\t\tmargin-left: -250px;\r\n");
      out.write("\t}\r\n");
      out.write("}\t\r\n");
      out.write("\r\n");
      out.write(".form {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\tmax-width:500px;\r\n");
      out.write("\theight: 275px;\r\n");
      out.write("\tmargin: 25px auto 0px auto;\r\n");
      out.write("\tpadding-top: 25px;\r\n");
      out.write("}\t\r\n");
      out.write(".login-content {\r\n");
      out.write("\theight: 300px;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\tmax-width:500px;\r\n");
      out.write("\tbackground-color: rgba(255, 250, 2550, .6);\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("}\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write(".input-group {\r\n");
      out.write("\tmargin: 0px 0px 30px 0px !important;\r\n");
      out.write("}\r\n");
      out.write(".form-control,\r\n");
      out.write(".input-group {\r\n");
      out.write("\theight: 40px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form-group {\r\n");
      out.write("\tmargin-bottom: 0px !important;\r\n");
      out.write("}\r\n");
      out.write(".login-title {\r\n");
      out.write("\tpadding: 20px 10px;\r\n");
      out.write("\tbackground-color: rgba(0, 0, 0, .6);\r\n");
      out.write("}\r\n");
      out.write(".login-title h1 {\r\n");
      out.write("\tmargin-top: 10px !important;\r\n");
      out.write("}\r\n");
      out.write(".login-title small {\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".link p {\r\n");
      out.write("\tline-height: 20px;\r\n");
      out.write("\tmargin-top: 30px;\r\n");
      out.write("}\r\n");
      out.write(".btn-sm {\r\n");
      out.write("\tpadding: 8px 24px !important;\r\n");
      out.write("\tfont-size: 16px !important;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"box\">\r\n");
      out.write("\t\t<div class=\"login-box\">\r\n");
      out.write("\t\t\t<div class=\"login-title text-center\">\r\n");
      out.write("\t\t\t\t<h1><small>武汉易修无人机进销存系统</small></h1>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"login-content \">\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"err\" name=\"err\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${err}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t\t<div class=\"form\">\r\n");
      out.write("\t\t\t<form action=\"/user/login\" method=\"post\">\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-12  \">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-user\"></span></span>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"name\" name=\"name\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" placeholder=\"用户名\" required=\"required\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-12  \">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-lock\"></span></span>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"password\" id=\"password\" name=\"password\" class=\"form-control\" placeholder=\"密码\" required=\"required\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form-group form-actions\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-4 col-xs-offset-4 \">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"buttom\" class=\"btn btn-sm btn-info\"  data-loading-text=\"登录中...\"><span class=\"glyphicon glyphicon-off\"></span> 登录</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-12 link\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div style=\"text-align:center;\">\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script src=\"http://libs.baidu.com/jquery/1.9.1/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\tvar err = $(\"#err\").val();\r\n");
      out.write("\tif(err==\"err\"){\r\n");
      out.write("\t\talert(\"账号密码错误\");\r\n");
      out.write("\t}\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}