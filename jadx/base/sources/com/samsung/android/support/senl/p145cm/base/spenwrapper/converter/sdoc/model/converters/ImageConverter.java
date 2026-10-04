package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentImage;
import com.samsung.android.sdk.composer.util.SpenComposerUtil;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.SpenObjectConstructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/ImageConverter;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/AbsContentConverter;", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentImage;", "<init>", "()V", "mComposer", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/INoteComposer;", "convertContent", "", "src", ActionHandler.PARAMS, "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/IConvertParams;", "release", "", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImageConverter extends AbsContentConverter<SpenContentImage> {
    private static final int IMAGE_MIN_SIZE = 74;

    @NotNull
    private static final String TAG = "SDocXConverter$ImageConverter";

    @Nullable
    private INoteComposer mComposer;

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.AbsContentConverter
    public void release() {
        this.mComposer = null;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.AbsContentConverter
    public boolean convertContent(@Nullable SpenContentImage src, @NotNull IConvertParams params) {
        DisplayMetrics displayMetrics;
        int width;
        int height;
        Intrinsics.checkNotNullParameter(params, "params");
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        companion.m7137i(TAG, "convert content");
        String thumbnailPath = src != null ? src.getThumbnailPath() : null;
        if (thumbnailPath == null) {
            companion.m7133e(TAG, "copy(), imagePath is null");
            return false;
        }
        this.mComposer = params.getComposer();
        ObjectTaskStyle objectTaskStyle = new ObjectTaskStyle(src);
        INoteComposer iNoteComposer = this.mComposer;
        Integer numValueOf = iNoteComposer != null ? Integer.valueOf(iNoteComposer.getObjectMaxWidth()) : null;
        IResourceGetter resourceGetter = params.getResourceGetter();
        if (resourceGetter == null || (displayMetrics = resourceGetter.getDisplayMetrics()) == null) {
            return false;
        }
        float f = displayMetrics.densityDpi / 160;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(thumbnailPath);
        if (bitmapDecodeFile == null) {
            companion.m7138w(TAG, "decoding bitmap failed, apply min width");
            width = 74;
            height = 74;
        } else {
            width = bitmapDecodeFile.getWidth();
            height = bitmapDecodeFile.getHeight();
        }
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        int i4 = i < i2 ? i : i2;
        INoteComposer iNoteComposer2 = this.mComposer;
        RectF imageViewSize = SpenComposerUtil.getImageViewSize(i4, f, width, height, src.getRatio(), numValueOf != null ? numValueOf.intValue() - ((int) (iNoteComposer2 != null ? iNoteComposer2.getDPI() : 0.0f)) : 0, objectTaskStyle.getMType() == 2);
        if (imageViewSize.width() > (this.mComposer != null ? r5.getObjectMaxWidth() : 0)) {
            float objectMaxWidth = (this.mComposer != null ? r3.getObjectMaxWidth() : 0) / imageViewSize.width();
            imageViewSize = new RectF(imageViewSize.left, imageViewSize.top, (imageViewSize.width() * objectMaxWidth) + imageViewSize.left, (imageViewSize.height() * objectMaxWidth) + imageViewSize.top);
        }
        SpenObjectImage spenObjectImageMakeObjectImage = SpenObjectConstructor.makeObjectImage();
        spenObjectImageMakeObjectImage.setRect(imageViewSize, false);
        spenObjectImageMakeObjectImage.setImage(thumbnailPath);
        if (src.getTaskStyle() == 0) {
            INoteComposer iNoteComposer3 = this.mComposer;
            if (iNoteComposer3 != null) {
                iNoteComposer3.appendObject(spenObjectImageMakeObjectImage);
            }
        } else {
            INoteComposer iNoteComposer4 = this.mComposer;
            if (iNoteComposer4 != null) {
                iNoteComposer4.appendTaskObject(spenObjectImageMakeObjectImage, objectTaskStyle);
            }
        }
        return true;
    }
}
