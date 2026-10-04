package org.apache.poi.xwpf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrDefault;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPrDefault;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.StylesDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XWPFStyles extends POIXMLDocumentPart {
    private CTStyles ctStyles;
    private XWPFDefaultParagraphStyle defaultParaStyle;
    private XWPFDefaultRunStyle defaultRunStyle;
    private XWPFLatentStyles latentStyles;
    private List<XWPFStyle> listStyle;

    public XWPFStyles(PackagePart packagePart) {
        super(packagePart);
        this.listStyle = new ArrayList();
    }

    public void addStyle(XWPFStyle xWPFStyle) {
        this.listStyle.add(xWPFStyle);
        this.ctStyles.addNewStyle();
        this.ctStyles.setStyleArray(this.ctStyles.sizeOfStyleArray() - 1, xWPFStyle.getCTStyle());
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    public void commit() throws IOException {
        if (this.ctStyles == null) {
            throw new IllegalStateException("Unable to write out styles that were never read in!");
        }
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTStyles.type.getName().getNamespaceURI(), "styles"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        this.ctStyles.save(outputStream, xmlOptions);
        outputStream.close();
    }

    public void ensureDocDefaults() {
        if (!this.ctStyles.isSetDocDefaults()) {
            this.ctStyles.addNewDocDefaults();
        }
        CTDocDefaults docDefaults = this.ctStyles.getDocDefaults();
        if (!docDefaults.isSetPPrDefault()) {
            docDefaults.addNewPPrDefault();
        }
        if (!docDefaults.isSetRPrDefault()) {
            docDefaults.addNewRPrDefault();
        }
        CTPPrDefault pPrDefault = docDefaults.getPPrDefault();
        CTRPrDefault rPrDefault = docDefaults.getRPrDefault();
        if (!pPrDefault.isSetPPr()) {
            pPrDefault.addNewPPr();
        }
        if (!rPrDefault.isSetRPr()) {
            rPrDefault.addNewRPr();
        }
        this.defaultRunStyle = new XWPFDefaultRunStyle(rPrDefault.getRPr());
        this.defaultParaStyle = new XWPFDefaultParagraphStyle(pPrDefault.getPPr());
    }

    public CTLanguage getCTLanguage() {
        ensureDocDefaults();
        return this.defaultRunStyle.getRPr().isSetLang() ? this.defaultRunStyle.getRPr().getLang() : this.defaultRunStyle.getRPr().addNewLang();
    }

    public XWPFDefaultParagraphStyle getDefaultParagraphStyle() {
        ensureDocDefaults();
        return this.defaultParaStyle;
    }

    public XWPFDefaultRunStyle getDefaultRunStyle() {
        ensureDocDefaults();
        return this.defaultRunStyle;
    }

    public XWPFLatentStyles getLatentStyles() {
        return this.latentStyles;
    }

    public int getNumberOfStyles() {
        return this.listStyle.size();
    }

    public XWPFStyle getStyle(String str) {
        for (XWPFStyle xWPFStyle : this.listStyle) {
            if (xWPFStyle.getStyleId().equals(str)) {
                return xWPFStyle;
            }
        }
        return null;
    }

    public XWPFStyle getStyleWithSameName(XWPFStyle xWPFStyle) {
        for (XWPFStyle xWPFStyle2 : this.listStyle) {
            if (xWPFStyle2.hasSameName(xWPFStyle)) {
                return xWPFStyle2;
            }
        }
        return null;
    }

    public List<XWPFStyle> getUsedStyleList(XWPFStyle xWPFStyle) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(xWPFStyle);
        return getUsedStyleList(xWPFStyle, arrayList);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    public void onDocumentRead() {
        InputStream inputStream = getPackagePart().getInputStream();
        try {
            try {
                setStyles(StylesDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getStyles());
                this.latentStyles = new XWPFLatentStyles(this.ctStyles.getLatentStyles(), this);
            } catch (XmlException e) {
                throw new POIXMLException("Unable to read styles", e);
            }
        } finally {
            inputStream.close();
        }
    }

    public void setDefaultFonts(CTFonts cTFonts) {
        ensureDocDefaults();
        this.defaultRunStyle.getRPr().setRFonts(cTFonts);
    }

    public void setEastAsia(String str) {
        getCTLanguage().setEastAsia(str);
    }

    public void setSpellingLanguage(String str) {
        CTLanguage cTLanguage = getCTLanguage();
        cTLanguage.setVal(str);
        cTLanguage.setBidi(str);
    }

    public void setStyles(CTStyles cTStyles) {
        this.ctStyles = cTStyles;
        for (CTStyle cTStyle : cTStyles.getStyleArray()) {
            this.listStyle.add(new XWPFStyle(cTStyle, this));
        }
        if (this.ctStyles.isSetDocDefaults()) {
            CTDocDefaults docDefaults = this.ctStyles.getDocDefaults();
            if (docDefaults.isSetRPrDefault() && docDefaults.getRPrDefault().isSetRPr()) {
                this.defaultRunStyle = new XWPFDefaultRunStyle(docDefaults.getRPrDefault().getRPr());
            }
            if (docDefaults.isSetPPrDefault() && docDefaults.getPPrDefault().isSetPPr()) {
                this.defaultParaStyle = new XWPFDefaultParagraphStyle(docDefaults.getPPrDefault().getPPr());
            }
        }
    }

    public boolean styleExist(String str) {
        Iterator<XWPFStyle> it = this.listStyle.iterator();
        while (it.hasNext()) {
            if (it.next().getStyleId().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public XWPFStyles() {
        this.listStyle = new ArrayList();
    }

    private List<XWPFStyle> getUsedStyleList(XWPFStyle xWPFStyle, List<XWPFStyle> list) {
        XWPFStyle style = getStyle(xWPFStyle.getBasisStyleID());
        if (style != null && !list.contains(style)) {
            list.add(style);
            getUsedStyleList(style, list);
        }
        XWPFStyle style2 = getStyle(xWPFStyle.getLinkStyleID());
        if (style2 != null && !list.contains(style2)) {
            list.add(style2);
            getUsedStyleList(style2, list);
        }
        XWPFStyle style3 = getStyle(xWPFStyle.getNextStyleID());
        if (style3 != null && !list.contains(style3)) {
            list.add(style2);
            getUsedStyleList(style2, list);
        }
        return list;
    }
}
