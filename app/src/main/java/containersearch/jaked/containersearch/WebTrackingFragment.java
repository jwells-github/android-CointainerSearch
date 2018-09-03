package containersearch.jaked.containersearch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class WebTrackingFragment extends Fragment {


    private static final String WEB_ADDRESS = "CONTAINER_NUMBER";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_webview, container, false);
        String mURL = getArguments().getString(WEB_ADDRESS);
        WebView webView = v.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(mURL);



        return v;
    }
}
