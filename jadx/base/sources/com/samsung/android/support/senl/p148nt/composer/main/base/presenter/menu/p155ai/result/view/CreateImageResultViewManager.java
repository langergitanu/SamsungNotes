package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.CreateImage;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CreateImageResultViewManager implements CreateImage.Listener {
    private static final String TAG = Logger.createTag("CreateImageResultViewManager", AiConstants.PREFIX_TAG);
    private final AiMenuResultCommonViews mCommonViews;
    private final Contract mContract;
    private CreateImage mCreateImage;
    private List<CreateImageResultView> mCreateImageResultViews;
    private CreateImageResultView mOriginalView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void requestRelease(String str);

        void updatePages(List<CreateImageResultView> list, int i, String str);
    }

    public CreateImageResultViewManager(CreateImage createImage, AiMenuResultCommonViews aiMenuResultCommonViews, Contract contract) {
        this.mCreateImage = createImage;
        createImage.setResultListener(this);
        this.mCommonViews = aiMenuResultCommonViews;
        this.mContract = contract;
    }

    private void initPopupMenu() {
        Object[] objArr = {Integer.valueOf(C9086R.string.ai_action_add_to_note)};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        this.mCommonViews.getTopView().makeMorePopup(AbstractC2322a.m1630t(obj, arrayList, obj, arrayList), new C9678D(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPopupMenu$0(int i) {
        AbstractC0000a.m3D(i, "PopupMenu#ItemClick# ", TAG);
        if (this.mCommonViews.getTopView().getMorePopup().getMenuItems().get(i).strId() == C9086R.string.ai_action_add_to_note) {
            this.mCommonViews.getBottomView().getAddToBtn().callOnClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCompleted$2() {
        this.mCommonViews.getBottomView().showDelay();
        this.mCommonViews.getBottomView().setFixed(true);
        this.mOriginalView.updateLayout("onCompleted");
        this.mContract.updatePages(getResultViews(), 1, "onCompleted");
        this.mCommonViews.hideProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onFailed$3(String str) {
        this.mCommonViews.hideProgress();
        this.mCommonViews.showErrorMessage();
        this.mCommonViews.mErrMsgView.setText(this.mCreateImage.getErrorMessage(str));
        this.mCommonViews.setTopButtonsVisibility(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestRelease$1(String str) {
        this.mContract.requestRelease(str);
    }

    private void updateResultViews() {
        if (this.mCreateImageResultViews == null) {
            this.mCreateImageResultViews = new ArrayList();
        }
        int validOutputCount = this.mCreateImage.getValidOutputCount();
        int i = 0;
        while (i < validOutputCount) {
            this.mCreateImageResultViews.add(i < this.mCreateImageResultViews.size() ? this.mCreateImageResultViews.get(i) : new CreateImageResultView(this.mCreateImage, this.mCommonViews, i + 1));
            i++;
        }
    }

    public void addResultPages() {
        updateResultViews();
        this.mCommonViews.getBottomView().showDelay();
        this.mCommonViews.getBottomView().setFixed(true);
        this.mOriginalView.updateLayout("addResultPages");
        this.mContract.updatePages(getResultViews(), this.mCreateImage.getFocusedOutputIndex() + 1, "addResultPages");
        this.mCommonViews.hideProgress();
    }

    public void clear(String str) {
        if (this.mCreateImage == null) {
            return;
        }
        CreateImageResultView createImageResultView = this.mOriginalView;
        if (createImageResultView != null) {
            createImageResultView.clear();
        }
        List<CreateImageResultView> list = this.mCreateImageResultViews;
        if (list != null) {
            Iterator<CreateImageResultView> it = list.iterator();
            while (it.hasNext()) {
                it.next().clear();
            }
        }
        this.mCommonViews.getBottomView().setDisabled(false);
        this.mCommonViews.getBottomView().getCopyBtn().setVisibility(0);
        this.mCommonViews.getBottomView().getReplaceBtn().setVisibility(0);
        this.mCommonViews.getBottomView().getAddToBtn().setVisibility(0);
        this.mCommonViews.getBottomView().getRetryBtn().setVisibility(8);
        this.mCreateImage.cancel(str);
        this.mCreateImage.setResultListener(null);
        this.mCreateImage = null;
    }

    public CreateImageResultView getOriginalView() {
        if (this.mOriginalView == null) {
            this.mOriginalView = new CreateImageResultView(this.mCreateImage, this.mCommonViews, 0);
        }
        return this.mOriginalView;
    }

    public List<CreateImageResultView> getResultViews() {
        return this.mCreateImageResultViews.subList(0, this.mCreateImage.getValidOutputCount());
    }

    public void initView() {
        CreateImageResultView createImageResultView = this.mOriginalView;
        if (createImageResultView != null) {
            createImageResultView.clear();
            this.mOriginalView = null;
        }
        List<CreateImageResultView> list = this.mCreateImageResultViews;
        if (list != null) {
            Iterator<CreateImageResultView> it = list.iterator();
            while (it.hasNext()) {
                it.next().clear();
            }
            this.mCreateImageResultViews = null;
        }
        initPopupMenu();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.ResultListener
    public void onCompleted(boolean z) {
        updateResultViews();
        this.mCreateImage.getHandler().post(new RunnableC9711g(this, 14));
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.ResultListener
    public void onFailed(@NonNull String str) {
        this.mCreateImage.getHandler().post(new RunnableC9692M(this, str, 1));
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.ResultListener
    public void onNextCompleted(boolean z) {
        if (this.mCreateImageResultViews == null) {
            this.mCreateImageResultViews = new ArrayList();
            int validOutputCount = this.mCreateImage.getValidOutputCount();
            int i = 0;
            while (i < validOutputCount) {
                i++;
                this.mCreateImageResultViews.add(new CreateImageResultView(this.mCreateImage, this.mCommonViews, i));
            }
        }
        if (this.mCreateImageResultViews.size() < 10) {
            this.mCreateImageResultViews.add(new CreateImageResultView(this.mCreateImage, this.mCommonViews, this.mCreateImageResultViews.size() + 1));
        }
        this.mCreateImage.getHandler().post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.CreateImageResultViewManager.1
            @Override // java.lang.Runnable
            public void run() {
                CreateImageResultViewManager.this.mCommonViews.getBottomView().showDelay();
                CreateImageResultViewManager.this.mCommonViews.getBottomView().setFixed(true);
                CreateImageResultViewManager.this.mOriginalView.updateLayout("onCompleted");
                CreateImageResultViewManager.this.mContract.updatePages(CreateImageResultViewManager.this.getResultViews(), 1, "onCompleted");
                CreateImageResultViewManager.this.mCommonViews.hideProgress();
            }
        });
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.ResultListener
    public void onProgressing() {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.CreateImage.Listener
    public void onStart() {
        this.mCommonViews.showProgress(8);
        this.mCommonViews.getBottomView().setFixed(false);
        this.mCommonViews.getBottomView().hide(false);
        this.mOriginalView.updateLayout("onStart");
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.CreateImage.Listener
    public void requestRelease(String str) {
        this.mCreateImage.getHandler().post(new RunnableC9692M(this, str, 0));
    }
}
