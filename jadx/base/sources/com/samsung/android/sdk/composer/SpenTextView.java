package com.samsung.android.sdk.composer;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.os.SystemClock;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.composer.document.SpenWNoteHelper;
import com.samsung.android.sdk.composer.listener.SpenTextComposerListenerManager;
import com.samsung.android.sdk.composer.text.SpenNoteTextManager;
import com.samsung.android.sdk.composer.util.SpenComposerUtil;
import com.samsung.android.sdk.composer.view.accessibility.AccessibilityDelegateImpl;
import com.samsung.android.sdk.composer.view.accessibility.SpenAccessibilityDelegateListener;
import com.samsung.android.sdk.composer.view.accessibility.SpenAccessibilityNodeInfo;
import com.samsung.android.sdk.composer.view.context.SpenComposerContext;
import com.samsung.android.sdk.composer.view.contextmenu.SpenComposerContextMenu;
import com.samsung.android.sdk.composer.view.zoomScroller.SpenNoteZoomScroller;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.engine.SpenGestureController;
import com.samsung.android.sdk.pen.engine.SpenIGestureController;
import com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface;
import com.samsung.android.sdk.pen.engine.pointericon.SpenHoverPointerIcon;
import com.samsung.android.sdk.pen.text.SpenInputManager;
import com.samsung.android.sdk.pen.view.SpenMotionEvent;
import com.samsung.android.sdk.pen.view.gesture.SpenGesture;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.spen.libwrapper.MotionEventWrapper;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 ¶\u00012\u00020\u0001:\u0002¶\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010U\u001a\u00020V2\u0006\u0010\u0002\u001a\u00020\u0003H\u0014J\u0010\u0010W\u001a\u00020V2\u0006\u0010\u0002\u001a\u00020\u0003H\u0014J\b\u0010X\u001a\u00020VH\u0002J\b\u0010Y\u001a\u00020VH\u0014J\b\u0010Z\u001a\u00020VH\u0014J\b\u0010[\u001a\u00020CH\u0016J\b\u0010\\\u001a\u00020]H\u0016J\b\u0010^\u001a\u00020VH\u0016J\b\u0010_\u001a\u00020VH\u0016J\b\u0010`\u001a\u00020VH\u0016J\u0010\u0010a\u001a\u00020V2\u0006\u0010b\u001a\u00020cH\u0016J\u0010\u0010d\u001a\u00020C2\u0006\u0010b\u001a\u00020=H\u0016J0\u0010e\u001a\u00020V2\u0006\u0010f\u001a\u00020C2\u0006\u0010g\u001a\u00020\n2\u0006\u0010h\u001a\u00020\n2\u0006\u0010i\u001a\u00020\n2\u0006\u0010j\u001a\u00020\nH\u0016J\u0010\u0010k\u001a\u00020C2\u0006\u0010b\u001a\u00020=H\u0016J\u0010\u0010l\u001a\u00020V2\u0006\u0010m\u001a\u00020CH\u0016J\u0010\u0010n\u001a\u00020V2\u0006\u0010o\u001a\u00020pH\u0014J\u0018\u0010q\u001a\u00020C2\u0006\u0010r\u001a\u00020\n2\u0006\u0010b\u001a\u00020sH\u0016J\u0018\u0010t\u001a\u00020C2\u0006\u0010r\u001a\u00020\n2\u0006\u0010b\u001a\u00020sH\u0016J\u0018\u0010u\u001a\u00020C2\u0006\u0010r\u001a\u00020\n2\u0006\u0010b\u001a\u00020sH\u0016J\u0018\u0010v\u001a\u00020C2\u0006\u0010r\u001a\u00020\n2\u0006\u0010b\u001a\u00020sH\u0016J\u0012\u0010w\u001a\u0004\u0018\u00010x2\u0006\u0010y\u001a\u00020zH\u0016J\b\u0010{\u001a\u00020CH\u0016J\u0012\u0010|\u001a\u00020V2\b\u0010}\u001a\u0004\u0018\u00010~H\u0014J\b\u0010\u007f\u001a\u00020VH\u0016J\t\u0010\u0080\u0001\u001a\u00020VH\u0014J\u0014\u0010\u0081\u0001\u001a\u00020C2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0013H\u0016J\u0007\u0010\u0083\u0001\u001a\u00020%J\u0007\u0010\u0084\u0001\u001a\u00020\u0019J\u0007\u0010\u0085\u0001\u001a\u00020+J\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001J\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001J\b\u0010\u008a\u0001\u001a\u00030\u0089\u0001J\u0010\u0010\u008b\u0001\u001a\u00020V2\u0007\u0010\u008c\u0001\u001a\u00020\nJ\u0010\u0010\u008d\u0001\u001a\u00020V2\u0007\u0010\u008e\u0001\u001a\u00020CJ\u0007\u0010\u008f\u0001\u001a\u00020VJ\u0010\u0010\u0090\u0001\u001a\u00020V2\u0007\u0010\u0091\u0001\u001a\u00020\nJ\u0010\u0010\u0092\u0001\u001a\u00020V2\u0007\u0010\u0093\u0001\u001a\u00020CJ\u0010\u0010\u0094\u0001\u001a\u00020V2\u0007\u0010\u0093\u0001\u001a\u00020CJ\u0010\u0010\u0095\u0001\u001a\u00020V2\u0007\u0010\u0096\u0001\u001a\u00020CJ\u0007\u0010\u0097\u0001\u001a\u00020VJ\t\u0010\u0098\u0001\u001a\u00020VH\u0016J\f\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001H\u0002J\u0011\u0010\u009b\u0001\u001a\u00020V2\u0006\u0010b\u001a\u00020=H\u0002J\u0012\u0010\u009c\u0001\u001a\u00020V2\u0007\u0010\u008c\u0001\u001a\u00020\nH\u0002J\t\u0010\u009d\u0001\u001a\u00020CH\u0002J\u0012\u0010\u009e\u0001\u001a\u00020V2\u0007\u0010\u009f\u0001\u001a\u00020CH\u0002J\t\u0010 \u0001\u001a\u00020VH\u0002J\t\u0010¡\u0001\u001a\u00020VH\u0002J=\u0010¢\u0001\u001a\u00020V2\u0006\u0010g\u001a\u00020C2\u0006\u0010h\u001a\u00020C2\u0006\u0010i\u001a\u00020C2\u0006\u0010j\u001a\u00020C2\b\u0010£\u0001\u001a\u00030\u0089\u00012\b\u0010¤\u0001\u001a\u00030\u0089\u0001H\u0002J\t\u0010¥\u0001\u001a\u00020VH\u0002J'\u0010¦\u0001\u001a\u00020V2\u0007\u0010§\u0001\u001a\u00020C2\u0007\u0010¨\u0001\u001a\u00020\n2\n\u0010©\u0001\u001a\u0005\u0018\u00010ª\u0001H\u0014J\t\u0010«\u0001\u001a\u00020VH\u0002J0\u0010¬\u0001\u001a\u00020V2\b\u0010\u00ad\u0001\u001a\u00030\u0089\u00012\b\u0010®\u0001\u001a\u00030\u0089\u00012\b\u0010¯\u0001\u001a\u00030\u0089\u00012\u0007\u0010°\u0001\u001a\u00020CH\u0002J\u0012\u0010±\u0001\u001a\u00020V2\u0007\u0010²\u0001\u001a\u00020\nH\u0002J\t\u0010³\u0001\u001a\u00020VH\u0002J\u0012\u0010´\u0001\u001a\u00020V2\u0007\u0010µ\u0001\u001a\u00020\nH\u0002R\u001a\u0010\f\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000207X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010=X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u000e\u0010B\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010D\u001a\u00020CX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u000f\"\u0004\bK\u0010\u0011R\u001a\u0010L\u001a\u00020CX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010F\"\u0004\bN\u0010HR\u001a\u0010O\u001a\u00020CX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010F\"\u0004\bQ\u0010HR\u001a\u0010R\u001a\u00020CX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010F\"\u0004\bT\u0010H¨\u0006·\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/SpenTextView;", "Lcom/samsung/android/sdk/composer/SpenZoomScrollView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mNativeHandle", "", "getMNativeHandle", "()J", "setMNativeHandle", "(J)V", "mDocument", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "getMDocument", "()Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "setMDocument", "(Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;)V", "mSpenNoteZoomScroller", "Lcom/samsung/android/sdk/composer/view/zoomScroller/SpenNoteZoomScroller;", "getMSpenNoteZoomScroller", "()Lcom/samsung/android/sdk/composer/view/zoomScroller/SpenNoteZoomScroller;", "setMSpenNoteZoomScroller", "(Lcom/samsung/android/sdk/composer/view/zoomScroller/SpenNoteZoomScroller;)V", "mSpenComposerContext", "Lcom/samsung/android/sdk/composer/view/context/SpenComposerContext;", "getMSpenComposerContext", "()Lcom/samsung/android/sdk/composer/view/context/SpenComposerContext;", "setMSpenComposerContext", "(Lcom/samsung/android/sdk/composer/view/context/SpenComposerContext;)V", "mListenerManager", "Lcom/samsung/android/sdk/composer/listener/SpenTextComposerListenerManager;", "getMListenerManager", "()Lcom/samsung/android/sdk/composer/listener/SpenTextComposerListenerManager;", "setMListenerManager", "(Lcom/samsung/android/sdk/composer/listener/SpenTextComposerListenerManager;)V", "mNoteTextManager", "Lcom/samsung/android/sdk/composer/text/SpenNoteTextManager;", "getMNoteTextManager", "()Lcom/samsung/android/sdk/composer/text/SpenNoteTextManager;", "setMNoteTextManager", "(Lcom/samsung/android/sdk/composer/text/SpenNoteTextManager;)V", "mGestureController", "Lcom/samsung/android/sdk/pen/engine/SpenGestureController;", "getMGestureController", "()Lcom/samsung/android/sdk/pen/engine/SpenGestureController;", "setMGestureController", "(Lcom/samsung/android/sdk/pen/engine/SpenGestureController;)V", "mWNoteHelper", "Lcom/samsung/android/sdk/composer/document/SpenWNoteHelper;", "getMWNoteHelper", "()Lcom/samsung/android/sdk/composer/document/SpenWNoteHelper;", "setMWNoteHelper", "(Lcom/samsung/android/sdk/composer/document/SpenWNoteHelper;)V", "mCurrentMotionEvent", "Landroid/view/MotionEvent;", "getMCurrentMotionEvent", "()Landroid/view/MotionEvent;", "setMCurrentMotionEvent", "(Landroid/view/MotionEvent;)V", "mIsPenButtonEnabledAtActionDown", "", "mIsDocumentLoaded", "getMIsDocumentLoaded", "()Z", "setMIsDocumentLoaded", "(Z)V", "mDocumentLoadingTime", "getMDocumentLoadingTime", "setMDocumentLoadingTime", "mIsShiftPressed", "getMIsShiftPressed", "setMIsShiftPressed", "mIsDisallowInterceptTouchEvent", "getMIsDisallowInterceptTouchEvent", "setMIsDisallowInterceptTouchEvent", "mIsRequestTouchCancel", "getMIsRequestTouchCancel", "setMIsRequestTouchCancel", "init", "", "initNativeInstance", "initAccessibilityDelegate", "onAttachedToWindow", "onDetachedFromWindow", "isNativeHandleValid", "getView", "Landroid/view/ViewGroup;", "handleResume", "handlePause", "handleTrimMemory", "handleHover", "event", "Lcom/samsung/android/sdk/pen/view/SpenMotionEvent;", "handleMouseWheel", "handleLayout", "changed", "left", "top", "right", "bottom", "handleTouch", "onWindowFocusChanged", "hasWindowFocus", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onKeyDown", "keyCode", "Landroid/view/KeyEvent;", "onKeyUp", "onKeyPreIme", "onKeyShortcut", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onCheckIsTextEditor", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "close", "finalizeNativeInstance", "setDocument", "doc", "getListenerManager", "getNoteZoomScroller", "getTextManager", "getGestureController", "Lcom/samsung/android/sdk/pen/engine/SpenIGestureController;", "getPanY", "", "getDeltaY", "setMode", "mode", "setDarkModeEnabled", "enabled", "forceInvalidate", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setFixedTextSizeEnabled", "enable", "setFixedContentHeightEnabled", "setViewFocus", "viewFocus", "requestCancelTouch", "handleZoom", "getActivity", "Landroid/app/Activity;", "convertMotionEventPenButtonAction", "onEditModeChanged", "isInputMethodShown", "onFlingGesture", "isStarted", "onVerticalScrollBegin", "onVerticalScrollEnd", "onShowEdgeEffect", "velocityX", "velocityY", "onInitLayoutFinished", "onFocusChanged", "gainFocus", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", "onComposerClicked", "onPullGestureAnimationUpdated", "animatedValue", "viewX", "viewY", "isReleased", "onVibrate", "vibrationPattern", "onZoomUpdated", "onTextContentOverflow", TextConst.KEY_START_INDEX, "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenTextView extends SpenZoomScrollView {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenTextView";

    @Nullable
    private MotionEvent mCurrentMotionEvent;

    @Nullable
    private SpenWNote mDocument;
    private long mDocumentLoadingTime;
    protected SpenGestureController mGestureController;
    private boolean mIsDisallowInterceptTouchEvent;
    private boolean mIsDocumentLoaded;
    private boolean mIsPenButtonEnabledAtActionDown;
    private boolean mIsRequestTouchCancel;
    private boolean mIsShiftPressed;
    public SpenTextComposerListenerManager mListenerManager;
    private long mNativeHandle;
    public SpenNoteTextManager mNoteTextManager;
    protected SpenComposerContext mSpenComposerContext;
    public SpenNoteZoomScroller mSpenNoteZoomScroller;
    protected SpenWNoteHelper mWNoteHelper;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0083 J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0083 J\u0011\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0083 J\u0011\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0083 J\u0011\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0083 J9\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019H\u0083 J\u0011\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0083 J\u0019\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0083 J1\u0010!\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020#H\u0083 J\u0019\u0010'\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0083 JI\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u0019H\u0083 J\u0011\u00101\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0083 J\u0011\u00102\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0083 J\u0011\u00103\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0083 J\u0019\u00104\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007H\u0083 J\u0019\u00106\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0083 J\u001b\u00108\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u00072\b\u00109\u001a\u0004\u0018\u00010:H\u0083 J\u001b\u0010;\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010<\u001a\u0004\u0018\u00010=H\u0083 J\u0019\u0010>\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010?2\u0006\u0010\u0011\u001a\u00020\u0007H\u0083 J\u001b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0019H\u0083 J\u0019\u0010D\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0019H\u0083 J\u0019\u0010E\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u0017H\u0083 J\u0019\u0010G\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u0017H\u0083 J\u0019\u0010H\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u0017H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006J"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/SpenTextView$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_init", "", "composer", "Lcom/samsung/android/sdk/composer/SpenTextView;", "contextHandle", "drawLoop", "Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopInterface;", "hoverPointerIcon", "Lcom/samsung/android/sdk/pen/engine/pointericon/SpenHoverPointerIcon;", "Native_finalize", "", "nativeHandle", "Native_getNoteZoomScroller", "Native_getTextManager", "Native_getGestureController", "Native_onLayout", "changed", "", "left", "", "top", "right", "bottom", "Native_onConfigurationChanged", "Native_onTouch", "event", "Lcom/samsung/android/sdk/pen/view/SpenMotionEvent;", "Native_onMouseWheel", "x", "", "y", "verticalAxisValue", "horizontalAxisValue", "Native_onHover", "Native_onKeyEvent", "nativeCanvas", "action", "keyCode", "downTime", "eventTime", "repeatCount", "metaState", "flags", "Native_onPause", "Native_onResume", "Native_onTrimMemory", "Native_setContextMenu", "contextMenu", "Native_setWNoteHelper", "wnoteHelper", "Native_setDocument", "noteDoc", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "Native_captureCurrentView", "bitmap", "Landroid/graphics/Bitmap;", "Native_getNodeList", "", "Lcom/samsung/android/sdk/composer/view/accessibility/SpenAccessibilityNodeInfo;", "Native_getObjectByNativeID", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "nativeId", "Native_isNodeInfoFocused", "Native_setFixedTextSizeEnabled", "enable", "Native_setFixedContentHeightEnabled", "Native_setViewFocus", "viewFocus", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private final boolean Native_captureCurrentView(long nativeHandle, Bitmap bitmap) {
            return SpenTextView.Native_captureCurrentView(nativeHandle, bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeHandle) {
            SpenTextView.Native_finalize(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getGestureController(long nativeHandle) {
            return SpenTextView.Native_getGestureController(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final List<SpenAccessibilityNodeInfo> Native_getNodeList(long nativeHandle) {
            return SpenTextView.Native_getNodeList(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getNoteZoomScroller(long nativeHandle) {
            return SpenTextView.Native_getNoteZoomScroller(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final SpenObjectBase Native_getObjectByNativeID(long nativeHandle, int nativeId) {
            return SpenTextView.Native_getObjectByNativeID(nativeHandle, nativeId);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getTextManager(long nativeHandle) {
            return SpenTextView.Native_getTextManager(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(SpenTextView composer, long contextHandle, SpenDrawLoopInterface drawLoop, SpenHoverPointerIcon hoverPointerIcon) {
            return SpenTextView.Native_init(composer, contextHandle, drawLoop, hoverPointerIcon);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isNodeInfoFocused(long nativeHandle, int nativeId) {
            return SpenTextView.Native_isNodeInfoFocused(nativeHandle, nativeId);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onConfigurationChanged(long nativeHandle) {
            SpenTextView.Native_onConfigurationChanged(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_onHover(long nativeHandle, SpenMotionEvent event) {
            return SpenTextView.Native_onHover(nativeHandle, event);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_onKeyEvent(long nativeCanvas, int action, int keyCode, long downTime, long eventTime, int repeatCount, int metaState, int flags) {
            return SpenTextView.Native_onKeyEvent(nativeCanvas, action, keyCode, downTime, eventTime, repeatCount, metaState, flags);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onLayout(long nativeHandle, boolean changed, int left, int top, int right, int bottom) {
            SpenTextView.Native_onLayout(nativeHandle, changed, left, top, right, bottom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_onMouseWheel(long nativeHandle, float x, float y2, float verticalAxisValue, float horizontalAxisValue) {
            return SpenTextView.Native_onMouseWheel(nativeHandle, x, y2, verticalAxisValue, horizontalAxisValue);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onPause(long nativeHandle) {
            SpenTextView.Native_onPause(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onResume(long nativeHandle) {
            SpenTextView.Native_onResume(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_onTouch(long nativeHandle, SpenMotionEvent event) {
            return SpenTextView.Native_onTouch(nativeHandle, event);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onTrimMemory(long nativeHandle) {
            SpenTextView.Native_onTrimMemory(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setContextMenu(long nativeHandle, long contextMenu) {
            SpenTextView.Native_setContextMenu(nativeHandle, contextMenu);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setDocument(long nativeCanvas, SpenWNote noteDoc) {
            return SpenTextView.Native_setDocument(nativeCanvas, noteDoc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setFixedContentHeightEnabled(long nativeHandle, boolean enable) {
            SpenTextView.Native_setFixedContentHeightEnabled(nativeHandle, enable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setFixedTextSizeEnabled(long nativeHandle, boolean enable) {
            SpenTextView.Native_setFixedTextSizeEnabled(nativeHandle, enable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setViewFocus(long nativeHandle, boolean viewFocus) {
            SpenTextView.Native_setViewFocus(nativeHandle, viewFocus);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setWNoteHelper(long nativeHandle, long wnoteHelper) {
            SpenTextView.Native_setWNoteHelper(nativeHandle, wnoteHelper);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenTextView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_captureCurrentView(long j, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getGestureController(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native List<SpenAccessibilityNodeInfo> Native_getNodeList(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getNoteZoomScroller(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native SpenObjectBase Native_getObjectByNativeID(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getTextManager(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(SpenTextView spenTextView, long j, SpenDrawLoopInterface spenDrawLoopInterface, SpenHoverPointerIcon spenHoverPointerIcon);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isNodeInfoFocused(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onConfigurationChanged(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_onHover(long j, SpenMotionEvent spenMotionEvent);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_onKeyEvent(long j, int i, int i2, long j2, long j3, int i4, int i5, int i6);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onLayout(long j, boolean z, int i, int i2, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_onMouseWheel(long j, float f, float f4, float f5, float f6);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onPause(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onResume(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_onTouch(long j, SpenMotionEvent spenMotionEvent);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onTrimMemory(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setContextMenu(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setDocument(long j, SpenWNote spenWNote);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setFixedContentHeightEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setFixedTextSizeEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setViewFocus(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setWNoteHelper(long j, long j2);

    private final void convertMotionEventPenButtonAction(MotionEvent event) {
        int action = event.getAction();
        if (action == 0) {
            this.mIsPenButtonEnabledAtActionDown = event.getButtonState() == 32;
        }
        if (this.mIsPenButtonEnabledAtActionDown) {
            if (action == 0) {
                event.setAction(MotionEventWrapper.ACTION_PEN_DOWN);
                return;
            }
            if (action == 1) {
                event.setAction(MotionEventWrapper.ACTION_PEN_UP);
            } else if (action == 2) {
                event.setAction(MotionEventWrapper.ACTION_PEN_MOVE);
            } else {
                if (action != 3) {
                    return;
                }
                event.setAction(MotionEventWrapper.ACTION_PEN_CANCEL);
            }
        }
    }

    private final Activity getActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Log.i(TAG, "getActivity - Activity found");
                return (Activity) context;
            }
        }
        Log.i(TAG, "getActivity - Activity NOT found");
        return null;
    }

    private final void initAccessibilityDelegate() {
        if (getMAccDelegateImpl() != null) {
            return;
        }
        setMAccDelegateImpl(new AccessibilityDelegateImpl(this, new SpenAccessibilityDelegateListener() { // from class: com.samsung.android.sdk.composer.SpenTextView.initAccessibilityDelegate.1
            @Override // com.samsung.android.sdk.composer.view.accessibility.SpenAccessibilityDelegateListener
            public int[] getCursorPos(int nativeID, int cursorIndex, boolean isNext, int selectBy) {
                return null;
            }

            @Override // com.samsung.android.sdk.composer.view.accessibility.SpenAccessibilityDelegateListener
            public Triple<Editable, Integer, Integer> getEditable(int nativeID, int pageIndex) {
                return SpenTextView.this.getMNoteTextManager().getObjectEditable(nativeID, pageIndex);
            }

            @Override // com.samsung.android.sdk.composer.view.accessibility.SpenAccessibilityDelegateListener
            public List<SpenAccessibilityNodeInfo> getNodeList() {
                return SpenTextView.INSTANCE.Native_getNodeList(SpenTextView.this.getMNativeHandle());
            }

            @Override // com.samsung.android.sdk.composer.view.accessibility.SpenAccessibilityDelegateListener
            public SpenObjectBase getObjectByNativeId(int nativeId) {
                return SpenTextView.INSTANCE.Native_getObjectByNativeID(SpenTextView.this.getMNativeHandle(), nativeId);
            }

            @Override // com.samsung.android.sdk.composer.view.accessibility.SpenAccessibilityDelegateListener
            public boolean isNodeInfoFocused(int nativeID) {
                return SpenTextView.INSTANCE.Native_isNodeInfoFocused(SpenTextView.this.getMNativeHandle(), nativeID);
            }

            @Override // com.samsung.android.sdk.composer.view.accessibility.SpenAccessibilityDelegateListener
            public void onAccessibilityStateChanged(boolean enabled) {
            }

            @Override // com.samsung.android.sdk.composer.view.accessibility.SpenAccessibilityDelegateListener
            public void onClick(int nativeId) {
            }

            @Override // com.samsung.android.sdk.composer.view.accessibility.SpenAccessibilityDelegateListener
            public void onMove(float y2) {
            }

            @Override // com.samsung.android.sdk.composer.view.accessibility.SpenAccessibilityDelegateListener
            public boolean onPerformContextMenuAction(int id) {
                return false;
            }

            @Override // com.samsung.android.sdk.composer.view.accessibility.SpenAccessibilityDelegateListener
            public void onScroll(float dx, float dy) {
            }
        }));
    }

    private final boolean isInputMethodShown() {
        return SpenInputManager.INSTANCE.isInputMethodShown(getContext());
    }

    private final void onComposerClicked() {
        Log.i(TAG, "onComposerClicked");
        getMListenerManager().onComposerClicked(this.mCurrentMotionEvent);
    }

    private final void onEditModeChanged(int mode) {
        Log.i(TAG, "onEditModeChanged mode=" + mode);
        getMListenerManager().onEditModeChanged(mode);
    }

    private final void onFlingGesture(boolean isStarted) {
        onFling(isStarted);
    }

    private final void onInitLayoutFinished() {
        Log.i(TAG, "onInitLayoutFinished");
        getMListenerManager().onInitLayoutFinished();
    }

    private final void onPullGestureAnimationUpdated(float animatedValue, float viewX, float viewY, boolean isReleased) {
        StringBuilder sbM1176v = AbstractC0622a.m1176v("onPullGestureAnimationUpdated, animatedValue=", animatedValue, ", pan(", viewX, SQLKeyword.COMMA);
        sbM1176v.append(viewY);
        sbM1176v.append("), isReleased=");
        sbM1176v.append(isReleased);
        Log.i(TAG, sbM1176v.toString());
        getMListenerManager().onPullGestureAnimationUpdated(animatedValue, viewX, viewY, isReleased);
    }

    private final void onShowEdgeEffect(boolean left, boolean top, boolean right, boolean bottom, float velocityX, float velocityY) {
        getMEdgeEffectManager().showEdgeEffect(left, top, right, bottom, velocityX, velocityY);
    }

    private final void onTextContentOverflow(int startIndex) {
        getMListenerManager().onTextContentOverflow(startIndex);
    }

    private final void onVerticalScrollBegin() {
        Log.i(TAG, "onVerticalScrollBegin");
        this.mIsDisallowInterceptTouchEvent = true;
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private final void onVerticalScrollEnd() {
        Log.i(TAG, "onVerticalScrollEnd");
        this.mIsDisallowInterceptTouchEvent = false;
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    private final void onVibrate(int vibrationPattern) {
        Log.i(TAG, "onVibrate " + vibrationPattern);
        SpenComposerUtil.performHapticFeedback(this, vibrationPattern);
    }

    private final void onZoomUpdated() {
        handleZoom();
    }

    @Override // com.samsung.android.sdk.composer.SpenZoomScrollView
    public void close() {
        AbstractC2322a.m1631u(System.identityHashCode(this), "close - ", TAG);
        INSTANCE.Native_setWNoteHelper(this.mNativeHandle, 0L);
        getMWNoteHelper().close();
        getMNoteTextManager().close();
        finalizeNativeInstance();
        this.mNativeHandle = 0L;
        getMSpenComposerContext().close();
        super.close();
    }

    public void finalizeNativeInstance() {
        INSTANCE.Native_finalize(this.mNativeHandle);
    }

    public final void forceInvalidate() {
        Log.i(TAG, "SpenEditText - forceInvalidate");
        getMSpenDrawLoop().onResume();
    }

    public final float getDeltaY() {
        PointF delta = getNoteZoomScroller().getDelta();
        if (delta != null) {
            return delta.y;
        }
        return 0.0f;
    }

    @NotNull
    public final SpenIGestureController getGestureController() {
        return getMGestureController();
    }

    @NotNull
    public final SpenTextComposerListenerManager getListenerManager() {
        return getMListenerManager();
    }

    @Nullable
    public final MotionEvent getMCurrentMotionEvent() {
        return this.mCurrentMotionEvent;
    }

    @Nullable
    public final SpenWNote getMDocument() {
        return this.mDocument;
    }

    public final long getMDocumentLoadingTime() {
        return this.mDocumentLoadingTime;
    }

    @NotNull
    public final SpenGestureController getMGestureController() {
        SpenGestureController spenGestureController = this.mGestureController;
        if (spenGestureController != null) {
            return spenGestureController;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mGestureController");
        return null;
    }

    public final boolean getMIsDisallowInterceptTouchEvent() {
        return this.mIsDisallowInterceptTouchEvent;
    }

    public final boolean getMIsDocumentLoaded() {
        return this.mIsDocumentLoaded;
    }

    public final boolean getMIsRequestTouchCancel() {
        return this.mIsRequestTouchCancel;
    }

    public final boolean getMIsShiftPressed() {
        return this.mIsShiftPressed;
    }

    @NotNull
    public final SpenTextComposerListenerManager getMListenerManager() {
        SpenTextComposerListenerManager spenTextComposerListenerManager = this.mListenerManager;
        if (spenTextComposerListenerManager != null) {
            return spenTextComposerListenerManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mListenerManager");
        return null;
    }

    public final long getMNativeHandle() {
        return this.mNativeHandle;
    }

    @NotNull
    public final SpenNoteTextManager getMNoteTextManager() {
        SpenNoteTextManager spenNoteTextManager = this.mNoteTextManager;
        if (spenNoteTextManager != null) {
            return spenNoteTextManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mNoteTextManager");
        return null;
    }

    @NotNull
    public final SpenComposerContext getMSpenComposerContext() {
        SpenComposerContext spenComposerContext = this.mSpenComposerContext;
        if (spenComposerContext != null) {
            return spenComposerContext;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSpenComposerContext");
        return null;
    }

    @NotNull
    public final SpenNoteZoomScroller getMSpenNoteZoomScroller() {
        SpenNoteZoomScroller spenNoteZoomScroller = this.mSpenNoteZoomScroller;
        if (spenNoteZoomScroller != null) {
            return spenNoteZoomScroller;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSpenNoteZoomScroller");
        return null;
    }

    @NotNull
    public final SpenWNoteHelper getMWNoteHelper() {
        SpenWNoteHelper spenWNoteHelper = this.mWNoteHelper;
        if (spenWNoteHelper != null) {
            return spenWNoteHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mWNoteHelper");
        return null;
    }

    @NotNull
    public final SpenNoteZoomScroller getNoteZoomScroller() {
        return getMSpenNoteZoomScroller();
    }

    public final float getPanY() {
        PointF pan = getNoteZoomScroller().getPan();
        if (pan != null) {
            return pan.y;
        }
        return 0.0f;
    }

    @NotNull
    public final SpenNoteTextManager getTextManager() {
        return getMNoteTextManager();
    }

    @Override // com.samsung.android.sdk.composer.SpenZoomScrollView
    @NotNull
    public ViewGroup getView() {
        return this;
    }

    @Override // com.samsung.android.sdk.composer.SpenZoomScrollView
    public void handleHover(@NotNull SpenMotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (isNativeHandleValid()) {
            INSTANCE.Native_onHover(this.mNativeHandle, event);
        }
    }

    @Override // com.samsung.android.sdk.composer.SpenZoomScrollView
    public void handleLayout(boolean changed, int left, int top, int right, int bottom) {
        if (isNativeHandleValid()) {
            INSTANCE.Native_onLayout(this.mNativeHandle, changed, left, top, right, bottom);
            if (this.mDocument != null) {
                getMNoteTextManager().onLayout(changed);
            }
        }
    }

    @Override // com.samsung.android.sdk.composer.SpenZoomScrollView
    public boolean handleMouseWheel(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (isNativeHandleValid()) {
            return INSTANCE.Native_onMouseWheel(this.mNativeHandle, event.getX(), event.getY(), event.getAxisValue(9), event.getAxisValue(10));
        }
        return false;
    }

    @Override // com.samsung.android.sdk.composer.SpenZoomScrollView
    public void handlePause() {
        if (isNativeHandleValid()) {
            INSTANCE.Native_onPause(this.mNativeHandle);
        }
    }

    @Override // com.samsung.android.sdk.composer.SpenZoomScrollView
    public void handleResume() {
        if (isNativeHandleValid()) {
            INSTANCE.Native_onResume(this.mNativeHandle);
        }
    }

    @Override // com.samsung.android.sdk.composer.SpenZoomScrollView
    public boolean handleTouch(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!isNativeHandleValid()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 34) {
            convertMotionEventPenButtonAction(event);
        }
        int actionMasked = event.getActionMasked();
        long jCurrentTimeMillis = System.currentTimeMillis();
        AbstractC6670b.m4744e(actionMasked, event.getToolType(0), "[JavaGesture] Note onTouch begin. action=", ", toolType=", TAG);
        if (getMListenerManager().onTouch(this, event)) {
            Log.i(TAG, "[JavaGesture] Note onTouchEvent is consumed by PreTouchListener. elapsed=" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
            return true;
        }
        if (actionMasked == 0) {
            setMIsTouchDown(true);
            this.mIsRequestTouchCancel = false;
            if (this.mIsDisallowInterceptTouchEvent) {
                onVerticalScrollBegin();
            }
        }
        if (actionMasked == 3 && !getMIsTouchDown()) {
            Log.i(TAG, "[JavaGesture] Note ignore touch cancel because we didn't receive touch down first. elapsed=" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
            return false;
        }
        if (this.mIsRequestTouchCancel) {
            event.setAction(3);
            Log.i(TAG, "[JavaGesture] touch canceled by request");
            this.mIsRequestTouchCancel = false;
        }
        SpenGesture.INSTANCE.onTouchEvent(event, false);
        getMNoteTextManager().onParentTouchEvent(event);
        SpenMotionEvent spenMotionEvent = new SpenMotionEvent(event);
        this.mCurrentMotionEvent = event;
        requestDisallowInterceptTouchEvent(INSTANCE.Native_onTouch(this.mNativeHandle, spenMotionEvent));
        if (actionMasked == 1 || actionMasked == 3) {
            this.mCurrentMotionEvent = null;
            setMIsTouchDown(false);
        }
        float x = event.getX();
        float y2 = event.getY();
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        StringBuilder sbM1176v = AbstractC0622a.m1176v("[JavaGesture] Note onTouch end. (", x, SQLKeyword.COMMA, y2, "), elapsed=");
        sbM1176v.append(jCurrentTimeMillis2);
        sbM1176v.append("ms");
        Log.i(TAG, sbM1176v.toString());
        return false;
    }

    @Override // com.samsung.android.sdk.composer.SpenZoomScrollView
    public void handleTrimMemory() {
        if (isNativeHandleValid()) {
            INSTANCE.Native_onTrimMemory(this.mNativeHandle);
        }
    }

    public void handleZoom() {
    }

    @Override // com.samsung.android.sdk.composer.SpenZoomScrollView
    public void init(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        long jUptimeMillis = SystemClock.uptimeMillis();
        AbstractC2322a.m1631u(System.identityHashCode(this), "[EntryPerformance] init Start - ", TAG);
        super.init(context);
        setMListenerManager(new SpenTextComposerListenerManager());
        setMSpenComposerContext(new SpenComposerContext(context, getMSpenDrawLoop().getMsgQueueHandle(), getMSpenDisplay(), getMSpenConfiguration(), getMSpenDrawLoop().getRendererType()));
        initNativeInstance(context);
        Companion companion = INSTANCE;
        setMSpenNoteZoomScroller(new SpenNoteZoomScroller(companion.Native_getNoteZoomScroller(this.mNativeHandle)));
        setMContextMenu(new SpenComposerContextMenu(this));
        SpenComposerContextMenu mContextMenu = getMContextMenu();
        if (mContextMenu != null) {
            companion.Native_setContextMenu(this.mNativeHandle, mContextMenu.getNativeContextMenu());
            mContextMenu.setListerManager(getMListenerManager());
        }
        setMNoteTextManager(new SpenNoteTextManager(this));
        getMNoteTextManager().setNativeHandle(companion.Native_getTextManager(this.mNativeHandle));
        getMNoteTextManager().setPerformContextMenuActionListener$SDK_fullRelease(new SpenInputManager.PerformContextMenuActionListener() { // from class: com.samsung.android.sdk.composer.SpenTextView.init.2
            @Override // com.samsung.android.sdk.pen.text.SpenInputManager.PerformContextMenuActionListener
            public boolean onPerformContextMenuAction(int id) {
                switch (id) {
                    case R.id.cut:
                    case R.id.copy:
                    case R.id.paste:
                        SpenTextView.this.setMIsShiftPressed(false);
                        break;
                }
                return true;
            }
        });
        setMGestureController(new SpenGestureController(companion.Native_getGestureController(this.mNativeHandle)));
        initActivity(getActivity());
        setWillNotDraw(false);
        setMWNoteHelper(new SpenWNoteHelper(false));
        companion.Native_setWNoteHelper(this.mNativeHandle, getMWNoteHelper().getNativeHandle());
        Log.i(TAG, "[EntryPerformance] init end " + (SystemClock.uptimeMillis() - jUptimeMillis) + "ms");
    }

    public void initNativeInstance(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mNativeHandle = INSTANCE.Native_init(this, getMSpenComposerContext().getHandle(), getMSpenDrawLoop(), getMHoverPointerIcon());
    }

    @Override // com.samsung.android.sdk.composer.SpenZoomScrollView
    public boolean isNativeHandleValid() {
        return this.mNativeHandle != 0;
    }

    @Override // com.samsung.android.sdk.composer.SpenZoomScrollView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mNativeHandle == 0) {
            return;
        }
        getMNoteTextManager().onAttachedToWindow();
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        return getMNoteTextManager().onCheckIsTextEditor();
    }

    @Override // com.samsung.android.sdk.composer.SpenZoomScrollView, android.view.View
    public void onConfigurationChanged(@Nullable Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (this.mDocument == null) {
            return;
        }
        getMNoteTextManager().onConfigurationChanged();
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_onConfigurationChanged(j);
        }
    }

    @Override // android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NotNull EditorInfo outAttrs) {
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        return isEnabled() ? getMNoteTextManager().onCreateInputConnection(outAttrs) : super.onCreateInputConnection(outAttrs);
    }

    @Override // com.samsung.android.sdk.composer.SpenZoomScrollView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i(TAG, "onDetachedFromWindow :" + this.mNativeHandle);
        getMSpenComposerContext().onViewDetachedFromWindow();
    }

    @Override // com.samsung.android.sdk.composer.SpenZoomScrollView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (isNativeHandleValid()) {
            super.onDraw(canvas);
            if (this.mIsDocumentLoaded) {
                Log.i(TAG, "[EntryPerformance] first onDraw called after setDocument " + (SystemClock.uptimeMillis() - this.mDocumentLoadingTime) + "ms");
                this.mIsDocumentLoaded = false;
            }
        }
    }

    @Override // com.samsung.android.sdk.composer.SpenZoomScrollView, android.view.View
    public void onFocusChanged(boolean gainFocus, int direction, @Nullable Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if (this.mNativeHandle != 0) {
            getMNoteTextManager().onFocusChanged(gainFocus);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.mNativeHandle == 0) {
            return false;
        }
        if (keyCode == 59 || keyCode == 60) {
            this.mIsShiftPressed = true;
        }
        if (getMNoteTextManager().onKeyDown(keyCode, event)) {
            return true;
        }
        int metaState = event.getMetaState();
        if (this.mIsShiftPressed) {
            metaState |= 1;
        }
        if (INSTANCE.Native_onKeyEvent(this.mNativeHandle, event.getAction(), keyCode, event.getDownTime(), event.getEventTime(), event.getRepeatCount(), metaState, event.getFlags())) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // android.view.View
    public boolean onKeyPreIme(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.mNativeHandle != 0 && keyCode == 4 && event.getAction() == 0) {
            if (getMSpenComposerContext().getMMode() != 2) {
                return getMNoteTextManager().onKeyPreIme(keyCode, event);
            }
            SpenWNote spenWNote = this.mDocument;
            if (spenWNote != null && spenWNote.getBodyText().getSelectedStart() != spenWNote.getBodyText().getSelectedEnd()) {
                spenWNote.getBodyText().setSelection(-1, -1);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public boolean onKeyShortcut(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.mNativeHandle == 0) {
            return false;
        }
        return getMNoteTextManager().onKeyShortcut(keyCode, event);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.mNativeHandle == 0) {
            return false;
        }
        if (keyCode == 59 || keyCode == 60) {
            this.mIsShiftPressed = false;
        }
        if (getMNoteTextManager().onKeyUp(keyCode, event)) {
            return true;
        }
        int metaState = event.getMetaState();
        if (this.mIsShiftPressed) {
            metaState |= 1;
        }
        if (INSTANCE.Native_onKeyEvent(this.mNativeHandle, event.getAction(), keyCode, event.getDownTime(), event.getEventTime(), event.getRepeatCount(), metaState, event.getFlags())) {
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override // com.samsung.android.sdk.composer.SpenZoomScrollView, android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        getMNoteTextManager().onWindowFocusChanged(hasWindowFocus);
    }

    public final void requestCancelTouch() {
        this.mIsRequestTouchCancel = true;
        Log.i(TAG, "[JavaGesture] request cancel touch");
    }

    public final void setColorTheme(int theme) {
        Log.i(TAG, "[TextComposer] setColorTheme = " + theme);
        getMSpenComposerContext().setColorTheme(theme);
    }

    public final void setDarkModeEnabled(boolean enabled) {
        getMSpenComposerContext().setSystemDarkMode(enabled);
    }

    public boolean setDocument(@Nullable SpenWNote doc) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        Log.i(TAG, "[EntryPerformance] setDocument java : " + doc + " Start");
        if (this.mNativeHandle == 0) {
            return false;
        }
        if (doc == this.mDocument) {
            Log.i(TAG, "setDocument : same document");
            return false;
        }
        this.mDocument = doc;
        getMNoteTextManager().setDocument(this.mDocument);
        boolean zNative_setDocument = INSTANCE.Native_setDocument(this.mNativeHandle, doc);
        this.mIsDocumentLoaded = true;
        this.mDocumentLoadingTime = SystemClock.uptimeMillis();
        initAccessibilityDelegate();
        Log.i(TAG, "[EntryPerformance] setDocument java end " + (SystemClock.uptimeMillis() - jUptimeMillis) + "ms");
        return zNative_setDocument;
    }

    public final void setFixedContentHeightEnabled(boolean enable) {
        if (this.mNativeHandle == 0) {
            return;
        }
        getMNoteTextManager().setFixedContentHeightEnabled(enable);
        INSTANCE.Native_setFixedContentHeightEnabled(this.mNativeHandle, enable);
    }

    public final void setFixedTextSizeEnabled(boolean enable) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setFixedTextSizeEnabled(j, enable);
    }

    public final void setMCurrentMotionEvent(@Nullable MotionEvent motionEvent) {
        this.mCurrentMotionEvent = motionEvent;
    }

    public final void setMDocument(@Nullable SpenWNote spenWNote) {
        this.mDocument = spenWNote;
    }

    public final void setMDocumentLoadingTime(long j) {
        this.mDocumentLoadingTime = j;
    }

    public final void setMGestureController(@NotNull SpenGestureController spenGestureController) {
        Intrinsics.checkNotNullParameter(spenGestureController, "<set-?>");
        this.mGestureController = spenGestureController;
    }

    public final void setMIsDisallowInterceptTouchEvent(boolean z) {
        this.mIsDisallowInterceptTouchEvent = z;
    }

    public final void setMIsDocumentLoaded(boolean z) {
        this.mIsDocumentLoaded = z;
    }

    public final void setMIsRequestTouchCancel(boolean z) {
        this.mIsRequestTouchCancel = z;
    }

    public final void setMIsShiftPressed(boolean z) {
        this.mIsShiftPressed = z;
    }

    public final void setMListenerManager(@NotNull SpenTextComposerListenerManager spenTextComposerListenerManager) {
        Intrinsics.checkNotNullParameter(spenTextComposerListenerManager, "<set-?>");
        this.mListenerManager = spenTextComposerListenerManager;
    }

    public final void setMNativeHandle(long j) {
        this.mNativeHandle = j;
    }

    public final void setMNoteTextManager(@NotNull SpenNoteTextManager spenNoteTextManager) {
        Intrinsics.checkNotNullParameter(spenNoteTextManager, "<set-?>");
        this.mNoteTextManager = spenNoteTextManager;
    }

    public final void setMSpenComposerContext(@NotNull SpenComposerContext spenComposerContext) {
        Intrinsics.checkNotNullParameter(spenComposerContext, "<set-?>");
        this.mSpenComposerContext = spenComposerContext;
    }

    public final void setMSpenNoteZoomScroller(@NotNull SpenNoteZoomScroller spenNoteZoomScroller) {
        Intrinsics.checkNotNullParameter(spenNoteZoomScroller, "<set-?>");
        this.mSpenNoteZoomScroller = spenNoteZoomScroller;
    }

    public final void setMWNoteHelper(@NotNull SpenWNoteHelper spenWNoteHelper) {
        Intrinsics.checkNotNullParameter(spenWNoteHelper, "<set-?>");
        this.mWNoteHelper = spenWNoteHelper;
    }

    public final void setMode(int mode) {
        Log.i(TAG, "setMode : " + mode);
        getMSpenComposerContext().setMode(mode);
        getMNoteTextManager().setEditable(mode == 1);
        if (mode == 1) {
            getMSpenComposerContext().setEditMode(1);
        } else {
            getMSpenComposerContext().setEditMode(0);
        }
    }

    public final void setViewFocus(boolean viewFocus) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setViewFocus(j, viewFocus);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }
}
