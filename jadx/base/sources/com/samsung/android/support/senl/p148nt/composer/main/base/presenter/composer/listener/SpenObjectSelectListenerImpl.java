package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.composer.listener.SpenObjectSelectListener;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.base.composer.common.BaseComposerSAConstants;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste.CoeditRestriction;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SpenObjectSelectListenerImpl extends SpenObjectSelectListener {
    private static final String TAG = Logger.createTag("SpenObjectSelectListenerImpl");
    private final BridgeListenerList<SpenObjectSelectListener> mBridgeListenerList = new BridgeListenerList<>();
    protected ModeManager mModeManager;
    private final ObjectManager mObjectManager;
    private final ListenerImplContract.IPresenter mPresenter;
    private final SoftInputManager mSoftInputManager;
    private final TextStateHandler mTextStateHandler;

    public SpenObjectSelectListenerImpl(ListenerImplContract.IPresenter iPresenter, SoftInputManager softInputManager, TextStateHandler textStateHandler) {
        this.mPresenter = iPresenter;
        this.mSoftInputManager = softInputManager;
        this.mModeManager = iPresenter.getComposerModel().getModeManager();
        this.mObjectManager = iPresenter.getObjectManager();
        this.mTextStateHandler = textStateHandler;
    }

    private void checkMaxCountSelectedObject(ArrayList<SpenObjectBase> arrayList) {
        if (new CoeditRestriction(this.mPresenter.getComposerModel()).isCoeditMaxCountLimit(arrayList) && this.mPresenter.getComposerControllerManager().getComposerSelectionController().clearSelection()) {
            ToastHandler.show(this.mPresenter.getView().getContext(), this.mPresenter.getView().getContext().getResources().getQuantityString(C9086R.plurals.plurals_restriction_selected_number, 100, 100), 0);
            Logger.m11003i(TAG, "checkMaxCountSelectedObject # coedit note & object selected more than max count");
            ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, "7651");
        }
    }

    public void addBridgeListener(SpenObjectSelectListener spenObjectSelectListener) {
        this.mBridgeListenerList.addBridgeListener(spenObjectSelectListener);
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenObjectSelectListener
    public void onObjectSelected(ArrayList<SpenWPage> arrayList, ArrayList<SpenObjectBase> arrayList2, boolean z) {
        boolean z2;
        String str = TAG;
        StringBuilder sbM3200j = AbstractC4539a.m3200j("onObjectSelected# ", " page : ", z);
        sbM3200j.append(arrayList == null ? "bodytext " : Integer.valueOf(arrayList.size()));
        sbM3200j.append(" obj: ");
        sbM3200j.append(arrayList2.size());
        Logger.m10999d(str, sbM3200j.toString());
        if (this.mObjectManager.isSelectedTextBox()) {
            this.mTextStateHandler.consumeAllMessages();
            z2 = false;
        } else {
            z2 = true;
        }
        if (z) {
            if (arrayList != null && arrayList.isEmpty()) {
                arrayList = null;
            } else if (this.mModeManager.isMode(Mode.Text) && !this.mObjectManager.isSelectedTextBox(arrayList2)) {
                this.mSoftInputManager.hide(this.mPresenter.getView());
            }
            this.mObjectManager.updateSelectedObject(arrayList, arrayList2);
            checkMaxCountSelectedObject(arrayList2);
        } else {
            this.mObjectManager.updateSelectedObject(null, null);
        }
        if (z2) {
            this.mTextStateHandler.consumeAllMessages();
        }
        Iterator<SpenObjectSelectListener> it = this.mBridgeListenerList.iterator();
        while (it.hasNext()) {
            it.next().onObjectSelected(arrayList, arrayList2, z);
        }
    }

    public void removeBridgeListener(SpenObjectSelectListener spenObjectSelectListener) {
        this.mBridgeListenerList.removeBridgeListener(spenObjectSelectListener);
    }
}
