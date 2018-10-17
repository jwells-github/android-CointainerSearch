package containersearch.jaked.containersearch;

import java.util.TreeMap;

public class ContainerNumber {

    String mContainerNumber;

    public ContainerNumber(String containerNumber){
        mContainerNumber = containerNumber;
    }

    public String getContainerNumber() {
        return mContainerNumber;
    }

    public Boolean isValid(){
        String[] containerNumber = mContainerNumber.split("(?!^)");

        if(containerNumber.length != 11){
            return false;
        }

        for(int i = 0; i <= 3; i++){
            if(!Character.isLetter(containerNumber[i].charAt(0))){
                return false;
            }
        }

        for(int i = 4; i <= 9; i++){
            if(!Character.isDigit(containerNumber[i].charAt(0))){
                return false;
            }
        }

        int finalDigit = sumOfNumbers(containerNumber) % 11;

        if(containerNumber[10].equals(String.valueOf(finalDigit))){
            return true;
        }
        else{
            return false;
        }

    }

    private int sumOfNumbers(String[] containerNumber){
        int total = 0;
        for(int i =0; i <= 9; i++){
            double a = Math.pow(2,i);
            total += CharacterValue(containerNumber[i].charAt(0)) *  Math.pow(2,i);
        }
        return total;
    }

    private int CharacterValue(Character c){
        if(Character.isDigit(c)){
            return Integer.valueOf(c.toString());
        }
        else {
            c = Character.toLowerCase(c);
            int value = ((int) c ) - 87;
            value += (value + 1) / 11;
            return value;
        }
    }

    public TreeMap<String, String> getServiceMap(){

        return new TreeMap<String, String>() {{
            put("ACL", "https://www.aclcargo.com/trackCargo.php");
            put("Alianca", "");
            put("Allalouf","");
            put("ANL", "");
            put("APL", "https://homeport.apl.com/gentrack/trackingMain.do?trackInput01="+mContainerNumber);
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
            put("CMA CGM", "https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Container&Reference="+mContainerNumber);
            put("CNC Line", "");
            put("CONCOR", "");
            put("Cosco Shipping Lines" , "http://elines.coscoshipping.com/ebusiness/cargoTracking?trackingType=CONTAINER&number="+mContainerNumber);
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
                    "&is_quick=Y&quick_params=&type=2&number=" + mContainerNumber + "&submit.x=21&submit.y=10");
            put("Italia Marittima","");
            put("K-line","");
            put("Kambara Kisen","");
            put("KiwiRail","");
            put("Korea Marine Transport","");
            put("Kuehne + Nagel","");
            put("Leschaco","");
            put("Linea Messina","");
            put("MACS","");
            put("Maersk Line","https://www.maersk.com/tracking/#tracking/"+mContainerNumber);
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
            put("OOCL","http://www.oocl.com/Pages/ExpressLink.aspx?eltype=ct&bl_no=&cont_no="+ mContainerNumber +"&booking_no=");
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
            put("Yang Ming","https://www.yangming.com/e-service/track_trace/mul_ctnr.aspx?str="+ mContainerNumber +",&rdolType=CT");
            put("ZIM","");
            put("Zim World Freight","");

        }};
    }


}
