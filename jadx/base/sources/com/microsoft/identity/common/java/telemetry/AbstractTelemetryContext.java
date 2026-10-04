package com.microsoft.identity.common.java.telemetry;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.util.TimeZone;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class AbstractTelemetryContext extends Properties {
    private TelemetryPropertiesCache mTelemetryPropsCache;

    public AbstractTelemetryContext(@NonNull TelemetryPropertiesCache telemetryPropertiesCache) {
        if (telemetryPropertiesCache == null) {
            throw new NullPointerException("telemetryPropertiesCache is marked non-null but is null");
        }
        this.mTelemetryPropsCache = telemetryPropertiesCache;
        put(TelemetryEventStrings.Device.f3609ID, telemetryPropertiesCache.getOrCreateRandomStableDeviceId());
        put(TelemetryEventStrings.Device.TIMEZONE, TimeZone.getDefault().getID());
    }

    public void addApplicationInfo(String str, String str2, String str3, String str4) {
        put(TelemetryEventStrings.App.NAME, str2);
        put(TelemetryEventStrings.App.PACKAGE, str);
        put(TelemetryEventStrings.App.VERSION, str3);
        put(TelemetryEventStrings.App.BUILD, str4);
    }

    public void addDeviceInfo(String str, String str2, String str3) {
        put(TelemetryEventStrings.Device.MANUFACTURER, str);
        put(TelemetryEventStrings.Device.MODEL, str2);
        put(TelemetryEventStrings.Device.NAME, str3);
    }

    public void addOsInfo(String str, String str2) {
        put(TelemetryEventStrings.C6439Os.NAME, str);
        put(TelemetryEventStrings.C6439Os.VERSION, str2);
    }
}
