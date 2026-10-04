package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item;

import android.R;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.IdRes;
import androidx.core.content.ContextCompat;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.ToolbarUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
abstract class AbsRtMenuPopupWindow extends AbsRtMenuPopup {
    protected View mDialogContainer;
    protected PopupWindow mPopupWindow;

    public AbsRtMenuPopupWindow(View view, View view2) {
        super(view, view2);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public boolean hidePopup() {
        if (!isPopupShowing()) {
            this.mPopupWindow = null;
            return false;
        }
        this.mPopupWindow.dismiss();
        this.mPopupWindow = null;
        return true;
    }

    public abstract View inflateView(Context context);

    public abstract void initButtons(View view, SpanStates spanStates);

    public void initPopupWindow(Context context) {
        View viewInflateView = inflateView(context);
        this.mDialogContainer = viewInflateView;
        initButtons(viewInflateView, this.mPresenter.getLastRtState());
        this.mDialogContainer.measure(0, 0);
        PopupWindow popupWindow = new PopupWindow(this.mDialogContainer, -2, this.mDialogContainer.getMeasuredHeight());
        this.mPopupWindow = popupWindow;
        initPopupWindow(context, popupWindow);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopup
    public boolean isPopupShowing() {
        PopupWindow popupWindow = this.mPopupWindow;
        return popupWindow != null && popupWindow.isShowing();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopup
    public void onUpdatePopup() {
        Logger.m11003i(getLogTag(), "onUpdatePopup()");
        if (this.mPopupWindow == null || !isPopupShowing()) {
            return;
        }
        Point offset = ToolbarUtil.getOffset(this.mContainer, this.mDialogContainer, super.getViewCenterPosition(), this.mIsTabletLayout);
        this.mPopupWindow.update(this.mContainer, offset.x, offset.y, -1, -1);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopup
    public void showPopup() {
        initPopupWindow(this.mView.getContext());
        Point offset = ToolbarUtil.getOffset(this.mContainer, this.mDialogContainer, super.getViewCenterPosition(), this.mIsTabletLayout);
        this.mPopupWindow.showAsDropDown(this.mContainer, offset.x, offset.y);
        this.mPopupWindow.update();
        this.mPopupWindow.getContentView().requestFocus();
    }

    public void updateBtnState(@IdRes int i, boolean z) {
        View viewFindViewById = this.mDialogContainer.findViewById(i);
        if (viewFindViewById.isSelected() != z) {
            viewFindViewById.setSelected(z);
        }
    }

    private void initPopupWindow(Context context, PopupWindow popupWindow) {
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setClippingEnabled(false);
        popupWindow.setFocusable(true);
        popupWindow.setInputMethodMode(2);
        popupWindow.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(context, R.color.transparent)));
    }
}
