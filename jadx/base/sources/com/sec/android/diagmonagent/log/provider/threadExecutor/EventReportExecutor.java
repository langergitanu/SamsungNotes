package com.sec.android.diagmonagent.log.provider.threadExecutor;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.sec.android.diagmonagent.common.logger.AppLog;
import com.sec.android.diagmonagent.common.util.CommonUtils;
import com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient;
import com.sec.android.diagmonagent.log.provider.DiagMonConfig;
import com.sec.android.diagmonagent.log.provider.EventBuilder;
import com.sec.android.diagmonagent.log.provider.utils.BundleContract;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;
import com.sec.android.diagmonagent.log.provider.utils.Validator;
import com.sec.android.diagmonagent.log.provider.utils.ZipHelper;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class EventReportExecutor implements AsyncTaskClient {
    private static final String intentNameApp = "com.sec.android.diagmonagent.intent.REPORT_ERROR_APP";
    private static final String intentNameSystem = "com.sec.android.diagmonagent.intent.REPORT_ERROR_V2";
    private final Context context;
    private final EventBuilder eventBuilder;
    private final DiagMonConfig mConfig;
    private final Bundle srObj;

    public EventReportExecutor(DiagMonConfig diagMonConfig, Bundle bundle, EventBuilder eventBuilder) {
        this.context = diagMonConfig.getContext();
        this.mConfig = diagMonConfig;
        this.srObj = bundle;
        this.eventBuilder = eventBuilder;
    }

    private Bundle addParcelFileDescriptor(Bundle bundle, String str) {
        ParcelFileDescriptor parcelFileDescriptorOpen;
        try {
            parcelFileDescriptorOpen = ParcelFileDescriptor.open(new File(str), 268435456);
            AppLog.m13140d("Zipping logs is completed");
            AppLog.m13140d("Zipped file size : " + parcelFileDescriptorOpen.getStatSize());
        } catch (Exception e) {
            AppLog.m13141e(e.getMessage());
            parcelFileDescriptorOpen = null;
        }
        bundle.putParcelable(BundleContract.FILE_DESCRIPTOR, parcelFileDescriptorOpen);
        return bundle;
    }

    private String collectLogs(Context context, String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            AppLog.m13144w("No Log Path, You have to set LogPath to report logs");
            throw new IOException("Not found");
        }
        try {
            String str2 = context.getFilesDir().getAbsolutePath() + "/zip";
            new File(str2).mkdir();
            return ZipHelper.zip(str, str2 + "/" + (System.currentTimeMillis() + Constants.ZIP_EXTENSION_WITH_DOT));
        } catch (Exception e) {
            AppLog.m13144w("Zipping failure");
            AppLog.m13144w("Exception : " + e.getMessage());
            throw e;
        }
    }

    private boolean eventReportViaBR(Context context, DiagMonConfig diagMonConfig, EventBuilder eventBuilder) {
        try {
            if (!Validator.isValidLegacyConfig(diagMonConfig)) {
                AppLog.m13144w("Invalid DiagMonConfiguration");
                return false;
            }
            if (!Validator.isValidLegacyEventBuilder(eventBuilder)) {
                AppLog.m13144w("Invalid EventBuilder");
                return false;
            }
            AppLog.m13140d("Valid EventBuilder");
            sendLogPath();
            context.sendBroadcast(makeEventobjAsIntent(context, diagMonConfig, eventBuilder));
            AppLog.m13140d("Report your logs");
            return true;
        } catch (NullPointerException | Exception unused) {
            return false;
        }
    }

    private boolean eventReportViaCP(Context context, DiagMonConfig diagMonConfig, EventBuilder eventBuilder, Bundle bundle) {
        try {
            if (diagMonConfig == null) {
                AppLog.m13144w("No Configuration");
                AppLog.m13144w("You have to set DiagMonConfiguration");
                return false;
            }
            Bundle bundleMakeEventObjAsBundle = makeEventObjAsBundle(diagMonConfig, eventBuilder);
            if (bundleMakeEventObjAsBundle == null) {
                AppLog.m13144w("No EventObject");
                return false;
            }
            if (!Validator.isValidMandatoryFields(bundle)) {
                AppLog.m13144w("Invalid SR object");
                return false;
            }
            if (!Validator.isValidMandatoryFields(bundleMakeEventObjAsBundle)) {
                AppLog.m13144w("Invalid ER object");
                return false;
            }
            AppLog.m13142i("Valid SR, ER object");
            AppLog.m13142i("Report your logs");
            AppLog.m13142i("networkMode : " + bundle.getBoolean(BundleContract.NETWORK_MODE, true));
            bundleMakeEventObjAsBundle.putBoolean(BundleContract.NETWORK_MODE, bundle.getBoolean(BundleContract.NETWORK_MODE, true));
            String strCollectLogs = collectLogs(context, eventBuilder.getLogPath());
            DiagMonUtil.printResultfromDMA(context.getContentResolver().call(DiagMonUtil.URI, "event_report", "eventReport", addParcelFileDescriptor(bundleMakeEventObjAsBundle, strCollectLogs)));
            if (!strCollectLogs.isEmpty()) {
                removeZipFile(strCollectLogs);
            }
            return true;
        } catch (NullPointerException | Exception unused) {
            return false;
        }
    }

    private int getUid(Context context) {
        return context.getApplicationInfo().uid;
    }

    private Bundle makeEventObjAsBundle(DiagMonConfig diagMonConfig, EventBuilder eventBuilder) {
        Bundle bundle = new Bundle();
        try {
            bundle.putString("serviceId", diagMonConfig.getServiceId());
            bundle.putString("serviceVersion", diagMonConfig.getServiceVer());
            bundle.putString(BundleContract.SERVICE_DEFINED_KEY, eventBuilder.getServiceDefinedKey());
            bundle.putString("errorCode", eventBuilder.getErrorCode());
            bundle.putString(BundleContract.DESCRIPTION, eventBuilder.getDescription());
            bundle.putString(BundleContract.RELAY_CLIENT_VER, eventBuilder.getRelayClientVer());
            bundle.putString(BundleContract.RELAY_CLIENT_TYPE, eventBuilder.getRelayClientType());
            bundle.putString(BundleContract.EXTRA_DATA, eventBuilder.getExtData());
            bundle.putString("deviceId", diagMonConfig.getDeviceId());
            bundle.putString(BundleContract.SERVICE_AGREE, diagMonConfig.getAgreeAsString());
            bundle.putString("sdkVersion", DiagMonUtil.getSdkVersion());
            bundle.putString(BundleContract.FOREGROUND, DiagMonUtil.isForeground(this.context));
            bundle.putString(BundleContract.SDK_TYPE, "S");
            bundle.putString(BundleContract.MEMORY, eventBuilder.getMemory().toString());
            bundle.putString(BundleContract.STORAGE, eventBuilder.getInternalStorageSize().toString());
            AppLog.m13140d("Generated EventObject");
            return bundle;
        } catch (Exception unused) {
            return null;
        }
    }

    private Intent makeEventobjAsIntent(Context context, DiagMonConfig diagMonConfig, EventBuilder eventBuilder) {
        JSONObject jSONObject = new JSONObject();
        Intent intent = getUid(context) == 1000 ? new Intent(intentNameSystem) : new Intent(intentNameApp);
        Bundle bundle = new Bundle();
        intent.addFlags(32);
        bundle.putBundle("DiagMon", new Bundle());
        bundle.getBundle("DiagMon").putBundle("CFailLogUpload", new Bundle());
        bundle.getBundle("DiagMon").getBundle("CFailLogUpload").putString("ServiceID", diagMonConfig.getServiceId());
        bundle.getBundle("DiagMon").getBundle("CFailLogUpload").putBundle("Ext", new Bundle());
        bundle.getBundle("DiagMon").getBundle("CFailLogUpload").getBundle("Ext").putString("ClientV", CommonUtils.getPackageVersion(context));
        if (!TextUtils.isEmpty(eventBuilder.getRelayClientType())) {
            bundle.getBundle("DiagMon").getBundle("CFailLogUpload").getBundle("Ext").putString("RelayClient", eventBuilder.getRelayClientType());
        }
        if (!TextUtils.isEmpty(eventBuilder.getRelayClientVer())) {
            bundle.getBundle("DiagMon").getBundle("CFailLogUpload").getBundle("Ext").putString("RelayClientV", eventBuilder.getRelayClientVer());
        }
        bundle.getBundle("DiagMon").getBundle("CFailLogUpload").getBundle("Ext").putString("UiMode", "0");
        bundle.getBundle("DiagMon").getBundle("CFailLogUpload").getBundle("Ext").putString("ResultCode", eventBuilder.getErrorCode());
        if (!TextUtils.isEmpty(eventBuilder.getServiceDefinedKey())) {
            bundle.getBundle("DiagMon").getBundle("CFailLogUpload").getBundle("Ext").putString("EventID", eventBuilder.getServiceDefinedKey());
        }
        try {
            jSONObject.put("SasdkV", "6.05.079");
            jSONObject.put("SdkV", DiagMonUtil.getSdkVersion());
            jSONObject.put("TrackingID", diagMonConfig.getTrackingId());
            jSONObject.put("Description", eventBuilder.getDescription());
        } catch (JSONException e) {
            AppLog.m13141e(e.getMessage());
        }
        bundle.getBundle("DiagMon").getBundle("CFailLogUpload").getBundle("Ext").putString("Description", jSONObject.toString());
        if (this.srObj.getBoolean(BundleContract.NETWORK_MODE, true)) {
            bundle.getBundle("DiagMon").getBundle("CFailLogUpload").getBundle("Ext").putString("WifiOnlyFeature", "1");
        } else {
            bundle.getBundle("DiagMon").getBundle("CFailLogUpload").getBundle("Ext").putString("WifiOnlyFeature", "0");
        }
        intent.putExtra("uploadMO", bundle);
        intent.setFlags(32);
        AppLog.m13142i("EventObject is generated");
        return intent;
    }

    private void removeZipFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            if (file.delete()) {
                AppLog.m13140d("Removed zipFile : " + str);
            } else {
                AppLog.m13140d("Couldn't removed zipFile : " + str);
            }
        }
    }

    private void sendLogPath() {
        try {
            String legacyAuthority = DiagMonUtil.getLegacyAuthority(this.mConfig.getServiceId());
            this.context.getContentResolver().call(Uri.parse(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME + legacyAuthority), "update_path", this.eventBuilder.getLogPath(), (Bundle) null);
        } catch (Exception e) {
            AppLog.m13144w("fail to send log path: " + e.getMessage());
        }
    }

    @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
    public int onFinish() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005b A[Catch: Exception -> 0x001b, TRY_LEAVE, TryCatch #0 {Exception -> 0x001b, blocks: (B:3:0x0002, B:6:0x0009, B:8:0x0015, B:12:0x001d, B:18:0x002b, B:24:0x005b, B:19:0x0036, B:20:0x0043, B:21:0x0053), top: B:28:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean zEventReportViaBR;
        try {
            if (DiagMonUtil.insufficientStorage()) {
                return;
            }
            if (!Validator.isValidLogPath(this.eventBuilder.getLogPath())) {
                AppLog.m13144w("You have to properly set LogPath");
                return;
            }
            int iCheckDMA = DiagMonUtil.checkDMA(this.context);
            if (iCheckDMA != 0) {
                if (iCheckDMA == 1) {
                    AppLog.m13140d("LEGACY DMA");
                    zEventReportViaBR = eventReportViaBR(this.context, this.mConfig, this.eventBuilder);
                } else if (iCheckDMA != 2) {
                    AppLog.m13144w("Exceptional case");
                    AppLog.m13144w("customEventReport is aborted");
                } else {
                    zEventReportViaBR = eventReportViaCP(this.context, this.mConfig, this.eventBuilder, this.srObj);
                }
                if (zEventReportViaBR) {
                    AppLog.m13144w("failed to customEventReport");
                    return;
                }
                return;
            }
            AppLog.m13144w("not installed");
            zEventReportViaBR = false;
            if (zEventReportViaBR) {
            }
        } catch (Exception e) {
            AppLog.m13144w("failed to customEventReport" + e);
        }
    }
}
