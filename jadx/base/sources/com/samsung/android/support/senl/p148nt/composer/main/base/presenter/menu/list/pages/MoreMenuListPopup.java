package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ListPopupWindow;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.ViewUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageListContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MoreMenuListPopup {
    static final int ADD = 0;
    static final int COPY = 1;
    static final int CUT = 2;
    static final int DELETE = 4;
    static final int ERASE_PAGE = 5;
    public static final int EXPORT = 7;
    static final int PASTE = 3;
    private static final boolean Q_OS_OVER;
    public static final int SHARE = 6;
    private static final String TAG = Logger.createTag("MoreMenuListPopup");
    private int mLastIndex;
    private List<Integer> mLastMenuList;
    private PageListContract.IView mLastPageListView;
    private View mLastTargetView;
    private ListPopupWindow mListPopupWindow;
    private String mMappedPageId;
    private HashMap<Integer, String> mMenuMap;
    private boolean mNeedToUpdate;
    private OnMoreMenuEventListener mOnMoreMenuEventListener;
    private PopupWindow.OnDismissListener mDismissListener = new OnDismissListenerImpl(this, 0);
    private View.OnLayoutChangeListener mOnTargetViewLayoutChangeListenerImpl = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.MoreMenuListPopup.1
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
            if (MoreMenuListPopup.this.isShowing() && MoreMenuListPopup.this.mNeedToUpdate) {
                MoreMenuListPopup moreMenuListPopup = MoreMenuListPopup.this;
                moreMenuListPopup.show(moreMenuListPopup.mLastTargetView, MoreMenuListPopup.this.mMappedPageId, MoreMenuListPopup.this.mLastIndex, MoreMenuListPopup.this.mLastMenuList, MoreMenuListPopup.this.mLastPageListView);
                MoreMenuListPopup.this.mNeedToUpdate = false;
            }
        }
    };
    private View.OnLayoutChangeListener mOnContainerLayoutChangeListenerImpl = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.MoreMenuListPopup.2
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
            if (!MoreMenuListPopup.this.isShowing() || i4 - i == i8 - i6) {
                return;
            }
            MoreMenuListPopup.this.mNeedToUpdate = true;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OnDismissListenerImpl implements PopupWindow.OnDismissListener {
        public /* synthetic */ OnDismissListenerImpl(MoreMenuListPopup moreMenuListPopup, int i) {
            this();
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (MoreMenuListPopup.this.mOnMoreMenuEventListener != null) {
                MoreMenuListPopup.this.mOnMoreMenuEventListener.onDismiss();
            }
            if (MoreMenuListPopup.this.mLastTargetView != null) {
                MoreMenuListPopup.this.mLastTargetView.removeOnLayoutChangeListener(MoreMenuListPopup.this.mOnTargetViewLayoutChangeListenerImpl);
                MoreMenuListPopup.this.mLastPageListView.getView().removeOnLayoutChangeListener(MoreMenuListPopup.this.mOnContainerLayoutChangeListenerImpl);
            }
            MoreMenuListPopup.this.setLastCallArguments(null, null, -1, null, null);
        }

        private OnDismissListenerImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnMoreMenuEventListener {
        void clearSelection();

        void onAdd(String str);

        void onCopy(Context context, String str);

        void onCut(Context context, String str);

        void onDelete(Context context, String str);

        void onDismiss();

        void onErasePage(Context context, String str);

        void onExport(Context context, String str, View view);

        void onPaste(Context context, String str);

        void onShare(Context context, String str, View view);
    }

    static {
        Q_OS_OVER = Build.VERSION.SDK_INT > 29;
    }

    public MoreMenuListPopup(OnMoreMenuEventListener onMoreMenuEventListener) {
        this.mOnMoreMenuEventListener = onMoreMenuEventListener;
    }

    private void initMenuNames(Resources resources) {
        HashMap<Integer, String> map = this.mMenuMap;
        if (map == null || !Objects.equals(map.get(0), resources.getString(C9086R.string.composer_ctx_menu_add_page))) {
            HashMap<Integer, String> map2 = new HashMap<>(8);
            this.mMenuMap = map2;
            map2.put(0, resources.getString(C9086R.string.composer_ctx_menu_add_page));
            this.mMenuMap.put(1, resources.getString(C9086R.string.composer_ctx_menu_copy));
            this.mMenuMap.put(2, resources.getString(C9086R.string.composer_ctx_menu_cut));
            this.mMenuMap.put(3, resources.getString(C9086R.string.composer_ctx_menu_paste));
            this.mMenuMap.put(4, resources.getString(C9086R.string.composer_ctx_menu_delete));
            this.mMenuMap.put(5, resources.getString(C9086R.string.composer_ctx_menu_erase_page));
            this.mMenuMap.put(6, resources.getString(C9086R.string.composer_ctx_menu_share));
            this.mMenuMap.put(7, resources.getString(C9086R.string.save_as));
        }
    }

    private int measureContentWidth(Context context, ArrayAdapter<String> arrayAdapter) {
        return ViewUtil.measureContentWidth(context, arrayAdapter, DeviceInfo.isVSTModel() ? context.getResources().getDimensionPixelSize(C9086R.dimen.popup_menu_side_margin) * 2 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastCallArguments(View view, String str, int i, List<Integer> list, PageListContract.IView iView) {
        this.mLastTargetView = view;
        this.mMappedPageId = str;
        this.mLastIndex = i;
        this.mLastMenuList = list;
        this.mLastPageListView = iView;
    }

    public void clear() {
        dismiss();
        this.mMenuMap = null;
    }

    public void dismiss() {
        if (isShowing()) {
            this.mListPopupWindow.dismiss();
            this.mListPopupWindow = null;
        }
        this.mMappedPageId = null;
    }

    public boolean isSamePage(String str) {
        return this.mMappedPageId.equals(str);
    }

    public boolean isShowing() {
        ListPopupWindow listPopupWindow = this.mListPopupWindow;
        return listPopupWindow != null && listPopupWindow.isShowing();
    }

    public void show(final View view, final String str, int i, List<Integer> list, PageListContract.IView iView) {
        ListPopupWindow listPopupWindow = this.mListPopupWindow;
        if (listPopupWindow != null) {
            listPopupWindow.dismiss();
            this.mListPopupWindow = null;
        }
        initMenuNames(view.getResources());
        this.mListPopupWindow = new ListPopupWindow(view.getContext());
        final String[] strArr = new String[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            strArr[i2] = this.mMenuMap.get(list.get(i2));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(view.getContext(), C9086R.layout.comp_page_list_item_more_menu_item, strArr) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.MoreMenuListPopup.3
            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            @NonNull
            public View getView(int i4, @Nullable View view2, @NonNull ViewGroup viewGroup) {
                if (view2 == null) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_page_list_item_more_menu_item, (ViewGroup) null);
                }
                ((TextView) view2.findViewById(C9086R.id.comp_page_list_item_more_menu_title)).setText((CharSequence) getItem(i4));
                return view2;
            }
        };
        int iMeasureContentWidth = measureContentWidth(view.getContext(), arrayAdapter);
        int spanCount = iView.getSpanCount();
        this.mListPopupWindow.setHorizontalOffset(-(i % spanCount == spanCount - 1 ? iMeasureContentWidth - view.getWidth() : (view.getResources().getDimensionPixelSize(C9086R.dimen.comp_page_list_item_width) / 2) - view.getWidth()));
        this.mListPopupWindow.setAdapter(arrayAdapter);
        this.mListPopupWindow.setAnchorView(view);
        this.mListPopupWindow.setOverlapAnchor(true);
        this.mListPopupWindow.setModal(true);
        this.mListPopupWindow.setWidth(iMeasureContentWidth);
        this.mListPopupWindow.setInputMethodMode(2);
        this.mListPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.MoreMenuListPopup.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i4, long j) {
                MoreMenuListPopup.this.mOnMoreMenuEventListener.clearSelection();
                MoreMenuListPopup.this.mListPopupWindow.dismiss();
                if (i4 < strArr.length) {
                    String str2 = (String) adapterView.getItemAtPosition(i4);
                    AbstractC8014b.m7196B("onItemClick# ", str2, MoreMenuListPopup.TAG);
                    if (str2.equals(MoreMenuListPopup.this.mMenuMap.get(0))) {
                        MoreMenuListPopup.this.mOnMoreMenuEventListener.onAdd(str);
                        return;
                    }
                    if (str2.equals(MoreMenuListPopup.this.mMenuMap.get(1))) {
                        MoreMenuListPopup.this.mOnMoreMenuEventListener.onCopy(view2.getContext(), str);
                        return;
                    }
                    if (str2.equals(MoreMenuListPopup.this.mMenuMap.get(2))) {
                        MoreMenuListPopup.this.mOnMoreMenuEventListener.onCut(view2.getContext(), str);
                        return;
                    }
                    if (str2.equals(MoreMenuListPopup.this.mMenuMap.get(3))) {
                        MoreMenuListPopup.this.mOnMoreMenuEventListener.onPaste(view2.getContext(), str);
                        return;
                    }
                    if (str2.equals(MoreMenuListPopup.this.mMenuMap.get(4))) {
                        MoreMenuListPopup.this.mOnMoreMenuEventListener.onDelete(view2.getContext(), str);
                        return;
                    }
                    if (str2.equals(MoreMenuListPopup.this.mMenuMap.get(5))) {
                        MoreMenuListPopup.this.mOnMoreMenuEventListener.onErasePage(view2.getContext(), str);
                    } else if (str2.equals(MoreMenuListPopup.this.mMenuMap.get(6))) {
                        MoreMenuListPopup.this.mOnMoreMenuEventListener.onShare(view2.getContext(), str, view);
                    } else if (str2.equals(MoreMenuListPopup.this.mMenuMap.get(7))) {
                        MoreMenuListPopup.this.mOnMoreMenuEventListener.onExport(view2.getContext(), str, view);
                    }
                }
            }
        });
        setLastCallArguments(view, str, i, list, iView);
        this.mListPopupWindow.setOnDismissListener(this.mDismissListener);
        if (Q_OS_OVER) {
            iView.getView().addOnLayoutChangeListener(this.mOnContainerLayoutChangeListenerImpl);
            view.addOnLayoutChangeListener(this.mOnTargetViewLayoutChangeListenerImpl);
        }
        this.mListPopupWindow.show();
    }
}
