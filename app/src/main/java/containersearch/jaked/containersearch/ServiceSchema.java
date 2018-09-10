package containersearch.jaked.containersearch;

import java.util.TreeMap;

public class ServiceSchema {
    /*
    public static final class SearchServices{
        public static final class Names{
            public static final String ACL = "ACL";
            public static final String ALIANCA = "Alianca";
            public static final String ALLALOUF= "Alialouf";
            public static final String ANL = "ANL";
            public static final String APL = "APL";
            public static final String ARKAS_LINE = "Arkas Line";
            public static final String AVANA_LOGISTEK = "Avana Logistek";
            public static final String BEACON_INTERMODAL = "Beacon Intermodal";
            public static final String BLUE_SKY = "Blue Sky";
            public static final String BMC_LINE = "BMC Line";
            public static final String BRIDGEHEAD = "Bridgehead";
            public static final String CAI = "CAI";
            public static final String CANADIAN_NATIONAL_RAILWAY = "Canadian National Railway";
            public static final String CARU_CONTIANERS = "Canadian Pacific Railway";
            public static final String CMA_CGM = " CMA CGM";
            public static final String CNC_LINE = "CNC Line";
            public static final String CONCOR = "Concor";
            public static final String COSCO_SHIPPING_LINES = "Cosco Shipping Lines";
            public static final String CROWLEY = "Crowley";
            public static final String CULLINES = "CULlines";
            public static final String DAL = "DAL";
            public static final String DB_SCHENKER = "DB Schenker";
            public static final String DHL = "DHL";
            public static final String DONG_YOUNG_SHIPPING = "Dong Young Shipping";
            public static final String DONGJIN_SHIPPING = "Dongjin Shipping";
            public static final String DP_WORLD_NHAVA_SHEVA = "DP World Nhava Sheva";
            public static final String ECON_SHIPPING = "Econ Shipping";
            public static final String EXU_WORLDWIDE = "ECU Worldwide";
            public static final String EMIRATES_SHIPPING_LINE = "Emirates Shipping Lines";
            public static final String EMKAY_LINE = "Emkay Line";
            public static final String ESL = "ESL";
            public static final String EVERGREEN = "Evergreen";
            public static final String FESCO = "FESCO";
            public static final String FINNLINES = "Finnlines";
            public static final String FLEXI_VAN_LEASING = "Flexi-Van Leasing";
            public static final String FLORENS = "Florens";
            public static final String FOCUS_TRUCKING = "Focus Trucking";
            public static final String GOLD_STAR_LINE = "Gold Star Line";
            public static final String GRIMALDI = "Grimaldi";
            public static final String HAMBURG_SUD = "Hamburg Sud";
            public static final String HAPAG_LLOYD = "Hapag-Lloyd";
            public static final String HDASCO_LINE = "HHDASCO Line";
            public static final String HEUNG_A_SHIPPING = "Heaung-A Shipping";
            public static final String HYUNDAI = "Hyundai (HMM)";
            public static final String ITALIS_MARITTIMA = "Italia Marittima";
            public static final String K_LINE = "K-line";
            public static final String KAMBARA_KISEN = "Kambara Kisen";
            public static final String KIWIRAIL = "KiwiRail";
            public static final String KOREA_MARINE_TRANSPORT = "Korea Marine Transport";
            public static final String KEUHNE_NAGEL = "Keuhne + Nagel";
            public static final String LESCHACO = "Leshaco";
            public static final String LINES_MESSINA = "Linea Messina";
            public static final String MACS = "MACS";
            public static final String MAERSK_LINE = "Maersk Line";
            public static final String MALDIVES_PORTS = "Maldives Ports";
            public static final String MARFRET = "Marfret";
            public static final String MARIAN_EXPRES_LINES = "Mariana Express Lines";
            public static final String MARITIME_UNITED_OPERATOR = "Maritime United Operator";
            public static final String MATSON = "Matson";
            public static final String MAXICO_CONTAINER_LINE = "Maxicon Container Line";
            public static final String MCC_TRANSPORT = "MCC Transport";
            public static final String MEDITERRANEAN_SHIPPING = "Mediterranean Shipping (MSC)";
            public static final String MERATUS_LINE = "Meratus Line";
            public static final String MINSHEN_OCEAN_SHIPPING = "Minsheng Ocean Shipping";
            public static final String MOL = "MOL";
            public static final String NAMSUNG = "Namsung";
            public static final String NILEDUTCH = "NileDutch";
            public static final String NIRINT_SHIPPING = "Nirint Shipping";
            public static final String NYK_LINE = "NYK Line";
            public static final String OCEAN_AXIS = "Ocean Axis";
            public static final String OCEAN_WORLD_LINES = "Ocean World Lines";
            public static final String ONE = "ONE";
            public static final String OOCL = "OOCL";
            public static final String OPDR = "OPDR";
            public static final String PACIFIC_DIRECT_LINE = "Pacific Direct Line";
            public static final String PAN_ASIA_LINE = "Pan Asia Line";
            public static final String PAN_CONTINENTAL_SHIPPING = "Pan Continental Shipping";
            public static final String PAN_OCEAN = "Pean Ocean";
            public static final String PASHA_HAWAII = "Pasha Hawaii";
            public static final String PERMA_SHIPPING_LINE = "Perma Shipping Line";
            public static final String PIL = "PTL";
            public static final String PSL_NAVEGACAO = "PSL Navegação";
            public static final String RCL = "RCL";
            public static final String SAFMARINE = "Safmarine";
            public static final String SAIGON_NEWPORT_CORPORATION = "Saigon Newport Corporation";
            public static final String SAMSKIP = "Samskip";
            public static final String SAMUDERA_SHIPING = "Samudera Shipping";
            public static final String SARJAK_CONTAINER_LINES = "Sarjak Container Lines";
            public static final String SCI = "SCI";
            public static final String SEABOARD_MARINE = "Seaboard Marine";
            public static final String SEACO = "Seaco";
            public static final String SEACUBE = "SeaCube";
            public static final String SEASGO_LINE = "Seago Line";
            public static final String SREYAS_RELAY_SYSTEM = "Shreyas Relay System";
            public static final String SINOKOR_MERCHANT_MARINE = "Sinokor Merchant Marine";
            public static final String SINOTRANS = "Sinotrans";
            public static final String SITC = "SITC";
            public static final String SM_LINE = "SM Line";
            public static final String SOFRANA_ANL = "Sofrana ANL";
            public static final String SPIL = "SPIL";
            public static final String ST_JOHN_FREIGHT_SYSTEMS = "St. John Freight Systems";
            public static final String SUNMARINE = "Sunmarine";
            public static final String TS_LINES = "T.S. Lines";
            public static final String TAIYOUNG_SHIPPING = "Taiyoung Shipping";
            public static final String TANTO = "Tanto";
            public static final String TARROS = "Tarros";
            public static final String TEXTAINER = "Textainer";
            public static final String THE_CHINA_NAVIGATION_COMPANY = "The China Navigation Company";
            public static final String TOTE_MARITIME = "TOTE Maritime";
            public static final String TOUAX = "Touax";
            public static final String TRAILER_BRIDGE = "Trailer Bridge";
            public static final String TRANS_ASIA = "Trans Asia";
            public static final String TRANSCONTAINER = "TransContainer";
            public static final String TRANSMAR = "Transmar";
            public static final String TRITON_INTERNATIONAL = "Triton International";
            public static final String TURKON_LINE = "Turkon Line";
            public static final String UES_INTERNATIONAL = "UES International";
            public static final String WEC_LINES = "W.E.C. Lines";
            public static final String WAN_HAI_LINE = "Wan Hai Line";
            public static final String WHITE_LINE = "White Line";
            public static final String WORLDWIDE_ALLIANCE = "WorldWide Alliance";
            public static final String YANG_MING = "Yang Ming";
            public static final String ZIM = "ZIM";
            public static final String ZIM_WORLD_FREIGHT = "Zim World Freight";

        }

        public static final class Urls{

            public static final String ACL = "";
            public static final String ALIANCA = "";
            public static final String ALLALOUF= "";
            public static final String ANL = "";
            public static final String APL = "https://homeport.apl.com/gentrack/trackingMain.do?trackInput01=";
            public static final String ARKAS_LINE = "";
            public static final String AVANA_LOGISTEK = "";
            public static final String BEACON_INTERMODAL = "";
            public static final String BLUE_SKY = "";
            public static final String BMC_LINE = "";
            public static final String BRIDGEHEAD = "";
            public static final String CAI = "";
            public static final String CANADIAN_NATIONAL_RAILWAY = "";
            public static final String CARU_CONTIANERS = "";
            public static final String CMA_CGM = "https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Container&Reference=";
            public static final String CNC_LINE = "";
            public static final String CONCOR = "";
            public static final String COSCO_SHIPPING_LINES = "http://elines.coscoshipping.com/ebusiness/cargoTracking?trackingType=CONTAINER&number=";
            public static final String CROWLEY = "";
            public static final String CULLINES = "";
            public static final String DAL = "";
            public static final String DB_SCHENKER = "";
            public static final String DHL = "";
            public static final String DONG_YOUNG_SHIPPING = "";
            public static final String DONGJIN_SHIPPING = "";
            public static final String DP_WORLD_NHAVA_SHEVA = "";
            public static final String ECON_SHIPPING = "";
            public static final String EXU_WORLDWIDE = "";
            public static final String EMIRATES_SHIPPING_LINE = "";
            public static final String EMKAY_LINE = "";
            public static final String ESL = "";
            public static final String EVERGREEN = "";
            public static final String FESCO = "";
            public static final String FINNLINES = "";
            public static final String FLEXI_VAN_LEASING = "";
            public static final String FLORENS = "";
            public static final String FOCUS_TRUCKING = "";
            public static final String GOLD_STAR_LINE = "";
            public static final String GRIMALDI = "";
            public static final String HAMBURG_SUD = "";
            public static final String HAPAG_LLOYD = "";
            public static final String HDASCO_LINE = "";
            public static final String HEUNG_A_SHIPPING = "";
            public static final String HYUNDAI_ONE = "https://www.hmm21.com/cms/business/ebiz/trackTrace" +
                    "/trackTrace/index.jsp?numbers=&numbers=&numbers=&numbers=&numbers=&numbers" +
                    "=&numbers=&numbers=&numbers=&numbers=&numbers=&numbers=&numbers=&is_quick=" +
                    "Y&quick_params=&type=2&number=";
            public static final String HYUNDAI_TWO = "&submit.x=21&submit.y=10";
            public static final String ITALIS_MARITTIMA = "";
            public static final String K_LINE = "";
            public static final String KAMBARA_KISEN = "";
            public static final String KIWIRAIL = "";
            public static final String KOREA_MARINE_TRANSPORT = "";
            public static final String KEUHNE_NAGEL = "";
            public static final String LESCHACO = "";
            public static final String LINES_MESSINA = "";
            public static final String MACS = "";
            public static final String MAERSK_LINE = "https://www.maersk.com/tracking/#tracking/";
            public static final String MALDIVES_PORTS = "";
            public static final String MARFRET = "";
            public static final String MARIAN_EXPRES_LINES = "";
            public static final String MARITIME_UNITED_OPERATOR = "";
            public static final String MATSON = "";
            public static final String MAXICO_CONTAINER_LINE = "";
            public static final String MCC_TRANSPORT = "";
            public static final String MEDITERRANEAN_SHIPPING_NO_EXTENSION = "https://www.msc.com/track-a-shipment";
            public static final String MERATUS_LINE = "";
            public static final String MINSHEN_OCEAN_SHIPPING = "";
            public static final String MOL = "";
            public static final String NAMSUNG = "";
            public static final String NILEDUTCH = "";
            public static final String NIRINT_SHIPPING = "";
            public static final String NYK_LINE = "";
            public static final String OCEAN_AXIS = "";
            public static final String OCEAN_WORLD_LINES = "";
            public static final String ONE = "";
            public static final String OOCL_ONE = "http://www.oocl.com/Pages/ExpressLink.aspx?eltype=ct&bl_no=&cont_no=";
            public static final String OOCL_TWO = "&booking_no=";
            public static final String OPDR = "";
            public static final String PACIFIC_DIRECT_LINE = "";
            public static final String PAN_ASIA_LINE = "";
            public static final String PAN_CONTINENTAL_SHIPPING = "";
            public static final String PAN_OCEAN = "";
            public static final String PASHA_HAWAII = "";
            public static final String PERMA_SHIPPING_LINE = "";
            public static final String PIL = "";
            public static final String PSL_NAVEGACAO = "";
            public static final String RCL = "";
            public static final String SAFMARINE = "";
            public static final String SAIGON_NEWPORT_CORPORATION = "";
            public static final String SAMSKIP = "";
            public static final String SAMUDERA_SHIPING = "";
            public static final String SARJAK_CONTAINER_LINES = "";
            public static final String SCI = "";
            public static final String SEABOARD_MARINE = "";
            public static final String SEACO = "";
            public static final String SEACUBE = "";
            public static final String SEASGO_LINE = "";
            public static final String SREYAS_RELAY_SYSTEM = "";
            public static final String SINOKOR_MERCHANT_MARINE = "";
            public static final String SINOTRANS = "";
            public static final String SITC = "";
            public static final String SM_LINE = "";
            public static final String SOFRANA_ANL = "";
            public static final String SPIL = "";
            public static final String ST_JOHN_FREIGHT_SYSTEMS = "";
            public static final String SUNMARINE = "";
            public static final String TS_LINES = "";
            public static final String TAIYOUNG_SHIPPING = "";
            public static final String TANTO = "";
            public static final String TARROS = "";
            public static final String TEXTAINER = "";
            public static final String THE_CHINA_NAVIGATION_COMPANY = "";
            public static final String TOTE_MARITIME = "";
            public static final String TOUAX = "";
            public static final String TRAILER_BRIDGE = "";
            public static final String TRANS_ASIA = "";
            public static final String TRANSCONTAINER = "";
            public static final String TRANSMAR = "";
            public static final String TRITON_INTERNATIONAL = "";
            public static final String TURKON_LINE = "";
            public static final String UES_INTERNATIONAL = "";
            public static final String WEC_LINES = "";
            public static final String WAN_HAI_LINES = "";
            public static final String WHITE_LINE = "";
            public static final String WORLDWIDE_ALLIANCE = "";
            public static final String YANG_MING_ONE = "https://www.yangming.com/e-service/track_trace/mul_ctnr.aspx?str=";
            public static final String YANG_MING_TWO = ",&rdolType=CT";
            public static final String ZIM = "";
            public static final String ZIM_WORLD_FREIGHT = "";
        }

        public static final class abc{
            public static final TreeMap abc = new TreeMap<String,String>(){
              put()
            };
        }
    }
    */
}