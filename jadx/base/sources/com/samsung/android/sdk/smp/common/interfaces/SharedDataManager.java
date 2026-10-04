package com.samsung.android.sdk.smp.common.interfaces;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.sdk.smp.common.exception.IErrors;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.preference.InitOptionsHolder;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class SharedDataManager {
    private static final String TAG = "SharedDataManager";
    private final String PROVIDER_BASE_URI;
    private final Context mContext;

    public SharedDataManager(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.PROVIDER_BASE_URI = AbstractC0541b.m773o(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME, applicationContext.getPackageName() + ".smp.provider", "/");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b4 A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[DONT_GENERATE, FINALLY_INSNS, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean getBoolean(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            SmpLog.m6494e(TAG, "getBoolean error. key null");
            return z;
        }
        if (!InitOptionsHolder.getInstance().isMultiprocessMode()) {
            return getBooleanForSingleProcess(this.mContext, str, z);
        }
        if (DeviceInfoUtil.isAppDisabled(this.mContext)) {
            SmpLog.m6496he(TAG, this.mContext.getPackageName() + " is disabled. finish...");
            return z;
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.mContext.getContentResolver().query(Uri.parse(getBooleanUri() + str + "/" + z), null, null, null, null);
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return z;
                }
                boolean zEquals = "true".equals(cursorQuery.getString(cursorQuery.getColumnIndex("value")));
                cursorQuery.close();
                return zEquals;
            } catch (Exception e) {
                SmpLog.m6496he(TAG, "Exception getBoolean " + e);
                throw new InternalException.ProviderErrorException(IErrors.ERROR_CODE_SMP_0601, IErrors.ERROR_MESSAGE_SMP_0601);
            }
        } finally {
        }
    }

    public abstract boolean getBooleanForSingleProcess(Context context, String str, boolean z);

    public abstract String getBooleanUri();

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a5 A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[DONT_GENERATE, FINALLY_INSNS, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getInteger(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            SmpLog.m6494e(TAG, "getInteger error. key null");
            return i;
        }
        if (!InitOptionsHolder.getInstance().isMultiprocessMode()) {
            return getIntegerForSingleProcess(this.mContext, str, i);
        }
        if (DeviceInfoUtil.isAppDisabled(this.mContext)) {
            SmpLog.m6496he(TAG, this.mContext.getPackageName() + " is disabled. finish...");
            return i;
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.mContext.getContentResolver().query(Uri.parse(getIntegerUri() + str), null, null, null, null);
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return i;
                }
                int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("value"));
                cursorQuery.close();
                return i2;
            } catch (Exception e) {
                SmpLog.m6496he(TAG, "Exception getInteger" + e);
                throw new InternalException.ProviderErrorException(IErrors.ERROR_CODE_SMP_0601, IErrors.ERROR_MESSAGE_SMP_0601);
            }
        } finally {
        }
    }

    public abstract int getIntegerForSingleProcess(Context context, String str, int i);

    public abstract String getIntegerUri();

    /* JADX WARN: Removed duplicated region for block: B:31:0x00b5 A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[DONT_GENERATE, FINALLY_INSNS, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Long getLong(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            SmpLog.m6494e(TAG, "getLong error. key null");
            return Long.valueOf(j);
        }
        if (!InitOptionsHolder.getInstance().isMultiprocessMode()) {
            return Long.valueOf(getLongForSingleProcess(this.mContext, str, j));
        }
        if (DeviceInfoUtil.isAppDisabled(this.mContext)) {
            SmpLog.m6496he(TAG, this.mContext.getPackageName() + " is disabled. finish...");
            return Long.valueOf(j);
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.mContext.getContentResolver().query(Uri.parse(getLongUri() + str), null, null, null, null);
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return Long.valueOf(j);
                }
                Long lValueOf = Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("value")));
                cursorQuery.close();
                return lValueOf;
            } catch (Exception e) {
                SmpLog.m6496he(TAG, "Exception getLong" + e);
                throw new InternalException.ProviderErrorException(IErrors.ERROR_CODE_SMP_0601, IErrors.ERROR_MESSAGE_SMP_0601);
            }
        } finally {
        }
    }

    public abstract long getLongForSingleProcess(Context context, String str, long j);

    public abstract String getLongUri();

    public abstract String getRemoveStringSetUri();

    public abstract String getRemoveUri();

    public String getSmpPrefProviderBaseUri() {
        return this.PROVIDER_BASE_URI;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a5 A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[DONT_GENERATE, FINALLY_INSNS, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getString(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            SmpLog.m6494e(TAG, "getString error. key null");
            return str2;
        }
        if (!InitOptionsHolder.getInstance().isMultiprocessMode()) {
            return getStringForSingleProcess(this.mContext, str, str2);
        }
        if (DeviceInfoUtil.isAppDisabled(this.mContext)) {
            SmpLog.m6496he(TAG, this.mContext.getPackageName() + " is disabled. finish...");
            return str2;
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.mContext.getContentResolver().query(Uri.parse(getStringUri() + str), null, null, null, null);
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return str2;
                }
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                cursorQuery.close();
                return string;
            } catch (Exception e) {
                SmpLog.m6496he(TAG, "Exception getString " + e);
                throw new InternalException.ProviderErrorException(IErrors.ERROR_CODE_SMP_0601, IErrors.ERROR_MESSAGE_SMP_0601);
            }
        } finally {
        }
    }

    public abstract String getStringForSingleProcess(Context context, String str, String str2);

    public Set<String> getStringSet(String str) {
        if (TextUtils.isEmpty(str)) {
            SmpLog.m6494e(TAG, "getStringSet error. key null");
            return new HashSet();
        }
        if (!InitOptionsHolder.getInstance().isMultiprocessMode()) {
            return getStringSetForSingleProcess(this.mContext, str);
        }
        if (DeviceInfoUtil.isAppDisabled(this.mContext)) {
            SmpLog.m6496he(TAG, this.mContext.getPackageName() + " is disabled. finish...");
            return new HashSet();
        }
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = this.mContext.getContentResolver().query(Uri.parse(getStringSetUri() + str), null, null, null, null);
                if (cursorQuery == null) {
                    SmpLog.m6494e(TAG, "getStringSet error. cursor null");
                    HashSet hashSet = new HashSet();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return hashSet;
                }
                HashSet hashSet2 = new HashSet();
                while (cursorQuery.moveToNext()) {
                    hashSet2.add(cursorQuery.getString(cursorQuery.getColumnIndex("value")));
                }
                cursorQuery.close();
                return hashSet2;
            } catch (Exception e) {
                SmpLog.m6496he(TAG, "Exception getStringSet " + e);
                throw new InternalException.ProviderErrorException(IErrors.ERROR_CODE_SMP_0601, IErrors.ERROR_MESSAGE_SMP_0601);
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public abstract Set<String> getStringSetForSingleProcess(Context context, String str);

    public abstract String getStringSetUri();

    public abstract String getStringUri();

    public void putBoolean(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            SmpLog.m6494e(TAG, "putBoolean error. key null");
            return;
        }
        if (!InitOptionsHolder.getInstance().isMultiprocessMode()) {
            putBooleanForSingleProcess(this.mContext, str, z);
            return;
        }
        if (DeviceInfoUtil.isAppDisabled(this.mContext)) {
            SmpLog.m6496he(TAG, this.mContext.getPackageName() + " is disabled. finish...");
            return;
        }
        try {
            Uri uri = Uri.parse(getBooleanUri() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", str);
            contentValues.put("value", Boolean.valueOf(z));
            this.mContext.getContentResolver().update(uri, contentValues, null, null);
        } catch (Exception e) {
            SmpLog.m6496he(TAG, "Exception putBoolean " + e);
            throw new InternalException.ProviderErrorException(IErrors.ERROR_CODE_SMP_0601, IErrors.ERROR_MESSAGE_SMP_0601);
        }
    }

    public abstract void putBooleanForSingleProcess(Context context, String str, boolean z);

    public void putInteger(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            SmpLog.m6494e(TAG, "putInteger error. key null");
            return;
        }
        if (!InitOptionsHolder.getInstance().isMultiprocessMode()) {
            putIntegerForSingleProcess(this.mContext, str, i);
            return;
        }
        if (DeviceInfoUtil.isAppDisabled(this.mContext)) {
            SmpLog.m6496he(TAG, this.mContext.getPackageName() + " is disabled. finish...");
            return;
        }
        try {
            Uri uri = Uri.parse(getIntegerUri() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", str);
            contentValues.put("value", Integer.valueOf(i));
            this.mContext.getContentResolver().update(uri, contentValues, null, null);
        } catch (Exception e) {
            SmpLog.m6496he(TAG, "Exception putInteger " + e);
            throw new InternalException.ProviderErrorException(IErrors.ERROR_CODE_SMP_0601, IErrors.ERROR_MESSAGE_SMP_0601);
        }
    }

    public abstract void putIntegerForSingleProcess(Context context, String str, int i);

    public void putLong(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            SmpLog.m6494e(TAG, "putLong error. key null");
            return;
        }
        if (!InitOptionsHolder.getInstance().isMultiprocessMode()) {
            putLongForSingleProcess(this.mContext, str, j);
            return;
        }
        if (DeviceInfoUtil.isAppDisabled(this.mContext)) {
            SmpLog.m6496he(TAG, this.mContext.getPackageName() + " is disabled. finish...");
            return;
        }
        try {
            Uri uri = Uri.parse(getLongUri() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", str);
            contentValues.put("value", Long.valueOf(j));
            this.mContext.getContentResolver().update(uri, contentValues, null, null);
        } catch (Exception e) {
            SmpLog.m6496he(TAG, "Exception putLong " + e);
            throw new InternalException.ProviderErrorException(IErrors.ERROR_CODE_SMP_0601, IErrors.ERROR_MESSAGE_SMP_0601);
        }
    }

    public abstract void putLongForSingleProcess(Context context, String str, long j);

    public void putString(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            SmpLog.m6494e(TAG, "putString error. key null");
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        if (!InitOptionsHolder.getInstance().isMultiprocessMode()) {
            putStringForSingleProcess(this.mContext, str, str2);
            return;
        }
        if (DeviceInfoUtil.isAppDisabled(this.mContext)) {
            SmpLog.m6496he(TAG, this.mContext.getPackageName() + " is disabled. finish...");
            return;
        }
        try {
            Uri uri = Uri.parse(getStringUri() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", str);
            contentValues.put("value", str2);
            this.mContext.getContentResolver().update(uri, contentValues, null, null);
        } catch (Exception e) {
            SmpLog.m6496he(TAG, "Exception putString " + e);
            throw new InternalException.ProviderErrorException(IErrors.ERROR_CODE_SMP_0601, IErrors.ERROR_MESSAGE_SMP_0601);
        }
    }

    public abstract void putStringForSingleProcess(Context context, String str, String str2);

    public void putStringSet(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            SmpLog.m6494e(TAG, "putStringSet error. key null");
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        if (!InitOptionsHolder.getInstance().isMultiprocessMode()) {
            putStringSetForSingleProcess(this.mContext, str, str2);
            return;
        }
        if (DeviceInfoUtil.isAppDisabled(this.mContext)) {
            SmpLog.m6496he(TAG, this.mContext.getPackageName() + " is disabled. finish...");
            return;
        }
        try {
            Uri uri = Uri.parse(getStringSetUri() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", str);
            contentValues.put("value", str2);
            this.mContext.getContentResolver().update(uri, contentValues, null, null);
        } catch (Exception e) {
            SmpLog.m6496he(TAG, "Exception putStringSet " + e);
            throw new InternalException.ProviderErrorException(IErrors.ERROR_CODE_SMP_0601, IErrors.ERROR_MESSAGE_SMP_0601);
        }
    }

    public abstract void putStringSetForSingleProcess(Context context, String str, String str2);

    public void remove(String str) {
        if (TextUtils.isEmpty(str)) {
            SmpLog.m6494e(TAG, "remove error. key null");
            return;
        }
        if (!InitOptionsHolder.getInstance().isMultiprocessMode()) {
            removeForSingleProcess(this.mContext, str);
            return;
        }
        if (DeviceInfoUtil.isAppDisabled(this.mContext)) {
            SmpLog.m6496he(TAG, this.mContext.getPackageName() + " is disabled. finish...");
            return;
        }
        try {
            this.mContext.getContentResolver().delete(Uri.parse(getRemoveUri() + str), null, null);
        } catch (Exception e) {
            SmpLog.m6496he(TAG, "Exception remove " + e);
            throw new InternalException.ProviderErrorException(IErrors.ERROR_CODE_SMP_0601, IErrors.ERROR_MESSAGE_SMP_0601);
        }
    }

    public abstract void removeForSingleProcess(Context context, String str);

    public void removeStringSet(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            SmpLog.m6494e(TAG, "removeStringSet error. key null");
            return;
        }
        if (!InitOptionsHolder.getInstance().isMultiprocessMode()) {
            removeStringSetForSingleProcess(this.mContext, str, str2);
            return;
        }
        if (DeviceInfoUtil.isAppDisabled(this.mContext)) {
            SmpLog.m6496he(TAG, this.mContext.getPackageName() + " is disabled. finish...");
            return;
        }
        try {
            this.mContext.getContentResolver().delete(Uri.parse(getRemoveStringSetUri() + str + "/" + str2), null, null);
        } catch (Exception e) {
            SmpLog.m6496he(TAG, "Exception removeStringSet " + e);
            throw new InternalException.ProviderErrorException(IErrors.ERROR_CODE_SMP_0601, IErrors.ERROR_MESSAGE_SMP_0601);
        }
    }

    public abstract void removeStringSetForSingleProcess(Context context, String str, String str2);
}
