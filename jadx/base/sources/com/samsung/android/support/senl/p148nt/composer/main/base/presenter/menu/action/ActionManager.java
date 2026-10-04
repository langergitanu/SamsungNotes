package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action;

import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ScrollController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ActionManager {
    private static final String TAG = Logger.createTag("ActionManager");
    protected HashMap<ActionType, AbsAction> mActionsMap;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ActionType {
        ZoomIn,
        ZoomOut,
        ReadOnlyMode,
        EditMode,
        FullScreen,
        TextIndent,
        TextOutdent,
        PageList,
        Print,
        SeekForward,
        SeekRewind,
        ToggleVoicePanel,
        ToggleAudioPlay,
        ToggleZoomLock,
        InsertNewPage,
        MoveVerticalScroll,
        MoveHorizontalScroll,
        Information,
        InputForm
    }

    private void addMap(ActionType actionType, AbsAction absAction) {
        if (absAction.isSupported()) {
            this.mActionsMap.put(actionType, absAction);
        }
    }

    public boolean doAction(ActionType actionType) {
        return doAction(actionType, "");
    }

    @Nullable
    public AbsAction getAction(ActionType actionType) {
        HashMap<ActionType, AbsAction> map = this.mActionsMap;
        if (map == null) {
            Logger.m11000e(TAG, "getAction : mActionsMap is null");
            return null;
        }
        AbsAction absAction = map.get(actionType);
        if (absAction == null) {
            Logger.m11000e(TAG, "getAction : don't have : " + actionType);
        }
        return absAction;
    }

    public void init(ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager, MenuPresenterContract.IMenuManager iMenuManager) {
        this.mActionsMap = new HashMap<>();
        ScrollController scrollController = composerViewPresenter.getComposerControllerManager().getScrollController();
        addMap(ActionType.ZoomIn, new ActionZoom(scrollController, true));
        addMap(ActionType.ZoomOut, new ActionZoom(scrollController, false));
        addMap(ActionType.ReadOnlyMode, new ActionReadonlyMode(composerViewPresenter, iMenuManager));
        addMap(ActionType.EditMode, new ActionEditMode(composerViewPresenter));
        addMap(ActionType.FullScreen, new ActionFullScreen(composerViewPresenter, iMenuManager));
        addMap(ActionType.TextIndent, new ActionTextIndent(composerViewPresenter, controllerManager, true));
        addMap(ActionType.TextOutdent, new ActionTextIndent(composerViewPresenter, controllerManager, false));
        addMap(ActionType.PageList, new ActionPageList(composerViewPresenter, controllerManager, iMenuManager));
        addMap(ActionType.SeekForward, new ActionAudioSeek(iMenuManager, true));
        addMap(ActionType.SeekRewind, new ActionAudioSeek(iMenuManager, false));
        addMap(ActionType.ToggleVoicePanel, new ActionVoicePanel(iMenuManager));
        addMap(ActionType.ToggleAudioPlay, new ActionAudioPlay(iMenuManager));
        addMap(ActionType.ToggleZoomLock, new ActionZoomLock(iMenuManager));
        addMap(ActionType.InsertNewPage, new ActionNewPage(composerViewPresenter));
        addMap(ActionType.Print, new ActionPrint(composerViewPresenter, controllerManager));
        addMap(ActionType.MoveVerticalScroll, new ActionMoveScroll(scrollController, true));
        addMap(ActionType.MoveHorizontalScroll, new ActionMoveScroll(scrollController, false));
        addMap(ActionType.Information, new ActionInformation(composerViewPresenter));
        addMap(ActionType.InputForm, new ActionInputForm(composerViewPresenter));
    }

    public boolean doAction(ActionType actionType, String str) {
        AbsAction action = getAction(actionType);
        if (action == null) {
            return false;
        }
        boolean zDoAction = action.doAction(str);
        Logger.m11003i(TAG, "doAction : do type = " + actionType + " / result = " + zDoAction + "/ caller = " + str);
        return zDoAction;
    }

    public boolean doAction(ActionType actionType, String str, Object obj) {
        AbsAction action = getAction(actionType);
        if (action == null) {
            return false;
        }
        boolean zDoAction = action.doAction(str, obj);
        Logger.m11003i(TAG, "doAction : do type = " + actionType + " / result = " + zDoAction + "/ caller = " + str + "/arg = " + obj);
        return zDoAction;
    }
}
