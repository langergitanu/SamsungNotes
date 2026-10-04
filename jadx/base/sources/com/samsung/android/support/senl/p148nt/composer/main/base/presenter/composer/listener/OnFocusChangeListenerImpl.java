package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OnFocusChangeListenerImpl implements View.OnFocusChangeListener {
    private final List<View.OnFocusChangeListener> mListeners = new ArrayList();

    public void addListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.mListeners.add(onFocusChangeListener);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        Iterator<View.OnFocusChangeListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onFocusChange(view, z);
        }
    }

    public void removeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.mListeners.remove(onFocusChangeListener);
    }
}
