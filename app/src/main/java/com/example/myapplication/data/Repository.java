package com.example.myapplication.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.myapplication.model.User;
import com.example.myapplication.ui.Activities.HomeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;

public class Repository {
    private static Repository instance;

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseFirestore db=FirebaseFirestore.getInstance();
    public void login(Context context, String email, String password) {
        if (!email.equals("") && !password.equals("")) {
            mAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Toast.makeText(context, "Login Successfull ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, HomeActivity.class);
                    context.startActivity(intent);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(context, "Login Failed " + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void register(Activity activity, String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
            if(task.isSuccessful()){

                Intent intent=new Intent(activity,HomeActivity.class);
                activity.startActivity(intent);
                activity.finish();
                Toast.makeText(activity,"Congratulations , You Are Now One Of US :)",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(activity,"Registeration Failed"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();

            }
            }
        });
    }

  public void addUser(User user){
   db.collection("users")
           .add(user)
           .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
               @Override
               public void onSuccess(DocumentReference documentReference) {
               }
           }).addOnFailureListener(new OnFailureListener() {
       @Override
       public void onFailure(@NonNull Exception e) {

       }
   });
  }



}
