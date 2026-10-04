package com.samsung.android.sdk.composer.voice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0002\u0013\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0006\u0010\u000f\u001a\u00020\nJ\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/voice/BluetoothScoIntentReceiver;", "Landroid/content/BroadcastReceiver;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/composer/voice/BluetoothScoStateListener;", "<init>", "(Lcom/samsung/android/sdk/composer/voice/BluetoothScoStateListener;)V", "mListener", "mHandler", "Lcom/samsung/android/sdk/composer/voice/BluetoothScoIntentReceiver$BluetoothScoStateHandler;", "onReceive", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "close", "sendMessage", "state", "", "BluetoothScoStateHandler", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class BluetoothScoIntentReceiver extends BroadcastReceiver {
    private static final int MESSAGE_CODE = 2019;
    private static final long MESSAGE_DELAYED_TIME = 100;

    @NotNull
    private static final String TAG = "BluetoothScoIntentReceiver";

    @NotNull
    private BluetoothScoStateHandler mHandler;

    @NotNull
    private BluetoothScoStateListener mListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/voice/BluetoothScoIntentReceiver$BluetoothScoStateHandler;", "Landroid/os/Handler;", "<init>", "(Lcom/samsung/android/sdk/composer/voice/BluetoothScoIntentReceiver;)V", "mState", "", "setState", "", "state", "handleMessage", "msg", "Landroid/os/Message;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class BluetoothScoStateHandler extends Handler {
        private int mState = -1;

        public BluetoothScoStateHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            AbstractC0541b.m755A(this.mState, "handleMessage() state: ", BluetoothScoIntentReceiver.TAG);
            int i = this.mState;
            if (i == 12) {
                BluetoothScoIntentReceiver.this.mListener.onScoAudioConnected();
            } else if (i == 10) {
                BluetoothScoIntentReceiver.this.mListener.onScoAudioDisconnected();
            }
        }

        public final void setState(int state) {
            this.mState = state;
        }
    }

    public BluetoothScoIntentReceiver(@NotNull BluetoothScoStateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListener = listener;
        this.mHandler = new BluetoothScoStateHandler();
    }

    private final void sendMessage(int state) {
        this.mHandler.setState(state);
        this.mHandler.removeMessages(MESSAGE_CODE);
        this.mHandler.sendEmptyMessageDelayed(MESSAGE_CODE, 100L);
    }

    public final void close() {
        this.mHandler.removeMessages(MESSAGE_CODE);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        String action;
        if (context == null || intent == null || (action = intent.getAction()) == null) {
            return;
        }
        if (!Intrinsics.areEqual(action, "android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) {
            if (Intrinsics.areEqual(action, "android.media.ACTION_SCO_AUDIO_STATE_UPDATED") && intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1) == -1) {
                Log.d(TAG, "onReceive() SCO_AUDIO_STATE_ERROR");
                this.mListener.onScoAudioError();
                return;
            }
            return;
        }
        int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
        AbstractC0541b.m755A(intExtra, "onReceive() profileState: ", TAG);
        if (intExtra == 10 || intExtra == 12) {
            sendMessage(intExtra);
        }
    }
}
