package com.samsung.android.sivs.p144ai.sdkcommon.asr;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.compose.foundation.layout.AbstractC1038a;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class ServerInfo extends ServerType {
    public static final Parcelable.Creator<ServerInfo> CREATOR = new Parcelable.Creator<ServerInfo>() { // from class: com.samsung.android.sivs.ai.sdkcommon.asr.ServerInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ServerInfo createFromParcel(Parcel parcel) {
            return new ServerInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ServerInfo[] newArray(int i) {
            return new ServerInfo[i];
        }
    };
    private final String endpoint;

    public ServerInfo(ServerFeature serverFeature, @NonNull String str, @NonNull String str2) {
        super(serverFeature, str);
        this.endpoint = str2;
    }

    @Override // com.samsung.android.sivs.p144ai.sdkcommon.asr.ServerType, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.samsung.android.sivs.p144ai.sdkcommon.asr.ServerType
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && super.equals(obj)) {
            return this.endpoint.equals(((ServerInfo) obj).endpoint);
        }
        return false;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    @Override // com.samsung.android.sivs.p144ai.sdkcommon.asr.ServerType
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.endpoint);
    }

    @Override // com.samsung.android.sivs.p144ai.sdkcommon.asr.ServerType
    public String toString() {
        StringBuilder sb = new StringBuilder("ServerInfo{endpoint='");
        sb.append(this.endpoint);
        sb.append("', ");
        return AbstractC1038a.m1213n('}', super.toString(), sb);
    }

    @Override // com.samsung.android.sivs.p144ai.sdkcommon.asr.ServerType, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.endpoint);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ServerInfo(ServerFeature serverFeature, @NonNull String str, @NonNull String str2, boolean z) {
        super(serverFeature, str, z);
        this.endpoint = str2;
    }

    public ServerInfo(Parcel parcel) {
        super(parcel);
        this.endpoint = parcel.readString();
    }
}
