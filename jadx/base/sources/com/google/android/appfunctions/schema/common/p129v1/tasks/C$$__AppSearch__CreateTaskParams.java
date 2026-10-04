package com.google.android.appfunctions.schema.common.p129v1.tasks;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__DateTime;
import com.google.android.appfunctions.schema.common.p129v1.types.DateTime;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.tasks.$$__AppSearch__CreateTaskParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__CreateTaskParams implements DocumentClassFactory<CreateTaskParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.tasks.CreateTaskParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(DateTime.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m761c("allDay", 2, AbstractC0541b.m762d("dateTime", C$$__AppSearch__DateTime.SCHEMA_NAME, 2, false, AbstractC0541b.m761c("completed", 2, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("title", 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e("description", 2, 0, 0, 0))))).addProperty(AbstractC0541b.m763e("recurrenceSchedule", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("externalId", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("taskCategoryId", 2, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public CreateTaskParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("title");
        String str = null;
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("description");
        String str3 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        boolean[] propertyBooleanArray = genericDocument.getPropertyBooleanArray("completed");
        Boolean boolValueOf = (propertyBooleanArray == null || propertyBooleanArray.length == 0) ? null : Boolean.valueOf(propertyBooleanArray[0]);
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("dateTime");
        DateTime dateTime = propertyDocument != null ? (DateTime) propertyDocument.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        boolean[] propertyBooleanArray2 = genericDocument.getPropertyBooleanArray("allDay");
        Boolean boolValueOf2 = (propertyBooleanArray2 == null || propertyBooleanArray2.length == 0) ? null : Boolean.valueOf(propertyBooleanArray2[0]);
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("recurrenceSchedule");
        String str4 = (propertyStringArray3 == null || propertyStringArray3.length == 0) ? null : propertyStringArray3[0];
        String[] propertyStringArray4 = genericDocument.getPropertyStringArray("externalId");
        String str5 = (propertyStringArray4 == null || propertyStringArray4.length == 0) ? null : propertyStringArray4[0];
        String[] propertyStringArray5 = genericDocument.getPropertyStringArray("taskCategoryId");
        if (propertyStringArray5 != null && propertyStringArray5.length != 0) {
            str = propertyStringArray5[0];
        }
        return new CreateTaskParams(namespace, id, str2, str3, boolValueOf, dateTime, boolValueOf2, str4, str5, str);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(CreateTaskParams createTaskParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(createTaskParams.getNamespace(), createTaskParams.getId(), SCHEMA_NAME);
        String title = createTaskParams.getTitle();
        if (title != null) {
            builder.setPropertyString("title", title);
        }
        String description = createTaskParams.getDescription();
        if (description != null) {
            builder.setPropertyString("description", description);
        }
        Boolean completed = createTaskParams.getCompleted();
        if (completed != null) {
            builder.setPropertyBoolean("completed", completed.booleanValue());
        }
        DateTime dateTime = createTaskParams.getDateTime();
        if (dateTime != null) {
            builder.setPropertyDocument("dateTime", GenericDocument.fromDocumentClass(dateTime));
        }
        Boolean allDay = createTaskParams.getAllDay();
        if (allDay != null) {
            builder.setPropertyBoolean("allDay", allDay.booleanValue());
        }
        String recurrenceSchedule = createTaskParams.getRecurrenceSchedule();
        if (recurrenceSchedule != null) {
            builder.setPropertyString("recurrenceSchedule", recurrenceSchedule);
        }
        String externalId = createTaskParams.getExternalId();
        if (externalId != null) {
            builder.setPropertyString("externalId", externalId);
        }
        String taskCategoryId = createTaskParams.getTaskCategoryId();
        if (taskCategoryId != null) {
            builder.setPropertyString("taskCategoryId", taskCategoryId);
        }
        return builder.build();
    }
}
