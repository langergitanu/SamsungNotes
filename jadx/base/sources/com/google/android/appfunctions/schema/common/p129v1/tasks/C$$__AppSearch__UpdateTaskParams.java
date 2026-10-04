package com.google.android.appfunctions.schema.common.p129v1.tasks;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetBooleanNullableField;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetDateTimeNullableField;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetStringNullableField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetBooleanNullableField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetDateTimeNullableField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringNullableField;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.tasks.$$__AppSearch__UpdateTaskParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__UpdateTaskParams implements DocumentClassFactory<UpdateTaskParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.tasks.UpdateTaskParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SetStringField.class);
        arrayList.add(SetStringNullableField.class);
        arrayList.add(SetBooleanNullableField.class);
        arrayList.add(SetDateTimeNullableField.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("recurrenceSchedule", C$$__AppSearch__SetStringNullableField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("allDay", C$$__AppSearch__SetBooleanNullableField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("dateTime", C$$__AppSearch__SetDateTimeNullableField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("completed", C$$__AppSearch__SetBooleanNullableField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("description", C$$__AppSearch__SetStringNullableField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("title", C$$__AppSearch__SetStringField.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("taskId", 3, 0, 0, 0))))))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public UpdateTaskParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("taskId");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("title");
        SetStringField setStringField = propertyDocument != null ? (SetStringField) propertyDocument.toDocumentClass(SetStringField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("description");
        SetStringNullableField setStringNullableField = propertyDocument2 != null ? (SetStringNullableField) propertyDocument2.toDocumentClass(SetStringNullableField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument3 = genericDocument.getPropertyDocument("completed");
        SetBooleanNullableField setBooleanNullableField = propertyDocument3 != null ? (SetBooleanNullableField) propertyDocument3.toDocumentClass(SetBooleanNullableField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument4 = genericDocument.getPropertyDocument("dateTime");
        SetDateTimeNullableField setDateTimeNullableField = propertyDocument4 != null ? (SetDateTimeNullableField) propertyDocument4.toDocumentClass(SetDateTimeNullableField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument5 = genericDocument.getPropertyDocument("allDay");
        SetBooleanNullableField setBooleanNullableField2 = propertyDocument5 != null ? (SetBooleanNullableField) propertyDocument5.toDocumentClass(SetBooleanNullableField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument6 = genericDocument.getPropertyDocument("recurrenceSchedule");
        return new UpdateTaskParams(namespace, id, str, setStringField, setStringNullableField, setBooleanNullableField, setDateTimeNullableField, setBooleanNullableField2, propertyDocument6 != null ? (SetStringNullableField) propertyDocument6.toDocumentClass(SetStringNullableField.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(UpdateTaskParams updateTaskParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(updateTaskParams.getNamespace(), updateTaskParams.getId(), SCHEMA_NAME);
        String taskId = updateTaskParams.getTaskId();
        if (taskId != null) {
            builder.setPropertyString("taskId", taskId);
        }
        SetStringField title = updateTaskParams.getTitle();
        if (title != null) {
            builder.setPropertyDocument("title", GenericDocument.fromDocumentClass(title));
        }
        SetStringNullableField description = updateTaskParams.getDescription();
        if (description != null) {
            builder.setPropertyDocument("description", GenericDocument.fromDocumentClass(description));
        }
        SetBooleanNullableField completed = updateTaskParams.getCompleted();
        if (completed != null) {
            builder.setPropertyDocument("completed", GenericDocument.fromDocumentClass(completed));
        }
        SetDateTimeNullableField dateTime = updateTaskParams.getDateTime();
        if (dateTime != null) {
            builder.setPropertyDocument("dateTime", GenericDocument.fromDocumentClass(dateTime));
        }
        SetBooleanNullableField allDay = updateTaskParams.getAllDay();
        if (allDay != null) {
            builder.setPropertyDocument("allDay", GenericDocument.fromDocumentClass(allDay));
        }
        SetStringNullableField recurrenceSchedule = updateTaskParams.getRecurrenceSchedule();
        if (recurrenceSchedule != null) {
            builder.setPropertyDocument("recurrenceSchedule", GenericDocument.fromDocumentClass(recurrenceSchedule));
        }
        return builder.build();
    }
}
