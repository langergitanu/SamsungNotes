package com.adobe.internal.xmp.impl;

import androidx.appcompat.widget.AbstractC0541b;
import com.adobe.internal.xmp.XMPConst;
import com.adobe.internal.xmp.XMPDateTime;
import com.adobe.internal.xmp.XMPException;
import com.adobe.internal.xmp.XMPMeta;
import com.adobe.internal.xmp.XMPMetaFactory;
import com.adobe.internal.xmp.XMPUtils;
import com.adobe.internal.xmp.impl.xpath.XMPPathParser;
import com.adobe.internal.xmp.options.ParseOptions;
import com.adobe.internal.xmp.options.PropertyOptions;
import com.adobe.internal.xmp.properties.XMPAliasInfo;
import com.samsung.android.support.senl.p148nt.model.markdown.generator.model.MarkdownDocument;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class XMPNormalizer {
    private static Map dcArrayForms;

    static {
        initDCArrays();
    }

    private XMPNormalizer() {
    }

    private static void compareAliasedSubtrees(XMPNode xMPNode, XMPNode xMPNode2, boolean z) throws XMPException {
        if (!xMPNode.getValue().equals(xMPNode2.getValue()) || xMPNode.getChildrenLength() != xMPNode2.getChildrenLength()) {
            throw new XMPException("Mismatch between alias and base nodes", 203);
        }
        if (!z && (!xMPNode.getName().equals(xMPNode2.getName()) || !xMPNode.getOptions().equals(xMPNode2.getOptions()) || xMPNode.getQualifierLength() != xMPNode2.getQualifierLength())) {
            throw new XMPException("Mismatch between alias and base nodes", 203);
        }
        Iterator itIterateChildren = xMPNode.iterateChildren();
        Iterator itIterateChildren2 = xMPNode2.iterateChildren();
        while (itIterateChildren.hasNext() && itIterateChildren2.hasNext()) {
            compareAliasedSubtrees((XMPNode) itIterateChildren.next(), (XMPNode) itIterateChildren2.next(), false);
        }
        Iterator itIterateQualifier = xMPNode.iterateQualifier();
        Iterator itIterateQualifier2 = xMPNode2.iterateQualifier();
        while (itIterateQualifier.hasNext() && itIterateQualifier2.hasNext()) {
            compareAliasedSubtrees((XMPNode) itIterateQualifier.next(), (XMPNode) itIterateQualifier2.next(), false);
        }
    }

    private static void deleteEmptySchemas(XMPNode xMPNode) {
        Iterator itIterateChildren = xMPNode.iterateChildren();
        while (itIterateChildren.hasNext()) {
            if (!((XMPNode) itIterateChildren.next()).hasChildren()) {
                itIterateChildren.remove();
            }
        }
    }

    private static void fixGPSTimeStamp(XMPNode xMPNode) throws XMPException {
        XMPNode xMPNodeFindChildNode = XMPNodeUtils.findChildNode(xMPNode, "exif:GPSTimeStamp", false);
        if (xMPNodeFindChildNode == null) {
            return;
        }
        try {
            XMPDateTime xMPDateTimeConvertToDate = XMPUtils.convertToDate(xMPNodeFindChildNode.getValue());
            if (xMPDateTimeConvertToDate.getYear() == 0 && xMPDateTimeConvertToDate.getMonth() == 0 && xMPDateTimeConvertToDate.getDay() == 0) {
                XMPNode xMPNodeFindChildNode2 = XMPNodeUtils.findChildNode(xMPNode, "exif:DateTimeOriginal", false);
                if (xMPNodeFindChildNode2 == null) {
                    xMPNodeFindChildNode2 = XMPNodeUtils.findChildNode(xMPNode, "exif:DateTimeDigitized", false);
                }
                if (xMPNodeFindChildNode2 == null) {
                    return;
                }
                XMPDateTime xMPDateTimeConvertToDate2 = XMPUtils.convertToDate(xMPNodeFindChildNode2.getValue());
                Calendar calendar = xMPDateTimeConvertToDate.getCalendar();
                calendar.set(1, xMPDateTimeConvertToDate2.getYear());
                calendar.set(2, xMPDateTimeConvertToDate2.getMonth());
                calendar.set(5, xMPDateTimeConvertToDate2.getDay());
                xMPNodeFindChildNode.setValue(XMPUtils.convertFromDate(new XMPDateTimeImpl(calendar)));
            }
        } catch (XMPException unused) {
        }
    }

    private static void initDCArrays() {
        dcArrayForms = new HashMap();
        PropertyOptions propertyOptions = new PropertyOptions();
        propertyOptions.setArray(true);
        dcArrayForms.put("dc:contributor", propertyOptions);
        dcArrayForms.put("dc:language", propertyOptions);
        dcArrayForms.put("dc:publisher", propertyOptions);
        dcArrayForms.put("dc:relation", propertyOptions);
        dcArrayForms.put("dc:subject", propertyOptions);
        dcArrayForms.put("dc:type", propertyOptions);
        PropertyOptions propertyOptions2 = new PropertyOptions();
        propertyOptions2.setArray(true);
        propertyOptions2.setArrayOrdered(true);
        dcArrayForms.put("dc:creator", propertyOptions2);
        dcArrayForms.put("dc:date", propertyOptions2);
        PropertyOptions propertyOptions3 = new PropertyOptions();
        propertyOptions3.setArray(true);
        propertyOptions3.setArrayOrdered(true);
        propertyOptions3.setArrayAlternate(true);
        propertyOptions3.setArrayAltText(true);
        dcArrayForms.put("dc:description", propertyOptions3);
        dcArrayForms.put("dc:rights", propertyOptions3);
        dcArrayForms.put("dc:title", propertyOptions3);
    }

    private static void migrateAudioCopyright(XMPMeta xMPMeta, XMPNode xMPNode) {
        try {
            XMPNode xMPNodeFindSchemaNode = XMPNodeUtils.findSchemaNode(((XMPMetaImpl) xMPMeta).getRoot(), "http://purl.org/dc/elements/1.1/", true);
            String value = xMPNode.getValue();
            XMPNode xMPNodeFindChildNode = XMPNodeUtils.findChildNode(xMPNodeFindSchemaNode, "dc:rights", false);
            if (xMPNodeFindChildNode == null || !xMPNodeFindChildNode.hasChildren()) {
                xMPMeta.setLocalizedText("http://purl.org/dc/elements/1.1/", "rights", "", XMPConst.X_DEFAULT, MarkdownDocument.NEW_LINE + value, null);
            } else {
                int iLookupLanguageItem = XMPNodeUtils.lookupLanguageItem(xMPNodeFindChildNode, XMPConst.X_DEFAULT);
                if (iLookupLanguageItem < 0) {
                    xMPMeta.setLocalizedText("http://purl.org/dc/elements/1.1/", "rights", "", XMPConst.X_DEFAULT, xMPNodeFindChildNode.getChild(1).getValue(), null);
                    iLookupLanguageItem = XMPNodeUtils.lookupLanguageItem(xMPNodeFindChildNode, XMPConst.X_DEFAULT);
                }
                XMPNode child = xMPNodeFindChildNode.getChild(iLookupLanguageItem);
                String value2 = child.getValue();
                int iIndexOf = value2.indexOf(MarkdownDocument.NEW_LINE);
                if (iIndexOf >= 0) {
                    int i = iIndexOf + 2;
                    if (!value2.substring(i).equals(value)) {
                        child.setValue(value2.substring(0, i) + value);
                    }
                } else if (!value.equals(value2)) {
                    child.setValue(value2 + MarkdownDocument.NEW_LINE + value);
                }
            }
            xMPNode.getParent().removeChild(xMPNode);
        } catch (XMPException unused) {
        }
    }

    private static void moveExplicitAliases(XMPNode xMPNode, ParseOptions parseOptions) throws XMPException {
        if (xMPNode.getHasAliases()) {
            xMPNode.setHasAliases(false);
            boolean strictAliasing = parseOptions.getStrictAliasing();
            for (XMPNode xMPNode2 : xMPNode.getUnmodifiableChildren()) {
                if (xMPNode2.getHasAliases()) {
                    Iterator itIterateChildren = xMPNode2.iterateChildren();
                    while (itIterateChildren.hasNext()) {
                        XMPNode xMPNode3 = (XMPNode) itIterateChildren.next();
                        if (xMPNode3.isAlias()) {
                            xMPNode3.setAlias(false);
                            XMPAliasInfo xMPAliasInfoFindAlias = XMPMetaFactory.getSchemaRegistry().findAlias(xMPNode3.getName());
                            if (xMPAliasInfoFindAlias != null) {
                                XMPNode child = null;
                                XMPNode xMPNodeFindSchemaNode = XMPNodeUtils.findSchemaNode(xMPNode, xMPAliasInfoFindAlias.getNamespace(), null, true);
                                xMPNodeFindSchemaNode.setImplicit(false);
                                XMPNode xMPNodeFindChildNode = XMPNodeUtils.findChildNode(xMPNodeFindSchemaNode, xMPAliasInfoFindAlias.getPrefix() + xMPAliasInfoFindAlias.getPropName(), false);
                                if (xMPNodeFindChildNode == null) {
                                    if (xMPAliasInfoFindAlias.getAliasForm().isSimple()) {
                                        xMPNode3.setName(xMPAliasInfoFindAlias.getPrefix() + xMPAliasInfoFindAlias.getPropName());
                                        xMPNodeFindSchemaNode.addChild(xMPNode3);
                                        itIterateChildren.remove();
                                    } else {
                                        XMPNode xMPNode4 = new XMPNode(xMPAliasInfoFindAlias.getPrefix() + xMPAliasInfoFindAlias.getPropName(), xMPAliasInfoFindAlias.getAliasForm().toPropertyOptions());
                                        xMPNodeFindSchemaNode.addChild(xMPNode4);
                                        transplantArrayItemAlias(itIterateChildren, xMPNode3, xMPNode4);
                                    }
                                } else if (xMPAliasInfoFindAlias.getAliasForm().isSimple()) {
                                    if (strictAliasing) {
                                        compareAliasedSubtrees(xMPNode3, xMPNodeFindChildNode, true);
                                    }
                                    itIterateChildren.remove();
                                } else {
                                    if (xMPAliasInfoFindAlias.getAliasForm().isArrayAltText()) {
                                        int iLookupLanguageItem = XMPNodeUtils.lookupLanguageItem(xMPNodeFindChildNode, XMPConst.X_DEFAULT);
                                        if (iLookupLanguageItem != -1) {
                                            child = xMPNodeFindChildNode.getChild(iLookupLanguageItem);
                                        }
                                    } else if (xMPNodeFindChildNode.hasChildren()) {
                                        child = xMPNodeFindChildNode.getChild(1);
                                    }
                                    if (child == null) {
                                        transplantArrayItemAlias(itIterateChildren, xMPNode3, xMPNodeFindChildNode);
                                    } else {
                                        if (strictAliasing) {
                                            compareAliasedSubtrees(xMPNode3, child, true);
                                        }
                                        itIterateChildren.remove();
                                    }
                                }
                            }
                        }
                    }
                    xMPNode2.setHasAliases(false);
                }
            }
        }
    }

    private static void normalizeDCArrays(XMPNode xMPNode) throws XMPException {
        for (int i = 1; i <= xMPNode.getChildrenLength(); i++) {
            XMPNode child = xMPNode.getChild(i);
            PropertyOptions propertyOptions = (PropertyOptions) dcArrayForms.get(child.getName());
            if (propertyOptions != null) {
                if (child.getOptions().isSimple()) {
                    XMPNode xMPNode2 = new XMPNode(child.getName(), propertyOptions);
                    child.setName(XMPConst.ARRAY_ITEM_NAME);
                    xMPNode2.addChild(child);
                    xMPNode.replaceChild(i, xMPNode2);
                    if (propertyOptions.isArrayAltText() && !child.getOptions().getHasLanguage()) {
                        child.addQualifier(new XMPNode(XMPConst.XML_LANG, XMPConst.X_DEFAULT, null));
                    }
                } else {
                    child.getOptions().setOption(7680, false);
                    child.getOptions().mergeWith(propertyOptions);
                    if (propertyOptions.isArrayAltText()) {
                        repairAltText(child);
                    }
                }
            }
        }
    }

    public static XMPMeta process(XMPMetaImpl xMPMetaImpl, ParseOptions parseOptions) throws XMPException {
        XMPNode root = xMPMetaImpl.getRoot();
        touchUpDataModel(xMPMetaImpl);
        moveExplicitAliases(root, parseOptions);
        tweakOldXMP(root);
        deleteEmptySchemas(root);
        return xMPMetaImpl;
    }

    private static void repairAltText(XMPNode xMPNode) throws XMPException {
        if (xMPNode == null || !xMPNode.getOptions().isArray()) {
            return;
        }
        xMPNode.getOptions().setArrayOrdered(true).setArrayAlternate(true).setArrayAltText(true);
        Iterator itIterateChildren = xMPNode.iterateChildren();
        while (itIterateChildren.hasNext()) {
            XMPNode xMPNode2 = (XMPNode) itIterateChildren.next();
            if (xMPNode2.getOptions().isCompositeProperty()) {
                itIterateChildren.remove();
            } else if (!xMPNode2.getOptions().getHasLanguage()) {
                String value = xMPNode2.getValue();
                if (value == null || value.length() == 0) {
                    itIterateChildren.remove();
                } else {
                    xMPNode2.addQualifier(new XMPNode(XMPConst.XML_LANG, "x-repair", null));
                }
            }
        }
    }

    private static void touchUpDataModel(XMPMetaImpl xMPMetaImpl) throws XMPException {
        XMPNode xMPNodeFindChildNode;
        XMPNodeUtils.findSchemaNode(xMPMetaImpl.getRoot(), "http://purl.org/dc/elements/1.1/", true);
        Iterator itIterateChildren = xMPMetaImpl.getRoot().iterateChildren();
        while (itIterateChildren.hasNext()) {
            XMPNode xMPNode = (XMPNode) itIterateChildren.next();
            if ("http://purl.org/dc/elements/1.1/".equals(xMPNode.getName())) {
                normalizeDCArrays(xMPNode);
            } else if (XMPConst.NS_EXIF.equals(xMPNode.getName())) {
                fixGPSTimeStamp(xMPNode);
                XMPNode xMPNodeFindChildNode2 = XMPNodeUtils.findChildNode(xMPNode, "exif:UserComment", false);
                if (xMPNodeFindChildNode2 != null) {
                    if (xMPNodeFindChildNode2.getOptions().isSimple()) {
                        XMPNode xMPNode2 = new XMPNode(XMPConst.ARRAY_ITEM_NAME, xMPNodeFindChildNode2.getValue(), xMPNodeFindChildNode2.getOptions());
                        xMPNode2.setParent(xMPNodeFindChildNode2);
                        for (int qualifierLength = xMPNodeFindChildNode2.getQualifierLength(); qualifierLength > 0; qualifierLength--) {
                            xMPNode2.addQualifier(xMPNodeFindChildNode2.getQualifier(xMPNodeFindChildNode2.getQualifierLength() - qualifierLength));
                        }
                        xMPNodeFindChildNode2.removeQualifiers();
                        if (!xMPNode2.getOptions().getHasLanguage()) {
                            xMPNode2.addQualifier(new XMPNode(XMPConst.XML_LANG, XMPConst.X_DEFAULT, new PropertyOptions().setQualifier(true)));
                            xMPNode2.getOptions().setHasQualifiers(true);
                            xMPNode2.getOptions().setHasLanguage(true);
                        }
                        xMPNodeFindChildNode2.addChild(xMPNode2);
                        xMPNodeFindChildNode2.setOptions(new PropertyOptions(7680));
                        xMPNodeFindChildNode2.setValue("");
                    }
                    repairAltText(xMPNodeFindChildNode2);
                }
            } else if (XMPConst.NS_DM.equals(xMPNode.getName())) {
                XMPNode xMPNodeFindChildNode3 = XMPNodeUtils.findChildNode(xMPNode, "xmpDM:copyright", false);
                if (xMPNodeFindChildNode3 != null) {
                    migrateAudioCopyright(xMPMetaImpl, xMPNodeFindChildNode3);
                }
            } else if (XMPConst.NS_XMP_RIGHTS.equals(xMPNode.getName()) && (xMPNodeFindChildNode = XMPNodeUtils.findChildNode(xMPNode, "xmpRights:UsageTerms", false)) != null) {
                repairAltText(xMPNodeFindChildNode);
            }
        }
    }

    private static void transplantArrayItemAlias(Iterator it, XMPNode xMPNode, XMPNode xMPNode2) throws XMPException {
        if (xMPNode2.getOptions().isArrayAltText()) {
            if (xMPNode.getOptions().getHasLanguage()) {
                throw new XMPException("Alias to x-default already has a language qualifier", 203);
            }
            xMPNode.addQualifier(new XMPNode(XMPConst.XML_LANG, XMPConst.X_DEFAULT, null));
        }
        it.remove();
        xMPNode.setName(XMPConst.ARRAY_ITEM_NAME);
        xMPNode2.addChild(xMPNode);
    }

    private static void tweakOldXMP(XMPNode xMPNode) throws XMPException {
        if (xMPNode.getName() == null || xMPNode.getName().length() < 36) {
            return;
        }
        String lowerCase = xMPNode.getName().toLowerCase();
        if (lowerCase.startsWith("uuid:")) {
            lowerCase = lowerCase.substring(5);
        }
        if (Utils.checkUUIDFormat(lowerCase)) {
            XMPNode xMPNodeFindNode = XMPNodeUtils.findNode(xMPNode, XMPPathParser.expandXPath(XMPConst.NS_XMP_MM, "InstanceID"), true, null);
            if (xMPNodeFindNode == null) {
                throw new XMPException("Failure creating xmpMM:InstanceID", 9);
            }
            xMPNodeFindNode.setOptions(null);
            xMPNodeFindNode.setValue(AbstractC0541b.m772n("uuid:", lowerCase));
            xMPNodeFindNode.removeChildren();
            xMPNodeFindNode.removeQualifiers();
            xMPNode.setName(null);
        }
    }
}
