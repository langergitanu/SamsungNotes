package com.samsung.android.support.senl.p148nt.app.lock.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.Window;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p122b2.RunnableC4199v;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\n"}, m13886d2 = {"com/samsung/android/support/senl/nt/app/lock/utils/LockDialogUtils$showTimerDialog$timerTask$1", "Ljava/util/TimerTask;", "time", "", "getTime", "()I", "setTime", "(I)V", "run", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LockDialogUtils$showTimerDialog$timerTask$1 extends TimerTask {
    final /* synthetic */ Context $context;
    final /* synthetic */ AlertDialog $dialog;
    final /* synthetic */ Handler $mainHandler;
    final /* synthetic */ Timer $timer;
    private int time;

    public LockDialogUtils$showTimerDialog$timerTask$1(int i, Timer timer, AlertDialog alertDialog, Context context, Handler handler) {
        this.$timer = timer;
        this.$dialog = alertDialog;
        this.$context = context;
        this.$mainHandler = handler;
        this.time = i;
    }

    public final int getTime() {
        return this.time;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    @Override // java.util.TimerTask, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean z;
        if (this.time != 0) {
            Resources resources = this.$context.getResources();
            int i = C8003R.plurals.lock_out_dialog_message;
            int i2 = this.time;
            String quantityString = resources.getQuantityString(i, i2, Integer.valueOf(i2));
            Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
            this.$mainHandler.post(new RunnableC4199v(this.$dialog, quantityString, 20));
            this.time--;
            return;
        }
        this.$timer.cancel();
        if (this.$dialog.getWindow() != null) {
            Window window = this.$dialog.getWindow();
            Intrinsics.checkNotNull(window);
            z = window.getDecorView().isAttachedToWindow();
        }
        if (z) {
            this.$dialog.dismiss();
        }
        LockLogger.m7356d(LockDialogUtils.TAG, "run#, isAttached : " + z);
    }

    public final void setTime(int i) {
        this.time = i;
    }
}
