package com.google.android.appfunctions.schema.common.p129v1.clock;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__Date;
import com.google.android.appfunctions.schema.common.p129v1.types.Date;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.clock.$$__AppSearch__DayPattern, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__DayPattern implements DocumentClassFactory<DayPattern> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.clock.DayPattern";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(Date.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m762d("date", C$$__AppSearch__Date.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME)).addProperty(AbstractC0541b.m763e("recurrencePattern", 2, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public DayPattern fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("date");
        String str = null;
        Date date = propertyDocument != null ? (Date) propertyDocument.toDocumentClass(Date.class, documentClassMappingContext) : null;
        String[] propertyStringArray = genericDocument.getPropertyStringArray("recurrencePattern");
        if (propertyStringArray != null && propertyStringArray.length != 0) {
            str = propertyStringArray[0];
        }
        return new DayPattern(namespace, id, date, str);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(DayPattern dayPattern) {
        GenericDocument.Builder builder = new GenericDocument.Builder(dayPattern.getNamespace(), dayPattern.getId(), SCHEMA_NAME);
        Date date = dayPattern.getDate();
        if (date != null) {
            builder.setPropertyDocument("date", GenericDocument.fromDocumentClass(date));
        }
        String recurrencePattern = dayPattern.getRecurrencePattern();
        if (recurrencePattern != null) {
            builder.setPropertyString("recurrencePattern", recurrencePattern);
        }
        return builder.build();
    }
}
