package uit.dev.demomvp.Presenter;

import java.util.ArrayList;

import uit.dev.demomvp.Model.User;
import uit.dev.demomvp.View.LoginView;

/**
 * Created by Phi on 09/12/2017.
 */

public class LoginLogicPresenter implements LoginPresenter {
    LoginView loginView ;

    public  LoginLogicPresenter(LoginView loginView)
    {
        this.loginView = loginView;
    }

    @Override
    public void CheckLogin(String username, String password) {

        if ((username.equals("gkz@gmail.com")|| username.equals("gkz") )&& password.equals("123456"))
        {
            loginView.loginSuccess();
        }
        else
        {
            loginView.loginFail();
        }
    }

    @Override
    public void AddEmailToListview(String email, ArrayList<User> listUser) {
     User user = new User();
     user.setEmail(email);
     listUser.add(user);
    }
}
