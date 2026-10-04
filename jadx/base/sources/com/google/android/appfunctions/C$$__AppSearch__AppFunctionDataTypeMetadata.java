package com.google.android.appfunctions;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.$$__AppSearch__AppFunctionDataTypeMetadata, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__AppFunctionDataTypeMetadata implements DocumentClassFactory<AppFunctionDataTypeMetadata> {
    public static final String SCHEMA_NAME = "AppFunctionDataTypeMetadata";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m761c("isNullable", 2, AbstractC0541b.m761c("isList", 2, AbstractC0541b.m760b("dataType", 2, 0, new AppSearchSchema.Builder(SCHEMA_NAME)))).addProperty(AbstractC0541b.m763e("documentType", 2, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppFunctionDataTypeMetadata fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String id = genericDocument.getId();
        String namespace = genericDocument.getNamespace();
        int propertyLong = (int) genericDocument.getPropertyLong("dataType");
        boolean propertyBoolean = genericDocument.getPropertyBoolean("isList");
        boolean propertyBoolean2 = genericDocument.getPropertyBoolean("isNullable");
        String[] propertyStringArray = genericDocument.getPropertyStringArray("documentType");
        return new AppFunctionDataTypeMetadata(id, namespace, propertyLong, propertyBoolean, propertyBoolean2, (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0]);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(AppFunctionDataTypeMetadata appFunctionDataTypeMetadata) {
        GenericDocument.Builder builder = new GenericDocument.Builder(appFunctionDataTypeMetadata.getNamespace(), appFunctionDataTypeMetadata.getId(), SCHEMA_NAME);
        builder.setPropertyLong("dataType", appFunctionDataTypeMetadata.getDataType());
        builder.setPropertyBoolean("isList", appFunctionDataTypeMetadata.getIsList());
        builder.setPropertyBoolean("isNullable", appFunctionDataTypeMetadata.getIsNullable());
        String documentType = appFunctionDataTypeMetadata.getDocumentType();
        if (documentType != null) {
            builder.setPropertyString("documentType", documentType);
        }
        return builder.build();
    }
}
