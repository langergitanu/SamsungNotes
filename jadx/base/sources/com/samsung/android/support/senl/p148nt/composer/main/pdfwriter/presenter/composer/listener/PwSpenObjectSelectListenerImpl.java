package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.composer.listener;

import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenObjectSelectListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.TextStateHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwSpenObjectSelectListenerImpl extends SpenObjectSelectListenerImpl {
    private static final String TAG = Logger.createTag("PwSpenObjectSelectListenerImpl");

    public PwSpenObjectSelectListenerImpl(ListenerImplContract.IPresenter iPresenter, SoftInputManager softInputManager, TextStateHandler textStateHandler) {
        super(iPresenter, softInputManager, textStateHandler);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenObjectSelectListenerImpl, com.samsung.android.sdk.composer.listener.SpenObjectSelectListener
    public void onObjectSelected(ArrayList<SpenWPage> arrayList, ArrayList<SpenObjectBase> arrayList2, boolean z) {
        super.onObjectSelected(arrayList, arrayList2, z);
        if (z || !this.mModeManager.isMode(Mode.Text)) {
            return;
        }
        this.mModeManager.setMode(Mode.Writing, AbstractC0622a.m1170p(TAG, " onObjectSelected#", new StringBuilder()), true);
    }
}
