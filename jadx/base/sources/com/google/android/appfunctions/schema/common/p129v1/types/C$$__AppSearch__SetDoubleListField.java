package com.google.android.appfunctions.schema.common.p129v1.types;

import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.types.$$__AppSearch__SetDoubleListField, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__SetDoubleListField implements DocumentClassFactory<SetDoubleListField> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.types.SetDoubleListField";

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
    public SetDoubleListField fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        double[] propertyDoubleArray = genericDocument.getPropertyDoubleArray("value");
        ?? arrayList = Collections.EMPTY_LIST;
        if (propertyDoubleArray != null) {
            arrayList = new ArrayList(propertyDoubleArray.length);
            for (double d : propertyDoubleArray) {
                arrayList.add(Double.valueOf(d));
            }
        }
        return new SetDoubleListField(namespace, id, arrayList);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(SetDoubleListField setDoubleListField) {
        GenericDocument.Builder builder = new GenericDocument.Builder(setDoubleListField.getNamespace(), setDoubleListField.getId(), SCHEMA_NAME);
        List<? extends Double> value = setDoubleListField.getValue();
        if (value != null) {
            double[] dArr = new double[value.size()];
            Iterator<? extends Double> it = value.iterator();
            int i = 0;
            while (it.hasNext()) {
                dArr[i] = it.next().doubleValue();
                i++;
            }
            builder.setPropertyDouble("value", dArr);
        }
        return builder.build();
    }
}
