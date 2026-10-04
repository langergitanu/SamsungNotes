package com.google.android.appfunctions;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.$$__AppSearch__AppFunctionParameterMetadata, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__AppFunctionParameterMetadata implements DocumentClassFactory<AppFunctionParameterMetadata> {
    public static final String SCHEMA_NAME = "AppFunctionParameterMetadata";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(AppFunctionDataTypeMetadata.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("parameterType", C$$__AppSearch__AppFunctionDataTypeMetadata.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("name", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("description", 2, 0, 0, 0)));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppFunctionParameterMetadata fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String id = genericDocument.getId();
        String namespace = genericDocument.getNamespace();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("name");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("description");
        String str2 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("parameterType");
        return new AppFunctionParameterMetadata(id, namespace, str, str2, propertyDocument != null ? (AppFunctionDataTypeMetadata) propertyDocument.toDocumentClass(AppFunctionDataTypeMetadata.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(AppFunctionParameterMetadata appFunctionParameterMetadata) {
        GenericDocument.Builder builder = new GenericDocument.Builder(appFunctionParameterMetadata.getNamespace(), appFunctionParameterMetadata.getId(), SCHEMA_NAME);
        String name = appFunctionParameterMetadata.getName();
        if (name != null) {
            builder.setPropertyString("name", name);
        }
        String description = appFunctionParameterMetadata.getDescription();
        if (description != null) {
            builder.setPropertyString("description", description);
        }
        AppFunctionDataTypeMetadata parameterType = appFunctionParameterMetadata.getParameterType();
        if (parameterType != null) {
            builder.setPropertyDocument("parameterType", GenericDocument.fromDocumentClass(parameterType));
        }
        return builder.build();
    }
}
