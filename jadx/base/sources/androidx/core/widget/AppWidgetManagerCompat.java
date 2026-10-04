package androidx.core.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.util.SizeFCompat;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a,\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\fH\u0002\u001a,\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\fH\u0000\u001a*\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\f\u001a,\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\fH\u0000\u001a8\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\f\u001a:\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\fH\u0000\u001a\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\u0015\u0010\u001b\u001a\u00020\u001c*\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0080\u0004\u001a\u0014\u0010\u001e\u001a\u00020\u0004*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\u0014\u0010\u001f\u001a\u00020 *\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a&\u0010!\u001a\u00020 *\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\f\u001a4\u0010!\u001a\u00020 *\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\""}, m13886d2 = {"LogTag", "", "area", "", "Landroidx/core/util/SizeFCompat;", "getArea", "(Landroidx/core/util/SizeFCompat;)F", "createAppWidget", "Landroid/widget/RemoteViews;", "landscapeSize", "portraitSize", "factory", "Lkotlin/Function1;", "createAppWidgetFromProviderInfo", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "createExactSizeAppWidget", "createExactSizeAppWidgetInner", "createResponsiveSizeAppWidget", "dpSizes", "", "createResponsiveSizeAppWidgetInner", "sizes", "getSizesFromOptionsBundle", "Landroidx/core/widget/LandscapePortraitSizes;", "approxDominates", "", "other", "getSizeFromProviderInfo", "requireValidAppWidgetId", "", "updateAppWidget", "core-remoteviews_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@JvmName(name = AppWidgetManagerCompat.LogTag)
@SourceDebugExtension({"SMAP\nAppWidgetManagerCompat.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppWidgetManagerCompat.kt\nandroidx/core/widget/AppWidgetManagerCompat\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,312:1\n1#2:313\n2333#3,14:314\n766#3:328\n857#3,2:329\n1963#3,14:331\n766#3:345\n857#3,2:346\n1963#3,14:348\n*S KotlinDebug\n*F\n+ 1 AppWidgetManagerCompat.kt\nandroidx/core/widget/AppWidgetManagerCompat\n*L\n236#1:314,14\n248#1:328\n248#1:329,2\n248#1:331,14\n250#1:345\n250#1:346,2\n250#1:348,14\n*E\n"})
public final class AppWidgetManagerCompat {

    @NotNull
    private static final String LogTag = "AppWidgetManagerCompat";

    public static final boolean approxDominates(@NotNull SizeFCompat sizeFCompat, @NotNull SizeFCompat other) {
        Intrinsics.checkNotNullParameter(sizeFCompat, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        float f = 1;
        return ((float) Math.ceil((double) sizeFCompat.getWidth())) + f >= other.getWidth() && ((float) Math.ceil((double) sizeFCompat.getHeight())) + f >= other.getHeight();
    }

    private static final RemoteViews createAppWidget(SizeFCompat sizeFCompat, SizeFCompat sizeFCompat2, Function1<? super SizeFCompat, ? extends RemoteViews> function1) {
        return Intrinsics.areEqual(sizeFCompat, sizeFCompat2) ? function1.invoke(sizeFCompat) : new RemoteViews(function1.invoke(sizeFCompat), function1.invoke(sizeFCompat2));
    }

    @NotNull
    public static final RemoteViews createAppWidgetFromProviderInfo(@NotNull AppWidgetManager appWidgetManager, int i, @NotNull Function1<? super SizeFCompat, ? extends RemoteViews> factory) {
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(factory, "factory");
        return factory.invoke(getSizeFromProviderInfo(appWidgetManager, i));
    }

    @NotNull
    public static final RemoteViews createExactSizeAppWidget(@NotNull AppWidgetManager appWidgetManager, int i, @NotNull Function1<? super SizeFCompat, ? extends RemoteViews> factory) {
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(factory, "factory");
        requireValidAppWidgetId(appWidgetManager, i);
        return Build.VERSION.SDK_INT >= 31 ? AppWidgetManagerApi31Impl.INSTANCE.createExactSizeAppWidget(appWidgetManager, i, factory) : createExactSizeAppWidgetInner(appWidgetManager, i, factory);
    }

    @NotNull
    public static final RemoteViews createExactSizeAppWidgetInner(@NotNull AppWidgetManager appWidgetManager, int i, @NotNull Function1<? super SizeFCompat, ? extends RemoteViews> factory) {
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(factory, "factory");
        LandscapePortraitSizes sizesFromOptionsBundle = getSizesFromOptionsBundle(appWidgetManager, i);
        if (sizesFromOptionsBundle != null) {
            return createAppWidget(sizesFromOptionsBundle.getLandscape(), sizesFromOptionsBundle.getPortrait(), factory);
        }
        Log.w(LogTag, "App widget sizes not found in the options bundle, falling back to the provider size");
        return createAppWidgetFromProviderInfo(appWidgetManager, i, factory);
    }

    @NotNull
    public static final RemoteViews createResponsiveSizeAppWidget(@NotNull AppWidgetManager appWidgetManager, int i, @NotNull Collection<SizeFCompat> dpSizes, @NotNull Function1<? super SizeFCompat, ? extends RemoteViews> factory) {
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(dpSizes, "dpSizes");
        Intrinsics.checkNotNullParameter(factory, "factory");
        requireValidAppWidgetId(appWidgetManager, i);
        if (dpSizes.isEmpty()) {
            throw new IllegalArgumentException("Sizes cannot be empty");
        }
        if (dpSizes.size() <= 16) {
            return Build.VERSION.SDK_INT >= 31 ? AppWidgetManagerApi31Impl.INSTANCE.createResponsiveSizeAppWidget(dpSizes, factory) : createResponsiveSizeAppWidgetInner(appWidgetManager, i, dpSizes, factory);
        }
        throw new IllegalArgumentException("At most 16 sizes may be provided");
    }

    @NotNull
    public static final RemoteViews createResponsiveSizeAppWidgetInner(@NotNull AppWidgetManager appWidgetManager, int i, @NotNull Collection<SizeFCompat> sizes, @NotNull Function1<? super SizeFCompat, ? extends RemoteViews> factory) {
        Object next;
        Object next2;
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(sizes, "sizes");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Collection<SizeFCompat> collection = sizes;
        Iterator<T> it = collection.iterator();
        Object next3 = null;
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                float area = getArea((SizeFCompat) next);
                do {
                    Object next4 = it.next();
                    float area2 = getArea((SizeFCompat) next4);
                    if (Float.compare(area, area2) > 0) {
                        next = next4;
                        area = area2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        SizeFCompat sizeFCompat = (SizeFCompat) next;
        if (sizeFCompat == null) {
            throw new IllegalStateException("Sizes cannot be empty");
        }
        LandscapePortraitSizes sizesFromOptionsBundle = getSizesFromOptionsBundle(appWidgetManager, i);
        if (sizesFromOptionsBundle == null) {
            Log.w(LogTag, "App widget sizes not found in the options bundle, falling back to the smallest supported size (" + sizeFCompat + PropertyUtils.MAPPED_DELIM2);
            sizesFromOptionsBundle = new LandscapePortraitSizes(sizeFCompat, sizeFCompat);
        }
        SizeFCompat landscape = sizesFromOptionsBundle.getLandscape();
        SizeFCompat portrait = sizesFromOptionsBundle.getPortrait();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (approxDominates(landscape, (SizeFCompat) obj)) {
                arrayList.add(obj);
            }
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            next2 = it2.next();
            if (it2.hasNext()) {
                float area3 = getArea((SizeFCompat) next2);
                do {
                    Object next5 = it2.next();
                    float area4 = getArea((SizeFCompat) next5);
                    if (Float.compare(area3, area4) < 0) {
                        next2 = next5;
                        area3 = area4;
                    }
                } while (it2.hasNext());
            }
        } else {
            next2 = null;
        }
        SizeFCompat sizeFCompat2 = (SizeFCompat) next2;
        SizeFCompat sizeFCompat3 = sizeFCompat2 == null ? sizeFCompat : sizeFCompat2;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : collection) {
            if (approxDominates(portrait, (SizeFCompat) obj2)) {
                arrayList2.add(obj2);
            }
        }
        Iterator it3 = arrayList2.iterator();
        if (it3.hasNext()) {
            next3 = it3.next();
            if (it3.hasNext()) {
                float area5 = getArea((SizeFCompat) next3);
                do {
                    Object next6 = it3.next();
                    float area6 = getArea((SizeFCompat) next6);
                    if (Float.compare(area5, area6) < 0) {
                        next3 = next6;
                        area5 = area6;
                    }
                } while (it3.hasNext());
            }
        }
        SizeFCompat sizeFCompat4 = (SizeFCompat) next3;
        if (sizeFCompat4 != null) {
            sizeFCompat = sizeFCompat4;
        }
        return createAppWidget(sizeFCompat3, sizeFCompat, factory);
    }

    public static final float getArea(@NotNull SizeFCompat sizeFCompat) {
        Intrinsics.checkNotNullParameter(sizeFCompat, "<this>");
        return sizeFCompat.getHeight() * sizeFCompat.getWidth();
    }

    @NotNull
    public static final SizeFCompat getSizeFromProviderInfo(@NotNull AppWidgetManager appWidgetManager, int i) {
        Intrinsics.checkNotNullParameter(appWidgetManager, "<this>");
        AppWidgetProviderInfo appWidgetInfo = appWidgetManager.getAppWidgetInfo(i);
        return new SizeFCompat(getSizeFromProviderInfo$pxToDp(appWidgetInfo.minWidth), getSizeFromProviderInfo$pxToDp(appWidgetInfo.minHeight));
    }

    private static final float getSizeFromProviderInfo$pxToDp(int i) {
        return i / Resources.getSystem().getDisplayMetrics().density;
    }

    private static final LandscapePortraitSizes getSizesFromOptionsBundle(AppWidgetManager appWidgetManager, int i) {
        Bundle appWidgetOptions = appWidgetManager.getAppWidgetOptions(i);
        int i2 = appWidgetOptions.getInt("appWidgetMinWidth", -1);
        int i4 = appWidgetOptions.getInt("appWidgetMaxHeight", -1);
        if (i2 >= 0 && i4 >= 0) {
            int i5 = appWidgetOptions.getInt("appWidgetMaxWidth", -1);
            int i6 = appWidgetOptions.getInt("appWidgetMinHeight", -1);
            if (i5 >= 0 && i6 >= 0) {
                return new LandscapePortraitSizes(new SizeFCompat(i5, i6), new SizeFCompat(i2, i4));
            }
        }
        return null;
    }

    private static final void requireValidAppWidgetId(AppWidgetManager appWidgetManager, int i) {
        if (appWidgetManager.getAppWidgetInfo(i) == null) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Invalid app widget id: ").toString());
        }
    }

    public static final void updateAppWidget(@NotNull AppWidgetManager appWidgetManager, int i, @NotNull Function1<? super SizeFCompat, ? extends RemoteViews> factory) {
        Intrinsics.checkNotNullParameter(appWidgetManager, "<this>");
        Intrinsics.checkNotNullParameter(factory, "factory");
        appWidgetManager.updateAppWidget(i, createExactSizeAppWidget(appWidgetManager, i, factory));
    }

    public static final void updateAppWidget(@NotNull AppWidgetManager appWidgetManager, int i, @NotNull Collection<SizeFCompat> dpSizes, @NotNull Function1<? super SizeFCompat, ? extends RemoteViews> factory) {
        Intrinsics.checkNotNullParameter(appWidgetManager, "<this>");
        Intrinsics.checkNotNullParameter(dpSizes, "dpSizes");
        Intrinsics.checkNotNullParameter(factory, "factory");
        appWidgetManager.updateAppWidget(i, createResponsiveSizeAppWidget(appWidgetManager, i, dpSizes, factory));
    }
}
