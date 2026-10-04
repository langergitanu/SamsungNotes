package com.microsoft.identity.common.internal.broker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.PropertyBagUtil;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ported.LocalBroadcaster;
import com.microsoft.identity.common.java.util.ported.PropertyBag;
import p017D1.C0061b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class InstallCertActivityLauncher extends AppCompatActivity {
    private static final String CERT_INSTALLATION_FAILED_WITH_EMPTY_RESPONSE = "Certificate installation failed with an empty response";
    private static final String INSTALL_CERT_BROADCAST_ALIAS = "install_cert_broadcast_alias";
    private static final String INSTALL_CERT_INTENT = "install_cert_intent";
    private static final String INSTALL_CERT_INTENT_STARTED = "broker_intent_started";
    private static final String TAG = "InstallCertActivityLauncher";
    final ActivityResultLauncher<Intent> installCertActivityResultLauncher;
    private Intent mInstallCertificateIntent;
    private Boolean mInstallCertificateIntentStarted;
    private Boolean mInstallCertificateResultReceived;

    public InstallCertActivityLauncher() {
        Boolean bool = Boolean.FALSE;
        this.mInstallCertificateIntentStarted = bool;
        this.mInstallCertificateResultReceived = bool;
        this.installCertActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0061b(this, 18));
    }

    public static void installCertificate(@NonNull Activity activity, @NonNull Intent intent, @NonNull IInstallCertCallback iInstallCertCallback, @NonNull String str, @NonNull String str2) {
        Intent intent2 = new Intent(activity, (Class<?>) InstallCertActivityLauncher.class);
        intent2.putExtra(INSTALL_CERT_INTENT, intent);
        registerCallbackAndParseResult(iInstallCertCallback, str, str2);
        activity.startActivity(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(ActivityResult activityResult) {
        PropertyBag propertyBag;
        String strM1170p = AbstractC0622a.m1170p(TAG, "#installCertActivityResultLauncher", new StringBuilder());
        Logger.info(strM1170p, "Result received from Broker, Result code: " + activityResult.getResultCode());
        Intent data = activityResult.getData();
        if (data == null || data.getExtras() == null) {
            Logger.error(strM1170p, CERT_INSTALLATION_FAILED_WITH_EMPTY_RESPONSE, null);
            propertyBag = new PropertyBag();
        } else {
            propertyBag = PropertyBagUtil.fromBundle(data.getExtras());
        }
        this.mInstallCertificateResultReceived = Boolean.TRUE;
        LocalBroadcaster.INSTANCE.broadcast(INSTALL_CERT_BROADCAST_ALIAS, propertyBag);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$registerCallbackAndParseResult$1(String str, String str2, IInstallCertCallback iInstallCertCallback, PropertyBag propertyBag) {
        String str3 = (String) propertyBag.get(str);
        String str4 = (String) propertyBag.get(str2);
        if (!StringUtil.isNullOrEmpty(str4) || StringUtil.isNullOrEmpty(str3)) {
            if (StringUtil.isNullOrEmpty(str4)) {
                str4 = CERT_INSTALLATION_FAILED_WITH_EMPTY_RESPONSE;
            }
            iInstallCertCallback.onError(new ClientException("unknown_error", str4));
        } else {
            iInstallCertCallback.onSuccess(Boolean.parseBoolean(str3));
        }
        LocalBroadcaster.INSTANCE.unregisterCallback(INSTALL_CERT_BROADCAST_ALIAS);
    }

    private static void registerCallbackAndParseResult(@NonNull final IInstallCertCallback iInstallCertCallback, @NonNull final String str, @NonNull final String str2) {
        LocalBroadcaster.INSTANCE.registerCallback(INSTALL_CERT_BROADCAST_ALIAS, new LocalBroadcaster.IReceiverCallback() { // from class: com.microsoft.identity.common.internal.broker.a
            @Override // com.microsoft.identity.common.java.util.ported.LocalBroadcaster.IReceiverCallback
            public final void onReceive(PropertyBag propertyBag) {
                InstallCertActivityLauncher.lambda$registerCallbackAndParseResult$1(str, str2, iInstallCertCallback, propertyBag);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String strM1170p = AbstractC0622a.m1170p(TAG, ":onCreate", new StringBuilder());
        if (bundle != null) {
            this.mInstallCertificateIntent = (Intent) bundle.getParcelable(INSTALL_CERT_INTENT);
            this.mInstallCertificateIntentStarted = Boolean.valueOf(bundle.getBoolean(INSTALL_CERT_INTENT_STARTED));
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.mInstallCertificateIntent = (Intent) extras.getParcelable(INSTALL_CERT_INTENT);
        } else {
            Logger.warn(strM1170p, "Extras is null.");
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (!this.mInstallCertificateResultReceived.booleanValue()) {
            Logger.error(TAG, "The activity is killed unexpectedly.", null);
            LocalBroadcaster.INSTANCE.broadcast(INSTALL_CERT_BROADCAST_ALIAS, new PropertyBag());
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mInstallCertificateIntentStarted.booleanValue()) {
            return;
        }
        this.mInstallCertificateIntentStarted = Boolean.TRUE;
        this.installCertActivityResultLauncher.launch(this.mInstallCertificateIntent);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(INSTALL_CERT_INTENT, this.mInstallCertificateIntent);
        bundle.putBoolean(INSTALL_CERT_INTENT_STARTED, this.mInstallCertificateIntentStarted.booleanValue());
    }
}
