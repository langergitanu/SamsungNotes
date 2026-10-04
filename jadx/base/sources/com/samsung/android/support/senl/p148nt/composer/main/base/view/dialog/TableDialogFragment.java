package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.picker.widget.SeslNumberPicker;
import androidx.picker.widget.SeslTimePicker;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.app.lock.view.verify.DialogInterfaceOnClickListenerC8137b;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.TableDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.TableCellSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TableDialogFragment extends DialogFragment {
    private static final int DEFAULT_COLUMN = 2;
    private static final int DEFAULT_ROW = 2;
    private static final int MAXIMUM_COLUMN = 10;
    private static final int MAXIMUM_ROW = 10;
    private static final String TAG = Logger.createTag("TableDialogFragment");
    private AlertDialog mAlertDialog;
    private TableDialogPresenter mPresenter;

    private TableDialogPresenter getPresenter() {
        DialogContract.IFragmentPresenterContainer iFragmentPresenterContainer;
        if (this.mPresenter == null && getActivity() != null && (iFragmentPresenterContainer = (DialogContract.IFragmentPresenterContainer) getActivity().getSupportFragmentManager().findFragmentByTag("Composer")) != null) {
            this.mPresenter = (TableDialogPresenter) iFragmentPresenterContainer.getDialogFragmentPresenter(19);
        }
        if (this.mPresenter == null) {
            Logger.m11000e(TAG, "getPresenter()# Presenter is null. dismiss call");
            dismiss();
        }
        return this.mPresenter;
    }

    private SeslNumberPicker initNumberPicker(SeslTimePicker seslTimePicker, int i, int i2, int i4) {
        SeslNumberPicker numberPicker = seslTimePicker.getNumberPicker(i);
        numberPicker.setMinValue(1);
        numberPicker.setValue(i2);
        numberPicker.setMaxValue(i4);
        numberPicker.setFormatter(null);
        numberPicker.setErrorToastMessage(seslTimePicker.getResources().getQuantityString(C9086R.plurals.plurals_composer_table_create_error_message, 10, 10));
        return numberPicker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$0(SeslNumberPicker seslNumberPicker, SeslNumberPicker seslNumberPicker2, DialogInterface dialogInterface, int i) {
        seslNumberPicker.setEditTextMode(false);
        seslNumberPicker2.setEditTextMode(false);
        getPresenter().createTable(seslNumberPicker.getValue(), seslNumberPicker2.getValue());
        ComposerSA.insertLog(TableCellSAConstants.PAGE_ID_TABLE, TableCellSAConstants.EVENT_TABLE_CREATE_SIZE, seslNumberPicker.getValue() + " X " + seslNumberPicker2.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$1(DialogInterface dialogInterface, int i) {
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        if (getPresenter() == null || getContext() == null) {
            return super.onCreateDialog(bundle);
        }
        Context context = getContext();
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(context);
        alertDialogBuilderForAppCompat.setTitle(getString(C9086R.string.composer_table_add_dialog_title));
        View viewInflate = View.inflate(context, C9086R.layout.comp_table_create_dialog, null);
        alertDialogBuilderForAppCompat.setView(viewInflate);
        SeslTimePicker seslTimePicker = (SeslTimePicker) viewInflate.findViewById(C9086R.id.composer_table_size_picker);
        seslTimePicker.setIs24HourView(Boolean.TRUE);
        TextView textView = (TextView) seslTimePicker.findViewById(C9086R.id.sesl_timepicker_divider);
        if (textView != null) {
            textView.setText("×");
            textView.setTextColor(context.getColor(C9086R.color.tag_editor_progress_color_1));
        }
        boolean zIsRTLMode = LocaleUtils.isRTLMode();
        alertDialogBuilderForAppCompat.setPositiveButton(C9086R.string.dialog_done, new DialogInterfaceOnClickListenerC8137b(this, 2, initNumberPicker(seslTimePicker, zIsRTLMode ? 1 : 0, 2, 10), initNumberPicker(seslTimePicker, !zIsRTLMode ? 1 : 0, ResourceUtils.isTabletLayout(context) ? 3 : 2, 10))).setNegativeButton(C9086R.string.dialog_cancel, new DialogInterfaceOnClickListenerC10231a(this, 4));
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        this.mAlertDialog = alertDialogCreate;
        alertDialogCreate.setCanceledOnTouchOutside(false);
        this.mAlertDialog.setCancelable(false);
        this.mAlertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.TableDialogFragment.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                TableDialogFragment.this.mAlertDialog = null;
            }
        });
        return this.mAlertDialog;
    }
}
