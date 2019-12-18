package pl.miroslawbrz.czarteruj.utils;


import org.json.JSONArray;
import org.json.JSONObject;
import pl.miroslawbrz.czarteruj.model.Address;
import pl.miroslawbrz.czarteruj.model.CharterPlace;
import pl.miroslawbrz.czarteruj.utils.GeoCoderApi;

public class JsonParse {


    public void setFullAddressAndCoordinatesFromApi(CharterPlace charterPlace){
        Address address = charterPlace.getAddress();
        GeoCoderApi geoCoderApi = new GeoCoderApi();
        String url = geoCoderApi.prepareRequest(address);
        String json = geoCoderApi.apiResponse(url);
        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONObject("Response").getJSONArray("View");
        JSONArray jsonArrayResult = null;
        for (int i = 0; i < jsonArray.length(); i++){
            jsonArrayResult = jsonArray.getJSONObject(i).getJSONArray("Result");
        }
        JSONObject jsonArrayLocation = null;
        for (int i = 0; i < jsonArray.length(); i++){
            jsonArrayLocation = jsonArrayResult.getJSONObject(i).getJSONObject("Location");
        }

        JSONArray jsonArrayNavPosition = null;
        JSONObject jsonObjectAddress = null;

        if(jsonArrayLocation!=null){
        for(int i = 0; i < jsonArrayLocation.length(); i++) {
            jsonObjectAddress = jsonArrayLocation.getJSONObject("Address");
            jsonArrayNavPosition = jsonArrayLocation.getJSONArray("NavigationPosition");
        }

        if(jsonObjectAddress!=null) {
            address.setCity(jsonObjectAddress.getString("City"));
            address.setBuildingNumber(jsonObjectAddress.getString("HouseNumber"));
            address.setPostalCode(jsonObjectAddress.getString("PostalCode"));
            address.setStreet(jsonObjectAddress.getString("Street"));
        }

        if(jsonArrayNavPosition!=null){
            for(int i = 0; i < jsonArray.length(); i++){
                charterPlace.setMapLongitude(jsonArrayNavPosition.getJSONObject(i).getDouble("Longitude"));
                charterPlace.setMapLatitude(jsonArrayNavPosition.getJSONObject(i).getDouble("Latitude"));
            }

        }




        }
    }


}
