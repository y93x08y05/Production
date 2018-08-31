package com.example.t_tazhan.production.util;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.*;
import java.io.*;
import java.util.*;
public class AzureMLClient {
    private static String endPointURL = "https://ussouthcentral.services.azureml.net/workspaces/f06b40ea77054bb2a012415b06082698/services/f234e6385c0c491cb343d013067e8ee8/execute?api-version=2.0&details=true\n";
    private static String key= "/bFwuPdF99daya1iRfEZyFV3mJb+9CGf51H7ut4LE1iyrtRM6MFlx5RN9rdE+hpdVQp4PHnkxjp9oXugyPRZuA==";
    public static String requestBody = "{\n" +
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
    public static String A = "0",B = "0",C = "0",D = "0",E = "0",F = "0",G = "0",H = "0";
      public static StringBuilder stringBuilder = new StringBuilder();
      public static String transferBeacon(TreeMap<String,String> map){
                A = map.get("A");
                B = map.get("B");
                C = map.get("C");
                D = map.get("D");
                E = map.get("E");
                F = map.get("F");
                G = map.get("G");
                H = map.get("H");
          System.out.println("信标map的大小为：" + map.size() + "输出信标值：" + A + " " +
                  B + " " + C + " " + D + " " + E + " " + F + " " + G + " " + H + " ");
            stringBuilder.append(requestBody1);
            appendString();
            stringBuilder.append(requestBody3);
            appendString();
            stringBuilder.append(requestBody2);
            return stringBuilder.toString();
      }
      public static void appendString(){
          stringBuilder.append("\"").append(A).append("\"").append(",").append("\n");
          stringBuilder.append("\"").append(B).append("\"").append(",").append("\n");
          stringBuilder.append("\"").append(C).append("\"").append(",").append("\n");
          stringBuilder.append("\"").append(D).append("\"").append(",").append("\n");
          stringBuilder.append("\"").append(E).append("\"").append(",").append("\n");
          stringBuilder.append("\"").append(F).append("\"").append(",").append("\n");
          stringBuilder.append("\"").append(G).append("\"").append(",").append("\n");
          stringBuilder.append("\"").append(H).append("\"").append(",").append("\n");
      }
      public static String requestResponse( String requestBody ) {
          createData(arr);
          HttpURLConnection conn = null;
          StringBuilder responseString = new StringBuilder();
              try {
                  URL u = new URL(endPointURL);
                  conn = (HttpURLConnection) u.openConnection();
                  conn.setRequestProperty("Authorization","Bearer "+ key);
                  conn.setRequestProperty("Content-Type","application/json");
                  conn.setRequestMethod("POST");
                  conn.setDoOutput(true);
                  String body= new String(requestBody);
                  OutputStreamWriter wr=new OutputStreamWriter(conn.getOutputStream());
                  wr.write(body);
                  wr.close();
                  BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                  String decodedString;
                  while ((decodedString = in.readLine()) != null) {
                      responseString.append(decodedString).append("\r");
                  }
              } catch (IOException e) {
                  e.printStackTrace();
              } finally {
                  if (conn != null) {
                      try {
                          conn.getInputStream().close();
                      } catch (IOException e) {
                          e.printStackTrace();
                      }
                  }
                  return responseString.toString();
              }
      }
    public static JSONObject jsonObject;
    public static List<Integer> temp;
    public static List<Integer> getPoint(String s){
        try {
            jsonObject = new JSONObject(s);
            JSONObject jsonObject1 = jsonObject.getJSONObject("Results").getJSONObject("output1").getJSONObject("value");
            String s1 = jsonObject1.getJSONArray("Values").getJSONArray(0).toString();
            input = Integer.parseInt(String.valueOf(s1.charAt(2)));
            System.out.println("API Request"+input);
            temp = getData(input);
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            return temp;
        }
    }
    public static int a = 1;
    public static int input;
    private static Map<Integer,List<Integer>> map=new HashMap<>();
    private static int [][]arr={{5,2},{5,6},{5,11},{5,15},{5,19}, {5,23},
            {11,2},{11,6},{11,11},{11,15},{11,19}, {11,23}};
    private static void createData(int [][]arr) {
        for (int i=0;i<12;i++) {
            List<Integer> list=new ArrayList<>();
            list.add(arr[i][0]);
            list.add(arr[i][1]);
            map.put(i+1,list);
        }
    }
    private static List<Integer> getData(int key) {
        return map.get(key);
    }
}
