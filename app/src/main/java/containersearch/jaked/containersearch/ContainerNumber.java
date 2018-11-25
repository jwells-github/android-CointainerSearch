package containersearch.jaked.containersearch;

import android.text.TextUtils;

import java.util.Arrays;
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
        String[] containerNumberDigits = mContainerNumber.split("(?!^)");

        if(containerNumberDigits.length < 10){
            return false;
        }

        for(int i = 0; i <= 3; i++){
            if(!Character.isLetter(containerNumberDigits[i].charAt(0))){
                return false;
            }
        }

        for(int i = 4; i <= 9; i++){
            if(!Character.isDigit(containerNumberDigits[i].charAt(0))){
                return false;
            }
        }

        int finalDigit = sumOfNumbers(containerNumberDigits) % 11;

        if(containerNumberDigits.length == 10){
           containerNumberDigits = Arrays.copyOf(containerNumberDigits, containerNumberDigits.length+1);
           containerNumberDigits[10] = String.valueOf(finalDigit);
           StringBuilder builder = new StringBuilder();
           for(String value : containerNumberDigits){
               builder.append(value);
           }
           mContainerNumber = builder.toString();
        }

        if(containerNumberDigits[10].equals(String.valueOf(finalDigit))){
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

    public TreeMap<String, String> getServiceMap()  {

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
            put("Kambara Kisen","http://esvc.kambara-kisen.co.jp/clt/CUP_HOM_3301.do");
            put("KiwiRail","http://www.kiwirailfreight.co.nz/track.aspx");
            put("Korea Marine Transport","http://www.ekmtc.com/CCIT100/searchContainerList.do");
            put("Kuehne + Nagel","https://onlineservices.kuehne-nagel.com/public-tracking/shipments?query="+mContainerNumber);
            put("Leschaco","https://visible.leschaco.com/?forwarderRef="+mContainerNumber);
            put("Linea Messina","https://www.messinaline.it/wps/wcm/connect/internet/messina_en/operativo/cntr_tracking/#tf-cntr_tracking");
            put("MACS","https://www.macship.com/E-BUSINESS/TrackingAndTracing.aspx");
            put("Maersk Line","https://www.maersk.com/tracking/#tracking/"+mContainerNumber);
            put("Maldives Ports","https://port.mv/port-live/container-live-search/");
            put("Marfret","http://www.marfret.fr/en/container-tracking/");
            put("Mariana Express Lines","https://www.mellship.com/Track?type=container&text="+mContainerNumber);
            put("Matson","https://www.matson.com/vcsc/VisibilityController");
            put("Mediterranean Shipping (MSC)","https://www.msc.com/track-a-shipment");
            put("Meratus Line","http://mo.meratusline.com/GeneralTracking.aspx?act=01");
            put("Minsheng Ocean Shipping","http://www.mssco.net/Eip/Svc/wfCargoTracking.aspx?BL=&CN="+mContainerNumber+"=");
            put("Namsung","http://e.namsung.co.kr/frt/biz/eService/selectCargoTrace.do");
            put("NileDutch","https://www.niledutch.com/en/schedules-tracking/track-your-container/");
            put("NYK Line","https://ecomm.one-line.com/ecom/CUP_HOM_3301.do?sessLocale=en?sessLocale=en");
            put("Ocean Axis","http://dxb.fresaxpress.com:7001/apex/fresaxp/f?p=202%3A3%3A0%3A%3ANO%3A3%3AP0_COMPANY_ID%2CP3_CONTAINER_NO%3A1002%2C"+mContainerNumber);
            put("Ocean World Lines","http://www.oceanworldlines.com/quicktrack.aspx");
            put("ONE","https://ecomm.one-line.com/ecom/CUP_HOM_3301.do?sessLocale=en?sessLocale=en");
            put("OOCL","http://www.oocl.com/Pages/ExpressLink.aspx?eltype=ct&bl_no=&cont_no="+ mContainerNumber +"&booking_no=");
            put("OPDR","http://www.opdr.com/en/fleet-container/container-tracking.html");
            put("Pacific Direct Line","http://www.pdl123.co.nz/track-and-trace/");
            put("Pan Asia Line","http://www.panasialine.net/ebusiness/frmNonLogin.aspx?Type=ContainerTracking");
            put("Pan Continental Shipping","http://www.pancon.co.kr/pan/pageLink.pcl");
            put("Pan Ocean","https://container.panocean.com/HP2401/hp2401List.stx");
            put("Pasha Hawaii","https://app.pashahawaii.com/PHLiner/Tracking");
            put("Perma Shipping Line","http://perma.sg/index.php");
            put("PIL","https://www.pilship.com/--/120.html");
            put("PSL Navegação","http://pslnavegacao.com/ing/tracking_resposta.asp?contrNumber="+mContainerNumber);
            put("Qatar Navigation","https://aznvoccweb1.qatarnav.com/qnless/eSelfAjaxServer.asp?FunName=BLSEARCH&ContainerNumber="+mContainerNumber+"&Vessel=&Voyage=&LoadingDate=&POL=&FPOD=");
            put("RCL","https://www.rclgroup.com/CrgTrack_02.asp?CrgDtl="+mContainerNumber);
            put("Safmarine","https://my.safmarine.com/tracking/#tracking/"+mContainerNumber);
            put("Saigon Newport Corporation","https://eport.saigonnewport.com.vn/Pages/Common/Containers_new");
            put("Samudera Shipping","https://ssl.cts.samudera.id:9600/ifcr-monitoring/applicationMssqlServer/script/home.php");
            put("Sarjak Container Lines","http://system.sarjak.com/sarjakweb/Tracking.aspx");
            put("SCI","http://www.shipindia.com/app/consignment-tracking.aspx");
            put("Seaboard Marine","https://www.seaboardmarine.com/tracking/?equipment_number="+mContainerNumber.substring(0,4)+"+"+ mContainerNumber.substring(4,10)+"-"+mContainerNumber.substring(10)+"&vehicleIdentificationNumber=&Track=Track");
            put("Seaco","https://newseaweb.seacoglobal.com/sap/bc/ui5_ui5/sap/zseaco_ue14/index.html");
            put("SeaCube","https://seacube.intermodalportal.com/");
            put("Sealand","https://my.mcc.com.sg/tracking/#tracking/"+mContainerNumber);
            put("Shreyas Relay System now Avana Logistek","");
            put("Sinokor Merchant Marine","http://eservice.sinokor.co.kr/ASPNETService/COM/CP_TrackingInquiry.aspx");
            put("Sinotrans","http://ebusiness.sinolines.com.cn/snlebusiness/TrackingByBlnoE.aspx?subject=cntrno&item="+mContainerNumber);
            put("SITC","http://www.sitcline.com/index.jsp?viewId=menuItem_view_SmiCargoTrack&status=1&url=/track/biz/trackCargoTrack.do?method=bookingNoIndexNew&rblNo="+mContainerNumber+"&type=1");
            put("SM Line","https://esvc.smlines.com/smline/CUP_HOM_3301.do");
            put("Sofrana ANL","https://www.anl.com.au/ebusiness/tracking/search?SearchBy=Container&Reference="+mContainerNumber);
            put("SPIL","http://www.spil.co.id/spilcoid_s1l/home/ScheduleTrackIndex?selectSearchName=track&trackinput="+mContainerNumber);
            put("St. John Freight Systems","http://220.225.124.34/cargotrack/tracktrace.aspx");
            put("Sunmarine","http://www.sunmarine.com/trackntrace.aspx?Type=CO&blno="+mContainerNumber);
            put("T.S. Lines","http://vgm.tslines.com/CargoTracking/CargoTracking");
            put("Taiyoung Shipping","http://www.agentinkorea.com/shms/source/sp/schedule/cargoTracing.asp?findgb=ct&findno="+mContainerNumber);
            put("Tarros","http://www.tarros.it/traccia-container-en/");
            put("Textainer","http://tex.textainer.com/Equipment/StatusAndSpecificationsInquiry.aspx");
            put("The China Navigation Company","https://ebiz.swirecnco.com/vgm/TrackAndTrace");
            put("TOTE Maritime","https://portal.totemaritime.com/Track/TrackDetails?trackportalid=0&searchNum="+mContainerNumber+"&trackType=1");
            put("Touax","http://www.touax-container.com/unit-inquiry");
            put("Trans Asia","http://111.93.109.35/Reports/ContainerTracking.aspx?containerno="+mContainerNumber);
            put("TransContainer","https://isales.trcont.com/#/tracking");
            put("Transmar","https://www.transmar.com/Track?BillOfLading=&ContainerNum="+mContainerNumber);
            put("Triton International","https://www.trtn.com/tritoncontainer/unitStatus/list");
            put("Turkon Line","https://www.turkon.com/en/Container-Tracking.aspx?p=1&cont="+mContainerNumber);
            put("UES International","http://www.ueshk.com/phone/inquiries_detail.aspx?classid=3&aid=5&leftid=18&seachstr="+mContainerNumber);
            put("W.E.C. Lines","https://odyssey.weclines.com/Odyssey/public/ContainerTrackSearch.seam");
            put("Wan Hai Lines","http://www.wanhai.com/views/cargoTrack/CargoTrack.xhtml?file_num=65580&parent_id=64738&top_file_num=64735");
            put("WorldWide Alliance","https://www.wwalliance.com/wwaonline/tra/index.php");
            put("Yang Ming","https://www.yangming.com/e-service/track_trace/mul_ctnr.aspx?str="+ mContainerNumber +",&rdolType=CT");
            put("ZIM","https://www.zim.com/tools/track-a-shipment?consnumber="+mContainerNumber);
            put("Zim World Freight","http://www.zline.in/ContainerTracking/ContainerTracking.aspx?TrackBy=CONTAINER_NO&TrackingText="+mContainerNumber);

        }};
    }


}
