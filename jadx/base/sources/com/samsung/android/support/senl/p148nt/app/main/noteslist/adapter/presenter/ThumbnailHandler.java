package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.bitmap.BitmapInfo;
import com.samsung.android.support.senl.p148nt.app.common.bitmap.BitmapManager;
import com.samsung.android.support.senl.p148nt.app.common.listener.ThumbnailHoverListener;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ThumbnailBitmapUtil;
import com.samsung.android.support.senl.p148nt.app.common.widget.HoverPopupTextView;
import com.samsung.android.support.senl.p148nt.app.main.common.data.HighlightText;
import com.samsung.android.support.senl.p148nt.app.main.common.exception.DisplayDataException;
import com.samsung.android.support.senl.p148nt.app.main.common.view.ImageScaleView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo.NotesHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.utils.ThumbnailColorUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.utils.ThumbnailPathUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view.ComposedView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view.ThumbnailContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.util.NotesHolderUtil;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.document.save.CoverThumbnailCreator;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ThumbnailHandler implements ThumbnailHoverListener.HoverRecyclerViewHolderListener {
    private final BitmapManager mBitmapManager = new BitmapManager();
    private final ComposedView mComposedView;
    private final HolderListener mHolderListener;
    private final NotesHolderInfo mNotesHolderInfo;
    private final ThumbnailContract mThumbnailContract;
    private final ThumbnailHoverListener mThumbnailHoverListener;

    public ThumbnailHandler(ThumbnailContract thumbnailContract, HolderListener holderListener, NotesHolderInfo notesHolderInfo, View view) {
        this.mThumbnailContract = thumbnailContract;
        this.mNotesHolderInfo = notesHolderInfo;
        this.mHolderListener = holderListener;
        this.mComposedView = new ComposedView(view, holderListener.getViewMode(), thumbnailContract);
        this.mThumbnailHoverListener = new ThumbnailHoverListener(this, holderListener.getViewMode());
    }

    private void enableForegroundDim(boolean z) {
        if (FeatureUtils.isRecyclebinMode(this.mHolderListener.getModeIndex())) {
            z = false;
        }
        if (this.mComposedView.hasNotTextContentView()) {
            return;
        }
        NotesHolderUtil.applyTextOnlyThumbnailFgDim((View) this.mComposedView.getTextContentView().getParent(), z, ThumbnailColorUtils.getBackgroundColor(this.mNotesHolderInfo, getResources()));
    }

    private Resources getResources() {
        return this.mThumbnailContract.getResources();
    }

    private String getTag() {
        return this.mThumbnailContract.getTag();
    }

    private int getViewMode() {
        return this.mHolderListener.getViewMode();
    }

    private boolean hasTemplateOrPdfBackground(MainListDocumentData mainListDocumentData) {
        return mainListDocumentData.getBackgroundType() > 0;
    }

    private boolean isLandscapePage(MainListDocumentData mainListDocumentData) {
        return mainListDocumentData.getLayout() == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$decorateExtra$0(MainListDocumentData mainListDocumentData, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mNotesHolderInfo.setIsVoiceChanged(false);
        if (mainListDocumentData.getUuid().equals(this.mNotesHolderInfo.getPrevUuid())) {
            if (z) {
                this.mComposedView.decorateRoundFavoriteShape(z2, true);
            }
            if (z3) {
                this.mComposedView.decorateVoiceAnimation(z4, true, z2);
            }
            if (z5) {
                this.mComposedView.decorateLockAnimation(z6, true, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$decorateExtra$1(MainListDocumentData mainListDocumentData, boolean z, boolean z2, boolean z3, boolean z4) {
        if (mainListDocumentData.getUuid().equals(this.mNotesHolderInfo.getPrevUuid())) {
            if (z) {
                this.mComposedView.decorateFavoriteAnimation(z2, true);
            }
            if (z3) {
                this.mComposedView.decorateLockThumbnailAnimation(z4, true);
            }
        }
    }

    private void setThumbnailHolder(ImageView imageView, String str, int i) {
        String tag = getTag();
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "setThumbnailHolder# modeIndex : ", " LastModifiedAt : ");
        sbM778t.append(this.mNotesHolderInfo.getLastModifiedAt());
        sbM778t.append(" hashCode : ");
        sbM778t.append(this.mNotesHolderInfo.hashCode());
        MainLogger.m7258i(tag, sbM778t.toString());
        if (this.mNotesHolderInfo.getPrevUuid() != null && this.mNotesHolderInfo.getPrevUuid().equals(this.mNotesHolderInfo.getUuid())) {
            if (!str.equals(this.mBitmapManager.getFilePath(imageView, str))) {
                this.mBitmapManager.clearAsyncDrawable(imageView);
            } else if (!FeatureUtils.isCoeditMode(i) && !FeatureUtils.isCoeditSpaceMode(i) && this.mNotesHolderInfo.getLastModifiedAt() == this.mBitmapManager.getModifiedAt(imageView, str)) {
                try {
                    BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
                    if (bitmapDrawable != null && bitmapDrawable.getBitmap() != null && !this.mNotesHolderInfo.isForceUpdate()) {
                        MainLogger.m7258i(getTag(), "setThumbnailHolder# Do not load because it is same thumbnail");
                        return;
                    }
                } catch (ClassCastException e) {
                    MainLogger.m7255e(getTag(), "setThumbnailHolder# VectorDrawable lock icon used on simple view : " + e.getMessage());
                }
            }
        }
        boolean zIsBlurView = isBlurView();
        this.mBitmapManager.onLoadImage(new BitmapInfo.BitmapInfoSetBuilder().setViewHolderInfo(imageView).setFilePathInfo(str).setViewModeInfo(getViewMode()).setLastModifiedAtInfo(this.mNotesHolderInfo.getLastModifiedAt()).setBlurViewInfo(zIsBlurView ? this.mComposedView.getBlurView() : null).setBackgroundColorInfo(zIsBlurView ? ThumbnailColorUtils.getBackgroundColor(this.mNotesHolderInfo, getResources()) : -1).setNeedSetRatioInfo(ThumbnailType.isImageRatioUsedMode(this.mComposedView.getType())).build());
    }

    private void setThumbnailHover(String str) {
        NotesHolderInfo notesHolderInfo = this.mNotesHolderInfo;
        if (ThumbnailType.isGridTextImageOnly(this.mComposedView.getType())) {
            str = ThumbnailPathUtils.getThumbnailFilePath(this.mNotesHolderInfo.getUuid(), this.mNotesHolderInfo.isDarkMode(), this.mNotesHolderInfo.isSupportInvertedBGColor());
        }
        notesHolderInfo.setHoverThumbnailFilePath(str);
        ImageView imageContentView = this.mComposedView.getImageContentView();
        if (imageContentView != null) {
            imageContentView.setOnHoverListener(this.mThumbnailHoverListener);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.common.listener.ThumbnailHoverListener.HoverRecyclerViewHolderListener
    public int backgroundColor() {
        return this.mNotesHolderInfo.getBackgroundColor();
    }

    public void checkTextContent(MainListDocumentData mainListDocumentData) {
        CharSequence charSequenceSubSequenceContent;
        boolean z = false;
        if (mainListDocumentData == null) {
            this.mNotesHolderInfo.setHasTextContents(false);
            return;
        }
        try {
            charSequenceSubSequenceContent = NotesHolderUtil.getDisplayContent(mainListDocumentData.getDisplayContent());
        } catch (DisplayDataException unused) {
            charSequenceSubSequenceContent = subSequenceContent(mainListDocumentData.getContent());
        }
        NotesHolderInfo notesHolderInfo = this.mNotesHolderInfo;
        if (!TextUtils.isEmpty(charSequenceSubSequenceContent) && (charSequenceSubSequenceContent.length() != 1 || (charSequenceSubSequenceContent.charAt(0) != '\n' && charSequenceSubSequenceContent.charAt(0) != ' '))) {
            z = true;
        }
        notesHolderInfo.setHasTextContents(z);
    }

    public void clearThumbnailHolder() {
        ImageView imageContentView = this.mComposedView.getImageContentView();
        if (imageContentView != null) {
            this.mBitmapManager.clearAsyncDrawable(imageContentView);
            imageContentView.setOnHoverListener(null);
            ThumbnailBitmapUtil.recycleBitmap(imageContentView);
            imageContentView.setImageBitmap(null);
            if (isBlurView()) {
                ((ImageScaleView) imageContentView).onViewRecycled();
            }
        }
    }

    public Bitmap createTextBitmap(ImageView imageView, MainListDocumentData mainListDocumentData) {
        MainLogger.m7254d(getTag(), "createTextBitmap for old note (.sdoc)");
        Context context = imageView.getContext();
        imageView.setVisibility(0);
        imageView.setColorFilter(0);
        int iWidth = DisplayUtils.getScreenDimension(context).width() / 2;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(iWidth, iWidth));
        frameLayout.layout(0, 0, iWidth, iWidth);
        frameLayout.setBackgroundColor(0);
        TextView textView = new TextView(context);
        textView.setTextColor(getResources().getColor(C8003R.color.noteslist_item_text_content_color, null));
        try {
            textView.setText(NotesHolderUtil.getDisplaySpan(context, NotesHolderUtil.getDisplayContent(mainListDocumentData.getDisplayContent()), true, 0, this.mNotesHolderInfo.isDarkMode(), false, getViewMode() == 4, 0));
        } catch (DisplayDataException e) {
            MainLogger.m7255e(getTag(), "createTextBitmap# uuid : " + mainListDocumentData.getUuid() + SQLKeyword.COMMA + e.getMessage());
            textView.setText(subSequenceContent(mainListDocumentData.getContent()));
        }
        textView.setLayoutParams(new FrameLayout.LayoutParams(iWidth, iWidth));
        frameLayout.addView(textView);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iWidth, 1073741824);
        frameLayout.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        frameLayout.layout(0, 0, frameLayout.getMeasuredWidth(), frameLayout.getMeasuredHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(frameLayout.getWidth(), frameLayout.getHeight(), Bitmap.Config.ARGB_8888);
        frameLayout.draw(new Canvas(bitmapCreateBitmap));
        imageView.setImageBitmap(bitmapCreateBitmap);
        imageView.setScaleType(ImageView.ScaleType.FIT_START);
        return bitmapCreateBitmap;
    }

    public void decorateExtra(final MainListDocumentData mainListDocumentData) {
        this.mComposedView.decorateExtra(mainListDocumentData, this.mNotesHolderInfo.getDateText());
        final boolean zIsLock = NotesUtils.isLock(this.mNotesHolderInfo.getLockType());
        final boolean zBooleanValue = this.mNotesHolderInfo.isVoice().booleanValue();
        final boolean zBooleanValue2 = this.mNotesHolderInfo.isFavorite().booleanValue();
        if (zBooleanValue) {
            boolean z = isNeedVoiceGradient(mainListDocumentData.getPlayTime()) && !(isCoverThumbnailEnabled(mainListDocumentData) && ContentUtils.isGridViewMode(getViewMode()));
            boolean zHasTemplateOrPdfBackground = hasTemplateOrPdfBackground(mainListDocumentData);
            if (this.mComposedView.getCoverType() == 8) {
                Context context = this.mThumbnailContract.getContext();
                int coverChipBackgroundColor = CoverEditorUtils.getCoverChipBackgroundColor(context, mainListDocumentData.getCoverBackgroundColor(), mainListDocumentData.getCoverTemplateUuid());
                if (CoverEditorUtils.needToApplyWhiteColor(mainListDocumentData.getCoverBackgroundColor(), mainListDocumentData.getCoverTemplateUuid())) {
                    this.mComposedView.decorateExtraBackground(z, zHasTemplateOrPdfBackground, coverChipBackgroundColor, context.getColor(C8003R.color.cover_summary_white_text_color));
                } else {
                    this.mComposedView.decorateExtraBackground(z, zHasTemplateOrPdfBackground, coverChipBackgroundColor);
                }
            } else {
                this.mComposedView.decorateExtraBackground(z, zHasTemplateOrPdfBackground, ThumbnailColorUtils.getBackgroundColor(this.mNotesHolderInfo, getResources()));
            }
        }
        Boolean boolIsPrevVoice = this.mNotesHolderInfo.isPrevVoice();
        Boolean boolIsPrevFavorite = this.mNotesHolderInfo.isPrevFavorite();
        final boolean z2 = (boolIsPrevVoice == null || zBooleanValue == boolIsPrevVoice.booleanValue()) ? false : true;
        final boolean z3 = zIsLock != NotesUtils.isLock(this.mNotesHolderInfo.isPrevLockType());
        final boolean z4 = (boolIsPrevFavorite == null || zBooleanValue2 == boolIsPrevFavorite.booleanValue()) ? false : true;
        boolean z5 = (z2 || z3 || z4) && mainListDocumentData.getUuid().equals(this.mNotesHolderInfo.getPrevUuid());
        if (!this.mComposedView.isRoundedViewUsed()) {
            boolean z6 = z5;
            final boolean z7 = z3 && (getViewMode() == 3);
            if (!z6 || (!z4 && !z7)) {
                this.mComposedView.decorateFavoriteAnimation(zBooleanValue2, false);
                this.mComposedView.decorateLockThumbnailAnimation(zIsLock, false);
                return;
            }
            ComposedView composedView = this.mComposedView;
            if (!z4) {
                z = zBooleanValue2;
            } else if (zBooleanValue2) {
                z = false;
            }
            composedView.decorateFavoriteAnimation(z, false);
            if (z7 && zIsLock) {
                this.mComposedView.decorateLockThumbnailAnimation(false, false);
            }
            this.mHolderListener.registerNoteAnimation(new Runnable() { // from class: N2.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f579a.lambda$decorateExtra$1(mainListDocumentData, z4, zBooleanValue2, z7, zIsLock);
                }
            });
            return;
        }
        if (!z5) {
            if (zIsLock) {
                this.mComposedView.hideAllView();
                this.mComposedView.decorateRoundFavoriteShape(zBooleanValue2, false);
                return;
            } else {
                this.mComposedView.decorateRoundFavoriteShape(zBooleanValue2, false);
                this.mComposedView.decorateVoiceAnimation(!this.mNotesHolderInfo.isVoiceChanged() && zBooleanValue, false, zBooleanValue2);
                return;
            }
        }
        if (z3) {
            if (getViewMode() == 1) {
                if (this.mNotesHolderInfo.hasBackgroundColor()) {
                    if (zIsLock) {
                        this.mComposedView.hideAllView();
                        return;
                    } else {
                        this.mComposedView.decorateRoundFavoriteShape(zBooleanValue2, false);
                        this.mComposedView.decorateVoiceAnimation(zBooleanValue, false, zBooleanValue2);
                        return;
                    }
                }
                if (zIsLock) {
                    this.mComposedView.decorateLockAnimation(false, false, zBooleanValue2);
                    this.mComposedView.getLockBackground().setTranslationX(0.0f);
                    this.mComposedView.getLockBackground().setAlpha(0.0f);
                    this.mComposedView.getLockIcon().setScaleX(0.0f);
                    this.mComposedView.getLockIcon().setScaleY(0.0f);
                } else {
                    this.mComposedView.hideContentsWithUnlockAnimation();
                }
                if (z4) {
                    this.mComposedView.decorateRoundFavoriteShape(zBooleanValue2, true);
                }
                if (z2) {
                    this.mComposedView.decorateVoiceAnimation(zBooleanValue, true, zBooleanValue2);
                }
                this.mComposedView.decorateLockAnimation(zIsLock, true, zBooleanValue2);
                return;
            }
            if (zIsLock) {
                this.mComposedView.decorateLockAnimation(false, false, zBooleanValue2);
                this.mComposedView.getLockBackground().setTranslationX(0.0f);
                this.mComposedView.getLockBackground().setAlpha(0.0f);
                this.mComposedView.getLockIcon().setScaleX(0.0f);
                this.mComposedView.getLockIcon().setScaleY(0.0f);
            }
        } else if (z2) {
            this.mNotesHolderInfo.setIsVoiceChanged(true);
            this.mComposedView.decorateVoiceAnimation(false, false, zBooleanValue2);
        } else if (zIsLock) {
            this.mComposedView.hideAllView();
        }
        this.mHolderListener.registerNoteAnimation(new Runnable() { // from class: N2.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f571a.lambda$decorateExtra$0(mainListDocumentData, z4, zBooleanValue2, z2, zBooleanValue, z3, zIsLock);
            }
        });
    }

    public void decorateOldNoteThumbnail(MainListDocumentData mainListDocumentData, HighlightText highlightText) {
        CharSequence displayContent;
        String sdocThumbnailFilePath;
        int iIntValue = mainListDocumentData.getFirstContentType().intValue();
        int iIntValue2 = mainListDocumentData.getSecondContentType().intValue();
        AbstractC8014b.m7200b(iIntValue, iIntValue2, "decorateOldNoteThumbnail# firstContentType : ", ", secondContentType : ", getTag());
        try {
            displayContent = NotesHolderUtil.getDisplayContent(mainListDocumentData.getDisplayContent());
        } catch (DisplayDataException e) {
            CharSequence charSequenceSubSequenceContent = subSequenceContent(mainListDocumentData.getContent());
            MainLogger.m7255e(getTag(), "decorateOldNoteThumbnail# uuid : " + mainListDocumentData.getUuid() + SQLKeyword.COMMA + e.getMessage());
            displayContent = charSequenceSubSequenceContent;
        }
        boolean z = (TextUtils.isEmpty(displayContent) || (displayContent.length() == 1 && displayContent.charAt(0) == '\n')) ? false : true;
        if (z) {
            setTextContents(displayContent, highlightText, false);
        }
        int viewMode = getViewMode();
        if (z || iIntValue == 0) {
            iIntValue = iIntValue2;
        }
        if (3 == iIntValue) {
            this.mNotesHolderInfo.setHasOnlyHandwritingSdoc(true);
            sdocThumbnailFilePath = ThumbnailPathUtils.getSdocHWThumbnailFilePath(mainListDocumentData.getStrokeUuid(), viewMode);
        } else {
            sdocThumbnailFilePath = iIntValue != 0 ? ThumbnailPathUtils.getSdocThumbnailFilePath(mainListDocumentData.getContentUuid()) : null;
        }
        if (sdocThumbnailFilePath == null) {
            this.mComposedView.hideImageView();
            return;
        }
        decorateThumbnail(sdocThumbnailFilePath, 0);
        if (z && !this.mComposedView.hasNotTextContentView() && ContentUtils.isGridViewMode(viewMode)) {
            HoverPopupTextView textContentView = this.mComposedView.getTextContentView();
            textContentView.setVisibility(0);
            if (viewMode == 4) {
                textContentView.setTextSize(0, textContentView.getResources().getDimensionPixelSize(C8003R.dimen.notes_small_grid_item_text_content_size));
            }
            textContentView.setMaxLines(getResources().getInteger(C8003R.integer.noteslist_grid_old_text_max_lines));
            textContentView.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public View decorateSearchExtra(String str, String str2, int i) {
        return this.mComposedView.decorateSearchExtra(str, str2, i);
    }

    public void decorateTextContent(MainListDocumentData mainListDocumentData, HighlightText highlightText) {
        CharSequence displayContent;
        try {
            displayContent = NotesHolderUtil.getDisplayContent(mainListDocumentData.getDisplayContent());
        } catch (DisplayDataException e) {
            CharSequence charSequenceSubSequenceContent = subSequenceContent(mainListDocumentData.getContent());
            MainLogger.m7255e(getTag(), "decorateTextContent# uuid : " + mainListDocumentData.getUuid() + SQLKeyword.COMMA + e.getMessage());
            displayContent = charSequenceSubSequenceContent;
        }
        setTextContents(displayContent, highlightText, true);
    }

    public void decorateThumbnail(String str, int i) {
        if (this.mComposedView.hasImageContentView()) {
            ImageView imageContentView = this.mComposedView.getImageContentView();
            imageContentView.setVisibility(0);
            MainLogger.m7258i(getTag(), "loadThumbnail# filePath : " + MainLogger.getEncode(str) + ", isNightMode : " + this.mNotesHolderInfo.isDarkMode() + ", isSupportInvertedBGColor : " + this.mNotesHolderInfo.isSupportInvertedBGColor());
            ThumbnailColorUtils.setThumbnailColorFilter(imageContentView, this.mNotesHolderInfo);
            if (ThumbnailPathUtils.isExistFilePath(str)) {
                if (ThumbnailType.isLayoutModeLandScape(this.mComposedView.getType())) {
                    imageContentView.setScaleType(ImageView.ScaleType.MATRIX);
                } else if (ThumbnailType.isLayoutModePortrait(this.mComposedView.getType())) {
                    this.mHolderListener.setThumbnailScale(imageContentView, str);
                    imageContentView.setScaleType(ImageView.ScaleType.FIT_XY);
                } else {
                    this.mHolderListener.setThumbnailScale(imageContentView, str);
                }
                setThumbnailHolder(imageContentView, str, i);
            } else {
                clearThumbnailHolder();
                MainLogger.m7258i(getTag(), "loadThumbnail# No thumbnail");
            }
            setThumbnailHover(str);
        }
    }

    public ImageView getImageContentView() {
        return this.mComposedView.getImageContentView();
    }

    @Override // com.samsung.android.support.senl.nt.app.common.listener.ThumbnailHoverListener.HoverRecyclerViewHolderListener
    public Drawable getImageDrawableImpl() {
        return this.mNotesHolderInfo.getImageDrawableImpl();
    }

    @Override // com.samsung.android.support.senl.nt.app.common.listener.ThumbnailHoverListener.HoverRecyclerViewHolderListener
    /* JADX INFO: renamed from: getItemView */
    public View get$itemView() {
        return this.mNotesHolderInfo.getRootCardView();
    }

    public View getLockBackground() {
        return this.mComposedView.getLockBackground();
    }

    public View getLockIcon() {
        return this.mComposedView.getLockIcon();
    }

    public String getTitle() {
        return this.mComposedView.getTitle();
    }

    public boolean hasImageContentView() {
        return this.mComposedView.hasImageContentView();
    }

    public boolean hasImagePage(MainListDocumentData mainListDocumentData) {
        return (TextUtils.isEmpty(mainListDocumentData.getImgObjectPathInThumbnailPage()) || hasTemplateOrPdfBackground(mainListDocumentData)) ? false : true;
    }

    public boolean hasOldNoteImageContent(MainListDocumentData mainListDocumentData, boolean z) {
        String sdocThumbnailFilePath;
        int iIntValue = mainListDocumentData.getFirstContentType().intValue();
        int iIntValue2 = mainListDocumentData.getSecondContentType().intValue();
        if (z || iIntValue == 0) {
            iIntValue = iIntValue2;
        }
        if (3 == iIntValue) {
            this.mNotesHolderInfo.setHasOnlyHandwritingSdoc(true);
            sdocThumbnailFilePath = ThumbnailPathUtils.getSdocHWThumbnailFilePath(mainListDocumentData.getStrokeUuid(), getViewMode());
        } else {
            sdocThumbnailFilePath = iIntValue != 0 ? ThumbnailPathUtils.getSdocThumbnailFilePath(mainListDocumentData.getContentUuid()) : null;
        }
        return !TextUtils.isEmpty(sdocThumbnailFilePath);
    }

    @Override // com.samsung.android.support.senl.nt.app.common.listener.ThumbnailHoverListener.HoverRecyclerViewHolderListener
    public boolean hasOnlyHandwritingSdoc() {
        return this.mNotesHolderInfo.hasOnlyHandwritingSdoc();
    }

    public void hideImageView() {
        this.mComposedView.hideImageView();
    }

    public void inflateTextContentView() {
        this.mComposedView.inflateTextContentView();
    }

    public void inflateThumbnail(MainListDocumentData mainListDocumentData) {
        int viewMode = getViewMode();
        boolean zIsSimpleViewMode = ContentUtils.isSimpleViewMode(viewMode);
        boolean zIsGridViewMode = ContentUtils.isGridViewMode(viewMode);
        boolean zIsLock = NotesUtils.isLock(this.mNotesHolderInfo.getLockType());
        String uuid = mainListDocumentData.getUuid();
        int i = 6;
        int i2 = 3;
        if (zIsLock) {
            this.mComposedView.setCoverType(viewMode == 3 ? 21 : (viewMode == 1 || viewMode == 6) ? 18 : 7);
        } else if (isCoverThumbnailEnabled(mainListDocumentData)) {
            this.mComposedView.setCoverType(viewMode == 3 ? 22 : zIsGridViewMode ? 8 : 19);
        } else {
            this.mComposedView.setCoverType(-1);
        }
        int i4 = 20;
        int i5 = zIsGridViewMode ? viewMode == 4 ? 9 : 1 : zIsSimpleViewMode ? 20 : 16;
        if (this.mNotesHolderInfo.isSdoc()) {
            boolean zHasOldNoteImageContent = hasOldNoteImageContent(mainListDocumentData, this.mNotesHolderInfo.hasTextContents());
            if (!this.mNotesHolderInfo.hasTextContents() || zHasOldNoteImageContent) {
                ComposedView composedView = this.mComposedView;
                if (zIsGridViewMode) {
                    i4 = viewMode == 4 ? 10 : 2;
                } else if (!zIsSimpleViewMode) {
                    i4 = 15;
                }
                composedView.setType(i4);
            } else {
                this.mComposedView.setType(i5);
            }
        } else if (this.mNotesHolderInfo.hasTextOnly()) {
            this.mComposedView.setType(i5);
        } else if (hasTemplateOrPdfBackground(mainListDocumentData)) {
            if (isLandscapePage(mainListDocumentData)) {
                ComposedView composedView2 = this.mComposedView;
                if (zIsGridViewMode) {
                    i4 = viewMode == 4 ? 13 : 5;
                } else if (!zIsSimpleViewMode) {
                    i4 = 15;
                }
                composedView2.setType(i4);
            } else {
                ComposedView composedView3 = this.mComposedView;
                if (!zIsGridViewMode) {
                    i = zIsSimpleViewMode ? 20 : 15;
                } else if (viewMode == 4) {
                    i = 14;
                }
                composedView3.setType(i);
            }
        } else if (TextUtils.isEmpty(ThumbnailPathUtils.getThumbnailFilePath(uuid, this.mNotesHolderInfo.isDarkMode(), this.mNotesHolderInfo.isSupportInvertedBGColor()))) {
            this.mComposedView.setType(i5);
        } else if (hasImagePage(mainListDocumentData)) {
            ComposedView composedView4 = this.mComposedView;
            if (zIsSimpleViewMode) {
                i2 = 20;
            } else if (!zIsGridViewMode) {
                i2 = 17;
            } else if (viewMode == 4) {
                i2 = 11;
            }
            composedView4.setType(i2);
        } else {
            ComposedView composedView5 = this.mComposedView;
            if (zIsGridViewMode) {
                i4 = viewMode == 4 ? 12 : 4;
            } else if (!zIsSimpleViewMode) {
                i4 = 15;
            }
            composedView5.setType(i4);
        }
        this.mComposedView.inflateThumbnail(uuid, this.mHolderListener.isUnlockConverting(uuid), this.mHolderListener.getCoverThumbnailType());
        this.mHolderListener.setThumbnailBackgroundColor(zIsLock, this.mNotesHolderInfo.isVoice().booleanValue(), mainListDocumentData.getPlayTime());
        enableForegroundDim(ThumbnailType.isGridTextOnly(this.mComposedView.getType()) && !this.mNotesHolderInfo.isVoice().booleanValue());
    }

    public void initView() {
        this.mComposedView.init();
    }

    public boolean isBlurView() {
        return ThumbnailType.isGridTextImageOnly(this.mComposedView.getType()) && this.mNotesHolderInfo.hasTextContents();
    }

    public boolean isCoverThumbnailEnabled(MainListDocumentData mainListDocumentData) {
        if (!mainListDocumentData.isCoverEnabled()) {
            return false;
        }
        int coverState = mainListDocumentData.getCoverState();
        int coverState2 = mainListDocumentData.getCoverState();
        if (coverState2 == -2 || coverState2 == 4 || coverState2 == 1 || coverState2 == 2) {
            return CoverThumbnailCreator.isExistCoverFile(this.mThumbnailContract.getContext(), mainListDocumentData.getUuid(), this.mHolderListener.getCoverThumbnailType());
        }
        AbstractC6670b.m4736A(coverState, "decorate# coverState : ", getTag());
        return false;
    }

    public boolean isListTextImageOnlyMode() {
        return this.mComposedView.getType() != 17;
    }

    public boolean isNeedVoiceGradient(String str) {
        if (TextUtils.isEmpty(str) || this.mNotesHolderInfo.hasBackgroundColor()) {
            return false;
        }
        return ThumbnailType.isGridTextOnly(this.mComposedView.getType()) || ThumbnailType.isListTextOnly(this.mComposedView.getType());
    }

    @Override // com.samsung.android.support.senl.nt.app.common.listener.ThumbnailHoverListener.HoverRecyclerViewHolderListener
    public boolean isSdoc() {
        return this.mNotesHolderInfo.isSdoc();
    }

    @Override // com.samsung.android.support.senl.nt.app.common.listener.ThumbnailHoverListener.HoverRecyclerViewHolderListener
    public boolean isSupportInvertedBGColor() {
        return this.mNotesHolderInfo.isSupportInvertedBGColor();
    }

    public void postUpdateListViewLayout() {
        this.mComposedView.postUpdateListViewLayout();
    }

    public void removeListViewAllCallbacks() {
        this.mComposedView.removeListViewAllCallbacks();
    }

    public void requestLayout(int i) {
        HoverPopupTextView textContentView;
        if (!ThumbnailType.isGridTextImageOnly(this.mComposedView.getType()) || (textContentView = this.mComposedView.getTextContentView()) == null) {
            return;
        }
        int viewMode = getViewMode();
        Resources resources = textContentView.getResources();
        int dimensionPixelSize = (i - resources.getDimensionPixelSize(viewMode == 4 ? C8003R.dimen.notes_small_grid_item_text_content_margin_top : C8003R.dimen.notes_grid_item_text_content_margin_top)) - resources.getDimensionPixelSize(viewMode == 4 ? C8003R.dimen.notes_small_grid_item_text_content_margin_bottom : C8003R.dimen.notes_grid_item_text_content_margin_bottom);
        if (isBlurView()) {
            dimensionPixelSize /= 2;
        }
        int lineHeight = dimensionPixelSize % textContentView.getLineHeight();
        int lineHeight2 = dimensionPixelSize / textContentView.getLineHeight();
        if (lineHeight > textContentView.getLineHeight() / 4) {
            lineHeight2++;
        }
        if (lineHeight2 != textContentView.getMaxLines()) {
            textContentView.setMaxLines(lineHeight2);
            textContentView.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public void setAutoTitle(MainListDocumentData mainListDocumentData, HighlightText highlightText, int i) {
        this.mComposedView.setAutoTitle(mainListDocumentData, highlightText, i);
    }

    public void setClipToOutline() {
        this.mComposedView.setClipToOutline();
    }

    public void setCoeditAutoTitle(MainListDocumentData mainListDocumentData, HighlightText highlightText, int i) {
        this.mComposedView.setCoeditAutoTitle(mainListDocumentData, highlightText, i);
    }

    public void setLockState(boolean z) {
        this.mComposedView.setLockState(z);
    }

    public void setTextContents(CharSequence charSequence, HighlightText highlightText, boolean z) {
        if (this.mComposedView.hasNotTextContentView()) {
            return;
        }
        HoverPopupTextView textContentView = this.mComposedView.getTextContentView();
        MainLogger.m7254d(getTag(), "setTextContents# isNightMode : " + this.mNotesHolderInfo.isDarkMode() + ", isSupportInvertedBGColor : " + this.mNotesHolderInfo.isSupportInvertedBGColor());
        int type = this.mComposedView.getType();
        if (charSequence == null || charSequence.length() <= 0 || type == 15) {
            textContentView.setVisibility(8);
            return;
        }
        textContentView.setVisibility(0);
        boolean z2 = getViewMode() == 4;
        boolean zIsGridTextImageOnly = ThumbnailType.isGridTextImageOnly(type);
        int color = getResources().getColor(C8003R.color.noteslist_item_title_color_white, null);
        textContentView.setOriginalText(NotesHolderUtil.setHighlightText(textContentView, new SpannableString(NotesHolderUtil.getDisplaySpan(textContentView.getContext(), charSequence, this.mNotesHolderInfo.isSdoc(), this.mNotesHolderInfo.getBackgroundColor(), this.mNotesHolderInfo.isDarkMode(), this.mNotesHolderInfo.isSupportInvertedBGColor(), z2, zIsGridTextImageOnly ? color : 0)), highlightText == null ? new ArrayList<>() : highlightText.getHighlightText()), this.mNotesHolderInfo.getBackgroundColor(), this.mNotesHolderInfo.isSdoc(), this.mNotesHolderInfo.isSupportInvertedBGColor(), z, !zIsGridTextImageOnly);
        if (zIsGridTextImageOnly && z2) {
            textContentView.setTextSize(0, textContentView.getResources().getDimensionPixelSize(C8003R.dimen.notes_small_grid_item_text_content_size));
        }
        textContentView.setLineSpacing(getResources().getDimensionPixelSize(z2 ? C8003R.dimen.noteslist_small_grid_item_line_spacing_extra : C8003R.dimen.noteslist_item_title_line_spacing_extra), 1.0f);
        if (!zIsGridTextImageOnly) {
            color = NotesHolderUtil.getTextContentsColor(textContentView.getContext(), this.mNotesHolderInfo.isSupportInvertedBGColor(), this.mNotesHolderInfo.isSdoc(), NotesUtils.isLock(this.mNotesHolderInfo.getLockType()), this.mNotesHolderInfo.getBackgroundColor());
        }
        textContentView.setTextColor(color);
    }

    public void setTitle(CharSequence charSequence, HighlightText highlightText, int i) {
        this.mComposedView.setTitle(charSequence, highlightText, i);
    }

    public CharSequence subSequenceContent(CharSequence charSequence) {
        return charSequence.length() > 300 ? charSequence.subSequence(0, 300) : charSequence;
    }
}
