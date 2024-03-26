package com.example.assignment_01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class screen2 extends AppCompatActivity {

    FragmentManager manager;
    FragmentTransaction transaction;
    Fragment f1, f2;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        manager = getSupportFragmentManager();

        // No need to begin transaction here

        f1 = new frag_1(); // Instantiate the fragment using its class name
        f2 = new frag_2(); // Instantiate the fragment using its class name

        // Use replace instead of add
        manager.beginTransaction().replace(R.id.frag1, f1).commit();
        manager.beginTransaction().replace(R.id.frag2, f2).commit();

        // No need to hide fragments initially

        b1 = findViewById(R.id.tab1);
        b2 = findViewById(R.id.tab2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Begin transaction each time
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.frag1, f1);
                transaction.commit();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Begin transaction each time
                FragmentTransaction transaction = manager.beginTransaction().hide(f1).show(f2);
                transaction.commit();


            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

