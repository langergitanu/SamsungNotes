package com.google.android.appfunctions.schema.common.p129v1.email;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.email.$$__AppSearch__CreateEmailDraftParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__CreateEmailDraftParams implements DocumentClassFactory<CreateEmailDraftParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.email.CreateEmailDraftParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("subject", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("message", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("senderAccountId", 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e("recipientIds", 1, 0, 0, 0)).addProperty(AbstractC0541b.m763e("ccRecipientIds", 1, 0, 0, 0)).addProperty(AbstractC0541b.m763e("bccRecipientIds", 1, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public CreateEmailDraftParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("subject");
        String str = null;
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("message");
        String str3 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("senderAccountId");
        if (propertyStringArray3 != null && propertyStringArray3.length != 0) {
            str = propertyStringArray3[0];
        }
        String str4 = str;
        String[] propertyStringArray4 = genericDocument.getPropertyStringArray("recipientIds");
        List listAsList = Collections.EMPTY_LIST;
        List listAsList2 = propertyStringArray4 != null ? Arrays.asList(propertyStringArray4) : listAsList;
        String[] propertyStringArray5 = genericDocument.getPropertyStringArray("ccRecipientIds");
        List listAsList3 = propertyStringArray5 != null ? Arrays.asList(propertyStringArray5) : listAsList;
        String[] propertyStringArray6 = genericDocument.getPropertyStringArray("bccRecipientIds");
        if (propertyStringArray6 != null) {
            listAsList = Arrays.asList(propertyStringArray6);
        }
        return new CreateEmailDraftParams(namespace, id, str2, str3, str4, listAsList2, listAsList3, listAsList);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(CreateEmailDraftParams createEmailDraftParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(createEmailDraftParams.getNamespace(), createEmailDraftParams.getId(), SCHEMA_NAME);
        String subject = createEmailDraftParams.getSubject();
        if (subject != null) {
            builder.setPropertyString("subject", subject);
        }
        String message = createEmailDraftParams.getMessage();
        if (message != null) {
            builder.setPropertyString("message", message);
        }
        String senderAccountId = createEmailDraftParams.getSenderAccountId();
        if (senderAccountId != null) {
            builder.setPropertyString("senderAccountId", senderAccountId);
        }
        List<String> recipientIds = createEmailDraftParams.getRecipientIds();
        if (recipientIds != null) {
            builder.setPropertyString("recipientIds", (String[]) recipientIds.toArray(new String[0]));
        }
        List<String> ccRecipientIds = createEmailDraftParams.getCcRecipientIds();
        if (ccRecipientIds != null) {
            builder.setPropertyString("ccRecipientIds", (String[]) ccRecipientIds.toArray(new String[0]));
        }
        List<String> bccRecipientIds = createEmailDraftParams.getBccRecipientIds();
        if (bccRecipientIds != null) {
            builder.setPropertyString("bccRecipientIds", (String[]) bccRecipientIds.toArray(new String[0]));
        }
        return builder.build();
    }
}
