package com.google.android.appfunctions.schema.common.p129v1.types;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.types.$$__AppSearch__SetIntNullableField, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__SetIntNullableField implements DocumentClassFactory<SetIntNullableField> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.types.SetIntNullableField";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m764f("value", 2, 0, new AppSearchSchema.Builder(SCHEMA_NAME));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public SetIntNullableField fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        long[] propertyLongArray = genericDocument.getPropertyLongArray("value");
        return new SetIntNullableField(namespace, id, (propertyLongArray == null || propertyLongArray.length == 0) ? null : Integer.valueOf((int) propertyLongArray[0]));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(SetIntNullableField setIntNullableField) {
        GenericDocument.Builder builder = new GenericDocument.Builder(setIntNullableField.getNamespace(), setIntNullableField.getId(), SCHEMA_NAME);
        if (setIntNullableField.getValue() != null) {
            builder.setPropertyLong("value", r5.intValue());
        }
        return builder.build();
    }
}
