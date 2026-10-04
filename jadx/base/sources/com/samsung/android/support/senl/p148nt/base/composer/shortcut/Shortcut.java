package com.samsung.android.support.senl.p148nt.base.composer.shortcut;

import android.view.KeyboardShortcutInfo;
import androidx.fragment.app.FragmentTransaction;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\bT\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B#\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bPj\u0002\bQj\u0002\bRj\u0002\bSj\u0002\bTj\u0002\bUj\u0002\bVj\u0002\bWj\u0002\bXj\u0002\bY¨\u0006^"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/shortcut/Shortcut;", "", "keyCode", "", "metaState", "editType", "", "<init>", "(Ljava/lang/String;IIIZ)V", "getKeyCode", "()I", "getMetaState", "getEditType", "()Z", "setEditType", "(Z)V", "None", Bixby2Constants.BIXBY_ACTION_COPY, "AdbCopy", "Cut", "AdbCut", Bixby2Constants.BIXBY_ACTION_PASTE, "AdbPaste", "SelectAll", "Delete", "DeleteSecond", "Clipboard", "AudioPlay", "EditMode", "EditTitle", "Find", "FullScreen", "ScrollUp", "ScrollDown", "ScrollLeft", "ScrollRight", "FitToScreen", "PageList", "PageScrollUp", "PageScrollDown", "ZoomIn", "ZoomOut", "Print", "ReadingMode", "Save", "SaveAs", "SeekAudioForward", "SeekAudioBackward", "VoicePanel", "ZoomLock", "NotesStyle", "InsertAudio", "InsertDrawing", "InsertImage", "InsertPDF", "InsertVoice", "InsertNewPage", "Redo", "Undo", "ToolbarSetting", "TextMode", "Pen", "Highlighter", "Eraser", "Selection", "ChangeStyle", "AlignRight", "AlignCenter", "AlignLeft", "Bold", "FontSizeIncrease", "FontSizeDecrease", "Indent", "Outdent", "Italic", "Strikethrough", "Underline", "TaskSpanNumbering", "TaskSpanBullet", "TaskSpanTodo", "AddTextBox", "TextColor", "TextBackgroundColor", "RemoteEraser", "RemoteFavoritePenForward", "RemoteFavoritePenBackward", "RemoteUndo", "RemoteRedo", "ShortCutInfo", "ShortCutInfo2", "makeKeyboardShortcutInfo", "Landroid/view/KeyboardShortcutInfo;", "name", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class Shortcut {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Shortcut[] $VALUES;
    public static final Shortcut Delete;
    public static final Shortcut InsertAudio;
    public static final Shortcut Print;
    public static final Shortcut ScrollDown;
    private boolean editType;
    private final int keyCode;
    private final int metaState;
    public static final Shortcut None = new Shortcut("None", 0, 0, 0, false, 4, null);
    public static final Shortcut Copy = new Shortcut(Bixby2Constants.BIXBY_ACTION_COPY, 1, 31, 4096, false, 4, null);
    public static final Shortcut AdbCopy = new Shortcut("AdbCopy", 2, 278, 0 == true ? 1 : 0, false, 4, null);
    public static final Shortcut Cut = new Shortcut("Cut", 3, 52, 4096, false, 4, null);
    public static final Shortcut AdbCut = new Shortcut("AdbCut", 4, 277, 0 == true ? 1 : 0, false, 4, null);
    public static final Shortcut Paste = new Shortcut(Bixby2Constants.BIXBY_ACTION_PASTE, 5, 50, 4096, false, 4, null);
    public static final Shortcut AdbPaste = new Shortcut("AdbPaste", 6, 279, 0 == true ? 1 : 0, false, 4, null);
    public static final Shortcut SelectAll = new Shortcut("SelectAll", 7, 29, 4096, false, 4, null);
    public static final Shortcut DeleteSecond = new Shortcut("DeleteSecond", 9, 32, 4096, false, 4, null);
    public static final Shortcut Clipboard = new Shortcut("Clipboard", 10, 1009, 0 == true ? 1 : 0, false, 4, null);
    public static final Shortcut AudioPlay = new Shortcut("AudioPlay", 11, 75, 4096, false, 4, null);
    public static final Shortcut EditMode = new Shortcut("EditMode", 12, 66, 0 == true ? 1 : 0, false, 4, null);
    public static final Shortcut EditTitle = new Shortcut("EditTitle", 13, 48, 17, false, 4, null);
    public static final Shortcut Find = new Shortcut("Find", 14, 34, 4096, false, 4, null);
    public static final Shortcut FullScreen = new Shortcut("FullScreen", 15, 34, 16, false, 4, null);
    public static final Shortcut ScrollUp = new Shortcut("ScrollUp", 16, 19, 16, false, 4, null);
    public static final Shortcut ScrollLeft = new Shortcut("ScrollLeft", 18, 21, 16, false, 4, null);
    public static final Shortcut ScrollRight = new Shortcut("ScrollRight", 19, 22, 16, false, 4, null);
    public static final Shortcut FitToScreen = new Shortcut("FitToScreen", 20, 45, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, false, 4, null);
    public static final Shortcut PageList = new Shortcut("PageList", 21, 44, 16, false, 4, null);
    public static final Shortcut PageScrollUp = new Shortcut("PageScrollUp", 22, 92, 0 == true ? 1 : 0, false, 4, null);
    public static final Shortcut PageScrollDown = new Shortcut("PageScrollDown", 23, 93, 0 == true ? 1 : 0, false, 4, null);
    public static final Shortcut ZoomIn = new Shortcut("ZoomIn", 24, 70, 4096, false, 4, null);
    public static final Shortcut ZoomOut = new Shortcut("ZoomOut", 25, 69, 4096, false, 4, null);
    public static final Shortcut ReadingMode = new Shortcut("ReadingMode", 27, 66, 16, false, 4, null);
    public static final Shortcut Save = new Shortcut("Save", 28, 47, 4096, false, 4, null);
    public static final Shortcut SaveAs = new Shortcut("SaveAs", 29, 47, 16, false, 4, null);
    public static final Shortcut SeekAudioForward = new Shortcut("SeekAudioForward", 30, 56, 4096, false, 4, null);
    public static final Shortcut SeekAudioBackward = new Shortcut("SeekAudioBackward", 31, 55, 4096, false, 4, null);
    public static final Shortcut VoicePanel = new Shortcut("VoicePanel", 32, 46, 16, false, 4, null);
    public static final Shortcut ZoomLock = new Shortcut("ZoomLock", 33, 40, 4112, false, 4, null);
    public static final Shortcut NotesStyle = new Shortcut("NotesStyle", 34, 48, 16, false, 4, null);
    public static final Shortcut InsertDrawing = new Shortcut("InsertDrawing", 36, 32, 17, false, 4, null);
    public static final Shortcut InsertImage = new Shortcut("InsertImage", 37, 33, 17, false, 4, null);
    public static final Shortcut InsertPDF = new Shortcut("InsertPDF", 38, 44, 17, false, 4, null);
    public static final Shortcut InsertVoice = new Shortcut("InsertVoice", 39, 50, 17, false, 4, null);
    public static final Shortcut InsertNewPage = new Shortcut("InsertNewPage", 40, 42, 4096, true);
    public static final Shortcut Redo = new Shortcut("Redo", 41, 53, 4096, true);
    public static final Shortcut Undo = new Shortcut("Undo", 42, 54, 4096, true);
    public static final Shortcut ToolbarSetting = new Shortcut("ToolbarSetting", 43, 48, 4096, true);
    public static final Shortcut TextMode = new Shortcut("TextMode", 44, 8, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, false, 4, null);
    public static final Shortcut Pen = new Shortcut("Pen", 45, 9, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, false, 4, null);
    public static final Shortcut Highlighter = new Shortcut("Highlighter", 46, 10, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, false, 4, null);
    public static final Shortcut Eraser = new Shortcut("Eraser", 47, 11, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, false, 4, null);
    public static final Shortcut Selection = new Shortcut("Selection", 48, 12, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, false, 4, null);
    public static final Shortcut ChangeStyle = new Shortcut("ChangeStyle", 49, 29, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, false, 4, null);
    public static final Shortcut AlignRight = new Shortcut("AlignRight", 50, 46, 4096, true);
    public static final Shortcut AlignCenter = new Shortcut("AlignCenter", 51, 33, 4096, true);
    public static final Shortcut AlignLeft = new Shortcut("AlignLeft", 52, 40, 4096, true);
    public static final Shortcut Bold = new Shortcut("Bold", 53, 30, 4096, true);
    public static final Shortcut FontSizeIncrease = new Shortcut("FontSizeIncrease", 54, 72, 4096, true);
    public static final Shortcut FontSizeDecrease = new Shortcut("FontSizeDecrease", 55, 71, 4096, true);
    public static final Shortcut Indent = new Shortcut("Indent", 56, 41, 4096, true);
    public static final Shortcut Outdent = new Shortcut("Outdent", 57, 41, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, true);
    public static final Shortcut Italic = new Shortcut("Italic", 58, 37, 4096, true);
    public static final Shortcut Strikethrough = new Shortcut("Strikethrough", 59, 76, 4096, true);
    public static final Shortcut Underline = new Shortcut("Underline", 60, 49, 4096, true);
    public static final Shortcut TaskSpanNumbering = new Shortcut("TaskSpanNumbering", 61, 14, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, true);
    public static final Shortcut TaskSpanBullet = new Shortcut("TaskSpanBullet", 62, 15, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, true);
    public static final Shortcut TaskSpanTodo = new Shortcut("TaskSpanTodo", 63, 31, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, true);
    public static final Shortcut AddTextBox = new Shortcut("AddTextBox", 64, 48, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, true);
    public static final Shortcut TextColor = new Shortcut("TextColor", 65, 55, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, true);
    public static final Shortcut TextBackgroundColor = new Shortcut("TextBackgroundColor", 66, 56, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, true);
    public static final Shortcut RemoteEraser = new Shortcut("RemoteEraser", 67, 32, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, true);
    public static final Shortcut RemoteFavoritePenForward = new Shortcut("RemoteFavoritePenForward", 68, 34, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, true);
    public static final Shortcut RemoteFavoritePenBackward = new Shortcut("RemoteFavoritePenBackward", 69, 44, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, true);
    public static final Shortcut RemoteUndo = new Shortcut("RemoteUndo", 70, 54, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, true);
    public static final Shortcut RemoteRedo = new Shortcut("RemoteRedo", 71, 53, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, true);
    public static final Shortcut ShortCutInfo = new Shortcut("ShortCutInfo", 72, 131, 0, false, 4, null);
    public static final Shortcut ShortCutInfo2 = new Shortcut("ShortCutInfo2", 73, 76, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, false, 4, null);

    private static final /* synthetic */ Shortcut[] $values() {
        return new Shortcut[]{None, Copy, AdbCopy, Cut, AdbCut, Paste, AdbPaste, SelectAll, Delete, DeleteSecond, Clipboard, AudioPlay, EditMode, EditTitle, Find, FullScreen, ScrollUp, ScrollDown, ScrollLeft, ScrollRight, FitToScreen, PageList, PageScrollUp, PageScrollDown, ZoomIn, ZoomOut, Print, ReadingMode, Save, SaveAs, SeekAudioForward, SeekAudioBackward, VoicePanel, ZoomLock, NotesStyle, InsertAudio, InsertDrawing, InsertImage, InsertPDF, InsertVoice, InsertNewPage, Redo, Undo, ToolbarSetting, TextMode, Pen, Highlighter, Eraser, Selection, ChangeStyle, AlignRight, AlignCenter, AlignLeft, Bold, FontSizeIncrease, FontSizeDecrease, Indent, Outdent, Italic, Strikethrough, Underline, TaskSpanNumbering, TaskSpanBullet, TaskSpanTodo, AddTextBox, TextColor, TextBackgroundColor, RemoteEraser, RemoteFavoritePenForward, RemoteFavoritePenBackward, RemoteUndo, RemoteRedo, ShortCutInfo, ShortCutInfo2};
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        Delete = new Shortcut("Delete", 8, 112, 0 == true ? 1 : 0, false, 4, defaultConstructorMarker);
        ScrollDown = new Shortcut("ScrollDown", 17, 20, 16, false, 4, defaultConstructorMarker);
        Print = new Shortcut("Print", 26, 44, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, false, 4, defaultConstructorMarker);
        InsertAudio = new Shortcut("InsertAudio", 35, 49, 17, false, 4, defaultConstructorMarker);
        Shortcut[] shortcutArr$values = $values();
        $VALUES = shortcutArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(shortcutArr$values);
    }

    private Shortcut(String str, int i, int i2, int i4, boolean z) {
        this.keyCode = i2;
        this.metaState = i4;
        this.editType = z;
    }

    @NotNull
    public static EnumEntries<Shortcut> getEntries() {
        return $ENTRIES;
    }

    public static Shortcut valueOf(String str) {
        return (Shortcut) Enum.valueOf(Shortcut.class, str);
    }

    public static Shortcut[] values() {
        return (Shortcut[]) $VALUES.clone();
    }

    public final boolean getEditType() {
        return this.editType;
    }

    public final int getKeyCode() {
        return this.keyCode;
    }

    public final int getMetaState() {
        return this.metaState;
    }

    @NotNull
    public final KeyboardShortcutInfo makeKeyboardShortcutInfo(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new KeyboardShortcutInfo(name, this.keyCode, this.metaState);
    }

    public final void setEditType(boolean z) {
        this.editType = z;
    }

    public /* synthetic */ Shortcut(String str, int i, int i2, int i4, boolean z, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, i4, (i5 & 4) != 0 ? false : z);
    }
}
