package com.example.noteassignment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddNote extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    EditText et_note;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        et_note = findViewById(R.id.newNote);
        save = findViewById(R.id.saveNote);

        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String note = et_note.getText().toString();

                Map<String, Object> notes = new HashMap<>();
                if (!note.isEmpty()) {
                    notes.put("note", note);

                    db.collection("NewNote")
                            .add(notes)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Log.e("zzz", "Data added successfully to database" + documentReference.getId());
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.e("zzz", "Failed to add database",e);

                                }
                            });
                } else {
                    Log.e("zzz", "Failed");
                }
            }
        });

    }


}

