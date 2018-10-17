package containersearch.jaked.containersearch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.TreeMap;

public class SearchChoiceFragment extends Fragment {

    private ContainerNumber mContainerNumber;



    public TreeMap<String, String> serviceMap;
    public TreeMap<String, String> suggestedMap;

    private static final String CONTAINER_NUMBER = "CONTAINER_NUMBER";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search_choice, container, false);
        mContainerNumber = new ContainerNumber(getArguments().getString(CONTAINER_NUMBER));

        serviceMap = mContainerNumber.getServiceMap();

        ArrayList<String> valueArray = new ArrayList<String>(serviceMap.values());
        ArrayList<String> keyArray = new ArrayList<String>(serviceMap.keySet());

        suggestedServices();

        //WebView webView = v.findViewById(R.id.suggestedWebview);
        //webView.loadUrl(suggestedMap.get(suggestedMap.firstKey()));
        ArrayList<String> suggestedValueArray = new ArrayList<String>(suggestedMap.values());
        ArrayList<String> suggestedKeyArray = new ArrayList<String>(suggestedMap.keySet());
        if(suggestedMap.keySet().size() > 0){
            final ContainerServiceAdapter suggestedServiceAdapter = new ContainerServiceAdapter(getContext(), suggestedKeyArray, suggestedValueArray);
            ListView listViewSuggested = v.findViewById(R.id.lvSuggested);
            listViewSuggested.setAdapter(suggestedServiceAdapter);
        }



        final ContainerServiceAdapter adapter = new ContainerServiceAdapter(getContext(), keyArray, valueArray);
        ListView listViewAllServices = v.findViewById(R.id.lvAll);
        listViewAllServices.setAdapter(adapter);


        return v;
    }

    private void setTreeMap(){

        final String containerNumber = mContainerNumber.getContainerNumber();
        serviceMap = new TreeMap<String, String>() {{
            put("ACL", "");
            put("Alianca", "");
            put("Allalouf","");
            put("ANL", "");
            put("APL", "https://homeport.apl.com/gentrack/trackingMain.do?trackInput01="+containerNumber);
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
            put("CMA CGM", "https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Container&Reference="+containerNumber);
            put("CNC Line", "");
            put("CONCOR", "");
            put("Cosco Shipping Lines" , "http://elines.coscoshipping.com/ebusiness/cargoTracking?trackingType=CONTAINER&number="+containerNumber);
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
                    "&is_quick=Y&quick_params=&type=2&number=" + containerNumber + "&submit.x=21&submit.y=10");
            put("Italia Marittima","");
            put("K-line","");
            put("Kambara Kisen","");
            put("KiwiRail","");
            put("Korea Marine Transport","");
            put("Kuehne + Nagel","");
            put("Leschaco","");
            put("Linea Messina","");
            put("MACS","");
            put("Maersk Line","https://www.maersk.com/tracking/#tracking/"+containerNumber);
            put("Maldives Ports","");
            put("Marfret","");
            put("Mariana Express Lines","");
            put("Maritime United Operator","");
            put("Matson","");
            put("Maxicon Container Line","");
            put("MCC Transport","");
            put("Mediterranean Shipping (MSC)","https://www.msc.com/track-a-shipment");
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
            put("OOCL","http://www.oocl.com/Pages/ExpressLink.aspx?eltype=ct&bl_no=&cont_no="+ containerNumber +"&booking_no=");
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
            put("Yang Ming","https://www.yangming.com/e-service/track_trace/mul_ctnr.aspx?str="+ containerNumber +",&rdolType=CT");
            put("ZIM","");
            put("Zim World Freight","");

        }};
    }

    private void suggestedServices(){
        suggestedMap = new TreeMap<String, String>();
        String containerNumber = mContainerNumber.getContainerNumber().toUpperCase();
        String serviceName;
        System.out.println("containernumber " + containerNumber);
        switch(containerNumber.substring(0,3)){
            case "HDM":
                serviceName = "Hyundai (HMM)";
                suggestedMap.put(serviceName,serviceMap.get(serviceName));
                break;
            case "OOc":
            case "OOL":
                serviceName = "OOCL";
                suggestedMap.put(serviceName, serviceMap.get(serviceName));
                break;
            case "MSC":
            case "MSD":
            case "MSM":
            case "MSP":
            case "MSZ":
            case "GTI":
            case "MED":
            case "MSY":
                serviceName = "Mediterranean Shipping (MSC)";
                suggestedMap.put(serviceName, serviceMap.get(serviceName));
                break;
            case "MCI":
                serviceName = "Maersk Line";
                suggestedMap.put(serviceName, serviceMap.get(serviceName));
                break;
            case "STM":
                serviceName = "CMA CGM";
                suggestedMap.put(serviceName, serviceMap.get(serviceName));
                break;

            case "APD":
                serviceName = "APL";
                suggestedMap.put(serviceName, serviceMap.get(serviceName));
                break;
            case "CCL":
            case "CSL":
            case "CSN":
                serviceName = "Cosco Shipping Lines";
                suggestedMap.put(serviceName, serviceMap.get(serviceName));
                break;
            case "YML":
            case "YMM":
            case "KMS":
                serviceName = "Yang Ming";
                suggestedMap.put(serviceName, serviceMap.get(serviceName));
                break;

        }
    }



}
