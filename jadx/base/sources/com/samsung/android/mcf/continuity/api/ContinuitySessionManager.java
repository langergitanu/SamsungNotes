package com.samsung.android.mcf.continuity.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface ContinuitySessionManager {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class PeerConnectionRequestListener {
        public abstract void onPeerConnectionRequested(@NonNull ContinuityNearbyMyDevice continuityNearbyMyDevice, @NonNull ContinuityNetworkPolicy continuityNetworkPolicy);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class PeerStatusListener {
        public abstract void onPeerStatusChanged(int i, @NonNull ContinuityNearbyMyDevice continuityNearbyMyDevice);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SessionStatusListener {
        public abstract void onSessionStatusChanged(int i);
    }

    boolean closeSession();

    boolean disconnect(@NonNull String str);

    @Nullable
    ContinuitySessionFileManager getContinuitySessionFileManager();

    @Nullable
    ContinuitySessionMessageManager getContinuitySessionMessageManager();

    boolean openSession(@NonNull SessionStatusListener sessionStatusListener);

    boolean registerPeerConnectionRequestListener(@NonNull PeerConnectionRequestListener peerConnectionRequestListener);

    boolean requestConnect(@NonNull String str, @NonNull ContinuityNetworkPolicy continuityNetworkPolicy, @NonNull PeerStatusListener peerStatusListener);

    boolean responseConnect(int i, @NonNull String str, @NonNull ContinuityNetworkPolicy continuityNetworkPolicy, @Nullable PeerStatusListener peerStatusListener);

    void unregisterPeerConnectionRequestListener();
}
