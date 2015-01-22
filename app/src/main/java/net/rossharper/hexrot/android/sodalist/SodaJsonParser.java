package net.rossharper.hexrot.android.sodalist;

import net.rossharper.hexrot.model.Soda;
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
        for(int i = 0; i < jsonArray.length(); ++i) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            final String sodaName = jsonObject.getString("name");
            sodaList.add(new Soda() {
                @Override
                public String getName() {
                    return sodaName;
                }
            });
        }

        return new SodaList(sodaList);
    }
}
