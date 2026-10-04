package com.samsung.android.sdk.smp.testmode;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.sdk.smp.common.preference.InitOptionsHolder;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.spsclient.SpsUtil;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.yubico.yubikit.core.fido.CtapException;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class TestModeChecker {
    private static final String APP_ID = "aid";
    private static final String DIGEST_ALGORITHM = "SHA";
    private static final int NOT_TEST_MODE = 0;
    private static final String SMP_TEST_REGISTER_PACKAGE = "com.samsung.android.smp.register";
    private static final String TAG = "TestModeChecker";
    private static final int TEST_MODE = 2;
    private static final int TEST_MODE_BUT_NOT_WRITABLE = 1;
    private static final byte[] SIGNATURE_APPLICATION = {CtapException.ERR_REQUEST_TOO_LARGE, 119, 77, -40, -30, -26, -36, -78, SprAttributeBase.TYPE_SHADOW, -13, 118, 121, 21, 76, 5, -28, -67, 62, -82, 83};
    private static boolean mTestModeChecked = false;
    private static String mNickname = "";

    public static int checkModeAndEnableLog(Context context) {
        mTestModeChecked = true;
        int iSpsCheckMode = DeviceInfoUtil.isSamsungPushService(context) ? spsCheckMode(context) : nonSpsCheckMode(context, InitOptionsHolder.getInstance().getAppId(context));
        String smpSdkVersion = DeviceInfoUtil.getSmpSdkVersion(context);
        if (iSpsCheckMode == 0) {
            SmpLog.setSmpLogSetting(context, false, false);
            SmpLog.m6497hi(TAG, "Test mode: false, v:" + smpSdkVersion + SQLKeyword.COMMA + context.getPackageName());
            return iSpsCheckMode;
        }
        if (iSpsCheckMode == 1) {
            SmpLog.setSmpLogSetting(context, true, false);
            SmpLog.m6497hi(TAG, "Test mode: true, canWrite: false, v:" + smpSdkVersion + SQLKeyword.COMMA + context.getPackageName());
            return iSpsCheckMode;
        }
        if (iSpsCheckMode != 2) {
            return iSpsCheckMode;
        }
        SmpLog.setSmpLogSetting(context, true, true);
        SmpLog.m6497hi(TAG, "Test mode: true, canWrite: true, v:" + smpSdkVersion + SQLKeyword.COMMA + context.getPackageName());
        return iSpsCheckMode;
    }

    private static boolean checkRegisterAppSignature(Context context) {
        Signature[] signature;
        try {
            signature = DeviceInfoUtil.getSignature(context, SMP_TEST_REGISTER_PACKAGE);
        } catch (PackageManager.NameNotFoundException unused) {
        } catch (Exception e) {
            SmpLog.m6496he(TAG, "error : " + e.getMessage());
        }
        if (signature == null) {
            SmpLog.m6496he(TAG, "error : register app signature is null");
            return false;
        }
        for (Signature signature2 : signature) {
            if (signature2 != null && Arrays.equals(SIGNATURE_APPLICATION, digestBytes(signature2.toByteArray()))) {
                return true;
            }
        }
        SmpLog.m6496he(TAG, "error : register app signature does not match. You may have to update Smp Device Register app to the latest version.");
        return false;
    }

    private static byte[] digestBytes(byte[] bArr) {
        try {
            return MessageDigest.getInstance(DIGEST_ALGORITHM).digest(bArr);
        } catch (Exception e) {
            SmpLog.m6494e(TAG, e.getMessage());
            return null;
        }
    }

    public static String getDeviceNickname() {
        return mNickname;
    }

    public static boolean isTestMode() {
        return !TextUtils.isEmpty(mNickname);
    }

    public static boolean isTestModeChecked() {
        return mTestModeChecked;
    }

    private static int nonSpsCheckMode(Context context, String str) {
        if (!checkRegisterAppSignature(context)) {
            return 0;
        }
        Cursor cursor = null;
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.samsung.android.smp.testreg.provider/testinfo").buildUpon().appendQueryParameter("aid", str).build(), null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("aid"));
                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(NetworkConfig.CLIENTS_DEVICENAME));
                if (!str.equals(string)) {
                    SmpLog.m6497hi(TAG, "not test mode. aid is not matched. test aid: " + string);
                    cursorQuery.close();
                    return 0;
                }
                mNickname = string2;
                if (SmpLog.isFileLogNotWritable(context)) {
                    cursorQuery.close();
                    return 1;
                }
                cursorQuery.close();
                return 2;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return 0;
        } catch (Exception unused) {
            if (0 != 0) {
                cursor.close();
            }
            return 0;
        } catch (Throwable th) {
            if (0 == 0) {
                throw th;
            }
            cursor.close();
            throw th;
        }
    }

    private static int spsCheckMode(Context context) {
        String testDeviceName = SpsUtil.getTestDeviceName(context);
        if (TextUtils.isEmpty(testDeviceName)) {
            return 0;
        }
        mNickname = testDeviceName;
        return SmpLog.isFileLogNotWritable(context) ? 1 : 2;
    }
}
