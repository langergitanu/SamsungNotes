package com.samsung.android.lib.galaxyfinder.search.api.search.item;

import android.net.Uri;
import androidx.annotation.RequiresApi;
import com.samsung.android.lib.galaxyfinder.search.api.payload.IntentResultItemPayload;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@RequiresApi(35)
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/Thumbnail1SearchResultItem;", "Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SearchResultItem;", "itemKey", "", "thumbnail", "Landroid/net/Uri;", "runningTime", "contentDescription", SearchIndexablesContract.RawData.PAYLOAD, "Lcom/samsung/android/lib/galaxyfinder/search/api/payload/IntentResultItemPayload;", "groupName", "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Lcom/samsung/android/lib/galaxyfinder/search/api/payload/IntentResultItemPayload;Ljava/lang/String;)V", "getContentDescription", "()Ljava/lang/String;", "group", "getGroup", "getRunningTime", "setRunningTime", "(Ljava/lang/String;)V", "DeviceSearchLibrary_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class Thumbnail1SearchResultItem extends SearchResultItem {

    @NotNull
    private final String contentDescription;

    @Nullable
    private final String groupName;

    @Nullable
    private String runningTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Thumbnail1SearchResultItem(@NotNull String itemKey, @NotNull Uri thumbnail, @Nullable String str, @NotNull String contentDescription, @Nullable IntentResultItemPayload intentResultItemPayload, @Nullable String str2) {
        super(itemKey, thumbnail, null, null, intentResultItemPayload);
        Intrinsics.checkNotNullParameter(itemKey, "itemKey");
        Intrinsics.checkNotNullParameter(thumbnail, "thumbnail");
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        this.runningTime = str;
        this.contentDescription = contentDescription;
        this.groupName = str2;
    }

    @NotNull
    public final String getContentDescription() {
        return this.contentDescription;
    }

    @Override // com.samsung.android.lib.galaxyfinder.search.api.search.item.SearchResultItem
    @Nullable
    /* JADX INFO: renamed from: getGroup, reason: from getter */
    public String getGroupName() {
        return this.groupName;
    }

    @Nullable
    public final String getRunningTime() {
        return this.runningTime;
    }

    public final void setRunningTime(@Nullable String str) {
        this.runningTime = str;
    }
}
