package com.samsung.scsp.framework.core.identity;

import com.samsung.scsp.common.PreferenceItem;
import com.samsung.scsp.common.Preferences;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ScspDevicePreferences extends Preferences {
    private static final String PREFERENCES_NAME = "scsp.device.preferences";
    public final PreferenceItem<String> ssdid;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class LazyHolder {
        private static final ScspDevicePreferences preferences = new ScspDevicePreferences();

        private LazyHolder() {
        }
    }

    public ScspDevicePreferences() {
        super(PREFERENCES_NAME);
        this.ssdid = new PreferenceItem<>(this, "ssdid", "");
    }

    public static ScspDevicePreferences get() {
        return LazyHolder.preferences;
    }
}
