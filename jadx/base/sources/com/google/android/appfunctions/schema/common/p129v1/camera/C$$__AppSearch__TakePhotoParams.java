package com.google.android.appfunctions.schema.common.p129v1.camera;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.camera.$$__AppSearch__TakePhotoParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__TakePhotoParams implements DocumentClassFactory<TakePhotoParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.camera.TakePhotoParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m764f("delaySeconds", 2, 0, new AppSearchSchema.Builder(SCHEMA_NAME));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public TakePhotoParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        long[] propertyLongArray = genericDocument.getPropertyLongArray("delaySeconds");
        return new TakePhotoParams(namespace, id, (propertyLongArray == null || propertyLongArray.length == 0) ? null : Integer.valueOf((int) propertyLongArray[0]));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(TakePhotoParams takePhotoParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(takePhotoParams.getNamespace(), takePhotoParams.getId(), SCHEMA_NAME);
        if (takePhotoParams.getDelaySeconds() != null) {
            builder.setPropertyLong("delaySeconds", r5.intValue());
        }
        return builder.build();
    }
}
