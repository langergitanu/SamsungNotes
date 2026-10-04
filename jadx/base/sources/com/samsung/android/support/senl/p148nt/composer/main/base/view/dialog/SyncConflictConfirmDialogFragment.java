package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SeslProgressBar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.SyncConflictConfirmDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.DateTimeUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SyncConflictConfirmDialogFragment extends DialogFragment {
    private static final String TAG = Logger.createTag("SyncConflictConfirmDialogFragment");
    private AlertDialog mAlertDialog;
    private View mCompareBtn;
    private String mDeviceName;
    private Handler mHandler;
    private boolean mIsLatestLocal;
    private boolean mIsTablet;
    private SyncConflictConfirmDialogPresenter mPresenter;
    private SeslProgressBar mProgressBar;
    private Runnable mRunnable;
    private TextView mTitleCompareBtn;
    private boolean mIsClicked = false;
    private Boolean isDownload = Boolean.FALSE;
    private final BroadcastReceiver mDeletedFromServerBroadcastReceiver = new DeletedFromServerBroadcastReceiver(this, 0);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class DeletedFromServerBroadcastReceiver extends BroadcastReceiver {
        public /* synthetic */ DeletedFromServerBroadcastReceiver(SyncConflictConfirmDialogFragment syncConflictConfirmDialogFragment, int i) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Logger.m10999d(SyncConflictConfirmDialogFragment.TAG, "DeletedFromServerBroadcastReceiver# onReceive");
            SyncConflictConfirmDialogFragment.this.getPresenter().closeCompareViewAndFinish();
        }

        private DeletedFromServerBroadcastReceiver() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callKeepBoth() {
        ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_SYNC_CONFLICT, ComposerSAConstants.EVENT_DIALOGS_SYNC_CONFLICT_KEEP_BOTH);
        getPresenter().saveAsNewDocWithCurrentDoc();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callKeepCurrent() {
        getPresenter().keepCurrent();
        ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_SYNC_CONFLICT, ComposerSAConstants.EVENT_DIALOGS_SYNC_CONFLICT_THIS_DEVICE, this.mIsLatestLocal ? "a" : "b");
        dismiss();
    }

    private void callKeepMerge() {
        dismiss();
        getPresenter().keepMerge();
        ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_SYNC_CONFLICT, ComposerSAConstants.EVENT_DIALOGS_SYNC_CONFLICT_THIS_DEVICE, this.mIsLatestLocal ? "a" : "b");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callReplace() {
        getPresenter().replace(isEnableToUpdateNow());
        ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_SYNC_CONFLICT, ComposerSAConstants.EVENT_DIALOGS_SYNC_CONFLICT_ANOTHER_DEVICE, !this.mIsLatestLocal ? "a" : "b");
        dismiss();
    }

    private String getBodyMessage(Resources resources) {
        return TextUtils.isEmpty(this.mDeviceName) ? resources.getString(C9086R.string.composer_sync_conflict_body_your_other_phone) : resources.getString(C9086R.string.composer_message_for_sync_conflict, this.mDeviceName);
    }

    private String getDeviceName() {
        String deviceNameForSyncConflicted = getPresenter().getDeviceNameForSyncConflicted();
        return (TextUtils.isEmpty(deviceNameForSyncConflicted) || "null".equalsIgnoreCase(deviceNameForSyncConflicted) || "unknown".equalsIgnoreCase(deviceNameForSyncConflicted)) ? "" : deviceNameForSyncConflicted;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SyncConflictConfirmDialogPresenter getPresenter() {
        DialogContract.IFragmentPresenterContainer iFragmentPresenterContainer;
        if (this.mPresenter == null && getActivity() != null && (iFragmentPresenterContainer = (DialogContract.IFragmentPresenterContainer) getActivity().getSupportFragmentManager().findFragmentByTag("Composer")) != null) {
            this.mPresenter = (SyncConflictConfirmDialogPresenter) iFragmentPresenterContainer.getDialogFragmentPresenter(11);
        }
        if (this.mPresenter == null) {
            Logger.m11000e(TAG, "getPresenter()# Presenter is null. dismiss call");
            dismiss();
        }
        return this.mPresenter;
    }

    private boolean getSyncTurnOnOptionState() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_SYNC_NOTES, false);
    }

    private boolean isEnableToUpdateNow() {
        FragmentActivity activity = getActivity();
        if (CommonUtils.isNotAvailableActivity(activity)) {
            Logger.m11000e(TAG, "isEnableToUpdateNow# isNotAvailableActivity true");
            return false;
        }
        RequestToSyncManager.Companion companion = RequestToSyncManager.INSTANCE;
        if (!companion.isDataCallNotLimitedForApp()) {
            showDialogSyncNetworkFailError(activity, C9086R.string.composer_sync_network_connection_error);
            return false;
        }
        if (companion.isWiFiSyncOnlyAndNotWiFiConnected(activity)) {
            showDialogSyncNetworkFailError(activity, C9086R.string.composer_sync_use_only_wifi_network);
            return false;
        }
        if (!getSyncTurnOnOptionState()) {
            showDialogDisableSyncTurnOnOptionState(activity);
            return false;
        }
        if (companion.isAutoSyncPossible()) {
            return true;
        }
        showDialogSyncNetworkFailError(activity, C9086R.string.base_string_could_not_sync_notes);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInvalidToClick() {
        if (this.mIsClicked) {
            return true;
        }
        this.mIsClicked = true;
        return false;
    }

    private void makeCompareButton(View view) {
        setDownloadState();
        this.mCompareBtn = view.findViewById(C9086R.id.comp_compare);
        this.mTitleCompareBtn = (TextView) view.findViewById(C9086R.id.comp_compare_title);
        this.mProgressBar = (SeslProgressBar) view.findViewById(C9086R.id.comp_compare_progress_bar);
        this.mTitleCompareBtn.setVisibility(0);
        this.mProgressBar.setVisibility(4);
        this.mCompareBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SyncConflictConfirmDialogFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SyncConflictConfirmDialogFragment.this.isInvalidToClick()) {
                    return;
                }
                if (SyncConflictConfirmDialogFragment.this.isDownload.booleanValue()) {
                    SyncConflictConfirmDialogFragment.this.getPresenter().compare();
                    return;
                }
                SyncConflictConfirmDialogFragment.this.mTitleCompareBtn.setVisibility(4);
                SyncConflictConfirmDialogFragment.this.mProgressBar.setVisibility(0);
                SyncConflictConfirmDialogFragment.this.getPresenter().requestDownloadServerNote();
            }
        });
    }

    private void makeKeepBothButton(View view) {
        view.findViewById(C9086R.id.comp_keep_both).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SyncConflictConfirmDialogFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SyncConflictConfirmDialogFragment.this.isInvalidToClick()) {
                    return;
                }
                SyncConflictConfirmDialogFragment.this.callKeepBoth();
            }
        });
    }

    private void makeKeepCurrentButton(Context context, View view, long j) {
        View viewFindViewById = view.findViewById(C9086R.id.comp_keep_current);
        ((TextView) view.findViewById(C9086R.id.comp_keep_current_title)).setText(context.getResources().getString(this.mIsTablet ? C9086R.string.composer_this_tablet : C9086R.string.composer_this_phone));
        TextView textView = (TextView) view.findViewById(C9086R.id.comp_keep_current_time);
        String strConvertFormattedTime = DateTimeUtil.convertFormattedTime(context, j);
        if (this.mIsLatestLocal) {
            view.findViewById(C9086R.id.comp_keep_current_latest_red_dot).setVisibility(0);
        }
        textView.setText(strConvertFormattedTime);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SyncConflictConfirmDialogFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SyncConflictConfirmDialogFragment.this.isInvalidToClick()) {
                    return;
                }
                SyncConflictConfirmDialogFragment.this.callKeepCurrent();
            }
        });
    }

    private void makeReplaceButton(Context context, View view, long j) {
        View viewFindViewById = view.findViewById(C9086R.id.comp_replace);
        TextView textView = (TextView) view.findViewById(C9086R.id.comp_replace_title);
        if (TextUtils.isEmpty(this.mDeviceName)) {
            textView.setText(context.getResources().getString(C9086R.string.composer_other_devices));
        } else {
            textView.setText(this.mDeviceName);
        }
        TextView textView2 = (TextView) view.findViewById(C9086R.id.comp_replace_time);
        String strConvertFormattedTime = DateTimeUtil.convertFormattedTime(context, j);
        if (!this.mIsLatestLocal) {
            view.findViewById(C9086R.id.comp_replace_latest_red_dot).setVisibility(0);
        }
        textView2.setText(strConvertFormattedTime);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SyncConflictConfirmDialogFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SyncConflictConfirmDialogFragment.this.isInvalidToClick()) {
                    return;
                }
                SyncConflictConfirmDialogFragment.this.callReplace();
            }
        });
    }

    private void setDownloadState() {
        getPresenter().setmDownloadState(new DialogContract.IDownloadState() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SyncConflictConfirmDialogFragment.7
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDownloadState
            public void onFail(final int i) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SyncConflictConfirmDialogFragment.7.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Context applicationContext;
                        Logger.m11003i(SyncConflictConfirmDialogFragment.TAG, "Download - onFalse");
                        SyncConflictConfirmDialogFragment.this.mIsClicked = false;
                        SyncConflictConfirmDialogFragment.this.mProgressBar.setVisibility(4);
                        SyncConflictConfirmDialogFragment.this.mTitleCompareBtn.setVisibility(0);
                        SyncConflictConfirmDialogFragment.this.mCompareBtn.requestLayout();
                        SyncConflictConfirmDialogFragment.this.isDownload = Boolean.FALSE;
                        try {
                            applicationContext = SyncConflictConfirmDialogFragment.this.requireContext();
                        } catch (Exception e) {
                            Logger.m11000e(SyncConflictConfirmDialogFragment.TAG, e.getMessage());
                            applicationContext = BaseUtils.getApplicationContext();
                        }
                        if (applicationContext != null) {
                            ToastHandler.show(applicationContext, i, 0);
                        }
                    }
                });
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDownloadState
            public void onSuccess() {
                Logger.m11003i(SyncConflictConfirmDialogFragment.TAG, "Download - onSuccess");
                SyncConflictConfirmDialogFragment.this.getPresenter().compare();
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SyncConflictConfirmDialogFragment.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SyncConflictConfirmDialogFragment.this.mIsClicked = false;
                        SyncConflictConfirmDialogFragment.this.mProgressBar.setVisibility(4);
                        SyncConflictConfirmDialogFragment.this.mTitleCompareBtn.setVisibility(0);
                        SyncConflictConfirmDialogFragment.this.mCompareBtn.requestLayout();
                        SyncConflictConfirmDialogFragment.this.isDownload = Boolean.TRUE;
                    }
                });
            }
        });
    }

    private void showDialogDisableSyncTurnOnOptionState(final Activity activity) {
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(activity).create();
        alertDialogCreate.setMessage(activity.getString(C9086R.string.handoff_turn_on_sync_snack_bar_msg));
        alertDialogCreate.setButton(-1, activity.getString(C9086R.string.dialog_ok), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SyncConflictConfirmDialogFragment.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                UserInputSkipper.setHoldingEventTime(300L, UserInputSkipper.Tag.Default);
                Intent intent = new Intent(BaseUtils.getApplicationContext(), NoteListAccessHandler.getSettingsActivity());
                intent.putExtra(SettingsConstants.KEY_CALLEE, SettingsConstants.CALLEE_COMPOSER);
                activity.startActivity(intent);
                SyncConflictConfirmDialogFragment.this.getPresenter().finish("DisableSyncTurnOnOptionState");
            }
        });
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.show();
    }

    private void showDialogSyncNetworkFailError(Activity activity, @StringRes int i) {
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(activity).create();
        alertDialogCreate.setMessage(activity.getResources().getString(i));
        alertDialogCreate.setButton(-1, activity.getString(C9086R.string.dialog_ok), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SyncConflictConfirmDialogFragment.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                UserInputSkipper.setHoldingEventTime(300L, UserInputSkipper.Tag.Default);
                SyncConflictConfirmDialogFragment.this.getPresenter().finish("SyncNetworkFailError");
            }
        });
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.show();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        AbstractC14516b.m15114b(i, i2, "onActivityResult# requestCode: ", ", resultCode: ", TAG);
        if (i != ComposerRequestCode.CompareConflict.getId()) {
            return;
        }
        if (i2 == 0) {
            this.mIsClicked = false;
            return;
        }
        int intExtra = intent.getIntExtra(ComposerConstants.RESULT_COMPARE, -1);
        if (intExtra == 0) {
            callKeepCurrent();
            return;
        }
        if (intExtra == 1) {
            callReplace();
            return;
        }
        if (intExtra == 2) {
            callKeepBoth();
            return;
        }
        if (intExtra == 3) {
            callKeepMerge();
            return;
        }
        if (intExtra == 10) {
            this.mHandler = new Handler(Looper.getMainLooper());
            this.mRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SyncConflictConfirmDialogFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    Logger.m11003i(SyncConflictConfirmDialogFragment.TAG, "reopen compare viewer");
                    SyncConflictConfirmDialogFragment.this.mRunnable = null;
                    SyncConflictConfirmDialogFragment.this.mHandler = null;
                    SyncConflictConfirmDialogFragment.this.getPresenter().compare();
                }
            };
        } else if (intExtra == 11) {
            getPresenter().hideDialog();
        } else {
            this.mIsClicked = false;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Logger.m11003i(TAG, "onCreate");
        SyncConflictConfirmDialogPresenter presenter = getPresenter();
        if (presenter != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(presenter.getUuidForSyncConflicted());
            ContextCompat.registerReceiver(requireContext(), this.mDeletedFromServerBroadcastReceiver, intentFilter, 2);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        if (getPresenter() == null || getContext() == null) {
            return super.onCreateDialog(bundle);
        }
        final Context context = getContext();
        this.mDeviceName = getDeviceName();
        this.mIsTablet = DeviceUtils.isTabletModel();
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(context);
        alertDialogBuilderForAppCompat.setTitle(C9086R.string.composer_sync_conflict_title);
        View viewInflate = View.inflate(context, C9086R.layout.comp_syncconflict_dialog_layout, null);
        alertDialogBuilderForAppCompat.setView(viewInflate);
        ((TextView) viewInflate.findViewById(C9086R.id.comp_message)).setText(getBodyMessage(context.getResources()));
        long noteLocalTimeForSyncConflicted = getPresenter().getNoteLocalTimeForSyncConflicted();
        long serverNoteModifiedTime = getPresenter().getServerNoteModifiedTime();
        this.mIsLatestLocal = noteLocalTimeForSyncConflicted > serverNoteModifiedTime;
        makeKeepCurrentButton(context, viewInflate, noteLocalTimeForSyncConflicted);
        makeReplaceButton(context, viewInflate, serverNoteModifiedTime);
        makeKeepBothButton(viewInflate);
        makeCompareButton(viewInflate);
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        this.mAlertDialog = alertDialogCreate;
        alertDialogCreate.setCanceledOnTouchOutside(false);
        this.mAlertDialog.setCancelable(false);
        this.mAlertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SyncConflictConfirmDialogFragment.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                SyncConflictConfirmDialogFragment.this.mAlertDialog = null;
            }
        });
        this.mAlertDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SyncConflictConfirmDialogFragment.2
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                InputMethodCompat.getInstance().forceHideSoftInput(context);
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_SYNC_CONFLICT, ComposerSAConstants.EVENT_DIALOGS_SYNC_CONFLICT_SHOW);
            }
        });
        return this.mAlertDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Logger.m11003i(TAG, "onPause");
        requireContext().unregisterReceiver(this.mDeletedFromServerBroadcastReceiver);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Runnable runnable;
        super.onPause();
        Logger.m11003i(TAG, "onPause");
        Handler handler = this.mHandler;
        if (handler == null || (runnable = this.mRunnable) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Logger.m11003i(TAG, "onResume");
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(this.mRunnable, 200L);
        }
    }
}
