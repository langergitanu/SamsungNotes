package uk.p245ac.p246ed.p247ph.snuggletex;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public interface SerializationSpecifier {
    public static final String DEFAULT_ENCODING = "UTF-8";
    public static final int DEFAULT_INDENT = 2;

    String getDoctypePublic();

    String getDoctypeSystem();

    String getEncoding();

    int getIndent();

    SerializationMethod getSerializationMethod();

    boolean isIncludingXMLDeclaration();

    boolean isIndenting();

    boolean isUsingNamedEntities();

    void setDoctypePublic(String str);

    void setDoctypeSystem(String str);

    void setEncoding(String str);

    void setIncludingXMLDeclaration(boolean z);

    void setIndent(int i);

    void setIndenting(boolean z);

    void setSerializationMethod(SerializationMethod serializationMethod);

    void setUsingNamedEntities(boolean z);
}
