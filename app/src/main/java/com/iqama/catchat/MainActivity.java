package com.iqama.catchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Set;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    NavController navController;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         toolbar = findViewById(R.id.toolBar);
         navigationView = findViewById(R.id.nav_view);
         drawerLayout= findViewById(R.id.drawerLayout);
         bottomNavigationView = findViewById(R.id.bottom_nav);
        setSupportActionBar(toolbar);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

         navController = navHostFragment.getNavController();

        NavInflater navInflater = navHostFragment.getNavController().getNavInflater();

        NavGraph navGraph = navInflater.inflate(R.navigation.nav_graph);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration
                .Builder(R.id.inboxFragment,R.id.helpFragment,R.id.sentItemFragment)
                .setOpenableLayout(drawerLayout)
                .build();


        NavigationUI.setupWithNavController(toolbar,navController,appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView,navController);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_toolbar,menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        NavController navController = Navigation.findNavController(this,R.id.nav_host_fragment);

        return NavigationUI.onNavDestinationSelected(item,navController)||
                super.onOptionsItemSelected(item);
    }
}