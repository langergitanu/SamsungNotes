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
import androidx.appsearch.app.GenericDocument;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.PropertyParcel;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
@SafeParcelable.Class(creator = "GenericDocumentParcelCreator")
public final class GenericDocumentParcel extends AbstractSafeParcelable implements Parcelable {
    public static final Parcelable.Creator<GenericDocumentParcel> CREATOR = new GenericDocumentParcelCreator();
    private static final int DEFAULT_SCORE = 0;
    private static final long DEFAULT_TTL_MILLIS = 0;
    private static final long INVALID_CREATION_TIMESTAMP_MILLIS = -1;

    @AbstractSafeParcelable.Field(getter = "getCreationTimestampMillis", m1109id = 4)
    private final long mCreationTimestampMillis;
    private Integer mHashCode;

    @AbstractSafeParcelable.Field(getter = "getId", m1109id = 2)
    private final String mId;

    @AbstractSafeParcelable.Field(getter = "getNamespace", m1109id = 1)
    private final String mNamespace;

    @AbstractSafeParcelable.Field(getter = "getParentTypes", m1109id = 8)
    private final List<String> mParentTypes;

    @AbstractSafeParcelable.Field(getter = "getProperties", m1109id = 7)
    private final List<PropertyParcel> mProperties;
    private final Map<String, PropertyParcel> mPropertyMap;

    @AbstractSafeParcelable.Field(getter = "getSchemaType", m1109id = 3)
    private final String mSchemaType;

    @AbstractSafeParcelable.Field(getter = "getScore", m1109id = 6)
    private final int mScore;

    @AbstractSafeParcelable.Field(getter = "getTtlMillis", m1109id = 5)
    private final long mTtlMillis;

    @AbstractSafeParcelable.Constructor
    public GenericDocumentParcel(@AbstractSafeParcelable.Param(m1110id = 1) String str, @AbstractSafeParcelable.Param(m1110id = 2) String str2, @AbstractSafeParcelable.Param(m1110id = 3) String str3, @AbstractSafeParcelable.Param(m1110id = 4) long j, @AbstractSafeParcelable.Param(m1110id = 5) long j2, @AbstractSafeParcelable.Param(m1110id = 6) int i, @AbstractSafeParcelable.Param(m1110id = 7) List<PropertyParcel> list, @AbstractSafeParcelable.Param(m1110id = 8) List<String> list2) {
        this(str, str2, str3, j, j2, i, list, createPropertyMapFromPropertyArray(list), list2);
    }

    private static Map<String, PropertyParcel> createPropertyMapFromPropertyArray(List<PropertyParcel> list) {
        Objects.requireNonNull(list);
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (int i = 0; i < list.size(); i++) {
            PropertyParcel propertyParcel = list.get(i);
            arrayMap.put(propertyParcel.getPropertyName(), propertyParcel);
        }
        return arrayMap;
    }

    public static GenericDocumentParcel fromGenericDocument(GenericDocument genericDocument) {
        Objects.requireNonNull(genericDocument);
        return genericDocument.getDocumentParcel();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GenericDocumentParcel)) {
            return false;
        }
        GenericDocumentParcel genericDocumentParcel = (GenericDocumentParcel) obj;
        return this.mNamespace.equals(genericDocumentParcel.mNamespace) && this.mId.equals(genericDocumentParcel.mId) && this.mSchemaType.equals(genericDocumentParcel.mSchemaType) && this.mTtlMillis == genericDocumentParcel.mTtlMillis && this.mCreationTimestampMillis == genericDocumentParcel.mCreationTimestampMillis && this.mScore == genericDocumentParcel.mScore && Objects.equals(this.mProperties, genericDocumentParcel.mProperties) && Objects.equals(this.mPropertyMap, genericDocumentParcel.mPropertyMap) && Objects.equals(this.mParentTypes, genericDocumentParcel.mParentTypes);
    }

    public long getCreationTimestampMillis() {
        return this.mCreationTimestampMillis;
    }

    public String getId() {
        return this.mId;
    }

    public String getNamespace() {
        return this.mNamespace;
    }

    public List<String> getParentTypes() {
        return this.mParentTypes;
    }

    public List<PropertyParcel> getProperties() {
        return this.mProperties;
    }

    public Map<String, PropertyParcel> getPropertyMap() {
        return this.mPropertyMap;
    }

    public Set<String> getPropertyNames() {
        return this.mPropertyMap.keySet();
    }

    public String getSchemaType() {
        return this.mSchemaType;
    }

    public int getScore() {
        return this.mScore;
    }

    public long getTtlMillis() {
        return this.mTtlMillis;
    }

    public int hashCode() {
        if (this.mHashCode == null) {
            this.mHashCode = Integer.valueOf(Objects.hash(this.mNamespace, this.mId, this.mSchemaType, Long.valueOf(this.mTtlMillis), Integer.valueOf(this.mScore), Long.valueOf(this.mCreationTimestampMillis), Integer.valueOf(Objects.hashCode(this.mProperties)), Integer.valueOf(Objects.hashCode(this.mPropertyMap)), Integer.valueOf(Objects.hashCode(this.mParentTypes))));
        }
        return this.mHashCode.intValue();
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    public void writeToParcel(Parcel parcel, int i) {
        GenericDocumentParcelCreator.writeToParcel(this, parcel, i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    public static final class Builder {
        private long mCreationTimestampMillis;
        private String mId;
        private String mNamespace;
        private List<String> mParentTypes;
        private Map<String, PropertyParcel> mPropertyMap;
        private String mSchemaType;
        private int mScore;
        private long mTtlMillis;

        public Builder(String str, String str2, String str3) {
            Objects.requireNonNull(str);
            this.mNamespace = str;
            Objects.requireNonNull(str2);
            this.mId = str2;
            Objects.requireNonNull(str3);
            this.mSchemaType = str3;
            this.mCreationTimestampMillis = -1L;
            this.mTtlMillis = 0L;
            this.mScore = 0;
            this.mPropertyMap = new ArrayMap();
        }

        public GenericDocumentParcel build() {
            if (this.mCreationTimestampMillis == -1) {
                this.mCreationTimestampMillis = System.currentTimeMillis();
            }
            return new GenericDocumentParcel(this.mNamespace, this.mId, this.mSchemaType, this.mCreationTimestampMillis, this.mTtlMillis, this.mScore, new ArrayList(this.mPropertyMap.values()), this.mParentTypes);
        }

        @CanIgnoreReturnValue
        public Builder clearProperty(String str) {
            Objects.requireNonNull(str);
            this.mPropertyMap.remove(str);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder putInPropertyMap(String str, String[] strArr) {
            putInPropertyMap(str, new PropertyParcel.Builder(str).setStringValues(strArr).build());
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setCreationTimestampMillis(long j) {
            this.mCreationTimestampMillis = j;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setId(String str) {
            Objects.requireNonNull(str);
            this.mId = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setNamespace(String str) {
            Objects.requireNonNull(str);
            this.mNamespace = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setParentTypes(List<String> list) {
            if (list == null) {
                this.mParentTypes = null;
                return this;
            }
            this.mParentTypes = new ArrayList(list);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSchemaType(String str) {
            Objects.requireNonNull(str);
            this.mSchemaType = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setScore(int i) {
            this.mScore = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setTtlMillis(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("Document ttlMillis cannot be negative.");
            }
            this.mTtlMillis = j;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder putInPropertyMap(String str, boolean[] zArr) {
            putInPropertyMap(str, new PropertyParcel.Builder(str).setBooleanValues(zArr).build());
            return this;
        }

        @CanIgnoreReturnValue
        public Builder putInPropertyMap(String str, double[] dArr) {
            putInPropertyMap(str, new PropertyParcel.Builder(str).setDoubleValues(dArr).build());
            return this;
        }

        public Builder(GenericDocumentParcel genericDocumentParcel) {
            Objects.requireNonNull(genericDocumentParcel);
            this.mNamespace = genericDocumentParcel.mNamespace;
            this.mId = genericDocumentParcel.mId;
            this.mSchemaType = genericDocumentParcel.mSchemaType;
            this.mCreationTimestampMillis = genericDocumentParcel.mCreationTimestampMillis;
            this.mTtlMillis = genericDocumentParcel.mTtlMillis;
            this.mScore = genericDocumentParcel.mScore;
            Map map = genericDocumentParcel.mPropertyMap;
            this.mPropertyMap = new ArrayMap(map.size());
            for (PropertyParcel propertyParcel : map.values()) {
                this.mPropertyMap.put(propertyParcel.getPropertyName(), propertyParcel);
            }
            this.mParentTypes = genericDocumentParcel.mParentTypes;
        }

        @CanIgnoreReturnValue
        public Builder putInPropertyMap(String str, long[] jArr) {
            putInPropertyMap(str, new PropertyParcel.Builder(str).setLongValues(jArr).build());
            return this;
        }

        @CanIgnoreReturnValue
        public Builder putInPropertyMap(String str, byte[][] bArr) {
            putInPropertyMap(str, new PropertyParcel.Builder(str).setBytesValues(bArr).build());
            return this;
        }

        @CanIgnoreReturnValue
        public Builder putInPropertyMap(String str, GenericDocumentParcel[] genericDocumentParcelArr) {
            putInPropertyMap(str, new PropertyParcel.Builder(str).setDocumentValues(genericDocumentParcelArr).build());
            return this;
        }

        @CanIgnoreReturnValue
        public Builder putInPropertyMap(String str, EmbeddingVector[] embeddingVectorArr) {
            putInPropertyMap(str, new PropertyParcel.Builder(str).setEmbeddingValues(embeddingVectorArr).build());
            return this;
        }

        @CanIgnoreReturnValue
        @ExperimentalAppSearchApi
        public Builder putInPropertyMap(String str, AppSearchBlobHandle[] appSearchBlobHandleArr) {
            Objects.requireNonNull(appSearchBlobHandleArr);
            putInPropertyMap(str, new PropertyParcel.Builder(str).setBlobHandleValues(appSearchBlobHandleArr).build());
            return this;
        }

        @CanIgnoreReturnValue
        public Builder putInPropertyMap(String str, PropertyParcel propertyParcel) {
            Objects.requireNonNull(propertyParcel);
            this.mPropertyMap.put(str, propertyParcel);
            return this;
        }
    }

    public GenericDocumentParcel(String str, String str2, String str3, long j, long j2, int i, List<PropertyParcel> list, Map<String, PropertyParcel> map, List<String> list2) {
        Objects.requireNonNull(str);
        this.mNamespace = str;
        Objects.requireNonNull(str2);
        this.mId = str2;
        Objects.requireNonNull(str3);
        this.mSchemaType = str3;
        this.mCreationTimestampMillis = j;
        this.mTtlMillis = j2;
        this.mScore = i;
        Objects.requireNonNull(list);
        this.mProperties = list;
        Objects.requireNonNull(map);
        this.mPropertyMap = map;
        this.mParentTypes = list2;
    }
}
