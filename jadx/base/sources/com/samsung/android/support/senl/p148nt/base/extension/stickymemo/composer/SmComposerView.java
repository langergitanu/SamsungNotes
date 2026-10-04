package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.samsung.android.sdk.composer.SpenTextWritingView;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p148nt.base.common.NoteCaptureControl;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.ControlFactory;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmControlManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.ToolShareControl;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.listener.SmListenerManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.shortcut.SmShortcutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 <2\u00020\u0001:\u0002;<B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010 \u001a\u00020\u0007J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u0016\u0010%\u001a\u00020\"2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020\"H\u0002J\u0010\u0010)\u001a\u00020\"2\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020\"J\u000e\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020\u0015J\u0006\u00100\u001a\u00020\u0015J\u0006\u00101\u001a\u00020\"J\u0006\u00102\u001a\u00020\"J\u0006\u00103\u001a\u00020\rJ\u0006\u00104\u001a\u00020\u000fJ\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u00020,J\u000e\u00108\u001a\u00020\"2\u0006\u00109\u001a\u00020:R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006="}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/SmComposerView;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "spenView", "Lcom/samsung/android/sdk/composer/SpenTextWritingView;", "doc", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "handler", "Landroid/os/Handler;", "smControlManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;", "listenerManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/SmListenerManager;", "contextMenuManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuManager;", "shortcutManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/shortcut/SmShortcutManager;", "colorTheme", "", "getColorTheme", "()I", "setColorTheme", "(I)V", "backgroundListener", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/SmComposerView$BackgroundListener;", "getBackgroundListener", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/SmComposerView$BackgroundListener;", "setBackgroundListener", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/SmComposerView$BackgroundListener;)V", "getView", "addViewTo", "", "parent", "Landroid/view/ViewGroup;", "init", "controlFactory", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ControlFactory;", "initModelFeature", "initViewByDoc", "updateDarkTheme", "isViewDarkTheme", "", "requestReadyForSave", "setBackgroundColor", "color", "getBackgroundColor", "release", "releaseControl", "getControlManager", "getListenerManager", "captureView", "Landroid/graphics/Bitmap;", "onBackPressed", "onConfiguration", "newConfig", "Landroid/content/res/Configuration;", "BackgroundListener", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmComposerView {

    @NotNull
    private static final String TAG = SmLogger.createTag("SmComposerView");

    @Nullable
    private BackgroundListener backgroundListener;
    private int colorTheme;
    private SmContextMenuManager contextMenuManager;
    private SpenWNote doc;

    @NotNull
    private final Handler handler;
    private SmListenerManager listenerManager;
    private SmShortcutManager shortcutManager;
    private SmControlManager smControlManager;

    @NotNull
    private final SpenTextWritingView spenView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/SmComposerView$BackgroundListener;", "", "onBackgroundColorChanged", "", "color", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface BackgroundListener {
        void onBackgroundColorChanged(int color);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public SmComposerView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.spenView = new SpenTextWritingView(context);
        this.handler = new Handler(Looper.getMainLooper());
    }

    private final void initModelFeature() {
        this.spenView.getTextManager().setDoubleTapSelectionEnabled(!SystemPropertiesCompat.INSTANCE.getInstance().isUSAModel());
    }

    private final void initViewByDoc(SpenWNote doc) {
        SmLogger smLogger = SmLogger.INSTANCE;
        String strValueOf = String.valueOf(hashCode());
        String str = TAG;
        smLogger.startTime(strValueOf, str, "initViewByDoc# start");
        this.doc = doc;
        this.spenView.setDocument(doc);
        this.spenView.setMode(1);
        this.spenView.requestFocus();
        smLogger.endTime(String.valueOf(hashCode()), str, "initViewByDoc# end");
    }

    public final void addViewTo(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.spenView.setClickable(true);
        this.spenView.setFocusable(true);
        this.spenView.setFocusableInTouchMode(true);
        this.spenView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.spenView.setFixedContentHeightEnabled(true);
        parent.addView(this.spenView, 0);
    }

    @NotNull
    public final Bitmap captureView() {
        SmLogger smLogger = SmLogger.INSTANCE;
        String strValueOf = String.valueOf(hashCode());
        String str = TAG;
        smLogger.startTime(strValueOf, str, "captureView# start");
        NoteCaptureControl noteCaptureControl = new NoteCaptureControl(this.spenView.getContext());
        SpenWNote spenWNote = this.doc;
        SpenWNote spenWNote2 = null;
        if (spenWNote == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doc");
            spenWNote = null;
        }
        noteCaptureControl.setWNote(spenWNote);
        SpenWNote spenWNote3 = this.doc;
        if (spenWNote3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doc");
            spenWNote3 = null;
        }
        SpenWPage page = spenWNote3.getPage(0);
        SpenWNote spenWNote4 = this.doc;
        if (spenWNote4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doc");
        } else {
            spenWNote2 = spenWNote4;
        }
        noteCaptureControl.setContents(page, spenWNote2.getBodyText(), 0);
        Bitmap bitmapCaptureRect = noteCaptureControl.captureRect(new RectF(0.0f, 0.0f, page.getWidth(), this.spenView.getHeight()));
        noteCaptureControl.close();
        smLogger.endTime(String.valueOf(hashCode()), str, "captureView# end");
        Intrinsics.checkNotNull(bitmapCaptureRect);
        return bitmapCaptureRect;
    }

    public final int getBackgroundColor() {
        SpenWNote spenWNote = this.doc;
        if (spenWNote == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doc");
            spenWNote = null;
        }
        return spenWNote.getPage(0).getBackgroundColor();
    }

    @Nullable
    public final BackgroundListener getBackgroundListener() {
        return this.backgroundListener;
    }

    public final int getColorTheme() {
        return this.colorTheme;
    }

    @NotNull
    public final SmControlManager getControlManager() {
        SmControlManager smControlManager = this.smControlManager;
        if (smControlManager != null) {
            return smControlManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("smControlManager");
        return null;
    }

    @NotNull
    public final SmListenerManager getListenerManager() {
        SmListenerManager smListenerManager = this.listenerManager;
        if (smListenerManager != null) {
            return smListenerManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("listenerManager");
        return null;
    }

    @NotNull
    /* JADX INFO: renamed from: getView, reason: from getter */
    public final SpenTextWritingView getSpenView() {
        return this.spenView;
    }

    public final void init(@NotNull SpenWNote doc, @NotNull ControlFactory controlFactory) {
        SmControlManager smControlManager;
        SmContextMenuManager smContextMenuManager;
        SmShortcutManager smShortcutManager;
        Intrinsics.checkNotNullParameter(doc, "doc");
        Intrinsics.checkNotNullParameter(controlFactory, "controlFactory");
        initModelFeature();
        initViewByDoc(doc);
        this.smControlManager = new SmControlManager(doc, this.spenView, this.handler, controlFactory);
        SpenTextWritingView spenTextWritingView = this.spenView;
        SmControlManager smControlManager2 = this.smControlManager;
        SmControlManager smControlManager3 = null;
        if (smControlManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smControlManager");
            smControlManager2 = null;
        }
        this.contextMenuManager = new SmContextMenuManager(spenTextWritingView, smControlManager2);
        SpenTextWritingView spenTextWritingView2 = this.spenView;
        SmContextMenuManager smContextMenuManager2 = this.contextMenuManager;
        if (smContextMenuManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contextMenuManager");
            smContextMenuManager2 = null;
        }
        SmControlManager smControlManager4 = this.smControlManager;
        if (smControlManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smControlManager");
            smControlManager4 = null;
        }
        this.shortcutManager = new SmShortcutManager(spenTextWritingView2, smContextMenuManager2, smControlManager4);
        SpenTextWritingView spenTextWritingView3 = this.spenView;
        Handler handler = this.handler;
        SmControlManager smControlManager5 = this.smControlManager;
        if (smControlManager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smControlManager");
            smControlManager = null;
        } else {
            smControlManager = smControlManager5;
        }
        SmContextMenuManager smContextMenuManager3 = this.contextMenuManager;
        if (smContextMenuManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contextMenuManager");
            smContextMenuManager = null;
        } else {
            smContextMenuManager = smContextMenuManager3;
        }
        SmShortcutManager smShortcutManager2 = this.shortcutManager;
        if (smShortcutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shortcutManager");
            smShortcutManager = null;
        } else {
            smShortcutManager = smShortcutManager2;
        }
        this.listenerManager = new SmListenerManager(spenTextWritingView3, handler, smControlManager, smContextMenuManager, smShortcutManager);
        SmControlManager smControlManager6 = this.smControlManager;
        if (smControlManager6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smControlManager");
            smControlManager6 = null;
        }
        if (smControlManager6.getToolShareControl() != null) {
            SmControlManager smControlManager7 = this.smControlManager;
            if (smControlManager7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("smControlManager");
            } else {
                smControlManager3 = smControlManager7;
            }
            ToolShareControl toolShareControl = smControlManager3.getToolShareControl();
            if (toolShareControl != null) {
                toolShareControl.init();
                return;
            }
            return;
        }
        SmControlManager smControlManager8 = this.smControlManager;
        if (smControlManager8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smControlManager");
            smControlManager8 = null;
        }
        if (smControlManager8.getModeControl().isWritingMode()) {
            SmControlManager smControlManager9 = this.smControlManager;
            if (smControlManager9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("smControlManager");
            } else {
                smControlManager3 = smControlManager9;
            }
            smControlManager3.getModeControl().setHwMode();
            return;
        }
        SmControlManager smControlManager10 = this.smControlManager;
        if (smControlManager10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smControlManager");
        } else {
            smControlManager3 = smControlManager10;
        }
        smControlManager3.getModeControl().setTextMode();
    }

    public final boolean onBackPressed() {
        SmControlManager smControlManager = this.smControlManager;
        if (smControlManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smControlManager");
            smControlManager = null;
        }
        return smControlManager.onBackPressed();
    }

    public final void onConfiguration(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        SmControlManager smControlManager = this.smControlManager;
        if (smControlManager != null) {
            if (smControlManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("smControlManager");
                smControlManager = null;
            }
            smControlManager.onConfiguration(newConfig);
        }
    }

    public final void release() {
        releaseControl();
        this.spenView.setDocument(null);
        this.spenView.close();
    }

    public final void releaseControl() {
        SmListenerManager smListenerManager = this.listenerManager;
        SmControlManager smControlManager = null;
        if (smListenerManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listenerManager");
            smListenerManager = null;
        }
        smListenerManager.release();
        SmControlManager smControlManager2 = this.smControlManager;
        if (smControlManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smControlManager");
        } else {
            smControlManager = smControlManager2;
        }
        smControlManager.release();
    }

    public final void requestReadyForSave() {
        SmLogger smLogger = SmLogger.INSTANCE;
        String strValueOf = String.valueOf(hashCode());
        String str = TAG;
        smLogger.startTime(strValueOf, str, "requestReadyForSave# start");
        SmControlManager smControlManager = this.smControlManager;
        if (smControlManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smControlManager");
            smControlManager = null;
        }
        smControlManager.getObjectManager().clearSelection();
        this.spenView.getMNoteTextManager().updateBodyTextPage();
        this.spenView.getNoteWritingViewManager().requestReadyForSave();
        smLogger.endTime(String.valueOf(hashCode()), str, "requestReadyForSave# end");
    }

    public final void setBackgroundColor(int color) {
        SpenWNote spenWNote = this.doc;
        if (spenWNote == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doc");
            spenWNote = null;
        }
        spenWNote.setBackgroundColor(color, true);
        BackgroundListener backgroundListener = this.backgroundListener;
        if (backgroundListener != null) {
            backgroundListener.onBackgroundColorChanged(color);
        }
    }

    public final void setBackgroundListener(@Nullable BackgroundListener backgroundListener) {
        this.backgroundListener = backgroundListener;
    }

    public final void setColorTheme(int i) {
        this.colorTheme = i;
    }

    public final void updateDarkTheme(boolean isViewDarkTheme) {
        SmLogger.m8661d(TAG, "updateDarkTheme# " + isViewDarkTheme);
        SpenTextWritingView spenTextWritingView = this.spenView;
        spenTextWritingView.setDarkModeEnabled(ContextUtils.isNightMode(spenTextWritingView.getContext()));
        this.colorTheme = isViewDarkTheme ? 1 : 0;
        this.spenView.setColorTheme(isViewDarkTheme ? 1 : 0);
    }
}
