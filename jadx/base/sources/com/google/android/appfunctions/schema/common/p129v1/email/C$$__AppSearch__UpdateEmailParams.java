package com.google.android.appfunctions.schema.common.p129v1.email;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetBooleanField;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetStringListField;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetStringNullableField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetBooleanField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringListField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringNullableField;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.email.$$__AppSearch__UpdateEmailParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__UpdateEmailParams implements DocumentClassFactory<UpdateEmailParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.email.UpdateEmailParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SetStringNullableField.class);
        arrayList.add(SetStringListField.class);
        arrayList.add(SetBooleanField.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("isRead", C$$__AppSearch__SetBooleanField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("bccRecipientIds", C$$__AppSearch__SetStringListField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("ccRecipientIds", C$$__AppSearch__SetStringListField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("recipientIds", C$$__AppSearch__SetStringListField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("message", C$$__AppSearch__SetStringNullableField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("subject", C$$__AppSearch__SetStringNullableField.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("emailId", 3, 0, 0, 0))))))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public UpdateEmailParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("emailId");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("subject");
        SetStringNullableField setStringNullableField = propertyDocument != null ? (SetStringNullableField) propertyDocument.toDocumentClass(SetStringNullableField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("message");
        SetStringNullableField setStringNullableField2 = propertyDocument2 != null ? (SetStringNullableField) propertyDocument2.toDocumentClass(SetStringNullableField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument3 = genericDocument.getPropertyDocument("recipientIds");
        SetStringListField setStringListField = propertyDocument3 != null ? (SetStringListField) propertyDocument3.toDocumentClass(SetStringListField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument4 = genericDocument.getPropertyDocument("ccRecipientIds");
        SetStringListField setStringListField2 = propertyDocument4 != null ? (SetStringListField) propertyDocument4.toDocumentClass(SetStringListField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument5 = genericDocument.getPropertyDocument("bccRecipientIds");
        SetStringListField setStringListField3 = propertyDocument5 != null ? (SetStringListField) propertyDocument5.toDocumentClass(SetStringListField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument6 = genericDocument.getPropertyDocument("isRead");
        return new UpdateEmailParams(namespace, id, str, setStringNullableField, setStringNullableField2, setStringListField, setStringListField2, setStringListField3, propertyDocument6 != null ? (SetBooleanField) propertyDocument6.toDocumentClass(SetBooleanField.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(UpdateEmailParams updateEmailParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(updateEmailParams.getNamespace(), updateEmailParams.getId(), SCHEMA_NAME);
        String emailId = updateEmailParams.getEmailId();
        if (emailId != null) {
            builder.setPropertyString("emailId", emailId);
        }
        SetStringNullableField subject = updateEmailParams.getSubject();
        if (subject != null) {
            builder.setPropertyDocument("subject", GenericDocument.fromDocumentClass(subject));
        }
        SetStringNullableField message = updateEmailParams.getMessage();
        if (message != null) {
            builder.setPropertyDocument("message", GenericDocument.fromDocumentClass(message));
        }
        SetStringListField recipientIds = updateEmailParams.getRecipientIds();
        if (recipientIds != null) {
            builder.setPropertyDocument("recipientIds", GenericDocument.fromDocumentClass(recipientIds));
        }
        SetStringListField ccRecipientIds = updateEmailParams.getCcRecipientIds();
        if (ccRecipientIds != null) {
            builder.setPropertyDocument("ccRecipientIds", GenericDocument.fromDocumentClass(ccRecipientIds));
        }
        SetStringListField bccRecipientIds = updateEmailParams.getBccRecipientIds();
        if (bccRecipientIds != null) {
            builder.setPropertyDocument("bccRecipientIds", GenericDocument.fromDocumentClass(bccRecipientIds));
        }
        SetBooleanField isRead = updateEmailParams.getIsRead();
        if (isRead != null) {
            builder.setPropertyDocument("isRead", GenericDocument.fromDocumentClass(isRead));
        }
        return builder.build();
    }
}
