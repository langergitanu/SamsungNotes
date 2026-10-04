package com.samsung.android.app.sdk.deepsky.contract.suggestion.view;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.SurfaceControlViewHost;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p018D2.AbstractC0071a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 C2\u00020\u0001:\u0001CB\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u009d\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0017J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\t\u0010,\u001a\u00020\u0012HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u00104\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u00105\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u00107\u001a\u0004\u0018\u00010\nHÆ\u0003J¦\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u00109J\b\u0010:\u001a\u00020\u0006H\u0016J\u0013\u0010;\u001a\u00020\u00122\b\u0010<\u001a\u0004\u0018\u00010=HÖ\u0003J\t\u0010>\u001a\u00020\u0006HÖ\u0001J\t\u0010?\u001a\u00020\nHÖ\u0001J\u0018\u0010@\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u0006H\u0017R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010#R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b)\u0010\u0019R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b*\u0010\u0019¨\u0006D"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SuggestionViewResponse;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "revision", "", "surfacePackage", "Landroid/view/SurfaceControlViewHost$SurfacePackage;", "itemId", "", "dataId", "viewId", "width", "height", "actionId", "cause", "isValid", "", "errorMessage", "extras", "Landroid/os/Bundle;", "actionUrl", "(ILandroid/view/SurfaceControlViewHost$SurfacePackage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/String;Landroid/os/Bundle;Ljava/lang/String;)V", "getActionId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getActionUrl", "()Ljava/lang/String;", "getCause", "getDataId", "getErrorMessage", "getExtras", "()Landroid/os/Bundle;", "getHeight", "()Z", "getItemId", "getRevision", "()I", "getSurfacePackage", "()Landroid/view/SurfaceControlViewHost$SurfacePackage;", "getViewId", "getWidth", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILandroid/view/SurfaceControlViewHost$SurfacePackage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/String;Landroid/os/Bundle;Ljava/lang/String;)Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SuggestionViewResponse;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class SuggestionViewResponse implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final Integer actionId;

    @Nullable
    private final String actionUrl;

    @Nullable
    private final String cause;

    @Nullable
    private final String dataId;

    @Nullable
    private final String errorMessage;

    @Nullable
    private final Bundle extras;

    @Nullable
    private final Integer height;
    private final boolean isValid;

    @Nullable
    private final String itemId;
    private final int revision;

    @Nullable
    private final SurfaceControlViewHost.SurfacePackage surfacePackage;

    @Nullable
    private final Integer viewId;

    @Nullable
    private final Integer width;

    /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.contract.suggestion.view.SuggestionViewResponse$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SuggestionViewResponse$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SuggestionViewResponse;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SuggestionViewResponse;", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @RequiresApi(30)
    public static final class Companion implements Parcelable.Creator<SuggestionViewResponse> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SuggestionViewResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SuggestionViewResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SuggestionViewResponse[] newArray(int size) {
            return new SuggestionViewResponse[size];
        }
    }

    public SuggestionViewResponse() {
        this(0, null, null, null, null, null, null, null, null, false, null, null, null, 8191, null);
    }

    public static /* synthetic */ SuggestionViewResponse copy$default(SuggestionViewResponse suggestionViewResponse, int i, SurfaceControlViewHost.SurfacePackage surfacePackage, String str, String str2, Integer num, Integer num2, Integer num3, Integer num4, String str3, boolean z, String str4, Bundle bundle, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = suggestionViewResponse.revision;
        }
        return suggestionViewResponse.copy(i, (i2 & 2) != 0 ? suggestionViewResponse.surfacePackage : surfacePackage, (i2 & 4) != 0 ? suggestionViewResponse.itemId : str, (i2 & 8) != 0 ? suggestionViewResponse.dataId : str2, (i2 & 16) != 0 ? suggestionViewResponse.viewId : num, (i2 & 32) != 0 ? suggestionViewResponse.width : num2, (i2 & 64) != 0 ? suggestionViewResponse.height : num3, (i2 & 128) != 0 ? suggestionViewResponse.actionId : num4, (i2 & 256) != 0 ? suggestionViewResponse.cause : str3, (i2 & 512) != 0 ? suggestionViewResponse.isValid : z, (i2 & 1024) != 0 ? suggestionViewResponse.errorMessage : str4, (i2 & 2048) != 0 ? suggestionViewResponse.extras : bundle, (i2 & 4096) != 0 ? suggestionViewResponse.actionUrl : str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getRevision() {
        return this.revision;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsValid() {
        return this.isValid;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Bundle getExtras() {
        return this.extras;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getActionUrl() {
        return this.actionUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SurfaceControlViewHost.SurfacePackage getSurfacePackage() {
        return this.surfacePackage;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getItemId() {
        return this.itemId;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDataId() {
        return this.dataId;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getViewId() {
        return this.viewId;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getWidth() {
        return this.width;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getHeight() {
        return this.height;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getActionId() {
        return this.actionId;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getCause() {
        return this.cause;
    }

    @NotNull
    public final SuggestionViewResponse copy(int revision, @Nullable SurfaceControlViewHost.SurfacePackage surfacePackage, @Nullable String itemId, @Nullable String dataId, @Nullable Integer viewId, @Nullable Integer width, @Nullable Integer height, @Nullable Integer actionId, @Nullable String cause, boolean isValid, @Nullable String errorMessage, @Nullable Bundle extras, @Nullable String actionUrl) {
        return new SuggestionViewResponse(revision, surfacePackage, itemId, dataId, viewId, width, height, actionId, cause, isValid, errorMessage, extras, actionUrl);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuggestionViewResponse)) {
            return false;
        }
        SuggestionViewResponse suggestionViewResponse = (SuggestionViewResponse) other;
        return this.revision == suggestionViewResponse.revision && Intrinsics.areEqual(this.surfacePackage, suggestionViewResponse.surfacePackage) && Intrinsics.areEqual(this.itemId, suggestionViewResponse.itemId) && Intrinsics.areEqual(this.dataId, suggestionViewResponse.dataId) && Intrinsics.areEqual(this.viewId, suggestionViewResponse.viewId) && Intrinsics.areEqual(this.width, suggestionViewResponse.width) && Intrinsics.areEqual(this.height, suggestionViewResponse.height) && Intrinsics.areEqual(this.actionId, suggestionViewResponse.actionId) && Intrinsics.areEqual(this.cause, suggestionViewResponse.cause) && this.isValid == suggestionViewResponse.isValid && Intrinsics.areEqual(this.errorMessage, suggestionViewResponse.errorMessage) && Intrinsics.areEqual(this.extras, suggestionViewResponse.extras) && Intrinsics.areEqual(this.actionUrl, suggestionViewResponse.actionUrl);
    }

    @Nullable
    public final Integer getActionId() {
        return this.actionId;
    }

    @Nullable
    public final String getActionUrl() {
        return this.actionUrl;
    }

    @Nullable
    public final String getCause() {
        return this.cause;
    }

    @Nullable
    public final String getDataId() {
        return this.dataId;
    }

    @Nullable
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @Nullable
    public final Bundle getExtras() {
        return this.extras;
    }

    @Nullable
    public final Integer getHeight() {
        return this.height;
    }

    @Nullable
    public final String getItemId() {
        return this.itemId;
    }

    public final int getRevision() {
        return this.revision;
    }

    @Nullable
    public final SurfaceControlViewHost.SurfacePackage getSurfacePackage() {
        return this.surfacePackage;
    }

    @Nullable
    public final Integer getViewId() {
        return this.viewId;
    }

    @Nullable
    public final Integer getWidth() {
        return this.width;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v25, types: [int] */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v44 */
    public int hashCode() {
        int iHashCode = Integer.hashCode(this.revision) * 31;
        SurfaceControlViewHost.SurfacePackage surfacePackage = this.surfacePackage;
        int iHashCode2 = (iHashCode + (surfacePackage == null ? 0 : surfacePackage.hashCode())) * 31;
        String str = this.itemId;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.dataId;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.viewId;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.width;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.height;
        int iHashCode7 = (iHashCode6 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.actionId;
        int iHashCode8 = (iHashCode7 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str3 = this.cause;
        int iHashCode9 = (iHashCode8 + (str3 == null ? 0 : str3.hashCode())) * 31;
        boolean z = this.isValid;
        ?? r12 = z;
        if (z) {
            r12 = 1;
        }
        int i = (iHashCode9 + r12) * 31;
        String str4 = this.errorMessage;
        int iHashCode10 = (i + (str4 == null ? 0 : str4.hashCode())) * 31;
        Bundle bundle = this.extras;
        int iHashCode11 = (iHashCode10 + (bundle == null ? 0 : bundle.hashCode())) * 31;
        String str5 = this.actionUrl;
        return iHashCode11 + (str5 != null ? str5.hashCode() : 0);
    }

    public final boolean isValid() {
        return this.isValid;
    }

    @NotNull
    public String toString() {
        int i = this.revision;
        SurfaceControlViewHost.SurfacePackage surfacePackage = this.surfacePackage;
        String str = this.itemId;
        String str2 = this.dataId;
        Integer num = this.viewId;
        Integer num2 = this.width;
        Integer num3 = this.height;
        Integer num4 = this.actionId;
        String str3 = this.cause;
        boolean z = this.isValid;
        String str4 = this.errorMessage;
        Bundle bundle = this.extras;
        String str5 = this.actionUrl;
        StringBuilder sb = new StringBuilder("SuggestionViewResponse(revision=");
        sb.append(i);
        sb.append(", surfacePackage=");
        sb.append(surfacePackage);
        sb.append(", itemId=");
        AbstractC2821a.m2207B(sb, str, ", dataId=", str2, ", viewId=");
        sb.append(num);
        sb.append(", width=");
        sb.append(num2);
        sb.append(", height=");
        sb.append(num3);
        sb.append(", actionId=");
        sb.append(num4);
        sb.append(", cause=");
        sb.append(str3);
        sb.append(", isValid=");
        sb.append(z);
        sb.append(", errorMessage=");
        sb.append(str4);
        sb.append(", extras=");
        sb.append(bundle);
        sb.append(", actionUrl=");
        return AbstractC0622a.m1170p(str5, ")", sb);
    }

    @Override // android.os.Parcelable
    @RequiresApi(30)
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.revision);
        parcel.writeParcelable(this.surfacePackage, flags);
        parcel.writeString(this.itemId);
        parcel.writeString(this.dataId);
        parcel.writeValue(this.viewId);
        parcel.writeValue(this.width);
        parcel.writeValue(this.height);
        parcel.writeValue(this.actionId);
        parcel.writeString(this.cause);
        parcel.writeByte(this.isValid ? (byte) 1 : (byte) 0);
        parcel.writeString(this.errorMessage);
        parcel.writeBundle(this.extras);
        parcel.writeString(this.actionUrl);
    }

    public SuggestionViewResponse(int i, @Nullable SurfaceControlViewHost.SurfacePackage surfacePackage, @Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable String str3, boolean z, @Nullable String str4, @Nullable Bundle bundle, @Nullable String str5) {
        this.revision = i;
        this.surfacePackage = surfacePackage;
        this.itemId = str;
        this.dataId = str2;
        this.viewId = num;
        this.width = num2;
        this.height = num3;
        this.actionId = num4;
        this.cause = str3;
        this.isValid = z;
        this.errorMessage = str4;
        this.extras = bundle;
        this.actionUrl = str5;
    }

    public /* synthetic */ SuggestionViewResponse(int i, SurfaceControlViewHost.SurfacePackage surfacePackage, String str, String str2, Integer num, Integer num2, Integer num3, Integer num4, String str3, boolean z, String str4, Bundle bundle, String str5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 3 : i, (i2 & 2) != 0 ? null : surfacePackage, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : num, (i2 & 32) != 0 ? null : num2, (i2 & 64) != 0 ? null : num3, (i2 & 128) != 0 ? null : num4, (i2 & 256) != 0 ? null : str3, (i2 & 512) != 0 ? true : z, (i2 & 1024) != 0 ? null : str4, (i2 & 2048) != 0 ? null : bundle, (i2 & 4096) != 0 ? null : str5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @RequiresApi(30)
    public SuggestionViewResponse(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int i = parcel.readInt();
        SurfaceControlViewHost.SurfacePackage surfacePackageM173g = AbstractC0071a.m173g(parcel.readParcelable(AbstractC0071a.m182p().getClassLoader()));
        String string = parcel.readString();
        String string2 = parcel.readString();
        Class cls = Integer.TYPE;
        Object value = parcel.readValue(cls.getClassLoader());
        Integer num = value instanceof Integer ? (Integer) value : null;
        Object value2 = parcel.readValue(cls.getClassLoader());
        Integer num2 = value2 instanceof Integer ? (Integer) value2 : null;
        Object value3 = parcel.readValue(cls.getClassLoader());
        Integer num3 = value3 instanceof Integer ? (Integer) value3 : null;
        Object value4 = parcel.readValue(cls.getClassLoader());
        this(i, surfacePackageM173g, string, string2, num, num2, num3, value4 instanceof Integer ? (Integer) value4 : null, parcel.readString(), parcel.readByte() != 0, parcel.readString(), parcel.readBundle(Bundle.class.getClassLoader()), parcel.readString());
    }
}
