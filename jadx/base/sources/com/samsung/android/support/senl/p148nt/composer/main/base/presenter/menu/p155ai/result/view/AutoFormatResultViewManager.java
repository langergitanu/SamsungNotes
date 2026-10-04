package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.view.View;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AutoFormatResultView;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AutoFormatResultViewManager implements AutoFormat.ResultListener, AutoFormatResultView.Contract {
    private static final String TAG = Logger.createTag("AutoFormatResultViewManager", AiConstants.PREFIX_TAG);
    AutoFormat mAutoFormat;
    List<AutoFormatResultView> mAutoFormatResultViewList;
    AiMenuResultCommonViews mCommonViews;
    Contract mContract;
    boolean mHasResult;
    AutoFormatOriginTextView mOriginalView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract extends AiMenuContract.IAiActionResultContainer {
        boolean updateEditedRecognizedHw();

        void updatePages();
    }

    public AutoFormatResultViewManager(AutoFormat autoFormat, AiMenuResultCommonViews aiMenuResultCommonViews, Contract contract) {
        this.mAutoFormat = autoFormat;
        if (autoFormat == null) {
            return;
        }
        autoFormat.setResultListener(this);
        this.mCommonViews = aiMenuResultCommonViews;
        this.mContract = contract;
    }

    private void hidePageErrorMsg() {
        Iterator<AutoFormatResultView> it = this.mAutoFormatResultViewList.iterator();
        while (it.hasNext()) {
            it.next().hidePageErrorMsg();
        }
    }

    private void showPageErrorMsg() {
        Iterator<AutoFormatResultView> it = this.mAutoFormatResultViewList.iterator();
        while (it.hasNext()) {
            it.next().showPageErrorMsg();
        }
    }

    public void addWatermark() {
        Iterator<AutoFormatResultView> it = this.mAutoFormatResultViewList.iterator();
        while (it.hasNext()) {
            it.next().addWatermark();
        }
    }

    public void clear() {
        if (this.mAutoFormat == null) {
            return;
        }
        AutoFormatOriginTextView autoFormatOriginTextView = this.mOriginalView;
        if (autoFormatOriginTextView != null) {
            autoFormatOriginTextView.clear();
        }
        Iterator<AutoFormatResultView> it = this.mAutoFormatResultViewList.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.mAutoFormat.cancel();
        this.mAutoFormat.setResultListener(null);
        this.mAutoFormat.clearResultNote();
        this.mAutoFormat = null;
        hideProgress();
    }

    public void createAutoFormatView(boolean z) {
        if (this.mAutoFormat == null) {
            return;
        }
        this.mAutoFormatResultViewList = new ArrayList();
        List<Integer> styleOrder = this.mAutoFormat.getStyleOrder();
        int size = styleOrder.size();
        for (int i = 0; i < size && (this.mAutoFormat.getErrorType() == null || i <= 0); i++) {
            AutoFormat autoFormat = this.mAutoFormat;
            int i2 = (size - 1) - i;
            AutoFormatResultView autoFormatResultView = new AutoFormatResultView(autoFormat, autoFormat.getSelectionMaxLength(styleOrder.get(i2).intValue()), this.mCommonViews, styleOrder.get(i2).intValue(), this);
            if (z && i == 0) {
                autoFormatResultView.setFirstPage(true);
            }
            this.mAutoFormatResultViewList.add(autoFormatResultView);
            autoFormatResultView.updateNote();
        }
        if (!this.mHasResult || this.mAutoFormat.isWaiting() || this.mAutoFormat.getLastErrorMessage() == null) {
            return;
        }
        onFailed(this.mAutoFormat.getLastErrorMessage());
        if (z) {
            this.mAutoFormatResultViewList = new ArrayList();
        }
    }

    public void createOriginView() {
        if (this.mAutoFormat == null) {
            return;
        }
        this.mOriginalView = new AutoFormatOriginTextView(this.mAutoFormat, this.mCommonViews);
        this.mAutoFormat.makeOriginNote();
    }

    public List<AutoFormatResultView> getAutoFormatResultViewList() {
        return this.mAutoFormatResultViewList;
    }

    public AutoFormatOriginTextView getOriginalView() {
        return this.mOriginalView;
    }

    public void hideProgress() {
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews != null) {
            aiMenuResultCommonViews.hideProgress();
        }
    }

    public void initView(View view) {
        AutoFormat autoFormat = this.mAutoFormat;
        if (autoFormat == null || autoFormat.isWaiting()) {
            return;
        }
        this.mHasResult = true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.ResultListener
    public void onFailed(@NonNull String str) {
        if (this.mCommonViews.handleRestrictedPersonalDataError(str)) {
            return;
        }
        this.mCommonViews.mErrMsgView.setText(str);
        this.mCommonViews.showErrorMessage();
        this.mCommonViews.getContinuesProgress().setEnable(false);
        this.mContract.updateResultState(false, true);
        if (this.mCommonViews.isShowingErrorMessage()) {
            return;
        }
        ToastHandler.show(this.mCommonViews.mErrMsgView.getContext(), str, 0);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.ResultListener
    public void onNextCompleted(boolean z) {
        this.mContract.updateContinuesResultState(z);
        addWatermark();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.ResultListener
    public void onProgressing() {
        this.mCommonViews.setBottomButtonsState(false);
        this.mCommonViews.getContinuesProgress().show(3);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.ResultListener
    public void onResult(boolean z) {
        AutoFormat autoFormat;
        this.mHasResult = true;
        if (this.mAutoFormatResultViewList.size() == 1 && (autoFormat = this.mAutoFormat) != null && autoFormat.getErrorType() == null) {
            List<Integer> styleOrder = this.mAutoFormat.getStyleOrder();
            int size = styleOrder.size();
            for (int i = 1; i < size; i++) {
                AutoFormat autoFormat2 = this.mAutoFormat;
                int i2 = (size - 1) - i;
                this.mAutoFormatResultViewList.add(new AutoFormatResultView(autoFormat2, autoFormat2.getSelectionMaxLength(styleOrder.get(i2).intValue()), this.mCommonViews, styleOrder.get(i2).intValue(), this));
            }
        }
        Iterator<AutoFormatResultView> it = this.mAutoFormatResultViewList.iterator();
        while (it.hasNext()) {
            it.next().updateNote();
        }
        this.mContract.updatePages();
        this.mContract.updateResultState(true, z);
        AutoFormat autoFormat3 = this.mAutoFormat;
        if (autoFormat3 != null) {
            autoFormat3.resetPreFormatType();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AutoFormatResultView.Contract
    public void updateEditedRecognizedHw(AutoFormatResultView autoFormatResultView) {
        List<AutoFormatResultView> list = this.mAutoFormatResultViewList;
        if (list == null || list.isEmpty() || this.mAutoFormatResultViewList.indexOf(autoFormatResultView) != 0 || !this.mContract.updateEditedRecognizedHw()) {
            return;
        }
        AutoFormat.ErrorType errorTypeCanExecute = this.mAutoFormat.canExecute();
        if (errorTypeCanExecute == null) {
            this.mCommonViews.showProgress(3);
            this.mCommonViews.setTopButtonState(false);
            this.mAutoFormat.setErrorType(null);
            this.mAutoFormat.execute();
            hidePageErrorMsg();
            return;
        }
        AutoFormat.ErrorType errorType = AutoFormat.ErrorType.MINIMUM;
        if (errorType.equals(errorTypeCanExecute)) {
            Logger.m10999d(TAG, "onPageSelected# minimum limitation");
            if (!errorType.equals(this.mAutoFormat.getErrorType())) {
                this.mAutoFormat.setErrorType(errorType);
                this.mAutoFormat.clearResultText();
                showPageErrorMsg();
                this.mContract.updatePages();
            }
            autoFormatResultView.setErrorState();
        }
    }
}
