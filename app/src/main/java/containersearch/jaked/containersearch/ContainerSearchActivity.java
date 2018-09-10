package containersearch.jaked.containersearch;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ContainerSearchActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fragment);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);


        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        ContainerSearchFragment containerSearchFragment = new ContainerSearchFragment();
        fragmentTransaction.add(R.id.fragment_container, containerSearchFragment).commit();

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

/*

    setContentView(R.layout.fragment_webview);
    final WebView mWebview = (WebView) findViewById(R.id.webView);
        System.out.println("VALUE OF a "  + (int) 'a');
                System.out.println("VALUE OF c "  + (int) 'c');

                ContainerNumber containerNumber = new ContainerNumber("HMCU1090544");
                System.out.println(containerNumber.isValid());
                mWebview.getSettings().setJavaScriptEnabled(true);
                mWebview.loadUrl("https://www.hmm21.com/cms/business/ebiz/trackTrace/trackTrace/index.jsp?numbers=&numbers=&numbers=&numbers=&numbers=&numbers=&numbers=&numbers=&numbers=&numbers=&numbers=&numbers=&numbers=&is_quick=Y&quick_params=&type=2&number=HDMU5584547&submit.x=21&submit.y=10");
                mWebview.setFindListener(new WebView.FindListener() {
@Override
public void onFindResultReceived(int i, int i1, boolean b) {
        if(b){
        System.out.println("Matches " + i1);
        if(i1 > 0){
        mWebview.setVisibility(View.VISIBLE);
        }
        }

        }
        });

        ;
        mWebview.setWebViewClient(new WebViewClient(){
@Override
public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        view.findAllAsync("Tracking Results");
        }
        });*/
