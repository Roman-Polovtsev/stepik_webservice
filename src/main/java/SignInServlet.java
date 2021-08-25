import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;

public class SignInServlet extends HttpServlet {
    private final UserService service;

    public SignInServlet(UserService service) {
        this.service = service;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = null;
        String password = null;
        Collection<String[]> params = req.getParameterMap().values();
        Set<String> keys = req.getParameterMap().keySet();
        if (keys.contains("login")) {
            login = req.getParameter("login");
        }
        if (keys.contains("password")) {
            password = req.getParameter("password");
        }

        boolean userExists = service.isUserExists(login, password);
        if (userExists) {
            successResponse(resp, login);
        } else {
            badResponse(resp);
        }
    }

    private void successResponse(HttpServletResponse response, String login) throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write("Authorized: ".concat(login));
    }

    private void badResponse(HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("Unauthorized");
    }
}
