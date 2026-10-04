package com.samsung.android.support.senl.p148nt.word.word.utils;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.constraintlayout.motion.widget.Key;
import com.microsoft.schemas.vml.CTGroup;
import com.microsoft.schemas.vml.CTShape;
import com.microsoft.schemas.vml.CTTextbox;
import com.microsoft.schemas.vml.STTrueFalse;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import com.samsung.android.support.senl.p148nt.word.common.ConvertUtils;
import com.samsung.android.support.senl.p148nt.word.word.data.WordParams;
import java.io.StringReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.util.DocumentHelper;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;
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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JR\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000fJ*\u0010\u0017\u001a\u00020\u00182\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJF\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0014JZ\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0011\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0007J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*H\u0007J\u000e\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020-R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006."}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/word/utils/WordUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "CT_SHAPE_PATH", "CT_TEXT_BOX_STYLE", "getAnchorWithGraphic", "Lorg/openxmlformats/schemas/drawingml/x2006/wordprocessingDrawing/CTAnchor;", "graphicalobject", "Lorg/openxmlformats/schemas/drawingml/x2006/main/CTGraphicalObject;", "drawingDescr", "width", "", "height", "left", "top", "behindText", "", "wrap", "behindDoc", "getInlineWithGraphic", "Lorg/openxmlformats/schemas/drawingml/x2006/wordprocessingDrawing/CTInline;", "createCTTxbxContent", "Lorg/openxmlformats/schemas/wordprocessingml/x2006/main/CTTxbxContent;", "ctGroup", "Lcom/microsoft/schemas/vml/CTGroup;", "", Key.ROTATION, "", "isCenter", "isFit", "addImageToRun", "Lorg/openxmlformats/schemas/wordprocessingml/x2006/main/CTDrawing;", "run", "Lorg/apache/poi/xwpf/usermodel/XWPFRun;", "isObjectSpan", "imgId", "configPageMargin", "wordParams", "Lcom/samsung/android/support/senl/nt/word/word/data/WordParams;", "isLongPage", "spenWNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WordUtils {

    @NotNull
    private static final String CT_SHAPE_PATH = "m 1,1 l 1,1000, 1000,1000, 1000,1 x e";

    @NotNull
    private static final String CT_TEXT_BOX_STYLE = "mso-fit-shape-to-text:true";

    @NotNull
    public static final WordUtils INSTANCE = new WordUtils();
    private static final String TAG = Logger.createTag("WordUtils");

    private WordUtils() {
    }

    @JvmStatic
    @Nullable
    public static final CTDrawing addImageToRun(@NotNull XWPFRun run, double left, double top, double width, double height, boolean behindText, boolean wrap, boolean isObjectSpan, int imgId, int behindDoc) {
        CTGraphicalObjectData graphicData;
        PackagePart packagePart;
        Intrinsics.checkNotNullParameter(run, "run");
        Logger.m10999d(TAG, "Image size : " + left + "," + top + "," + width + "," + height);
        String strM1317j = AbstractC1974b.m1317j(new Date().getTime(), "image", ".png");
        String strM11h = AbstractC0000a.m11h(imgId, "rId");
        XWPFDocument document = run.getDocument();
        if (document != null && (packagePart = document.getPackagePart()) != null) {
            packagePart.addRelationship(new URI(AbstractC0541b.m767i(imgId, "/word/media/image", ".png")), TargetMode.INTERNAL, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", strM11h);
        }
        try {
            try {
                CTDrawing cTDrawingAddNewDrawing = run.getCTR().addNewDrawing();
                CTInline cTInlineAddNewInline = cTDrawingAddNewDrawing.addNewInline();
                String namespaceURI = CTGraphicalObject.type.getName().getNamespaceURI();
                SchemaType schemaType = CTPicture.type;
                cTInlineAddNewInline.set(XmlToken.Factory.parse(DocumentHelper.readDocument(new InputSource(new StringReader("<a:graphic xmlns:a=\"" + namespaceURI + "\"><a:graphicData uri=\"" + schemaType.getName().getNamespaceURI() + "\"><pic:pic xmlns:pic=\"" + schemaType.getName().getNamespaceURI() + "\" /></a:graphicData></a:graphic>"))).getDocumentElement(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS));
                CTGraphicalObject graphic = cTInlineAddNewInline.getGraphic();
                if (graphic != null && (graphicData = graphic.getGraphicData()) != null) {
                    ArrayList arrayList = new ArrayList();
                    XmlObject[] xmlObjectArrSelectPath = graphicData.selectPath("declare namespace pic='" + schemaType.getName().getNamespaceURI() + "' .//pic:pic");
                    Intrinsics.checkNotNull(xmlObjectArrSelectPath);
                    if (!(xmlObjectArrSelectPath.length == 0)) {
                        XmlObject xmlObject = xmlObjectArrSelectPath[0];
                        if (xmlObject instanceof XmlAnyTypeImpl) {
                            try {
                                xmlObject = CTPicture.Factory.parse(((XmlAnyTypeImpl) xmlObject).toString(), new XmlOptions());
                            } catch (XmlException e) {
                                Logger.m11000e(TAG, "addImageToRun(), e: " + e.getMessage());
                            }
                        }
                        if (xmlObject instanceof CTPicture) {
                            arrayList.add(xmlObject);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        CTPicture cTPicture = (CTPicture) arrayList.get(0);
                        CTPictureNonVisual cTPictureNonVisualAddNewNvPicPr = cTPicture.addNewNvPicPr();
                        CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTPictureNonVisualAddNewNvPicPr.addNewCNvPr();
                        cTNonVisualDrawingPropsAddNewCNvPr.setId(imgId);
                        cTNonVisualDrawingPropsAddNewCNvPr.setName("Picture " + imgId);
                        cTNonVisualDrawingPropsAddNewCNvPr.setDescr(strM1317j);
                        cTPictureNonVisualAddNewNvPicPr.addNewCNvPicPr().addNewPicLocks().setNoChangeAspect(true);
                        CTBlipFillProperties cTBlipFillPropertiesAddNewBlipFill = cTPicture.addNewBlipFill();
                        cTBlipFillPropertiesAddNewBlipFill.addNewBlip().setEmbed(strM11h);
                        cTBlipFillPropertiesAddNewBlipFill.addNewStretch().addNewFillRect();
                        CTShapeProperties cTShapePropertiesAddNewSpPr = cTPicture.addNewSpPr();
                        CTTransform2D cTTransform2DAddNewXfrm = cTShapePropertiesAddNewSpPr.addNewXfrm();
                        CTPoint2D cTPoint2DAddNewOff = cTTransform2DAddNewXfrm.addNewOff();
                        cTPoint2DAddNewOff.setX(0L);
                        cTPoint2DAddNewOff.setY(0L);
                        CTPositiveSize2D cTPositiveSize2DAddNewExt = cTTransform2DAddNewXfrm.addNewExt();
                        cTPositiveSize2DAddNewExt.setCx(Units.toEMU(width));
                        cTPositiveSize2DAddNewExt.setCy(Units.toEMU(height));
                        CTPresetGeometry2D cTPresetGeometry2DAddNewPrstGeom = cTShapePropertiesAddNewSpPr.addNewPrstGeom();
                        cTPresetGeometry2DAddNewPrstGeom.setPrst(STShapeType.RECT);
                        cTPresetGeometry2DAddNewPrstGeom.addNewAvLst();
                        if (isObjectSpan) {
                            WordUtils wordUtils = INSTANCE;
                            ConvertUtils convertUtils = ConvertUtils.INSTANCE;
                            cTDrawingAddNewDrawing.setInlineArray(new CTInline[]{wordUtils.getInlineWithGraphic(graphic, strM1317j, Units.toEMU(convertUtils.dpToPt(width)), Units.toEMU(convertUtils.dpToPt(height)))});
                            return cTDrawingAddNewDrawing;
                        }
                        WordUtils wordUtils2 = INSTANCE;
                        ConvertUtils convertUtils2 = ConvertUtils.INSTANCE;
                        cTDrawingAddNewDrawing.setAnchorArray(new CTAnchor[]{wordUtils2.getAnchorWithGraphic(graphic, strM1317j, Units.toEMU(convertUtils2.dpToPt(width)), Units.toEMU(convertUtils2.dpToPt(height)), Units.toEMU(convertUtils2.dpToPt(left)), Units.toEMU(convertUtils2.dpToPt(top)), behindText, wrap, behindDoc)});
                        return cTDrawingAddNewDrawing;
                    }
                }
                return cTDrawingAddNewDrawing;
            } catch (SAXException e2) {
                throw new IllegalStateException(e2);
            }
        } catch (XmlException e3) {
            throw new IllegalStateException(e3);
        }
    }

    @JvmStatic
    @NotNull
    public static final String configPageMargin(@NotNull WordParams wordParams) {
        Intrinsics.checkNotNullParameter(wordParams, "wordParams");
        int i = wordParams.marginTop;
        int i2 = wordParams.marginRight;
        return AbstractC2322a.m1625o(AbstractC0622a.m1173s(i, i2, "<w:pgMar xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\" w:top=\"", "\" w:right=\"", "\" w:bottom=\""), wordParams.marginBottom, wordParams.marginLeft, "\" w:left=\"", "\" w:header=\"720\" w:footer=\"720\" w:gutter=\"0\"/>");
    }

    @NotNull
    public final CTTxbxContent createCTTxbxContent(@NotNull CTGroup ctGroup, double left, double top, double width, double height, float rotation, boolean isCenter, boolean isFit) {
        Intrinsics.checkNotNullParameter(ctGroup, "ctGroup");
        CTShape cTShapeAddNewShape = ctGroup.addNewShape();
        cTShapeAddNewShape.setPath2(CT_SHAPE_PATH);
        cTShapeAddNewShape.setStyle((isCenter ? "v-text-anchor:middle;" : "") + "position:absolute;margin-left:" + left + "pt;margin-top:" + top + "pt;width:" + width + "pt;height:" + height + "pt;z-index:1;visibility:visible;rotation:" + rotation + ";");
        STTrueFalse.Enum r32 = STTrueFalse.FALSE;
        cTShapeAddNewShape.setStroked(r32);
        cTShapeAddNewShape.setFilled(r32);
        CTTextbox cTTextboxAddNewTextbox = cTShapeAddNewShape.addNewTextbox();
        if (isFit) {
            cTTextboxAddNewTextbox.setStyle(CT_TEXT_BOX_STYLE);
        }
        CTTxbxContent cTTxbxContentAddNewTxbxContent = cTTextboxAddNewTextbox.addNewTxbxContent();
        Intrinsics.checkNotNullExpressionValue(cTTxbxContentAddNewTxbxContent, "addNewTxbxContent(...)");
        return cTTxbxContentAddNewTxbxContent;
    }

    @NotNull
    public final CTAnchor getAnchorWithGraphic(@Nullable CTGraphicalObject graphicalobject, @Nullable String drawingDescr, int width, int height, int left, int top, boolean behindText, boolean wrap, int behindDoc) {
        StringBuilder sb = new StringBuilder(1000);
        sb.append("<wp:anchor xmlns:wp=\"http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing\" simplePos=\"0\" relativeHeight=\"0\" behindDoc=\"");
        sb.append(behindDoc);
        sb.append("\" locked=\"0\" layoutInCell=\"1\" allowOverlap=\"1\"><wp:simplePos x=\"0\" y=\"0\"/><wp:positionH relativeFrom=\"column\"><wp:posOffset>");
        sb.append(left);
        AbstractC0622a.m1180z(sb, top, width, "</wp:posOffset></wp:positionH><wp:positionV relativeFrom=\"paragraph\"><wp:posOffset>", "</wp:posOffset></wp:positionV><wp:extent cx=\"");
        AbstractC1974b.m1330w(height, "\" cy=\"", "\"/><wp:effectExtent l=\"0\" t=\"0\" r=\"0\" b=\"0\"/>", sb);
        if (behindText) {
            sb.append("<wp:wrapNone/>");
        } else if (wrap) {
            sb.append("<wp:wrapTight wrapText=\"bothSides\"><wp:wrapPolygon edited=\"0\"><wp:start x=\"0\" y=\"0\"/><wp:lineTo x=\"0\" y=\"21600\"/><wp:lineTo x=\"21600\" y=\"21600\"/><wp:lineTo x=\"21600\" y=\"0\"/><wp:lineTo x=\"0\" y=\"0\"/></wp:wrapPolygon></wp:wrapTight>");
        } else {
            sb.append("<wp:wrapTopAndBottom/>");
        }
        sb.append("<wp:docPr id=\"1\" name=\"Drawing 0\" descr=\"");
        sb.append(drawingDescr);
        sb.append("\"/><wp:cNvGraphicFramePr/></wp:anchor>");
        CTAnchor anchorArray = CTDrawing.Factory.parse(sb.toString()).getAnchorArray(0);
        anchorArray.setGraphic(graphicalobject);
        Intrinsics.checkNotNull(anchorArray);
        return anchorArray;
    }

    @NotNull
    public final CTInline getInlineWithGraphic(@Nullable CTGraphicalObject graphicalobject, @Nullable String drawingDescr, int width, int height) {
        StringBuilder sb = new StringBuilder(1000);
        sb.append("<wp:inline xmlns:wp=\"http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing\" distT=\"0\" distB=\"0\" distL=\"0\" distR=\"0\"><wp:extent cx=\"");
        sb.append(width);
        sb.append("\" cy=\"");
        sb.append(height);
        sb.append("\"/><wp:effectExtent l=\"0\" t=\"0\" r=\"0\" b=\"0\"/><wp:docPr id=\"1\" name=\"Drawing 0\" descr=\"");
        sb.append(drawingDescr);
        sb.append("\"/><wp:cNvGraphicFramePr/></wp:inline>");
        CTInline inlineArray = CTDrawing.Factory.parse(sb.toString()).getInlineArray(0);
        inlineArray.setGraphic(graphicalobject);
        Intrinsics.checkNotNull(inlineArray);
        return inlineArray;
    }

    public final boolean isLongPage(@NotNull SpenWNote spenWNote) {
        Intrinsics.checkNotNullParameter(spenWNote, "spenWNote");
        if (spenWNote.getPageCount() < 0 && spenWNote.getPageMode() == SpenWNote.PageMode.SINGLE) {
            return false;
        }
        int width = spenWNote.getPage(0).getWidth();
        int height = spenWNote.getPage(0).getHeight();
        return DocumentPageRatio.PageRatioType.LONG.equal(spenWNote.getOrientation() == SpenWNote.Orientation.LANDSCAPE ? width / height : height / width);
    }
}
