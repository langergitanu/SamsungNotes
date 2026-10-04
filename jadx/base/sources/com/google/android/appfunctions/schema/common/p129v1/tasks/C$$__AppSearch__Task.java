package com.google.android.appfunctions.schema.common.p129v1.tasks;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__DateTime;
import com.google.android.appfunctions.schema.common.p129v1.types.DateTime;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.tasks.$$__AppSearch__Task, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__Task implements DocumentClassFactory<Task> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.tasks.Task";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(DateTime.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m761c("allDay", 2, AbstractC0541b.m762d("dateTime", C$$__AppSearch__DateTime.SCHEMA_NAME, 2, false, AbstractC0541b.m761c("completed", 2, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("title", 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e("description", 2, 0, 0, 0))).addProperty(AbstractC0541b.m763e("taskCategoryId", 2, 0, 0, 0)))).addProperty(AbstractC0541b.m763e("recurrenceSchedule", 2, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public Task fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("title");
        String str = null;
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("description");
        String str3 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        boolean[] propertyBooleanArray = genericDocument.getPropertyBooleanArray("completed");
        Boolean boolValueOf = (propertyBooleanArray == null || propertyBooleanArray.length == 0) ? null : Boolean.valueOf(propertyBooleanArray[0]);
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("taskCategoryId");
        String str4 = (propertyStringArray3 == null || propertyStringArray3.length == 0) ? null : propertyStringArray3[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("dateTime");
        DateTime dateTime = propertyDocument != null ? (DateTime) propertyDocument.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        boolean[] propertyBooleanArray2 = genericDocument.getPropertyBooleanArray("allDay");
        Boolean boolValueOf2 = (propertyBooleanArray2 == null || propertyBooleanArray2.length == 0) ? null : Boolean.valueOf(propertyBooleanArray2[0]);
        String[] propertyStringArray4 = genericDocument.getPropertyStringArray("recurrenceSchedule");
        if (propertyStringArray4 != null && propertyStringArray4.length != 0) {
            str = propertyStringArray4[0];
        }
        return new Task(namespace, id, str2, str3, boolValueOf, str4, dateTime, boolValueOf2, str);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(Task task) {
        GenericDocument.Builder builder = new GenericDocument.Builder(task.getNamespace(), task.getId(), SCHEMA_NAME);
        String title = task.getTitle();
        if (title != null) {
            builder.setPropertyString("title", title);
        }
        String description = task.getDescription();
        if (description != null) {
            builder.setPropertyString("description", description);
        }
        Boolean completed = task.getCompleted();
        if (completed != null) {
            builder.setPropertyBoolean("completed", completed.booleanValue());
        }
        String taskCategoryId = task.getTaskCategoryId();
        if (taskCategoryId != null) {
            builder.setPropertyString("taskCategoryId", taskCategoryId);
        }
        DateTime dateTime = task.getDateTime();
        if (dateTime != null) {
            builder.setPropertyDocument("dateTime", GenericDocument.fromDocumentClass(dateTime));
        }
        Boolean allDay = task.getAllDay();
        if (allDay != null) {
            builder.setPropertyBoolean("allDay", allDay.booleanValue());
        }
        String recurrenceSchedule = task.getRecurrenceSchedule();
        if (recurrenceSchedule != null) {
            builder.setPropertyString("recurrenceSchedule", recurrenceSchedule);
        }
        return builder.build();
    }
}
