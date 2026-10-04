package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.view.View;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.SpellingCorrection;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiMenuResultViewCorrectionOrigin extends AiMenuResultViewOriginAbs {
    private final SpellingCorrection mSpellingCorrection;

    public AiMenuResultViewCorrectionOrigin(SpellingCorrection spellingCorrection, AiMenuResultCommonViews aiMenuResultCommonViews) {
        super(aiMenuResultCommonViews);
        this.mSpellingCorrection = spellingCorrection;
        spellingCorrection.makeOriginNote();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultViewOriginAbs, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public AiMenuContract.IAiAction getAction() {
        return this.mSpellingCorrection;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultViewOriginAbs
    public SpenWNote getReferenceNote() {
        return this.mSpellingCorrection.getOriginalNote();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultViewOriginAbs, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void initView(View view, View view2) {
        super.initView(view, view2);
        setNote(this.mSpellingCorrection.getOriginalNote(), this.mSpellingCorrection.getSrcContentInfo().mIsBGColorInverted);
        boolean z = view.getResources().getConfiguration().orientation == 2;
        View viewFindViewById = view.findViewById(C9086R.id.result_layout_content);
        updateLayout(z, viewFindViewById.getMeasuredWidth(), viewFindViewById.getMeasuredHeight());
        this.mRestoreSpenEditViewScroll = new AbsAiActionResultView.RestoreSpenEditViewScroll(this.mSimpleEditView, this.mSpellingCorrection.getHandler());
    }
}
