package com.google.android.appfunctions.schema.common.p129v1.calendar;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__DateTime;
import com.google.android.appfunctions.schema.common.p129v1.types.DateTime;
import com.samsung.scsp.common.Header;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.calendar.$$__AppSearch__CreateEventParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__CreateEventParams implements DocumentClassFactory<CreateEventParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.calendar.CreateEventParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(DateTime.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m761c("allDay", 2, AbstractC0541b.m762d("endDate", C$$__AppSearch__DateTime.SCHEMA_NAME, 3, false, AbstractC0541b.m762d("startDate", C$$__AppSearch__DateTime.SCHEMA_NAME, 3, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("title", 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e("description", 2, 0, 0, 0)))).addProperty(AbstractC0541b.m763e("attendeeIds", 1, 0, 0, 0))).addProperty(AbstractC0541b.m763e(Header.LOCATION, 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("recurrenceSchedule", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("eventStatus", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("externalId", 2, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public CreateEventParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("title");
        String str = null;
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("description");
        String str3 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("startDate");
        DateTime dateTime = propertyDocument != null ? (DateTime) propertyDocument.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("endDate");
        DateTime dateTime2 = propertyDocument2 != null ? (DateTime) propertyDocument2.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("attendeeIds");
        List listAsList = Collections.EMPTY_LIST;
        if (propertyStringArray3 != null) {
            listAsList = Arrays.asList(propertyStringArray3);
        }
        List list = listAsList;
        boolean[] propertyBooleanArray = genericDocument.getPropertyBooleanArray("allDay");
        Boolean boolValueOf = (propertyBooleanArray == null || propertyBooleanArray.length == 0) ? null : Boolean.valueOf(propertyBooleanArray[0]);
        String[] propertyStringArray4 = genericDocument.getPropertyStringArray(Header.LOCATION);
        String str4 = (propertyStringArray4 == null || propertyStringArray4.length == 0) ? null : propertyStringArray4[0];
        String[] propertyStringArray5 = genericDocument.getPropertyStringArray("recurrenceSchedule");
        String str5 = (propertyStringArray5 == null || propertyStringArray5.length == 0) ? null : propertyStringArray5[0];
        String[] propertyStringArray6 = genericDocument.getPropertyStringArray("eventStatus");
        String str6 = (propertyStringArray6 == null || propertyStringArray6.length == 0) ? null : propertyStringArray6[0];
        String[] propertyStringArray7 = genericDocument.getPropertyStringArray("externalId");
        if (propertyStringArray7 != null && propertyStringArray7.length != 0) {
            str = propertyStringArray7[0];
        }
        return new CreateEventParams(namespace, id, str2, str3, dateTime, dateTime2, list, boolValueOf, str4, str5, str6, str);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(CreateEventParams createEventParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(createEventParams.getNamespace(), createEventParams.getId(), SCHEMA_NAME);
        String title = createEventParams.getTitle();
        if (title != null) {
            builder.setPropertyString("title", title);
        }
        String description = createEventParams.getDescription();
        if (description != null) {
            builder.setPropertyString("description", description);
        }
        DateTime startDate = createEventParams.getStartDate();
        if (startDate != null) {
            builder.setPropertyDocument("startDate", GenericDocument.fromDocumentClass(startDate));
        }
        DateTime endDate = createEventParams.getEndDate();
        if (endDate != null) {
            builder.setPropertyDocument("endDate", GenericDocument.fromDocumentClass(endDate));
        }
        List<String> attendeeIds = createEventParams.getAttendeeIds();
        if (attendeeIds != null) {
            builder.setPropertyString("attendeeIds", (String[]) attendeeIds.toArray(new String[0]));
        }
        Boolean allDay = createEventParams.getAllDay();
        if (allDay != null) {
            builder.setPropertyBoolean("allDay", allDay.booleanValue());
        }
        String location = createEventParams.getLocation();
        if (location != null) {
            builder.setPropertyString(Header.LOCATION, location);
        }
        String recurrenceSchedule = createEventParams.getRecurrenceSchedule();
        if (recurrenceSchedule != null) {
            builder.setPropertyString("recurrenceSchedule", recurrenceSchedule);
        }
        String eventStatus = createEventParams.getEventStatus();
        if (eventStatus != null) {
            builder.setPropertyString("eventStatus", eventStatus);
        }
        String externalId = createEventParams.getExternalId();
        if (externalId != null) {
            builder.setPropertyString("externalId", externalId);
        }
        return builder.build();
    }
}
