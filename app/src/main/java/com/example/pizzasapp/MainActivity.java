package com.example.pizzasapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        Toolbar toolbars = findViewById(R.id.toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        Button btn_continuar = findViewById(R.id.btn_continuar);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        setSupportActionBar(toolbars);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();

                if (itemId == R.id.drawer_inicio) {
                    displayToast(getString(R.string.drawer_act_inicio));
                    return true;
                } else if (itemId == R.id.drawer_paquetes) {
                    displayToast(getString(R.string.drawer_act_paquetes));
                    return true;
                } else if (itemId == R.id.drawer_promociones) {
                    displayToast(getString(R.string.drawer_act_promociones));
                    return true;
                } else if (itemId == R.id.drawer_contacto) {
                    displayToast(getString(R.string.drawer_act_contacto));
                    return true;
                }

                return false;
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbars, R.string.app_name,
                R.string.app_name);
        if (drawer != null) {
            drawer.addDrawerListener(toggle);
        }
        toggle.syncState();

        btn_continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OrdenarActivity.class);
                startActivity(intent);
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.actionbar_carrito) {
            displayToast(getString(R.string.actionbar_act_carrito));
            return true;
        } else if (id == R.id.actionbar_favoritos) {
            displayToast(getString(R.string.actionbar_favoritos));
            return true;
        } else if (id == R.id.actionbar_ubicacion) {
            displayToast(getString(R.string.actionbar_act_ubicacion));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,Toast.LENGTH_SHORT).show();
    }
}