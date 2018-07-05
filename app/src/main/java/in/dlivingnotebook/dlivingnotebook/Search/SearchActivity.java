package in.dlivingnotebook.dlivingnotebook.Search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import in.dlivingnotebook.dlivingnotebook.R;
import in.dlivingnotebook.dlivingnotebook.utils.BottomNavigationViewHelper;

public class SearchActivity extends AppCompatActivity {
    private static final String TAG = "SearchActivity";
    private static final int ACTIVITY_NO=1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: created");
        setupBottomNavigationView();
    }

    /**
     * Bottom Navigation View Setup
     */
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: Setting up navigation view");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(SearchActivity.this, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem item = menu.getItem(ACTIVITY_NO);
        item.setChecked(true);

    }
}
