package com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.adapter.holder;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.bitmap.BitmapInfo;
import com.samsung.android.support.senl.p148nt.app.common.bitmap.BitmapManager;
import com.samsung.android.support.senl.p148nt.app.common.listener.ThumbnailHoverListener;
import com.samsung.android.support.senl.p148nt.app.common.util.ResourcesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ThumbnailBitmapUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewShapeManager;
import com.samsung.android.support.senl.p148nt.app.common.widget.HoverPopupTextView;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010)\u001a\u0004\u0018\u00010\u0003J\b\u0010*\u001a\u0004\u0018\u00010\u0011J\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020,H\u0002J\u0006\u0010.\u001a\u00020,J\u0010\u0010/\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010(J\u000e\u00105\u001a\u00020,2\u0006\u00106\u001a\u000207J\u0010\u0010:\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010(J\u000e\u0010=\u001a\u00020,2\u0006\u00106\u001a\u000207J\u001a\u0010?\u001a\u00020,2\b\u0010@\u001a\u0004\u0018\u00010(2\b\u0010A\u001a\u0004\u0018\u00010BJ\u000e\u0010C\u001a\u00020,2\u0006\u00106\u001a\u000207J\u000e\u0010H\u001a\u00020,2\u0006\u00106\u001a\u000207J\u000e\u0010I\u001a\u00020,2\u0006\u0010J\u001a\u00020(R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u00101\u001a\u0004\u0018\u0001028F¢\u0006\u0006\u001a\u0004\b3\u00104R\u0011\u00108\u001a\u0002078F¢\u0006\u0006\u001a\u0004\b8\u00109R\u0013\u0010;\u001a\u0004\u0018\u0001028F¢\u0006\u0006\u001a\u0004\b<\u00104R\u0011\u0010>\u001a\u0002078F¢\u0006\u0006\u001a\u0004\b>\u00109R\u0013\u0010D\u001a\u0004\u0018\u00010E8F¢\u0006\u0006\u001a\u0004\bF\u0010G¨\u0006K"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/adapter/holder/ImportDocumentRecyclerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mThumbnailHoverListener", "Lcom/samsung/android/support/senl/nt/app/common/listener/ThumbnailHoverListener;", "mRootCardView", "mImageView", "Landroid/widget/ImageView;", "mFavoriteView", "mVoiceContainer", "mVoiceIcon", "mVoiceRuntime", "Landroid/widget/TextView;", "mCheckBox", "Landroid/widget/CheckBox;", "getMCheckBox", "()Landroid/widget/CheckBox;", "setMCheckBox", "(Landroid/widget/CheckBox;)V", "mTitleView", "getMTitleView", "()Landroid/widget/TextView;", "setMTitleView", "(Landroid/widget/TextView;)V", "mContentView", "Lcom/samsung/android/support/senl/nt/app/common/widget/HoverPopupTextView;", "getMContentView", "()Lcom/samsung/android/support/senl/nt/app/common/widget/HoverPopupTextView;", "setMContentView", "(Lcom/samsung/android/support/senl/nt/app/common/widget/HoverPopupTextView;)V", "mTimeContainer", "Landroid/widget/LinearLayout;", "getMTimeContainer", "()Landroid/widget/LinearLayout;", "mModifiedTime", "getMModifiedTime", "mImagePath", "", "getRootCardView", "getCheckBox", "addTitleView", "", "addContentView", "dismissHoverPopup", "setTitleText", "string", "titleText", "", "getTitleText", "()Ljava/lang/CharSequence;", "setTitleVisibility", "visible", "", "isVisibleTitle", "()Z", "setContentText", MarketingConstants.NotificationConst.CONTENT_TEXT, "getContentText", "setContentVisibility", "isVisibleContent", "setImage", DBSchema.DocumentThumbnail.IMAGE_PATH, "bitmapManager", "Lcom/samsung/android/support/senl/nt/app/common/bitmap/BitmapManager;", "setImageVisibility", "imageDrawable", "Landroid/graphics/drawable/Drawable;", "getImageDrawable", "()Landroid/graphics/drawable/Drawable;", "updateFavoriteLayout", "updateVoiceContainer", "voiceRuntime", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImportDocumentRecyclerViewHolder extends RecyclerView.ViewHolder {

    @Nullable
    private CheckBox mCheckBox;

    @Nullable
    private HoverPopupTextView mContentView;

    @Nullable
    private ImageView mFavoriteView;

    @Nullable
    private String mImagePath;

    @Nullable
    private ImageView mImageView;

    @NotNull
    private final TextView mModifiedTime;

    @Nullable
    private View mRootCardView;

    @NotNull
    private final ThumbnailHoverListener mThumbnailHoverListener;

    @NotNull
    private final LinearLayout mTimeContainer;

    @Nullable
    private TextView mTitleView;

    @Nullable
    private View mVoiceContainer;

    @Nullable
    private ImageView mVoiceIcon;

    @Nullable
    private TextView mVoiceRuntime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImportDocumentRecyclerViewHolder(@NotNull final View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.mThumbnailHoverListener = new ThumbnailHoverListener(new ThumbnailHoverListener.HoverRecyclerViewHolderListener() { // from class: com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.adapter.holder.ImportDocumentRecyclerViewHolder.1
            @Override // com.samsung.android.support.senl.nt.app.common.listener.ThumbnailHoverListener.HoverRecyclerViewHolderListener
            public int backgroundColor() {
                return 0;
            }

            @Override // com.samsung.android.support.senl.nt.app.common.listener.ThumbnailHoverListener.HoverRecyclerViewHolderListener
            public Drawable getImageDrawableImpl() {
                Drawable imageDrawable = this.getImageDrawable();
                Intrinsics.checkNotNull(imageDrawable);
                return imageDrawable;
            }

            @Override // com.samsung.android.support.senl.nt.app.common.listener.ThumbnailHoverListener.HoverRecyclerViewHolderListener
            /* JADX INFO: renamed from: getItemView, reason: from getter */
            public View get$itemView() {
                return itemView;
            }

            @Override // com.samsung.android.support.senl.nt.app.common.listener.ThumbnailHoverListener.HoverRecyclerViewHolderListener
            public boolean hasOnlyHandwritingSdoc() {
                return false;
            }

            @Override // com.samsung.android.support.senl.nt.app.common.listener.ThumbnailHoverListener.HoverRecyclerViewHolderListener
            public boolean isSdoc() {
                return false;
            }

            @Override // com.samsung.android.support.senl.nt.app.common.listener.ThumbnailHoverListener.HoverRecyclerViewHolderListener
            public boolean isSupportInvertedBGColor() {
                return false;
            }
        }, 1);
        this.mRootCardView = itemView.findViewById(C8003R.id.root_cardview);
        View viewFindViewById = itemView.findViewById(C8003R.id.time_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        LinearLayout linearLayout = (LinearLayout) viewFindViewById;
        this.mTimeContainer = linearLayout;
        View viewFindViewById2 = linearLayout.findViewById(C8003R.id.modified_time);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.mModifiedTime = (TextView) viewFindViewById2;
        addTitleView();
        addContentView();
        View viewFindViewById3 = linearLayout.findViewById(C8003R.id.created_time);
        if (viewFindViewById3 != null) {
            viewFindViewById3.setVisibility(8);
        }
        if (this.mCheckBox == null) {
            View inflatedView = ViewModeUtils.getInflatedView(itemView, C8003R.id.checkbox, C8003R.id.inflate_checkbox);
            Intrinsics.checkNotNull(inflatedView, "null cannot be cast to non-null type android.widget.CheckBox");
            CheckBox checkBox = (CheckBox) inflatedView;
            this.mCheckBox = checkBox;
            Intrinsics.checkNotNull(checkBox);
            checkBox.setVisibility(0);
        }
    }

    private final void addContentView() {
        if (this.mContentView == null) {
            View inflatedView = ViewModeUtils.getInflatedView(this.itemView, C8003R.id.content, C8003R.id.inflate_content);
            Intrinsics.checkNotNull(inflatedView, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.common.widget.HoverPopupTextView");
            this.mContentView = (HoverPopupTextView) inflatedView;
        }
    }

    private final void addTitleView() {
        if (this.mTitleView == null) {
            View inflatedView = ViewModeUtils.getInflatedView(this.itemView, C8003R.id.title, C8003R.id.inflate_title);
            Intrinsics.checkNotNull(inflatedView, "null cannot be cast to non-null type android.widget.TextView");
            this.mTitleView = (TextView) inflatedView;
        }
    }

    public final void dismissHoverPopup() {
        this.mThumbnailHoverListener.dismissHoverPopup();
    }

    @Nullable
    /* JADX INFO: renamed from: getCheckBox, reason: from getter */
    public final CheckBox getMCheckBox() {
        return this.mCheckBox;
    }

    @Nullable
    public final CharSequence getContentText() {
        HoverPopupTextView hoverPopupTextView = this.mContentView;
        if (hoverPopupTextView != null) {
            return hoverPopupTextView.getText();
        }
        return null;
    }

    @Nullable
    public final Drawable getImageDrawable() {
        if (TextUtils.isEmpty(this.mImagePath)) {
            return null;
        }
        return Drawable.createFromPath(this.mImagePath);
    }

    @Nullable
    public final CheckBox getMCheckBox() {
        return this.mCheckBox;
    }

    @Nullable
    public final HoverPopupTextView getMContentView() {
        return this.mContentView;
    }

    @NotNull
    public final TextView getMModifiedTime() {
        return this.mModifiedTime;
    }

    @NotNull
    public final LinearLayout getMTimeContainer() {
        return this.mTimeContainer;
    }

    @Nullable
    public final TextView getMTitleView() {
        return this.mTitleView;
    }

    @Nullable
    /* JADX INFO: renamed from: getRootCardView, reason: from getter */
    public final View getMRootCardView() {
        return this.mRootCardView;
    }

    @Nullable
    public final CharSequence getTitleText() {
        TextView textView = this.mTitleView;
        if (textView != null) {
            return textView.getText();
        }
        return null;
    }

    public final boolean isVisibleContent() {
        HoverPopupTextView hoverPopupTextView = this.mContentView;
        if (hoverPopupTextView == null) {
            return false;
        }
        Intrinsics.checkNotNull(hoverPopupTextView);
        return hoverPopupTextView.getVisibility() == 0;
    }

    public final boolean isVisibleTitle() {
        TextView textView = this.mTitleView;
        if (textView == null) {
            return false;
        }
        Intrinsics.checkNotNull(textView);
        return textView.getVisibility() == 0;
    }

    public final void setContentText(@Nullable String string) {
        HoverPopupTextView hoverPopupTextView = this.mContentView;
        if (hoverPopupTextView != null) {
            if (string == null || string.length() == 0) {
                hoverPopupTextView.setVisibility(8);
            } else {
                hoverPopupTextView.setOriginalText(string, ResourcesUtils.getDefaultBackgroundColor(this.itemView.getResources()), false, true, false, true);
                hoverPopupTextView.setVisibility(0);
            }
        }
    }

    public final void setContentVisibility(boolean visible) {
        HoverPopupTextView hoverPopupTextView = this.mContentView;
        if (hoverPopupTextView != null) {
            hoverPopupTextView.setVisibility(visible ? 0 : 8);
        }
    }

    public final void setImage(@Nullable String imagePath, @Nullable BitmapManager bitmapManager) {
        if (TextUtils.isEmpty(imagePath)) {
            this.mImagePath = null;
            ImageView imageView = this.mImageView;
            if (imageView != null) {
                imageView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mImageView == null) {
            View inflatedView = ViewModeUtils.getInflatedView(this.itemView, C8003R.id.image, C8003R.id.inflate_image);
            Intrinsics.checkNotNull(inflatedView, "null cannot be cast to non-null type android.widget.ImageView");
            this.mImageView = (ImageView) inflatedView;
        }
        ImageView imageView2 = this.mImageView;
        Intrinsics.checkNotNull(imageView2);
        imageView2.setVisibility(0);
        ImageView imageView3 = this.mImageView;
        Intrinsics.checkNotNull(imageView3);
        imageView3.setOnHoverListener(this.mThumbnailHoverListener);
        if (TextUtils.equals(imagePath, this.mImagePath)) {
            return;
        }
        this.mImagePath = imagePath;
        if (bitmapManager != null) {
            if (bitmapManager.cancelPotentialWork(imagePath, this.mImageView)) {
                ThumbnailBitmapUtil.recycleBitmap(this.mImageView);
                ImageView imageView4 = this.mImageView;
                Intrinsics.checkNotNull(imageView4);
                imageView4.setImageBitmap(null);
            }
            bitmapManager.onLoadImage(new BitmapInfo.BitmapInfoSetBuilder().setViewHolderInfo(this.mImageView).setFilePathInfo(this.mImagePath).build());
        }
    }

    public final void setImageVisibility(boolean visible) {
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setVisibility(visible ? 0 : 8);
        }
    }

    public final void setMCheckBox(@Nullable CheckBox checkBox) {
        this.mCheckBox = checkBox;
    }

    public final void setMContentView(@Nullable HoverPopupTextView hoverPopupTextView) {
        this.mContentView = hoverPopupTextView;
    }

    public final void setMTitleView(@Nullable TextView textView) {
        this.mTitleView = textView;
    }

    public final void setTitleText(@Nullable String string) {
        TextView textView = this.mTitleView;
        if (textView != null) {
            if (string == null || string.length() == 0) {
                textView.setVisibility(8);
            } else {
                textView.setText(string);
                textView.setVisibility(0);
            }
        }
    }

    public final void setTitleVisibility(boolean visible) {
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setVisibility(visible ? 0 : 8);
        }
    }

    public final void updateFavoriteLayout(boolean visible) {
        if (visible) {
            if (this.mFavoriteView == null) {
                View inflatedView = ViewModeUtils.getInflatedView(this.itemView, C8003R.id.favorite, C8003R.id.inflate_favorite);
                Intrinsics.checkNotNull(inflatedView, "null cannot be cast to non-null type android.widget.ImageView");
                ImageView imageView = (ImageView) inflatedView;
                this.mFavoriteView = imageView;
                Intrinsics.checkNotNull(imageView);
                Drawable drawable = imageView.getDrawable();
                if (drawable != null) {
                    drawable.setAutoMirrored(true);
                }
            }
            ImageView imageView2 = this.mFavoriteView;
            Intrinsics.checkNotNull(imageView2);
            imageView2.setVisibility(0);
            ViewCompat companion = ViewCompat.INSTANCE.getInstance();
            ImageView imageView3 = this.mFavoriteView;
            Intrinsics.checkNotNull(imageView3);
            companion.setTooltipText(imageView3, imageView3.getContext().getText(C8003R.string.notes_icon_favorite));
        } else {
            ImageView imageView4 = this.mFavoriteView;
            if (imageView4 != null) {
                imageView4.setVisibility(8);
            }
        }
        View view = this.mRootCardView;
        if (view != null) {
            view.setClipToOutline(true);
            view.setOutlineProvider(visible ? ViewShapeManager.INSTANCE.getInstance().getFavoriteNoteHolderOutlineProvider(1) : ViewShapeManager.INSTANCE.getInstance().getDefaultNoteHolderOutlineProvider(1));
        }
    }

    public final void updateVoiceContainer(@NotNull String voiceRuntime) {
        Drawable drawableFindDrawableByLayerId;
        Intrinsics.checkNotNullParameter(voiceRuntime, "voiceRuntime");
        if (TextUtils.isEmpty(voiceRuntime)) {
            View view = this.mVoiceContainer;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mVoiceContainer == null) {
            this.mVoiceContainer = ViewModeUtils.getInflatedView(this.itemView.findViewById(C8003R.id.thumbnail_container), C8003R.id.voice_chip, C8003R.id.inflate_voice_chip);
        }
        View view2 = this.mVoiceContainer;
        if (view2 != null) {
            view2.setVisibility(0);
            view2.setBackgroundResource(C8003R.drawable.notes_item_voice_blur_chip_background);
            LayerDrawable layerDrawable = (LayerDrawable) view2.getBackground();
            if (layerDrawable != null && (drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(C8003R.id.voice_color_chip_background)) != null) {
                drawableFindDrawableByLayerId.setColorFilter(new PorterDuffColorFilter(ResourcesUtils.getDefaultBackgroundColor(view2.getResources()), PorterDuff.Mode.SRC_IN));
            }
        }
        if (this.mVoiceRuntime == null) {
            View view3 = this.mVoiceContainer;
            this.mVoiceRuntime = view3 != null ? (TextView) view3.findViewById(C8003R.id.voice_time) : null;
        }
        TextView textView = this.mVoiceRuntime;
        if (textView != null) {
            if (8 <= voiceRuntime.length() && StringsKt.m14145S(voiceRuntime, "00:")) {
                voiceRuntime = voiceRuntime.substring(StringsKt.m14129C(":", 0, 6, voiceRuntime));
                Intrinsics.checkNotNullExpressionValue(voiceRuntime, "substring(...)");
            }
            textView.setText(voiceRuntime);
            textView.setTextColor(textView.getResources().getColor(C8003R.color.noteslist_item_extra_voice_icon_text_blur_chip, null));
        }
        if (this.mVoiceIcon == null) {
            View view4 = this.mVoiceContainer;
            this.mVoiceIcon = view4 != null ? (ImageView) view4.findViewById(C8003R.id.voice_icon) : null;
        }
        ImageView imageView = this.mVoiceIcon;
        if (imageView != null) {
            imageView.setImageResource(C8003R.drawable.ic_voice_blur_chip);
            ViewCompat companion = ViewCompat.INSTANCE.getInstance();
            View view5 = this.mVoiceContainer;
            Intrinsics.checkNotNull(view5);
            companion.setTooltipText(imageView, view5.getContext().getText(C8003R.string.notes_icon_voice));
        }
    }
}
