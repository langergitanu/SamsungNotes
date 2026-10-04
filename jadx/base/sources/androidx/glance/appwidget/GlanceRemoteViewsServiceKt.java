package androidx.glance.appwidget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0001¨\u0006\f"}, m13886d2 = {"setRemoteAdapter", "", "Landroid/widget/RemoteViews;", "context", "Landroid/content/Context;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "viewId", "sizeInfo", "", "items", "Landroidx/glance/appwidget/RemoteCollectionItems;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class GlanceRemoteViewsServiceKt {
    @DoNotInline
    public static final void setRemoteAdapter(@NotNull RemoteViews remoteViews, @NotNull Context context, int i, int i2, @NotNull String sizeInfo, @NotNull RemoteCollectionItems items) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sizeInfo, "sizeInfo");
        Intrinsics.checkNotNullParameter(items, "items");
        if (Build.VERSION.SDK_INT > 31) {
            CollectionItemsApi31Impl.INSTANCE.setRemoteAdapter(remoteViews, i2, items);
            return;
        }
        Intent intentPutExtra = new Intent(context, (Class<?>) GlanceRemoteViewsService.class).putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, i).putExtra(GlanceRemoteViewsService.EXTRA_VIEW_ID, i2).putExtra(GlanceRemoteViewsService.EXTRA_SIZE_INFO, sizeInfo);
        intentPutExtra.setData(Uri.parse(intentPutExtra.toUri(1)));
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "apply(...)");
        if (context.getPackageManager().resolveService(intentPutExtra, 0) == null) {
            throw new IllegalStateException("GlanceRemoteViewsService could not be resolved, check the app manifest.");
        }
        remoteViews.setRemoteAdapter(i2, intentPutExtra);
        GlanceRemoteViewsService.INSTANCE.saveItems$glance_appwidget_release(i, i2, sizeInfo, items);
        AppWidgetManager.getInstance(context).notifyAppWidgetViewDataChanged(i, i2);
    }
}
