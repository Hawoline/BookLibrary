package com.example.firebasefirestorelibrary.presentation.view;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.firebasefirestorelibrary.R;
import com.example.firebasefirestorelibrary.data.net.RestApi;
import com.example.firebasefirestorelibrary.data.net.RestApiImpl;
import com.example.firebasefirestorelibrary.util.Constants;
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
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);

            Callable<String> callable = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    RestApi restApi = new RestApiImpl(MainActivity.this);
                    return restApi.searchBooks(query);
                }
            };

            FutureTask<String> future = new FutureTask<>(callable);
            new Thread(future).start();
            try {
                Log.d(Constants.LOG_TAG, future.get());
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                Toast.makeText(MainActivity.this, "query execution is interrupted", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull @NotNull Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);

        return true;

    }
}