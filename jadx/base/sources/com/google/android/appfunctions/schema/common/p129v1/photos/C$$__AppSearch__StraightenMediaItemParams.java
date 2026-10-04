package com.google.android.appfunctions.schema.common.p129v1.photos;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__Uri;
import com.google.android.appfunctions.schema.common.p129v1.types.Uri;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.photos.$$__AppSearch__StraightenMediaItemParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__StraightenMediaItemParams implements DocumentClassFactory<StraightenMediaItemParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.photos.StraightenMediaItemParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(Uri.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m761c("autoStraighten", 2, AbstractC0541b.m762d("mediaItemUri", C$$__AppSearch__Uri.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("mediaItemId", 2, 0, 0, 0)))).addProperty(new AppSearchSchema.DoublePropertyConfig.Builder("straightenDegrees").setCardinality(2).build()).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public StraightenMediaItemParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("mediaItemId");
        Double dValueOf = null;
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("mediaItemUri");
        Uri uri = propertyDocument != null ? (Uri) propertyDocument.toDocumentClass(Uri.class, documentClassMappingContext) : null;
        boolean[] propertyBooleanArray = genericDocument.getPropertyBooleanArray("autoStraighten");
        Boolean boolValueOf = (propertyBooleanArray == null || propertyBooleanArray.length == 0) ? null : Boolean.valueOf(propertyBooleanArray[0]);
        double[] propertyDoubleArray = genericDocument.getPropertyDoubleArray("straightenDegrees");
        if (propertyDoubleArray != null && propertyDoubleArray.length != 0) {
            dValueOf = Double.valueOf(propertyDoubleArray[0]);
        }
        return new StraightenMediaItemParams(namespace, id, str, uri, boolValueOf, dValueOf);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(StraightenMediaItemParams straightenMediaItemParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(straightenMediaItemParams.getNamespace(), straightenMediaItemParams.getId(), SCHEMA_NAME);
        String mediaItemId = straightenMediaItemParams.getMediaItemId();
        if (mediaItemId != null) {
            builder.setPropertyString("mediaItemId", mediaItemId);
        }
        Uri mediaItemUri = straightenMediaItemParams.getMediaItemUri();
        if (mediaItemUri != null) {
            builder.setPropertyDocument("mediaItemUri", GenericDocument.fromDocumentClass(mediaItemUri));
        }
        Boolean autoStraighten = straightenMediaItemParams.getAutoStraighten();
        if (autoStraighten != null) {
            builder.setPropertyBoolean("autoStraighten", autoStraighten.booleanValue());
        }
        Double straightenDegrees = straightenMediaItemParams.getStraightenDegrees();
        if (straightenDegrees != null) {
            builder.setPropertyDouble("straightenDegrees", straightenDegrees.doubleValue());
        }
        return builder.build();
    }
}
