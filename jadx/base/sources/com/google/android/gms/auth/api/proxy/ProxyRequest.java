package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Patterns;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@ShowFirstParty
@KeepForSdkWithMembers
@SafeParcelable.Class(creator = "ProxyRequestCreator")
public class ProxyRequest extends AbstractSafeParcelable {
    public static final int VERSION_CODE = 2;

    @NonNull
    @SafeParcelable.Field(m3227id = 4)
    public final byte[] body;

    @SafeParcelable.Field(m3227id = 2)
    public final int httpMethod;

    @SafeParcelable.Field(m3227id = 3)
    public final long timeoutMillis;

    @NonNull
    @SafeParcelable.Field(m3227id = 1)
    public final String url;

    @SafeParcelable.VersionField(m3230id = 1000)
    final int zza;

    @SafeParcelable.Field(m3227id = 5)
    Bundle zzb;

    @NonNull
    public static final Parcelable.Creator<ProxyRequest> CREATOR = new zza();
    public static final int HTTP_METHOD_GET = 0;
    public static final int HTTP_METHOD_POST = 1;
    public static final int HTTP_METHOD_PUT = 2;
    public static final int HTTP_METHOD_DELETE = 3;
    public static final int HTTP_METHOD_HEAD = 4;
    public static final int HTTP_METHOD_OPTIONS = 5;
    public static final int HTTP_METHOD_TRACE = 6;
    public static final int HTTP_METHOD_PATCH = 7;
    public static final int LAST_CODE = 7;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @ShowFirstParty
    @KeepForSdkWithMembers
    public static class Builder {
        private final String zza;
        private int zzb = ProxyRequest.HTTP_METHOD_GET;
        private long zzc = AiSTTListView.USER_SCROLL_INTERVAL;
        private byte[] zzd = new byte[0];
        private final Bundle zze = new Bundle();

        public Builder(@NonNull String str) {
            Preconditions.checkNotEmpty(str);
            if (!Patterns.WEB_URL.matcher(str).matches()) {
                throw new IllegalArgumentException(AbstractC0541b.m773o("The supplied url [ ", str, "] is not match Patterns.WEB_URL!"));
            }
            this.zza = str;
        }

        @NonNull
        public ProxyRequest build() {
            if (this.zzd == null) {
                this.zzd = new byte[0];
            }
            return new ProxyRequest(2, this.zza, this.zzb, this.zzc, this.zzd, this.zze);
        }

        @NonNull
        public Builder putHeader(@NonNull String str, @NonNull String str2) {
            Preconditions.checkNotEmpty(str, "Header name cannot be null or empty!");
            Bundle bundle = this.zze;
            if (str2 == null) {
                str2 = "";
            }
            bundle.putString(str, str2);
            return this;
        }

        @NonNull
        public Builder setBody(@NonNull byte[] bArr) {
            this.zzd = bArr;
            return this;
        }

        @NonNull
        public Builder setHttpMethod(int i) {
            boolean z = false;
            if (i >= 0 && i <= ProxyRequest.LAST_CODE) {
                z = true;
            }
            Preconditions.checkArgument(z, "Unrecognized http method code.");
            this.zzb = i;
            return this;
        }

        @NonNull
        public Builder setTimeoutMillis(long j) {
            Preconditions.checkArgument(j >= 0, "The specified timeout must be non-negative.");
            this.zzc = j;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public ProxyRequest(@SafeParcelable.Param(m3228id = 1000) int i, @SafeParcelable.Param(m3228id = 1) String str, @SafeParcelable.Param(m3228id = 2) int i2, @SafeParcelable.Param(m3228id = 3) long j, @SafeParcelable.Param(m3228id = 4) byte[] bArr, @SafeParcelable.Param(m3228id = 5) Bundle bundle) {
        this.zza = i;
        this.url = str;
        this.httpMethod = i2;
        this.timeoutMillis = j;
        this.body = bArr;
        this.zzb = bundle;
    }

    @NonNull
    public Map<String, String> getHeaderMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.zzb.size());
        for (String str : this.zzb.keySet()) {
            String string = this.zzb.getString(str);
            if (string == null) {
                string = "";
            }
            linkedHashMap.put(str, string);
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    @NonNull
    public String toString() {
        return AbstractC1974b.m1319l("ProxyRequest[ url: ", this.httpMethod, this.url, ", method: ", " ]");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.url, false);
        SafeParcelWriter.writeInt(parcel, 2, this.httpMethod);
        SafeParcelWriter.writeLong(parcel, 3, this.timeoutMillis);
        SafeParcelWriter.writeByteArray(parcel, 4, this.body, false);
        SafeParcelWriter.writeBundle(parcel, 5, this.zzb, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
