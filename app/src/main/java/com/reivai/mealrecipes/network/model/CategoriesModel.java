package com.reivai.mealrecipes.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoriesModel implements Parcelable {

    @Expose
    @SerializedName("strCategoryDescription")
    public String strCategoryDescription;
    @Expose
    @SerializedName("strCategoryThumb")
    public String strCategoryThumb;
    @Expose
    @SerializedName("strCategory")
    public String strCategory;
    @Expose
    @SerializedName("idCategory")
    public String idCategory;

    protected CategoriesModel(Parcel in) {
        strCategoryDescription = in.readString();
        strCategoryThumb = in.readString();
        strCategory = in.readString();
        idCategory = in.readString();
    }

    public static final Creator<CategoriesModel> CREATOR = new Creator<CategoriesModel>() {
        @Override
        public CategoriesModel createFromParcel(Parcel in) {
            return new CategoriesModel(in);
        }

        @Override
        public CategoriesModel[] newArray(int size) {
            return new CategoriesModel[size];
        }
    };

    public String getStrCategoryDescription() {
        return strCategoryDescription;
    }

    public void setStrCategoryDescription(String strCategoryDescription) {
        this.strCategoryDescription = strCategoryDescription;
    }

    public String getStrCategoryThumb() {
        return strCategoryThumb;
    }

    public void setStrCategoryThumb(String strCategoryThumb) {
        this.strCategoryThumb = strCategoryThumb;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public int describeContents() {
        return this.describeContents();
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(strCategoryDescription);
        parcel.writeString(strCategoryThumb);
        parcel.writeString(strCategory);
        parcel.writeString(idCategory);
    }
}
