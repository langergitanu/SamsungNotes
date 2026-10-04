package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool;

import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenLayout;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b7\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013J\u001e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rJ\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\u0019\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006K"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/QuickToolSA;", "", "<init>", "()V", "shouldLogFirstBehavior", "", "getShouldLogFirstBehavior", "()Z", "setShouldLogFirstBehavior", "(Z)V", "logFirstBehavior", "", NetworkConfig.CLIENTS_FEEDBACK_DETAIL, "", "log", "event", "mode", "", "type", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$RotationType;", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenLayout$ViewMode;", "getSADetailPenType", "penName", "getAlphaPercent", "alpha", "SCREEN_EDIT_MAIN", "EVENT_QT_CALL_QUICK_TOOLS", "EVENT_QT_PEN_LIST", "EVENT_QT_THICKNESS_AND_TRANSPARENCY", "EVENT_QT_COLOR_LIST", "EVENT_QT_EYEDROPPER", "EVENT_QT_COLOR_PICKER", "EVENT_QT_NOTE_ASSIST_AUTO_FORMAT", "EVENT_QT_NOTE_ASSIST_SUMMARIZE", "EVENT_QT_NOTE_ASSIST_TRANSLATE", "EVENT_QT_NOTE_ASSIST_DRAWING_ASSIST", "EVENT_QT_NOTE_ASSIST_TRANSCRIBE", "EVENT_QT_ADD_FAVORITE_PEN", "EVENT_QT_FIRST_BEHAVIOR", "EVENT_QT_SELECT_PEN_STYLE", "EVENT_QT_MODIFY_PEN_THICKNESS", "EVENT_QT_MODIFY_PEN_TRANSPARENCY", "EVENT_QT_CHANGE_FAVORITE_PEN", "EVENT_QT_DOCKING", "EVENT_QT_MOVE_QUICK_TOOLS", "EVENT_QT_LAST_MODE", "EVENT_QT_CHANGE_MODE", "DETAIL_QT_FIRST_BEHAVIOR_PEN_LIST", "DETAIL_QT_FIRST_BEHAVIOR_THICKNESS", "DETAIL_QT_FIRST_BEHAVIOR_PEN_COLOR", "DETAIL_QT_FIRST_BEHAVIOR_FAVORITE_MODE", "DETAIL_QT_FIRST_BEHAVIOR_PEN_SETTINGS_MODE", "DETAIL_QT_FIRST_BEHAVIOR_NOTE_ASSIST_MODE", "DETAIL_QT_FIRST_BEHAVIOR_NOTE_ASSIST_FEATURES", "DETAIL_QT_FIRST_BEHAVIOR_DRAG_QUICK_TOOLS", "DETAIL_QT_FIRST_BEHAVIOR_DRAG_TO_DOCKING", "DETAIL_QT_FIRST_BEHAVIOR_CLOSE_BY_TAPPING", "DETAIL_QT_FIRST_BEHAVIOR_CLOSE_BY_PEN_BUTTON", "DETAIL_QT_FLOATING", "DETAIL_QT_DOCKING", "DETAIL_QT_FAVORITE_FLOATING_MAIN", "DETAIL_QT_FAVORITE_FLOATING_FAVORITE", "DETAIL_QT_FAVORITE_DOCKING", "DETAIL_QT_STYLE_FOUNTAIN_PEN", "DETAIL_QT_STYLE_CALLIGRAPHY_PEN", "DETAIL_QT_STYLE_PEN", "DETAIL_QT_STYLE_PENCIL", "DETAIL_QT_STYLE_CALLIGRAPHY_BRUSH", "DETAIL_QT_STYLE_HIGHLIGHTER", "DETAIL_QT_STYLE_MAKER_PEN", "DETAIL_QT_STYLE_STRAIGHT_HIGHLIGHTER", "DETAIL_QT_STYLE_STRAIGHT_MARKER", "DETAIL_QT_MODE_PEN_SETTING", "DETAIL_QT_MODE_FAVORITE", "DETAIL_QT_MODE_NOTES_ASSIST", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class QuickToolSA {

    @NotNull
    private static final String DETAIL_QT_DOCKING = "2";

    @NotNull
    private static final String DETAIL_QT_FAVORITE_DOCKING = "3";

    @NotNull
    private static final String DETAIL_QT_FAVORITE_FLOATING_FAVORITE = "2";

    @NotNull
    private static final String DETAIL_QT_FAVORITE_FLOATING_MAIN = "1";

    @NotNull
    public static final String DETAIL_QT_FIRST_BEHAVIOR_CLOSE_BY_PEN_BUTTON = "11";

    @NotNull
    public static final String DETAIL_QT_FIRST_BEHAVIOR_CLOSE_BY_TAPPING = "10";

    @NotNull
    public static final String DETAIL_QT_FIRST_BEHAVIOR_DRAG_QUICK_TOOLS = "8";

    @NotNull
    public static final String DETAIL_QT_FIRST_BEHAVIOR_DRAG_TO_DOCKING = "9";

    @NotNull
    public static final String DETAIL_QT_FIRST_BEHAVIOR_FAVORITE_MODE = "4";

    @NotNull
    public static final String DETAIL_QT_FIRST_BEHAVIOR_NOTE_ASSIST_FEATURES = "7";

    @NotNull
    public static final String DETAIL_QT_FIRST_BEHAVIOR_NOTE_ASSIST_MODE = "6";

    @NotNull
    public static final String DETAIL_QT_FIRST_BEHAVIOR_PEN_COLOR = "3";

    @NotNull
    public static final String DETAIL_QT_FIRST_BEHAVIOR_PEN_LIST = "1";

    @NotNull
    public static final String DETAIL_QT_FIRST_BEHAVIOR_PEN_SETTINGS_MODE = "5";

    @NotNull
    public static final String DETAIL_QT_FIRST_BEHAVIOR_THICKNESS = "2";

    @NotNull
    private static final String DETAIL_QT_FLOATING = "1";

    @NotNull
    private static final String DETAIL_QT_MODE_FAVORITE = "2";

    @NotNull
    private static final String DETAIL_QT_MODE_NOTES_ASSIST = "3";

    @NotNull
    private static final String DETAIL_QT_MODE_PEN_SETTING = "1";

    @NotNull
    private static final String DETAIL_QT_STYLE_CALLIGRAPHY_BRUSH = "5";

    @NotNull
    private static final String DETAIL_QT_STYLE_CALLIGRAPHY_PEN = "2";

    @NotNull
    private static final String DETAIL_QT_STYLE_FOUNTAIN_PEN = "1";

    @NotNull
    private static final String DETAIL_QT_STYLE_HIGHLIGHTER = "6";

    @NotNull
    private static final String DETAIL_QT_STYLE_MAKER_PEN = "7";

    @NotNull
    private static final String DETAIL_QT_STYLE_PEN = "3";

    @NotNull
    private static final String DETAIL_QT_STYLE_PENCIL = "4";

    @NotNull
    private static final String DETAIL_QT_STYLE_STRAIGHT_HIGHLIGHTER = "8";

    @NotNull
    private static final String DETAIL_QT_STYLE_STRAIGHT_MARKER = "9";

    @NotNull
    public static final String EVENT_QT_ADD_FAVORITE_PEN = "QTLS0012";

    @NotNull
    public static final String EVENT_QT_CALL_QUICK_TOOLS = "QTLS0001";

    @NotNull
    public static final String EVENT_QT_CHANGE_FAVORITE_PEN = "QTLS0017";

    @NotNull
    public static final String EVENT_QT_CHANGE_MODE = "QTLS0021";

    @NotNull
    public static final String EVENT_QT_COLOR_LIST = "QTLS0004";

    @NotNull
    public static final String EVENT_QT_COLOR_PICKER = "QTLS0006";

    @NotNull
    public static final String EVENT_QT_DOCKING = "QTLS0018";

    @NotNull
    public static final String EVENT_QT_EYEDROPPER = "QTLS0005";

    @NotNull
    private static final String EVENT_QT_FIRST_BEHAVIOR = "QTLS0013";

    @NotNull
    public static final String EVENT_QT_LAST_MODE = "QTLS0020";

    @NotNull
    public static final String EVENT_QT_MODIFY_PEN_THICKNESS = "QTLS0015";

    @NotNull
    public static final String EVENT_QT_MODIFY_PEN_TRANSPARENCY = "QTLS0016";

    @NotNull
    public static final String EVENT_QT_MOVE_QUICK_TOOLS = "QTLS0019";

    @NotNull
    public static final String EVENT_QT_NOTE_ASSIST_AUTO_FORMAT = "QTLS0007";

    @NotNull
    public static final String EVENT_QT_NOTE_ASSIST_DRAWING_ASSIST = "QTLS0010";

    @NotNull
    public static final String EVENT_QT_NOTE_ASSIST_SUMMARIZE = "QTLS0008";

    @NotNull
    public static final String EVENT_QT_NOTE_ASSIST_TRANSCRIBE = "QTLS0011";

    @NotNull
    public static final String EVENT_QT_NOTE_ASSIST_TRANSLATE = "QTLS0009";

    @NotNull
    public static final String EVENT_QT_PEN_LIST = "QTLS0002";

    @NotNull
    public static final String EVENT_QT_SELECT_PEN_STYLE = "QTLS0014";

    @NotNull
    public static final String EVENT_QT_THICKNESS_AND_TRANSPARENCY = "QTLS0003";

    @NotNull
    public static final QuickToolSA INSTANCE = new QuickToolSA();

    @NotNull
    private static final String SCREEN_EDIT_MAIN = "401";
    private static boolean shouldLogFirstBehavior;

    private QuickToolSA() {
    }

    public final int getAlphaPercent(int alpha) {
        return (alpha * 100) / 255;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @NotNull
    public final String getSADetailPenType(@NotNull String penName) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        switch (penName.hashCode()) {
            case -1720765579:
                return !penName.equals(SpenPenManager.SPEN_MARKER2) ? "" : "7";
            case -1720765578:
                return !penName.equals(SpenPenManager.SPEN_MARKER3) ? "" : "7";
            case -1720765577:
                return !penName.equals(SpenPenManager.SPEN_MARKER4) ? "" : "6";
            case -1499175198:
                return !penName.equals(SpenPenManager.SPEN_BRUSH_PEN) ? "" : "5";
            case -610903172:
                return !penName.equals(SpenPenManager.SPEN_INK_PEN2) ? "" : "3";
            case 202751947:
                return !penName.equals(SpenPenManager.SPEN_OBLIQUE_PEN) ? "" : "2";
            case 383993284:
                return !penName.equals(SpenPenManager.SPEN_STRAIGHT_HIGHLIGHTER) ? "" : "8";
            case 478214391:
                return !penName.equals(SpenPenManager.SPEN_STRAIGHT_MARKER) ? "" : "9";
            case 1052333314:
                return !penName.equals(SpenPenManager.SPEN_PENCIL2) ? "" : "4";
            case 1052333315:
                return !penName.equals(SpenPenManager.SPEN_PENCIL3) ? "" : "4";
            case 1559752130:
                return !penName.equals(SpenPenManager.SPEN_FOUNTAIN_PEN) ? "" : "1";
            case 1642861430:
                return !penName.equals(SpenPenManager.SPEN_INK_PEN) ? "" : "3";
            case 1745606749:
                return !penName.equals(SpenPenManager.SPEN_MARKER) ? "" : "6";
            case 1835061552:
                return !penName.equals(SpenPenManager.SPEN_PENCIL) ? "" : "4";
            default:
                return "";
        }
    }

    public final boolean getShouldLogFirstBehavior() {
        return shouldLogFirstBehavior;
    }

    public final void log(@NotNull String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        NotesSamsungAnalytics.INSTANCE.insertLog("401", event);
    }

    public final void logFirstBehavior(@NotNull String detail) {
        Intrinsics.checkNotNullParameter(detail, "detail");
        if (shouldLogFirstBehavior) {
            NotesSamsungAnalytics.INSTANCE.insertLog("401", EVENT_QT_FIRST_BEHAVIOR, detail);
            shouldLogFirstBehavior = false;
        }
    }

    public final void setShouldLogFirstBehavior(boolean z) {
        shouldLogFirstBehavior = z;
    }

    public final void log(@NotNull String event, @NotNull String detail) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(detail, "detail");
        NotesSamsungAnalytics.INSTANCE.insertLog("401", event, detail);
    }

    public final void log(@NotNull String event, int mode) {
        String str;
        Intrinsics.checkNotNullParameter(event, "event");
        if (mode == 0) {
            str = "1";
        } else if (mode != 1) {
            str = "3";
        } else {
            str = "2";
        }
        NotesSamsungAnalytics.INSTANCE.insertLog("401", event, str);
    }

    public final void log(@NotNull String event, @NotNull SpenSettingQTPenContainer.RotationType type) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(type, "type");
        NotesSamsungAnalytics.INSTANCE.insertLog("401", event, type == SpenSettingQTPenContainer.RotationType.NONE ? "1" : "2");
    }

    public final void log(@NotNull String event, @NotNull SpenSettingQTPenContainer.RotationType type, @NotNull SpenSettingQTPenLayout.ViewMode mode) {
        String str;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (type == SpenSettingQTPenContainer.RotationType.NONE) {
            if (mode == SpenSettingQTPenLayout.ViewMode.MAIN) {
                str = "1";
            } else {
                str = "2";
            }
        } else {
            str = "3";
        }
        NotesSamsungAnalytics.INSTANCE.insertLog("401", event, str);
    }
}
