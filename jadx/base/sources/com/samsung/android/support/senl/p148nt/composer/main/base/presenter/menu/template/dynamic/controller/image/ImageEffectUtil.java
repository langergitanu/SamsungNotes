package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.controller.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/controller/image/ImageEffectUtil;", "", "<init>", "()V", "applyRoundedEffect", "", "srcPath", "", "size", "", "applyConnerCutEffect", "Landroid/graphics/Bitmap;", "bitmap", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImageEffectUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageEffectUtil.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/controller/image/ImageEffectUtil\n+ 2 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,63:1\n84#2,6:64\n84#2,6:70\n*S KotlinDebug\n*F\n+ 1 ImageEffectUtil.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/controller/image/ImageEffectUtil\n*L\n21#1:64,6\n45#1:70,6\n*E\n"})
public final class ImageEffectUtil {

    @NotNull
    public static final ImageEffectUtil INSTANCE = new ImageEffectUtil();

    private ImageEffectUtil() {
    }

    @JvmStatic
    public static final void applyConnerCutEffect(@NotNull String srcPath, int size) {
        Intrinsics.checkNotNullParameter(srcPath, "srcPath");
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(srcPath);
        Intrinsics.checkNotNull(bitmapDecodeFile);
        Bitmap bitmapApplyEffect = ConnerCutEffect.applyEffect(bitmapDecodeFile, size);
        ImageUtils.make(bitmapApplyEffect, new File(srcPath), 100, Bitmap.CompressFormat.PNG);
        bitmapApplyEffect.recycle();
        bitmapDecodeFile.recycle();
    }

    @JvmStatic
    public static final void applyRoundedEffect(@NotNull String srcPath, int size) {
        Intrinsics.checkNotNullParameter(srcPath, "srcPath");
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(srcPath);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        canvas.drawRoundRect(rectF, 50.0f, 50.0f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmapDecodeFile, new Rect(0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight()), rectF, paint);
        ImageUtils.make(bitmapCreateBitmap, new File(srcPath), 100, Bitmap.CompressFormat.PNG);
        bitmapCreateBitmap.recycle();
        bitmapDecodeFile.recycle();
    }

    @JvmStatic
    @NotNull
    public static final Bitmap applyConnerCutEffect(@NotNull Bitmap bitmap, int size) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Bitmap bitmapApplyEffect = ConnerCutEffect.applyEffect(bitmap, size);
        bitmap.recycle();
        return bitmapApplyEffect;
    }

    @JvmStatic
    @NotNull
    public static final Bitmap applyRoundedEffect(@NotNull Bitmap bitmap, int size) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        canvas.drawRoundRect(rectF, 50.0f, 50.0f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rectF, paint);
        bitmap.recycle();
        return bitmapCreateBitmap;
    }
}
