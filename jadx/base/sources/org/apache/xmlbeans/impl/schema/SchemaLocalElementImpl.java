package org.apache.xmlbeans.impl.schema;

import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.soap.SOAPArrayType;
import org.apache.xmlbeans.soap.SchemaWSDLArrayType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SchemaLocalElementImpl extends SchemaParticleImpl implements SchemaLocalElement, SchemaWSDLArrayType {
    protected boolean _abs;
    private SchemaAnnotation _annotation;
    private boolean _blockExt;
    private boolean _blockRest;
    private boolean _blockSubst;
    private SchemaIdentityConstraint.Ref[] _constraints = new SchemaIdentityConstraint.Ref[0];
    private SOAPArrayType _wsdlArrayType;

    public SchemaLocalElementImpl() {
        setParticleType(4);
    }

    @Override // org.apache.xmlbeans.SchemaLocalElement
    public boolean blockExtension() {
        return this._blockExt;
    }

    @Override // org.apache.xmlbeans.SchemaLocalElement
    public boolean blockRestriction() {
        return this._blockRest;
    }

    @Override // org.apache.xmlbeans.SchemaLocalElement
    public boolean blockSubstitution() {
        return this._blockSubst;
    }

    @Override // org.apache.xmlbeans.SchemaAnnotated
    public SchemaAnnotation getAnnotation() {
        return this._annotation;
    }

    public SchemaIdentityConstraint.Ref[] getIdentityConstraintRefs() {
        SchemaIdentityConstraint.Ref[] refArr = this._constraints;
        int length = refArr.length;
        SchemaIdentityConstraint.Ref[] refArr2 = new SchemaIdentityConstraint.Ref[length];
        System.arraycopy(refArr, 0, refArr2, 0, length);
        return refArr2;
    }

    @Override // org.apache.xmlbeans.SchemaLocalElement
    public SchemaIdentityConstraint[] getIdentityConstraints() {
        int length = this._constraints.length;
        SchemaIdentityConstraint[] schemaIdentityConstraintArr = new SchemaIdentityConstraint[length];
        for (int i = 0; i < length; i++) {
            schemaIdentityConstraintArr[i] = this._constraints[i].get();
        }
        return schemaIdentityConstraintArr;
    }

    @Override // org.apache.xmlbeans.soap.SchemaWSDLArrayType
    public SOAPArrayType getWSDLArrayType() {
        return this._wsdlArrayType;
    }

    @Override // org.apache.xmlbeans.SchemaLocalElement
    public boolean isAbstract() {
        return this._abs;
    }

    public void setAbstract(boolean z) {
        this._abs = z;
    }

    public void setAnnotation(SchemaAnnotation schemaAnnotation) {
        this._annotation = schemaAnnotation;
    }

    public void setBlock(boolean z, boolean z2, boolean z3) {
        mutate();
        this._blockExt = z;
        this._blockRest = z2;
        this._blockSubst = z3;
    }

    public void setIdentityConstraints(SchemaIdentityConstraint.Ref[] refArr) {
        mutate();
        this._constraints = refArr;
    }

    public void setWsdlArrayType(SOAPArrayType sOAPArrayType) {
        this._wsdlArrayType = sOAPArrayType;
    }
}
