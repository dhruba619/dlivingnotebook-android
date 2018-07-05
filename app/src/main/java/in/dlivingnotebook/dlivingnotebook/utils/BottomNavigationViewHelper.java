package in.dlivingnotebook.dlivingnotebook.utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import in.dlivingnotebook.dlivingnotebook.Home.HomeActivity;
import in.dlivingnotebook.dlivingnotebook.Like.LikeActivity;
import in.dlivingnotebook.dlivingnotebook.Profile.ProfileActivity;
import in.dlivingnotebook.dlivingnotebook.R;
import in.dlivingnotebook.dlivingnotebook.Search.SearchActivity;
import in.dlivingnotebook.dlivingnotebook.Share.ShareActivity;

/**
 *
 */
public class BottomNavigationViewHelper {
    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        Log.d(TAG, "setupBottomNavigationView: Setting up bottom navigation view");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.ic_house:
                        Intent homeIntent = new Intent(context, HomeActivity.class); //ACTIVITY_NO=0
                        context.startActivity(homeIntent);
                        break;

                    case R.id.ic_search:
                        Intent searchIntent = new Intent(context, SearchActivity.class); //ACTIVITY_NO=1
                        context.startActivity(searchIntent);
                        break;

                    case R.id.ic_circle:
                        Intent circleIntent = new Intent(context, ShareActivity.class); //ACTIVITY_NO=2
                        context.startActivity(circleIntent);
                        break;

                    case R.id.ic_alert:
                        Intent likeIntent = new Intent(context, LikeActivity.class); //ACTIVITY_NO=3
                        context.startActivity(likeIntent);
                        break;

                    case R.id.ic_android:
                        Intent profileIntent = new Intent(context, ProfileActivity.class); //ACTIVITY_NO=4
                        context.startActivity(profileIntent);
                        break;
                }
                return false;
            }
        });

    }
}
