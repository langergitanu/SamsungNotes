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

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.calendar.$$__AppSearch__Event, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__Event implements DocumentClassFactory<Event> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.calendar.Event";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(DateTime.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m761c("isOrganizer", 2, AbstractC0541b.m761c("isInPublicCalendar", 2, AbstractC0541b.m761c("isReadOnly", 2, AbstractC0541b.m761c("allDay", 2, AbstractC0541b.m762d("endDate", C$$__AppSearch__DateTime.SCHEMA_NAME, 3, false, AbstractC0541b.m762d("startDate", C$$__AppSearch__DateTime.SCHEMA_NAME, 3, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("title", 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e("description", 2, 0, 0, 0)))).addProperty(AbstractC0541b.m763e("attendeeIds", 1, 0, 0, 0))).addProperty(AbstractC0541b.m763e(Header.LOCATION, 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("recurrenceSchedule", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("eventStatus", 2, 0, 0, 0))))).addProperty(AbstractC0541b.m763e("selfAttendeeStatus", 2, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public Event fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("title");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("description");
        String str2 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("startDate");
        DateTime dateTime = propertyDocument != null ? (DateTime) propertyDocument.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("endDate");
        DateTime dateTime2 = propertyDocument2 != null ? (DateTime) propertyDocument2.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("attendeeIds");
        List listAsList = Collections.EMPTY_LIST;
        if (propertyStringArray3 != null) {
            listAsList = Arrays.asList(propertyStringArray3);
        }
        boolean[] propertyBooleanArray = genericDocument.getPropertyBooleanArray("allDay");
        Boolean boolValueOf = (propertyBooleanArray == null || propertyBooleanArray.length == 0) ? null : Boolean.valueOf(propertyBooleanArray[0]);
        String[] propertyStringArray4 = genericDocument.getPropertyStringArray(Header.LOCATION);
        String str3 = (propertyStringArray4 == null || propertyStringArray4.length == 0) ? null : propertyStringArray4[0];
        String[] propertyStringArray5 = genericDocument.getPropertyStringArray("recurrenceSchedule");
        String str4 = (propertyStringArray5 == null || propertyStringArray5.length == 0) ? null : propertyStringArray5[0];
        String[] propertyStringArray6 = genericDocument.getPropertyStringArray("eventStatus");
        String str5 = (propertyStringArray6 == null || propertyStringArray6.length == 0) ? null : propertyStringArray6[0];
        boolean[] propertyBooleanArray2 = genericDocument.getPropertyBooleanArray("isReadOnly");
        Boolean boolValueOf2 = (propertyBooleanArray2 == null || propertyBooleanArray2.length == 0) ? null : Boolean.valueOf(propertyBooleanArray2[0]);
        boolean[] propertyBooleanArray3 = genericDocument.getPropertyBooleanArray("isInPublicCalendar");
        Boolean boolValueOf3 = (propertyBooleanArray3 == null || propertyBooleanArray3.length == 0) ? null : Boolean.valueOf(propertyBooleanArray3[0]);
        boolean[] propertyBooleanArray4 = genericDocument.getPropertyBooleanArray("isOrganizer");
        Boolean boolValueOf4 = (propertyBooleanArray4 == null || propertyBooleanArray4.length == 0) ? null : Boolean.valueOf(propertyBooleanArray4[0]);
        String[] propertyStringArray7 = genericDocument.getPropertyStringArray("selfAttendeeStatus");
        return new Event(namespace, id, str, str2, dateTime, dateTime2, listAsList, boolValueOf, str3, str4, str5, boolValueOf2, boolValueOf3, boolValueOf4, (propertyStringArray7 == null || propertyStringArray7.length == 0) ? null : propertyStringArray7[0]);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(Event event) {
        GenericDocument.Builder builder = new GenericDocument.Builder(event.getNamespace(), event.getId(), SCHEMA_NAME);
        String title = event.getTitle();
        if (title != null) {
            builder.setPropertyString("title", title);
        }
        String description = event.getDescription();
        if (description != null) {
            builder.setPropertyString("description", description);
        }
        DateTime startDate = event.getStartDate();
        if (startDate != null) {
            builder.setPropertyDocument("startDate", GenericDocument.fromDocumentClass(startDate));
        }
        DateTime endDate = event.getEndDate();
        if (endDate != null) {
            builder.setPropertyDocument("endDate", GenericDocument.fromDocumentClass(endDate));
        }
        List<String> attendeeIds = event.getAttendeeIds();
        if (attendeeIds != null) {
            builder.setPropertyString("attendeeIds", (String[]) attendeeIds.toArray(new String[0]));
        }
        Boolean allDay = event.getAllDay();
        if (allDay != null) {
            builder.setPropertyBoolean("allDay", allDay.booleanValue());
        }
        String location = event.getLocation();
        if (location != null) {
            builder.setPropertyString(Header.LOCATION, location);
        }
        String recurrenceSchedule = event.getRecurrenceSchedule();
        if (recurrenceSchedule != null) {
            builder.setPropertyString("recurrenceSchedule", recurrenceSchedule);
        }
        String eventStatus = event.getEventStatus();
        if (eventStatus != null) {
            builder.setPropertyString("eventStatus", eventStatus);
        }
        Boolean isReadOnly = event.getIsReadOnly();
        if (isReadOnly != null) {
            builder.setPropertyBoolean("isReadOnly", isReadOnly.booleanValue());
        }
        Boolean isInPublicCalendar = event.getIsInPublicCalendar();
        if (isInPublicCalendar != null) {
            builder.setPropertyBoolean("isInPublicCalendar", isInPublicCalendar.booleanValue());
        }
        Boolean isOrganizer = event.getIsOrganizer();
        if (isOrganizer != null) {
            builder.setPropertyBoolean("isOrganizer", isOrganizer.booleanValue());
        }
        String selfAttendeeStatus = event.getSelfAttendeeStatus();
        if (selfAttendeeStatus != null) {
            builder.setPropertyString("selfAttendeeStatus", selfAttendeeStatus);
        }
        return builder.build();
    }
}
