package pl.miroslawbrz.czarteruj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.miroslawbrz.czarteruj.model.Address;
import pl.miroslawbrz.czarteruj.model.CharterPlace;

import pl.miroslawbrz.czarteruj.service.GeoCoderApi;
import pl.miroslawbrz.czarteruj.service.JsonParse;


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
        GeoCoderApi geocoderApi = new GeoCoderApi();
        String url = geocoderApi.prepareRequest(address);
        Assertions.assertEquals(expectedUrl, url);
    }
    @Test
    void prepareRequestWithFullAddressTest(){
        String expectedUrl = "https://geocoder.ls.hereapi.com/6.2/geocode.json?apikey=B6z_NyiG71oD6yT8FTXsj6pVvH2-VfuJWaO3dP5c4RI&searchtext=1+x+x+Poland";
        Address address = new Address("x", "x", "1");
        GeoCoderApi geocoderApi = new GeoCoderApi();
        String url = geocoderApi.prepareRequest(address);
        Assertions.assertEquals(expectedUrl, url);
    }

   @Test
    void jsonParseTest(){
       JsonParse jsonParse = new JsonParse();
       Address address = new Address("Warszawa", "Bogusławskiego", "17");
       CharterPlace charterPlace = new CharterPlace();
       charterPlace.setAddress(address);
       jsonParse.setFullAddressAndCoordinatesFromApi(charterPlace);
       Assertions.assertNotNull(address.getPostalCode());
    }



}
