package com.samsung.android.lib.galaxyfinder.search.api.search;

import com.samsung.android.lib.galaxyfinder.search.api.search.item.SimpleSearchResultItem;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\u001d\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\t2\u0006\u0010\u0013\u001a\u00020\u0002H\u0014¢\u0006\u0002\u0010\u0014R\u001c\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\t8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/lib/galaxyfinder/search/api/search/SimpleSearchResult;", "Lcom/samsung/android/lib/galaxyfinder/search/api/search/SearchResult;", "Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SimpleSearchResultItem;", "query", "", "resultType", "(Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;)V", "itemColumns", "", "getItemColumns", "()[Ljava/lang/String;", "mResultType", "getResultType", "()Ljava/lang/String;", "resultVersion", "getResultVersion", "transformCursorRaw", "", "item", "(Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SimpleSearchResultItem;)[Ljava/lang/Object;", "DeviceSearchLibrary_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SimpleSearchResult extends SearchResult<SimpleSearchResultItem> {

    @NotNull
    private String mResultType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleSearchResult(@NotNull String query) {
        super(query, SimpleSearchResultItem.class);
        Intrinsics.checkNotNullParameter(query, "query");
        this.mResultType = "";
    }

    @Override // com.samsung.android.lib.galaxyfinder.search.api.search.SearchResult
    @NotNull
    public String[] getItemColumns() {
        return new String[0];
    }

    @Override // com.samsung.android.lib.galaxyfinder.search.api.search.SearchResult
    @NotNull
    public String getResultType() {
        String str = this.mResultType;
        return str.length() == 0 ? NetworkConfig.CLIENTS_BASIC : str;
    }

    @Override // com.samsung.android.lib.galaxyfinder.search.api.search.SearchResult
    @NotNull
    public String getResultVersion() {
        return "1";
    }

    @Override // com.samsung.android.lib.galaxyfinder.search.api.search.SearchResult
    @NotNull
    public Object[] transformCursorRaw(@NotNull SimpleSearchResultItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return new Object[0];
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleSearchResult(@NotNull String query, @NotNull String resultType) {
        this(query);
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(resultType, "resultType");
        this.mResultType = resultType;
    }
}
