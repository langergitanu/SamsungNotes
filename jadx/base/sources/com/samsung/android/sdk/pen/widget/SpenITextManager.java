package com.samsung.android.sdk.pen.widget;

import android.graphics.PointF;
import android.graphics.RectF;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.control.SpenControlObjectListener;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenSuggestionSpan;
import com.samsung.android.sdk.pen.text.SpenCursorChangedListener;
import com.samsung.android.sdk.pen.text.SpenSoftInputListener;
import com.samsung.android.sdk.pen.text.SpenTextLimitListener;
import com.samsung.android.sdk.pen.text.SpenTextScaleListener;
import com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Triple;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u000eH&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0012H&J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0017H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0017H&J$\u0010\u001b\u001a\u00020\u00032\u001a\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001fH&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0017H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0017H&J\u0012\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$H&J*\u0010\"\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H&J\b\u0010+\u001a\u00020\u0003H&J\u0012\u0010,\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010-H&J\u0018\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u0002002\u0006\u0010\u0004\u001a\u000201H&J\u0018\u00102\u001a\u00020\u00172\u0006\u0010/\u001a\u0002002\u0006\u0010\u0004\u001a\u000201H&J\u0018\u00103\u001a\u00020\u00172\u0006\u0010/\u001a\u0002002\u0006\u0010\u0004\u001a\u000201H&J\u0018\u00104\u001a\u00020\u00172\u0006\u0010/\u001a\u0002002\u0006\u0010\u0004\u001a\u000201H&J\b\u00105\u001a\u00020\u0017H&J\u0012\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u000209H&J\u0010\u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u0017H&J \u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u0002002\u0006\u0010>\u001a\u0002002\u0006\u0010?\u001a\u00020\u0017H&J\u001a\u0010@\u001a\u00020\u00032\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010?\u001a\u00020\u0017H&J\u0012\u0010G\u001a\u00020\u00032\b\u0010A\u001a\u0004\u0018\u00010BH&J\u001a\u0010H\u001a\u00020\u00172\u0006\u0010I\u001a\u0002002\b\u0010J\u001a\u0004\u0018\u00010DH&J\u001a\u0010K\u001a\u00020\u00172\u0006\u0010I\u001a\u0002002\b\u0010J\u001a\u0004\u0018\u00010DH&J\u0012\u0010L\u001a\u00020\u00172\b\u0010J\u001a\u0004\u0018\u00010DH&J\u001a\u0010M\u001a\u00020\u00032\b\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010P\u001a\u00020*H&J\b\u0010Q\u001a\u00020\u0003H&J\u001a\u0010R\u001a\u00020\u00032\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010S\u001a\u000200H&J\u0018\u0010T\u001a\u0002002\u0006\u0010A\u001a\u00020B2\u0006\u0010U\u001a\u00020(H&J\u0010\u0010V\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0017H&J\u001a\u0010Y\u001a\u0004\u0018\u00010*2\u0006\u0010A\u001a\u00020B2\u0006\u0010Z\u001a\u000200H&J\u001a\u0010[\u001a\u0004\u0018\u00010*2\u0006\u0010A\u001a\u00020B2\u0006\u0010Z\u001a\u000200H&J\u0010\u0010`\u001a\u00020\u00032\u0006\u0010a\u001a\u00020\u0017H&J\u0010\u0010b\u001a\u00020\u00032\u0006\u0010c\u001a\u00020\u0017H&J\b\u0010g\u001a\u00020\u0003H&J\u0010\u0010h\u001a\u00020\u00032\u0006\u0010i\u001a\u00020\u0017H&J\b\u0010j\u001a\u00020\u0003H&J\b\u0010k\u001a\u00020\u0003H&J\u0012\u0010t\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010uH&J\u0010\u0010v\u001a\u00020\u00032\u0006\u0010w\u001a\u00020oH&J\b\u0010x\u001a\u00020\u0003H&J\u0010\u0010y\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0017H&J\u0012\u0010z\u001a\u0004\u0018\u00010*2\u0006\u0010{\u001a\u00020\u0017H&J\u0012\u0010|\u001a\u0004\u0018\u00010*2\u0006\u0010{\u001a\u00020\u0017H&J\u0010\u0010}\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0017H&J1\u0010~\u001a\u0019\u0012\u0007\u0012\u0005\u0018\u00010\u0080\u0001\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000200\u0018\u00010\u007f2\u0007\u0010\u0081\u0001\u001a\u0002002\u0007\u0010\u0082\u0001\u001a\u000200H&R\u0014\u0010C\u001a\u0004\u0018\u00010DX¦\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0012\u0010W\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\bW\u0010XR\u0018\u0010\\\u001a\u00020\u0017X¦\u000e¢\u0006\f\u001a\u0004\b]\u0010X\"\u0004\b^\u0010_R\u0012\u0010d\u001a\u000200X¦\u0004¢\u0006\u0006\u001a\u0004\be\u0010fR\u0018\u0010l\u001a\u00020\u0017X¦\u000e¢\u0006\f\u001a\u0004\bl\u0010X\"\u0004\bm\u0010_R\u0018\u0010n\u001a\u00020oX¦\u000e¢\u0006\f\u001a\u0004\bp\u0010q\"\u0004\br\u0010s¨\u0006\u0083\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/widget/SpenITextManager;", "", "onPopulateAccessibilityEvent", "", "event", "Landroid/view/accessibility/AccessibilityEvent;", "setNativeHandle", "handle", "", "close", "setActionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/widget/listener/SpenTextManagerActionListener;", "setSoftInputListener", "Lcom/samsung/android/sdk/pen/text/SpenSoftInputListener;", "setCursorChangedListener", "Lcom/samsung/android/sdk/pen/text/SpenCursorChangedListener;", "setControlObjectListener", "Lcom/samsung/android/sdk/pen/control/SpenControlObjectListener;", "setTextLimitListener", "Lcom/samsung/android/sdk/pen/text/SpenTextLimitListener;", "setTextInputBlock", "setBlock", "", "setEditable", "enable", "setHashTagEnabled", "setTagList", XmlErrorCodes.LIST, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "setHyperTextEnabled", "setDoubleTapSelectionEnabled", "setCursorAnchorPosition", "composingText", "", "view", "Landroid/view/View;", "viewPosition", "Landroid/graphics/PointF;", "cursorAnchorRect", "Landroid/graphics/RectF;", "onAttachedToWindow", "onParentTouchEvent", "Landroid/view/MotionEvent;", "onKeyDown", "keyCode", "", "Landroid/view/KeyEvent;", "onKeyUp", "onKeyPreIme", "onKeyShortcut", "onCheckIsTextEditor", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onShowSoftInput", Constants.IntentExtraValue.SHOW, "onCursorChanged", "start", "end", "editable", "onCursorObjectChanged", "objectShape", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "selectedObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "getSelectedObject", "()Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "finishComposingText", "onControlObjectClicked", "tooltype", "objectBase", "onControlObjectLongClicked", "onControlObjectButtonClicked", "onSuggestionTextClicked", "span", "Lcom/samsung/android/sdk/pen/document/textspan/SpenSuggestionSpan;", "rect", "onViewClicked", "onInsertLineFeed", "count", "getCurosrIndex", "position", "setCursorBlink", "isCursorBlinking", "()Z", "getCursorRect", "cursorPos", "getCursorRectOnScreenCoordinates", "autoBlinkOffOnWindowFocusChanged", "getAutoBlinkOffOnWindowFocusChanged", "setAutoBlinkOffOnWindowFocusChanged", "(Z)V", "onWindowFocusChanged", "hasWindowFocus", "onFocusChanged", "gainFocus", "textSizeDelta", "getTextSizeDelta", "()I", "updateHashTagPosition", "onLayout", "changed", "onConfigurationChanged", "updateSuggestionPopup", "isAutoFocusEnabled", "setAutoFocusEnabled", "textScale", "", "getTextScale", "()F", "setTextScale", "(F)V", "setTextScaleListener", "Lcom/samsung/android/sdk/pen/text/SpenTextScaleListener;", "onTextScaleChanged", WiggleAnimationConfig.KEY_SCALE, "showTextContextMenu", "setSelectionContextMenuForceEnabled", "getStartCursorHandleRect", "onViewCoordinates", "getEndCursorHandleRect", "setTextGradientSelectionEnabled", "getObjectEditable", "Lkotlin/Triple;", "Landroid/text/Editable;", "nativeID", "pageIndex", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenITextManager {
    void close();

    void finishComposingText(@Nullable SpenObjectShape objectShape);

    /* JADX INFO: renamed from: getAutoBlinkOffOnWindowFocusChanged */
    boolean getMIsAutoBlinkOffOnWindowFocusChanged();

    int getCurosrIndex(@NotNull SpenObjectShape objectShape, @NotNull PointF position);

    @Nullable
    RectF getCursorRect(@NotNull SpenObjectShape objectShape, int cursorPos);

    @Nullable
    RectF getCursorRectOnScreenCoordinates(@NotNull SpenObjectShape objectShape, int cursorPos);

    @Nullable
    RectF getEndCursorHandleRect(boolean onViewCoordinates);

    @Nullable
    Triple<Editable, Integer, Integer> getObjectEditable(int nativeID, int pageIndex);

    @Nullable
    SpenObjectBase getSelectedObject();

    @Nullable
    RectF getStartCursorHandleRect(boolean onViewCoordinates);

    float getTextScale();

    int getTextSizeDelta();

    boolean isAutoFocusEnabled();

    boolean isCursorBlinking();

    void onAttachedToWindow();

    boolean onCheckIsTextEditor();

    void onConfigurationChanged();

    boolean onControlObjectButtonClicked(@Nullable SpenObjectBase objectBase);

    boolean onControlObjectClicked(int tooltype, @Nullable SpenObjectBase objectBase);

    boolean onControlObjectLongClicked(int tooltype, @Nullable SpenObjectBase objectBase);

    @Nullable
    InputConnection onCreateInputConnection(@NotNull EditorInfo outAttrs);

    void onCursorChanged(int start, int end, boolean editable);

    void onCursorObjectChanged(@Nullable SpenObjectShape objectShape, boolean editable);

    void onFocusChanged(boolean gainFocus);

    void onInsertLineFeed(@Nullable SpenObjectShape objectShape, int count);

    boolean onKeyDown(int keyCode, @NotNull KeyEvent event);

    boolean onKeyPreIme(int keyCode, @NotNull KeyEvent event);

    boolean onKeyShortcut(int keyCode, @NotNull KeyEvent event);

    boolean onKeyUp(int keyCode, @NotNull KeyEvent event);

    void onLayout(boolean changed);

    void onParentTouchEvent(@Nullable MotionEvent event);

    void onPopulateAccessibilityEvent(@NotNull AccessibilityEvent event);

    void onShowSoftInput(boolean show);

    void onSuggestionTextClicked(@Nullable SpenSuggestionSpan span, @NotNull RectF rect);

    void onTextScaleChanged(float scale);

    void onViewClicked();

    void onWindowFocusChanged(boolean hasWindowFocus);

    void setActionListener(@Nullable SpenTextManagerActionListener listener);

    void setAutoBlinkOffOnWindowFocusChanged(boolean z);

    void setAutoFocusEnabled(boolean z);

    void setControlObjectListener(@Nullable SpenControlObjectListener listener);

    void setCursorAnchorPosition(@NotNull View view, @Nullable CharSequence composingText, @NotNull PointF viewPosition, @NotNull RectF cursorAnchorRect);

    void setCursorAnchorPosition(@Nullable CharSequence composingText);

    void setCursorBlink(boolean enable);

    void setCursorChangedListener(@Nullable SpenCursorChangedListener listener);

    void setDoubleTapSelectionEnabled(boolean enable);

    void setEditable(boolean enable);

    void setHashTagEnabled(boolean enable);

    void setHyperTextEnabled(boolean enable);

    void setNativeHandle(long handle);

    void setSelectionContextMenuForceEnabled(boolean enable);

    void setSoftInputListener(@Nullable SpenSoftInputListener listener);

    void setTagList(@Nullable ArrayList<String> list);

    void setTextGradientSelectionEnabled(boolean enable);

    void setTextInputBlock(boolean setBlock);

    void setTextLimitListener(@Nullable SpenTextLimitListener listener);

    void setTextScale(float f);

    void setTextScaleListener(@Nullable SpenTextScaleListener listener);

    void showTextContextMenu();

    void updateHashTagPosition();

    void updateSuggestionPopup();
}
