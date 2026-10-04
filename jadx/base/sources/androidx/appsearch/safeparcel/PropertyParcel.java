package androidx.appsearch.safeparcel;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.app.AppSearchBlobHandle;
import androidx.appsearch.app.EmbeddingVector;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
@SafeParcelable.Class(creator = "PropertyParcelCreator")
public final class PropertyParcel extends AbstractSafeParcelable implements Parcelable {
    public static final Parcelable.Creator<PropertyParcel> CREATOR = new PropertyParcelCreator();

    @ExperimentalAppSearchApi
    @AbstractSafeParcelable.Field(getter = "getBlobHandleValues", m1109id = 9)
    private final AppSearchBlobHandle[] mBlobHandleValues;

    @AbstractSafeParcelable.Field(getter = "getBooleanValues", m1109id = 5)
    private final boolean[] mBooleanValues;

    @AbstractSafeParcelable.Field(getter = "getBytesValues", m1109id = 6)
    private final byte[][] mBytesValues;

    @AbstractSafeParcelable.Field(getter = "getDocumentValues", m1109id = 7)
    private final GenericDocumentParcel[] mDocumentValues;

    @AbstractSafeParcelable.Field(getter = "getDoubleValues", m1109id = 4)
    private final double[] mDoubleValues;

    @AbstractSafeParcelable.Field(getter = "getEmbeddingValues", m1109id = 8)
    private final EmbeddingVector[] mEmbeddingValues;
    private Integer mHashCode;

    @AbstractSafeParcelable.Field(getter = "getLongValues", m1109id = 3)
    private final long[] mLongValues;

    @AbstractSafeParcelable.Field(getter = "getPropertyName", m1109id = 1)
    private final String mPropertyName;

    @AbstractSafeParcelable.Field(getter = "getStringValues", m1109id = 2)
    private final String[] mStringValues;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @ExperimentalAppSearchApi
    public static final class Builder {
        private AppSearchBlobHandle[] mBlobHandleValues;
        private boolean[] mBooleanValues;
        private byte[][] mBytesValues;
        private GenericDocumentParcel[] mDocumentValues;
        private double[] mDoubleValues;
        private EmbeddingVector[] mEmbeddingValues;
        private long[] mLongValues;
        private String mPropertyName;
        private String[] mStringValues;

        public Builder(String str) {
            Objects.requireNonNull(str);
            this.mPropertyName = str;
        }

        public PropertyParcel build() {
            return new PropertyParcel(this.mPropertyName, this.mStringValues, this.mLongValues, this.mDoubleValues, this.mBooleanValues, this.mBytesValues, this.mDocumentValues, this.mEmbeddingValues, this.mBlobHandleValues);
        }

        @CanIgnoreReturnValue
        public Builder setBlobHandleValues(AppSearchBlobHandle[] appSearchBlobHandleArr) {
            Objects.requireNonNull(appSearchBlobHandleArr);
            this.mBlobHandleValues = appSearchBlobHandleArr;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setBooleanValues(boolean[] zArr) {
            Objects.requireNonNull(zArr);
            this.mBooleanValues = zArr;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setBytesValues(byte[][] bArr) {
            Objects.requireNonNull(bArr);
            this.mBytesValues = bArr;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setDocumentValues(GenericDocumentParcel[] genericDocumentParcelArr) {
            Objects.requireNonNull(genericDocumentParcelArr);
            this.mDocumentValues = genericDocumentParcelArr;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setDoubleValues(double[] dArr) {
            Objects.requireNonNull(dArr);
            this.mDoubleValues = dArr;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setEmbeddingValues(EmbeddingVector[] embeddingVectorArr) {
            Objects.requireNonNull(embeddingVectorArr);
            this.mEmbeddingValues = embeddingVectorArr;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setLongValues(long[] jArr) {
            Objects.requireNonNull(jArr);
            this.mLongValues = jArr;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setStringValues(String[] strArr) {
            Objects.requireNonNull(strArr);
            this.mStringValues = strArr;
            return this;
        }
    }

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    @AbstractSafeParcelable.Constructor
    public PropertyParcel(@AbstractSafeParcelable.Param(m1110id = 1) String str, @AbstractSafeParcelable.Param(m1110id = 2) String[] strArr, @AbstractSafeParcelable.Param(m1110id = 3) long[] jArr, @AbstractSafeParcelable.Param(m1110id = 4) double[] dArr, @AbstractSafeParcelable.Param(m1110id = 5) boolean[] zArr, @AbstractSafeParcelable.Param(m1110id = 6) byte[][] bArr, @AbstractSafeParcelable.Param(m1110id = 7) GenericDocumentParcel[] genericDocumentParcelArr, @AbstractSafeParcelable.Param(m1110id = 8) EmbeddingVector[] embeddingVectorArr, @AbstractSafeParcelable.Param(m1110id = 9) AppSearchBlobHandle[] appSearchBlobHandleArr) {
        Objects.requireNonNull(str);
        this.mPropertyName = str;
        this.mStringValues = strArr;
        this.mLongValues = jArr;
        this.mDoubleValues = dArr;
        this.mBooleanValues = zArr;
        this.mBytesValues = bArr;
        this.mDocumentValues = genericDocumentParcelArr;
        this.mEmbeddingValues = embeddingVectorArr;
        this.mBlobHandleValues = appSearchBlobHandleArr;
        checkOnlyOneArrayCanBeSet();
    }

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    private void checkOnlyOneArrayCanBeSet() {
        int i = this.mStringValues != null ? 1 : 0;
        if (this.mLongValues != null) {
            i++;
        }
        if (this.mDoubleValues != null) {
            i++;
        }
        if (this.mBooleanValues != null) {
            i++;
        }
        if (this.mBytesValues != null) {
            i++;
        }
        if (this.mDocumentValues != null) {
            i++;
        }
        if (this.mEmbeddingValues != null) {
            i++;
        }
        if (this.mBlobHandleValues != null) {
            i++;
        }
        if (i == 0 || i > 1) {
            throw new IllegalArgumentException("One and only one type array can be set in PropertyParcel");
        }
    }

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PropertyParcel)) {
            return false;
        }
        PropertyParcel propertyParcel = (PropertyParcel) obj;
        return this.mPropertyName.equals(propertyParcel.mPropertyName) && Arrays.equals(this.mStringValues, propertyParcel.mStringValues) && Arrays.equals(this.mLongValues, propertyParcel.mLongValues) && Arrays.equals(this.mDoubleValues, propertyParcel.mDoubleValues) && Arrays.equals(this.mBooleanValues, propertyParcel.mBooleanValues) && Arrays.deepEquals(this.mBytesValues, propertyParcel.mBytesValues) && Arrays.equals(this.mDocumentValues, propertyParcel.mDocumentValues) && Arrays.deepEquals(this.mEmbeddingValues, propertyParcel.mEmbeddingValues) && Arrays.deepEquals(this.mBlobHandleValues, propertyParcel.mBlobHandleValues);
    }

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    public AppSearchBlobHandle[] getBlobHandleValues() {
        return this.mBlobHandleValues;
    }

    public boolean[] getBooleanValues() {
        return this.mBooleanValues;
    }

    public byte[][] getBytesValues() {
        return this.mBytesValues;
    }

    public GenericDocumentParcel[] getDocumentValues() {
        return this.mDocumentValues;
    }

    public double[] getDoubleValues() {
        return this.mDoubleValues;
    }

    public EmbeddingVector[] getEmbeddingValues() {
        return this.mEmbeddingValues;
    }

    public long[] getLongValues() {
        return this.mLongValues;
    }

    public String getPropertyName() {
        return this.mPropertyName;
    }

    public String[] getStringValues() {
        return this.mStringValues;
    }

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    public Object getValues() {
        String[] strArr = this.mStringValues;
        if (strArr != null) {
            return strArr;
        }
        long[] jArr = this.mLongValues;
        if (jArr != null) {
            return jArr;
        }
        double[] dArr = this.mDoubleValues;
        if (dArr != null) {
            return dArr;
        }
        boolean[] zArr = this.mBooleanValues;
        if (zArr != null) {
            return zArr;
        }
        byte[][] bArr = this.mBytesValues;
        if (bArr != null) {
            return bArr;
        }
        GenericDocumentParcel[] genericDocumentParcelArr = this.mDocumentValues;
        if (genericDocumentParcelArr != null) {
            return genericDocumentParcelArr;
        }
        EmbeddingVector[] embeddingVectorArr = this.mEmbeddingValues;
        if (embeddingVectorArr != null) {
            return embeddingVectorArr;
        }
        AppSearchBlobHandle[] appSearchBlobHandleArr = this.mBlobHandleValues;
        if (appSearchBlobHandleArr != null) {
            return appSearchBlobHandleArr;
        }
        return null;
    }

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    public int hashCode() {
        int iDeepHashCode;
        if (this.mHashCode == null) {
            String[] strArr = this.mStringValues;
            if (strArr != null) {
                iDeepHashCode = Arrays.hashCode(strArr);
            } else {
                long[] jArr = this.mLongValues;
                if (jArr != null) {
                    iDeepHashCode = Arrays.hashCode(jArr);
                } else {
                    double[] dArr = this.mDoubleValues;
                    if (dArr != null) {
                        iDeepHashCode = Arrays.hashCode(dArr);
                    } else {
                        boolean[] zArr = this.mBooleanValues;
                        if (zArr != null) {
                            iDeepHashCode = Arrays.hashCode(zArr);
                        } else {
                            byte[][] bArr = this.mBytesValues;
                            if (bArr != null) {
                                iDeepHashCode = Arrays.deepHashCode(bArr);
                            } else {
                                GenericDocumentParcel[] genericDocumentParcelArr = this.mDocumentValues;
                                if (genericDocumentParcelArr != null) {
                                    iDeepHashCode = Arrays.hashCode(genericDocumentParcelArr);
                                } else {
                                    EmbeddingVector[] embeddingVectorArr = this.mEmbeddingValues;
                                    if (embeddingVectorArr != null) {
                                        iDeepHashCode = Arrays.deepHashCode(embeddingVectorArr);
                                    } else {
                                        AppSearchBlobHandle[] appSearchBlobHandleArr = this.mBlobHandleValues;
                                        iDeepHashCode = appSearchBlobHandleArr != null ? Arrays.deepHashCode(appSearchBlobHandleArr) : 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            this.mHashCode = Integer.valueOf(Objects.hash(this.mPropertyName, Integer.valueOf(iDeepHashCode)));
        }
        return this.mHashCode.intValue();
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    public void writeToParcel(Parcel parcel, int i) {
        PropertyParcelCreator.writeToParcel(this, parcel, i);
    }
}
