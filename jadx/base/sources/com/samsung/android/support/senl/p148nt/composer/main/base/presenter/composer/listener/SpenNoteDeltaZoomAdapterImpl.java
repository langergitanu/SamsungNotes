package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import com.samsung.android.sdk.composer.view.zoomScroller.SpenNoteZoomScrollerListener;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SpenNoteDeltaZoomAdapterImpl extends SpenNoteZoomScrollerListener {
    private static final String TAG = Logger.createTag("SpenNoteDeltaZoomAdapterImpl");
    private final List<SpenNoteZoomScrollerListener> mNoteZoomScrollerListeners = new ArrayList();

    public void addZoomScrollerListener(SpenNoteZoomScrollerListener spenNoteZoomScrollerListener) {
        List<SpenNoteZoomScrollerListener> list = this.mNoteZoomScrollerListeners;
        if (list != null) {
            list.add(spenNoteZoomScrollerListener);
        }
    }

    public boolean isEnable() {
        return !this.mNoteZoomScrollerListeners.isEmpty();
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.SpenNoteZoomScrollerListener
    public void onScrollLockChanged(boolean z) {
        AbstractC8014b.m7224z("onScrollLockChanged# ", TAG, z);
        Iterator<SpenNoteZoomScrollerListener> it = this.mNoteZoomScrollerListeners.iterator();
        while (it.hasNext()) {
            it.next().onScrollLockChanged(z);
        }
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.SpenNoteZoomScrollerListener
    public void onZoomLockChanged(boolean z) {
        AbstractC8014b.m7224z("onZoomLockChanged# ", TAG, z);
        Iterator<SpenNoteZoomScrollerListener> it = this.mNoteZoomScrollerListeners.iterator();
        while (it.hasNext()) {
            it.next().onZoomLockChanged(z);
        }
    }

    public void removeZoomScrollerListener(SpenNoteZoomScrollerListener spenNoteZoomScrollerListener) {
        List<SpenNoteZoomScrollerListener> list = this.mNoteZoomScrollerListeners;
        if (list != null) {
            list.remove(spenNoteZoomScrollerListener);
        }
    }
}
