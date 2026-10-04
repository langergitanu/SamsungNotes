package androidx.appsearch.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import androidx.core.util.Preconditions;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@FlaggedApi(Flags.FLAG_ENABLE_SCHEMA_EMBEDDING_PROPERTY_CONFIG)
@SafeParcelable.Class(creator = "EmbeddingVectorCreator")
public final class EmbeddingVector extends AbstractSafeParcelable {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<EmbeddingVector> CREATOR = new StubCreators.EmbeddingVectorCreator();
    private Integer mHashCode;

    @AbstractSafeParcelable.Field(getter = "getModelSignature", m1109id = 2)
    private final String mModelSignature;

    @AbstractSafeParcelable.Field(getter = "getValues", m1109id = 1)
    private final float[] mValues;

    @AbstractSafeParcelable.Constructor
    public EmbeddingVector(@AbstractSafeParcelable.Param(m1110id = 1) float[] fArr, @AbstractSafeParcelable.Param(m1110id = 2) String str) {
        float[] fArr2 = (float[]) Preconditions.checkNotNull(fArr);
        this.mValues = fArr2;
        if (fArr2.length == 0) {
            throw new IllegalArgumentException("Embedding values cannot be empty.");
        }
        this.mModelSignature = (String) Preconditions.checkNotNull(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EmbeddingVector)) {
            return false;
        }
        EmbeddingVector embeddingVector = (EmbeddingVector) obj;
        return Arrays.equals(this.mValues, embeddingVector.mValues) && this.mModelSignature.equals(embeddingVector.mModelSignature);
    }

    public String getModelSignature() {
        return this.mModelSignature;
    }

    public float[] getValues() {
        return this.mValues;
    }

    public int hashCode() {
        if (this.mHashCode == null) {
            this.mHashCode = Integer.valueOf(Objects.hash(Integer.valueOf(Arrays.hashCode(this.mValues)), this.mModelSignature));
        }
        return this.mHashCode.intValue();
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }
}
