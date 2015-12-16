package net.rossharper.hexrot.model;

// TODO: does soda really need to just be an interface or can it just be a simple bean?
public interface Soda {
    public String getName();
    public Price getPrice();
    public Volume getVolume();
}
