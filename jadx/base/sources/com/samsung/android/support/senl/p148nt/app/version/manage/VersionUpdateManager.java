package com.samsung.android.support.senl.p148nt.app.version.manage;

import com.samsung.android.support.senl.p148nt.app.version.history.VersionUpdate;
import com.samsung.android.support.senl.p148nt.app.version.history.VersionUpdate_To_4_2_0_22;
import com.samsung.android.support.senl.p148nt.app.version.history.VersionUpdate_To_4_2_1_53;
import com.samsung.android.support.senl.p148nt.app.version.history.VersionUpdate_To_4_2_4_27;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class VersionUpdateManager {
    public static final int[] APP_VERSION_TABLE = {0, 2, 3, 4};
    public static final String VERSION_4_1_0_01 = "4.1.0.01";
    public static final String VERSION_4_2_0_22 = "4.2.0.22";
    public static final String VERSION_4_2_1_53 = "4.2.1.53";
    public static final String VERSION_4_2_4_27 = "4.2.4.27";
    public static final int VERSION_CODE_4_1_0_01 = 0;
    public static final int VERSION_CODE_4_2_0_22 = 2;
    public static final int VERSION_CODE_4_2_1_53 = 3;
    public static final int VERSION_CODE_4_2_4_27 = 4;

    public int convertVersionCode(String str) {
        return 0;
    }

    public VersionUpdate createVersionUpdate(int i, int i2) {
        if (i2 == 2) {
            return new VersionUpdate_To_4_2_0_22(i);
        }
        if (i2 == 3) {
            return new VersionUpdate_To_4_2_1_53(i);
        }
        if (i2 != 4) {
            return null;
        }
        return new VersionUpdate_To_4_2_4_27(i);
    }

    public List<VersionUpdate> findUpgrades(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i4 : APP_VERSION_TABLE) {
            if (i < i4 && i4 <= i2) {
                arrayList.add(createVersionUpdate(i, i4));
            }
        }
        return arrayList;
    }
}
