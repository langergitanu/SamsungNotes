package org.apache.xmlbeans;

import java.math.BigInteger;
import org.apache.poi.javax.xml.namespace.QName;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface SchemaParticle {
    public static final int ALL = 1;
    public static final int CHOICE = 2;
    public static final int ELEMENT = 4;
    public static final int LAX = 2;
    public static final int SEQUENCE = 3;
    public static final int SKIP = 3;
    public static final int STRICT = 1;
    public static final int WILDCARD = 5;

    QNameSet acceptedStartNames();

    boolean canStartWithElement(QName qName);

    int countOfParticleChild();

    String getDefaultText();

    XmlAnySimpleType getDefaultValue();

    int getIntMaxOccurs();

    int getIntMinOccurs();

    BigInteger getMaxOccurs();

    BigInteger getMinOccurs();

    QName getName();

    SchemaParticle getParticleChild(int i);

    SchemaParticle[] getParticleChildren();

    int getParticleType();

    SchemaType getType();

    int getWildcardProcess();

    QNameSet getWildcardSet();

    boolean isDefault();

    boolean isFixed();

    boolean isNillable();

    boolean isSingleton();

    boolean isSkippable();
}
