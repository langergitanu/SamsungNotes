package com.sec.android.diagmonagent.log.provider.threadExecutor;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.sec.android.diagmonagent.common.logger.AppLog;
import com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient;
import com.sec.android.diagmonagent.log.provider.DiagMonConfig;
import com.sec.android.diagmonagent.log.provider.utils.BundleContract;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;
import com.sec.android.diagmonagent.log.provider.utils.Validator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ServiceRegistrationExecutor implements AsyncTaskClient {
    private final Context context;
    private final DiagMonConfig mConfig;
    private final Bundle srObj;
    private final String PREF_DIAGMON_NAME = "diagmon_pref";
    private final String PREF_DIAGMON_TIMESTAMP = "diagmon_timestamp";
    private final long MIN_WAITING_TIME = TimeUnit.HOURS.toMillis(6);

    public ServiceRegistrationExecutor(DiagMonConfig diagMonConfig, Bundle bundle) {
        this.context = diagMonConfig.getContext();
        this.mConfig = diagMonConfig;
        this.srObj = bundle;
    }

    private boolean checkAuthority(String str, int i) {
        if (i != 2) {
            return true;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("serviceId", str);
            this.context.getContentResolver().call(DiagMonUtil.URI, "request_deviceid", "request_deviceid", bundle);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private long getPrefDiagmonTimestamp() {
        return this.context.getSharedPreferences("diagmon_pref", 0).getLong("diagmon_timestamp", 0L);
    }

    private boolean isTestMode() {
        return ("com.samsung.diagmonagenttest".equals(this.context.getPackageName()) || "com.samsung.context.sdk.sampleapp".equals(this.context.getPackageName())) && Build.TYPE.equals("eng");
    }

    private void sendLegacySRObj() {
        try {
            String legacyAuthority = DiagMonUtil.getLegacyAuthority(this.mConfig.getServiceId());
            Bundle bundle = new Bundle();
            bundle.putString("deviceId", this.mConfig.getDeviceId());
            bundle.putBoolean(BundleContract.SERVICE_AGREE, this.mConfig.getAgree());
            bundle.putString("serviceId", legacyAuthority);
            this.context.getContentResolver().call(Uri.parse(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME + legacyAuthority), "service_registration", (String) null, bundle);
        } catch (Exception e) {
            AppLog.m13144w("fail to send SR obj: " + e.getMessage());
        }
    }

    private void sendSRObj() {
        try {
            AppLog.m13142i("Request Service Registration");
            DiagMonUtil.printResultfromDMA(this.context.getContentResolver().call(DiagMonUtil.URI, "register_service", "registration", this.srObj));
        } catch (Exception unused) {
            AppLog.m13144w("fail to send SR obj");
        }
    }

    private void setPrefDiagmonTimestamp(long j) {
        SharedPreferences.Editor editorEdit = this.context.getSharedPreferences("diagmon_pref", 0).edit();
        editorEdit.putLong("diagmon_timestamp", j);
        editorEdit.apply();
    }

    @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
    public int onFinish() {
        return 0;
    }

    @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
    public void run() {
        int iCheckDMA = DiagMonUtil.checkDMA(this.context);
        if (iCheckDMA == 0) {
            AppLog.m13144w("Not installed DMA");
            AppLog.m13144w("SetConfiguration is aborted");
            return;
        }
        if (iCheckDMA == 1) {
            if (Validator.isValidLegacyConfig(this.mConfig)) {
                sendLegacySRObj();
                AppLog.m13142i("Valid DiagMonConfiguration");
                return;
            } else {
                AppLog.m13144w("Invalid DiagMonConfiguration");
                AppLog.m13144w("SetConfiguration is aborted");
                return;
            }
        }
        if (iCheckDMA != 2) {
            AppLog.m13144w("Exceptional case");
            AppLog.m13144w("SetConfiguration is aborted");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long prefDiagmonTimestamp = getPrefDiagmonTimestamp();
        if (isTestMode() || jCurrentTimeMillis > prefDiagmonTimestamp + this.MIN_WAITING_TIME) {
            if (!checkAuthority(this.mConfig.getServiceId(), iCheckDMA)) {
                AppLog.m13144w("Authority check got failed");
                return;
            }
            setPrefDiagmonTimestamp(jCurrentTimeMillis);
            if (Validator.isValidMandatoryFields(this.srObj)) {
                sendSRObj();
            } else {
                Log.w(DiagMonUtil.TAG, "Invalid SR object");
            }
        }
    }
}
