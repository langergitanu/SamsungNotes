package com.google.android.appfunctions.schema.common.p129v1.phone;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import androidx.autofill.HintConstants;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.phone.$$__AppSearch__MakeCallParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__MakeCallParams implements DocumentClassFactory<MakeCallParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.phone.MakeCallParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m761c("isSpeakerOn", 2, AbstractC0541b.m761c("shouldRecord", 2, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("type", 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("contactId", 2, 0, 0, 0)))).addProperty(new AppSearchSchema.BooleanPropertyConfig.Builder("isVideoCall").setCardinality(2).build()).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public MakeCallParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("type");
        Boolean boolValueOf = null;
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray(HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        String str2 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("contactId");
        String str3 = (propertyStringArray3 == null || propertyStringArray3.length == 0) ? null : propertyStringArray3[0];
        boolean[] propertyBooleanArray = genericDocument.getPropertyBooleanArray("shouldRecord");
        Boolean boolValueOf2 = (propertyBooleanArray == null || propertyBooleanArray.length == 0) ? null : Boolean.valueOf(propertyBooleanArray[0]);
        boolean[] propertyBooleanArray2 = genericDocument.getPropertyBooleanArray("isSpeakerOn");
        Boolean boolValueOf3 = (propertyBooleanArray2 == null || propertyBooleanArray2.length == 0) ? null : Boolean.valueOf(propertyBooleanArray2[0]);
        boolean[] propertyBooleanArray3 = genericDocument.getPropertyBooleanArray("isVideoCall");
        if (propertyBooleanArray3 != null && propertyBooleanArray3.length != 0) {
            boolValueOf = Boolean.valueOf(propertyBooleanArray3[0]);
        }
        return new MakeCallParams(namespace, id, str, str2, str3, boolValueOf2, boolValueOf3, boolValueOf);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(MakeCallParams makeCallParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(makeCallParams.getNamespace(), makeCallParams.getId(), SCHEMA_NAME);
        String type = makeCallParams.getType();
        if (type != null) {
            builder.setPropertyString("type", type);
        }
        String phoneNumber = makeCallParams.getPhoneNumber();
        if (phoneNumber != null) {
            builder.setPropertyString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, phoneNumber);
        }
        String contactId = makeCallParams.getContactId();
        if (contactId != null) {
            builder.setPropertyString("contactId", contactId);
        }
        Boolean bool = makeCallParams.shouldRecord;
        if (bool != null) {
            builder.setPropertyBoolean("shouldRecord", bool.booleanValue());
        }
        Boolean isSpeakerOn = makeCallParams.getIsSpeakerOn();
        if (isSpeakerOn != null) {
            builder.setPropertyBoolean("isSpeakerOn", isSpeakerOn.booleanValue());
        }
        Boolean isVideoCall = makeCallParams.getIsVideoCall();
        if (isVideoCall != null) {
            builder.setPropertyBoolean("isVideoCall", isVideoCall.booleanValue());
        }
        return builder.build();
    }
}
