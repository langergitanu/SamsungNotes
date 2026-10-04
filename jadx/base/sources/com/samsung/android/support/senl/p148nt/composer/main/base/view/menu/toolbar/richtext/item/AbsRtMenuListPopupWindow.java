package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListPopupWindow;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.ViewUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.util.CustomAccessibilityDelegate;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
abstract class AbsRtMenuListPopupWindow<T> extends AbsRtMenuPopup {
    private static final int DEFAULT_DELAY = 300;
    private static final String TAG = Logger.createTag("AbsRtMenuListPopupWindow");
    Activity mActivity;
    ArrayAdapter mArrayAdapter;
    ListPopupWindow mListPopupWindow;
    private final Runnable mShowPopupRunnable;

    public AbsRtMenuListPopupWindow(Activity activity, View view, View view2) {
        super(view, view2);
        this.mActivity = activity;
        this.mShowPopupRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuListPopupWindow.1
            @Override // java.lang.Runnable
            public void run() {
                AbsRtMenuListPopupWindow.this.showPopup();
            }
        };
        this.mContainer.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuListPopupWindow.2
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view3, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                if (AbsRtMenuListPopupWindow.this.isPopupShowing() && AbsRtMenuListPopupWindow.this.isLayoutChanged(i, i2, i4, i5, i6, i7, i8, i9)) {
                    AbsRtMenuListPopupWindow.this.updatePopup();
                }
            }
        });
    }

    private void initPopup(int i, int i2) {
        this.mListPopupWindow.setAnchorView(this.mView);
        this.mListPopupWindow.setModal(true);
        this.mListPopupWindow.setDropDownGravity(8388611);
        this.mListPopupWindow.setWidth(i);
        if (i2 != 0) {
            this.mListPopupWindow.setHeight(i2);
        }
        this.mListPopupWindow.setInputMethodMode(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLayoutChanged(int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        return (i == i6 && i2 == i7 && i4 == i8 && i5 == i9) ? false : true;
    }

    public abstract ArrayAdapter<T> getArrayAdapter();

    public int getPopupWindowHeight() {
        return this.mContainer.getResources().getDimensionPixelSize(C9086R.dimen.composer_rich_text_menu_dropdown_list_popup_height);
    }

    public int getPopupWindowWidth() {
        return ViewUtil.measureContentWidth(this.mActivity, this.mArrayAdapter, this.mListPopupWindow.getListView());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public boolean hidePopup() {
        if (!isPopupShowing()) {
            this.mListPopupWindow = null;
            return false;
        }
        this.mListPopupWindow.dismiss();
        this.mListPopupWindow = null;
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void initAccessibilityDelegate() {
        Resources resources = this.mView.getResources();
        StringBuilder sb = new StringBuilder();
        AbstractC8014b.m7202d(resources, C9086R.string.rich_text_dropdown_list, sb, SQLKeyword.COMMA);
        sb.append((Object) this.mView.getContentDescription());
        this.mView.setAccessibilityDelegate(new CustomAccessibilityDelegate(this.mView.getContentDescription().toString(), sb.toString()));
    }

    public void initListPopupWindow(Context context) {
        this.mListPopupWindow = new ListPopupWindow(context);
        ArrayAdapter<T> arrayAdapter = getArrayAdapter();
        this.mArrayAdapter = arrayAdapter;
        this.mListPopupWindow.setAdapter(arrayAdapter);
        this.mListPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuListPopupWindow.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AbsRtMenuListPopupWindow.this.onItemClick(adapterView, view, i, j);
            }
        });
        initPopup(getPopupWindowWidth(), getPopupWindowHeight());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopup
    public boolean isPopupShowing() {
        ListPopupWindow listPopupWindow = this.mListPopupWindow;
        return listPopupWindow != null && listPopupWindow.isShowing();
    }

    public abstract void onItemClick(AdapterView<?> adapterView, View view, int i, long j);

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopup
    public void onUpdatePopup() {
        Logger.m11003i(getLogTag(), "it going to updated by onLayoutChange");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopup
    public void showPopup() {
        initListPopupWindow(this.mView.getContext());
        if (this.mActivity.getResources().getConfiguration().orientation == 2) {
            this.mListPopupWindow.setHorizontalOffset(this.mContainer.getResources().getDimensionPixelSize(C9086R.dimen.composer_rich_text_menu_start_end_padding_land) * (-1));
        } else {
            this.mListPopupWindow.setHorizontalOffset(this.mContainer.getResources().getDimensionPixelSize(C9086R.dimen.composer_rich_text_menu_start_end_padding) * (-1));
        }
        if (ViewAnchorUtil.Area.TOP.equals(ViewAnchorUtil.recommendDirection(this.mContainer))) {
            this.mListPopupWindow.setAnimationStyle(C9086R.style.RtPopupTopEnterExitAnimation);
            this.mListPopupWindow.setDropDownGravity(48);
        } else {
            this.mListPopupWindow.setAnimationStyle(C9086R.style.RtPopupBottomEnterExitAnimation);
            this.mListPopupWindow.setDropDownGravity(80);
        }
        try {
            this.mListPopupWindow.show();
        } catch (WindowManager.BadTokenException e) {
            Logger.m11000e(TAG, "showPopup : " + e.getMessage());
        }
    }

    public void updatePopup() {
        hidePopup();
        this.mView.removeCallbacks(this.mShowPopupRunnable);
        this.mView.postDelayed(this.mShowPopupRunnable, 300L);
    }
}
