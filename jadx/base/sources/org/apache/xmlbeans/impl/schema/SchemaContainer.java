package org.apache.xmlbeans.impl.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class SchemaContainer {
    boolean _immutable;
    private String _namespace;
    private SchemaTypeSystem _typeSystem;
    private List _globalElements = new ArrayList();
    private List _globalAttributes = new ArrayList();
    private List _modelGroups = new ArrayList();
    private List _redefinedModelGroups = new ArrayList();
    private List _attributeGroups = new ArrayList();
    private List _redefinedAttributeGroups = new ArrayList();
    private List _globalTypes = new ArrayList();
    private List _redefinedGlobalTypes = new ArrayList();
    private List _documentTypes = new ArrayList();
    private List _attributeTypes = new ArrayList();
    private List _identityConstraints = new ArrayList();
    private List _annotations = new ArrayList();

    public SchemaContainer(String str) {
        this._namespace = str;
    }

    private void check_immutable() {
        if (this._immutable) {
            throw new IllegalStateException("Cannot add components to immutable SchemaContainer");
        }
    }

    private List getComponentList(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(((SchemaComponent.Ref) list.get(i)).getComponent());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void addAnnotation(SchemaAnnotation schemaAnnotation) {
        check_immutable();
        this._annotations.add(schemaAnnotation);
    }

    public void addAttributeGroup(SchemaAttributeGroup.Ref ref) {
        check_immutable();
        this._attributeGroups.add(ref);
    }

    public void addAttributeType(SchemaType.Ref ref) {
        check_immutable();
        this._attributeTypes.add(ref);
    }

    public void addDocumentType(SchemaType.Ref ref) {
        check_immutable();
        this._documentTypes.add(ref);
    }

    public void addGlobalAttribute(SchemaGlobalAttribute.Ref ref) {
        check_immutable();
        this._globalAttributes.add(ref);
    }

    public void addGlobalElement(SchemaGlobalElement.Ref ref) {
        check_immutable();
        this._globalElements.add(ref);
    }

    public void addGlobalType(SchemaType.Ref ref) {
        check_immutable();
        this._globalTypes.add(ref);
    }

    public void addIdentityConstraint(SchemaIdentityConstraint.Ref ref) {
        check_immutable();
        this._identityConstraints.add(ref);
    }

    public void addModelGroup(SchemaModelGroup.Ref ref) {
        check_immutable();
        this._modelGroups.add(ref);
    }

    public void addRedefinedAttributeGroup(SchemaAttributeGroup.Ref ref) {
        check_immutable();
        this._redefinedAttributeGroups.add(ref);
    }

    public void addRedefinedModelGroup(SchemaModelGroup.Ref ref) {
        check_immutable();
        this._redefinedModelGroups.add(ref);
    }

    public void addRedefinedType(SchemaType.Ref ref) {
        check_immutable();
        this._redefinedGlobalTypes.add(ref);
    }

    public List annotations() {
        return Collections.unmodifiableList(this._annotations);
    }

    public List attributeGroups() {
        return getComponentList(this._attributeGroups);
    }

    public List attributeTypes() {
        return getComponentList(this._attributeTypes);
    }

    public List documentTypes() {
        return getComponentList(this._documentTypes);
    }

    public String getNamespace() {
        return this._namespace;
    }

    public synchronized SchemaTypeSystem getTypeSystem() {
        return this._typeSystem;
    }

    public List globalAttributes() {
        return getComponentList(this._globalAttributes);
    }

    public List globalElements() {
        return getComponentList(this._globalElements);
    }

    public List globalTypes() {
        return getComponentList(this._globalTypes);
    }

    public List identityConstraints() {
        return getComponentList(this._identityConstraints);
    }

    public List modelGroups() {
        return getComponentList(this._modelGroups);
    }

    public List redefinedAttributeGroups() {
        return getComponentList(this._redefinedAttributeGroups);
    }

    public List redefinedGlobalTypes() {
        return getComponentList(this._redefinedGlobalTypes);
    }

    public List redefinedModelGroups() {
        return getComponentList(this._redefinedModelGroups);
    }

    public synchronized void setImmutable() {
        this._immutable = true;
    }

    public synchronized void setTypeSystem(SchemaTypeSystem schemaTypeSystem) {
        this._typeSystem = schemaTypeSystem;
    }

    public synchronized void unsetImmutable() {
        this._immutable = false;
    }
}
