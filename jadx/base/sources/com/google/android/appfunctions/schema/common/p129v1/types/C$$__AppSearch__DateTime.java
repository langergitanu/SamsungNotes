package com.google.android.appfunctions.schema.common.p129v1.types;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.types.$$__AppSearch__DateTime, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__DateTime implements DocumentClassFactory<DateTime> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.types.DateTime";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Date.class);
        arrayList.add(TimeOfDay.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("timeOfDay", C$$__AppSearch__TimeOfDay.SCHEMA_NAME, 3, false, AbstractC0541b.m762d("date", C$$__AppSearch__Date.SCHEMA_NAME, 3, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("timeZone", 3, 0, 0, 0))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public DateTime fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("timeZone");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("date");
        Date date = propertyDocument != null ? (Date) propertyDocument.toDocumentClass(Date.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("timeOfDay");
        return new DateTime(namespace, id, str, date, propertyDocument2 != null ? (TimeOfDay) propertyDocument2.toDocumentClass(TimeOfDay.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(DateTime dateTime) {
        GenericDocument.Builder builder = new GenericDocument.Builder(dateTime.getNamespace(), dateTime.getId(), SCHEMA_NAME);
        String timeZone = dateTime.getTimeZone();
        if (timeZone != null) {
            builder.setPropertyString("timeZone", timeZone);
        }
        Date date = dateTime.getDate();
        if (date != null) {
            builder.setPropertyDocument("date", GenericDocument.fromDocumentClass(date));
        }
        TimeOfDay timeOfDay = dateTime.getTimeOfDay();
        if (timeOfDay != null) {
            builder.setPropertyDocument("timeOfDay", GenericDocument.fromDocumentClass(timeOfDay));
        }
        return builder.build();
    }
}
