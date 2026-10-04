package com.samsung.android.support.senl.p148nt.app.main.folder.presenter;

import android.app.Activity;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.lock.LockManager;
import com.samsung.android.support.senl.p148nt.app.lock.helper.AbsLockHelper;
import com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class LockHelper extends AbsLockHelper {
    private static final String TAG = "LockHelper";
    private final IPresenter mPresenter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPresenter {
        void onFolderDeleteVerifySuccess();
    }

    public LockHelper(IPresenter iPresenter) {
        this.mPresenter = iPresenter;
        setLockManager(new LockManager(new ILockManagerListener() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.LockHelper.1
            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onCreatePasswordFail(int i, int i2, Intent intent) {
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onCreatePasswordSuccess(int i, Intent intent) {
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onLockFail(int i, int i2, String... strArr) {
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onLockSuccess(int i, String... strArr) {
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onUnlockFail(int i, int i2, String... strArr) {
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onUnlockSuccess(int i, Intent intent, String... strArr) {
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onVerifyFail(int i, int i2, String... strArr) {
                AbstractC8014b.m7200b(i, i2, "onVerifyFail# requestCode ", " failCode ", LockHelper.TAG);
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onVerifySuccess(int i, Intent intent, String... strArr) {
                AbstractC8014b.m7201c(i, "onVerifySuccess# requestCode : ", LockHelper.TAG);
                if (i == 112) {
                    LockHelper.this.mPresenter.onFolderDeleteVerifySuccess();
                }
            }
        }));
    }

    public boolean onActivityResultFromLockManager(AppCompatActivity appCompatActivity, int i, int i2, Intent intent) {
        return onActivityResult(appCompatActivity, i, i2, intent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.helper.AbsLockHelper
    public void restoreTask() {
    }

    public void verifyForDelete(Activity activity) {
        this.mLockManager.verifyForDelete(activity, 112);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.helper.ILockHelper
    public void verifyLockedNote(int i, Intent intent, String... strArr) {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.helper.ILockHelper
    public void verifyLockedNoteWithMultiAccount(int i, Intent intent, String... strArr) {
    }
}
