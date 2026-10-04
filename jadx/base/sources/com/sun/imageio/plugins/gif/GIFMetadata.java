package com.sun.imageio.plugins.gif;

import androidx.appcompat.widget.AbstractC0541b;
import org.apache.poi.javax.imageio.metadata.IIOInvalidTreeException;
import org.apache.poi.javax.imageio.metadata.IIOMetadata;
import org.apache.poi.javax.imageio.metadata.IIOMetadataFormatImpl;
import org.w3c.dom.Node;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
abstract class GIFMetadata extends IIOMetadata {
    static final int UNDEFINED_INTEGER_VALUE = -1;

    public GIFMetadata(boolean z, String str, String str2, String[] strArr, String[] strArr2) {
        super(z, str, str2, strArr, strArr2);
    }

    public static void fatal(Node node, String str) throws IIOInvalidTreeException {
        throw new IIOInvalidTreeException(str, node);
    }

    public static String getAttribute(Node node, String str, String str2, boolean z) throws IIOInvalidTreeException {
        Node namedItem = node.getAttributes().getNamedItem(str);
        if (namedItem == null) {
            if (!z) {
                return str2;
            }
            fatal(node, AbstractC0541b.m773o("Required attribute ", str, " not present!"));
        }
        return namedItem.getNodeValue();
    }

    public static boolean getBooleanAttribute(Node node, String str, boolean z, boolean z2) throws IIOInvalidTreeException {
        Node namedItem = node.getAttributes().getNamedItem(str);
        if (namedItem == null) {
            if (!z2) {
                return z;
            }
            fatal(node, AbstractC0541b.m773o("Required attribute ", str, " not present!"));
        }
        String nodeValue = namedItem.getNodeValue();
        if (nodeValue.equals("TRUE") || nodeValue.equals("true")) {
            return true;
        }
        if (!nodeValue.equals("FALSE") && !nodeValue.equals("false")) {
            fatal(node, AbstractC0541b.m773o("Attribute ", str, " must be 'TRUE' or 'FALSE'!"));
        }
        return false;
    }

    public static int getEnumeratedAttribute(Node node, String str, String[] strArr, int i, boolean z) throws IIOInvalidTreeException {
        Node namedItem = node.getAttributes().getNamedItem(str);
        if (namedItem == null) {
            if (!z) {
                return i;
            }
            fatal(node, AbstractC0541b.m773o("Required attribute ", str, " not present!"));
        }
        String nodeValue = namedItem.getNodeValue();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (nodeValue.equals(strArr[i2])) {
                return i2;
            }
        }
        fatal(node, AbstractC0541b.m773o("Illegal value for attribute ", str, "!"));
        return -1;
    }

    public static float getFloatAttribute(Node node, String str, float f, boolean z) throws IIOInvalidTreeException {
        String stringAttribute = getStringAttribute(node, str, null, z, null);
        return stringAttribute == null ? f : Float.parseFloat(stringAttribute);
    }

    public static int getIntAttribute(Node node, String str, int i, boolean z, boolean z2, int i2, int i4) throws IIOInvalidTreeException {
        String stringAttribute = getStringAttribute(node, str, null, z, null);
        if (stringAttribute != null && !"".equals(stringAttribute)) {
            try {
                i = Integer.parseInt(stringAttribute);
            } catch (NumberFormatException unused) {
                fatal(node, "Bad value for " + node.getNodeName() + " attribute " + str + "!");
            }
            if (z2 && (i < i2 || i > i4)) {
                fatal(node, "Bad value for " + node.getNodeName() + " attribute " + str + "!");
            }
        }
        return i;
    }

    public static String getStringAttribute(Node node, String str, String str2, boolean z, String[] strArr) throws IIOInvalidTreeException {
        Node namedItem = node.getAttributes().getNamedItem(str);
        if (namedItem == null) {
            if (!z) {
                return str2;
            }
            fatal(node, AbstractC0541b.m773o("Required attribute ", str, " not present!"));
        }
        String nodeValue = namedItem.getNodeValue();
        if (strArr != null) {
            if (nodeValue == null) {
                fatal(node, "Null value for " + node.getNodeName() + " attribute " + str + "!");
            }
            for (String str3 : strArr) {
                if (nodeValue.equals(str3)) {
                    return nodeValue;
                }
            }
            fatal(node, "Bad value for " + node.getNodeName() + " attribute " + str + "!");
        }
        return nodeValue;
    }

    public byte[] getColorTable(Node node, String str, boolean z, int i) throws IIOInvalidTreeException {
        int i2;
        byte[] bArr = new byte[256];
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        Node firstChild = node.getFirstChild();
        if (firstChild == null) {
            fatal(node, "Palette has no entries!");
        }
        int i4 = -1;
        while (true) {
            if (firstChild == null) {
                break;
            }
            if (!firstChild.getNodeName().equals(str)) {
                StringBuilder sbM15l = AbstractC0000a.m15l("Only a ", str, " may be a child of a ");
                sbM15l.append(firstChild.getNodeName());
                sbM15l.append("!");
                fatal(node, sbM15l.toString());
            }
            int intAttribute = getIntAttribute(firstChild, "index", true, 0, 255);
            if (intAttribute > i4) {
                i4 = intAttribute;
            }
            bArr[intAttribute] = (byte) getIntAttribute(firstChild, "red", true, 0, 255);
            bArr2[intAttribute] = (byte) getIntAttribute(firstChild, "green", true, 0, 255);
            bArr3[intAttribute] = (byte) getIntAttribute(firstChild, "blue", true, 0, 255);
            firstChild = firstChild.getNextSibling();
        }
        int i5 = i4 + 1;
        if (z && i5 != i) {
            fatal(node, "Unexpected length for palette!");
        }
        byte[] bArr4 = new byte[i5 * 3];
        int i6 = 0;
        for (i2 = 0; i2 < i5; i2++) {
            bArr4[i6] = bArr[i2];
            int i7 = i6 + 2;
            bArr4[i6 + 1] = bArr2[i2];
            i6 += 3;
            bArr4[i7] = bArr3[i2];
        }
        return bArr4;
    }

    public abstract void mergeNativeTree(Node node);

    public abstract void mergeStandardTree(Node node);

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public void mergeTree(String str, Node node) {
        if (str.equals(this.nativeMetadataFormatName)) {
            if (node == null) {
                throw new IllegalArgumentException("root == null!");
            }
            mergeNativeTree(node);
        } else {
            if (!str.equals(IIOMetadataFormatImpl.standardMetadataFormatName)) {
                throw new IllegalArgumentException("Not a recognized format!");
            }
            if (node == null) {
                throw new IllegalArgumentException("root == null!");
            }
            mergeStandardTree(node);
        }
    }

    public static float getFloatAttribute(Node node, String str) {
        return getFloatAttribute(node, str, -1.0f, true);
    }

    public static int getIntAttribute(Node node, String str, boolean z, int i, int i2) {
        return getIntAttribute(node, str, -1, true, z, i, i2);
    }

    public static String getAttribute(Node node, String str) {
        return getAttribute(node, str, null, true);
    }

    public static boolean getBooleanAttribute(Node node, String str) {
        return getBooleanAttribute(node, str, false, true);
    }

    public static int getEnumeratedAttribute(Node node, String str, String[] strArr) {
        return getEnumeratedAttribute(node, str, strArr, -1, true);
    }
}
