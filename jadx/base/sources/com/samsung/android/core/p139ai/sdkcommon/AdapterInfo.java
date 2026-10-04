package com.samsung.android.core.p139ai.sdkcommon;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.layout.AbstractC1038a;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001%B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0012\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u000e\u0010\u0010\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0003J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J1\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0018HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u0011¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/core/ai/sdkcommon/AdapterInfo;", "Landroid/os/Parcelable;", "loraConfigJson", "", "samplerJson", "loraName", "language", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getLoraConfigJson", "()Ljava/lang/String;", "getSamplerJson", "getLoraName", "setLoraName", "(Ljava/lang/String;)V", "getLanguage", "setLanguage", "", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class AdapterInfo implements Parcelable {

    @NotNull
    private String language;

    @NotNull
    private final String loraConfigJson;

    @NotNull
    private String loraName;

    @NotNull
    private final String samplerJson;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<AdapterInfo> CREATOR = new Parcelable.Creator<AdapterInfo>() { // from class: com.samsung.android.core.ai.sdkcommon.AdapterInfo$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdapterInfo createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new AdapterInfo(source, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdapterInfo[] newArray(int size) {
            return new AdapterInfo[size];
        }
    };

    public /* synthetic */ AdapterInfo(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    public static /* synthetic */ AdapterInfo copy$default(AdapterInfo adapterInfo, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adapterInfo.loraConfigJson;
        }
        if ((i & 2) != 0) {
            str2 = adapterInfo.samplerJson;
        }
        if ((i & 4) != 0) {
            str3 = adapterInfo.loraName;
        }
        if ((i & 8) != 0) {
            str4 = adapterInfo.language;
        }
        return adapterInfo.copy(str, str2, str3, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLoraConfigJson() {
        return this.loraConfigJson;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSamplerJson() {
        return this.samplerJson;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLoraName() {
        return this.loraName;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    @NotNull
    public final AdapterInfo copy(@NotNull String loraConfigJson, @NotNull String samplerJson, @NotNull String loraName, @NotNull String language) {
        Intrinsics.checkNotNullParameter(loraConfigJson, "loraConfigJson");
        Intrinsics.checkNotNullParameter(samplerJson, "samplerJson");
        Intrinsics.checkNotNullParameter(loraName, "loraName");
        Intrinsics.checkNotNullParameter(language, "language");
        return new AdapterInfo(loraConfigJson, samplerJson, loraName, language);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdapterInfo)) {
            return false;
        }
        AdapterInfo adapterInfo = (AdapterInfo) other;
        return Intrinsics.areEqual(this.loraConfigJson, adapterInfo.loraConfigJson) && Intrinsics.areEqual(this.samplerJson, adapterInfo.samplerJson) && Intrinsics.areEqual(this.loraName, adapterInfo.loraName) && Intrinsics.areEqual(this.language, adapterInfo.language);
    }

    @NotNull
    public final String getLanguage() {
        return this.language;
    }

    @NotNull
    public final String getLoraConfigJson() {
        return this.loraConfigJson;
    }

    @NotNull
    public final String getLoraName() {
        return this.loraName;
    }

    @NotNull
    public final String getSamplerJson() {
        return this.samplerJson;
    }

    public int hashCode() {
        return this.language.hashCode() + AbstractC1038a.m1202c(AbstractC1038a.m1202c(this.loraConfigJson.hashCode() * 31, 31, this.samplerJson), 31, this.loraName);
    }

    public final void setLanguage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.language = str;
    }

    /* JADX INFO: renamed from: setLoraName, reason: collision with other method in class */
    public final void m22152setLoraName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.loraName = str;
    }

    @NotNull
    public String toString() {
        String str = this.loraConfigJson;
        String str2 = this.samplerJson;
        return AbstractC0541b.m776r(AbstractC0000a.m16m("AdapterInfo(loraConfigJson=", str, ", samplerJson=", str2, ", loraName="), this.loraName, ", language=", this.language, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.loraConfigJson);
        parcel.writeString(this.samplerJson);
        parcel.writeString(this.loraName);
        parcel.writeString(this.language);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdapterInfo(@NotNull String loraConfigJson) {
        this(loraConfigJson, null, null, null, 14, null);
        Intrinsics.checkNotNullParameter(loraConfigJson, "loraConfigJson");
    }

    public final byte setLoraName(@NotNull String loraName) {
        Intrinsics.checkNotNullParameter(loraName, "loraName");
        String lowerCase = loraName.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        this.loraName = lowerCase;
        return (byte) 0;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdapterInfo(@NotNull String loraConfigJson, @NotNull String samplerJson) {
        this(loraConfigJson, samplerJson, null, null, 12, null);
        Intrinsics.checkNotNullParameter(loraConfigJson, "loraConfigJson");
        Intrinsics.checkNotNullParameter(samplerJson, "samplerJson");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdapterInfo(@NotNull String loraConfigJson, @NotNull String samplerJson, @NotNull String loraName) {
        this(loraConfigJson, samplerJson, loraName, null, 8, null);
        Intrinsics.checkNotNullParameter(loraConfigJson, "loraConfigJson");
        Intrinsics.checkNotNullParameter(samplerJson, "samplerJson");
        Intrinsics.checkNotNullParameter(loraName, "loraName");
    }

    @JvmOverloads
    public AdapterInfo(@NotNull String loraConfigJson, @NotNull String samplerJson, @NotNull String loraName, @NotNull String language) {
        Intrinsics.checkNotNullParameter(loraConfigJson, "loraConfigJson");
        Intrinsics.checkNotNullParameter(samplerJson, "samplerJson");
        Intrinsics.checkNotNullParameter(loraName, "loraName");
        Intrinsics.checkNotNullParameter(language, "language");
        this.loraConfigJson = loraConfigJson;
        this.samplerJson = samplerJson;
        this.loraName = loraName;
        this.language = language;
    }

    public /* synthetic */ AdapterInfo(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private AdapterInfo(Parcel parcel) {
        String string = parcel.readString();
        string = string == null ? "" : string;
        String string2 = parcel.readString();
        string2 = string2 == null ? "" : string2;
        String string3 = parcel.readString();
        string3 = string3 == null ? "" : string3;
        String string4 = parcel.readString();
        this(string, string2, string3, string4 != null ? string4 : "");
    }
}
