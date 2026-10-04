package com.samsung.android.support.senl.p148nt.word.powerpoint.utils;

import android.util.Log;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.util.Units;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.jetbrains.annotations.NotNull;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPictureNonVisual;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/powerpoint/utils/PPTUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "createPicture", "Lorg/openxmlformats/schemas/presentationml/x2006/main/CTPicture;", "slide", "Lorg/apache/poi/xslf/usermodel/XSLFSlide;", "x", "", "y", "width", "height", "imageId", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PPTUtils {

    @NotNull
    public static final PPTUtils INSTANCE = new PPTUtils();

    @NotNull
    public static final String TAG = "PPTUtils";

    private PPTUtils() {
    }

    @NotNull
    public final CTPicture createPicture(@NotNull XSLFSlide slide, int x, int y2, int width, int height, int imageId) throws IOException {
        Intrinsics.checkNotNullParameter(slide, "slide");
        CTCommonSlideData cSld = slide.getXmlObject().getCSld();
        if (cSld == null) {
            throw new IOException("failed to get CommonSlideData.");
        }
        CTGroupShape spTree = cSld.getSpTree();
        if (spTree == null) {
            throw new IOException("failed to get CTGroupShape.");
        }
        CTPicture cTPictureAddNewPic = spTree.addNewPic();
        CTPictureNonVisual cTPictureNonVisualAddNewNvPicPr = cTPictureAddNewPic.addNewNvPicPr();
        CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTPictureNonVisualAddNewNvPicPr.addNewCNvPr();
        cTNonVisualDrawingPropsAddNewCNvPr.setName("Picture " + imageId);
        cTNonVisualDrawingPropsAddNewCNvPr.setId((long) imageId);
        cTPictureNonVisualAddNewNvPicPr.addNewCNvPicPr().addNewPicLocks().setNoChangeAspect(true);
        cTPictureNonVisualAddNewNvPicPr.addNewNvPr();
        CTBlipFillProperties cTBlipFillPropertiesAddNewBlipFill = cTPictureAddNewPic.addNewBlipFill();
        String strM11h = AbstractC0000a.m11h(imageId, "rId");
        cTBlipFillPropertiesAddNewBlipFill.addNewBlip().setEmbed(strM11h);
        cTBlipFillPropertiesAddNewBlipFill.addNewStretch().addNewFillRect();
        CTShapeProperties cTShapePropertiesAddNewSpPr = cTPictureAddNewPic.addNewSpPr();
        CTTransform2D cTTransform2DAddNewXfrm = cTShapePropertiesAddNewSpPr.addNewXfrm();
        CTPoint2D cTPoint2DAddNewOff = cTTransform2DAddNewXfrm.addNewOff();
        cTPoint2DAddNewOff.setX(Units.toEMU(x));
        cTPoint2DAddNewOff.setY(Units.toEMU(y2));
        CTPositiveSize2D cTPositiveSize2DAddNewExt = cTTransform2DAddNewXfrm.addNewExt();
        cTPositiveSize2DAddNewExt.setCx(Units.toEMU(width));
        cTPositiveSize2DAddNewExt.setCy(Units.toEMU(height));
        CTPresetGeometry2D cTPresetGeometry2DAddNewPrstGeom = cTShapePropertiesAddNewSpPr.addNewPrstGeom();
        cTPresetGeometry2DAddNewPrstGeom.setPrst(STShapeType.RECT);
        cTPresetGeometry2DAddNewPrstGeom.addNewAvLst();
        try {
            slide.getPackagePart().addRelationship(new URI("/ppt/media/image" + imageId + ".png"), TargetMode.INTERNAL, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", strM11h);
        } catch (URISyntaxException unused) {
            Log.e(TAG, "Failed to create URI");
        }
        Intrinsics.checkNotNull(cTPictureAddNewPic);
        return cTPictureAddNewPic;
    }
}
