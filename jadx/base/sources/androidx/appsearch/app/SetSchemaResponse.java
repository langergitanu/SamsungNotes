package androidx.appsearch.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "SetSchemaResponseCreator")
public final class SetSchemaResponse extends AbstractSafeParcelable {

    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<SetSchemaResponse> CREATOR = new StubCreators.SetSchemaResponseCreator();

    @AbstractSafeParcelable.Field(m1109id = 1)
    final List<String> mDeletedTypes;
    private Set<String> mDeletedTypesCached;

    @AbstractSafeParcelable.Field(m1109id = 2)
    final List<String> mIncompatibleTypes;
    private Set<String> mIncompatibleTypesCached;

    @AbstractSafeParcelable.Field(m1109id = 3)
    final List<String> mMigratedTypes;
    private Set<String> mMigratedTypesCached;
    private final List<MigrationFailure> mMigrationFailures;

    @AbstractSafeParcelable.Constructor
    public SetSchemaResponse(@AbstractSafeParcelable.Param(m1110id = 1) List<String> list, @AbstractSafeParcelable.Param(m1110id = 2) List<String> list2, @AbstractSafeParcelable.Param(m1110id = 3) List<String> list3) {
        this.mDeletedTypes = list;
        this.mIncompatibleTypes = list2;
        this.mMigratedTypes = list3;
        this.mMigrationFailures = Collections.EMPTY_LIST;
    }

    public Set<String> getDeletedTypes() {
        if (this.mDeletedTypesCached == null) {
            this.mDeletedTypesCached = new ArraySet((Collection) Preconditions.checkNotNull(this.mDeletedTypes));
        }
        return Collections.unmodifiableSet(this.mDeletedTypesCached);
    }

    public Set<String> getIncompatibleTypes() {
        if (this.mIncompatibleTypesCached == null) {
            this.mIncompatibleTypesCached = new ArraySet((Collection) Preconditions.checkNotNull(this.mIncompatibleTypes));
        }
        return Collections.unmodifiableSet(this.mIncompatibleTypesCached);
    }

    public Set<String> getMigratedTypes() {
        if (this.mMigratedTypesCached == null) {
            this.mMigratedTypesCached = new ArraySet((Collection) Preconditions.checkNotNull(this.mMigratedTypes));
        }
        return Collections.unmodifiableSet(this.mMigratedTypesCached);
    }

    public List<MigrationFailure> getMigrationFailures() {
        return Collections.unmodifiableList(this.mMigrationFailures);
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @SafeParcelable.Class(creator = "MigrationFailureCreator")
    public static class MigrationFailure extends AbstractSafeParcelable {

        @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final Parcelable.Creator<MigrationFailure> CREATOR = new StubCreators.MigrationFailureCreator();

        @AbstractSafeParcelable.Field(getter = "getDocumentId", m1109id = 2)
        private final String mDocumentId;

        @AbstractSafeParcelable.Field(m1109id = 4)
        final String mErrorMessage;

        @AbstractSafeParcelable.Field(getter = "getNamespace", m1109id = 1)
        private final String mNamespace;

        @AbstractSafeParcelable.Field(m1109id = 5)
        final int mResultCode;

        @AbstractSafeParcelable.Field(getter = "getSchemaType", m1109id = 3)
        private final String mSchemaType;

        @AbstractSafeParcelable.Constructor
        public MigrationFailure(@AbstractSafeParcelable.Param(m1110id = 1) String str, @AbstractSafeParcelable.Param(m1110id = 2) String str2, @AbstractSafeParcelable.Param(m1110id = 3) String str3, @AbstractSafeParcelable.Param(m1110id = 4) String str4, @AbstractSafeParcelable.Param(m1110id = 5) int i) {
            this.mNamespace = str;
            this.mDocumentId = str2;
            this.mSchemaType = str3;
            this.mErrorMessage = str4;
            this.mResultCode = i;
        }

        public AppSearchResult<Void> getAppSearchResult() {
            return AppSearchResult.newFailedResult(this.mResultCode, this.mErrorMessage);
        }

        public String getDocumentId() {
            return this.mDocumentId;
        }

        public String getNamespace() {
            return this.mNamespace;
        }

        public String getSchemaType() {
            return this.mSchemaType;
        }

        public String toString() {
            return "MigrationFailure { schemaType: " + getSchemaType() + ", namespace: " + getNamespace() + ", documentId: " + getDocumentId() + ", appSearchResult: " + getAppSearchResult().toString() + "}";
        }

        @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
        @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void writeToParcel(Parcel parcel, int i) {
            AbstractCreator.writeToParcel(this, parcel, i);
        }

        public MigrationFailure(String str, String str2, String str3, AppSearchResult<?> appSearchResult) {
            this.mNamespace = str;
            this.mDocumentId = str2;
            this.mSchemaType = str3;
            Preconditions.checkNotNull(appSearchResult);
            Preconditions.checkArgument(!appSearchResult.isSuccess(), "failedResult was actually successful");
            this.mErrorMessage = appSearchResult.getErrorMessage();
            this.mResultCode = appSearchResult.getResultCode();
        }
    }

    public SetSchemaResponse(List<String> list, List<String> list2, List<String> list3, List<MigrationFailure> list4) {
        this.mDeletedTypes = list;
        this.mIncompatibleTypes = list2;
        this.mMigratedTypes = list3;
        this.mMigrationFailures = (List) Preconditions.checkNotNull(list4);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private List<MigrationFailure> mMigrationFailures = new ArrayList();
        private ArrayList<String> mDeletedTypes = new ArrayList<>();
        private ArrayList<String> mMigratedTypes = new ArrayList<>();
        private ArrayList<String> mIncompatibleTypes = new ArrayList<>();
        private boolean mBuilt = false;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(SetSchemaResponse setSchemaResponse) {
            Preconditions.checkNotNull(setSchemaResponse);
            this.mDeletedTypes.addAll(setSchemaResponse.getDeletedTypes());
            this.mIncompatibleTypes.addAll(setSchemaResponse.getIncompatibleTypes());
            this.mMigratedTypes.addAll(setSchemaResponse.getMigratedTypes());
            this.mMigrationFailures.addAll(setSchemaResponse.getMigrationFailures());
        }

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mMigrationFailures = new ArrayList(this.mMigrationFailures);
                this.mDeletedTypes = new ArrayList<>(this.mDeletedTypes);
                this.mMigratedTypes = new ArrayList<>(this.mMigratedTypes);
                this.mIncompatibleTypes = new ArrayList<>(this.mIncompatibleTypes);
                this.mBuilt = false;
            }
        }

        @CanIgnoreReturnValue
        public Builder addDeletedType(String str) {
            Preconditions.checkNotNull(str);
            resetIfBuilt();
            this.mDeletedTypes.add(str);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addDeletedTypes(Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mDeletedTypes.addAll(collection);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addIncompatibleType(String str) {
            Preconditions.checkNotNull(str);
            resetIfBuilt();
            this.mIncompatibleTypes.add(str);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addIncompatibleTypes(Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mIncompatibleTypes.addAll(collection);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addMigratedType(String str) {
            Preconditions.checkNotNull(str);
            resetIfBuilt();
            this.mMigratedTypes.add(str);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addMigratedTypes(Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mMigratedTypes.addAll(collection);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addMigrationFailure(MigrationFailure migrationFailure) {
            Preconditions.checkNotNull(migrationFailure);
            resetIfBuilt();
            this.mMigrationFailures.add(migrationFailure);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addMigrationFailures(Collection<MigrationFailure> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mMigrationFailures.addAll(collection);
            return this;
        }

        public SetSchemaResponse build() {
            this.mBuilt = true;
            return new SetSchemaResponse(this.mDeletedTypes, this.mIncompatibleTypes, this.mMigratedTypes, this.mMigrationFailures);
        }

        public Builder() {
        }
    }
}
