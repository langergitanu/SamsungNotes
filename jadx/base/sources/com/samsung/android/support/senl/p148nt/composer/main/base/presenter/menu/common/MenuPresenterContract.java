package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common;

import android.util.Pair;
import android.view.View;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface MenuPresenterContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum CMenu {
        AI_MENU_RESULT,
        AI_MENU_FOR_PDF_VIEWER,
        AI_MENU_FOR_PDF_VIEWER_OVERLAY,
        AI_DRAWING_TRIGGER
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IMenuManager {
        public static final int CLICK_AI_ASSIST = 11;
        public static final int CLICK_LASER_PEN = 13;
        public static final int CLICK_SAVE_AS_NEW_NOTE_WITH_TRANSLATION = 12;
        public static final int HIDE_SORT_PAGE = 5;
        public static final int SEEK_AUDIO_FORWARD = 7;
        public static final int SEEK_AUDIO_REWIND = 8;
        public static final int SHOW_CAMERA_ATTACH_MENU = 1;
        public static final int SHOW_IMAGE_ATTACH_MENU = 2;
        public static final int SHOW_LIST_MENU = 3;
        public static final int SHOW_TITLE = 14;
        public static final int TOGGLE_AUDIO_PLAY = 9;
        public static final int TOGGLE_SORT_PAGE = 4;
        public static final int TOGGLE_TOOLBAR_VISIBILITY = 6;
        public static final int TOGGLE_ZOOM_LOCK = 10;

        void attachBottomView();

        void changeNoteType();

        void clearRecommendedCover();

        void doAiSuggestionForTranslation();

        boolean finish(String str);

        Pair<Integer, Integer> getLaserPenData();

        View getToolbarView();

        void hideAndInvalidateOptionsMenu();

        void hideBottomMenu();

        void hideOverlayTranslation();

        void hideStickyMemo(@Nullable String str);

        void invalidateOptionsMenu();

        boolean isClickedPageList();

        boolean isEnabledInAppCollaboration();

        boolean isPageListShowing();

        boolean isRestrictedInAppCollaboration();

        boolean isToolbarShowing();

        void notifyChangedIsOverlayTranslating(boolean z);

        void onEvent(int i);

        void onHideMenu(CMenu cMenu);

        void onSearchDone(String str);

        void onShowMenu(CMenu cMenu);

        void onTranslationStateUpdated(int i);

        void onTriggerMenu(CMenu cMenu);

        void showOverlayTranslation();

        void stopVoice();

        boolean toggleVoicePanel();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IMenuParent {
        boolean finish(String str);
    }
}
