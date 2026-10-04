package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters;

import android.graphics.BitmapFactory;
import android.graphics.RectF;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentDrawing;
import com.samsung.android.sdk.composer.util.SpenComposerUtil;
import com.samsung.android.sdk.pen.document.SpenObjectPainting;
import com.samsung.android.sdk.pen.document.SpenPaintingDoc;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.SpenObjectConstructor;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/DrawingConverter;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/AbsContentConverter;", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentDrawing;", "<init>", "()V", "convertContent", "", "src", ActionHandler.PARAMS, "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/IConvertParams;", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DrawingConverter extends AbsContentConverter<SpenContentDrawing> {

    @NotNull
    private static final String TAG = "SDocXConverter$DrawingConverter";

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.AbsContentConverter
    public boolean convertContent(@Nullable SpenContentDrawing src, @NotNull IConvertParams params) {
        boolean z;
        Intrinsics.checkNotNullParameter(params, "params");
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        companion.m7137i(TAG, "convert content");
        String attachedFile = src != null ? src.getAttachedFile() : null;
        String thumbnailPath = src != null ? src.getThumbnailPath() : null;
        if (attachedFile == null || attachedFile.length() == 0 || !AbstractC2322a.m1607A(attachedFile) || thumbnailPath == null || thumbnailPath.length() == 0 || !AbstractC2322a.m1607A(thumbnailPath)) {
            companion.m7133e(TAG, "can't add ContentDrawing : not file");
            return false;
        }
        INoteComposer composer = params.getComposer();
        ObjectTaskStyle objectTaskStyle = new ObjectTaskStyle(src);
        int dpi = (int) (composer.getDPI() * objectTaskStyle.getHorizontalSpace());
        int width = composer.getWidth();
        int height = composer.getHeight();
        ISpenDocCreator docCreator = params.getDocCreator();
        SpenPaintingDoc spenPaintingDocCreatePaintingDoc = docCreator != null ? docCreator.createPaintingDoc(width, height, attachedFile) : null;
        if (spenPaintingDocCreatePaintingDoc == null) {
            companion.m7133e(TAG, "can't add ContentDrawing : failed painting doc creation");
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(new File(thumbnailPath).getAbsolutePath(), options);
        int i = options.outWidth;
        int i2 = options.outHeight;
        IResourceGetter resourceGetter = params.getResourceGetter();
        if ((resourceGetter != null ? resourceGetter.getDisplayMetrics() : null) != null) {
            RectF imageViewSize = SpenComposerUtil.getImageViewSize((int) Math.min(r3.widthPixels, r3.heightPixels), r3.densityDpi / 160, i, i2, src.getRatio(), composer.getObjectMaxWidth() - dpi, false);
            SpenObjectPainting spenObjectPaintingMakeObjectPainting = SpenObjectConstructor.makeObjectPainting();
            spenObjectPaintingMakeObjectPainting.setThumbnailPath(src.getThumbnailPath());
            spenObjectPaintingMakeObjectPainting.setRect(imageViewSize, false);
            if (src.getTaskStyle() == 0) {
                params.getComposer().appendObject(spenObjectPaintingMakeObjectPainting, attachedFile);
            } else {
                params.getComposer().appendObject(spenObjectPaintingMakeObjectPainting, attachedFile, objectTaskStyle);
            }
            z = true;
        } else {
            z = true;
        }
        try {
            spenPaintingDocCreatePaintingDoc.close(z);
            return true;
        } catch (IOException e) {
            LoggerBase.INSTANCE.m7132d(TAG, "convertContent, close() - " + e.getMessage());
            return true;
        }
    }
}
