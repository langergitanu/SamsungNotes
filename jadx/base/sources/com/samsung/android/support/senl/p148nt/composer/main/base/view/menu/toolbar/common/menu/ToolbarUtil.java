package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import com.samsung.android.sdk.pen.setting.colorpalette.OnSelectItemEventListener;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ToolbarUtil {
    private static final String TAG = Logger.createTag("ToolbarUtil");

    public static void adjustToolbarItemLayoutForVST(View view, ViewGroup viewGroup) {
        if (view == null || viewGroup == null) {
            Logger.m10999d(TAG, "adjustToolbarItemLayoutForVST# container or itemListContainer is null");
            return;
        }
        int childCount = viewGroup.getChildCount();
        int height = view.getHeight();
        int iConvertDpToPixel = (int) ResourceUtils.convertDpToPixel(view.getContext(), 628.0f);
        if (height < iConvertDpToPixel) {
            height = iConvertDpToPixel;
        }
        float f = height;
        float f4 = 0.065f * f;
        float dimensionPixelSize = ((f - (2.0f * f4)) - (view.getResources().getDimensionPixelSize(C9086R.dimen.comp_hw_floating_menu_item_ripple_size_for_vst) * (childCount + 1))) / childCount;
        if (dimensionPixelSize < 0.0f) {
            dimensionPixelSize = 0.0f;
        }
        boolean z = true;
        for (int i = 0; i < childCount - 1; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                int i2 = (int) dimensionPixelSize;
                layoutParams.bottomMargin = i2;
                if (z) {
                    layoutParams.topMargin = i2;
                    z = false;
                }
                childAt.setLayoutParams(layoutParams);
            }
        }
        int i4 = (int) f4;
        view.setPadding(0, i4, 0, i4);
    }

    public static int convertDipToPixels(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static Point getBasicOffset(View view, View view2, Point point, boolean z) {
        int measuredWidth = 0;
        view2.measure(0, 0);
        Point point2 = new Point(0, 0);
        int width = ((View) view.getParent()).getWidth();
        int i = point.x;
        if (z) {
            point2.x = (i - (view2.getMeasuredWidth() / 2)) - ((int) view.getX());
            if (LocaleUtils.isRTLMode()) {
                measuredWidth = view.getMeasuredWidth();
            }
        } else {
            point2.x = ((width / 2) - (view2.getMeasuredWidth() / 2)) - ((int) view.getX());
            if (LocaleUtils.isRTLMode()) {
                measuredWidth = width;
            }
        }
        int measuredWidth2 = view2.getMeasuredWidth() + point2.x + ((int) view.getX());
        if (measuredWidth2 > width) {
            point2.x -= measuredWidth2 - width;
        } else if (width < view2.getMeasuredWidth()) {
            point2.x = (int) view.getX();
        }
        point2.x -= measuredWidth;
        AbstractC8014b.m7195A(new StringBuilder("x offset : "), TAG, point2.x);
        return point2;
    }

    public static OnSelectItemEventListener getColorSetRestrictToastListener(final Context context, final int i) {
        return new OnSelectItemEventListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ToolbarUtil.1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnSelectItemEventListener
            public void onSelectItemChanged(int i2, boolean z) {
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnSelectItemEventListener
            public void onSelectItemUnchanged(int i2, OnSelectItemEventListener.UnchangedReason unchangedReason) {
                if (!OnSelectItemEventListener.UnchangedReason.MAX_VALUE_LIMIT.equals(unchangedReason)) {
                    if (OnSelectItemEventListener.UnchangedReason.MIN_VALUE_LIMIT.equals(unchangedReason)) {
                        ToastHandler.show(context, C8875R.string.colorset_toast_min_restriction, 0);
                    }
                } else {
                    Resources resources = context.getResources();
                    int i4 = C8875R.plurals.colorset_toast_max_restriction;
                    int i5 = i;
                    ToastHandler.show(context, resources.getQuantityString(i4, i5, Integer.valueOf(i5)), 0);
                }
            }
        };
    }

    public static int[] getHorizonOnScreen(View view, int i) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[0] + i;
        int[] iArr2 = {i2, (view.getWidth() / 2) + i2, view.getWidth() + i};
        int i4 = iArr2[0];
        return iArr2;
    }

    public static Rect getIntersect(Rect rect, Rect rect2) {
        return new Rect(Math.max(0, Math.max(rect.left, rect2.left)), Math.max(0, Math.max(rect.top, rect2.top)), Math.max(0, Math.min(rect.right, rect2.right)), Math.max(0, Math.min(rect.bottom, rect2.bottom)));
    }

    public static Point getOffset(Activity activity, View view, View view2) {
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(C9086R.dimen.comp_actionbar_height);
        Point point = new Point();
        int[] iArr = new int[2];
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        int i = iArr[1];
        rect.top = i;
        rect.bottom = view.getHeight() + i;
        view2.measure(0, 0);
        int width = (view.getWidth() - view2.getMeasuredWidth()) / 2;
        point.x = width;
        if (width < 0) {
            point.x = 0;
        }
        int i2 = displayMetrics.widthPixels;
        int i4 = displayMetrics.heightPixels;
        if (i2 <= i4 || rect.bottom == i4 || ((i4 - (i4 - rect.top)) - dimensionPixelSize) - convertDipToPixels(activity, 12.0f) >= view2.getMeasuredHeight()) {
            point.y = (convertDipToPixels(activity, 12.0f) + view2.getMeasuredHeight() + view.getHeight()) * (-1);
        } else {
            point.y = ((view2.getMeasuredHeight() / 2) + view.getHeight()) * (-1);
        }
        if (WindowManagerCompat.getInstance().isMultiWindowMode(activity)) {
            if (activity.getWindow().getDecorView().getHeight() < view2.getMeasuredHeight()) {
                point.y = view2.getMeasuredHeight() * (-1);
            } else {
                point.y = (convertDipToPixels(activity, 12.0f) + view2.getMeasuredHeight() + view.getHeight()) * (-1);
            }
        }
        String str = TAG;
        Logger.m10999d(str, "x offset : " + point.x);
        AbstractC8014b.m7221w(new StringBuilder("y offset : "), str, point.y);
        return point;
    }

    private static Point getVSTOffset(View view, View view2, Point point, boolean z) {
        view2.measure(0, 0);
        int i = point.x;
        int i2 = point.y;
        Point point2 = new Point(0, 0);
        if (LocaleUtils.isRTLMode()) {
            point2.x = 0;
        } else {
            point2.x = -view2.getMeasuredWidth();
        }
        point2.y = i2 - ((int) view.getY());
        Logger.m11003i(TAG, "getVSTOffset# offset : " + point2);
        return point2;
    }

    public static Point getViewCenterPosition(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return new Point((view.getWidth() / 2) + iArr[0], (view.getHeight() / 2) + iArr[1]);
    }

    public static boolean isOutOfWindow(View view, View view2, Point point) {
        view2.measure(0, 0);
        boolean z = view2.getMeasuredWidth() + (new Point(point.x, point.y).x + ((int) view.getX())) > ((View) view.getParent()).getWidth();
        AbstractC8014b.m7224z("isOutOfWindow: ", TAG, z);
        return z;
    }

    public static void setBgRippleToolbar(View view) {
        if (view == null) {
            return;
        }
        int i = C9086R.drawable.editor_hw_toolbar_pressed;
        int i2 = C9086R.drawable.editor_hw_toolbar_selected;
        if (!ContextUtils.isNightMode(view.getContext()) && !DesktopModeCompat.INSTANCE.getInstance().isNotDexModeOrStandAloneMode(view.getContext())) {
            i2 = C9086R.drawable.editor_hw_toolbar_selected_dex;
        } else if (SettingsCompat.getInstance().isHighTextContrastEnabled(view.getContext())) {
            i2 = C9086R.drawable.editor_hw_toolbar_selected_high_contrast;
        }
        if (DeviceInfo.isVSTModel()) {
            i = C9086R.drawable.editor_hw_toolbar_pressed_vst;
            i2 = C9086R.drawable.editor_hw_toolbar_selected_vst;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_selected}, ResourcesCompat.getDrawable(view.getResources(), i2, view.getContext().getTheme()));
        stateListDrawable.addState(new int[]{R.attr.state_enabled}, ResourcesCompat.getDrawable(view.getResources(), i, view.getContext().getTheme()));
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, ResourcesCompat.getDrawable(view.getResources(), i, view.getContext().getTheme()));
        stateListDrawable.addState(new int[]{R.attr.state_focused}, ResourcesCompat.getDrawable(view.getResources(), i2, view.getContext().getTheme()));
        view.setBackground(stateListDrawable);
    }

    public static void setTooltipText(View view, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT > 26) {
            ViewCompat.getInstance().setTooltipText(view, charSequence);
        }
    }

    public static Point getOffset(View view, View view2, Point point, boolean z) {
        if (DeviceInfo.isVSTModel()) {
            return getVSTOffset(view, view2, point, z);
        }
        return getBasicOffset(view, view2, point, z);
    }
}
