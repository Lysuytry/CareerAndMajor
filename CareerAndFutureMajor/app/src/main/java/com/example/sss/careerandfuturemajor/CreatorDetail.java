package com.example.sss.careerandfuturemajor;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Ly Suytry on 8/22/2016.
 */
public class CreatorDetail extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        ArrayList<Creator> c=new ArrayList<Creator>();
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvcCreator);
            // Initialize contacts
            // Create adapter passing in the sample user data
        c.add(new Creator("Ly SuyTry","092 500 733","Suytry Ly",R.mipmap.ic_launcher));
        c.add(new Creator("Te SoPheak","096 347 363","Sopheak Te",R.mipmap.ic_launcher));
        c.add(new Creator("Yoeu Samrith","010 849 331","Samrith Yeou",R.mipmap.ic_launcher));
        RVCadpaterCreator adapter = new RVCadpaterCreator(this,c);
            // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        rvContacts.setHasFixedSize(true);
            // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
            // That's all!
    }
}
