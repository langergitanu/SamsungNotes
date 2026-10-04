package com.google.android.appfunctions.schema.common.p129v1.clock;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.clock.$$__AppSearch__SetDayPatternField, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__SetDayPatternField implements DocumentClassFactory<SetDayPatternField> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.clock.SetDayPatternField";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(DayPattern.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("value", C$$__AppSearch__DayPattern.SCHEMA_NAME, 3, false, new AppSearchSchema.Builder(SCHEMA_NAME));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public SetDayPatternField fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("value");
        return new SetDayPatternField(namespace, id, propertyDocument != null ? (DayPattern) propertyDocument.toDocumentClass(DayPattern.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(SetDayPatternField setDayPatternField) {
        GenericDocument.Builder builder = new GenericDocument.Builder(setDayPatternField.getNamespace(), setDayPatternField.getId(), SCHEMA_NAME);
        DayPattern value = setDayPatternField.getValue();
        if (value != null) {
            builder.setPropertyDocument("value", GenericDocument.fromDocumentClass(value));
        }
        return builder.build();
    }
}
