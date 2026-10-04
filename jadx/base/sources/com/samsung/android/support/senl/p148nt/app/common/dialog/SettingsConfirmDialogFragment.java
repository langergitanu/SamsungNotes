package com.samsung.android.support.senl.p148nt.app.common.dialog;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.listener.OnBackKeyListener;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import p042J1.C0145c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SettingsConfirmDialogFragment extends DialogFragment implements OnBackKeyListener {
    public static final String TAG = "SettingsConfirmDialogFragment";
    public static final int TYPE_OPTION_TO_MOVE_PEN_TOOLS = 4;
    public static final int TYPE_SIGN_IN_AND_TURN_ON_SAMSUNG_CLOUD_SYNC = 3;
    public static final int TYPE_TURN_OFF_MS_SYNC = 1;
    public static final int TYPE_TURN_ON_SAMSUNG_CLOUD_SYNC = 2;
    public static final int TYPE_TURN_ON_WIFI_SETTINGS = 5;
    private DialogListener mDialogListener;
    private Boolean mIsWiFiSyncOnly = null;
    private int mMessageNameResID;
    private int mMessageResID;
    private int mNegativeResId;
    private int mPositiveResId;
    private int mTitleNameResID;
    private int mTitleResID;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DialogListener {
        void onCancel();

        void onConfirm();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface WifiSyncOnlyDialogListener extends DialogListener {
        void onConfirm(boolean z);
    }

    public SettingsConfirmDialogFragment() {
    }

    @StringRes
    public static int getSamsungAppNameRes(Context context) {
        return CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.settings_samsung_cloud_jp : CommonUtils.hasSaSetting(context) ? C8003R.string.settings_samsung_cloud_storage : C8003R.string.settings_samsung_cloud;
    }

    private void initRadioButtons(View view) {
        RadioGroup radioGroup = (RadioGroup) view.findViewById(C8003R.id.radio_group);
        radioGroup.setVisibility(0);
        RadioButton radioButton = (RadioButton) radioGroup.findViewById(C8003R.id.settings_wifi_sync_only_button);
        RadioButton radioButton2 = (RadioButton) radioGroup.findViewById(C8003R.id.settings_both_wifi_and_mobile_button);
        Boolean boolValueOf = Boolean.valueOf(C0145c.m299G(getContext()));
        this.mIsWiFiSyncOnly = boolValueOf;
        if (boolValueOf.booleanValue()) {
            radioButton.setChecked(true);
        } else {
            radioButton2.setChecked(true);
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.samsung.android.support.senl.nt.app.common.dialog.SettingsConfirmDialogFragment.3
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup2, int i) {
                if (i == C8003R.id.settings_wifi_sync_only_button) {
                    SettingsConfirmDialogFragment.this.mIsWiFiSyncOnly = Boolean.TRUE;
                } else if (i == C8003R.id.settings_both_wifi_and_mobile_button) {
                    SettingsConfirmDialogFragment.this.mIsWiFiSyncOnly = Boolean.FALSE;
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.app.common.listener.OnBackKeyListener
    public boolean onBackKeyDown() {
        DialogListener dialogListener = this.mDialogListener;
        if (dialogListener == null) {
            return false;
        }
        dialogListener.onCancel();
        return false;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        DialogListener dialogListener = this.mDialogListener;
        if (dialogListener != null) {
            dialogListener.onCancel();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        if (bundle != null) {
            this.mTitleResID = bundle.getInt("mTitleResID");
            this.mMessageResID = bundle.getInt("mMessageResID");
            this.mPositiveResId = bundle.getInt("mPositiveResId");
            this.mNegativeResId = bundle.getInt("mNegativeResId");
            this.mTitleNameResID = bundle.getInt("mTitleNameResID");
            this.mMessageNameResID = bundle.getInt("mMessageNameResID");
        }
        View viewInflate = getLayoutInflater().inflate(C8003R.layout.settings_sync_confirm_dialog_fragment, (ViewGroup) null);
        if (this.mMessageResID > 0) {
            if (this.mMessageNameResID > 0) {
                ((TextView) viewInflate.findViewById(C8003R.id.dialog_body_text)).setText(getString(this.mMessageResID, getString(this.mMessageNameResID)));
            } else {
                ((TextView) viewInflate.findViewById(C8003R.id.dialog_body_text)).setText(this.mMessageResID);
            }
        }
        if (C8003R.string.settings_sync_option_title == this.mTitleResID) {
            viewInflate.findViewById(C8003R.id.dialog_body_text).setVisibility(8);
            initRadioButtons(viewInflate);
        }
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getActivity()).setPositiveButton(this.mPositiveResId, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.common.dialog.SettingsConfirmDialogFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (SettingsConfirmDialogFragment.this.mDialogListener == null) {
                    return;
                }
                if (SettingsConfirmDialogFragment.this.mIsWiFiSyncOnly != null) {
                    ((WifiSyncOnlyDialogListener) SettingsConfirmDialogFragment.this.mDialogListener).onConfirm(SettingsConfirmDialogFragment.this.mIsWiFiSyncOnly.booleanValue());
                } else {
                    SettingsConfirmDialogFragment.this.mDialogListener.onConfirm();
                }
            }
        }).setNegativeButton(this.mNegativeResId, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.common.dialog.SettingsConfirmDialogFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (SettingsConfirmDialogFragment.this.mDialogListener != null) {
                    SettingsConfirmDialogFragment.this.mDialogListener.onCancel();
                }
            }
        }).create();
        alertDialogCreate.setView(viewInflate);
        int i = this.mTitleResID;
        if (i > 0) {
            int i2 = this.mTitleNameResID;
            if (i2 > 0) {
                alertDialogCreate.setTitle(getString(i, getString(i2)));
            } else {
                alertDialogCreate.setTitle(i);
            }
        }
        alertDialogCreate.setCancelable(true);
        alertDialogCreate.setCanceledOnTouchOutside(false);
        ResourceUtils.setBlurInfoPopup(getContext(), alertDialogCreate.findViewById(R.id.content));
        return alertDialogCreate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putInt("mTitleResID", this.mTitleResID);
        bundle.putInt("mMessageResID", this.mMessageResID);
        bundle.putInt("mTitleNameResID", this.mTitleNameResID);
        bundle.putInt("mMessageNameResID", this.mMessageNameResID);
        bundle.putInt("mPositiveResId", this.mPositiveResId);
        bundle.putInt("mNegativeResId", this.mNegativeResId);
    }

    public void setDialogListener(DialogListener dialogListener) {
        this.mDialogListener = dialogListener;
    }

    public void showAllowingStateLoss(FragmentManager fragmentManager, String str) {
        if (fragmentManager == null || fragmentManager.isDestroyed()) {
            return;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.add(this, str);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    public SettingsConfirmDialogFragment(int i) {
        if (i == 1) {
            this.mTitleResID = C8003R.string.settings_sync_to_ms_turn_off_confirm_dialog_title;
            this.mMessageResID = C8003R.string.settings_sync_to_ms_turn_off_confirm_dialog_body;
            this.mMessageNameResID = getSamsungAppNameRes(getContext());
            this.mPositiveResId = C8003R.string.settings_sync_to_ms_turn_off_confirm_dialog_positive_button;
            this.mNegativeResId = C8003R.string.cancel_btn;
            return;
        }
        if (i == 2) {
            this.mTitleResID = C8003R.string.settings_sync_your_notes_with_samsung_cloud_dialog_title;
            this.mTitleNameResID = getSamsungAppNameRes(getContext());
            this.mMessageResID = C8003R.string.settings_sync_with_samsung_cloud_turn_on_confirm_dialog_body;
            this.mMessageNameResID = getSamsungAppNameRes(getContext());
            this.mPositiveResId = C8003R.string.sync;
            this.mNegativeResId = C8003R.string.cancel_btn;
            return;
        }
        if (i == 3) {
            this.mTitleResID = C8003R.string.settings_sync_your_notes_with_samsung_cloud_dialog_title;
            this.mTitleNameResID = getSamsungAppNameRes(getContext());
            this.mMessageResID = C8003R.string.settings_samsung_account_login_for_ms_sync_body;
            this.mMessageNameResID = getSamsungAppNameRes(getContext());
            this.mPositiveResId = C8003R.string.settings_samsung_account_login_for_ms_sync_positive;
            this.mNegativeResId = C8003R.string.cancel_btn;
            return;
        }
        if (i == 4) {
            this.mMessageResID = DeviceInfo.getSemPlatformVersionInt(0) < 140000 ? C8003R.string.settings_use_phone_as_toolbar_dialog_message : C8003R.string.settings_use_phone_as_toolbar_dialog_message_sep_14;
            this.mPositiveResId = C8003R.string.base_string_settings;
            this.mNegativeResId = C8003R.string.cancel_btn;
        } else {
            if (i != 5) {
                AbstractC8014b.m7201c(i, "unexpected type: ", TAG);
                return;
            }
            this.mTitleResID = C8003R.string.settings_sync_option_title;
            this.mPositiveResId = C8003R.string.dialog_done;
            this.mNegativeResId = C8003R.string.cancel_btn;
        }
    }
}
