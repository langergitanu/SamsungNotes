package com.google.android.appfunctions.schema.common.p129v1.nearbysharing;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__Uri;
import com.google.android.appfunctions.schema.common.p129v1.types.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.nearbysharing.$$__AppSearch__ShareFilesToNearbyDeviceParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__ShareFilesToNearbyDeviceParams implements DocumentClassFactory<ShareFilesToNearbyDeviceParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.nearbysharing.ShareFilesToNearbyDeviceParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(Uri.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("files", C$$__AppSearch__Uri.SCHEMA_NAME, 1, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("targetDeviceId", 3, 0, 0, 0)));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.ArrayList] */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public ShareFilesToNearbyDeviceParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("targetDeviceId");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument[] propertyDocumentArray = genericDocument.getPropertyDocumentArray("files");
        ?? arrayList = Collections.EMPTY_LIST;
        if (propertyDocumentArray != null) {
            arrayList = new ArrayList(propertyDocumentArray.length);
            for (GenericDocument genericDocument2 : propertyDocumentArray) {
                arrayList.add((Uri) genericDocument2.toDocumentClass(Uri.class, documentClassMappingContext));
            }
        }
        return new ShareFilesToNearbyDeviceParams(namespace, id, str, arrayList);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(ShareFilesToNearbyDeviceParams shareFilesToNearbyDeviceParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(shareFilesToNearbyDeviceParams.getNamespace(), shareFilesToNearbyDeviceParams.getId(), SCHEMA_NAME);
        String targetDeviceId = shareFilesToNearbyDeviceParams.getTargetDeviceId();
        if (targetDeviceId != null) {
            builder.setPropertyString("targetDeviceId", targetDeviceId);
        }
        List<Uri> files = shareFilesToNearbyDeviceParams.getFiles();
        if (files != null) {
            GenericDocument[] genericDocumentArr = new GenericDocument[files.size()];
            Iterator<Uri> it = files.iterator();
            int i = 0;
            while (it.hasNext()) {
                genericDocumentArr[i] = GenericDocument.fromDocumentClass(it.next());
                i++;
            }
            builder.setPropertyDocument("files", genericDocumentArr);
        }
        return builder.build();
    }
}
