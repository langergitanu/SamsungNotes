package com.google.android.appfunctions.schema.common.p129v1.phone;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import androidx.autofill.HintConstants;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__DateTime;
import com.google.android.appfunctions.schema.common.p129v1.types.DateTime;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.phone.$$__AppSearch__CallRecord, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__CallRecord implements DocumentClassFactory<CallRecord> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.phone.CallRecord";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(DateTime.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m760b("durationMillis", 2, 0, AbstractC0541b.m762d("startTime", C$$__AppSearch__DateTime.SCHEMA_NAME, 3, false, AbstractC0541b.m761c("isVideoCall", 2, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("contactId", 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e("callType", 3, 0, 0, 0))))).addProperty(AbstractC0541b.m763e("sipAddress", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, 2, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public CallRecord fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("contactId");
        String str = null;
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("callType");
        String str3 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        boolean[] propertyBooleanArray = genericDocument.getPropertyBooleanArray("isVideoCall");
        Boolean boolValueOf = (propertyBooleanArray == null || propertyBooleanArray.length == 0) ? null : Boolean.valueOf(propertyBooleanArray[0]);
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("startTime");
        DateTime dateTime = propertyDocument != null ? (DateTime) propertyDocument.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        long[] propertyLongArray = genericDocument.getPropertyLongArray("durationMillis");
        Long lValueOf = (propertyLongArray == null || propertyLongArray.length == 0) ? null : Long.valueOf(propertyLongArray[0]);
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("sipAddress");
        String str4 = (propertyStringArray3 == null || propertyStringArray3.length == 0) ? null : propertyStringArray3[0];
        String[] propertyStringArray4 = genericDocument.getPropertyStringArray(HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        if (propertyStringArray4 != null && propertyStringArray4.length != 0) {
            str = propertyStringArray4[0];
        }
        return new CallRecord(namespace, id, str2, str3, boolValueOf, dateTime, lValueOf, str4, str);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(CallRecord callRecord) {
        GenericDocument.Builder builder = new GenericDocument.Builder(callRecord.getNamespace(), callRecord.getId(), SCHEMA_NAME);
        String contactId = callRecord.getContactId();
        if (contactId != null) {
            builder.setPropertyString("contactId", contactId);
        }
        String callType = callRecord.getCallType();
        if (callType != null) {
            builder.setPropertyString("callType", callType);
        }
        Boolean isVideoCall = callRecord.getIsVideoCall();
        if (isVideoCall != null) {
            builder.setPropertyBoolean("isVideoCall", isVideoCall.booleanValue());
        }
        DateTime startTime = callRecord.getStartTime();
        if (startTime != null) {
            builder.setPropertyDocument("startTime", GenericDocument.fromDocumentClass(startTime));
        }
        Long durationMillis = callRecord.getDurationMillis();
        if (durationMillis != null) {
            builder.setPropertyLong("durationMillis", durationMillis.longValue());
        }
        String sipAddress = callRecord.getSipAddress();
        if (sipAddress != null) {
            builder.setPropertyString("sipAddress", sipAddress);
        }
        String phoneNumber = callRecord.getPhoneNumber();
        if (phoneNumber != null) {
            builder.setPropertyString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, phoneNumber);
        }
        return builder.build();
    }
}
