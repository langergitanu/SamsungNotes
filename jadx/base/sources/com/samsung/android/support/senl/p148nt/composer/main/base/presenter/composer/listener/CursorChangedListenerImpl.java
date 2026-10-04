package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.text.SpenCursorChangedListener;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CursorChangedListenerImpl extends SpenCursorChangedListener {
    private static final String TAG = Logger.createTag("CursorChangedListenerImpl");
    private long mLastLogTime;
    private QuickSaveTimerController mQuickSaveTimerController;
    private SpenCursorChangedListener mSubCursorChangedListener;
    private TextManager mTextManager;
    private TextSelectionChangedListener mTextSelectionChangedListener;
    private TextStateHandler mTextStateHandler;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TextSelectionChangedListener {
        void onChanged(int i, int i2);
    }

    public CursorChangedListenerImpl(ListenerImplContract.IPresenter iPresenter, QuickSaveTimerController quickSaveTimerController, TextStateHandler textStateHandler) {
        this.mTextManager = iPresenter.getTextManager();
        this.mQuickSaveTimerController = quickSaveTimerController;
        this.mTextStateHandler = textStateHandler;
    }

    private void printLogForSelection(int i, int i2) {
        SpenObjectShape textBox;
        int i4 = i2 - i;
        if (Math.abs(i4) <= 500) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.mLastLogTime + 10000 >= jCurrentTimeMillis || (textBox = this.mTextManager.getTextBox()) == null || textBox.getText() == null) {
            return;
        }
        this.mLastLogTime = jCurrentTimeMillis;
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i4, i, "selectText# len= ", " / st= ", " / end= ");
        sbM1173s.append(i2);
        sbM1173s.append(", backtrace: ");
        sbM1173s.append(CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        Logger.m11002f(str, sbM1173s.toString());
    }

    public void consumeAllMessages() {
        this.mTextStateHandler.consumeAllMessages();
    }

    @Override // com.samsung.android.sdk.pen.text.SpenCursorChangedListener
    public void onChanged(int i, int i2) {
        AbstractC8014b.m7216r(i, i2, "onChanged ", " ", TAG);
        TextSelectionChangedListener textSelectionChangedListener = this.mTextSelectionChangedListener;
        if (textSelectionChangedListener != null) {
            textSelectionChangedListener.onChanged(i, i2);
        }
        SpenCursorChangedListener spenCursorChangedListener = this.mSubCursorChangedListener;
        if (spenCursorChangedListener != null) {
            spenCursorChangedListener.onChanged(i, i2);
        }
        if (i != -1 && i2 != -1) {
            this.mTextStateHandler.sendMessageDelayed(this.mTextManager.getTextBox(), i, i2);
            this.mQuickSaveTimerController.lock("textCursor");
        }
        printLogForSelection(i, i2);
    }

    public void release() {
        this.mTextStateHandler.release();
    }

    public void setCursorChangedListener(SpenCursorChangedListener spenCursorChangedListener) {
        this.mSubCursorChangedListener = spenCursorChangedListener;
    }

    public void setTextSelectionChangedListener(TextSelectionChangedListener textSelectionChangedListener) {
        this.mTextSelectionChangedListener = textSelectionChangedListener;
    }
}
