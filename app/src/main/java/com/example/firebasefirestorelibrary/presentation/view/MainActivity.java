package com.example.firebasefirestorelibrary.presentation.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.firebasefirestorelibrary.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.container_main, MainFragment.class, null)
                    .commit();
        }

    }
}