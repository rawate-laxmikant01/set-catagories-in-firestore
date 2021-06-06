package com.example.catagories;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<CatagoriesModel> list;
    CatagoriesAdapter catagoriesAdapter;
    FirebaseFirestore firestore;
    CollectionReference reference;

    //Catagoires

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycelerView);
        list=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, true));

        firestore=FirebaseFirestore.getInstance();
        reference=firestore.collection("Catagoires");

       reference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
           @Override
           public void onComplete(@NonNull Task<QuerySnapshot> task) {
               if (task.isSuccessful()) {
                   for (QueryDocumentSnapshot dataSnapshot : task.getResult()) {
                       list.add(new CatagoriesModel(dataSnapshot.get("img").toString(), dataSnapshot.get("name").toString()));
                       //  CatagoriesAdapter.notifydatasetchangle();
                   }
                   catagoriesAdapter = new CatagoriesAdapter(list, MainActivity.this);
                   recyclerView.setAdapter(catagoriesAdapter);

               }
           }
       }).addOnFailureListener(new OnFailureListener() {
           @Override
           public void onFailure(@NonNull Exception e) {
               Toast.makeText(MainActivity.this, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
           }
       });

    }
}