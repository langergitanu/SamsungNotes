package com.yubico.yubikit.core.application;

import androidx.appcompat.widget.AbstractC0541b;
import com.yubico.yubikit.core.Version;
import com.yubico.yubikit.core.application.ApplicationSession;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class Feature<T extends ApplicationSession<T>> {
    protected final String featureName;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Versioned<T extends ApplicationSession<T>> extends Feature<T> {
        private final Version requiredVersion;

        public Versioned(String str, int i, int i2, int i4) {
            super(str);
            this.requiredVersion = new Version(i, i2, i4);
        }

        @Override // com.yubico.yubikit.core.application.Feature
        public String getRequiredMessage() {
            return this.featureName + " requires YubiKey " + this.requiredVersion + " or later";
        }

        @Override // com.yubico.yubikit.core.application.Feature
        public boolean isSupportedBy(Version version) {
            return version.major == 0 || version.compareTo(this.requiredVersion) >= 0;
        }
    }

    public Feature(String str) {
        this.featureName = str;
    }

    public String getFeatureName() {
        return this.featureName;
    }

    public String getRequiredMessage() {
        return AbstractC0541b.m756B(this.featureName, " is not supported by this YubiKey");
    }

    public abstract boolean isSupportedBy(Version version);
}
