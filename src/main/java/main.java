import pl.miroslawbrz.czarteruj.model.Address;
import pl.miroslawbrz.czarteruj.model.CharterPlace;
import pl.miroslawbrz.czarteruj.utils.JsonParse;

public class main {

    public static void main(String[] args) {
        JsonParse jsonParse = new JsonParse();
        Address address = new Address("Warszawa", "Bogusławskiego", "17");
        CharterPlace charterPlace = new CharterPlace();
        charterPlace.setAddress(address);
        jsonParse.setFullAddressAndCoordinatesFromApi(charterPlace);
    }
}
