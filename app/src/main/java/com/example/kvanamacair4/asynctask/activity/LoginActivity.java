package com.example.kvanamacair4.asynctask.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kvanamacair4.asynctask.R;
import com.example.kvanamacair4.asynctask.helper.DatabaseHelper;
import com.example.kvanamacair4.asynctask.model.User;

public class LoginActivity extends AppCompatActivity {

    private Button mlogin;
    private TextView tv_register;
    private EditText musername, mpassword;
    private String EmailHolder, PasswordHolder;
    private Boolean EditTextEmptyHolder;
    private SQLiteDatabase sqLiteDatabaseObj;
    private DatabaseHelper databaseHelper;
    Cursor cursor;
    String TempPassword = "NOT_FOUND";
    public static final String UserEmail = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        musername = findViewById(R.id.et_username);
        mpassword = findViewById(R.id.et_password);
        mlogin = findViewById(R.id.btn_login);
        tv_register = findViewById(R.id.tv_register);
        databaseHelper = new DatabaseHelper(this);

        //Adding click listener to log in button.
        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Calling EditText is empty or no method.
                CheckEditTextStatus();

                // Calling login method.
                LoginFunction();
                Intent intent = new Intent(LoginActivity.this, NevigationDrawerActivity.class);
                startActivity(intent);
            }
        });

        // Adding click listener to register button.
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });

    }

    // Login function starts from here.
    public void LoginFunction() {

        if (EditTextEmptyHolder) {

            // Opening SQLite database write permission.
            sqLiteDatabaseObj = databaseHelper.getWritableDatabase();

            // Adding search email query to cursor.
            cursor = sqLiteDatabaseObj.query(User.TABLE_NAME, null, " " + User.Table_Column_2_Email + "=?", new String[]{EmailHolder}, null, null, null);

            while (cursor.moveToNext()) {

                if (cursor.isFirst()) {

                    cursor.moveToFirst();

                    // Storing Password associated with entered email.
                    TempPassword = cursor.getString(cursor.getColumnIndex(User.Table_Column_3_Password));

                    // Closing cursor.
                    cursor.close();
                }
            }

            /* Calling method to check final result .. */
            CheckFinalResult();

        } else {

            //If any of login EditText empty then this block will be executed.
            Toast.makeText(LoginActivity.this, "Please Enter UserName or Password.", Toast.LENGTH_LONG).show();

        }

    }

    // Checking EditText is empty or not.
    public void CheckEditTextStatus() {

        // Getting value from All EditText and storing into String Variables.
        EmailHolder = musername.getText().toString();
        PasswordHolder = mpassword.getText().toString();

        // Checking EditText is empty or no using TextUtils.
        if (TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder)) {

            EditTextEmptyHolder = false;

        } else {

            EditTextEmptyHolder = true;
        }
    }

    // Checking entered password from SQLite database email associated password.
    public void CheckFinalResult() {

        if (TempPassword.equalsIgnoreCase(PasswordHolder)) {

            Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_LONG).show();


            Intent intent = new Intent(LoginActivity.this, MainActivity.class);


            startActivity(intent);

        } else {

            Toast.makeText(LoginActivity.this, "UserName or Password is Wrong, Please Try Again.", Toast.LENGTH_LONG).show();

        }
        TempPassword = "NOT_FOUND";

    }

}