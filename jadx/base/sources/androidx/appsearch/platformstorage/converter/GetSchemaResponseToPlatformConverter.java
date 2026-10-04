package androidx.appsearch.platformstorage.converter;

import android.app.appsearch.GetSchemaResponse;
import android.app.appsearch.PackageIdentifier;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.app.GetSchemaResponse;
import androidx.appsearch.app.SchemaVisibilityConfig;
import androidx.appsearch.platformstorage.AbstractC0560a;
import androidx.appsearch.platformstorage.AbstractC0573h;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class GetSchemaResponseToPlatformConverter {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(33)
    public static class ApiHelperForT {
        private ApiHelperForT() {
        }

        @DoNotInline
        public static Map<String, Set<Set<Integer>>> getRequiredPermissionsForSchemaTypeVisibility(GetSchemaResponse getSchemaResponse) {
            return getSchemaResponse.getRequiredPermissionsForSchemaTypeVisibility();
        }

        @DoNotInline
        public static Set<String> getSchemaTypesNotDisplayedBySystem(GetSchemaResponse getSchemaResponse) {
            return getSchemaResponse.getSchemaTypesNotDisplayedBySystem();
        }

        @DoNotInline
        public static Map<String, Set<PackageIdentifier>> getSchemaTypesVisibleToPackage(GetSchemaResponse getSchemaResponse) {
            return getSchemaResponse.getSchemaTypesVisibleToPackages();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(35)
    public static class ApiHelperForV {
        private ApiHelperForV() {
        }

        @DoNotInline
        public static Map<String, androidx.appsearch.app.PackageIdentifier> getPubliclyVisibleSchemas(GetSchemaResponse getSchemaResponse) {
            Map publiclyVisibleSchemas = getSchemaResponse.getPubliclyVisibleSchemas();
            if (publiclyVisibleSchemas.isEmpty()) {
                return Collections.EMPTY_MAP;
            }
            ArrayMap arrayMap = new ArrayMap(publiclyVisibleSchemas.size());
            for (Map.Entry entry : publiclyVisibleSchemas.entrySet()) {
                arrayMap.put((String) entry.getKey(), new androidx.appsearch.app.PackageIdentifier(AbstractC0573h.m1061i(entry.getValue()).getPackageName(), AbstractC0573h.m1061i(entry.getValue()).getSha256Certificate()));
            }
            return arrayMap;
        }

        @DoNotInline
        public static Map<String, Set<SchemaVisibilityConfig>> getSchemasVisibleToConfigs(GetSchemaResponse getSchemaResponse) {
            Map schemaTypesVisibleToConfigs = getSchemaResponse.getSchemaTypesVisibleToConfigs();
            if (schemaTypesVisibleToConfigs.isEmpty()) {
                return Collections.EMPTY_MAP;
            }
            ArrayMap arrayMap = new ArrayMap(schemaTypesVisibleToConfigs.size());
            for (Map.Entry entry : schemaTypesVisibleToConfigs.entrySet()) {
                ArraySet arraySet = new ArraySet(((Set) entry.getValue()).size());
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    arraySet.add(toJetpackSchemaVisibilityConfig(AbstractC0560a.m871e(it.next())));
                }
                arrayMap.put((String) entry.getKey(), arraySet);
            }
            return arrayMap;
        }

        private static SchemaVisibilityConfig toJetpackSchemaVisibilityConfig(android.app.appsearch.SchemaVisibilityConfig schemaVisibilityConfig) {
            Preconditions.checkNotNull(schemaVisibilityConfig);
            SchemaVisibilityConfig.Builder builder = new SchemaVisibilityConfig.Builder();
            List allowedPackages = schemaVisibilityConfig.getAllowedPackages();
            for (int i = 0; i < allowedPackages.size(); i++) {
                builder.addAllowedPackage(new androidx.appsearch.app.PackageIdentifier(AbstractC0573h.m1061i(allowedPackages.get(i)).getPackageName(), AbstractC0573h.m1061i(allowedPackages.get(i)).getSha256Certificate()));
            }
            Iterator it = schemaVisibilityConfig.getRequiredPermissions().iterator();
            while (it.hasNext()) {
                builder.addRequiredPermissions((Set) it.next());
            }
            PackageIdentifier publiclyVisibleTargetPackage = schemaVisibilityConfig.getPubliclyVisibleTargetPackage();
            if (publiclyVisibleTargetPackage != null) {
                builder.setPubliclyVisibleTargetPackage(new androidx.appsearch.app.PackageIdentifier(publiclyVisibleTargetPackage.getPackageName(), publiclyVisibleTargetPackage.getSha256Certificate()));
            }
            return builder.build();
        }
    }

    private GetSchemaResponseToPlatformConverter() {
    }

    @RequiresApi(33)
    private static void convertSchemasVisibleToPackages(GetSchemaResponse getSchemaResponse, GetSchemaResponse.Builder builder) {
        Map<String, Set<PackageIdentifier>> schemaTypesVisibleToPackage = ApiHelperForT.getSchemaTypesVisibleToPackage(getSchemaResponse);
        if (schemaTypesVisibleToPackage != null) {
            for (Map.Entry<String, Set<PackageIdentifier>> entry : schemaTypesVisibleToPackage.entrySet()) {
                ArraySet arraySet = new ArraySet(entry.getValue().size());
                Iterator<PackageIdentifier> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    PackageIdentifier packageIdentifierM1061i = AbstractC0573h.m1061i(it.next());
                    arraySet.add(new androidx.appsearch.app.PackageIdentifier(packageIdentifierM1061i.getPackageName(), packageIdentifierM1061i.getSha256Certificate()));
                }
                builder.setSchemaTypeVisibleToPackages(entry.getKey(), arraySet);
            }
        }
    }

    public static androidx.appsearch.app.GetSchemaResponse toJetpackGetSchemaResponse(android.app.appsearch.GetSchemaResponse getSchemaResponse) {
        Preconditions.checkNotNull(getSchemaResponse);
        GetSchemaResponse.Builder builder = new GetSchemaResponse.Builder();
        if (Build.VERSION.SDK_INT < 33) {
            builder.setVisibilitySettingSupported(false);
        }
        Iterator it = getSchemaResponse.getSchemas().iterator();
        while (it.hasNext()) {
            builder.addSchema(SchemaToPlatformConverter.toJetpackSchema(AbstractC0573h.m1055c(it.next())));
        }
        builder.setVersion(getSchemaResponse.getVersion());
        if (Build.VERSION.SDK_INT >= 33) {
            Iterator<String> it2 = ApiHelperForT.getSchemaTypesNotDisplayedBySystem(getSchemaResponse).iterator();
            while (it2.hasNext()) {
                builder.addSchemaTypeNotDisplayedBySystem(it2.next());
            }
            convertSchemasVisibleToPackages(getSchemaResponse, builder);
            for (Map.Entry<String, Set<Set<Integer>>> entry : ApiHelperForT.getRequiredPermissionsForSchemaTypeVisibility(getSchemaResponse).entrySet()) {
                builder.setRequiredPermissionsForSchemaTypeVisibility(entry.getKey(), entry.getValue());
            }
        }
        if (Build.VERSION.SDK_INT >= 35) {
            Map<String, androidx.appsearch.app.PackageIdentifier> publiclyVisibleSchemas = ApiHelperForV.getPubliclyVisibleSchemas(getSchemaResponse);
            if (!publiclyVisibleSchemas.isEmpty()) {
                for (Map.Entry<String, androidx.appsearch.app.PackageIdentifier> entry2 : publiclyVisibleSchemas.entrySet()) {
                    builder.setPubliclyVisibleSchema(entry2.getKey(), entry2.getValue());
                }
            }
            Map<String, Set<SchemaVisibilityConfig>> schemasVisibleToConfigs = ApiHelperForV.getSchemasVisibleToConfigs(getSchemaResponse);
            if (!schemasVisibleToConfigs.isEmpty()) {
                for (Map.Entry<String, Set<SchemaVisibilityConfig>> entry3 : schemasVisibleToConfigs.entrySet()) {
                    builder.setSchemaTypeVisibleToConfigs(entry3.getKey(), entry3.getValue());
                }
            }
        }
        return builder.build();
    }
}
