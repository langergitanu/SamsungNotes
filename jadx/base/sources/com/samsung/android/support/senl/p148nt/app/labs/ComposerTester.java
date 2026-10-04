package com.samsung.android.support.senl.p148nt.app.labs;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncDocumentState;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceBinder;
import com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper;
import com.samsung.android.support.senl.p148nt.model.service.NotesWordDocumentService;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ComposerTester {
    private final Context mContext;
    private Handler mHandler = new Handler();
    private IDocumentServiceWrapper mService;
    private DocumentSubscriptionId mSubscriptionId;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class DocumentServiceConnection implements ServiceConnection {
        public /* synthetic */ DocumentServiceConnection(ComposerTester composerTester, int i) {
            this();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder instanceof IDocumentServiceBinder) {
                ComposerTester.this.mService = ((IDocumentServiceBinder) iBinder).subscribe(DocumentSubscriptionId.SYNC_SERVICE_ID.getUser(), ComposerTester.this.mSubscriptionId);
                ComposerTester composerTester = ComposerTester.this;
                composerTester.mSubscriptionId = composerTester.mService.getUser();
                Intent intent = new Intent();
                intent.putExtra(SyncDocumentState.DOCUMENT_STATE_TYPE, 1);
                intent.putExtra("sdocx_uuid", ComposerManager.getInstance().getLatestComposerUuid());
                ComposerTester.this.mService.sendBroadcastMessage(ComposerTester.this.mService.getUser(), intent);
                ComposerTester.this.mHandler.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.labs.ComposerTester.DocumentServiceConnection.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ComposerTester.this.mService != null) {
                            ComposerTester.this.mService.unsubscribe();
                        }
                    }
                }, 1000L);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ComposerTester.this.mService = null;
        }

        private DocumentServiceConnection() {
        }
    }

    public ComposerTester(@NonNull Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAppUpdateDialog() {
        if (TextUtils.isEmpty(ComposerManager.getInstance().getLatestComposerUuid())) {
            return;
        }
        this.mContext.bindService(new Intent(this.mContext, (Class<?>) NotesWordDocumentService.class), new DocumentServiceConnection(this, 0), 1);
    }

    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setPositiveButton("Version conflict", new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.labs.ComposerTester.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ComposerTester.this.startAppUpdateDialog();
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }
}
