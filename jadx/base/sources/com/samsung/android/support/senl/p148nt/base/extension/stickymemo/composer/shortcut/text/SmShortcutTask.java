package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.shortcut.text;

import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmModeControl;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.text.SmTextManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/shortcut/text/SmShortcutTask;", "Lcom/samsung/android/support/senl/nt/base/composer/shortcut/AbsShortCutAction;", "shortcut", "Lcom/samsung/android/support/senl/nt/base/composer/shortcut/Shortcut;", "modeControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmModeControl;", "textManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/composer/shortcut/Shortcut;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmModeControl;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;)V", "taskType", "", "doAction", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmShortcutTask extends AbsShortCutAction {
    private static final int INVALID = -1;

    @NotNull
    private final SmModeControl modeControl;

    @NotNull
    private final Shortcut shortcut;
    private final int taskType;

    @NotNull
    private final SmTextManager textManager;

    @NotNull
    private static final String TAG = SmLogger.createTag("SmShortcutTask");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Shortcut.values().length];
            try {
                iArr[Shortcut.TaskSpanTodo.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Shortcut.TaskSpanBullet.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Shortcut.TaskSpanNumbering.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmShortcutTask(@NotNull Shortcut shortcut, @NotNull SmModeControl modeControl, @NotNull SmTextManager textManager) {
        super(shortcut);
        Intrinsics.checkNotNullParameter(shortcut, "shortcut");
        Intrinsics.checkNotNullParameter(modeControl, "modeControl");
        Intrinsics.checkNotNullParameter(textManager, "textManager");
        this.shortcut = shortcut;
        this.modeControl = modeControl;
        this.textManager = textManager;
        int i = WhenMappings.$EnumSwitchMapping$0[shortcut.ordinal()];
        this.taskType = i != 1 ? i != 2 ? i != 3 ? -1 : 4 : 8 : 2;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction() {
        SmLogger.m8661d(TAG, "doAction# " + this.taskType);
        if (this.taskType == -1 || !this.modeControl.isTextMode()) {
            return false;
        }
        this.textManager.toggleTask(this.taskType);
        return true;
    }
}
