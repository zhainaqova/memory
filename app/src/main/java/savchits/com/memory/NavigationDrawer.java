package savchits.com.memory;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

public class NavigationDrawer extends AppCompatActivity {
    DrawerLayout          drawerLayout;
    ActionBarDrawerToggle toggle;
    Toolbar               toolbar;
    public NavigationView        navigationView;
    Button nav_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.drawer_layout);
        drawerLayout = findViewById (R.id.drawer);
        navigationView = findViewById (R.id.nav_view);
        toolbar = findViewById (R.id.toolBar);
        setSupportActionBar (toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toggle = new ActionBarDrawerToggle( this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener (toggle);
        toggle.syncState();

        changeFragment (new LevelPage());

        navigationView.setNavigationItemSelectedListener ( new NavigationView.OnNavigationItemSelectedListener () {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId ();
                switch (id) {
                    case R.id.share:
                        Intent i = new Intent (Intent.ACTION_SEND);
                        i.setType ("text/plain");
                        i.putExtra ( Intent.EXTRA_SUBJECT,"Title");
                        String message = "App Link";
                        i.putExtra ( Intent.EXTRA_TEXT,message);
                        startActivity ( Intent.createChooser ( i,"share"));
                        break;
                    case R.id.star:
                        break;
                    case R.id.write:
                        break;
                    case R.id.apps:
                        break;

                    default:
                        return  true;
                }
                return  true;
            }
        });
    }
    public void changeFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager ().beginTransaction ();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }
}
