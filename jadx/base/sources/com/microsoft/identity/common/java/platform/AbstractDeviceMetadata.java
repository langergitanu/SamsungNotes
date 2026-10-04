package com.microsoft.identity.common.java.platform;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractDeviceMetadata implements IDeviceMetadata {
    private static final String SEPARATOR = ":";

    @Override // com.microsoft.identity.common.java.platform.IDeviceMetadata
    public String getAllMetadata() {
        return getDeviceModel() + ":" + getManufacturer() + ":" + getCpu() + ":" + getOsForEsts() + ":" + getOsForDrs();
    }
}
