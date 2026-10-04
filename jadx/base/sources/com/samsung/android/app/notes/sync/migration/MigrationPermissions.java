package com.samsung.android.app.notes.sync.migration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceManager;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import p042J1.AbstractC0147e;
import p042J1.C0148f;
import p079T.AbstractC0299q;
import p186h1.C12020a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MigrationPermissions extends Activity {
    private static final String EXPORT_SESSION_TIME_EXTRAS = "EXPORT_SESSION_TIME";
    private static final int MY_PERMISSIONS_WRITE_EXTERNAL_STORAGE_FOR_BACKUP = 1005;
    private static final int MY_PERMISSIONS_WRITE_EXTERNAL_STORAGE_FOR_RESOTRE_SF = 1006;
    private static final String SOURCE_EXTRAS = "SOURCE";
    private static final String TAG = "SS$".concat("MigrationPermissions");
    private Intent mIntent;

    private void runSmartSwitch() {
        C12020a.m13620N().f8772b = this.mIntent;
        ServiceManager.INSTANCE.getInstance().startService(BaseUtils.getApplicationContext(), new Intent(BaseUtils.getApplicationContext(), (Class<?>) MigrationService.class));
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.mIntent = intent;
        String[] strArr = (String[]) intent.getSerializableExtra("REQUIRED_PERMISSIONS");
        if (strArr == null) {
            AbstractC0299q.m646q(TAG, "onCreate invalid permissions");
            finish();
            return;
        }
        String action = this.mIntent.getAction();
        action.getClass();
        if (action.equals("com.samsung.android.intent.action.REQUEST_BACKUP_SAMSUNGNOTE")) {
            PermissionHelper.requestPermissions(this, 1005, strArr);
        } else if (action.equals("com.samsung.android.intent.action.REQUEST_RESTORE_SAMSUNGNOTE_SF")) {
            PermissionHelper.requestPermissions(this, 1006, strArr);
        } else {
            AbstractC0299q.m646q(TAG, "onCreate invalid request");
            finish();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        String str = TAG;
        AbstractC0299q.m643n(str, "onRequestPermissionsResult. Req code : " + i);
        if (i != 1005) {
            if (i != 1006) {
                AbstractC0299q.m646q(str, "onRequestPermissionsResult. Req code error.");
                return;
            }
            if (iArr.length > 0 && iArr[0] == 0) {
                runSmartSwitch();
            }
            finish();
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            String stringExtra = this.mIntent.hasExtra(SOURCE_EXTRAS) ? this.mIntent.getStringExtra(SOURCE_EXTRAS) : "";
            String stringExtra2 = this.mIntent.hasExtra(EXPORT_SESSION_TIME_EXTRAS) ? this.mIntent.getStringExtra(EXPORT_SESSION_TIME_EXTRAS) : "";
            String str2 = C0148f.f420k;
            AbstractC0147e.f419a.getClass();
            C0148f.m357m(1, 4, stringExtra, stringExtra2);
        } else {
            runSmartSwitch();
        }
        finish();
    }
}
