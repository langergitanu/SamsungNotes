package com.samsung.android.sdk.composer.listener;

import android.graphics.RectF;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.pen.engine.SpenTouchListener;
import com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuDelegateListener;
import com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u000f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0010\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0011\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bJ\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010\u001a\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u0013H\u0016J\b\u0010!\u001a\u00020\rH\u0016J\u0012\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010$\u001a\u00020\u00132\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(J\u000e\u0010)\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020*J\u0006\u0010+\u001a\u00020\rJ\u0010\u0010,\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010(J&\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020\u0013J\u000e\u00103\u001a\u00020\r2\u0006\u00104\u001a\u00020*R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/listener/SpenTextComposerListenerManager;", "Lcom/samsung/android/sdk/composer/listener/SpenIContextMenuListener;", "<init>", "()V", "mContextMenuListener", "Lcom/samsung/android/sdk/pen/view/contextmenu/SpenContextMenuListener;", "mContextMenuDelegateListener", "Lcom/samsung/android/sdk/pen/view/contextmenu/SpenContextMenuDelegateListener;", "mTouchListener", "Lcom/samsung/android/sdk/pen/engine/SpenTouchListener;", "mComposerActionListener", "Lcom/samsung/android/sdk/composer/listener/SpenComposerActionListener;", "setContextMenuListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setContextMenuDelegateListener", "setPreTouchListener", "setComposerActionListener", "onCreateActionMode", "", "mode", "Landroid/view/ActionMode;", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "onCreateContextMenu", "Landroid/view/ContextMenu;", "onActionItemClicked", "item", "Landroid/view/MenuItem;", "onShowContextMenu", "contentRect", "Landroid/graphics/RectF;", "enableVibration", "onHideContextMenu", "onUpdateContentRect", "rect", "onTouch", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "onEditModeChanged", "", "onInitLayoutFinished", "onComposerClicked", "onPullGestureAnimationUpdated", "animatedValue", "", "viewX", "viewY", "isReleased", "onTextContentOverflow", TextConst.KEY_START_INDEX, "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenTextComposerListenerManager implements SpenIContextMenuListener {

    @Nullable
    private SpenComposerActionListener mComposerActionListener;

    @Nullable
    private SpenContextMenuDelegateListener mContextMenuDelegateListener;

    @Nullable
    private SpenContextMenuListener mContextMenuListener;

    @Nullable
    private SpenTouchListener mTouchListener;

    @Override // com.samsung.android.sdk.composer.listener.SpenIContextMenuListener
    public boolean onActionItemClicked(@Nullable ActionMode mode, @Nullable MenuItem item) {
        SpenContextMenuListener spenContextMenuListener = this.mContextMenuListener;
        if (spenContextMenuListener != null) {
            return spenContextMenuListener.onActionItemClicked(mode, item);
        }
        return false;
    }

    public final void onComposerClicked(@Nullable MotionEvent event) {
        SpenComposerActionListener spenComposerActionListener = this.mComposerActionListener;
        if (spenComposerActionListener != null) {
            spenComposerActionListener.onComposerClicked(event);
        }
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenIContextMenuListener
    public boolean onCreateActionMode(@Nullable ActionMode mode, @Nullable Menu menu) {
        SpenContextMenuListener spenContextMenuListener = this.mContextMenuListener;
        if (spenContextMenuListener != null) {
            return spenContextMenuListener.onCreateActionMode(mode, menu);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenIContextMenuListener
    public void onCreateContextMenu(@Nullable ContextMenu menu) {
        SpenContextMenuListener spenContextMenuListener = this.mContextMenuListener;
        if (spenContextMenuListener != null) {
            spenContextMenuListener.onCreateContextMenu(menu);
        }
    }

    public final void onEditModeChanged(int mode) {
        SpenComposerActionListener spenComposerActionListener = this.mComposerActionListener;
        if (spenComposerActionListener != null) {
            spenComposerActionListener.onEditModeChanged(mode);
        }
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenIContextMenuListener
    public void onHideContextMenu() {
        SpenContextMenuDelegateListener spenContextMenuDelegateListener = this.mContextMenuDelegateListener;
        if (spenContextMenuDelegateListener != null) {
            spenContextMenuDelegateListener.onHideContextMenu();
        }
    }

    public final void onInitLayoutFinished() {
        SpenComposerActionListener spenComposerActionListener = this.mComposerActionListener;
        if (spenComposerActionListener != null) {
            spenComposerActionListener.onInitLayoutFinished();
        }
    }

    public final void onPullGestureAnimationUpdated(float animatedValue, float viewX, float viewY, boolean isReleased) {
        SpenComposerActionListener spenComposerActionListener = this.mComposerActionListener;
        if (spenComposerActionListener != null) {
            spenComposerActionListener.onPullGestureAnimationUpdated(animatedValue, viewX, viewY, isReleased);
        }
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenIContextMenuListener
    public boolean onShowContextMenu(@Nullable RectF contentRect, boolean enableVibration) {
        SpenContextMenuDelegateListener spenContextMenuDelegateListener = this.mContextMenuDelegateListener;
        if (spenContextMenuDelegateListener != null) {
            return spenContextMenuDelegateListener.onShowContextMenu(contentRect, enableVibration);
        }
        return false;
    }

    public final void onTextContentOverflow(int startIndex) {
        SpenComposerActionListener spenComposerActionListener = this.mComposerActionListener;
        if (spenComposerActionListener != null) {
            spenComposerActionListener.onTextContentOverflow(startIndex);
        }
    }

    public final boolean onTouch(@Nullable View view, @Nullable MotionEvent event) {
        SpenTouchListener spenTouchListener = this.mTouchListener;
        if (spenTouchListener != null) {
            return spenTouchListener.onTouch(view, event);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenIContextMenuListener
    public void onUpdateContentRect(@Nullable RectF rect) {
        SpenContextMenuDelegateListener spenContextMenuDelegateListener = this.mContextMenuDelegateListener;
        if (spenContextMenuDelegateListener != null) {
            spenContextMenuDelegateListener.onUpdateContentRect(rect);
        }
    }

    public final void setComposerActionListener(@Nullable SpenComposerActionListener listener) {
        this.mComposerActionListener = listener;
    }

    public final void setContextMenuDelegateListener(@Nullable SpenContextMenuDelegateListener listener) {
        this.mContextMenuDelegateListener = listener;
    }

    public final void setContextMenuListener(@Nullable SpenContextMenuListener listener) {
        this.mContextMenuListener = listener;
    }

    public final void setPreTouchListener(@Nullable SpenTouchListener listener) {
        this.mTouchListener = listener;
    }
}
