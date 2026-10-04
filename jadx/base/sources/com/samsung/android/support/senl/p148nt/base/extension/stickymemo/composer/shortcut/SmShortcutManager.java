package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.shortcut;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import com.samsung.android.sdk.composer.SpenTextWritingView;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuClipboard;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuCode;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuCopy;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuCut;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuItem;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuPaste;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuSelectAll;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmControlManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmModeControl;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.ToolShareControl;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.shortcut.p152hw.SmShortcutChangeStyle;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.shortcut.p152hw.SmShortcutEraser;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.shortcut.p152hw.SmShortcutPen;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.shortcut.p152hw.SmShortcutSelection;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.shortcut.p152hw.SmShortcutTextMode;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.shortcut.text.SmShortcutAlign;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.shortcut.text.SmShortcutFontColor;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.shortcut.text.SmShortcutFontSize;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.shortcut.text.SmShortcutTask;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.shortcut.text.SmShortcutTextStyle;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.text.SmTextManager;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0002J&\u0010\u001b\u001a\u00020\u00192\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0002J \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020$H\u0002J$\u0010&\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020$2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0(H\u0002J\u000e\u0010)\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020$J\u0006\u0010*\u001a\u00020\u001eJ\u0006\u0010+\u001a\u00020\u001eJ\u0006\u0010,\u001a\u00020\u001eJ\u0006\u0010-\u001a\u00020\u001eR\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/shortcut/SmShortcutManager;", "Landroid/view/View$OnKeyListener;", "spenView", "Lcom/samsung/android/sdk/composer/SpenTextWritingView;", "contextMenuManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuManager;", "controlManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;", "<init>", "(Lcom/samsung/android/sdk/composer/SpenTextWritingView;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuManager;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;)V", "shortcutMap", "", "", "Lcom/samsung/android/support/senl/nt/base/composer/shortcut/AbsShortCutAction;", "bLEShortcutMap", "globalShortcutMap", "cutAction", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/shortcut/SmShortcutCut;", "copyAction", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/shortcut/SmShortcutCopy;", "selectAll", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/shortcut/SmShortcutSelectAll;", "pasteAction", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/shortcut/SmShortcutPaste;", "putShortcutMap", "", "action", "putAction", "map", "onKey", "", VPathDataCmd.RCurveTo, "Landroid/view/View;", "keyCode", "", "event", "Landroid/view/KeyEvent;", "keyEvent", "doAction", "keyMap", "", "onUnhandledKeyEvent", "executeCopy", "executeCut", "executePaste", "executeSelectAll", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmShortcutManager implements View.OnKeyListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SmLogger.createTag("SmShortcutManager");

    @NotNull
    private final Map<Long, AbsShortCutAction> bLEShortcutMap;

    @NotNull
    private final SmShortcutCopy copyAction;

    @NotNull
    private final SmShortcutCut cutAction;

    @NotNull
    private final Map<Long, AbsShortCutAction> globalShortcutMap;

    @NotNull
    private final SmShortcutPaste pasteAction;

    @NotNull
    private final SmShortcutSelectAll selectAll;

    @NotNull
    private final Map<Long, AbsShortCutAction> shortcutMap;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/shortcut/SmShortcutManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return SmShortcutManager.TAG;
        }

        private Companion() {
        }
    }

    public SmShortcutManager(@NotNull SpenTextWritingView spenView, @NotNull SmContextMenuManager contextMenuManager, @NotNull SmControlManager controlManager) {
        Intrinsics.checkNotNullParameter(spenView, "spenView");
        Intrinsics.checkNotNullParameter(contextMenuManager, "contextMenuManager");
        Intrinsics.checkNotNullParameter(controlManager, "controlManager");
        this.shortcutMap = new HashMap();
        this.bLEShortcutMap = new HashMap();
        this.globalShortcutMap = new HashMap();
        SmContextMenuItem menu = contextMenuManager.getMenu(SmContextMenuCode.CONTEXT_MENU_ID_CUT);
        Intrinsics.checkNotNull(menu, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuCut");
        SmShortcutCut smShortcutCut = new SmShortcutCut((SmContextMenuCut) menu);
        this.cutAction = smShortcutCut;
        SmContextMenuItem menu2 = contextMenuManager.getMenu(SmContextMenuCode.CONTEXT_MENU_ID_COPY);
        Intrinsics.checkNotNull(menu2, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuCopy");
        SmShortcutCopy smShortcutCopy = new SmShortcutCopy((SmContextMenuCopy) menu2);
        this.copyAction = smShortcutCopy;
        SmContextMenuItem menu3 = contextMenuManager.getMenu(SmContextMenuCode.CONTEXT_MENU_ID_SELECT_ALL);
        Intrinsics.checkNotNull(menu3, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuSelectAll");
        SmShortcutSelectAll smShortcutSelectAll = new SmShortcutSelectAll((SmContextMenuSelectAll) menu3);
        this.selectAll = smShortcutSelectAll;
        SmContextMenuItem menu4 = contextMenuManager.getMenu(SmContextMenuCode.CONTEXT_MENU_ID_PASTE);
        Intrinsics.checkNotNull(menu4, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuPaste");
        SmShortcutPaste smShortcutPaste = new SmShortcutPaste((SmContextMenuPaste) menu4);
        this.pasteAction = smShortcutPaste;
        Context context = spenView.getContext();
        SmModeControl modeControl = controlManager.getModeControl();
        SmTextManager textManager = controlManager.getTextManager();
        ToolShareControl toolShareControl = controlManager.getToolShareControl();
        Intrinsics.checkNotNull(toolShareControl);
        putShortcutMap(smShortcutCut);
        putShortcutMap(smShortcutCopy);
        putShortcutMap(smShortcutPaste);
        putShortcutMap(smShortcutSelectAll);
        SmContextMenuItem menu5 = contextMenuManager.getMenu(SmContextMenuCode.CONTEXT_MENU_ID_CLIPBOARD);
        Intrinsics.checkNotNull(menu5, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuClipboard");
        putShortcutMap(new SmShortcutClipboard((SmContextMenuClipboard) menu5));
        putShortcutMap(new SmShortcutUndo(controlManager.getObjectManager()));
        putShortcutMap(new SmShortcutRedo(controlManager.getObjectManager()));
        putShortcutMap(new SmShortcutToolbarSetting(toolShareControl, modeControl));
        putShortcutMap(new SmShortcutTextStyle(Shortcut.Bold, modeControl, textManager));
        putShortcutMap(new SmShortcutTextStyle(Shortcut.Italic, modeControl, textManager));
        putShortcutMap(new SmShortcutTextStyle(Shortcut.Strikethrough, modeControl, textManager));
        putShortcutMap(new SmShortcutTextStyle(Shortcut.Underline, modeControl, textManager));
        putShortcutMap(new SmShortcutTask(Shortcut.TaskSpanTodo, modeControl, textManager));
        putShortcutMap(new SmShortcutTask(Shortcut.TaskSpanNumbering, modeControl, textManager));
        putShortcutMap(new SmShortcutTask(Shortcut.TaskSpanBullet, modeControl, textManager));
        putShortcutMap(new SmShortcutFontSize(Shortcut.FontSizeIncrease, modeControl, textManager, new WeakReference(context)));
        putShortcutMap(new SmShortcutFontColor(Shortcut.TextColor, toolShareControl, modeControl));
        putShortcutMap(new SmShortcutFontColor(Shortcut.TextBackgroundColor, toolShareControl, modeControl));
        putShortcutMap(new SmShortcutFontSize(Shortcut.FontSizeDecrease, modeControl, textManager, new WeakReference(context)));
        putShortcutMap(new SmShortcutAlign(Shortcut.AlignLeft, modeControl, textManager));
        putShortcutMap(new SmShortcutAlign(Shortcut.AlignRight, modeControl, textManager));
        putShortcutMap(new SmShortcutAlign(Shortcut.AlignCenter, modeControl, textManager));
        putShortcutMap(new SmShortcutTextMode(toolShareControl, modeControl, controlManager.getSipController()));
        putShortcutMap(new SmShortcutPen(toolShareControl, modeControl));
        putShortcutMap(new SmShortcutEraser(toolShareControl, modeControl));
        putShortcutMap(new SmShortcutSelection(toolShareControl, modeControl));
        putShortcutMap(new SmShortcutChangeStyle(toolShareControl, modeControl));
    }

    private final boolean doAction(KeyEvent keyEvent, Map<Long, ? extends AbsShortCutAction> keyMap) {
        long jConvertKey = AbsShortCutAction.convertKey(keyEvent);
        AbsShortCutAction absShortCutAction = keyMap.get(Long.valueOf(jConvertKey));
        if (absShortCutAction == null) {
            return false;
        }
        SmLogger.m8666i(TAG, "doAction# " + jConvertKey + " action" + absShortCutAction);
        return absShortCutAction.doAction(keyEvent);
    }

    private final void putAction(Map<Long, AbsShortCutAction> map, AbsShortCutAction action) {
        if (action == null) {
            SmLogger.m8662e(TAG, "putAction# action is null");
        } else {
            map.put(Long.valueOf(action.getKey()), action);
        }
    }

    private final void putShortcutMap(AbsShortCutAction action) {
        putAction(this.shortcutMap, action);
    }

    public final boolean executeCopy() {
        return this.copyAction.doAction();
    }

    public final boolean executeCut() {
        return this.cutAction.doAction();
    }

    public final boolean executePaste() {
        return this.pasteAction.doAction();
    }

    public final boolean executeSelectAll() {
        return this.selectAll.doAction();
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(@NotNull View v, int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        return onKey(event);
    }

    public final boolean onUnhandledKeyEvent(@NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        if (keyEvent.getAction() != 0) {
            return false;
        }
        return doAction(keyEvent, this.globalShortcutMap);
    }

    private final boolean onKey(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && (keyEvent.getFlags() & 33554432) == 0) {
            return doAction(keyEvent, this.shortcutMap);
        }
        return false;
    }
}
