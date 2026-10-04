package org.apache.poi.xslf.usermodel;

import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorScheme;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSLFTheme extends POIXMLDocumentPart {
    private Map<String, CTColor> _schemeColors;
    private CTOfficeStyleSheet _theme;

    public XSLFTheme() {
        this._theme = CTOfficeStyleSheet.Factory.newInstance();
    }

    private void initialize() {
        CTColorScheme clrScheme = this._theme.getThemeElements().getClrScheme();
        this._schemeColors = new HashMap(12);
        for (XmlObject xmlObject : clrScheme.selectPath("*")) {
            CTColor cTColor = (CTColor) xmlObject;
            this._schemeColors.put(cTColor.getDomNode().getLocalName(), cTColor);
        }
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    public final void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(XSSFRelation.NS_DRAWINGML, BaseWidgetConstant.WIDGET_THEME));
        OutputStream outputStream = getPackagePart().getOutputStream();
        getXmlObject().save(outputStream, xmlOptions);
        outputStream.close();
    }

    public CTColor getCTColor(String str) {
        return this._schemeColors.get(str);
    }

    public CTTextParagraphProperties getDefaultParagraphStyle() {
        XmlObject[] xmlObjectArrSelectPath = this._theme.selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//a:objectDefaults/a:spDef/a:lstStyle/a:defPPr");
        if (xmlObjectArrSelectPath.length == 1) {
            return (CTTextParagraphProperties) xmlObjectArrSelectPath[0];
        }
        return null;
    }

    public String getMajorFont() {
        return this._theme.getThemeElements().getFontScheme().getMajorFont().getLatin().getTypeface();
    }

    public String getMinorFont() {
        return this._theme.getThemeElements().getFontScheme().getMinorFont().getLatin().getTypeface();
    }

    public String getName() {
        return this._theme.getName();
    }

    @Internal
    public CTOfficeStyleSheet getXmlObject() {
        return this._theme;
    }

    public void importTheme(XSLFTheme xSLFTheme) {
        this._theme = xSLFTheme.getXmlObject();
        this._schemeColors = xSLFTheme._schemeColors;
    }

    public void initColorMap(CTColorMapping cTColorMapping) {
        Map<String, CTColor> map = this._schemeColors;
        map.put("bg1", map.get(cTColorMapping.getBg1().toString()));
        Map<String, CTColor> map2 = this._schemeColors;
        map2.put("bg2", map2.get(cTColorMapping.getBg2().toString()));
        Map<String, CTColor> map3 = this._schemeColors;
        map3.put("tx1", map3.get(cTColorMapping.getTx1().toString()));
        Map<String, CTColor> map4 = this._schemeColors;
        map4.put("tx2", map4.get(cTColorMapping.getTx2().toString()));
    }

    public void setName(String str) {
        this._theme.setName(str);
    }

    public XSLFTheme(PackagePart packagePart) {
        super(packagePart);
        this._theme = ThemeDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getTheme();
        initialize();
    }
}
