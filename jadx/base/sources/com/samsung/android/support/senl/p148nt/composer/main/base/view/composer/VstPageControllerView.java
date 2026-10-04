package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class VstPageControllerView {
    ViewTreeObserver.OnGlobalLayoutListener bottomCoverLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.VstPageControllerView.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            View view = VstPageControllerView.this.mContainer;
            if (view == null) {
                return;
            }
            float fConvertDpToPixel = ResourceUtils.convertDpToPixel(view.getContext(), 20.0f);
            if (VstPageControllerView.this.mBottomCoverContainer.getVisibility() == 0) {
                fConvertDpToPixel += VstPageControllerView.this.mBottomCoverContainer.getHeight();
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) VstPageControllerView.this.mContainer.getLayoutParams();
            if (marginLayoutParams.bottomMargin != fConvertDpToPixel) {
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, (int) fConvertDpToPixel);
                VstPageControllerView.this.mContainer.setLayoutParams(marginLayoutParams);
            }
        }
    };
    View mBottomCoverContainer;
    View mCollapseButton;
    View mContainer;
    View mExpandButton;
    boolean mIsExpand;
    View mPageControllerLayout;
    ComposerViewContract.IPresenter mPresenter;

    public VstPageControllerView(ViewGroup viewGroup, ComposerViewContract.IPresenter iPresenter) {
        this.mPresenter = iPresenter;
        this.mContainer = viewGroup.findViewById(C9086R.id.vst_comp_page_controller_container);
        this.mBottomCoverContainer = iPresenter.getActivity().findViewById(C9086R.id.comp_bottom_cover_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void togglePageController(boolean z) {
        if (this.mIsExpand == z) {
            return;
        }
        this.mIsExpand = z;
        if (z) {
            this.mPageControllerLayout.setVisibility(0);
            this.mExpandButton.setVisibility(8);
        } else {
            this.mPageControllerLayout.setVisibility(8);
            this.mExpandButton.setVisibility(0);
        }
    }

    public void init() {
        if (DeviceInfo.isVSTModel()) {
            this.mContainer.setVisibility(0);
            this.mPageControllerLayout = this.mContainer.findViewById(C9086R.id.vst_comp_page_controller);
            this.mCollapseButton = this.mContainer.findViewById(C9086R.id.vst_comp_page_controller_toggle_collapse_btn);
            this.mExpandButton = this.mContainer.findViewById(C9086R.id.vst_comp_page_controller_toggle_expand_btn);
            this.mIsExpand = false;
            this.mPageControllerLayout.setVisibility(8);
            this.mExpandButton.setVisibility(0);
            this.mExpandButton.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.VstPageControllerView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    VstPageControllerView.this.togglePageController(true);
                    if (DeviceInfo.isVSTModel()) {
                        ComposerSA.insertLog(ComposerSA.getScreenID(VstPageControllerView.this.mPresenter.getComposerModel().getModeManager().isEditMode(), VstPageControllerView.this.mPresenter.getComposerModel().getModeManager().isMode(Mode.Writing), VstPageControllerView.this.mPresenter.getComposerModel().isTabletLayout()), ComposerSAConstants.EVENT_VST_PAGE_CONTROLLER_EXPAND);
                    }
                }
            });
            this.mCollapseButton.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.VstPageControllerView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    VstPageControllerView.this.togglePageController(false);
                    if (DeviceInfo.isVSTModel()) {
                        ComposerSA.insertLog(ComposerSA.getScreenID(VstPageControllerView.this.mPresenter.getComposerModel().getModeManager().isEditMode(), VstPageControllerView.this.mPresenter.getComposerModel().getModeManager().isMode(Mode.Writing), VstPageControllerView.this.mPresenter.getComposerModel().isTabletLayout()), ComposerSAConstants.EVENT_VST_PAGE_CONTROLLER_COLLAPSE);
                    }
                }
            });
            this.mBottomCoverContainer.getViewTreeObserver().addOnGlobalLayoutListener(this.bottomCoverLayoutListener);
        }
    }

    public void release() {
        this.mBottomCoverContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this.bottomCoverLayoutListener);
    }
}
