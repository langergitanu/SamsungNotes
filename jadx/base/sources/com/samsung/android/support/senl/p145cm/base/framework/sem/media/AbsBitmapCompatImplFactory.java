package com.samsung.android.support.senl.p145cm.base.framework.sem.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u0000 \n2\u00020\u0001:\u0003\b\t\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsBitmapCompatImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsBitmapCompatImplFactory$IBitmapCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "IBitmapCompatImpl", "BitmapCompatPureImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsBitmapCompatImplFactory {

    @NotNull
    private static final String TAG = "AbsBitmapCompatImplFactory";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J(\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsBitmapCompatImplFactory$BitmapCompatPureImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsBitmapCompatImplFactory$IBitmapCompatImpl;", "<init>", "()V", "decodeFile", "Landroid/graphics/Bitmap;", "pathName", "", "opts", "Landroid/graphics/BitmapFactory$Options;", "mimeType", "decodeStream", "is", "Ljava/io/InputStream;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class BitmapCompatPureImpl implements IBitmapCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.media.AbsBitmapCompatImplFactory.IBitmapCompatImpl
        @NotNull
        public Bitmap decodeFile(@Nullable String pathName, @Nullable BitmapFactory.Options opts, @Nullable String mimeType) {
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(pathName, opts);
            Intrinsics.checkNotNullExpressionValue(bitmapDecodeFile, "decodeFile(...)");
            return bitmapDecodeFile;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.media.AbsBitmapCompatImplFactory.IBitmapCompatImpl
        @Nullable
        public Bitmap decodeStream(@Nullable InputStream is, @Nullable BitmapFactory.Options opts, @Nullable String mimeType) {
            return BitmapFactory.decodeStream(is, null, opts);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&J(\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsBitmapCompatImplFactory$IBitmapCompatImpl;", "", "decodeFile", "Landroid/graphics/Bitmap;", "pathName", "", "opts", "Landroid/graphics/BitmapFactory$Options;", "mimeType", "decodeStream", "is", "Ljava/io/InputStream;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IBitmapCompatImpl {
        @Nullable
        Bitmap decodeFile(@Nullable String pathName, @Nullable BitmapFactory.Options opts, @Nullable String mimeType);

        @Nullable
        Bitmap decodeStream(@Nullable InputStream is, @Nullable BitmapFactory.Options opts, @Nullable String mimeType);
    }

    @NotNull
    public IBitmapCompatImpl create(int deviceType) {
        return new BitmapCompatPureImpl();
    }
}
