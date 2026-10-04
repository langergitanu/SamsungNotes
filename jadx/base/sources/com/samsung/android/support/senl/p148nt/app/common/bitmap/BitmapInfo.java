package com.samsung.android.support.senl.p148nt.app.common.bitmap;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\u0011\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/common/bitmap/BitmapInfo;", "", "builder", "Lcom/samsung/android/support/senl/nt/app/common/bitmap/BitmapInfo$BitmapInfoSetBuilder;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/common/bitmap/BitmapInfo$BitmapInfoSetBuilder;)V", "Lcom/samsung/android/support/senl/nt/app/common/bitmap/BitmapInfo$BitmapInfoGetBuilder;", "(Lcom/samsung/android/support/senl/nt/app/common/bitmap/BitmapInfo$BitmapInfoGetBuilder;)V", "viewHolder", "Landroid/widget/ImageView;", "filePath", "", "viewMode", "", "lastModifiedAt", "", "blurView", "Landroid/view/View;", "backgroundColor", "needSetRatio", "", "ratio", "", "bitmap", "Landroid/graphics/Bitmap;", "BitmapInfoSetBuilder", "BitmapInfoGetBuilder", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BitmapInfo {

    @JvmField
    public int backgroundColor;

    @JvmField
    @Nullable
    public Bitmap bitmap;

    @JvmField
    @Nullable
    public View blurView;

    @JvmField
    @Nullable
    public String filePath;

    @JvmField
    public long lastModifiedAt;

    @JvmField
    public boolean needSetRatio;

    @JvmField
    public float ratio;

    @JvmField
    @Nullable
    public ImageView viewHolder;

    @JvmField
    public int viewMode;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/common/bitmap/BitmapInfo$BitmapInfoGetBuilder;", "", "<init>", "()V", "ratio", "", "getRatio", "()F", "setRatio", "(F)V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "build", "Lcom/samsung/android/support/senl/nt/app/common/bitmap/BitmapInfo;", "setRatioInfo", "setBitmapInfo", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class BitmapInfoGetBuilder {

        @Nullable
        private Bitmap bitmap;
        private float ratio;

        @NotNull
        public final BitmapInfo build() {
            return new BitmapInfo(this);
        }

        @Nullable
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final float getRatio() {
            return this.ratio;
        }

        public final void setBitmap(@Nullable Bitmap bitmap) {
            this.bitmap = bitmap;
        }

        @NotNull
        public final BitmapInfoGetBuilder setBitmapInfo(@Nullable Bitmap bitmap) {
            this.bitmap = bitmap;
            return this;
        }

        public final void setRatio(float f) {
            this.ratio = f;
        }

        @NotNull
        public final BitmapInfoGetBuilder setRatioInfo(float ratio) {
            this.ratio = ratio;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010+\u001a\u00020,J\u0010\u0010-\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010.\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010/\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u00100\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u00101\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u000e\u00102\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0011J\u000e\u00103\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00064"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/common/bitmap/BitmapInfo$BitmapInfoSetBuilder;", "", "<init>", "()V", "viewHolder", "Landroid/widget/ImageView;", "getViewHolder", "()Landroid/widget/ImageView;", "setViewHolder", "(Landroid/widget/ImageView;)V", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "viewMode", "", "getViewMode", "()I", "setViewMode", "(I)V", "lastModifiedAt", "", "getLastModifiedAt", "()J", "setLastModifiedAt", "(J)V", "blurView", "Landroid/view/View;", "getBlurView", "()Landroid/view/View;", "setBlurView", "(Landroid/view/View;)V", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "needSetRatio", "", "getNeedSetRatio", "()Z", "setNeedSetRatio", "(Z)V", "build", "Lcom/samsung/android/support/senl/nt/app/common/bitmap/BitmapInfo;", "setViewHolderInfo", "setFilePathInfo", "setViewModeInfo", "setLastModifiedAtInfo", "setBlurViewInfo", "setBackgroundColorInfo", "setNeedSetRatioInfo", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class BitmapInfoSetBuilder {

        @Nullable
        private View blurView;

        @Nullable
        private String filePath;
        private boolean needSetRatio;

        @Nullable
        private ImageView viewHolder;
        private int viewMode = -1;
        private long lastModifiedAt = -1;
        private int backgroundColor = -1;

        @NotNull
        public final BitmapInfo build() {
            return new BitmapInfo(this);
        }

        public final int getBackgroundColor() {
            return this.backgroundColor;
        }

        @Nullable
        public final View getBlurView() {
            return this.blurView;
        }

        @Nullable
        public final String getFilePath() {
            return this.filePath;
        }

        public final long getLastModifiedAt() {
            return this.lastModifiedAt;
        }

        public final boolean getNeedSetRatio() {
            return this.needSetRatio;
        }

        @Nullable
        public final ImageView getViewHolder() {
            return this.viewHolder;
        }

        public final int getViewMode() {
            return this.viewMode;
        }

        public final void setBackgroundColor(int i) {
            this.backgroundColor = i;
        }

        @NotNull
        public final BitmapInfoSetBuilder setBackgroundColorInfo(int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public final void setBlurView(@Nullable View view) {
            this.blurView = view;
        }

        @NotNull
        public final BitmapInfoSetBuilder setBlurViewInfo(@Nullable View blurView) {
            this.blurView = blurView;
            return this;
        }

        public final void setFilePath(@Nullable String str) {
            this.filePath = str;
        }

        @NotNull
        public final BitmapInfoSetBuilder setFilePathInfo(@Nullable String filePath) {
            this.filePath = filePath;
            return this;
        }

        public final void setLastModifiedAt(long j) {
            this.lastModifiedAt = j;
        }

        @NotNull
        public final BitmapInfoSetBuilder setLastModifiedAtInfo(long lastModifiedAt) {
            this.lastModifiedAt = lastModifiedAt;
            return this;
        }

        public final void setNeedSetRatio(boolean z) {
            this.needSetRatio = z;
        }

        @NotNull
        public final BitmapInfoSetBuilder setNeedSetRatioInfo(boolean needSetRatio) {
            this.needSetRatio = needSetRatio;
            return this;
        }

        public final void setViewHolder(@Nullable ImageView imageView) {
            this.viewHolder = imageView;
        }

        @NotNull
        public final BitmapInfoSetBuilder setViewHolderInfo(@Nullable ImageView viewHolder) {
            this.viewHolder = viewHolder;
            return this;
        }

        public final void setViewMode(int i) {
            this.viewMode = i;
        }

        @NotNull
        public final BitmapInfoSetBuilder setViewModeInfo(int viewMode) {
            this.viewMode = viewMode;
            return this;
        }
    }

    public BitmapInfo(@NotNull BitmapInfoSetBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.viewHolder = builder.getViewHolder();
        this.filePath = builder.getFilePath();
        this.viewMode = builder.getViewMode();
        this.lastModifiedAt = builder.getLastModifiedAt();
        this.blurView = builder.getBlurView();
        this.backgroundColor = builder.getBackgroundColor();
        this.needSetRatio = builder.getNeedSetRatio();
    }

    public BitmapInfo(@NotNull BitmapInfoGetBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.ratio = builder.getRatio();
        this.bitmap = builder.getBitmap();
    }
}
