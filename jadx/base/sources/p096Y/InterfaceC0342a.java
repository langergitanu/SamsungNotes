package p096Y;

import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard;

/* JADX INFO: renamed from: Y.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface InterfaceC0342a {
    void cancelAllImportNotification();

    void cancelAllSyncNotification();

    void launchImportNotification(DocTypeConstants docTypeConstants, int i);

    void launchImportTipCardNotification(DocTypeConstants docTypeConstants, int i);

    void launchSyncNotification(TipCard tipCard);

    void launchSyncTipCardNotification(TipCard tipCard);

    void showImportedFileCorruptedMessage(int i, int i2, int i4);

    void showImportedFileSuccessMessage();
}
