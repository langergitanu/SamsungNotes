package com.google.android.appfunctions.schema.common.p129v1.email;

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

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.email.$$__AppSearch__FindEmailsParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__FindEmailsParams implements DocumentClassFactory<FindEmailsParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.email.FindEmailsParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(DateTime.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m764f("maxCount", 3, 0, AbstractC0541b.m761c("read", 2, AbstractC0541b.m761c("sent", 2, AbstractC0541b.m762d("endTime", C$$__AppSearch__DateTime.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("startTime", C$$__AppSearch__DateTime.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("query", 2, 0, 0, 0)))))).addProperty(AbstractC0541b.m763e("senderIds", 1, 0, 0, 0)).addProperty(AbstractC0541b.m763e("recipientIds", 1, 0, 0, 0)).addProperty(AbstractC0541b.m763e("labels", 1, 0, 0, 0)));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public FindEmailsParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("query");
        Boolean boolValueOf = null;
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("startTime");
        DateTime dateTime = propertyDocument != null ? (DateTime) propertyDocument.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("endTime");
        DateTime dateTime2 = propertyDocument2 != null ? (DateTime) propertyDocument2.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        boolean[] propertyBooleanArray = genericDocument.getPropertyBooleanArray("sent");
        Boolean boolValueOf2 = (propertyBooleanArray == null || propertyBooleanArray.length == 0) ? null : Boolean.valueOf(propertyBooleanArray[0]);
        boolean[] propertyBooleanArray2 = genericDocument.getPropertyBooleanArray("read");
        if (propertyBooleanArray2 != null && propertyBooleanArray2.length != 0) {
            boolValueOf = Boolean.valueOf(propertyBooleanArray2[0]);
        }
        Boolean bool = boolValueOf;
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("senderIds");
        List listAsList = Collections.EMPTY_LIST;
        List listAsList2 = propertyStringArray2 != null ? Arrays.asList(propertyStringArray2) : listAsList;
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("recipientIds");
        List listAsList3 = propertyStringArray3 != null ? Arrays.asList(propertyStringArray3) : listAsList;
        String[] propertyStringArray4 = genericDocument.getPropertyStringArray("labels");
        if (propertyStringArray4 != null) {
            listAsList = Arrays.asList(propertyStringArray4);
        }
        return new FindEmailsParams(namespace, id, str, dateTime, dateTime2, boolValueOf2, bool, listAsList2, listAsList3, listAsList, (int) genericDocument.getPropertyLong("maxCount"));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(FindEmailsParams findEmailsParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(findEmailsParams.getNamespace(), findEmailsParams.getId(), SCHEMA_NAME);
        String query = findEmailsParams.getQuery();
        if (query != null) {
            builder.setPropertyString("query", query);
        }
        DateTime startTime = findEmailsParams.getStartTime();
        if (startTime != null) {
            builder.setPropertyDocument("startTime", GenericDocument.fromDocumentClass(startTime));
        }
        DateTime endTime = findEmailsParams.getEndTime();
        if (endTime != null) {
            builder.setPropertyDocument("endTime", GenericDocument.fromDocumentClass(endTime));
        }
        Boolean sent = findEmailsParams.getSent();
        if (sent != null) {
            builder.setPropertyBoolean("sent", sent.booleanValue());
        }
        Boolean read = findEmailsParams.getRead();
        if (read != null) {
            builder.setPropertyBoolean("read", read.booleanValue());
        }
        List<String> senderIds = findEmailsParams.getSenderIds();
        if (senderIds != null) {
            builder.setPropertyString("senderIds", (String[]) senderIds.toArray(new String[0]));
        }
        List<String> recipientIds = findEmailsParams.getRecipientIds();
        if (recipientIds != null) {
            builder.setPropertyString("recipientIds", (String[]) recipientIds.toArray(new String[0]));
        }
        List<String> labels = findEmailsParams.getLabels();
        if (labels != null) {
            builder.setPropertyString("labels", (String[]) labels.toArray(new String[0]));
        }
        builder.setPropertyLong("maxCount", findEmailsParams.getMaxCount());
        return builder.build();
    }
}
