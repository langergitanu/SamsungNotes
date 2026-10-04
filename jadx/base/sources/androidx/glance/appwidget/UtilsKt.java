package androidx.glance.appwidget;

import android.content.Context;
import android.widget.RemoteViews;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.core.widget.RemoteViewsCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00012\b\b\u0003\u0010\u0006\u001a\u00020\u00012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0001¢\u0006\u0002\u0010\b\u001a\u0019\u0010\t\u001a\u00020\n*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\u0010\r\u001a\u001c\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\u001a\u001e\u0010\u0013\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001e\u0010\u0013\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0018\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, m13886d2 = {"inflateViewStub", "", "Landroid/widget/RemoteViews;", "translationContext", "Landroidx/glance/appwidget/TranslationContext;", "viewStubId", "layoutId", "inflatedId", "(Landroid/widget/RemoteViews;Landroidx/glance/appwidget/TranslationContext;IILjava/lang/Integer;)I", "pixelsToDp", "Landroidx/compose/ui/unit/Dp;", "density", "", "(IF)F", "setViewEnabled", "", "viewId", "enabled", "", "toPixels", "context", "Landroid/content/Context;", "toPixels-D5KLDUw", "(FLandroid/content/Context;)I", "(FF)I", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\nandroidx/glance/appwidget/UtilsKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,65:1\n174#2:66\n1#3:67\n*S KotlinDebug\n*F\n+ 1 Utils.kt\nandroidx/glance/appwidget/UtilsKt\n*L\n34#1:66\n*E\n"})
public final class UtilsKt {
    @IdRes
    public static final int inflateViewStub(@NotNull RemoteViews remoteViews, @NotNull TranslationContext translationContext, @IdRes int i, @LayoutRes int i2, @IdRes @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        if (i == -1) {
            throw new IllegalArgumentException("viewStubId must not be View.NO_ID");
        }
        int iIntValue = num != null ? num.intValue() : translationContext.nextViewId();
        if (iIntValue != -1) {
            RemoteViewsCompat.setViewStubInflatedId(remoteViews, i, iIntValue);
        }
        if (i2 != 0) {
            RemoteViewsCompat.setViewStubLayoutResource(remoteViews, i, i2);
        }
        remoteViews.setViewVisibility(i, 0);
        return iIntValue;
    }

    public static /* synthetic */ int inflateViewStub$default(RemoteViews remoteViews, TranslationContext translationContext, int i, int i2, Integer num, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            num = null;
        }
        return inflateViewStub(remoteViews, translationContext, i, i2, num);
    }

    public static final float pixelsToDp(int i, float f) {
        return C2256Dp.m20968constructorimpl(i / f);
    }

    public static final void setViewEnabled(@NotNull RemoteViews remoteViews, int i, boolean z) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        remoteViews.setBoolean(i, "setEnabled", z);
    }

    /* JADX INFO: renamed from: toPixels-D5KLDUw, reason: not valid java name */
    public static final int m21327toPixelsD5KLDUw(float f, float f4) {
        return (int) (f * f4);
    }

    /* JADX INFO: renamed from: toPixels-D5KLDUw, reason: not valid java name */
    public static final int m21328toPixelsD5KLDUw(float f, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return m21327toPixelsD5KLDUw(f, context.getResources().getDisplayMetrics().density);
    }
}
