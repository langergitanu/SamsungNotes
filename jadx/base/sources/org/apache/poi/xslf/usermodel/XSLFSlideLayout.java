package org.apache.poi.xslf.usermodel;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.p226sl.usermodel.MasterSheet;
import org.apache.poi.p226sl.usermodel.Placeholder;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackground;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout;
import org.openxmlformats.schemas.presentationml.x2006.main.SldLayoutDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSLFSlideLayout extends XSLFSheet implements MasterSheet<XSLFShape, XSLFTextParagraph> {
    private CTSlideLayout _layout;
    private XSLFSlideMaster _master;

    /* JADX INFO: renamed from: org.apache.poi.xslf.usermodel.XSLFSlideLayout$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C141191 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$Placeholder;

        static {
            int[] iArr = new int[Placeholder.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$Placeholder = iArr;
            try {
                iArr[Placeholder.DATETIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$Placeholder[Placeholder.SLIDE_NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$Placeholder[Placeholder.FOOTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public XSLFSlideLayout() {
        this._layout = CTSlideLayout.Factory.newInstance();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public boolean canDraw(XSLFShape xSLFShape) {
        return !(xSLFShape instanceof XSLFSimpleShape) || ((XSLFSimpleShape) xSLFShape).getCTPlaceholder() == null;
    }

    public void copyLayout(XSLFSlide xSLFSlide) {
        XSLFTextShape xSLFTextShape;
        Placeholder textType;
        int i;
        for (XSLFShape xSLFShape : getShapes()) {
            if ((xSLFShape instanceof XSLFTextShape) && (textType = (xSLFTextShape = (XSLFTextShape) xSLFShape).getTextType()) != null && (i = C141191.$SwitchMap$org$apache$poi$sl$usermodel$Placeholder[textType.ordinal()]) != 1 && i != 2 && i != 3) {
                xSLFSlide.getSpTree().addNewSp().set(xSLFTextShape.getXmlObject().copy());
            }
        }
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet, org.apache.poi.p226sl.usermodel.Sheet
    public boolean getFollowMasterGraphics() {
        return this._layout.getShowMasterSp();
    }

    public String getName() {
        return this._layout.getCSld().getName();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public String getRootElementName() {
        return "sldLayout";
    }

    public XSLFSlideMaster getSlideMaster() {
        if (this._master == null) {
            for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
                if (pOIXMLDocumentPart instanceof XSLFSlideMaster) {
                    this._master = (XSLFSlideMaster) pOIXMLDocumentPart;
                }
            }
        }
        XSLFSlideMaster xSLFSlideMaster = this._master;
        if (xSLFSlideMaster != null) {
            return xSLFSlideMaster;
        }
        throw new IllegalStateException("SlideMaster was not found for " + this);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public XSLFTheme getTheme() {
        return getSlideMaster().getTheme();
    }

    public SlideLayout getType() {
        return SlideLayout.values()[this._layout.getType().intValue() - 1];
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet, org.apache.poi.p226sl.usermodel.Sheet
    public XSLFBackground getBackground() {
        CTBackground bg = this._layout.getCSld().getBg();
        return bg != null ? new XSLFBackground(bg, this) : getMasterSheet().getBackground();
    }

    @Override // org.apache.poi.p226sl.usermodel.Sheet
    public XSLFSlideMaster getMasterSheet() {
        return getSlideMaster();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    @Internal
    public CTSlideLayout getXmlObject() {
        return this._layout;
    }

    public XSLFSlideLayout(PackagePart packagePart) {
        super(packagePart);
        CTSlideLayout sldLayout = SldLayoutDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getSldLayout();
        this._layout = sldLayout;
        setCommonSlideData(sldLayout.getCSld());
    }
}
