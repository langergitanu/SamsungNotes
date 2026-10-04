package com.samsung.android.support.senl.p148nt.composer.main.base.widget.share;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.PopupWindow;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.ListPopupWindow;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.ViewUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PopupWindowHelper {
    private static int measureContentWidth(Activity activity, ListPopupWindow listPopupWindow, ArrayAdapter arrayAdapter) {
        return ViewUtil.measureContentWidth(activity, arrayAdapter, listPopupWindow.getListView(), activity.getResources().getDimensionPixelSize(C9086R.dimen.popup_menu_side_margin) * 2);
    }

    public static void setDefaultState(PopupWindow popupWindow, Context context) {
        setDefaultState(popupWindow, context, C9086R.drawable.popup_menu_background);
    }

    public static void updateContainerWidth(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        int measuredWidth = 0;
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0 && measuredWidth < childAt.getMeasuredWidth()) {
                measuredWidth = childAt.getMeasuredWidth();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt2 = viewGroup.getChildAt(i2);
            if (childAt2.getVisibility() == 0 && childAt2.getMeasuredWidth() < measuredWidth) {
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.width = measuredWidth;
                childAt2.setLayoutParams(layoutParams);
            }
        }
    }

    public static void setDefaultState(PopupWindow popupWindow, Context context, @DrawableRes int i) {
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setClippingEnabled(true);
        popupWindow.setFocusable(true);
        popupWindow.setInputMethodMode(2);
        popupWindow.setOverlapAnchor(true);
        popupWindow.setBackgroundDrawable(context.getDrawable(i));
        popupWindow.setElevation(12.0f);
        popupWindow.setAnimationStyle(C9086R.style.MorePopupEnterExitAnimation);
    }

    public static void setDefaultState(ListPopupWindow listPopupWindow, ArrayAdapter arrayAdapter, Activity activity) {
        listPopupWindow.setAdapter(arrayAdapter);
        listPopupWindow.setOverlapAnchor(true);
        listPopupWindow.setModal(true);
        listPopupWindow.setDropDownGravity(8388611);
        listPopupWindow.setBackgroundDrawable(activity.getDrawable(C9086R.drawable.popup_menu_background));
        listPopupWindow.setWidth(measureContentWidth(activity, listPopupWindow, arrayAdapter));
        listPopupWindow.setInputMethodMode(2);
        listPopupWindow.setAnimationStyle(C9086R.style.MorePopupEnterExitAnimation);
    }
}
