package com.samsung.android.support.senl.p148nt.composer.main.simple.model;

import android.app.Activity;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.OpenParam;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface DocumentLoadContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IComposer {
        Activity getActivity();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IDataStore {
        void loadDocument(IComposer iComposer, OpenParam openParam);

        void onDestroyed();

        void setLoadListener(LoadListener loadListener);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface LoadListener {
        void onLoadNoteCompleted(SpenWNote spenWNote, String str);

        void onLoadNoteFailed(Throwable th);
    }
}
