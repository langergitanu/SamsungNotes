package com.google.android.appfunctions.schema.common.p129v1.types;

import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.types.$$__AppSearch__SetFloatField, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__SetFloatField implements DocumentClassFactory<SetFloatField> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.types.SetFloatField";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(new AppSearchSchema.DoublePropertyConfig.Builder("value").setCardinality(3).build()).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public SetFloatField fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        return new SetFloatField(genericDocument.getNamespace(), genericDocument.getId(), (float) genericDocument.getPropertyDouble("value"));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(SetFloatField setFloatField) {
        GenericDocument.Builder builder = new GenericDocument.Builder(setFloatField.getNamespace(), setFloatField.getId(), SCHEMA_NAME);
        builder.setPropertyDouble("value", setFloatField.getValue().floatValue());
        return builder.build();
    }
}
