package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.progress;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SeslProgressBar;
import androidx.core.util.Pair;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.NavigationBarUtil;
import p001A.AbstractC0000a;
import p046K2.DialogInterfaceOnClickListenerC0161a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerProgressBar {
    private static final String TAG = Logger.createTag("PC$ComposerProgressBar");
    private Activity mActivity;
    private boolean mEnabledNavigationBar;
    private final OnCancelListener mOnCancelListener;
    private TextView mPbFileNameView;
    private TextView mPbPercentView;
    private SeslProgressBar mProgressBar;
    private AlertDialog mProgressBarDialog;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnCancelListener {
        void onCancel(DialogInterface dialogInterface);
    }

    public ComposerProgressBar(OnCancelListener onCancelListener) {
        this.mOnCancelListener = onCancelListener;
    }

    private void clearNavigationBarFlag(Window window) {
        NavigationBarUtil.clearHideNavigationBarFlag(window.getDecorView());
    }

    private void hideNavigationBar(Window window) {
        NavigationBarUtil.hideNavigationBar(this.mActivity, window.getDecorView());
    }

    private void initProgressBarDialog(Pair<Boolean, Integer> pair, boolean z) {
        View viewInflate = this.mActivity.getLayoutInflater().inflate(C9086R.layout.comp_progress_bar_dialog_layout, (ViewGroup) null);
        this.mProgressBar = (SeslProgressBar) viewInflate.findViewById(C9086R.id.comp_progress_bar);
        TextView textView = (TextView) viewInflate.findViewById(C9086R.id.comp_progress_bar_file_name);
        this.mPbFileNameView = textView;
        textView.setText(pair.second.intValue());
        this.mPbPercentView = (TextView) viewInflate.findViewById(C9086R.id.comp_progress_bar_percent);
        this.mProgressBar.setMax(100);
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(this.mActivity);
        if (z) {
            alertDialogBuilderForAppCompat.setTitle(C9086R.string.document_service_notification_name_saving);
        }
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        this.mProgressBarDialog = alertDialogCreate;
        alertDialogCreate.setView(viewInflate);
        this.mProgressBarDialog.setCanceledOnTouchOutside(false);
        this.mProgressBarDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.progress.ComposerProgressBar.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                AbstractC0000a.m3D(i, "Dialog onKey# ", ComposerProgressBar.TAG);
                if (!ComposerProgressBar.this.isCancelKeyEvent(i, keyEvent)) {
                    return false;
                }
                ComposerProgressBar.this.mOnCancelListener.onCancel(dialogInterface);
                return true;
            }
        });
        if (pair.first.booleanValue()) {
            this.mProgressBarDialog.setButton(-2, this.mActivity.getString(C9086R.string.dialog_cancel), new DialogInterfaceOnClickListenerC0161a(this, 11));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initProgressBarDialog$0(DialogInterface dialogInterface, int i) {
        this.mOnCancelListener.onCancel(dialogInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public void updateProgressState(int i) {
        AlertDialog alertDialog = this.mProgressBarDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.mProgressBar.setProgress(i, true);
        this.mPbPercentView.setText(i + "%");
    }

    public void enableToHideNavigationBar(boolean z) {
        this.mEnabledNavigationBar = z;
    }

    public void hide() {
        AlertDialog alertDialog = this.mProgressBarDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        Logger.m10999d(TAG, "hide#");
        this.mProgressBarDialog.dismiss();
    }

    public void init(Activity activity) {
        this.mActivity = activity;
    }

    public boolean isCancelKeyEvent(int i, KeyEvent keyEvent) {
        return (i == 4 || i == 111) && 1 == keyEvent.getAction();
    }

    public void onDetachView() {
        this.mActivity = null;
        this.mProgressBarDialog = null;
    }

    public void setProgress(final int i) {
        if (!CommonUtils.isOnMainUIThread()) {
            this.mProgressBar.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.progress.ComposerProgressBar.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractC8014b.m7221w(new StringBuilder("setProgress#post# "), ComposerProgressBar.TAG, i);
                    ComposerProgressBar.this.updateProgressState(i);
                }
            });
        } else {
            AbstractC0000a.m3D(i, "setProgress# ", TAG);
            updateProgressState(i);
        }
    }

    public void setTitle(String str) {
        this.mPbFileNameView.setText(str);
    }

    public boolean show(Pair<Boolean, Integer> pair, boolean z) {
        if (CommonUtil.isNotAvailableActivity(this.mActivity)) {
            Logger.m11000e(TAG, "show#isNotAvailableActivity true");
            return false;
        }
        AlertDialog alertDialog = this.mProgressBarDialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            return false;
        }
        String str = TAG;
        Logger.m10999d(str, "show#");
        initProgressBarDialog(pair, z);
        Window window = this.mProgressBarDialog.getWindow();
        if (window == null) {
            Logger.m11000e(str, "window is null");
            return false;
        }
        if (!this.mEnabledNavigationBar || !NavigationBarUtil.isEnabledToHideNavigationBar()) {
            clearNavigationBarFlag(window);
            this.mProgressBarDialog.show();
            return true;
        }
        hideNavigationBar(window);
        window.setFlags(8, 8);
        this.mProgressBarDialog.show();
        window.clearFlags(8);
        return true;
    }
}
