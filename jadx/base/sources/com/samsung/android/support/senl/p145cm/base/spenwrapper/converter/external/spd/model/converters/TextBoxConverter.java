package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters;

import android.graphics.RectF;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectContainer;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenFontSizeSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenLineSpacingParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u001a\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/TextBoxConverter;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/AbsObjectConverter;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "<init>", "()V", "convertObject", "", "src", ActionHandler.PARAMS, "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/IConvertParams;", "convertObjectLayoutType", "", CoeditServiceConstants.Element.NAME_OBJECT, "convertObjectContainer", "objectContainer", "Lcom/samsung/android/sdk/pen/document/SpenObjectContainer;", "convertObjectShape", "objectShape", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TextBoxConverter extends AbsObjectConverter<SpenObjectBase> {

    @NotNull
    private static final String TAG = "SPDToSDocXConverter$TextBoxConverter";
    private static final int VOICE_MEMO_TYPE = 23;

    private final void convertObjectContainer(SpenObjectContainer objectContainer, IConvertParams params) {
        INoteComposer noteComposer = params != null ? params.getNoteComposer() : null;
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
                convertObjectShape((SpenObjectShape) spenObjectBase, params);
                if (objectContainer.getExtraDataInt(PackageRelationship.TYPE_ATTRIBUTE_NAME) != 23) {
                    arrayList.add(spenObjectBase);
                }
            } else if (type == 4) {
                convertObjectContainer((SpenObjectContainer) spenObjectBase, params);
            } else if (type == 7) {
                convertObjectShape((SpenObjectShape) spenObjectBase, params);
            }
        }
        if (!arrayList.isEmpty()) {
            objectContainer.removeObject(arrayList);
            if (noteComposer != null) {
                noteComposer.appendObjects(arrayList);
            }
        }
        if (!objectContainer.getObjectList().isEmpty() || noteComposer == null) {
            return;
        }
        noteComposer.removeObject(objectContainer);
    }

    private final void convertObjectLayoutType(SpenObjectBase object) {
        if (object.getLayoutType() == 1) {
            object.setLayoutType(2);
        }
    }

    private final void convertObjectShape(SpenObjectShape objectShape, IConvertParams params) {
        RectF rectF;
        INoteComposer noteComposer;
        INoteComposer noteComposer2;
        float pageWidth = (params == null || (noteComposer2 = params.getNoteComposer()) == null) ? 1.0f : noteComposer2.getPageWidth() / 360.0f;
        RectF rect = objectShape.getRect();
        float fHeight = (rect.height() / 1.3f) * 1.35f;
        float height = (params == null || (noteComposer = params.getNoteComposer()) == null) ? 0.0f : noteComposer.getHeight();
        if (rect.bottom > height || rect.top + fHeight < height) {
            float f = rect.left;
            float f4 = rect.top;
            rectF = new RectF(f, f4, rect.right, fHeight + f4);
        } else {
            rectF = new RectF(rect.left, rect.top, rect.right, height);
        }
        objectShape.setRect(rectF, false);
        ArrayList<SpenTextSpanBase> textSpan = objectShape.getTextSpan();
        if (textSpan != null) {
            Iterator<SpenTextSpanBase> it = textSpan.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                SpenTextSpanBase next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                SpenTextSpanBase spenTextSpanBase = next;
                if (spenTextSpanBase.getType() == 3) {
                    SpenFontSizeSpan spenFontSizeSpan = new SpenFontSizeSpan(spenTextSpanBase.getStart(), spenTextSpanBase.getEnd(), spenTextSpanBase.getExpansion(), ((SpenFontSizeSpan) spenTextSpanBase).getSize() / pageWidth);
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
                    objectShape.setRect(rect, false);
                    SpenLineSpacingParagraph spenLineSpacingParagraph = (SpenLineSpacingParagraph) spenTextParagraphBase;
                    if (spenLineSpacingParagraph.getLineSpacingType() != 1) {
                        SpenLineSpacingParagraph spenLineSpacingParagraph2 = new SpenLineSpacingParagraph(spenLineSpacingParagraph.getStart(), spenLineSpacingParagraph.getEnd(), 0, spenLineSpacingParagraph.getLineSpacing() / pageWidth);
                        objectShape.removeTextParagraph(spenTextParagraphBase);
                        objectShape.appendTextParagraph(spenLineSpacingParagraph2);
                    }
                }
            }
        }
        float leftMargin = objectShape.getLeftMargin() / pageWidth;
        float topMargin = objectShape.getTopMargin() / pageWidth;
        objectShape.setMargin(leftMargin, topMargin >= 0.0f ? topMargin : 0.0f, objectShape.getRightMargin() / pageWidth, objectShape.getBottomMargin() / pageWidth);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.AbsObjectConverter
    public boolean convertObject(@NotNull SpenObjectBase src, @Nullable IConvertParams params) {
        Intrinsics.checkNotNullParameter(src, "src");
        LoggerBase.INSTANCE.m7137i(TAG, "convert object");
        convertObjectLayoutType(src);
        int type = src.getType();
        if (type != 2) {
            if (type == 4) {
                convertObjectContainer((SpenObjectContainer) src, params);
                return true;
            }
            if (type != 7) {
                return true;
            }
        }
        convertObjectShape((SpenObjectShape) src, params);
        return true;
    }
}
