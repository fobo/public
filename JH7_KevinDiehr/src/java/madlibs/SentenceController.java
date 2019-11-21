/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madlibs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kevin Diehr
 */
@WebServlet(name = "SentenceController", urlPatterns = {"/SentenceController"})
public class SentenceController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        SentenceCollection sentenceCollection = (SentenceCollection) getServletContext().getAttribute("sentenceCollection");
        System.out.println(sentenceCollection);
        String action = request.getParameter("action");
        String querySentence = "";
        DB_Sentence sentenceThing;
        int sentenceID = 0;
        
        if(action.equals("Submit Sentence")) {
            String newsentence = request.getParameter("sentence");
            DB_Sentence sentence = new DB_Sentence(newsentence, 0);
            System.out.println(sentence);
            sentenceCollection.addSentence(sentence);
        }
        
        if(action.equals("Delete Sentence")){
           
               
             
            sentenceCollection.removeSentence(Integer.parseInt(request.getParameter("index")));
            
            
        }
        
        if(action.equals("Generate Sentence")){
            
            
            sentenceThing = sentenceCollection.generateSentence();
            querySentence = sentenceThing.getSentence();
            sentenceID = sentenceThing.getIndex();
            String adj = request.getParameter("adj");
            String noun = request.getParameter("noun");
            System.out.println(querySentence + " " + noun + " " + adj);
            
            querySentence = querySentence.replace("?n", noun);
            querySentence = querySentence.replace("?a", adj);
            System.out.println(querySentence);
            
        }
        request.setAttribute("sentenceGen", querySentence);
        request.setAttribute("sentenceID", sentenceID);
        request.getRequestDispatcher("MadLib.jsp").forward(request, response);
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
