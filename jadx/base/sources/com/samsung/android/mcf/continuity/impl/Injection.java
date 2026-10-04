package com.samsung.android.mcf.continuity.impl;

import androidx.annotation.NonNull;
import com.samsung.android.mcf.continuity.interfaces.IContinuitySdkCallback;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class Injection {
    @NonNull
    public static ContinuityCallbackManager createContinuityCallbackManager() {
        return new ContinuityCallbackManager();
    }

    @NonNull
    public static ContinuityCommandManager createContinuityCommandManager(@NonNull IContinuitySdkCallback iContinuitySdkCallback) {
        return new ContinuityCommandManager(iContinuitySdkCallback);
    }

    @NonNull
    public static ContinuityDiscoveryManagerImpl createContinuityDiscoveryManagerImpl(@NonNull ContinuityCommandManager continuityCommandManager, @NonNull ContinuityCallbackManager continuityCallbackManager, @NonNull ContinuitySimpleMessageManagerImpl continuitySimpleMessageManagerImpl) {
        return new ContinuityDiscoveryManagerImpl(continuityCommandManager, continuityCallbackManager, continuitySimpleMessageManagerImpl);
    }

    @NonNull
    public static ContinuitySession createContinuitySession(@NonNull ContinuityCommandManager continuityCommandManager, @NonNull ContinuityCallbackManager continuityCallbackManager) {
        return new ContinuitySession(continuityCommandManager, continuityCallbackManager);
    }

    @NonNull
    public static ContinuitySessionFileManagerImpl createContinuitySessionFileManagerImpl(@NonNull ContinuitySession continuitySession) {
        return new ContinuitySessionFileManagerImpl(continuitySession);
    }

    @NonNull
    public static ContinuitySessionManagerImpl createContinuitySessionManagerImpl(@NonNull ContinuitySessionMessageManagerImpl continuitySessionMessageManagerImpl, @NonNull ContinuitySessionFileManagerImpl continuitySessionFileManagerImpl, @NonNull ContinuitySession continuitySession) {
        return new ContinuitySessionManagerImpl(continuitySessionMessageManagerImpl, continuitySessionFileManagerImpl, continuitySession);
    }

    @NonNull
    public static ContinuitySessionMessageManagerImpl createContinuitySessionMessageManagerImpl(@NonNull ContinuitySession continuitySession) {
        return new ContinuitySessionMessageManagerImpl(continuitySession);
    }

    @NonNull
    public static ContinuitySimpleMessageManagerImpl createContinuitySimpleMessageManagerImpl(@NonNull ContinuityCommandManager continuityCommandManager, @NonNull ContinuityCallbackManager continuityCallbackManager) {
        return new ContinuitySimpleMessageManagerImpl(continuityCommandManager, continuityCallbackManager);
    }
}
