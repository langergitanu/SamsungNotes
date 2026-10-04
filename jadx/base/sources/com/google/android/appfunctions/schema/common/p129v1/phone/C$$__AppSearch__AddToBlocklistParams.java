package com.google.android.appfunctions.schema.common.p129v1.phone;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import androidx.autofill.HintConstants;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.phone.$$__AppSearch__AddToBlocklistParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__AddToBlocklistParams implements DocumentClassFactory<AddToBlocklistParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.phone.AddToBlocklistParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("type", 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("contactId", 2, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public AddToBlocklistParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("type");
        String str = null;
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray(HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        String str3 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("contactId");
        if (propertyStringArray3 != null && propertyStringArray3.length != 0) {
            str = propertyStringArray3[0];
        }
        return new AddToBlocklistParams(namespace, id, str2, str3, str);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(AddToBlocklistParams addToBlocklistParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(addToBlocklistParams.getNamespace(), addToBlocklistParams.getId(), SCHEMA_NAME);
        String type = addToBlocklistParams.getType();
        if (type != null) {
            builder.setPropertyString("type", type);
        }
        String phoneNumber = addToBlocklistParams.getPhoneNumber();
        if (phoneNumber != null) {
            builder.setPropertyString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, phoneNumber);
        }
        String contactId = addToBlocklistParams.getContactId();
        if (contactId != null) {
            builder.setPropertyString("contactId", contactId);
        }
        return builder.build();
    }
}
