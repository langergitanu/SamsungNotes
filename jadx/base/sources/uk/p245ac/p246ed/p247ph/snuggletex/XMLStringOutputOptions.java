package uk.p245ac.p246ed.p247ph.snuggletex;

import uk.p245ac.p246ed.p247ph.snuggletex.utilities.SerializationOptions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class XMLStringOutputOptions extends DOMOutputOptions implements SerializationSpecifier {
    private final SerializationOptions serializationOptions = new SerializationOptions();

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public String getDoctypePublic() {
        return this.serializationOptions.getDoctypePublic();
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public String getDoctypeSystem() {
        return this.serializationOptions.getDoctypeSystem();
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public String getEncoding() {
        return this.serializationOptions.getEncoding();
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public int getIndent() {
        return this.serializationOptions.getIndent();
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public SerializationMethod getSerializationMethod() {
        return this.serializationOptions.getSerializationMethod();
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public boolean isIncludingXMLDeclaration() {
        return this.serializationOptions.isIncludingXMLDeclaration();
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public boolean isIndenting() {
        return this.serializationOptions.isIndenting();
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public boolean isUsingNamedEntities() {
        return this.serializationOptions.isUsingNamedEntities();
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public void setDoctypePublic(String str) {
        this.serializationOptions.setDoctypePublic(str);
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public void setDoctypeSystem(String str) {
        this.serializationOptions.setDoctypeSystem(str);
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public void setEncoding(String str) {
        this.serializationOptions.setEncoding(str);
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public void setIncludingXMLDeclaration(boolean z) {
        this.serializationOptions.setIncludingXMLDeclaration(z);
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public void setIndent(int i) {
        this.serializationOptions.setIndent(i);
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public void setIndenting(boolean z) {
        this.serializationOptions.setIndenting(z);
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public void setSerializationMethod(SerializationMethod serializationMethod) {
        this.serializationOptions.setSerializationMethod(serializationMethod);
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier
    public void setUsingNamedEntities(boolean z) {
        this.serializationOptions.setUsingNamedEntities(z);
    }
}
