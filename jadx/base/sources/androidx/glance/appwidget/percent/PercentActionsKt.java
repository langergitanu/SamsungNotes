package androidx.glance.appwidget.percent;

import android.widget.RemoteViews;
import androidx.glance.appwidget.InsertedViewInfo;
import androidx.glance.appwidget.TranslationContext;
import androidx.glance.appwidget.util.RemoteViewsExtensionKt;
import androidx.glance.appwidget.util.RemoteViewsReflections;
import androidx.glance.oneui.common.GlanceLog;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.namefind.BilouCodec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u001a(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a>\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a2\u0010\u0013\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0015\u001aD\u0010\u001a\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001aB\u0010$\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010%\u001a\u00020\u001c2\b\b\u0001\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010(\u001a\u00020\u001c2\b\b\u0002\u0010)\u001a\u00020\u001c\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006*"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "applyPercentPaddingModifiers", "", "translationContext", "Landroidx/glance/appwidget/TranslationContext;", "rv", "Landroid/widget/RemoteViews;", "percentPaddingModifier", "Landroidx/glance/appwidget/percent/PercentPaddingModifier;", "viewDef", "Landroidx/glance/appwidget/InsertedViewInfo;", "applyPercentSizeModifiers", "percentRatioSizeModifier", "Landroidx/glance/appwidget/percent/PercentRatioSizeModifier;", "percentWidthModifier", "Landroidx/glance/appwidget/percent/PercentWidthModifier;", "percentHeightModifier", "Landroidx/glance/appwidget/percent/PercentHeightModifier;", "setAutoSizeTextTypeUniformWithConfiguration", "viewId", "", "autoSizeMinTextSize", "autoSizeMaxTextSize", "autoSizeStepGranularity", BilouCodec.UNIT, "setViewPaddingPercent", "left", "", "top", "right", "bottom", "policy", "Landroidx/glance/appwidget/percent/PercentSizePolicy;", "setViewPaddingPercent-E-5S6FA", "(Landroid/widget/RemoteViews;IFFFFI)V", "setViewTextPercent", "heightPercent", "widthPercent", "text", "minSize", "maxSize", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPercentActions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PercentActions.kt\nandroidx/glance/appwidget/percent/PercentActionsKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,142:1\n1109#2,2:143\n1109#2,2:145\n1109#2,2:147\n*S KotlinDebug\n*F\n+ 1 PercentActions.kt\nandroidx/glance/appwidget/percent/PercentActionsKt\n*L\n69#1:143,2\n90#1:145,2\n127#1:147,2\n*E\n"})
public final class PercentActionsKt {

    @NotNull
    private static final String TAG = "GWT:PercentSizeAction";

    public static final void applyPercentPaddingModifiers(@NotNull TranslationContext translationContext, @NotNull RemoteViews rv, @NotNull PercentPaddingModifier percentPaddingModifier, @NotNull InsertedViewInfo viewDef) {
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(percentPaddingModifier, "percentPaddingModifier");
        Intrinsics.checkNotNullParameter(viewDef, "viewDef");
        m21359setViewPaddingPercentE5S6FA(rv, viewDef.getMainViewId(), percentPaddingModifier.getStart(), percentPaddingModifier.getTop(), percentPaddingModifier.getEnd(), percentPaddingModifier.getBottom(), percentPaddingModifier.getPercentPolicy());
    }

    public static final void applyPercentSizeModifiers(@NotNull TranslationContext translationContext, @NotNull RemoteViews rv, @Nullable PercentRatioSizeModifier percentRatioSizeModifier, @Nullable PercentWidthModifier percentWidthModifier, @Nullable PercentHeightModifier percentHeightModifier, @NotNull InsertedViewInfo viewDef) {
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(viewDef, "viewDef");
        int mainViewId = viewDef.getMainViewId();
        if (percentRatioSizeModifier != null) {
            RemoteViewsExtensionKt.setViewLayoutPercent(rv, mainViewId, percentRatioSizeModifier.getWidth(), percentRatioSizeModifier.getHeight(), percentRatioSizeModifier.getMaxWidth(), percentRatioSizeModifier.getMaxHeight(), percentRatioSizeModifier.getRatio());
            return;
        }
        if (percentWidthModifier != null) {
            RemoteViewsExtensionKt.m21416setViewLayoutPercentI9SXPLc(rv, mainViewId, percentWidthModifier.getWidth(), percentWidthModifier.getPercentPolicy(), PercentParamType.INSTANCE.m21371getLAYOUT_WIDTHlhCYxaY(), percentWidthModifier.getMaxWidth(), percentWidthModifier.getMaxWidth());
        }
        if (percentHeightModifier != null) {
            RemoteViewsExtensionKt.m21416setViewLayoutPercentI9SXPLc(rv, mainViewId, percentHeightModifier.getHeight(), percentHeightModifier.getPercentPolicy(), PercentParamType.INSTANCE.m21370getLAYOUT_HEIGHTlhCYxaY(), percentHeightModifier.getMaxHeight(), percentHeightModifier.getMaxHeight());
        }
    }

    public static final void setAutoSizeTextTypeUniformWithConfiguration(@NotNull RemoteViews remoteViews, int i, int i2, int i4, int i5, int i6) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        try {
            Method[] declaredMethods = remoteViews.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            for (Method method : declaredMethods) {
                method.setAccessible(true);
                if (Intrinsics.areEqual(method.getName(), RemoteViewsReflections.SET_AUTO_SIZE_TEXT_TYPE_UNIFORM_WITH_CONFIGURATION)) {
                    method.invoke(remoteViews, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
                    return;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } catch (Exception e) {
            GlanceLog.INSTANCE.m2305w(TAG, "hidden_semSetAutoSizeTextTypeUniformWithConfiguration isn't supported. / " + e);
        }
    }

    /* JADX INFO: renamed from: setViewPaddingPercent-E-5S6FA, reason: not valid java name */
    public static final void m21359setViewPaddingPercentE5S6FA(@NotNull RemoteViews setViewPaddingPercent, int i, float f, float f4, float f5, float f6, int i2) {
        Intrinsics.checkNotNullParameter(setViewPaddingPercent, "$this$setViewPaddingPercent");
        try {
            Method[] declaredMethods = setViewPaddingPercent.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            for (Method method : declaredMethods) {
                method.setAccessible(true);
                if (Intrinsics.areEqual(method.getName(), RemoteViewsReflections.SET_VIEW_PADDING_PERCENT)) {
                    method.invoke(setViewPaddingPercent, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Integer.valueOf(PercentSizePolicy.m21377toIntimpl(i2)));
                    return;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } catch (Exception e) {
            GlanceLog.INSTANCE.m2305w(TAG, "hidden_semSetPercentViewPadding isn't supported. / " + e);
        }
    }

    public static final void setViewTextPercent(@NotNull RemoteViews remoteViews, int i, @PercentRange float f, @PercentRange float f4, @NotNull String text, float f5, float f6) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        try {
            Method[] declaredMethods = remoteViews.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            int length = declaredMethods.length;
            int i2 = 0;
            while (i2 < length) {
                Method method = declaredMethods[i2];
                method.setAccessible(true);
                if (Intrinsics.areEqual(method.getName(), RemoteViewsReflections.SET_VIEW_TEXT_PERCENT)) {
                    method.invoke(remoteViews, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(Math.min(50.0f, f6)), text);
                    return;
                } else {
                    i2++;
                    f6 = f6;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } catch (Exception e) {
            GlanceLog.INSTANCE.m2305w(TAG, "hidden_semSetTextPercentSize isn't supported. / " + e);
        }
    }

    public static /* synthetic */ void setViewTextPercent$default(RemoteViews remoteViews, int i, float f, float f4, String str, float f5, float f6, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            f5 = 0.0f;
        }
        if ((i2 & 32) != 0) {
            f6 = 0.0f;
        }
        setViewTextPercent(remoteViews, i, f, f4, str, f5, f6);
    }
}
