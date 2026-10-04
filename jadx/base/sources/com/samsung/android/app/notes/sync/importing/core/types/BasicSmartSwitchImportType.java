package com.samsung.android.app.notes.sync.importing.core.types;

import com.samsung.android.app.notes.sync.items.ImportItem;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class BasicSmartSwitchImportType extends AbstractImportType {
    private boolean mFromSmartSwitch;
    private String mSessionTime;
    private String mSource;

    public BasicSmartSwitchImportType(List<ImportItem> list, String str, String str2, boolean z) {
        setImportItems(list);
        this.mSource = str;
        this.mSessionTime = str2;
        this.mFromSmartSwitch = z;
    }

    public boolean getFromSmartSwitch() {
        return this.mFromSmartSwitch;
    }

    public String getSessionTime() {
        return this.mSessionTime;
    }

    public String getSource() {
        return this.mSource;
    }
}
