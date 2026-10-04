package com.samsung.android.support.senl.p148nt.coedit.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.android.support.senl.p148nt.coedit.view.CriticalErrorDialogFragment;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DialogManager {
    private WeakReference<AppCompatActivity> mActivityWeakRef;

    private synchronized FragmentManager getSupportFragmentManager() {
        AppCompatActivity appCompatActivity = this.mActivityWeakRef.get();
        if (!CoeditUtils.isActivityValid(appCompatActivity)) {
            return null;
        }
        return appCompatActivity.getSupportFragmentManager();
    }

    public synchronized void init(WeakReference<AppCompatActivity> weakReference) {
        this.mActivityWeakRef = weakReference;
    }

    public synchronized void release() {
        WeakReference<AppCompatActivity> weakReference = this.mActivityWeakRef;
        if (weakReference != null) {
            weakReference.clear();
            this.mActivityWeakRef = null;
        }
    }

    public synchronized void showCriticalDialog(CriticalErrorDialogFragment.Contract contract) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null && !supportFragmentManager.isDestroyed()) {
            if (((CriticalErrorDialogFragment) supportFragmentManager.findFragmentByTag(CriticalErrorDialogFragment.TAG)) != null) {
                return;
            }
            CriticalErrorDialogFragment criticalErrorDialogFragment = new CriticalErrorDialogFragment();
            criticalErrorDialogFragment.setCancelable(false);
            criticalErrorDialogFragment.setContract(contract);
            criticalErrorDialogFragment.showAllowingStateLoss(supportFragmentManager, CriticalErrorDialogFragment.TAG);
        }
    }
}
