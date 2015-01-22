package net.rossharper.hexrot.sodalist;

import net.rossharper.hexrot.model.Soda;

import java.util.List;

public class SodaList {
    private List<Soda> mSodaList;

    public SodaList(List<Soda> sodaList) {
        mSodaList = sodaList;
    }

    public int size() {
        return mSodaList.size();
    }

    public Soda get(int i) {
        return mSodaList.get(i);
    }
}
