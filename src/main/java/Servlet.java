
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Servlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Object key = req.getAttribute("key");
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
