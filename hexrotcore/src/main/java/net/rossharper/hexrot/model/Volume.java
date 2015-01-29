package net.rossharper.hexrot.model;

import java.math.BigDecimal;

public class Volume {
    private final BigDecimal mVolume;

    private Volume(int millilitres) {
        mVolume = new BigDecimal(millilitres).movePointLeft(3);
    }

    public static Volume fromMillilitres(int millilitres) {
        return new Volume(millilitres);
    }

    public int getVolumeInMillilitres() {
        return mVolume.movePointRight(3).intValue();
    }

    @Override
    public String toString() {
        return mVolume.stripTrailingZeros().toString() + "l";
    }
}
