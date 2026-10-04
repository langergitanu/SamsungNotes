package androidx.appsearch.safeparcel;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import androidx.core.util.ObjectsCompat;
import androidx.glance.AbstractC2821a;
import java.util.List;
import java.util.Objects;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
@SafeParcelable.Class(creator = "PropertyConfigParcelCreator")
public final class PropertyConfigParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PropertyConfigParcel> CREATOR = new StubCreators.PropertyConfigParcelCreator();

    @AbstractSafeParcelable.Field(getter = "getCardinality", m1109id = 3)
    private final int mCardinality;

    @AbstractSafeParcelable.Field(getter = "getDataType", m1109id = 2)
    private final int mDataType;

    @AbstractSafeParcelable.Field(getter = "getDescription", m1109id = 9)
    private final String mDescription;

    @AbstractSafeParcelable.Field(getter = "getDocumentIndexingConfigParcel", m1109id = 6)
    private final DocumentIndexingConfigParcel mDocumentIndexingConfigParcel;

    @AbstractSafeParcelable.Field(getter = "getEmbeddingIndexingConfigParcel", m1109id = 10)
    private final EmbeddingIndexingConfigParcel mEmbeddingIndexingConfigParcel;
    private Integer mHashCode;

    @AbstractSafeParcelable.Field(getter = "getIntegerIndexingConfigParcel", m1109id = 7)
    private final IntegerIndexingConfigParcel mIntegerIndexingConfigParcel;

    @AbstractSafeParcelable.Field(getter = "getJoinableConfigParcel", m1109id = 8)
    private final JoinableConfigParcel mJoinableConfigParcel;

    @AbstractSafeParcelable.Field(getter = "getName", m1109id = 1)
    private final String mName;

    @AbstractSafeParcelable.Field(getter = "getSchemaType", m1109id = 4)
    private final String mSchemaType;

    @AbstractSafeParcelable.Field(getter = "isScoringEnabled", m1109id = 11)
    private final boolean mScoringEnabled;

    @AbstractSafeParcelable.Field(getter = "getStringIndexingConfigParcel", m1109id = 5)
    private final StringIndexingConfigParcel mStringIndexingConfigParcel;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @SafeParcelable.Class(creator = "DocumentIndexingConfigParcelCreator")
    public static class DocumentIndexingConfigParcel extends AbstractSafeParcelable {
        public static final Parcelable.Creator<DocumentIndexingConfigParcel> CREATOR = new StubCreators.DocumentIndexingConfigParcelCreator();

        @AbstractSafeParcelable.Field(getter = "shouldIndexNestedProperties", m1109id = 1)
        private final boolean mIndexNestedProperties;

        @AbstractSafeParcelable.Field(getter = "getIndexableNestedPropertiesList", m1109id = 2)
        private final List<String> mIndexableNestedPropertiesList;

        @AbstractSafeParcelable.Constructor
        public DocumentIndexingConfigParcel(@AbstractSafeParcelable.Param(m1110id = 1) boolean z, @AbstractSafeParcelable.Param(m1110id = 2) List<String> list) {
            this.mIndexNestedProperties = z;
            Objects.requireNonNull(list);
            this.mIndexableNestedPropertiesList = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DocumentIndexingConfigParcel)) {
                return false;
            }
            DocumentIndexingConfigParcel documentIndexingConfigParcel = (DocumentIndexingConfigParcel) obj;
            return ObjectsCompat.equals(Boolean.valueOf(this.mIndexNestedProperties), Boolean.valueOf(documentIndexingConfigParcel.mIndexNestedProperties)) && ObjectsCompat.equals(this.mIndexableNestedPropertiesList, documentIndexingConfigParcel.mIndexableNestedPropertiesList);
        }

        public List<String> getIndexableNestedPropertiesList() {
            return this.mIndexableNestedPropertiesList;
        }

        public int hashCode() {
            return ObjectsCompat.hash(Boolean.valueOf(this.mIndexNestedProperties), this.mIndexableNestedPropertiesList);
        }

        public boolean shouldIndexNestedProperties() {
            return this.mIndexNestedProperties;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{indexNestedProperties: ");
            sb.append(this.mIndexNestedProperties);
            sb.append(", indexableNestedPropertiesList: ");
            return AbstractC0541b.m777s(sb, this.mIndexableNestedPropertiesList, "}");
        }

        @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
        public void writeToParcel(Parcel parcel, int i) {
            AbstractCreator.writeToParcel(this, parcel, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @SafeParcelable.Class(creator = "EmbeddingIndexingConfigParcelCreator")
    public static class EmbeddingIndexingConfigParcel extends AbstractSafeParcelable {
        public static final Parcelable.Creator<EmbeddingIndexingConfigParcel> CREATOR = new StubCreators.EmbeddingIndexingConfigParcelCreator();

        @AbstractSafeParcelable.Field(getter = "getIndexingType", m1109id = 1)
        private final int mIndexingType;

        @AbstractSafeParcelable.Field(getter = "getQuantizationType", m1109id = 2)
        private final int mQuantizationType;

        @AbstractSafeParcelable.Constructor
        public EmbeddingIndexingConfigParcel(@AbstractSafeParcelable.Param(m1110id = 1) int i, @AbstractSafeParcelable.Param(m1110id = 2) int i2) {
            this.mIndexingType = i;
            this.mQuantizationType = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EmbeddingIndexingConfigParcel)) {
                return false;
            }
            EmbeddingIndexingConfigParcel embeddingIndexingConfigParcel = (EmbeddingIndexingConfigParcel) obj;
            return this.mIndexingType == embeddingIndexingConfigParcel.mIndexingType && this.mQuantizationType == embeddingIndexingConfigParcel.mQuantizationType;
        }

        public int getIndexingType() {
            return this.mIndexingType;
        }

        public int getQuantizationType() {
            return this.mQuantizationType;
        }

        public int hashCode() {
            return ObjectsCompat.hash(Integer.valueOf(this.mIndexingType), Integer.valueOf(this.mQuantizationType));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{indexingType: ");
            sb.append(this.mIndexingType);
            sb.append(", quantizationType: ");
            return AbstractC2821a.m2223n(sb, "}", this.mQuantizationType);
        }

        @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
        public void writeToParcel(Parcel parcel, int i) {
            AbstractCreator.writeToParcel(this, parcel, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @SafeParcelable.Class(creator = "IntegerIndexingConfigParcelCreator")
    public static class IntegerIndexingConfigParcel extends AbstractSafeParcelable {
        public static final Parcelable.Creator<IntegerIndexingConfigParcel> CREATOR = new StubCreators.IntegerIndexingConfigParcelCreator();

        @AbstractSafeParcelable.Field(getter = "getIndexingType", m1109id = 1)
        private final int mIndexingType;

        @AbstractSafeParcelable.Constructor
        public IntegerIndexingConfigParcel(@AbstractSafeParcelable.Param(m1110id = 1) int i) {
            this.mIndexingType = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IntegerIndexingConfigParcel) && this.mIndexingType == ((IntegerIndexingConfigParcel) obj).mIndexingType;
        }

        public int getIndexingType() {
            return this.mIndexingType;
        }

        public int hashCode() {
            return ObjectsCompat.hashCode(Integer.valueOf(this.mIndexingType));
        }

        public String toString() {
            return AbstractC2821a.m2223n(new StringBuilder("{indexingType: "), "}", this.mIndexingType);
        }

        @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
        public void writeToParcel(Parcel parcel, int i) {
            AbstractCreator.writeToParcel(this, parcel, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @SafeParcelable.Class(creator = "JoinableConfigParcelCreator")
    public static class JoinableConfigParcel extends AbstractSafeParcelable {
        public static final Parcelable.Creator<JoinableConfigParcel> CREATOR = new StubCreators.JoinableConfigParcelCreator();

        @AbstractSafeParcelable.Field(getter = "getDeletePropagationType", m1109id = 3)
        private final int mDeletePropagationType;

        @AbstractSafeParcelable.Field(getter = "getJoinableValueType", m1109id = 1)
        private final int mJoinableValueType;

        @AbstractSafeParcelable.Constructor
        public JoinableConfigParcel(@AbstractSafeParcelable.Param(m1110id = 1) int i, @AbstractSafeParcelable.Param(m1110id = 3) int i2) {
            this.mJoinableValueType = i;
            this.mDeletePropagationType = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof JoinableConfigParcel)) {
                return false;
            }
            JoinableConfigParcel joinableConfigParcel = (JoinableConfigParcel) obj;
            return ObjectsCompat.equals(Integer.valueOf(this.mJoinableValueType), Integer.valueOf(joinableConfigParcel.mJoinableValueType)) && this.mDeletePropagationType == joinableConfigParcel.mDeletePropagationType;
        }

        public int getDeletePropagationType() {
            return this.mDeletePropagationType;
        }

        public int getJoinableValueType() {
            return this.mJoinableValueType;
        }

        public int hashCode() {
            return ObjectsCompat.hash(Integer.valueOf(this.mJoinableValueType), Integer.valueOf(this.mDeletePropagationType));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{joinableValueType: ");
            sb.append(this.mJoinableValueType);
            sb.append(", deletePropagationType: ");
            return AbstractC2821a.m2223n(sb, "}", this.mDeletePropagationType);
        }

        @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
        public void writeToParcel(Parcel parcel, int i) {
            AbstractCreator.writeToParcel(this, parcel, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @SafeParcelable.Class(creator = "StringIndexingConfigParcelCreator")
    public static class StringIndexingConfigParcel extends AbstractSafeParcelable {
        public static final Parcelable.Creator<StringIndexingConfigParcel> CREATOR = new StubCreators.StringIndexingConfigParcelCreator();

        @AbstractSafeParcelable.Field(getter = "getIndexingType", m1109id = 1)
        private final int mIndexingType;

        @AbstractSafeParcelable.Field(getter = "getTokenizerType", m1109id = 2)
        private final int mTokenizerType;

        @AbstractSafeParcelable.Constructor
        public StringIndexingConfigParcel(@AbstractSafeParcelable.Param(m1110id = 1) int i, @AbstractSafeParcelable.Param(m1110id = 2) int i2) {
            this.mIndexingType = i;
            this.mTokenizerType = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StringIndexingConfigParcel)) {
                return false;
            }
            StringIndexingConfigParcel stringIndexingConfigParcel = (StringIndexingConfigParcel) obj;
            return this.mIndexingType == stringIndexingConfigParcel.mIndexingType && ObjectsCompat.equals(Integer.valueOf(this.mTokenizerType), Integer.valueOf(stringIndexingConfigParcel.mTokenizerType));
        }

        public int getIndexingType() {
            return this.mIndexingType;
        }

        public int getTokenizerType() {
            return this.mTokenizerType;
        }

        public int hashCode() {
            return ObjectsCompat.hash(Integer.valueOf(this.mIndexingType), Integer.valueOf(this.mTokenizerType));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{indexingType: ");
            sb.append(this.mIndexingType);
            sb.append(", tokenizerType: ");
            return AbstractC2821a.m2223n(sb, "}", this.mTokenizerType);
        }

        @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
        public void writeToParcel(Parcel parcel, int i) {
            AbstractCreator.writeToParcel(this, parcel, i);
        }
    }

    @AbstractSafeParcelable.Constructor
    public PropertyConfigParcel(@AbstractSafeParcelable.Param(m1110id = 1) String str, @AbstractSafeParcelable.Param(m1110id = 2) int i, @AbstractSafeParcelable.Param(m1110id = 3) int i2, @AbstractSafeParcelable.Param(m1110id = 4) String str2, @AbstractSafeParcelable.Param(m1110id = 5) StringIndexingConfigParcel stringIndexingConfigParcel, @AbstractSafeParcelable.Param(m1110id = 6) DocumentIndexingConfigParcel documentIndexingConfigParcel, @AbstractSafeParcelable.Param(m1110id = 7) IntegerIndexingConfigParcel integerIndexingConfigParcel, @AbstractSafeParcelable.Param(m1110id = 8) JoinableConfigParcel joinableConfigParcel, @AbstractSafeParcelable.Param(m1110id = 9) String str3, @AbstractSafeParcelable.Param(m1110id = 10) EmbeddingIndexingConfigParcel embeddingIndexingConfigParcel, @AbstractSafeParcelable.Param(m1110id = 11) boolean z) {
        Objects.requireNonNull(str);
        this.mName = str;
        this.mDataType = i;
        this.mCardinality = i2;
        this.mSchemaType = str2;
        this.mStringIndexingConfigParcel = stringIndexingConfigParcel;
        this.mDocumentIndexingConfigParcel = documentIndexingConfigParcel;
        this.mIntegerIndexingConfigParcel = integerIndexingConfigParcel;
        this.mJoinableConfigParcel = joinableConfigParcel;
        Objects.requireNonNull(str3);
        this.mDescription = str3;
        this.mEmbeddingIndexingConfigParcel = embeddingIndexingConfigParcel;
        this.mScoringEnabled = z;
    }

    @ExperimentalAppSearchApi
    public static PropertyConfigParcel createForBlobHandle(String str, String str2, int i) {
        Objects.requireNonNull(str);
        Objects.requireNonNull(str2);
        return new PropertyConfigParcel(str, 8, i, null, null, null, null, null, str2, null, false);
    }

    public static PropertyConfigParcel createForBoolean(String str, String str2, int i, boolean z) {
        Objects.requireNonNull(str);
        Objects.requireNonNull(str2);
        return new PropertyConfigParcel(str, 4, i, null, null, null, null, null, str2, null, z);
    }

    public static PropertyConfigParcel createForBytes(String str, String str2, int i) {
        Objects.requireNonNull(str);
        Objects.requireNonNull(str2);
        return new PropertyConfigParcel(str, 5, i, null, null, null, null, null, str2, null, false);
    }

    public static PropertyConfigParcel createForDocument(String str, String str2, int i, String str3, DocumentIndexingConfigParcel documentIndexingConfigParcel) {
        Objects.requireNonNull(str);
        Objects.requireNonNull(str3);
        Objects.requireNonNull(documentIndexingConfigParcel);
        Objects.requireNonNull(str2);
        return new PropertyConfigParcel(str, 6, i, str3, null, documentIndexingConfigParcel, null, null, str2, null, false);
    }

    public static PropertyConfigParcel createForDouble(String str, String str2, int i, boolean z) {
        Objects.requireNonNull(str);
        Objects.requireNonNull(str2);
        return new PropertyConfigParcel(str, 3, i, null, null, null, null, null, str2, null, z);
    }

    public static PropertyConfigParcel createForEmbedding(String str, String str2, int i, int i2, int i4) {
        Objects.requireNonNull(str);
        Objects.requireNonNull(str2);
        return new PropertyConfigParcel(str, 7, i, null, null, null, null, null, str2, new EmbeddingIndexingConfigParcel(i2, i4), false);
    }

    public static PropertyConfigParcel createForLong(String str, String str2, int i, int i2, boolean z) {
        Objects.requireNonNull(str);
        IntegerIndexingConfigParcel integerIndexingConfigParcel = new IntegerIndexingConfigParcel(i2);
        Objects.requireNonNull(str2);
        return new PropertyConfigParcel(str, 2, i, null, null, null, integerIndexingConfigParcel, null, str2, null, z);
    }

    public static PropertyConfigParcel createForString(String str, String str2, int i, StringIndexingConfigParcel stringIndexingConfigParcel, JoinableConfigParcel joinableConfigParcel) {
        Objects.requireNonNull(str);
        Objects.requireNonNull(stringIndexingConfigParcel);
        Objects.requireNonNull(joinableConfigParcel);
        Objects.requireNonNull(str2);
        return new PropertyConfigParcel(str, 1, i, null, stringIndexingConfigParcel, null, null, joinableConfigParcel, str2, null, false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PropertyConfigParcel)) {
            return false;
        }
        PropertyConfigParcel propertyConfigParcel = (PropertyConfigParcel) obj;
        return ObjectsCompat.equals(this.mName, propertyConfigParcel.mName) && Objects.equals(this.mDescription, propertyConfigParcel.mDescription) && ObjectsCompat.equals(Integer.valueOf(this.mDataType), Integer.valueOf(propertyConfigParcel.mDataType)) && ObjectsCompat.equals(Integer.valueOf(this.mCardinality), Integer.valueOf(propertyConfigParcel.mCardinality)) && ObjectsCompat.equals(this.mSchemaType, propertyConfigParcel.mSchemaType) && ObjectsCompat.equals(this.mStringIndexingConfigParcel, propertyConfigParcel.mStringIndexingConfigParcel) && ObjectsCompat.equals(this.mDocumentIndexingConfigParcel, propertyConfigParcel.mDocumentIndexingConfigParcel) && ObjectsCompat.equals(this.mIntegerIndexingConfigParcel, propertyConfigParcel.mIntegerIndexingConfigParcel) && ObjectsCompat.equals(this.mJoinableConfigParcel, propertyConfigParcel.mJoinableConfigParcel) && ObjectsCompat.equals(this.mEmbeddingIndexingConfigParcel, propertyConfigParcel.mEmbeddingIndexingConfigParcel) && this.mScoringEnabled == propertyConfigParcel.mScoringEnabled;
    }

    public int getCardinality() {
        return this.mCardinality;
    }

    public int getDataType() {
        return this.mDataType;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public DocumentIndexingConfigParcel getDocumentIndexingConfigParcel() {
        return this.mDocumentIndexingConfigParcel;
    }

    public EmbeddingIndexingConfigParcel getEmbeddingIndexingConfigParcel() {
        return this.mEmbeddingIndexingConfigParcel;
    }

    public IntegerIndexingConfigParcel getIntegerIndexingConfigParcel() {
        return this.mIntegerIndexingConfigParcel;
    }

    public JoinableConfigParcel getJoinableConfigParcel() {
        return this.mJoinableConfigParcel;
    }

    public String getName() {
        return this.mName;
    }

    public String getSchemaType() {
        return this.mSchemaType;
    }

    public StringIndexingConfigParcel getStringIndexingConfigParcel() {
        return this.mStringIndexingConfigParcel;
    }

    public int hashCode() {
        if (this.mHashCode == null) {
            this.mHashCode = Integer.valueOf(ObjectsCompat.hash(this.mName, this.mDescription, Integer.valueOf(this.mDataType), Integer.valueOf(this.mCardinality), this.mSchemaType, this.mStringIndexingConfigParcel, this.mDocumentIndexingConfigParcel, this.mIntegerIndexingConfigParcel, this.mJoinableConfigParcel, this.mEmbeddingIndexingConfigParcel, Boolean.valueOf(this.mScoringEnabled)));
        }
        return this.mHashCode.intValue();
    }

    public boolean isScoringEnabled() {
        return this.mScoringEnabled;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{name: ");
        sb.append(this.mName);
        sb.append(", description: ");
        sb.append(this.mDescription);
        sb.append(", dataType: ");
        sb.append(this.mDataType);
        sb.append(", cardinality: ");
        sb.append(this.mCardinality);
        sb.append(", schemaType: ");
        sb.append(this.mSchemaType);
        sb.append(", stringIndexingConfigParcel: ");
        sb.append(this.mStringIndexingConfigParcel);
        sb.append(", documentIndexingConfigParcel: ");
        sb.append(this.mDocumentIndexingConfigParcel);
        sb.append(", integerIndexingConfigParcel: ");
        sb.append(this.mIntegerIndexingConfigParcel);
        sb.append(", joinableConfigParcel: ");
        sb.append(this.mJoinableConfigParcel);
        sb.append(", embeddingIndexingConfigParcel: ");
        sb.append(this.mEmbeddingIndexingConfigParcel);
        sb.append(", isScoringEnabled: ");
        return AbstractC0000a.m14k(sb, this.mScoringEnabled, "}");
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    public void writeToParcel(Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }
}
