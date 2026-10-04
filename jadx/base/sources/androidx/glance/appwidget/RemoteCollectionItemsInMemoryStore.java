package androidx.glance.appwidget;

import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005J \u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005J&\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Landroidx/glance/appwidget/RemoteCollectionItemsInMemoryStore;", "", "()V", "items", "", "", "Landroidx/glance/appwidget/RemoteCollectionItems;", "getItems", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "viewId", "sizeInfo", "key", "removeItems", "", "save", "remoteCollectionItems", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
final class RemoteCollectionItemsInMemoryStore {

    @NotNull
    private final Map<String, RemoteCollectionItems> items = new LinkedHashMap();

    private final String key(int appWidgetId, int viewId, String sizeInfo) {
        return appWidgetId + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + viewId + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + sizeInfo;
    }

    @NotNull
    public final RemoteCollectionItems getItems(int appWidgetId, int viewId, @NotNull String sizeInfo) {
        Intrinsics.checkNotNullParameter(sizeInfo, "sizeInfo");
        RemoteCollectionItems remoteCollectionItems = this.items.get(key(appWidgetId, viewId, sizeInfo));
        return remoteCollectionItems == null ? RemoteCollectionItems.INSTANCE.getEmpty() : remoteCollectionItems;
    }

    public final void removeItems(int appWidgetId, int viewId, @NotNull String sizeInfo) {
        Intrinsics.checkNotNullParameter(sizeInfo, "sizeInfo");
        this.items.remove(key(appWidgetId, viewId, sizeInfo));
    }

    public final void save(int appWidgetId, int viewId, @NotNull String sizeInfo, @NotNull RemoteCollectionItems remoteCollectionItems) {
        Intrinsics.checkNotNullParameter(sizeInfo, "sizeInfo");
        Intrinsics.checkNotNullParameter(remoteCollectionItems, "remoteCollectionItems");
        this.items.put(key(appWidgetId, viewId, sizeInfo), remoteCollectionItems);
    }
}
