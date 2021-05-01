//package main.MMT;



import jdk.nashorn.internal.parser.JSONParser;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Map;
import java.util.Scanner;

//public class DESHaw {

//    public static void main(String[] args) throws ScriptException, MalformedURLException, IOException {
//
//        ScriptEngine engine;
//        ScriptEngineManager sem = new ScriptEngineManager();
//        engine = sem.getEngineByName("javascript");
//        String json = "\n" +
//                "\n" +
//                "[\n" +
//                "  {\n" +
//                "    \"id\": 1,\n" +
//                "    \"name\": \"Vinay Kumar\",\n" +
//                "    \"username\": \"vinayk\",\n" +
//                "    \"email\": \"vinayk@abcu.com\",\n" +
//                "    \"address\": {\n" +
//                "      \"street\": \"random1\",\n" +
//                "      \"suite\": \"APR\",\n" +
//                "      \"city\": \"Mumbai\",\n" +
//                "      \"zipcode\": \"192008-13874\",\n" +
//                "      \"geo\": {\n" +
//                "        \"lat\": \"-17.3159\",\n" +
//                "        \"lng\": \"91.1496\"\n" +
//                "      }\n" +
//                "    },\n" +
//                "    \"website\": \"seuinfra.org\",\n" +
//                "    \"company\": {\n" +
//                "      \"name\": \"sec infra\",\n" +
//                "      \"basename\": \"seu infra tech\"\n" +
//                "    }\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"id\": 2,\n" +
//                "    \"name\": \"Anandita Basu\",\n" +
//                "    \"username\": \"PrernaB\",\n" +
//                "    \"email\": \"Anandita.b@abc1f.cpm\",\n" +
//                "    \"address\": {\n" +
//                "      \"street\": \"Hawroh Bridge\",\n" +
//                "      \"suite\": \"ATY\",\n" +
//                "      \"city\": \"Kolkata\",\n" +
//                "      \"zipcode\": \"700001\",\n" +
//                "      \"geo\": {\n" +
//                "        \"lat\": \"-67.3159\",\n" +
//                "        \"lng\": \"91.8006\"\n" +
//                "      }\n" +
//                "    },\n" +
//                "    \"website\": \"techInfar.org\",\n" +
//                "    \"company\": {\n" +
//                "      \"name\": \"tech infar world\",\n" +
//                "      \"basename\": \"seu infra tech\"\n" +
//                "    }\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"id\": 3,\n" +
//                "    \"name\": \"Charvi Malhotra\",\n" +
//                "    \"username\": \"CharviM\",\n" +
//                "    \"email\": \"Charvim@mail.net\",\n" +
//                "    \"address\": {\n" +
//                "      \"street\": \"whitehouse Extension\",\n" +
//                "      \"suite\": \"A782\",\n" +
//                "      \"city\": \"Bengaluru\",\n" +
//                "      \"zipcode\": \"560001\",\n" +
//                "      \"geo\": {\n" +
//                "        \"lat\": \"-68.6102\",\n" +
//                "        \"lng\": \"-47.0653\"\n" +
//                "      }\n" +
//                "    },\n" +
//                "    \"website\": \"Infesystem.info\",\n" +
//                "    \"company\": {\n" +
//                "      \"name\": \"infeystems\",\n" +
//                "      \"basename\": \"Information E stsyem\"\n" +
//                "    }\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"id\": 4,\n" +
//                "    \"name\": \"Patricia Wilson\",\n" +
//                "    \"username\": \"WilsonP\",\n" +
//                "    \"email\": \"Wilsonp@mymail.org\",\n" +
//                "    \"address\": {\n" +
//                "      \"street\": \"Kalangut\",\n" +
//                "      \"suite\": \"Apt 6\",\n" +
//                "      \"city\": \"Panjim\",\n" +
//                "      \"zipcode\": \"403110\",\n" +
//                "      \"geo\": {\n" +
//                "        \"lat\": \"29.4572\",\n" +
//                "        \"lng\": \"-164.2990\"\n" +
//                "      }\n" +
//                "    },\n" +
//                "    \"website\": \"giant.Tech.biz\",\n" +
//                "    \"company\": {\n" +
//                "      \"name\": \"robert-techgiant\",\n" +
//                "      \"basename\": \"transition cutting-edge web services provider\"\n" +
//                "    }\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"id\": 5,\n" +
//                "    \"name\": \"Chetan Chauhan \",\n" +
//                "    \"username\": \"ChauhanChetan\",\n" +
//                "    \"email\": \"chetanc@mailme.in\",\n" +
//                "    \"address\": {\n" +
//                "      \"street\": \"Willow Walks\",\n" +
//                "      \"suite\": \"1351\",\n" +
//                "      \"city\": \"Hyderabad\",\n" +
//                "      \"zipcode\": \"500001\",\n" +
//                "      \"geo\": {\n" +
//                "        \"lat\": \"-31.8129\",\n" +
//                "        \"lng\": \"62.5342\"\n" +
//                "      }\n" +
//                "    },\n" +
//                "    \"website\": \"sanganak.info\",\n" +
//                "    \"company\": {\n" +
//                "      \"name\": \"Sanganak\",\n" +
//                "      \"basename\": \"end-to-end solution provider\"\n" +
//                "    }\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"id\": 6,\n" +
//                "    \"name\": \"Pragya Mathur\",\n" +
//                "    \"username\": \"mathurpragya\",\n" +
//                "    \"email\": \"pragya.mathur@mail.in\",\n" +
//                "    \"address\": {\n" +
//                "      \"street\": \"Rosewind Crossing\",\n" +
//                "      \"suite\": \"A-50\",\n" +
//                "      \"city\": \"Delhi\",\n" +
//                "      \"zipcode\": \"100001\",\n" +
//                "      \"geo\": {\n" +
//                "        \"lat\": \"-71.4197\",\n" +
//                "        \"lng\": \"71.7478\"\n" +
//                "      }\n" +
//                "    },\n" +
//                "    \"website\": \"hola.in\",\n" +
//                "    \"company\": {\n" +
//                "      \"name\": \"Hola Technocrafts\",\n" +
//                "      \"basename\": \"e-enable innovative applications\"\n" +
//                "    }\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"id\": 7,\n" +
//                "    \"name\": \"Krish Ahuja\",\n" +
//                "    \"username\": \"ahujakrish\",\n" +
//                "    \"email\": \"ahujakrish@mails.in\",\n" +
//                "    \"address\": {\n" +
//                "      \"street\": \"Havmore Extension\",\n" +
//                "      \"suite\": \"A3221\",\n" +
//                "      \"city\": \"Bengalura\",\n" +
//                "      \"zipcode\": \"560058\",\n" +
//                "      \"geo\": {\n" +
//                "        \"lat\": \"24.8918\",\n" +
//                "        \"lng\": \"21.8984\"\n" +
//                "      }\n" +
//                "    },\n" +
//                "    \"website\": \"tellybelly.in\",\n" +
//                "    \"company\": {\n" +
//                "      \"name\": \"Telly Belly\",\n" +
//                "      \"basename\": \"generate application support solutions\"\n" +
//                "    }\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"id\": 8,\n" +
//                "    \"name\": \"Nilofar Anam\",\n" +
//                "    \"username\": \"anamnilofar\",\n" +
//                "    \"email\": \"nilofaranam.d@maily.me\",\n" +
//                "    \"address\": {\n" +
//                "      \"street\": \"fountains lane\",\n" +
//                "      \"suite\": \"B902\",\n" +
//                "      \"city\": \"pune\",\n" +
//                "      \"zipcode\": \"400001\",\n" +
//                "      \"geo\": {\n" +
//                "        \"lat\": \"-14.3990\",\n" +
//                "        \"lng\": \"-120.7677\"\n" +
//                "      }\n" +
//                "    },\n" +
//                "    \"website\": \"techoba.com\",\n" +
//                "    \"company\": {\n" +
//                "      \"name\": \"Tech Happy Group\",\n" +
//                "      \"basename\": \"e-support to middle retailers\"\n" +
//                "    }\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"id\": 9,\n" +
//                "    \"name\": \"Garima Gupta\",\n" +
//                "    \"username\": \"Garimag\",\n" +
//                "    \"email\": \"gupta.garima22@myemails.io\",\n" +
//                "    \"address\": {\n" +
//                "      \"street\": \"Little Park\",\n" +
//                "      \"suite\": \"B68\",\n" +
//                "      \"city\": \"Surat\",\n" +
//                "      \"zipcode\": \"764920\",\n" +
//                "      \"geo\": {\n" +
//                "        \"lat\": \"24.6463\",\n" +
//                "        \"lng\": \"-168.8889\"\n" +
//                "      }\n" +
//                "    },\n" +
//                "    \"website\": \"contech.com\",\n" +
//                "    \"company\": {\n" +
//                "      \"name\": \"Configs Techs\",\n" +
//                "      \"basename\": \"real-time technologies support\"\n" +
//                "    }\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"id\": 10,\n" +
//                "    \"name\": \"Dharma Dhar\",\n" +
//                "    \"username\": \"Dharmadhar55\",\n" +
//                "    \"email\": \"dharmadhar55@olexa.in\",\n" +
//                "    \"address\": {\n" +
//                "      \"street\": \"Anam Street\",\n" +
//                "      \"suite\": \"198/23\",\n" +
//                "      \"city\": \"Surat\",\n" +
//                "      \"zipcode\": \"314280\",\n" +
//                "      \"geo\": {\n" +
//                "        \"lat\": \"-38.2386\",\n" +
//                "        \"lng\": \"57.2232\"\n" +
//                "      }\n" +
//                "    },\n" +
//                "    \"website\": \"ampitech.net\",\n" +
//                "    \"company\": {\n" +
//                "      \"name\": \"Ampitech Solutions Ltd\",\n" +
//                "      \"basename\": \"target end-to-end startup support\"\n" +
//                "    }\n" +
//                "  }\n" +
//                "]";
//
//
//     //   System.out.println(json);
//        String script = "Java.asJSONCompatible(" + json + ")";
//
//        //System.out.println(script);
//        Object result = engine.eval(script);
//
//
//
//
//      //  Map<String, Object> contents = (Map<String, Object>) result;
//
//
////        contents.forEach((t, u) -> {
////            //key-value pairs
////            System.out.println("key" + t);
////        });
//
//
//
////        Object obj = engine.eval("Java.asJSONCompatible("+ json +")");
////        Map<String, Object> map = (Map<String, Object>)obj;
////
////        System.out.println(map.get("number"));
////      //  System.out.println(map.get("primes"));
//    //    System.out.println(List.class.isAssignableFrom(map.get("primes").getClass()));
//
//
//        URL url= new URL("https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users");
//        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//        conn.setRequestMethod("GET");
//        conn.connect();
//        String inline="";
//        int responsecode = conn.getResponseCode();
//        if(responsecode != 200)
//            throw new RuntimeException("HttpResponseCode: " +responsecode);
//           else {
//            Scanner sc = new Scanner(url.openStream());
//            while(sc.hasNext())
//            {
//                inline+=sc.nextLine();
//            }
//           // System.out.println(“\nJSON data in string format”);
//            System.out.println(inline);
//            sc.close();
//           inline.
//        }
//
//    }
//
//    public static List<Integer> apiResponseParser(List<String> inputList, int size) throws IOException {
//
//        URL url= new URL("https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users");
//        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//        conn.setRequestMethod("GET");
//        conn.connect();
//        String inline="";
//        int responsecode = conn.getResponseCode();
//        if(responsecode != 200)
//            throw new RuntimeException("HttpResponseCode: " +responsecode);
//        else {
//            Scanner sc = new Scanner(url.openStream());
//            while(sc.hasNext())
//            {
//                inline+=sc.nextLine();
//            }
//            // System.out.println(“\nJSON data in string format”);
//            System.out.println(inline);
//            sc.close();
//
//        }
//
//        JSONArray jsonArr = new JSONArray(inline);
//
//        for (int i = 0; i < jsonArr.length(); i++)
//        {
//            JSONObject jsonObj = jsonArr.getJSONObject(i);
//
//            System.out.println(jsonObj);
//        }
//
//
//    }
//
//}
//
//
//class Employee {
//
//}