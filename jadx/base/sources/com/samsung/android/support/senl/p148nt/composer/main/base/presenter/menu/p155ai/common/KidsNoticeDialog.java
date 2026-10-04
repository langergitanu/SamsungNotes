package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common;

import android.content.Context;
import android.content.DialogInterface;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class KidsNoticeDialog {
    public void show(Context context, final Runnable runnable, int i) {
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(context);
        alertDialogBuilderForAppCompat.setMessage(context.getResources().getQuantityString(C9086R.plurals.kids_notice, i, Integer.valueOf(i))).setPositiveButton(C9086R.string.f6715OK, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.KidsNoticeDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        });
        alertDialogBuilderForAppCompat.create().show();
    }
}
