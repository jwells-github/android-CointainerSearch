package containersearch.jaked.containersearch;

import android.content.Intent;
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


public class SearchChoiceActivity extends AppCompatActivity  implements  ContainerServiceAdapter.Callbacks  {


    private static final String CONTAINER_NUMBER = "CONTAINER_NUMBER";
    private static final String WEB_ADDRESS = "WEB_ADDRESS";
    private static final String SERVICE_NAME = "SERVICE_NAME";
    private String containerNumber;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        Intent intent = getIntent();
        Bundle bundle = new Bundle();
        containerNumber = intent.getStringExtra(CONTAINER_NUMBER);
        bundle.putString(CONTAINER_NUMBER, containerNumber);


        mDrawerLayout = findViewById(R.id.drawer_layout);



        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                System.out.println("History pressed");
                switch (item.getItemId()){

                    case R.id.drawer_tracked_containers:

                        break;
                    case R.id.drawer_history:
                        item.setChecked(true);
                        System.out.println("History pressed");

                        Fragment fragment = new SearchHistoryFragment();
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragment_container, fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;
                    case R.id.drawer_options:

                        break;
                    case R.id.drawer_about:

                        break;
                }
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        SearchChoiceFragment searchChoiceFragment = new SearchChoiceFragment();
        searchChoiceFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.fragment_container, searchChoiceFragment).commit();

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

    @Override
    public void onServiceSelected(String serviceName, String url) {
        Fragment fragment = new WebTrackingFragment();
        Bundle bundle = new Bundle();
        bundle.putString(WEB_ADDRESS, url);
        bundle.putString(SERVICE_NAME, serviceName);
        bundle.putString(CONTAINER_NUMBER,containerNumber);
        fragment.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
