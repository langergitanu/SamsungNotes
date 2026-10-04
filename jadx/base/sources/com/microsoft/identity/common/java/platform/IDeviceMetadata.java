package com.microsoft.identity.common.java.platform;

import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IDeviceMetadata {
    String getAllMetadata();

    @NonNull
    String getCpu();

    @NonNull
    String getDeviceModel();

    @NonNull
    String getDeviceType();

    @NonNull
    String getManufacturer();

    @NonNull
    String getOsForDrs();

    @NonNull
    String getOsForEsts();

    @NonNull
    String getOsForMats();
}
