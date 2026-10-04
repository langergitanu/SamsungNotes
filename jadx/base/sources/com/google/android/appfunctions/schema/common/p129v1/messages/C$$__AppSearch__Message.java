package com.google.android.appfunctions.schema.common.p129v1.messages;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.Attachment;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__Attachment;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__DateTime;
import com.google.android.appfunctions.schema.common.p129v1.types.DateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.messages.$$__AppSearch__Message, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__Message implements DocumentClassFactory<Message> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.messages.Message";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(DateTime.class);
        arrayList.add(Attachment.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("messageAttachments", C$$__AppSearch__Attachment.SCHEMA_NAME, 1, false, AbstractC0541b.m762d("dateRead", C$$__AppSearch__DateTime.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("dateReceived", C$$__AppSearch__DateTime.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("dateSent", C$$__AppSearch__DateTime.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("messageType", 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e("body", 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e("senderId", 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e("recipientsIds", 1, 0, 0, 0))))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.util.ArrayList] */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public Message fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("messageType");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("body");
        String str2 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("senderId");
        String str3 = (propertyStringArray3 == null || propertyStringArray3.length == 0) ? null : propertyStringArray3[0];
        String[] propertyStringArray4 = genericDocument.getPropertyStringArray("recipientsIds");
        ?? arrayList = Collections.EMPTY_LIST;
        ?? AsList = propertyStringArray4 != null ? Arrays.asList(propertyStringArray4) : arrayList;
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("dateSent");
        DateTime dateTime = propertyDocument != null ? (DateTime) propertyDocument.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("dateReceived");
        DateTime dateTime2 = propertyDocument2 != null ? (DateTime) propertyDocument2.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument3 = genericDocument.getPropertyDocument("dateRead");
        DateTime dateTime3 = propertyDocument3 != null ? (DateTime) propertyDocument3.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        GenericDocument[] propertyDocumentArray = genericDocument.getPropertyDocumentArray("messageAttachments");
        if (propertyDocumentArray != null) {
            arrayList = new ArrayList(propertyDocumentArray.length);
            for (GenericDocument genericDocument2 : propertyDocumentArray) {
                arrayList.add((Attachment) genericDocument2.toDocumentClass(Attachment.class, documentClassMappingContext));
            }
        }
        return new Message(namespace, id, str, str2, str3, AsList, dateTime, dateTime2, dateTime3, arrayList);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(Message message) {
        GenericDocument.Builder builder = new GenericDocument.Builder(message.getNamespace(), message.getId(), SCHEMA_NAME);
        String messageType = message.getMessageType();
        if (messageType != null) {
            builder.setPropertyString("messageType", messageType);
        }
        String body = message.getBody();
        if (body != null) {
            builder.setPropertyString("body", body);
        }
        String senderId = message.getSenderId();
        if (senderId != null) {
            builder.setPropertyString("senderId", senderId);
        }
        List<String> recipientsIds = message.getRecipientsIds();
        int i = 0;
        if (recipientsIds != null) {
            builder.setPropertyString("recipientsIds", (String[]) recipientsIds.toArray(new String[0]));
        }
        DateTime dateSent = message.getDateSent();
        if (dateSent != null) {
            builder.setPropertyDocument("dateSent", GenericDocument.fromDocumentClass(dateSent));
        }
        DateTime dateReceived = message.getDateReceived();
        if (dateReceived != null) {
            builder.setPropertyDocument("dateReceived", GenericDocument.fromDocumentClass(dateReceived));
        }
        DateTime dateRead = message.getDateRead();
        if (dateRead != null) {
            builder.setPropertyDocument("dateRead", GenericDocument.fromDocumentClass(dateRead));
        }
        List<Attachment> messageAttachments = message.getMessageAttachments();
        if (messageAttachments != null) {
            GenericDocument[] genericDocumentArr = new GenericDocument[messageAttachments.size()];
            Iterator<Attachment> it = messageAttachments.iterator();
            while (it.hasNext()) {
                genericDocumentArr[i] = GenericDocument.fromDocumentClass(it.next());
                i++;
            }
            builder.setPropertyDocument("messageAttachments", genericDocumentArr);
        }
        return builder.build();
    }
}
