package com.samsung.android.support.senl.p148nt.app.lock.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.biometrics.fingerprint.FingerprintApi;
import com.samsung.android.support.senl.p148nt.app.biometrics.iris.IrisApi;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u001a\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/utils/LockBackupUtil;", "", "<init>", "()V", "PREF_PASSWORD_HASH_BACKUP", "", "PREF_PASSWORD_SALT_BACKUP", "PREF_PASSWORD_ENCRYPTED_HASH_BACKUP", "PREF_PASSWORD_ENCRYPTED_SALT_BACKUP", "PREF_PASSWORD_OWNER_GUID_BACKUP", "PREF_FINGERPRINT_UNIQUE_ID_BACKUP", "PREF_FINGERPRINT_UNIQUE_TIME_BACKUP", "PREF_IRIS_UNIQUE_ID_BACKUP", "PREF_IRIS_UNIQUE_TIME_BACKUP", "backupLockInfo", "", "getPrefPasswordHashBackup", "context", "Landroid/content/Context;", "getPrefPasswordSaltBackup", "getPrefPasswordEncryptedHashBackup", "getPrefPasswordEncryptedSaltBackup", "getPrefFingerprintUniqueTimeBackup", "", "getPrefFingerprintUniqueIdBackup", "", "getPrefIrisUniqueTimeBackup", "getPrefIrisUniqueIdBackup", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LockBackupUtil {

    @NotNull
    public static final LockBackupUtil INSTANCE = new LockBackupUtil();

    @NotNull
    private static final String PREF_FINGERPRINT_UNIQUE_ID_BACKUP = "PrefFingerprintUniqueIdBackup";

    @NotNull
    private static final String PREF_FINGERPRINT_UNIQUE_TIME_BACKUP = "PrefFingerprintUniqueTimeBackup";

    @NotNull
    private static final String PREF_IRIS_UNIQUE_ID_BACKUP = "PrefIrisUniqueIdBackup";

    @NotNull
    private static final String PREF_IRIS_UNIQUE_TIME_BACKUP = "PrefIrisUniqueTimeBackup";

    @NotNull
    private static final String PREF_PASSWORD_ENCRYPTED_HASH_BACKUP = "PrefPasswordEncryptedHashBackup";

    @NotNull
    private static final String PREF_PASSWORD_ENCRYPTED_SALT_BACKUP = "PrefPasswordEncryptedSaltBackup";

    @NotNull
    private static final String PREF_PASSWORD_HASH_BACKUP = "PrefPasswordHadhBackup";

    @NotNull
    private static final String PREF_PASSWORD_OWNER_GUID_BACKUP = "PrefPasswordOwnerBackup";

    @NotNull
    private static final String PREF_PASSWORD_SALT_BACKUP = "PrefPasswordSaltBackup";

    private LockBackupUtil() {
    }

    @JvmStatic
    public static final void backupLockInfo() {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
        if (TextUtils.isEmpty(defaultSharedPreferences.getString(PREF_PASSWORD_ENCRYPTED_SALT_BACKUP, ""))) {
            String prefNotesPasswordHash = LockPrefUtils.getPrefNotesPasswordHash(applicationContext);
            String prefNotesPasswordSalt = LockPrefUtils.getPrefNotesPasswordSalt(applicationContext);
            String encryptedPasswordHash = LockUtils.getEncryptedPasswordHash(applicationContext);
            String encryptedPasswordSalt = LockUtils.getEncryptedPasswordSalt(applicationContext);
            editorEdit.putString(PREF_PASSWORD_HASH_BACKUP, prefNotesPasswordHash);
            editorEdit.putString(PREF_PASSWORD_SALT_BACKUP, prefNotesPasswordSalt);
            editorEdit.putString(PREF_PASSWORD_ENCRYPTED_HASH_BACKUP, encryptedPasswordHash);
            editorEdit.putString(PREF_PASSWORD_ENCRYPTED_SALT_BACKUP, encryptedPasswordSalt);
            String localUserID = LockPrefUtils.getLocalUserID(applicationContext);
            String localPasswordOwnerGuid = LockPrefUtils.getLocalPasswordOwnerGuid(applicationContext);
            if (TextUtils.isEmpty(localUserID)) {
                editorEdit.putString(PREF_PASSWORD_OWNER_GUID_BACKUP, localPasswordOwnerGuid);
            } else {
                editorEdit.putString(PREF_PASSWORD_OWNER_GUID_BACKUP, "");
            }
            if (Build.VERSION.SDK_INT > 26) {
                if (new FingerprintApi().hasEnrolledFingerprint(applicationContext)) {
                    long prefFingerprintUniqueTime = LockPrefUtils.getPrefFingerprintUniqueTime(applicationContext);
                    if (prefFingerprintUniqueTime > 0) {
                        editorEdit.putLong(PREF_FINGERPRINT_UNIQUE_TIME_BACKUP, prefFingerprintUniqueTime);
                    } else {
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        editorEdit.putLong(PREF_FINGERPRINT_UNIQUE_TIME_BACKUP, jElapsedRealtime);
                        LockPrefUtils.setPrefFingerprintUniqueTime(applicationContext, jElapsedRealtime);
                    }
                }
                if (new IrisApi().hasEnrolledIris(applicationContext)) {
                    long prefIrisUniqueTime = LockPrefUtils.getPrefIrisUniqueTime(applicationContext);
                    if (prefIrisUniqueTime > 0) {
                        editorEdit.putLong(PREF_IRIS_UNIQUE_TIME_BACKUP, prefIrisUniqueTime);
                    } else {
                        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                        editorEdit.putLong(PREF_IRIS_UNIQUE_TIME_BACKUP, jElapsedRealtime2);
                        LockPrefUtils.setPrefIrisUniqueTime(applicationContext, jElapsedRealtime2);
                    }
                }
            } else {
                editorEdit.putStringSet(PREF_FINGERPRINT_UNIQUE_ID_BACKUP, LockPrefUtils.getPrefFingerprintUniqueId(applicationContext));
                editorEdit.putString(PREF_IRIS_UNIQUE_ID_BACKUP, LockPrefUtils.getPrefIrisUniqueId(applicationContext));
            }
            editorEdit.apply();
        }
    }

    @JvmStatic
    @Nullable
    public static final Set<String> getPrefFingerprintUniqueIdBackup(@Nullable Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getStringSet(PREF_FINGERPRINT_UNIQUE_ID_BACKUP, null);
    }

    @JvmStatic
    public static final long getPrefFingerprintUniqueTimeBackup(@Nullable Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(PREF_FINGERPRINT_UNIQUE_TIME_BACKUP, 0L);
    }

    @JvmStatic
    @Nullable
    public static final String getPrefIrisUniqueIdBackup(@Nullable Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(PREF_IRIS_UNIQUE_ID_BACKUP, "");
    }

    @JvmStatic
    public static final long getPrefIrisUniqueTimeBackup(@Nullable Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(PREF_IRIS_UNIQUE_TIME_BACKUP, 0L);
    }

    @JvmStatic
    @Nullable
    public static final String getPrefPasswordEncryptedHashBackup(@Nullable Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(PREF_PASSWORD_ENCRYPTED_HASH_BACKUP, "");
    }

    @JvmStatic
    @Nullable
    public static final String getPrefPasswordEncryptedSaltBackup(@Nullable Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(PREF_PASSWORD_ENCRYPTED_SALT_BACKUP, "");
    }

    @Nullable
    public final String getPrefPasswordHashBackup(@Nullable Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(PREF_PASSWORD_HASH_BACKUP, "");
    }

    @Nullable
    public final String getPrefPasswordSaltBackup(@Nullable Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(PREF_PASSWORD_SALT_BACKUP, "");
    }
}
