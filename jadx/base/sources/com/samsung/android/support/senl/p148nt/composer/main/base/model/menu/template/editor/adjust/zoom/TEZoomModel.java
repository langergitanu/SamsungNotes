package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.zoom;

import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TEZoomModel implements IZoomConstants {
    private static final String TAG = CTLogger.createTag("TEZoomModel");
    private List<TEZoomObserver> mObservers = new ArrayList();
    protected float mCurrentScale = 1.0f;
    protected float mMinScale = 1.0f;
    protected float mMaxScale = 3.0f;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TEZoomObserver {
        void onScaleChanged();
    }

    private float getValidateScale(float f) {
        float f4 = this.mMaxScale;
        if (f > f4) {
            f = f4;
        }
        float f5 = this.mMinScale;
        return f < f5 ? f5 : f;
    }

    public void addObserver(TEZoomObserver tEZoomObserver) {
        this.mObservers.add(tEZoomObserver);
    }

    public float getCurrentScale() {
        return this.mCurrentScale;
    }

    public float getMaxScale() {
        return this.mMaxScale;
    }

    public float getMinScale() {
        return this.mMinScale;
    }

    public void multiplyScale(float f) {
        setCurrentScale(this.mCurrentScale * f);
    }

    public void removeObserver(TEZoomObserver tEZoomObserver) {
        this.mObservers.remove(tEZoomObserver);
    }

    public void setCurrentScale(float f) {
        Logger.m11003i(TAG, "setCurrentScale, currentScale/newScale= " + this.mCurrentScale + "/" + f);
        float validateScale = getValidateScale(f);
        if (Float.compare(this.mCurrentScale, validateScale) != 0) {
            this.mCurrentScale = validateScale;
            Iterator<TEZoomObserver> it = this.mObservers.iterator();
            while (it.hasNext()) {
                it.next().onScaleChanged();
            }
        }
    }

    public void setScales(float f) {
        if (Float.compare(f, 0.0f) == 0) {
            f = 1.0f;
        }
        this.mMinScale = f;
        this.mMaxScale = 3.0f * f;
        setCurrentScale(f);
        Logger.m11003i(TAG, "setMinScale = " + this.mMinScale);
    }
}
