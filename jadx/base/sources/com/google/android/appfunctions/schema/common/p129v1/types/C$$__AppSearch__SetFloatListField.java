package com.google.android.appfunctions.schema.common.p129v1.types;

import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.types.$$__AppSearch__SetFloatListField, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__SetFloatListField implements DocumentClassFactory<SetFloatListField> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.types.SetFloatListField";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(new AppSearchSchema.DoublePropertyConfig.Builder("value").setCardinality(1).build()).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.ArrayList] */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public SetFloatListField fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        double[] propertyDoubleArray = genericDocument.getPropertyDoubleArray("value");
        ?? arrayList = Collections.EMPTY_LIST;
        if (propertyDoubleArray != null) {
            arrayList = new ArrayList(propertyDoubleArray.length);
            for (double d : propertyDoubleArray) {
                arrayList.add(Float.valueOf((float) d));
            }
        }
        return new SetFloatListField(namespace, id, arrayList);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(SetFloatListField setFloatListField) {
        GenericDocument.Builder builder = new GenericDocument.Builder(setFloatListField.getNamespace(), setFloatListField.getId(), SCHEMA_NAME);
        List<? extends Float> value = setFloatListField.getValue();
        if (value != null) {
            double[] dArr = new double[value.size()];
            Iterator<? extends Float> it = value.iterator();
            int i = 0;
            while (it.hasNext()) {
                dArr[i] = it.next().floatValue();
                i++;
            }
            builder.setPropertyDouble("value", dArr);
        }
        return builder.build();
    }
}
