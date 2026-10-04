package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SubTranslation extends Translation {
    boolean mIsShowing;

    public SubTranslation(SrcContentInfo srcContentInfo, ComposerViewPresenter composerViewPresenter) {
        super(srcContentInfo, composerViewPresenter);
        this.mIsShowing = false;
    }

    public void changeOriginalText(String str) {
        this.mOriginalText = str;
        this.mSrcContentInfo.setSubResultText(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.Translation
    public String getOriginalText() {
        return TextUtils.isEmpty(this.mOriginalText) ? this.mSrcContentInfo.getSubResultText() : this.mOriginalText;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.Translation
    public String getSelectText() {
        return this.mSrcContentInfo.getSubResultText();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.Translation
    public void initOriginalText() {
        this.mOriginalText = getSelectText();
        updateOriginalNote();
    }

    public boolean isShowing() {
        return this.mIsShowing;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.Translation, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.Translation, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void restoreState(Bundle bundle, SrcContentInfo srcContentInfo) {
        super.restoreState(bundle, srcContentInfo);
    }

    public void setShowing(boolean z) {
        this.mIsShowing = z;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.Translation
    public void updateOriginalText() {
    }
}
