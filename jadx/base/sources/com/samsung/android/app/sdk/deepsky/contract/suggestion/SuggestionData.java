package com.samsung.android.app.sdk.deepsky.contract.suggestion;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.core.app.FrameMetricsAggregator;
import androidx.glance.AbstractC2821a;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b%\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 B2\u00020\u0001:\u0001BB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Bi\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\t\u0010-\u001a\u00020\u0006HÂ\u0003J\t\u0010.\u001a\u00020\u0006HÂ\u0003J\t\u0010/\u001a\u00020\u0006HÂ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\nHÂ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\nHÂ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\rHÂ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u000fHÂ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0006HÂ\u0003J\t\u00105\u001a\u00020\u0012HÂ\u0003Jm\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\b\u00107\u001a\u000208H\u0016J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\t\u0010=\u001a\u000208HÖ\u0001J\t\u0010>\u001a\u00020\u0006HÖ\u0001J\u0018\u0010?\u001a\u00020@2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010A\u001a\u000208H\u0016R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010 \u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b!\u0010\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\"\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b#\u0010\u001cR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010$\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b(\u0010\u001cR\u0011\u0010)\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b*\u0010\u001cR\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010+\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b,\u0010\u001cR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "idParam", "", "titleParam", "descriptionParam", "iconParam", "Landroid/net/Uri;", "backgroundParam", "extrasParam", "Landroid/os/Bundle;", "structuredDataParam", "Lorg/json/JSONObject;", "urlParam", "creationTimeParam", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Landroid/net/Uri;Landroid/os/Bundle;Lorg/json/JSONObject;Ljava/lang/String;J)V", "background", "getBackground", "()Landroid/net/Uri;", "creationTime", "getCreationTime", "()J", "description", "getDescription", "()Ljava/lang/String;", "extras", "getExtras", "()Landroid/os/Bundle;", "icon", "getIcon", "id", "getId", "structuredData", "getStructuredData", "()Lorg/json/JSONObject;", "suggestionFrom", "getSuggestionFrom", "title", DynamicActionBarProvider.METHOD_GET_DATA, "url", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class SuggestionData implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final Uri backgroundParam;
    private final long creationTimeParam;

    @NotNull
    private final String descriptionParam;

    @Nullable
    private final Bundle extrasParam;

    @Nullable
    private final Uri iconParam;

    @NotNull
    private final String idParam;

    @Nullable
    private final JSONObject structuredDataParam;

    @NotNull
    private final String titleParam;

    @Nullable
    private final String urlParam;

    /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionData$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionData;", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion implements Parcelable.Creator<SuggestionData> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SuggestionData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SuggestionData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SuggestionData[] newArray(int size) {
            return new SuggestionData[size];
        }
    }

    public SuggestionData() {
        this(null, null, null, null, null, null, null, null, 0L, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final String getIdParam() {
        return this.idParam;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final String getTitleParam() {
        return this.titleParam;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final String getDescriptionParam() {
        return this.descriptionParam;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final Uri getIconParam() {
        return this.iconParam;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    private final Uri getBackgroundParam() {
        return this.backgroundParam;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    private final Bundle getExtrasParam() {
        return this.extrasParam;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    private final JSONObject getStructuredDataParam() {
        return this.structuredDataParam;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    private final String getUrlParam() {
        return this.urlParam;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    private final long getCreationTimeParam() {
        return this.creationTimeParam;
    }

    public static /* synthetic */ SuggestionData copy$default(SuggestionData suggestionData, String str, String str2, String str3, Uri uri, Uri uri2, Bundle bundle, JSONObject jSONObject, String str4, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = suggestionData.idParam;
        }
        if ((i & 2) != 0) {
            str2 = suggestionData.titleParam;
        }
        if ((i & 4) != 0) {
            str3 = suggestionData.descriptionParam;
        }
        if ((i & 8) != 0) {
            uri = suggestionData.iconParam;
        }
        if ((i & 16) != 0) {
            uri2 = suggestionData.backgroundParam;
        }
        if ((i & 32) != 0) {
            bundle = suggestionData.extrasParam;
        }
        if ((i & 64) != 0) {
            jSONObject = suggestionData.structuredDataParam;
        }
        if ((i & 128) != 0) {
            str4 = suggestionData.urlParam;
        }
        if ((i & 256) != 0) {
            j = suggestionData.creationTimeParam;
        }
        long j2 = j;
        JSONObject jSONObject2 = jSONObject;
        String str5 = str4;
        Uri uri3 = uri2;
        Bundle bundle2 = bundle;
        return suggestionData.copy(str, str2, str3, uri, uri3, bundle2, jSONObject2, str5, j2);
    }

    @NotNull
    public final SuggestionData copy(@NotNull String idParam, @NotNull String titleParam, @NotNull String descriptionParam, @Nullable Uri iconParam, @Nullable Uri backgroundParam, @Nullable Bundle extrasParam, @Nullable JSONObject structuredDataParam, @Nullable String urlParam, long creationTimeParam) {
        Intrinsics.checkNotNullParameter(idParam, "idParam");
        Intrinsics.checkNotNullParameter(titleParam, "titleParam");
        Intrinsics.checkNotNullParameter(descriptionParam, "descriptionParam");
        return new SuggestionData(idParam, titleParam, descriptionParam, iconParam, backgroundParam, extrasParam, structuredDataParam, urlParam, creationTimeParam);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuggestionData)) {
            return false;
        }
        SuggestionData suggestionData = (SuggestionData) other;
        return Intrinsics.areEqual(this.idParam, suggestionData.idParam) && Intrinsics.areEqual(this.titleParam, suggestionData.titleParam) && Intrinsics.areEqual(this.descriptionParam, suggestionData.descriptionParam) && Intrinsics.areEqual(this.iconParam, suggestionData.iconParam) && Intrinsics.areEqual(this.backgroundParam, suggestionData.backgroundParam) && Intrinsics.areEqual(this.extrasParam, suggestionData.extrasParam) && Intrinsics.areEqual(this.structuredDataParam, suggestionData.structuredDataParam) && Intrinsics.areEqual(this.urlParam, suggestionData.urlParam) && this.creationTimeParam == suggestionData.creationTimeParam;
    }

    @Nullable
    public final Uri getBackground() {
        return this.backgroundParam;
    }

    public final long getCreationTime() {
        return this.creationTimeParam;
    }

    @NotNull
    public final String getDescription() {
        return this.descriptionParam;
    }

    @Nullable
    public final Bundle getExtras() {
        return this.extrasParam;
    }

    @Nullable
    public final Uri getIcon() {
        return this.iconParam;
    }

    @NotNull
    public final String getId() {
        return this.idParam;
    }

    @Nullable
    public final JSONObject getStructuredData() {
        return this.structuredDataParam;
    }

    @NotNull
    public final String getSuggestionFrom() {
        String string;
        Bundle bundle = this.extrasParam;
        if (bundle == null || (string = bundle.getString(SuggestionContract.EXTRA_SUGGESTION_FROM)) == null) {
            Bundle bundle2 = this.extrasParam;
            string = bundle2 != null ? bundle2.getString("suggestionFrom") : null;
        }
        return string == null ? "" : string;
    }

    @NotNull
    public final String getTitle() {
        return this.titleParam;
    }

    @Nullable
    public final String getUrl() {
        return this.urlParam;
    }

    public int hashCode() {
        int iM1202c = AbstractC1038a.m1202c(AbstractC1038a.m1202c(this.idParam.hashCode() * 31, 31, this.titleParam), 31, this.descriptionParam);
        Uri uri = this.iconParam;
        int iHashCode = (iM1202c + (uri == null ? 0 : uri.hashCode())) * 31;
        Uri uri2 = this.backgroundParam;
        int iHashCode2 = (iHashCode + (uri2 == null ? 0 : uri2.hashCode())) * 31;
        Bundle bundle = this.extrasParam;
        int iHashCode3 = (iHashCode2 + (bundle == null ? 0 : bundle.hashCode())) * 31;
        JSONObject jSONObject = this.structuredDataParam;
        int iHashCode4 = (iHashCode3 + (jSONObject == null ? 0 : jSONObject.hashCode())) * 31;
        String str = this.urlParam;
        return Long.hashCode(this.creationTimeParam) + ((iHashCode4 + (str != null ? str.hashCode() : 0)) * 31);
    }

    @NotNull
    public String toString() {
        String str = this.idParam;
        String str2 = this.titleParam;
        String str3 = this.descriptionParam;
        Uri uri = this.iconParam;
        Uri uri2 = this.backgroundParam;
        Bundle bundle = this.extrasParam;
        JSONObject jSONObject = this.structuredDataParam;
        String str4 = this.urlParam;
        long j = this.creationTimeParam;
        StringBuilder sbM16m = AbstractC0000a.m16m("SuggestionData(idParam=", str, ", titleParam=", str2, ", descriptionParam=");
        sbM16m.append(str3);
        sbM16m.append(", iconParam=");
        sbM16m.append(uri);
        sbM16m.append(", backgroundParam=");
        sbM16m.append(uri2);
        sbM16m.append(", extrasParam=");
        sbM16m.append(bundle);
        sbM16m.append(", structuredDataParam=");
        sbM16m.append(jSONObject);
        sbM16m.append(", urlParam=");
        sbM16m.append(str4);
        sbM16m.append(", creationTimeParam=");
        return AbstractC2821a.m2224o(sbM16m, ")", j);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.idParam);
        parcel.writeString(this.titleParam);
        parcel.writeString(this.descriptionParam);
        parcel.writeParcelable(this.iconParam, flags);
        parcel.writeParcelable(this.backgroundParam, flags);
        parcel.writeBundle(this.extrasParam);
        JSONObject jSONObject = this.structuredDataParam;
        parcel.writeString(jSONObject != null ? jSONObject.toString() : null);
        parcel.writeString(this.urlParam);
        parcel.writeLong(this.creationTimeParam);
    }

    public SuggestionData(@NotNull String idParam, @NotNull String titleParam, @NotNull String descriptionParam, @Nullable Uri uri, @Nullable Uri uri2, @Nullable Bundle bundle, @Nullable JSONObject jSONObject, @Nullable String str, long j) {
        Intrinsics.checkNotNullParameter(idParam, "idParam");
        Intrinsics.checkNotNullParameter(titleParam, "titleParam");
        Intrinsics.checkNotNullParameter(descriptionParam, "descriptionParam");
        this.idParam = idParam;
        this.titleParam = titleParam;
        this.descriptionParam = descriptionParam;
        this.iconParam = uri;
        this.backgroundParam = uri2;
        this.extrasParam = bundle;
        this.structuredDataParam = jSONObject;
        this.urlParam = str;
        this.creationTimeParam = j;
    }

    public /* synthetic */ SuggestionData(String str, String str2, String str3, Uri uri, Uri uri2, Bundle bundle, JSONObject jSONObject, String str4, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? null : uri, (i & 16) != 0 ? null : uri2, (i & 32) != 0 ? null : bundle, (i & 64) != 0 ? null : jSONObject, (i & 128) != 0 ? null : str4, (i & 256) != 0 ? 0L : j);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SuggestionData(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        String str = string == null ? "" : string;
        String string2 = parcel.readString();
        String str2 = string2 == null ? "" : string2;
        String string3 = parcel.readString();
        String str3 = string3 == null ? "" : string3;
        Uri uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        Uri uri2 = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        Bundle bundle = parcel.readBundle(Bundle.class.getClassLoader());
        String string4 = parcel.readString();
        this(str, str2, str3, uri, uri2, bundle, new JSONObject(string4 == null ? "{ }" : string4), parcel.readString(), parcel.readLong());
    }
}
