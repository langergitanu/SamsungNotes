package com.samsung.android.support.senl.p148nt.composer.main.simple.model;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PagePanInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.simple.common.SimpleComposerConstant;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerState implements Serializable {
    public static final String KEY_STATE = "ComposerState";
    private static final transient String TAG = Logger.createTag(KEY_STATE, SimpleComposerConstant.TAG_PREFIX);
    private static final long serialVersionUID = 1;
    private EventListener mEventListener;
    private transient boolean mReadyRestore;
    private PagePanInfo mPagePan = new PagePanInfo();
    private float mZoomRatio = -1.0f;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface EventListener {
        void onPositionChanged();
    }

    public PagePanInfo getPagePanInfo() {
        return this.mPagePan;
    }

    public float getZoomRatio() {
        return this.mZoomRatio;
    }

    public boolean isReadyRestore() {
        return this.mReadyRestore;
    }

    public void setEventListener(EventListener eventListener) {
        this.mEventListener = eventListener;
    }

    public void setPosition(PagePanInfo pagePanInfo, float f) {
        if (this.mPagePan.equals(pagePanInfo) && this.mZoomRatio == f) {
            return;
        }
        this.mPagePan = pagePanInfo;
        this.mZoomRatio = f;
        EventListener eventListener = this.mEventListener;
        if (eventListener != null) {
            eventListener.onPositionChanged();
        }
    }

    public void setReadyRestore(boolean z) {
        this.mReadyRestore = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ComposerState{, mPagePan=");
        sb.append(this.mPagePan);
        sb.append(", mZoomRatio=");
        return AbstractC0622a.m1171q(sb, this.mZoomRatio, '}');
    }
}
