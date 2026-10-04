package com.google.android.appfunctions.schema.common.p129v1.nearbysharing;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.nearbysharing.$$__AppSearch__NearbyDevice, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__NearbyDevice implements DocumentClassFactory<NearbyDevice> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.nearbysharing.NearbyDevice";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("nearbyDeviceId", 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e("deviceName", 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e(HandoffConstant.KEY_DEVICE_TYPE, 2, 0, 0, 0)).addProperty(new AppSearchSchema.BooleanPropertyConfig.Builder("isMyDevice").setCardinality(2).build()).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public NearbyDevice fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("nearbyDeviceId");
        Boolean boolValueOf = null;
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("deviceName");
        String str2 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray(HandoffConstant.KEY_DEVICE_TYPE);
        String str3 = (propertyStringArray3 == null || propertyStringArray3.length == 0) ? null : propertyStringArray3[0];
        boolean[] propertyBooleanArray = genericDocument.getPropertyBooleanArray("isMyDevice");
        if (propertyBooleanArray != null && propertyBooleanArray.length != 0) {
            boolValueOf = Boolean.valueOf(propertyBooleanArray[0]);
        }
        return new NearbyDevice(namespace, id, str, str2, str3, boolValueOf);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(NearbyDevice nearbyDevice) {
        GenericDocument.Builder builder = new GenericDocument.Builder(nearbyDevice.getNamespace(), nearbyDevice.getId(), SCHEMA_NAME);
        String nearbyDeviceId = nearbyDevice.getNearbyDeviceId();
        if (nearbyDeviceId != null) {
            builder.setPropertyString("nearbyDeviceId", nearbyDeviceId);
        }
        String deviceName = nearbyDevice.getDeviceName();
        if (deviceName != null) {
            builder.setPropertyString("deviceName", deviceName);
        }
        String deviceType = nearbyDevice.getDeviceType();
        if (deviceType != null) {
            builder.setPropertyString(HandoffConstant.KEY_DEVICE_TYPE, deviceType);
        }
        Boolean isMyDevice = nearbyDevice.getIsMyDevice();
        if (isMyDevice != null) {
            builder.setPropertyBoolean("isMyDevice", isMyDevice.booleanValue());
        }
        return builder.build();
    }
}
