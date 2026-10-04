package androidx.core.widget;

import android.appwidget.AppWidgetManager;
import android.util.Log;
import android.util.SizeF;
import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.util.SizeFCompat;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(31)
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\nH\u0007J*\u0010\f\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\nH\u0007J\f\u0010\u000f\u001a\u00020\u000b*\u00020\u0010H\u0002¨\u0006\u0011"}, m13886d2 = {"Landroidx/core/widget/AppWidgetManagerApi31Impl;", "", "()V", "createExactSizeAppWidget", "Landroid/widget/RemoteViews;", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "factory", "Lkotlin/Function1;", "Landroidx/core/util/SizeFCompat;", "createResponsiveSizeAppWidget", "dpSizes", "", "toSizeFCompat", "Landroid/util/SizeF;", "core-remoteviews_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAppWidgetManagerCompat.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppWidgetManagerCompat.kt\nandroidx/core/widget/AppWidgetManagerApi31Impl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,312:1\n1271#2,2:313\n1285#2,4:315\n1179#2,2:319\n1253#2,4:321\n*S KotlinDebug\n*F\n+ 1 AppWidgetManagerCompat.kt\nandroidx/core/widget/AppWidgetManagerApi31Impl\n*L\n198#1:313,2\n198#1:315,4\n206#1:319,2\n206#1:321,4\n*E\n"})
final class AppWidgetManagerApi31Impl {

    @NotNull
    public static final AppWidgetManagerApi31Impl INSTANCE = new AppWidgetManagerApi31Impl();

    private AppWidgetManagerApi31Impl() {
    }

    private final SizeFCompat toSizeFCompat(SizeF sizeF) {
        SizeFCompat sizeFCompat = SizeFCompat.toSizeFCompat(sizeF);
        Intrinsics.checkNotNullExpressionValue(sizeFCompat, "toSizeFCompat(this)");
        return sizeFCompat;
    }

    @DoNotInline
    @NotNull
    public final RemoteViews createExactSizeAppWidget(@NotNull AppWidgetManager appWidgetManager, int appWidgetId, @NotNull Function1<? super SizeFCompat, ? extends RemoteViews> factory) {
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(factory, "factory");
        ArrayList parcelableArrayList = appWidgetManager.getAppWidgetOptions(appWidgetId).getParcelableArrayList("appWidgetSizes");
        if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
            Log.w("AppWidgetManagerCompat", "App widget SizeF sizes not found in the options bundle, falling back to the min/max sizes");
            return AppWidgetManagerCompat.createExactSizeAppWidgetInner(appWidgetManager, appWidgetId, factory);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.m13952k(parcelableArrayList)), 16));
        for (Object obj : parcelableArrayList) {
            SizeF it = (SizeF) obj;
            AppWidgetManagerApi31Impl appWidgetManagerApi31Impl = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            linkedHashMap.put(obj, factory.invoke(appWidgetManagerApi31Impl.toSizeFCompat(it)));
        }
        return new RemoteViews(linkedHashMap);
    }

    @DoNotInline
    @NotNull
    public final RemoteViews createResponsiveSizeAppWidget(@NotNull Collection<SizeFCompat> dpSizes, @NotNull Function1<? super SizeFCompat, ? extends RemoteViews> factory) {
        Intrinsics.checkNotNullParameter(dpSizes, "dpSizes");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Collection<SizeFCompat> collection = dpSizes;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.m13952k(collection)), 16));
        for (SizeFCompat sizeFCompat : collection) {
            Pair pairM13893to = TuplesKt.m13893to(sizeFCompat.toSizeF(), factory.invoke(sizeFCompat));
            linkedHashMap.put(pairM13893to.getFirst(), pairM13893to.getSecond());
        }
        return new RemoteViews(linkedHashMap);
    }
}
