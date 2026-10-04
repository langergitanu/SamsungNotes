package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.listener;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.samsung.android.sdk.pen.text.SpenCursorChangedListener;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmControlManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmQuickSaveControl;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.text.SmTextManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0006\u0010\u000f\u001a\u00020\u000bR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/CursorChangedListenerImpl;", "Lcom/samsung/android/sdk/pen/text/SpenCursorChangedListener;", "smControlManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;)V", "quickSaveControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmQuickSaveControl;", "cursorInfoHandler", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/CursorChangedListenerImpl$CursorInfoHandler;", "onChanged", "", "startPos", "", "endPos", "release", "CursorInfoHandler", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CursorChangedListenerImpl extends SpenCursorChangedListener {
    public static final long DELAY = 200;
    public static final int MSG_CURSOR = 1;
    public static final int MSG_SELECTION = 2;

    @NotNull
    public static final String QUICK_SAVE_TAG = "SmTextCursor";

    @NotNull
    private final CursorInfoHandler cursorInfoHandler;

    @Nullable
    private SmQuickSaveControl quickSaveControl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0006\u0010\u000e\u001a\u00020\u000bR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/CursorChangedListenerImpl$CursorInfoHandler;", "Landroid/os/Handler;", "smControlManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;)V", "quickSaveControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmQuickSaveControl;", "textManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;", "handleMessage", "", "msg", "Landroid/os/Message;", "release", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class CursorInfoHandler extends Handler {

        @Nullable
        private SmQuickSaveControl quickSaveControl;

        @NotNull
        private final SmTextManager textManager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CursorInfoHandler(@NotNull SmControlManager smControlManager) {
            super(Looper.getMainLooper());
            Intrinsics.checkNotNullParameter(smControlManager, "smControlManager");
            this.quickSaveControl = smControlManager.getQuickSaveControl();
            this.textManager = smControlManager.getTextManager();
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            int i = msg.what;
            if (i == 1) {
                SmTextManager smTextManager = this.textManager;
                Object obj = msg.obj;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                smTextManager.updateSpanStateCursor(((Integer) obj).intValue());
            } else if (i == 2) {
                this.textManager.updateSpanStateSelection(msg.arg1, msg.arg2);
            }
            SmQuickSaveControl smQuickSaveControl = this.quickSaveControl;
            if (smQuickSaveControl != null) {
                smQuickSaveControl.unlock(CursorChangedListenerImpl.QUICK_SAVE_TAG);
            }
        }

        public final void release() {
            this.quickSaveControl = null;
        }
    }

    public CursorChangedListenerImpl(@NotNull SmControlManager smControlManager) {
        Intrinsics.checkNotNullParameter(smControlManager, "smControlManager");
        this.quickSaveControl = smControlManager.getQuickSaveControl();
        this.cursorInfoHandler = new CursorInfoHandler(smControlManager);
    }

    @Override // com.samsung.android.sdk.pen.text.SpenCursorChangedListener
    public void onChanged(int startPos, int endPos) {
        if (startPos == -1 || endPos == -1) {
            return;
        }
        this.cursorInfoHandler.removeMessages(1);
        this.cursorInfoHandler.removeMessages(2);
        Message messageObtainMessage = startPos == endPos ? this.cursorInfoHandler.obtainMessage(1, Integer.valueOf(startPos)) : this.cursorInfoHandler.obtainMessage(2, startPos, endPos);
        Intrinsics.checkNotNull(messageObtainMessage);
        this.cursorInfoHandler.sendMessageDelayed(messageObtainMessage, 200L);
        SmQuickSaveControl smQuickSaveControl = this.quickSaveControl;
        if (smQuickSaveControl != null) {
            smQuickSaveControl.lock(QUICK_SAVE_TAG);
        }
    }

    public final void release() {
        this.quickSaveControl = null;
    }
}
