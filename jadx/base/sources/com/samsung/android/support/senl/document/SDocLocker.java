package com.samsung.android.support.senl.document;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.support.senl.document.delegator.AppDelegator;
import com.samsung.android.support.senl.document.memoconverter.core.SNBToSPDConverter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import java.util.Random;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SDocLocker {
    private static final char[] CHAR_TABLE = {'a', 'b', DeviceInfoUtil.FLAVOR_TYPE_C, 'd', 'e', 'f', DeviceInfoUtil.FLAVOR_TYPE_G, 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final String PREF_KEY_NOTES_ANDROID_ID = "NotesDeviceID#2";
    private static final String PREF_KEY_NOTES_DEVICE_UUID = "NotesDeviceID#1";
    private static final String PREF_KEY_NOTES_SERIAL_NUMBER = "NotesDeviceID#3";
    private static final String PREF_NAME_DEVICE_INFO = "NotesDeviceInfo";
    private static final String STRING_DEFAULT = "#_ empty";
    public static final int USER_CODE_PADDING_2 = 0;
    public static final int USER_CODE_PADDING_6 = 1;
    private Context mContext;
    private SNBToSPDConverter mConverter;
    private SharedPreferences.Editor mEditor;
    private SharedPreferences mSharedPreferences;

    private SDocLocker() {
        this.mSharedPreferences = null;
        this.mEditor = null;
        this.mContext = null;
        this.mConverter = null;
    }

    private static String getRandomString(int i) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i2 = 0; i2 < i; i2++) {
            char[] cArr = CHAR_TABLE;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    public String[] getUserCode() {
        String string = this.mSharedPreferences.getString(PREF_KEY_NOTES_DEVICE_UUID, STRING_DEFAULT);
        String str = "";
        if (string == null || string.equals(STRING_DEFAULT)) {
            string = UUID.randomUUID().toString();
            if (this.mEditor == null) {
                this.mEditor = this.mSharedPreferences.edit();
            }
            if (!AppDelegator.getInstance().detourUtils_commitEditor(this.mEditor.putString(PREF_KEY_NOTES_DEVICE_UUID, string))) {
                string = "";
            }
        }
        String string2 = this.mSharedPreferences.getString(PREF_KEY_NOTES_ANDROID_ID, STRING_DEFAULT);
        if (string2 == null || string2.equals(STRING_DEFAULT)) {
            string2 = Settings.Secure.getString(this.mContext.getContentResolver(), SharedPreferencesConstants.COMPOSER_SP_KEY_ANDROID_ID);
            if (this.mEditor == null) {
                this.mEditor = this.mSharedPreferences.edit();
            }
            if (!AppDelegator.getInstance().detourUtils_commitEditor(this.mEditor.putString(PREF_KEY_NOTES_ANDROID_ID, string2))) {
                string2 = "";
            }
        }
        String string3 = this.mSharedPreferences.getString(PREF_KEY_NOTES_SERIAL_NUMBER, STRING_DEFAULT);
        if (string3 == null || string3.equals(STRING_DEFAULT)) {
            String randomString = getRandomString(16);
            if (this.mEditor == null) {
                this.mEditor = this.mSharedPreferences.edit();
            }
            if (AppDelegator.getInstance().detourUtils_commitEditor(this.mEditor.putString(PREF_KEY_NOTES_SERIAL_NUMBER, randomString))) {
                str = randomString;
            }
        } else {
            str = string3;
        }
        String[] strArr = new String[2];
        strArr[0] = this.mConverter.getPassword(string2, str, string);
        if (str.length() <= 16) {
            strArr[1] = null;
            return strArr;
        }
        strArr[1] = this.mConverter.getPassword(string2, str.substring(str.length() - 16), string);
        return strArr;
    }

    public boolean is64bitCodeAvailable() {
        String string = this.mSharedPreferences.getString(PREF_KEY_NOTES_SERIAL_NUMBER, STRING_DEFAULT);
        if (string == null || string.equals(STRING_DEFAULT)) {
            string = getRandomString(16);
            if (this.mEditor == null) {
                this.mEditor = this.mSharedPreferences.edit();
            }
            if (!AppDelegator.getInstance().detourUtils_commitEditor(this.mEditor.putString(PREF_KEY_NOTES_SERIAL_NUMBER, string))) {
                string = "";
            }
        }
        return string.length() > 16;
    }

    public SDocLocker(Context context) {
        this.mSharedPreferences = null;
        this.mEditor = null;
        this.mContext = null;
        this.mConverter = null;
        this.mSharedPreferences = context.getSharedPreferences(PREF_NAME_DEVICE_INFO, 0);
        this.mContext = context;
        this.mConverter = new SNBToSPDConverter();
    }
}
