package com.samsung.android.kmxservice.sdk.e2ee.data;

import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class PackageVO {

    @SerializedName("a")
    private final String mAppId;

    @SerializedName("b")
    private final String mPackageName;

    @SerializedName("d")
    private final String[] mServiceId;

    @SerializedName("c")
    private final String[] mSignature;

    public PackageVO(String str, String str2, String[] strArr, String[] strArr2) {
        this.mAppId = str;
        this.mPackageName = str2;
        this.mSignature = strArr;
        this.mServiceId = strArr2;
    }

    /* JADX INFO: renamed from: of */
    public static PackageVO m5526of(String str, String str2, String[] strArr, String[] strArr2) {
        return new PackageVO(str, str2, strArr, strArr2);
    }

    public String getAppId() {
        return this.mAppId;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public String[] getServiceId() {
        return this.mServiceId;
    }

    public String[] getSignature() {
        return this.mSignature;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.mSignature) {
            sb.append("\"");
            sb.append(str);
            sb.append("\",");
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : this.mServiceId) {
            sb2.append("\"");
            sb2.append(str2);
            sb2.append("\",");
        }
        return "{appId=" + this.mAppId + ",packageName=" + this.mPackageName + ",signature=" + ((Object) sb) + ",serviceId=" + ((Object) sb2) + "}";
    }
}
