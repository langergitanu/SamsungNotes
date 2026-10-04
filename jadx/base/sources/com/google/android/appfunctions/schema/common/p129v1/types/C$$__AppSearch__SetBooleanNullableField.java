package com.google.android.appfunctions.schema.common.p129v1.types;

import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.types.$$__AppSearch__SetBooleanNullableField, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__SetBooleanNullableField implements DocumentClassFactory<SetBooleanNullableField> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.types.SetBooleanNullableField";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(new AppSearchSchema.BooleanPropertyConfig.Builder("value").setCardinality(2).build()).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public SetBooleanNullableField fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        boolean[] propertyBooleanArray = genericDocument.getPropertyBooleanArray("value");
        return new SetBooleanNullableField(namespace, id, (propertyBooleanArray == null || propertyBooleanArray.length == 0) ? null : Boolean.valueOf(propertyBooleanArray[0]));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(SetBooleanNullableField setBooleanNullableField) {
        GenericDocument.Builder builder = new GenericDocument.Builder(setBooleanNullableField.getNamespace(), setBooleanNullableField.getId(), SCHEMA_NAME);
        Boolean value = setBooleanNullableField.getValue();
        if (value != null) {
            builder.setPropertyBoolean("value", value.booleanValue());
        }
        return builder.build();
    }
}
