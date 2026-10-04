package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ViewUtil {
    public static int getDefaultTintColor(Resources resources) {
        return resources.getColor(C9086R.color.composer_default_button_color, null);
    }

    public static int measureContentWidth(Activity activity, ArrayAdapter arrayAdapter, ListView listView) {
        return measureContentWidth(activity, arrayAdapter, listView, 0);
    }

    public static int measureContentWidth(Activity activity, ArrayAdapter arrayAdapter, ListView listView, int i) {
        if (listView == null) {
            listView = new ListView(activity);
        }
        int width = activity.getWindow().getDecorView().getWidth();
        if (width <= 0) {
            width = activity.getResources().getDisplayMetrics().widthPixels;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = arrayAdapter.getCount();
        activity.getResources().getValue(C9086R.dimen.memo_list_category_spinner_list_popup_max_width_ratio, new TypedValue(), true);
        View view = null;
        int i2 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < count; i5++) {
            int itemViewType = arrayAdapter.getItemViewType(i5);
            if (itemViewType != i4) {
                view = null;
                i4 = itemViewType;
            }
            view = arrayAdapter.getView(i5, view, listView);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth() + i;
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
            if (i2 > width) {
                return width;
            }
        }
        return i2;
    }

    public static int measureContentWidth(View view) {
        if (view == null) {
            return 0;
        }
        view.measure(0, 0);
        return view.getMeasuredWidth();
    }

    public static int measureContentWidth(Context context, ArrayAdapter arrayAdapter) {
        return measureContentWidth(context, arrayAdapter, 0);
    }

    public static int measureContentWidth(Context context, ArrayAdapter arrayAdapter, int i) {
        FrameLayout frameLayout = new FrameLayout(context);
        View view = null;
        int i2 = 0;
        for (int i4 = 0; i4 < arrayAdapter.getCount(); i4++) {
            view = arrayAdapter.getView(i4, view, frameLayout);
            view.measure(0, 0);
            int measuredWidth = view.getMeasuredWidth() + i;
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }
}
