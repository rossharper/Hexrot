package net.rossharper.hexrot.android.sodadetails;

import android.os.Parcel;
import android.os.Parcelable;

import net.rossharper.hexrot.model.Price;
import net.rossharper.hexrot.model.Soda;
import net.rossharper.hexrot.model.Volume;

public class SodaParcel implements Parcelable {
    private Soda mSoda;

    public SodaParcel(Soda soda) {
        mSoda = soda;
    }

    public SodaParcel(final Parcel source) {
        mSoda = new Soda() {
            @Override
            public String getName() {
                return source.readString();
            }

            @Override
            public Price getPrice() {
                return Price.fromGbpPence(source.readInt());
            }

            @Override
            public Volume getVolume() {
                return Volume.fromMillilitres(source.readInt());
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mSoda.getName());
        parcel.writeInt(mSoda.getPrice().getPriceInPence());
        parcel.writeInt(mSoda.getVolume().getVolumeInMillilitres());
    }

    public static final Parcelable.Creator<SodaParcel> CREATOR = new Parcelable.Creator<SodaParcel>() {

        @Override
        public SodaParcel createFromParcel(Parcel source) {
            return new SodaParcel(source);
        }

        @Override
        public SodaParcel[] newArray(int size) {
            return new SodaParcel[size];
        }

    };

    public Soda getSoda() {
        return mSoda;
    }
}
