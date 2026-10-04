package androidx.biometric;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"SyntheticAccessor"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class DeviceCredentialHandlerActivity extends AppCompatActivity {
    static final String EXTRA_PROMPT_INFO_BUNDLE = "prompt_info_bundle";
    private static final String KEY_DID_CHANGE_CONFIGURATION = "did_change_configuration";
    private static final String TAG = "DeviceCredentialHandler";
    private boolean mDidChangeConfiguration;

    public void handleDeviceCredentialResult(int i) {
        DeviceCredentialHandlerBridge instanceIfNotNull = DeviceCredentialHandlerBridge.getInstanceIfNotNull();
        if (instanceIfNotNull == null) {
            Log.e(TAG, "onActivityResult: Bridge or callback was null!");
        } else if (i == -1) {
            instanceIfNotNull.setDeviceCredentialResult(1);
            instanceIfNotNull.setConfirmingDeviceCredential(false);
            instanceIfNotNull.startIgnoringReset();
        } else {
            instanceIfNotNull.setDeviceCredentialResult(2);
            instanceIfNotNull.setConfirmingDeviceCredential(false);
            instanceIfNotNull.startIgnoringReset();
        }
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        handleDeviceCredentialResult(i2);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        DeviceCredentialHandlerBridge deviceCredentialHandlerBridge = DeviceCredentialHandlerBridge.getInstance();
        if (deviceCredentialHandlerBridge.getClientThemeResId() != 0) {
            setTheme(deviceCredentialHandlerBridge.getClientThemeResId());
            getTheme().applyStyle(C0595R.style.TransparentStyle, true);
        }
        super.onCreate(bundle);
        boolean z = bundle != null && bundle.getBoolean(KEY_DID_CHANGE_CONFIGURATION, false);
        this.mDidChangeConfiguration = z;
        if (z) {
            this.mDidChangeConfiguration = false;
        } else {
            deviceCredentialHandlerBridge.stopIgnoringReset();
        }
        setTitle((CharSequence) null);
        setContentView(C0595R.layout.device_credential_handler_activity);
        if (deviceCredentialHandlerBridge.getExecutor() != null && deviceCredentialHandlerBridge.getAuthenticationCallback() != null) {
            new BiometricPrompt(this, deviceCredentialHandlerBridge.getExecutor(), deviceCredentialHandlerBridge.getAuthenticationCallback()).authenticate(new BiometricPrompt.PromptInfo(getIntent().getBundleExtra(EXTRA_PROMPT_INFO_BUNDLE)));
        } else {
            Log.e(TAG, "onCreate: Executor and/or callback was null!");
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        DeviceCredentialHandlerBridge instanceIfNotNull = DeviceCredentialHandlerBridge.getInstanceIfNotNull();
        if (!isChangingConfigurations() || instanceIfNotNull == null) {
            return;
        }
        instanceIfNotNull.ignoreNextReset();
        this.mDidChangeConfiguration = true;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(KEY_DID_CHANGE_CONFIGURATION, this.mDidChangeConfiguration);
    }
}
