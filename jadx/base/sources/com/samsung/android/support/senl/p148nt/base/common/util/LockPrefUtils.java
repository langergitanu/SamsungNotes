package com.samsung.android.support.senl.p148nt.base.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.samsung.android.support.senl.p145cm.base.common.util.HashUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\"\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\u001c\u0010 \u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010#\u001a\u00020$2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\u001a\u0010%\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010&\u001a\u00020$H\u0007J\u0012\u0010'\u001a\u00020(2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\u001a\u0010)\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010*\u001a\u00020(H\u0007J\u0012\u0010+\u001a\u00020(2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\u001a\u0010,\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010*\u001a\u00020(H\u0007J\u0010\u0010-\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J.\u0010.\u001a\u00020/2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u00100\u001a\u0004\u0018\u00010\u00052\b\u00101\u001a\u0004\u0018\u00010\u00052\b\u00102\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u00103\u001a\u00020/2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u00104\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u001a\u00104\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u00105\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u00105\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u0005H\u0002J\u0010\u00106\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u001a\u00107\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u00108\u001a\u00020/H\u0007J\u0012\u00109\u001a\u00020/2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\u001a\u0010:\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u00108\u001a\u00020/H\u0007J\u0012\u0010;\u001a\u00020/2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\u001a\u0010<\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u00108\u001a\u00020/H\u0007J\u0012\u0010=\u001a\u00020/2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\u001a\u0010>\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u00108\u001a\u00020/H\u0007J\u0012\u0010?\u001a\u00020/2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\u0010\u0010@\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0012\u0010A\u001a\u00020/2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\u0010\u0010B\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0012\u0010C\u001a\u00020/2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\"\u0010D\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001f2\u0010\u0010E\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010FH\u0007J\u0018\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010F2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010H\u001a\u00020(2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u0010I\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020(H\u0007J\u001a\u0010J\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010K\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010L\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u0010M\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020(H\u0007J\u0010\u0010N\u001a\u00020(2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0012\u0010O\u001a\u00020$2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\u001a\u0010P\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010Q\u001a\u00020$H\u0007J\u0012\u0010R\u001a\u00020(2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\u001a\u0010S\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010*\u001a\u00020(H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006T"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/LockPrefUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "PREF_NOTES_PASSWORD_HASH", "PREF_NOTES_PASSWORD_SALT", "SYNC_PREFERENCE_USER_ID_NAME", "SYNC_PREFERENCE_LOCAL_PASSWORD_USER_ID_KEY", "PREF_USE_FINGERPRINT", "PREF_USE_IRIS", "PREF_FINGERPRINT_CHANGED", "PREF_IRIS_CHANGED", "PREF_AVAILABLE_FINGERPRINT", "PREF_AVAILABLE_IRIS", "PREF_BIOMETRICS_UNIQUE_ID_KEY", "PREF_FINGERPRINT_UNIQUE_ID", "PREF_FINGERPRINT_UNIQUE_TIME", "PREF_IRIS_UNIQUE_ID", "PREF_IRIS_UNIQUE_TIME", "PREF_NAME_USER_AUTH_INFO", "PREF_OLD_BIOMETRIC_METHOD_FAIL_COUNT", "PREF_OLD_BIOMETRIC_METHOD_BLOCK_END_TIME", "PREF_UNLOCK_TRY_COUNT", "PREF_NAME_VERSION_NAME", "BLOCK_END_TIME", "BLOCK_END_TIME_BIOMETRIC", "LOCAL_PASSWORD_OWNER_GUID", "getLocalPasswordOwnerGuid", "context", "Landroid/content/Context;", "setLocalPasswordOwnerGuid", "", "guid", "getUnlockTryCount", "", "setUnlockTryCount", "count", "getBlockEndTime", "", "setBlockEndTime", "time", "getBlockEndTimeBiometric", "setBlockEndTimeBiometric", "getOldUserInfo", "backUpData", "", "tempName", "hashStr", "saltStr", "isPrefUserAuthInfoNull", "getPrefNotesPasswordHash", "getPrefNotesPasswordSalt", "getLocalUserID", "setPrefUseFingerprint", "state", "getPrefUseFingerprint", "setPrefFingerprintChanged", "getPrefFingerprintChanged", "setPrefUseIris", "getPrefUseIris", "setPrefIrisChanged", "getPrefIrisChanged", "setPrefAvailableFingerprint", "getPrefAvailableFingerprint", "setPrefAvailableIris", "getPrefAvailableIris", "setPrefFingerprintUniqueId", "uniqueIDList", "", "getPrefFingerprintUniqueId", "getPrefFingerprintUniqueTime", "setPrefFingerprintUniqueTime", "setPrefIrisUniqueId", "irisUniqueId", "getPrefIrisUniqueId", "setPrefIrisUniqueTime", "getPrefIrisUniqueTime", "getOldBiometricMethodFailCount", "setOldBiometricMethodFailCount", "failCount", "getOldBiometricMethodBlockEndTime", "setOldBiometricMethodBlockEndTime", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LockPrefUtils {

    @NotNull
    private static final String BLOCK_END_TIME = "BlockEndTime";

    @NotNull
    private static final String BLOCK_END_TIME_BIOMETRIC = "BlockEndTimeBiometric";

    @NotNull
    public static final LockPrefUtils INSTANCE = new LockPrefUtils();

    @NotNull
    private static final String LOCAL_PASSWORD_OWNER_GUID = "local_password_owner";

    @NotNull
    private static final String PREF_AVAILABLE_FINGERPRINT = "AvailableFingerprint_SEC";

    @NotNull
    private static final String PREF_AVAILABLE_IRIS = "AvailableIris";

    @NotNull
    private static final String PREF_BIOMETRICS_UNIQUE_ID_KEY = "UniqueID_Key";

    @NotNull
    private static final String PREF_FINGERPRINT_CHANGED = "FingerprintChanged";

    @NotNull
    private static final String PREF_FINGERPRINT_UNIQUE_ID = "FingerprintUniqueID";

    @NotNull
    private static final String PREF_FINGERPRINT_UNIQUE_TIME = "FingerprintUniqueTime";

    @NotNull
    private static final String PREF_IRIS_CHANGED = "IrisChanged";

    @NotNull
    private static final String PREF_IRIS_UNIQUE_ID = "IrisUniqueID";

    @NotNull
    private static final String PREF_IRIS_UNIQUE_TIME = "IrisUniqueTime";

    @NotNull
    private static final String PREF_NAME_USER_AUTH_INFO = "UserAuthInfo";

    @NotNull
    private static final String PREF_NAME_VERSION_NAME = "VersionName";

    @NotNull
    private static final String PREF_NOTES_PASSWORD_HASH = "NotesPasswordHash";

    @NotNull
    private static final String PREF_NOTES_PASSWORD_SALT = "NotesPasswordSalt";

    @NotNull
    private static final String PREF_OLD_BIOMETRIC_METHOD_BLOCK_END_TIME = "OldBiometricMethodBlockEndTime";

    @NotNull
    private static final String PREF_OLD_BIOMETRIC_METHOD_FAIL_COUNT = "OldBiometricMethodFailCount";

    @NotNull
    private static final String PREF_UNLOCK_TRY_COUNT = "UNLOCK_TRY_COUNT";

    @NotNull
    private static final String PREF_USE_FINGERPRINT = "UseFingerprint_SEC";

    @NotNull
    private static final String PREF_USE_IRIS = "UseIris";

    @NotNull
    private static final String SYNC_PREFERENCE_LOCAL_PASSWORD_USER_ID_KEY = "UserIdForLocalPasswordKey";

    @NotNull
    private static final String SYNC_PREFERENCE_USER_ID_NAME = "UserIdForSync";

    @NotNull
    private static final String TAG = "LockPrefUtils";

    private LockPrefUtils() {
    }

    @JvmStatic
    public static final boolean backUpData(@NotNull Context context, @Nullable String tempName, @Nullable String hashStr, @Nullable String saltStr) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(tempName, 0).edit();
        editorEdit.putString(PREF_NAME_VERSION_NAME, PackageManagerCompat.INSTANCE.getInstance().getVersionInfo(context));
        editorEdit.putString(PREF_NOTES_PASSWORD_HASH, hashStr);
        editorEdit.putString(PREF_NOTES_PASSWORD_SALT, saltStr);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editorEdit.putBoolean(PREF_USE_FINGERPRINT, defaultSharedPreferences.getBoolean(PREF_USE_FINGERPRINT, false));
        editorEdit.putBoolean(PREF_USE_IRIS, defaultSharedPreferences.getBoolean(PREF_USE_IRIS, false));
        return editorEdit.commit();
    }

    @JvmStatic
    public static final long getBlockEndTime(@Nullable Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(BLOCK_END_TIME, 0L);
    }

    @JvmStatic
    public static final long getBlockEndTimeBiometric(@Nullable Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(BLOCK_END_TIME_BIOMETRIC, 0L);
    }

    @JvmStatic
    @Nullable
    public static final String getLocalPasswordOwnerGuid(@Nullable Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString(LOCAL_PASSWORD_OWNER_GUID, "");
        if (HashUtils.isHashed(string)) {
            return string;
        }
        String strGenerateSha256 = HashUtils.generateSha256(string);
        setLocalPasswordOwnerGuid(context, strGenerateSha256);
        return strGenerateSha256;
    }

    @JvmStatic
    @NotNull
    public static final String getLocalUserID(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getSharedPreferences(SYNC_PREFERENCE_USER_ID_NAME, 0).getString(SYNC_PREFERENCE_LOCAL_PASSWORD_USER_ID_KEY, "");
        return string == null ? "" : string;
    }

    @JvmStatic
    public static final long getOldBiometricMethodBlockEndTime(@Nullable Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(PREF_OLD_BIOMETRIC_METHOD_BLOCK_END_TIME, 0L);
    }

    @JvmStatic
    public static final int getOldBiometricMethodFailCount(@Nullable Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(PREF_OLD_BIOMETRIC_METHOD_FAIL_COUNT, 0);
    }

    @JvmStatic
    public static final void getOldUserInfo(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREF_NAME_USER_AUTH_INFO, 0).edit();
        editorEdit.putString(PREF_NOTES_PASSWORD_HASH, defaultSharedPreferences.getString(PREF_NOTES_PASSWORD_HASH, ""));
        editorEdit.putString(PREF_NOTES_PASSWORD_SALT, defaultSharedPreferences.getString(PREF_NOTES_PASSWORD_SALT, ""));
        editorEdit.apply();
        SharedPreferences.Editor editorEdit2 = defaultSharedPreferences.edit();
        editorEdit2.remove(PREF_NOTES_PASSWORD_HASH);
        editorEdit2.remove(PREF_NOTES_PASSWORD_SALT);
        editorEdit2.apply();
    }

    @JvmStatic
    public static final boolean getPrefAvailableFingerprint(@Nullable Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREF_AVAILABLE_FINGERPRINT, false);
    }

    @JvmStatic
    public static final boolean getPrefAvailableIris(@Nullable Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREF_AVAILABLE_IRIS, false);
    }

    @JvmStatic
    public static final boolean getPrefFingerprintChanged(@Nullable Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREF_FINGERPRINT_CHANGED, false);
    }

    @JvmStatic
    @Nullable
    public static final Set<String> getPrefFingerprintUniqueId(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getSharedPreferences(PREF_FINGERPRINT_UNIQUE_ID, 0).getStringSet(PREF_BIOMETRICS_UNIQUE_ID_KEY, new HashSet());
    }

    @JvmStatic
    public static final long getPrefFingerprintUniqueTime(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getSharedPreferences(PREF_FINGERPRINT_UNIQUE_TIME, 0).getLong(PREF_BIOMETRICS_UNIQUE_ID_KEY, 0L);
    }

    @JvmStatic
    public static final boolean getPrefIrisChanged(@Nullable Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREF_IRIS_CHANGED, false);
    }

    @JvmStatic
    @Nullable
    public static final String getPrefIrisUniqueId(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getSharedPreferences(PREF_IRIS_UNIQUE_ID, 0).getString(PREF_BIOMETRICS_UNIQUE_ID_KEY, null);
    }

    @JvmStatic
    public static final long getPrefIrisUniqueTime(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getSharedPreferences(PREF_IRIS_UNIQUE_TIME, 0).getLong(PREF_BIOMETRICS_UNIQUE_ID_KEY, 0L);
    }

    @JvmStatic
    @NotNull
    public static final String getPrefNotesPasswordHash(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return INSTANCE.getPrefNotesPasswordHash(context, PREF_NAME_USER_AUTH_INFO);
    }

    @JvmStatic
    @NotNull
    public static final String getPrefNotesPasswordSalt(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return INSTANCE.getPrefNotesPasswordSalt(context, PREF_NAME_USER_AUTH_INFO);
    }

    @JvmStatic
    public static final boolean getPrefUseFingerprint(@Nullable Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREF_USE_FINGERPRINT, false);
    }

    @JvmStatic
    public static final boolean getPrefUseIris(@Nullable Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREF_USE_IRIS, false);
    }

    @JvmStatic
    public static final int getUnlockTryCount(@Nullable Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(PREF_UNLOCK_TRY_COUNT, 0);
    }

    @JvmStatic
    public static final boolean isPrefUserAuthInfoNull(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getSharedPreferences(PREF_NAME_USER_AUTH_INFO, 0) == null;
    }

    @JvmStatic
    public static final void setBlockEndTime(@Nullable Context context, long time) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putLong(BLOCK_END_TIME, time);
        editorEdit.apply();
    }

    @JvmStatic
    public static final void setBlockEndTimeBiometric(@Nullable Context context, long time) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putLong(BLOCK_END_TIME_BIOMETRIC, time);
        editorEdit.apply();
    }

    @JvmStatic
    public static final void setLocalPasswordOwnerGuid(@Nullable Context context, @Nullable String guid) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putString(LOCAL_PASSWORD_OWNER_GUID, guid);
        editorEdit.apply();
    }

    @JvmStatic
    public static final void setOldBiometricMethodBlockEndTime(@Nullable Context context, long time) {
        LoggerBase.INSTANCE.m7132d(TAG, "setOldBiometricMethodBlockEndTime : " + time);
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putLong(PREF_OLD_BIOMETRIC_METHOD_BLOCK_END_TIME, time);
        editorEdit.apply();
    }

    @JvmStatic
    public static final void setOldBiometricMethodFailCount(@Nullable Context context, int failCount) {
        LoggerBase.INSTANCE.m7132d(TAG, "setOldBiometricMethodFailCount : " + failCount);
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putInt(PREF_OLD_BIOMETRIC_METHOD_FAIL_COUNT, failCount);
        editorEdit.apply();
    }

    @JvmStatic
    public static final void setPrefFingerprintChanged(@Nullable Context context, boolean state) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putBoolean(PREF_FINGERPRINT_CHANGED, state);
        editorEdit.apply();
    }

    @JvmStatic
    public static final void setPrefFingerprintUniqueId(@NotNull Context context, @Nullable Set<String> uniqueIDList) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREF_FINGERPRINT_UNIQUE_ID, 0).edit();
        editorEdit.putStringSet(PREF_BIOMETRICS_UNIQUE_ID_KEY, uniqueIDList);
        editorEdit.apply();
    }

    @JvmStatic
    public static final void setPrefFingerprintUniqueTime(@NotNull Context context, long time) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREF_FINGERPRINT_UNIQUE_TIME, 0).edit();
        editorEdit.putLong(PREF_BIOMETRICS_UNIQUE_ID_KEY, time);
        editorEdit.apply();
    }

    @JvmStatic
    public static final void setPrefIrisChanged(@Nullable Context context, boolean state) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putBoolean(PREF_IRIS_CHANGED, state);
        editorEdit.apply();
    }

    @JvmStatic
    public static final void setPrefIrisUniqueId(@NotNull Context context, @Nullable String irisUniqueId) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREF_IRIS_UNIQUE_ID, 0).edit();
        editorEdit.putString(PREF_BIOMETRICS_UNIQUE_ID_KEY, irisUniqueId);
        editorEdit.apply();
    }

    @JvmStatic
    public static final void setPrefIrisUniqueTime(@NotNull Context context, long time) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREF_IRIS_UNIQUE_TIME, 0).edit();
        editorEdit.putLong(PREF_BIOMETRICS_UNIQUE_ID_KEY, time);
        editorEdit.apply();
    }

    @JvmStatic
    public static final void setPrefUseFingerprint(@Nullable Context context, boolean state) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putBoolean(PREF_USE_FINGERPRINT, state);
        editorEdit.apply();
    }

    @JvmStatic
    public static final void setPrefUseIris(@Nullable Context context, boolean state) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putBoolean(PREF_USE_IRIS, state);
        editorEdit.apply();
    }

    @JvmStatic
    public static final void setUnlockTryCount(@Nullable Context context, int count) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putInt(PREF_UNLOCK_TRY_COUNT, count);
        editorEdit.apply();
    }

    public final void setPrefAvailableFingerprint(@Nullable Context context) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putBoolean(PREF_AVAILABLE_FINGERPRINT, true);
        editorEdit.apply();
    }

    public final void setPrefAvailableIris(@Nullable Context context) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putBoolean(PREF_AVAILABLE_IRIS, true);
        editorEdit.apply();
    }

    private final String getPrefNotesPasswordHash(Context context, String tempName) {
        String string = context.getSharedPreferences(tempName, 0).getString(PREF_NOTES_PASSWORD_HASH, "");
        return string == null ? "" : string;
    }

    private final String getPrefNotesPasswordSalt(Context context, String tempName) {
        String string = context.getSharedPreferences(tempName, 0).getString(PREF_NOTES_PASSWORD_SALT, "");
        return string == null ? "" : string;
    }
}
