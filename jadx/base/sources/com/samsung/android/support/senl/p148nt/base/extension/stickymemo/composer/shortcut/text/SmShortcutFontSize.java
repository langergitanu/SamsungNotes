package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.shortcut.text;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.FontSizeUtil;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmModeControl;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.text.SmTextManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0011\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/shortcut/text/SmShortcutFontSize;", "Lcom/samsung/android/support/senl/nt/base/composer/shortcut/AbsShortCutAction;", "shortcut", "Lcom/samsung/android/support/senl/nt/base/composer/shortcut/Shortcut;", "modeControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmModeControl;", "textManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;", "contextRef", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/composer/shortcut/Shortcut;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmModeControl;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;Ljava/lang/ref/WeakReference;)V", "isIncrease", "", "fontSizes", "", "doAction", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmShortcutFontSize extends AbsShortCutAction {

    @NotNull
    private static final String TAG = SmLogger.createTag("SmShortcutFontSize");

    @NotNull
    private final WeakReference<Context> contextRef;

    @Nullable
    private int[] fontSizes;
    private final boolean isIncrease;

    @NotNull
    private final SmModeControl modeControl;

    @NotNull
    private final SmTextManager textManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmShortcutFontSize(@NotNull Shortcut shortcut, @NotNull SmModeControl modeControl, @NotNull SmTextManager textManager, @NotNull WeakReference<Context> contextRef) {
        super(shortcut);
        Intrinsics.checkNotNullParameter(shortcut, "shortcut");
        Intrinsics.checkNotNullParameter(modeControl, "modeControl");
        Intrinsics.checkNotNullParameter(textManager, "textManager");
        Intrinsics.checkNotNullParameter(contextRef, "contextRef");
        this.modeControl = modeControl;
        this.textManager = textManager;
        this.contextRef = contextRef;
        this.isIncrease = shortcut == Shortcut.FontSizeIncrease;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction() {
        if (!this.modeControl.isTextMode()) {
            return false;
        }
        Context context = this.contextRef.get();
        if (context != null) {
            if (this.fontSizes == null) {
                this.fontSizes = FontSizeUtil.getFontSizeList(context);
            }
            int nextFontSize = FontSizeUtil.getNextFontSize(this.fontSizes, this.textManager.getFontSize(), this.isIncrease);
            SmLogger.m8661d(TAG, "doAction# " + this.isIncrease + " " + nextFontSize);
            this.textManager.setFontSize(nextFontSize, true);
        }
        SmLogger.m8662e(TAG, "doAction# context is null");
        return true;
    }
}
