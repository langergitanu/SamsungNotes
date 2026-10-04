package com.samsung.android.support.senl.p145cm.base.framework.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.framework.sem.media.AbsBitmapCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.media.BitmapCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ&\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/media/BitmapCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsBitmapCompatImplFactory$IBitmapCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsBitmapCompatImplFactory$IBitmapCompatImpl;)V", "decodeStream", "Landroid/graphics/Bitmap;", "is", "Ljava/io/InputStream;", "opts", "Landroid/graphics/BitmapFactory$Options;", "mimeType", "", "decodeFile", "pathName", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BitmapCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "BitmapCompat";

    @Nullable
    private static BitmapCompat mInstance;

    @NotNull
    private final AbsBitmapCompatImplFactory.IBitmapCompatImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/media/BitmapCompat$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/media/BitmapCompat;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/media/BitmapCompat;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized BitmapCompat getInstance() {
            BitmapCompat bitmapCompat;
            try {
                if (BitmapCompat.mInstance == null) {
                    BitmapCompat.mInstance = new BitmapCompat(new BitmapCompatImplFactory().create(DeviceInfo.getDeviceType()), null);
                }
                bitmapCompat = BitmapCompat.mInstance;
                Intrinsics.checkNotNull(bitmapCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.media.BitmapCompat");
            } catch (Throwable th) {
                throw th;
            }
            return bitmapCompat;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }

    public /* synthetic */ BitmapCompat(AbsBitmapCompatImplFactory.IBitmapCompatImpl iBitmapCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iBitmapCompatImpl);
    }

    @NotNull
    public static final synchronized BitmapCompat getInstance() {
        return INSTANCE.getInstance();
    }

    @Nullable
    public final Bitmap decodeFile(@Nullable String pathName, @Nullable BitmapFactory.Options opts, @Nullable String mimeType) {
        if (!TextUtils.isEmpty(pathName)) {
            return this.mImpl.decodeFile(pathName, opts, mimeType);
        }
        LoggerBase.INSTANCE.m7133e(TAG, "decodeFile#: pathName is empty");
        return null;
    }

    @Nullable
    public final Bitmap decodeStream(@Nullable InputStream is, @Nullable BitmapFactory.Options opts, @Nullable String mimeType) {
        if (is != null) {
            return this.mImpl.decodeStream(is, opts, mimeType);
        }
        LoggerBase.INSTANCE.m7133e(TAG, "decodeStream#: stream is null");
        return null;
    }

    private BitmapCompat(AbsBitmapCompatImplFactory.IBitmapCompatImpl iBitmapCompatImpl) {
        this.mImpl = iBitmapCompatImpl;
    }
}
