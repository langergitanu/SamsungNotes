package com.samsung.android.support.senl.p148nt.app.trigger.lock;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.lock.LockManager;
import com.samsung.android.support.senl.p148nt.app.lock.helper.AbsLockHelper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TriggerLockHelper extends AbsLockHelper {
    private AppCompatActivity mActivity;

    public TriggerLockHelper(AppCompatActivity appCompatActivity, @NonNull LockManager lockManager) {
        this.mActivity = appCompatActivity;
        setLockManager(lockManager);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        return onActivityResult(this.mActivity, i, i2, intent);
    }

    public void onDestroy() {
        this.mActivity = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.helper.AbsLockHelper
    public void restoreTask() {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.helper.ILockHelper
    public void verifyLockedNote(int i, Intent intent, String... strArr) {
        verifyLockedNote(this.mActivity, i, intent, strArr);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.helper.ILockHelper
    public void verifyLockedNoteWithMultiAccount(int i, Intent intent, String... strArr) {
        verifyLockedNoteWithMultiAccount(this.mActivity, i, intent, strArr);
    }
}
