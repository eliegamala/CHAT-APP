package chatApp;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User createUser = new User(username, email, password);
        UserDatabase registerUser = new UserDatabase(ConnectionDB.getConnection());

        if (registerUser.saveUser(createUser)) {
            response.sendRedirect("login.jsp");
        } else {
            HttpSession regSession = request.getSession();
            regSession.setAttribute("regError", "Username or Email is already taken");
            response.sendRedirect("fail.jsp");
        }
    }
}
