package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.quicknote;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MsgPermissionAction {
    private static final String TAG = Logger.createTag("MsgPermissionAction");

    public String getAndroidId() {
        return SharedPreferencesCompat.getInstance("Composer").getString(SharedPreferencesConstants.COMPOSER_SP_KEY_ANDROID_ID, null);
    }

    public boolean hasAndroidId() {
        return getAndroidId() != null;
    }

    public boolean hasPermission(Context context) {
        return PermissionHelper.isPermissionGrantedWithoutNotice(context, "android.permission.READ_PHONE_STATE");
    }

    public void requestPermissions(Fragment fragment, int i, Runnable runnable) {
        PermissionHelper.requestPermissions(fragment, i, false, runnable, "android.permission.READ_PHONE_STATE");
    }

    public void saveAndroidId(Context context) {
        String androidDeviceId = SettingsCompat.getInstance().getAndroidDeviceId(context);
        if (TextUtils.isEmpty(androidDeviceId)) {
            AbstractC8014b.m7196B("saveAndroidId# fail ", androidDeviceId, TAG);
            return;
        }
        try {
            SharedPreferencesCompat.getInstance("Composer").putString(SharedPreferencesConstants.COMPOSER_SP_KEY_ANDROID_ID, Base64Utils.encodeBase64(androidDeviceId));
        } catch (UnsupportedEncodingException e) {
            Logger.m11000e(TAG, "saveAndroidId# " + e.getMessage());
        }
    }
}
