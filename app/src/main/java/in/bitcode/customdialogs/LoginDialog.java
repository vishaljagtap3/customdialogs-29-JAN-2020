package in.bitcode.customdialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginDialog extends Dialog {

    private EditText mEdtUsername, mEdtPassword;
    private Button mBtnSignIn;

    private Context mContext;


    public interface OnLoginListener {
        void onSuccess(LoginDialog loginDialog);
        void onFailure(LoginDialog loginDialog);
    }

    private OnLoginListener mOnLoginListener;

    public void setOnLoginListener(OnLoginListener onLoginListener) {
        this.mOnLoginListener = onLoginListener;
    }

    public LoginDialog(Context context) {
        super(context);
        mContext = context;
        init();
    }

    private void init() {
        setContentView(R.layout.login);

        mEdtUsername = findViewById(R.id.edtUsername);
        mEdtPassword = findViewById(R.id.edtPassword);
        mBtnSignIn = findViewById(R.id.btnSignIn);

        mBtnSignIn.setOnClickListener(new BtnSignInClickListener());
    }

    private class BtnSignInClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (mOnLoginListener == null) {
                return;
            }
            if(mEdtUsername.getText().toString().equals("bitcode")) {
                mOnLoginListener.onSuccess(LoginDialog.this);
            }
            else {
                mOnLoginListener.onFailure(LoginDialog.this);
            }
        }
    }


    //version 1
    /*
    private class BtnSignInClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if(mEdtUsername.getText().toString().equals("bitcode")) {
                mt("Sign In Successful");
                dismiss();

                Intent intent = new Intent(mContext, HomeAct.class);
                mContext.startActivity(intent);
            }
            else {
                mt("Sign In Not Successful");
            }
        }
    }
    */
    private void mt(String text) {
        Toast.makeText(mContext, text, Toast.LENGTH_LONG).show();
    }
}
