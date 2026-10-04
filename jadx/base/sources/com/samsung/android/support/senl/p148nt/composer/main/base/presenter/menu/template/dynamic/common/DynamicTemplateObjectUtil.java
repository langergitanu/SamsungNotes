package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.RectF;
import android.text.TextUtils;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import com.samsung.android.sdk.pen.base.SpenObjectFindType;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectLine;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.shapeeffect.SpenFillColorEffect;
import com.samsung.android.sdk.pen.document.shapeeffect.SpenLineColorEffect;
import com.samsung.android.sdk.pen.document.shapeeffect.SpenLineStyleEffect;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectFindUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.DateTextBox;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.DayOfWeekTextBox;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Element;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.GeneratedImage;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Image;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.TextBox;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.model.assist.common.C2paHandler;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.ImageUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.commons.lang3.exception.C13834b;
import org.apache.commons.lang3.function.C13849N;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J0\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J0\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J2\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007J2\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u0005H\u0003J0\u0010)\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0003J\u0010\u0010+\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000fH\u0003J\"\u0010,\u001a\u00020-2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007J\"\u0010.\u001a\u00020-2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007J\"\u0010/\u001a\u00020-2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u00101\u001a\u00020&2\u0006\u00102\u001a\u000203H\u0003J(\u00104\u001a\u00020&2\u0006\u00100\u001a\u0002032\u0006\u00105\u001a\u0002032\u0006\u00106\u001a\u00020\u00182\u0006\u00107\u001a\u00020\u0007H\u0007J \u00108\u001a\u00020&2\u0006\u00100\u001a\u0002032\u0006\u00105\u001a\u0002032\u0006\u00107\u001a\u00020\u0007H\u0003J \u00109\u001a\u00020&2\u0006\u00100\u001a\u0002032\u0006\u00105\u001a\u0002032\u0006\u00106\u001a\u00020\u0018H\u0003J \u00109\u001a\u00020&2\u0006\u00100\u001a\u0002032\u0006\u00105\u001a\u0002032\u0006\u0010:\u001a\u00020\u0005H\u0003J(\u0010;\u001a\u00020&2\u0006\u00100\u001a\u0002032\u0006\u00105\u001a\u0002032\u0006\u0010:\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0018H\u0003J\u0010\u0010<\u001a\u00020&2\u0006\u0010=\u001a\u00020>H\u0007J \u0010?\u001a\u00020&2\u0006\u0010=\u001a\u00020>2\u0006\u0010@\u001a\u00020-2\b\u0010A\u001a\u0004\u0018\u00010\u0005J\u0016\u0010B\u001a\u00020&2\u0006\u0010=\u001a\u00020>2\u0006\u0010@\u001a\u00020-J*\u0010C\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\u00130E0D2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010G\u001a\u00020HH\u0007J(\u0010I\u001a\u00020F2\u0006\u0010J\u001a\u00020\u00132\u0006\u0010K\u001a\u00020\t2\u0006\u0010L\u001a\u00020\u00152\u0006\u0010M\u001a\u00020\u0007H\u0003J\u001a\u0010N\u001a\u0004\u0018\u00010\u00132\u0006\u0010O\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\tH\u0003J\u001a\u0010Q\u001a\u0002032\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010K\u001a\u00020\tH\u0007J\u0016\u0010R\u001a\u00020\u00072\f\u0010S\u001a\b\u0012\u0004\u0012\u0002030DH\u0007J\u0010\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u000203H\u0007J\u001a\u0010V\u001a\u0004\u0018\u0001032\u0006\u0010=\u001a\u00020>2\u0006\u0010W\u001a\u00020\u0005H\u0007J\"\u0010V\u001a\u0004\u0018\u0001032\u0006\u0010=\u001a\u00020>2\u0006\u0010X\u001a\u00020\t2\u0006\u0010W\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006Y"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/common/DynamicTemplateObjectUtil;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "ENABLE_TEXT_BOX_HIGHLIGHT", "", "HIGHLIGHT_COLOR", "", "BORDER_LEFT", "BORDER_RIGHT", "BORDER_TOP", "BORDER_BOTTOM", "makeObjectTextBox", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", ExternalDataConstants.Column.TEXT_BOX, "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/TextBox;", "bound", "Landroid/graphics/RectF;", "templatePageWidth", "", "docPageWidth", "initTimeInMillis", "", "makeObjectDateTextBox", "dateTextBox", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/DateTextBox;", "makeObjectDayOfWeekTextBox", "dayOfWeekTextBox", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/DayOfWeekTextBox;", "makeObjectTextBoxForInsertImage", "image", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/Image;", "makeObjectTextBoxForGenerateImage", "generatedImage", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/GeneratedImage;", "initTextBoxOptionForImage", "", "objectTextBox", "objectImageId", "makeObjectBaseTextBox", "objectId", "initTextBoxDefaultOption", "makeImage", "Lcom/samsung/android/sdk/pen/document/SpenObjectImage;", "makeGeneratedImage", "makeObjectImageForBackground", "src", "initBaseDefaultOption", "baseObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "copy", "target", "copiedTimeInMillis", "keepCurrentData", "copyAttribute", "copyExtraData", "key", "copyIdData", "removeAllObject", "page", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "updateImage", "objectImage", "path", "releaseImage", "makeObjectBorders", "", "Lkotlin/Pair;", "Lcom/samsung/android/sdk/pen/document/SpenObjectLine;", "element", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/Element;", "makeObjectLine", "lineBound", "color", "width", "withDash", "getLineRectFromObjectRect", "objectRect", "position", "makeObjectShape", "isTaskTextBoxContained", "objectBases", "isTaskTextBox", "objectBase", "findObjectById", "id", "typeFilter", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DynamicTemplateObjectUtil {
    public static final int BORDER_BOTTOM = 4096;
    public static final int BORDER_LEFT = 1;
    public static final int BORDER_RIGHT = 16;
    public static final int BORDER_TOP = 256;
    private static final boolean ENABLE_TEXT_BOX_HIGHLIGHT = false;
    private static final int HIGHLIGHT_COLOR = 587137279;

    @NotNull
    public static final DynamicTemplateObjectUtil INSTANCE = new DynamicTemplateObjectUtil();

    @NotNull
    private static final String TAG = "DynamicTemplateObjectUtil";

    private DynamicTemplateObjectUtil() {
    }

    @JvmStatic
    public static final void copy(@NotNull SpenObjectBase src, @NotNull SpenObjectBase target, long copiedTimeInMillis, boolean keepCurrentData) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(target, "target");
        if (DynamicTemplateUtil.isDynamicTemplateObject(src)) {
            copyAttribute(src, target, keepCurrentData);
            copyExtraData(src, target, copiedTimeInMillis);
        }
    }

    @JvmStatic
    private static final void copyAttribute(SpenObjectBase src, SpenObjectBase target, boolean keepCurrentData) {
        target.setSelectable(src.getSelectable());
        target.setMovable(src.getMovable());
        target.setLayoutType(src.getLayoutType());
        target.setRemovable(src.getRemovable());
        target.setRotatable(src.getRotatable());
        target.setResizeOption(src.getResizeOption());
        target.setRect(src.getRect(), false);
        if ((src instanceof SpenObjectImage) && (target instanceof SpenObjectImage)) {
            if (keepCurrentData) {
                return;
            }
            SpenObjectImage spenObjectImage = (SpenObjectImage) target;
            spenObjectImage.setImage(DynamicTemplateUtil.getImageBoxDefaultImage(spenObjectImage));
            return;
        }
        if (!(src instanceof SpenObjectTextBox) || !(target instanceof SpenObjectTextBox)) {
            if ((src instanceof SpenObjectLine) && (target instanceof SpenObjectLine)) {
                SpenLineColorEffect spenLineColorEffect = new SpenLineColorEffect();
                ((SpenObjectLine) src).getLineColorEffect(spenLineColorEffect);
                ((SpenObjectLine) target).setLineColorEffect(spenLineColorEffect);
                return;
            }
            return;
        }
        if (keepCurrentData || DynamicTemplateUtil.hasAction(src) || !((SpenObjectTextBox) src).getTextEditable()) {
            ((SpenObjectTextBox) target).setText(((SpenObjectTextBox) src).getText());
        } else {
            ((SpenObjectTextBox) target).setText("");
        }
        SpenObjectTextBox spenObjectTextBox = (SpenObjectTextBox) target;
        SpenObjectTextBox spenObjectTextBox2 = (SpenObjectTextBox) src;
        spenObjectTextBox.setTextEditable(spenObjectTextBox2.getTextEditable());
        spenObjectTextBox.setAutoFitOption(spenObjectTextBox2.getAutoFitOption());
        spenObjectTextBox.setEllipsisType(spenObjectTextBox2.getEllipsisType());
        spenObjectTextBox.setFontSize(spenObjectTextBox2.getFontSize());
        spenObjectTextBox.setTextColor(spenObjectTextBox2.getTextColor());
        spenObjectTextBox.setTextStyle(spenObjectTextBox2.getTextStyle());
        spenObjectTextBox.setTextAlignment(spenObjectTextBox2.getTextAlignment());
        spenObjectTextBox.setGravity(spenObjectTextBox2.getGravity());
        spenObjectTextBox.setLinedPaperEnabled(spenObjectTextBox2.getLinedPaperEnabled());
    }

    @JvmStatic
    private static final void copyExtraData(SpenObjectBase src, SpenObjectBase target, long copiedTimeInMillis) {
        Iterator<String> it = Constant.INSTANCE.getKEYS_FOR_DYNAMIC_TEMPLATE_COMMON().iterator();
        while (it.hasNext()) {
            copyExtraData(src, target, it.next());
        }
        Iterator<String> it2 = Constant.INSTANCE.getKEYS_FOR_DYNAMIC_TEMPLATE_OBJECT_ID().iterator();
        while (it2.hasNext()) {
            copyIdData(src, target, it2.next(), copiedTimeInMillis);
        }
        if (src.getType() == 3) {
            Iterator<String> it3 = Constant.INSTANCE.getKEYS_FOR_DYNAMIC_TEMPLATE_IMAGE_OBJECT().iterator();
            while (it3.hasNext()) {
                copyExtraData(src, target, it3.next());
            }
        } else if (src.getType() == 2) {
            Iterator<String> it4 = Constant.INSTANCE.getKEYS_FOR_DYNAMIC_TEMPLATE_TEXT_OBJECT().iterator();
            while (it4.hasNext()) {
                copyExtraData(src, target, it4.next());
            }
        }
    }

    @JvmStatic
    private static final void copyIdData(SpenObjectBase src, SpenObjectBase target, String key, long copiedTimeInMillis) {
        if (src.hasExtraDataString(key)) {
            String extraDataString = src.getExtraDataString(key);
            if (TextUtils.isEmpty(extraDataString)) {
                return;
            }
            target.setExtraDataString(key, StringsKt.m14167w(extraDataString, Constant.POST_FIX_ID_IMAGE_TARGET_IMAGE) ? DynamicTemplateUtil.makeImageBoxImageId(StringsKt.m14154b0(StringsKt__StringsKt.removeSuffix(extraDataString, (CharSequence) "_post_fix_id_image_target_image"), "_"), copiedTimeInMillis) : StringsKt.m14167w(extraDataString, Constant.POST_FIX_ID_IMAGE_GUIDE_TEXT) ? DynamicTemplateUtil.makeImageBoxTextId(StringsKt.m14154b0(StringsKt__StringsKt.removeSuffix(extraDataString, (CharSequence) "_post_fix_id_image_guide_text"), "_"), copiedTimeInMillis) : DynamicTemplateUtil.makeObjectId(StringsKt.m14154b0(extraDataString, "_"), copiedTimeInMillis));
        }
    }

    @JvmStatic
    @Nullable
    public static final SpenObjectBase findObjectById(@NotNull SpenWPage page, @NotNull String id) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(id, "id");
        return findObjectById(page, SpenObjectFindType.ALL, id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean findObjectById$lambda$9(String keyword, SpenObjectBase spenObjectBase) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        return Intrinsics.areEqual(keyword, DynamicTemplateUtil.INSTANCE.getObjectId(spenObjectBase));
    }

    @JvmStatic
    private static final RectF getLineRectFromObjectRect(RectF objectRect, int position) {
        if (position == 1) {
            float f = objectRect.left;
            return new RectF(f, objectRect.top, f, objectRect.bottom);
        }
        if (position == 16) {
            float f4 = objectRect.right;
            return new RectF(f4, objectRect.top, f4, objectRect.bottom);
        }
        if (position == 256) {
            float f5 = objectRect.left;
            float f6 = objectRect.top;
            return new RectF(f5, f6, objectRect.right, f6);
        }
        if (position != 4096) {
            return null;
        }
        float f7 = objectRect.left;
        float f8 = objectRect.bottom;
        return new RectF(f7, f8, objectRect.right, f8);
    }

    @JvmStatic
    private static final void initBaseDefaultOption(SpenObjectBase baseObject) {
        baseObject.setExtraDataInt(Constant.KEY_IS_DYNAMIC_TEMPLATE_OBJECT, 1);
        baseObject.setMovable(false);
        baseObject.setLayoutType(1);
        baseObject.setRemovable(false);
        baseObject.setRotatable(false);
        baseObject.setResizeOption(2);
    }

    @JvmStatic
    private static final void initTextBoxDefaultOption(SpenObjectTextBox objectTextBox) {
        initBaseDefaultOption(objectTextBox);
        objectTextBox.setAutoFitOption(0);
        objectTextBox.setEllipsisType(0);
    }

    @JvmStatic
    private static final void initTextBoxOptionForImage(SpenObjectTextBox objectTextBox, String objectImageId) {
        objectTextBox.setExtraDataString(Constant.KEY_GROUPED_OBJECT_ID, objectImageId);
        objectTextBox.setSelectable(false);
        objectTextBox.setTextEditable(false);
        objectTextBox.setGravity(1);
        objectTextBox.setTextAlignment(2);
    }

    @JvmStatic
    public static final boolean isTaskTextBox(@NotNull SpenObjectBase objectBase) {
        Intrinsics.checkNotNullParameter(objectBase, "objectBase");
        return (objectBase instanceof SpenObjectTextBox) && objectBase.getExtraDataInt(Constant.KEY_TEXT_BOX_PARAGRAPH_TYPE) == 1;
    }

    @JvmStatic
    public static final boolean isTaskTextBoxContained(@NotNull List<? extends SpenObjectBase> objectBases) {
        Intrinsics.checkNotNullParameter(objectBases, "objectBases");
        Iterator<? extends SpenObjectBase> it = objectBases.iterator();
        while (it.hasNext()) {
            if (isTaskTextBox(it.next())) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    @NotNull
    public static final SpenObjectImage makeGeneratedImage(@NotNull GeneratedImage generatedImage, @NotNull RectF bound, long initTimeInMillis) {
        Intrinsics.checkNotNullParameter(generatedImage, "generatedImage");
        Intrinsics.checkNotNullParameter(bound, "bound");
        String strMakeImageBoxImageId = DynamicTemplateUtil.makeImageBoxImageId(generatedImage.getId(), initTimeInMillis);
        String strMakeImageBoxTextId = DynamicTemplateUtil.makeImageBoxTextId(generatedImage.getId(), initTimeInMillis);
        SpenObjectImage spenObjectImage = new SpenObjectImage();
        initBaseDefaultOption(spenObjectImage);
        spenObjectImage.setRect(bound, false);
        spenObjectImage.setExtraDataInt(Constant.KEY_IS_DYNAMIC_TEMPLATE_GENERATIVE_OBJECT, 1);
        spenObjectImage.setExtraDataString(Constant.KEY_OBJECT_ID, strMakeImageBoxImageId);
        spenObjectImage.setExtraDataString(Constant.KEY_GROUPED_OBJECT_ID, strMakeImageBoxTextId);
        spenObjectImage.setExtraDataString(Constant.KEY_OBJECT_ACTION, Constant.VALUE_OBJECT_ACTION_INSERT_GENERATED_IMAGE);
        spenObjectImage.setExtraDataInt(Constant.KEY_IMAGE_MASK_TYPE, generatedImage.getMaskType());
        spenObjectImage.setImage(DynamicTemplateUtil.getImageBoxDefaultImage(spenObjectImage));
        return spenObjectImage;
    }

    public static /* synthetic */ SpenObjectImage makeGeneratedImage$default(GeneratedImage generatedImage, RectF rectF, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 0;
        }
        return makeGeneratedImage(generatedImage, rectF, j);
    }

    @JvmStatic
    @NotNull
    public static final SpenObjectImage makeImage(@NotNull Image image, @NotNull RectF bound, long initTimeInMillis) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(bound, "bound");
        String strMakeImageBoxImageId = DynamicTemplateUtil.makeImageBoxImageId(image.getId(), initTimeInMillis);
        String strMakeImageBoxTextId = DynamicTemplateUtil.makeImageBoxTextId(image.getId(), initTimeInMillis);
        SpenObjectImage spenObjectImage = new SpenObjectImage();
        initBaseDefaultOption(spenObjectImage);
        spenObjectImage.setRect(bound, false);
        spenObjectImage.setExtraDataString(Constant.KEY_OBJECT_ID, strMakeImageBoxImageId);
        spenObjectImage.setExtraDataString(Constant.KEY_GROUPED_OBJECT_ID, strMakeImageBoxTextId);
        spenObjectImage.setExtraDataString(Constant.KEY_OBJECT_ACTION, Constant.VALUE_OBJECT_ACTION_INSERT_IMAGE);
        spenObjectImage.setExtraDataInt(Constant.KEY_IMAGE_MASK_TYPE, image.getMaskType());
        spenObjectImage.setImage(DynamicTemplateUtil.getImageBoxDefaultImage(spenObjectImage));
        return spenObjectImage;
    }

    public static /* synthetic */ SpenObjectImage makeImage$default(Image image, RectF rectF, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 0;
        }
        return makeImage(image, rectF, j);
    }

    @JvmStatic
    private static final SpenObjectTextBox makeObjectBaseTextBox(TextBox textBox, String objectId, RectF bound, float templatePageWidth, float docPageWidth) {
        SpenObjectTextBox spenObjectTextBox = new SpenObjectTextBox();
        initTextBoxDefaultOption(spenObjectTextBox);
        spenObjectTextBox.setExtraDataString(Constant.KEY_OBJECT_ID, objectId);
        spenObjectTextBox.setRect(bound, false);
        spenObjectTextBox.setFontSize(DynamicTemplateUtil.convertSizeToDocSize(textBox.getFontSize(), templatePageWidth, docPageWidth));
        if (textBox.getParagraphType() != 0) {
            spenObjectTextBox.setExtraDataInt(Constant.KEY_TEXT_BOX_PARAGRAPH_TYPE, textBox.getParagraphType());
        }
        spenObjectTextBox.setTextColor(textBox.getFontColor());
        spenObjectTextBox.setTextStyle(textBox.getTextStyle());
        if (textBox.getTextAlignment() != -1) {
            spenObjectTextBox.setTextAlignment(textBox.getTextAlignment());
        }
        spenObjectTextBox.setLinedPaperEnabled(textBox.getLinedPaperEnabled());
        spenObjectTextBox.setLinedPagerColor(textBox.getLinedPagerColor());
        return spenObjectTextBox;
    }

    @JvmStatic
    @NotNull
    public static final List<Pair<SpenObjectLine, RectF>> makeObjectBorders(@NotNull RectF bound, @NotNull Element element) {
        RectF rectF;
        Intrinsics.checkNotNullParameter(bound, "bound");
        Intrinsics.checkNotNullParameter(element, "element");
        ArrayList arrayList = new ArrayList();
        boolean z = element.getBorderShape().getType() == 1;
        boolean z2 = element.getBorderShape().getType() == 2;
        float thickness = element.getBorderShape().getThickness();
        int color = element.getBorderShape().getColor();
        if (element.getBorderShape().getTop()) {
            rectF = bound;
            makeObjectBorders$addBorder(rectF, z2, color, thickness, z, arrayList, 256);
        } else {
            rectF = bound;
        }
        if (element.getBorderShape().getBottom()) {
            makeObjectBorders$addBorder(rectF, z2, color, thickness, z, arrayList, 4096);
        }
        if (element.getBorderShape().getLeft()) {
            makeObjectBorders$addBorder(rectF, z2, color, thickness, z, arrayList, 1);
        }
        if (element.getBorderShape().getRight()) {
            makeObjectBorders$addBorder(rectF, z2, color, thickness, z, arrayList, 16);
        }
        return arrayList;
    }

    private static final void makeObjectBorders$addBorder(RectF rectF, boolean z, int i, float f, boolean z2, List<Pair<SpenObjectLine, RectF>> list, int i2) {
        RectF lineRectFromObjectRect = getLineRectFromObjectRect(rectF, i2);
        if (lineRectFromObjectRect != null) {
            SpenObjectLine spenObjectLineMakeObjectLine = makeObjectLine(lineRectFromObjectRect, i, f, z2);
            if (i2 == 1) {
                lineRectFromObjectRect.right = lineRectFromObjectRect.left + f;
            } else if (i2 == 16) {
                lineRectFromObjectRect.left = lineRectFromObjectRect.right - f;
            } else if (i2 == 256) {
                lineRectFromObjectRect.bottom = lineRectFromObjectRect.top + f;
            } else if (i2 == 4096) {
                lineRectFromObjectRect.top = lineRectFromObjectRect.bottom - f;
            }
            list.add(new Pair<>(spenObjectLineMakeObjectLine, lineRectFromObjectRect));
        }
        if (z) {
            RectF rectF2 = new RectF(rectF);
            float f4 = 2;
            rectF2.top += f4;
            rectF2.bottom -= f4;
            rectF2.left += f4;
            rectF2.right -= f4;
            RectF lineRectFromObjectRect2 = getLineRectFromObjectRect(rectF2, i2);
            if (lineRectFromObjectRect2 != null) {
                SpenObjectLine spenObjectLineMakeObjectLine2 = makeObjectLine(lineRectFromObjectRect2, i, f, z2);
                if (i2 == 1) {
                    lineRectFromObjectRect2.right = lineRectFromObjectRect2.left + f;
                } else if (i2 == 16) {
                    lineRectFromObjectRect2.left = lineRectFromObjectRect2.right - f;
                } else if (i2 == 256) {
                    lineRectFromObjectRect2.bottom = lineRectFromObjectRect2.top + f;
                } else if (i2 == 4096) {
                    lineRectFromObjectRect2.top = lineRectFromObjectRect2.bottom - f;
                }
                list.add(new Pair<>(spenObjectLineMakeObjectLine2, lineRectFromObjectRect2));
            }
        }
    }

    @JvmStatic
    @NotNull
    public static final SpenObjectTextBox makeObjectDateTextBox(@NotNull DateTextBox dateTextBox, @NotNull RectF bound, float templatePageWidth, float docPageWidth, long initTimeInMillis) {
        Intrinsics.checkNotNullParameter(dateTextBox, "dateTextBox");
        Intrinsics.checkNotNullParameter(bound, "bound");
        String strMakeObjectId = DynamicTemplateUtil.makeObjectId(dateTextBox.getId(), initTimeInMillis);
        String strMakeObjectId2 = DynamicTemplateUtil.makeObjectId(dateTextBox.getTargetId(), initTimeInMillis);
        SpenObjectTextBox spenObjectTextBoxMakeObjectBaseTextBox = makeObjectBaseTextBox(dateTextBox, strMakeObjectId, bound, templatePageWidth, docPageWidth);
        spenObjectTextBoxMakeObjectBaseTextBox.setSelectable(false);
        spenObjectTextBoxMakeObjectBaseTextBox.setTextEditable(false);
        spenObjectTextBoxMakeObjectBaseTextBox.setGravity(1);
        spenObjectTextBoxMakeObjectBaseTextBox.setExtraDataString(Constant.KEY_OBJECT_ACTION, Constant.VALUE_OBJECT_ACTION_SHOW_DATE_PICKER_TEXT);
        spenObjectTextBoxMakeObjectBaseTextBox.setExtraDataString(Constant.KEY_DATE_TEXT_BOX_FORMAT, dateTextBox.getFormat());
        spenObjectTextBoxMakeObjectBaseTextBox.setExtraDataString(Constant.KEY_GROUPED_OBJECT_ID, strMakeObjectId2);
        DynamicTemplateUtil.setDateTextBoxTimeInMillis(spenObjectTextBoxMakeObjectBaseTextBox, System.currentTimeMillis());
        spenObjectTextBoxMakeObjectBaseTextBox.setMargin(0.0f, 0.0f, 0.0f, 0.0f);
        return spenObjectTextBoxMakeObjectBaseTextBox;
    }

    @JvmStatic
    @NotNull
    public static final SpenObjectTextBox makeObjectDayOfWeekTextBox(@NotNull DayOfWeekTextBox dayOfWeekTextBox, @NotNull RectF bound, float templatePageWidth, float docPageWidth, long initTimeInMillis) {
        Intrinsics.checkNotNullParameter(dayOfWeekTextBox, "dayOfWeekTextBox");
        Intrinsics.checkNotNullParameter(bound, "bound");
        String strMakeObjectId = DynamicTemplateUtil.makeObjectId(dayOfWeekTextBox.getId(), initTimeInMillis);
        String strMakeObjectId2 = DynamicTemplateUtil.makeObjectId(dayOfWeekTextBox.getTargetId(), initTimeInMillis);
        SpenObjectTextBox spenObjectTextBoxMakeObjectBaseTextBox = makeObjectBaseTextBox(dayOfWeekTextBox, strMakeObjectId, bound, templatePageWidth, docPageWidth);
        spenObjectTextBoxMakeObjectBaseTextBox.setSelectable(false);
        spenObjectTextBoxMakeObjectBaseTextBox.setTextEditable(false);
        spenObjectTextBoxMakeObjectBaseTextBox.setGravity(1);
        spenObjectTextBoxMakeObjectBaseTextBox.setExtraDataString(Constant.KEY_OBJECT_ACTION, Constant.VALUE_OBJECT_ACTION_SHOW_DATE_PICKER_TEXT);
        spenObjectTextBoxMakeObjectBaseTextBox.setExtraDataInt(Constant.KEY_DAY_OF_WEEK_TEXT_BOX_DISPLAY_TYPE, dayOfWeekTextBox.getDisplayType());
        spenObjectTextBoxMakeObjectBaseTextBox.setExtraDataString(Constant.KEY_GROUPED_OBJECT_ID, strMakeObjectId2);
        spenObjectTextBoxMakeObjectBaseTextBox.setMargin(0.0f, 0.0f, 0.0f, 0.0f);
        return spenObjectTextBoxMakeObjectBaseTextBox;
    }

    @JvmStatic
    @NotNull
    public static final SpenObjectImage makeObjectImageForBackground(@NotNull RectF bound, @NotNull String src, long initTimeInMillis) {
        Intrinsics.checkNotNullParameter(bound, "bound");
        Intrinsics.checkNotNullParameter(src, "src");
        String strMakeImageBoxImageId = DynamicTemplateUtil.makeImageBoxImageId("background_image", initTimeInMillis);
        SpenObjectImage spenObjectImage = new SpenObjectImage();
        initBaseDefaultOption(spenObjectImage);
        spenObjectImage.setSelectable(false);
        spenObjectImage.setRect(bound, false);
        spenObjectImage.setExtraDataString(Constant.KEY_OBJECT_ID, strMakeImageBoxImageId);
        spenObjectImage.setImage(BitmapFactory.decodeFile(src));
        return spenObjectImage;
    }

    public static /* synthetic */ SpenObjectImage makeObjectImageForBackground$default(RectF rectF, String str, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 0;
        }
        return makeObjectImageForBackground(rectF, str, j);
    }

    @JvmStatic
    private static final SpenObjectLine makeObjectLine(RectF lineBound, int color, float width, boolean withDash) {
        SpenObjectLine spenObjectLine = new SpenObjectLine(0, new PointF(lineBound.left, lineBound.top), new PointF(lineBound.right, lineBound.bottom), true);
        initBaseDefaultOption(spenObjectLine);
        spenObjectLine.setRect(lineBound, false);
        spenObjectLine.setSelectable(false);
        SpenLineColorEffect spenLineColorEffect = new SpenLineColorEffect();
        spenLineColorEffect.setSolidColor(color);
        spenObjectLine.setLineColorEffect(spenLineColorEffect);
        SpenLineStyleEffect spenLineStyleEffect = new SpenLineStyleEffect();
        spenLineStyleEffect.setWidth(width);
        spenLineStyleEffect.setDashType(withDash ? 5 : 0);
        spenObjectLine.setLineStyleEffect(spenLineStyleEffect);
        return spenObjectLine;
    }

    @JvmStatic
    @NotNull
    public static final SpenObjectBase makeObjectShape(@NotNull RectF bound, int color) {
        Intrinsics.checkNotNullParameter(bound, "bound");
        SpenObjectShape spenObjectShape = new SpenObjectShape(4, true);
        initBaseDefaultOption(spenObjectShape);
        spenObjectShape.setRect(bound, false);
        spenObjectShape.setSelectable(false);
        SpenFillColorEffect spenFillColorEffect = new SpenFillColorEffect();
        spenFillColorEffect.setSolidColor(color);
        spenObjectShape.setFillEffect(spenFillColorEffect);
        SpenLineColorEffect spenLineColorEffect = new SpenLineColorEffect();
        spenLineColorEffect.setSolidColor(ColorKt.m18579toArgb8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU()));
        spenObjectShape.setLineColorEffect(spenLineColorEffect);
        return spenObjectShape;
    }

    public static /* synthetic */ SpenObjectBase makeObjectShape$default(RectF rectF, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = ColorKt.m18579toArgb8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU());
        }
        return makeObjectShape(rectF, i);
    }

    @JvmStatic
    @NotNull
    public static final SpenObjectTextBox makeObjectTextBox(@NotNull TextBox textBox, @NotNull RectF bound, float templatePageWidth, float docPageWidth, long initTimeInMillis) {
        Intrinsics.checkNotNullParameter(textBox, "textBox");
        Intrinsics.checkNotNullParameter(bound, "bound");
        SpenObjectTextBox spenObjectTextBoxMakeObjectBaseTextBox = makeObjectBaseTextBox(textBox, DynamicTemplateUtil.makeObjectId(textBox.getId(), initTimeInMillis), bound, templatePageWidth, docPageWidth);
        spenObjectTextBoxMakeObjectBaseTextBox.setSelectable(textBox.getEditable());
        spenObjectTextBoxMakeObjectBaseTextBox.setTextEditable(textBox.getEditable());
        int gravity = textBox.getGravity();
        spenObjectTextBoxMakeObjectBaseTextBox.setGravity(gravity != 1 ? gravity != 2 ? 0 : 1 : 2);
        String strConvertTextToReservedMessage = DynamicTemplateUtil.INSTANCE.convertTextToReservedMessage(textBox.getText());
        if (strConvertTextToReservedMessage.length() > 0) {
            spenObjectTextBoxMakeObjectBaseTextBox.setText(strConvertTextToReservedMessage);
        }
        spenObjectTextBoxMakeObjectBaseTextBox.setMargin(0.0f, 0.0f, 0.0f, 0.0f);
        return spenObjectTextBoxMakeObjectBaseTextBox;
    }

    @JvmStatic
    @NotNull
    public static final SpenObjectTextBox makeObjectTextBoxForGenerateImage(@NotNull GeneratedImage generatedImage, @NotNull RectF bound, float templatePageWidth, float docPageWidth, long initTimeInMillis) {
        Intrinsics.checkNotNullParameter(generatedImage, "generatedImage");
        Intrinsics.checkNotNullParameter(bound, "bound");
        String strMakeImageBoxImageId = DynamicTemplateUtil.makeImageBoxImageId(generatedImage.getId(), initTimeInMillis);
        String strMakeImageBoxTextId = DynamicTemplateUtil.makeImageBoxTextId(generatedImage.getId(), initTimeInMillis);
        SpenObjectTextBox spenObjectTextBoxMakeObjectBaseTextBox = makeObjectBaseTextBox(new TextBox(strMakeImageBoxTextId, generatedImage.getLeft(), generatedImage.getTop(), generatedImage.getWidth(), generatedImage.getHeight(), null, 14, ColorKt.m18579toArgb8_81llA(ColorKt.Color(4279123547L)), 2, 0, false, false, null, false, 0, 0, 0, 130080, null), strMakeImageBoxTextId, bound, templatePageWidth, docPageWidth);
        initTextBoxOptionForImage(spenObjectTextBoxMakeObjectBaseTextBox, strMakeImageBoxImageId);
        spenObjectTextBoxMakeObjectBaseTextBox.setExtraDataString(Constant.KEY_OBJECT_ACTION, Constant.VALUE_OBJECT_ACTION_INSERT_GENERATED_IMAGE);
        spenObjectTextBoxMakeObjectBaseTextBox.setText(DynamicTemplateUtil.INSTANCE.convertTextToGenerateImageMessage(generatedImage.getText()), true);
        float fConvertSizeToDocSize = DynamicTemplateUtil.convertSizeToDocSize(30, templatePageWidth, docPageWidth);
        spenObjectTextBoxMakeObjectBaseTextBox.setMargin(fConvertSizeToDocSize, 0.0f, fConvertSizeToDocSize, 0.0f);
        return spenObjectTextBoxMakeObjectBaseTextBox;
    }

    public static /* synthetic */ SpenObjectTextBox makeObjectTextBoxForGenerateImage$default(GeneratedImage generatedImage, RectF rectF, float f, float f4, long j, int i, Object obj) {
        if ((i & 16) != 0) {
            j = 0;
        }
        return makeObjectTextBoxForGenerateImage(generatedImage, rectF, f, f4, j);
    }

    @JvmStatic
    @NotNull
    public static final SpenObjectTextBox makeObjectTextBoxForInsertImage(@NotNull Image image, @NotNull RectF bound, float templatePageWidth, float docPageWidth, long initTimeInMillis) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(bound, "bound");
        String strMakeImageBoxImageId = DynamicTemplateUtil.makeImageBoxImageId(image.getId(), initTimeInMillis);
        String strMakeImageBoxTextId = DynamicTemplateUtil.makeImageBoxTextId(image.getId(), initTimeInMillis);
        SpenObjectTextBox spenObjectTextBoxMakeObjectBaseTextBox = makeObjectBaseTextBox(new TextBox(strMakeImageBoxTextId, image.getLeft(), image.getTop(), image.getWidth(), image.getHeight(), null, 14, ColorKt.m18579toArgb8_81llA(Color.INSTANCE.m18551getBlack0d7_KjU()), 2, 0, false, false, null, false, 0, 0, 0, 130080, null), strMakeImageBoxTextId, bound, templatePageWidth, docPageWidth);
        initTextBoxOptionForImage(spenObjectTextBoxMakeObjectBaseTextBox, strMakeImageBoxImageId);
        spenObjectTextBoxMakeObjectBaseTextBox.setExtraDataString(Constant.KEY_OBJECT_ACTION, Constant.VALUE_OBJECT_ACTION_INSERT_IMAGE);
        spenObjectTextBoxMakeObjectBaseTextBox.setText(BaseUtils.getContext().getString(C9086R.string.composer_ctx_menu_select_new_image), true);
        float fConvertSizeToDocSize = DynamicTemplateUtil.convertSizeToDocSize(30, templatePageWidth, docPageWidth);
        spenObjectTextBoxMakeObjectBaseTextBox.setMargin(fConvertSizeToDocSize, 0.0f, fConvertSizeToDocSize, 0.0f);
        return spenObjectTextBoxMakeObjectBaseTextBox;
    }

    public static /* synthetic */ SpenObjectTextBox makeObjectTextBoxForInsertImage$default(Image image, RectF rectF, float f, float f4, long j, int i, Object obj) {
        if ((i & 16) != 0) {
            j = 0;
        }
        return makeObjectTextBoxForInsertImage(image, rectF, f, f4, j);
    }

    @JvmStatic
    public static final void removeAllObject(@NotNull SpenWPage page) {
        Intrinsics.checkNotNullParameter(page, "page");
        Logger.m10999d(TAG, "removeAllObject ");
        Iterator<SpenObjectBase> it = page.getObjectList().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenObjectBase next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SpenObjectBase spenObjectBase = next;
            if (!DynamicTemplateUtil.isDynamicTemplateObject(spenObjectBase)) {
                page.removeObject(spenObjectBase);
            } else if (spenObjectBase instanceof SpenObjectImage) {
                INSTANCE.releaseImage(page, (SpenObjectImage) spenObjectBase);
            } else if ((spenObjectBase instanceof SpenObjectTextBox) && !DynamicTemplateUtil.hasAction(spenObjectBase)) {
                ((SpenObjectTextBox) spenObjectBase).setText("");
            }
        }
    }

    public final void releaseImage(@NotNull SpenWPage page, @NotNull SpenObjectImage objectImage) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(objectImage, "objectImage");
        SpenObjectBase spenObjectBaseFindObjectById = findObjectById(page, DynamicTemplateUtil.INSTANCE.getGroupedObjectId(objectImage));
        if (spenObjectBaseFindObjectById instanceof SpenObjectTextBox) {
            if (objectImage.getImage() != null) {
                objectImage.setImage(DynamicTemplateUtil.getImageBoxDefaultImage(objectImage));
            }
            ImageUtil.removeGenerativeEditExtraData(objectImage);
            objectImage.setCropRect(null);
            SpenObjectTextBox spenObjectTextBox = (SpenObjectTextBox) spenObjectBaseFindObjectById;
            objectImage.setRect(spenObjectTextBox.getRect(), false);
            int objectIndex = page.getObjectIndex(objectImage);
            int objectIndex2 = page.getObjectIndex(spenObjectBaseFindObjectById);
            AbstractC8014b.m7216r(objectIndex, objectIndex2, "releaseImage, imagePageIndex: ", ", textBoxPageIndex: ", TAG);
            if (objectIndex < objectIndex2) {
                page.moveObjectIndex(objectImage, objectIndex2 - 1, false);
            } else {
                page.moveObjectIndex(spenObjectBaseFindObjectById, objectIndex - 1, false);
            }
            AbstractC8014b.m7216r(page.getObjectIndex(objectImage), page.getObjectIndex(spenObjectBaseFindObjectById), "releaseImage, imagePageIndex: ", ", textBoxPageIndex: ", TAG);
            spenObjectTextBox.setVisible(true);
        }
    }

    public final void updateImage(@NotNull SpenWPage page, @NotNull SpenObjectImage objectImage, @Nullable String path) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(objectImage, "objectImage");
        SpenObjectBase spenObjectBaseFindObjectById = findObjectById(page, DynamicTemplateUtil.INSTANCE.getGroupedObjectId(objectImage));
        if (spenObjectBaseFindObjectById != null && (spenObjectBaseFindObjectById instanceof SpenObjectTextBox)) {
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(path);
            Intrinsics.checkNotNullExpressionValue(bitmapDecodeFile, "decodeFile(...)");
            objectImage.setImage(DynamicTemplateUtil.getImageBoxMaskedImage(objectImage, bitmapDecodeFile));
            if (path != null) {
                C2paHandler.getInstance().executeForGenerativeImage(path, new C13834b(objectImage, 9));
            }
            int objectIndex = page.getObjectIndex(objectImage);
            int objectIndex2 = page.getObjectIndex(spenObjectBaseFindObjectById);
            AbstractC8014b.m7216r(objectIndex, objectIndex2, "updateImage, imagePageIndex: ", ", textBoxPageIndex: ", TAG);
            if (objectIndex < objectIndex2) {
                page.moveObjectIndex(objectImage, objectIndex2 + 1, false);
            } else {
                page.moveObjectIndex(spenObjectBaseFindObjectById, objectIndex + 1, false);
            }
            AbstractC8014b.m7216r(page.getObjectIndex(objectImage), page.getObjectIndex(spenObjectBaseFindObjectById), "updateImage, imagePageIndex: ", ", textBoxPageIndex: ", TAG);
            spenObjectBaseFindObjectById.setVisible(false);
        }
    }

    @JvmStatic
    @Nullable
    public static final SpenObjectBase findObjectById(@NotNull SpenWPage page, int typeFilter, @NotNull String id) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(id, "id");
        return ObjectFindUtil.getObjectFromObjectList(page, typeFilter, id, new C13849N(12));
    }

    @JvmStatic
    private static final void copyExtraData(SpenObjectBase src, SpenObjectBase target, String key) {
        if (src.hasExtraDataString(key)) {
            target.setExtraDataString(key, src.getExtraDataString(key));
        } else if (src.hasExtraDataInt(key)) {
            target.setExtraDataInt(key, src.getExtraDataInt(key));
        }
    }
}
