package uk.p245ac.p246ed.p247ph.snuggletex.utilities;

import org.ccil.cowan.tagsoup.XMLWriter;
import uk.p245ac.p246ed.p247ph.snuggletex.SerializationMethod;
import uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleLogicException;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ConstraintUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ObjectUtilities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class SerializationOptions implements SerializationSpecifier, Cloneable {
    private String doctypePublic;
    private String doctypeSystem;
    private boolean includingXMLDeclaration;
    private boolean indenting;
    private boolean usingNamedEntities;
    private SerializationMethod serializationMethod = SerializationMethod.XML;
    private String encoding = "UTF-8";
    private int indent = 2;

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new SnuggleLogicException(e);
        }
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public String getDoctypePublic() {
        return this.doctypePublic;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public String getDoctypeSystem() {
        return this.doctypeSystem;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public String getEncoding() {
        return this.encoding;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public int getIndent() {
        return this.indent;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public SerializationMethod getSerializationMethod() {
        return this.serializationMethod;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public boolean isIncludingXMLDeclaration() {
        return this.includingXMLDeclaration;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public boolean isIndenting() {
        return this.indenting;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public boolean isUsingNamedEntities() {
        return this.usingNamedEntities;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public void setDoctypePublic(String str) {
        this.doctypePublic = str;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public void setDoctypeSystem(String str) {
        this.doctypeSystem = str;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public void setEncoding(String str) {
        ConstraintUtilities.ensureNotNull(str, XMLWriter.ENCODING);
        this.encoding = str;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public void setIncludingXMLDeclaration(boolean z) {
        this.includingXMLDeclaration = z;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public void setIndent(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("indent must be non-negative");
        }
        this.indent = i;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public void setIndenting(boolean z) {
        this.indenting = z;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public void setSerializationMethod(SerializationMethod serializationMethod) {
        ConstraintUtilities.ensureNotNull(serializationMethod, "serializationMethod");
        this.serializationMethod = serializationMethod;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public void setUsingNamedEntities(boolean z) {
        this.usingNamedEntities = z;
    }

    public String toString() {
        return ObjectUtilities.beanToString(this);
    }
}
