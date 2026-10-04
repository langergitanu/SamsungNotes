package com.samsung.android.support.senl.addons.brush.binding.adapter;

import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.utils.TabletUtil;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.IBrushMenuInfo;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/adapter/BAZoomMenuPosition;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "setZoomMenuPosition", "", "view", "Landroid/view/View;", "info", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/IBrushMenuInfo;", "setZoomTextPosition", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BAZoomMenuPosition {

    @NotNull
    public static final BAZoomMenuPosition INSTANCE = new BAZoomMenuPosition();

    @NotNull
    private static final String TAG = Logger.createBrushTag("BAZoomMenuPosition");

    private BAZoomMenuPosition() {
    }

    public final void setZoomMenuPosition(@NotNull View view, @Nullable IBrushMenuInfo info) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (info == null) {
            return;
        }
        Rect penRect = info.getPenRect();
        Rect colorRect = info.getColorRect();
        if (penRect.width() == 0 || penRect.height() == 0 || colorRect.width() == 0 || colorRect.height() == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(C7944R.dimen.brush_toolbar_zoom_btn_menu_margin);
        if (!TabletUtil.isTabletUi()) {
            if (marginLayoutParams.getMarginEnd() != dimensionPixelSize) {
                marginLayoutParams.setMarginEnd(dimensionPixelSize);
                view.requestLayout();
                return;
            }
            return;
        }
        int y2 = (int) view.getY();
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        int width = ((View) parent).getWidth() - dimensionPixelSize;
        Rect rect = new Rect(width - view.getWidth(), y2, width, view.getHeight() + y2);
        boolean z = penRect.intersects(rect.left, rect.top, rect.right, rect.bottom) || colorRect.intersects(rect.left, rect.top, rect.right, rect.bottom);
        int iHeight = colorRect.width() > colorRect.height() ? colorRect.height() : colorRect.width();
        if (z) {
            Logger.m7100d(TAG, "updateZoomMenuPosition. Overlapped menu.");
            marginLayoutParams.setMarginEnd(iHeight + dimensionPixelSize);
            view.requestLayout();
        } else if (marginLayoutParams.getMarginEnd() != dimensionPixelSize) {
            marginLayoutParams.setMarginEnd(dimensionPixelSize);
            view.requestLayout();
        }
    }

    public final void setZoomTextPosition(@NotNull View view, @Nullable IBrushMenuInfo info) {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        Intrinsics.checkNotNullParameter(view, "view");
        if (info == null) {
            return;
        }
        Rect penRect = info.getPenRect();
        Rect colorRect = info.getColorRect();
        if (penRect.width() == 0 || penRect.height() == 0 || colorRect.width() == 0 || colorRect.height() == 0) {
            return;
        }
        float f = view.getContext().getResources().getDisplayMetrics().densityDpi / view.getContext().getApplicationContext().getResources().getDisplayMetrics().densityDpi;
        if (TabletUtil.isTabletUi()) {
            dimensionPixelSize = (int) (view.getResources().getDimensionPixelSize(C7944R.dimen.base_zoom_percentage_view_margin_end_tablet) * f);
            dimensionPixelSize2 = view.getResources().getDimensionPixelSize(C7944R.dimen.base_zoom_percentage_view_margin_top_tablet);
        } else {
            dimensionPixelSize = (int) (view.getResources().getDimensionPixelSize(C7944R.dimen.base_zoom_percentage_view_margin_end) * f);
            dimensionPixelSize2 = view.getResources().getDimensionPixelSize(C7944R.dimen.base_zoom_percentage_view_margin_top);
        }
        int i = (int) (dimensionPixelSize2 * f);
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        int width = ((View) parent).getWidth();
        Paint paint = new Paint();
        TextView textView = (TextView) view;
        paint.setTextSize(textView.getTextSize());
        paint.setTypeface(textView.getTypeface());
        int paddingRight = textView.getPaddingRight() + textView.getPaddingLeft() + ((int) paint.measureText(textView.getText().toString()));
        int height = textView.getHeight();
        boolean z = false;
        if (height == 0) {
            view.measure(0, 0);
            height = textView.getMeasuredHeight();
        }
        Rect rect = new Rect();
        if (textView.getResources().getConfiguration().getLayoutDirection() == 0) {
            rect.set((width - paddingRight) - dimensionPixelSize, i, width - dimensionPixelSize, height + i);
        } else {
            rect.set(paddingRight - dimensionPixelSize, i, dimensionPixelSize, height + i);
        }
        boolean z2 = true;
        boolean z3 = penRect.intersects(rect.left, rect.top, rect.right, rect.bottom) || colorRect.intersects(rect.left, rect.top, rect.right, rect.bottom);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int iHeight = colorRect.width() > colorRect.height() ? colorRect.height() : colorRect.width();
        if (!z3) {
            Logger.m7100d(TAG, "updateZoomTextPosition. Not overlapped menu.");
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                z = true;
            }
            if (marginLayoutParams.getMarginEnd() != dimensionPixelSize) {
                marginLayoutParams.setMarginEnd(dimensionPixelSize);
                z = true;
            }
            if (textView.getTop() == rect.top && textView.getBottom() == rect.bottom && textView.getLeft() == rect.left && textView.getRight() == rect.right) {
                z2 = z;
            }
            if (z2) {
                view.requestLayout();
                return;
            }
            return;
        }
        if (!penRect.intersects(rect.left, rect.top + iHeight, rect.right, rect.bottom) && !colorRect.intersects(rect.left, rect.top + iHeight, rect.right, rect.bottom)) {
            marginLayoutParams.topMargin = i + iHeight;
            view.requestLayout();
            Logger.m7100d(TAG, "updateZoomTextPosition. Overlapped menu 1.");
        } else if (!penRect.intersects(rect.left - iHeight, rect.top, rect.right - iHeight, rect.bottom) && !colorRect.intersects(rect.left - iHeight, rect.top, rect.right - iHeight, rect.bottom)) {
            marginLayoutParams.setMarginEnd(dimensionPixelSize + iHeight);
            view.requestLayout();
            Logger.m7100d(TAG, "updateZoomTextPosition. Overlapped menu 2.");
        } else {
            marginLayoutParams.topMargin = i + iHeight;
            marginLayoutParams.setMarginEnd(dimensionPixelSize + iHeight);
            view.requestLayout();
            Logger.m7100d(TAG, "updateZoomTextPosition. Overlapped menu 3.");
        }
    }
}
