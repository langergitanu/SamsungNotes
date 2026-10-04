package androidx.glance.appwidget.util;

import android.widget.RemoteViews;
import androidx.annotation.StyleRes;
import androidx.glance.appwidget.percent.PercentParamType;
import androidx.glance.appwidget.percent.PercentRange;
import androidx.glance.appwidget.percent.PercentSizePolicy;
import androidx.glance.oneui.common.GlanceLog;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a=\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\n\"\u00020\bH\u0002¢\u0006\u0002\u0010\u000b\u001a&\u0010\f\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001e\u0010\u0013\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u0014\u001a\u00020\u000eH\u0000\u001aL\u0010\u0015\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00172\b\b\u0002\u0010\u001d\u001a\u00020\u0017H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001aF\u0010\u0015\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010 \u001a\u00020\u00172\b\b\u0001\u0010!\u001a\u00020\u00172\b\b\u0002\u0010\u001c\u001a\u00020\u00172\b\b\u0002\u0010\u001d\u001a\u00020\u00172\b\b\u0002\u0010\"\u001a\u00020\u0017H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "invokeMethod", "", "Landroid/widget/RemoteViews;", "method", "paramTypes", "", "", ActionHandler.PARAMS, "", "(Landroid/widget/RemoteViews;Ljava/lang/String;Ljava/util/List;[Ljava/lang/Object;)V", "setFadingEdgeOnListView", "viewId", "", "edgeLength", "Landroidx/compose/ui/unit/Dp;", "setFadingEdgeOnListView-wH6b6FI", "(Landroid/widget/RemoteViews;IF)V", "setTextAppearanceStyle", "resId", "setViewLayoutPercent", "percent", "", "percentPolicy", "Landroidx/glance/appwidget/percent/PercentSizePolicy;", "percentType", "Landroidx/glance/appwidget/percent/PercentParamType;", "maxWidthSize", "maxHeightSize", "setViewLayoutPercent-I9SXPLc", "(Landroid/widget/RemoteViews;IFIIFF)V", "width", "height", "ratio", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nRemoteViewsExtension.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteViewsExtension.kt\nandroidx/glance/appwidget/util/RemoteViewsExtensionKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,115:1\n1109#2,2:116\n*S KotlinDebug\n*F\n+ 1 RemoteViewsExtension.kt\nandroidx/glance/appwidget/util/RemoteViewsExtensionKt\n*L\n104#1:116,2\n*E\n"})
public final class RemoteViewsExtensionKt {

    @NotNull
    private static final String TAG = "GWT:RemoteViewsExtension";

    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void invokeMethod(RemoteViews remoteViews, String str, List<? extends Object> list, Object... objArr) {
        boolean zAreEqual;
        try {
            Method[] declaredMethods = remoteViews.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            for (Method method : declaredMethods) {
                boolean z = true;
                method.setAccessible(true);
                if (Intrinsics.areEqual(method.getName(), str)) {
                    if (list.isEmpty()) {
                        zAreEqual = true;
                    } else {
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        Intrinsics.checkNotNullExpressionValue(parameterTypes, "getParameterTypes(...)");
                        zAreEqual = Intrinsics.areEqual(ArraysKt.toList(parameterTypes), list);
                    }
                    if (zAreEqual) {
                    }
                } else {
                    z = false;
                }
                if (z) {
                    method.invoke(remoteViews, Arrays.copyOf(objArr, objArr.length));
                    return;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } catch (Exception e) {
            GlanceLog.INSTANCE.m2305w(TAG, str + " " + objArr.length + " isn't supported. " + e);
        }
    }

    public static /* synthetic */ void invokeMethod$default(RemoteViews remoteViews, String str, List list, Object[] objArr, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        invokeMethod(remoteViews, str, list, objArr);
    }

    /* JADX INFO: renamed from: setFadingEdgeOnListView-wH6b6FI, reason: not valid java name */
    public static final void m21415setFadingEdgeOnListViewwH6b6FI(@NotNull RemoteViews setFadingEdgeOnListView, int i, float f) {
        Intrinsics.checkNotNullParameter(setFadingEdgeOnListView, "$this$setFadingEdgeOnListView");
        setFadingEdgeOnListView.setBoolean(i, RemoteViewsListReflections.SET_VERTICAL_FADING_EDGE_ENABLED, true);
        setFadingEdgeOnListView.setInt(i, RemoteViewsListReflections.SET_FADING_EDGE_LENGTH, (int) f);
        setFadingEdgeOnListView.setFloat(i, RemoteViewsListReflections.SET_BOTTOM_FADING_EDGE_STRENGTH, 1.0f);
        setFadingEdgeOnListView.setFloat(i, RemoteViewsListReflections.SET_TOP_FADING_EDGE_STRENGTH, 0.0f);
    }

    public static final void setTextAppearanceStyle(@NotNull RemoteViews remoteViews, int i, @StyleRes int i2) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        invokeMethod$default(remoteViews, RemoteViewsReflections.SET_TEXT_APPEARANCE, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}, 2, null);
    }

    public static final void setViewLayoutPercent(@NotNull RemoteViews remoteViews, int i, @PercentRange float f, @PercentRange float f4, float f5, float f6, float f7) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Class cls = Integer.TYPE;
        Class cls2 = Float.TYPE;
        invokeMethod(remoteViews, RemoteViewsReflections.SET_VIEW_LAYOUT_PERCENT, CollectionsKt.listOf((Object[]) new Class[]{cls, cls2, cls2, cls2, cls2, cls2}), Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7));
    }

    public static /* synthetic */ void setViewLayoutPercent$default(RemoteViews remoteViews, int i, float f, float f4, float f5, float f6, float f7, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            f5 = Float.MIN_VALUE;
        }
        float f8 = f5;
        if ((i2 & 16) != 0) {
            f6 = Float.MAX_VALUE;
        }
        float f9 = f6;
        if ((i2 & 32) != 0) {
            f7 = 0.0f;
        }
        setViewLayoutPercent(remoteViews, i, f, f4, f8, f9, f7);
    }

    /* JADX INFO: renamed from: setViewLayoutPercent-I9SXPLc, reason: not valid java name */
    public static final void m21416setViewLayoutPercentI9SXPLc(@NotNull RemoteViews setViewLayoutPercent, int i, @PercentRange float f, int i2, int i4, float f4, float f5) {
        Intrinsics.checkNotNullParameter(setViewLayoutPercent, "$this$setViewLayoutPercent");
        Class cls = Integer.TYPE;
        Class cls2 = Float.TYPE;
        List listListOf = CollectionsKt.listOf((Object[]) new Class[]{cls, cls2, cls, cls, cls2, cls2});
        Integer numValueOf = Integer.valueOf(i);
        Float fValueOf = Float.valueOf(f);
        PercentSizePolicy.Companion companion = PercentSizePolicy.INSTANCE;
        invokeMethod(setViewLayoutPercent, RemoteViewsReflections.SET_VIEW_LAYOUT_PERCENT, listListOf, numValueOf, fValueOf, Integer.valueOf(PercentSizePolicy.m21375equalsimpl0(i2, companion.m21382getWidth3SpTkPA()) ? PercentSizePolicy.m21377toIntimpl(companion.m21382getWidth3SpTkPA()) : PercentSizePolicy.m21377toIntimpl(companion.m21381getHeight3SpTkPA())), Integer.valueOf(PercentParamType.m21367toIntimpl(i4)), Float.valueOf(f4), Float.valueOf(f5));
    }

    /* JADX INFO: renamed from: setViewLayoutPercent-I9SXPLc$default, reason: not valid java name */
    public static /* synthetic */ void m21417setViewLayoutPercentI9SXPLc$default(RemoteViews remoteViews, int i, float f, int i2, int i4, float f4, float f5, int i5, Object obj) {
        if ((i5 & 16) != 0) {
            f4 = 0.0f;
        }
        if ((i5 & 32) != 0) {
            f5 = 0.0f;
        }
        m21416setViewLayoutPercentI9SXPLc(remoteViews, i, f, i2, i4, f4, f5);
    }
}
