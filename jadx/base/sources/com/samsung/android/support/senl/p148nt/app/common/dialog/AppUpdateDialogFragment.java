package com.samsung.android.support.senl.p148nt.app.common.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class AppUpdateDialogFragment extends DialogFragment {
    public static final String FOR_ADDONS = "FOR_ADDONS";
    public static final String FOR_COEDIT = "FOR_COEDIT";
    public static final String FOR_LOW_VERSION_FORMAT_SYNC = "FOR_LOW_VERSION_FORMAT_SYNC";
    public static final String FOR_UNSUPPORTED_FORMAT_IMPORT = "FOR_UNSUPPORTED_FORMAT_IMPORT";
    public static final String FOR_UNSUPPORTED_FORMAT_SYNC = "FOR_UNSUPPORTED_FORMAT_SYNC";
    private static final String TAG = "AppUpdateDialogFragment";
    private AppUpdateDialogListener mDialogListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AppUpdateDialogListener extends DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NonNull DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        AppUpdateDialogListener appUpdateDialogListener = this.mDialogListener;
        if (appUpdateDialogListener != null) {
            appUpdateDialogListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        String string;
        String string2;
        boolean zIsSecBrandAsGalaxy = CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy();
        String tag = getTag();
        if (FOR_ADDONS.equals(tag)) {
            string2 = getString(zIsSecBrandAsGalaxy ? C8003R.string.app_update_dialog_title_jp : C8003R.string.app_update_dialog_title);
            string = getResources().getString(zIsSecBrandAsGalaxy ? C8003R.string.critical_app_update_dialog_jp : C8003R.string.critical_app_update_dialog);
        } else if (FOR_UNSUPPORTED_FORMAT_IMPORT.equals(tag)) {
            string2 = getString(zIsSecBrandAsGalaxy ? C8003R.string.app_update_dialog_title_jp : C8003R.string.app_update_dialog_title);
            string = getString(C8003R.string.import_new_format_content, getString(zIsSecBrandAsGalaxy ? C8003R.string.notes_jp : C8003R.string.app_name));
        } else {
            if (FOR_UNSUPPORTED_FORMAT_SYNC.equals(tag)) {
                string = getResources().getString(zIsSecBrandAsGalaxy ? C8003R.string.sync_new_format_content_jp : C8003R.string.sync_new_format_content);
            } else if (FOR_LOW_VERSION_FORMAT_SYNC.equals(tag)) {
                string = getResources().getString(C8003R.string.app_update_low_version_for_sync);
            } else if (FOR_COEDIT.equals(tag)) {
                string = getResources().getString(zIsSecBrandAsGalaxy ? C8003R.string.sync_new_format_content_jp : C8003R.string.sync_new_format_content);
            } else {
                AbstractC6670b.m4738C("unexpected dialogTag: ", tag, TAG);
                string = "";
                string2 = string;
            }
            string2 = "";
        }
        return new AlertDialogBuilderForAppCompat(getActivity()).setTitle(string2).setMessage(string).setCancelable(true).setPositiveButton(C8003R.string.string_update, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.common.dialog.AppUpdateDialogFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AppUpdateDialogFragment.this.dismissAllowingStateLoss();
                if (AppUpdateDialogFragment.this.mDialogListener != null) {
                    AppUpdateDialogFragment.this.mDialogListener.onClick(dialogInterface, i);
                }
            }
        }).setNegativeButton(C8003R.string.cancel_btn, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.common.dialog.AppUpdateDialogFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AppUpdateDialogFragment.this.dismissAllowingStateLoss();
                if (AppUpdateDialogFragment.this.mDialogListener != null) {
                    AppUpdateDialogFragment.this.mDialogListener.onClick(dialogInterface, i);
                }
            }
        }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.samsung.android.support.senl.nt.app.common.dialog.AppUpdateDialogFragment.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (AppUpdateDialogFragment.this.mDialogListener == null || i != 4 || keyEvent.getAction() != 1) {
                    return false;
                }
                AppUpdateDialogFragment.this.mDialogListener.onClick(dialogInterface, -2);
                return false;
            }
        }).create();
    }

    public void setDialogListener(AppUpdateDialogListener appUpdateDialogListener) {
        this.mDialogListener = appUpdateDialogListener;
    }

    public void showAllowingStateLoss(FragmentManager fragmentManager, String str) {
        if (fragmentManager == null || fragmentManager.isDestroyed()) {
            return;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.add(this, str);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }
}
