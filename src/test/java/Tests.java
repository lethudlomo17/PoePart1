import org.example.Login;
import org.junit.Assert;
import org.junit.Test;

public class Tests {


    @Test
    public void goodRegistration(){
        String user="leth_g";
        String password="ABCDEFGHI,9";
        String firstname="Lethu";
        String lastname="Dlomo";
        Login login =new Login();
        String response = login.registerUser(firstname,lastname,user, password);
        System.out.println(response);

    }

    @Test
    public void goodUserName(){
        String user="leth_";
        Login login =new Login();
        Assert.assertTrue(login.checkUserName(user));
    }

    @Test
    public void badUserName(){
        String user="kyle !!!!!!! ";
        Login login =new Login();
        Assert.assertFalse(login.checkUserName(user));
    }

    @Test
    public void goodPassword(){
        String password="Ch&&sec@ke99!";
        Login login =new Login();
        Assert.assertTrue(login.checkPasswordComplexity(password));
    }

    @Test
    public void badPassword(){
        String password="password";
        Login login =new Login();
        Assert.assertFalse(login.checkPasswordComplexity(password));
    }

    @Test
    public void goodLogin(){
        String user="leth_";
        String password="ABCDEFGHI,9";
        Login login =new Login();
        login.registerUser("Lethu", "Dlomo",user,password);
        Assert.assertTrue(login.loginUser(user,password));
    }

    @Test
    public void badLogin(){
        String user="leth_";
        String password="ABCDEFGHI,9";
        Login login =new Login();
        login.registerUser("Leth","Dlomo","test","test");
        System.out.println();
        Assert.assertFalse(login.loginUser(user,password));
    }

}


