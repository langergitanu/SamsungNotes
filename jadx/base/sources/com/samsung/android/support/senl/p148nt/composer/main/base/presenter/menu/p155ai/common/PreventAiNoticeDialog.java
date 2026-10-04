package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common;

import android.content.Context;
import android.content.DialogInterface;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PreventAiNoticeDialog {
    public void show(Context context, final Runnable runnable, final Runnable runnable2) {
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(context);
        StringBuilder sb = new StringBuilder();
        sb.append(context.getString(C9086R.string.settings_notes_prevent_ai));
        alertDialogBuilderForAppCompat.setTitle(C9086R.string.settings_notes_prevent_ai_title).setMessage(sb).setCancelable(true).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.PreventAiNoticeDialog.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                Runnable runnable3 = runnable2;
                if (runnable3 != null) {
                    runnable3.run();
                }
            }
        }).setNegativeButton(C9086R.string.dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.PreventAiNoticeDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Runnable runnable3 = runnable2;
                if (runnable3 != null) {
                    runnable3.run();
                }
                dialogInterface.dismiss();
            }
        }).setPositiveButton(C9086R.string.action_settings, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.PreventAiNoticeDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Runnable runnable3 = runnable;
                if (runnable3 != null) {
                    runnable3.run();
                }
            }
        });
        alertDialogBuilderForAppCompat.create().show();
    }
}
