package controller;

import model.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Definindo o dispatcher para sucesso e erro.
        RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
        RequestDispatcher rdError = request.getRequestDispatcher("index.jsp");

        try (PrintWriter out = response.getWriter()) {
            //Declaracao das variaveis que utilizaremos. Pegando usuario e senha da request.
            String login = request.getParameter("login");
            String password = request.getParameter("pass");
            HttpSession session = request.getSession();
            User loginUser;

            try {
                //Com o login, enviamos pelo webservice para verificar se esta no banco de dados.
                loginUser = new LoginDAO().loginUser(login);
                //Validacao se o login e a senha esta correto.
                if (loginUser != null && loginUser.getSenha().equalsIgnoreCase(password)) {
                    request.setAttribute("loginUser", loginUser);
                    session.setAttribute("loginUser", loginUser);
                    rd.forward(request, response);
                } else {
                    request.setAttribute("erro", "Usuário ou senha inválida");
                    rdError.forward(request, response);
                }
            } catch (NullPointerException e) {

            }
        }
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
