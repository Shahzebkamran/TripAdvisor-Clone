package com.example.tripadvisor;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOUser{
    private DatabaseReference dbRefrence;

    public void DAOUsers(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        dbRefrence = db.getReference("User");
    }
    public Task<Void> addUser(User user){
        return dbRefrence.push().setValue(user);
    }
//    boolean auth(String Email, String psswd){
//        getData();
//        if(users!= null){
//            for (int i = 0; i < users.size(); i++) {
//                if (Email == users.get(i).getUserEmail() && psswd == users.get(i).getPassword())
//                    return true;
//            }
//        }
//        return false;
//    }
//    String userName(String Email){
//        if(users!= null){
//            for(int i =0;i<users.size();i++){
//                if(Email==users.get(i).getUserEmail())
//                    return users.get(i).getUserName();
//            }
//        }
//        return "";
//    }
//    void getData(){
//        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();
//        dbRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                data = new ArrayList<Hashtable<String,String>>();
//                for(DataSnapshot snapshot1: snapshot.getChildren() ){
//                    GenericTypeIndicator<HashMap<String,Object>> type = new GenericTypeIndicator<HashMap<String, Object>>() {};
//                    HashMap<String,Object> map =  snapshot1.getValue(type);
//                    Hashtable<String,String> obj = new Hashtable<String,String>();
//                    for(String key : map.keySet()){
//                        obj.put(key,map.get(key).toString());
//                    }
//                    data.add(obj);
//                    for (String User: map.keySet()){
//                        String Name = snapshot1.child(User).child("useremail").getValue().toString();
//                        String Email = snapshot1.child(User).child("username").getValue().toString();
//                        String Password = snapshot1.child(User).child("Password").getValue().toString();
//                        User tempUser = new User(Name,Email,Password);
//                        users.add(tempUser);
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                System.out.print(error.getMessage());
//            }
//        });
//
//    }
}
