package org.apache.poi.xwpf.usermodel;

import com.samsung.scsp.common.Header;
import java.io.InputStream;
import java.io.StringReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.p228wp.usermodel.CharacterRun;
import org.apache.poi.util.DocumentHelper;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.picture.CTPictureNonVisual;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdnRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBrClear$Enum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBrType$Enum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHighlightColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STUnderline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalAlignRun;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XWPFRun implements ISDTContents, IRunElement, CharacterRun {
    private IRunBody parent;
    private String pictureText;
    private List<XWPFPicture> pictures;
    private CTR run;

    public XWPFRun(CTR ctr, IRunBody iRunBody) {
        this.run = ctr;
        this.parent = iRunBody;
        for (CTDrawing cTDrawing : ctr.getDrawingArray()) {
            for (CTAnchor cTAnchor : cTDrawing.getAnchorArray()) {
                if (cTAnchor.getDocPr() != null) {
                    getDocument().getDrawingIdManager().reserve(cTAnchor.getDocPr().getId());
                }
            }
            for (CTInline cTInline : cTDrawing.getInlineArray()) {
                if (cTInline.getDocPr() != null) {
                    getDocument().getDrawingIdManager().reserve(cTInline.getDocPr().getId());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(ctr.getPictArray()));
        arrayList.addAll(Arrays.asList(ctr.getDrawingArray()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            for (XmlObject xmlObject : ((XmlObject) it.next()).selectPath("declare namespace w='http://schemas.openxmlformats.org/wordprocessingml/2006/main' .//w:t")) {
                NodeList childNodes = xmlObject.getDomNode().getChildNodes();
                for (int i = 0; i < childNodes.getLength(); i++) {
                    if (childNodes.item(i) instanceof Text) {
                        if (sb.length() > 0) {
                            sb.append("\n");
                        }
                        sb.append(childNodes.item(i).getNodeValue());
                    }
                }
            }
        }
        this.pictureText = sb.toString();
        this.pictures = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Iterator<CTPicture> it3 = getCTPictures((XmlObject) it2.next()).iterator();
            while (it3.hasNext()) {
                this.pictures.add(new XWPFPicture(it3.next(), this));
            }
        }
    }

    private void _getText(XmlObject xmlObject, StringBuffer stringBuffer) {
        if ((xmlObject instanceof CTText) && !"w:instrText".equals(xmlObject.getDomNode().getNodeName())) {
            stringBuffer.append(((CTText) xmlObject).getStringValue());
        }
        if (xmlObject instanceof CTFldChar) {
            CTFldChar cTFldChar = (CTFldChar) xmlObject;
            if (cTFldChar.getFldCharType() == STFldCharType.BEGIN && cTFldChar.getFfData() != null) {
                for (CTFFCheckBox cTFFCheckBox : cTFldChar.getFfData().getCheckBoxList()) {
                    if (cTFFCheckBox.getDefault() == null || cTFFCheckBox.getDefault().getVal() != STOnOff.X_1) {
                        stringBuffer.append("|_|");
                    } else {
                        stringBuffer.append("|X|");
                    }
                }
            }
        }
        if (xmlObject instanceof CTPTab) {
            stringBuffer.append("\t");
        }
        if (xmlObject instanceof CTBr) {
            stringBuffer.append("\n");
        }
        if (xmlObject instanceof CTEmpty) {
            String nodeName = xmlObject.getDomNode().getNodeName();
            if ("w:tab".equals(nodeName) || "tab".equals(nodeName)) {
                stringBuffer.append("\t");
            }
            if ("w:br".equals(nodeName) || Header.f8126BR.equals(nodeName)) {
                stringBuffer.append("\n");
            }
            if ("w:cr".equals(nodeName) || "cr".equals(nodeName)) {
                stringBuffer.append("\n");
            }
        }
        if (xmlObject instanceof CTFtnEdnRef) {
            CTFtnEdnRef cTFtnEdnRef = (CTFtnEdnRef) xmlObject;
            StringBuilder sb = cTFtnEdnRef.getDomNode().getLocalName().equals("footnoteReference") ? new StringBuilder("[footnoteRef:") : new StringBuilder("[endnoteRef:");
            sb.append(cTFtnEdnRef.getId().intValue());
            sb.append("]");
            stringBuffer.append(sb.toString());
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    private List<CTPicture> getCTPictures(XmlObject xmlObject) throws POIXMLException {
        ArrayList arrayList = new ArrayList();
        XmlObject[] xmlObjectArrSelectPath = xmlObject.selectPath("declare namespace pic='" + CTPicture.type.getName().getNamespaceURI() + "' .//pic:pic");
        int length = xmlObjectArrSelectPath.length;
        for (int i = 0; i < length; i++) {
            XmlObject xmlObject2 = xmlObjectArrSelectPath[i];
            if (xmlObject2 instanceof XmlAnyTypeImpl) {
                try {
                    xmlObject2 = CTPicture.Factory.parse(xmlObject2.toString(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
                } catch (XmlException e) {
                    throw new POIXMLException(e);
                }
            }
            if (xmlObject2 instanceof CTPicture) {
                arrayList.add((CTPicture) xmlObject2);
            }
        }
        return arrayList;
    }

    private void handleRuby(XmlObject xmlObject, StringBuffer stringBuffer, boolean z) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        xmlCursorNewCursor.selectPath(".//*");
        boolean z2 = false;
        boolean z3 = false;
        while (xmlCursorNewCursor.toNextSelection()) {
            XmlObject object = xmlCursorNewCursor.getObject();
            if (object instanceof CTRubyContent) {
                String nodeName = object.getDomNode().getNodeName();
                if ("w:rt".equals(nodeName)) {
                    z2 = true;
                } else if ("w:rubyBase".equals(nodeName)) {
                    z2 = false;
                    z3 = true;
                }
            } else if (z && z2) {
                _getText(object, stringBuffer);
            } else if (!z && z3) {
                _getText(object, stringBuffer);
            }
        }
        xmlCursorNewCursor.dispose();
    }

    private static boolean isCTOnOff(CTOnOff cTOnOff) {
        STOnOff.Enum val;
        return !cTOnOff.isSetVal() || STOnOff.TRUE == (val = cTOnOff.getVal()) || STOnOff.X_1 == val || STOnOff.f10218ON == val;
    }

    public static void preserveSpaces(XmlString xmlString) {
        String stringValue = xmlString.getStringValue();
        if (stringValue != null) {
            if (stringValue.startsWith(" ") || stringValue.endsWith(" ")) {
                XmlCursor xmlCursorNewCursor = xmlString.newCursor();
                xmlCursorNewCursor.toNextToken();
                xmlCursorNewCursor.insertAttributeWithValue(new QName("http://www.w3.org/XML/1998/namespace", "space"), "preserve");
                xmlCursorNewCursor.dispose();
            }
        }
    }

    public void addBreak() {
        this.run.addNewBr();
    }

    public void addCarriageReturn() {
        this.run.addNewCr();
    }

    public XWPFPicture addPicture(InputStream inputStream, int i, String str, int i2, int i4) {
        XWPFPictureData xWPFPictureData;
        if (this.parent.getPart() instanceof XWPFHeaderFooter) {
            XWPFHeaderFooter xWPFHeaderFooter = (XWPFHeaderFooter) this.parent.getPart();
            xWPFPictureData = (XWPFPictureData) xWPFHeaderFooter.getRelationById(xWPFHeaderFooter.addPictureData(inputStream, i));
        } else {
            XWPFDocument document = this.parent.getDocument();
            xWPFPictureData = (XWPFPictureData) document.getRelationById(document.addPictureData(inputStream, i));
        }
        try {
            CTInline cTInlineAddNewInline = this.run.addNewDrawing().addNewInline();
            StringBuilder sb = new StringBuilder("<a:graphic xmlns:a=\"");
            sb.append(CTGraphicalObject.type.getName().getNamespaceURI());
            sb.append("\"><a:graphicData uri=\"");
            SchemaType schemaType = CTPicture.type;
            sb.append(schemaType.getName().getNamespaceURI());
            sb.append("\"><pic:pic xmlns:pic=\"");
            sb.append(schemaType.getName().getNamespaceURI());
            sb.append("\" /></a:graphicData></a:graphic>");
            cTInlineAddNewInline.set(XmlToken.Factory.parse(DocumentHelper.readDocument(new InputSource(new StringReader(sb.toString()))).getDocumentElement(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS));
            cTInlineAddNewInline.setDistT(0L);
            cTInlineAddNewInline.setDistR(0L);
            cTInlineAddNewInline.setDistB(0L);
            cTInlineAddNewInline.setDistL(0L);
            CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewDocPr = cTInlineAddNewInline.addNewDocPr();
            long jReserveNew = getParent().getDocument().getDrawingIdManager().reserveNew();
            cTNonVisualDrawingPropsAddNewDocPr.setId(jReserveNew);
            cTNonVisualDrawingPropsAddNewDocPr.setName("Drawing " + jReserveNew);
            cTNonVisualDrawingPropsAddNewDocPr.setDescr(str);
            CTPositiveSize2D cTPositiveSize2DAddNewExtent = cTInlineAddNewInline.addNewExtent();
            long j = i2;
            cTPositiveSize2DAddNewExtent.setCx(j);
            long j2 = i4;
            cTPositiveSize2DAddNewExtent.setCy(j2);
            CTPicture cTPicture = getCTPictures(cTInlineAddNewInline.getGraphic().getGraphicData()).get(0);
            CTPictureNonVisual cTPictureNonVisualAddNewNvPicPr = cTPicture.addNewNvPicPr();
            CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTPictureNonVisualAddNewNvPicPr.addNewCNvPr();
            cTNonVisualDrawingPropsAddNewCNvPr.setId(0L);
            cTNonVisualDrawingPropsAddNewCNvPr.setName("Picture " + jReserveNew);
            cTNonVisualDrawingPropsAddNewCNvPr.setDescr(str);
            cTPictureNonVisualAddNewNvPicPr.addNewCNvPicPr().addNewPicLocks().setNoChangeAspect(true);
            CTBlipFillProperties cTBlipFillPropertiesAddNewBlipFill = cTPicture.addNewBlipFill();
            cTBlipFillPropertiesAddNewBlipFill.addNewBlip().setEmbed(this.parent.getPart().getRelationId(xWPFPictureData));
            cTBlipFillPropertiesAddNewBlipFill.addNewStretch().addNewFillRect();
            CTShapeProperties cTShapePropertiesAddNewSpPr = cTPicture.addNewSpPr();
            CTTransform2D cTTransform2DAddNewXfrm = cTShapePropertiesAddNewSpPr.addNewXfrm();
            CTPoint2D cTPoint2DAddNewOff = cTTransform2DAddNewXfrm.addNewOff();
            cTPoint2DAddNewOff.setX(0L);
            cTPoint2DAddNewOff.setY(0L);
            CTPositiveSize2D cTPositiveSize2DAddNewExt = cTTransform2DAddNewXfrm.addNewExt();
            cTPositiveSize2DAddNewExt.setCx(j);
            cTPositiveSize2DAddNewExt.setCy(j2);
            CTPresetGeometry2D cTPresetGeometry2DAddNewPrstGeom = cTShapePropertiesAddNewSpPr.addNewPrstGeom();
            cTPresetGeometry2DAddNewPrstGeom.setPrst(STShapeType.RECT);
            cTPresetGeometry2DAddNewPrstGeom.addNewAvLst();
            XWPFPicture xWPFPicture = new XWPFPicture(cTPicture, this);
            this.pictures.add(xWPFPicture);
            return xWPFPicture;
        } catch (XmlException e) {
            throw new IllegalStateException(e);
        } catch (SAXException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public void addTab() {
        this.run.addNewTab();
    }

    @Internal
    public CTR getCTR() {
        return this.run;
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public int getCharacterSpacing() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetSpacing()) {
            return 0;
        }
        return rPr.getSpacing().getVal().intValue();
    }

    public String getColor() {
        if (!this.run.isSetRPr()) {
            return null;
        }
        CTRPr rPr = this.run.getRPr();
        if (rPr.isSetColor()) {
            return rPr.getColor().xgetVal().getStringValue();
        }
        return null;
    }

    public XWPFDocument getDocument() {
        IRunBody iRunBody = this.parent;
        if (iRunBody != null) {
            return iRunBody.getDocument();
        }
        return null;
    }

    public List<XWPFPicture> getEmbeddedPictures() {
        return this.pictures;
    }

    public String getFontFamily() {
        return getFontFamily(null);
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public String getFontName() {
        return getFontFamily();
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public int getFontSize() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetSz()) {
            return -1;
        }
        return rPr.getSz().getVal().divide(new BigInteger("2")).intValue();
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public int getKerning() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetKern()) {
            return 0;
        }
        return rPr.getKern().getVal().intValue();
    }

    public XWPFParagraph getParagraph() {
        IRunBody iRunBody = this.parent;
        if (iRunBody instanceof XWPFParagraph) {
            return (XWPFParagraph) iRunBody;
        }
        return null;
    }

    public IRunBody getParent() {
        return this.parent;
    }

    public String getPhonetic() {
        StringBuffer stringBuffer = new StringBuffer();
        XmlCursor xmlCursorNewCursor = this.run.newCursor();
        xmlCursorNewCursor.selectPath("./*");
        while (xmlCursorNewCursor.toNextSelection()) {
            XmlObject object = xmlCursorNewCursor.getObject();
            if (object instanceof CTRuby) {
                handleRuby(object, stringBuffer, true);
            }
        }
        String str = this.pictureText;
        if (str != null && str.length() > 0) {
            stringBuffer.append("\n");
            stringBuffer.append(this.pictureText);
            stringBuffer.append("\n");
        }
        xmlCursorNewCursor.dispose();
        return stringBuffer.toString();
    }

    public String getPictureText() {
        return this.pictureText;
    }

    public VerticalAlign getSubscript() {
        CTRPr rPr = this.run.getRPr();
        return (rPr == null || !rPr.isSetVertAlign()) ? VerticalAlign.BASELINE : VerticalAlign.valueOf(rPr.getVertAlign().getVal().intValue());
    }

    public String getText(int i) {
        if (this.run.sizeOfTArray() == 0) {
            return null;
        }
        return this.run.getTArray(i).getStringValue();
    }

    public int getTextPosition() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetPosition()) {
            return -1;
        }
        return rPr.getPosition().getVal().intValue();
    }

    public UnderlinePatterns getUnderline() {
        CTRPr rPr = this.run.getRPr();
        return (rPr == null || !rPr.isSetU() || rPr.getU().getVal() == null) ? UnderlinePatterns.NONE : UnderlinePatterns.valueOf(rPr.getU().getVal().intValue());
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public boolean isBold() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetB()) {
            return false;
        }
        return isCTOnOff(rPr.getB());
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public boolean isCapitalized() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetCaps()) {
            return false;
        }
        return isCTOnOff(rPr.getCaps());
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public boolean isDoubleStrikeThrough() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetDstrike()) {
            return false;
        }
        return isCTOnOff(rPr.getDstrike());
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public boolean isEmbossed() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetEmboss()) {
            return false;
        }
        return isCTOnOff(rPr.getEmboss());
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public boolean isHighlighted() {
        CTRPr rPr = this.run.getRPr();
        return (rPr == null || !rPr.isSetHighlight() || rPr.getHighlight().getVal() == STHighlightColor.NONE) ? false : true;
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public boolean isImprinted() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetImprint()) {
            return false;
        }
        return isCTOnOff(rPr.getImprint());
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public boolean isItalic() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetI()) {
            return false;
        }
        return isCTOnOff(rPr.getI());
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public boolean isShadowed() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetShadow()) {
            return false;
        }
        return isCTOnOff(rPr.getShadow());
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public boolean isSmallCaps() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetSmallCaps()) {
            return false;
        }
        return isCTOnOff(rPr.getSmallCaps());
    }

    @Deprecated
    public boolean isStrike() {
        return isStrikeThrough();
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public boolean isStrikeThrough() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetStrike()) {
            return false;
        }
        return isCTOnOff(rPr.getStrike());
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public void setBold(boolean z) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetB() ? rPr.getB() : rPr.addNewB()).setVal(z ? STOnOff.TRUE : STOnOff.FALSE);
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public void setCapitalized(boolean z) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetCaps() ? rPr.getCaps() : rPr.addNewCaps()).setVal(z ? STOnOff.TRUE : STOnOff.FALSE);
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public void setCharacterSpacing(int i) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetSpacing() ? rPr.getSpacing() : rPr.addNewSpacing()).setVal(BigInteger.valueOf(i));
    }

    public void setColor(String str) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetColor() ? rPr.getColor() : rPr.addNewColor()).setVal(str);
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public void setDoubleStrikethrough(boolean z) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetDstrike() ? rPr.getDstrike() : rPr.addNewDstrike()).setVal(z ? STOnOff.TRUE : STOnOff.FALSE);
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public void setEmbossed(boolean z) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetEmboss() ? rPr.getEmboss() : rPr.addNewEmboss()).setVal(z ? STOnOff.TRUE : STOnOff.FALSE);
    }

    public void setFontFamily(String str) {
        setFontFamily(str, null);
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public void setFontSize(int i) {
        BigInteger bigInteger = new BigInteger(AbstractC0000a.m11h(i, ""));
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetSz() ? rPr.getSz() : rPr.addNewSz()).setVal(bigInteger.multiply(new BigInteger("2")));
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public void setImprinted(boolean z) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetImprint() ? rPr.getImprint() : rPr.addNewImprint()).setVal(z ? STOnOff.TRUE : STOnOff.FALSE);
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public void setItalic(boolean z) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetI() ? rPr.getI() : rPr.addNewI()).setVal(z ? STOnOff.TRUE : STOnOff.FALSE);
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public void setKerning(int i) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetKern() ? rPr.getKern() : rPr.addNewKern()).setVal(BigInteger.valueOf(i));
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public void setShadow(boolean z) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetShadow() ? rPr.getShadow() : rPr.addNewShadow()).setVal(z ? STOnOff.TRUE : STOnOff.FALSE);
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public void setSmallCaps(boolean z) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetSmallCaps() ? rPr.getSmallCaps() : rPr.addNewSmallCaps()).setVal(z ? STOnOff.TRUE : STOnOff.FALSE);
    }

    @Deprecated
    public void setStrike(boolean z) {
        setStrikeThrough(z);
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public void setStrikeThrough(boolean z) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetStrike() ? rPr.getStrike() : rPr.addNewStrike()).setVal(z ? STOnOff.TRUE : STOnOff.FALSE);
    }

    public void setSubscript(VerticalAlign verticalAlign) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetVertAlign() ? rPr.getVertAlign() : rPr.addNewVertAlign()).setVal(STVerticalAlignRun.Enum.forInt(verticalAlign.getValue()));
    }

    public void setText(String str) {
        setText(str, this.run.sizeOfTArray());
    }

    public void setTextPosition(int i) {
        BigInteger bigInteger = new BigInteger(AbstractC0000a.m11h(i, ""));
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetPosition() ? rPr.getPosition() : rPr.addNewPosition()).setVal(bigInteger);
    }

    public void setUnderline(UnderlinePatterns underlinePatterns) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.getU() == null ? rPr.addNewU() : rPr.getU()).setVal(STUnderline.Enum.forInt(underlinePatterns.getValue()));
    }

    @Override // org.apache.poi.p228wp.usermodel.CharacterRun
    public String text() {
        StringBuffer stringBuffer = new StringBuffer();
        XmlCursor xmlCursorNewCursor = this.run.newCursor();
        xmlCursorNewCursor.selectPath("./*");
        while (xmlCursorNewCursor.toNextSelection()) {
            XmlObject object = xmlCursorNewCursor.getObject();
            if (object instanceof CTRuby) {
                handleRuby(object, stringBuffer, false);
            } else {
                _getText(object, stringBuffer);
            }
        }
        xmlCursorNewCursor.dispose();
        return stringBuffer.toString();
    }

    public String toString() {
        String phonetic = getPhonetic();
        if (phonetic.length() <= 0) {
            return text();
        }
        return text() + " (" + phonetic.toString() + ")";
    }

    public void addBreak(BreakType breakType) {
        this.run.addNewBr().setType(STBrType$Enum.forInt(breakType.getValue()));
    }

    public String getFontFamily(FontCharRange fontCharRange) {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetRFonts()) {
            return null;
        }
        CTFonts rFonts = rPr.getRFonts();
        int[] iArr = 1.$SwitchMap$org$apache$poi$xwpf$usermodel$XWPFRun$FontCharRange;
        if (fontCharRange == null) {
            fontCharRange = FontCharRange.ascii;
        }
        int i = iArr[fontCharRange.ordinal()];
        return i != 2 ? i != 3 ? i != 4 ? rFonts.getAscii() : rFonts.getHAnsi() : rFonts.getEastAsia() : rFonts.getCs();
    }

    public void setFontFamily(String str, FontCharRange fontCharRange) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        CTFonts rFonts = rPr.isSetRFonts() ? rPr.getRFonts() : rPr.addNewRFonts();
        if (fontCharRange == null) {
            rFonts.setAscii(str);
            if (!rFonts.isSetHAnsi()) {
                rFonts.setHAnsi(str);
            }
            if (!rFonts.isSetCs()) {
                rFonts.setCs(str);
            }
            if (rFonts.isSetEastAsia()) {
                return;
            }
            rFonts.setEastAsia(str);
            return;
        }
        int i = 1.$SwitchMap$org$apache$poi$xwpf$usermodel$XWPFRun$FontCharRange[fontCharRange.ordinal()];
        if (i == 1) {
            rFonts.setAscii(str);
            return;
        }
        if (i == 2) {
            rFonts.setCs(str);
        } else if (i == 3) {
            rFonts.setEastAsia(str);
        } else {
            if (i != 4) {
                return;
            }
            rFonts.setHAnsi(str);
        }
    }

    public void setText(String str, int i) {
        if (i > this.run.sizeOfTArray()) {
            throw new ArrayIndexOutOfBoundsException("Value too large for the parameter position in XWPFRun.setText(String value,int pos)");
        }
        CTText cTTextAddNewT = (i >= this.run.sizeOfTArray() || i < 0) ? this.run.addNewT() : this.run.getTArray(i);
        cTTextAddNewT.setStringValue(str);
        preserveSpaces(cTTextAddNewT);
    }

    public void addBreak(BreakClear breakClear) {
        CTBr cTBrAddNewBr = this.run.addNewBr();
        cTBrAddNewBr.setType(STBrType$Enum.forInt(BreakType.TEXT_WRAPPING.getValue()));
        cTBrAddNewBr.setClear(STBrClear$Enum.forInt(breakClear.getValue()));
    }

    public void removeBreak() {
    }

    public void removeCarriageReturn() {
    }

    public void removeTab() {
    }

    public XWPFRun(CTR ctr, XWPFParagraph xWPFParagraph) {
        this(ctr, (IRunBody) xWPFParagraph);
    }
}
