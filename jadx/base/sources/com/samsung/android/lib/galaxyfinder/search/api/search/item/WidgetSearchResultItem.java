package com.samsung.android.lib.galaxyfinder.search.api.search.item;

import android.net.Uri;
import com.samsung.android.lib.galaxyfinder.search.api.payload.IntentResultItemPayload;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/WidgetSearchResultItem;", "Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SearchResultItem;", "appID", "", "widgetImgUrl", "Landroid/net/Uri;", "widgetName", "subText", "widgetSize", "widgetCnt", SearchIndexablesContract.RawData.PAYLOAD, "Lcom/samsung/android/lib/galaxyfinder/search/api/payload/IntentResultItemPayload;", "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/samsung/android/lib/galaxyfinder/search/api/payload/IntentResultItemPayload;)V", "getAppID", "()Ljava/lang/String;", "setAppID", "(Ljava/lang/String;)V", "group", "getGroup", "getWidgetCnt", "setWidgetCnt", "getWidgetImgUrl", "()Landroid/net/Uri;", "setWidgetImgUrl", "(Landroid/net/Uri;)V", "getWidgetName", "setWidgetName", "getWidgetSize", "setWidgetSize", "DeviceSearchLibrary_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class WidgetSearchResultItem extends SearchResultItem {

    @NotNull
    private String appID;

    @NotNull
    private String widgetCnt;

    @Nullable
    private Uri widgetImgUrl;

    @NotNull
    private String widgetName;

    @Nullable
    private String widgetSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSearchResultItem(@NotNull String appID, @Nullable Uri uri, @NotNull String widgetName, @Nullable String str, @Nullable String str2, @NotNull String widgetCnt, @Nullable IntentResultItemPayload intentResultItemPayload) {
        super(appID, uri, widgetName, str, intentResultItemPayload);
        Intrinsics.checkNotNullParameter(appID, "appID");
        Intrinsics.checkNotNullParameter(widgetName, "widgetName");
        Intrinsics.checkNotNullParameter(widgetCnt, "widgetCnt");
        this.appID = appID;
        this.widgetImgUrl = uri;
        this.widgetName = widgetName;
        this.widgetSize = str2;
        this.widgetCnt = widgetCnt;
    }

    @NotNull
    public final String getAppID() {
        return this.appID;
    }

    @Override // com.samsung.android.lib.galaxyfinder.search.api.search.item.SearchResultItem
    @Nullable
    /* JADX INFO: renamed from: getGroup */
    public String getGroupName() {
        return null;
    }

    @NotNull
    public final String getWidgetCnt() {
        return this.widgetCnt;
    }

    @Nullable
    public final Uri getWidgetImgUrl() {
        return this.widgetImgUrl;
    }

    @NotNull
    public final String getWidgetName() {
        return this.widgetName;
    }

    @Nullable
    public final String getWidgetSize() {
        return this.widgetSize;
    }

    public final void setAppID(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appID = str;
    }

    public final void setWidgetCnt(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.widgetCnt = str;
    }

    public final void setWidgetImgUrl(@Nullable Uri uri) {
        this.widgetImgUrl = uri;
    }

    public final void setWidgetName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.widgetName = str;
    }

    public final void setWidgetSize(@Nullable String str) {
        this.widgetSize = str;
    }
}
