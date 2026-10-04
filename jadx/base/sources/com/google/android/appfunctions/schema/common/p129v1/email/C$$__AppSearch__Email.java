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

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.email.$$__AppSearch__Email, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__Email implements DocumentClassFactory<Email> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.email.Email";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(DateTime.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("dateRead", C$$__AppSearch__DateTime.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("dateReceived", C$$__AppSearch__DateTime.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("dateSent", C$$__AppSearch__DateTime.SCHEMA_NAME, 2, false, AbstractC0541b.m761c("isDraft", 2, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("subject", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("message", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("senderId", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("recipientIds", 1, 0, 0, 0)).addProperty(AbstractC0541b.m763e("ccRecipientIds", 1, 0, 0, 0)).addProperty(AbstractC0541b.m763e("bccRecipientIds", 1, 0, 0, 0))))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public Email fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("subject");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("message");
        String str2 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("senderId");
        String str3 = (propertyStringArray3 == null || propertyStringArray3.length == 0) ? null : propertyStringArray3[0];
        String[] propertyStringArray4 = genericDocument.getPropertyStringArray("recipientIds");
        List listAsList = Collections.EMPTY_LIST;
        List listAsList2 = propertyStringArray4 != null ? Arrays.asList(propertyStringArray4) : listAsList;
        String[] propertyStringArray5 = genericDocument.getPropertyStringArray("ccRecipientIds");
        List listAsList3 = propertyStringArray5 != null ? Arrays.asList(propertyStringArray5) : listAsList;
        String[] propertyStringArray6 = genericDocument.getPropertyStringArray("bccRecipientIds");
        if (propertyStringArray6 != null) {
            listAsList = Arrays.asList(propertyStringArray6);
        }
        boolean[] propertyBooleanArray = genericDocument.getPropertyBooleanArray("isDraft");
        Boolean boolValueOf = (propertyBooleanArray == null || propertyBooleanArray.length == 0) ? null : Boolean.valueOf(propertyBooleanArray[0]);
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("dateSent");
        DateTime dateTime = propertyDocument != null ? (DateTime) propertyDocument.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("dateReceived");
        DateTime dateTime2 = propertyDocument2 != null ? (DateTime) propertyDocument2.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument3 = genericDocument.getPropertyDocument("dateRead");
        return new Email(namespace, id, str, str2, str3, listAsList2, listAsList3, listAsList, boolValueOf, dateTime, dateTime2, propertyDocument3 != null ? (DateTime) propertyDocument3.toDocumentClass(DateTime.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(Email email) {
        GenericDocument.Builder builder = new GenericDocument.Builder(email.getNamespace(), email.getId(), SCHEMA_NAME);
        String subject = email.getSubject();
        if (subject != null) {
            builder.setPropertyString("subject", subject);
        }
        String message = email.getMessage();
        if (message != null) {
            builder.setPropertyString("message", message);
        }
        String senderId = email.getSenderId();
        if (senderId != null) {
            builder.setPropertyString("senderId", senderId);
        }
        List<String> recipientIds = email.getRecipientIds();
        if (recipientIds != null) {
            builder.setPropertyString("recipientIds", (String[]) recipientIds.toArray(new String[0]));
        }
        List<String> ccRecipientIds = email.getCcRecipientIds();
        if (ccRecipientIds != null) {
            builder.setPropertyString("ccRecipientIds", (String[]) ccRecipientIds.toArray(new String[0]));
        }
        List<String> bccRecipientIds = email.getBccRecipientIds();
        if (bccRecipientIds != null) {
            builder.setPropertyString("bccRecipientIds", (String[]) bccRecipientIds.toArray(new String[0]));
        }
        Boolean isDraft = email.getIsDraft();
        if (isDraft != null) {
            builder.setPropertyBoolean("isDraft", isDraft.booleanValue());
        }
        DateTime dateSent = email.getDateSent();
        if (dateSent != null) {
            builder.setPropertyDocument("dateSent", GenericDocument.fromDocumentClass(dateSent));
        }
        DateTime dateReceived = email.getDateReceived();
        if (dateReceived != null) {
            builder.setPropertyDocument("dateReceived", GenericDocument.fromDocumentClass(dateReceived));
        }
        DateTime dateRead = email.getDateRead();
        if (dateRead != null) {
            builder.setPropertyDocument("dateRead", GenericDocument.fromDocumentClass(dateRead));
        }
        return builder.build();
    }
}
