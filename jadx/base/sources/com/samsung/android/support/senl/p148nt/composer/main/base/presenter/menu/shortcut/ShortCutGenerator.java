package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ScrollController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.ActionManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuCopy;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuCut;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuDelete;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuPaste;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuSelectAll;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.CompListPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuAddPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarPresenter;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutGenerator {
    private final ActionManager mActionManager;
    private final ComposerState mComposerState;
    private final ComposerViewPresenter mComposerViewPresenter;
    private final ControllerManager mControllerManager;
    private final HwToolbarPresenter mHwToolbarPresenter;
    private long mKeyCopy;
    private long mKeyCut;
    private long mKeyPaste;
    private long mKeySelectAll;
    private final ModeManager mModeManager;
    private final OptionMenuPresenter mOptionMenuPresenter;
    private final RtToolbarPresenter mRtToolbarPresenter;
    private final ScrollController mScrollController;
    private final TextManager mTextManager;

    public ShortCutGenerator(ControllerManager controllerManager, @NonNull ComposerViewPresenter composerViewPresenter, @NonNull HwToolbarPresenter hwToolbarPresenter, @NonNull RtToolbarPresenter rtToolbarPresenter, @NonNull OptionMenuPresenter optionMenuPresenter, @NonNull ActionManager actionManager) {
        this.mControllerManager = controllerManager;
        this.mComposerViewPresenter = composerViewPresenter;
        this.mHwToolbarPresenter = hwToolbarPresenter;
        this.mRtToolbarPresenter = rtToolbarPresenter;
        this.mComposerState = composerViewPresenter.getComposerModel().getComposerState();
        this.mTextManager = composerViewPresenter.getTextManager();
        this.mScrollController = composerViewPresenter.getComposerControllerManager().getScrollController();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
        this.mOptionMenuPresenter = optionMenuPresenter;
        this.mActionManager = actionManager;
    }

    private void generateAttachMenu(@NonNull Map<Long, AbsShortCutAction> map) {
        OptionMenuAddPresenter optionMenuAddPresenter = this.mOptionMenuPresenter.getOptionMenuAddPresenter();
        putAction(map, new ShortCutAddTextBox(this.mModeManager, optionMenuAddPresenter));
        putAction(map, new ShortCutInsertPDF(this.mModeManager, optionMenuAddPresenter));
        putAction(map, new ShortCutInsertVoiceRecording(this.mModeManager, optionMenuAddPresenter));
        putAction(map, new ShortCutInsertImage(this.mModeManager, optionMenuAddPresenter));
        putAction(map, new ShortCutInsertAudioFile(this.mModeManager, optionMenuAddPresenter));
        putAction(map, new ShortCutInsertDrawing(this.mModeManager, optionMenuAddPresenter));
    }

    private void generateAudio(@NonNull Map<Long, AbsShortCutAction> map) {
        putAction(map, new ShortCutSeekAudio(this.mActionManager, true));
        putAction(map, new ShortCutSeekAudio(this.mActionManager, false));
        putAction(map, new ShortCutVoicePanel(this.mActionManager));
        putAction(map, new ShortCutAudioPlay(this.mActionManager));
    }

    private void generateHwToolbar(@NonNull Map<Long, AbsShortCutAction> map) {
        putAction(map, new ShortCutTextMode(this.mModeManager, this.mControllerManager.getSoftInputManager()));
        putAction(map, new ShortCutHwToolbarPen(this.mModeManager, this.mHwToolbarPresenter));
        putAction(map, new ShortCutHwToolbarHighlighter(this.mModeManager, this.mHwToolbarPresenter));
        putAction(map, new ShortCutHwToolbarEraser(this.mModeManager, this.mHwToolbarPresenter));
        putAction(map, new ShortCutHwToolbarSelection(this.mModeManager, this.mHwToolbarPresenter));
        putAction(map, new ShortCutHwToolbarChangeStyle(this.mModeManager, this.mHwToolbarPresenter));
    }

    private void generateKeyboardMenu(@NonNull Map<Long, AbsShortCutAction> map) {
        putAction(map, new KeyboardShortcutInfo(this.mComposerViewPresenter, true));
        putAction(map, new KeyboardShortcutInfo(this.mComposerViewPresenter, false));
    }

    private void generateOptionMenu(@NonNull Map<Long, AbsShortCutAction> map) {
        putAction(map, new ShortCutEditTitle(this.mOptionMenuPresenter));
        putAction(map, new ShortCutSaveAs(this.mOptionMenuPresenter));
        putAction(map, new ShortCutNoteStyle(this.mOptionMenuPresenter));
        putAction(map, new ShortCutPrint(this.mComposerViewPresenter, this.mActionManager, this.mOptionMenuPresenter));
        if (!this.mComposerViewPresenter.getComposerModel().isSingleMode()) {
            putAction(map, new ShortCutPageList(this.mActionManager));
        }
        generateAttachMenu(map);
    }

    private void generateRtToolbar(@NonNull Map<Long, AbsShortCutAction> map) {
        putAction(map, new ShortCutSetBold(this.mModeManager, this.mTextManager));
        putAction(map, new ShortCutSetItalic(this.mModeManager, this.mTextManager));
        putAction(map, new ShortCutSetStrikethrough(this.mModeManager, this.mTextManager));
        putAction(map, new ShortCutSetUnderline(this.mModeManager, this.mTextManager));
        putAction(map, new ShortCutUndo(this.mComposerViewPresenter, this.mHwToolbarPresenter));
        putAction(map, new ShortCutRedo(this.mComposerViewPresenter, this.mHwToolbarPresenter));
        putAction(map, new ShortCutToolbarSetting(this.mModeManager, this.mRtToolbarPresenter, this.mHwToolbarPresenter));
        putAction(map, new ShortCutSetFontSize(this.mModeManager, this.mRtToolbarPresenter, true));
        putAction(map, new ShortCutSetFontSize(this.mModeManager, this.mRtToolbarPresenter, false));
        putAction(map, new ShortCutSetAlign(this.mModeManager, this.mRtToolbarPresenter, 0));
        putAction(map, new ShortCutSetAlign(this.mModeManager, this.mRtToolbarPresenter, 2));
        putAction(map, new ShortCutSetAlign(this.mModeManager, this.mRtToolbarPresenter, 1));
        putAction(map, new ShortCutSetTextColor(this.mModeManager, this.mRtToolbarPresenter, false));
        putAction(map, new ShortCutSetTextColor(this.mModeManager, this.mRtToolbarPresenter, true));
        putAction(map, new ShortCutToggleTaskSpan(this.mModeManager, this.mRtToolbarPresenter, 8));
        putAction(map, new ShortCutToggleTaskSpan(this.mModeManager, this.mRtToolbarPresenter, 4));
        putAction(map, new ShortCutToggleTaskSpan(this.mModeManager, this.mRtToolbarPresenter, 2));
        putAction(map, new ShortCutSetIndent(this.mActionManager, true));
        putAction(map, new ShortCutSetIndent(this.mActionManager, false));
    }

    private void generateScroll(@NonNull Map<Long, AbsShortCutAction> map) {
        putAction(map, new ShortCutPageScroll(this.mModeManager, this.mScrollController, this.mComposerState, true));
        putAction(map, new ShortCutPageScroll(this.mModeManager, this.mScrollController, this.mComposerState, false));
        putAction(map, new ShortCutPageZoom(this.mActionManager, this.mComposerState, true));
        putAction(map, new ShortCutPageZoom(this.mActionManager, this.mComposerState, false));
        putAction(map, new ShortCutMoveScroll(this.mModeManager, this.mActionManager, true, true));
        putAction(map, new ShortCutMoveScroll(this.mModeManager, this.mActionManager, true, false));
    }

    private void putAction(@NonNull Map<Long, AbsShortCutAction> map, @NonNull AbsShortCutAction absShortCutAction) {
        map.put(Long.valueOf(absShortCutAction.getKey()), absShortCutAction);
    }

    public ShortCutGenerator generate(@NonNull Map<Long, AbsShortCutAction> map) {
        generateRtToolbar(map);
        generateHwToolbar(map);
        generateOptionMenu(map);
        generateScroll(map);
        generateAudio(map);
        generateKeyboardMenu(map);
        if (!this.mComposerViewPresenter.getComposerModel().isPDFReader()) {
            putAction(map, new ShortCutReadOnly(this.mActionManager));
            putAction(map, new ShortCutEditMode(this.mActionManager));
        }
        putAction(map, new ShortCutFullScreen(this.mActionManager));
        putAction(map, new ShortCutZoomLock(this.mActionManager));
        putAction(map, new ShortCutNewPage(this.mActionManager));
        return this;
    }

    public ShortCutGenerator generateBLE(@NonNull Map<Long, AbsShortCutAction> map) {
        putAction(map, new ShortCutRemoteFavoritePen(this.mHwToolbarPresenter, this.mComposerState, true));
        putAction(map, new ShortCutRemoteFavoritePen(this.mHwToolbarPresenter, this.mComposerState, false));
        putAction(map, new ShortCutRemoteEraser(this.mHwToolbarPresenter));
        putAction(map, new ShortCutRemoteUndo(this.mComposerViewPresenter, this.mHwToolbarPresenter));
        putAction(map, new ShortCutRemoteRedo(this.mComposerViewPresenter, this.mHwToolbarPresenter));
        putAction(map, new ShortCutPageScroll(this.mModeManager, this.mScrollController, this.mComposerState, true));
        putAction(map, new ShortCutPageScroll(this.mModeManager, this.mScrollController, this.mComposerState, false));
        putAction(map, new ShortCutPageZoom(this.mActionManager, this.mComposerState, true));
        putAction(map, new ShortCutPageZoom(this.mActionManager, this.mComposerState, false));
        putAction(map, new ShortCutPageFitToScreen());
        return this;
    }

    public ShortCutGenerator generateContextMenu(@NonNull Map<Long, AbsShortCutAction> map, @NonNull Map<Long, AbsShortCutAction> map2, @NonNull ContextMenuManager contextMenuManager, @NonNull CompListPresenter compListPresenter) {
        ContextMenuCopy contextMenuCopy = (ContextMenuCopy) contextMenuManager.getContextMenu(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_COPY.getId());
        ShortCutCopy shortCutCopy = new ShortCutCopy(contextMenuCopy);
        this.mKeyCopy = shortCutCopy.getKey();
        map.put(Long.valueOf(shortCutCopy.getKey()), shortCutCopy);
        ContextMenuCut contextMenuCut = (ContextMenuCut) contextMenuManager.getContextMenu(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CUT.getId());
        ShortCutCut shortCutCut = new ShortCutCut(contextMenuCut);
        this.mKeyCut = shortCutCut.getKey();
        map.put(Long.valueOf(shortCutCut.getKey()), shortCutCut);
        ContextMenuPaste contextMenuPaste = (ContextMenuPaste) contextMenuManager.getContextMenu(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_PASTE.getId());
        ShortCutPaste shortCutPaste = new ShortCutPaste(contextMenuPaste);
        this.mKeyPaste = shortCutPaste.getKey();
        map.put(Long.valueOf(shortCutPaste.getKey()), shortCutPaste);
        ShortCutSelectAll shortCutSelectAll = new ShortCutSelectAll((ContextMenuSelectAll) contextMenuManager.getContextMenu(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_SELECT_ALL.getId()));
        this.mKeySelectAll = shortCutSelectAll.getKey();
        map.put(Long.valueOf(shortCutSelectAll.getKey()), shortCutSelectAll);
        putAction(map, new ShortCutAdbCopy(contextMenuCopy));
        putAction(map, new ShortCutAdbCut(contextMenuCut));
        putAction(map, new ShortCutAdbPaste(contextMenuPaste));
        putAction(map, new ShortCutClipboard(this.mControllerManager.getClipboardController()));
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_OBJECT_DELETE;
        putAction(map, new ShortCutDelete((ContextMenuDelete) contextMenuManager.getContextMenu(contextMenuCode.getId())));
        putAction(map, new ShortCutDeleteSecond(this.mTextManager, (ContextMenuDelete) contextMenuManager.getContextMenu(contextMenuCode.getId())));
        putAction(map, new ShortCutSave(this.mComposerViewPresenter.getComposerModel()));
        putAction(map, map2, new ShortCutFind(this.mComposerViewPresenter, compListPresenter, this.mOptionMenuPresenter));
        return this;
    }

    public long getKeyCopy() {
        return this.mKeyCopy;
    }

    public long getKeyCut() {
        return this.mKeyCut;
    }

    public long getKeyPaste() {
        return this.mKeyPaste;
    }

    public long getKeySelectAll() {
        return this.mKeySelectAll;
    }

    private void putAction(@NonNull Map<Long, AbsShortCutAction> map, @NonNull Map<Long, AbsShortCutAction> map2, @NonNull AbsShortCutAction absShortCutAction) {
        map.put(Long.valueOf(absShortCutAction.getKey()), absShortCutAction);
        map2.put(Long.valueOf(absShortCutAction.getKey()), absShortCutAction);
    }
}
