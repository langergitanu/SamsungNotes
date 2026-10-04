package org.codehaus.stax2.p230ri.evt;

import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.events.Namespace;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NamespaceEventImpl extends AttributeEventImpl implements Namespace {
    final String mPrefix;
    final String mURI;

    public NamespaceEventImpl(Location location, String str) {
        super(location, XMLConstants.XMLNS_ATTRIBUTE, "http://www.w3.org/2000/xmlns/", null, str, true);
        this.mPrefix = "";
        this.mURI = str;
    }

    public static NamespaceEventImpl constructDefaultNamespace(Location location, String str) {
        return new NamespaceEventImpl(location, str);
    }

    public static NamespaceEventImpl constructNamespace(Location location, String str, String str2) {
        return (str == null || str.length() == 0) ? new NamespaceEventImpl(location, str2) : new NamespaceEventImpl(location, str, str2);
    }

    @Override // org.codehaus.stax2.p230ri.evt.AttributeEventImpl, org.codehaus.stax2.p230ri.evt.BaseEventImpl, org.apache.poi.javax.xml.stream.events.XMLEvent
    public int getEventType() {
        return 13;
    }

    @Override // org.apache.poi.javax.xml.stream.events.Namespace
    public String getNamespaceURI() {
        return this.mURI;
    }

    @Override // org.apache.poi.javax.xml.stream.events.Namespace
    public String getPrefix() {
        return this.mPrefix;
    }

    @Override // org.apache.poi.javax.xml.stream.events.Namespace
    public boolean isDefaultNamespaceDeclaration() {
        return this.mPrefix.length() == 0;
    }

    @Override // org.codehaus.stax2.p230ri.evt.BaseEventImpl, org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isNamespace() {
        return true;
    }

    public NamespaceEventImpl(Location location, String str, String str2) {
        super(location, str, "http://www.w3.org/2000/xmlns/", XMLConstants.XMLNS_ATTRIBUTE, str2, true);
        this.mPrefix = str;
        this.mURI = str2;
    }
}
