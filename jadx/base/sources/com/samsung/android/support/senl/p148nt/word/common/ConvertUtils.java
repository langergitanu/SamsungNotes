package com.samsung.android.support.senl.p148nt.word.common;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectPainting;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p196io.CloseableKt;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\tJ>\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0005J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"J\u000e\u0010$\u001a\u00020%2\u0006\u0010#\u001a\u00020%¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/common/ConvertUtils;", "", "<init>", "()V", "isStrokeType", "", "type", "", "convertRectF", "Landroid/graphics/RectF;", "wPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "width", "height", "rectF", "convertRectContinuousPage", "prevHeight", "widthNote", "heightNote", "widthOffice", "heightOffice", "hasPDF", "getCropRect", "Landroid/graphics/Rect;", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "bitmapToInputStream", "Ljava/io/InputStream;", "bitmap", "Landroid/graphics/Bitmap;", "filePathToInputStream", "filePath", "", "dpToPt", "", JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT, "dpToDxa", "", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ConvertUtils {

    @NotNull
    public static final ConvertUtils INSTANCE = new ConvertUtils();

    private ConvertUtils() {
    }

    @Nullable
    public final InputStream bitmapToInputStream(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 85, byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    @NotNull
    public final RectF convertRectContinuousPage(int prevHeight, int widthNote, int heightNote, int widthOffice, int heightOffice, @NotNull RectF rectF, boolean hasPDF) {
        int i;
        Intrinsics.checkNotNullParameter(rectF, "rectF");
        RectF rectF2 = new RectF(rectF);
        float fCoerceAtLeast = RangesKt.coerceAtLeast(0.0f, rectF.top - prevHeight);
        rectF2.top = fCoerceAtLeast;
        float f = (rectF.bottom - rectF.top) + fCoerceAtLeast;
        rectF2.bottom = f;
        if (!hasPDF || widthNote <= heightNote) {
            heightNote -= 36;
            float f4 = heightNote / 1.4142857f;
            float f5 = f4 / widthNote;
            rectF2.left *= f5;
            rectF2.right *= f5;
            widthNote = (int) f4;
        }
        if ((heightOffice * widthNote) / heightNote > widthOffice) {
            i = widthNote;
        } else {
            widthOffice = heightOffice;
            i = heightNote;
        }
        float f6 = widthOffice / i;
        rectF2.top = fCoerceAtLeast * f6;
        rectF2.bottom = f * f6;
        rectF2.left *= f6;
        rectF2.right *= f6;
        if (hasPDF && widthNote > heightNote) {
            return rectF2;
        }
        rectF2.offset(0.0f, 36.0f);
        return rectF2;
    }

    @NotNull
    public final RectF convertRectF(@NotNull SpenWPage wPage, int width, int height, @NotNull RectF rectF) {
        int width2;
        Intrinsics.checkNotNullParameter(wPage, "wPage");
        Intrinsics.checkNotNullParameter(rectF, "rectF");
        if ((wPage.getHeight() * width) / wPage.getWidth() > height) {
            width2 = wPage.getHeight();
            width = height;
        } else {
            width2 = wPage.getWidth();
        }
        float f = width;
        float f4 = width2;
        return new RectF((rectF.left * f) / f4, (rectF.top * f) / f4, (rectF.right * f) / f4, (rectF.bottom * f) / f4);
    }

    public final float dpToDxa(float dp) {
        return (dp * 1440.0f) / 160.0f;
    }

    public final double dpToPt(double dp) {
        return (dp * ((double) 72)) / ((double) 160);
    }

    @NotNull
    public final InputStream filePathToInputStream(@Nullable String filePath) {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        try {
            FileChannel channel = fileInputStream.getChannel();
            try {
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                int iCapacity = map.capacity();
                byte[] bArr = new byte[iCapacity];
                map.get(bArr, 0, iCapacity);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                CloseableKt.closeFinally(channel, null);
                CloseableKt.closeFinally(fileInputStream, null);
                return byteArrayInputStream;
            } finally {
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Rect getCropRect(@NotNull SpenObjectBase objectBase) {
        Rect cropRect;
        Intrinsics.checkNotNullParameter(objectBase, "objectBase");
        if (objectBase.getType() == 3) {
            cropRect = objectBase instanceof SpenObjectImage ? ((SpenObjectImage) objectBase).getCropRect() : null;
        } else if (objectBase.getType() == 14 && (objectBase instanceof SpenObjectPainting)) {
            cropRect = ((SpenObjectPainting) objectBase).getCropRect();
        }
        if (cropRect == null || (cropRect.left == 0 && cropRect.top == 0 && cropRect.right == 0 && cropRect.bottom == 0)) {
            return null;
        }
        return cropRect;
    }

    public final boolean isStrokeType(int type) {
        return type == 1 || type == 7 || type == 8;
    }
}
