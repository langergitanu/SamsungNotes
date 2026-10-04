package com.samsung.android.support.senl.p148nt.base.common.access.lock;

import android.content.Intent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016J-\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\tJ5\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\fJ7\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\u0010J5\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\fJ7\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\u0010J5\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\fJ\u001a\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\"\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/access/lock/ILockManagerListener;", "", "onLockSuccess", "", "requestCode", "", "uuidList", "", "", "(I[Ljava/lang/String;)V", "onLockFail", "failCode", "(II[Ljava/lang/String;)V", "onUnlockSuccess", "data", "Landroid/content/Intent;", "(ILandroid/content/Intent;[Ljava/lang/String;)V", "onUnlockFail", "onVerifySuccess", "onVerifyFail", "onCreatePasswordSuccess", "onCreatePasswordFail", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ILockManagerListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int FAIL_CODE_CANCEL = 6;
    public static final int FAIL_CODE_CANCEL_SDOC_MIGRATION = 9;
    public static final int FAIL_CODE_DELETED_NOTE = 10;
    public static final int FAIL_CODE_EMPTY_GUID = 7;
    public static final int FAIL_CODE_EMPTY_UUID = 1;
    public static final int FAIL_CODE_LEGACY_NOTE = 4;
    public static final int FAIL_CODE_NEED_ACCOUNT_PERMISSION = 8;
    public static final int FAIL_CODE_NOT_EXIST_NOTE = 11;
    public static final int FAIL_CODE_NOT_LOGIN = 2;
    public static final int FAIL_CODE_NOT_OWNER = 3;
    public static final int FAIL_CODE_NO_USER_INFO = 5;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/access/lock/ILockManagerListener$Companion;", "", "<init>", "()V", "FAIL_CODE_EMPTY_UUID", "", "FAIL_CODE_NOT_LOGIN", "FAIL_CODE_NOT_OWNER", "FAIL_CODE_LEGACY_NOTE", "FAIL_CODE_NO_USER_INFO", "FAIL_CODE_CANCEL", "FAIL_CODE_EMPTY_GUID", "FAIL_CODE_NEED_ACCOUNT_PERMISSION", "FAIL_CODE_CANCEL_SDOC_MIGRATION", "FAIL_CODE_DELETED_NOTE", "FAIL_CODE_NOT_EXIST_NOTE", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int FAIL_CODE_CANCEL = 6;
        public static final int FAIL_CODE_CANCEL_SDOC_MIGRATION = 9;
        public static final int FAIL_CODE_DELETED_NOTE = 10;
        public static final int FAIL_CODE_EMPTY_GUID = 7;
        public static final int FAIL_CODE_EMPTY_UUID = 1;
        public static final int FAIL_CODE_LEGACY_NOTE = 4;
        public static final int FAIL_CODE_NEED_ACCOUNT_PERMISSION = 8;
        public static final int FAIL_CODE_NOT_EXIST_NOTE = 11;
        public static final int FAIL_CODE_NOT_LOGIN = 2;
        public static final int FAIL_CODE_NOT_OWNER = 3;
        public static final int FAIL_CODE_NO_USER_INFO = 5;

        private Companion() {
        }
    }

    void onCreatePasswordFail(int requestCode, int failCode, @Nullable Intent data);

    void onCreatePasswordSuccess(int requestCode, @Nullable Intent data);

    void onLockFail(int requestCode, int failCode, @NotNull String... uuidList);

    void onLockSuccess(int requestCode, @NotNull String... uuidList);

    void onUnlockFail(int requestCode, int failCode, @NotNull String... uuidList);

    void onUnlockSuccess(int requestCode, @Nullable Intent data, @NotNull String... uuidList);

    void onVerifyFail(int requestCode, int failCode, @NotNull String... uuidList);

    void onVerifySuccess(int requestCode, @Nullable Intent data, @NotNull String... uuidList);
}
