package uit.dev.demomvp.View

import android.app.Presentation
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast

import java.util.ArrayList

import uit.dev.demomvp.Adapter.LoginAdapter
import uit.dev.demomvp.Model.User
import uit.dev.demomvp.Presenter.LoginLogicPresenter
import uit.dev.demomvp.R
import uit.dev.demomvp.View.LoginView

class MainActivity : AppCompatActivity(), LoginView, View.OnClickListener {
    protected lateinit var btnLogin: Button
    protected lateinit var edtEmail: EditText
    protected lateinit var edtPassword: EditText
    protected lateinit var loginLogicPresenter: LoginLogicPresenter

    protected lateinit var listviewUser: ListView
    protected lateinit var loginAdapter: LoginAdapter
    protected lateinit var Users: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        maping()
        loginLogicPresenter = LoginLogicPresenter(this)
        btnLogin.setOnClickListener(this)
    }

    private fun maping() {
        btnLogin = findViewById<View>(R.id.btnSignIn) as Button
        edtEmail = findViewById<View>(R.id.edtEmail) as EditText
        edtPassword = findViewById<View>(R.id.edtPassword) as EditText
        Users = ArrayList()
        listviewUser = findViewById<View>(R.id.listviewUser) as ListView
        loginAdapter = LoginAdapter(this, Users)
        listviewUser.adapter = loginAdapter
    }


    override fun loginFail() {
        Toast.makeText(this, "Fail to connect", Toast.LENGTH_SHORT).show()
    }

    override fun loginSuccess() {
        Toast.makeText(this, "Success to connect", Toast.LENGTH_SHORT).show()
        addListViewUser()

    }

    override fun addListViewUser() {
        loginLogicPresenter.AddEmailToListview(edtEmail.text.toString(), Users)
    }

    override fun onClick(v: View) {
        loginLogicPresenter.CheckLogin(edtEmail.text.toString(), edtPassword.text.toString())

    }
}
