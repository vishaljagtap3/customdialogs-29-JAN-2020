package in.bitcode.customdialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        mBtnLogin = findViewById(R.id.btnLogin);
        mBtnLogin.setOnClickListener(new BtnLoginClickListener());
    }

    private class BtnLoginClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            LoginDialog loginDialog = new LoginDialog(MainActivity.this);
            loginDialog.setOnLoginListener(new MyOnLoginListener());
            loginDialog.show();

        }
    }

    private class MyOnLoginListener implements LoginDialog.OnLoginListener {
        @Override
        public void onSuccess(LoginDialog loginDialog) {
            mt("Login is Successful");
            loginDialog.dismiss();
        }

        @Override
        public void onFailure(LoginDialog loginDialog) {
            mt("Login is not Successful");
        }
    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}