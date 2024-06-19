import org.example.Login;
import org.junit.Test;

public class Tests {
    @Test
    public void goodregistration(){

        String user="leth_";
        String password="ABCDEFGHI,9";
        String myAnswer;

        Login login =new Login();
        myAnswer = login.registerUser(user, password);
        System.out.println(myAnswer);

    }
}
