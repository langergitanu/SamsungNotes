package com.samsung.android.mcf.continuity.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface ContinuityDiscoveryManager {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class DiscoveryListener {
        public abstract void onDiscovered(int i, @NonNull ContinuityNearbyMyDevice continuityNearbyMyDevice);
    }

    @NonNull
    ContinuitySimpleMessageManager getContinuitySimpleMessageManager();

    @NonNull
    List<ContinuityNearbyMyDevice> getNearbyMyDevices();

    boolean startAdvertisement();

    boolean startDiscovery(@NonNull DiscoveryListener discoveryListener);

    boolean stopAdvertisement();

    boolean stopDiscovery();

    @Deprecated
    boolean updateAdvertisement(@Nullable byte[] bArr);
}
