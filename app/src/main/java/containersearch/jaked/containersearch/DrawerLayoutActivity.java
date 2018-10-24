package containersearch.jaked.containersearch;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class DrawerLayoutActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Boolean fragmentOnStack = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fragment);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        final NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if(item.isChecked()){
                    return false;
                }

                Fragment fragment = null;
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (item.getItemId()){

                    case R.id.drawer_container_search:
                        fm.popBackStack();
                        fragmentOnStack = false;
                        break;
                    case R.id.drawer_history:
                        fragment = new SearchHistoryFragment();

                        break;
                    case R.id.drawer_options:

                        break;
                    case R.id.drawer_about:
                        fragment = new AboutPageFragment();
                        break;
                }
                if (fragment != null){
                    transaction.replace(R.id.fragment_container, fragment);
                    if(!fragmentOnStack){
                        transaction.addToBackStack(null);
                        fragmentOnStack = true;
                    }
                    else{
                        fm.popBackStack();
                        transaction.addToBackStack(null);
                    }

                    transaction.commit();
                }

                for (int i = 0; i < navigationView.getMenu().size(); i++) {
                    navigationView.getMenu().getItem(i).setChecked(false);
                }
                mDrawerLayout.closeDrawers();
                item.setChecked(true);
                return true;
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        final NavigationView navigationView = findViewById(R.id.nav_view);
        for (int i = 0; i < navigationView.getMenu().size(); i++) {
            navigationView.getMenu().getItem(i).setChecked(false);
        }
        navigationView.getMenu().getItem(0).setChecked(true);
        setTitle(getResources().getString(R.string.app_name));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
