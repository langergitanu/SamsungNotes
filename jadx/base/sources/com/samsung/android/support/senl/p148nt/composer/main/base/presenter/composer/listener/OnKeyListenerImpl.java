package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import com.samsung.android.sdk.pen.setting.common.ViewOnKeyListenerC7560e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OnKeyListenerImpl implements View.OnKeyListener {
    private boolean mIsCtrlPressedLast;
    private final List<View.OnKeyListener> mListeners = new ArrayList();

    public OnKeyListenerImpl() {
        addListener(new ViewOnKeyListenerC7560e(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(View view, int i, KeyEvent keyEvent) {
        if (keyEvent == null) {
            return false;
        }
        if (i == 113 || i == 114) {
            this.mIsCtrlPressedLast = keyEvent.isCtrlPressed();
        } else {
            this.mIsCtrlPressedLast = false;
        }
        return false;
    }

    public void addListener(final View.OnKeyListener onKeyListener) {
        new Handler().post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.OnKeyListenerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (OnKeyListenerImpl.this.mListeners) {
                    try {
                        if (!OnKeyListenerImpl.this.mListeners.contains(onKeyListener)) {
                            OnKeyListenerImpl.this.mListeners.add(onKeyListener);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    public boolean isCtrlPressedLast() {
        return this.mIsCtrlPressedLast;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        boolean z;
        synchronized (this.mListeners) {
            try {
                Iterator<View.OnKeyListener> it = this.mListeners.iterator();
                z = false;
                while (it.hasNext()) {
                    if (it.next().onKey(view, i, keyEvent)) {
                        z = true;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public void removeListener(final View.OnKeyListener onKeyListener) {
        new Handler().post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.OnKeyListenerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (OnKeyListenerImpl.this.mListeners) {
                    OnKeyListenerImpl.this.mListeners.remove(onKeyListener);
                }
            }
        });
    }
}
