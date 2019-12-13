package pl.miroslawbrz.czarteruj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.miroslawbrz.czarteruj.model.Address;
import pl.miroslawbrz.czarteruj.service.GeocoderApi;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


class GeoCoderApiTests {

    @Test
    void connectionTest() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL("https://geocoder.ls.hereapi.com/6.2/geocode.json?apikey=B6z_NyiG71oD6yT8FTXsj6pVvH2-VfuJWaO3dP5c4RI&searchtext=17+Bogus%C5%82awskiego+Warszawa+Poland").openConnection();
        int responseCode = connection.getResponseCode();
        Assertions.assertEquals(200, responseCode);
    }

    @Test
    void prepareRequestWithEmptyAddressTest(){
        String expectedUrl = "https://geocoder.ls.hereapi.com/6.2/geocode.json?apikey=B6z_NyiG71oD6yT8FTXsj6pVvH2-VfuJWaO3dP5c4RI&searchtext=Poland";
        Address address = new Address();
        GeocoderApi geocoderApi = new GeocoderApi();
        String url = geocoderApi.prepareRequest(address);
        Assertions.assertEquals(expectedUrl, url);
    }
    @Test
    void prepareRequestWithFullAddressTest(){
        String expectedUrl = "https://geocoder.ls.hereapi.com/6.2/geocode.json?apikey=B6z_NyiG71oD6yT8FTXsj6pVvH2-VfuJWaO3dP5c4RI&searchtext=1+x+x+Poland";
        Address address = new Address("x", "x", "1");
        GeocoderApi geocoderApi = new GeocoderApi();
        String url = geocoderApi.prepareRequest(address);
        Assertions.assertEquals(expectedUrl, url);
    }



}
