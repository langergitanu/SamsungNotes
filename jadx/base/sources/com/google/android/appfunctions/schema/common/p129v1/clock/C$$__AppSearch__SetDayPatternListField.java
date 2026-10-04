package com.google.android.appfunctions.schema.common.p129v1.clock;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.clock.$$__AppSearch__SetDayPatternListField, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__SetDayPatternListField implements DocumentClassFactory<SetDayPatternListField> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.clock.SetDayPatternListField";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(DayPattern.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("value", C$$__AppSearch__DayPattern.SCHEMA_NAME, 1, false, new AppSearchSchema.Builder(SCHEMA_NAME));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.ArrayList] */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public SetDayPatternListField fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        GenericDocument[] propertyDocumentArray = genericDocument.getPropertyDocumentArray("value");
        ?? arrayList = Collections.EMPTY_LIST;
        if (propertyDocumentArray != null) {
            arrayList = new ArrayList(propertyDocumentArray.length);
            for (GenericDocument genericDocument2 : propertyDocumentArray) {
                arrayList.add((DayPattern) genericDocument2.toDocumentClass(DayPattern.class, documentClassMappingContext));
            }
        }
        return new SetDayPatternListField(namespace, id, arrayList);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(SetDayPatternListField setDayPatternListField) {
        GenericDocument.Builder builder = new GenericDocument.Builder(setDayPatternListField.getNamespace(), setDayPatternListField.getId(), SCHEMA_NAME);
        List<? extends DayPattern> value = setDayPatternListField.getValue();
        if (value != null) {
            GenericDocument[] genericDocumentArr = new GenericDocument[value.size()];
            Iterator<? extends DayPattern> it = value.iterator();
            int i = 0;
            while (it.hasNext()) {
                genericDocumentArr[i] = GenericDocument.fromDocumentClass(it.next());
                i++;
            }
            builder.setPropertyDocument("value", genericDocumentArr);
        }
        return builder.build();
    }
}
