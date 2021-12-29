package com.example.tripadvisor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.signup_page);
        TextView email = findViewById(R.id.email_text_signup);
        TextView passText = findViewById(R.id.pwd_text_signup);
        TextView nameText = findViewById(R.id.name_text_signup);
        DAOusers dao = new DAOusers();
//        String userName = dao.userName(mail);
        Button signup = findViewById(R.id.signup_btn_register);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail=email.getText().toString();
                String name = nameText.getText().toString();
                String pass = passText.getText().toString();
                User u = new User(mail,name,pass);
                dao.addUser(u).addOnSuccessListener(suc -> {
                    Toast.makeText(Signup.this,"Record is inserted",Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(fail-> {
                    Toast.makeText(Signup.this,""+fail.getMessage(),Toast.LENGTH_SHORT).show();
                });
                DbHelper db = new DbHelper(Signup.this);
                db.addUsers(u.getUserName(),u.getUserEmail());
                Intent intent = new Intent(Signup.this,Admobs.class);
                startActivity(intent);
//                if(userName !=""){
//                    System.out.println(userName);
//                    DbHelper db = new DbHelper(Signup.this);
//                    db.addUsers(dao.userName(mail),mail);
//                    User u2 = new User(mail,name,pass);
//                    dao.addUser(u2);
//                    Intent intent = new Intent(Signup.this,Home.class);
//                    startActivity(intent);
//                }else{
//                    Toast.makeText(Signup.this, "Email already register", Toast.LENGTH_SHORT).show();
//                }
            }
        });
//        TextView email = findViewById(R.id.email_text_signup);
//        TextView pass = findViewById(R.id.pwd_text_signup);
//        TextView name = findViewById(R.id.name_text_signup);
//        DAOUser dao = new DAOUser();
//        String mail=email.getText().toString();
//        String userName = dao.userName(mail);
//        Button signup = findViewById(R.id.signup_btn_register);
//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(userName !=""){
//                    DbHelper db = new DbHelper(Signup.this);
//                    db.addUsers(dao.userName(mail),mail);
//                    Intent intent = new Intent(Signup.this,Home.class);
//                    startActivity(intent);
//                }else{
//                    Toast.makeText(Signup.this, "Email already register", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }
}
