package com.samsung.android.support.senl.p148nt.app.lock.helper;

import android.content.Intent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ7\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000bJ7\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000bJ\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/helper/ILockHelper;", "", "verifyLockedNote", "", "requestCode", "", "returnData", "Landroid/content/Intent;", "uuidList", "", "", "(ILandroid/content/Intent;[Ljava/lang/String;)V", "verifyLockedNoteWithMultiAccount", "restoreLockHelperTask", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ILockHelper {
    public static final int ACTION_GET_ACTIVITY_RESULT = 6;
    public static final int ACTION_MOVE_TO_SECURE_FOLDER = 7;
    public static final int ACTION_NONE = 0;
    public static final int ACTION_SET_LOCK_NOTE = 3;
    public static final int ACTION_SET_UNLOCK_NOTE = 4;
    public static final int ACTION_UNLOCK_NOTE = 5;
    public static final int ACTION_VERIFY_LOCKED_NOTE = 1;
    public static final int ACTION_VERIFY_LOCKED_NOTE_FOR_CONVERT = 2;
    public static final int ACTION_VERIFY_WITH_MULTI_ACCOUNT_LOCKED_NOTE = 8;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/helper/ILockHelper$Companion;", "", "<init>", "()V", "ACTION_NONE", "", "ACTION_VERIFY_LOCKED_NOTE", "ACTION_VERIFY_LOCKED_NOTE_FOR_CONVERT", "ACTION_SET_LOCK_NOTE", "ACTION_SET_UNLOCK_NOTE", "ACTION_UNLOCK_NOTE", "ACTION_GET_ACTIVITY_RESULT", "ACTION_MOVE_TO_SECURE_FOLDER", "ACTION_VERIFY_WITH_MULTI_ACCOUNT_LOCKED_NOTE", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int ACTION_GET_ACTIVITY_RESULT = 6;
        public static final int ACTION_MOVE_TO_SECURE_FOLDER = 7;
        public static final int ACTION_NONE = 0;
        public static final int ACTION_SET_LOCK_NOTE = 3;
        public static final int ACTION_SET_UNLOCK_NOTE = 4;
        public static final int ACTION_UNLOCK_NOTE = 5;
        public static final int ACTION_VERIFY_LOCKED_NOTE = 1;
        public static final int ACTION_VERIFY_LOCKED_NOTE_FOR_CONVERT = 2;
        public static final int ACTION_VERIFY_WITH_MULTI_ACCOUNT_LOCKED_NOTE = 8;

        private Companion() {
        }
    }

    void restoreLockHelperTask();

    void verifyLockedNote(int requestCode, @Nullable Intent returnData, @NotNull String... uuidList);

    void verifyLockedNoteWithMultiAccount(int requestCode, @Nullable Intent returnData, @NotNull String... uuidList);
}
