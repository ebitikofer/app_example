package com.example.e.permaguru;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int RC_SIGN_IN = 123;

    private List<Date> dates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //https://firebase.google.com/docs/auth/
        //https://github.com/firebase/FirebaseUI-Android/tree/master/auth#ui-customization

        FirebaseAuth auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);

            ImageButton profilePicture = (ImageButton) navigationView.getHeaderView(0).findViewById(R.id.profilePicture);
            profilePicture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent profileEntry = new Intent(MainActivity.this, ProfileActivity.class);
                    //plantEntry.putExtra("Bar", daySelected);
                    startActivity(profileEntry);
                }
            });

            TextView name = (TextView) findViewById(R.id.textView1);
            TextView email = (TextView) findViewById(R.id.textView);

            //https://firebase.google.com/docs/auth/android/manage-users#get_the_currently_signed-in_user

            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user != null) {
                // Name, email address, and profile photo Url
                //String fname = user.getDisplayName();
                //String femail = user.getEmail();
                //Url photoUrl = user.getPhotoUrl();

            //     name.setText(fname);
            //    email.setText(femail);

            }

            dates = new ArrayList<>();
            dates.add(new Date(4, 5, 18, "act 1", "lorem ipsum",4));
            dates.add(new Date(5, 5, 18, "act 2", "lorem ipsum",5));
            dates.add(new Date(6, 5, 18, "act 3", "lorem ipsum",6));
            dates.add(new Date(7, 5, 18, "act 4", "lorem ipsum",7));
            dates.add(new Date(8, 5, 18, "act 5", "lorem ipsum",8));
            dates.add(new Date(4, 5, 18, "act 1", "lorem ipsum",4));
            dates.add(new Date(5, 5, 18, "act 2", "lorem ipsum",5));
            dates.add(new Date(6, 5, 18, "act 3", "lorem ipsum",6));
            dates.add(new Date(7, 5, 18, "act 4", "lorem ipsum",7));
            dates.add(new Date(8, 5, 18, "act 5", "lorem ipsum",8));
            dates.add(new Date(4, 5, 18, "act 1", "lorem ipsum",4));
            dates.add(new Date(5, 5, 18, "act 2", "lorem ipsum",5));
            dates.add(new Date(6, 5, 18, "act 3", "lorem ipsum",6));
            dates.add(new Date(7, 5, 18, "act 4", "lorem ipsum",7));
            dates.add(new Date(8, 5, 18, "act 5", "lorem ipsum",8));
            dates.add(new Date(4, 5, 18, "act 1", "lorem ipsum",4));
            dates.add(new Date(5, 5, 18, "act 2", "lorem ipsum",5));
            dates.add(new Date(6, 5, 18, "act 3", "lorem ipsum",6));
            dates.add(new Date(7, 5, 18, "act 4", "lorem ipsum",7));
            dates.add(new Date(8, 5, 18, "act 5", "lorem ipsum",8));

            RecyclerView calendar = (RecyclerView)findViewById(R.id.calendar);
            LinearLayoutManager manager = new LinearLayoutManager(this);
            calendar.setLayoutManager(manager);

            RecycleAdapter adapter = new RecycleAdapter(dates);
            calendar.setAdapter(adapter);


        } else {

            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            //.setAvailableProviders(
                            //        Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build()))
                            .build(),
                    RC_SIGN_IN);

        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_logout) {
            AuthUI.getInstance()
                    .signOut(this)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(@NonNull Task<Void> task) {
                            startActivityForResult(
                                    AuthUI.getInstance()
                                            .createSignInIntentBuilder()
                                            .setAvailableProviders(
                                                    Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                                            new AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build()))
                                            .build(),
                                    RC_SIGN_IN);
                        }
                    });

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.nav_camera) {

            Intent planEntry = new Intent(MainActivity.this, PlanActivity.class);
            //plantEntry.putExtra("Bar", daySelected);
            startActivity(planEntry);
            //} else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_gallery) {

            Intent plantEntry = new Intent(MainActivity.this, PlantActivity.class);
            //plantEntry.putExtra("Bar", daySelected);
            startActivity(plantEntry);
        //} else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

            Intent plantEntry = new Intent(MainActivity.this, PlantActivity.class);
            //plantEntry.putExtra("Bar", daySelected);
            startActivity(plantEntry);
            //} else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_share) {

            Intent plantEntry = new Intent(MainActivity.this, PlantActivity.class);
            //plantEntry.putExtra("Bar", daySelected);
            startActivity(plantEntry);
            //} else if (id == R.id.nav_slideshow) {

        } //else if (id == R.id.nav_send) {

        //}

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
