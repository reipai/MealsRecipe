package com.reivai.mealrecipes.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AreaModel implements Parcelable {
    @Expose
    @SerializedName("strArea")
    private String strArea;

    protected AreaModel(Parcel in) {
        strArea = in.readString();
    }

    public static final Creator<AreaModel> CREATOR = new Creator<AreaModel>() {
        @Override
        public AreaModel createFromParcel(Parcel in) {
            return new AreaModel(in);
        }

        @Override
        public AreaModel[] newArray(int size) {
            return new AreaModel[size];
        }
    };

    public String getStrArea() {
        return strArea;
    }

    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }

    @Override
    public int describeContents() {
        return this.describeContents();
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(strArea);
    }
}
