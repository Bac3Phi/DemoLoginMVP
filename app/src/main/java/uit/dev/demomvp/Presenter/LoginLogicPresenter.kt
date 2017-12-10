package uit.dev.demomvp.Presenter

import java.util.ArrayList

import uit.dev.demomvp.Model.User
import uit.dev.demomvp.View.LoginView

/**
 * Created by Phi on 09/12/2017.
 */

class LoginLogicPresenter(internal var loginView: LoginView) : LoginPresenter {

    override fun CheckLogin(username: String, password: String) {

        if ((username == "gkz@gmail.com" || username == "gkz") && password == "123456") {
            loginView.loginSuccess()
        } else {
            loginView.loginFail()
        }
    }

    override fun AddEmailToListview(email: String, listUser: ArrayList<User>) {
        val user = User()
        user.email = email
        listUser.add(user)
    }
}
