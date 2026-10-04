package com.google.android.appfunctions.schema.common.p129v1.phone;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.phone.$$__AppSearch__Call, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__Call implements DocumentClassFactory<Call> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.phone.Call";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("contactId", 3, 0, 0, 0)).addProperty(new AppSearchSchema.BooleanPropertyConfig.Builder("isVideoCall").setCardinality(2).build()).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public Call fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("contactId");
        Boolean boolValueOf = null;
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        boolean[] propertyBooleanArray = genericDocument.getPropertyBooleanArray("isVideoCall");
        if (propertyBooleanArray != null && propertyBooleanArray.length != 0) {
            boolValueOf = Boolean.valueOf(propertyBooleanArray[0]);
        }
        return new Call(namespace, id, str, boolValueOf);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(Call call) {
        GenericDocument.Builder builder = new GenericDocument.Builder(call.getNamespace(), call.getId(), SCHEMA_NAME);
        String contactId = call.getContactId();
        if (contactId != null) {
            builder.setPropertyString("contactId", contactId);
        }
        Boolean isVideoCall = call.getIsVideoCall();
        if (isVideoCall != null) {
            builder.setPropertyBoolean("isVideoCall", isVideoCall.booleanValue());
        }
        return builder.build();
    }
}
