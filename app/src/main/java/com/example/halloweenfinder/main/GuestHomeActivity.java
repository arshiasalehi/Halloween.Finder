package com.example.halloweenfinder.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.halloweenfinder.R;
import com.example.halloweenfinder.guest_fragments.PartyListFragment;
import com.example.halloweenfinder.guest_fragments.HistoryFragment;
import com.example.halloweenfinder.shared_fragments.ConversationFragment;
import com.example.halloweenfinder.shared_fragments.MapFragment;

public class GuestHomeActivity extends AppCompatActivity {

    private LinearLayout partyListButton, reviewButton, conversationRoomButton, mapButton, hostBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_guest_home);

        // Initialize buttons
        partyListButton = findViewById(R.id.partyListButton);
        reviewButton = findViewById(R.id.reviewButton);
        conversationRoomButton = findViewById(R.id.conversationRoomButton);
        mapButton = findViewById(R.id.mapButton);
        hostBtn = findViewById(R.id.hostButton);


        // Set default fragment (optional)
        loadFragment(new PartyListFragment());

        // Set click listeners for buttons
        partyListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new PartyListFragment());
            }
        });

        reviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadFragment(new HistoryFragment());
            }
        });

        conversationRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadFragment(new ConversationFragment());
            }
        });

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to MapFragment
                loadFragment(new MapFragment());
            }
        });

        hostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to HostHomeActivity
                Intent intent = new Intent(GuestHomeActivity.this, HostHomePage.class);
                startActivity(intent);
            }
        });
    }

    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
    }
}
