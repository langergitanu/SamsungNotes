package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import com.samsung.android.sdk.pen.engine.deltaZoom.SpenZoomListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SpenZoomListenerImpl implements SpenZoomListener {
    private final List<ZoomListener> mZoomListenerList = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ZoomListener {
        void onZoom(float f, float f4, float f5, float f6, float f7);
    }

    public void addZoomListener(ZoomListener zoomListener) {
        if (this.mZoomListenerList.contains(zoomListener)) {
            return;
        }
        this.mZoomListenerList.add(zoomListener);
    }

    public boolean isEnable() {
        return !this.mZoomListenerList.isEmpty();
    }

    @Override // com.samsung.android.sdk.pen.engine.deltaZoom.SpenZoomListener
    public void onZoom(float f, float f4, float f5, float f6, float f7) {
        Iterator it = new ArrayList(this.mZoomListenerList).iterator();
        while (it.hasNext()) {
            ((ZoomListener) it.next()).onZoom(f, f4, f5, f6, f7);
        }
    }

    public void removeZoomListener(ZoomListener zoomListener) {
        Iterator<ZoomListener> it = this.mZoomListenerList.iterator();
        while (it.hasNext()) {
            if (it.next().equals(zoomListener)) {
                it.remove();
            }
        }
    }
}
