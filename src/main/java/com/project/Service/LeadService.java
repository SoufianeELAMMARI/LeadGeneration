package com.project.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dto.Facebook.FacebookParser;
import com.project.dto.youtube.YoutubeParser;
import com.project.entity.Lead;
import com.project.repository.LeadRepository;
import com.project.util.Util;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class LeadService {

    private static final String apiYoutube = "https://www.googleapis.com/youtube/v3/commentThreads?part=snippet&videoId=gD3KOVAD62k&key=AIzaSyAObvP_pWs_joK5QIyEiaqLL3r9QgUdCR8&maxResults=100";
    private static final String apiFacebook = "https://graph.facebook.com/v2.12/me?fields=id%2Cname%2Cposts%7Bcomments%7D&access_token=EAAMsyAHsNAQBADoSA6t83W9MnNT5bpuCzrxQZAMeEoOARlsXBa3B19al8zMlZAxzDnMHx9AE1EFYi1zokvqUWkVkxGOHeswXghBpH66yvA2csfMYSedEt2I8ON8uU6ZCnWGHOaW58eZA5d3SGSG1B4pPN1eczsziKQZBHtOdocgZDZD";

    @Autowired
    private LeadRepository leadRepository;

    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    @Scheduled(fixedDelay = 10000) //every 10 seconds
    public void getLeadFromYoutube() throws IOException, JSONException {
        try {
            URL obj = new URL(apiYoutube);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject myresponse = new JSONObject(response.toString());
            List<Lead> leads = new ArrayList<>();


            YoutubeParser y = new ObjectMapper().readerFor(YoutubeParser.class).readValue(myresponse.toString());
            if (y.items.size() > 0) {
                for (int i = 0; i < y.items.size(); i++) {
                    if (leadRepository.findByIdYoutube(y.items.get(i).snippet.topLevelComment.snippet.authorChannelId.value) == null) {
                        Lead l = new Lead();
                        String text = y.items.get(i).snippet.topLevelComment.snippet.textOriginal;
                        l.setEmail(Util.getEmailFromText(text));
                        l.setPhone(Util.getPhoneFromText(text));
                        l.setIdYoutube(y.items.get(i).snippet.topLevelComment.snippet.authorChannelId.value);
                        l.setNom(y.items.get(i).snippet.topLevelComment.snippet.authorDisplayName);

                        leads.add(l);
                    }
                }
                leadRepository.saveAll(leads);


            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    //@Scheduled(fixedDelay = 2000) //every 2 seconds
    public void getLeadFromFacebook() throws IOException, JSONException {
        String text = "";
        URL obj = new URL(apiFacebook);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        int responseCode = con.getResponseCode();
        // System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();


        JSONObject myresponse = new JSONObject(response.toString());
        System.out.println(myresponse);
        List<Lead> leads = new ArrayList<Lead>();
        Lead l = new Lead();
        FacebookParser y = new ObjectMapper().readerFor(FacebookParser.class).readValue(myresponse.toString());
        try {
            for (int i = 0; i < y.posts.data.size(); i++) {
                for (int p = 0; p < y.posts.data.get(i).comments.data.size(); p++) {

                    if (leadRepository.findByIdFacebook(y.posts.data.get(i).comments.data.get(p).from.id) == null) {
                        text = y.posts.data.get(i).comments.data.get(p).message;
                        l.setNom(y.posts.data.get(i).comments.data.get(p).from.name);
                        l.setEmail(Util.getEmailFromText(text));
                        l.setPhone(Util.getPhoneFromText(text));
                        l.setIdFacebook(y.posts.data.get(i).comments.data.get(p).from.id);
                        leadRepository.save(l);

                    }
                }

            }

        } catch (Exception e) {
            System.out.println("Prob");
        }


    }
}
