package com.samsung.android.sdk.composer.view.contextmenu;

import android.graphics.RectF;
import android.util.Log;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.composer.text.SpenNoteTextManager;
import com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuDelegateListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\bJ\u0010\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001J\u0006\u0010\u000f\u001a\u00020\nJ\u0006\u0010\u0010\u001a\u00020\nJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0012\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/view/contextmenu/SpenContextMenuDelegate;", "Lcom/samsung/android/sdk/pen/view/contextmenu/SpenContextMenuDelegateListener;", "<init>", "()V", "mIsStarted", "", "mListener", "mTextManager", "Lcom/samsung/android/sdk/composer/text/SpenNoteTextManager;", "close", "", "setTextManager", "textManager", "setListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "startAction", "stopAction", "onShowContextMenu", "contentRect", "Landroid/graphics/RectF;", "enableVibration", "onHideContextMenu", "onUpdateContentRect", "rect", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenContextMenuDelegate extends SpenContextMenuDelegateListener {

    @NotNull
    private static final String TAG = "SpenContextMenuDelegate";
    private boolean mIsStarted;

    @Nullable
    private SpenContextMenuDelegateListener mListener;

    @Nullable
    private SpenNoteTextManager mTextManager;

    public final void close() {
        stopAction();
        this.mTextManager = null;
        this.mListener = null;
    }

    @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuDelegateListener
    public void onHideContextMenu() {
        if (this.mIsStarted) {
            Log.i(TAG, "ContextMenuDelegate - onHideContextMenu");
            SpenContextMenuDelegateListener spenContextMenuDelegateListener = this.mListener;
            if (spenContextMenuDelegateListener != null) {
                spenContextMenuDelegateListener.onHideContextMenu();
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuDelegateListener
    public boolean onShowContextMenu(@Nullable RectF contentRect, boolean enableVibration) {
        if (!this.mIsStarted) {
            return false;
        }
        Log.i(TAG, "ContextMenuDelegate - onShowContextMenu");
        SpenContextMenuDelegateListener spenContextMenuDelegateListener = this.mListener;
        if (spenContextMenuDelegateListener == null) {
            return true;
        }
        spenContextMenuDelegateListener.onShowContextMenu(contentRect, enableVibration);
        return true;
    }

    @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuDelegateListener
    public void onUpdateContentRect(@Nullable RectF rect) {
        if (this.mIsStarted) {
            Log.i(TAG, "ContextMenuDelegate - onUpdateContentRect");
            SpenContextMenuDelegateListener spenContextMenuDelegateListener = this.mListener;
            if (spenContextMenuDelegateListener != null) {
                spenContextMenuDelegateListener.onUpdateContentRect(rect);
            }
        }
    }

    public final void setListener(@Nullable SpenContextMenuDelegateListener listener) {
        this.mListener = listener;
    }

    public final void setTextManager(@Nullable SpenNoteTextManager textManager) {
        this.mTextManager = textManager;
    }

    public final void startAction() {
        Log.i(TAG, "ContextMenuDelegate - startAction");
        if (this.mIsStarted) {
            return;
        }
        this.mIsStarted = true;
        SpenNoteTextManager spenNoteTextManager = this.mTextManager;
        if (spenNoteTextManager != null) {
            spenNoteTextManager.setSelectionContextMenuForceEnabled(true);
        }
    }

    public final void stopAction() {
        Log.i(TAG, "ContextMenuDelegate - stopAction");
        if (this.mIsStarted) {
            SpenNoteTextManager spenNoteTextManager = this.mTextManager;
            if (spenNoteTextManager != null) {
                spenNoteTextManager.setSelectionContextMenuForceEnabled(false);
            }
            this.mIsStarted = false;
        }
    }
}
