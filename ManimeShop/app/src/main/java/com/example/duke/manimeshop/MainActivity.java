package com.example.duke.manimeshop;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        // esto funciona si los fragments, es necesario
        implements NavigationView.OnNavigationItemSelectedListener, ProductosFragment.OnFragmentInteractionListener,VideosFragment.OnFragmentInteractionListener,GratisFragment.OnFragmentInteractionListener ,FormFragment.OnFragmentInteractionListener,SocialFragment.OnFragmentInteractionListener, DragonFragment.OnFragmentInteractionListener,NarutoFragment.OnFragmentInteractionListener,OnepieceFragment.OnFragmentInteractionListener,DigimonTriFragment.OnFragmentInteractionListener,registroFragment.OnFragmentInteractionListener,adminFragment.OnFragmentInteractionListener{
     String cadena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        cadena= getIntent().getStringExtra("dato");
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
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        Fragment fragment= new FormFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.content_main,fragment).commit();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //

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
        item.setTitle("Usuario");

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
                Toast.makeText(this,cadena, Toast.LENGTH_SHORT).show();
                return true;



        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        //esto es para que el fragment sea seleccionado
        int id = item.getItemId();
        Fragment miFragment=null;
        boolean fragentSeleccionado=false;
        if (id == R.id.nav_camera) {
            miFragment=new FormFragment();
            fragentSeleccionado=true;
        } else if (id == R.id.nav_gallery) {
            miFragment=new ProductosFragment();
            fragentSeleccionado=true;
        } else if (id == R.id.nav_slideshow) {
            miFragment=new VideosFragment();
            fragentSeleccionado=true;
        } else if (id == R.id.nav_manage) {
            miFragment=new GratisFragment();
            fragentSeleccionado=true;
        } else if (id == R.id.nav_share) {
            String url = "https://www.facebook.com/WeirDuke";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }

        if(fragentSeleccionado==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,miFragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
