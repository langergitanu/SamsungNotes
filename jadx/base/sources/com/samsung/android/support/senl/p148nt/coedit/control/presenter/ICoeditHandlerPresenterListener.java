package com.samsung.android.support.senl.p148nt.coedit.control.presenter;

import com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager;
import com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler;
import com.samsung.android.support.senl.p148nt.coedit.control.model.CoeditHandlerModel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface ICoeditHandlerPresenterListener {
    CoeditControlPresenter getCoeditControlPresenter();

    CoeditGrpcPresenter getCoeditGrpcPresenter();

    CoeditHandlerModel getCoeditHandlerModel();

    BaseCoeditManager getCoeditManager();

    ICoeditHandler.ComposerContract getComposerContract();

    void initUiThreadHandler();

    boolean isAlreadySnapReleased();

    boolean isClosingState();

    boolean isClosingState(String str);

    boolean isMaxCounted(long j, String str);

    void releaseUiThreadHandler();

    void runOnUIThread(Runnable runnable, String str);

    void runOnWorkerThread(Runnable runnable, String str, int i);
}
