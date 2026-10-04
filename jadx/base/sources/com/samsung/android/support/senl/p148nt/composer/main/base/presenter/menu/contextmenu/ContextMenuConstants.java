package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuConstants {
    public static int CONTEXT_MENU_ID_CLOSE = -1;
    public static final int CONTEXT_MENU_ID_FIRST_ITEM = 16908353;
    public static final int CONTEXT_MENU_ID_PROCESS_TEXT_INTENT_ACTIONS_START = 200;
    public static final int CONTEXT_MENU_ID_SECONDARY_ASSIST_ACTIONS_START = 100;
    public static final Integer CONTEXT_MENU_ID_WRITING_TOOLKIT = getContextMenuIdWritingToolkit();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ContextMenuCode {
        CONTEXT_MENU_ID_WRITING_TOOLKIT,
        CONTEXT_MENU_ID_FIRST,
        CONTEXT_MENU_IMAGE_STYLE_CHANGER,
        CONTEXT_MENU_ID_CUT,
        CONTEXT_MENU_ID_COPY,
        CONTEXT_MENU_ID_PASTE,
        CONTEXT_MENU_ID_PASTE_AS_PLAIN_TEXT,
        CONTEXT_MENU_ID_CORE_TRANSLATE,
        CONTEXT_MENU_ID_OBJECT_DELETE,
        CONTEXT_MENU_ID_WEB_CLIP,
        CONTEXT_MENU_ID_CROP,
        CONTEXT_MENU_ID_LASSO_CROP,
        CONTEXT_MENU_ID_DRAWING,
        CONTEXT_MENU_ID_SELECT_ALL,
        CONTEXT_MENU_ID_DICTIONARY,
        CONTEXT_MENU_ID_OBJECT_CHANGE_STYLE,
        CONTEXT_MENU_ID_ADD_TEXT_BOX,
        CONTEXT_MENU_ID_SCAN_TEXT,
        CONTEXT_MENU_ID_TEXT_RECOGNITION,
        CONTEXT_MENU_ID_CONVERT_TO_MATH,
        CONTEXT_MENU_ID_CONVERT_TO_TEXT,
        CONTEXT_MENU_ID_CONVERT_TO_HANDWRITING,
        CONTEXT_MENU_ID_OBJECT_ALIGNMENT,
        CONTEXT_MENU_ID_ANCHOR_TO_TEXT,
        CONTEXT_MENU_ID_REMOVE_ANCHOR_TO_TEXT,
        CONTEXT_MENU_ID_OBJECT_LOCK,
        CONTEXT_MENU_ID_TEXT_WRAP,
        CONTEXT_MENU_ID_FIT_TO_PAGE_WIDTH,
        CONTEXT_MENU_ID_RESIZE_TO_DEFAULT,
        CONTEXT_MENU_ID_OBJECT_BRING_TO_FRONT,
        CONTEXT_MENU_ID_OBJECT_SEND_TO_BACK,
        CONTEXT_MENU_ID_PHOTO_EDITOR,
        CONTEXT_MENU_ID_HBD_TRANSLATE,
        CONTEXT_MENU_ID_CLIPBOARD,
        CONTEXT_MENU_ID_SHARE,
        CONTEXT_MENU_ID_SAVE_TO_GALLERY,
        CONTEXT_MENU_ID_RENAME,
        CONTEXT_MENU_ID_PLAY,
        CONTEXT_MENU_ID_CALCULATE_MODE_OFF,
        CONTEXT_MENU_ID_REPLACE_IMAGE_BY_IMAGE_PICKER,
        CONTEXT_MENU_ID_REPLACE_IMAGE_BY_DRAWING_TOOLKIT,
        CONTEXT_MENU_ID_TABLE_ADD_ROW,
        CONTEXT_MENU_ID_TABLE_DELETE_ROW,
        CONTEXT_MENU_ID_REPLACE_INSERTED_IMAGE,
        CONTEXT_MENU_ID_REPLACE_GENERATED_IMAGE,
        CONTEXT_MENU_ID_REPLACE_CAMERA_IMAGE,
        CONTEXT_MENU_ID_REMOVE_EMPTY_IMAGE,
        CONTEXT_MENU_ID_STICKY_MEMO,
        CONTEXT_MENU_ID_CONVERT_TO_TEXT_LINK,
        CONTEXT_MENU_ID_NONE;

        public static ContextMenuCode get(int i) {
            for (ContextMenuCode contextMenuCode : values()) {
                if (contextMenuCode.getId() == i) {
                    return contextMenuCode;
                }
            }
            return CONTEXT_MENU_ID_NONE;
        }

        public int getId() {
            return ordinal();
        }
    }

    private static Integer getContextMenuIdWritingToolkit() {
        try {
            return (Integer) Class.forName("com.android.internal.R$id").getField("writing_toolkit").get(null);
        } catch (Exception e) {
            Logger.m10999d("ContextMenuConstants", "exception: " + e);
            return null;
        }
    }

    public static int getWritingToolkitId() {
        Integer num = CONTEXT_MENU_ID_WRITING_TOOLKIT;
        if (num != null) {
            return num.intValue();
        }
        return 16908353;
    }
}
