package androidx.appsearch.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.PackageIdentifierParcel;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import androidx.collection.ArraySet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@FlaggedApi(Flags.FLAG_ENABLE_SET_SCHEMA_VISIBLE_TO_CONFIGS)
@SafeParcelable.Class(creator = "VisibilityConfigCreator")
public final class SchemaVisibilityConfig extends AbstractSafeParcelable {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<SchemaVisibilityConfig> CREATOR = new StubCreators.VisibilityConfigCreator();

    @AbstractSafeParcelable.Field(m1109id = 1)
    final List<PackageIdentifierParcel> mAllowedPackages;
    private List<PackageIdentifier> mAllowedPackagesCached;
    private Integer mHashCode;

    @AbstractSafeParcelable.Field(m1109id = 3)
    final PackageIdentifierParcel mPubliclyVisibleTargetPackage;

    @AbstractSafeParcelable.Field(m1109id = 2)
    final List<VisibilityPermissionConfig> mRequiredPermissions;
    private Set<Set<Integer>> mRequiredPermissionsCached;

    @AbstractSafeParcelable.Constructor
    public SchemaVisibilityConfig(@AbstractSafeParcelable.Param(m1110id = 1) List<PackageIdentifierParcel> list, @AbstractSafeParcelable.Param(m1110id = 2) List<VisibilityPermissionConfig> list2, @AbstractSafeParcelable.Param(m1110id = 3) PackageIdentifierParcel packageIdentifierParcel) {
        Objects.requireNonNull(list);
        this.mAllowedPackages = list;
        Objects.requireNonNull(list2);
        this.mRequiredPermissions = list2;
        this.mPubliclyVisibleTargetPackage = packageIdentifierParcel;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SchemaVisibilityConfig)) {
            return false;
        }
        SchemaVisibilityConfig schemaVisibilityConfig = (SchemaVisibilityConfig) obj;
        return Objects.equals(this.mAllowedPackages, schemaVisibilityConfig.mAllowedPackages) && Objects.equals(this.mRequiredPermissions, schemaVisibilityConfig.mRequiredPermissions) && Objects.equals(this.mPubliclyVisibleTargetPackage, schemaVisibilityConfig.mPubliclyVisibleTargetPackage);
    }

    public List<PackageIdentifier> getAllowedPackages() {
        if (this.mAllowedPackagesCached == null) {
            this.mAllowedPackagesCached = new ArrayList(this.mAllowedPackages.size());
            for (int i = 0; i < this.mAllowedPackages.size(); i++) {
                this.mAllowedPackagesCached.add(new PackageIdentifier(this.mAllowedPackages.get(i)));
            }
        }
        return this.mAllowedPackagesCached;
    }

    public PackageIdentifier getPubliclyVisibleTargetPackage() {
        PackageIdentifierParcel packageIdentifierParcel = this.mPubliclyVisibleTargetPackage;
        if (packageIdentifierParcel == null) {
            return null;
        }
        return new PackageIdentifier(packageIdentifierParcel);
    }

    public Set<Set<Integer>> getRequiredPermissions() {
        if (this.mRequiredPermissionsCached == null) {
            this.mRequiredPermissionsCached = new ArraySet(this.mRequiredPermissions.size());
            for (int i = 0; i < this.mRequiredPermissions.size(); i++) {
                Set<Integer> allRequiredPermissions = this.mRequiredPermissions.get(i).getAllRequiredPermissions();
                Set<Set<Integer>> set = this.mRequiredPermissionsCached;
                if (set != null && allRequiredPermissions != null) {
                    set.add(allRequiredPermissions);
                }
            }
        }
        Set<Set<Integer>> set2 = this.mRequiredPermissionsCached;
        Objects.requireNonNull(set2);
        return set2;
    }

    public int hashCode() {
        if (this.mHashCode == null) {
            this.mHashCode = Integer.valueOf(Objects.hash(this.mAllowedPackages, this.mRequiredPermissions, this.mPubliclyVisibleTargetPackage));
        }
        return this.mHashCode.intValue();
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @FlaggedApi(Flags.FLAG_ENABLE_SET_SCHEMA_VISIBLE_TO_CONFIGS)
    public static final class Builder {
        private List<PackageIdentifierParcel> mAllowedPackages;
        private boolean mBuilt;
        private PackageIdentifierParcel mPubliclyVisibleTargetPackage;
        private List<VisibilityPermissionConfig> mRequiredPermissions;

        public Builder() {
            this.mAllowedPackages = new ArrayList();
            this.mRequiredPermissions = new ArrayList();
        }

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mAllowedPackages = new ArrayList(this.mAllowedPackages);
                this.mRequiredPermissions = new ArrayList(this.mRequiredPermissions);
                this.mBuilt = false;
            }
        }

        @CanIgnoreReturnValue
        public Builder addAllowedPackage(PackageIdentifier packageIdentifier) {
            Objects.requireNonNull(packageIdentifier);
            resetIfBuilt();
            this.mAllowedPackages.add(packageIdentifier.getPackageIdentifierParcel());
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addRequiredPermissions(Set<Integer> set) {
            Objects.requireNonNull(set);
            resetIfBuilt();
            this.mRequiredPermissions.add(new VisibilityPermissionConfig(set));
            return this;
        }

        public SchemaVisibilityConfig build() {
            this.mBuilt = true;
            return new SchemaVisibilityConfig(this.mAllowedPackages, this.mRequiredPermissions, this.mPubliclyVisibleTargetPackage);
        }

        @CanIgnoreReturnValue
        public Builder clearAllowedPackages() {
            resetIfBuilt();
            this.mAllowedPackages.clear();
            return this;
        }

        @CanIgnoreReturnValue
        public Builder clearRequiredPermissions() {
            resetIfBuilt();
            this.mRequiredPermissions.clear();
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPubliclyVisibleTargetPackage(PackageIdentifier packageIdentifier) {
            resetIfBuilt();
            if (packageIdentifier == null) {
                this.mPubliclyVisibleTargetPackage = null;
                return this;
            }
            this.mPubliclyVisibleTargetPackage = packageIdentifier.getPackageIdentifierParcel();
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(SchemaVisibilityConfig schemaVisibilityConfig) {
            this.mAllowedPackages = new ArrayList();
            this.mRequiredPermissions = new ArrayList();
            Objects.requireNonNull(schemaVisibilityConfig);
            this.mAllowedPackages = new ArrayList(schemaVisibilityConfig.mAllowedPackages);
            this.mRequiredPermissions = new ArrayList(schemaVisibilityConfig.mRequiredPermissions);
            this.mPubliclyVisibleTargetPackage = schemaVisibilityConfig.mPubliclyVisibleTargetPackage;
        }
    }
}
