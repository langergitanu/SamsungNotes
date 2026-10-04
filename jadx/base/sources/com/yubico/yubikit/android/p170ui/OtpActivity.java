package com.yubico.yubikit.android.p170ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.yubico.yubikit.android.C11888R;
import com.yubico.yubikit.android.p170ui.OtpKeyListener;
import com.yubico.yubikit.android.transport.nfc.NfcYubiKeyDevice;
import com.yubico.yubikit.android.transport.usb.UsbConfiguration;
import com.yubico.yubikit.android.transport.usb.UsbYubiKeyDevice;
import com.yubico.yubikit.core.YubiKeyDevice;
import com.yubico.yubikit.core.application.CommandState;
import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.NdefUtils;
import com.yubico.yubikit.core.util.Pair;
import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class OtpActivity extends YubiKeyPromptActivity {
    public static final String EXTRA_ERROR = "error";
    public static final String EXTRA_OTP = "otp";
    public static final int RESULT_ERROR = 1;
    private OtpKeyListener keyListener;
    private int usbSessionCounter = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class YubiKeyNdefAction extends YubiKeyPromptAction {
        @Override // com.yubico.yubikit.android.p170ui.YubiKeyPromptAction
        public void onYubiKey(YubiKeyDevice yubiKeyDevice, Bundle bundle, CommandState commandState, Callback<Pair<Integer, Intent>> callback) {
            if (yubiKeyDevice instanceof NfcYubiKeyDevice) {
                Intent intent = new Intent();
                try {
                    intent.putExtra(OtpActivity.EXTRA_OTP, NdefUtils.getNdefPayload(((NfcYubiKeyDevice) yubiKeyDevice).readNdef()));
                    callback.invoke(new Pair<>(-1, intent));
                } catch (IOException e) {
                    intent.putExtra("error", e);
                    callback.invoke(new Pair<>(1, intent));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0() {
        this.helpTextView.setText(isNfcEnabled() ? C11888R.string.yubikit_prompt_plug_in_or_tap : C11888R.string.yubikit_prompt_plug_in);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1() {
        int i = this.usbSessionCounter - 1;
        this.usbSessionCounter = i;
        if (i == 0) {
            runOnUiThread(new RunnableC11900a(this, 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2() {
        this.helpTextView.setText(C11888R.string.yubikit_otp_touch);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(UsbYubiKeyDevice usbYubiKeyDevice) {
        this.usbSessionCounter++;
        usbYubiKeyDevice.setOnClosed(new RunnableC11900a(this, 0));
        runOnUiThread(new RunnableC11900a(this, 1));
    }

    @Override // com.yubico.yubikit.android.p170ui.YubiKeyPromptActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        getIntent().putExtra(YubiKeyPromptActivity.ARG_ACTION_CLASS, YubiKeyNdefAction.class);
        getIntent().putExtra(YubiKeyPromptActivity.ARG_ALLOW_USB, false);
        super.onCreate(bundle);
        getYubiKitManager().startUsbDiscovery(new UsbConfiguration().handlePermissions(false), new C11903d(this, 2));
        this.keyListener = new OtpKeyListener(new OtpKeyListener.OtpListener() { // from class: com.yubico.yubikit.android.ui.OtpActivity.1
            @Override // com.yubico.yubikit.android.ui.OtpKeyListener.OtpListener
            public void onCaptureComplete(String str) {
                Intent intent = new Intent();
                intent.putExtra(OtpActivity.EXTRA_OTP, str);
                OtpActivity.this.setResult(-1, intent);
                OtpActivity.this.finish();
            }

            @Override // com.yubico.yubikit.android.ui.OtpKeyListener.OtpListener
            public void onCaptureStarted() {
                OtpActivity.this.helpTextView.setText(C11888R.string.yubikit_prompt_wait);
            }
        });
    }

    @Override // com.yubico.yubikit.android.p170ui.YubiKeyPromptActivity, android.app.Activity
    public void onDestroy() {
        getYubiKitManager().stopUsbDiscovery();
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.keyListener.onKeyEvent(keyEvent);
    }
}
