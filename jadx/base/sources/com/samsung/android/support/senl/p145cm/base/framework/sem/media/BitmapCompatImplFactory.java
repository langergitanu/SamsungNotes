package com.samsung.android.support.senl.p145cm.base.framework.sem.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.samsung.android.support.senl.p145cm.base.framework.sem.media.AbsBitmapCompatImplFactory;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import java.io.InputStream;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/media/BitmapCompatImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsBitmapCompatImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsBitmapCompatImplFactory$IBitmapCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "BitmapCompatSemImpl", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BitmapCompatImplFactory extends AbsBitmapCompatImplFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J(\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/media/BitmapCompatImplFactory$BitmapCompatSemImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsBitmapCompatImplFactory$IBitmapCompatImpl;", "<init>", "()V", "decodeFile", "Landroid/graphics/Bitmap;", "pathName", "", "opts", "Landroid/graphics/BitmapFactory$Options;", "mimeType", "decodeStream", "is", "Ljava/io/InputStream;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class BitmapCompatSemImpl implements AbsBitmapCompatImplFactory.IBitmapCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.media.AbsBitmapCompatImplFactory.IBitmapCompatImpl
        @Nullable
        public Bitmap decodeFile(@Nullable String pathName, @Nullable BitmapFactory.Options opts, @Nullable String mimeType) {
            return BitmapFactory.decodeFile(pathName, opts);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.media.AbsBitmapCompatImplFactory.IBitmapCompatImpl
        @Nullable
        public Bitmap decodeStream(@Nullable InputStream is, @Nullable BitmapFactory.Options opts, @Nullable String mimeType) {
            return BitmapFactory.decodeStream(is, null, opts);
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.media.AbsBitmapCompatImplFactory
    @NotNull
    public AbsBitmapCompatImplFactory.IBitmapCompatImpl create(int deviceType) {
        return (deviceType != 2 || Build.VERSION.SDK_INT < 30) ? super.create(deviceType) : new BitmapCompatSemImpl();
    }
}
