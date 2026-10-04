package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.common;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.view.SpenConfiguration;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.base.common.util.PageCacheUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.search.RecentSearchKeywordManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.SpanStates;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ModelManager {
    private final ObjectManager mObjectManager;
    private PageManager mPageManager;
    private final TextManager mTextManager;
    private final WritingToolManager mWritingToolManager;
    private final NoteManager mNoteManager = new NoteManager();
    private final RecentSearchKeywordManager mRecentSearchKeywordManager = new RecentSearchKeywordManager();
    private final PdfManager mPdfManager = new PdfManager();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ComponentFactory {
        @NonNull
        ObjectManager createObjectManager();

        @NonNull
        TextManager createTextManager();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IView {
        void initNoteManager(NoteManager noteManager);

        void initObjectManager(ObjectManager objectManager);

        void initPdfManager(PdfManager pdfManager);

        void initTextManager(TextManager textManager);

        void initWritingToolManager(WritingToolManager writingToolManager);
    }

    public ModelManager(@NonNull ComponentFactory componentFactory, @NonNull KeyguardPresenter keyguardPresenter) {
        this.mTextManager = componentFactory.createTextManager();
        this.mObjectManager = componentFactory.createObjectManager();
        this.mWritingToolManager = new WritingToolManager(keyguardPresenter);
    }

    public void createPageManager(Context context, String str, int i, boolean z) {
        float dimension = context.getResources().getDimension(C9086R.dimen.comp_page_list_search_item_width);
        if (z && SpenConfiguration.isTabletUX(context)) {
            dimension *= 1.4142857f;
        }
        this.mPageManager = new PageManager(PageCacheUtils.getCacheDirectory(context, str, i), PageCacheUtils.createPageThumbnailCacheDirectory(context, str, i), i, dimension);
    }

    @NonNull
    public NoteManager getNoteManager() {
        return this.mNoteManager;
    }

    @NonNull
    public ObjectManager getObjectManager() {
        return this.mObjectManager;
    }

    public PageManager getPageManager() {
        return this.mPageManager;
    }

    @NonNull
    public PdfManager getPdfManager() {
        return this.mPdfManager;
    }

    public RecentSearchKeywordManager getRecentSearchKeywordManager() {
        return this.mRecentSearchKeywordManager;
    }

    @NonNull
    public TextManager getTextManager() {
        return this.mTextManager;
    }

    @NonNull
    public WritingToolManager getWritingToolManager() {
        return this.mWritingToolManager;
    }

    public void init(IView iView, SpenWNote spenWNote, Activity activity, ComposerModel composerModel) {
        iView.initNoteManager(this.mNoteManager);
        iView.initWritingToolManager(this.mWritingToolManager);
        iView.initObjectManager(this.mObjectManager);
        iView.initTextManager(this.mTextManager);
        iView.initPdfManager(this.mPdfManager);
        this.mWritingToolManager.setDoc(spenWNote);
        this.mObjectManager.init(spenWNote, this.mTextManager, this.mPdfManager, composerModel.getVoiceModel(), activity.getResources().getDimensionPixelOffset(C9086R.dimen.insert_object_margin), composerModel.getMdeManager().getCoeditAdapter().isCoeditNote(), composerModel.getMdeManager().getMdeInfo().isMde());
        this.mTextManager.init(spenWNote, spenWNote.getTitle(), spenWNote.getBodyText(), activity.getResources().getColor(C9086R.color.composer_light_font_color, null), new SpanStates.IContract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.common.ModelManager.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.text.SpanStates.IContract
            public boolean isSelectedBodyText() {
                return ModelManager.this.mObjectManager.isSelectedBodyText();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.text.SpanStates.IContract
            public boolean isSelectedTable() {
                return ModelManager.this.mObjectManager.getSelectedObjectManager().isSelectedTable();
            }
        }, SpenConfiguration.isTabletUX(activity));
        this.mNoteManager.init(spenWNote, spenWNote.getPageDefaultWidth() / 360.0f);
        this.mPdfManager.init(this.mObjectManager.getCachePath(), composerModel.getCoeditAdapter().isCoeditNote());
        this.mRecentSearchKeywordManager.setCacheDirPath(PageCacheUtils.getCacheDirectory(activity, composerModel.getDocInfo().getUuid()));
        this.mNoteManager.setTextOnlyModeState(composerModel.getTextOnlyModeState());
        this.mObjectManager.setTextOnlyModeState(composerModel.getTextOnlyModeState());
        this.mTextManager.setTextOnlyModeState(composerModel.getTextOnlyModeState());
        composerModel.getDocState().setPDFDataSource(this.mPdfManager);
    }

    public void onConfigurationChanged(Context context) {
        if (this.mPageManager == null) {
            return;
        }
        float dimension = context.getResources().getDimension(C9086R.dimen.comp_page_list_search_item_width);
        if (dimension != this.mPageManager.getDefaultThumbnailWidth()) {
            this.mPageManager.updateThumbnailRatio(this.mNoteManager.getNote().getPageDefaultWidth(), dimension);
        }
    }
}
