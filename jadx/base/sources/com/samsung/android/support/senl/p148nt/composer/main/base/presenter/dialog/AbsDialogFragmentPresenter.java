package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsDialogFragmentPresenter implements DialogContract.IFragmentPresenter {
    protected Activity mActivity;

    public boolean canShow(Activity activity, String str) {
        if (CommonUtil.isNotAvailableActivity(activity)) {
            Logger.m11000e(str, "show# error = " + activity);
            return false;
        }
        if (findFragmentByTag(activity) == null) {
            return true;
        }
        Logger.m11004w(str, "show# dialog is already shown");
        return false;
    }

    public abstract DialogFragment findFragmentByTag(Activity activity);

    public DialogFragment findFragmentByTag(Activity activity, String str) {
        if (activity == null) {
            return null;
        }
        AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
        DialogFragment dialogFragment = (DialogFragment) appCompatActivity.getSupportFragmentManager().findFragmentByTag(str);
        if (dialogFragment == null) {
            FragmentManager supportFragmentManager = appCompatActivity.getSupportFragmentManager();
            if (!supportFragmentManager.getFragments().isEmpty()) {
                return (DialogFragment) supportFragmentManager.getFragments().get(0).getChildFragmentManager().findFragmentByTag(str);
            }
        }
        return dialogFragment;
    }

    public void hide() {
        DialogFragment dialogFragmentFindFragmentByTag = findFragmentByTag(this.mActivity);
        if (dialogFragmentFindFragmentByTag != null) {
            dialogFragmentFindFragmentByTag.dismiss();
        }
    }

    public void onAttachView(Activity activity) {
        this.mActivity = activity;
    }

    public void onDetachView() {
        this.mActivity = null;
    }

    public void show(Activity activity, String str, DialogFragment dialogFragment) {
        FragmentManager childFragmentManager = ((AppCompatActivity) activity).getSupportFragmentManager().getFragments().get(0).getChildFragmentManager();
        childFragmentManager.beginTransaction().add(dialogFragment, str).commitAllowingStateLoss();
        childFragmentManager.executePendingTransactions();
    }
}
