package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.DialogViewContract;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ExportPdfDialogFragment extends AbsDialogFragment {
    private static final String KEY_EXPORTING_NOTE_NAME = "key_exporting_note_name";
    private static final String KEY_FINISHED = "key_finished";
    private static final String KEY_TOTAL = "key_total";
    private AlertDialog mAlertDialog;
    private DialogViewContract.IExportPdfDialog mContract;
    private String mExportingNoteName;
    private TextView mExportingNoteNameTextView;
    private int mFinished;
    private ProgressBar mProgressBar;
    private TextView mProgressPercentTextView;
    private TextView mProgressRateTextView;
    private int mTotal;

    public ExportPdfDialogFragment() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelShareTask() {
        DialogViewContract.IExportPdfDialog iExportPdfDialog = this.mContract;
        if (iExportPdfDialog == null) {
            return;
        }
        iExportPdfDialog.cancelTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getProgressPercent(int i) {
        return getContext() == null ? "" : String.format(LocaleUtils.getLocale(getResources().getConfiguration()), "%d%%", Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public String getProgressRate() {
        if (LocaleUtils.isRTLMode()) {
            return LocaleUtils.convertToArabicNumber(this.mTotal) + "/" + LocaleUtils.convertToArabicNumber(this.mFinished);
        }
        return this.mFinished + "/" + this.mTotal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgressValue() {
        int i = this.mTotal;
        if (i <= 0) {
            return 0;
        }
        return (this.mFinished * 100) / i;
    }

    private void initLayout(@NonNull View view) {
        this.mExportingNoteNameTextView = (TextView) view.findViewById(C8003R.id.exporting_note_name);
        this.mProgressRateTextView = (TextView) view.findViewById(C8003R.id.progress_rate);
        this.mProgressPercentTextView = (TextView) view.findViewById(C8003R.id.progress_percent);
        this.mProgressBar = (ProgressBar) view.findViewById(C8003R.id.progress_bar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTitle() {
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog == null) {
            return;
        }
        Resources resources = getResources();
        int i = C8003R.plurals.save_as_pdf_dialog_title;
        int i2 = this.mTotal;
        alertDialog.setTitle(resources.getQuantityString(i, i2, Integer.valueOf(i2)));
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        View viewInflate = View.inflate(getContext(), C8003R.layout.pdf_export_dialog, null);
        initLayout(viewInflate);
        onRestoreInstanceState(bundle);
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(getContext());
        Resources resources = getResources();
        int i = C8003R.plurals.save_as_pdf_dialog_title;
        int i2 = this.mTotal;
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.setTitle(resources.getQuantityString(i, i2, Integer.valueOf(i2))).setView(viewInflate).setNegativeButton(C8003R.string.cancel_btn, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.ExportPdfDialogFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                ExportPdfDialogFragment.this.cancelShareTask();
            }
        }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.ExportPdfDialogFragment.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
                if (ExportPdfDialogFragment.this.getParentFragment() == null) {
                    return false;
                }
                if ((i4 == 4 || i4 == 111) && keyEvent.getAction() == 1) {
                    ExportPdfDialogFragment.this.cancelShareTask();
                }
                return false;
            }
        }).setCancelable(true).create();
        this.mAlertDialog = alertDialogCreate;
        alertDialogCreate.setCanceledOnTouchOutside(false);
        return this.mAlertDialog;
    }

    public void onRestoreInstanceState(@Nullable Bundle bundle) {
        int i = this.mTotal;
        int i2 = this.mFinished;
        String string = this.mExportingNoteName;
        if (bundle != null) {
            i = bundle.getInt(KEY_TOTAL);
            i2 = bundle.getInt(KEY_FINISHED);
            string = bundle.getString(KEY_EXPORTING_NOTE_NAME);
        }
        updateProgress(i, i2);
        updateExportingNoteName(string);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(KEY_TOTAL, this.mTotal);
        bundle.putInt(KEY_FINISHED, this.mFinished);
        bundle.putString(KEY_EXPORTING_NOTE_NAME, this.mExportingNoteName);
    }

    public void setContract(DialogViewContract.IExportPdfDialog iExportPdfDialog) {
        this.mContract = iExportPdfDialog;
    }

    public void updateExportingNoteName(String str) {
        this.mExportingNoteName = str;
        FragmentActivity activity = getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.ExportPdfDialogFragment.3
            @Override // java.lang.Runnable
            public void run() {
                ExportPdfDialogFragment.this.mExportingNoteNameTextView.setText(ExportPdfDialogFragment.this.mExportingNoteName);
            }
        });
    }

    public void updateProgress(int i, int i2) {
        this.mTotal = i;
        this.mFinished = i2;
        FragmentActivity activity = getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.ExportPdfDialogFragment.4
            @Override // java.lang.Runnable
            public void run() {
                ExportPdfDialogFragment.this.updateTitle();
                int progressValue = ExportPdfDialogFragment.this.getProgressValue();
                ExportPdfDialogFragment.this.mProgressRateTextView.setText(ExportPdfDialogFragment.this.getProgressRate());
                ExportPdfDialogFragment.this.mProgressPercentTextView.setText(ExportPdfDialogFragment.this.getProgressPercent(progressValue));
                ExportPdfDialogFragment.this.mProgressBar.setProgress(progressValue);
            }
        });
    }

    public ExportPdfDialogFragment(int i) {
        this();
        this.mTotal = i;
    }
}
