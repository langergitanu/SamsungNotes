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
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/GalaxyStoreSearchResultItem;", "Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SearchResultItem;", "appID", "", "productImgUrl", "Landroid/net/Uri;", "productName", "sellerName", "price", SearchIndexablesContract.RawData.PAYLOAD, "Lcom/samsung/android/lib/galaxyfinder/search/api/payload/IntentResultItemPayload;", "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/samsung/android/lib/galaxyfinder/search/api/payload/IntentResultItemPayload;)V", "getAppID", "()Ljava/lang/String;", "group", "getGroup", "getPrice", "getProductImgUrl", "()Landroid/net/Uri;", "getProductName", "getSellerName", "DeviceSearchLibrary_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class GalaxyStoreSearchResultItem extends SearchResultItem {

    @NotNull
    private final String appID;

    @NotNull
    private final String price;

    @Nullable
    private final Uri productImgUrl;

    @NotNull
    private final String productName;

    @Nullable
    private final String sellerName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GalaxyStoreSearchResultItem(@NotNull String appID, @Nullable Uri uri, @NotNull String productName, @Nullable String str, @NotNull String price, @Nullable IntentResultItemPayload intentResultItemPayload) {
        super(appID, uri, productName, str, intentResultItemPayload);
        Intrinsics.checkNotNullParameter(appID, "appID");
        Intrinsics.checkNotNullParameter(productName, "productName");
        Intrinsics.checkNotNullParameter(price, "price");
        this.appID = appID;
        this.productImgUrl = uri;
        this.productName = productName;
        this.sellerName = str;
        this.price = price;
    }

    @NotNull
    public final String getAppID() {
        return this.appID;
    }

    @Override // com.samsung.android.lib.galaxyfinder.search.api.search.item.SearchResultItem
    @Nullable
    public String getGroup() {
        return null;
    }

    @NotNull
    public final String getPrice() {
        return this.price;
    }

    @Nullable
    public final Uri getProductImgUrl() {
        return this.productImgUrl;
    }

    @NotNull
    public final String getProductName() {
        return this.productName;
    }

    @Nullable
    public final String getSellerName() {
        return this.sellerName;
    }
}
