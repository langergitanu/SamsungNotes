package com.samsung.android.support.senl.p148nt.app.settings.common.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 22\u00020\u0001:\u00012B-\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\u000bB\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\fB\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\rJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J&\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007J\u0006\u0010#\u001a\u00020\u001aJ\u0010\u0010$\u001a\u00020\u001a2\b\b\u0001\u0010%\u001a\u00020\u0007J\b\u0010&\u001a\u00020\u001aH\u0003J\u0010\u0010'\u001a\u00020\u001a2\b\b\u0001\u0010(\u001a\u00020\u0007J\b\u0010)\u001a\u00020\u001aH\u0003J\u0010\u0010*\u001a\u00020\u001a2\b\b\u0001\u0010+\u001a\u00020\u0007J\b\u0010,\u001a\u00020\u001aH\u0003J\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u0007J\u000e\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u0007J\b\u00101\u001a\u00020\u001aH\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/common/component/ImageViewPreference;", "Landroidx/preference/Preference;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "mImageView", "Landroid/widget/ImageView;", "mImageResId", "mContentDescriptionResId", "mColorFilterResId", "mHeight", "mWidth", "mPaddingStart", "mPaddingTop", "mPaddingEnd", "mPaddingBottom", "init", "", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "setPaddingRelative", "start", "top", "end", "bottom", "applyPaddingRelative", BaseWidgetConstant.SET_IMAGE_RESOURCE, "imageResId", "applyImageResource", "setContentDescription", "contentDescriptionResId", "applyContentDescription", BaseWidgetConstant.SET_COLOR_FILTER, "colorResId", "applyColorFilter", "setWidth", "width", "setHeight", "height", "applySize", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImageViewPreference extends Preference {

    @NotNull
    private static final String TAG = "ImageViewPreference";

    @ColorRes
    private int mColorFilterResId;

    @StringRes
    private int mContentDescriptionResId;
    private int mHeight;

    @DrawableRes
    private int mImageResId;

    @Nullable
    private ImageView mImageView;
    private int mPaddingBottom;
    private int mPaddingEnd;
    private int mPaddingStart;
    private int mPaddingTop;
    private int mWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageViewPreference(@Nullable Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNull(context);
        this.mPaddingStart = -1;
        this.mPaddingTop = -1;
        this.mPaddingEnd = -1;
        this.mPaddingBottom = -1;
        init();
    }

    @SuppressLint({"ResourceType"})
    private final void applyColorFilter() {
        ImageView imageView = this.mImageView;
        if (imageView == null || this.mColorFilterResId == 0) {
            return;
        }
        Intrinsics.checkNotNull(imageView);
        imageView.setColorFilter(this.mColorFilterResId, PorterDuff.Mode.OVERLAY);
    }

    @SuppressLint({"ResourceType"})
    private final void applyContentDescription() {
        if (this.mImageView == null) {
            return;
        }
        String strM756B = AbstractC0541b.m756B(this.mContentDescriptionResId != 0 ? AbstractC0541b.m756B(getContext().getResources().getString(this.mContentDescriptionResId), " ") : "", getContext().getResources().getString(C9086R.string.base_string_image));
        ImageView imageView = this.mImageView;
        Intrinsics.checkNotNull(imageView);
        imageView.setContentDescription(strM756B);
    }

    @SuppressLint({"ResourceType"})
    private final void applyImageResource() {
        ImageView imageView = this.mImageView;
        if (imageView == null || this.mImageResId == 0) {
            return;
        }
        Intrinsics.checkNotNull(imageView);
        imageView.setImageResource(this.mImageResId);
    }

    private final void applySize() {
        ImageView imageView = this.mImageView;
        if (imageView == null) {
            return;
        }
        Intrinsics.checkNotNull(imageView);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        int i = this.mWidth;
        if (i == 0) {
            i = layoutParams2.width;
        }
        layoutParams2.width = i;
        int i2 = this.mHeight;
        if (i2 == 0) {
            i2 = layoutParams2.height;
        }
        layoutParams2.height = i2;
        ImageView imageView2 = this.mImageView;
        Intrinsics.checkNotNull(imageView2);
        imageView2.setLayoutParams(layoutParams2);
    }

    private final void init() {
        setLayoutResource(C8003R.layout.settings_imageview_preference_layout);
    }

    public final void applyPaddingRelative() {
        ImageView imageView = this.mImageView;
        if (imageView == null) {
            return;
        }
        Intrinsics.checkNotNull(imageView);
        ViewParent parent = imageView.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        int paddingStart = viewGroup.getPaddingStart();
        int paddingTop = viewGroup.getPaddingTop();
        int paddingEnd = viewGroup.getPaddingEnd();
        int paddingBottom = viewGroup.getPaddingBottom();
        int i = this.mPaddingStart;
        if (i > 0) {
            paddingStart = i;
        }
        int i2 = this.mPaddingTop;
        if (i2 > 0) {
            paddingTop = i2;
        }
        int i4 = this.mPaddingEnd;
        if (i4 > 0) {
            paddingEnd = i4;
        }
        int i5 = this.mPaddingBottom;
        if (i5 > 0) {
            paddingBottom = i5;
        }
        viewGroup.setPaddingRelative(paddingStart, paddingTop, paddingEnd, paddingBottom);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(@NotNull PreferenceViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MainLogger.m7258i(TAG, "onBindViewHolder");
        super.onBindViewHolder(holder);
        View viewFindViewById = holder.findViewById(C8003R.id.settings_imageview);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) viewFindViewById;
        this.mImageView = imageView;
        Intrinsics.checkNotNull(imageView);
        imageView.setBackgroundColor(holder.itemView.getResources().getColor(NotesUtils.getAntiGreenisFilteredColor(C8003R.color.settings_list_background_color), null));
        applyImageResource();
        applyPaddingRelative();
        applyContentDescription();
        applyColorFilter();
        applySize();
    }

    public final void setColorFilter(@ColorRes int colorResId) {
        this.mColorFilterResId = colorResId;
        applyColorFilter();
    }

    public final void setContentDescription(@StringRes int contentDescriptionResId) {
        this.mContentDescriptionResId = contentDescriptionResId;
        applyContentDescription();
    }

    public final void setHeight(int height) {
        this.mHeight = height;
        applySize();
    }

    public final void setImageResource(@DrawableRes int imageResId) {
        this.mImageResId = imageResId;
        applyImageResource();
    }

    public final void setPaddingRelative(int start, int top, int end, int bottom) {
        this.mPaddingStart = start;
        this.mPaddingTop = top;
        this.mPaddingEnd = end;
        this.mPaddingBottom = bottom;
    }

    public final void setWidth(int width) {
        this.mWidth = width;
        applySize();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageViewPreference(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNull(context);
        this.mPaddingStart = -1;
        this.mPaddingTop = -1;
        this.mPaddingEnd = -1;
        this.mPaddingBottom = -1;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageViewPreference(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNull(context);
        this.mPaddingStart = -1;
        this.mPaddingTop = -1;
        this.mPaddingEnd = -1;
        this.mPaddingBottom = -1;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageViewPreference(@Nullable Context context) {
        super(context);
        Intrinsics.checkNotNull(context);
        this.mPaddingStart = -1;
        this.mPaddingTop = -1;
        this.mPaddingEnd = -1;
        this.mPaddingBottom = -1;
        init();
    }
}
