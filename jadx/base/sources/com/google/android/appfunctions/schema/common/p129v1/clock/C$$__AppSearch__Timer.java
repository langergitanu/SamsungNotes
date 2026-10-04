package com.google.android.appfunctions.schema.common.p129v1.clock;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.clock.$$__AppSearch__Timer, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__Timer implements DocumentClassFactory<Timer> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.clock.Timer";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m760b("expireTimeEpochMillis", 2, 0, AbstractC0541b.m760b("remainingDurationMillis", 3, 0, AbstractC0541b.m760b("durationMillis", 3, 0, AbstractC0541b.m760b("originalDurationMillis", 3, 0, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("label", 2, 0, 0, 0)))).addProperty(AbstractC0541b.m763e("timerState", 3, 0, 0, 0)))).addProperty(new AppSearchSchema.BooleanPropertyConfig.Builder("isFiring").setCardinality(2).build()).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public Timer fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("label");
        Boolean boolValueOf = null;
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        long propertyLong = genericDocument.getPropertyLong("originalDurationMillis");
        long propertyLong2 = genericDocument.getPropertyLong("durationMillis");
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("timerState");
        String str2 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        long propertyLong3 = genericDocument.getPropertyLong("remainingDurationMillis");
        long[] propertyLongArray = genericDocument.getPropertyLongArray("expireTimeEpochMillis");
        Long lValueOf = (propertyLongArray == null || propertyLongArray.length == 0) ? null : Long.valueOf(propertyLongArray[0]);
        boolean[] propertyBooleanArray = genericDocument.getPropertyBooleanArray("isFiring");
        if (propertyBooleanArray != null && propertyBooleanArray.length != 0) {
            boolValueOf = Boolean.valueOf(propertyBooleanArray[0]);
        }
        return new Timer(namespace, id, str, propertyLong, propertyLong2, str2, propertyLong3, lValueOf, boolValueOf);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(Timer timer) {
        GenericDocument.Builder builder = new GenericDocument.Builder(timer.getNamespace(), timer.getId(), SCHEMA_NAME);
        String label = timer.getLabel();
        if (label != null) {
            builder.setPropertyString("label", label);
        }
        builder.setPropertyLong("originalDurationMillis", timer.getOriginalDurationMillis());
        builder.setPropertyLong("durationMillis", timer.getDurationMillis());
        String timerState = timer.getTimerState();
        if (timerState != null) {
            builder.setPropertyString("timerState", timerState);
        }
        builder.setPropertyLong("remainingDurationMillis", timer.getRemainingDurationMillis());
        Long expireTimeEpochMillis = timer.getExpireTimeEpochMillis();
        if (expireTimeEpochMillis != null) {
            builder.setPropertyLong("expireTimeEpochMillis", expireTimeEpochMillis.longValue());
        }
        Boolean isFiring = timer.getIsFiring();
        if (isFiring != null) {
            builder.setPropertyBoolean("isFiring", isFiring.booleanValue());
        }
        return builder.build();
    }
}
