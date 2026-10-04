package androidx.appsearch.platformstorage.converter;

import android.annotation.SuppressLint;
import android.app.appsearch.AppSearchSchema;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.core.util.Preconditions;
import com.microsoft.identity.common.java.WarningType;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SchemaToPlatformConverter {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(34)
    public static class ApiHelperForU {
        private ApiHelperForU() {
        }

        @DoNotInline
        @SuppressLint({"WrongConstant"})
        public static int getIndexingType(AppSearchSchema.LongPropertyConfig longPropertyConfig) {
            return longPropertyConfig.getIndexingType();
        }

        @DoNotInline
        @SuppressLint({"WrongConstant"})
        public static int getJoinableValueType(AppSearchSchema.StringPropertyConfig stringPropertyConfig) {
            return stringPropertyConfig.getJoinableValueType();
        }

        @DoNotInline
        public static void setIndexingType(AppSearchSchema.LongPropertyConfig.Builder builder, int i) {
            builder.setIndexingType(i);
        }

        @DoNotInline
        public static void setJoinableValueType(AppSearchSchema.StringPropertyConfig.Builder builder, int i) {
            builder.setJoinableValueType(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(35)
    public static class ApiHelperForV {
        private ApiHelperForV() {
        }

        @DoNotInline
        public static void addIndexableNestedProperties(AppSearchSchema.DocumentPropertyConfig.Builder builder, Collection<String> collection) {
            builder.addIndexableNestedProperties(collection);
        }

        @DoNotInline
        @SuppressLint({WarningType.NewApi})
        public static void addParentType(AppSearchSchema.Builder builder, String str) {
            builder.addParentType(str);
        }

        @DoNotInline
        public static List<String> getIndexableNestedProperties(AppSearchSchema.DocumentPropertyConfig documentPropertyConfig) {
            return documentPropertyConfig.getIndexableNestedProperties();
        }

        @DoNotInline
        public static List<String> getParentTypes(AppSearchSchema appSearchSchema) {
            return appSearchSchema.getParentTypes();
        }
    }

    private SchemaToPlatformConverter() {
    }

    @SuppressLint({"WrongConstant"})
    private static AppSearchSchema.PropertyConfig toJetpackProperty(AppSearchSchema.PropertyConfig propertyConfig) {
        Preconditions.checkNotNull(propertyConfig);
        if (AbstractC0566c.m966n(propertyConfig)) {
            AppSearchSchema.StringPropertyConfig stringPropertyConfigM932f = AbstractC0565b.m932f(propertyConfig);
            AppSearchSchema.StringPropertyConfig.Builder tokenizerType = new AppSearchSchema.StringPropertyConfig.Builder(stringPropertyConfigM932f.getName()).setCardinality(stringPropertyConfigM932f.getCardinality()).setIndexingType(stringPropertyConfigM932f.getIndexingType()).setTokenizerType(stringPropertyConfigM932f.getTokenizerType());
            if (Build.VERSION.SDK_INT >= 34) {
                tokenizerType.setJoinableValueType(ApiHelperForU.getJoinableValueType(stringPropertyConfigM932f));
            }
            return tokenizerType.build();
        }
        if (AbstractC0566c.m965m(propertyConfig)) {
            AppSearchSchema.LongPropertyConfig longPropertyConfigM957e = AbstractC0566c.m957e(propertyConfig);
            AppSearchSchema.LongPropertyConfig.Builder cardinality = new AppSearchSchema.LongPropertyConfig.Builder(longPropertyConfigM957e.getName()).setCardinality(longPropertyConfigM957e.getCardinality());
            if (Build.VERSION.SDK_INT >= 34) {
                cardinality.setIndexingType(ApiHelperForU.getIndexingType(longPropertyConfigM957e));
            }
            return cardinality.build();
        }
        if (AbstractC0567d.m980n(propertyConfig)) {
            return new AppSearchSchema.DoublePropertyConfig.Builder(propertyConfig.getName()).setCardinality(propertyConfig.getCardinality()).build();
        }
        if (AbstractC0567d.m985s(propertyConfig)) {
            return new AppSearchSchema.BooleanPropertyConfig.Builder(propertyConfig.getName()).setCardinality(propertyConfig.getCardinality()).build();
        }
        if (AbstractC0567d.m986t(propertyConfig)) {
            return new AppSearchSchema.BytesPropertyConfig.Builder(propertyConfig.getName()).setCardinality(propertyConfig.getCardinality()).build();
        }
        if (AbstractC0567d.m987u(propertyConfig)) {
            AppSearchSchema.DocumentPropertyConfig documentPropertyConfigM931e = AbstractC0565b.m931e(propertyConfig);
            AppSearchSchema.DocumentPropertyConfig.Builder shouldIndexNestedProperties = new AppSearchSchema.DocumentPropertyConfig.Builder(documentPropertyConfigM931e.getName(), documentPropertyConfigM931e.getSchemaType()).setCardinality(documentPropertyConfigM931e.getCardinality()).setShouldIndexNestedProperties(documentPropertyConfigM931e.shouldIndexNestedProperties());
            if (Build.VERSION.SDK_INT >= 35) {
                shouldIndexNestedProperties.addIndexableNestedProperties(ApiHelperForV.getIndexableNestedProperties(documentPropertyConfigM931e));
            }
            return shouldIndexNestedProperties.build();
        }
        throw new IllegalArgumentException("Invalid property type " + propertyConfig.getClass() + ": " + propertyConfig);
    }

    public static androidx.appsearch.app.AppSearchSchema toJetpackSchema(android.app.appsearch.AppSearchSchema appSearchSchema) {
        Preconditions.checkNotNull(appSearchSchema);
        AppSearchSchema.Builder builder = new AppSearchSchema.Builder(appSearchSchema.getSchemaType());
        List properties = appSearchSchema.getProperties();
        if (Build.VERSION.SDK_INT >= 35) {
            List<String> parentTypes = ApiHelperForV.getParentTypes(appSearchSchema);
            for (int i = 0; i < parentTypes.size(); i++) {
                builder.addParentType(parentTypes.get(i));
            }
        }
        for (int i2 = 0; i2 < properties.size(); i2++) {
            builder.addProperty(toJetpackProperty(AbstractC0566c.m958f(properties.get(i2))));
        }
        return builder.build();
    }

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    @SuppressLint({"WrongConstant"})
    private static AppSearchSchema.PropertyConfig toPlatformProperty(AppSearchSchema.PropertyConfig propertyConfig) {
        Preconditions.checkNotNull(propertyConfig);
        if (!propertyConfig.getDescription().isEmpty()) {
            throw new UnsupportedOperationException("SCHEMA_SET_DESCRIPTION is not available on this AppSearch implementation.");
        }
        if (propertyConfig instanceof AppSearchSchema.StringPropertyConfig) {
            AppSearchSchema.StringPropertyConfig stringPropertyConfig = (AppSearchSchema.StringPropertyConfig) propertyConfig;
            AppSearchSchema.StringPropertyConfig.Builder tokenizerType = new AppSearchSchema.StringPropertyConfig.Builder(stringPropertyConfig.getName()).setCardinality(stringPropertyConfig.getCardinality()).setIndexingType(stringPropertyConfig.getIndexingType()).setTokenizerType(stringPropertyConfig.getTokenizerType());
            int i = Build.VERSION.SDK_INT;
            if (i == 33) {
                Preconditions.checkArgumentInRange(stringPropertyConfig.getTokenizerType(), 0, 1, "tokenizerType");
            }
            if (stringPropertyConfig.getJoinableValueType() == 1) {
                if (i < 34) {
                    throw new UnsupportedOperationException("StringPropertyConfig.JOINABLE_VALUE_TYPE_QUALIFIED_ID is not supported on this AppSearch implementation.");
                }
                ApiHelperForU.setJoinableValueType(tokenizerType, stringPropertyConfig.getJoinableValueType());
            }
            if (stringPropertyConfig.getDeletePropagationType() == 0) {
                return tokenizerType.build();
            }
            throw new UnsupportedOperationException("StringPropertyConfig.DELETE_PROPAGATION_TYPE_PROPAGATE_FROM is not supported on this AppSearch implementation.");
        }
        if (propertyConfig instanceof AppSearchSchema.LongPropertyConfig) {
            AppSearchSchema.LongPropertyConfig longPropertyConfig = (AppSearchSchema.LongPropertyConfig) propertyConfig;
            AppSearchSchema.LongPropertyConfig.Builder cardinality = new AppSearchSchema.LongPropertyConfig.Builder(propertyConfig.getName()).setCardinality(propertyConfig.getCardinality());
            if (longPropertyConfig.getIndexingType() == 1) {
                if (Build.VERSION.SDK_INT < 34) {
                    throw new UnsupportedOperationException("LongProperty.INDEXING_TYPE_RANGE is not supported on this AppSearch implementation.");
                }
                ApiHelperForU.setIndexingType(cardinality, longPropertyConfig.getIndexingType());
            }
            if (longPropertyConfig.isScoringEnabled()) {
                throw new UnsupportedOperationException("SCHEMA_SCORABLE_PROPERTY_CONFIG is not available on this AppSearch implementation.");
            }
            return cardinality.build();
        }
        if (propertyConfig instanceof AppSearchSchema.DoublePropertyConfig) {
            if (((AppSearchSchema.DoublePropertyConfig) propertyConfig).isScoringEnabled()) {
                throw new UnsupportedOperationException("SCHEMA_SCORABLE_PROPERTY_CONFIG is not available on this AppSearch implementation.");
            }
            return new AppSearchSchema.DoublePropertyConfig.Builder(propertyConfig.getName()).setCardinality(propertyConfig.getCardinality()).build();
        }
        if (propertyConfig instanceof AppSearchSchema.BooleanPropertyConfig) {
            if (((AppSearchSchema.BooleanPropertyConfig) propertyConfig).isScoringEnabled()) {
                throw new UnsupportedOperationException("SCHEMA_SCORABLE_PROPERTY_CONFIG is not available on this AppSearch implementation.");
            }
            return new AppSearchSchema.BooleanPropertyConfig.Builder(propertyConfig.getName()).setCardinality(propertyConfig.getCardinality()).build();
        }
        if (propertyConfig instanceof AppSearchSchema.BytesPropertyConfig) {
            return new AppSearchSchema.BytesPropertyConfig.Builder(propertyConfig.getName()).setCardinality(propertyConfig.getCardinality()).build();
        }
        if (propertyConfig instanceof AppSearchSchema.DocumentPropertyConfig) {
            AppSearchSchema.DocumentPropertyConfig documentPropertyConfig = (AppSearchSchema.DocumentPropertyConfig) propertyConfig;
            AppSearchSchema.DocumentPropertyConfig.Builder shouldIndexNestedProperties = new AppSearchSchema.DocumentPropertyConfig.Builder(documentPropertyConfig.getName(), documentPropertyConfig.getSchemaType()).setCardinality(documentPropertyConfig.getCardinality()).setShouldIndexNestedProperties(documentPropertyConfig.shouldIndexNestedProperties());
            if (!documentPropertyConfig.getIndexableNestedProperties().isEmpty()) {
                if (Build.VERSION.SDK_INT < 35) {
                    throw new UnsupportedOperationException("DocumentPropertyConfig.addIndexableNestedProperties is not supported on this AppSearch implementation.");
                }
                ApiHelperForV.addIndexableNestedProperties(shouldIndexNestedProperties, documentPropertyConfig.getIndexableNestedProperties());
            }
            return shouldIndexNestedProperties.build();
        }
        if (propertyConfig instanceof AppSearchSchema.EmbeddingPropertyConfig) {
            throw new UnsupportedOperationException("SCHEMA_EMBEDDING_PROPERTY_CONFIG is not available on this AppSearch implementation.");
        }
        if (propertyConfig instanceof AppSearchSchema.BlobHandlePropertyConfig) {
            throw new UnsupportedOperationException("BLOB_STORAGE is not available on this AppSearch implementation.");
        }
        throw new IllegalArgumentException("Invalid dataType: " + propertyConfig.getDataType());
    }

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    public static android.app.appsearch.AppSearchSchema toPlatformSchema(androidx.appsearch.app.AppSearchSchema appSearchSchema) {
        Preconditions.checkNotNull(appSearchSchema);
        AbstractC0566c.m963k();
        AppSearchSchema.Builder builderM954b = AbstractC0566c.m954b(appSearchSchema.getSchemaType());
        if (!appSearchSchema.getDescription().isEmpty()) {
            throw new UnsupportedOperationException("SCHEMA_SET_DESCRIPTION is not available on this AppSearch implementation.");
        }
        if (!appSearchSchema.getParentTypes().isEmpty()) {
            if (Build.VERSION.SDK_INT < 35) {
                throw new UnsupportedOperationException("SCHEMA_ADD_PARENT_TYPE is not available on this AppSearch implementation.");
            }
            List<String> parentTypes = appSearchSchema.getParentTypes();
            for (int i = 0; i < parentTypes.size(); i++) {
                ApiHelperForV.addParentType(builderM954b, parentTypes.get(i));
            }
        }
        List<AppSearchSchema.PropertyConfig> properties = appSearchSchema.getProperties();
        for (int i2 = 0; i2 < properties.size(); i2++) {
            builderM954b.addProperty(toPlatformProperty(properties.get(i2)));
        }
        return builderM954b.build();
    }
}
