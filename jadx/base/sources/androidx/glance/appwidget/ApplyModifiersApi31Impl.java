package androidx.glance.appwidget;

import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.widget.RemoteViewsCompat;
import androidx.glance.unit.Dimension;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(31)
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nH\u0007J \u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0007¨\u0006\u000f"}, m13886d2 = {"Landroidx/glance/appwidget/ApplyModifiersApi31Impl;", "", "()V", "applyRoundedCorners", "", "rv", "Landroid/widget/RemoteViews;", "viewId", "", "radius", "Landroidx/glance/unit/Dimension;", "setViewHeight", "height", "setViewWidth", "width", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nApplyModifiers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ApplyModifiers.kt\nandroidx/glance/appwidget/ApplyModifiersApi31Impl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,830:1\n1#2:831\n*E\n"})
final class ApplyModifiersApi31Impl {

    @NotNull
    public static final ApplyModifiersApi31Impl INSTANCE = new ApplyModifiersApi31Impl();

    private ApplyModifiersApi31Impl() {
    }

    @DoNotInline
    public final void applyRoundedCorners(@NotNull RemoteViews rv, int viewId, @NotNull Dimension radius) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(radius, "radius");
        RemoteViewsCompat.setViewClipToOutline(rv, viewId, true);
        if (radius instanceof Dimension.C3532Dp) {
            rv.setViewOutlinePreferredRadius(viewId, ((Dimension.C3532Dp) radius).getDp(), 1);
        } else {
            if (radius instanceof Dimension.Resource) {
                rv.setViewOutlinePreferredRadiusDimen(viewId, ((Dimension.Resource) radius).getRes());
                return;
            }
            throw new IllegalStateException(("Rounded corners should not be " + radius.getClass().getCanonicalName()).toString());
        }
    }

    @DoNotInline
    public final void setViewHeight(@NotNull RemoteViews rv, int viewId, @NotNull Dimension height) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(height, "height");
        if (height instanceof Dimension.Wrap) {
            rv.setViewLayoutHeight(viewId, -2.0f, 0);
        } else if (height instanceof Dimension.Expand) {
            rv.setViewLayoutHeight(viewId, 0.0f, 0);
        } else if (height instanceof Dimension.C3532Dp) {
            rv.setViewLayoutHeight(viewId, ((Dimension.C3532Dp) height).getDp(), 1);
        } else if (height instanceof Dimension.Resource) {
            rv.setViewLayoutHeightDimen(viewId, ((Dimension.Resource) height).getRes());
        } else {
            if (!Intrinsics.areEqual(height, Dimension.Fill.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            rv.setViewLayoutHeight(viewId, -1.0f, 0);
        }
        Unit unit = Unit.INSTANCE;
    }

    @DoNotInline
    public final void setViewWidth(@NotNull RemoteViews rv, int viewId, @NotNull Dimension width) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(width, "width");
        if (width instanceof Dimension.Wrap) {
            rv.setViewLayoutWidth(viewId, -2.0f, 0);
        } else if (width instanceof Dimension.Expand) {
            rv.setViewLayoutWidth(viewId, 0.0f, 0);
        } else if (width instanceof Dimension.C3532Dp) {
            rv.setViewLayoutWidth(viewId, ((Dimension.C3532Dp) width).getDp(), 1);
        } else if (width instanceof Dimension.Resource) {
            rv.setViewLayoutWidthDimen(viewId, ((Dimension.Resource) width).getRes());
        } else {
            if (!Intrinsics.areEqual(width, Dimension.Fill.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            rv.setViewLayoutWidth(viewId, -1.0f, 0);
        }
        Unit unit = Unit.INSTANCE;
    }
}
