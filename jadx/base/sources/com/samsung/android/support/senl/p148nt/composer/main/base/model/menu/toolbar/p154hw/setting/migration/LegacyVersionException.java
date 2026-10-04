package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.SPenVersion;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class LegacyVersionException extends Exception {
    private String value;
    private SPenVersion.Version version;

    public LegacyVersionException(SPenVersion.Version version, String str) {
        super("Legacy preference value");
        this.version = version;
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public SPenVersion.Version getVersion() {
        return this.version;
    }
}
