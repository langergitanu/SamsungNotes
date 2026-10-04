package com.samsung.android.support.senl.p148nt.base.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.p145cm.base.common.constants.LockType;
import com.samsung.android.support.senl.p145cm.base.common.util.HashUtils;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserManagerCompat;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001CB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J\u0012\u0010\u0017\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J,\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\fH\u0007J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J\u0014\u0010 \u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J(\u0010!\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\fH\u0007J\u0010\u0010$\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J \u0010%\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0013H\u0007J\u001a\u0010(\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u001c\u0010*\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010+\u001a\u0004\u0018\u00010\u0005H\u0002J\u001c\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010+\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020/H\u0007J\u0010\u0010-\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u0005H\u0007J\u0012\u00101\u001a\u00020\u00132\b\u00102\u001a\u0004\u0018\u00010\u0005H\u0007J0\u00103\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u00010\u00052\b\u00104\u001a\u0004\u0018\u00010\u00052\b\u00105\u001a\u0004\u0018\u00010\u00052\b\u00106\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u00103\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u00010\u00052\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010;\u001a\u00020\u00132\b\b\u0001\u0010<\u001a\u00020\fH\u0007J\u0012\u0010=\u001a\u00020\u00132\b\b\u0001\u0010<\u001a\u00020\fH\u0007J\u0012\u0010>\u001a\u00020\u00132\b\b\u0001\u0010<\u001a\u00020\fH\u0007J\u0012\u0010?\u001a\u00020\u00132\b\b\u0001\u0010<\u001a\u00020\fH\u0007J\u0012\u0010@\u001a\u00020\u00052\b\b\u0001\u0010<\u001a\u00020\fH\u0007J\u0014\u0010A\u001a\u0004\u0018\u00010\u00052\b\u0010B\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R \u00107\u001a\b\u0012\u0004\u0012\u00020\f0\u00118FX\u0087\u0004¢\u0006\f\u0012\u0004\b8\u0010\u0003\u001a\u0004\b9\u0010:¨\u0006D"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/LockUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "PREF_NAME_USER_AUTH_INFO", "PREF_NOTES_PASSWORD_HASH", "PREF_NOTES_PASSWORD_SALT", "PREF_ENCRYPTED_NOTES_PASSWORD_HASH", "PREF_ENCRYPTED_NOTES_PASSWORD_SALT", "OWNER_CHECK_RESULT_OK", "", "OWNER_CHECK_RESULT_NO_CURRENT_GUID", "OWNER_CHECK_RESULT_DIFFERENT_USER", "PREF_NOTES_PASSWORD_HASH_SALT_UPDATED_BY", "sLegacyLockTypes", "", "isLockMenuEnabled", "", "context", "Landroid/content/Context;", "isBiometricDisabledMode", "isSetPassword", "setPasswordHashAndSalt", "", "passwordHash", "passwordSalt", "by", "getPasswordHash", "getPasswordSalt", "getEncryptedPasswordHash", "getEncryptedPasswordSalt", "setEncryptedPasswordHashAndSalt", "encryptedHashStr", "encryptedSaltStr", "getEncryptedPasswordHashAndSaltBy", "updateUserAuthInfo", "filePath", "synced", "backupSettings", "destDir", "getPrefNotesPasswordHash", "tempName", "getPrefNotesPasswordSalt", "isLocked", "wNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "docPath", "isEmptyGuid", "noteGUID", "isNoteOwner", "currentGUID", "oldAccountName", "currentAccountName", "unlockedDocTypes", "getUnlockedDocTypes$annotations", "getUnlockedDocTypes", "()Ljava/util/List;", "isUnLockedDocType", "lockType", "isLockedSdocType", "isLockedOtherDocType", "isLockedType", "lockTypeToString", "getHashedAccountGuid", "accountGuid", "NotesPasswordHashSaltBy", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LockUtils {
    public static final int OWNER_CHECK_RESULT_DIFFERENT_USER = 3;
    private static final int OWNER_CHECK_RESULT_NO_CURRENT_GUID = 2;
    public static final int OWNER_CHECK_RESULT_OK = 1;

    @NotNull
    private static final String PREF_ENCRYPTED_NOTES_PASSWORD_HASH = "NotesPasswordHash_enc";

    @NotNull
    private static final String PREF_ENCRYPTED_NOTES_PASSWORD_SALT = "NotesPasswordSalt_enc";

    @NotNull
    private static final String PREF_NAME_USER_AUTH_INFO = "UserAuthInfo";

    @NotNull
    private static final String PREF_NOTES_PASSWORD_HASH = "NotesPasswordHash";

    @NotNull
    private static final String PREF_NOTES_PASSWORD_HASH_SALT_UPDATED_BY = "NotesPasswordHashSalt_by";

    @NotNull
    private static final String PREF_NOTES_PASSWORD_SALT = "NotesPasswordSalt";

    @NotNull
    private static final String TAG = "LockUtils";

    @NotNull
    public static final LockUtils INSTANCE = new LockUtils();

    @JvmField
    @NotNull
    public static final List<Integer> sLegacyLockTypes = CollectionsKt.listOf((Object[]) new Integer[]{2, 3, 4});

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/LockUtils$NotesPasswordHashSaltBy;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "UNKNOWN", "LOCK", "SYNC", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class NotesPasswordHashSaltBy {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ NotesPasswordHashSaltBy[] $VALUES;

        @JvmField
        public final int value;
        public static final NotesPasswordHashSaltBy UNKNOWN = new NotesPasswordHashSaltBy("UNKNOWN", 0, 0);
        public static final NotesPasswordHashSaltBy LOCK = new NotesPasswordHashSaltBy("LOCK", 1, 1);
        public static final NotesPasswordHashSaltBy SYNC = new NotesPasswordHashSaltBy("SYNC", 2, 2);

        private static final /* synthetic */ NotesPasswordHashSaltBy[] $values() {
            return new NotesPasswordHashSaltBy[]{UNKNOWN, LOCK, SYNC};
        }

        static {
            NotesPasswordHashSaltBy[] notesPasswordHashSaltByArr$values = $values();
            $VALUES = notesPasswordHashSaltByArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(notesPasswordHashSaltByArr$values);
        }

        private NotesPasswordHashSaltBy(String str, int i, int i2) {
            this.value = i2;
        }

        @NotNull
        public static EnumEntries<NotesPasswordHashSaltBy> getEntries() {
            return $ENTRIES;
        }

        public static NotesPasswordHashSaltBy valueOf(String str) {
            return (NotesPasswordHashSaltBy) Enum.valueOf(NotesPasswordHashSaltBy.class, str);
        }

        public static NotesPasswordHashSaltBy[] values() {
            return (NotesPasswordHashSaltBy[]) $VALUES.clone();
        }
    }

    private LockUtils() {
    }

    private final boolean backupSettings(Context context, String destDir) {
        String prefNotesPasswordHash;
        String prefNotesPasswordSalt;
        Boolean boolValueOf;
        Logger.m8702i(TAG, "backupSettings");
        if (destDir == null || destDir.length() == 0) {
            Logger.m8698e(TAG, "dest path is invalid");
            return false;
        }
        String encryptedPasswordHash = getEncryptedPasswordHash(context);
        String encryptedPasswordSalt = getEncryptedPasswordSalt(context);
        if (encryptedPasswordHash == null || encryptedPasswordHash.length() <= 0 || encryptedPasswordSalt == null || encryptedPasswordSalt.length() <= 0) {
            Logger.m8702i(TAG, "old data");
            prefNotesPasswordHash = LockPrefUtils.getPrefNotesPasswordHash(context);
            if (prefNotesPasswordHash != null && prefNotesPasswordHash.length() == 0) {
                LockPrefUtils.getOldUserInfo(context);
                prefNotesPasswordHash = LockPrefUtils.getPrefNotesPasswordHash(context);
                if (prefNotesPasswordHash != null) {
                    boolValueOf = Boolean.valueOf(prefNotesPasswordHash.length() == 0);
                } else {
                    boolValueOf = null;
                }
                Intrinsics.checkNotNull(boolValueOf);
                if (boolValueOf.booleanValue()) {
                    Logger.m8702i(TAG, "No setting data");
                    return false;
                }
            }
            prefNotesPasswordSalt = LockPrefUtils.getPrefNotesPasswordSalt(context);
        } else {
            prefNotesPasswordHash = PasswordEncryptUtils.decryptString$default(encryptedPasswordHash, null, 2, null);
            prefNotesPasswordSalt = PasswordEncryptUtils.decryptString$default(encryptedPasswordSalt, null, 2, null);
            if (prefNotesPasswordHash == null || prefNotesPasswordSalt == null) {
                Logger.m8702i(TAG, "No setting data");
                return false;
            }
        }
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        if (!LockPrefUtils.backUpData(context, string, prefNotesPasswordHash, prefNotesPasswordSalt)) {
            Logger.m8698e(TAG, "Fail to backup settings.");
            return false;
        }
        String parent = context.getFilesDir().getParent();
        File file = new File(AbstractC0541b.m757C(parent != null ? parent.concat("/shared_prefs/") : null, string, ".xml"));
        if (!file.exists()) {
            Logger.m8698e(TAG, "Fail to make backup file");
            return false;
        }
        File file2 = new File(AbstractC0541b.m756B(destDir, "/LockSettings_backup.xml"));
        if (file2.exists() && !file2.delete()) {
            Logger.m8702i(TAG, "backupSettings - destFile delete fail");
        }
        if (file.renameTo(file2)) {
            Logger.m8702i(TAG, "backupSettings - complete!!");
            return true;
        }
        Logger.m8698e(TAG, "Fail to move file");
        return false;
    }

    @JvmStatic
    @Nullable
    public static final String getEncryptedPasswordHash(@Nullable Context context) {
        SharedPreferences sharedPreferences = context != null ? context.getSharedPreferences(PREF_NAME_USER_AUTH_INFO, 0) : null;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(PREF_ENCRYPTED_NOTES_PASSWORD_HASH, "");
        }
        return null;
    }

    @JvmStatic
    public static final int getEncryptedPasswordHashAndSaltBy(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getSharedPreferences(PREF_NAME_USER_AUTH_INFO, 0).getInt(PREF_NOTES_PASSWORD_HASH_SALT_UPDATED_BY, NotesPasswordHashSaltBy.UNKNOWN.value);
    }

    @JvmStatic
    @Nullable
    public static final String getEncryptedPasswordSalt(@Nullable Context context) {
        SharedPreferences sharedPreferences = context != null ? context.getSharedPreferences(PREF_NAME_USER_AUTH_INFO, 0) : null;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(PREF_ENCRYPTED_NOTES_PASSWORD_SALT, "");
        }
        return null;
    }

    @JvmStatic
    @Nullable
    public static final String getHashedAccountGuid(@Nullable String accountGuid) {
        return HashUtils.isHashed(accountGuid) ? accountGuid : HashUtils.generateSha256(accountGuid);
    }

    @JvmStatic
    @NotNull
    public static final String getPasswordHash(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String strDecryptString$default = PasswordEncryptUtils.decryptString$default(getEncryptedPasswordHash(context), null, 2, null);
        if (strDecryptString$default != null) {
            return strDecryptString$default;
        }
        Logger.m8697d(TAG, "decryption error");
        return "";
    }

    @JvmStatic
    @NotNull
    public static final String getPasswordSalt(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String strDecryptString$default = PasswordEncryptUtils.decryptString$default(getEncryptedPasswordSalt(context), null, 2, null);
        if (strDecryptString$default != null) {
            return strDecryptString$default;
        }
        Logger.m8697d(TAG, "decryption error");
        return "";
    }

    private final String getPrefNotesPasswordHash(Context context, String tempName) {
        return context.getSharedPreferences(tempName, 0).getString(PREF_NOTES_PASSWORD_HASH, "");
    }

    private final String getPrefNotesPasswordSalt(Context context, String tempName) {
        return context.getSharedPreferences(tempName, 0).getString(PREF_NOTES_PASSWORD_SALT, "");
    }

    @NotNull
    public static final List<Integer> getUnlockedDocTypes() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        return arrayList;
    }

    @JvmStatic
    public static /* synthetic */ void getUnlockedDocTypes$annotations() {
    }

    @JvmStatic
    public static final boolean isBiometricDisabledMode(@Nullable Context context) {
        return UserManagerCompat.INSTANCE.getInstance().isGuestMode(context);
    }

    @JvmStatic
    public static final boolean isEmptyGuid(@Nullable String noteGUID) {
        return TextUtils.isEmpty(noteGUID) || Intrinsics.areEqual(HashUtils.getEmptyHashedString(), noteGUID);
    }

    @JvmStatic
    public static final boolean isLockMenuEnabled(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!DeviceUtils.isSupportedLock(context)) {
            return false;
        }
        if (isSetPassword(context)) {
            return true;
        }
        return DeviceUtils.isSupportedSetLockPassword(context);
    }

    @JvmStatic
    public static final boolean isLocked(@NotNull SpenWNote wNote) {
        Intrinsics.checkNotNullParameter(wNote, "wNote");
        return wNote.getDocumentType() != SpenWNote.DocumentType.UNLOCKED_DOC;
    }

    @JvmStatic
    public static final boolean isLockedOtherDocType(@LockType int lockType) {
        return 2 == lockType || 3 == lockType || 4 == lockType;
    }

    @JvmStatic
    public static final boolean isLockedSdocType(@LockType int lockType) {
        return 1 == lockType || -2 == lockType;
    }

    @JvmStatic
    public static final boolean isLockedType(@LockType int lockType) {
        return lockType >= 1 || lockType == -2;
    }

    @JvmStatic
    public static final int isNoteOwner(@Nullable String noteGUID, @Nullable String currentGUID, @Nullable String oldAccountName, @Nullable String currentAccountName) {
        int iIsNoteOwner = isNoteOwner(noteGUID, currentGUID);
        if (iIsNoteOwner != 3) {
            return iIsNoteOwner;
        }
        Logger.m8697d(TAG, "isNoteOwner oldAccountName : " + Logger.getEncode(oldAccountName));
        Logger.m8697d(TAG, "isNoteOwner currentAccountName : " + Logger.getEncode(currentAccountName));
        if (isEmptyGuid(noteGUID) && TextUtils.isEmpty(oldAccountName)) {
            Logger.m8697d(TAG, "isNoteOwner# GUID and AccountName are empty");
            return 1;
        }
        if (currentAccountName == null || oldAccountName == null || !Intrinsics.areEqual(currentAccountName, oldAccountName)) {
            Logger.m8698e(TAG, "isNoteOwner# different user");
            return 3;
        }
        Logger.m8697d(TAG, "isNoteOwner# same AccountName");
        return 1;
    }

    @JvmStatic
    public static final boolean isSetPassword(@Nullable Context context) {
        String encryptedPasswordHash = getEncryptedPasswordHash(context);
        String encryptedPasswordSalt = getEncryptedPasswordSalt(context);
        if (encryptedPasswordHash != null && encryptedPasswordHash.length() > 0 && encryptedPasswordSalt != null && encryptedPasswordSalt.length() > 0) {
            return true;
        }
        Logger.m8703w(TAG, "password is not set");
        return false;
    }

    @JvmStatic
    public static final boolean isUnLockedDocType(@LockType int lockType) {
        return lockType == 0;
    }

    @JvmStatic
    @NotNull
    public static final String lockTypeToString(@LockType int lockType) {
        if (lockType == -2) {
            return "UNSUPPORTED_VERSION_SDOC_LOCK";
        }
        if (lockType == 0) {
            return "LOCK_TYPE_NONE";
        }
        if (lockType == 1) {
            return "LOCK_TYPE_SDOC";
        }
        if (lockType == 2) {
            return "LOCK_TYPE_SPD";
        }
        if (lockType == 3) {
            return "LOCK_TYPE_SNB";
        }
        if (lockType == 4) {
            return "LOCK_TYPE_TMEMO";
        }
        if (lockType == 5) {
            return "LOCK_TYPE_SDOCX";
        }
        AbstractC4539a.m3203m(lockType, "unknown lock type: ", TAG);
        return "unknown";
    }

    @JvmStatic
    public static final void setEncryptedPasswordHashAndSalt(@NotNull Context context, @NotNull String encryptedHashStr, @NotNull String encryptedSaltStr, int by) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(encryptedHashStr, "encryptedHashStr");
        Intrinsics.checkNotNullParameter(encryptedSaltStr, "encryptedSaltStr");
        int length = encryptedHashStr.length();
        int length2 = encryptedSaltStr.length();
        StringBuilder sbM1173s = AbstractC0622a.m1173s(by, length, "setEncryptedPasswordHashAndSalt by ", ", encryptedHash/SaltStr length : ", "/");
        sbM1173s.append(length2);
        Logger.m8700f(TAG, sbM1173s.toString());
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREF_NAME_USER_AUTH_INFO, 0).edit();
        editorEdit.putString(PREF_ENCRYPTED_NOTES_PASSWORD_HASH, encryptedHashStr);
        editorEdit.putString(PREF_ENCRYPTED_NOTES_PASSWORD_SALT, encryptedSaltStr);
        editorEdit.putInt(PREF_NOTES_PASSWORD_HASH_SALT_UPDATED_BY, by);
        editorEdit.apply();
    }

    @JvmStatic
    public static final void setPasswordHashAndSalt(@NotNull Context context, @Nullable String passwordHash, @Nullable String passwordSalt, int by) {
        Intrinsics.checkNotNullParameter(context, "context");
        String strEncryptString = PasswordEncryptUtils.encryptString(context, passwordHash);
        String strEncryptString2 = PasswordEncryptUtils.encryptString(context, passwordSalt);
        if (strEncryptString == null || strEncryptString2 == null) {
            Logger.m8697d(TAG, "encryption error");
        } else {
            setEncryptedPasswordHashAndSalt(context, strEncryptString, strEncryptString2, by);
        }
    }

    @JvmStatic
    public static final boolean updateUserAuthInfo(@NotNull Context context, @NotNull String filePath, boolean synced) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Logger.m8702i(TAG, "updateUserAuthInfo()");
        File file = new File(filePath);
        if (!file.exists()) {
            Logger.m8698e(TAG, "File is not exist.");
            return false;
        }
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String parent = context.getFilesDir().getParent();
        File file2 = new File(AbstractC0541b.m757C(parent != null ? parent.concat("/shared_prefs/") : null, string, ".xml"));
        if (file2.exists() && !file2.delete()) {
            Logger.m8698e(TAG, "Fail to delete dest file.");
            return false;
        }
        if (!file.renameTo(file2)) {
            Logger.m8698e(TAG, "Fail to move file.");
            return false;
        }
        LockUtils lockUtils = INSTANCE;
        String strEncryptString = PasswordEncryptUtils.encryptString(context, lockUtils.getPrefNotesPasswordHash(context, string));
        String strEncryptString2 = PasswordEncryptUtils.encryptString(context, lockUtils.getPrefNotesPasswordSalt(context, string));
        if (strEncryptString == null || strEncryptString2 == null) {
            Logger.m8698e(TAG, "Fail to encrypt data. delete dest file : " + file2.delete());
            return false;
        }
        setEncryptedPasswordHashAndSalt(context, strEncryptString, strEncryptString2, NotesPasswordHashSaltBy.SYNC.value);
        if (!synced) {
            LockPrefUtils.setPrefUseFingerprint(context, false);
            if (Build.VERSION.SDK_INT < 28) {
                LockPrefUtils.setPrefUseFingerprint(context, false);
                LockPrefUtils.setPrefFingerprintUniqueId(context, new HashSet());
            }
            LockPrefUtils.setPrefUseIris(context, false);
            LockPrefUtils.setPrefIrisUniqueId(context, "");
        }
        if (file2.delete()) {
            return true;
        }
        Logger.m8702i(TAG, "Fail to remove dest file");
        return true;
    }

    @JvmStatic
    public static final boolean isLocked(@NotNull String docPath) {
        Intrinsics.checkNotNullParameter(docPath, "docPath");
        return SpenWNoteFile.getDocumentType(docPath) != SpenWNote.DocumentType.UNLOCKED_DOC;
    }

    @JvmStatic
    public static final int isNoteOwner(@Nullable String noteGUID, @Nullable String currentGUID) {
        Logger.m8697d(TAG, "isNoteOwner noteGUID : " + Logger.getEncode(noteGUID));
        Logger.m8697d(TAG, "isNoteOwner currentGUID : " + Logger.getEncode(currentGUID));
        if (TextUtils.isEmpty(currentGUID)) {
            Logger.m8697d(TAG, "isNoteOwner# can't get samsung account guid");
            return 2;
        }
        if (isEmptyGuid(noteGUID)) {
            return 3;
        }
        Intrinsics.checkNotNull(noteGUID);
        if (currentGUID == null || currentGUID.length() != noteGUID.length()) {
            noteGUID = String.valueOf(HashUtils.generateSha256(noteGUID));
            AbstractC4539a.m3188B("isNoteOwner hashed noteGUID : ", Logger.getEncode(noteGUID), TAG);
        }
        if (currentGUID == null || currentGUID.compareTo(noteGUID) != 0) {
            return 3;
        }
        Logger.m8697d(TAG, "isNoteOwner# same GUID");
        return 1;
    }

    @JvmStatic
    @Nullable
    public static final String backupSettings(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String parent = context.getFilesDir().getParent();
        String strConcat = parent != null ? parent.concat("/shared_prefs") : null;
        if (INSTANCE.backupSettings(context, strConcat)) {
            return AbstractC0541b.m756B(strConcat, "/LockSettings_backup.xml");
        }
        return null;
    }
}
