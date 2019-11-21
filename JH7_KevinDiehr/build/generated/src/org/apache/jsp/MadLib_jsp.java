package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class MadLib_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Madlibs</title>\n");
      out.write("        <link href=\"madlibcss.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    </head>\n");
      out.write("    <pre>\n");
      out.write("To create a funny sentence, enter and adjective, and then a noun, and press the 'Generate Sentence' button.\n");
      out.write("To add your own sentence, use the syntax '?a' for an adjective, and '?n' for a noun, then press the 'Submit Sentence' button.\n");
      out.write("An example of this is the following:\n");
      out.write("\"The ?n is very ?a. I like the ?n due to this reason.\"\n");
      out.write("If you don't like the sentence that is generated, press the 'Delete Sentence' button, and it will be removed.\n");
      out.write("        </pre>\n");
      out.write("    <div class=\"center\">\n");
      out.write("    <form action=\"SentenceController\">\n");
      out.write("        <input type=\"text\" name=\"adj\" /> Adjective\n");
      out.write("        <br><input type=\"text\" name=\"noun\" /> Noun\n");
      out.write("        <br><input type=\"submit\" name=\"action\" value=\"Generate Sentence\" />\n");
      out.write("    </form>\n");
      out.write("    <hr>\n");
      out.write("    <form action=\"SentenceController\">\n");
      out.write("        <input type=\"text\" name=\"sentence\" /> Add new sentence to DB\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <br><input type=\"submit\" name=\"action\" value=\"Submit Sentence\" />\n");
      out.write("    <br>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sentenceGen}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("    <input type=\"hidden\" name=\"index\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(empty sentenceID) ? 0 : sentenceID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\n");
      out.write("    <br><br><input type=\"submit\" name=\"action\" value=\"Delete Sentence\" />\n");
      out.write("    \n");
      out.write("    </form>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
