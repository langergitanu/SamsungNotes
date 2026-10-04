package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class COSEAlgorithmIdentifier implements Parcelable {

    @NonNull
    public static final Parcelable.Creator<COSEAlgorithmIdentifier> CREATOR = new zzp();

    @NonNull
    private final Algorithm zza;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class UnsupportedAlgorithmIdentifierException extends Exception {
        public UnsupportedAlgorithmIdentifierException(int i) {
            super(AbstractC0541b.m767i(i, "Algorithm with COSE value ", " not supported"));
        }
    }

    public COSEAlgorithmIdentifier(@NonNull Algorithm algorithm) {
        this.zza = (Algorithm) Preconditions.checkNotNull(algorithm);
    }

    @NonNull
    public static COSEAlgorithmIdentifier fromCoseValue(int i) throws UnsupportedAlgorithmIdentifierException {
        Algorithm algorithm;
        if (i == RSAAlgorithm.LEGACY_RS1.getAlgoValue()) {
            algorithm = RSAAlgorithm.RS1;
        } else {
            RSAAlgorithm[] rSAAlgorithmArrValues = RSAAlgorithm.values();
            int length = rSAAlgorithmArrValues.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    for (EC2Algorithm eC2Algorithm : EC2Algorithm.values()) {
                        if (eC2Algorithm.getAlgoValue() == i) {
                            algorithm = eC2Algorithm;
                        }
                    }
                    throw new UnsupportedAlgorithmIdentifierException(i);
                }
                RSAAlgorithm rSAAlgorithm = rSAAlgorithmArrValues[i2];
                if (rSAAlgorithm.getAlgoValue() == i) {
                    algorithm = rSAAlgorithm;
                    break;
                }
                i2++;
            }
        }
        return new COSEAlgorithmIdentifier(algorithm);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@NonNull Object obj) {
        return (obj instanceof COSEAlgorithmIdentifier) && this.zza.getAlgoValue() == ((COSEAlgorithmIdentifier) obj).zza.getAlgoValue();
    }

    public int hashCode() {
        return Objects.hashCode(this.zza);
    }

    public int toCoseValue() {
        return this.zza.getAlgoValue();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(this.zza.getAlgoValue());
    }
}
