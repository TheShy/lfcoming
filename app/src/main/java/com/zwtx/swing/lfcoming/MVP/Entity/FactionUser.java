package com.zwtx.swing.lfcoming.MVP.Entity;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by SuperSow
 */

public class FactionUser implements Parcelable {

    private String faction_Url;
    private String faction_name;

    public FactionUser(String faction_Url, String faction_name) {
        this.faction_Url = faction_Url;
        this.faction_name = faction_name;
    }

    public String getFaction_Url() {
        return faction_Url;
    }

    public void setFaction_Url(String faction_Url) {
        this.faction_Url = faction_Url;
    }

    public String getFaction_name() {
        return faction_name;
    }

    public void setFaction_name(String faction_name) {
        this.faction_name = faction_name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.faction_Url);
        dest.writeString(this.faction_name);

    }

    public FactionUser() {
    }

    protected FactionUser(Parcel in) {
        this.faction_name = in.readString();
        this.faction_Url = in.readString();
    }

    public static final Parcelable.Creator<FactionUser> CREATOR = new Parcelable.Creator<FactionUser>() {
        @Override
        public FactionUser createFromParcel(Parcel source) {
            return new FactionUser(source);
        }

        @Override
        public FactionUser[] newArray(int size) {
            return new FactionUser[size];
        }
    };
}
