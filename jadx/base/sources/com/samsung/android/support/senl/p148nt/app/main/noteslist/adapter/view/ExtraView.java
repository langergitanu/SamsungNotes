package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.content.res.ResourcesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.data.RepositoryManager;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.util.NotesHolderUtil;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ExtraView extends ViewGroup {
    static final int CATEGORY_COLOR_BLACK = 0;
    static final int CATEGORY_COLOR_NONE = -1;
    private static final String TAG = "ExtraView";
    private int mFavoriteIconSize;
    private ImageView mFavoriteView;
    private View mItemView;
    private LinearLayout mSdoc;
    private LinearLayout mSimpleFolderView;
    private ImageView mSyncNotSupported;
    private TextView mTimeView;
    private ImageView mVoiceIconView;
    private TextView mVoiceText;
    private View mVoiceView;
    private ImageView mWarningView;

    public ExtraView(Context context) {
        super(context);
        this.mFavoriteIconSize = -1;
    }

    private void addFavorite() {
        if (this.mFavoriteView == null) {
            this.mFavoriteView = (ImageView) ViewModeUtils.getInflatedView(this.mItemView, C8003R.id.favorite, C8003R.id.inflate_favorite);
            ViewCompat.getInstance().setTooltipText(this.mFavoriteView);
            Drawable drawable = this.mFavoriteView.getDrawable();
            if (drawable != null) {
                drawable.setAutoMirrored(true);
            }
            if (this.mFavoriteIconSize != -1) {
                ViewGroup.LayoutParams layoutParams = this.mFavoriteView.getLayoutParams();
                int i = this.mFavoriteIconSize;
                layoutParams.width = i;
                layoutParams.height = i;
                this.mFavoriteView.setLayoutParams(layoutParams);
            }
        }
        this.mFavoriteView.setVisibility(0);
    }

    private void addSdoc(MainListDocumentData mainListDocumentData) {
        if (this.mSdoc == null) {
            this.mSdoc = (LinearLayout) ViewModeUtils.getInflatedView(this.mItemView, C8003R.id.is_sdoc, C8003R.id.inflate_item_sdoc);
        }
        this.mSdoc.setVisibility(0);
        View viewFindViewById = this.mSdoc.findViewById(C8003R.id.mark_color_view);
        viewFindViewById.getBackground().setColorFilter(new PorterDuffColorFilter(getCategoryColor(viewFindViewById, mainListDocumentData), PorterDuff.Mode.SRC_ATOP));
    }

    private void addSyncNotSupported() {
        if (this.mSyncNotSupported == null) {
            ImageView imageView = (ImageView) ViewModeUtils.getInflatedView(this.mItemView, C8003R.id.sync_not_supported, C8003R.id.inflate_sync_not_supported);
            this.mSyncNotSupported = imageView;
            imageView.setContentDescription(imageView.getContext().getString(C8003R.string.notes_icon_sync_not_supported));
            ViewCompat.getInstance().setTooltipText(this.mSyncNotSupported);
        }
        this.mSyncNotSupported.setVisibility(0);
        MainLogger.m7254d(TAG, "addSyncNotSupported");
    }

    private void addTime(String str) {
        if (this.mTimeView == null) {
            this.mTimeView = (TextView) this.mItemView.findViewById(C8003R.id.time);
        }
        this.mTimeView.setText(str);
        this.mTimeView.setVisibility(0);
    }

    private void addVoice(String str) {
        if (TextUtils.isEmpty(str) || this.mFavoriteIconSize == -1) {
            this.mVoiceView = ViewModeUtils.getInflatedView(this.mItemView.findViewById(C8003R.id.extra), C8003R.id.voice, C8003R.id.inflate_voice);
        } else {
            this.mVoiceView = ViewModeUtils.getInflatedView(this.mItemView.findViewById(C8003R.id.thumbnail_container), C8003R.id.voice_chip, C8003R.id.inflate_voice_chip);
        }
        this.mVoiceView.setVisibility(0);
        TextView textView = (TextView) this.mVoiceView.findViewById(C8003R.id.voice_time);
        this.mVoiceText = textView;
        if (textView != null) {
            textView.setText(str);
        }
        ImageView imageView = (ImageView) this.mVoiceView.findViewById(C8003R.id.voice_icon);
        this.mVoiceIconView = imageView;
        if (imageView != null) {
            imageView.setContentDescription(this.mVoiceView.getContext().getString(C8003R.string.notes_icon_voice));
            ViewCompat.getInstance().setTooltipText(this.mVoiceIconView);
        }
    }

    private void addWarning() {
        if (this.mWarningView == null) {
            ImageView imageView = (ImageView) ViewModeUtils.getInflatedView(this.mItemView, C8003R.id.warning, C8003R.id.inflate_warning);
            this.mWarningView = imageView;
            imageView.setContentDescription(imageView.getContext().getString(C8003R.string.notes_icon_warning));
            ViewCompat.getInstance().setTooltipText(this.mWarningView);
        }
        this.mWarningView.setVisibility(0);
        MainLogger.m7254d(TAG, "addWarning");
    }

    private int getCategoryColor(View view, MainListDocumentData mainListDocumentData) {
        NotesFolder notesFolderFind = RepositoryManager.getInstance().getDocumentCategoryTree().find(mainListDocumentData.getAbsolutePath());
        if (notesFolderFind != null) {
            int displayNameColor = notesFolderFind.getDisplayNameColor();
            if (displayNameColor != 0 && displayNameColor != -1) {
                return displayNameColor;
            }
            if ("1".equals(notesFolderFind.getUuid()) || displayNameColor == -1) {
                return view.getContext().getResources().getColor(C8003R.color.category_mark_color_background_uncategorized, null);
            }
        }
        NotesFolder folderData = DataManager.getInstance().getFolderData(mainListDocumentData.getCategoryUuid());
        return (folderData == null || "1".equals(folderData.getUuid()) || folderData.getDisplayNameColor() == -1) ? view.getContext().getResources().getColor(C8003R.color.category_mark_color_background_uncategorized, null) : "2".equals(folderData.getUuid()) ? view.getContext().getResources().getColor(C8003R.color.category_mark_color_screen_off_memo, null) : folderData.getDisplayNameColor();
    }

    private void updateBlurVoiceChipBgColor(@ColorInt int i, boolean z, boolean z2) {
        if (this.mVoiceView == null || this.mVoiceText == null) {
            return;
        }
        LayerDrawable layerDrawable = (LayerDrawable) ResourcesCompat.getDrawable(getResources(), C8003R.drawable.notes_item_voice_blur_chip_background, null);
        if (layerDrawable == null) {
            this.mVoiceView.setBackground(null);
            return;
        }
        if (!z && z2) {
            Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(C8003R.id.voice_color_chip_background);
            if (drawableFindDrawableByLayerId != null) {
                drawableFindDrawableByLayerId.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
            }
            Drawable drawableFindDrawableByLayerId2 = layerDrawable.findDrawableByLayerId(C8003R.id.voice_color_chip_foreground);
            if (drawableFindDrawableByLayerId2 != null) {
                drawableFindDrawableByLayerId2.setColorFilter(new PorterDuffColorFilter(getResources().getColor(C8003R.color.noteslist_item_extra_voice_icon_blur_chip_dark, null), PorterDuff.Mode.SRC_IN));
            }
        } else if (!z) {
            Drawable drawableFindDrawableByLayerId3 = layerDrawable.findDrawableByLayerId(C8003R.id.voice_color_chip_background);
            if (drawableFindDrawableByLayerId3 != null) {
                drawableFindDrawableByLayerId3.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
            }
            Drawable drawableFindDrawableByLayerId4 = layerDrawable.findDrawableByLayerId(C8003R.id.voice_color_chip_foreground);
            if (drawableFindDrawableByLayerId4 != null) {
                drawableFindDrawableByLayerId4.setColorFilter(new PorterDuffColorFilter(getResources().getColor(C8003R.color.noteslist_item_extra_voice_icon_blur_chip, null), PorterDuff.Mode.SRC_IN));
            }
        }
        this.mVoiceView.setBackground(layerDrawable);
    }

    private void updateBlurVoiceIconColor(@ColorInt int i) {
        if (this.mVoiceIconView == null) {
            return;
        }
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), C8003R.drawable.ic_voice_blur_chip, null);
        if (drawable == null) {
            this.mVoiceIconView.setImageDrawable(null);
        } else {
            drawable.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
            this.mVoiceIconView.setImageDrawable(drawable);
        }
    }

    private void updateBlurVoiceTextColor(boolean z, boolean z2) {
        TextView textView = this.mVoiceText;
        if (textView == null) {
            return;
        }
        if (z || !z2) {
            textView.setTextColor(textView.getResources().getColor(C8003R.color.noteslist_item_extra_voice_icon_text_blur_chip, null));
        } else {
            textView.setTextColor(textView.getResources().getColor(C8003R.color.noteslist_item_extra_voice_icon_text_blur_chip_dark, null));
        }
    }

    private void updateColoredVoiceLayout() {
        View view = this.mVoiceView;
        if (view != null && this.mVoiceText != null) {
            view.setBackground(ResourcesCompat.getDrawable(getResources(), C8003R.drawable.notes_item_voice_color_chip_background, null));
        }
        ImageView imageView = this.mVoiceIconView;
        if (imageView != null) {
            imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), C8003R.drawable.ic_voice_color_chip, null));
        }
        TextView textView = this.mVoiceText;
        if (textView != null) {
            textView.setTextColor(textView.getResources().getColor(C8003R.color.noteslist_item_extra_voice_icon_text_color_chip, null));
        }
    }

    public void decorateExtraBackground(boolean z, boolean z2, @ColorInt int i) {
        if (z) {
            updateColoredVoiceLayout();
            return;
        }
        boolean zIsBlackNoteListCardViewColor = NotesHolderUtil.isBlackNoteListCardViewColor(getResources(), i);
        updateBlurVoiceChipBgColor(i, z2, zIsBlackNoteListCardViewColor);
        updateBlurVoiceIconColor(z2, zIsBlackNoteListCardViewColor);
        updateBlurVoiceTextColor(z2, zIsBlackNoteListCardViewColor);
    }

    public View decorateSearchExtra(String str, String str2, int i) {
        if (this.mSimpleFolderView == null) {
            this.mSimpleFolderView = (LinearLayout) ViewModeUtils.getInflatedView(this.mItemView, C8003R.id.simple_folder_layout, C8003R.id.inflate_simple_folder_layout);
        }
        int adjustedFolderDefaultColor = FolderUtils.getAdjustedFolderDefaultColor(i, this.mItemView.getContext());
        ImageView imageView = (ImageView) this.mItemView.findViewById(C8003R.id.folder_icon);
        if (imageView != null) {
            imageView.setColorFilter(new PorterDuffColorFilter(adjustedFolderDefaultColor, PorterDuff.Mode.SRC_IN));
        }
        TextView textView = (TextView) this.mItemView.findViewById(C8003R.id.folder_title);
        String prefixedFolderName = FolderUtils.getPrefixedFolderName(this.mItemView.getContext(), str);
        if (!TextUtils.isEmpty(prefixedFolderName)) {
            str2 = prefixedFolderName;
        }
        if (textView != null) {
            textView.setText(str2);
        }
        this.mSimpleFolderView.setContentDescription(str2);
        ViewCompat.getInstance().setTooltipText(this.mSimpleFolderView);
        this.mSimpleFolderView.setVisibility("coedit:///".equals(str) ? 8 : 0);
        return this.mSimpleFolderView;
    }

    public ImageView getFavoriteView() {
        return this.mFavoriteView;
    }

    public ImageView getVoiceIconView() {
        return this.mVoiceIconView;
    }

    public TextView getVoiceText() {
        return this.mVoiceText;
    }

    public View getVoiceView() {
        return this.mVoiceView;
    }

    public void init() {
        ImageView imageView = this.mFavoriteView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        View view = this.mVoiceView;
        if (view != null) {
            view.setVisibility(8);
        }
        LinearLayout linearLayout = this.mSdoc;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        ImageView imageView2 = this.mWarningView;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        ImageView imageView3 = this.mSyncNotSupported;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.mSimpleFolderView;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
    }

    public void setExtraData(MainListDocumentData mainListDocumentData, String str) {
        addTime(str);
        boolean z = true;
        if (mainListDocumentData.getIsFavorite() == 1) {
            addFavorite();
        }
        boolean zIsLock = NotesUtils.isLock(mainListDocumentData.getIsLock());
        boolean zIsWarning = NotesUtils.isWarning(mainListDocumentData.getCorrupted());
        if (!NotesUtils.isSyncNotSupported(mainListDocumentData.getSyncState()) && (mainListDocumentData.getSyncState() & 65536) != 65536) {
            z = false;
        }
        if (!zIsLock && mainListDocumentData.getVrUuid() != null && !mainListDocumentData.getVrUuid().isEmpty()) {
            addVoice(mainListDocumentData.getPlayTime());
        }
        if (mainListDocumentData.isSDoc()) {
            addSdoc(mainListDocumentData);
        }
        if (zIsWarning) {
            addWarning();
        } else if (z) {
            addSyncNotSupported();
        }
    }

    public ExtraView(View view, int i) {
        super(view.getContext());
        this.mItemView = view;
        this.mFavoriteIconSize = i;
    }

    private void updateBlurVoiceTextColor(@ColorInt int i) {
        TextView textView = this.mVoiceText;
        if (textView == null) {
            return;
        }
        textView.setTextColor(i);
    }

    public ExtraView(View view) {
        super(view.getContext());
        this.mFavoriteIconSize = -1;
        this.mItemView = view;
    }

    private void updateBlurVoiceIconColor(boolean z, boolean z2) {
        if (this.mVoiceIconView == null) {
            return;
        }
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), C8003R.drawable.ic_voice_blur_chip, null);
        if (drawable == null) {
            this.mVoiceIconView.setImageDrawable(null);
            return;
        }
        if (!z && z2) {
            drawable.setColorFilter(new PorterDuffColorFilter(this.mVoiceText.getResources().getColor(C8003R.color.noteslist_item_extra_voice_icon_text_blur_chip_dark, null), PorterDuff.Mode.SRC_IN));
        } else {
            drawable.setColorFilter(new PorterDuffColorFilter(this.mVoiceText.getResources().getColor(C8003R.color.noteslist_item_extra_voice_icon_text_blur_chip, null), PorterDuff.Mode.SRC_IN));
        }
        this.mVoiceIconView.setImageDrawable(drawable);
    }

    public void decorateExtraBackground(boolean z, boolean z2, @ColorInt int i, @ColorInt int i2) {
        if (z) {
            updateColoredVoiceLayout();
            return;
        }
        updateBlurVoiceChipBgColor(i, z2, NotesHolderUtil.isBlackNoteListCardViewColor(getResources(), i));
        updateBlurVoiceIconColor(i2);
        updateBlurVoiceTextColor(i2);
    }
}
