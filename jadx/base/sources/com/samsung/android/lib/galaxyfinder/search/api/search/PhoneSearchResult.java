package com.samsung.android.lib.galaxyfinder.search.api.search;

import com.samsung.android.lib.galaxyfinder.search.api.search.item.PhoneSearchResultItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00072\u0006\u0010\u0011\u001a\u00020\u0002H\u0014¢\u0006\u0002\u0010\u0012R\u001c\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00078TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/lib/galaxyfinder/search/api/search/PhoneSearchResult;", "Lcom/samsung/android/lib/galaxyfinder/search/api/search/SearchResult;", "Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/PhoneSearchResultItem;", "query", "", "(Ljava/lang/String;)V", "itemColumns", "", "getItemColumns", "()[Ljava/lang/String;", "resultType", "getResultType", "()Ljava/lang/String;", "resultVersion", "getResultVersion", "transformCursorRaw", "", "item", "(Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/PhoneSearchResultItem;)[Ljava/lang/Object;", "DeviceSearchLibrary_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class PhoneSearchResult extends SearchResult<PhoneSearchResultItem> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneSearchResult(@NotNull String query) {
        super(query, PhoneSearchResultItem.class);
        Intrinsics.checkNotNullParameter(query, "query");
    }

    @Override // com.samsung.android.lib.galaxyfinder.search.api.search.SearchResult
    @NotNull
    public String[] getItemColumns() {
        return new String[]{"tertiaryText", "tagIcon"};
    }

    @Override // com.samsung.android.lib.galaxyfinder.search.api.search.SearchResult
    @NotNull
    public String getResultType() {
        return "Phone";
    }

    @Override // com.samsung.android.lib.galaxyfinder.search.api.search.SearchResult
    @NotNull
    public String getResultVersion() {
        return "1";
    }

    @Override // com.samsung.android.lib.galaxyfinder.search.api.search.SearchResult
    @NotNull
    public Object[] transformCursorRaw(@NotNull PhoneSearchResultItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return new Object[]{item.getTertiaryText(), item.getTagIcon()};
    }
}
