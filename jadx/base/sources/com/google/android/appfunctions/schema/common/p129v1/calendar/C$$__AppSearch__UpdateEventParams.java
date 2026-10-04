package com.google.android.appfunctions.schema.common.p129v1.calendar;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetBooleanField;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetDateTimeField;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetStringListField;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetStringNullableField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetBooleanField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetDateTimeField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringListField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringNullableField;
import com.samsung.scsp.common.Header;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.calendar.$$__AppSearch__UpdateEventParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__UpdateEventParams implements DocumentClassFactory<UpdateEventParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.calendar.UpdateEventParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SetStringField.class);
        arrayList.add(SetStringNullableField.class);
        arrayList.add(SetDateTimeField.class);
        arrayList.add(SetStringListField.class);
        arrayList.add(SetBooleanField.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("eventStatus", C$$__AppSearch__SetStringField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("recurrenceSchedule", C$$__AppSearch__SetStringNullableField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d(Header.LOCATION, C$$__AppSearch__SetStringNullableField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("allDay", C$$__AppSearch__SetBooleanField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("attendeeIds", C$$__AppSearch__SetStringListField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("endDate", C$$__AppSearch__SetDateTimeField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("startDate", C$$__AppSearch__SetDateTimeField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("description", C$$__AppSearch__SetStringNullableField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("title", C$$__AppSearch__SetStringField.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("eventId", 3, 0, 0, 0)))))))))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public UpdateEventParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("eventId");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("title");
        SetStringField setStringField = propertyDocument != null ? (SetStringField) propertyDocument.toDocumentClass(SetStringField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("description");
        SetStringNullableField setStringNullableField = propertyDocument2 != null ? (SetStringNullableField) propertyDocument2.toDocumentClass(SetStringNullableField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument3 = genericDocument.getPropertyDocument("startDate");
        SetDateTimeField setDateTimeField = propertyDocument3 != null ? (SetDateTimeField) propertyDocument3.toDocumentClass(SetDateTimeField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument4 = genericDocument.getPropertyDocument("endDate");
        SetDateTimeField setDateTimeField2 = propertyDocument4 != null ? (SetDateTimeField) propertyDocument4.toDocumentClass(SetDateTimeField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument5 = genericDocument.getPropertyDocument("attendeeIds");
        SetStringListField setStringListField = propertyDocument5 != null ? (SetStringListField) propertyDocument5.toDocumentClass(SetStringListField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument6 = genericDocument.getPropertyDocument("allDay");
        SetBooleanField setBooleanField = propertyDocument6 != null ? (SetBooleanField) propertyDocument6.toDocumentClass(SetBooleanField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument7 = genericDocument.getPropertyDocument(Header.LOCATION);
        SetStringNullableField setStringNullableField2 = propertyDocument7 != null ? (SetStringNullableField) propertyDocument7.toDocumentClass(SetStringNullableField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument8 = genericDocument.getPropertyDocument("recurrenceSchedule");
        SetStringNullableField setStringNullableField3 = propertyDocument8 != null ? (SetStringNullableField) propertyDocument8.toDocumentClass(SetStringNullableField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument9 = genericDocument.getPropertyDocument("eventStatus");
        return new UpdateEventParams(namespace, id, str, setStringField, setStringNullableField, setDateTimeField, setDateTimeField2, setStringListField, setBooleanField, setStringNullableField2, setStringNullableField3, propertyDocument9 != null ? (SetStringField) propertyDocument9.toDocumentClass(SetStringField.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(UpdateEventParams updateEventParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(updateEventParams.getNamespace(), updateEventParams.getId(), SCHEMA_NAME);
        String eventId = updateEventParams.getEventId();
        if (eventId != null) {
            builder.setPropertyString("eventId", eventId);
        }
        SetStringField title = updateEventParams.getTitle();
        if (title != null) {
            builder.setPropertyDocument("title", GenericDocument.fromDocumentClass(title));
        }
        SetStringNullableField description = updateEventParams.getDescription();
        if (description != null) {
            builder.setPropertyDocument("description", GenericDocument.fromDocumentClass(description));
        }
        SetDateTimeField startDate = updateEventParams.getStartDate();
        if (startDate != null) {
            builder.setPropertyDocument("startDate", GenericDocument.fromDocumentClass(startDate));
        }
        SetDateTimeField endDate = updateEventParams.getEndDate();
        if (endDate != null) {
            builder.setPropertyDocument("endDate", GenericDocument.fromDocumentClass(endDate));
        }
        SetStringListField attendeeIds = updateEventParams.getAttendeeIds();
        if (attendeeIds != null) {
            builder.setPropertyDocument("attendeeIds", GenericDocument.fromDocumentClass(attendeeIds));
        }
        SetBooleanField allDay = updateEventParams.getAllDay();
        if (allDay != null) {
            builder.setPropertyDocument("allDay", GenericDocument.fromDocumentClass(allDay));
        }
        SetStringNullableField location = updateEventParams.getLocation();
        if (location != null) {
            builder.setPropertyDocument(Header.LOCATION, GenericDocument.fromDocumentClass(location));
        }
        SetStringNullableField recurrenceSchedule = updateEventParams.getRecurrenceSchedule();
        if (recurrenceSchedule != null) {
            builder.setPropertyDocument("recurrenceSchedule", GenericDocument.fromDocumentClass(recurrenceSchedule));
        }
        SetStringField eventStatus = updateEventParams.getEventStatus();
        if (eventStatus != null) {
            builder.setPropertyDocument("eventStatus", GenericDocument.fromDocumentClass(eventStatus));
        }
        return builder.build();
    }
}
