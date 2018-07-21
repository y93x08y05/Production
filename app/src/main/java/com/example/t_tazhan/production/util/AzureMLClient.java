package com.example.t_tazhan.production.util;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.*;
import java.io.*;
import java.util.*;

public class AzureMLClient {
    public static String response;
    public static HashMap<Integer,String> map;
    private static String endPointURL = "https://ussouthcentral.services.azureml.net/workspaces/f06b40ea77054bb2a012415b06082698/services/b29e0acade724cccbf9234e0ce25c2c0/execute?api-version=2.0&details=true\n";
    private static String key= "Bs6aXj46rwuvaJulO+KsG4s8DUWzCxhxcIyamwoR4H/ur/CPoGhItPj9ao5AX7SuHuG8pLGIba0zjviRWgRsRA==";
    private static String requestBody = "{\n" +
            "  \"Inputs\": {\n" +
            "    \"input1\": {\n" +
            "      \"ColumnNames\": [\n" +
            "        \"A\",\n" +
            "        \"B\",\n" +
            "        \"C\",\n" +
            "        \"D\",\n" +
            "        \"E\",\n" +
            "        \"F\",\n" +
            "        \"G\",\n" +
            "        \"H\",\n" +
            "      ],\n" +
            "      \"Values\": [\n" +
            "        [\n" +
            "          \"0\",\n" +
            "          \"0\",\n" +
            "          \"0\",\n" +
            "          \"0\",\n" +
            "          \"0\",\n" +
            "          \"0\",\n" +
            "          \"0\",\n" +
            "          \"0\",\n" +
            "        ],\n" +
            "        [\n" +
            "          \"0\",\n" +
            "          \"0\",\n" +
            "          \"0\",\n" +
            "          \"0\",\n" +
            "          \"0\",\n" +
            "          \"0\",\n" +
            "          \"0\",\n" +
            "          \"0\",\n" +
            "        ]\n" +
            "      ]\n" +
            "    }\n" +
            "  },\n" +
            "  \"GlobalParameters\": {}\n" +
            "}";
    private static String requestBody1 = "{\n" +
            "  \"Inputs\": {\n" +
            "    \"input1\": {\n" +
            "      \"ColumnNames\": [\n" +
            "        \"A\",\n" +
            "        \"B\",\n" +
            "        \"C\",\n" +
            "        \"D\",\n" +
            "        \"E\",\n" +
            "        \"F\",\n" +
            "        \"G\",\n" +
            "        \"H\",\n" +
            "      ],\n" +
            "      \"Values\": [\n" +
            "        [\n";
    private static String requestBody2 = "]\n" +
                        "      ]\n" +
                        "    }\n" +
                        "  },\n" +
                        "  \"GlobalParameters\": {}\n" +
                        "}";
    private static String requestBody3 = "],\n" +
                        "        [\n";
    public static String A,B,C,D,E,F,G,H;
      public static StringBuilder stringBuilder = new StringBuilder();
      public static String transferBeacon(TreeMap<String,String> map){
            for (int i=0;i<map.size();i++) {
                A = map.get("A");
                B = map.get("B");
                C = map.get("C");
                D = map.get("D");
                E = map.get("E");
                F = map.get("F");
                G = map.get("G");
                H = map.get("H");
            }
            stringBuilder.append(requestBody1);
            appendString();
            stringBuilder.append(requestBody3);
            appendString();
            stringBuilder.append(requestBody2);
            return stringBuilder.toString();
      }
      public static void appendString(){
          stringBuilder.append("\"").append(A).append("\"").append("\n");
          stringBuilder.append("\"").append(B).append("\"").append("\n");
          stringBuilder.append("\"").append(C).append("\"").append("\n");
          stringBuilder.append("\"").append(D).append("\"").append("\n");
          stringBuilder.append("\"").append(E).append("\"").append("\n");
          stringBuilder.append("\"").append(F).append("\"").append("\n");
          stringBuilder.append("\"").append(G).append("\"").append("\n");
          stringBuilder.append("\"").append(H).append("\"").append("\n");
      }
      public static String requestResponse( String requestBody ) throws Exception {
        URL u = new URL(endPointURL);
        HttpURLConnection conn = (HttpURLConnection) u.openConnection();

        conn.setRequestProperty("Authorization","Bearer "+ key);
        conn.setRequestProperty("Content-Type","application/json");
        conn.setRequestMethod("POST");
        
        String body= new String(requestBody);
        
        conn.setDoOutput(true);
        OutputStreamWriter wr=new OutputStreamWriter(conn.getOutputStream());

        wr.write(body);
        wr.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        
        String decodedString;
        String responseString="";    

        while ((decodedString = in.readLine()) != null) 
    	  {
            response+=decodedString;
        }
    	  return responseString;
     }
    public static JSONObject jsonObject;
    public static String temp;
    public static String getPoint(String s){
        try {
            jsonObject = new JSONObject(s);
            JSONObject jsonObject1 = jsonObject.getJSONObject("Results").getJSONObject("output1").getJSONObject("value");
            String s1 = jsonObject1.getJSONArray("Values").getJSONArray(0).toString();
            input = Integer.parseInt(String.valueOf(s1.charAt(2)));
            temp = putValue(input);
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            return temp;
        }
    }
    public static int a = 1;
    public static int input;
    public static String areaCode;
    public static String putValue(int value) {
        map.put(1, "5,5");
        map.put(2, "14,3");
        map.put(3, "24,7");
        map.put(4, "24,9");
        map.put(5, "24,3");
        areaCode = map.get(value - 1);
        return areaCode;
    }
}
