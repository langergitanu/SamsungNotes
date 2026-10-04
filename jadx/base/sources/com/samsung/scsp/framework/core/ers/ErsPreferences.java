package com.samsung.scsp.framework.core.ers;

import com.samsung.scsp.common.PreferenceItem;
import com.samsung.scsp.common.Preferences;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ErsPreferences extends Preferences {
    private static final String name = "scsp.ers.preferences";
    public final PreferenceItem<String> defaultUrl;
    public final PreferenceItem<Long> expiredTime;
    public final PreferenceItem<String> odmUrl;
    public final PreferenceItem<String> playUrl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LazyHolder {
        private static final ErsPreferences preferences = new ErsPreferences(0);

        private LazyHolder() {
        }
    }

    public /* synthetic */ ErsPreferences(int i) {
        this();
    }

    public static ErsPreferences get() {
        return LazyHolder.preferences;
    }

    private ErsPreferences() {
        super(name);
        this.defaultUrl = new PreferenceItem<>(this, "defaultUrl", "https://api.samsungcloud.com");
        this.playUrl = new PreferenceItem<>(this, "playUrl", "https://play.samsungcloud.com");
        this.odmUrl = new PreferenceItem<>(this, "odmUrl", "https://play.samsungcloud.com");
        this.expiredTime = new PreferenceItem<>(this, "expiredTime", 7200000L);
    }
}
