package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.menu;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.BarProgressDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.ObjectLimitConvertDialog;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncProgressListener;
import com.samsung.android.support.senl.p148nt.data.sync.resolver.MaxObjectLimitHelper;
import p026F1.C0099c;
import p244u1.C14477a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ConvertNoteMenu {
    private static final String TAG = "ConvertNoteMenu";
    private final AbsAppCompatActivity mActivity;

    public ConvertNoteMenu(AbsAppCompatActivity absAppCompatActivity) {
        this.mActivity = absAppCompatActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressDialog(final String str, String str2, String str3) {
        String string = this.mActivity.getString(C8003R.string.base_string_converting);
        if (TextUtils.isEmpty(str2)) {
            str2 = str3;
        }
        BarProgressDialogFragment barProgressDialogFragment = new BarProgressDialogFragment(string, str2);
        barProgressDialogFragment.setCanceledOnTouchOutside(false);
        barProgressDialogFragment.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.menu.ConvertNoteMenu.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                C14477a.m15065b().m15076l(102);
            }
        });
        barProgressDialogFragment.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.menu.ConvertNoteMenu.3
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                ConvertNoteMenu.this.startConvertNote(dialogInterface, str);
            }
        });
        barProgressDialogFragment.showAllowingStateLoss(this.mActivity.getSupportFragmentManager(), TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startConvertNote(final DialogInterface dialogInterface, String str) {
        C14477a c14477aM15065b = C14477a.m15065b();
        SyncProgressListener syncProgressListener = new SyncProgressListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.menu.ConvertNoteMenu.4
            @Override // com.samsung.android.support.senl.p148nt.base.common.sync.SyncProgressListener
            public void onEnded(int i) {
                AbstractC6670b.m4736A(i, "startConvertNote#onEnded : ", ConvertNoteMenu.TAG);
                dialogInterface.dismiss();
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.sync.SyncProgressListener
            public void onStarted() {
                MainLogger.m7254d(ConvertNoteMenu.TAG, "startConvertNote#onStarted");
            }
        };
        c14477aM15065b.getClass();
        Debugger.m8615i("SyncManager", "requestSyncUpFirstUsingGrouping() : " + str);
        MaxObjectLimitHelper.setUserConfirmConverting(str, true);
        C6903f.m5119c().f4475c = syncProgressListener;
        C0099c c0099c = new C0099c(64);
        c0099c.f323b = str;
        c14477aM15065b.f10283a.m5100j(c0099c);
    }

    public boolean startConvertNoteForSync(final MainEntryParam mainEntryParam) {
        if (!NotesUtils.isSyncNotSupported(mainEntryParam.getSyncState())) {
            return false;
        }
        new ObjectLimitConvertDialog(this.mActivity, new ObjectLimitConvertDialog.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.menu.ConvertNoteMenu.1
            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.ObjectLimitConvertDialog.OnClickListener
            public void convertNote() {
                MaxObjectLimitHelper.setUserConfirmConverting(mainEntryParam.getUuid(), true);
                ConvertNoteMenu.this.showProgressDialog(mainEntryParam.getUuid(), mainEntryParam.getDocTitle(), mainEntryParam.getUiTitle());
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.ObjectLimitConvertDialog.OnClickListener
            public void stopSync() {
                MaxObjectLimitHelper.setUserConfirmConverting(mainEntryParam.getUuid(), false);
                C14477a.m15065b().m15076l(102);
            }
        }).showDialog();
        return true;
    }
}
