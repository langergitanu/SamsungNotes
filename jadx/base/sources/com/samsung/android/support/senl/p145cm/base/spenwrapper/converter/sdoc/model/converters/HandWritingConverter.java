package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters;

import android.graphics.Bitmap;
import android.graphics.RectF;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentHandWriting;
import com.samsung.android.sdk.pen.document.SpenNoteDoc;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectContainer;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.document.shapeeffect.SpenFillColorEffect;
import com.samsung.android.sdk.pen.document.shapeeffect.SpenLineColorEffect;
import com.samsung.android.sdk.pen.document.textspan.SpenFontSizeSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenLineSpacingParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.engine.SpenCapturePage;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p145cm.base.common.util.BaseImageUtils;
import com.samsung.android.support.senl.p145cm.base.framework.constructor.AndroidInstanceConstructor;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.SpenObjectConstructor;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 *2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0002J$\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J2\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001a2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001a\u0010\u001d\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J\u001a\u0010\u001f\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010 \u001a\u00020\u0012H\u0002J\u0018\u0010!\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u0012H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/HandWritingConverter;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/AbsContentConverter;", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentHandWriting;", "<init>", "()V", "mPageDoc", "Lcom/samsung/android/sdk/pen/document/SpenPageDoc;", "mNewDocumentPixel", "", "convertContent", "", "src", ActionHandler.PARAMS, "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/IConvertParams;", "release", "", "convertObjects", "convertBackgroundImage", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "pageDoc", "rect", "Landroid/graphics/RectF;", "init", "composer", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/INoteComposer;", "convertBackgroundColor", "", "refHeight", "", "updateMagicPenColor", "handWritingBGColor", "appendObjectToBottom", "objectBase", "convertRect", "convertObjectShape", "objectShape", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "convertObjectContainer", "objectContainer", "Lcom/samsung/android/sdk/pen/document/SpenObjectContainer;", "convertObjectLayoutType", CoeditServiceConstants.Element.NAME_OBJECT, "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class HandWritingConverter extends AbsContentConverter<SpenContentHandWriting> {

    @NotNull
    private static final String TAG = "SDocXConverter$HandWritingConverter";
    private static final int VOICE_MEMO_TYPE = 23;
    private float mNewDocumentPixel;

    @Nullable
    private SpenPageDoc mPageDoc;

    private final void appendObjectToBottom(SpenPageDoc pageDoc, SpenObjectBase objectBase) {
        if (pageDoc != null) {
            pageDoc.appendObject(objectBase);
        }
        if (pageDoc != null) {
            pageDoc.moveObjectIndex(objectBase, pageDoc.getObjectIndex(objectBase) * (-1), false);
        }
    }

    private final List<SpenObjectBase> convertBackgroundColor(SpenContentHandWriting src, SpenPageDoc pageDoc, RectF rect, int refHeight) {
        int i;
        int backgroundColor = src.getBackgroundColor();
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        companion.m7137i(TAG, "FirstHandWritingColor : " + backgroundColor);
        if (backgroundColor == 0) {
            backgroundColor = src.getNoteDoc().getPage(0).getBackgroundColor();
        }
        companion.m7137i(TAG, "handWritingBGColor " + Integer.toHexString(backgroundColor));
        updateMagicPenColor(pageDoc, backgroundColor);
        ArrayList arrayList = new ArrayList();
        if (backgroundColor == 0) {
            return null;
        }
        int i2 = refHeight * 2;
        int i4 = refHeight >> 1;
        float f = rect.top;
        int iCeil = (int) Math.ceil(rect.height() / i2);
        float fHeight = rect.height();
        float f4 = rect.top;
        float f5 = rect.bottom;
        String str = " / ";
        StringBuilder sbM1176v = AbstractC0622a.m1176v("handWritingBGColor : Height = ", fHeight, " / ", f4, " / ");
        sbM1176v.append(f5);
        sbM1176v.append(" / ");
        sbM1176v.append(i2);
        sbM1176v.append(" / ");
        sbM1176v.append(iCeil);
        companion.m7137i(TAG, sbM1176v.toString());
        SpenFillColorEffect spenFillColorEffect = new SpenFillColorEffect();
        spenFillColorEffect.setSolidColor(backgroundColor);
        SpenLineColorEffect spenLineColorEffect = new SpenLineColorEffect();
        spenLineColorEffect.setSolidColor(0);
        int i5 = iCeil;
        String str2 = CoverStickerConstants.Category.NONE.NAME;
        int i6 = 0;
        while (i6 < i5) {
            float f6 = (i6 * i2) + f;
            int i7 = i6 + 1;
            int i8 = i2;
            float f7 = (i7 * i8) + f;
            float f8 = f;
            float f9 = rect.bottom;
            if (f7 > f9) {
                i = i5;
                str2 = "handWritingBGColor : shorten - " + f7 + str + f9;
                f7 = rect.bottom;
            } else {
                i = i5;
                if (i4 + f7 > f9) {
                    i5 = i - 1;
                    str2 = "handWritingBGColor : merge left - " + f7 + str + f9;
                    f7 = rect.bottom;
                }
                SpenObjectShape spenObjectShapeMakeObjectShape = SpenObjectConstructor.makeObjectShape(4);
                spenObjectShapeMakeObjectShape.setRect(new RectF(rect.left, f6, rect.right, f7), false);
                spenObjectShapeMakeObjectShape.setFillEffect(spenFillColorEffect);
                spenObjectShapeMakeObjectShape.setLineColorEffect(spenLineColorEffect);
                spenObjectShapeMakeObjectShape.setExtraDataInt("extra_key_converted_type", 1);
                appendObjectToBottom(pageDoc, spenObjectShapeMakeObjectShape);
                arrayList.add(i6, spenObjectShapeMakeObjectShape);
                f = f8;
                i6 = i7;
                i2 = i8;
                str = str;
                i4 = i4;
                str2 = str2;
            }
            i5 = i;
            SpenObjectShape spenObjectShapeMakeObjectShape2 = SpenObjectConstructor.makeObjectShape(4);
            spenObjectShapeMakeObjectShape2.setRect(new RectF(rect.left, f6, rect.right, f7), false);
            spenObjectShapeMakeObjectShape2.setFillEffect(spenFillColorEffect);
            spenObjectShapeMakeObjectShape2.setLineColorEffect(spenLineColorEffect);
            spenObjectShapeMakeObjectShape2.setExtraDataInt("extra_key_converted_type", 1);
            appendObjectToBottom(pageDoc, spenObjectShapeMakeObjectShape2);
            arrayList.add(i6, spenObjectShapeMakeObjectShape2);
            f = f8;
            i6 = i7;
            i2 = i8;
            str = str;
            i4 = i4;
            str2 = str2;
        }
        LoggerBase.INSTANCE.m7137i(TAG, str2);
        return arrayList;
    }

    private final SpenObjectBase convertBackgroundImage(SpenPageDoc pageDoc, RectF rect, IConvertParams params) {
        SpenCapturePage spenCapturePageCreateCapturePage;
        ArrayList<SpenObjectBase> objectList = pageDoc != null ? pageDoc.getObjectList() : null;
        if (pageDoc != null) {
            pageDoc.removeAllObject();
        }
        ISpenDocCreator docCreator = params.getDocCreator();
        if (docCreator != null && (spenCapturePageCreateCapturePage = docCreator.createCapturePage(pageDoc)) != null) {
            Bitmap bitmapCapturePage = spenCapturePageCreateCapturePage.capturePage(1.0f);
            if (objectList != null && !objectList.isEmpty()) {
                pageDoc.appendObjectList(objectList);
            }
            spenObjectBaseCreateObject = pageDoc != null ? pageDoc.createObject(3) : null;
            Intrinsics.checkNotNull(spenObjectBaseCreateObject, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectImage");
            SpenObjectImage spenObjectImage = (SpenObjectImage) spenObjectBaseCreateObject;
            spenObjectImage.setImage(bitmapCapturePage);
            spenObjectImage.setRect(rect, false);
            spenObjectImage.setVisibility(true);
            appendObjectToBottom(pageDoc, spenObjectBaseCreateObject);
            spenCapturePageCreateCapturePage.close();
        }
        return spenObjectBaseCreateObject;
    }

    private final void convertObjectContainer(SpenObjectContainer objectContainer) {
        SpenPageDoc spenPageDoc;
        ArrayList<SpenObjectBase> objectList = objectContainer.getObjectList();
        ArrayList<SpenObjectBase> arrayList = new ArrayList<>();
        Iterator<SpenObjectBase> it = objectList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenObjectBase next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SpenObjectBase spenObjectBase = next;
            int type = spenObjectBase.getType();
            if (type == 2) {
                convertObjectShape((SpenObjectShape) spenObjectBase);
                if (objectContainer.getExtraDataInt(PackageRelationship.TYPE_ATTRIBUTE_NAME) != 23) {
                    arrayList.add(spenObjectBase);
                }
            } else if (type == 4) {
                convertObjectContainer((SpenObjectContainer) spenObjectBase);
            } else if (type == 7) {
                convertObjectShape((SpenObjectShape) spenObjectBase);
            }
        }
        if (!arrayList.isEmpty()) {
            objectContainer.removeObject(arrayList);
            SpenPageDoc spenPageDoc2 = this.mPageDoc;
            if (spenPageDoc2 != null) {
                spenPageDoc2.appendObjectList(arrayList);
            }
        }
        if (!objectContainer.getObjectList().isEmpty() || (spenPageDoc = this.mPageDoc) == null) {
            return;
        }
        spenPageDoc.removeObject(objectContainer);
    }

    private final void convertObjectLayoutType(SpenObjectBase object) {
        if (object.getLayoutType() == 1) {
            object.setLayoutType(2);
        }
    }

    private final void convertObjectShape(SpenObjectShape objectShape) {
        RectF rect = objectShape.getRect();
        float fHeight = (rect.height() / 1.3f) * 1.35f;
        float f = rect.left;
        float f4 = rect.top;
        objectShape.setRect(new RectF(f, f4, rect.right, fHeight + f4), false);
        ArrayList<SpenTextSpanBase> textSpan = objectShape.getTextSpan();
        if (textSpan != null) {
            Iterator<SpenTextSpanBase> it = textSpan.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                SpenTextSpanBase next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                SpenTextSpanBase spenTextSpanBase = next;
                if (spenTextSpanBase.getType() == 3) {
                    SpenFontSizeSpan spenFontSizeSpan = new SpenFontSizeSpan(spenTextSpanBase.getStart(), spenTextSpanBase.getEnd(), spenTextSpanBase.getExpansion(), ((SpenFontSizeSpan) spenTextSpanBase).getSize() / this.mNewDocumentPixel);
                    objectShape.removeTextSpan(spenTextSpanBase);
                    objectShape.appendTextSpan(spenFontSizeSpan);
                }
            }
        }
        ArrayList<SpenTextParagraphBase> textParagraph = objectShape.getTextParagraph();
        if (textParagraph != null) {
            Iterator<SpenTextParagraphBase> it2 = textParagraph.iterator();
            Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
            while (it2.hasNext()) {
                SpenTextParagraphBase next2 = it2.next();
                Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                SpenTextParagraphBase spenTextParagraphBase = next2;
                if (spenTextParagraphBase.getType() == 4) {
                    SpenLineSpacingParagraph spenLineSpacingParagraph = (SpenLineSpacingParagraph) spenTextParagraphBase;
                    if (spenLineSpacingParagraph.getLineSpacingType() != 1) {
                        SpenLineSpacingParagraph spenLineSpacingParagraph2 = new SpenLineSpacingParagraph(spenLineSpacingParagraph.getStart(), spenLineSpacingParagraph.getEnd(), 0, spenLineSpacingParagraph.getLineSpacing() / this.mNewDocumentPixel);
                        objectShape.removeTextParagraph(spenTextParagraphBase);
                        objectShape.appendTextParagraph(spenLineSpacingParagraph2);
                    }
                }
            }
        }
        objectShape.setMargin(objectShape.getLeftMargin() / this.mNewDocumentPixel, objectShape.getTopMargin() / this.mNewDocumentPixel, objectShape.getRightMargin() / this.mNewDocumentPixel, objectShape.getBottomMargin() / this.mNewDocumentPixel);
    }

    private final void convertObjects() {
        ArrayList<SpenObjectBase> objectList;
        SpenPageDoc spenPageDoc = this.mPageDoc;
        if (spenPageDoc == null || (objectList = spenPageDoc.getObjectList()) == null) {
            return;
        }
        Iterator<SpenObjectBase> it = objectList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenObjectBase next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SpenObjectBase spenObjectBase = next;
            convertObjectLayoutType(spenObjectBase);
            int type = spenObjectBase.getType();
            if (type != 2) {
                if (type == 4) {
                    convertObjectContainer((SpenObjectContainer) spenObjectBase);
                } else if (type != 7) {
                }
            }
            convertObjectShape((SpenObjectShape) spenObjectBase);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final RectF convertRect(SpenContentHandWriting src, INoteComposer composer) {
        float imageRatio;
        float objectMaxHeight;
        int objectMaxWidth;
        SpenPageDoc page = src.getNoteDoc().getPage(0);
        if (!page.hasBackgroundImage() || page.getBackgroundImage() == null) {
            if (src.getObjectRect().isEmpty() || src.getObjectRect().left != 0.0f) {
                String thumbnailPath = src.getThumbnailPath();
                if (thumbnailPath == null) {
                    imageRatio = 1.0f;
                } else if (StringsKt.m14167w(thumbnailPath, ".spi")) {
                    LoggerBase.INSTANCE.m7138w(TAG, "convertRect : .spi case !!");
                    objectMaxHeight = composer.getObjectMaxHeight();
                    objectMaxWidth = composer.getObjectMaxWidth();
                } else {
                    imageRatio = BaseImageUtils.getImageRatio(thumbnailPath);
                }
            } else {
                RectF objectRect = src.getObjectRect();
                objectRect.top = 0.0f;
                imageRatio = objectRect.height() / objectRect.width();
            }
            return AndroidInstanceConstructor.makeRectF(0.0f, 0.0f, this.mPageDoc == null ? r5.getWidth() : 0.0f, this.mPageDoc == null ? r0.getWidth() * imageRatio : 0.0f);
        }
        objectMaxHeight = page.getHeight();
        objectMaxWidth = page.getWidth();
        imageRatio = objectMaxHeight / objectMaxWidth;
        if (this.mPageDoc == null) {
        }
        return AndroidInstanceConstructor.makeRectF(0.0f, 0.0f, this.mPageDoc == null ? r5.getWidth() : 0.0f, this.mPageDoc == null ? r0.getWidth() * imageRatio : 0.0f);
    }

    private final boolean init(SpenContentHandWriting src, INoteComposer composer) {
        try {
            src.createNoteDoc(MathKt.roundToInt(composer.getOldObjectMaxWidth()), src.getItemHeight());
            return true;
        } catch (IOException e) {
            AbstractC0000a.m23t("can't add ContentHandWriting : failed note doc creation : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
            return false;
        }
    }

    private final void updateMagicPenColor(SpenPageDoc pageDoc, int handWritingBGColor) {
        ArrayList<SpenObjectBase> objectList;
        if (pageDoc == null || (objectList = pageDoc.getObjectList()) == null) {
            return;
        }
        Iterator<SpenObjectBase> it = objectList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenObjectBase next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SpenObjectBase spenObjectBase = next;
            if (spenObjectBase.getType() == 1) {
                SpenObjectStroke spenObjectStroke = (SpenObjectStroke) spenObjectBase;
                if (Intrinsics.areEqual(SpenPenManager.SPEN_MAGIC_PEN, spenObjectStroke.getPenName())) {
                    spenObjectStroke.setColor((spenObjectStroke.getColor() & (-16777216)) | (16777215 & handWritingBGColor));
                }
            }
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.AbsContentConverter
    public void release() {
        this.mPageDoc = null;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.AbsContentConverter
    public boolean convertContent(@Nullable SpenContentHandWriting src, @NotNull IConvertParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        companion.m7137i(TAG, "convert content");
        String attachedFile = src != null ? src.getAttachedFile() : null;
        if (attachedFile == null || attachedFile.length() == 0) {
            companion.m7138w(TAG, "can't add ContentHandWriting : not file");
            return false;
        }
        INoteComposer composer = params.getComposer();
        if (!init(src, composer)) {
            return false;
        }
        this.mPageDoc = src.getNoteDoc().getPage(0);
        this.mNewDocumentPixel = params.getComposer().getWidth() / 360.0f;
        convertObjects();
        RectF rectFConvertRect = convertRect(src, composer);
        SpenPageDoc spenPageDoc = this.mPageDoc;
        SpenObjectBase spenObjectBaseConvertBackgroundImage = (spenPageDoc != null ? spenPageDoc.getBackgroundImage() : null) != null ? convertBackgroundImage(this.mPageDoc, rectFConvertRect, params) : null;
        List<SpenObjectBase> listConvertBackgroundColor = convertBackgroundColor(src, this.mPageDoc, rectFConvertRect, composer.getHeight());
        composer.appendObjects(this.mPageDoc, rectFConvertRect, spenObjectBaseConvertBackgroundImage, listConvertBackgroundColor);
        if (listConvertBackgroundColor != null) {
            listConvertBackgroundColor.clear();
            params.getComposer().getNote().invertBackgroundColor(false);
        }
        try {
            SpenNoteDoc.close$default(src.getNoteDoc(), true, false, 2, null);
        } catch (IOException e) {
            AbstractC0000a.m23t("convertContent, e : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
        }
        return true;
    }
}
