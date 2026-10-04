package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.NameResolver;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class ServiceConfigState {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Nullable
    private NameResolver.ConfigOrError currentServiceConfigOrError;

    @Nullable
    private final NameResolver.ConfigOrError defaultServiceConfig;
    private final boolean lookUpServiceConfig;
    private boolean updated;

    public ServiceConfigState(@Nullable ManagedChannelServiceConfig managedChannelServiceConfig, boolean z) {
        if (managedChannelServiceConfig == null) {
            this.defaultServiceConfig = null;
        } else {
            this.defaultServiceConfig = NameResolver.ConfigOrError.fromConfig(managedChannelServiceConfig);
        }
        this.lookUpServiceConfig = z;
        if (z) {
            return;
        }
        this.currentServiceConfigOrError = this.defaultServiceConfig;
    }

    public boolean expectUpdates() {
        return this.lookUpServiceConfig;
    }

    @Nullable
    public NameResolver.ConfigOrError getCurrent() {
        Preconditions.checkState(!shouldWaitOnServiceConfig(), "still waiting on service config");
        return this.currentServiceConfigOrError;
    }

    public boolean shouldWaitOnServiceConfig() {
        return !this.updated && expectUpdates();
    }

    public void update(@Nullable NameResolver.ConfigOrError configOrError) {
        Preconditions.checkState(expectUpdates(), "unexpected service config update");
        boolean z = this.updated;
        this.updated = true;
        if (!z) {
            if (configOrError == null) {
                this.currentServiceConfigOrError = this.defaultServiceConfig;
                return;
            }
            if (configOrError.getError() == null) {
                this.currentServiceConfigOrError = configOrError;
                return;
            }
            NameResolver.ConfigOrError configOrError2 = this.defaultServiceConfig;
            if (configOrError2 != null) {
                this.currentServiceConfigOrError = configOrError2;
                return;
            } else {
                this.currentServiceConfigOrError = configOrError;
                return;
            }
        }
        if (configOrError == null) {
            NameResolver.ConfigOrError configOrError3 = this.defaultServiceConfig;
            if (configOrError3 != null) {
                this.currentServiceConfigOrError = configOrError3;
                return;
            } else {
                this.currentServiceConfigOrError = null;
                return;
            }
        }
        if (configOrError.getError() == null) {
            this.currentServiceConfigOrError = configOrError;
            return;
        }
        NameResolver.ConfigOrError configOrError4 = this.currentServiceConfigOrError;
        if (configOrError4 == null || configOrError4.getError() == null) {
            return;
        }
        this.currentServiceConfigOrError = configOrError;
    }
}
