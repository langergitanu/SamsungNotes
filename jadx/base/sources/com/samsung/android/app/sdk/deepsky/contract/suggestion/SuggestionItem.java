package com.samsung.android.app.sdk.deepsky.contract.suggestion;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 N2\u00020\u0001:\u0001NB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0081\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0018J\t\u00108\u001a\u00020\u0006HÂ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0016HÂ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0006HÂ\u0003J\t\u0010;\u001a\u00020\u0006HÂ\u0003J\t\u0010<\u001a\u00020\u0006HÂ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\nHÂ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\nHÂ\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÂ\u0003J\t\u0010@\u001a\u00020\u0010HÂ\u0003J\t\u0010A\u001a\u00020\u0012HÂ\u0003J\t\u0010B\u001a\u00020\u0014HÂ\u0003J\u0085\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\b\u0010D\u001a\u00020EH\u0016J\u0013\u0010F\u001a\u00020\u00122\b\u0010G\u001a\u0004\u0018\u00010HHÖ\u0003J\t\u0010I\u001a\u00020EHÖ\u0001J\t\u0010J\u001a\u00020\u0006HÖ\u0001J\u0018\u0010K\u001a\u00020L2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010M\u001a\u00020EH\u0016R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u00168F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\"\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b#\u0010\u001bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010$\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b%\u0010\u001eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010)\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010,\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b-\u0010\u001eR\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010.\u001a\u0004\u0018\u00010\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u00100\u001a\u0004\b1\u0010\u001eR\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00102\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b3\u00104R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00105\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b6\u00107R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionItem;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "idParam", "", "titleParam", "descriptionParam", "iconParam", "Landroid/net/Uri;", "backgroundParam", "itemsParam", "", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionData;", "scoreParam", "", "validParam", "", "validTimeParam", "", "extrasParam", "Landroid/os/Bundle;", "urlParam", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Landroid/net/Uri;Ljava/util/List;DZJLandroid/os/Bundle;Ljava/lang/String;)V", "background", "getBackground", "()Landroid/net/Uri;", "description", "getDescription", "()Ljava/lang/String;", "extras", "getExtras", "()Landroid/os/Bundle;", "icon", "getIcon", "id", "getId", "items", "getItems", "()Ljava/util/List;", "score", "getScore", "()D", "title", DynamicActionBarProvider.METHOD_GET_DATA, "url", "getUrl$annotations", "()V", "getUrl", "valid", "getValid", "()Z", "validTime", "getValidTime", "()J", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class SuggestionItem implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final Uri backgroundParam;

    @NotNull
    private final String descriptionParam;

    @Nullable
    private final Bundle extrasParam;

    @Nullable
    private final Uri iconParam;

    @NotNull
    private final String idParam;

    @NotNull
    private final List<SuggestionData> itemsParam;
    private final double scoreParam;

    @NotNull
    private final String titleParam;

    @Nullable
    private final String urlParam;
    private final boolean validParam;
    private final long validTimeParam;

    /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionItem$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionItem$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionItem;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionItem;", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion implements Parcelable.Creator<SuggestionItem> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SuggestionItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SuggestionItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SuggestionItem[] newArray(int size) {
            return new SuggestionItem[size];
        }
    }

    public SuggestionItem() {
        this(null, null, null, null, null, null, 0.0d, false, 0L, null, null, SpenTextParagraphBase.FILTER_PARAGRAPH_ALL, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final String getIdParam() {
        return this.idParam;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    private final Bundle getExtrasParam() {
        return this.extrasParam;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    private final String getUrlParam() {
        return this.urlParam;
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

    private final List<SuggestionData> component6() {
        return this.itemsParam;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    private final double getScoreParam() {
        return this.scoreParam;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    private final boolean getValidParam() {
        return this.validParam;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    private final long getValidTimeParam() {
        return this.validTimeParam;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SuggestionItem copy$default(SuggestionItem suggestionItem, String str, String str2, String str3, Uri uri, Uri uri2, List list, double d, boolean z, long j, Bundle bundle, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = suggestionItem.idParam;
        }
        return suggestionItem.copy(str, (i & 2) != 0 ? suggestionItem.titleParam : str2, (i & 4) != 0 ? suggestionItem.descriptionParam : str3, (i & 8) != 0 ? suggestionItem.iconParam : uri, (i & 16) != 0 ? suggestionItem.backgroundParam : uri2, (i & 32) != 0 ? suggestionItem.itemsParam : list, (i & 64) != 0 ? suggestionItem.scoreParam : d, (i & 128) != 0 ? suggestionItem.validParam : z, (i & 256) != 0 ? suggestionItem.validTimeParam : j, (i & 512) != 0 ? suggestionItem.extrasParam : bundle, (i & 1024) != 0 ? suggestionItem.urlParam : str4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "The url from SuggestionData are going to be used", replaceWith = @ReplaceWith(expression = "SuggestionData.url", imports = {"com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionData"}))
    public static /* synthetic */ void getUrl$annotations() {
    }

    @NotNull
    public final SuggestionItem copy(@NotNull String idParam, @NotNull String titleParam, @NotNull String descriptionParam, @Nullable Uri iconParam, @Nullable Uri backgroundParam, @NotNull List<SuggestionData> itemsParam, double scoreParam, boolean validParam, long validTimeParam, @Nullable Bundle extrasParam, @Nullable String urlParam) {
        Intrinsics.checkNotNullParameter(idParam, "idParam");
        Intrinsics.checkNotNullParameter(titleParam, "titleParam");
        Intrinsics.checkNotNullParameter(descriptionParam, "descriptionParam");
        Intrinsics.checkNotNullParameter(itemsParam, "itemsParam");
        return new SuggestionItem(idParam, titleParam, descriptionParam, iconParam, backgroundParam, itemsParam, scoreParam, validParam, validTimeParam, extrasParam, urlParam);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuggestionItem)) {
            return false;
        }
        SuggestionItem suggestionItem = (SuggestionItem) other;
        return Intrinsics.areEqual(this.idParam, suggestionItem.idParam) && Intrinsics.areEqual(this.titleParam, suggestionItem.titleParam) && Intrinsics.areEqual(this.descriptionParam, suggestionItem.descriptionParam) && Intrinsics.areEqual(this.iconParam, suggestionItem.iconParam) && Intrinsics.areEqual(this.backgroundParam, suggestionItem.backgroundParam) && Intrinsics.areEqual(this.itemsParam, suggestionItem.itemsParam) && Double.compare(this.scoreParam, suggestionItem.scoreParam) == 0 && this.validParam == suggestionItem.validParam && this.validTimeParam == suggestionItem.validTimeParam && Intrinsics.areEqual(this.extrasParam, suggestionItem.extrasParam) && Intrinsics.areEqual(this.urlParam, suggestionItem.urlParam);
    }

    @Nullable
    public final Uri getBackground() {
        return this.backgroundParam;
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

    @NotNull
    public final List<SuggestionData> getItems() {
        return this.itemsParam;
    }

    public final double getScore() {
        return this.scoreParam;
    }

    @NotNull
    public final String getTitle() {
        return this.titleParam;
    }

    @Nullable
    public final String getUrl() {
        return this.urlParam;
    }

    public final boolean getValid() {
        return this.validParam;
    }

    public final long getValidTime() {
        return this.validTimeParam;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    public int hashCode() {
        int iM1202c = AbstractC1038a.m1202c(AbstractC1038a.m1202c(this.idParam.hashCode() * 31, 31, this.titleParam), 31, this.descriptionParam);
        Uri uri = this.iconParam;
        int iHashCode = (iM1202c + (uri == null ? 0 : uri.hashCode())) * 31;
        Uri uri2 = this.backgroundParam;
        int iHashCode2 = (Double.hashCode(this.scoreParam) + AbstractC0622a.m1159e(this.itemsParam, (iHashCode + (uri2 == null ? 0 : uri2.hashCode())) * 31, 31)) * 31;
        boolean z = this.validParam;
        ?? r02 = z;
        if (z) {
            r02 = 1;
        }
        int iM1311d = AbstractC1974b.m1311d(this.validTimeParam, (iHashCode2 + r02) * 31, 31);
        Bundle bundle = this.extrasParam;
        int iHashCode3 = (iM1311d + (bundle == null ? 0 : bundle.hashCode())) * 31;
        String str = this.urlParam;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.idParam;
        String str2 = this.titleParam;
        String str3 = this.descriptionParam;
        Uri uri = this.iconParam;
        Uri uri2 = this.backgroundParam;
        List<SuggestionData> list = this.itemsParam;
        double d = this.scoreParam;
        boolean z = this.validParam;
        long j = this.validTimeParam;
        Bundle bundle = this.extrasParam;
        String str4 = this.urlParam;
        StringBuilder sbM16m = AbstractC0000a.m16m("SuggestionItem(idParam=", str, ", titleParam=", str2, ", descriptionParam=");
        sbM16m.append(str3);
        sbM16m.append(", iconParam=");
        sbM16m.append(uri);
        sbM16m.append(", backgroundParam=");
        sbM16m.append(uri2);
        sbM16m.append(", itemsParam=");
        sbM16m.append(list);
        sbM16m.append(", scoreParam=");
        sbM16m.append(d);
        sbM16m.append(", validParam=");
        sbM16m.append(z);
        AbstractC1038a.m1223x(sbM16m, ", validTimeParam=", j, ", extrasParam=");
        sbM16m.append(bundle);
        sbM16m.append(", urlParam=");
        sbM16m.append(str4);
        sbM16m.append(")");
        return sbM16m.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.idParam);
        parcel.writeString(this.titleParam);
        parcel.writeString(this.descriptionParam);
        parcel.writeParcelable(this.iconParam, flags);
        parcel.writeParcelable(this.backgroundParam, flags);
        parcel.writeTypedList(this.itemsParam);
        parcel.writeDouble(this.scoreParam);
        parcel.writeByte(this.validParam ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.validTimeParam);
        parcel.writeBundle(this.extrasParam);
        parcel.writeString(this.urlParam);
    }

    public SuggestionItem(@NotNull String idParam, @NotNull String titleParam, @NotNull String descriptionParam, @Nullable Uri uri, @Nullable Uri uri2, @NotNull List<SuggestionData> itemsParam, double d, boolean z, long j, @Nullable Bundle bundle, @Nullable String str) {
        Intrinsics.checkNotNullParameter(idParam, "idParam");
        Intrinsics.checkNotNullParameter(titleParam, "titleParam");
        Intrinsics.checkNotNullParameter(descriptionParam, "descriptionParam");
        Intrinsics.checkNotNullParameter(itemsParam, "itemsParam");
        this.idParam = idParam;
        this.titleParam = titleParam;
        this.descriptionParam = descriptionParam;
        this.iconParam = uri;
        this.backgroundParam = uri2;
        this.itemsParam = itemsParam;
        this.scoreParam = d;
        this.validParam = z;
        this.validTimeParam = j;
        this.extrasParam = bundle;
        this.urlParam = str;
    }

    public /* synthetic */ SuggestionItem(String str, String str2, String str3, Uri uri, Uri uri2, List list, double d, boolean z, long j, Bundle bundle, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) == 0 ? str3 : "", (i & 8) != 0 ? null : uri, (i & 16) != 0 ? null : uri2, (i & 32) != 0 ? CollectionsKt.emptyList() : list, (i & 64) != 0 ? 0.0d : d, (i & 128) != 0 ? false : z, (i & 256) != 0 ? 0L : j, (i & 512) != 0 ? null : bundle, (i & 1024) != 0 ? null : str4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SuggestionItem(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        String str = string == null ? "" : string;
        String string2 = parcel.readString();
        String str2 = string2 == null ? "" : string2;
        String string3 = parcel.readString();
        String str3 = string3 == null ? "" : string3;
        Uri uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        Uri uri2 = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        List listCreateTypedArrayList = parcel.createTypedArrayList(SuggestionData.INSTANCE);
        this(str, str2, str3, uri, uri2, listCreateTypedArrayList == null ? CollectionsKt.emptyList() : listCreateTypedArrayList, parcel.readDouble(), parcel.readByte() != 0, parcel.readLong(), parcel.readBundle(Bundle.class.getClassLoader()), parcel.readString());
    }
}
