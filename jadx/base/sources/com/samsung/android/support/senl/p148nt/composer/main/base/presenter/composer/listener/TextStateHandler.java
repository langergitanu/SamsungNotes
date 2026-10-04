package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.handoff.HandoffHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TextStateHandler {
    static final int DELAY = 200;
    private CursorInfoHandler mCursorInfoHandler;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CursorInfoHandler extends Handler {
        static final int MSG_CURSOR = 1;
        static final int MSG_SELECTION = 2;
        private HandoffHandler mHandoffHandler;
        private ConcurrentLinkedQueue<Message> mMessageQueue = new ConcurrentLinkedQueue<>();
        private QuickSaveTimerController mQuickSaveTimerController;
        private TextManager mTextManager;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Param {
            int end;
            int start;
            SpenObjectShape textBox;

            public Param(SpenObjectShape spenObjectShape, int i, int i2) {
                this.textBox = spenObjectShape;
                this.start = i;
                this.end = i2;
            }
        }

        public CursorInfoHandler(TextManager textManager, QuickSaveTimerController quickSaveTimerController, HandoffHandler handoffHandler) {
            this.mTextManager = textManager;
            this.mQuickSaveTimerController = quickSaveTimerController;
            this.mHandoffHandler = handoffHandler;
        }

        public void clearInnerQueue() {
            this.mMessageQueue.clear();
        }

        public void consumeAllMessages() {
            for (Message message : this.mMessageQueue) {
                handleMessage(message);
                removeMessages(message.what);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            this.mMessageQueue.remove(message);
            Param param = (Param) message.obj;
            if (param == null) {
                return;
            }
            int i = message.what;
            if (i == 1) {
                this.mTextManager.updateRichTextStateWithCursor(param.textBox, param.start);
                this.mHandoffHandler.sendHandoffData();
                this.mQuickSaveTimerController.unLock("textCursor");
            } else {
                if (i != 2) {
                    return;
                }
                this.mTextManager.updateRichTextStateWithSelection(param.textBox, param.start, param.end);
                this.mQuickSaveTimerController.unLock("textCursor");
            }
        }

        public void updateMessagesInnerQueue(@NonNull Message message) {
            Iterator<Message> it = this.mMessageQueue.iterator();
            while (it.hasNext()) {
                removeMessages(it.next().what);
            }
            this.mMessageQueue.clear();
            this.mMessageQueue.add(message);
        }
    }

    public TextStateHandler(TextManager textManager, QuickSaveTimerController quickSaveTimerController, HandoffHandler handoffHandler) {
        this.mCursorInfoHandler = new CursorInfoHandler(textManager, quickSaveTimerController, handoffHandler);
    }

    public void consumeAllMessages() {
        this.mCursorInfoHandler.consumeAllMessages();
    }

    public void release() {
        this.mCursorInfoHandler.clearInnerQueue();
        this.mCursorInfoHandler.removeMessages(1);
        this.mCursorInfoHandler.removeMessages(2);
    }

    public void sendMessageDelayed(SpenObjectShape spenObjectShape, int i, int i2) {
        Message messageObtainMessage = this.mCursorInfoHandler.obtainMessage(i == i2 ? 1 : 2, new CursorInfoHandler.Param(spenObjectShape, i, i2));
        this.mCursorInfoHandler.updateMessagesInnerQueue(messageObtainMessage);
        this.mCursorInfoHandler.removeMessages(messageObtainMessage.what);
        this.mCursorInfoHandler.sendMessageDelayed(messageObtainMessage, 200L);
    }
}
