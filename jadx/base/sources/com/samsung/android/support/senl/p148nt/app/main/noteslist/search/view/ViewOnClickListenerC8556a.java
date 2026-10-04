package com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view;

import android.content.Context;
import android.view.View;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.ConvertConfirmDialogFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsConvertOldNotesFragment;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.adapter.ImportDocumentRecyclerViewAdapter;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.view.ImportDocumentView;
import com.samsung.android.support.senl.p148nt.base.common.util.AppInfoUtil;
import com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.GoToSettingsActivity;
import com.samsung.android.support.senl.p148nt.base.winset.snackbar.SnackbarHelper;
import com.samsung.android.support.senl.p148nt.base.winset.view.palette.PaletteContainerView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.MenuPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtogglefab.HwToggleFabManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.AiSuggestionView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.page.PageRatioSettingView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.guide.AiDrawingGuide;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.DetailsViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.TitleEditor;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.TitleEditorViewSet;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerViewCore;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTAttributesLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPatternLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.RtToolbarMenu;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.item.MenuItem;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingPenColor;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingRemoverLayout;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.STTSelectTranscribeDialogFragment;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.STTSettingLanguageDialogFragment;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.search.view.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ViewOnClickListenerC8556a implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6245a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6246b;

    public /* synthetic */ ViewOnClickListenerC8556a(Object obj, int i) {
        this.f6245a = i;
        this.f6246b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f6245a) {
            case 0:
                FlexboxHashTagView.mHashTagClickListener$lambda$0((FlexboxHashTagView) this.f6246b, view);
                break;
            case 1:
                SearchFilterAbsView.mFiltersClickListener$lambda$0((SearchFilterAbsView) this.f6246b, view);
                break;
            case 2:
                SearchFilterStickerView.mStickerClickListener$lambda$0((SearchFilterStickerView) this.f6246b, view);
                break;
            case 3:
                ConvertConfirmDialogFragment.onCreateDialog$lambda$1$lambda$0((ConvertConfirmDialogFragment) this.f6246b, view);
                break;
            case 4:
                SettingsConvertOldNotesFragment.initLayout$lambda$1((SettingsConvertOldNotesFragment) this.f6246b, view);
                break;
            case 5:
                ImportDocumentRecyclerViewAdapter.onCreateViewHolder$lambda$2$lambda$0((ImportDocumentRecyclerViewAdapter) this.f6246b, view);
                break;
            case 6:
                ImportDocumentView.initSpinnerLayout$lambda$6((ImportDocumentView) this.f6246b, view);
                break;
            case 7:
                BaseWidgetSettingView.initBackgroundColorOneUI7x$lambda$1((BaseWidgetSettingView) this.f6246b, view);
                break;
            case 8:
                AppInfoUtil.showDetailsSettings$default((GoToSettingsActivity) this.f6246b, null, 2, null);
                break;
            case 9:
                AppInfoUtil.showDetailsSettings$default((Context) this.f6246b, null, 2, null);
                break;
            case 10:
                SnackbarHelper.show$lambda$2((View.OnClickListener) this.f6246b, view);
                break;
            case 11:
                PaletteContainerView.setPaletteItemInfo$lambda$0((PaletteContainerView) this.f6246b, view);
                break;
            case 12:
                ((MenuPresenterManager) this.f6246b).lambda$onEvent$0(view);
                break;
            case 13:
                AiSuggestionView.makeButtons$lambda$2((AiSuggestionView) this.f6246b, view);
                break;
            case 14:
                ((AiDrawingGuide) this.f6246b).lambda$init$0(view);
                break;
            case 15:
                NoteStyleLayout.initPagePreview$lambda$0((NoteStyleLayout) this.f6246b, view);
                break;
            case 16:
                ((PageRatioSettingView) this.f6246b).lambda$initPageRatio$1(view);
                break;
            case 17:
                ((DetailsViewManager) this.f6246b).lambda$init$2(view);
                break;
            case 18:
                ((TitleEditor) this.f6246b).lambda$init$2(view);
                break;
            case 19:
                ((TitleEditorViewSet) this.f6246b).lambda$attachNaviUpButton$1(view);
                break;
            case 20:
                QTColorPickerViewCore.initPickerView$lambda$0((QTColorPickerViewCore) this.f6246b, view);
                break;
            case 21:
                SettingQTAttributesLayout._init_$lambda$0((SettingQTAttributesLayout) this.f6246b, view);
                break;
            case 22:
                SettingQTPatternLayout.mPatternClickListener$lambda$0((SettingQTPatternLayout) this.f6246b, view);
                break;
            case 23:
                ((RtToolbarMenu) this.f6246b).lambda$initButtons$0(view);
                break;
            case 24:
                ((MenuItem) this.f6246b).onClick();
                break;
            case 25:
                ((SettingPenColor) this.f6246b).performOnClick();
                break;
            case 26:
                SettingRemoverLayout.initEraseAllButton$lambda$0((SettingRemoverLayout) this.f6246b, view);
                break;
            case 27:
                STTSelectTranscribeDialogFragment.ViewHolder._init_$lambda$0((STTSelectTranscribeDialogFragment.ViewHolder) this.f6246b, view);
                break;
            case 28:
                STTSettingLanguageDialogFragment.initMoreLanguageLayout$lambda$0((STTSettingLanguageDialogFragment) this.f6246b, view);
                break;
            default:
                HwToggleFabManager.onAttachView$lambda$0((HwToggleFabManager) this.f6246b, view);
                break;
        }
    }
}
