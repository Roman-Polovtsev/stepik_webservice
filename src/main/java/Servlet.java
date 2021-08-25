
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Servlet extends HttpServlet {


    List<String> users = new ArrayList<>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Object key = req.getAttribute("key");
        HttpSession session = req.getSession();
        String cookie = Arrays.stream(req.getCookies()).findFirst().get().getValue();
        if (users.contains(cookie))
            resp.getWriter().write("exist");
        else users.add(cookie);
            System.out.println(
                session
        );
        Map<String, String[]> parameterMap = req.getParameterMap();
        List<String> collect = parameterMap.values().stream().map(arr -> arr[0]).collect(Collectors.toList());
        collect.forEach(value -> {
            try {
                resp.getWriter().write(value);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
    }
}
