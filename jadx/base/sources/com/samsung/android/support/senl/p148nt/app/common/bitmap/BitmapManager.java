package com.samsung.android.support.senl.p148nt.app.common.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/common/bitmap/BitmapManager;", "", "<init>", "()V", "onLoadImage", "", "bitmapInfo", "Lcom/samsung/android/support/senl/nt/app/common/bitmap/BitmapInfo;", "cancelPotentialWork", "", "filePath", "", "viewHolder", "Landroid/widget/ImageView;", "clearAsyncDrawable", "getModifiedAt", "", "imageView", "getFilePath", "getBitmapWorkerTask", "Lcom/samsung/android/support/senl/nt/app/common/bitmap/ThumbnailBitmapWorkerTask;", "AsyncDrawable", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BitmapManager {

    @NotNull
    private static final String TAG = "BitmapManager";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\f\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/common/bitmap/BitmapManager$AsyncDrawable;", "Landroid/graphics/drawable/BitmapDrawable;", "res", "Landroid/content/res/Resources;", "bitmap", "Landroid/graphics/Bitmap;", "thumbnailBitmapWorkerTask", "Lcom/samsung/android/support/senl/nt/app/common/bitmap/ThumbnailBitmapWorkerTask;", "<init>", "(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Lcom/samsung/android/support/senl/nt/app/common/bitmap/ThumbnailBitmapWorkerTask;)V", "bitmapWorkerTaskReference", "Ljava/lang/ref/WeakReference;", "bitmapWorkerTask", "getBitmapWorkerTask", "()Lcom/samsung/android/support/senl/nt/app/common/bitmap/ThumbnailBitmapWorkerTask;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class AsyncDrawable extends BitmapDrawable {

        @NotNull
        private final WeakReference<ThumbnailBitmapWorkerTask> bitmapWorkerTaskReference;

        public AsyncDrawable(@Nullable Resources resources, @Nullable Bitmap bitmap, @Nullable ThumbnailBitmapWorkerTask thumbnailBitmapWorkerTask) {
            super(resources, bitmap);
            this.bitmapWorkerTaskReference = new WeakReference<>(thumbnailBitmapWorkerTask);
        }

        @Nullable
        public final ThumbnailBitmapWorkerTask getBitmapWorkerTask() {
            return this.bitmapWorkerTaskReference.get();
        }
    }

    private final ThumbnailBitmapWorkerTask getBitmapWorkerTask(ImageView imageView, String filePath) {
        if (imageView == null || filePath == null) {
            return null;
        }
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AsyncDrawable) {
            return ((AsyncDrawable) drawable).getBitmapWorkerTask();
        }
        return null;
    }

    public final boolean cancelPotentialWork(@Nullable String filePath, @Nullable ImageView viewHolder) {
        ThumbnailBitmapWorkerTask bitmapWorkerTask = getBitmapWorkerTask(viewHolder, filePath);
        if (bitmapWorkerTask == null) {
            return true;
        }
        String mFilePath = bitmapWorkerTask.getMFilePath();
        ImageView holder = bitmapWorkerTask.getHolder();
        if (mFilePath == null) {
            return false;
        }
        if (Intrinsics.areEqual(mFilePath, filePath) && Intrinsics.areEqual(holder, viewHolder)) {
            return false;
        }
        bitmapWorkerTask.cancel();
        return true;
    }

    public final void clearAsyncDrawable(@Nullable ImageView viewHolder) {
        Drawable drawable;
        if (viewHolder == null || (drawable = viewHolder.getDrawable()) == null) {
            return;
        }
        try {
            ThumbnailBitmapWorkerTask bitmapWorkerTask = ((AsyncDrawable) drawable).getBitmapWorkerTask();
            if (bitmapWorkerTask != null) {
                bitmapWorkerTask.cancel();
            }
        } catch (ClassCastException unused) {
        }
    }

    @Nullable
    public final String getFilePath(@Nullable ImageView imageView, @Nullable String filePath) {
        ThumbnailBitmapWorkerTask bitmapWorkerTask = getBitmapWorkerTask(imageView, filePath);
        return bitmapWorkerTask != null ? bitmapWorkerTask.getMFilePath() : "";
    }

    public final long getModifiedAt(@Nullable ImageView imageView, @Nullable String filePath) {
        ThumbnailBitmapWorkerTask bitmapWorkerTask = getBitmapWorkerTask(imageView, filePath);
        if (bitmapWorkerTask != null) {
            return bitmapWorkerTask.getMModifiedAt();
        }
        return -1L;
    }

    public final void onLoadImage(@NotNull BitmapInfo bitmapInfo) {
        BitmapDrawable bitmapDrawable;
        Intrinsics.checkNotNullParameter(bitmapInfo, "bitmapInfo");
        String str = bitmapInfo.filePath;
        ImageView imageView = bitmapInfo.viewHolder;
        if (imageView == null) {
            return;
        }
        if (!cancelPotentialWork(str, imageView)) {
            AbstractC0000a.m25v("onLoadImage# not cancel Potential Work filePath : ", MainLogger.getEncode(str), TAG);
            return;
        }
        try {
            bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
        } catch (ClassCastException e) {
            AbstractC0000a.m25v("onLoadImage# VectorDrawable lock icon used on simple view : ", e.getMessage(), TAG);
        }
        Bitmap bitmap = bitmapDrawable != null ? bitmapDrawable.getBitmap() : null;
        ThumbnailBitmapWorkerTask thumbnailBitmapWorkerTask = new ThumbnailBitmapWorkerTask(bitmapInfo);
        imageView.setImageDrawable(new AsyncDrawable(imageView.getResources(), bitmap, thumbnailBitmapWorkerTask));
        WorkerTask.run$default(thumbnailBitmapWorkerTask, null, 1, null);
    }
}
