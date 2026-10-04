package com.samsung.android.app.notes.sync.importing.core.types;

import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SmartSwitchImportTypeFactory {
    private static final String TAG = "SS$SmartSwitchImportTypeFactory";

    public static BasicSmartSwitchImportType getImportTypeByMask(int i, String str, String str2, boolean z, List<ImportItem> list) {
        if ((i & 1) != 0 || (i & 64) != 0) {
            if (list != null && !list.isEmpty()) {
                return new SmartSwitchSDocImportType(list, str, str2, z);
            }
            AbstractC0000a.m17n(i, "No item to restore. type : ", TAG);
            return null;
        }
        if ((i & 8) != 0) {
            if (list != null && !list.isEmpty()) {
                return new SmartSwitchNMemoImportType(list, str, str2, z);
            }
            AbstractC0000a.m17n(i, "No item to restore. type : ", TAG);
            return null;
        }
        if ((i & 32) != 0 || (i & 16) != 0) {
            return new SmartSwitchNMemoImportType(list, str, str2, z);
        }
        if ((i & 2) != 0) {
            return new SmartSwitchLMemoImportType(list, str, str2, z);
        }
        if ((i & 512) != 0) {
            return new SmartSwitchQMemoImportType(list, str, str2, z);
        }
        if ((i & 4) != 0) {
            return new SmartSwitchTMemo1ImportType(list, str, str2, z);
        }
        if ((i & 256) != 0) {
            return new SmartSwitchSnbSpdImportType(list, str, str2, z);
        }
        if ((i & 128) != 0) {
            AbstractC0000a.m17n(i, "Do Nothing. type : ", TAG);
            return null;
        }
        Debugger.m8609e(TAG, "Mask not matched. type : " + i);
        return null;
    }
}
