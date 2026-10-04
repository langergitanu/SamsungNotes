package com.samsung.android.app.notes.sync.importing.core.types;

import com.samsung.android.app.notes.sync.importing.core.ImportHelper;
import p252w0.AbstractC14503a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class BasicSmartSwitchImportHelperAdapter extends BasicImportHelperAdapter {
    public BasicSmartSwitchImportHelperAdapter(ImportHelper importHelper) {
        super(importHelper);
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.types.BasicImportHelperAdapter
    public void configureImportHelper(AbstractImportType abstractImportType) {
        AbstractC14503a abstractC14503a = (AbstractC14503a) getImportHelper();
        BasicSmartSwitchImportType basicSmartSwitchImportType = (BasicSmartSwitchImportType) abstractImportType;
        basicSmartSwitchImportType.getSource();
        basicSmartSwitchImportType.getSessionTime();
        abstractC14503a.mo15110a(basicSmartSwitchImportType.getFromSmartSwitch());
    }
}
