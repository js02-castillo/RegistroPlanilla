package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.AppPlanilla.models.Planilla;
import java.util.List;

public final class Register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Planilla</title>\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" />\n");
      out.write("        <script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            if(request.getAttribute("code")!=null){
                if( Integer.parseInt(request.getAttribute("code").toString())==200){
                    
        
      out.write("\n");
      out.write("        <script>\n");
      out.write("                alert('200-Registro con Exito')\n");
      out.write("        </script>\n");
      out.write("        ");

                }else{
        
      out.write("\n");
      out.write("        <script>\n");
      out.write("                alert('500-Error en el proceso')\n");
      out.write("        </script>\n");
      out.write("        ");

                    
                }
            }
        
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"container\">\n");
      out.write("            \n");
      out.write("            <div class=\"card\" >\n");
      out.write("                <p class=\"h1\" style=\"text-align: center\" >Cálculo de Planilla</p>\n");
      out.write("                <form method=\"post\" action=\"AccountPlanillaController\">\n");
      out.write("                    <div class=\"input-group\">\n");
      out.write("                        <input id=\"txtmes\" name=\"txtmes\" type=\"number\" min=\"1\" pattern=\"^[0-9]+\" class=\"form-control\" placeholder=\"Ingrese Mes\" aria-label=\"Recipient's username with two button addons\">\n");
      out.write("                        \n");
      out.write("                        <button class=\"btn btn-outline-secondary\" type=\"submit\" id=\"btnregister\" name=\"btnregister\" value=\"Register\" >Calcular</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <table class=\"table table-striped table-hover\">\n");
      out.write("                <thead>\n");
      out.write("                  <tr>\n");
      out.write("                    <th scope=\"col\">idPlanilla</th>\n");
      out.write("                    <th scope=\"col\">idAfp</th>\n");
      out.write("                    <th scope=\"col\">idTrabajador</th>\n");
      out.write("                    <th scope=\"col\">idMes</th>\n");
      out.write("                    <th scope=\"col\">DiasFalta</th>\n");
      out.write("                    <th scope=\"col\">HorasFalta</th>\n");
      out.write("                    <th scope=\"col\">TotalIngresos</th>\n");
      out.write("                    <th scope=\"col\">TotalDescuentos</th>\n");
      out.write("                  </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");

                        if(request.getAttribute("listPlanilla")!=null){
                            for(Planilla item : (List<Planilla>) request.getAttribute("listPlanilla")){  
                    
      out.write("\n");
      out.write("                  <tr>\n");
      out.write("                    <th scope=\"row\">");
      out.print( item.getIdPlanilla() );
      out.write("</th>\n");
      out.write("                    <td>");
      out.print( item.getIdAfp() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( item.getIdTrabajador() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( item.getIdMes() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( item.getDiasFalta() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( item.getHorasFalta() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( item.getTotalIngresos() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( item.getTotalDescuentos() );
      out.write("</td>\n");
      out.write("                  </tr>\n");
      out.write("                  \n");
      out.write("                  ");

                        }
                      }
                  
      out.write("\n");
      out.write("                  \n");
      out.write("                </tbody>\n");
      out.write("              </table>\n");
      out.write("        </div> <br><br>\n");
      out.write("        \n");
      out.write("        <div class=\"card\" >\n");
      out.write("                <p class=\"h5\" style=\"text-align: left\" >Integrantes:</p>\n");
      out.write("                <li  style=\"text-align: left\" >Caiguaray Cotrina, Luis Fernando.</li>\n");
      out.write("                <li  style=\"text-align: left\" >Castillo Campos, Johnny Stuar.</li>\n");
      out.write("                <li style=\"text-align: left\" >García Horna, Francisco Alejandro.</li>\n");
      out.write("                <li  style=\"text-align: left\" >Guevara Segura, Jair Erinson.</li>\n");
      out.write("                <li  style=\"text-align: left\" >Ortiz Noriega, Keyly Esperanza.</li>\n");
      out.write("                <li  style=\"text-align: left\" >Puelles Caldas, Miuler.</li>\n");
      out.write("                <li  style=\"text-align: left\" >Reyes Julca, Christian Steven.</li>\n");
      out.write("                <li  style=\"text-align: left\" >Vera Paredes, Tania Maribel.</li>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </body>\n");
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
