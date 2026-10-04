package com.samsung.scsp.framework.core;

import com.samsung.scsp.framework.core.identity.AccountInfoSupplier;
import com.samsung.scsp.framework.core.identity.DeviceIdSupplier;
import com.samsung.scsp.framework.core.identity.E2eeInfoSupplier;
import com.samsung.scsp.framework.core.identity.PushInfoSupplier;
import com.samsung.scsp.framework.core.network.NetworkFunction;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ScspSuppliers {
    final AccountInfoSupplier accountInfoSupplier;
    final DeviceIdSupplier deviceIdSupplier;
    final E2eeInfoSupplier e2eeInfoSupplier;
    final NetworkFunction networkFunction;
    final PushInfoSupplier pushInfoSupplier;
    final ScspConfig scspConfig;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private AccountInfoSupplier accountInfoSupplier;
        private DeviceIdSupplier deviceIdSupplier;
        private E2eeInfoSupplier e2eeInfoSupplier;
        private NetworkFunction networkFunction;
        private PushInfoSupplier pushInfoSupplier;
        private ScspConfig scspConfig;

        public ScspSuppliers build() {
            return new ScspSuppliers(this, 0);
        }

        public Builder with(AccountInfoSupplier accountInfoSupplier) {
            this.accountInfoSupplier = accountInfoSupplier;
            return this;
        }

        public Builder with(PushInfoSupplier pushInfoSupplier) {
            this.pushInfoSupplier = pushInfoSupplier;
            return this;
        }

        public Builder with(DeviceIdSupplier deviceIdSupplier) {
            this.deviceIdSupplier = deviceIdSupplier;
            return this;
        }

        public Builder with(E2eeInfoSupplier e2eeInfoSupplier) {
            this.e2eeInfoSupplier = e2eeInfoSupplier;
            return this;
        }

        public Builder with(NetworkFunction networkFunction) {
            this.networkFunction = networkFunction;
            return this;
        }

        public Builder with(ScspConfig scspConfig) {
            this.scspConfig = scspConfig;
            return this;
        }
    }

    public /* synthetic */ ScspSuppliers(Builder builder, int i) {
        this(builder);
    }

    private ScspSuppliers(Builder builder) {
        this.accountInfoSupplier = builder.accountInfoSupplier;
        this.pushInfoSupplier = builder.pushInfoSupplier;
        this.deviceIdSupplier = builder.deviceIdSupplier;
        this.e2eeInfoSupplier = builder.e2eeInfoSupplier;
        this.networkFunction = builder.networkFunction;
        this.scspConfig = builder.scspConfig;
    }
}
