package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.SimpleEditView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AiMenuResultViewOriginAbs extends AbsAiActionResultView {
    protected SimpleEditView mSimpleEditView;
    protected View mView;

    public AiMenuResultViewOriginAbs(AiMenuResultCommonViews aiMenuResultCommonViews) {
        super(aiMenuResultCommonViews);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void clear() {
        SimpleEditView simpleEditView = this.mSimpleEditView;
        if (simpleEditView != null) {
            simpleEditView.release();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public abstract AiMenuContract.IAiAction getAction();

    public abstract SpenWNote getReferenceNote();

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public View inflateView(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.ai_result_spen_text_original, viewGroup, false);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void initView(View view, View view2) {
        this.mView = view2;
        SimpleEditView simpleEditView = new SimpleEditView(view2.getContext(), this.mCommonViews.mContract.getPresenter());
        this.mSimpleEditView = simpleEditView;
        simpleEditView.attachView((ViewGroup) view2.findViewById(C9086R.id.simple_edit_text_container));
        this.mSimpleEditView.setScrollBarListener(new SimpleEditView.ScrollBarListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewOriginAbs.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.SimpleEditView.ScrollBarListener
            public void onWorking(boolean z) {
                AiMenuResultViewOriginAbs.this.mCommonViews.mViewPager.setUserInputEnabled(!z);
            }
        });
        this.mSimpleEditView.setEnabledBlurEffect(true);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public boolean isBottomMenuSupported() {
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public boolean isInitialized() {
        return this.mSimpleEditView != null;
    }

    public void setNote(SpenWNote spenWNote, boolean z) {
        SimpleEditView simpleEditView = this.mSimpleEditView;
        if (simpleEditView == null) {
            return;
        }
        simpleEditView.initView(spenWNote, z, this.mView.getResources().getDimensionPixelSize(C9086R.dimen.ai_result_page_horizontal_padding), true);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void setTitle() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView
    public void updateHorizontalPadding(int i) {
        if (isInitialized()) {
            this.mSimpleEditView.updateHorizontalPadding(this.mView.getResources().getDimensionPixelSize(C9086R.dimen.ai_menu_result_side_margin_size));
        }
    }
}
