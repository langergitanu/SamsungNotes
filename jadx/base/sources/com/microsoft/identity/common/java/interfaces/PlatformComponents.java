package com.microsoft.identity.common.java.interfaces;

import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.microsoft.identity.common.java.providers.oauth2.IStateGenerator;
import com.microsoft.identity.common.java.strategies.IAuthorizationStrategyFactory;
import com.microsoft.identity.common.java.util.IBroadcaster;
import com.microsoft.identity.common.java.util.IClockSkewManager;
import com.microsoft.identity.common.java.util.IPlatformUtil;
import edu.umd.cs.findbugs.annotations.Nullable;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class PlatformComponents implements IPlatformComponents {

    @Nullable
    private final IAuthorizationStrategyFactory mAuthorizationStrategyFactory;

    @NonNull
    private final IBroadcaster mBroadcaster;

    @NonNull
    private final IClockSkewManager mClockSkewManager;

    @NonNull
    private final IHttpClientWrapper mHttpClientWrapper;

    @NonNull
    private final IPlatformUtil mPlatformUtil;

    @NonNull
    private final IPopManagerSupplier mPopManagerLoader;

    @Nullable
    private final IStateGenerator mStateGenerator;

    @NonNull
    private final IStorageSupplier mStorageSupplier;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class PlatformComponentsBuilder<C extends PlatformComponents, B extends PlatformComponentsBuilder<C, B>> {
        private IAuthorizationStrategyFactory authorizationStrategyFactory;
        private IBroadcaster broadcaster;
        private IClockSkewManager clockSkewManager;
        private IHttpClientWrapper httpClientWrapper;
        private IPlatformUtil platformUtil;
        private IPopManagerSupplier popManagerLoader;
        private IStateGenerator stateGenerator;
        private IStorageSupplier storageSupplier;

        public B authorizationStrategyFactory(@Nullable IAuthorizationStrategyFactory iAuthorizationStrategyFactory) {
            this.authorizationStrategyFactory = iAuthorizationStrategyFactory;
            return (B) self();
        }

        public B broadcaster(@NonNull IBroadcaster iBroadcaster) {
            if (iBroadcaster == null) {
                throw new NullPointerException("broadcaster is marked non-null but is null");
            }
            this.broadcaster = iBroadcaster;
            return (B) self();
        }

        public abstract C build();

        public B clockSkewManager(@NonNull IClockSkewManager iClockSkewManager) {
            if (iClockSkewManager == null) {
                throw new NullPointerException("clockSkewManager is marked non-null but is null");
            }
            this.clockSkewManager = iClockSkewManager;
            return (B) self();
        }

        public B httpClientWrapper(@NonNull IHttpClientWrapper iHttpClientWrapper) {
            if (iHttpClientWrapper == null) {
                throw new NullPointerException("httpClientWrapper is marked non-null but is null");
            }
            this.httpClientWrapper = iHttpClientWrapper;
            return (B) self();
        }

        public B platformUtil(@NonNull IPlatformUtil iPlatformUtil) {
            if (iPlatformUtil == null) {
                throw new NullPointerException("platformUtil is marked non-null but is null");
            }
            this.platformUtil = iPlatformUtil;
            return (B) self();
        }

        public B popManagerLoader(@NonNull IPopManagerSupplier iPopManagerSupplier) {
            if (iPopManagerSupplier == null) {
                throw new NullPointerException("popManagerLoader is marked non-null but is null");
            }
            this.popManagerLoader = iPopManagerSupplier;
            return (B) self();
        }

        public abstract B self();

        public B stateGenerator(@Nullable IStateGenerator iStateGenerator) {
            this.stateGenerator = iStateGenerator;
            return (B) self();
        }

        public B storageSupplier(@NonNull IStorageSupplier iStorageSupplier) {
            if (iStorageSupplier == null) {
                throw new NullPointerException("storageSupplier is marked non-null but is null");
            }
            this.storageSupplier = iStorageSupplier;
            return (B) self();
        }

        public String toString() {
            return "PlatformComponents.PlatformComponentsBuilder(clockSkewManager=" + this.clockSkewManager + ", broadcaster=" + this.broadcaster + ", popManagerLoader=" + this.popManagerLoader + ", storageSupplier=" + this.storageSupplier + ", authorizationStrategyFactory=" + this.authorizationStrategyFactory + ", stateGenerator=" + this.stateGenerator + ", platformUtil=" + this.platformUtil + ", httpClientWrapper=" + this.httpClientWrapper + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class PlatformComponentsBuilderImpl extends PlatformComponentsBuilder<PlatformComponents, PlatformComponentsBuilderImpl> {
        private PlatformComponentsBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.interfaces.PlatformComponents.PlatformComponentsBuilder
        public PlatformComponents build() {
            return new PlatformComponents(this);
        }

        @Override // com.microsoft.identity.common.java.interfaces.PlatformComponents.PlatformComponentsBuilder
        public PlatformComponentsBuilderImpl self() {
            return this;
        }
    }

    public PlatformComponents(PlatformComponentsBuilder<?, ?> platformComponentsBuilder) {
        IClockSkewManager iClockSkewManager = ((PlatformComponentsBuilder) platformComponentsBuilder).clockSkewManager;
        this.mClockSkewManager = iClockSkewManager;
        if (iClockSkewManager == null) {
            throw new NullPointerException("mClockSkewManager is marked non-null but is null");
        }
        IBroadcaster iBroadcaster = ((PlatformComponentsBuilder) platformComponentsBuilder).broadcaster;
        this.mBroadcaster = iBroadcaster;
        if (iBroadcaster == null) {
            throw new NullPointerException("mBroadcaster is marked non-null but is null");
        }
        IPopManagerSupplier iPopManagerSupplier = ((PlatformComponentsBuilder) platformComponentsBuilder).popManagerLoader;
        this.mPopManagerLoader = iPopManagerSupplier;
        if (iPopManagerSupplier == null) {
            throw new NullPointerException("mPopManagerLoader is marked non-null but is null");
        }
        IStorageSupplier iStorageSupplier = ((PlatformComponentsBuilder) platformComponentsBuilder).storageSupplier;
        this.mStorageSupplier = iStorageSupplier;
        if (iStorageSupplier == null) {
            throw new NullPointerException("mStorageSupplier is marked non-null but is null");
        }
        this.mAuthorizationStrategyFactory = ((PlatformComponentsBuilder) platformComponentsBuilder).authorizationStrategyFactory;
        this.mStateGenerator = ((PlatformComponentsBuilder) platformComponentsBuilder).stateGenerator;
        IPlatformUtil iPlatformUtil = ((PlatformComponentsBuilder) platformComponentsBuilder).platformUtil;
        this.mPlatformUtil = iPlatformUtil;
        if (iPlatformUtil == null) {
            throw new NullPointerException("mPlatformUtil is marked non-null but is null");
        }
        IHttpClientWrapper iHttpClientWrapper = ((PlatformComponentsBuilder) platformComponentsBuilder).httpClientWrapper;
        this.mHttpClientWrapper = iHttpClientWrapper;
        if (iHttpClientWrapper == null) {
            throw new NullPointerException("mHttpClientWrapper is marked non-null but is null");
        }
    }

    public static PlatformComponentsBuilder<?, ?> builder() {
        return new PlatformComponentsBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPlatformComponents
    @Nullable
    public IAuthorizationStrategyFactory getAuthorizationStrategyFactory() {
        return this.mAuthorizationStrategyFactory;
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPlatformComponents
    @NonNull
    public IBroadcaster getBroadcaster() {
        return this.mBroadcaster;
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPlatformComponents
    @NonNull
    public IClockSkewManager getClockSkewManager() {
        return this.mClockSkewManager;
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPopManagerSupplier
    @NonNull
    public IDevicePopManager getDefaultDevicePopManager() {
        return this.mPopManagerLoader.getDefaultDevicePopManager();
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPopManagerSupplier
    @NonNull
    public IDevicePopManager getDevicePopManager(@Nullable String str) {
        return this.mPopManagerLoader.getDevicePopManager(str);
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPlatformComponents
    @NonNull
    public IHttpClientWrapper getHttpClientWrapper() {
        return this.mHttpClientWrapper;
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPlatformComponents
    @NonNull
    public IPlatformUtil getPlatformUtil() {
        return this.mPlatformUtil;
    }

    @NonNull
    public IPopManagerSupplier getPopManagerLoader() {
        return this.mPopManagerLoader;
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPlatformComponents
    @Nullable
    public IStateGenerator getStateGenerator() {
        return this.mStateGenerator;
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPlatformComponents
    @NonNull
    public IStorageSupplier getStorageSupplier() {
        return this.mStorageSupplier;
    }
}
