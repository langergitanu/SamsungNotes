package com.sec.android.diagmonagent.log.provider.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.sec.android.diagmonagent.common.logger.AppLog;
import com.sec.android.diagmonagent.log.provider.DiagMonConfig;
import com.sec.android.diagmonagent.log.provider.EventBuilder;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Validator {
    public static boolean isValidLegacyConfig(DiagMonConfig diagMonConfig) {
        if (TextUtils.isEmpty(diagMonConfig.getServiceId())) {
            AppLog.m13144w("Service ID has to be set");
            return false;
        }
        if (diagMonConfig.getAgree()) {
            return true;
        }
        AppLog.m13144w("You have to agree to terms and conditions");
        return false;
    }

    public static boolean isValidLegacyEventBuilder(EventBuilder eventBuilder) {
        if (!TextUtils.isEmpty(eventBuilder.getErrorCode())) {
            return true;
        }
        AppLog.m13144w("No Result code - you have to set");
        return false;
    }

    public static boolean isValidLogPath(String str) {
        File[] fileArrListFiles;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.isDirectory() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length >= 1;
    }

    public static boolean isValidMandatoryFields(Bundle bundle) {
        if (bundle.getString("serviceId", "").isEmpty()) {
            AppLog.m13144w("Service ID has to be set");
            return false;
        }
        if (bundle.getString("serviceVersion", "").isEmpty()) {
            AppLog.m13144w("No service version");
            return false;
        }
        if (bundle.getString("sdkVersion", "").isEmpty()) {
            AppLog.m13144w("No SDK version");
            return false;
        }
        if (bundle.getString(BundleContract.SDK_TYPE, "").isEmpty()) {
            AppLog.m13144w("No SDK type");
            return false;
        }
        if (bundle.getString(BundleContract.SERVICE_AGREE, "").isEmpty()) {
            AppLog.m13144w("You have to agree to terms and conditions");
            return false;
        }
        String string = bundle.getString(BundleContract.SERVICE_AGREE, "");
        AppLog.m13142i("Agreement value: " + string);
        if (!DiagMonUtil.AGREE_TYPE_DIAGNOSTIC.equals(string) && !"S".equals(string)) {
            AppLog.m13144w("Undefined agreement: " + string);
            return false;
        }
        if (!DiagMonUtil.AGREE_TYPE_DIAGNOSTIC.equals(string) || bundle.getString("deviceId", "").isEmpty()) {
            return true;
        }
        AppLog.m13144w("You can't use setDeviceId API if you used setAgree as Diagnostic agreement");
        return false;
    }
}
