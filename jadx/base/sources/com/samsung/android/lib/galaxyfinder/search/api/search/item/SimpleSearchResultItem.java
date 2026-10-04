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
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SimpleSearchResultItem;", "Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SearchResultItem;", "itemKey", "", "icon", "Landroid/net/Uri;", "text", "text2", "groupName", SearchIndexablesContract.RawData.PAYLOAD, "Lcom/samsung/android/lib/galaxyfinder/search/api/payload/IntentResultItemPayload;", "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/samsung/android/lib/galaxyfinder/search/api/payload/IntentResultItemPayload;)V", "group", "getGroup", "()Ljava/lang/String;", "DeviceSearchLibrary_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SimpleSearchResultItem extends SearchResultItem {

    @NotNull
    private final String groupName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleSearchResultItem(@NotNull String itemKey, @Nullable Uri uri, @NotNull String text, @Nullable String str, @NotNull String groupName, @Nullable IntentResultItemPayload intentResultItemPayload) {
        super(itemKey, uri, text, str, intentResultItemPayload);
        Intrinsics.checkNotNullParameter(itemKey, "itemKey");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        this.groupName = groupName;
    }

    @Override // com.samsung.android.lib.galaxyfinder.search.api.search.item.SearchResultItem
    @NotNull
    /* JADX INFO: renamed from: getGroup, reason: from getter */
    public String getGroupName() {
        return this.groupName;
    }
}
