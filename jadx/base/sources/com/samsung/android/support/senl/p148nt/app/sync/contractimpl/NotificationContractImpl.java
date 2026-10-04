package com.samsung.android.support.senl.p148nt.app.sync.contractimpl;

import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification.SyncNotificationHelper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import p096Y.InterfaceC0342a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotificationContractImpl implements InterfaceC0342a {
    @Override // p096Y.InterfaceC0342a
    public void cancelAllImportNotification() {
        new SyncNotificationHelper(BaseUtils.getApplicationContext()).cancelAllImportNotification();
    }

    @Override // p096Y.InterfaceC0342a
    public void cancelAllSyncNotification() {
        new SyncNotificationHelper(BaseUtils.getApplicationContext()).cancelAllSyncNotification();
    }

    @Override // p096Y.InterfaceC0342a
    public void launchImportNotification(DocTypeConstants docTypeConstants, int i) {
        new SyncNotificationHelper(BaseUtils.getApplicationContext()).launchImportNotification(docTypeConstants, i);
    }

    @Override // p096Y.InterfaceC0342a
    public void launchImportTipCardNotification(DocTypeConstants docTypeConstants, int i) {
        new SyncNotificationHelper(BaseUtils.getApplicationContext()).launchImportTipCardNotification(docTypeConstants, i);
    }

    @Override // p096Y.InterfaceC0342a
    public void launchSyncNotification(TipCard tipCard) {
        new SyncNotificationHelper(BaseUtils.getApplicationContext()).launchSyncNotification(tipCard);
    }

    @Override // p096Y.InterfaceC0342a
    public void launchSyncTipCardNotification(TipCard tipCard) {
        new SyncNotificationHelper(BaseUtils.getApplicationContext()).launchSyncTipCardNotification(tipCard);
    }

    @Override // p096Y.InterfaceC0342a
    public void showImportedFileCorruptedMessage(int i, int i2, int i4) {
        String string = BaseUtils.getApplicationContext().getResources().getString(C8003R.string.sync_imported_corrupted_files, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4));
        if (i4 == 1) {
            string = BaseUtils.getApplicationContext().getResources().getString(C8003R.string.sync_imported_corrupted_one_file, Integer.valueOf(i), Integer.valueOf(i2));
        }
        if (i == 1) {
            string = BaseUtils.getApplicationContext().getResources().getString(C8003R.string.sync_imported_one_file_and_corrupted_files, Integer.valueOf(i4));
        }
        ToastHandler.show(BaseUtils.getApplicationContext(), string, 1);
    }

    @Override // p096Y.InterfaceC0342a
    public void showImportedFileSuccessMessage() {
        ToastHandler.show(BaseUtils.getApplicationContext(), BaseUtils.getApplicationContext().getResources().getString(C8003R.string.base_string_convert_finish), 1);
        NotesSamsungAnalytics.insertLog(SettingsSAConstants.SCREEN_OLDNOTES, NotesSAConstants.EVENT_OLDNOTES_CONVERT);
    }
}
