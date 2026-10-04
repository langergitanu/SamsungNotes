package com.samsung.android.support.senl.p148nt.app.lock.model.password;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.framework.constructor.JavaInstanceConstructor;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockBackupUtil;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.PasswordEncryptUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bJ\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014J\u001a\u0010\u0015\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/model/password/PasswordModel;", "", "<init>", "()V", "mEncryptedNotesPasswordHash", "", "mEncryptedNotesPasswordSalt", "mIsOldPasswordVerification", "", "setEncryptedHashAndSalt", "", "hash", "salt", "setIsOldPasswordVerification", "isOldPasswordVerification", "savePassword", "context", "Landroid/content/Context;", "password", "onSaveResultListener", "Lcom/samsung/android/support/senl/nt/app/lock/model/password/PasswordModel$OnSaveResultListener;", "verifyPassword", "getPasswordHash", "getPasswordSalt", "storePassword", "encryptUserInfo", "OnSaveResultListener", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PasswordModel {

    @NotNull
    private static final String SYNC_PREFERENCE_LOCAL_PASSWORD_USER_ID_KEY = "UserIdForLocalPasswordKey";

    @NotNull
    private static final String SYNC_PREFERENCE_USER_ID_NAME = "UserIdForSync";

    @Nullable
    private String mEncryptedNotesPasswordHash;

    @Nullable
    private String mEncryptedNotesPasswordSalt;
    private boolean mIsOldPasswordVerification;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = LockLogger.createTag("PasswordModel");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/model/password/PasswordModel$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "SYNC_PREFERENCE_USER_ID_NAME", "SYNC_PREFERENCE_LOCAL_PASSWORD_USER_ID_KEY", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return PasswordModel.TAG;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/model/password/PasswordModel$OnSaveResultListener;", "", "onSuccess", "", "onFailure", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnSaveResultListener {
        void onFailure();

        void onSuccess();
    }

    private final void encryptUserInfo(Context context) {
        String str = TAG;
        LockLogger.m7358i(str, "convert information");
        String strEncryptString = PasswordEncryptUtils.encryptString(context, LockPrefUtils.getPrefNotesPasswordHash(context));
        String strEncryptString2 = PasswordEncryptUtils.encryptString(context, LockPrefUtils.getPrefNotesPasswordSalt(context));
        if (strEncryptString == null || strEncryptString2 == null) {
            LockLogger.m7357e(str, "Fail to encrypt data.");
        } else {
            LockUtils.setEncryptedPasswordHashAndSalt(context, strEncryptString, strEncryptString2, LockUtils.NotesPasswordHashSaltBy.LOCK.value);
        }
    }

    private final String getPasswordHash(Context context) {
        return this.mIsOldPasswordVerification ? LockBackupUtil.INSTANCE.getPrefPasswordHashBackup(context) : LockPrefUtils.getPrefNotesPasswordHash(context);
    }

    private final String getPasswordSalt(Context context) {
        return this.mIsOldPasswordVerification ? LockBackupUtil.INSTANCE.getPrefPasswordSaltBackup(context) : LockPrefUtils.getPrefNotesPasswordSalt(context);
    }

    private final boolean storePassword(Context context, String password) {
        if (LockPrefUtils.isPrefUserAuthInfoNull(context)) {
            LockLogger.m7357e(TAG, "Fail to store password 1");
            return false;
        }
        byte[] bArr = new byte[32];
        JavaInstanceConstructor.getSecureRandom().nextBytes(bArr);
        byte[] secureHash = PasswordEncryptUtils.getSecureHash(password, bArr);
        if (secureHash == null) {
            LockLogger.m7357e(TAG, "Fail to store password 2");
            return false;
        }
        String strEncryptBytes = PasswordEncryptUtils.encryptBytes(context, secureHash);
        String strEncryptBytes2 = PasswordEncryptUtils.encryptBytes(context, bArr);
        if (strEncryptBytes == null || strEncryptBytes2 == null) {
            LockLogger.m7357e(TAG, "Fail to store password 3");
            return false;
        }
        LockUtils.setEncryptedPasswordHashAndSalt(context, strEncryptBytes, strEncryptBytes2, LockUtils.NotesPasswordHashSaltBy.LOCK.value);
        return true;
    }

    public final void savePassword(@NotNull Context context, @NotNull String password, @NotNull OnSaveResultListener onSaveResultListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(onSaveResultListener, "onSaveResultListener");
        if (storePassword(context, password)) {
            onSaveResultListener.onSuccess();
        } else {
            onSaveResultListener.onFailure();
        }
    }

    public final void setEncryptedHashAndSalt(@Nullable String hash, @Nullable String salt) {
        this.mEncryptedNotesPasswordHash = hash;
        this.mEncryptedNotesPasswordSalt = salt;
    }

    public final void setIsOldPasswordVerification(boolean isOldPasswordVerification) {
        this.mIsOldPasswordVerification = isOldPasswordVerification;
    }

    public final boolean verifyPassword(@Nullable Context context, @Nullable String password) {
        String passwordHash;
        String passwordSalt;
        String str = TAG;
        LockLogger.m7356d(str, "verifyPassword Start");
        if (DeviceUtils.isDemoDevice(context)) {
            return true;
        }
        if (password == null || password.length() == 0 || context == null) {
            LockLogger.m7356d(str, "verify password - invalid argument");
            return false;
        }
        LockLogger.m7356d(str, "verifyPassword getAuthInfo");
        if (LockPrefUtils.isPrefUserAuthInfoNull(context)) {
            return false;
        }
        LockLogger.m7356d(str, "verifyPassword start get hash info");
        if (TextUtils.isEmpty(this.mEncryptedNotesPasswordHash) || TextUtils.isEmpty(this.mEncryptedNotesPasswordSalt)) {
            LockLogger.m7358i(str, "vP - old data");
            passwordHash = getPasswordHash(context);
            if (passwordHash == null || passwordHash.length() == 0) {
                LockPrefUtils.getOldUserInfo(context);
                passwordHash = getPasswordHash(context);
                if (passwordHash == null || passwordHash.length() == 0) {
                    return false;
                }
            }
            passwordSalt = getPasswordSalt(context);
            encryptUserInfo(context);
        } else {
            LockLogger.m7356d(str, "verifyPassword Start decrypt Hash");
            passwordHash = PasswordEncryptUtils.decryptString$default(this.mEncryptedNotesPasswordHash, null, 2, null);
            passwordSalt = PasswordEncryptUtils.decryptString$default(this.mEncryptedNotesPasswordSalt, null, 2, null);
            if (passwordHash == null || passwordSalt == null) {
                LockLogger.m7358i(str, "verify password - invalid state 2");
                return false;
            }
            LockLogger.m7356d(str, "verifyPassword end decrypt Hash");
        }
        LockLogger.m7356d(str, "verifyPassword start cur hash");
        byte[] secureHash = PasswordEncryptUtils.getSecureHash(password, PasswordEncryptUtils.getByteArray(passwordSalt));
        if (secureHash == null) {
            return false;
        }
        LockLogger.m7356d(str, "verifyPassword end cur hash");
        String hexString = PasswordEncryptUtils.getHexString(secureHash);
        if (hexString == null) {
            return false;
        }
        if (Intrinsics.areEqual(hexString, passwordHash)) {
            LockLogger.m7356d(str, "verify password - success");
            return true;
        }
        LockLogger.m7356d(str, "verify password - fail, last updated by " + LockUtils.getEncryptedPasswordHashAndSaltBy(context));
        return false;
    }
}
