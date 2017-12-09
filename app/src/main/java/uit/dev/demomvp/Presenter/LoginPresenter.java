package uit.dev.demomvp.Presenter;

import java.util.ArrayList;

import uit.dev.demomvp.Model.User;

/**
 * Created by Administrator on 09/12/2017.
 */

public interface LoginPresenter {
    void CheckLogin(String username,String password);
    void AddEmailToListview(String Email,ArrayList<User> listUser);
}
