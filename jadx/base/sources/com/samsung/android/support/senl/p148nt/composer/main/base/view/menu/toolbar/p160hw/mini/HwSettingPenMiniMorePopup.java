package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.mini;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.transition.TransitionManager;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.common.HwInOutVI;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class HwSettingPenMiniMorePopup {
    View mAddView;
    ViewGroup mContainer;
    View mDeleteView;
    View mHwSettingPopup;
    OnClickListener mOnClickListener;
    ViewGroup mPopupContainer;
    View mRotateView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnClickListener {
        void onAddClick(View view);

        void onDeleteClick(View view);

        void onRotateClick(View view);
    }

    public HwSettingPenMiniMorePopup(@NonNull ViewGroup viewGroup) {
        this.mContainer = viewGroup;
        init();
    }

    private void inOutVI() {
        TransitionManager.endTransitions(this.mPopupContainer);
        if (this.mPopupContainer.isLaidOut()) {
            TransitionManager.beginDelayedTransition(this.mPopupContainer, new HwInOutVI());
        } else {
            this.mPopupContainer.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniMorePopup.4
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    HwSettingPenMiniMorePopup.this.mPopupContainer.getViewTreeObserver().removeOnPreDrawListener(this);
                    new HwInOutVI(1).getAnimator(HwSettingPenMiniMorePopup.this.mPopupContainer).start();
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean internalHide(boolean z) {
        if (!this.mHwSettingPopup.isShown()) {
            return false;
        }
        if (z) {
            inOutVI();
        }
        this.mHwSettingPopup.setVisibility(8);
        return true;
    }

    public View getView() {
        return this.mHwSettingPopup;
    }

    public boolean hide() {
        return internalHide(true);
    }

    public void init() {
        if (this.mHwSettingPopup != null) {
            return;
        }
        View viewInflate = LayoutInflater.from(this.mContainer.getContext()).inflate(C9086R.layout.comp_hw_setting_popup, (ViewGroup) null);
        this.mHwSettingPopup = viewInflate;
        this.mPopupContainer = (ViewGroup) viewInflate.findViewById(C9086R.id.popup_container);
        View viewFindViewById = this.mHwSettingPopup.findViewById(C9086R.id.add);
        this.mAddView = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniMorePopup.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnClickListener onClickListener = HwSettingPenMiniMorePopup.this.mOnClickListener;
                if (onClickListener != null) {
                    onClickListener.onAddClick(view);
                    HwSettingPenMiniMorePopup.this.hide();
                }
            }
        });
        View viewFindViewById2 = this.mHwSettingPopup.findViewById(C9086R.id.delete);
        this.mDeleteView = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniMorePopup.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnClickListener onClickListener = HwSettingPenMiniMorePopup.this.mOnClickListener;
                if (onClickListener != null) {
                    onClickListener.onDeleteClick(view);
                    HwSettingPenMiniMorePopup.this.hide();
                }
            }
        });
        View viewFindViewById3 = this.mHwSettingPopup.findViewById(C9086R.id.rotate);
        this.mRotateView = viewFindViewById3;
        viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniMorePopup.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnClickListener onClickListener = HwSettingPenMiniMorePopup.this.mOnClickListener;
                if (onClickListener != null) {
                    onClickListener.onRotateClick(view);
                    HwSettingPenMiniMorePopup.this.internalHide(false);
                }
            }
        });
        this.mContainer.addView(this.mHwSettingPopup);
        this.mHwSettingPopup.bringToFront();
        this.mHwSettingPopup.setVisibility(8);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void show(boolean z, boolean z2) {
        this.mAddView.setVisibility(z ? 0 : 8);
        this.mDeleteView.setVisibility(z2 ? 0 : 8);
        inOutVI();
        this.mHwSettingPopup.setVisibility(0);
    }
}
