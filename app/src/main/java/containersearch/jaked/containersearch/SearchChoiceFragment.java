package containersearch.jaked.containersearch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SearchChoiceFragment extends Fragment {

    private ContainerNumber mContainerNumber;



    public TreeMap<String, String> serviceMap;
    public TreeMap<String, String> suggestedMap;

    private static final String CONTAINER_NUMBER = "CONTAINER_NUMBER";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.as, container, false);
        mContainerNumber = new ContainerNumber(getArguments().getString(CONTAINER_NUMBER));
        setTreeMap();

        ArrayList<String> valueArray = new ArrayList<String>(serviceMap.values());
        ArrayList<String> keyArray = new ArrayList<String>(serviceMap.keySet());

        suggestedServices();

        //WebView webView = v.findViewById(R.id.suggestedWebview);
        //webView.loadUrl(suggestedMap.get(suggestedMap.firstKey()));
        ArrayList<String> suggestedValueArray = new ArrayList<String>(suggestedMap.values());
        ArrayList<String> suggestedKeyArray = new ArrayList<String>(suggestedMap.keySet());
        final ContainerServiceAdapter suggestedServiceAdapter = new ContainerServiceAdapter(getContext(), suggestedKeyArray, suggestedValueArray);
        ListView listViewSuggested = v.findViewById(R.id.lvSuggested);
        listViewSuggested.setAdapter(suggestedServiceAdapter);


        final ContainerServiceAdapter adapter = new ContainerServiceAdapter(getContext(), keyArray, valueArray);
        ListView listViewAllServices = v.findViewById(R.id.lvAll);
        listViewAllServices.setAdapter(adapter);




        return v;
    }

    private void setTreeMap(){
        serviceMap = new TreeMap<String, String>() {{
            put("ACL", "");
            put("Alianca", "");
            put("Allalouf","");
            put("ANL", "");
            put("APL", "");
            put("Arkas Line", "");
            put("Avana Logistek", "");
            put("Beacon Intermodal", "");
            put("Blue Sky", "");
            put("BMC Line", "");
            put("Bridgehead", "");
            put("CAI", "");
            put("Canadian National Railway", "");
            put("Canadian Pacific Railway", "");
            put("CARU containers", "");
            put("CMA CGM", "");
            put("CNC Line", "");
            put("CONCOR", "");
            put("Cosco Shipping Lines" , "");
            put("Crowley", "");
            put("CULlines", "");
            put("DAL" , "");
            put("DB Schenker", "");
            put("DHL" , "");
            put("Dong Young Shipping", "");
            put("Dongjin Shipping", "");
            put("DP World Nhava Sheva", "");
            put("Econ Shipping", "");
            put("ECU Worldwide", "");
            put("Emirates Shipping Line", "");
            put("Emkay Line", "");
            put("ESL", "");
            put("Evergreen", "");
            put("FESCO", "");
            put("Finnlines","");
            put("Flexi-Van Leasing","");
            put("Florens","");
            put("Focus Trucking","");
            put("Gold Star Line","");
            put("Grimaldi","");
            put("Hamburg Süd","");
            put("Hapag-Lloyd","");
            put("HDASCO Line","");
            put("Heung-A Shipping","");
            put("Hyundai (HMM)", "https://www.hmm21.com/cms/business/ebiz/trackTrace/trackTrace/index.jsp?numbers=" +
                    "&numbers=&numbers=&numbers=&numbers=&numbers=&numbers=&numbers=&numbers=&numbers=&numbers=&numbers=&numbers=" +
                    "&is_quick=Y&quick_params=&type=2&number=" + mContainerNumber.getContainerNumber() + "&submit.x=21&submit.y=10");
            put("Italia Marittima","");
            put("K-line","");
            put("Kambara Kisen","");
            put("KiwiRail","");
            put("Korea Marine Transport","");
            put("Kuehne + Nagel","");
            put("Leschaco","");
            put("Linea Messina","");
            put("MACS","");
            put("Maersk Line","");
            put("Maldives Ports","");
            put("Marfret","");
            put("Mariana Express Lines","");
            put("Maritime United Operator","");
            put("Matson","");
            put("Maxicon Container Line","");
            put("MCC Transport","");
            put("Mediterranean Shipping","");
            put("Meratus Line","");
            put("Minsheng Ocean Shipping","");
            put("MOL now ONE","");
            put("Namsung","");
            put("NileDutch","");
            put("Nirint Shipping","");
            put("NYK Line","");
            put("Ocean Axis","");
            put("Ocean World Lines","");
            put("ONE","");
            put("OOCL","");
            put("OPDR","");
            put("Pacific Direct Line","");
            put("Pan Asia Line","");
            put("Pan Continental Shipping","");
            put("Pan Ocean","");
            put("Pasha Hawaii","");
            put("Perma Shipping Line","");
            put("PIL","");
            put("PSL Navegação","");
            put("RCL","");
            put("Safmarine","");
            put("Saigon Newport Corporation","");
            put("Samskip","");
            put("Samudera Shipping","");
            put("Sarjak Container Lines","");
            put("SCI","");
            put("Seaboard Marine","");
            put("Seaco","");
            put("SeaCube","");
            put("Seago Line","");
            put("Shreyas Relay System now Avana Logistek","");
            put("Sinokor Merchant Marine","");
            put("Sinotrans","");
            put("SITC","");
            put("SM Line","");
            put("Sofrana ANL","");
            put("SPIL","");
            put("St. John Freight Systems","");
            put("Sunmarine","");
            put("T.S. Lines","");
            put("Taiyoung Shipping","");
            put("Tanto","");
            put("Tarros","");
            put("Textainer","");
            put("The China Navigation Company","");
            put("TOTE Maritime","");
            put("Touax","");
            put("Trailer Bridge","");
            put("Trans Asia","");
            put("TransContainer","");
            put("Transmar","");
            put("Triton International","");
            put("Turkon Line","");
            put("UES International","");
            put("W.E.C. Lines","");
            put("Wan Hai Lines","");
            put("White Line","");
            put("WorldWide Alliance","");
            put("Yang Ming","");
            put("ZIM","");
            put("Zim World Freight","");

        }};
    }

    private void suggestedServices(){
        suggestedMap = new TreeMap<String, String>();
        String containerNumber = mContainerNumber.getContainerNumber();
        String serviceName;
        switch(containerNumber.substring(0,3)){
            case "HDM":
                serviceName = "Hyundai (HMM)";
                suggestedMap.put(serviceName,serviceMap.get(serviceName));


        }
    }



}
