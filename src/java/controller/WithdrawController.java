package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.LoginDAO;
import model.User;
import model.BalanceDAO;

@WebServlet(name = "Withdraw", urlPatterns = {"/Withdraw"})
public class WithdrawController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Definindo o dispatcher que utilizaremos e resetando os erros.
        RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
        RequestDispatcher rdError = request.getRequestDispatcher("withdraw.jsp");
        request.setAttribute("erro", null);

        try (PrintWriter out = response.getWriter()) {
            //Declaracao das variaveis que utilizaremos.
            HttpSession session = request.getSession();
            String saque = request.getParameter("saque");
            Float saqueFloat = Float.parseFloat(saque);
            String password = request.getParameter("password");
            User user = (User) session.getAttribute("loginUser");
            User loginUser;

            try {
                Float saldo = user.getSaldo();
                //Verificando se existe saldo suficiente. Se nao existir informamos o usuario.
                if (saldo < 0 || saldo < saqueFloat) {
                    request.setAttribute("erro", "Saldo insuficiente.");
                    rdError.forward(request, response);
                    return;
                }
                //Verificando se a senha esta correta. Se nao informamos o usuario.
                if (!password.equals(user.getSenha())) {
                    request.setAttribute("erro", "Senha incorreta.");
                    rdError.forward(request, response);
                    return;
                }
                //Calculo do saque no saldo e enviando para o webservice PHP.
                float saldoFinal = saldo - saqueFloat;
                new BalanceDAO().update(user.getLogin(), saldoFinal + "");
                //Buscando saldo atual no webservice PHP.
                loginUser = new LoginDAO().loginUser(user.getLogin());
                //Inserindo dados do usuario atualizados na sessao.
                request.setAttribute("sucesso", "Saque realizado com sucesso.");
                request.setAttribute("loginUser", loginUser);
                session.setAttribute("loginUser", loginUser);
                rd.forward(request, response);
            } catch (Exception e) {
                //Tratamento de erro genérico não previsto.
                request.setAttribute("erro", "Houve um erro não esperado. Contate o suporte.");
                rdError.forward(request, response);
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
