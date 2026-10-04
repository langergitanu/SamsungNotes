package com.samsung.android.sdk.composer.listener;

import android.graphics.RectF;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.composer.document.search.SearchData;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.engine.SpenHoverListener;
import com.samsung.android.sdk.pen.engine.SpenTouchListener;
import com.samsung.android.sdk.pen.util.SpenAnalyticsUtil;
import com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuDelegateListener;
import com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener;
import com.samsung.android.sdk.pen.worddoc.SpenCustomObject;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 v2\u00020\u0001:\u0001vB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u001f\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010 \u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\rJ\u0010\u0010!\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\"\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011J\u0010\u0010#\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013J\u0010\u0010$\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015J\u0010\u0010%\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017J\u000e\u0010&\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019J\u0010\u0010'\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010)J\u000e\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020,J&\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020,2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000203J\u000e\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u00020,JN\u00107\u001a\u00020\u001b2\u001e\u00108\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010:\u0018\u000109j\f\u0012\u0006\u0012\u0004\u0018\u00010:\u0018\u0001`;2\u001e\u0010<\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010=\u0018\u000109j\f\u0012\u0006\u0012\u0004\u0018\u00010=\u0018\u0001`;2\u0006\u0010>\u001a\u000203J\u0018\u0010?\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020,2\b\u0010A\u001a\u0004\u0018\u00010=J\u0018\u0010B\u001a\u00020\u001b2\b\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020,J\u0006\u0010F\u001a\u00020\u001bJ\u0010\u0010G\u001a\u00020\u001b2\b\u0010H\u001a\u0004\u0018\u00010IJ\u0018\u0010J\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020,2\b\u0010L\u001a\u0004\u0018\u00010MJ\u000e\u0010N\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020,J&\u0010O\u001a\u00020\u001b2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020Q2\u0006\u0010T\u001a\u000203J\u0006\u0010U\u001a\u00020\u001bJ\u0006\u0010V\u001a\u00020\u001bJ\u000e\u0010W\u001a\u00020\u001b2\u0006\u0010X\u001a\u00020YJ\u000e\u0010Z\u001a\u00020\u001b2\u0006\u0010X\u001a\u00020YJ\u001c\u0010[\u001a\u0002032\b\u00106\u001a\u0004\u0018\u00010\\2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J\u0012\u0010_\u001a\u00020\u001b2\b\u0010]\u001a\u0004\u0018\u00010`H\u0016J\u001c\u0010a\u001a\u0002032\b\u00106\u001a\u0004\u0018\u00010\\2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J\u001a\u0010d\u001a\u0002032\b\u0010e\u001a\u0004\u0018\u00010f2\b\u0010H\u001a\u0004\u0018\u00010IJ.\u0010g\u001a\u00020\u001b2\u0006\u0010h\u001a\u0002032\u0006\u0010i\u001a\u00020,2\u0006\u0010j\u001a\u00020,2\u0006\u0010k\u001a\u00020,2\u0006\u0010l\u001a\u00020,J\u000e\u0010m\u001a\u0002032\u0006\u0010@\u001a\u00020,J\u001a\u0010n\u001a\u0002032\b\u0010o\u001a\u0004\u0018\u00010p2\u0006\u0010q\u001a\u000203H\u0016J\b\u0010r\u001a\u00020\u001bH\u0016J\u0012\u0010s\u001a\u00020\u001b2\b\u0010t\u001a\u0004\u0018\u00010pH\u0016J\u001a\u0010u\u001a\u0002032\b\u0010e\u001a\u0004\u0018\u00010f2\b\u0010H\u001a\u0004\u0018\u00010IR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006w"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/listener/SpenComposerListenerManager;", "Lcom/samsung/android/sdk/composer/listener/SpenIContextMenuListener;", "<init>", "()V", "mThumbnailChangeListener", "Lcom/samsung/android/sdk/composer/listener/SpenThumbnailChangeListener;", "mPageActionLister", "Lcom/samsung/android/sdk/composer/listener/SpenPageActionListener;", "mPageLayoutLister", "Lcom/samsung/android/sdk/composer/listener/SpenPageLayoutListener;", "mComposerActionListener", "Lcom/samsung/android/sdk/composer/listener/SpenComposerActionListener;", "mTouchListener", "Lcom/samsung/android/sdk/pen/engine/SpenTouchListener;", "mObjectSelectListener", "Lcom/samsung/android/sdk/composer/listener/SpenObjectSelectListener;", "mDialogActionListener", "Lcom/samsung/android/sdk/composer/listener/SpenDialogActionListener;", "mContextMenuListener", "Lcom/samsung/android/sdk/pen/view/contextmenu/SpenContextMenuListener;", "mContextMenuDelegateListener", "Lcom/samsung/android/sdk/pen/view/contextmenu/SpenContextMenuDelegateListener;", "mStrokeShapeListener", "Lcom/samsung/android/sdk/composer/listener/SpenStrokeShapeListener;", "mHoverListener", "Lcom/samsung/android/sdk/pen/engine/SpenHoverListener;", "setThumbnailChangeListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPageActionListener", "setPageLayoutListener", "setComposerActionListener", "setPreTouchListener", "setObjectSelectListener", "setDialogActionListener", "setContextMenuListener", "setContextMenuDelegateListener", "setStrokeShapeListener", "setHoverListener", "setLoggingListener", "l", "Lcom/samsung/android/sdk/composer/listener/SpenAnalyticsListener;", "onThumbnailChanged", "pageIndex", "", "onLastPageChanged", "totalHeight", "onPageLayoutChanged", "pageLayoutColumn", "pageLayoutRow", "pageLayoutFitScreen", "", "pageLayoutVertical", "onEditModeChanged", "mode", "onObjectSelected", "pageList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "Lkotlin/collections/ArrayList;", "objectList", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "selected", "onShowAlertDialog", "id", "content", "onActionLinkClicked", "text", "", "linkType", "onInitLayoutFinished", "onComposerClicked", "event", "Landroid/view/MotionEvent;", "onSearchingText", "totalCount", "searchData", "Lcom/samsung/android/sdk/composer/document/search/SearchData;", "onSearchTextFinished", "onPullGestureAnimationUpdated", "animatedValue", "", "viewX", "viewY", "isReleased", "onStrokeShapeConverted", "onSmoothScrollEnd", "onStickyMemoClicked", "customObject", "Lcom/samsung/android/sdk/pen/worddoc/SpenCustomObject;", "onStickyMemoMovedByUser", "onCreateActionMode", "Landroid/view/ActionMode;", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "onCreateContextMenu", "Landroid/view/ContextMenu;", "onActionItemClicked", "item", "Landroid/view/MenuItem;", "onTouch", "view", "Landroid/view/View;", "onLayout", "changed", "oldWidth", "oldHeight", "newWidth", "newHeight", "onPerformContextMenuAction", "onShowContextMenu", "contentRect", "Landroid/graphics/RectF;", "enableVibration", "onHideContextMenu", "onUpdateContentRect", "rect", "onHover", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenComposerListenerManager implements SpenIContextMenuListener {
    private static final int ALERT_REMOVE_DELKEY_CONTENT = 2;
    private static final int ALERT_REMOVE_DELKEY_RECORDING_VOICE = 3;
    private static final int ALERT_REMOVE_RECORDING_VOICE = 1;

    @Nullable
    private SpenComposerActionListener mComposerActionListener;

    @Nullable
    private SpenContextMenuDelegateListener mContextMenuDelegateListener;

    @Nullable
    private SpenContextMenuListener mContextMenuListener;

    @Nullable
    private SpenDialogActionListener mDialogActionListener;

    @Nullable
    private SpenHoverListener mHoverListener;

    @Nullable
    private SpenObjectSelectListener mObjectSelectListener;

    @Nullable
    private SpenPageActionListener mPageActionLister;

    @Nullable
    private SpenPageLayoutListener mPageLayoutLister;

    @Nullable
    private SpenStrokeShapeListener mStrokeShapeListener;

    @Nullable
    private SpenThumbnailChangeListener mThumbnailChangeListener;

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

    public final void onActionLinkClicked(@Nullable String text, int linkType) {
        SpenComposerActionListener spenComposerActionListener = this.mComposerActionListener;
        if (spenComposerActionListener != null) {
            spenComposerActionListener.onActionLinkClicked(text, linkType);
        }
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

    public final boolean onHover(@Nullable View view, @Nullable MotionEvent event) {
        SpenHoverListener spenHoverListener = this.mHoverListener;
        if (spenHoverListener != null) {
            return spenHoverListener.onHover(view, event);
        }
        return false;
    }

    public final void onInitLayoutFinished() {
        SpenComposerActionListener spenComposerActionListener = this.mComposerActionListener;
        if (spenComposerActionListener != null) {
            spenComposerActionListener.onInitLayoutFinished();
        }
    }

    public final void onLastPageChanged(int totalHeight) {
        SpenPageActionListener spenPageActionListener = this.mPageActionLister;
        if (spenPageActionListener != null) {
            spenPageActionListener.onLastPageChanged(totalHeight);
        }
    }

    public final void onLayout(boolean changed, int oldWidth, int oldHeight, int newWidth, int newHeight) {
        SpenComposerActionListener spenComposerActionListener = this.mComposerActionListener;
        if (spenComposerActionListener != null) {
            spenComposerActionListener.onLayout(changed, oldWidth, oldHeight, newWidth, newHeight);
        }
    }

    public final void onObjectSelected(@Nullable ArrayList<SpenWPage> pageList, @Nullable ArrayList<SpenObjectBase> objectList, boolean selected) {
        SpenObjectSelectListener spenObjectSelectListener = this.mObjectSelectListener;
        if (spenObjectSelectListener != null) {
            spenObjectSelectListener.onObjectSelected(pageList, objectList, selected);
        }
    }

    public final void onPageLayoutChanged(int pageLayoutColumn, int pageLayoutRow, boolean pageLayoutFitScreen, boolean pageLayoutVertical) {
        SpenPageLayoutListener spenPageLayoutListener = this.mPageLayoutLister;
        if (spenPageLayoutListener != null) {
            spenPageLayoutListener.onChanged(pageLayoutColumn, pageLayoutRow, pageLayoutFitScreen, pageLayoutVertical);
        }
    }

    public final boolean onPerformContextMenuAction(int id) {
        SpenComposerActionListener spenComposerActionListener = this.mComposerActionListener;
        if (spenComposerActionListener != null) {
            return spenComposerActionListener.onPerformContextMenuAction(id);
        }
        return false;
    }

    public final void onPullGestureAnimationUpdated(float animatedValue, float viewX, float viewY, boolean isReleased) {
        SpenComposerActionListener spenComposerActionListener = this.mComposerActionListener;
        if (spenComposerActionListener != null) {
            spenComposerActionListener.onPullGestureAnimationUpdated(animatedValue, viewX, viewY, isReleased);
        }
    }

    public final void onSearchTextFinished(int totalCount) {
        SpenComposerActionListener spenComposerActionListener = this.mComposerActionListener;
        if (spenComposerActionListener != null) {
            spenComposerActionListener.onSearchTextFinished(totalCount);
        }
    }

    public final void onSearchingText(int totalCount, @Nullable SearchData searchData) {
        SpenComposerActionListener spenComposerActionListener = this.mComposerActionListener;
        if (spenComposerActionListener != null) {
            spenComposerActionListener.onSearchingText(totalCount, searchData);
        }
    }

    public final void onShowAlertDialog(int id, @Nullable SpenObjectBase content) {
        SpenDialogActionListener spenDialogActionListener;
        if (id == 1) {
            SpenDialogActionListener spenDialogActionListener2 = this.mDialogActionListener;
            if (spenDialogActionListener2 != null) {
                spenDialogActionListener2.onRequestShowRemoveRecordingVoiceDialog();
                return;
            }
            return;
        }
        if (id != 2) {
            if (id == 3 && (spenDialogActionListener = this.mDialogActionListener) != null) {
                spenDialogActionListener.onRequestShowCancelVoiceDialog();
                return;
            }
            return;
        }
        SpenDialogActionListener spenDialogActionListener3 = this.mDialogActionListener;
        if (spenDialogActionListener3 != null) {
            spenDialogActionListener3.onRequestShowConfirmRemoveDialog(content);
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

    public final void onSmoothScrollEnd() {
        SpenComposerActionListener spenComposerActionListener = this.mComposerActionListener;
        if (spenComposerActionListener != null) {
            spenComposerActionListener.onSmoothScrollEnd();
        }
    }

    public final void onStickyMemoClicked(@NotNull SpenCustomObject customObject) {
        Intrinsics.checkNotNullParameter(customObject, "customObject");
        SpenComposerActionListener spenComposerActionListener = this.mComposerActionListener;
        if (spenComposerActionListener != null) {
            spenComposerActionListener.onStickyMemoClicked(customObject);
        }
    }

    public final void onStickyMemoMovedByUser(@NotNull SpenCustomObject customObject) {
        Intrinsics.checkNotNullParameter(customObject, "customObject");
        SpenComposerActionListener spenComposerActionListener = this.mComposerActionListener;
        if (spenComposerActionListener != null) {
            spenComposerActionListener.onStickyMemoMovedByUser(customObject);
        }
    }

    public final void onStrokeShapeConverted() {
        SpenStrokeShapeListener spenStrokeShapeListener = this.mStrokeShapeListener;
        if (spenStrokeShapeListener != null) {
            spenStrokeShapeListener.onStrokeShapeConverted();
        }
    }

    public final void onThumbnailChanged(int pageIndex) {
        SpenThumbnailChangeListener spenThumbnailChangeListener = this.mThumbnailChangeListener;
        if (spenThumbnailChangeListener != null) {
            spenThumbnailChangeListener.onThumbnailChanged(pageIndex);
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

    public final void setDialogActionListener(@Nullable SpenDialogActionListener listener) {
        this.mDialogActionListener = listener;
    }

    public final void setHoverListener(@NotNull SpenHoverListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mHoverListener = listener;
    }

    public final void setLoggingListener(@Nullable SpenAnalyticsListener l) {
        SpenAnalyticsUtil.INSTANCE.getInstance().setListener(l);
    }

    public final void setObjectSelectListener(@Nullable SpenObjectSelectListener listener) {
        this.mObjectSelectListener = listener;
    }

    public final void setPageActionListener(@Nullable SpenPageActionListener listener) {
        this.mPageActionLister = listener;
    }

    public final void setPageLayoutListener(@Nullable SpenPageLayoutListener listener) {
        this.mPageLayoutLister = listener;
    }

    public final void setPreTouchListener(@Nullable SpenTouchListener listener) {
        this.mTouchListener = listener;
    }

    public final void setStrokeShapeListener(@Nullable SpenStrokeShapeListener listener) {
        this.mStrokeShapeListener = listener;
    }

    public final void setThumbnailChangeListener(@Nullable SpenThumbnailChangeListener listener) {
        this.mThumbnailChangeListener = listener;
    }
}
