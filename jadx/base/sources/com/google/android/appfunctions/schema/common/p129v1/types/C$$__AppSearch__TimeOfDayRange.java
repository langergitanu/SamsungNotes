package com.google.android.appfunctions.schema.common.p129v1.types;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.types.$$__AppSearch__TimeOfDayRange, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__TimeOfDayRange implements DocumentClassFactory<TimeOfDayRange> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.types.TimeOfDayRange";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(TimeOfDay.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("endTime", C$$__AppSearch__TimeOfDay.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("startTime", C$$__AppSearch__TimeOfDay.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME)));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public TimeOfDayRange fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("startTime");
        TimeOfDay timeOfDay = propertyDocument != null ? (TimeOfDay) propertyDocument.toDocumentClass(TimeOfDay.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("endTime");
        return new TimeOfDayRange(namespace, id, timeOfDay, propertyDocument2 != null ? (TimeOfDay) propertyDocument2.toDocumentClass(TimeOfDay.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(TimeOfDayRange timeOfDayRange) {
        GenericDocument.Builder builder = new GenericDocument.Builder(timeOfDayRange.getNamespace(), timeOfDayRange.getId(), SCHEMA_NAME);
        TimeOfDay startTime = timeOfDayRange.getStartTime();
        if (startTime != null) {
            builder.setPropertyDocument("startTime", GenericDocument.fromDocumentClass(startTime));
        }
        TimeOfDay endTime = timeOfDayRange.getEndTime();
        if (endTime != null) {
            builder.setPropertyDocument("endTime", GenericDocument.fromDocumentClass(endTime));
        }
        return builder.build();
    }
}
