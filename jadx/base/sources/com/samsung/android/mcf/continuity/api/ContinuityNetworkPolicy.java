package com.samsung.android.mcf.continuity.api;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ContinuityNetworkPolicy {
    private final int mTopology;
    private final int mType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private int mType = 12;
        private int mTopology = 21;

        @NonNull
        public ContinuityNetworkPolicy build() {
            return new ContinuityNetworkPolicy(this.mType, this.mTopology);
        }

        @NonNull
        public Builder setTopology(int i) {
            if (i < 20 || i > 23) {
                throw new IllegalArgumentException("invalid topology");
            }
            this.mTopology = i;
            return this;
        }

        @NonNull
        public Builder setType(int i) {
            if (i < 10 || i > 13) {
                throw new IllegalArgumentException("invalid type");
            }
            this.mType = i;
            return this;
        }
    }

    public ContinuityNetworkPolicy(int i, int i2) {
        this.mType = i;
        this.mTopology = i2;
    }

    public int getTopology() {
        return this.mTopology;
    }

    public int getType() {
        return this.mType;
    }
}
