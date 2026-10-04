package com.samsung.android.support.senl.p148nt.base.common;

import android.graphics.Bitmap;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/BitmapInfoObject;", "", "bitmap", "Landroid/graphics/Bitmap;", "filePath", "", "<init>", "(Landroid/graphics/Bitmap;Ljava/lang/String;)V", "mBitmap", "getFilePath", "()Ljava/lang/String;", "getBitmap", "()Landroid/graphics/Bitmap;", "recycle", "", "cloneBitmap", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBitmapInfoObject.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BitmapInfoObject.kt\ncom/samsung/android/support/senl/nt/base/common/BitmapInfoObject\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1#2:52\n*E\n"})
public final class BitmapInfoObject {

    @NotNull
    private static final String TAG = "BitmapInfoObject";

    @NotNull
    private final String filePath;

    @Nullable
    private Bitmap mBitmap;

    public BitmapInfoObject(@Nullable Bitmap bitmap, @NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.mBitmap = cloneBitmap(bitmap);
        this.filePath = filePath;
    }

    private final Bitmap cloneBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            Bitmap.Config config = bitmap.getConfig();
            if (config != null) {
                return bitmap.copy(config, bitmap.isMutable());
            }
            return null;
        } catch (Exception e) {
            LoggerBase.INSTANCE.m7132d(TAG, "cloneBitmapException #" + e.getMessage());
            return null;
        }
    }

    @Nullable
    public final Bitmap getBitmap() {
        synchronized (BitmapInfoObject.class) {
            try {
                Bitmap bitmap = this.mBitmap;
                if (bitmap != null) {
                    Boolean boolValueOf = bitmap != null ? Boolean.valueOf(bitmap.isRecycled()) : null;
                    Intrinsics.checkNotNull(boolValueOf);
                    if (!boolValueOf.booleanValue()) {
                        return cloneBitmap(this.mBitmap);
                    }
                }
                Unit unit = Unit.INSTANCE;
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NotNull
    public final String getFilePath() {
        return this.filePath;
    }

    public final synchronized void recycle() {
        Bitmap bitmap;
        try {
            Bitmap bitmap2 = this.mBitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && (bitmap = this.mBitmap) != null) {
                bitmap.recycle();
            }
            this.mBitmap = null;
        } catch (Throwable th) {
            throw th;
        }
    }
}
