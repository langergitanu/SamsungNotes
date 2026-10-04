package com.yubico.yubikit.android.p170ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.RunnableC10960a;
import com.yubico.yubikit.android.C11888R;
import com.yubico.yubikit.android.YubiKitManager;
import com.yubico.yubikit.android.transport.nfc.NfcConfiguration;
import com.yubico.yubikit.android.transport.nfc.NfcNotAvailable;
import com.yubico.yubikit.android.transport.nfc.NfcYubiKeyDevice;
import com.yubico.yubikit.android.transport.nfc.NfcYubiKeyManager;
import com.yubico.yubikit.android.transport.usb.UsbConfiguration;
import com.yubico.yubikit.android.transport.usb.UsbYubiKeyDevice;
import com.yubico.yubikit.core.YubiKeyDevice;
import com.yubico.yubikit.core.application.CommandState;
import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Pair;
import java.util.Objects;
import javax.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class YubiKeyPromptActivity extends Activity {
    public static final String ARG_ACTION_CLASS = "ACTION_CLASS";
    public static final String ARG_ALLOW_NFC = "ALLOW_NFC";
    public static final String ARG_ALLOW_USB = "ALLOW_USB";
    public static final String ARG_CANCEL_BUTTON_ID = "CANCEL_BUTTON_ID";
    public static final String ARG_CONTENT_VIEW_ID = "CONTENT_VIEW_ID";
    public static final String ARG_ENABLE_NFC_BUTTON_ID = "ENABLE_NFC_BUTTON_ID";
    public static final String ARG_HELP_TEXT_VIEW_ID = "HELP_TEXT_VIEW_ID";
    public static final String ARG_TITLE_ID = "TITLE_ID";
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) YubiKeyPromptActivity.class);
    private YubiKeyPromptAction action;
    private boolean allowNfc;
    private boolean allowUsb;
    protected Button cancelButton;
    protected Button enableNfcButton;
    protected TextView helpTextView;
    private YubiKitManager yubiKit;
    private final MyCommandState commandState = new MyCommandState();
    private boolean hasNfc = true;
    private int usbSessionCounter = 0;
    private boolean isDone = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class MyCommandState extends CommandState {
        boolean awaitingTouch;

        private MyCommandState() {
            this.awaitingTouch = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onKeepAliveStatus$0() {
            YubiKeyPromptActivity.this.helpTextView.setText(C11888R.string.yubikit_prompt_uv);
        }

        @Override // com.yubico.yubikit.core.application.CommandState
        public void onKeepAliveStatus(byte b) {
            if (this.awaitingTouch || b != 2) {
                return;
            }
            this.awaitingTouch = true;
            YubiKeyPromptActivity.this.runOnUiThread(new RunnableC11900a(this, 3));
        }
    }

    public static Intent createIntent(Context context, Class<? extends YubiKeyPromptAction> cls, @StringRes int i) {
        Intent intentCreateIntent = createIntent(context, cls);
        intentCreateIntent.putExtra(ARG_TITLE_ID, i);
        return intentCreateIntent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishIfDone() {
        if (this.isDone) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        this.commandState.cancel();
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3() {
        this.helpTextView.setText(this.hasNfc ? C11888R.string.yubikit_prompt_plug_in_or_tap : C11888R.string.yubikit_prompt_plug_in);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4() {
        int i = this.usbSessionCounter - 1;
        this.usbSessionCounter = i;
        if (i == 0) {
            runOnUiThread(new RunnableC11901b(this, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5() {
        this.helpTextView.setText(C11888R.string.yubikit_prompt_wait);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(UsbYubiKeyDevice usbYubiKeyDevice) {
        this.usbSessionCounter++;
        usbYubiKeyDevice.setOnClosed(new RunnableC11901b(this, 1));
        runOnUiThread(new RunnableC11901b(this, 2));
        onYubiKeyDevice(usbYubiKeyDevice, new RunnableC11901b(this, 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$7(View view) {
        startActivity(new Intent(NfcYubiKeyManager.NFC_SETTINGS_ACTION));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$10(NfcYubiKeyDevice nfcYubiKeyDevice) {
        onYubiKeyDevice(nfcYubiKeyDevice, new RunnableC10960a(this, nfcYubiKeyDevice, 21));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$8() {
        this.helpTextView.setText(C11888R.string.yubikit_prompt_remove);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$9(NfcYubiKeyDevice nfcYubiKeyDevice) {
        runOnUiThread(new RunnableC11901b(this, 4));
        nfcYubiKeyDevice.remove(new RunnableC11901b(this, 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onYubiKeyDevice$0() {
        this.helpTextView.setText(this.hasNfc ? C11888R.string.yubikit_prompt_plug_in_or_tap : C11888R.string.yubikit_prompt_plug_in);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onYubiKeyDevice$1(Runnable runnable, Pair pair) {
        if (((Integer) pair.first).intValue() != 101) {
            provideResult(((Integer) pair.first).intValue(), (Intent) pair.second);
        } else if (this.commandState.awaitingTouch) {
            runOnUiThread(new RunnableC11901b(this, 3));
            this.commandState.awaitingTouch = false;
        }
        runnable.run();
    }

    public CommandState getCommandState() {
        return this.commandState;
    }

    public YubiKitManager getYubiKitManager() {
        return this.yubiKit;
    }

    public boolean isNfcEnabled() {
        return this.hasNfc;
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        Objects.requireNonNull(extras);
        this.allowUsb = extras.getBoolean(ARG_ALLOW_USB, true);
        this.allowNfc = extras.getBoolean(ARG_ALLOW_NFC, true);
        Class cls = (Class) extras.getSerializable(ARG_ACTION_CLASS);
        if (cls != null) {
            try {
            } catch (IllegalAccessException e) {
                e = e;
                com.yubico.yubikit.core.internal.Logger.error(logger, "Unable to instantiate ConnectionAction", e);
                finish();
            } catch (IllegalStateException e2) {
                e = e2;
                com.yubico.yubikit.core.internal.Logger.error(logger, "Unable to instantiate ConnectionAction", e);
                finish();
            } catch (InstantiationException e3) {
                e = e3;
                com.yubico.yubikit.core.internal.Logger.error(logger, "Unable to instantiate ConnectionAction", e);
                finish();
            }
            if (YubiKeyPromptAction.class.isAssignableFrom(cls)) {
                this.action = (YubiKeyPromptAction) cls.newInstance();
                setContentView(extras.getInt(ARG_CONTENT_VIEW_ID, C11888R.layout.yubikit_yubikey_prompt_content));
                if (extras.containsKey(ARG_TITLE_ID)) {
                    setTitle(extras.getInt(ARG_TITLE_ID));
                }
                TextView textView = (TextView) findViewById(C11888R.id.yubikit_prompt_title);
                if (textView != null) {
                    textView.setText(getTitle());
                }
                this.helpTextView = (TextView) findViewById(extras.getInt(ARG_HELP_TEXT_VIEW_ID, C11888R.id.yubikit_prompt_help_text_view));
                Button button = (Button) findViewById(extras.getInt(ARG_CANCEL_BUTTON_ID, C11888R.id.yubikit_prompt_cancel_btn));
                this.cancelButton = button;
                button.setFocusable(false);
                final int i = 0;
                this.cancelButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.yubico.yubikit.android.ui.c

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ YubiKeyPromptActivity f8436b;

                    {
                        this.f8436b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        switch (i) {
                            case 0:
                                this.f8436b.lambda$onCreate$2(view);
                                break;
                            default:
                                this.f8436b.lambda$onCreate$7(view);
                                break;
                        }
                    }
                });
                YubiKitManager yubiKitManager = new YubiKitManager(this);
                this.yubiKit = yubiKitManager;
                if (this.allowUsb) {
                    yubiKitManager.startUsbDiscovery(new UsbConfiguration(), new C11903d(this, 0));
                }
                if (this.allowNfc) {
                    Button button2 = (Button) findViewById(extras.getInt(ARG_ENABLE_NFC_BUTTON_ID, C11888R.id.yubikit_prompt_enable_nfc_btn));
                    this.enableNfcButton = button2;
                    button2.setFocusable(false);
                    final int i2 = 1;
                    this.enableNfcButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.yubico.yubikit.android.ui.c

                        /* JADX INFO: renamed from: b */
                        public final /* synthetic */ YubiKeyPromptActivity f8436b;

                        {
                            this.f8436b = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            switch (i2) {
                                case 0:
                                    this.f8436b.lambda$onCreate$2(view);
                                    break;
                                default:
                                    this.f8436b.lambda$onCreate$7(view);
                                    break;
                            }
                        }
                    });
                    return;
                }
                return;
            }
        }
        throw new IllegalStateException("Missing or invalid ConnectionAction class");
    }

    @Override // android.app.Activity
    public void onDestroy() {
        if (this.allowUsb) {
            this.yubiKit.stopUsbDiscovery();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        if (this.allowNfc) {
            this.yubiKit.stopNfcDiscovery(this);
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.allowNfc) {
            this.enableNfcButton.setVisibility(8);
            try {
                this.yubiKit.startNfcDiscovery(new NfcConfiguration(), this, new C11903d(this, 1));
            } catch (NfcNotAvailable e) {
                this.hasNfc = false;
                this.helpTextView.setText(C11888R.string.yubikit_prompt_plug_in);
                if (e.isDisabled()) {
                    this.enableNfcButton.setVisibility(0);
                }
            }
        }
    }

    public void onYubiKeyDevice(YubiKeyDevice yubiKeyDevice, final Runnable runnable) {
        this.action.onYubiKey(yubiKeyDevice, getIntent().getExtras(), this.commandState, new Callback() { // from class: com.yubico.yubikit.android.ui.e
            @Override // com.yubico.yubikit.core.util.Callback
            public final void invoke(Object obj) {
                this.f8439a.lambda$onYubiKeyDevice$1(runnable, (Pair) obj);
            }
        });
    }

    public void provideResult(int i, Intent intent) {
        setResult(i, intent);
        this.isDone = true;
    }

    public static Intent createIntent(Context context, Class<? extends YubiKeyPromptAction> cls) {
        Intent intent = new Intent(context, (Class<?>) YubiKeyPromptActivity.class);
        intent.putExtra(ARG_ACTION_CLASS, cls);
        return intent;
    }
}
