package com.microsoft.schemas.vml;

import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.schemas.office.office.STInsetMode;
import com.microsoft.schemas.office.office.STTrueFalse;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent;

/* JADX INFO: loaded from: classes6.dex */
public interface CTTextbox extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTextbox.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttextboxf712type");

    CTTxbxContent addNewTxbxContent();

    String getId();

    String getInset();

    STInsetMode.Enum getInsetmode();

    STTrueFalse.Enum getSingleclick();

    String getStyle();

    CTTxbxContent getTxbxContent();

    boolean isSetId();

    boolean isSetInset();

    boolean isSetInsetmode();

    boolean isSetSingleclick();

    boolean isSetStyle();

    boolean isSetTxbxContent();

    void setId(String str);

    void setInset(String str);

    void setInsetmode(STInsetMode.Enum r12);

    void setSingleclick(STTrueFalse.Enum r12);

    void setStyle(String str);

    void setTxbxContent(CTTxbxContent cTTxbxContent);

    void unsetId();

    void unsetInset();

    void unsetInsetmode();

    void unsetSingleclick();

    void unsetStyle();

    void unsetTxbxContent();

    XmlString xgetId();

    XmlString xgetInset();

    STInsetMode xgetInsetmode();

    com.microsoft.schemas.office.office.STTrueFalse xgetSingleclick();

    XmlString xgetStyle();

    void xsetId(XmlString xmlString);

    void xsetInset(XmlString xmlString);

    void xsetInsetmode(STInsetMode sTInsetMode);

    void xsetSingleclick(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse);

    void xsetStyle(XmlString xmlString);
}
