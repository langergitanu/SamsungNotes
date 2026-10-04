package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut.keyshortcut;

import android.app.Activity;
import android.view.KeyboardShortcutGroup;
import android.view.KeyboardShortcutInfo;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.AbstractC12991c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class KeyboardShortcutManager {
    private void initAlign(Activity activity, List<KeyboardShortcutInfo> list) {
        AbstractC12991c.m14003x(activity, C9086R.string.composer_align_left, Shortcut.AlignLeft, list);
        AbstractC12991c.m14003x(activity, C9086R.string.composer_align_center, Shortcut.AlignCenter, list);
        AbstractC12991c.m14003x(activity, C9086R.string.composer_align_right, Shortcut.AlignRight, list);
    }

    private void initAudioSeek(Activity activity, List<KeyboardShortcutInfo> list) {
        AbstractC12991c.m14003x(activity, C9086R.string.voice_record_backward, Shortcut.SeekAudioBackward, list);
        AbstractC12991c.m14003x(activity, C9086R.string.voice_record_forward, Shortcut.SeekAudioForward, list);
    }

    private void initCutCopyPaste(Activity activity, List<KeyboardShortcutInfo> list) {
        AbstractC12991c.m14003x(activity, C9086R.string.composer_ctx_menu_cut, Shortcut.Cut, list);
        AbstractC12991c.m14003x(activity, C9086R.string.composer_ctx_menu_copy, Shortcut.Copy, list);
        AbstractC12991c.m14003x(activity, C9086R.string.composer_ctx_menu_paste, Shortcut.Paste, list);
    }

    private void initDelete(Activity activity, List<KeyboardShortcutInfo> list) {
        AbstractC12991c.m14003x(activity, C9086R.string.action_delete, Shortcut.DeleteSecond, list);
        AbstractC12991c.m14003x(activity, C9086R.string.action_delete, Shortcut.Delete, list);
    }

    private void initFontColor(Activity activity, List<KeyboardShortcutInfo> list) {
        AbstractC12991c.m14003x(activity, C9086R.string.composer_font_color, Shortcut.TextColor, list);
        AbstractC12991c.m14003x(activity, C9086R.string.composer_font_bg_color, Shortcut.TextBackgroundColor, list);
    }

    private void initFontSize(Activity activity, List<KeyboardShortcutInfo> list) {
        AbstractC12991c.m14003x(activity, C9086R.string.composer_increase_font_size, Shortcut.FontSizeIncrease, list);
        AbstractC12991c.m14003x(activity, C9086R.string.composer_decrease_font_size, Shortcut.FontSizeDecrease, list);
    }

    private void initInsertContent(Activity activity, List<KeyboardShortcutInfo> list) {
        AbstractC12991c.m14003x(activity, C9086R.string.composer_insert_pdf, Shortcut.InsertPDF, list);
        AbstractC12991c.m14003x(activity, C9086R.string.composer_insert_voice_recording, Shortcut.InsertVoice, list);
        AbstractC12991c.m14003x(activity, C9086R.string.composer_insert_image, Shortcut.InsertImage, list);
        AbstractC12991c.m14003x(activity, C9086R.string.composer_insert_audio_file, Shortcut.InsertAudio, list);
        AbstractC12991c.m14003x(activity, C9086R.string.composer_insert_drawing, Shortcut.InsertDrawing, list);
        AbstractC12991c.m14003x(activity, C9086R.string.composer_edit_title, Shortcut.EditTitle, list);
    }

    private void initNoteStyle(Activity activity, List<KeyboardShortcutInfo> list) {
        AbstractC12991c.m14003x(activity, C9086R.string.composer_note_style, Shortcut.NotesStyle, list);
    }

    private void initOptionMenu(Activity activity, List<KeyboardShortcutInfo> list, boolean z) {
        AbstractC12991c.m14003x(activity, C9086R.string.composer_reading_mode, Shortcut.ReadingMode, list);
        AbstractC12991c.m14003x(activity, C9086R.string.composer_opt_full_screen, Shortcut.FullScreen, list);
        if (!z) {
            AbstractC12991c.m14003x(activity, C9086R.string.composer_sort_pages, Shortcut.PageList, list);
            AbstractC12991c.m14003x(activity, C9086R.string.composer_ctx_menu_add_page, Shortcut.InsertNewPage, list);
        }
        AbstractC12991c.m14003x(activity, C9086R.string.action_print, Shortcut.Print, list);
    }

    private void initSave(Activity activity, List<KeyboardShortcutInfo> list) {
        AbstractC12991c.m14003x(activity, C9086R.string.action_save, Shortcut.Save, list);
    }

    private void initSaveAs(Activity activity, List<KeyboardShortcutInfo> list) {
        AbstractC12991c.m14003x(activity, C9086R.string.composer_save_as, Shortcut.SaveAs, list);
    }

    private void initSelectAll(Activity activity, List<KeyboardShortcutInfo> list) {
        AbstractC12991c.m14003x(activity, C9086R.string.composer_ctx_menu_select_all, Shortcut.SelectAll, list);
    }

    private void initSetting(Activity activity, List<KeyboardShortcutInfo> list, Mode mode) {
        if (mode == Mode.Writing) {
            AbstractC12991c.m14003x(activity, C9086R.string.composer_show_pen_settings, Shortcut.ToolbarSetting, list);
        } else {
            if (mode != Mode.Text || ResourceUtils.isTabletLayout(activity)) {
                return;
            }
            AbstractC12991c.m14003x(activity, C9086R.string.composer_text_options, Shortcut.ToolbarSetting, list);
        }
    }

    private void initTextIndent(Activity activity, List<KeyboardShortcutInfo> list) {
        AbstractC12991c.m14003x(activity, C9086R.string.composer_indent, Shortcut.Indent, list);
        AbstractC12991c.m14003x(activity, C9086R.string.composer_outdent, Shortcut.Outdent, list);
    }

    private void initTextOption(Activity activity, List<KeyboardShortcutInfo> list) {
        AbstractC12991c.m14003x(activity, C9086R.string.composer_bold, Shortcut.Bold, list);
        AbstractC12991c.m14003x(activity, C9086R.string.composer_italic, Shortcut.Italic, list);
        AbstractC12991c.m14003x(activity, C9086R.string.composer_underline, Shortcut.Underline, list);
    }

    private void initToolbar(Activity activity, List<KeyboardShortcutInfo> list) {
        AbstractC12991c.m14003x(activity, C9086R.string.hw_toolbar_item_menu_text, Shortcut.TextMode, list);
        AbstractC12991c.m14003x(activity, C9086R.string.hw_toolbar_item_menu_pen_mode, Shortcut.Pen, list);
        AbstractC12991c.m14003x(activity, C9086R.string.hw_toolbar_item_menu_highlighter, Shortcut.Highlighter, list);
        AbstractC12991c.m14003x(activity, C9086R.string.hw_toolbar_item_erase_mode, Shortcut.Eraser, list);
        AbstractC12991c.m14003x(activity, C9086R.string.hw_toolbar_item_selection_mode, Shortcut.Selection, list);
        AbstractC12991c.m14003x(activity, C9086R.string.hw_toolbar_item_change_style, Shortcut.ChangeStyle, list);
    }

    private void initUndoRedo(Activity activity, List<KeyboardShortcutInfo> list) {
        AbstractC12991c.m14003x(activity, C9086R.string.base_string_undo, Shortcut.Undo, list);
        AbstractC12991c.m14003x(activity, C9086R.string.base_string_redo, Shortcut.Redo, list);
    }

    private void initVoicePanel(Activity activity, List<KeyboardShortcutInfo> list) {
        AbstractC12991c.m14003x(activity, C9086R.string.composer_show_voice_panel, Shortcut.VoicePanel, list);
    }

    private void initZoom(Activity activity, List<KeyboardShortcutInfo> list) {
        AbstractC12991c.m14003x(activity, C9086R.string.ble_zoom_in, Shortcut.ZoomIn, list);
        AbstractC12991c.m14003x(activity, C9086R.string.ble_zoom_out, Shortcut.ZoomOut, list);
    }

    private void initZoomLock(Activity activity, List<KeyboardShortcutInfo> list) {
        AbstractC12991c.m14003x(activity, C9086R.string.composer_zoom_lock_on_off, Shortcut.ZoomLock, list);
    }

    public KeyboardShortcutGroup getKeyboardShortcutGroup(Activity activity, boolean z, Mode mode) {
        ArrayList arrayList = new ArrayList();
        initCutCopyPaste(activity, arrayList);
        initSelectAll(activity, arrayList);
        initTextOption(activity, arrayList);
        initUndoRedo(activity, arrayList);
        initSave(activity, arrayList);
        initDelete(activity, arrayList);
        initFind(activity, arrayList);
        initFontSize(activity, arrayList);
        initAlign(activity, arrayList);
        initTextIndent(activity, arrayList);
        initFontColor(activity, arrayList);
        initZoom(activity, arrayList);
        initOptionMenu(activity, arrayList, z);
        initZoomLock(activity, arrayList);
        initNoteStyle(activity, arrayList);
        initSaveAs(activity, arrayList);
        initInsertContent(activity, arrayList);
        initSetting(activity, arrayList, mode);
        initToolbar(activity, arrayList);
        initVoicePanel(activity, arrayList);
        initAudioSeek(activity, arrayList);
        return new KeyboardShortcutGroup(activity.getResources().getString(C9086R.string.app_name), arrayList);
    }

    public void initFind(Activity activity, List<KeyboardShortcutInfo> list) {
        AbstractC12991c.m14003x(activity, C9086R.string.composer_search_note, Shortcut.Find, list);
    }
}
