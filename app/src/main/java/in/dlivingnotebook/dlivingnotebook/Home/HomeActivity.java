package in.dlivingnotebook.dlivingnotebook.Home;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import in.dlivingnotebook.dlivingnotebook.R;
import in.dlivingnotebook.dlivingnotebook.utils.BottomNavigationViewHelper;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "DLN_HomeActivity";
    private static final int ACTIVITY_NO=0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: starting the application");
        setupBottomNavigationView();
        setUpViewPager();
    }

    /**
     * Responsible for adding three tabs: camera, home, messages
     */
    private void setUpViewPager(){
        SectionPagerAdapter pagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new CameraFragment()); //First Fragmanent as per UI
        pagerAdapter.addFragment(new HomeFragment()); //Second Fragment as per UI
        pagerAdapter.addFragment(new MessagesFragment()); //Third Fragment as per UI

        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);// Index 0
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_notebook);// Index 1
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_arrow);// Index 2
    }

    /**
     * Bottom Navigation View Setup
     */
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: Setting up navigation view");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(HomeActivity.this, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem item = menu.getItem(ACTIVITY_NO);
        item.setChecked(true);

    }
}
