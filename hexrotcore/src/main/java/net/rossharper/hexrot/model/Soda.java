package net.rossharper.hexrot.model;

public class Soda {

    private final String name;
    private final Price price;
    private final Volume volume;

    public Soda(String name, Price price, Volume volume) {

        this.name = name;
        this.price = price;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public Volume getVolume() {
        return volume;
    }
}
