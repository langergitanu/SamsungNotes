package com.samsung.android.support.senl.p148nt.composer.main.screenoff.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PowerManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/PowerManagerHandler;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "release", "", "requestGoToSleep", "millisecond", "", "requestStopGoToSleep", "MESSAGE_REQUEST_GO_TO_SLEEP", "HANDLER", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/PowerManagerHandler$MessageHandler;", "MessageHandler", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PowerManagerHandler {

    @NotNull
    private static final MessageHandler HANDLER;
    private static final int MESSAGE_REQUEST_GO_TO_SLEEP = 1;

    @NotNull
    public static final PowerManagerHandler INSTANCE = new PowerManagerHandler();

    @NotNull
    private static final String TAG = SOLogger.createTag("PowerManagerHandler");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/PowerManagerHandler$MessageHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "<init>", "(Landroid/os/Looper;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nPowerManagerHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PowerManagerHandler.kt\ncom/samsung/android/support/senl/nt/composer/main/screenoff/util/PowerManagerHandler$MessageHandler\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,47:1\n1#2:48\n*E\n"})
    public static final class MessageHandler extends Handler {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MessageHandler(@NotNull Looper looper) {
            super(looper);
            Intrinsics.checkNotNullParameter(looper, "looper");
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            Context applicationContext;
            Intrinsics.checkNotNullParameter(msg, "msg");
            super.handleMessage(msg);
            if (msg.what != 1 || (applicationContext = BaseUtils.getApplicationContext()) == null) {
                return;
            }
            PowerManagerCompat.INSTANCE.getInstance(applicationContext).goToSleep(SystemClock.uptimeMillis());
        }
    }

    static {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            looperMyLooper = Looper.getMainLooper();
        }
        Intrinsics.checkNotNull(looperMyLooper);
        HANDLER = new MessageHandler(looperMyLooper);
    }

    private PowerManagerHandler() {
    }

    public final void release() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "release#");
        HANDLER.removeMessages(1);
    }

    public final void requestGoToSleep(int millisecond) {
        AbstractC8014b.m7206h("requestGoToSleep# ", millisecond, SOLogger.INSTANCE, TAG);
        MessageHandler messageHandler = HANDLER;
        messageHandler.removeMessages(1);
        messageHandler.sendEmptyMessageDelayed(1, millisecond);
    }

    public final void requestStopGoToSleep() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "requestStopGoToSleep#");
        HANDLER.removeMessages(1);
    }
}
