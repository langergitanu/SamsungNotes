package org.apache.poi.xslf.usermodel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.p226sl.usermodel.MasterSheet;
import org.apache.poi.p226sl.usermodel.Placeholder;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackground;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles;
import org.openxmlformats.schemas.presentationml.x2006.main.SldMasterDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSLFSlideMaster extends XSLFSheet implements MasterSheet<XSLFShape, XSLFTextParagraph> {
    private Map<String, XSLFSlideLayout> _layouts;
    private CTSlideMaster _slide;
    private XSLFTheme _theme;

    /* JADX INFO: renamed from: org.apache.poi.xslf.usermodel.XSLFSlideMaster$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C141201 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$Placeholder;

        static {
            int[] iArr = new int[Placeholder.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$Placeholder = iArr;
            try {
                iArr[Placeholder.TITLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$Placeholder[Placeholder.CENTERED_TITLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$Placeholder[Placeholder.SUBTITLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$Placeholder[Placeholder.BODY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public XSLFSlideMaster() {
        this._slide = CTSlideMaster.Factory.newInstance();
    }

    private Map<String, XSLFSlideLayout> getLayouts() {
        if (this._layouts == null) {
            this._layouts = new HashMap();
            for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
                if (pOIXMLDocumentPart instanceof XSLFSlideLayout) {
                    XSLFSlideLayout xSLFSlideLayout = (XSLFSlideLayout) pOIXMLDocumentPart;
                    this._layouts.put(xSLFSlideLayout.getName().toLowerCase(Locale.ROOT), xSLFSlideLayout);
                }
            }
        }
        return this._layouts;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public boolean canDraw(XSLFShape xSLFShape) {
        return !(xSLFShape instanceof XSLFSimpleShape) || ((XSLFSimpleShape) xSLFShape).getCTPlaceholder() == null;
    }

    public XSLFSlideLayout getLayout(SlideLayout slideLayout) {
        for (XSLFSlideLayout xSLFSlideLayout : getLayouts().values()) {
            if (xSLFSlideLayout.getType() == slideLayout) {
                return xSLFSlideLayout;
            }
        }
        return null;
    }

    @Override // org.apache.poi.p226sl.usermodel.Sheet
    public XSLFSlideMaster getMasterSheet() {
        return null;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public String getRootElementName() {
        return "sldMaster";
    }

    public XSLFSlideLayout[] getSlideLayouts() {
        return (XSLFSlideLayout[]) getLayouts().values().toArray(new XSLFSlideLayout[this._layouts.size()]);
    }

    public CTTextListStyle getTextProperties(Placeholder placeholder) {
        CTSlideMasterTextStyles txStyles = getXmlObject().getTxStyles();
        int i = C141201.$SwitchMap$org$apache$poi$sl$usermodel$Placeholder[placeholder.ordinal()];
        return (i == 1 || i == 2 || i == 3) ? txStyles.getTitleStyle() : i != 4 ? txStyles.getOtherStyle() : txStyles.getBodyStyle();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public XSLFTheme getTheme() {
        if (this._theme == null) {
            Iterator<POIXMLDocumentPart> it = getRelations().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                POIXMLDocumentPart next = it.next();
                if (next instanceof XSLFTheme) {
                    this._theme = (XSLFTheme) next;
                    CTColorMapping clrMap = this._slide.getClrMap();
                    if (clrMap != null) {
                        this._theme.initColorMap(clrMap);
                    }
                }
            }
        }
        return this._theme;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet, org.apache.poi.p226sl.usermodel.Sheet
    public XSLFBackground getBackground() {
        CTBackground bg = this._slide.getCSld().getBg();
        if (bg != null) {
            return new XSLFBackground(bg, this);
        }
        return null;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public CTSlideMaster getXmlObject() {
        return this._slide;
    }

    public XSLFSlideMaster(PackagePart packagePart) {
        super(packagePart);
        CTSlideMaster sldMaster = SldMasterDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getSldMaster();
        this._slide = sldMaster;
        setCommonSlideData(sldMaster.getCSld());
    }

    public XSLFSlideLayout getLayout(String str) {
        return getLayouts().get(str.toLowerCase(Locale.ROOT));
    }
}
