package org.apache.xmlbeans;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface SchemaTypeSystem extends SchemaTypeLoader {
    SchemaAnnotation[] annotations();

    SchemaAttributeGroup[] attributeGroups();

    SchemaType[] attributeTypes();

    SchemaType[] documentTypes();

    ClassLoader getClassLoader();

    String getName();

    SchemaGlobalAttribute[] globalAttributes();

    SchemaGlobalElement[] globalElements();

    SchemaType[] globalTypes();

    SchemaModelGroup[] modelGroups();

    void resolve();

    SchemaComponent resolveHandle(String str);

    void save(Filer filer);

    void saveToDirectory(File file);

    SchemaType typeForHandle(String str);
}
