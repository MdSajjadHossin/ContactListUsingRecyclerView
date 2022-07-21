package com.example.recyclerviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContactModel> arrContact = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //calling constractor
//        ContactModel model = new ContactModel(R.drawable.a, "Md Sajjad Hossin","01790561194");

        //passing value to arrayList
        arrContact.add(new ContactModel(R.drawable.a, "Md Sajjad Hossin","01790561194"));
        arrContact.add(new ContactModel(R.drawable.b, "Md Sajid Hossin","01890561194"));
        arrContact.add(new ContactModel(R.drawable.c, "Md Asif Iquebal","01190561194"));
        arrContact.add(new ContactModel(R.drawable.d, "Md Sami Ahmed","01290561196"));
        arrContact.add(new ContactModel(R.drawable.e, "Md Fahim Ahmed","01390561197"));
        arrContact.add(new ContactModel(R.drawable.f, "Md Tanvir Ahmed","01490562294"));
        arrContact.add(new ContactModel(R.drawable.g, "Md Shakil Ahemd","01590651194"));
        arrContact.add(new ContactModel(R.drawable.h, "Md Jubayer Mia","01680563394"));
        arrContact.add(new ContactModel(R.drawable.i, "Md Jaber Mia","01760564494"));
        arrContact.add(new ContactModel(R.drawable.j, "Md Jahid Biswas","01890565594"));
        arrContact.add(new ContactModel(R.drawable.k, "Md Sujon Biswas","01990505594"));
        arrContact.add(new ContactModel(R.drawable.a, "Md Razon Biswas","01890441194"));
        arrContact.add(new ContactModel(R.drawable.b, "Md Tanvir Rahman","01590567796"));
        arrContact.add(new ContactModel(R.drawable.g, "Md Shakil Ahemd","01590651194"));
        arrContact.add(new ContactModel(R.drawable.h, "Md Jubayer Mia","01680563394"));
        arrContact.add(new ContactModel(R.drawable.i, "Md Jaber Mia","01760564494"));
        arrContact.add(new ContactModel(R.drawable.j, "Md Jahid Biswas","01890565594"));
        arrContact.add(new ContactModel(R.drawable.c, "Md Sujon Biswas","01990505594"));
        arrContact.add(new ContactModel(R.drawable.a, "Md Razon Biswas","01890441194"));
        arrContact.add(new ContactModel(R.drawable.avatar, "Md Tanvir Rahman","01590567796"));

        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this, arrContact);
        recyclerView.setAdapter(adapter);


    }
}