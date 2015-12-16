package net.rossharper.hexrot.sodaprovider;

import net.rossharper.hexrot.model.Price;
import net.rossharper.hexrot.model.Soda;
import net.rossharper.hexrot.model.Volume;
import net.rossharper.hexrot.sodalist.SodaList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

class SodaJsonParser {

    public class SodaJsonParserException extends Exception {
    }

    public SodaList parse(String response) throws SodaJsonParserException {
        JSONObject rootJsonObject = new JSONObject(response);
        JSONArray jsonArray = rootJsonObject.getJSONArray("sodaList");
        List<Soda> sodaList = parseSodaList(jsonArray);

        return new SodaList(sodaList);
    }

    private List<Soda> parseSodaList(JSONArray jsonArray) throws SodaJsonParserException {
        List<Soda> sodaList = new ArrayList<Soda>();
        for(int i = 0; i < jsonArray.length(); ++i) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            sodaList.add(parseSodaItem(jsonObject));
        }
        return sodaList;
    }
    
    // TODO: don't modify the list in place!
    private Soda parseSodaItem(JSONObject jsonObject) throws SodaJsonParserException {
        try {
            final String sodaName = parseSodaName(jsonObject);
            final Price sodaPrice = parseSodaPrice(jsonObject);
            final Volume sodaVolume = parseSodaVolume(jsonObject);
            return new Soda(sodaName, sodaPrice, sodaVolume);
        }
        catch(JSONException e) {
            throw new SodaJsonParserException();
        }
    }

    private Volume parseSodaVolume(JSONObject jsonObject) throws JSONException {
        int volumeInMillilitres = jsonObject.getInt("volume");
        return Volume.fromMillilitres(volumeInMillilitres);
    }

    private Price parseSodaPrice(JSONObject jsonObject) throws JSONException {
        int priceInPence = jsonObject.getInt("price");
        return Price.fromGbpPence(priceInPence);
    }

    private String parseSodaName(JSONObject jsonObject) throws JSONException {
        return jsonObject.getString("name");
    }
}
