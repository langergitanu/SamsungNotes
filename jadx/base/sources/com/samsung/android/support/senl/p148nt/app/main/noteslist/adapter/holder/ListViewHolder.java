package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.data.HighlightText;
import com.samsung.android.support.senl.p148nt.app.main.common.exception.DisplayDataException;
import com.samsung.android.support.senl.p148nt.app.main.common.view.ImageScaleView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter.HolderListener;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter.ThumbnailHandler;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.utils.ThumbnailColorUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.utils.ThumbnailPathUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.util.NotesHolderUtil;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.document.save.CoverThumbnailCreator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ListViewHolder extends NotesHolder implements HolderListener {
    private static final String TAG = "ListViewHolder";
    private View mGradientView;
    private final ConstraintLayout mThumbnailContainer;

    public ListViewHolder(View view) {
        super(view, 1);
        this.mNotesHolderInfo.getRootCardView().setClipToOutline(true);
        this.mThumbnailContainer = (ConstraintLayout) view.findViewById(C8003R.id.thumbnail_container);
    }

    private void decorateListThumbnail(MainListDocumentData mainListDocumentData, HighlightText highlightText) {
        if (this.mThumbnailHandler.hasImagePage(mainListDocumentData)) {
            setTextContent(mainListDocumentData, highlightText);
            this.mThumbnailHandler.decorateThumbnail(mainListDocumentData.getImgObjectPathInThumbnailPage(), getModeIndex());
            return;
        }
        String existFilePath = ThumbnailPathUtils.getExistFilePath(mainListDocumentData.getUuid(), (this.mNotesHolderInfo.isDarkMode() && this.mNotesHolderInfo.isSupportInvertedBGColor()) ? Constants.MAIN_DARK_THUMBNAIL_FILE_NAME : "thumbnail");
        if (existFilePath != null) {
            this.mThumbnailHandler.decorateThumbnail(existFilePath, getModeIndex());
            return;
        }
        setTextContent(mainListDocumentData, highlightText);
        String existFilePath2 = ThumbnailPathUtils.getExistFilePath(mainListDocumentData.getUuid(), "image");
        if (existFilePath2 != null) {
            this.mThumbnailHandler.decorateThumbnail(existFilePath2, getModeIndex());
        } else {
            this.mThumbnailHandler.hideImageView();
        }
    }

    private void setTextContent(MainListDocumentData mainListDocumentData, HighlightText highlightText) {
        CharSequence displayContent;
        try {
            displayContent = NotesHolderUtil.getDisplayContent(mainListDocumentData.getDisplayContent());
        } catch (DisplayDataException e) {
            CharSequence charSequenceSubSequenceContent = this.mThumbnailHandler.subSequenceContent(mainListDocumentData.getContent());
            MainLogger.m7255e(getTag(), "decorateThumbnail# uuid : " + mainListDocumentData.getUuid() + SQLKeyword.COMMA + e.getMessage());
            displayContent = charSequenceSubSequenceContent;
        }
        if (TextUtils.isEmpty(displayContent)) {
            return;
        }
        this.mThumbnailHandler.setTextContents(displayContent, highlightText, false);
    }

    private void showVoiceGradientView() {
        if (this.mGradientView == null) {
            this.mGradientView = ViewModeUtils.getInflatedView(this.mThumbnailContainer, C8003R.id.gradient_view, C8003R.id.inflate_gradient_view);
        }
        this.mGradientView.setVisibility(0);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder
    public void clearThumbnailHolder() {
        super.clearThumbnailHolder();
        this.mThumbnailHandler.removeListViewAllCallbacks();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder
    public void createThumbnailHandler() {
        this.mThumbnailHandler = new ThumbnailHandler(this, this, this.mNotesHolderInfo, this.itemView);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void decorate(Common common, StateInfo stateInfo) {
        decorate(common.notes, stateInfo.getHighlightText());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder
    public void decorateThumbnail(@NonNull MainListDocumentData mainListDocumentData, HighlightText highlightText) {
        this.mThumbnailHandler.inflateThumbnail(mainListDocumentData);
        this.mThumbnailHandler.inflateTextContentView();
        if (NotesUtils.isLock(this.mNotesHolderInfo.getLockType())) {
            initLockInteractionListener();
        } else if (this.mNotesHolderInfo.isSdoc()) {
            this.mThumbnailHandler.decorateOldNoteThumbnail(mainListDocumentData, highlightText);
        } else {
            decorateListThumbnail(mainListDocumentData, highlightText);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder
    public void decorateTitle(MainListDocumentData mainListDocumentData, HighlightText highlightText) {
        String title = mainListDocumentData.getTitle();
        if (!TextUtils.isEmpty(title)) {
            this.mThumbnailHandler.setTitle(title, highlightText, 1);
            return;
        }
        int modeIndex = getMAdapterContract().getModeIndex();
        if (FeatureUtils.isCoeditMode(modeIndex) || FeatureUtils.isCoeditSpaceMode(modeIndex)) {
            this.mThumbnailHandler.setCoeditAutoTitle(mainListDocumentData, highlightText, 1);
        } else {
            this.mThumbnailHandler.setTitle(null, highlightText, 1);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter.HolderListener
    public CoverThumbnailCreator.ThumbnailType getCoverThumbnailType() {
        return CoverThumbnailCreator.ThumbnailType.SQUARE;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter.HolderListener
    public int getModeIndex() {
        return getMAdapterContract().getModeIndex();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder, com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view.ThumbnailContract
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder, com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder, com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view.ThumbnailContract, com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter.HolderListener
    public int getViewMode() {
        return 1;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder
    public void init() {
        super.init();
        View view = this.mGradientView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter.HolderListener
    public boolean isUnlockConverting(String str) {
        return getMAdapterContract().isUnlockConverting(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter.HolderListener
    public void registerNoteAnimation(@NonNull Runnable runnable) {
        getMAdapterContract().registerNoteAnimation(runnable);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter.HolderListener
    public void setThumbnailBackgroundColor(boolean z, boolean z2, @NonNull String str) {
        if (!z && z2 && this.mThumbnailHandler.isNeedVoiceGradient(str)) {
            showVoiceGradientView();
        } else {
            if (z) {
                return;
            }
            int backgroundColor = ThumbnailColorUtils.getBackgroundColor(this.mNotesHolderInfo, getResources());
            Drawable drawable = ResourcesCompat.getDrawable(getResources(), C8003R.drawable.notes_grid_item_bg_shape, null);
            drawable.setColorFilter(backgroundColor, PorterDuff.Mode.SRC);
            this.mThumbnailContainer.setBackground(drawable);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter.HolderListener
    public void setThumbnailScale(@NonNull ImageView imageView, String str) {
        try {
            if (this.mThumbnailHandler.isListTextImageOnlyMode()) {
                ((ImageScaleView) imageView).setRatio(1.0f);
            }
        } catch (ClassCastException unused) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            MainLogger.m7255e(getTag(), "loadThumbnail# ContentView is not ImageScaleView, viewMode : " + getViewMode());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder
    public void decorate(MainListDocumentData mainListDocumentData, HighlightText highlightText) {
        super.decorate(mainListDocumentData, highlightText);
        decorateThumbnail(mainListDocumentData, highlightText);
        decorateTitle(mainListDocumentData, highlightText);
        decorateExtra(mainListDocumentData);
        this.mThumbnailHandler.postUpdateListViewLayout();
    }
}
