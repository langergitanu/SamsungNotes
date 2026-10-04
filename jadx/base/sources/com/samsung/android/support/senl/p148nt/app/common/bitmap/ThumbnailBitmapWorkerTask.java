package com.samsung.android.support.senl.p148nt.app.common.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ThumbnailBitmapUtil;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.common.view.ImageScaleView;
import com.samsung.android.support.senl.p148nt.base.common.BitmapInfoObject;
import com.samsung.android.support.senl.p148nt.base.common.EntryImprovementManager;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002()B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\"\u001a\u0004\u0018\u00010\tJ\u0006\u0010#\u001a\u00020\u000fJ\b\u0010$\u001a\u00020\u0016H\u0016J\b\u0010%\u001a\u00020\rH\u0016J\b\u0010&\u001a\u00020\u0019H\u0002J\u0006\u0010'\u001a\u00020\u0019R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u001d\u001a\u0004\u0018\u00010\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/common/bitmap/ThumbnailBitmapWorkerTask;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask;", "Ljava/lang/Void;", "bitmapInfo", "Lcom/samsung/android/support/senl/nt/app/common/bitmap/BitmapInfo;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/common/bitmap/BitmapInfo;)V", "mImageViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/widget/ImageView;", "mBlurView", "Landroid/view/View;", "mFilePath", "", "mModifiedAt", "", "mViewMode", "", "mBackgroundColor", "mNeedSetRatio", "", "mResult", "Lcom/samsung/android/support/senl/nt/app/common/bitmap/ThumbnailBitmapWorkerTask$Result;", "isEntryImproveActive", "execute", "", "taskParams", "onPostExecute", "value", "filePath", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "getHolder", "getModifiedAt", "getResult", "getTag", "init", "updateBackgroundColor", "Result", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nThumbnailBitmapWorkerTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThumbnailBitmapWorkerTask.kt\ncom/samsung/android/support/senl/nt/app/common/bitmap/ThumbnailBitmapWorkerTask\n+ 2 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,157:1\n84#2,6:158\n*S KotlinDebug\n*F\n+ 1 ThumbnailBitmapWorkerTask.kt\ncom/samsung/android/support/senl/nt/app/common/bitmap/ThumbnailBitmapWorkerTask\n*L\n140#1:158,6\n*E\n"})
public final class ThumbnailBitmapWorkerTask extends WorkerTask<Void> {

    @NotNull
    private static final String TAG = "ThumbnailBitmapWorkerTask";
    private final boolean isEntryImproveActive;
    private int mBackgroundColor;

    @Nullable
    private final WeakReference<View> mBlurView;

    @Nullable
    private String mFilePath;

    @Nullable
    private final WeakReference<ImageView> mImageViewRef;
    private long mModifiedAt;
    private final boolean mNeedSetRatio;

    @NotNull
    private Result mResult;
    private final int mViewMode;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u0006\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/common/bitmap/ThumbnailBitmapWorkerTask$Result;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Result;", "tag", "", "bitmap", "Landroid/graphics/Bitmap;", "hashCode", "", "<init>", "(Ljava/lang/String;Landroid/graphics/Bitmap;I)V", "getTag", "()Ljava/lang/String;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "getHashCode", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "toString", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class Result implements WorkerTask.Result {

        @Nullable
        private Bitmap bitmap;
        private final int hashCode;

        @NotNull
        private final String tag;

        public Result(@NotNull String tag, @Nullable Bitmap bitmap, int i) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.tag = tag;
            this.bitmap = bitmap;
            this.hashCode = i;
        }

        public static /* synthetic */ Result copy$default(Result result, String str, Bitmap bitmap, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = result.tag;
            }
            if ((i2 & 2) != 0) {
                bitmap = result.bitmap;
            }
            if ((i2 & 4) != 0) {
                i = result.hashCode;
            }
            return result.copy(str, bitmap, i);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTag() {
            return this.tag;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getHashCode() {
            return this.hashCode;
        }

        @NotNull
        public final Result copy(@NotNull String tag, @Nullable Bitmap bitmap, int hashCode) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            return new Result(tag, bitmap, hashCode);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return Intrinsics.areEqual(this.tag, result.tag) && Intrinsics.areEqual(this.bitmap, result.bitmap) && this.hashCode == result.hashCode;
        }

        @Nullable
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
        public int getHashCode() {
            return this.hashCode;
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
        @NotNull
        public String getTag() {
            return this.tag;
        }

        public int hashCode() {
            int iHashCode = this.tag.hashCode() * 31;
            Bitmap bitmap = this.bitmap;
            return Integer.hashCode(this.hashCode) + ((iHashCode + (bitmap == null ? 0 : bitmap.hashCode())) * 31);
        }

        public final void setBitmap(@Nullable Bitmap bitmap) {
            this.bitmap = bitmap;
        }

        @NotNull
        public String toString() {
            String str = this.tag;
            Bitmap bitmap = this.bitmap;
            int i = this.hashCode;
            StringBuilder sb = new StringBuilder("Result(tag=");
            sb.append(str);
            sb.append(", bitmap=");
            sb.append(bitmap);
            sb.append(", hashCode=");
            return AbstractC2821a.m2223n(sb, ")", i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThumbnailBitmapWorkerTask(@NotNull BitmapInfo bitmapInfo) {
        super(0, null, 3, null);
        Intrinsics.checkNotNullParameter(bitmapInfo, "bitmapInfo");
        this.mImageViewRef = new WeakReference<>(bitmapInfo.viewHolder);
        this.mBlurView = bitmapInfo.blurView != null ? new WeakReference<>(bitmapInfo.blurView) : null;
        this.mFilePath = bitmapInfo.filePath;
        this.mModifiedAt = bitmapInfo.lastModifiedAt;
        this.mViewMode = bitmapInfo.viewMode;
        this.mBackgroundColor = bitmapInfo.backgroundColor;
        this.mNeedSetRatio = bitmapInfo.needSetRatio;
        this.mResult = new Result(TAG, bitmapInfo.bitmap, getHashCode());
        this.isEntryImproveActive = EntryImprovementManager.INSTANCE.getInstance().getMIsActive();
    }

    private final void init() {
        setFilePath("");
        this.mModifiedAt = -1L;
    }

    @Nullable
    /* JADX INFO: renamed from: getFilePath, reason: from getter */
    public final String getMFilePath() {
        return this.mFilePath;
    }

    @Nullable
    public final ImageView getHolder() {
        WeakReference<ImageView> weakReference = this.mImageViewRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: renamed from: getModifiedAt, reason: from getter */
    public final long getMModifiedAt() {
        return this.mModifiedAt;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    public void onPostExecute() {
        ImageView holder;
        super.onPostExecute();
        if (isCancelled() || (holder = getHolder()) == null || this.mResult.getBitmap() == null) {
            return;
        }
        ThumbnailBitmapUtil.recycleBitmap(holder);
        holder.setImageBitmap(this.mResult.getBitmap());
        if (this.isEntryImproveActive) {
            EntryImprovementManager companion = EntryImprovementManager.INSTANCE.getInstance();
            Bitmap bitmap = this.mResult.getBitmap();
            String mFilePath = getMFilePath();
            Intrinsics.checkNotNull(mFilePath);
            companion.add(new BitmapInfoObject(bitmap, mFilePath + this.mModifiedAt));
        }
        WeakReference<View> weakReference = this.mBlurView;
        if (weakReference != null) {
            if (NotesUtils.isSupportREImageFilter) {
                holder.requestLayout();
                return;
            }
            View view = weakReference.get();
            if (view != null) {
                view.setVisibility(0);
                view.setBackground(ResourcesCompat.getDrawable(view.getResources(), C8003R.drawable.black_gradient_blur, null));
            }
        }
    }

    public final void setFilePath(@Nullable String str) {
        this.mFilePath = str;
    }

    public final void updateBackgroundColor() {
        Bitmap bitmap = this.mResult.getBitmap();
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(this.mBackgroundColor);
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        bitmap.recycle();
        this.mResult.setBitmap(bitmapCreateBitmap);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    public void execute(@Nullable Void taskParams) {
        if (isCancelled()) {
            return;
        }
        ImageView holder = getHolder();
        if (holder == null || isCancelled()) {
            init();
            this.mResult.setBitmap(null);
            return;
        }
        if (this.isEntryImproveActive) {
            Result result = this.mResult;
            EntryImprovementManager companion = EntryImprovementManager.INSTANCE.getInstance();
            Context context = holder.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            result.setBitmap(companion.getBitmap(context, getMFilePath() + this.mModifiedAt));
            if (this.mNeedSetRatio && (holder instanceof ImageScaleView)) {
                ((ImageScaleView) holder).setRatio(ImageUtils.getImageRatio(getMFilePath()));
            }
        }
        if (this.mResult.getBitmap() == null) {
            if (isCancelled()) {
                init();
                return;
            }
            BitmapInfo bitmapInfoForImageView = ThumbnailBitmapUtil.getBitmapInfoForImageView(getHolder(), getMFilePath(), this.mViewMode);
            this.mResult.setBitmap(bitmapInfoForImageView.bitmap);
            if (this.mNeedSetRatio && (holder instanceof ImageScaleView)) {
                ((ImageScaleView) holder).setRatio(bitmapInfoForImageView.ratio);
            }
        }
        if (this.mResult.getBitmap() == null) {
            init();
        } else if (this.mBlurView != null) {
            updateBackgroundColor();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    /* JADX INFO: renamed from: getResult, reason: from getter */
    public Result getMResult() {
        return this.mResult;
    }
}
