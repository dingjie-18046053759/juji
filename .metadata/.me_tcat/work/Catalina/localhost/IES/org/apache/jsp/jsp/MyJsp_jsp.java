package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class MyJsp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html >\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\r\n");
      out.write("    <title>搜电影</title>\r\n");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        function changeSource1() {\r\n");
      out.write("            var but1 = document.getElementById('button1');\r\n");
      out.write("            but1.style.backgroundColor = '#2222ff';\r\n");
      out.write("            document.getElementById(\"iframe\").src = \"http://www.btpipi.com/e/\" + document.getElementById('sss').value + \"/\";\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function changeSource2() {\r\n");
      out.write("            var but2 = document.getElementById('button2');\r\n");
      out.write("            but2.style.backgroundColor = \"#2222ff\";\r\n");
      out.write("            document.getElementById(\"iframe\").src = \"http://www.13910.com/s/?kw=\" + document.getElementById('sss').value;\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<label for=\"sss\"></label>\r\n");
      out.write("<input name=\"sss\" type=\"text\" id=\"sss\" value=\"杀破狼\"/>\r\n");
      out.write("<input type=\"submit\" style=\"height:22px;width:70px;\" value=\"BTpipi\" onClick=\"changeSource1()\" id=\"button1\"/>\r\n");
      out.write("<input type=\"submit\" style=\"height:22px;width:70px;\" value=\"盘找我\" onClick=\"changeSource2()\" id=\"button2\"/>\r\n");
      out.write("<br/>\r\n");
      out.write("<iframe id=\"iframe\" align=middle marginwidth=0 vspace=-0 marginheight=0 src=\"http://www.baidu.com/\" frameborder=no\r\n");
      out.write("width=100% scrolling=auto height=903></iframe>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
