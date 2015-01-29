package net.rossharper.hexrot.android.sodalist;

import net.rossharper.hexrot.model.Price;
import net.rossharper.hexrot.model.Soda;
import net.rossharper.hexrot.model.Volume;
import net.rossharper.hexrot.sodalist.SodaList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SodaJsonParser {
    public SodaList parse(String response) throws JSONException {
        List<Soda> sodaList = new ArrayList<Soda>();

        JSONObject rootJsonObject = new JSONObject(response);
        JSONArray jsonArray = rootJsonObject.getJSONArray("sodaList");
        parseSodaList(sodaList, jsonArray);

        return new SodaList(sodaList);
    }

    private void parseSodaList(List<Soda> sodaList, JSONArray jsonArray) throws JSONException {
        for(int i = 0; i < jsonArray.length(); ++i) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            parseSodaItem(sodaList, jsonObject);
        }
    }

    private void parseSodaItem(List<Soda> sodaList, JSONObject jsonObject) throws JSONException {
        final String sodaName = parseSodaName(jsonObject);
        final Price sodaPrice = parseSodaPrice(jsonObject);
        final Volume sodaVolume = parseSodaVolume(jsonObject);
        sodaList.add(new Soda() {
            @Override
            public String getName() {
                return sodaName;
            }

            @Override
            public Price getPrice() {
                return sodaPrice;
            }

            @Override
            public Volume getVolume() {
                return sodaVolume;
            }
        });
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
