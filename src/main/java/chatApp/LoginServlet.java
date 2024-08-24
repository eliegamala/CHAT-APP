package chatApp;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String logEmail = request.getParameter("email");
        String logPassword = request.getParameter("password");

        UserDatabase db = new UserDatabase(ConnectionDB.getConnection());
        User user = db.loginUser(logEmail, logPassword);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("logUser", user);
            response.sendRedirect("homepage.jsp");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("loginError", "Invalid email or password.");
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
