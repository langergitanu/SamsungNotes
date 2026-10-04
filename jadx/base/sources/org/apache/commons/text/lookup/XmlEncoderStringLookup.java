package org.apache.commons.text.lookup;

import org.apache.commons.text.StringEscapeUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class XmlEncoderStringLookup extends AbstractStringLookup {
    static final XmlEncoderStringLookup INSTANCE = new XmlEncoderStringLookup();

    @Override // org.apache.commons.text.lookup.StringLookup
    public String lookup(String str) {
        return StringEscapeUtils.escapeXml10(str);
    }
}
