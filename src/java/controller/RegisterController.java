package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RegisterDAO;
import model.User;
import util.Util;

@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class RegisterController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Resetando variavel de erro da request.
        request.setAttribute("erro", null);
        //Definindo os dispatchers de erro e sucesso.
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        RequestDispatcher rdError = request.getRequestDispatcher("register.jsp");
        
        try (PrintWriter out = response.getWriter()) {
            //Instanciando um user e pegando as variaveis necessarias para registrar o usuario da request.
            User user = new User();
            String nomeCompleto = request.getParameter("nomeCompleto");
            String cpf = request.getParameter("cpf");
            String email = request.getParameter("email");
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String password2 = request.getParameter("password2");
            //Setando no objeto user os dados digitados pelo usuario no formulario.
            user.setNome_completo(nomeCompleto);
            user.setCpf(cpf);
            user.setEmail(email);
            user.setLogin(login);
            user.setSenha(password);
            //Verificando se as senhas batem.
            if (!password.equals(password2)) {
                request.setAttribute("erro", "As senhas não conferem!");
                rdError.forward(request, response);
                return;
            }
            //Verificacao de CPF.
            Boolean validCpf = new Util().validateCpf(cpf);
            if (!validCpf) {
                request.setAttribute("erro", "CPF inválido!");
                rdError.forward(request, response);
                return;
            }
            
            try {
                //Caso passou por todas validacoes, vamos registrar o usuario pelo webservice.
                Boolean inserido = new RegisterDAO().inserir(user);
                //Verifico se o usuario foi inserido ou não e informo na tela.
                if (inserido) {
                    request.setAttribute("sucesso", "Conta registrada com sucesso!");
                    rd.forward(request, response);
                } else {
                    request.setAttribute("erro", "Erro ao inserir! Por favor, contate o suporte!");
                }
            } catch (IOException | ServletException e) {
                request.setAttribute("erro", "Erro ao inserir! Por favor, contate o suporte!");
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
