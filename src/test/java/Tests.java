import org.example.Login;
import org.junit.Assert;
import org.junit.Test;


public class Tests {

    //test for successful registration
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

    //test for correct username
    @Test
    public void goodUserName(){
        String user="leth_";
        Login login =new Login();
        Assert.assertTrue(login.checkUserName(user));
    }

    //test for incorrect username
    @Test
    public void badUserName(){
        String user="kyle !!!!!!! ";
        Login login =new Login();
        Assert.assertFalse(login.checkUserName(user));
    }

    //test for vaild password
    @Test
    public void goodPassword(){
        String password="Ch&&sec@ke99!";
        Login login =new Login();
        Assert.assertTrue(login.checkPasswordComplexity(password));
    }

    //test for invaild password
    @Test
    public void badPassword(){
        String password="password";
        Login login =new Login();
        Assert.assertFalse(login.checkPasswordComplexity(password));
    }

    //test for successful login
    @Test
    public void goodLogin(){
        String user="leth_";
        String password="ABCDEFGHI,9";
        Login login =new Login();
        login.registerUser("Lethu", "Dlomo",user,password);
        Assert.assertTrue(login.loginUser(user,password));
    }

    //test for unsuccessful login
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


