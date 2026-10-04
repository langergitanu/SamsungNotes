package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.changedInfo.SpenObjectChangedInfo;
import com.samsung.android.sdk.pen.document.changedInfo.SpenObjectChangedTextInfo;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.common.ModelManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HyperTextUpdateController implements SpenWNote.ObjectEventListener {
    private static final int INPUT_DELAY = 1000;
    private static final String TAG = "HyperTextUpdateController";
    private ComposerModel mComposerModel;
    private Context mContext;
    private ControllerManager mControllerManager;
    private final CHandler mHandler = new CHandler(Looper.getMainLooper());
    private HyperTextUpdateHandler mHyperTextUpdateHandler;
    private boolean mIsBlocked;
    private NoteManager mNoteManager;
    private PageManager mPageManager;
    private int mPendingIndex;
    private TextManager mTextManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CHandler extends Handler {
        static final int MSG_START = 1;

        public CHandler(@NonNull Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what == 1) {
                AbstractC8014b.m7221w(new StringBuilder("start: "), HyperTextUpdateController.TAG, message.arg1);
                HyperTextUpdateController hyperTextUpdateController = HyperTextUpdateController.this;
                hyperTextUpdateController.parseHyperText(hyperTextUpdateController.mContext);
            }
        }
    }

    public void init(ComposerModel composerModel, ControllerManager controllerManager, ModelManager modelManager) {
        this.mNoteManager = modelManager.getNoteManager();
        this.mTextManager = modelManager.getTextManager();
        this.mPageManager = modelManager.getPageManager();
        this.mComposerModel = composerModel;
        this.mControllerManager = controllerManager;
        this.mIsBlocked = false;
        this.mPendingIndex = -1;
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
    public void onObjectAdded(SpenWPage spenWPage, ArrayList<SpenObjectBase> arrayList, int i) {
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
    public void onObjectChanged(SpenWPage spenWPage, SpenObjectChangedInfo spenObjectChangedInfo, int i) {
        if (spenObjectChangedInfo.type != 1) {
            return;
        }
        if (spenObjectChangedInfo instanceof SpenObjectChangedTextInfo) {
            onTextChanged((SpenObjectChangedTextInfo) spenObjectChangedInfo);
        } else {
            Logger.m11000e(TAG, "onObjectChanged: unexpected object type");
        }
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
    public void onObjectRemoved(SpenWPage spenWPage, ArrayList<SpenObjectBase> arrayList, int i) {
    }

    public void onTextChanged(SpenObjectChangedTextInfo spenObjectChangedTextInfo) {
        if (spenObjectChangedTextInfo.textChangedType == 1) {
            if (this.mIsBlocked) {
                Logger.m10999d(TAG, "onTextChanged# ignored by invalid status");
                this.mPendingIndex = spenObjectChangedTextInfo.index;
                this.mHandler.removeMessages(1);
            } else {
                stopParsingHyperText();
                Message messageObtain = Message.obtain(this.mHandler, 1, spenObjectChangedTextInfo.index, 0);
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(messageObtain, 1000L);
            }
        }
    }

    public void parseHyperText(Context context) {
        if (this.mHyperTextUpdateHandler != null || this.mComposerModel.getCoeditAdapter().isCoeditNote()) {
            AbstractC8014b.m7215q(new StringBuilder("parseHyperText# "), this.mHyperTextUpdateHandler != null, TAG);
            return;
        }
        HyperTextUpdateHandler hyperTextUpdateHandler = new HyperTextUpdateHandler(Looper.getMainLooper());
        this.mHyperTextUpdateHandler = hyperTextUpdateHandler;
        hyperTextUpdateHandler.init(context, this.mTextManager, this.mNoteManager.getNote(), this.mComposerModel, this.mControllerManager.getQuickSaveTimer());
        this.mHyperTextUpdateHandler.parseTextBox(this.mPageManager.getDocPageInfo().getCurrentPageIndex());
        this.mPageManager.getDocPageInfo().addPageIndexObserver(this.mHyperTextUpdateHandler);
    }

    public void release() {
        this.mHandler.removeCallbacksAndMessages(null);
        HyperTextUpdateHandler hyperTextUpdateHandler = this.mHyperTextUpdateHandler;
        if (hyperTextUpdateHandler != null) {
            hyperTextUpdateHandler.onDetachView();
        }
    }

    public void setBlock(boolean z) {
        AbstractC8014b.m7221w(AbstractC4539a.m3200j("setBlock# ", ", pendingIndex : ", z), TAG, this.mPendingIndex);
        this.mIsBlocked = z;
        if (z || this.mPendingIndex < 0) {
            return;
        }
        stopParsingHyperText();
        Message messageObtain = Message.obtain(this.mHandler, 1, this.mPendingIndex, 0);
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(messageObtain, 1000L);
        this.mPendingIndex = -1;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void stopParsingHyperText() {
        if (this.mHyperTextUpdateHandler == null) {
            return;
        }
        Logger.m10999d(TAG, "stopParsingHyperText#");
        this.mPageManager.getDocPageInfo().removePageIndexObserver(this.mHyperTextUpdateHandler);
        this.mHyperTextUpdateHandler.stop();
        this.mHyperTextUpdateHandler = null;
    }
}
