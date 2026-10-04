package com.google.android.appfunctions.schema.common.p129v1.nearbysharing;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.nearbysharing.$$__AppSearch__FindNearbyDevicesParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__FindNearbyDevicesParams implements DocumentClassFactory<FindNearbyDevicesParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.nearbysharing.FindNearbyDevicesParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m764f("maxCount", 3, 0, AbstractC0541b.m760b("maxSearchTimeMillis", 2, 0, AbstractC0541b.m761c("isMyDevice", 2, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("query", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e(HandoffConstant.KEY_DEVICE_TYPE, 2, 0, 0, 0)))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public FindNearbyDevicesParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("query");
        Long lValueOf = null;
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray(HandoffConstant.KEY_DEVICE_TYPE);
        String str2 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        boolean[] propertyBooleanArray = genericDocument.getPropertyBooleanArray("isMyDevice");
        Boolean boolValueOf = (propertyBooleanArray == null || propertyBooleanArray.length == 0) ? null : Boolean.valueOf(propertyBooleanArray[0]);
        long[] propertyLongArray = genericDocument.getPropertyLongArray("maxSearchTimeMillis");
        if (propertyLongArray != null && propertyLongArray.length != 0) {
            lValueOf = Long.valueOf(propertyLongArray[0]);
        }
        return new FindNearbyDevicesParams(namespace, id, str, str2, boolValueOf, lValueOf, (int) genericDocument.getPropertyLong("maxCount"));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(FindNearbyDevicesParams findNearbyDevicesParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(findNearbyDevicesParams.getNamespace(), findNearbyDevicesParams.getId(), SCHEMA_NAME);
        String query = findNearbyDevicesParams.getQuery();
        if (query != null) {
            builder.setPropertyString("query", query);
        }
        String deviceType = findNearbyDevicesParams.getDeviceType();
        if (deviceType != null) {
            builder.setPropertyString(HandoffConstant.KEY_DEVICE_TYPE, deviceType);
        }
        Boolean isMyDevice = findNearbyDevicesParams.getIsMyDevice();
        if (isMyDevice != null) {
            builder.setPropertyBoolean("isMyDevice", isMyDevice.booleanValue());
        }
        Long maxSearchTimeMillis = findNearbyDevicesParams.getMaxSearchTimeMillis();
        if (maxSearchTimeMillis != null) {
            builder.setPropertyLong("maxSearchTimeMillis", maxSearchTimeMillis.longValue());
        }
        builder.setPropertyLong("maxCount", findNearbyDevicesParams.getMaxCount());
        return builder.build();
    }
}
