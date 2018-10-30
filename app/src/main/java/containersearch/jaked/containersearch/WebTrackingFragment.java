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
import android.widget.ProgressBar;

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
        String URL = getArguments().getString(WEB_ADDRESS);
        String ServiceName = getArguments().getString(SERVICE_NAME);
        String ContainerNumber = getArguments().getString(CONTAINER_NUMBER);

        final ProgressBar progressBar = v.findViewById(R.id.progressBar);

        final WebView webView = v.findViewById(R.id.webView);
        final String js = determineService(ContainerNumber, ServiceName);
        webView.setWebViewClient(new WebViewClient(){

            boolean b = true;
            @Override
            public void onPageFinished(WebView view, String url) {
                webView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
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
        webView.loadUrl(URL);

        RecordSaver recordSaver = new RecordSaver();
        recordSaver.addRecord(ContainerNumber,ServiceName, getContext());

        getActivity().setTitle(ServiceName);
        return v;
    }

    private String determineService(String containerNumber, String serviceName){
        String js = "";
        switch (serviceName){
            case "Mediterranean Shipping (MSC)":
                js  = "document.getElementById('ctl00_ctl00_plcMain_plcMain_TrackSearch_txtBolSearch_TextField').value='"+containerNumber+"';"
                    + "document.getElementById('ctl00_ctl00_plcMain_plcMain_TrackSearch_hlkSearch').click();";
                break;
            case "ACL":
                js = "document.getElementsByName('search_for')[0].value='"+containerNumber+"';";
                break;
            case "Alianca":
                // Services prevents scripting
                break;
            case "Beacon Intermodal":
                js  = "document.getElementById('txtLookupConId').value='"+containerNumber+"';"
                    + "document.getElementById('btnPublicLookup').click();";
                break;
            case "BMC Line":
                js  = "document.getElementById('container').value='"+containerNumber+"';";
                break;
            case "Bridgehead":
                js  = "document.getElementById('contNO').value='"+containerNumber+"';";
                break;
            case "CONCOR":
                js  = "document.getElementById('contno').value='"+containerNumber+"';"
                        + "document.getElementById('CONTButton1').click();";
                break;
            case "Crowley":
                js  = "document.getElementById('i1').value='"+containerNumber+"';";
                break;
            case "Dong Young Shipping":
                js  = "document.getElementById('number1').value='"+containerNumber+"';";
                break;
            case "Dongjin Shipping":
                js = "document.getElementsByName('search_word')[0].value='"+containerNumber+"';";
                break;
            case "DP World Nhava Sheva":
                js = "document.getElementsByName('containerNo')[0].value='"+containerNumber+"';";
                break;
            case "Emirates Shipping Line":
                js  = "document.getElementById('blsearch1').value='"+containerNumber+"';";
                break;
            case "Evergreen":
                js  = "document.getElementById('NO').value='"+containerNumber+"';";
                break;
            case "Finnlines":
                js  = "document.getElementById('ContentPlaceHolder_Main_ASPxPageControl1_TextBox_Shpmt').value='"+containerNumber+"';";
                break;
            case "Flexi-Van Leasing":
                js  = "document.getElementById('ctl00_FvContent_txtUnitInput').value='"+containerNumber+"';"
                        + "document.getElementById('ctl00_FvContent_btnUnitDetail').click();";
                break;
            case "Grimaldi":
                js  = "document.getElementById('ContentPlaceHolder_Main_ASPxPageControl1_TextBox_Shpmt').value='"+containerNumber+"';";
                break;
            case "Kambara Kisen":
                js  = "document.getElementById('searchName').value='"+containerNumber+"';";
                break;
            case "KiwiRail":
                js  = "document.getElementById('container-wagon-number').value='"+containerNumber+"';";
                break;
            case "MACS":
                js  = "document.getElementById('cnumber').value='"+containerNumber+"';"
                    + "document.getElementById('view').click();";
                break;
            case "Marfret":
                js  = "document.getElementById('suivi_conteneur').value='"+containerNumber+"';";
                break;
            case "Matson":
                js  = "document.getElementById('containerNumber').value='"+containerNumber+"';";
                break;
            case "Meratus Line":
                js  = "document.getElementById('ctl00_ContentPane_TxtFind').value='"+containerNumber+"';";
                break;
            case "Namsung":
                js  = "document.getElementById('cntrNo').value='"+containerNumber+"';";
                break;
            case "NileDutch":
                js  = "document.getElementById('ContainerNumber').value='"+containerNumber+"';"
                        + "document.getElementById('advancedTrackingSubmit').click();";
                break;
            case "NYK Line":
            case "ONE":
                js  = "document.getElementById('searchName').value='"+containerNumber+"';";
                break;
            case "Ocean World Lines":
                js  = "document.getElementById('containernumber').value='"+containerNumber+"';";
                break;
            case "Pan Asia Line":
                js  = "document.getElementById('txtContainerNo').value='"+containerNumber+"';"
                        + "document.getElementById('cmdShow').click();";
                break;
            case "Pan Continental Shipping":
                js  = "document.getElementById('I_AS_ARGU1').value='"+containerNumber+"';"
                        + "document.getElementById('WEB_212_INQ').click();";
                break;
            case "Pasha Hawaii":
                js  = "document.getElementById('SearchTerm').value='"+containerNumber+"';";
                break;
            case "PSL Navegação":
                js  = "document.getElementById('refnumbers').value='"+containerNumber+"';"
                        + "document.getElementById('button').click();";
                break;
            case "Sarjak Container Lines":
                js  = "document.getElementById('txtsearchB').value='"+containerNumber+"';"
                        + "document.getElementById('ibsearch').click();";
                break;
            case "Seaco":
                js  = "document.getElementById('idTAUnitNo').value='"+containerNumber+"';"
                        + "document.getElementById('idBtnUnitEnqSubmit').click();";
                break;
            case "SeaCube":
                js  = "document.getElementById('txtLookupConId').value='"+containerNumber+"';"
                        + "document.getElementById('btnPublicLookup').click();";
                break;
            case "T.S. Lines":
                js  = "document.getElementById('TextBox1').value='"+containerNumber+"';"
                        + "document.getElementById('Button1').click();";
                break;
            case "Textainer":
                js  = "document.getElementById('ctl00_bodyContent_ucEqpIds_txtEqpId').value='"+containerNumber+"';"
                        + "document.getElementById('ctl00_bodyContent_btnSubmit').click();";
                break;
            case "The China Navigation Company":
                js  = "document.getElementById('MainContent_txtTackandTrace').value='"+containerNumber+"';"
                        + "document.getElementById('MainContent_btnTrace').click();";
                break;
            case "Touax":
                js  = "document.getElementById('app_unitenquiry_filter_container_numbers').value='"+containerNumber+"';";
                break;
            case "Triton International":
                js  = "document.getElementById('unitNumbers').value='"+containerNumber+"';";
                break;
        }
        return js;
    }
}
