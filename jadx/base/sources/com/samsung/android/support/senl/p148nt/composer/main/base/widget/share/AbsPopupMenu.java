package com.samsung.android.support.senl.p148nt.composer.main.base.widget.share;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.samsung.android.support.senl.p148nt.base.common.WindowInsetsManager;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsPopupMenu {
    private View mAnchorView;
    protected PopupWindow.OnDismissListener mOnDismissListener;
    protected OnItemClickListener mOnItemClickListener;
    protected PopupWindow mPopupMenu;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnItemClickListener {
        void onItemClick();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PopupWindowMenuAdapter extends RecyclerView.Adapter<PopupWindowMenuHolder> {
        ArrayList<String> mItemArray;
        View.OnClickListener mOnClickListener;

        public PopupWindowMenuAdapter(ArrayList<String> arrayList, View.OnClickListener onClickListener) {
            this.mItemArray = arrayList;
            this.mOnClickListener = onClickListener;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            ArrayList<String> arrayList = this.mItemArray;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull PopupWindowMenuHolder popupWindowMenuHolder, int i) {
            ((TextView) popupWindowMenuHolder.itemView.findViewById(C9086R.id.item_text)).setText(this.mItemArray.get(i));
            popupWindowMenuHolder.itemView.setTag(Integer.valueOf(i));
            popupWindowMenuHolder.itemView.setOnClickListener(this.mOnClickListener);
            if (i == this.mItemArray.size() - 1) {
                popupWindowMenuHolder.itemView.setBackgroundResource(C9086R.drawable.comp_ripple_effect_bottom);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public PopupWindowMenuHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new PopupWindowMenuHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_title_list_popup_window_item, viewGroup, false));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PopupWindowMenuHolder extends RecyclerView.ViewHolder {
        public PopupWindowMenuHolder(View view) {
            super(view);
        }
    }

    private int getBottomInsets() {
        WindowInsetsCompat windowInsets = WindowInsetsManager.getInstance().getWindowInsets();
        return Math.max(windowInsets.getInsets(WindowInsetsCompat.Type.displayCutout()).bottom, windowInsets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom);
    }

    private void initPopupMenu(Activity activity, String str, ArrayList<String> arrayList) {
        View viewInflate = View.inflate(activity, C9086R.layout.comp_title_list_popup_window_layout, null);
        initPopupMenuTitle(viewInflate, str);
        BackgroundColorUtil.setBlurInfoPopup(activity, viewInflate);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(C9086R.id.popup_menu_recycler_view);
        recyclerView.setAdapter(new PopupWindowMenuAdapter(arrayList, getOnClickListener()));
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        this.mPopupMenu = popupWindow;
        PopupWindowHelper.setDefaultState(popupWindow, activity);
    }

    private void initPopupMenuTitle(View view, String str) {
        TextView textView = (TextView) view.findViewById(C9086R.id.text_menu_title);
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
            textView.setVisibility(0);
        }
    }

    @SuppressLint({"RestrictedApi"})
    private void showPopupMenuAtLocation(View view) {
        PopupWindow popupWindow = this.mPopupMenu;
        if (popupWindow == null) {
            return;
        }
        PopupWindow.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            popupWindow.setOnDismissListener(onDismissListener);
        }
        this.mAnchorView = view;
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        if (!(view.getParent() instanceof BottomNavigationMenuView)) {
            PopupWindow popupWindow2 = this.mPopupMenu;
            popupWindow2.showAtLocation(view, 0, iArr[0], iArr[1] - popupWindow2.getHeight());
        } else {
            this.mPopupMenu.showAtLocation(view, 8388691, iArr[0], this.mAnchorView.getContext().getResources().getDimensionPixelSize(C9086R.dimen.bottom_popup_menu_y_location_offset) + this.mAnchorView.getHeight() + getBottomInsets());
        }
    }

    public abstract ArrayList<String> getMenuItems();

    public abstract View.OnClickListener getOnClickListener();

    public abstract String getTag();

    public void hidePopupMenu() {
        Logger.m11003i(getTag(), "hidePopupMenu#");
        if (isShowingPopupMenu()) {
            this.mPopupMenu.dismiss();
        }
    }

    public abstract void initShareTypeItems(Activity activity);

    public boolean isShowingPopupMenu() {
        PopupWindow popupWindow = this.mPopupMenu;
        return popupWindow != null && popupWindow.isShowing();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void showPopupMenu(Activity activity, View view, String str) {
        if (CommonUtil.isNotAvailableActivity(activity)) {
            Logger.m11000e(getTag(), "showPopupMenu# isDestroyed");
            return;
        }
        if (isShowingPopupMenu()) {
            Logger.m11000e(getTag(), "showPopupMenu# isShowing()");
            this.mPopupMenu.dismiss();
        }
        if (view == null) {
            Logger.m11000e(getTag(), "showPopupMenu# anchorView is null");
            return;
        }
        Logger.m11003i(getTag(), "showPopupMenu#");
        initShareTypeItems(activity);
        initPopupMenu(activity, str, getMenuItems());
        showPopupMenuAtLocation(view);
    }

    public void updatePopupMenu(@Nullable View view) {
        if (!isShowingPopupMenu()) {
            Logger.m11000e(getTag(), "updatePopupMenu# popup menu is not showing");
            return;
        }
        PopupWindow popupWindow = this.mPopupMenu;
        if (popupWindow != null) {
            popupWindow.setOnDismissListener(null);
            this.mPopupMenu.dismiss();
        }
        if (view != null) {
            View view2 = this.mAnchorView;
            if (view2 == null || view2.hashCode() == view.hashCode()) {
                Logger.m10999d(getTag(), "updatePopupMenu#");
                showPopupMenuAtLocation(view);
            }
        }
    }
}
