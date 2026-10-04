package com.samsung.android.support.senl.p148nt.app.lock.helper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.lock.LockManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H$J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0005H\u0004J\u0010\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016J,\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u0004J;\u0010 \u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010!2\u0006\u0010\u001d\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u000b2\u0012\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000e¢\u0006\u0002\u0010$J?\u0010%\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010!2\u0006\u0010\u001d\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u000b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\r\"\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010$JG\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u000b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\r\"\u0004\u0018\u00010\u000eH\u0004¢\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\u0011H\u0016R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00078\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R \u0010\f\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r8\u0004@\u0004X\u0085\u000e¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/helper/AbsLockHelper;", "Lcom/samsung/android/support/senl/nt/app/lock/helper/ILockHelper;", "<init>", "()V", "mLockManager", "Lcom/samsung/android/support/senl/nt/app/lock/LockManager;", "mLatestAction", "", "mLatestRequestCode", "mLatestResultCode", "mLatestReturnData", "Landroid/content/Intent;", "mLatestUuidList", "", "", "[Ljava/lang/String;", "restoreTask", "", "setLockManager", "lockManager", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "Landroid/os/Bundle;", "onRestoreInstanceState", "savedInstanceState", "onActivityResult", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroidx/appcompat/app/AppCompatActivity;", "requestCode", "resultCode", "data", "verifyLockedNote", "Landroid/app/Activity;", "returnData", "uuidList", "(Landroid/app/Activity;ILandroid/content/Intent;[Ljava/lang/String;)V", "verifyLockedNoteWithMultiAccount", "saveLockHelperTask", "action", "(IIILandroid/content/Intent;[Ljava/lang/String;)V", "restoreLockHelperTask", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAbsLockHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbsLockHelper.kt\ncom/samsung/android/support/senl/nt/app/lock/helper/AbsLockHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,80:1\n1#2:81\n*E\n"})
public abstract class AbsLockHelper implements ILockHelper {

    @JvmField
    protected int mLatestAction;

    @JvmField
    protected int mLatestRequestCode;

    @JvmField
    protected int mLatestResultCode;

    @JvmField
    @Nullable
    protected Intent mLatestReturnData;

    @JvmField
    @Nullable
    protected String[] mLatestUuidList;

    @JvmField
    @Nullable
    protected LockManager mLockManager;

    public final boolean onActivityResult(@Nullable AppCompatActivity activity, int requestCode, int resultCode, @Nullable Intent data) {
        saveLockHelperTask(6, requestCode, resultCode, data, new String[0]);
        LockManager lockManager = this.mLockManager;
        if (lockManager != null) {
            return lockManager.onActivityResult(activity, requestCode, resultCode, data);
        }
        return false;
    }

    public final void onRestoreInstanceState(@Nullable Bundle savedInstanceState) {
        LockManager lockManager;
        if (savedInstanceState == null || (lockManager = this.mLockManager) == null) {
            return;
        }
        lockManager.onRestoreInstanceState(savedInstanceState);
    }

    public final void onSaveInstanceState(@Nullable Bundle outState) {
        LockManager lockManager;
        if (outState == null || (lockManager = this.mLockManager) == null) {
            return;
        }
        lockManager.onSaveInstanceState(outState);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.helper.ILockHelper
    public void restoreLockHelperTask() {
        int i = this.mLatestAction;
        if (i == 1) {
            String[] strArr = this.mLatestUuidList;
            if (strArr != null) {
                verifyLockedNote(this.mLatestRequestCode, this.mLatestReturnData, (String[]) Arrays.copyOf(strArr, strArr.length));
            }
        } else if (i == 8) {
            String[] strArr2 = this.mLatestUuidList;
            if (strArr2 != null) {
                verifyLockedNoteWithMultiAccount(this.mLatestRequestCode, this.mLatestReturnData, (String[]) Arrays.copyOf(strArr2, strArr2.length));
            }
        } else {
            restoreTask();
        }
        this.mLatestAction = 0;
        this.mLatestRequestCode = 0;
        this.mLatestUuidList = null;
        this.mLatestReturnData = null;
    }

    public abstract void restoreTask();

    public final void saveLockHelperTask(int action, int requestCode, int resultCode, @Nullable Intent returnData, @NotNull String... uuidList) {
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        this.mLatestAction = action;
        this.mLatestRequestCode = requestCode;
        this.mLatestResultCode = resultCode;
        this.mLatestReturnData = returnData;
        this.mLatestUuidList = uuidList;
    }

    public final void setLockManager(@NotNull LockManager lockManager) {
        Intrinsics.checkNotNullParameter(lockManager, "lockManager");
        this.mLockManager = lockManager;
    }

    public final void verifyLockedNote(@Nullable Activity activity, int requestCode, @Nullable Intent returnData, @NotNull String... uuidList) {
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        saveLockHelperTask(1, requestCode, 0, returnData, (String[]) Arrays.copyOf(uuidList, uuidList.length));
        LockManager lockManager = this.mLockManager;
        if (lockManager != null) {
            lockManager.verify(activity, requestCode, returnData, (String[]) Arrays.copyOf(uuidList, uuidList.length));
        }
    }

    public final void verifyLockedNoteWithMultiAccount(@Nullable Activity activity, int requestCode, @Nullable Intent returnData, @NotNull String... uuidList) {
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        saveLockHelperTask(1, requestCode, 0, returnData, (String[]) Arrays.copyOf(uuidList, uuidList.length));
        LockManager lockManager = this.mLockManager;
        if (lockManager != null) {
            lockManager.verify(activity, requestCode, returnData, (String[]) Arrays.copyOf(uuidList, uuidList.length));
        }
    }
}
