package com.google.android.appfunctions.schema.common.p129v1.types;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import androidx.compose.foundation.layout.AbstractC1038a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.types.$$__AppSearch__SetIntListField, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__SetIntListField implements DocumentClassFactory<SetIntListField> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.types.SetIntListField";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m764f("value", 1, 0, new AppSearchSchema.Builder(SCHEMA_NAME));
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
    public SetIntListField fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        long[] propertyLongArray = genericDocument.getPropertyLongArray("value");
        ?? arrayList = Collections.EMPTY_LIST;
        if (propertyLongArray != null) {
            arrayList = new ArrayList(propertyLongArray.length);
            for (int iM1200a = 0; iM1200a < propertyLongArray.length; iM1200a = AbstractC1038a.m1200a((int) propertyLongArray[iM1200a], iM1200a, 1, arrayList)) {
            }
        }
        return new SetIntListField(namespace, id, arrayList);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(SetIntListField setIntListField) {
        GenericDocument.Builder builder = new GenericDocument.Builder(setIntListField.getNamespace(), setIntListField.getId(), SCHEMA_NAME);
        List<? extends Integer> value = setIntListField.getValue();
        if (value != null) {
            long[] jArr = new long[value.size()];
            Iterator<? extends Integer> it = value.iterator();
            int i = 0;
            while (it.hasNext()) {
                jArr[i] = it.next().intValue();
                i++;
            }
            builder.setPropertyLong("value", jArr);
        }
        return builder.build();
    }
}
