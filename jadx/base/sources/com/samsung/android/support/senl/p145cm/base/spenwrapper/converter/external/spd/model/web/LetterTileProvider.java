package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.web;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/web/LetterTileProvider;", "", "<init>", "()V", "mPaint", "Landroid/text/TextPaint;", "mBounds", "Landroid/graphics/Rect;", "mCanvas", "Landroid/graphics/Canvas;", "mFirstChar", "", "getLetterTile", "Landroid/graphics/Bitmap;", "displayChar", "", "size", "", "color", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LetterTileProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SPDToSDocXConverter$LetterTileProvider";

    @NotNull
    private final Rect mBounds;

    @NotNull
    private final Canvas mCanvas;

    @NotNull
    private final char[] mFirstChar;

    @NotNull
    private final TextPaint mPaint;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/web/LetterTileProvider$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "isEnglishLetterOrDigit", "", "c", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isEnglishLetterOrDigit(char c) {
            if ('A' <= c && c < '[') {
                return true;
            }
            if ('a' > c || c >= '{') {
                return '0' <= c && c < ':';
            }
            return true;
        }

        private Companion() {
        }
    }

    public LetterTileProvider() {
        TextPaint textPaint = new TextPaint();
        this.mPaint = textPaint;
        this.mBounds = new Rect();
        this.mCanvas = new Canvas();
        this.mFirstChar = new char[1];
        textPaint.setTypeface(Typeface.create("sans-serif-light", 0));
        textPaint.setColor(-1);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setAntiAlias(true);
    }

    @NotNull
    public final Bitmap getLetterTile(char displayChar, int size, int color) {
        LoggerBase.INSTANCE.m7132d(TAG, "getLetterTile, displayChar: " + displayChar + ", size: " + size + ", color: " + color);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = this.mCanvas;
        canvas.setBitmap(bitmapCreateBitmap);
        canvas.drawColor(color);
        if (INSTANCE.isEnglishLetterOrDigit(displayChar)) {
            this.mFirstChar[0] = Character.toUpperCase(displayChar);
            float f = size;
            this.mPaint.setTextSize(0.7f * f);
            this.mPaint.getTextBounds(this.mFirstChar, 0, 1, this.mBounds);
            char[] cArr = this.mFirstChar;
            float f4 = f / 2.0f;
            Rect rect = this.mBounds;
            canvas.drawText(cArr, 0, 1, f4, ((rect.bottom - rect.top) / 2.0f) + f4, this.mPaint);
        }
        return bitmapCreateBitmap;
    }
}
