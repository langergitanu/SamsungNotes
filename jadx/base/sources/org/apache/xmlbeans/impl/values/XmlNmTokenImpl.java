package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlNMTOKEN;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.XMLChar;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XmlNmTokenImpl extends JavaStringHolderEx implements XmlNMTOKEN {
    public XmlNmTokenImpl() {
        super(XmlNMTOKEN.type, false);
    }

    public static void validateLexical(String str, ValidationContext validationContext) {
        if (XMLChar.isValidNmtoken(str)) {
            return;
        }
        validationContext.invalid(XmlErrorCodes.NMTOKEN, new Object[]{str});
    }

    public XmlNmTokenImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
