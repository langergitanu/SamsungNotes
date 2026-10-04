package com.adobe.internal.xmp.impl;

import androidx.exifinterface.media.ExifInterface;
import com.adobe.internal.xmp.XMPConst;
import com.adobe.internal.xmp.XMPException;
import com.adobe.internal.xmp.XMPSchemaRegistry;
import com.adobe.internal.xmp.options.AliasOptions;
import com.adobe.internal.xmp.properties.XMPAliasInfo;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class XMPSchemaRegistryImpl implements XMPSchemaRegistry, XMPConst {
    private Map namespaceToPrefixMap = new HashMap();
    private Map prefixToNamespaceMap = new HashMap();
    private Map aliasMap = new HashMap();

    /* JADX INFO: renamed from: p */
    private Pattern f1904p = Pattern.compile("[/*?\\[\\]]");

    public XMPSchemaRegistryImpl() throws Throwable {
        try {
            registerStandardNamespaces();
            registerStandardAliases();
        } catch (XMPException unused) {
            throw new RuntimeException("The XMPSchemaRegistry cannot be initialized!");
        }
    }

    private void registerStandardAliases() throws Throwable {
        AliasOptions arrayOrdered = new AliasOptions().setArrayOrdered(true);
        AliasOptions arrayAltText = new AliasOptions().setArrayAltText(true);
        registerAlias(XMPConst.NS_XMP, "Author", "http://purl.org/dc/elements/1.1/", "creator", arrayOrdered);
        registerAlias(XMPConst.NS_XMP, "Authors", "http://purl.org/dc/elements/1.1/", "creator", null);
        registerAlias(XMPConst.NS_XMP, "Description", "http://purl.org/dc/elements/1.1/", "description", null);
        registerAlias(XMPConst.NS_XMP, "Format", "http://purl.org/dc/elements/1.1/", "format", null);
        registerAlias(XMPConst.NS_XMP, "Keywords", "http://purl.org/dc/elements/1.1/", "subject", null);
        registerAlias(XMPConst.NS_XMP, "Locale", "http://purl.org/dc/elements/1.1/", "language", null);
        registerAlias(XMPConst.NS_XMP, "Title", "http://purl.org/dc/elements/1.1/", "title", null);
        registerAlias(XMPConst.NS_XMP_RIGHTS, ExifInterface.TAG_COPYRIGHT, "http://purl.org/dc/elements/1.1/", "rights", null);
        registerAlias(XMPConst.NS_PDF, "Author", "http://purl.org/dc/elements/1.1/", "creator", arrayOrdered);
        registerAlias(XMPConst.NS_PDF, "BaseURL", XMPConst.NS_XMP, "BaseURL", null);
        registerAlias(XMPConst.NS_PDF, "CreationDate", XMPConst.NS_XMP, "CreateDate", null);
        registerAlias(XMPConst.NS_PDF, "Creator", XMPConst.NS_XMP, "CreatorTool", null);
        registerAlias(XMPConst.NS_PDF, "ModDate", XMPConst.NS_XMP, "ModifyDate", null);
        registerAlias(XMPConst.NS_PDF, "Subject", "http://purl.org/dc/elements/1.1/", "description", arrayAltText);
        registerAlias(XMPConst.NS_PDF, "Title", "http://purl.org/dc/elements/1.1/", "title", arrayAltText);
        registerAlias(XMPConst.NS_PHOTOSHOP, "Author", "http://purl.org/dc/elements/1.1/", "creator", arrayOrdered);
        registerAlias(XMPConst.NS_PHOTOSHOP, "Caption", "http://purl.org/dc/elements/1.1/", "description", arrayAltText);
        registerAlias(XMPConst.NS_PHOTOSHOP, ExifInterface.TAG_COPYRIGHT, "http://purl.org/dc/elements/1.1/", "rights", arrayAltText);
        registerAlias(XMPConst.NS_PHOTOSHOP, "Keywords", "http://purl.org/dc/elements/1.1/", "subject", null);
        registerAlias(XMPConst.NS_PHOTOSHOP, "Marked", XMPConst.NS_XMP_RIGHTS, "Marked", null);
        registerAlias(XMPConst.NS_PHOTOSHOP, "Title", "http://purl.org/dc/elements/1.1/", "title", arrayAltText);
        registerAlias(XMPConst.NS_PHOTOSHOP, "WebStatement", XMPConst.NS_XMP_RIGHTS, "WebStatement", null);
        registerAlias(XMPConst.NS_TIFF, ExifInterface.TAG_ARTIST, "http://purl.org/dc/elements/1.1/", "creator", arrayOrdered);
        registerAlias(XMPConst.NS_TIFF, ExifInterface.TAG_COPYRIGHT, "http://purl.org/dc/elements/1.1/", "rights", null);
        registerAlias(XMPConst.NS_TIFF, ExifInterface.TAG_DATETIME, XMPConst.NS_XMP, "ModifyDate", null);
        registerAlias(XMPConst.NS_EXIF, ExifInterface.TAG_DATETIME_DIGITIZED, XMPConst.NS_XMP, "CreateDate", null);
        registerAlias(XMPConst.NS_TIFF, ExifInterface.TAG_IMAGE_DESCRIPTION, "http://purl.org/dc/elements/1.1/", "description", null);
        registerAlias(XMPConst.NS_TIFF, ExifInterface.TAG_SOFTWARE, XMPConst.NS_XMP, "CreatorTool", null);
        registerAlias(XMPConst.NS_PNG, "Author", "http://purl.org/dc/elements/1.1/", "creator", arrayOrdered);
        registerAlias(XMPConst.NS_PNG, ExifInterface.TAG_COPYRIGHT, "http://purl.org/dc/elements/1.1/", "rights", arrayAltText);
        registerAlias(XMPConst.NS_PNG, "CreationTime", XMPConst.NS_XMP, "CreateDate", null);
        registerAlias(XMPConst.NS_PNG, "Description", "http://purl.org/dc/elements/1.1/", "description", arrayAltText);
        registerAlias(XMPConst.NS_PNG, "ModificationTime", XMPConst.NS_XMP, "ModifyDate", null);
        registerAlias(XMPConst.NS_PNG, ExifInterface.TAG_SOFTWARE, XMPConst.NS_XMP, "CreatorTool", null);
        registerAlias(XMPConst.NS_PNG, "Title", "http://purl.org/dc/elements/1.1/", "title", arrayAltText);
    }

    private void registerStandardNamespaces() {
        registerNamespace("http://www.w3.org/XML/1998/namespace", "xml");
        registerNamespace(XMPConst.NS_RDF, "rdf");
        registerNamespace("http://purl.org/dc/elements/1.1/", "dc");
        registerNamespace(XMPConst.NS_IPTCCORE, "Iptc4xmpCore");
        registerNamespace(XMPConst.NS_IPTCEXT, "Iptc4xmpExt");
        registerNamespace(XMPConst.NS_DICOM, "DICOM");
        registerNamespace(XMPConst.NS_PLUS, "plus");
        registerNamespace(XMPConst.NS_X, "x");
        registerNamespace(XMPConst.NS_IX, "iX");
        registerNamespace(XMPConst.NS_XMP, "xmp");
        registerNamespace(XMPConst.NS_XMP_RIGHTS, "xmpRights");
        registerNamespace(XMPConst.NS_XMP_MM, "xmpMM");
        registerNamespace(XMPConst.NS_XMP_BJ, "xmpBJ");
        registerNamespace(XMPConst.NS_XMP_NOTE, "xmpNote");
        registerNamespace(XMPConst.NS_PDF, Constants.PDF_EXTENSION);
        registerNamespace(XMPConst.NS_PDFX, "pdfx");
        registerNamespace(XMPConst.NS_PDFX_ID, "pdfxid");
        registerNamespace(XMPConst.NS_PDFA_SCHEMA, "pdfaSchema");
        registerNamespace(XMPConst.NS_PDFA_PROPERTY, "pdfaProperty");
        registerNamespace(XMPConst.NS_PDFA_TYPE, "pdfaType");
        registerNamespace(XMPConst.NS_PDFA_FIELD, "pdfaField");
        registerNamespace(XMPConst.NS_PDFA_ID, "pdfaid");
        registerNamespace(XMPConst.NS_PDFA_EXTENSION, "pdfaExtension");
        registerNamespace(XMPConst.NS_PHOTOSHOP, "photoshop");
        registerNamespace(XMPConst.NS_PSALBUM, "album");
        registerNamespace(XMPConst.NS_EXIF, "exif");
        registerNamespace(XMPConst.NS_EXIFX, "exifEX");
        registerNamespace(XMPConst.NS_EXIF_AUX, "aux");
        registerNamespace(XMPConst.NS_TIFF, "tiff");
        registerNamespace(XMPConst.NS_PNG, Constants.THUMBNAIL_PNG_EXTENSION);
        registerNamespace(XMPConst.NS_JPEG, "jpeg");
        registerNamespace(XMPConst.NS_JP2K, "jp2k");
        registerNamespace(XMPConst.NS_CAMERARAW, "crs");
        registerNamespace(XMPConst.NS_ADOBESTOCKPHOTO, "bmsp");
        registerNamespace(XMPConst.NS_CREATOR_ATOM, "creatorAtom");
        registerNamespace(XMPConst.NS_ASF, "asf");
        registerNamespace(XMPConst.NS_WAV, "wav");
        registerNamespace(XMPConst.NS_BWF, "bext");
        registerNamespace(XMPConst.NS_RIFFINFO, "riffinfo");
        registerNamespace(XMPConst.NS_SCRIPT, "xmpScript");
        registerNamespace(XMPConst.NS_TXMP, "txmp");
        registerNamespace(XMPConst.NS_SWF, "swf");
        registerNamespace(XMPConst.NS_CCV, "ccv");
        registerNamespace(XMPConst.NS_DM, "xmpDM");
        registerNamespace(XMPConst.NS_TRANSIENT, "xmpx");
        registerNamespace(XMPConst.TYPE_TEXT, "xmpT");
        registerNamespace(XMPConst.TYPE_PAGEDFILE, "xmpTPg");
        registerNamespace(XMPConst.TYPE_GRAPHICS, "xmpG");
        registerNamespace(XMPConst.TYPE_IMAGE, "xmpGImg");
        registerNamespace(XMPConst.TYPE_FONT, "stFnt");
        registerNamespace(XMPConst.TYPE_DIMENSIONS, "stDim");
        registerNamespace(XMPConst.TYPE_RESOURCEEVENT, "stEvt");
        registerNamespace(XMPConst.TYPE_RESOURCEREF, "stRef");
        registerNamespace(XMPConst.TYPE_ST_VERSION, "stVer");
        registerNamespace(XMPConst.TYPE_ST_JOB, "stJob");
        registerNamespace(XMPConst.TYPE_MANIFESTITEM, "stMfs");
        registerNamespace(XMPConst.TYPE_IDENTIFIERQUAL, "xmpidq");
    }

    @Override // com.adobe.internal.xmp.XMPSchemaRegistry
    public synchronized void deleteNamespace(String str) {
        String namespacePrefix = getNamespacePrefix(str);
        if (namespacePrefix != null) {
            this.namespaceToPrefixMap.remove(str);
            this.prefixToNamespaceMap.remove(namespacePrefix);
        }
    }

    @Override // com.adobe.internal.xmp.XMPSchemaRegistry
    public synchronized XMPAliasInfo findAlias(String str) {
        return (XMPAliasInfo) this.aliasMap.get(str);
    }

    @Override // com.adobe.internal.xmp.XMPSchemaRegistry
    public synchronized XMPAliasInfo[] findAliases(String str) {
        ArrayList arrayList;
        try {
            String namespacePrefix = getNamespacePrefix(str);
            arrayList = new ArrayList();
            if (namespacePrefix != null) {
                for (String str2 : this.aliasMap.keySet()) {
                    if (str2.startsWith(namespacePrefix)) {
                        arrayList.add(findAlias(str2));
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return (XMPAliasInfo[]) arrayList.toArray(new XMPAliasInfo[arrayList.size()]);
    }

    @Override // com.adobe.internal.xmp.XMPSchemaRegistry
    public synchronized Map getAliases() {
        return Collections.unmodifiableMap(new TreeMap(this.aliasMap));
    }

    @Override // com.adobe.internal.xmp.XMPSchemaRegistry
    public synchronized String getNamespacePrefix(String str) {
        return (String) this.namespaceToPrefixMap.get(str);
    }

    @Override // com.adobe.internal.xmp.XMPSchemaRegistry
    public synchronized String getNamespaceURI(String str) {
        if (str != null) {
            try {
                if (!str.endsWith(":")) {
                    str = str.concat(":");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return (String) this.prefixToNamespaceMap.get(str);
    }

    @Override // com.adobe.internal.xmp.XMPSchemaRegistry
    public synchronized Map getNamespaces() {
        return Collections.unmodifiableMap(new TreeMap(this.namespaceToPrefixMap));
    }

    @Override // com.adobe.internal.xmp.XMPSchemaRegistry
    public synchronized Map getPrefixes() {
        return Collections.unmodifiableMap(new TreeMap(this.prefixToNamespaceMap));
    }

    public synchronized void registerAlias(String str, String str2, final String str3, final String str4, AliasOptions aliasOptions) throws Throwable {
        Throwable th;
        AliasOptions aliasOptions2;
        try {
            try {
                ParameterAsserts.assertSchemaNS(str);
                ParameterAsserts.assertPropName(str2);
                ParameterAsserts.assertSchemaNS(str3);
                ParameterAsserts.assertPropName(str4);
                if (aliasOptions != null) {
                    try {
                        aliasOptions2 = new AliasOptions(XMPNodeUtils.verifySetOptions(aliasOptions.toPropertyOptions(), null).getOptions());
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    aliasOptions2 = new AliasOptions();
                }
                final AliasOptions aliasOptions3 = aliasOptions2;
                if (this.f1904p.matcher(str2).find() || this.f1904p.matcher(str4).find()) {
                    throw new XMPException("Alias and actual property names must be simple", 102);
                }
                String namespacePrefix = getNamespacePrefix(str);
                final String namespacePrefix2 = getNamespacePrefix(str3);
                if (namespacePrefix == null) {
                    throw new XMPException("Alias namespace is not registered", 101);
                }
                if (namespacePrefix2 == null) {
                    throw new XMPException("Actual namespace is not registered", 101);
                }
                String str5 = namespacePrefix + str2;
                if (this.aliasMap.containsKey(str5)) {
                    throw new XMPException("Alias is already existing", 4);
                }
                if (this.aliasMap.containsKey(namespacePrefix2 + str4)) {
                    throw new XMPException("Actual property is already an alias, use the base property", 4);
                }
                this.aliasMap.put(str5, new XMPAliasInfo() { // from class: com.adobe.internal.xmp.impl.XMPSchemaRegistryImpl.1
                    @Override // com.adobe.internal.xmp.properties.XMPAliasInfo
                    public AliasOptions getAliasForm() {
                        return aliasOptions3;
                    }

                    @Override // com.adobe.internal.xmp.properties.XMPAliasInfo
                    public String getNamespace() {
                        return str3;
                    }

                    @Override // com.adobe.internal.xmp.properties.XMPAliasInfo
                    public String getPrefix() {
                        return namespacePrefix2;
                    }

                    @Override // com.adobe.internal.xmp.properties.XMPAliasInfo
                    public String getPropName() {
                        return str4;
                    }

                    public String toString() {
                        return namespacePrefix2 + str4 + " NS(" + str3 + "), FORM (" + getAliasForm() + ")";
                    }
                });
                return;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        th = th;
        throw th;
    }

    @Override // com.adobe.internal.xmp.XMPSchemaRegistry
    public synchronized String registerNamespace(String str, String str2) {
        try {
            ParameterAsserts.assertSchemaNS(str);
            ParameterAsserts.assertPrefix(str2);
            if (str2.charAt(str2.length() - 1) != ':') {
                str2 = str2.concat(":");
            }
            if (!Utils.isXMLNameNS(str2.substring(0, str2.length() - 1))) {
                throw new XMPException("The prefix is a bad XML name", 201);
            }
            String str3 = (String) this.namespaceToPrefixMap.get(str);
            String str4 = (String) this.prefixToNamespaceMap.get(str2);
            if (str3 != null) {
                return str3;
            }
            if (str4 != null) {
                String str5 = str2;
                int i = 1;
                while (this.prefixToNamespaceMap.containsKey(str5)) {
                    str5 = str2.substring(0, str2.length() - 1) + "_" + i + "_:";
                    i++;
                }
                str2 = str5;
            }
            this.prefixToNamespaceMap.put(str2, str);
            this.namespaceToPrefixMap.put(str, str2);
            return str2;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.adobe.internal.xmp.XMPSchemaRegistry
    public synchronized XMPAliasInfo resolveAlias(String str, String str2) {
        String namespacePrefix = getNamespacePrefix(str);
        if (namespacePrefix == null) {
            return null;
        }
        return (XMPAliasInfo) this.aliasMap.get(namespacePrefix + str2);
    }
}
