package uit.dev.demomvp.View;

import android.app.Presentation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import uit.dev.demomvp.Adapter.LoginAdapter;
import uit.dev.demomvp.Model.User;
import uit.dev.demomvp.Presenter.LoginLogicPresenter;
import uit.dev.demomvp.R;
import uit.dev.demomvp.View.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView,View.OnClickListener{
    Button btnLogin;
    EditText edtEmail, edtPassword;
    LoginLogicPresenter loginLogicPresenter;

    ListView listviewUser;
    LoginAdapter loginAdapter;
    ArrayList<User> Users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        maping();
        loginLogicPresenter= new LoginLogicPresenter(this);
        btnLogin.setOnClickListener(this);
    }

    private void maping() {
        btnLogin = (Button) findViewById(R.id.btnSignIn);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        Users = new ArrayList<>();
        listviewUser = (ListView) findViewById(R.id.listviewUser);
        loginAdapter = new LoginAdapter(this,Users);
        listviewUser.setAdapter(loginAdapter);
    }


    @Override
    public void loginFail() {
        Toast.makeText(this, "Fail to connect", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Success to connect", Toast.LENGTH_SHORT).show();
        addListViewUser();

    }

    @Override
    public void addListViewUser() {
        loginLogicPresenter.AddEmailToListview(edtEmail.getText().toString(),Users);
    }

    @Override
    public void onClick(View v) {
        loginLogicPresenter.CheckLogin(edtEmail.getText().toString(),edtPassword.getText().toString());

    }
}
