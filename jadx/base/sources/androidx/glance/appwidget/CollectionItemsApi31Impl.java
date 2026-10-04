package androidx.glance.appwidget;

import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(31)
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\r"}, m13886d2 = {"Landroidx/glance/appwidget/CollectionItemsApi31Impl;", "", "()V", "setRemoteAdapter", "", "remoteViews", "Landroid/widget/RemoteViews;", "viewId", "", "items", "Landroidx/glance/appwidget/RemoteCollectionItems;", "toPlatformCollectionItems", "Landroid/widget/RemoteViews$RemoteCollectionItems;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
final class CollectionItemsApi31Impl {

    @NotNull
    public static final CollectionItemsApi31Impl INSTANCE = new CollectionItemsApi31Impl();

    private CollectionItemsApi31Impl() {
    }

    @DoNotInline
    public final void setRemoteAdapter(@NotNull RemoteViews remoteViews, int viewId, @NotNull RemoteCollectionItems items) {
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(items, "items");
        remoteViews.setRemoteAdapter(viewId, toPlatformCollectionItems(items));
    }

    @DoNotInline
    @NotNull
    public final RemoteViews.RemoteCollectionItems toPlatformCollectionItems(@NotNull RemoteCollectionItems items) {
        Intrinsics.checkNotNullParameter(items, "items");
        RemoteViews.RemoteCollectionItems.Builder viewTypeCount = new RemoteViews.RemoteCollectionItems.Builder().setHasStableIds(items.getHasStableIds()).setViewTypeCount(items.get_viewTypeCount());
        int itemCount = items.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            viewTypeCount.addItem(items.getItemId(i), items.getItemView(i));
        }
        RemoteViews.RemoteCollectionItems remoteCollectionItemsBuild = viewTypeCount.build();
        Intrinsics.checkNotNullExpressionValue(remoteCollectionItemsBuild, "build(...)");
        return remoteCollectionItemsBuild;
    }
}
