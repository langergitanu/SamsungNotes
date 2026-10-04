package com.google.android.appfunctions.schema.common.p129v1.messages;

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

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.messages.$$__AppSearch__FindMessagesParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__FindMessagesParams implements DocumentClassFactory<FindMessagesParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.messages.FindMessagesParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(DateTime.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m764f("maxCount", 3, 0, AbstractC0541b.m761c("read", 2, AbstractC0541b.m762d("endTime", C$$__AppSearch__DateTime.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("startTime", C$$__AppSearch__DateTime.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("senderId", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("recipientsIds", 1, 0, 0, 0)))).addProperty(AbstractC0541b.m763e("query", 2, 0, 0, 0))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public FindMessagesParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("senderId");
        Boolean boolValueOf = null;
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("recipientsIds");
        List listAsList = Collections.EMPTY_LIST;
        if (propertyStringArray2 != null) {
            listAsList = Arrays.asList(propertyStringArray2);
        }
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("startTime");
        DateTime dateTime = propertyDocument != null ? (DateTime) propertyDocument.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("endTime");
        DateTime dateTime2 = propertyDocument2 != null ? (DateTime) propertyDocument2.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("query");
        String str2 = (propertyStringArray3 == null || propertyStringArray3.length == 0) ? null : propertyStringArray3[0];
        boolean[] propertyBooleanArray = genericDocument.getPropertyBooleanArray("read");
        if (propertyBooleanArray != null && propertyBooleanArray.length != 0) {
            boolValueOf = Boolean.valueOf(propertyBooleanArray[0]);
        }
        return new FindMessagesParams(namespace, id, str, listAsList, dateTime, dateTime2, str2, boolValueOf, (int) genericDocument.getPropertyLong("maxCount"));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(FindMessagesParams findMessagesParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(findMessagesParams.getNamespace(), findMessagesParams.getId(), SCHEMA_NAME);
        String senderId = findMessagesParams.getSenderId();
        if (senderId != null) {
            builder.setPropertyString("senderId", senderId);
        }
        List<String> recipientsIds = findMessagesParams.getRecipientsIds();
        if (recipientsIds != null) {
            builder.setPropertyString("recipientsIds", (String[]) recipientsIds.toArray(new String[0]));
        }
        DateTime startTime = findMessagesParams.getStartTime();
        if (startTime != null) {
            builder.setPropertyDocument("startTime", GenericDocument.fromDocumentClass(startTime));
        }
        DateTime endTime = findMessagesParams.getEndTime();
        if (endTime != null) {
            builder.setPropertyDocument("endTime", GenericDocument.fromDocumentClass(endTime));
        }
        String query = findMessagesParams.getQuery();
        if (query != null) {
            builder.setPropertyString("query", query);
        }
        Boolean read = findMessagesParams.getRead();
        if (read != null) {
            builder.setPropertyBoolean("read", read.booleanValue());
        }
        builder.setPropertyLong("maxCount", findMessagesParams.getMaxCount());
        return builder.build();
    }
}
