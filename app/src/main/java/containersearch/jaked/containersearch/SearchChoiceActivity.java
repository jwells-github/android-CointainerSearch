package containersearch.jaked.containersearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;


public class SearchChoiceActivity extends AppCompatActivity  implements  ContainerServiceAdapter.Callbacks  {

    private static final String CONTAINER_NUMBER = "CONTAINER_NUMBER";
    private static final String WEB_ADDRESS = "WEB_ADDRESS";
    private static final String SERVICE_NAME = "SERVICE_NAME";
    private String containerNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent intent = getIntent();
        Bundle bundle = new Bundle();
        containerNumber = intent.getStringExtra(CONTAINER_NUMBER);
        bundle.putString(CONTAINER_NUMBER, containerNumber);

        setContentView(R.layout.activity_fragment);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        SearchChoiceFragment searchChoiceFragment = new SearchChoiceFragment();
        searchChoiceFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.fragment_container, searchChoiceFragment).commit();

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
