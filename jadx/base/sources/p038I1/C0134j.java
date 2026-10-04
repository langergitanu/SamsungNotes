package p038I1;

import android.content.Context;
import com.samsung.android.support.notes.sync.C7943R;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import java.util.ArrayList;
import p192j1.C12936a;

/* JADX INFO: renamed from: I1.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0134j extends TipCard {
    public C0134j() {
        super(11, C7943R.string.sync_tipcard_fail_to_sync_permission_denied_title, C7943R.string.sync_tipcard_fail_to_sync_permission_denied_body, C7943R.string.base_string_settings, 0, 4);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard
    public final String getMessage() {
        Context applicationContext = BaseUtils.getApplicationContext();
        int bodyResource = getBodyResource();
        Context applicationContext2 = BaseUtils.getApplicationContext();
        C12936a.m13839c().getClass();
        ArrayList arrayListM13840e = C12936a.m13840e();
        String[] strArr = new String[arrayListM13840e.size()];
        for (int i = 0; i < arrayListM13840e.size(); i++) {
            strArr[i] = PermissionCompat.getPermissionGroupName(applicationContext2, (String) arrayListM13840e.get(i));
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append(CharUtils.arrayJoin(applicationContext2.getString(C7943R.string.string_comma) + " ", strArr));
        return applicationContext.getString(bodyResource, sb.toString());
    }
}
