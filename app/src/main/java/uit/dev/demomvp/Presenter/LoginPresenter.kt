package uit.dev.demomvp.Presenter

import java.util.ArrayList

import uit.dev.demomvp.Model.User

/**
 * Created by Administrator on 09/12/2017.
 */

interface LoginPresenter {
    fun CheckLogin(username: String, password: String)
    fun AddEmailToListview(Email: String, listUser: ArrayList<User>)
}
