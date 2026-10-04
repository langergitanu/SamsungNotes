package androidx.appsearch.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.app.SchemaVisibilityConfig;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import androidx.collection.ArraySet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SafeParcelable.Class(creator = "InternalVisibilityConfigCreator")
public final class InternalVisibilityConfig extends AbstractSafeParcelable {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<InternalVisibilityConfig> CREATOR = new StubCreators.InternalVisibilityConfigCreator();

    @AbstractSafeParcelable.Field(getter = "isNotDisplayedBySystem", m1109id = 2)
    private final boolean mIsNotDisplayedBySystem;

    @AbstractSafeParcelable.Field(getter = "getSchemaType", m1109id = 1)
    private final String mSchemaType;

    @AbstractSafeParcelable.Field(getter = "getVisibilityConfig", m1109id = 3)
    private final SchemaVisibilityConfig mVisibilityConfig;

    @AbstractSafeParcelable.Field(m1109id = 4)
    final List<SchemaVisibilityConfig> mVisibleToConfigs;

    @AbstractSafeParcelable.Constructor
    public InternalVisibilityConfig(@AbstractSafeParcelable.Param(m1110id = 1) String str, @AbstractSafeParcelable.Param(m1110id = 2) boolean z, @AbstractSafeParcelable.Param(m1110id = 3) SchemaVisibilityConfig schemaVisibilityConfig, @AbstractSafeParcelable.Param(m1110id = 4) List<SchemaVisibilityConfig> list) {
        this.mIsNotDisplayedBySystem = z;
        Objects.requireNonNull(str);
        this.mSchemaType = str;
        Objects.requireNonNull(schemaVisibilityConfig);
        this.mVisibilityConfig = schemaVisibilityConfig;
        Objects.requireNonNull(list);
        this.mVisibleToConfigs = list;
    }

    public static List<InternalVisibilityConfig> toInternalVisibilityConfigs(SetSchemaRequest setSchemaRequest) {
        Set<AppSearchSchema> schemas = setSchemaRequest.getSchemas();
        Set<String> schemasNotDisplayedBySystem = setSchemaRequest.getSchemasNotDisplayedBySystem();
        Map<String, Set<PackageIdentifier>> schemasVisibleToPackages = setSchemaRequest.getSchemasVisibleToPackages();
        Map<String, Set<Set<Integer>>> requiredPermissionsForSchemaTypeVisibility = setSchemaRequest.getRequiredPermissionsForSchemaTypeVisibility();
        Map<String, PackageIdentifier> publiclyVisibleSchemas = setSchemaRequest.getPubliclyVisibleSchemas();
        Map<String, Set<SchemaVisibilityConfig>> schemasVisibleToConfigs = setSchemaRequest.getSchemasVisibleToConfigs();
        ArrayList arrayList = new ArrayList(schemas.size());
        Iterator<AppSearchSchema> it = schemas.iterator();
        while (it.hasNext()) {
            String schemaType = it.next().getSchemaType();
            Builder notDisplayedBySystem = new Builder(schemaType).setNotDisplayedBySystem(schemasNotDisplayedBySystem.contains(schemaType));
            Set<PackageIdentifier> set = schemasVisibleToPackages.get(schemaType);
            if (set != null) {
                Iterator<PackageIdentifier> it2 = set.iterator();
                while (it2.hasNext()) {
                    notDisplayedBySystem.addVisibleToPackage(it2.next());
                }
            }
            Set<Set<Integer>> set2 = requiredPermissionsForSchemaTypeVisibility.get(schemaType);
            if (set2 != null) {
                Iterator<Set<Integer>> it3 = set2.iterator();
                while (it3.hasNext()) {
                    notDisplayedBySystem.addVisibleToPermissions(it3.next());
                }
            }
            PackageIdentifier packageIdentifier = publiclyVisibleSchemas.get(schemaType);
            if (packageIdentifier != null) {
                notDisplayedBySystem.setPubliclyVisibleTargetPackage(packageIdentifier);
            }
            Set<SchemaVisibilityConfig> set3 = schemasVisibleToConfigs.get(schemaType);
            if (set3 != null) {
                Iterator<SchemaVisibilityConfig> it4 = set3.iterator();
                while (it4.hasNext()) {
                    notDisplayedBySystem.addVisibleToConfig(it4.next());
                }
            }
            arrayList.add(notDisplayedBySystem.build());
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InternalVisibilityConfig)) {
            return false;
        }
        InternalVisibilityConfig internalVisibilityConfig = (InternalVisibilityConfig) obj;
        return this.mIsNotDisplayedBySystem == internalVisibilityConfig.mIsNotDisplayedBySystem && Objects.equals(this.mSchemaType, internalVisibilityConfig.mSchemaType) && Objects.equals(this.mVisibilityConfig, internalVisibilityConfig.mVisibilityConfig) && Objects.equals(this.mVisibleToConfigs, internalVisibilityConfig.mVisibleToConfigs);
    }

    public String getSchemaType() {
        return this.mSchemaType;
    }

    public SchemaVisibilityConfig getVisibilityConfig() {
        return this.mVisibilityConfig;
    }

    public Set<SchemaVisibilityConfig> getVisibleToConfigs() {
        return new ArraySet(this.mVisibleToConfigs);
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(this.mIsNotDisplayedBySystem), this.mSchemaType, this.mVisibilityConfig, this.mVisibleToConfigs);
    }

    public boolean isNotDisplayedBySystem() {
        return this.mIsNotDisplayedBySystem;
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    public void writeToParcel(Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @FlaggedApi(Flags.FLAG_ENABLE_SET_SCHEMA_VISIBLE_TO_CONFIGS)
    public static final class Builder {
        private boolean mBuilt;
        private boolean mIsNotDisplayedBySystem;
        private String mSchemaType;
        private SchemaVisibilityConfig.Builder mVisibilityConfigBuilder;
        private List<SchemaVisibilityConfig> mVisibleToConfigs;

        public Builder(String str) {
            this.mVisibleToConfigs = new ArrayList();
            Objects.requireNonNull(str);
            this.mSchemaType = str;
            this.mVisibilityConfigBuilder = new SchemaVisibilityConfig.Builder();
        }

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mVisibleToConfigs = new ArrayList(this.mVisibleToConfigs);
                this.mBuilt = false;
            }
        }

        @CanIgnoreReturnValue
        public Builder addVisibleToConfig(SchemaVisibilityConfig schemaVisibilityConfig) {
            Objects.requireNonNull(schemaVisibilityConfig);
            resetIfBuilt();
            this.mVisibleToConfigs.add(schemaVisibilityConfig);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addVisibleToPackage(PackageIdentifier packageIdentifier) {
            resetIfBuilt();
            this.mVisibilityConfigBuilder.addAllowedPackage(packageIdentifier);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addVisibleToPermissions(Set<Integer> set) {
            resetIfBuilt();
            this.mVisibilityConfigBuilder.addRequiredPermissions(set);
            return this;
        }

        public InternalVisibilityConfig build() {
            this.mBuilt = true;
            return new InternalVisibilityConfig(this.mSchemaType, this.mIsNotDisplayedBySystem, this.mVisibilityConfigBuilder.build(), this.mVisibleToConfigs);
        }

        @CanIgnoreReturnValue
        public Builder clearVisibleToConfig() {
            resetIfBuilt();
            this.mVisibleToConfigs.clear();
            return this;
        }

        @CanIgnoreReturnValue
        public Builder clearVisibleToPackages() {
            resetIfBuilt();
            this.mVisibilityConfigBuilder.clearAllowedPackages();
            return this;
        }

        @CanIgnoreReturnValue
        public Builder clearVisibleToPermissions() {
            resetIfBuilt();
            this.mVisibilityConfigBuilder.clearRequiredPermissions();
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setNotDisplayedBySystem(boolean z) {
            resetIfBuilt();
            this.mIsNotDisplayedBySystem = z;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPubliclyVisibleTargetPackage(PackageIdentifier packageIdentifier) {
            resetIfBuilt();
            this.mVisibilityConfigBuilder.setPubliclyVisibleTargetPackage(packageIdentifier);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSchemaType(String str) {
            resetIfBuilt();
            Objects.requireNonNull(str);
            this.mSchemaType = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setVisibilityConfig(SchemaVisibilityConfig schemaVisibilityConfig) {
            resetIfBuilt();
            this.mVisibilityConfigBuilder = new SchemaVisibilityConfig.Builder(schemaVisibilityConfig);
            return this;
        }

        public Builder(InternalVisibilityConfig internalVisibilityConfig) {
            this.mVisibleToConfigs = new ArrayList();
            Objects.requireNonNull(internalVisibilityConfig);
            this.mSchemaType = internalVisibilityConfig.mSchemaType;
            this.mIsNotDisplayedBySystem = internalVisibilityConfig.mIsNotDisplayedBySystem;
            this.mVisibilityConfigBuilder = new SchemaVisibilityConfig.Builder(internalVisibilityConfig.getVisibilityConfig());
            this.mVisibleToConfigs = internalVisibilityConfig.mVisibleToConfigs;
        }
    }

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    public static List<InternalVisibilityConfig> toInternalVisibilityConfigs(SetBlobVisibilityRequest setBlobVisibilityRequest) {
        Set<String> namespacesNotDisplayedBySystem = setBlobVisibilityRequest.getNamespacesNotDisplayedBySystem();
        Map<String, Set<SchemaVisibilityConfig>> namespacesVisibleToConfigs = setBlobVisibilityRequest.getNamespacesVisibleToConfigs();
        ArraySet<String> arraySet = new ArraySet(namespacesNotDisplayedBySystem);
        arraySet.addAll(namespacesVisibleToConfigs.keySet());
        ArrayList arrayList = new ArrayList();
        for (String str : arraySet) {
            Builder notDisplayedBySystem = new Builder(str).setNotDisplayedBySystem(namespacesNotDisplayedBySystem.contains(str));
            Set<SchemaVisibilityConfig> set = namespacesVisibleToConfigs.get(str);
            if (set != null) {
                Iterator<SchemaVisibilityConfig> it = set.iterator();
                while (it.hasNext()) {
                    notDisplayedBySystem.addVisibleToConfig(it.next());
                }
            }
            arrayList.add(notDisplayedBySystem.build());
        }
        return arrayList;
    }
}
