package com.samsung.scsp.pam.kps.lite;

import com.samsung.scsp.common.Header;
import com.samsung.scsp.common.PreferenceItem;
import com.samsung.scsp.common.Preferences;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class KpsLitePreferences extends Preferences {
    private static final String name = "scsp.kps.lite.preferences";
    public final PreferenceItem<String> eTag;
    public final PreferenceItem<Long> expiredTime;
    public final PreferenceItem<String> policies;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LazyHolder {
        private static final KpsLitePreferences preferences = new KpsLitePreferences();

        private LazyHolder() {
        }
    }

    public KpsLitePreferences() {
        super(name);
        this.policies = new PreferenceItem<>(this, "policies", "");
        this.eTag = new PreferenceItem<>(this, Header.ETAG, "");
        this.expiredTime = new PreferenceItem<>(this, "expiredTime", 0L);
    }

    public static KpsLitePreferences get() {
        return LazyHolder.preferences;
    }
}
