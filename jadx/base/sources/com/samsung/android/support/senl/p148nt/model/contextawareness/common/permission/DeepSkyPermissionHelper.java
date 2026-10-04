package com.samsung.android.support.senl.p148nt.model.contextawareness.common.permission;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.common.log.CALogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class DeepSkyPermissionHelper {
    private static final String ACTIVITY_INTERFACE_URI = "smartsuggestions://feature/permission";
    private static final String BUNDLE_KEY_FEATURE_TYPE = "feature_type";
    private static final String BUNDLE_KEY_METHOD_TYPE = "method_type";
    private static final String BUNDLE_VALUE_QUICK_NOTE = "quick_notes";
    private static final String CONTENT_PROVIDER_INTERFACE_URI = "content://com.samsung.android.app.deepsky.DeepSkyQuery.provider";
    private static final String METHOD_GO_TO_PERMISSION_SETTING_DIALOG = "go_to_permission_setting_dialog";
    private static final String METHOD_IS_ALL_GRANTED_PERMISSION = "is_all_granted_permission";
    private static final String METHOD_NEED_PERMISSION_CONFIRM = "need_permission_confirm";
    private static final String METHOD_SHOW_PERMISSION_CONFIRM_DIALOG = "show_permission_confirm_dialog";
    private static final String RESULT_KEY_IS_ALL_GRANTED_PERMISSION = "is_all_granted_permission_result";
    private static final String RESULT_KEY_NEED_PERMISSION_CONFIRM = "need_permission_confirm_result";
    private static final String TAG = CALogger.createTag("DeepSkyPermissionHelper");

    public static Intent getIntentForAllowDataUsagePermissionSettingDialog() {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(ACTIVITY_INTERFACE_URI));
        intent.putExtra(BUNDLE_KEY_FEATURE_TYPE, BUNDLE_VALUE_QUICK_NOTE);
        intent.putExtra(BUNDLE_KEY_METHOD_TYPE, METHOD_GO_TO_PERMISSION_SETTING_DIALOG);
        return intent;
    }

    public static boolean isAllGrantedPermission() {
        boolean z;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(BUNDLE_KEY_FEATURE_TYPE, BUNDLE_VALUE_QUICK_NOTE);
            z = BaseUtils.getApplicationContext().getContentResolver().call(Uri.parse("content://com.samsung.android.app.deepsky.DeepSkyQuery.provider"), METHOD_IS_ALL_GRANTED_PERMISSION, (String) null, bundle).getBoolean(RESULT_KEY_IS_ALL_GRANTED_PERMISSION);
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("isAllGrantedPermission# "), TAG);
            z = false;
        }
        DataLogger.m12302d(TAG, "isAllGrantedPermission# " + z);
        return z;
    }

    public static boolean needPermissionConfirm() {
        boolean z;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(BUNDLE_KEY_FEATURE_TYPE, BUNDLE_VALUE_QUICK_NOTE);
            z = BaseUtils.getApplicationContext().getContentResolver().call(Uri.parse("content://com.samsung.android.app.deepsky.DeepSkyQuery.provider"), METHOD_NEED_PERMISSION_CONFIRM, (String) null, bundle).getBoolean(RESULT_KEY_NEED_PERMISSION_CONFIRM);
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("needPermissionConfirm# "), TAG);
            z = true;
        }
        DataLogger.m12302d(TAG, "needPermissionConfirm# " + z);
        return z;
    }

    public static void showPermissionConfirmDialog() {
        DataLogger.m12302d(TAG, "showPermissionConfirmDialog#");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(ACTIVITY_INTERFACE_URI));
            intent.putExtra(BUNDLE_KEY_FEATURE_TYPE, BUNDLE_VALUE_QUICK_NOTE);
            intent.putExtra(BUNDLE_KEY_METHOD_TYPE, METHOD_SHOW_PERMISSION_CONFIRM_DIALOG);
            intent.addFlags(268435456);
            BaseUtils.getApplicationContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            DataLogger.m12303e(TAG, "showPermissionConfirmDialog# " + e.getMessage());
        }
    }
}
