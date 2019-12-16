import org.json.JSONArray;
import org.json.JSONObject;
import pl.miroslawbrz.czarteruj.model.Address;
import pl.miroslawbrz.czarteruj.model.CharterPlace;
import pl.miroslawbrz.czarteruj.service.GeoCoderApi;
import pl.miroslawbrz.czarteruj.service.JsonParse;

public class main {

    public static void main(String[] args) {
        JsonParse jsonParse = new JsonParse();
        Address address = new Address("Warszawa", "Bogusławskiego", "17");
        CharterPlace charterPlace = new CharterPlace();
        charterPlace.setAddress(address);
        jsonParse.setFullAddressAndCoordinatesFromApi(charterPlace);
    }
}
