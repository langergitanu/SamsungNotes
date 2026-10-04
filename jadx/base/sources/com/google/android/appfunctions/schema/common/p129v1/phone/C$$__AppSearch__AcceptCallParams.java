package com.google.android.appfunctions.schema.common.p129v1.phone;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.phone.$$__AppSearch__AcceptCallParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__AcceptCallParams implements DocumentClassFactory<AcceptCallParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.phone.AcceptCallParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m761c("isSpeakerOn", 2, AbstractC0541b.m761c("shouldRecord", 2, new AppSearchSchema.Builder(SCHEMA_NAME))).addProperty(new AppSearchSchema.BooleanPropertyConfig.Builder("isVideoCall").setCardinality(2).build()).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public AcceptCallParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        boolean[] propertyBooleanArray = genericDocument.getPropertyBooleanArray("shouldRecord");
        Boolean boolValueOf = null;
        Boolean boolValueOf2 = (propertyBooleanArray == null || propertyBooleanArray.length == 0) ? null : Boolean.valueOf(propertyBooleanArray[0]);
        boolean[] propertyBooleanArray2 = genericDocument.getPropertyBooleanArray("isSpeakerOn");
        Boolean boolValueOf3 = (propertyBooleanArray2 == null || propertyBooleanArray2.length == 0) ? null : Boolean.valueOf(propertyBooleanArray2[0]);
        boolean[] propertyBooleanArray3 = genericDocument.getPropertyBooleanArray("isVideoCall");
        if (propertyBooleanArray3 != null && propertyBooleanArray3.length != 0) {
            boolValueOf = Boolean.valueOf(propertyBooleanArray3[0]);
        }
        return new AcceptCallParams(namespace, id, boolValueOf2, boolValueOf3, boolValueOf);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(AcceptCallParams acceptCallParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(acceptCallParams.getNamespace(), acceptCallParams.getId(), SCHEMA_NAME);
        Boolean bool = acceptCallParams.shouldRecord;
        if (bool != null) {
            builder.setPropertyBoolean("shouldRecord", bool.booleanValue());
        }
        Boolean isSpeakerOn = acceptCallParams.getIsSpeakerOn();
        if (isSpeakerOn != null) {
            builder.setPropertyBoolean("isSpeakerOn", isSpeakerOn.booleanValue());
        }
        Boolean isVideoCall = acceptCallParams.getIsVideoCall();
        if (isVideoCall != null) {
            builder.setPropertyBoolean("isVideoCall", isVideoCall.booleanValue());
        }
        return builder.build();
    }
}
