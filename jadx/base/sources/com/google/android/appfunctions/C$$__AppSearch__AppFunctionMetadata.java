package com.google.android.appfunctions;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.$$__AppSearch__AppFunctionMetadata, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__AppFunctionMetadata implements DocumentClassFactory<AppFunctionMetadata> {
    public static final String SCHEMA_NAME = "AppFunctionMetadata";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(AppFunctionParameterMetadata.class);
        arrayList.add(AppFunctionDataTypeMetadata.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g(Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE, C$$__AppSearch__AppFunctionDataTypeMetadata.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("parameters", C$$__AppSearch__AppFunctionParameterMetadata.SCHEMA_NAME, 1, false, AbstractC0541b.m761c("enabledByDefault", 2, new AppSearchSchema.Builder(SCHEMA_NAME)).addProperty(AbstractC0541b.m763e("description", 2, 0, 0, 0))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.util.ArrayList] */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppFunctionMetadata fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String id = genericDocument.getId();
        String namespace = genericDocument.getNamespace();
        boolean propertyBoolean = genericDocument.getPropertyBoolean("enabledByDefault");
        String[] propertyStringArray = genericDocument.getPropertyStringArray("description");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument[] propertyDocumentArray = genericDocument.getPropertyDocumentArray("parameters");
        ?? arrayList = Collections.EMPTY_LIST;
        if (propertyDocumentArray != null) {
            arrayList = new ArrayList(propertyDocumentArray.length);
            for (GenericDocument genericDocument2 : propertyDocumentArray) {
                arrayList.add((AppFunctionParameterMetadata) genericDocument2.toDocumentClass(AppFunctionParameterMetadata.class, documentClassMappingContext));
            }
        }
        GenericDocument propertyDocument = genericDocument.getPropertyDocument(Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE);
        return new AppFunctionMetadata(id, namespace, propertyBoolean, str, arrayList, propertyDocument != null ? (AppFunctionDataTypeMetadata) propertyDocument.toDocumentClass(AppFunctionDataTypeMetadata.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(AppFunctionMetadata appFunctionMetadata) {
        GenericDocument.Builder builder = new GenericDocument.Builder(appFunctionMetadata.getNamespace(), appFunctionMetadata.getId(), SCHEMA_NAME);
        int i = 0;
        builder.setPropertyBoolean("enabledByDefault", appFunctionMetadata.getEnabledByDefault());
        String description = appFunctionMetadata.getDescription();
        if (description != null) {
            builder.setPropertyString("description", description);
        }
        List<AppFunctionParameterMetadata> parameters = appFunctionMetadata.getParameters();
        if (parameters != null) {
            GenericDocument[] genericDocumentArr = new GenericDocument[parameters.size()];
            Iterator<AppFunctionParameterMetadata> it = parameters.iterator();
            while (it.hasNext()) {
                genericDocumentArr[i] = GenericDocument.fromDocumentClass(it.next());
                i++;
            }
            builder.setPropertyDocument("parameters", genericDocumentArr);
        }
        AppFunctionDataTypeMetadata returnType = appFunctionMetadata.getReturnType();
        if (returnType != null) {
            builder.setPropertyDocument(Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE, GenericDocument.fromDocumentClass(returnType));
        }
        return builder.build();
    }
}
