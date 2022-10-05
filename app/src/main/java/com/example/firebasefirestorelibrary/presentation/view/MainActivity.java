package com.example.firebasefirestorelibrary.presentation.view;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.firebasefirestorelibrary.R;
import com.example.firebasefirestorelibrary.data.net.RestApi;
import com.example.firebasefirestorelibrary.data.net.RestApiImpl;
import com.example.firebasefirestorelibrary.presentation.model.BookShortInfoModel;
import com.example.firebasefirestorelibrary.util.JsonParser;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

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