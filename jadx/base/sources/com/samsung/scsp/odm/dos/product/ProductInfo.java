package com.samsung.scsp.odm.dos.product;

import com.google.gson.annotations.SerializedName;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ProductInfo {

    @SerializedName("products")
    public List<Product> products;

    @SerializedName("unregistered")
    public List<String> unregistered;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Item {

        @SerializedName("file")
        public ProductFile file;

        @SerializedName("name")
        public String name;

        @SerializedName("type")
        public String type;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Product {

        @SerializedName("color")
        public String color;

        @SerializedName("division")
        public String division;

        @SerializedName("images")
        public List<Item> images;

        @SerializedName("keySpec")
        public String keySpec;

        @SerializedName("marketingName")
        public String marketingName;

        @SerializedName(IdentityApiContract.Parameter.MODEL_CODE)
        public String modelCode;

        @SerializedName(IdentityApiContract.Parameter.MODEL_NAME)
        public String modelName;

        @SerializedName("modifiedDate")
        public String modifiedDate;
    }
}
