package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiDrawingDeleteConfirmDialog extends Dialog {
    private static final String TAG = Logger.createTag("AiDrawingDeleteConfirmDialog", AiConstants.PREFIX_TAG);

    public AiDrawingDeleteConfirmDialog(Context context, final DialogContract.IAIDrawingDeleteConfirmDialogPresenter iAIDrawingDeleteConfirmDialogPresenter) {
        Logger.m10999d(TAG, "create#");
        AlertDialog.Builder builder = new AlertDialog.Builder(context, C9086R.style.NoteAlertDialogThemeForAppCompat);
        View viewInflate = LayoutInflater.from(context).inflate(C9086R.layout.ai_drawing_delete_confirm_dialog_option_layout, (ViewGroup) null);
        final CheckBox checkBox = (CheckBox) viewInflate.findViewById(C9086R.id.option_check_box);
        builder.setView(viewInflate);
        builder.setTitle(context.getResources().getString(C9086R.string.ai_drawing_delete_confirm_dialog_title));
        builder.setMessage(context.getResources().getQuantityString(C9086R.plurals.ai_drawing_delete_confirm_dialog_message, 10, 10));
        builder.setPositiveButton(context.getResources().getString(C9086R.string.dialog_delete), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.AiDrawingDeleteConfirmDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                iAIDrawingDeleteConfirmDialogPresenter.delete();
                if (checkBox.isChecked()) {
                    iAIDrawingDeleteConfirmDialogPresenter.setOffOption();
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNeutralButton(context.getResources().getString(C9086R.string.dialog_cancel), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.AiDrawingDeleteConfirmDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        this.mDialog = alertDialogCreate;
        alertDialogCreate.setCanceledOnTouchOutside(true);
        this.mDialog.setOnDismissListener(getDefaultDismissListener(iAIDrawingDeleteConfirmDialogPresenter));
    }
}
