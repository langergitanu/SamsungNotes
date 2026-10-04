package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub;

import com.samsung.android.support.senl.p148nt.composer.main.base.common.Callback;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.CompListPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.search.SearchModePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title.TitleEditorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.ToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.directwrite.DwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtogglefab.HwToggleFabContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.quicktool.QuickToolPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.table.TableAndCellPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.translation.TlToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuPresenter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface ComposerSubContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IView {
        void attachBottomMenu();

        void attachCompList(CompListPresenter compListPresenter);

        void attachComposerView(ComposerViewPresenter composerViewPresenter, boolean z);

        void attachDirectWriteMenu(DwToolbarPresenter dwToolbarPresenter);

        void attachGuideTextView();

        void attachHwToggleFab(HwToggleFabContract.IView iView);

        void attachHwToolbarMenu(HwToolbarPresenter hwToolbarPresenter, boolean z);

        void attachQuickTool(QuickToolPresenter quickToolPresenter);

        void attachRichTextMenu(RtToolbarPresenter rtToolbarPresenter, boolean z);

        void attachSearchModeView(SearchModePresenter searchModePresenter);

        void attachTableAndCellMenu(TableAndCellPresenter tableAndCellPresenter);

        void attachTitle(TitleEditorPresenter titleEditorPresenter);

        void attachToolbar(ToolbarPresenter toolbarPresenter);

        void attachTranslationLanguageMenu(TlToolbarPresenter tlToolbarPresenter);

        void attachVoiceMenu(VoiceRecordMenuPresenter voiceRecordMenuPresenter);

        void releaseComposerView(Callback callback);

        void removeCaptureComposerView();

        void showComposerCover();
    }
}
