package containersearch.jaked.containersearch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;

import containersearch.jaked.containersearch.database.DatabaseReader;
import containersearch.jaked.containersearch.database.RecordSaver;

public class WebTrackingFragment extends Fragment {


    private static final String WEB_ADDRESS = "WEB_ADDRESS";
    private static final String SERVICE_NAME = "SERVICE_NAME";
    private static final String CONTAINER_NUMBER = "CONTAINER_NUMBER";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_webview, container, false);
        String mURL = getArguments().getString(WEB_ADDRESS);
        String mServiceName = getArguments().getString(SERVICE_NAME);
        String mContainerNumber = getArguments().getString(CONTAINER_NUMBER);
        WebView webView = v.findViewById(R.id.webView);
        final String js = determineService(mContainerNumber, mServiceName);
        webView.setWebViewClient(new WebViewClient(){

            boolean b = true;
            @Override
            public void onPageFinished(WebView view, String url) {

                super.onPageFinished(view, url);
                if (b){
                    b = false;
                    view.evaluateJavascript(js, new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String s) {

                        }
                    });
                }


            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        // For zoom
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        // for javascript
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl(mURL);

        RecordSaver recordSaver = new RecordSaver();
        recordSaver.addRecord(mContainerNumber,mServiceName, getContext());
        DatabaseReader databaseReader = new DatabaseReader();
        ArrayList<String[]> searches = databaseReader.DatabaseReader(getContext());

        for (String[] s : searches){
            System.out.println("Container number " + s[0] + " service " + s[1] + " date " + s[2] );
        }
        return v;
    }

    private String determineService(String containerNumber, String serviceName){
        String js = "";
        switch (serviceName){
            case "Mediterranean Shipping (MSC)":
                js  = "document.getElementById('ctl00_ctl00_plcMain_plcMain_TrackSearch_txtBolSearch_TextField').value='"+containerNumber+"';"
                    + "document.getElementById('ctl00_ctl00_plcMain_plcMain_TrackSearch_hlkSearch').click();";
                break;

        }
        return js;
    }
}
