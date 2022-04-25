package br.edu.ifsp.dmo.ifitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView toolbarTitle;
    private DrawerLayout toolbarDrawer;

    private LinearLayout layoutIcomWalk;
    private LinearLayout layoutIcomRun;
    private LinearLayout layoutIcomSwim;
    private LinearLayout layoutIcomBike;

    private NavigationView navigationView;
    private TextView txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText(getString(R.string.app_name));

        toolbarDrawer = findViewById(R.id.nav_drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                toolbarDrawer, toolbar,  R.string.toggle_open, R.string.toggle_close);
        toolbarDrawer.addDrawerListener(toggle);

        toggle.syncState();

        Log.d("arthur", "onCreate ONE: " + navigationView);
        navigationView = findViewById(R.id.menu_nav_view);
        Log.d("arthur", "onCreate TWO: " + navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Intent intent = null;

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        intent = new Intent(MainActivity.this,
                                MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_user:
                        intent = new Intent(MainActivity.this,
                                UserProfileActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_category:
                        Toast.makeText(MainActivity.this, "Categorias",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_logout:
                        Toast.makeText(MainActivity.this, "Sair",
                                Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }

                toolbarDrawer.closeDrawer(GravityCompat.START);

                return true;
            }
        });


        txtLogin = navigationView.getHeaderView(0)
                .findViewById(R.id.header_profile_name);
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        UserLoginActivity.class);
                startActivity(intent);
            }
        });

        layoutIcomWalk = findViewById(R.id.ll_icon_walk);
        layoutIcomWalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        DetailSportActivity.class);
                intent.putExtra("title", getString(R.string.walking));
                startActivity(intent);
            }
        });

        layoutIcomWalk = findViewById(R.id.ll_icon_run);
        layoutIcomWalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        DetailSportActivity.class);
                intent.putExtra("title", getString(R.string.running));
                startActivity(intent);
            }
        });

        layoutIcomWalk = findViewById(R.id.ll_icon_swim);
        layoutIcomWalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        DetailSportActivity.class);
                intent.putExtra("title", getString(R.string.swimming));
                startActivity(intent);
            }
        });

        layoutIcomWalk = findViewById(R.id.ll_icon_bike);
        layoutIcomWalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        DetailSportActivity.class);
                intent.putExtra("title", getString(R.string.cycling));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(toolbarDrawer.isDrawerOpen(GravityCompat.START)){
            toolbarDrawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}