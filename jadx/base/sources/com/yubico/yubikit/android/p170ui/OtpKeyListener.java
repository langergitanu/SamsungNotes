package com.yubico.yubikit.android.p170ui;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.InputDevice;
import android.view.KeyEvent;
import p012C1.RunnableC0050f;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class OtpKeyListener {
    private static final int OTP_DELAY_MS = 1000;
    private static final int YUBICO_VID = 4176;
    private final OtpListener listener;
    private final SparseArray<StringBuilder> inputBuffers = new SparseArray<>();
    private final Handler handler = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OtpListener {
        void onCaptureComplete(String str);

        void onCaptureStarted();
    }

    public OtpKeyListener(OtpListener otpListener) {
        this.listener = otpListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onKeyEvent$0(int i) {
        StringBuilder sb = this.inputBuffers.get(i, new StringBuilder());
        if (sb.length() > 0) {
            this.listener.onCaptureComplete(sb.toString());
            this.inputBuffers.delete(i);
        }
    }

    public boolean onKeyEvent(KeyEvent keyEvent) {
        InputDevice device = keyEvent.getDevice();
        if (device == null || device.getVendorId() != 4176) {
            return false;
        }
        if (keyEvent.getAction() == 1) {
            int deviceId = keyEvent.getDeviceId();
            StringBuilder sb = this.inputBuffers.get(deviceId, new StringBuilder());
            if (keyEvent.getKeyCode() != 66 && keyEvent.getKeyCode() != 160) {
                if (sb.length() == 0) {
                    this.handler.postDelayed(new RunnableC0050f(this, deviceId, 26), 1000L);
                    this.listener.onCaptureStarted();
                }
                sb.append((char) keyEvent.getUnicodeChar());
                this.inputBuffers.put(deviceId, sb);
                return true;
            }
            this.listener.onCaptureComplete(sb.toString());
            this.inputBuffers.delete(deviceId);
        }
        return true;
    }
}
