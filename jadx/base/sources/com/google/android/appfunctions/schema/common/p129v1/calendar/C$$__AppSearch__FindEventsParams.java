package com.google.android.appfunctions.schema.common.p129v1.calendar;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__DateTime;
import com.google.android.appfunctions.schema.common.p129v1.types.DateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.calendar.$$__AppSearch__FindEventsParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__FindEventsParams implements DocumentClassFactory<FindEventsParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.calendar.FindEventsParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(DateTime.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m760b("maxCount", 3, 0, AbstractC0541b.m762d("endDate", C$$__AppSearch__DateTime.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("startDate", C$$__AppSearch__DateTime.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME))).addProperty(AbstractC0541b.m763e("query", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("attendeeIds", 1, 0, 0, 0))).addProperty(AbstractC0541b.m763e("orderBy", 2, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public FindEventsParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("startDate");
        String str = null;
        DateTime dateTime = propertyDocument != null ? (DateTime) propertyDocument.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("endDate");
        DateTime dateTime2 = propertyDocument2 != null ? (DateTime) propertyDocument2.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        String[] propertyStringArray = genericDocument.getPropertyStringArray("query");
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("attendeeIds");
        List listAsList = Collections.EMPTY_LIST;
        if (propertyStringArray2 != null) {
            listAsList = Arrays.asList(propertyStringArray2);
        }
        List list = listAsList;
        int propertyLong = (int) genericDocument.getPropertyLong("maxCount");
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("orderBy");
        if (propertyStringArray3 != null && propertyStringArray3.length != 0) {
            str = propertyStringArray3[0];
        }
        return new FindEventsParams(namespace, id, dateTime, dateTime2, str2, list, propertyLong, str);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(FindEventsParams findEventsParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(findEventsParams.getNamespace(), findEventsParams.getId(), SCHEMA_NAME);
        DateTime startDate = findEventsParams.getStartDate();
        if (startDate != null) {
            builder.setPropertyDocument("startDate", GenericDocument.fromDocumentClass(startDate));
        }
        DateTime endDate = findEventsParams.getEndDate();
        if (endDate != null) {
            builder.setPropertyDocument("endDate", GenericDocument.fromDocumentClass(endDate));
        }
        String query = findEventsParams.getQuery();
        if (query != null) {
            builder.setPropertyString("query", query);
        }
        List<String> attendeeIds = findEventsParams.getAttendeeIds();
        if (attendeeIds != null) {
            builder.setPropertyString("attendeeIds", (String[]) attendeeIds.toArray(new String[0]));
        }
        builder.setPropertyLong("maxCount", findEventsParams.getMaxCount());
        String orderBy = findEventsParams.getOrderBy();
        if (orderBy != null) {
            builder.setPropertyString("orderBy", orderBy);
        }
        return builder.build();
    }
}
