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

public class WebTrackingFragment extends Fragment {


    private static final String WEB_ADDRESS = "WEB_ADDRESS";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_webview, container, false);
        String mURL = getArguments().getString(WEB_ADDRESS);

        WebView webView = v.findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient(){

            boolean b = true;
            @Override
            public void onPageFinished(WebView view, String url) {

                super.onPageFinished(view, url);
                String containerNumber = "MSCU3651213";
                String js = "javascript:var uselessvar =document.getElementById('ctl00_ctl00_plcMain_plcMain_TrackSearch_txtBolSearch_TextField').value='"+containerNumber+"';"
                            + "javascript:var uselessvar =document.getElementById('ctl00_ctl00_plcMain_plcMain_TrackSearch_hlkSearch').click();" ;


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

        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);

        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

        // for javascript
        webView.getSettings().setDomStorageEnabled(true);

        webView.loadUrl(mURL);


        System.out.println("url loaded");

        return v;
    }
}
