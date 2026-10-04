package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.listener.ThumbnailHoverListener;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.data.HighlightText;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter.HolderListener;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter.ThumbnailHandler;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.utils.ThumbnailColorUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.utils.ThumbnailPathUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.model.document.save.CoverThumbnailCreator;
import p071Q2.ViewOnClickListenerC0219a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SimpleViewHolder extends NotesHolder implements HolderListener {
    private static final String TAG = "SimpleViewHolder";

    public SimpleViewHolder(View view) {
        super(view, 3);
        this.mThumbnailHandler.setClipToOutline();
    }

    private void createTextBitmap(MainListDocumentData mainListDocumentData) {
        if (this.mThumbnailHandler.hasImageContentView()) {
            ImageView imageContentView = this.mThumbnailHandler.getImageContentView();
            imageContentView.setVisibility(0);
            final Bitmap bitmapCreateTextBitmap = this.mThumbnailHandler.createTextBitmap(imageContentView, mainListDocumentData);
            imageContentView.setOnHoverListener(new ThumbnailHoverListener(new ThumbnailHoverListener.HoverRecyclerViewHolderListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.holder.SimpleViewHolder.1
                @Override // com.samsung.android.support.senl.nt.app.common.listener.ThumbnailHoverListener.HoverRecyclerViewHolderListener
                public int backgroundColor() {
                    return SimpleViewHolder.this.mNotesHolderInfo.getBackgroundColor();
                }

                @Override // com.samsung.android.support.senl.nt.app.common.listener.ThumbnailHoverListener.HoverRecyclerViewHolderListener
                public Drawable getImageDrawableImpl() {
                    if (NotesUtils.isLock(SimpleViewHolder.this.mNotesHolderInfo.getLockType())) {
                        return null;
                    }
                    return new BitmapDrawable(SimpleViewHolder.this.getResources(), bitmapCreateTextBitmap);
                }

                @Override // com.samsung.android.support.senl.nt.app.common.listener.ThumbnailHoverListener.HoverRecyclerViewHolderListener
                /* JADX INFO: renamed from: getItemView */
                public View get$itemView() {
                    return SimpleViewHolder.this.mNotesHolderInfo.getRootCardView();
                }

                @Override // com.samsung.android.support.senl.nt.app.common.listener.ThumbnailHoverListener.HoverRecyclerViewHolderListener
                public boolean hasOnlyHandwritingSdoc() {
                    return false;
                }

                @Override // com.samsung.android.support.senl.nt.app.common.listener.ThumbnailHoverListener.HoverRecyclerViewHolderListener
                public boolean isSdoc() {
                    return true;
                }

                @Override // com.samsung.android.support.senl.nt.app.common.listener.ThumbnailHoverListener.HoverRecyclerViewHolderListener
                public boolean isSupportInvertedBGColor() {
                    return false;
                }
            }, getViewMode()));
        }
    }

    private void decorateSearchExtra(MainListDocumentData mainListDocumentData) {
        MainLogger.m7254d(getTag(), "decorateSearchExtra");
        NotesFolder folderData = getFolderData();
        if (folderData == null) {
            return;
        }
        this.mThumbnailHandler.decorateSearchExtra(folderData.getUuid(), folderData.getDisplayName(), folderData.getDisplayNameColor()).setOnClickListener(new ViewOnClickListenerC0219a(this, mainListDocumentData, 8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$decorateSearchExtra$0(MainListDocumentData mainListDocumentData, View view) {
        if (mainListDocumentData.isSDoc()) {
            getMAdapterContract().onOldCategorySelected(mainListDocumentData.getCategoryUuid());
        } else {
            getMAdapterContract().onSubFolderSelected(mainListDocumentData.getCategoryUuid());
        }
    }

    private void setBackgroundResources() {
        if (DeviceInfo.isVSTModel()) {
            this.mNotesHolderInfo.getRootCardView().setBackgroundColor(ContextCompat.getColor(this.itemView.getContext(), C8003R.color.noteslist_simple_list_item_bg_color_for_vst));
        }
    }

    public void addImageContentViewPadding(ImageView imageView, boolean z) {
        if (imageView == null) {
            return;
        }
        if (z) {
            imageView.setPadding(5, 5, 5, 5);
        } else {
            imageView.setPadding(0, 0, 0, 0);
        }
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
    public void decorateOldNoteThumbnail(MainListDocumentData mainListDocumentData, HighlightText highlightText) {
        if (this.mThumbnailHandler.hasImageContentView()) {
            int iIntValue = mainListDocumentData.getFirstContentType().intValue();
            ImageView imageContentView = this.mThumbnailHandler.getImageContentView();
            imageContentView.setVisibility(0);
            if (1 == iIntValue) {
                createTextBitmap(mainListDocumentData);
                addImageContentViewPadding(imageContentView, true);
                this.mNotesHolderInfo.setHoverThumbnailFilePath(null);
            } else {
                addImageContentViewPadding(imageContentView, false);
                if (3 != iIntValue) {
                    this.mThumbnailHandler.decorateThumbnail(ThumbnailPathUtils.getSdocThumbnailFilePath(mainListDocumentData.getContentUuid()), getModeIndex());
                } else {
                    this.mNotesHolderInfo.setHasOnlyHandwritingSdoc(true);
                    this.mThumbnailHandler.decorateThumbnail(ThumbnailPathUtils.getSdocHWThumbnailFilePath(mainListDocumentData.getStrokeUuid(), 3), getModeIndex());
                }
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder
    public void decorateThumbnail(MainListDocumentData mainListDocumentData, HighlightText highlightText) {
        this.mThumbnailHandler.inflateThumbnail(mainListDocumentData);
        if (NotesUtils.isLock(this.mNotesHolderInfo.getLockType())) {
            return;
        }
        if (this.mNotesHolderInfo.isSdoc()) {
            decorateOldNoteThumbnail(mainListDocumentData, highlightText);
        } else {
            this.mThumbnailHandler.decorateTextContent(mainListDocumentData, highlightText);
            decorateThumbnail(this.mNotesHolderInfo.getUuid(), getModeIndex());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder
    public void decorateTitle(MainListDocumentData mainListDocumentData, HighlightText highlightText) {
        String title = mainListDocumentData.getTitle();
        if (!TextUtils.isEmpty(title)) {
            if ("null".contentEquals(title)) {
                title = this.itemView.getResources().getString(C8003R.string.noteslist_title_no_title);
            }
            this.mThumbnailHandler.setTitle(title, highlightText, 1);
        } else {
            int modeIndex = getMAdapterContract().getModeIndex();
            if (FeatureUtils.isCoeditMode(modeIndex) || FeatureUtils.isCoeditSpaceMode(modeIndex)) {
                this.mThumbnailHandler.setCoeditAutoTitle(mainListDocumentData, highlightText, 1);
            } else {
                this.mThumbnailHandler.setAutoTitle(mainListDocumentData, highlightText, 1);
            }
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
        return 3;
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
        if (this.mThumbnailHandler.hasImageContentView()) {
            ImageView imageContentView = this.mThumbnailHandler.getImageContentView();
            imageContentView.setVisibility(0);
            ThumbnailColorUtils.setSimpleViewBackgroundColor(imageContentView, this.mNotesHolderInfo, z);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter.HolderListener
    public void setThumbnailScale(@NonNull ImageView imageView, String str) {
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setClipToOutline(true);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder
    public void decorate(MainListDocumentData mainListDocumentData, HighlightText highlightText) {
        super.decorate(mainListDocumentData, highlightText);
        decorateTitle(mainListDocumentData, highlightText);
        decorateThumbnail(mainListDocumentData, highlightText);
        if (highlightText != null && !highlightText.isEmpty()) {
            decorateSearchExtra(mainListDocumentData);
        }
        setBackgroundResources();
        decorateExtra(mainListDocumentData);
    }

    public SimpleViewHolder(View view, int i) {
        super(view, i);
    }

    public void decorateThumbnail(String str, int i) {
        if (this.mThumbnailHandler.hasImageContentView()) {
            ImageView imageContentView = this.mThumbnailHandler.getImageContentView();
            imageContentView.setVisibility(0);
            imageContentView.setPadding(0, 2, 0, 0);
            this.mThumbnailHandler.decorateThumbnail(ThumbnailPathUtils.getSimpleThumbnailFilePath(str, this.mNotesHolderInfo.isDarkMode(), this.mNotesHolderInfo.isSupportInvertedBGColor()), i);
        }
    }
}
