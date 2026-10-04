package com.microsoft.schemas.vml;

import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.schemas.office.office.STConnectType;
import com.microsoft.schemas.office.office.STTrueFalse;
import com.microsoft.schemas.vml.STTrueFalse;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;

/* JADX INFO: loaded from: classes6.dex */
public interface CTPath extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTPath.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctpath5963type");

    STTrueFalse.Enum getArrowok();

    String getConnectangles();

    String getConnectlocs();

    STConnectType.Enum getConnecttype();

    STTrueFalse.Enum getExtrusionok();

    STTrueFalse.Enum getFillok();

    STTrueFalse.Enum getGradientshapeok();

    String getId();

    STTrueFalse.Enum getInsetpenok();

    String getLimo();

    STTrueFalse.Enum getShadowok();

    STTrueFalse.Enum getStrokeok();

    String getTextboxrect();

    STTrueFalse.Enum getTextpathok();

    String getV();

    boolean isSetArrowok();

    boolean isSetConnectangles();

    boolean isSetConnectlocs();

    boolean isSetConnecttype();

    boolean isSetExtrusionok();

    boolean isSetFillok();

    boolean isSetGradientshapeok();

    boolean isSetId();

    boolean isSetInsetpenok();

    boolean isSetLimo();

    boolean isSetShadowok();

    boolean isSetStrokeok();

    boolean isSetTextboxrect();

    boolean isSetTextpathok();

    boolean isSetV();

    void setArrowok(STTrueFalse.Enum r12);

    void setConnectangles(String str);

    void setConnectlocs(String str);

    void setConnecttype(STConnectType.Enum r12);

    void setExtrusionok(STTrueFalse.Enum r12);

    void setFillok(STTrueFalse.Enum r12);

    void setGradientshapeok(STTrueFalse.Enum r12);

    void setId(String str);

    void setInsetpenok(STTrueFalse.Enum r12);

    void setLimo(String str);

    void setShadowok(STTrueFalse.Enum r12);

    void setStrokeok(STTrueFalse.Enum r12);

    void setTextboxrect(String str);

    void setTextpathok(STTrueFalse.Enum r12);

    void setV(String str);

    void unsetArrowok();

    void unsetConnectangles();

    void unsetConnectlocs();

    void unsetConnecttype();

    void unsetExtrusionok();

    void unsetFillok();

    void unsetGradientshapeok();

    void unsetId();

    void unsetInsetpenok();

    void unsetLimo();

    void unsetShadowok();

    void unsetStrokeok();

    void unsetTextboxrect();

    void unsetTextpathok();

    void unsetV();

    STTrueFalse xgetArrowok();

    XmlString xgetConnectangles();

    XmlString xgetConnectlocs();

    STConnectType xgetConnecttype();

    com.microsoft.schemas.office.office.STTrueFalse xgetExtrusionok();

    STTrueFalse xgetFillok();

    STTrueFalse xgetGradientshapeok();

    XmlString xgetId();

    STTrueFalse xgetInsetpenok();

    XmlString xgetLimo();

    STTrueFalse xgetShadowok();

    STTrueFalse xgetStrokeok();

    XmlString xgetTextboxrect();

    STTrueFalse xgetTextpathok();

    XmlString xgetV();

    void xsetArrowok(STTrueFalse sTTrueFalse);

    void xsetConnectangles(XmlString xmlString);

    void xsetConnectlocs(XmlString xmlString);

    void xsetConnecttype(STConnectType sTConnectType);

    void xsetExtrusionok(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse);

    void xsetFillok(STTrueFalse sTTrueFalse);

    void xsetGradientshapeok(STTrueFalse sTTrueFalse);

    void xsetId(XmlString xmlString);

    void xsetInsetpenok(STTrueFalse sTTrueFalse);

    void xsetLimo(XmlString xmlString);

    void xsetShadowok(STTrueFalse sTTrueFalse);

    void xsetStrokeok(STTrueFalse sTTrueFalse);

    void xsetTextboxrect(XmlString xmlString);

    void xsetTextpathok(STTrueFalse sTTrueFalse);

    void xsetV(XmlString xmlString);
}
