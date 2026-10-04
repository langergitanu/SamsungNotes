package com.google.android.appfunctions.schema.common.p129v1.notes;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__DateTime;
import com.google.android.appfunctions.schema.common.p129v1.types.DateTime;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.notes.$$__AppSearch__FindNotesParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__FindNotesParams implements DocumentClassFactory<FindNotesParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.notes.FindNotesParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(DateTime.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m764f("maxCount", 3, 0, AbstractC0541b.m762d("endDate", C$$__AppSearch__DateTime.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("startDate", C$$__AppSearch__DateTime.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("query", 2, 0, 0, 0)))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public FindNotesParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("query");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("startDate");
        DateTime dateTime = propertyDocument != null ? (DateTime) propertyDocument.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("endDate");
        return new FindNotesParams(namespace, id, str, dateTime, propertyDocument2 != null ? (DateTime) propertyDocument2.toDocumentClass(DateTime.class, documentClassMappingContext) : null, (int) genericDocument.getPropertyLong("maxCount"));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(FindNotesParams findNotesParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(findNotesParams.getNamespace(), findNotesParams.getId(), SCHEMA_NAME);
        String query = findNotesParams.getQuery();
        if (query != null) {
            builder.setPropertyString("query", query);
        }
        DateTime startDate = findNotesParams.getStartDate();
        if (startDate != null) {
            builder.setPropertyDocument("startDate", GenericDocument.fromDocumentClass(startDate));
        }
        DateTime endDate = findNotesParams.getEndDate();
        if (endDate != null) {
            builder.setPropertyDocument("endDate", GenericDocument.fromDocumentClass(endDate));
        }
        builder.setPropertyLong("maxCount", findNotesParams.getMaxCount());
        return builder.build();
    }
}
