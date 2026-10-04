package com.google.android.appfunctions.schema.common.p129v1.video;

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

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.video.$$__AppSearch__Transcript, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__Transcript implements DocumentClassFactory<Transcript> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.video.Transcript";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Uri.class);
        arrayList.add(TimedText.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("timedText", C$$__AppSearch__TimedText.SCHEMA_NAME, 1, false, AbstractC0541b.m762d("content", C$$__AppSearch__Uri.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME)).addProperty(AbstractC0541b.m763e("text", 2, 0, 0, 0)));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List] */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public Transcript fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("content");
        String str = null;
        Uri uri = propertyDocument != null ? (Uri) propertyDocument.toDocumentClass(Uri.class, documentClassMappingContext) : null;
        String[] propertyStringArray = genericDocument.getPropertyStringArray("text");
        if (propertyStringArray != null && propertyStringArray.length != 0) {
            str = propertyStringArray[0];
        }
        String str2 = str;
        GenericDocument[] propertyDocumentArray = genericDocument.getPropertyDocumentArray("timedText");
        ?? arrayList = Collections.EMPTY_LIST;
        if (propertyDocumentArray != null) {
            arrayList = new ArrayList(propertyDocumentArray.length);
            for (GenericDocument genericDocument2 : propertyDocumentArray) {
                arrayList.add((TimedText) genericDocument2.toDocumentClass(TimedText.class, documentClassMappingContext));
            }
        }
        return new Transcript(namespace, id, uri, str2, arrayList);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(Transcript transcript) {
        GenericDocument.Builder builder = new GenericDocument.Builder(transcript.getNamespace(), transcript.getId(), SCHEMA_NAME);
        Uri content = transcript.getContent();
        if (content != null) {
            builder.setPropertyDocument("content", GenericDocument.fromDocumentClass(content));
        }
        String text = transcript.getText();
        if (text != null) {
            builder.setPropertyString("text", text);
        }
        List<TimedText> timedText = transcript.getTimedText();
        if (timedText != null) {
            GenericDocument[] genericDocumentArr = new GenericDocument[timedText.size()];
            Iterator<TimedText> it = timedText.iterator();
            int i = 0;
            while (it.hasNext()) {
                genericDocumentArr[i] = GenericDocument.fromDocumentClass(it.next());
                i++;
            }
            builder.setPropertyDocument("timedText", genericDocumentArr);
        }
        return builder.build();
    }
}
