package com.example.tripadvisor;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOusers {
    private DatabaseReference databaseReference;
    public DAOusers(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference("User");
    }
    public Task<Void> addUser(User user){
        return databaseReference.push().setValue(user);
    }
}
