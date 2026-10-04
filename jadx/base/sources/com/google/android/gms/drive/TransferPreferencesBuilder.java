package com.google.android.gms.drive;

import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class TransferPreferencesBuilder {
    public static final TransferPreferences DEFAULT_PREFERENCES = new zza(1, true, 256);
    private int zzbl;
    private boolean zzbm;
    private int zzbn;

    public static class zza implements TransferPreferences {
        private final int zzbl;
        private final boolean zzbm;
        private final int zzbn;

        public zza(int i, boolean z, int i2) {
            this.zzbl = i;
            this.zzbm = z;
            this.zzbn = i2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && zza.class == obj.getClass()) {
                zza zzaVar = (zza) obj;
                if (zzaVar.zzbl == this.zzbl && zzaVar.zzbm == this.zzbm && zzaVar.zzbn == this.zzbn) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.gms.drive.TransferPreferences
        public final int getBatteryUsagePreference() {
            return this.zzbn;
        }

        @Override // com.google.android.gms.drive.TransferPreferences
        public final int getNetworkPreference() {
            return this.zzbl;
        }

        public final int hashCode() {
            return Objects.hashCode(Integer.valueOf(this.zzbl), Boolean.valueOf(this.zzbm), Integer.valueOf(this.zzbn));
        }

        @Override // com.google.android.gms.drive.TransferPreferences
        public final boolean isRoamingAllowed() {
            return this.zzbm;
        }

        public final String toString() {
            int i = this.zzbl;
            boolean z = this.zzbm;
            int i2 = this.zzbn;
            StringBuilder sbM2226q = AbstractC2821a.m2226q("NetworkPreference: ", i, ", IsRoamingAllowed ", z, ", BatteryUsagePreference ");
            sbM2226q.append(i2);
            return sbM2226q.toString();
        }
    }

    public TransferPreferencesBuilder() {
        this(DEFAULT_PREFERENCES);
    }

    public TransferPreferences build() {
        return new zza(this.zzbl, this.zzbm, this.zzbn);
    }

    public TransferPreferencesBuilder setBatteryUsagePreference(int i) {
        this.zzbn = i;
        return this;
    }

    public TransferPreferencesBuilder setIsRoamingAllowed(boolean z) {
        this.zzbm = z;
        return this;
    }

    public TransferPreferencesBuilder setNetworkPreference(int i) {
        this.zzbl = i;
        return this;
    }

    public TransferPreferencesBuilder(TransferPreferences transferPreferences) {
        this.zzbl = transferPreferences.getNetworkPreference();
        this.zzbm = transferPreferences.isRoamingAllowed();
        this.zzbn = transferPreferences.getBatteryUsagePreference();
    }

    public TransferPreferencesBuilder(FileUploadPreferences fileUploadPreferences) {
        this.zzbl = fileUploadPreferences.getNetworkTypePreference();
        this.zzbm = fileUploadPreferences.isRoamingAllowed();
        this.zzbn = fileUploadPreferences.getBatteryUsagePreference();
    }
}
