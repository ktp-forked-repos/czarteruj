package pl.miroslawbrz.czarteruj.service;

import pl.miroslawbrz.czarteruj.constans.ApiUrl;
import pl.miroslawbrz.czarteruj.model.Address;
import pl.miroslawbrz.czarteruj.model.CharterPlace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GocoderApi {

    public String apiResponse(String request){

        String response = null;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(request).openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getResponseCode() == 200 ? connection.getInputStream():connection.getErrorStream()
            ));
            String line = "";
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            response = stringBuilder.toString();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

        return response;
    }


    public String prepareRequest(CharterPlace charterPlace){
        String url = ApiUrl.GEO_CODER_URL;
        String apiKey = ApiUrl.GEO_CODER_API_KEY;

        Address address = charterPlace.getAddress();

        StringBuilder sb = new StringBuilder();
        sb.append(url).append(apiKey);

        if(address.getBuildingNumber() != null){
            sb.append(address.getBuildingNumber()).append("+");
        }
        if(address.getStreet() != null){
            sb.append(address.getStreet()).append("+");
        }
        if (address.getCity() != null){
            sb.append(address.getCity()).append("+");
        }
        sb.append(address.getCountry());

        return sb.toString();
    }

}
