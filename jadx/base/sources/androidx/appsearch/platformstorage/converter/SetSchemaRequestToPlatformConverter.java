package androidx.appsearch.platformstorage.converter;

import android.app.appsearch.GenericDocument;
import android.app.appsearch.PackageIdentifier;
import android.app.appsearch.SchemaVisibilityConfig;
import android.app.appsearch.SetSchemaRequest;
import android.app.appsearch.SetSchemaResponse;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.Migrator;
import androidx.appsearch.app.SchemaVisibilityConfig;
import androidx.appsearch.app.SetSchemaResponse;
import androidx.appsearch.platformstorage.AbstractC0560a;
import androidx.core.util.Preconditions;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SetSchemaRequestToPlatformConverter {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(33)
    public static class ApiHelperForT {
        private ApiHelperForT() {
        }

        @DoNotInline
        public static void addRequiredPermissionsForSchemaTypeVisibility(SetSchemaRequest.Builder builder, String str, Set<Integer> set) {
            builder.addRequiredPermissionsForSchemaTypeVisibility(str, set);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(35)
    public static class ApiHelperForV {
        private ApiHelperForV() {
        }

        @DoNotInline
        public static void addSchemaTypeVisibleToConfig(SetSchemaRequest.Builder builder, String str, Set<SchemaVisibilityConfig> set) {
            Iterator<SchemaVisibilityConfig> it = set.iterator();
            while (it.hasNext()) {
                builder.addSchemaTypeVisibleToConfig(str, toPlatformSchemaVisibilityConfig(it.next()));
            }
        }

        @DoNotInline
        public static void setPubliclyVisibleSchema(SetSchemaRequest.Builder builder, String str, PackageIdentifier packageIdentifier) {
            builder.setPubliclyVisibleSchema(str, packageIdentifier);
        }

        private static android.app.appsearch.SchemaVisibilityConfig toPlatformSchemaVisibilityConfig(SchemaVisibilityConfig schemaVisibilityConfig) {
            Preconditions.checkNotNull(schemaVisibilityConfig);
            SchemaVisibilityConfig.Builder builderM869c = AbstractC0560a.m869c();
            List<androidx.appsearch.app.PackageIdentifier> allowedPackages = schemaVisibilityConfig.getAllowedPackages();
            for (int i = 0; i < allowedPackages.size(); i++) {
                AbstractC0568e.m1007o();
                builderM869c.addAllowedPackage(AbstractC0568e.m994b(allowedPackages.get(i).getPackageName(), allowedPackages.get(i).getSha256Certificate()));
            }
            Iterator<Set<Integer>> it = schemaVisibilityConfig.getRequiredPermissions().iterator();
            while (it.hasNext()) {
                builderM869c.addRequiredPermissions(it.next());
            }
            androidx.appsearch.app.PackageIdentifier publiclyVisibleTargetPackage = schemaVisibilityConfig.getPubliclyVisibleTargetPackage();
            if (publiclyVisibleTargetPackage != null) {
                AbstractC0568e.m1007o();
                builderM869c.setPubliclyVisibleTargetPackage(AbstractC0568e.m994b(publiclyVisibleTargetPackage.getPackageName(), publiclyVisibleTargetPackage.getSha256Certificate()));
            }
            return builderM869c.build();
        }
    }

    private SetSchemaRequestToPlatformConverter() {
    }

    public static SetSchemaResponse toJetpackSetSchemaResponse(android.app.appsearch.SetSchemaResponse setSchemaResponse) {
        Preconditions.checkNotNull(setSchemaResponse);
        SetSchemaResponse.Builder builderAddMigratedTypes = new SetSchemaResponse.Builder().addDeletedTypes(setSchemaResponse.getDeletedTypes()).addIncompatibleTypes(setSchemaResponse.getIncompatibleTypes()).addMigratedTypes(setSchemaResponse.getMigratedTypes());
        Iterator it = setSchemaResponse.getMigrationFailures().iterator();
        while (it.hasNext()) {
            SetSchemaResponse.MigrationFailure migrationFailureM1003k = AbstractC0568e.m1003k(it.next());
            builderAddMigratedTypes.addMigrationFailure(new SetSchemaResponse.MigrationFailure(migrationFailureM1003k.getNamespace(), migrationFailureM1003k.getDocumentId(), migrationFailureM1003k.getSchemaType(), AppSearchResultToPlatformConverter.platformAppSearchResultToJetpack(migrationFailureM1003k.getAppSearchResult(), Function.identity())));
        }
        return builderAddMigratedTypes.build();
    }

    public static SetSchemaRequest toPlatformSetSchemaRequest(androidx.appsearch.app.SetSchemaRequest setSchemaRequest) {
        Preconditions.checkNotNull(setSchemaRequest);
        SetSchemaRequest.Builder builderM999g = AbstractC0568e.m999g();
        Iterator<AppSearchSchema> it = setSchemaRequest.getSchemas().iterator();
        while (it.hasNext()) {
            builderM999g.addSchemas(SchemaToPlatformConverter.toPlatformSchema(it.next()));
        }
        Iterator<String> it2 = setSchemaRequest.getSchemasNotDisplayedBySystem().iterator();
        while (it2.hasNext()) {
            builderM999g.setSchemaTypeDisplayedBySystem(it2.next(), false);
        }
        for (Map.Entry<String, Set<androidx.appsearch.app.PackageIdentifier>> entry : setSchemaRequest.getSchemasVisibleToPackagesInternal().entrySet()) {
            for (androidx.appsearch.app.PackageIdentifier packageIdentifier : entry.getValue()) {
                String key = entry.getKey();
                AbstractC0568e.m1007o();
                builderM999g.setSchemaTypeVisibilityForPackage(key, true, AbstractC0568e.m994b(packageIdentifier.getPackageName(), packageIdentifier.getSha256Certificate()));
            }
        }
        if (!setSchemaRequest.getRequiredPermissionsForSchemaTypeVisibility().isEmpty()) {
            if (Build.VERSION.SDK_INT < 33) {
                throw new UnsupportedOperationException("Set required permissions for schema type visibility are not supported with this backend/Android API level combination.");
            }
            for (Map.Entry<String, Set<Set<Integer>>> entry2 : setSchemaRequest.getRequiredPermissionsForSchemaTypeVisibility().entrySet()) {
                Iterator<Set<Integer>> it3 = entry2.getValue().iterator();
                while (it3.hasNext()) {
                    ApiHelperForT.addRequiredPermissionsForSchemaTypeVisibility(builderM999g, entry2.getKey(), it3.next());
                }
            }
        }
        if (!setSchemaRequest.getPubliclyVisibleSchemas().isEmpty()) {
            if (Build.VERSION.SDK_INT < 35) {
                throw new UnsupportedOperationException("Publicly visible schema are not supported on this AppSearch implementation.");
            }
            for (Map.Entry<String, androidx.appsearch.app.PackageIdentifier> entry3 : setSchemaRequest.getPubliclyVisibleSchemas().entrySet()) {
                androidx.appsearch.app.PackageIdentifier value = entry3.getValue();
                String key2 = entry3.getKey();
                AbstractC0568e.m1007o();
                ApiHelperForV.setPubliclyVisibleSchema(builderM999g, key2, AbstractC0568e.m994b(value.getPackageName(), value.getSha256Certificate()));
            }
        }
        if (!setSchemaRequest.getSchemasVisibleToConfigs().isEmpty()) {
            if (Build.VERSION.SDK_INT < 35) {
                throw new UnsupportedOperationException("Schema visible to config are not supported on this AppSearch implementation.");
            }
            for (Map.Entry<String, Set<androidx.appsearch.app.SchemaVisibilityConfig>> entry4 : setSchemaRequest.getSchemasVisibleToConfigs().entrySet()) {
                ApiHelperForV.addSchemaTypeVisibleToConfig(builderM999g, entry4.getKey(), entry4.getValue());
            }
        }
        for (Map.Entry<String, Migrator> entry5 : setSchemaRequest.getMigrators().entrySet()) {
            final Migrator value2 = entry5.getValue();
            builderM999g.setMigrator(entry5.getKey(), new android.app.appsearch.Migrator() { // from class: androidx.appsearch.platformstorage.converter.SetSchemaRequestToPlatformConverter.1
                public GenericDocument onDowngrade(int i, int i2, GenericDocument genericDocument) {
                    androidx.appsearch.app.GenericDocument jetpackGenericDocument = GenericDocumentToPlatformConverter.toJetpackGenericDocument(genericDocument);
                    androidx.appsearch.app.GenericDocument genericDocumentOnDowngrade = value2.onDowngrade(i, i2, jetpackGenericDocument);
                    return jetpackGenericDocument.equals(genericDocumentOnDowngrade) ? genericDocument : GenericDocumentToPlatformConverter.toPlatformGenericDocument(genericDocumentOnDowngrade);
                }

                public GenericDocument onUpgrade(int i, int i2, GenericDocument genericDocument) {
                    androidx.appsearch.app.GenericDocument jetpackGenericDocument = GenericDocumentToPlatformConverter.toJetpackGenericDocument(genericDocument);
                    androidx.appsearch.app.GenericDocument genericDocumentOnUpgrade = value2.onUpgrade(i, i2, jetpackGenericDocument);
                    return jetpackGenericDocument.equals(genericDocumentOnUpgrade) ? genericDocument : GenericDocumentToPlatformConverter.toPlatformGenericDocument(genericDocumentOnUpgrade);
                }

                public boolean shouldMigrate(int i, int i2) {
                    return value2.shouldMigrate(i, i2);
                }
            });
        }
        return builderM999g.setForceOverride(setSchemaRequest.isForceOverride()).setVersion(setSchemaRequest.getVersion()).build();
    }
}
