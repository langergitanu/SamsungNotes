package com.google.android.appfunctions.schema.common.p129v1.photos;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__Uri;
import com.google.android.appfunctions.schema.common.p129v1.types.Uri;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.photos.$$__AppSearch__SetMediaItemFilterParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__SetMediaItemFilterParams implements DocumentClassFactory<SetMediaItemFilterParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.photos.SetMediaItemFilterParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(Uri.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m762d("mediaItemUri", C$$__AppSearch__Uri.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("mediaItemId", 2, 0, 0, 0))).addProperty(AbstractC0541b.m763e("filter", 3, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public SetMediaItemFilterParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("mediaItemId");
        String str = null;
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("mediaItemUri");
        Uri uri = propertyDocument != null ? (Uri) propertyDocument.toDocumentClass(Uri.class, documentClassMappingContext) : null;
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("filter");
        if (propertyStringArray2 != null && propertyStringArray2.length != 0) {
            str = propertyStringArray2[0];
        }
        return new SetMediaItemFilterParams(namespace, id, str2, uri, str);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(SetMediaItemFilterParams setMediaItemFilterParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(setMediaItemFilterParams.getNamespace(), setMediaItemFilterParams.getId(), SCHEMA_NAME);
        String mediaItemId = setMediaItemFilterParams.getMediaItemId();
        if (mediaItemId != null) {
            builder.setPropertyString("mediaItemId", mediaItemId);
        }
        Uri mediaItemUri = setMediaItemFilterParams.getMediaItemUri();
        if (mediaItemUri != null) {
            builder.setPropertyDocument("mediaItemUri", GenericDocument.fromDocumentClass(mediaItemUri));
        }
        String filter = setMediaItemFilterParams.getFilter();
        if (filter != null) {
            builder.setPropertyString("filter", filter);
        }
        return builder.build();
    }
}
