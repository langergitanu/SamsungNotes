package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.sdk.pen.engine.SpenTouchListener;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mde.CoeditAdapter;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SpenPreTouchListenerImpl implements SpenTouchListener {
    private CoeditTouchEventLocker mCoeditTouchEventLocker;
    private final List<PreTouchListener> mPreTouchListenerList = new CopyOnWriteArrayList();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CoeditTouchEventLocker implements PreTouchListener {
        private static final String TAG = "CoeditTouchEventLocker";
        private CoeditAdapter mCoeditAdapter;
        private final Handler mHandler = new Handler(Looper.getMainLooper());
        private Runnable mResumeCoedit = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl.CoeditTouchEventLocker.1
            @Override // java.lang.Runnable
            public void run() {
                CoeditTouchEventLocker.this.mCoeditAdapter.resumeCoeditNoTimeout(CoeditTouchEventLocker.TAG);
            }
        };

        public CoeditTouchEventLocker(CoeditAdapter coeditAdapter) {
            this.mCoeditAdapter = coeditAdapter;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl.PreTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.mCoeditAdapter.pauseCoeditNoTimeout(TAG);
                this.mHandler.removeCallbacks(this.mResumeCoedit);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            this.mHandler.post(this.mResumeCoedit);
            return false;
        }

        public void release() {
            this.mHandler.removeCallbacks(this.mResumeCoedit);
            this.mCoeditAdapter.resumeCoeditNoTimeout(TAG);
            this.mCoeditAdapter = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PreTouchListener {
        boolean onTouch(View view, MotionEvent motionEvent);
    }

    public SpenPreTouchListenerImpl(CoeditAdapter coeditAdapter) {
        if (coeditAdapter.isCoeditNote()) {
            CoeditTouchEventLocker coeditTouchEventLocker = new CoeditTouchEventLocker(coeditAdapter);
            this.mCoeditTouchEventLocker = coeditTouchEventLocker;
            addPreTouchListener(coeditTouchEventLocker);
        }
    }

    public void addPreTouchListener(PreTouchListener preTouchListener) {
        if (this.mPreTouchListenerList.contains(preTouchListener)) {
            return;
        }
        this.mPreTouchListenerList.add(preTouchListener);
    }

    public boolean isEnable() {
        return !this.mPreTouchListenerList.isEmpty();
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Iterator<PreTouchListener> it = this.mPreTouchListenerList.iterator();
        while (it.hasNext()) {
            if (it.next().onTouch(view, motionEvent)) {
                return true;
            }
        }
        return false;
    }

    public void release() {
        this.mPreTouchListenerList.clear();
        CoeditTouchEventLocker coeditTouchEventLocker = this.mCoeditTouchEventLocker;
        if (coeditTouchEventLocker != null) {
            coeditTouchEventLocker.release();
        }
    }

    public void removePreTouchListener(PreTouchListener preTouchListener) {
        this.mPreTouchListenerList.remove(preTouchListener);
    }
}
