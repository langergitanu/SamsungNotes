package com.google.android.appfunctions.schema.common.p129v1.video;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.video.$$__AppSearch__TimedText, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__TimedText implements DocumentClassFactory<TimedText> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.video.TimedText";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m760b("durationMills", 3, 0, AbstractC0541b.m760b("startTimeMillis", 3, 0, new AppSearchSchema.Builder(SCHEMA_NAME))).addProperty(new AppSearchSchema.DoublePropertyConfig.Builder("confidence").setCardinality(3).build()).addProperty(AbstractC0541b.m763e("text", 3, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public TimedText fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        long propertyLong = genericDocument.getPropertyLong("startTimeMillis");
        long propertyLong2 = genericDocument.getPropertyLong("durationMills");
        double propertyDouble = genericDocument.getPropertyDouble("confidence");
        String[] propertyStringArray = genericDocument.getPropertyStringArray("text");
        return new TimedText(namespace, id, propertyLong, propertyLong2, propertyDouble, (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0]);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(TimedText timedText) {
        GenericDocument.Builder builder = new GenericDocument.Builder(timedText.getNamespace(), timedText.getId(), SCHEMA_NAME);
        builder.setPropertyLong("startTimeMillis", timedText.getStartTimeMillis());
        builder.setPropertyLong("durationMills", timedText.getDurationMills());
        builder.setPropertyDouble("confidence", timedText.getConfidence());
        String text = timedText.getText();
        if (text != null) {
            builder.setPropertyString("text", text);
        }
        return builder.build();
    }
}
