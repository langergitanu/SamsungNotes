package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AutoFormatResultViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.SimpleEditView;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AutoFormatStreamingResultViewManager extends AutoFormatResultViewManager {
    private AutoFormatStreamingResultView mAutoFormatStreamingResultView;
    boolean mStreamingStartFlag;

    public AutoFormatStreamingResultViewManager(AutoFormat autoFormat, AiMenuResultCommonViews aiMenuResultCommonViews, AutoFormatResultViewManager.Contract contract) {
        super(autoFormat, aiMenuResultCommonViews, contract);
        this.mStreamingStartFlag = false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AutoFormatResultViewManager
    public void clear() {
        AutoFormat autoFormat = this.mAutoFormat;
        if (autoFormat == null) {
            return;
        }
        autoFormat.cancel();
        this.mAutoFormat.setResultListener(null);
        this.mAutoFormat.clearResultNote();
        this.mAutoFormat = null;
        AutoFormatOriginTextView autoFormatOriginTextView = this.mOriginalView;
        if (autoFormatOriginTextView != null) {
            autoFormatOriginTextView.clear();
        }
        if (!this.mStreamingStartFlag) {
            Iterator<AutoFormatResultView> it = this.mAutoFormatResultViewList.iterator();
            while (it.hasNext()) {
                it.next().clear();
            }
        }
        AutoFormatStreamingResultView autoFormatStreamingResultView = this.mAutoFormatStreamingResultView;
        if (autoFormatStreamingResultView != null) {
            autoFormatStreamingResultView.clear();
        }
        hideProgress();
    }

    public void createAutoFormatStreamingResultView() {
        this.mAutoFormatStreamingResultView = new AutoFormatStreamingResultView(this.mAutoFormat, this.mCommonViews);
    }

    public AutoFormatStreamingResultView geAutoFormatStreamingResultView() {
        return this.mAutoFormatStreamingResultView;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AutoFormatResultViewManager, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.ResultListener
    public void onResult(boolean z) {
        if (z) {
            this.mStreamingStartFlag = false;
            this.mHasResult = true;
            this.mContract.updateResultState(true, z);
            addWatermark();
            AutoFormatStreamingResultView autoFormatStreamingResultView = this.mAutoFormatStreamingResultView;
            if (autoFormatStreamingResultView != null) {
                autoFormatStreamingResultView.setMode(1);
            }
            AutoFormat autoFormat = this.mAutoFormat;
            if (autoFormat != null) {
                autoFormat.resetPreFormatType();
                return;
            }
            return;
        }
        AutoFormatStreamingResultView autoFormatStreamingResultView2 = this.mAutoFormatStreamingResultView;
        if (autoFormatStreamingResultView2 == null) {
            return;
        }
        autoFormatStreamingResultView2.scrollToPosition(SimpleEditView.SCROLL_POSITION.BOTTOM);
        if (!this.mStreamingStartFlag || this.mCommonViews.isShowingProgress()) {
            this.mStreamingStartFlag = true;
            this.mAutoFormatStreamingResultView.updateNote();
            this.mContract.updateStreamingState();
            this.mAutoFormatStreamingResultView.setMode(3);
        }
    }
}
