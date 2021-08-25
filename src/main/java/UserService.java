import java.util.HashMap;
import java.util.Map;

public class UserService {
    private final Map<String,String> loginPassMap;

    public UserService() {
        this.loginPassMap =  new HashMap<>();
    }

    public void registerUser(String login, String password){
        loginPassMap.put(login, password);
    }

    public boolean isUserExists(String login, String password){
        String passwordByLogin = loginPassMap.get(login);
        return passwordByLogin.equals(password);
    }
}
