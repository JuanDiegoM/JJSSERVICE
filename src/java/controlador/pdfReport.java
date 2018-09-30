
package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego
 */
@WebServlet(name = "pdfReport", urlPatterns = {"/pdfReport"})
public class pdfReport extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*response.setContentType("aplication/pdf");
        OutputStream out = response.getOutputStream();
        try {
            String fechaInicion = request.getParameter("reporteFechaInicio");
            String fechaFin = request.getParameter("reporteFechaFin");
            int idTipoVehiculo = Integer.parseInt(request.getParameter("parametroTipoVehiculonew"));
            int idTipoServicio = Integer.parseInt(request.getParameter("parametroServicionew"));
            //System.out.println(fechaInicion);
            //System.out.println(fechaFin);
            try {
                
                Document documento = new Document();
                PdfWriter.getInstance(documento, out);
                documento.open();
                
                Paragraph pr1 = new Paragraph();
                Font fontitulo = new Font(Font.FontFamily.HELVETICA,16,Font.BOLD,BaseColor.BLACK);
                pr1.add(new Phrase("Reporte General",fontitulo));
                pr1.setAlignment(Element.ALIGN_CENTER);
                pr1.add(new Phrase(Chunk.NEWLINE));
                pr1.add(new Phrase(Chunk.NEWLINE));
                documento.add(pr1);
                
                
                documento.close();
                
            } catch (DocumentException e) {
                e.getMessage();
            }
            
        }finally{
            out.close();
        }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
