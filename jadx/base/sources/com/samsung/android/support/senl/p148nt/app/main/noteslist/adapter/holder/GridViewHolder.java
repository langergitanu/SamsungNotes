package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.datepicker.ViewOnFocusChangeListenerC4697c;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract;
import com.samsung.android.support.senl.p148nt.app.main.common.data.HighlightText;
import com.samsung.android.support.senl.p148nt.app.main.common.view.GridRatioView;
import com.samsung.android.support.senl.p148nt.app.main.common.view.ImageScaleView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter.HolderListener;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter.ThumbnailHandler;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.utils.ThumbnailColorUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.utils.ThumbnailPathUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.document.save.CoverThumbnailCreator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class GridViewHolder extends NotesHolder implements HolderListener, GridRatioView.Listener {
    private static final String TAG = "GridViewHolder";
    private View mGradientView;
    private final FrameLayout mThumbnailContainer;

    public GridViewHolder(View view) {
        super(view, 2);
        this.mThumbnailContainer = (FrameLayout) view.findViewById(C8003R.id.thumbnail_container);
        setFocusListener();
    }

    private String getThumbnailFilePath(@NonNull MainListDocumentData mainListDocumentData) {
        return this.mThumbnailHandler.hasImagePage(mainListDocumentData) ? mainListDocumentData.getImgObjectPathInThumbnailPage() : ThumbnailPathUtils.getThumbnailFilePath(this.mNotesHolderInfo.getUuid(), this.mNotesHolderInfo.isDarkMode(), this.mNotesHolderInfo.isSupportInvertedBGColor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFocusListener$0(View view, boolean z) {
        if (z) {
            this.mThumbnailContainer.requestFocus();
        }
    }

    private void setFocusListener() {
        this.mNotesHolderInfo.getRootCardView().setOnFocusChangeListener(new ViewOnFocusChangeListenerC4697c(this, 1));
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
        if (NotesUtils.isLock(this.mNotesHolderInfo.getLockType())) {
            initLockInteractionListener();
            return;
        }
        if (this.mNotesHolderInfo.isSdoc()) {
            this.mThumbnailHandler.decorateOldNoteThumbnail(mainListDocumentData, highlightText);
        } else {
            if (this.mThumbnailHandler.isCoverThumbnailEnabled(mainListDocumentData)) {
                return;
            }
            this.mThumbnailHandler.decorateTextContent(mainListDocumentData, highlightText);
            this.mThumbnailHandler.decorateThumbnail(getThumbnailFilePath(mainListDocumentData), getModeIndex());
            requestLayout();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder
    public void decorateTitle(MainListDocumentData mainListDocumentData, HighlightText highlightText) {
        String title = mainListDocumentData.getTitle();
        if (!TextUtils.isEmpty(title)) {
            if ("null".contentEquals(title)) {
                title = getResources().getString(C8003R.string.noteslist_title_no_title);
            }
            this.mThumbnailHandler.setTitle(title, highlightText, 2);
        } else {
            int modeIndex = getModeIndex();
            if (FeatureUtils.isCoeditMode(modeIndex) || FeatureUtils.isCoeditSpaceMode(modeIndex)) {
                this.mThumbnailHandler.setCoeditAutoTitle(mainListDocumentData, highlightText, 2);
            } else {
                this.mThumbnailHandler.setAutoTitle(mainListDocumentData, highlightText, 2);
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
        return 2;
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

    @Override // com.samsung.android.support.senl.nt.app.main.common.view.GridRatioView.Listener
    public void onError(String str) {
        MainLogger.m7255e(getTag(), "onError, uuid: " + this.mNotesHolderInfo.getUuid() + ", e: " + str);
        NotesDataRepositoryFactory.newInstance(this.itemView.getContext()).createDocumentDataRepository().setDisplayContent(this.mNotesHolderInfo.getUuid(), new byte[0]);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter.HolderListener
    public void registerNoteAnimation(@NonNull Runnable runnable) {
        getMAdapterContract().registerNoteAnimation(runnable);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.common.view.GridRatioView.Listener
    public void requestLayout() {
        int measuredHeight = this.mThumbnailContainer.getMeasuredHeight();
        if (measuredHeight == 0) {
            return;
        }
        this.mThumbnailHandler.requestLayout(measuredHeight);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void setAdapterContract(AdapterContract adapterContract) {
        super.setAdapterContract(adapterContract);
        ((GridRatioView) this.mThumbnailContainer).setAdapterContract(adapterContract);
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
            ((ImageScaleView) imageView).setInvalidate(this.mThumbnailHandler.isBlurView());
        } catch (ClassCastException unused) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            MainLogger.m7255e(getTag(), "loadThumbnail# ContentView is not ImageScaleView, viewMode : " + getViewMode());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder
    public void decorate(MainListDocumentData mainListDocumentData, HighlightText highlightText) {
        super.decorate(mainListDocumentData, highlightText);
        if (mainListDocumentData == null) {
            return;
        }
        this.mThumbnailContainer.setEnabled(true);
        ((GridRatioView) this.mThumbnailContainer).setListener(this);
        decorateThumbnail(mainListDocumentData, highlightText);
        decorateTitle(mainListDocumentData, highlightText);
        decorateExtra(mainListDocumentData);
    }

    public GridViewHolder(View view, int i) {
        super(view, i);
        this.mThumbnailContainer = (FrameLayout) view.findViewById(C8003R.id.thumbnail_container);
        setFocusListener();
    }
}
