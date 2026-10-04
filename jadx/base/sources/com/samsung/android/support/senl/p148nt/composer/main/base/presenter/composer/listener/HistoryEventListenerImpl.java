package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.os.Handler;
import android.os.Looper;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HistoryEventListenerImpl {
    private static final String TAG = Logger.createTag("HistoryEventListenerImpl");
    private SpenWNote.HistoryEventListener mHistoryEventListener;
    private Runnable mObjectChangedRunnable;
    private Runnable mObjectOnRedoable;
    private Runnable mObjectOnUndoable;
    private OnCommitListener mOnCommitListener;
    private SpenWNote mSpenWNote;
    private UndoRedoListener mUndoRedoListener;
    private Handler mHandler = new Handler();
    private List<HistoryEventBridgeListener> mBridgeListeners = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface HistoryEventBridgeListener {
        void onUndoable(SpenWNote spenWNote, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnCommitListener {
        void onCommit();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface UndoRedoListener {
        void onObjectChanged();

        void onRedoable(boolean z);

        void onUndoable(boolean z);
    }

    public HistoryEventListenerImpl(SpenWNote spenWNote) {
        this.mSpenWNote = spenWNote;
    }

    private void makeHistoryEventListener(final UndoRedoListener undoRedoListener) {
        Logger.m10999d(TAG, "makeHistoryEventListener");
        this.mUndoRedoListener = undoRedoListener;
        this.mObjectChangedRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.HistoryEventListenerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                UndoRedoListener undoRedoListener2 = undoRedoListener;
                if (undoRedoListener2 != null) {
                    undoRedoListener2.onObjectChanged();
                }
            }
        };
        this.mObjectOnUndoable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.HistoryEventListenerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                UndoRedoListener undoRedoListener2 = undoRedoListener;
                if (undoRedoListener2 != null) {
                    undoRedoListener2.onUndoable(HistoryEventListenerImpl.this.mSpenWNote.isUndoable());
                }
            }
        };
        this.mObjectOnRedoable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.HistoryEventListenerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                UndoRedoListener undoRedoListener2 = undoRedoListener;
                if (undoRedoListener2 != null) {
                    undoRedoListener2.onRedoable(HistoryEventListenerImpl.this.mSpenWNote.isRedoable());
                }
            }
        };
        this.mHistoryEventListener = new SpenWNote.HistoryEventListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.HistoryEventListenerImpl.4
            @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.HistoryEventListener
            public void onCommit(SpenWNote spenWNote) {
                if (HistoryEventListenerImpl.this.mOnCommitListener != null) {
                    HistoryEventListenerImpl.this.mOnCommitListener.onCommit();
                }
            }

            @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.HistoryEventListener
            public void onPreSubmit(SpenWNote spenWNote, SpenObjectBase spenObjectBase, int i, int i2, int i4) {
            }

            @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.HistoryEventListener
            public void onRedo(SpenWNote spenWNote) {
                Logger.m10999d(HistoryEventListenerImpl.TAG, "onRedo");
                if (HistoryEventListenerImpl.this.mHandler != null) {
                    HistoryEventListenerImpl.this.mHandler.post(HistoryEventListenerImpl.this.mObjectChangedRunnable);
                }
            }

            @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.HistoryEventListener
            public void onRedoable(SpenWNote spenWNote, boolean z) {
                AbstractC8014b.m7220v("onRedoable : ", HistoryEventListenerImpl.TAG, z);
                HistoryEventListenerImpl historyEventListenerImpl = HistoryEventListenerImpl.this;
                historyEventListenerImpl.update(historyEventListenerImpl.mObjectOnRedoable);
            }

            @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.HistoryEventListener
            public void onUndo(SpenWNote spenWNote) {
                Logger.m10999d(HistoryEventListenerImpl.TAG, "onUndo");
                if (HistoryEventListenerImpl.this.mHandler != null) {
                    HistoryEventListenerImpl.this.mHandler.post(HistoryEventListenerImpl.this.mObjectChangedRunnable);
                }
            }

            @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.HistoryEventListener
            public void onUndoable(SpenWNote spenWNote, boolean z) {
                AbstractC8014b.m7220v("onUndoable : ", HistoryEventListenerImpl.TAG, z);
                HistoryEventListenerImpl historyEventListenerImpl = HistoryEventListenerImpl.this;
                historyEventListenerImpl.update(historyEventListenerImpl.mObjectOnUndoable);
                Iterator it = HistoryEventListenerImpl.this.mBridgeListeners.iterator();
                while (it.hasNext()) {
                    ((HistoryEventBridgeListener) it.next()).onUndoable(spenWNote, z);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
            return;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public void addBridgeListener(HistoryEventBridgeListener historyEventBridgeListener) {
        List<HistoryEventBridgeListener> list = this.mBridgeListeners;
        if (list != null) {
            list.add(historyEventBridgeListener);
        }
    }

    public void notifyClearedHistory() {
        SpenWNote.HistoryEventListener historyEventListener = this.mHistoryEventListener;
        if (historyEventListener != null) {
            historyEventListener.onUndoable(null, false);
        }
    }

    public void registerHistoryEventListener(UndoRedoListener undoRedoListener) {
        if (this.mSpenWNote == null) {
            Logger.m10999d(TAG, "registerHistoryEventListener mSpenWNote is null");
            return;
        }
        String str = TAG;
        Logger.m10999d(str, "registerHistoryEventListener");
        UndoRedoListener undoRedoListener2 = this.mUndoRedoListener;
        if (undoRedoListener2 == null || !undoRedoListener2.equals(undoRedoListener)) {
            releaseHistoryEventListener(this.mUndoRedoListener);
            makeHistoryEventListener(undoRedoListener);
            this.mSpenWNote.registerHistoryEventListener(this.mHistoryEventListener);
            Logger.m10999d(str, "HistoryEventListenerImplTest 1: " + this.mHistoryEventListener.hashCode());
        }
        if (undoRedoListener != null) {
            undoRedoListener.onUndoable(this.mSpenWNote.isUndoable());
            undoRedoListener.onRedoable(this.mSpenWNote.isRedoable());
        }
    }

    public void release() {
        if (this.mHandler != null) {
            releaseHistoryEventListener(this.mUndoRedoListener);
            this.mHandler = null;
            this.mSpenWNote = null;
            this.mBridgeListeners = null;
        }
        this.mOnCommitListener = null;
    }

    public void releaseHistoryEventListener(UndoRedoListener undoRedoListener) {
        UndoRedoListener undoRedoListener2;
        if (this.mHistoryEventListener == null || (undoRedoListener2 = this.mUndoRedoListener) == null || !undoRedoListener2.equals(undoRedoListener)) {
            return;
        }
        String str = TAG;
        Logger.m10999d(str, "releaseHistoryEventListener");
        SpenWNote spenWNote = this.mSpenWNote;
        if (spenWNote != null && !spenWNote.isClosed()) {
            Logger.m10999d(str, "HistoryEventListenerImplTest 3: " + this.mHistoryEventListener.hashCode());
            this.mSpenWNote.deregisterHistoryEventListener(this.mHistoryEventListener);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHistoryEventListener = null;
        this.mUndoRedoListener = null;
        this.mObjectChangedRunnable = null;
        this.mObjectOnUndoable = null;
        this.mObjectOnRedoable = null;
    }

    public void removeBridgeListener(HistoryEventBridgeListener historyEventBridgeListener) {
        List<HistoryEventBridgeListener> list = this.mBridgeListeners;
        if (list != null) {
            list.remove(historyEventBridgeListener);
        }
    }

    public void setOnCommitListener(OnCommitListener onCommitListener) {
        this.mOnCommitListener = onCommitListener;
    }
}
