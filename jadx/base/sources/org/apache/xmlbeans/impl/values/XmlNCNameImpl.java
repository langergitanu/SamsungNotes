package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.XMLChar;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XmlNCNameImpl extends JavaStringHolderEx implements XmlNCName {
    public XmlNCNameImpl() {
        super(XmlNCName.type, false);
    }

    public static void validateLexical(String str, ValidationContext validationContext) {
        if (XMLChar.isValidNCName(str)) {
            return;
        }
        validationContext.invalid(XmlErrorCodes.NCNAME, new Object[]{str});
    }

    public XmlNCNameImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
