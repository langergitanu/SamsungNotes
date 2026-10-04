package com.samsung.android.app.sdk.deepsky.contract.suggestion.view;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.RemoteViews;
import androidx.collection.AbstractC0622a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 F2\u00020\u0001:\u0001FB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u009d\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\u0010HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00100\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00101\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00104\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00105\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\t\u00107\u001a\u00020\u0006HÆ\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000eHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0010HÆ\u0003Jª\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0002\u0010;J\b\u0010<\u001a\u00020\u0006H\u0016J\u0013\u0010=\u001a\u00020\u00142\b\u0010>\u001a\u0004\u0018\u00010?HÖ\u0003J\t\u0010@\u001a\u00020\u0006HÖ\u0001J\t\u0010A\u001a\u00020BHÖ\u0001J\u0018\u0010C\u001a\u00020D2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u0006H\u0016R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b&\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b)\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b+\u0010\u001bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b,\u0010\u001b¨\u0006G"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SuggestionViewSpec;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "revision", "", "titleId", "descriptionId", "iconId", "suggestionFromId", "listViewId", "listViewItemId", "clickableIdList", "", "listView", "Landroid/widget/RemoteViews;", "listItemView", "maxListItemVisibleCount", "enableSwipeDismiss", "", "extras", "Landroid/os/Bundle;", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/util/List;Landroid/widget/RemoteViews;Landroid/widget/RemoteViews;Ljava/lang/Integer;Ljava/lang/Boolean;Landroid/os/Bundle;)V", "getClickableIdList", "()Ljava/util/List;", "getDescriptionId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEnableSwipeDismiss", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getExtras", "()Landroid/os/Bundle;", "getIconId", "getListItemView", "()Landroid/widget/RemoteViews;", "getListView", "getListViewId", "getListViewItemId", "()I", "getMaxListItemVisibleCount", "getRevision", "getSuggestionFromId", "getTitleId", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/util/List;Landroid/widget/RemoteViews;Landroid/widget/RemoteViews;Ljava/lang/Integer;Ljava/lang/Boolean;Landroid/os/Bundle;)Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SuggestionViewSpec;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "flags", "CREATOR", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSuggestionViewSpec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuggestionViewSpec.kt\ncom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SuggestionViewSpec\n+ 2 SuggestionViewSpec.kt\ncom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SuggestionViewSpec$CREATOR\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,76:1\n73#2:77\n1#3:78\n*S KotlinDebug\n*F\n+ 1 SuggestionViewSpec.kt\ncom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SuggestionViewSpec\n*L\n34#1:77\n*E\n"})
public final /* data */ class SuggestionViewSpec implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final List<Integer> clickableIdList;

    @Nullable
    private final Integer descriptionId;

    @Nullable
    private final Boolean enableSwipeDismiss;

    @Nullable
    private final Bundle extras;

    @Nullable
    private final Integer iconId;

    @NotNull
    private final RemoteViews listItemView;

    @Nullable
    private final RemoteViews listView;

    @Nullable
    private final Integer listViewId;
    private final int listViewItemId;

    @Nullable
    private final Integer maxListItemVisibleCount;
    private final int revision;

    @Nullable
    private final Integer suggestionFromId;

    @Nullable
    private final Integer titleId;

    /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.contract.suggestion.view.SuggestionViewSpec$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u0004\u0018\u0001H\r\"\u0006\b\u0000\u0010\r\u0018\u0001*\u00020\u000eH\u0082\b¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SuggestionViewSpec$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SuggestionViewSpec;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SuggestionViewSpec;", "toListOrNull", "T", "Ljava/io/Serializable;", "(Ljava/io/Serializable;)Ljava/lang/Object;", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion implements Parcelable.Creator<SuggestionViewSpec> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final /* synthetic */ <T> T toListOrNull(Serializable serializable) {
            Intrinsics.reifiedOperationMarker(1, "T?");
            return serializable;
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SuggestionViewSpec createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SuggestionViewSpec(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SuggestionViewSpec[] newArray(int size) {
            return new SuggestionViewSpec[size];
        }
    }

    public SuggestionViewSpec(int i, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5, int i2, @Nullable List<Integer> list, @Nullable RemoteViews remoteViews, @NotNull RemoteViews listItemView, @Nullable Integer num6, @Nullable Boolean bool, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(listItemView, "listItemView");
        this.revision = i;
        this.titleId = num;
        this.descriptionId = num2;
        this.iconId = num3;
        this.suggestionFromId = num4;
        this.listViewId = num5;
        this.listViewItemId = i2;
        this.clickableIdList = list;
        this.listView = remoteViews;
        this.listItemView = listItemView;
        this.maxListItemVisibleCount = num6;
        this.enableSwipeDismiss = bool;
        this.extras = bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SuggestionViewSpec copy$default(SuggestionViewSpec suggestionViewSpec, int i, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, int i2, List list, RemoteViews remoteViews, RemoteViews remoteViews2, Integer num6, Boolean bool, Bundle bundle, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = suggestionViewSpec.revision;
        }
        return suggestionViewSpec.copy(i, (i4 & 2) != 0 ? suggestionViewSpec.titleId : num, (i4 & 4) != 0 ? suggestionViewSpec.descriptionId : num2, (i4 & 8) != 0 ? suggestionViewSpec.iconId : num3, (i4 & 16) != 0 ? suggestionViewSpec.suggestionFromId : num4, (i4 & 32) != 0 ? suggestionViewSpec.listViewId : num5, (i4 & 64) != 0 ? suggestionViewSpec.listViewItemId : i2, (i4 & 128) != 0 ? suggestionViewSpec.clickableIdList : list, (i4 & 256) != 0 ? suggestionViewSpec.listView : remoteViews, (i4 & 512) != 0 ? suggestionViewSpec.listItemView : remoteViews2, (i4 & 1024) != 0 ? suggestionViewSpec.maxListItemVisibleCount : num6, (i4 & 2048) != 0 ? suggestionViewSpec.enableSwipeDismiss : bool, (i4 & 4096) != 0 ? suggestionViewSpec.extras : bundle);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getRevision() {
        return this.revision;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final RemoteViews getListItemView() {
        return this.listItemView;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Integer getMaxListItemVisibleCount() {
        return this.maxListItemVisibleCount;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Boolean getEnableSwipeDismiss() {
        return this.enableSwipeDismiss;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Bundle getExtras() {
        return this.extras;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getTitleId() {
        return this.titleId;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getDescriptionId() {
        return this.descriptionId;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getIconId() {
        return this.iconId;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getSuggestionFromId() {
        return this.suggestionFromId;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getListViewId() {
        return this.listViewId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getListViewItemId() {
        return this.listViewItemId;
    }

    @Nullable
    public final List<Integer> component8() {
        return this.clickableIdList;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final RemoteViews getListView() {
        return this.listView;
    }

    @NotNull
    public final SuggestionViewSpec copy(int revision, @Nullable Integer titleId, @Nullable Integer descriptionId, @Nullable Integer iconId, @Nullable Integer suggestionFromId, @Nullable Integer listViewId, int listViewItemId, @Nullable List<Integer> clickableIdList, @Nullable RemoteViews listView, @NotNull RemoteViews listItemView, @Nullable Integer maxListItemVisibleCount, @Nullable Boolean enableSwipeDismiss, @Nullable Bundle extras) {
        Intrinsics.checkNotNullParameter(listItemView, "listItemView");
        return new SuggestionViewSpec(revision, titleId, descriptionId, iconId, suggestionFromId, listViewId, listViewItemId, clickableIdList, listView, listItemView, maxListItemVisibleCount, enableSwipeDismiss, extras);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuggestionViewSpec)) {
            return false;
        }
        SuggestionViewSpec suggestionViewSpec = (SuggestionViewSpec) other;
        return this.revision == suggestionViewSpec.revision && Intrinsics.areEqual(this.titleId, suggestionViewSpec.titleId) && Intrinsics.areEqual(this.descriptionId, suggestionViewSpec.descriptionId) && Intrinsics.areEqual(this.iconId, suggestionViewSpec.iconId) && Intrinsics.areEqual(this.suggestionFromId, suggestionViewSpec.suggestionFromId) && Intrinsics.areEqual(this.listViewId, suggestionViewSpec.listViewId) && this.listViewItemId == suggestionViewSpec.listViewItemId && Intrinsics.areEqual(this.clickableIdList, suggestionViewSpec.clickableIdList) && Intrinsics.areEqual(this.listView, suggestionViewSpec.listView) && Intrinsics.areEqual(this.listItemView, suggestionViewSpec.listItemView) && Intrinsics.areEqual(this.maxListItemVisibleCount, suggestionViewSpec.maxListItemVisibleCount) && Intrinsics.areEqual(this.enableSwipeDismiss, suggestionViewSpec.enableSwipeDismiss) && Intrinsics.areEqual(this.extras, suggestionViewSpec.extras);
    }

    @Nullable
    public final List<Integer> getClickableIdList() {
        return this.clickableIdList;
    }

    @Nullable
    public final Integer getDescriptionId() {
        return this.descriptionId;
    }

    @Nullable
    public final Boolean getEnableSwipeDismiss() {
        return this.enableSwipeDismiss;
    }

    @Nullable
    public final Bundle getExtras() {
        return this.extras;
    }

    @Nullable
    public final Integer getIconId() {
        return this.iconId;
    }

    @NotNull
    public final RemoteViews getListItemView() {
        return this.listItemView;
    }

    @Nullable
    public final RemoteViews getListView() {
        return this.listView;
    }

    @Nullable
    public final Integer getListViewId() {
        return this.listViewId;
    }

    public final int getListViewItemId() {
        return this.listViewItemId;
    }

    @Nullable
    public final Integer getMaxListItemVisibleCount() {
        return this.maxListItemVisibleCount;
    }

    public final int getRevision() {
        return this.revision;
    }

    @Nullable
    public final Integer getSuggestionFromId() {
        return this.suggestionFromId;
    }

    @Nullable
    public final Integer getTitleId() {
        return this.titleId;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.revision) * 31;
        Integer num = this.titleId;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.descriptionId;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.iconId;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.suggestionFromId;
        int iHashCode5 = (iHashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.listViewId;
        int iM1157c = AbstractC0622a.m1157c(this.listViewItemId, (iHashCode5 + (num5 == null ? 0 : num5.hashCode())) * 31, 31);
        List<Integer> list = this.clickableIdList;
        int iHashCode6 = (iM1157c + (list == null ? 0 : list.hashCode())) * 31;
        RemoteViews remoteViews = this.listView;
        int iHashCode7 = (this.listItemView.hashCode() + ((iHashCode6 + (remoteViews == null ? 0 : remoteViews.hashCode())) * 31)) * 31;
        Integer num6 = this.maxListItemVisibleCount;
        int iHashCode8 = (iHashCode7 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Boolean bool = this.enableSwipeDismiss;
        int iHashCode9 = (iHashCode8 + (bool == null ? 0 : bool.hashCode())) * 31;
        Bundle bundle = this.extras;
        return iHashCode9 + (bundle != null ? bundle.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SuggestionViewSpec(revision=" + this.revision + ", titleId=" + this.titleId + ", descriptionId=" + this.descriptionId + ", iconId=" + this.iconId + ", suggestionFromId=" + this.suggestionFromId + ", listViewId=" + this.listViewId + ", listViewItemId=" + this.listViewItemId + ", clickableIdList=" + this.clickableIdList + ", listView=" + this.listView + ", listItemView=" + this.listItemView + ", maxListItemVisibleCount=" + this.maxListItemVisibleCount + ", enableSwipeDismiss=" + this.enableSwipeDismiss + ", extras=" + this.extras + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.revision);
        parcel.writeValue(this.titleId);
        parcel.writeValue(this.descriptionId);
        parcel.writeValue(this.iconId);
        parcel.writeValue(this.suggestionFromId);
        parcel.writeValue(this.listViewId);
        parcel.writeInt(this.listViewItemId);
        parcel.writeSerializable(this.clickableIdList != null ? new ArrayList(this.clickableIdList) : null);
        parcel.writeParcelable(this.listView, flags);
        parcel.writeParcelable(this.listItemView, flags);
        parcel.writeValue(this.maxListItemVisibleCount);
        parcel.writeValue(this.enableSwipeDismiss);
        parcel.writeBundle(this.extras);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ SuggestionViewSpec(int r17, java.lang.Integer r18, java.lang.Integer r19, java.lang.Integer r20, java.lang.Integer r21, java.lang.Integer r22, int r23, java.util.List r24, android.widget.RemoteViews r25, android.widget.RemoteViews r26, java.lang.Integer r27, java.lang.Boolean r28, android.os.Bundle r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r16 = this;
            r0 = r30
            r1 = r0 & 1
            if (r1 == 0) goto L9
            r1 = 1
            r3 = r1
            goto Lb
        L9:
            r3 = r17
        Lb:
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L12
            r4 = r2
            goto L14
        L12:
            r4 = r18
        L14:
            r1 = r0 & 4
            if (r1 == 0) goto L1a
            r5 = r2
            goto L1c
        L1a:
            r5 = r19
        L1c:
            r1 = r0 & 8
            if (r1 == 0) goto L22
            r6 = r2
            goto L24
        L22:
            r6 = r20
        L24:
            r1 = r0 & 16
            if (r1 == 0) goto L2a
            r7 = r2
            goto L2c
        L2a:
            r7 = r21
        L2c:
            r1 = r0 & 32
            if (r1 == 0) goto L32
            r8 = r2
            goto L34
        L32:
            r8 = r22
        L34:
            r1 = r0 & 128(0x80, float:1.8E-43)
            if (r1 == 0) goto L3a
            r10 = r2
            goto L3c
        L3a:
            r10 = r24
        L3c:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L42
            r11 = r2
            goto L44
        L42:
            r11 = r25
        L44:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L4a
            r13 = r2
            goto L4c
        L4a:
            r13 = r27
        L4c:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L52
            r14 = r2
            goto L54
        L52:
            r14 = r28
        L54:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L60
            r15 = r2
            r9 = r23
            r12 = r26
            r2 = r16
            goto L68
        L60:
            r15 = r29
            r2 = r16
            r9 = r23
            r12 = r26
        L68:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.android.app.sdk.deepsky.contract.suggestion.view.SuggestionViewSpec.<init>(int, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, int, java.util.List, android.widget.RemoteViews, android.widget.RemoteViews, java.lang.Integer, java.lang.Boolean, android.os.Bundle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SuggestionViewSpec(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int i = parcel.readInt();
        Class cls = Integer.TYPE;
        Object value = parcel.readValue(cls.getClassLoader());
        Integer num = value instanceof Integer ? (Integer) value : null;
        Object value2 = parcel.readValue(cls.getClassLoader());
        Integer num2 = value2 instanceof Integer ? (Integer) value2 : null;
        Object value3 = parcel.readValue(cls.getClassLoader());
        Integer num3 = value3 instanceof Integer ? (Integer) value3 : null;
        Object value4 = parcel.readValue(cls.getClassLoader());
        Integer num4 = value4 instanceof Integer ? (Integer) value4 : null;
        Object value5 = parcel.readValue(cls.getClassLoader());
        Integer num5 = value5 instanceof Integer ? (Integer) value5 : null;
        int i2 = parcel.readInt();
        Serializable serializable = parcel.readSerializable();
        List list = serializable != null ? (List) serializable : null;
        RemoteViews remoteViews = (RemoteViews) parcel.readParcelable(RemoteViews.class.getClassLoader());
        Parcelable parcelable = parcel.readParcelable(RemoteViews.class.getClassLoader());
        if (parcelable != null) {
            RemoteViews remoteViews2 = (RemoteViews) parcelable;
            Object value6 = parcel.readValue(cls.getClassLoader());
            Integer num6 = value6 instanceof Integer ? (Integer) value6 : null;
            Object value7 = parcel.readValue(Boolean.TYPE.getClassLoader());
            this(i, num, num2, num3, num4, num5, i2, list, remoteViews, remoteViews2, num6, value7 instanceof Boolean ? (Boolean) value7 : null, parcel.readBundle(Bundle.class.getClassLoader()));
            return;
        }
        throw new IllegalStateException("listItemView is null");
    }
}
