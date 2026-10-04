package com.samsung.android.support.senl.p148nt.app.sync.p150ui.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.importing.controllers.C6753b;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification.SyncNotificationHelper;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import p042J1.C0145c;
import p044K.C0158a;
import p186h1.C12028i;
import p248v0.C14497a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NetworkConnectionFailedDialog extends AppCompatActivity {
    public static final String IS_RUN_ON_ACTIVITY = "RUN_ON_ACTIVITY";
    private static final int REQUEST_CODE = 1234;
    private static final String TAG = "NT$NetworkConnectionFailedDialog";
    private int mSyncType;
    private static final int RES_ID_BTN_OK = C8003R.string.sync_network_dialog_btn_ok;
    private static final int RES_ID_BTN_CANCEL = C8003R.string.sync_network_dialog_btn_cancel;
    private Context mContext = null;
    private AlertDialog mAlertDialog = null;
    private int mConnectionType = -1;
    private boolean mRunOnActivity = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SingleButtonClickListener implements DialogInterface.OnClickListener {
        private final int mType;

        public SingleButtonClickListener(int i) {
            this.mType = i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (NetworkConnectionFailedDialog.this.mContext == null) {
                return;
            }
            NetworkConnectionFailedDialog networkConnectionFailedDialog = NetworkConnectionFailedDialog.this;
            NetworkConnectionFailedType.getInstance();
            AbstractC4539a.m3190D("[SingleButtonClickListener] onClick(OK) : ", networkConnectionFailedDialog.getString(NetworkConnectionFailedType.getResIdTitle(this.mType)), NetworkConnectionFailedDialog.TAG);
            NetworkConnectionFailedDialog.this.networkConnectionResolved(false);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class TwoButtonNegativeClickListener implements DialogInterface.OnClickListener {
        private final int mType;

        public TwoButtonNegativeClickListener(int i) {
            this.mType = i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (NetworkConnectionFailedDialog.this.mContext == null) {
                return;
            }
            NetworkConnectionFailedDialog networkConnectionFailedDialog = NetworkConnectionFailedDialog.this;
            NetworkConnectionFailedType.getInstance();
            AbstractC4539a.m3190D("[TwoButtonNegativeClickListener] onClick(Negative) : ", networkConnectionFailedDialog.getString(NetworkConnectionFailedType.getResIdTitle(this.mType)), NetworkConnectionFailedDialog.TAG);
            NetworkConnectionFailedDialog.this.cancelImportList();
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class TwoButtonPositiveClickListener implements DialogInterface.OnClickListener {
        private final int mType;

        public TwoButtonPositiveClickListener(int i) {
            this.mType = i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (NetworkConnectionFailedDialog.this.mContext == null) {
                return;
            }
            NetworkConnectionFailedDialog networkConnectionFailedDialog = NetworkConnectionFailedDialog.this;
            NetworkConnectionFailedType.getInstance();
            AbstractC4539a.m3190D("[TwoButtonPositiveClickListener] onClick(OK BTN) : ", networkConnectionFailedDialog.getString(NetworkConnectionFailedType.getResIdTitle(this.mType)), NetworkConnectionFailedDialog.TAG);
            int i2 = this.mType;
            if (i2 == 104) {
                Debugger.m8607d(NetworkConnectionFailedDialog.TAG, "[TwoButtonPositiveClickListener] onClick(OK) : DATA_REACHED_TO_LIMIT");
                NetworkConnectionFailedDialog.this.startMoblieDataUsage();
                return;
            }
            if (i2 == 2) {
                Debugger.m8607d(NetworkConnectionFailedDialog.TAG, "[TwoButtonPositiveClickListener] onClick(OK) : ROAM_DATA_WARNING");
                NetworkConnectionFailedDialog.this.networkConnectionResolved(true);
                dialogInterface.dismiss();
            } else if (i2 == 3) {
                Debugger.m8607d(NetworkConnectionFailedDialog.TAG, "[TwoButtonPositiveClickListener] onClick(OK) : MOBILE_DATA_WARNING");
                NetworkConnectionFailedDialog.this.networkConnectionResolved(true);
                dialogInterface.dismiss();
            } else {
                Integer numValueOf = Integer.valueOf(i2);
                NetworkConnectionFailedDialog networkConnectionFailedDialog2 = NetworkConnectionFailedDialog.this;
                NetworkConnectionFailedType.getInstance();
                Debugger.m8607d(NetworkConnectionFailedDialog.TAG, String.format("[TwoButtonPositiveClickListener] no Err Type(%d) : %s", numValueOf, networkConnectionFailedDialog2.getString(NetworkConnectionFailedType.getResIdTitle(this.mType))));
                NetworkConnectionFailedDialog.this.networkConnectionResolved(false);
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelImportList() {
        Debugger.m8607d(TAG, "cancelImportList()");
        if (this.mSyncType == 3) {
            C14497a c14497aM15078a = C14497a.m15078a();
            c14497aM15078a.getClass();
            C0158a.m407a().getClass();
            if (C0158a.m411g()) {
                c14497aM15078a.f10310a.m4894a(new C12028i(), true);
            } else {
                Debugger.m8615i("ImportManager", "onCancelImportDialogFinish : not supported!)");
            }
        }
    }

    private boolean getConnectionFailedType(Intent intent) {
        try {
            Bundle extras = intent.getExtras();
            Object obj = extras.get(NetworkConnectionFailedHelper.NETWORK_CONNECTION_FAILED_TYPE);
            if (obj == null) {
                return false;
            }
            this.mConnectionType = Integer.valueOf((String) obj).intValue();
            Object obj2 = extras.get(NetworkConnectionFailedHelper.NETWORK_CONNECTION_SYNC_TYPE);
            if (obj2 == null) {
                return false;
            }
            this.mSyncType = Integer.valueOf((String) obj2).intValue();
            Object obj3 = extras.get(IS_RUN_ON_ACTIVITY);
            if (obj3 == null) {
                return false;
            }
            this.mRunOnActivity = Boolean.valueOf((String) obj3).booleanValue();
            Debugger.m8607d(TAG, String.format("getConnectionFailedType() : %d, %d, runOnActivity(%s)", Integer.valueOf(this.mConnectionType), Integer.valueOf(this.mSyncType), this.mRunOnActivity ? "true" : "false"));
            return true;
        } catch (Exception e) {
            AbstractC4539a.m3213w(e, new StringBuilder("getConnectionFailedType(intent) : Failed with exception "), TAG);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void networkConnectionResolved(boolean z) {
        AbstractC4539a.m3190D("networkConnectionResolved() - RESOLVE : ", Boolean.toString(z), TAG);
        if (z) {
            new SyncNotificationHelper(this.mContext).cancelNetworkErrNotification();
        }
        if (z) {
            C14497a c14497aM15078a = C14497a.m15078a();
            int i = this.mConnectionType;
            int i2 = this.mSyncType;
            c14497aM15078a.getClass();
            C0158a.m407a().getClass();
            if (C0158a.m411g()) {
                c14497aM15078a.f10310a.m4894a(new C6753b(i, i2), true);
            } else {
                Debugger.m8615i("ImportManager", "onNetworkConnectionFailedDialogFinish : not supported!)");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startMoblieDataUsage() {
        Debugger.m8607d(TAG, "startMoblieDataUsage()");
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.setAction("android.settings.WIFI_SETTINGS");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_CODE);
            Debugger.m8607d(TAG, "\t Intent (android.provider.Settings.ACTION_WIFI_SETTINGS)");
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Debugger.m8607d(TAG, "finish()");
        if (this.mRunOnActivity) {
            overridePendingTransition(0, 0);
        }
        super.finish();
    }

    public int getConnectionType() {
        return this.mConnectionType;
    }

    public int getSyncType() {
        return this.mSyncType;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Debugger.m8607d(TAG, "onActivityResult()");
        if (C0145c.m337v(this.mContext)) {
            Debugger.m8607d(TAG, "\t RE-CONNECT SUCCEED (resolved)");
            this.mConnectionType = 1;
            networkConnectionResolved(true);
        } else {
            networkConnectionResolved(false);
            Debugger.m8607d(TAG, "\t RE-CONNECT FAILED");
        }
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mRunOnActivity) {
            overridePendingTransition(0, 0);
        }
        this.mContext = this;
        Debugger.m8607d(TAG, "onCreate()");
        setContentView(C8003R.layout.transparent_activity_main);
        if (getIntent().getExtras() == null || !getConnectionFailedType(getIntent())) {
            finish();
        } else {
            showWarningDialog(this.mConnectionType);
            NetworkConnectionFailedHelper.getInstance().setCurrentDialog(this);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Debugger.m8607d(TAG, "onDestroy()");
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.mAlertDialog = null;
        }
        NetworkConnectionFailedHelper.getInstance().setCurrentDialog(null);
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Debugger.m8607d(TAG, "onNewIntent()");
    }

    public void showWarningDialog(int i) {
        String string;
        String string2;
        if (i == -1) {
            return;
        }
        if (i == 2 || i == 3) {
            if (this.mSyncType == 1) {
                Debugger.m8607d(TAG, String.format("showWarningDialog() : ignore type(%d)", Integer.valueOf(i)));
                networkConnectionResolved(true);
                finish();
                return;
            }
            string = this.mContext.getString(RES_ID_BTN_OK);
            string2 = this.mContext.getString(RES_ID_BTN_CANCEL);
        } else {
            if (i != 101 && i != 102 && i != 103 && i != 100) {
                if (i == 0 && this.mSyncType == 3) {
                    Debugger.m8607d(TAG, String.format("showWarningDialog() : WAN type(%d)", Integer.valueOf(i)));
                    finish();
                    return;
                } else {
                    Debugger.m8607d(TAG, String.format("showWarningDialog() : Incorrect type(%d)", Integer.valueOf(i)));
                    networkConnectionResolved(true);
                    finish();
                    return;
                }
            }
            string = this.mContext.getString(RES_ID_BTN_OK);
            string2 = null;
        }
        NetworkConnectionFailedType.getInstance();
        String string3 = getString(NetworkConnectionFailedType.getResIdTitle(i));
        NetworkConnectionFailedType.getInstance();
        String string4 = getString(NetworkConnectionFailedType.getResIdBody(i));
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(this);
        alertDialogBuilderForAppCompat.setTitle(string3);
        alertDialogBuilderForAppCompat.setMessage(string4);
        alertDialogBuilderForAppCompat.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.samsung.android.support.senl.nt.app.sync.ui.dialog.NetworkConnectionFailedDialog.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                if (i2 == 4) {
                    NetworkConnectionFailedDialog.this.finish();
                    NetworkConnectionFailedDialog.this.networkConnectionResolved(false);
                    return true;
                }
                if (i2 != 66 && i2 != 23) {
                    return false;
                }
                if (NetworkConnectionFailedDialog.this.mAlertDialog != null && NetworkConnectionFailedDialog.this.mAlertDialog.isShowing()) {
                    Button button = NetworkConnectionFailedDialog.this.mAlertDialog.getButton(-1);
                    Button button2 = NetworkConnectionFailedDialog.this.mAlertDialog.getButton(-2);
                    NetworkConnectionFailedDialog.this.finish();
                    if (button != null && button.isFocused()) {
                        NetworkConnectionFailedDialog.this.networkConnectionResolved(true);
                        return true;
                    }
                    if (button2 != null && button2.isFocused()) {
                        NetworkConnectionFailedDialog.this.networkConnectionResolved(false);
                    }
                }
                return true;
            }
        });
        Debugger.m8607d(TAG, "showWarningDialog() : " + string3 + SQLKeyword.COMMA + string4);
        if (TextUtils.isEmpty(string2)) {
            alertDialogBuilderForAppCompat.setPositiveButton(string, new SingleButtonClickListener(i));
        } else {
            alertDialogBuilderForAppCompat.setPositiveButton(string, new TwoButtonPositiveClickListener(i)).setNegativeButton(string2, new TwoButtonNegativeClickListener(i));
        }
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        this.mAlertDialog = alertDialogCreate;
        alertDialogCreate.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.app.sync.ui.dialog.NetworkConnectionFailedDialog.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                NetworkConnectionFailedDialog.this.mAlertDialog = null;
                Debugger.m8607d(NetworkConnectionFailedDialog.TAG, "onDismiss()");
                NetworkConnectionFailedDialog.this.finish();
            }
        });
        this.mAlertDialog.setCanceledOnTouchOutside(!this.mRunOnActivity);
        this.mAlertDialog.show();
    }
}
