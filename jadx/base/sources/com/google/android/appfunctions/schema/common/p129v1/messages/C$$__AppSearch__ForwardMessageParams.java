package com.google.android.appfunctions.schema.common.p129v1.messages;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.messages.$$__AppSearch__ForwardMessageParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__ForwardMessageParams implements DocumentClassFactory<ForwardMessageParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.messages.ForwardMessageParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("messageId", 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e("recipientsIds", 1, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public ForwardMessageParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("messageId");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("recipientsIds");
        List listAsList = Collections.EMPTY_LIST;
        if (propertyStringArray2 != null) {
            listAsList = Arrays.asList(propertyStringArray2);
        }
        return new ForwardMessageParams(namespace, id, str, listAsList);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(ForwardMessageParams forwardMessageParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(forwardMessageParams.getNamespace(), forwardMessageParams.getId(), SCHEMA_NAME);
        String messageId = forwardMessageParams.getMessageId();
        if (messageId != null) {
            builder.setPropertyString("messageId", messageId);
        }
        List<String> recipientsIds = forwardMessageParams.getRecipientsIds();
        if (recipientsIds != null) {
            builder.setPropertyString("recipientsIds", (String[]) recipientsIds.toArray(new String[0]));
        }
        return builder.build();
    }
}
