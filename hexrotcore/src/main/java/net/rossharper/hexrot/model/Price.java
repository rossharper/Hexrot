package net.rossharper.hexrot.model;

import java.math.BigDecimal;
import java.util.Currency;

public class Price {
    private final BigDecimal mPrice;
    private Currency mCurrency;

    private Price(Currency currency, int priceInPence) {
        mCurrency = currency;
        mPrice = new BigDecimal(priceInPence).movePointLeft(2);
    }

    public static Price fromGbpPence(int priceInPence) {
        return new Price(Currency.getInstance("GBP"), priceInPence);
    }

    public int getPriceInPence() {
        return mPrice.movePointRight(2).intValue();
    }

    @Override
    public String toString() {
        return mCurrency.getSymbol() + mPrice.toString();
    }
}
