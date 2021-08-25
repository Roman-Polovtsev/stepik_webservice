import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;

public class SignUpServlet extends HttpServlet {
    private final UserService service;

    public SignUpServlet(UserService service) {
        this.service = service;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = null;
        String password = null;
        Set<String> keys = req.getParameterMap().keySet();
        if (keys.contains("login")) {
            login = req.getParameter("login");
        }
        if (keys.contains("password")) {
            password = req.getParameter("password");
        }

        service.registerUser(login,password);
    }

}
