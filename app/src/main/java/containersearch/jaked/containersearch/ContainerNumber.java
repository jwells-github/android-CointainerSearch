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
            put("Alianca", "https://www.alianca.com.br/alianca/en/alianca/ecommerce_alianca/track_trace_alianca/index.html");
            put("Allalouf","http://en.allalouf.com/block/FirstColumn/Cargo-Tracking-Iscont-Lines/?action=results&container=" +mContainerNumber);
            put("ANL", "https://www.anl.com.au/ebusiness/tracking/search?SearchBy=Container&Reference="+mContainerNumber);
            put("APL", "https://homeport.apl.com/gentrack/trackingMain.do?trackInput01="+mContainerNumber);
            put("Arkas Line", "http://tracking.arkasline.com.tr/ContainerTracking/?Search="+mContainerNumber+"&Column=ContainerNo&Page=1");
            put("Avana Logistek", "http://web8.transworld.com/avanatracking/containertracking.aspx?container="+mContainerNumber);
            put("Beacon Intermodal", "https://beacon.intermodalportal.com/");
            put("Blue Sky", "https://bsiu.com/our-containers/?ref="+mContainerNumber);
            put("BMC Line", "http://www.whizecargo.com/clientbmc/view_container_tracking.php?nomenu=1");
            put("Bridgehead", "http://www.bridgeheadcontainers.com/onhire.asp");
            put("CAI", "https://www.capps.com/cgi-bin/publicUnitInfo?UNIT="+mContainerNumber);
            put("Canadian Pacific Railway", "https://www8.cpr.ca/cpcustomerstation");
            put("CARU containers", "https://portal.carucontainers.com/scripts/cgiip.exe/WService=caru/system/web/sp-web-menu.r?program=DP.WEB-UNIT_INQUIRY&containernumber="+mContainerNumber+"&Submit=Open");
            put("CMA CGM", "https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Container&Reference="+mContainerNumber);
            put("CNC Line", "https://www.cnc-ebusiness.com/ebusiness/tracking/search?SearchBy=Container&Reference="+mContainerNumber);
            put("CONCOR", "http://www.concorindia.com/Domcontainerquery.aspx");
            put("Cosco Shipping Lines" , "http://elines.coscoshipping.com/ebusiness/cargoTracking?trackingType=CONTAINER&number="+mContainerNumber);
            put("Crowley", "http://www.crowley.com/What-We-Do/Shipping-and-Logistics/Liner-Shipment-Tracking");
            put("CULlines", "http://211.152.47.139:9080/gemship/website/ordertracks.html");
            put("DAL" , "https://my.dal.biz/cts#/data_eq_no/"+mContainerNumber);
            put("DB Schenker", "https://eschenker.dbschenker.com/nges-portal/public/en-US_US/#!/tracking/schenker-search?refNumber="+mContainerNumber);
            put("DHL" , "https://dhli.dhl.com/dhli-client/publicTrackingSummary?1&searchType=CN&searchValue="+mContainerNumber);
            put("Dong Young Shipping", "http://www.pcsline.co.kr/eng/ebusiness/ebusiness01.asp");
            put("Dongjin Shipping", "http://korea.djship.co.kr/dj/servlet/kr.eservice.action.sub3_21_Action?mode=S");
            put("DP World Nhava Sheva", "http://dpworldmumbai.com/php/searchContainerNoResult.php");
            put("Econ Shipping", "http://13.71.25.234/tracer/TrackYourShipment.aspx?CheckId="+mContainerNumber+"SpType=GetTYSData&Reftype=Cntr&PType=W");
            put("ECU Worldwide", "http://ecu.statistics.eu.eculine.net/ECU.TNT/Frontend/home.html?ref="+mContainerNumber);
            put("Emirates Shipping Line", "https://www.emiratesline.com/cargo-tracking");
            put("Emkay Line", "http://www.emkayline.com/trackbycno.php?txt_container_no="+mContainerNumber);
            put("ESL", "https://www.ethiopianshippinglines.com.et/Search.php?Field=C&query="+mContainerNumber);
            put("Evergreen", "https://www.shipmentlink.com/servlet/TDB1_CargoTracking.do");
            put("FESCO", "https://www.fesco.ru/en/clients/tracking/?codes="+mContainerNumber);
            put("Finnlines","https://www.net.grimaldi.co.uk/GNET45/Pages_GAtlas/WFContainerTracking");
            put("Flexi-Van Leasing","https://fvcustomer.flexivan.com/fvcustomer/ChassisLookUp.aspx");
            put("Florens","https://www.florens.com/equipment#/unit-inquiry");
            put("Focus Trucking","http://www.focustr.us/trucking/trace");
            put("Gold Star Line","https://www.shipcont.com/CCM.aspx?hidSearch=true&hidFromHomePage=false&hidSearchType=1&id=166&l=4&textContainerNumber="+mContainerNumber);
            put("Grimaldi","https://www.net.grimaldi.co.uk/GNET45/Pages_GAtlas/WFContainerTracking");
            put("Hamburg Süd","https://www.hamburgsud-line.com/liner/en/liner_services/ecommerce/track_trace/index.html");
            put("Hapag-Lloyd","");
            put("HDASCO Line","");
            put("Heung-A Shipping","");
            put("Hyundai (HMM)", "https://www.hmm21.com/cms/business/ebiz/trackTrace/trackTrace/index.jsp?numbers=" +
                    "&numbers=&numbers=&numbers=&numbers=&numbers=&numbers=&numbers=&numbers=&numbers=&numbers=&numbers=&numbers=" +
                    "&is_quick=Y&quick_params=&type=2&number=" + mContainerNumber + "&submit.x=21&submit.y=10");
            put("Italia Marittima","https://www.shipmentlink.com/servlet/TDB1_CargoTracking.do");
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
