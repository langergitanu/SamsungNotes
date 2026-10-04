package com.adobe.internal.xmp.impl;

import com.adobe.internal.xmp.XMPConst;
import com.adobe.internal.xmp.XMPException;
import com.adobe.internal.xmp.XMPMeta;
import com.adobe.internal.xmp.XMPMetaFactory;
import com.adobe.internal.xmp.impl.xpath.XMPPath;
import com.adobe.internal.xmp.impl.xpath.XMPPathParser;
import com.adobe.internal.xmp.options.PropertyOptions;
import com.adobe.internal.xmp.options.SerializeOptions;
import com.adobe.internal.xmp.options.TemplateOptions;
import com.adobe.internal.xmp.properties.XMPAliasInfo;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class XMPUtilsImpl implements XMPConst {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String COMMAS = ",，､﹐﹑、،՝";
    private static final String CONTROLS = "\u2028\u2029";
    private static final String QUOTES = "\"«»〝〞〟―‹›";
    private static final String SEMICOLA = ";；﹔؛;";
    private static final String SPACES = " \u3000〿";
    private static final int UCK_COMMA = 2;
    private static final int UCK_CONTROL = 5;
    private static final int UCK_NORMAL = 0;
    private static final int UCK_QUOTE = 4;
    private static final int UCK_SEMICOLON = 3;
    private static final int UCK_SPACE = 1;

    private XMPUtilsImpl() {
    }

    public static void appendProperties(XMPMeta xMPMeta, XMPMeta xMPMeta2, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        ParameterAsserts.assertImplementation(xMPMeta);
        ParameterAsserts.assertImplementation(xMPMeta2);
        XMPMetaImpl xMPMetaImpl = (XMPMetaImpl) xMPMeta2;
        Iterator itIterateChildren = ((XMPMetaImpl) xMPMeta).getRoot().iterateChildren();
        while (itIterateChildren.hasNext()) {
            XMPNode xMPNode = (XMPNode) itIterateChildren.next();
            XMPNode xMPNodeFindSchemaNode = XMPNodeUtils.findSchemaNode(xMPMetaImpl.getRoot(), xMPNode.getName(), false);
            if (xMPNodeFindSchemaNode == null) {
                xMPNodeFindSchemaNode = new XMPNode(xMPNode.getName(), xMPNode.getValue(), new PropertyOptions().setSchemaNode(true));
                xMPMetaImpl.getRoot().addChild(xMPNodeFindSchemaNode);
                z4 = true;
            } else {
                z4 = false;
            }
            XMPNode xMPNode2 = xMPNodeFindSchemaNode;
            Iterator itIterateChildren2 = xMPNode.iterateChildren();
            while (itIterateChildren2.hasNext()) {
                XMPNode xMPNode3 = (XMPNode) itIterateChildren2.next();
                if (z || !Utils.isInternalProperty(xMPNode.getName(), xMPNode3.getName())) {
                    z5 = z2;
                    z6 = z3;
                    appendSubtree(xMPMetaImpl, xMPNode3, xMPNode2, false, z5, z6);
                } else {
                    z5 = z2;
                    z6 = z3;
                }
                z2 = z5;
                z3 = z6;
            }
            boolean z7 = z2;
            boolean z8 = z3;
            if (!xMPNode2.hasChildren() && (z4 || z8)) {
                xMPMetaImpl.getRoot().removeChild(xMPNode2);
            }
            z2 = z7;
            z3 = z8;
        }
    }

    private static void appendSubtree(XMPMetaImpl xMPMetaImpl, XMPNode xMPNode, XMPNode xMPNode2, boolean z, boolean z2, boolean z3) throws XMPException {
        boolean z4;
        XMPNode xMPNode3;
        XMPNode xMPNodeFindChildNode = XMPNodeUtils.findChildNode(xMPNode2, xMPNode.getName(), false);
        if (!xMPNode.getOptions().isSimple() ? xMPNode.hasChildren() : !(xMPNode.getValue() == null || xMPNode.getValue().length() == 0)) {
            if (!z3 || xMPNodeFindChildNode == null) {
                return;
            }
            xMPNode2.removeChild(xMPNodeFindChildNode);
            return;
        }
        if (xMPNodeFindChildNode == null) {
            XMPNode xMPNode4 = (XMPNode) xMPNode.clone(true);
            if (xMPNode4 != null) {
                xMPNode2.addChild(xMPNode4);
                return;
            }
            return;
        }
        PropertyOptions options = xMPNode.getOptions();
        if ((!z || options.isSimple()) ? z2 : false) {
            xMPNode2.removeChild(xMPNodeFindChildNode);
            XMPNode xMPNode5 = (XMPNode) xMPNode.clone(true);
            if (xMPNode5 != null) {
                xMPNode2.addChild(xMPNode5);
                return;
            }
            return;
        }
        if (options.getOptions() != xMPNodeFindChildNode.getOptions().getOptions() || options.isSimple()) {
            return;
        }
        if (options.isStruct()) {
            Iterator itIterateChildren = xMPNode.iterateChildren();
            while (itIterateChildren.hasNext()) {
                XMPMetaImpl xMPMetaImpl2 = xMPMetaImpl;
                boolean z5 = z;
                boolean z6 = z2;
                boolean z7 = z3;
                appendSubtree(xMPMetaImpl2, (XMPNode) itIterateChildren.next(), xMPNodeFindChildNode, z5, z6, z7);
                if (z7 && !xMPNodeFindChildNode.hasChildren()) {
                    xMPNode2.removeChild(xMPNodeFindChildNode);
                }
                xMPMetaImpl = xMPMetaImpl2;
                z = z5;
                z2 = z6;
                z3 = z7;
            }
            return;
        }
        if (!options.isArrayAltText()) {
            if (options.isArray()) {
                Iterator itIterateChildren2 = xMPNode.iterateChildren();
                while (itIterateChildren2.hasNext()) {
                    XMPNode xMPNode6 = (XMPNode) itIterateChildren2.next();
                    Iterator itIterateChildren3 = xMPNodeFindChildNode.iterateChildren();
                    while (true) {
                        if (!itIterateChildren3.hasNext()) {
                            z4 = false;
                            break;
                        } else if (itemValuesMatch(xMPNode6, (XMPNode) itIterateChildren3.next())) {
                            z4 = true;
                            break;
                        }
                    }
                    if (!z4 && (xMPNode3 = (XMPNode) xMPNode6.clone(true)) != null) {
                        xMPNodeFindChildNode.addChild(xMPNode3);
                    }
                }
                return;
            }
            return;
        }
        Iterator itIterateChildren4 = xMPNode.iterateChildren();
        while (itIterateChildren4.hasNext()) {
            XMPNode xMPNode7 = (XMPNode) itIterateChildren4.next();
            if (xMPNode7.hasQualifier() && XMPConst.XML_LANG.equals(xMPNode7.getQualifier(1).getName())) {
                int iLookupLanguageItem = XMPNodeUtils.lookupLanguageItem(xMPNodeFindChildNode, xMPNode7.getQualifier(1).getValue());
                if (xMPNode7.getValue() == null || xMPNode7.getValue().length() == 0) {
                    if (z3 && iLookupLanguageItem != -1) {
                        xMPNodeFindChildNode.removeChild(iLookupLanguageItem);
                        if (!xMPNodeFindChildNode.hasChildren()) {
                            xMPNode2.removeChild(xMPNodeFindChildNode);
                        }
                    }
                } else if (iLookupLanguageItem == -1) {
                    if (XMPConst.X_DEFAULT.equals(xMPNode7.getQualifier(1).getValue()) && xMPNodeFindChildNode.hasChildren()) {
                        XMPNode xMPNode8 = new XMPNode(xMPNode7.getName(), xMPNode7.getValue(), xMPNode7.getOptions());
                        xMPNode7.cloneSubtree(xMPNode8, true);
                        xMPNodeFindChildNode.addChild(1, xMPNode8);
                    } else {
                        XMPNode xMPNode9 = (XMPNode) xMPNode7.clone(true);
                        if (xMPNode9 != null) {
                            xMPNodeFindChildNode.addChild(xMPNode9);
                        }
                    }
                } else if (z2) {
                    xMPNodeFindChildNode.getChild(iLookupLanguageItem).setValue(xMPNode7.getValue());
                }
            }
        }
    }

    private static String applyQuotes(String str, char c, char c2, boolean z) {
        if (str == null) {
            str = "";
        }
        int i = 0;
        boolean z2 = false;
        while (i < str.length()) {
            int iClassifyCharacter = classifyCharacter(str.charAt(i));
            if (i == 0 && iClassifyCharacter == 4) {
                break;
            }
            if (iClassifyCharacter == 1) {
                if (z2) {
                    break;
                }
                z2 = true;
                i++;
            } else {
                if (iClassifyCharacter == 3 || iClassifyCharacter == 5 || (iClassifyCharacter == 2 && !z)) {
                    break;
                }
                z2 = false;
                i++;
            }
        }
        if (i >= str.length()) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str.length() + 2);
        int i2 = 0;
        while (i2 <= i && classifyCharacter(str.charAt(i)) != 4) {
            i2++;
        }
        stringBuffer.append(c);
        stringBuffer.append(str.substring(0, i2));
        while (i2 < str.length()) {
            stringBuffer.append(str.charAt(i2));
            if (classifyCharacter(str.charAt(i2)) == 4 && isSurroundingQuote(str.charAt(i2), c, c2)) {
                stringBuffer.append(str.charAt(i2));
            }
            i2++;
        }
        stringBuffer.append(c2);
        return stringBuffer.toString();
    }

    public static void applyTemplate(XMPMeta xMPMeta, XMPMeta xMPMeta2, TemplateOptions templateOptions) {
        XMPMetaImpl xMPMetaImpl = (XMPMetaImpl) xMPMeta;
        XMPMetaImpl xMPMetaImpl2 = (XMPMetaImpl) xMPMeta2;
        boolean z = false;
        boolean z2 = (templateOptions.getOptions() & 2) != 0;
        boolean z3 = (templateOptions.getOptions() & 64) != 0;
        boolean z4 = (templateOptions.getOptions() & 16) != 0;
        boolean z5 = (templateOptions.getOptions() & 128) != 0;
        boolean z6 = z4 | z5;
        boolean z7 = (!z2) & z5;
        boolean z8 = (templateOptions.getOptions() & 32) != 0;
        if (z2) {
            for (int childrenLength = xMPMetaImpl.getRoot().getChildrenLength(); childrenLength > 0; childrenLength--) {
                XMPNode child = xMPMetaImpl.getRoot().getChild(childrenLength);
                XMPNode xMPNodeFindSchemaNode = XMPNodeUtils.findSchemaNode(xMPMetaImpl2.getRoot(), child.getName(), false);
                if (xMPNodeFindSchemaNode != null) {
                    for (int childrenLength2 = child.getChildrenLength(); childrenLength2 > 0; childrenLength2--) {
                        XMPNode child2 = child.getChild(childrenLength2);
                        if ((z8 || !Utils.isInternalProperty(child.getName(), child2.getName())) && XMPNodeUtils.findChildNode(xMPNodeFindSchemaNode, child2.getName(), false) == null) {
                            child.removeChild(childrenLength2);
                        }
                    }
                } else if (z8) {
                    child.removeChildren();
                } else {
                    for (int childrenLength3 = child.getChildrenLength(); childrenLength3 > 0; childrenLength3--) {
                        if (!Utils.isInternalProperty(child.getName(), child.getChild(childrenLength3).getName())) {
                            child.removeChild(childrenLength3);
                        }
                    }
                }
                if (!child.hasChildren()) {
                    xMPMetaImpl.getRoot().removeChild(childrenLength);
                }
            }
        }
        if (z3 || z6) {
            int childrenLength4 = xMPMetaImpl2.getRoot().getChildrenLength();
            int i = 0;
            while (i < childrenLength4) {
                int i2 = i + 1;
                XMPNode child3 = xMPMetaImpl2.getRoot().getChild(i2);
                XMPNode xMPNodeFindSchemaNode2 = XMPNodeUtils.findSchemaNode(xMPMetaImpl.getRoot(), child3.getName(), z);
                if (xMPNodeFindSchemaNode2 == null) {
                    xMPNodeFindSchemaNode2 = new XMPNode(child3.getName(), child3.getValue(), new PropertyOptions(Integer.MIN_VALUE));
                    xMPMetaImpl.getRoot().addChild(xMPNodeFindSchemaNode2);
                    xMPNodeFindSchemaNode2.setParent(xMPMetaImpl.getRoot());
                }
                int childrenLength5 = child3.getChildrenLength();
                int i4 = 1;
                while (i4 <= childrenLength5) {
                    boolean z9 = z6;
                    XMPNode xMPNode = xMPNodeFindSchemaNode2;
                    XMPNode child4 = child3.getChild(i4);
                    if (z8 || !Utils.isInternalProperty(child3.getName(), child4.getName())) {
                        appendSubtree(xMPMetaImpl, child4, xMPNode, z3, z9, z7);
                    }
                    i4++;
                    xMPNodeFindSchemaNode2 = xMPNode;
                    z6 = z9;
                }
                boolean z10 = z6;
                XMPNode xMPNode2 = xMPNodeFindSchemaNode2;
                if (!xMPNode2.hasChildren()) {
                    xMPMetaImpl.getRoot().removeChild(xMPNode2);
                }
                z6 = z10;
                i = i2;
                z = false;
            }
        }
    }

    public static String catenateArrayItems(XMPMeta xMPMeta, String str, String str2, String str3, String str4, boolean z) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertArrayName(str2);
        ParameterAsserts.assertImplementation(xMPMeta);
        if (str3 == null || str3.length() == 0) {
            str3 = "; ";
        }
        if (str4 == null || str4.length() == 0) {
            str4 = "\"";
        }
        XMPNode xMPNodeFindNode = XMPNodeUtils.findNode(((XMPMetaImpl) xMPMeta).getRoot(), XMPPathParser.expandXPath(str, str2), false, null);
        if (xMPNodeFindNode == null) {
            return "";
        }
        if (!xMPNodeFindNode.getOptions().isArray() || xMPNodeFindNode.getOptions().isArrayAlternate()) {
            throw new XMPException("Named property must be non-alternate array", 4);
        }
        checkSeparator(str3);
        char cCharAt = str4.charAt(0);
        char cCheckQuotes = checkQuotes(str4, cCharAt);
        StringBuffer stringBuffer = new StringBuffer();
        Iterator itIterateChildren = xMPNodeFindNode.iterateChildren();
        while (itIterateChildren.hasNext()) {
            XMPNode xMPNode = (XMPNode) itIterateChildren.next();
            if (xMPNode.getOptions().isCompositeProperty()) {
                throw new XMPException("Array items must be simple", 4);
            }
            stringBuffer.append(applyQuotes(xMPNode.getValue(), cCharAt, cCheckQuotes, z));
            if (itIterateChildren.hasNext()) {
                stringBuffer.append(str3);
            }
        }
        return stringBuffer.toString();
    }

    private static char checkQuotes(String str, char c) throws XMPException {
        char cCharAt;
        if (classifyCharacter(c) != 4) {
            throw new XMPException("Invalid quoting character", 4);
        }
        if (str.length() == 1) {
            cCharAt = c;
        } else {
            cCharAt = str.charAt(1);
            if (classifyCharacter(cCharAt) != 4) {
                throw new XMPException("Invalid quoting character", 4);
            }
        }
        if (cCharAt == getClosingQuote(c)) {
            return cCharAt;
        }
        throw new XMPException("Mismatched quote pair", 4);
    }

    private static void checkSeparator(String str) throws XMPException {
        boolean z = false;
        for (int i = 0; i < str.length(); i++) {
            int iClassifyCharacter = classifyCharacter(str.charAt(i));
            if (iClassifyCharacter == 3) {
                if (z) {
                    throw new XMPException("Separator can have only one semicolon", 4);
                }
                z = true;
            } else if (iClassifyCharacter != 1) {
                throw new XMPException("Separator can have only spaces and one semicolon", 4);
            }
        }
        if (!z) {
            throw new XMPException("Separator must have one semicolon", 4);
        }
    }

    private static int classifyCharacter(char c) {
        if (SPACES.indexOf(c) >= 0) {
            return 1;
        }
        if (8192 <= c && c <= 8203) {
            return 1;
        }
        if (COMMAS.indexOf(c) >= 0) {
            return 2;
        }
        if (SEMICOLA.indexOf(c) >= 0) {
            return 3;
        }
        if (QUOTES.indexOf(c) >= 0) {
            return 4;
        }
        if (12296 <= c && c <= 12303) {
            return 4;
        }
        if (8216 > c || c > 8223) {
            return (c < ' ' || CONTROLS.indexOf(c) >= 0) ? 5 : 0;
        }
        return 4;
    }

    public static void createEstimatedSizeMap(XMPMetaImpl xMPMetaImpl, Map<Integer, List<List<String>>> map) {
        for (int childrenLength = xMPMetaImpl.getRoot().getChildrenLength(); childrenLength > 0; childrenLength--) {
            XMPNode child = xMPMetaImpl.getRoot().getChild(childrenLength);
            for (int childrenLength2 = child.getChildrenLength(); childrenLength2 > 0; childrenLength2--) {
                XMPNode child2 = child.getChild(childrenLength2);
                if (!child.getName().equals(XMPConst.NS_XMP_NOTE) || !child2.getName().equals("xmpNote:HasExtendedXMP")) {
                    int iEstimateSizeForJPEG = estimateSizeForJPEG(child2);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(child.getName());
                    arrayList.add(child2.getName());
                    putObjectsInMultiMap(map, Integer.valueOf(iEstimateSizeForJPEG), arrayList);
                }
            }
        }
    }

    public static void duplicateSubtree(XMPMeta xMPMeta, XMPMeta xMPMeta2, String str, String str2, String str3, String str4, PropertyOptions propertyOptions) {
        ParameterAsserts.assertNotNull(xMPMeta);
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertSchemaNS(str2);
        ParameterAsserts.assertNotNull(xMPMeta2);
        ParameterAsserts.assertNotNull(str3);
        ParameterAsserts.assertNotNull(str4);
        if (str3.length() == 0) {
            str3 = str;
        }
        if (str4.length() == 0) {
            str4 = str2;
        }
        boolean zEquals = str.equals("*");
        boolean zEquals2 = str3.equals("*");
        if (xMPMeta == xMPMeta2 && (zEquals || zEquals2)) {
            throw new XMPException("Can't duplicate tree onto itself", 4);
        }
        if (zEquals && zEquals2) {
            throw new XMPException("Use Clone for full tree to full tree", 4);
        }
        if (zEquals) {
            XMPNode xMPNodeFindNode = XMPNodeUtils.findNode(((XMPMetaImpl) xMPMeta2).getRoot(), XMPPathParser.expandXPath(str3, str4), false, null);
            if (xMPNodeFindNode == null || !xMPNodeFindNode.getOptions().isStruct()) {
                throw new XMPException("Destination must be an existing struct", 102);
            }
            if (xMPNodeFindNode.hasChildren()) {
                if (propertyOptions == null || (propertyOptions.getOptions() & 536870912) == 0) {
                    throw new XMPException("Destination must be an empty struct", 102);
                }
                xMPNodeFindNode.removeChildren();
            }
            XMPMetaImpl xMPMetaImpl = (XMPMetaImpl) xMPMeta;
            int childrenLength = xMPMetaImpl.getRoot().getChildrenLength();
            for (int i = 1; i <= childrenLength; i++) {
                XMPNode child = xMPMetaImpl.getRoot().getChild(i);
                int childrenLength2 = child.getChildrenLength();
                for (int i2 = 1; i2 <= childrenLength2; i2++) {
                    xMPNodeFindNode.addChild((XMPNode) child.getChild(i2).clone(false));
                }
            }
            return;
        }
        if (!zEquals2) {
            XMPPath xMPPathExpandXPath = XMPPathParser.expandXPath(str, str2);
            XMPPath xMPPathExpandXPath2 = XMPPathParser.expandXPath(str3, str4);
            XMPMetaImpl xMPMetaImpl2 = (XMPMetaImpl) xMPMeta2;
            XMPNode xMPNodeFindNode2 = XMPNodeUtils.findNode(((XMPMetaImpl) xMPMeta).getRoot(), xMPPathExpandXPath, false, null);
            if (xMPNodeFindNode2 == null) {
                throw new XMPException("Can't find source subtree", 102);
            }
            if (XMPNodeUtils.findNode(xMPMetaImpl2.getRoot(), xMPPathExpandXPath2, false, null) != null) {
                throw new XMPException("Destination subtree must not exist", 102);
            }
            XMPNode xMPNodeFindNode3 = XMPNodeUtils.findNode(xMPMetaImpl2.getRoot(), xMPPathExpandXPath2, true, null);
            if (xMPNodeFindNode3 == null) {
                throw new XMPException("Can't create destination root node", 102);
            }
            if (xMPMeta == xMPMeta2) {
                for (XMPNode parent = xMPNodeFindNode3; parent != null; parent = parent.getParent()) {
                    if (parent == xMPNodeFindNode2) {
                        throw new XMPException("Destination subtree is within the source subtree", 102);
                    }
                }
            }
            xMPNodeFindNode3.setValue(xMPNodeFindNode2.getValue());
            xMPNodeFindNode3.setOptions(xMPNodeFindNode2.getOptions());
            xMPNodeFindNode2.cloneSubtree(xMPNodeFindNode3, false);
            return;
        }
        XMPMetaImpl xMPMetaImpl3 = (XMPMetaImpl) xMPMeta2;
        XMPNode xMPNodeFindNode4 = XMPNodeUtils.findNode(((XMPMetaImpl) xMPMeta).getRoot(), XMPPathParser.expandXPath(str, str2), false, null);
        if (xMPNodeFindNode4 == null || !xMPNodeFindNode4.getOptions().isStruct()) {
            throw new XMPException("Source must be an existing struct", 102);
        }
        XMPNode root = xMPMetaImpl3.getRoot();
        if (root.hasChildren()) {
            if (propertyOptions == null || (propertyOptions.getOptions() & 536870912) == 0) {
                throw new XMPException("Source must be an existing struct", 102);
            }
            root.removeChildren();
        }
        int childrenLength3 = xMPNodeFindNode4.getChildrenLength();
        for (int i4 = 1; i4 <= childrenLength3; i4++) {
            XMPNode child2 = xMPNodeFindNode4.getChild(i4);
            int iIndexOf = child2.getName().indexOf(58);
            if (iIndexOf != -1) {
                String namespaceURI = XMPMetaFactory.getSchemaRegistry().getNamespaceURI(new String(child2.getName().substring(0, iIndexOf + 1)));
                if (namespaceURI == null) {
                    throw new XMPException("Source field namespace is not global", 101);
                }
                XMPNode xMPNodeFindSchemaNode = XMPNodeUtils.findSchemaNode(xMPMetaImpl3.getRoot(), namespaceURI, true);
                if (xMPNodeFindSchemaNode == null) {
                    throw new XMPException("Failed to find destination schema", 101);
                }
                xMPNodeFindSchemaNode.addChild((XMPNode) child2.clone(false));
            }
        }
    }

    public static int estimateSizeForJPEG(XMPNode xMPNode) {
        int length = xMPNode.getName().length();
        boolean zIsArray = xMPNode.getOptions().isArray();
        if (xMPNode.getOptions().isSimple()) {
            return xMPNode.getValue().length() + (zIsArray ? 0 : length + 3);
        }
        int i = 1;
        if (!xMPNode.getOptions().isArray()) {
            int iEstimateSizeForJPEG = (zIsArray ? 0 : (length * 2) + 5) + 25;
            int childrenLength = xMPNode.getChildrenLength();
            while (i <= childrenLength) {
                iEstimateSizeForJPEG += estimateSizeForJPEG(xMPNode.getChild(i));
                i++;
            }
            return iEstimateSizeForJPEG;
        }
        int i2 = zIsArray ? 0 : (length * 2) + 5;
        int childrenLength2 = xMPNode.getChildrenLength();
        int iEstimateSizeForJPEG2 = (childrenLength2 * 17) + i2 + 19;
        while (i <= childrenLength2) {
            iEstimateSizeForJPEG2 += estimateSizeForJPEG(xMPNode.getChild(i));
            i++;
        }
        return iEstimateSizeForJPEG2;
    }

    private static List<String> getBiggestEntryInMultiMap(Map<Integer, List<List<String>>> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        TreeMap treeMap = (TreeMap) map;
        List<List<String>> list = map.get(treeMap.lastKey());
        List<String> list2 = list.get(0);
        list.remove(0);
        if (list.isEmpty()) {
            map.remove(treeMap.lastKey());
        }
        return list2;
    }

    private static char getClosingQuote(char c) {
        switch (c) {
            case '\"':
                return '\"';
            case 171:
                return (char) 187;
            case 187:
                return (char) 171;
            case 8213:
                return (char) 8213;
            case 8216:
                return Typography.rightSingleQuote;
            case 8218:
                return (char) 8219;
            case 8220:
                return Typography.rightDoubleQuote;
            case 8222:
                return (char) 8223;
            case 8249:
                return (char) 8250;
            case 8250:
                return (char) 8249;
            case 12296:
                return (char) 12297;
            case 12298:
                return (char) 12299;
            case 12300:
                return (char) 12301;
            case 12302:
                return (char) 12303;
            case 12317:
                return (char) 12319;
            default:
                return (char) 0;
        }
    }

    private static boolean isClosingingQuote(char c, char c2, char c4) {
        if (c != c4) {
            return (c2 == 12317 && c == 12318) || c == 12319;
        }
        return true;
    }

    private static boolean isSurroundingQuote(char c, char c2, char c4) {
        return c == c2 || isClosingingQuote(c, c2, c4);
    }

    private static boolean itemValuesMatch(XMPNode xMPNode, XMPNode xMPNode2) throws XMPException {
        PropertyOptions options = xMPNode.getOptions();
        if (!options.equals(xMPNode2.getOptions())) {
            return false;
        }
        if (options.isSimple()) {
            if (!xMPNode.getValue().equals(xMPNode2.getValue()) || xMPNode.getOptions().getHasLanguage() != xMPNode2.getOptions().getHasLanguage()) {
                return false;
            }
            if (xMPNode.getOptions().getHasLanguage() && !xMPNode.getQualifier(1).getValue().equals(xMPNode2.getQualifier(1).getValue())) {
                return false;
            }
        } else {
            if (!options.isStruct()) {
                Iterator itIterateChildren = xMPNode.iterateChildren();
                while (itIterateChildren.hasNext()) {
                    XMPNode xMPNode3 = (XMPNode) itIterateChildren.next();
                    Iterator itIterateChildren2 = xMPNode2.iterateChildren();
                    while (itIterateChildren2.hasNext()) {
                        if (itemValuesMatch(xMPNode3, (XMPNode) itIterateChildren2.next())) {
                            break;
                        }
                    }
                    return false;
                }
            }
            if (xMPNode.getChildrenLength() != xMPNode2.getChildrenLength()) {
                return false;
            }
            Iterator itIterateChildren3 = xMPNode.iterateChildren();
            while (itIterateChildren3.hasNext()) {
                XMPNode xMPNode4 = (XMPNode) itIterateChildren3.next();
                XMPNode xMPNodeFindChildNode = XMPNodeUtils.findChildNode(xMPNode2, xMPNode4.getName(), false);
                if (xMPNodeFindChildNode == null || !itemValuesMatch(xMPNode4, xMPNodeFindChildNode)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void mergeFromJPEG(XMPMeta xMPMeta, XMPMeta xMPMeta2) {
        applyTemplate((XMPMetaImpl) xMPMeta, (XMPMetaImpl) xMPMeta2, new TemplateOptions(48));
        xMPMeta.deleteProperty(XMPConst.NS_XMP_NOTE, "HasExtendedXMP");
    }

    public static int moveLargestProperty(XMPMetaImpl xMPMetaImpl, XMPMetaImpl xMPMetaImpl2, Map<Integer, List<List<String>>> map) throws XMPException {
        int iIntValue = ((Integer) ((TreeMap) map).lastKey()).intValue();
        List<String> biggestEntryInMultiMap = getBiggestEntryInMultiMap(map);
        moveOneProperty(xMPMetaImpl, xMPMetaImpl2, biggestEntryInMultiMap.get(0), biggestEntryInMultiMap.get(1));
        return iIntValue;
    }

    public static boolean moveOneProperty(XMPMetaImpl xMPMetaImpl, XMPMetaImpl xMPMetaImpl2, String str, String str2) throws XMPException {
        XMPNode xMPNodeFindSchemaNode = XMPNodeUtils.findSchemaNode(xMPMetaImpl.getRoot(), str, false);
        XMPNode xMPNodeFindChildNode = xMPNodeFindSchemaNode != null ? XMPNodeUtils.findChildNode(xMPNodeFindSchemaNode, str2, false) : null;
        if (xMPNodeFindChildNode == null) {
            return false;
        }
        XMPNode xMPNodeFindSchemaNode2 = XMPNodeUtils.findSchemaNode(xMPMetaImpl2.getRoot(), str, true);
        xMPNodeFindChildNode.setParent(xMPNodeFindSchemaNode2);
        xMPNodeFindSchemaNode2.setImplicit(false);
        xMPNodeFindSchemaNode2.addChild(xMPNodeFindChildNode);
        xMPNodeFindSchemaNode.removeChild(xMPNodeFindChildNode);
        if (!xMPNodeFindSchemaNode.hasChildren()) {
            xMPNodeFindSchemaNode.getParent().removeChild(xMPNodeFindSchemaNode);
        }
        return true;
    }

    public static void packageForJPEG(XMPMeta xMPMeta, StringBuilder sb, StringBuilder sb2, StringBuilder sb3) {
        XMPMetaImpl xMPMetaImpl = (XMPMetaImpl) xMPMeta;
        XMPMetaImpl xMPMetaImpl2 = new XMPMetaImpl();
        XMPMetaImpl xMPMetaImpl3 = new XMPMetaImpl();
        SerializeOptions serializeOptions = new SerializeOptions(64);
        serializeOptions.setPadding(0);
        serializeOptions.setIndent("");
        serializeOptions.setBaseIndent(0);
        serializeOptions.setNewline(" ");
        String strSerializeToString = XMPMetaFactory.serializeToString(xMPMetaImpl, serializeOptions);
        if (strSerializeToString.length() > 65000) {
            xMPMetaImpl2.getRoot().setOptions(xMPMetaImpl.getRoot().getOptions());
            xMPMetaImpl2.getRoot().setName(xMPMetaImpl.getRoot().getName());
            xMPMetaImpl2.getRoot().setValue(xMPMetaImpl.getRoot().getValue());
            xMPMetaImpl.getRoot().cloneSubtree(xMPMetaImpl2.getRoot(), false);
            if (xMPMetaImpl2.doesPropertyExist(XMPConst.NS_XMP, "Thumbnails")) {
                xMPMetaImpl2.deleteProperty(XMPConst.NS_XMP, "Thumbnails");
                strSerializeToString = XMPMetaFactory.serializeToString(xMPMetaImpl2, serializeOptions);
            }
        }
        if (strSerializeToString.length() > 65000) {
            xMPMetaImpl2.setProperty(XMPConst.NS_XMP_NOTE, "HasExtendedXMP", "123456789-123456789-123456789-12", new PropertyOptions(0));
            XMPNode xMPNodeFindSchemaNode = XMPNodeUtils.findSchemaNode(xMPMetaImpl2.getRoot(), XMPConst.NS_CAMERARAW, false);
            if (xMPNodeFindSchemaNode != null) {
                xMPNodeFindSchemaNode.setParent(xMPMetaImpl3.getRoot());
                xMPMetaImpl3.getRoot().addChild(xMPNodeFindSchemaNode);
                xMPMetaImpl2.getRoot().removeChild(xMPNodeFindSchemaNode);
                strSerializeToString = XMPMetaFactory.serializeToString(xMPMetaImpl2, serializeOptions);
            }
        }
        if (strSerializeToString.length() > 65000 && moveOneProperty(xMPMetaImpl2, xMPMetaImpl3, XMPConst.NS_PHOTOSHOP, "photoshop:History")) {
            strSerializeToString = XMPMetaFactory.serializeToString(xMPMetaImpl2, serializeOptions);
        }
        if (strSerializeToString.length() > 65000) {
            TreeMap treeMap = new TreeMap();
            createEstimatedSizeMap(xMPMetaImpl2, treeMap);
            while (strSerializeToString.length() > 65000 && !treeMap.isEmpty()) {
                int length = strSerializeToString.length();
                while (length > 65000 && !treeMap.isEmpty()) {
                    int iMoveLargestProperty = moveLargestProperty(xMPMetaImpl2, xMPMetaImpl3, treeMap);
                    if (iMoveLargestProperty > length) {
                        iMoveLargestProperty = length;
                    }
                    length -= iMoveLargestProperty;
                }
                strSerializeToString = XMPMetaFactory.serializeToString(xMPMetaImpl2, serializeOptions);
            }
        }
        if (strSerializeToString.length() > 65000) {
            throw new XMPException("Can't reduce XMP enough for JPEG file", 9);
        }
        if (xMPMetaImpl3.getRoot().getChildrenLength() == 0) {
            sb.append(strSerializeToString);
        } else {
            String strSerializeToString2 = XMPMetaFactory.serializeToString(xMPMetaImpl3, new SerializeOptions(80));
            sb2.append(strSerializeToString2);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(strSerializeToString2.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            for (byte b : bArrDigest) {
                sb3.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
            xMPMetaImpl2.setProperty(XMPConst.NS_XMP_NOTE, "HasExtendedXMP", sb3.toString(), new PropertyOptions(0));
            sb.append(XMPMetaFactory.serializeToString(xMPMetaImpl2, serializeOptions));
        }
        int length2 = 65000 - sb.length();
        if (length2 > 2047) {
            length2 = 2047;
        }
        sb.delete(sb.toString().indexOf("<?xpacket end=\"w\"?>"), sb.length());
        for (int i = 0; i < length2; i++) {
            sb.append(' ');
        }
        sb.append("<?xpacket end=\"w\"?>");
    }

    private static void putObjectsInMultiMap(Map<Integer, List<List<String>>> map, Integer num, List<String> list) {
        if (map == null) {
            return;
        }
        List<List<String>> arrayList = map.get(num);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            map.put(num, arrayList);
        }
        arrayList.add(list);
    }

    public static void removeProperties(XMPMeta xMPMeta, String str, String str2, boolean z, boolean z2) {
        ParameterAsserts.assertImplementation(xMPMeta);
        XMPMetaImpl xMPMetaImpl = (XMPMetaImpl) xMPMeta;
        if (str2 != null && str2.length() > 0) {
            if (str == null || str.length() == 0) {
                throw new XMPException("Property name requires schema namespace", 4);
            }
            XMPPath xMPPathExpandXPath = XMPPathParser.expandXPath(str, str2);
            XMPNode xMPNodeFindNode = XMPNodeUtils.findNode(xMPMetaImpl.getRoot(), xMPPathExpandXPath, false, null);
            if (xMPNodeFindNode != null) {
                if (z || !Utils.isInternalProperty(xMPPathExpandXPath.getSegment(0).getName(), xMPPathExpandXPath.getSegment(1).getName())) {
                    XMPNode parent = xMPNodeFindNode.getParent();
                    parent.removeChild(xMPNodeFindNode);
                    if (!parent.getOptions().isSchemaNode() || parent.hasChildren()) {
                        return;
                    }
                    parent.getParent().removeChild(parent);
                    return;
                }
                return;
            }
            return;
        }
        if (str == null || str.length() <= 0) {
            Iterator itIterateChildren = xMPMetaImpl.getRoot().iterateChildren();
            while (itIterateChildren.hasNext()) {
                if (removeSchemaChildren((XMPNode) itIterateChildren.next(), z)) {
                    itIterateChildren.remove();
                }
            }
            return;
        }
        XMPNode xMPNodeFindSchemaNode = XMPNodeUtils.findSchemaNode(xMPMetaImpl.getRoot(), str, false);
        if (xMPNodeFindSchemaNode != null && removeSchemaChildren(xMPNodeFindSchemaNode, z)) {
            xMPMetaImpl.getRoot().removeChild(xMPNodeFindSchemaNode);
        }
        if (z2) {
            for (XMPAliasInfo xMPAliasInfo : XMPMetaFactory.getSchemaRegistry().findAliases(str)) {
                XMPNode xMPNodeFindNode2 = XMPNodeUtils.findNode(xMPMetaImpl.getRoot(), XMPPathParser.expandXPath(xMPAliasInfo.getNamespace(), xMPAliasInfo.getPropName()), false, null);
                if (xMPNodeFindNode2 != null) {
                    xMPNodeFindNode2.getParent().removeChild(xMPNodeFindNode2);
                }
            }
        }
    }

    private static boolean removeSchemaChildren(XMPNode xMPNode, boolean z) {
        Iterator itIterateChildren = xMPNode.iterateChildren();
        while (itIterateChildren.hasNext()) {
            XMPNode xMPNode2 = (XMPNode) itIterateChildren.next();
            if (z || !Utils.isInternalProperty(xMPNode.getName(), xMPNode2.getName())) {
                itIterateChildren.remove();
            }
        }
        return !xMPNode.hasChildren();
    }

    public static void separateArrayItems(XMPMeta xMPMeta, String str, String str2, String str3, PropertyOptions propertyOptions, boolean z) {
        StringBuilder sb;
        char cCharAt;
        int i;
        int iClassifyCharacter;
        int arrayElementsLimit;
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertArrayName(str2);
        if (str3 == null) {
            throw new XMPException("Parameter must not be null", 4);
        }
        ParameterAsserts.assertImplementation(xMPMeta);
        XMPNode xMPNodeSeparateFindCreateArray = separateFindCreateArray(str, str2, propertyOptions, (XMPMetaImpl) xMPMeta);
        int i2 = Integer.MAX_VALUE;
        if (xMPNodeSeparateFindCreateArray != null && propertyOptions != null && (arrayElementsLimit = propertyOptions.getArrayElementsLimit()) != -1) {
            i2 = arrayElementsLimit;
        }
        int length = str3.length();
        int i4 = 0;
        int iClassifyCharacter2 = 0;
        char cCharAt2 = 0;
        while (i4 < length && xMPNodeSeparateFindCreateArray.getChildrenLength() < i2) {
            while (i4 < length) {
                cCharAt2 = str3.charAt(i4);
                iClassifyCharacter2 = classifyCharacter(cCharAt2);
                if (iClassifyCharacter2 == 0 || iClassifyCharacter2 == 4) {
                    break;
                } else {
                    i4++;
                }
            }
            if (i4 >= length) {
                return;
            }
            int i5 = 1;
            if (iClassifyCharacter2 != 4) {
                int i6 = i4;
                while (i6 < length) {
                    cCharAt2 = str3.charAt(i6);
                    iClassifyCharacter2 = classifyCharacter(cCharAt2);
                    if (iClassifyCharacter2 != 0 && iClassifyCharacter2 != 4 && ((iClassifyCharacter2 != 2 || !z) && (iClassifyCharacter2 != 1 || (i = i6 + 1) >= length || ((iClassifyCharacter = classifyCharacter((cCharAt2 = str3.charAt(i)))) != 0 && iClassifyCharacter != 4 && (iClassifyCharacter != 2 || !z))))) {
                        break;
                    } else {
                        i6++;
                    }
                }
                sb = new StringBuilder(str3.substring(i4, i6));
                i4 = i6;
            } else {
                char closingQuote = getClosingQuote(cCharAt2);
                i4++;
                sb = new StringBuilder("");
                char cCharAt3 = cCharAt2;
                while (true) {
                    if (i4 >= length) {
                        cCharAt2 = cCharAt3;
                        break;
                    }
                    cCharAt3 = str3.charAt(i4);
                    iClassifyCharacter2 = classifyCharacter(cCharAt3);
                    if (iClassifyCharacter2 == 4 && isSurroundingQuote(cCharAt3, cCharAt2, closingQuote)) {
                        int i7 = i4 + 1;
                        if (i7 < length) {
                            cCharAt = str3.charAt(i7);
                            classifyCharacter(cCharAt);
                        } else {
                            cCharAt = SQLKeyword.DELIMITER;
                        }
                        if (cCharAt3 != cCharAt) {
                            if (isClosingingQuote(cCharAt3, cCharAt2, closingQuote)) {
                                cCharAt2 = cCharAt3;
                                i4 = i7;
                                break;
                            }
                            sb.append(cCharAt3);
                        } else {
                            sb.append(cCharAt3);
                            i4 = i7;
                        }
                    } else {
                        sb.append(cCharAt3);
                    }
                    i4++;
                }
            }
            while (true) {
                if (i5 > xMPNodeSeparateFindCreateArray.getChildrenLength()) {
                    i5 = -1;
                    break;
                } else if (sb.toString().equals(xMPNodeSeparateFindCreateArray.getChild(i5).getValue())) {
                    break;
                } else {
                    i5++;
                }
            }
            if (i5 < 0) {
                xMPNodeSeparateFindCreateArray.addChild(new XMPNode(XMPConst.ARRAY_ITEM_NAME, sb.toString(), null));
            }
        }
    }

    private static XMPNode separateFindCreateArray(String str, String str2, PropertyOptions propertyOptions, XMPMetaImpl xMPMetaImpl) throws XMPException {
        PropertyOptions propertyOptionsVerifySetOptions = XMPNodeUtils.verifySetOptions(propertyOptions, null);
        if (!propertyOptionsVerifySetOptions.isOnlyArrayOptions()) {
            throw new XMPException("Options can only provide array form", 103);
        }
        XMPPath xMPPathExpandXPath = XMPPathParser.expandXPath(str, str2);
        XMPNode xMPNodeFindNode = XMPNodeUtils.findNode(xMPMetaImpl.getRoot(), xMPPathExpandXPath, false, null);
        if (xMPNodeFindNode == null) {
            XMPNode xMPNodeFindNode2 = XMPNodeUtils.findNode(xMPMetaImpl.getRoot(), xMPPathExpandXPath, true, propertyOptionsVerifySetOptions.setArray(true));
            if (xMPNodeFindNode2 != null) {
                return xMPNodeFindNode2;
            }
            throw new XMPException("Failed to create named array", 102);
        }
        PropertyOptions options = xMPNodeFindNode.getOptions();
        if (!options.isArray() || options.isArrayAlternate()) {
            throw new XMPException("Named property must be non-alternate array", 102);
        }
        if (propertyOptionsVerifySetOptions.equalArrayTypes(options)) {
            throw new XMPException("Mismatch of specified and existing array form", 102);
        }
        return xMPNodeFindNode;
    }
}
