package com.samsung.android.sdk.composer.view.accessibility;

import android.R;
import android.animation.TimeAnimator;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.Selection;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.ScrollView;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.p109ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.firebase.messaging.Constants;
import com.samsung.android.sdk.composer.util.SpenComposerUtil;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.stt.common.constant.DialogConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010 \n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0015\n\u0002\b\b\b\u0007\u0018\u0000 \u0095\u00012\u00020\u0001:\u0006\u0093\u0001\u0094\u0001\u0095\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u00104\u001a\u000205J \u00106\u001a\u0002052\u0006\u00107\u001a\u00020\u00132\u0006\u00108\u001a\u00020\u00182\b\u00109\u001a\u0004\u0018\u00010:J\u000e\u0010;\u001a\u00020\u00132\u0006\u0010<\u001a\u00020=J\u000e\u0010>\u001a\u00020\u00132\u0006\u0010<\u001a\u00020?J\u000e\u0010@\u001a\u0002052\u0006\u0010A\u001a\u00020\u0018J\b\u0010B\u001a\u000205H\u0002J\b\u0010C\u001a\u000205H\u0002J\u0010\u0010D\u001a\u00020\u00182\u0006\u0010E\u001a\u00020\u0018H\u0002J\b\u0010F\u001a\u00020\u0013H\u0002J\u0010\u0010G\u001a\u00020\u00132\u0006\u00108\u001a\u00020\u0018H\u0002J\b\u0010H\u001a\u000205H\u0002J\u0010\u0010I\u001a\u0002052\u0006\u0010J\u001a\u00020\u0018H\u0002J\b\u0010K\u001a\u00020\u0013H\u0002J\u0010\u0010L\u001a\u00020\u00132\u0006\u0010J\u001a\u00020\u0018H\u0002J\u0010\u0010M\u001a\u0002052\u0006\u0010N\u001a\u00020\u0018H\u0002J\u0012\u0010O\u001a\u0004\u0018\u00010\u00192\u0006\u0010N\u001a\u00020\u0018H\u0002J\u0012\u0010P\u001a\u0004\u0018\u00010\u00192\u0006\u0010Q\u001a\u00020\u0018H\u0002J\u0012\u0010R\u001a\u0004\u0018\u00010\u00192\u0006\u0010S\u001a\u00020\u0018H\u0002J\u0012\u0010T\u001a\u0004\u0018\u00010\u00192\u0006\u0010S\u001a\u00020\u0018H\u0002J\u0010\u0010U\u001a\u0002052\u0006\u0010V\u001a\u00020\u0018H\u0002J\u0018\u0010W\u001a\u0002052\u000e\u0010X\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010YH\u0002J\u0016\u0010Z\u001a\u0002052\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00180\u001cH\u0002J\u0018\u0010\\\u001a\u00020\u00182\u0006\u0010]\u001a\u00020\u00182\u0006\u0010^\u001a\u00020\u0018H\u0002J\u0012\u0010_\u001a\u0004\u0018\u00010\u00192\u0006\u0010J\u001a\u00020\u0018H\u0002J\u001a\u0010_\u001a\u0004\u0018\u00010\u00192\u0006\u0010J\u001a\u00020\u00182\u0006\u0010`\u001a\u00020\u0013H\u0002J\u0010\u0010a\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\u0018H\u0002J\u0010\u0010b\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\u0018H\u0002J\u0010\u0010c\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\u0018H\u0002J\u0010\u0010d\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\u0018H\u0002J\u0010\u0010e\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\u0018H\u0002J(\u0010f\u001a\u00020\u00132\u0006\u00108\u001a\u00020\u00182\u0006\u0010g\u001a\u00020:2\u0006\u0010h\u001a\u00020:2\u0006\u0010i\u001a\u00020:H\u0002J(\u0010j\u001a\u00020\u00132\u0006\u00108\u001a\u00020\u00182\u0006\u0010g\u001a\u00020:2\u0006\u0010k\u001a\u00020:2\u0006\u0010l\u001a\u00020:H\u0002J \u0010m\u001a\u00020\u00132\u0006\u00108\u001a\u00020\u00182\u0006\u0010k\u001a\u00020:2\u0006\u0010l\u001a\u00020:H\u0002J \u0010n\u001a\u00020\u00132\u0006\u00108\u001a\u00020\u00182\u0006\u0010o\u001a\u00020:2\u0006\u0010p\u001a\u00020:H\u0002J \u0010q\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u00182\u0006\u0010g\u001a\u00020:2\u0006\u0010p\u001a\u00020:H\u0002J \u0010r\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u00182\u0006\u0010g\u001a\u00020:2\u0006\u0010p\u001a\u00020:H\u0002J \u0010s\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u00182\u0006\u0010g\u001a\u00020:2\u0006\u0010p\u001a\u00020:H\u0002J \u0010t\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u00182\u0006\u0010g\u001a\u00020:2\u0006\u0010p\u001a\u00020:H\u0002J\u0018\u0010u\u001a\u00020\u00182\u0006\u0010q\u001a\u00020\u00182\u0006\u0010v\u001a\u00020\u0018H\u0002J \u0010v\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u00182\u0006\u0010g\u001a\u00020:2\u0006\u0010p\u001a\u00020:H\u0002J \u0010w\u001a\u00020\u00132\u0006\u0010x\u001a\u00020:2\u0006\u0010y\u001a\u00020:2\u0006\u00108\u001a\u00020\u0018H\u0002J\u0010\u0010z\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\u0018H\u0002J\u0010\u0010{\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\u0018H\u0002J\u0010\u0010|\u001a\u0002052\u0006\u0010A\u001a\u00020\u0018H\u0002J\u001d\u0010}\u001a\u00020\u00132\b\u0010~\u001a\u0004\u0018\u00010\u007f2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u001fH\u0002J9\u0010\u0081\u0001\u001a\u00020\u00132\b\u0010~\u001a\u0004\u0018\u00010\u007f2\u0007\u0010\u0082\u0001\u001a\u00020\u00192\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u001f2\u0007\u0010\u0083\u0001\u001a\u00020\u00132\u0007\u0010\u0084\u0001\u001a\u00020\u0013H\u0002J8\u0010\u0085\u0001\u001a\u00020\u00132\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u001f2\u0007\u0010\u0083\u0001\u001a\u00020\u00132\u0007\u0010\u0086\u0001\u001a\u00020\u00182\u0007\u0010\u0082\u0001\u001a\u00020\u00192\u0007\u0010\u0087\u0001\u001a\u00020\u0013H\u0002J-\u0010\u0088\u0001\u001a\u0002052\u0007\u0010\u0089\u0001\u001a\u00020\u00182\u0007\u0010\u0086\u0001\u001a\u00020\u00182\u0007\u0010\u008a\u0001\u001a\u00020\u00182\u0007\u0010\u008b\u0001\u001a\u00020\u0018H\u0002J/\u0010\u008c\u0001\u001a\u00020\u00132\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u001f2\u0007\u0010\u0083\u0001\u001a\u00020\u00132\u0007\u0010\u0086\u0001\u001a\u00020\u00182\u0007\u0010\u0082\u0001\u001a\u00020\u0019H\u0002J;\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u00132\u0007\u0010\u0086\u0001\u001a\u00020\u00182\u0007\u0010\u008f\u0001\u001a\u00020\u00182\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u001f2\u0007\u0010\u0090\u0001\u001a\u00020\u0018H\u0002J\u001d\u0010\u0091\u0001\u001a\u00020\u00132\u0007\u0010\u0089\u0001\u001a\u00020\u00182\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u001fH\u0002J'\u0010\u0092\u0001\u001a\u00020\u00132\u0007\u0010\u0089\u0001\u001a\u00020\u00182\b\u0010~\u001a\u0004\u0018\u00010\u007f2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0019H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0018\u00010\u000bR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R2\u0010\u0016\u001a&\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u0017j\u0012\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u0001`\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0018\u00010!R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010/\u001a\u0002008F¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00103\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u0015¨\u0006\u0096\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/view/accessibility/AccessibilityDelegateImpl;", "", "host", "Landroid/view/View;", "l", "Lcom/samsung/android/sdk/composer/view/accessibility/SpenAccessibilityDelegateListener;", "<init>", "(Landroid/view/View;Lcom/samsung/android/sdk/composer/view/accessibility/SpenAccessibilityDelegateListener;)V", "mAccessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "mDelegate", "Lcom/samsung/android/sdk/composer/view/accessibility/AccessibilityDelegateImpl$SpenAccessibilityDelegate;", "mListener", "mStateChangeListener", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "mContext", "Landroid/content/Context;", "mHost", "value", "", "isEnabled", "()Z", "mHashMap", "Ljava/util/HashMap;", "", "Lcom/samsung/android/sdk/composer/view/accessibility/SpenAccessibilityNodeInfo;", "Lkotlin/collections/HashMap;", "mNodeList", "", "mTextNodeNativeId", "mSpenObjectTextBox", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "mInvalidateHandler", "Lcom/samsung/android/sdk/composer/view/accessibility/AccessibilityDelegateImpl$SpenAccessibilityHandler;", "mMovementPos", "mCurrentCursorPos", "mScrollAnimator", "Landroid/animation/TimeAnimator;", "mAutoscrollDistance", "", "mAutoscrollDistanceGap", "mHandler", "Landroid/os/Handler;", "getMHandler$annotations", "()V", "mAccessibilityContentResolver", "Lcom/samsung/android/sdk/composer/view/accessibility/AccessibilityContentObserver;", "accessibilityClassName", "", "getAccessibilityClassName", "()Ljava/lang/CharSequence;", "isFocusInScreen", "close", "", "onFocusChanged", "gainFocus", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", "dispatchHoverEvent", "event", "Landroid/view/MotionEvent;", "dispatchKeyEvent", "Landroid/view/KeyEvent;", "onScrollChanged", "dy", "clearCache", "setEnabled", "keyToDirection", "keyCode", "clickKeyboardFocusedVirtualView", "moveKeyFocus", "invalidateRoot", "invalidateVirtualView", "id", "hasFocus", "isInScreen", "updateFocus", "offsetY", "findNextFocusByDirection", "findNextFocusByIndex", "index", "getLastNodeInScreen", Constants.MessagePayloadKeys.FROM, "getFirstNodeInScreen", "setFocus", "focusId", "setNodeListWithCache", XmlErrorCodes.LIST, "", "getNodeList", DialogConstant.BUNDLE_IDS, "getId", "x", "y", "getNodeInfo", "extend", "getNodeIndex", "getNextNodeId", "getPrevNodeId", "getUpNodeId", "getDownNodeId", "isBetterCandidate", "source", "candidate", "currentBest", "beamBeats", "rect1", "rect2", "beamsOverlap", "isToDirectionOf", "src", "dest", "majorAxisDistance", "majorAxisDistanceRaw", "majorAxisDistanceToFarEdge", "majorAxisDistanceToFarEdgeRaw", "getWeightedDistanceFor", "minorAxisDistance", "isCandidate", "srcRect", "destRect", "moveTop", "moveBottom", "scroll", "performSetSelectAction", "arguments", "Landroid/os/Bundle;", "objectTextBox", "performMovementAction", "nodeInfo", "isNext", "isNodeFocused", "doMoveCursor", "granularity", "isFocused", "sendViewTextTraversedAtGranularityEvent", "action", "fromIndex", "toIndex", "doExtendSelection", "getNewCursorPosition", "", "nativeId", "currentPos", "performCopyAction", "performActionForTextContent", "SpenAccessibilityDelegate", "SpenAccessibilityHandler", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
@SourceDebugExtension({"SMAP\nAccessibilityDelegateImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AccessibilityDelegateImpl.kt\ncom/samsung/android/sdk/composer/view/accessibility/AccessibilityDelegateImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1375:1\n1#2:1376\n*E\n"})
public final class AccessibilityDelegateImpl {
    private static final float AUTOSCROLL_MAX_DISTANCE = 10.3f;
    private static final float AUTOSCROLL_MIN_DISTANCE = 0.5f;
    private static final int AUTOSCROLL_SPEED_LEVEL_COUNT_DEFAULT = 15;
    private static final int AUTOSCROLL_SPEED_LEVEL_DEFAULT = 8;
    private static final int BOOLEAN_PROPERTY_CHECKABLE = 1;
    private static final int BOOLEAN_PROPERTY_CHECKED = 2;
    private static final int BOOLEAN_PROPERTY_CLICKABLE = 32;
    private static final int BOOLEAN_PROPERTY_EDITABLE = 4096;
    private static final int BOOLEAN_PROPERTY_LONG_CLICKABLE = 64;
    private static final int CURSOR_POSITION_UNDEFINED = -1;
    public static final int INVALIDATE_ROOT = 1;
    private static final int SEM_ACTION_AUTOSCROLL_OFF = 8388608;
    private static final int SEM_ACTION_AUTOSCROLL_ON = 4194304;
    private static final int SEM_ACTION_AUTOSCROLL_SPEED_DOWN = 536870912;
    private static final int SEM_ACTION_AUTOSCROLL_SPEED_UP = 268435456;
    private static final int SEM_ACTION_AUTOSCROLL_TOP = 67108864;
    public static final int SET_FOCUS_INTERVAL = 2;

    @NotNull
    private static final String TAG = "AccessibilityDelegateImpl";
    private boolean isEnabled;

    @NotNull
    private final AccessibilityContentObserver mAccessibilityContentResolver;

    @NotNull
    private AccessibilityManager mAccessibilityManager;
    private float mAutoscrollDistance;
    private float mAutoscrollDistanceGap;

    @NotNull
    private Context mContext;
    private int mCurrentCursorPos;

    @Nullable
    private SpenAccessibilityDelegate mDelegate;

    @NotNull
    private final Handler mHandler;

    @Nullable
    private HashMap<Integer, SpenAccessibilityNodeInfo> mHashMap;

    @Nullable
    private View mHost;

    @Nullable
    private SpenAccessibilityHandler mInvalidateHandler;

    @Nullable
    private SpenAccessibilityDelegateListener mListener;
    private int mMovementPos;

    @Nullable
    private List<SpenAccessibilityNodeInfo> mNodeList;

    @Nullable
    private TimeAnimator mScrollAnimator;

    @Nullable
    private SpenObjectTextBox mSpenObjectTextBox;

    @NotNull
    private AccessibilityManager.AccessibilityStateChangeListener mStateChangeListener;
    private int mTextNodeNativeId;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0014J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0014J\u0016\u0010\u001a\u001a\u00020\u00072\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\tH\u0014J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\tH\u0014J\"\u0010 \u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\"\u0010$\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u000f2\b\u0010%\u001a\u0004\u0018\u00010#H\u0016¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/view/accessibility/AccessibilityDelegateImpl$SpenAccessibilityDelegate;", "Landroidx/customview/widget/ExploreByTouchHelper;", "host", "Landroid/view/View;", "<init>", "(Lcom/samsung/android/sdk/composer/view/accessibility/AccessibilityDelegateImpl;Landroid/view/View;)V", "onInitializeAccessibilityNodeInfo", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "onPopulateEventForHost", "event", "Landroid/view/accessibility/AccessibilityEvent;", "onPopulateEventForVirtualView", "virtualViewId", "", "onRequestSendAccessibilityEvent", "", "Landroid/view/ViewGroup;", "child", "onInitializeAccessibilityEvent", "onPopulateAccessibilityEvent", "getVirtualViewAt", "x", "", "y", "getVisibleVirtualViews", "virtualViewIds", "", "onPopulateNodeForHost", "node", "onPopulateNodeForVirtualView", "onPerformActionForVirtualView", "action", "arguments", "Landroid/os/Bundle;", "performAccessibilityAction", "args", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nAccessibilityDelegateImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AccessibilityDelegateImpl.kt\ncom/samsung/android/sdk/composer/view/accessibility/AccessibilityDelegateImpl$SpenAccessibilityDelegate\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1375:1\n1#2:1376\n*E\n"})
    public final class SpenAccessibilityDelegate extends ExploreByTouchHelper {
        final /* synthetic */ AccessibilityDelegateImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SpenAccessibilityDelegate(@NotNull AccessibilityDelegateImpl accessibilityDelegateImpl, View host) {
            super(host);
            Intrinsics.checkNotNullParameter(host, "host");
            this.this$0 = accessibilityDelegateImpl;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public int getVirtualViewAt(float x, float y2) {
            int id = this.this$0.getId((int) (x + 0.5f), (int) (y2 + 0.5f));
            if (id != -1) {
                return id;
            }
            return Integer.MIN_VALUE;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void getVisibleVirtualViews(@NotNull List<Integer> virtualViewIds) {
            Intrinsics.checkNotNullParameter(virtualViewIds, "virtualViewIds");
            this.this$0.getNodeList(virtualViewIds);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(@NotNull View host, @NotNull AccessibilityEvent event) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(event, "event");
            super.onInitializeAccessibilityEvent(host, event);
            event.setClassName(this.this$0.getAccessibilityClassName());
            event.setEnabled(this.this$0.getIsEnabled());
            if (event.getEventType() == 8192) {
                SpenObjectTextBox spenObjectTextBox = this.this$0.mSpenObjectTextBox;
                String text = spenObjectTextBox != null ? spenObjectTextBox.getText() : null;
                if (text == null || text.length() == 0) {
                    return;
                }
                event.setClassName(AndroidComposeViewAccessibilityDelegateCompat.TextFieldClassName);
                event.setFromIndex(this.this$0.mCurrentCursorPos);
                event.setToIndex(this.this$0.mCurrentCursorPos);
                event.setItemCount(text.length());
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(@NotNull View host, @NotNull AccessibilityNodeInfoCompat info) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(host, info);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public boolean onPerformActionForVirtualView(int virtualViewId, int action, @Nullable Bundle arguments) {
            View view;
            AccessibilityNodeProviderCompat accessibilityNodeProvider;
            SpenAccessibilityNodeInfo nodeInfo;
            if (action == 16) {
                SpenAccessibilityNodeInfo nodeInfo2 = this.this$0.getNodeInfo(getAccessibilityFocusedVirtualViewId());
                if (nodeInfo2 != null && (nodeInfo2.getPropertyFlag() & 4096) == 4096 && (view = this.this$0.mHost) != null) {
                    SpenAccessibilityDelegate spenAccessibilityDelegate = this.this$0.mDelegate;
                    return Intrinsics.areEqual((spenAccessibilityDelegate == null || (accessibilityNodeProvider = spenAccessibilityDelegate.getAccessibilityNodeProvider(view)) == null) ? null : Boolean.valueOf(accessibilityNodeProvider.performAction(nodeInfo2.hashCode(), 1, arguments)), Boolean.TRUE);
                }
            } else if ((action == 256 || action == 512 || action == 16384 || action == 32768 || action == 65536 || action == 131072) && (nodeInfo = this.this$0.getNodeInfo(virtualViewId)) != null && (nodeInfo.getPropertyFlag() & 4096) == 4096) {
                return this.this$0.performActionForTextContent(action, arguments, nodeInfo);
            }
            return false;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(@NotNull View host, @NotNull AccessibilityEvent event) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(event, "event");
            super.onPopulateAccessibilityEvent(host, event);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateEventForHost(@NotNull AccessibilityEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.onPopulateEventForHost(event);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateEventForVirtualView(int virtualViewId, @NotNull AccessibilityEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.onPopulateEventForVirtualView(virtualViewId, event);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForHost(@NotNull AccessibilityNodeInfoCompat node) {
            Intrinsics.checkNotNullParameter(node, "node");
            super.onPopulateNodeForHost(node);
            node.setEnabled(true);
            node.setClickable(true);
            node.setFocusable(true);
            node.setScrollable(true);
            node.setVisibleToUser(true);
            node.setImportantForAccessibility(true);
            if (node.isClickable()) {
                node.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            }
            if (node.isLongClickable()) {
                node.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_LONG_CLICK);
            }
            if (node.isScrollable()) {
                node.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                node.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForVirtualView(int virtualViewId, @NotNull AccessibilityNodeInfoCompat node) {
            Rect bound;
            Intrinsics.checkNotNullParameter(node, "node");
            node.setContentDescription("");
            node.setBoundsInParent(new Rect());
            SpenAccessibilityNodeInfo nodeInfo = this.this$0.getNodeInfo(virtualViewId);
            if (nodeInfo == null || (bound = nodeInfo.getBound()) == null || bound.isEmpty()) {
                return;
            }
            Editable text = nodeInfo.getText();
            if (text == null) {
                text = "";
            }
            node.setText(text);
            SpenAccessibilityDelegateListener spenAccessibilityDelegateListener = this.this$0.mListener;
            if (spenAccessibilityDelegateListener != null) {
                AccessibilityDelegateImpl accessibilityDelegateImpl = this.this$0;
                SpenObjectBase objectByNativeId = spenAccessibilityDelegateListener.getObjectByNativeId(nodeInfo.getNativeId());
                if (objectByNativeId != null && (objectByNativeId instanceof SpenObjectTextBox)) {
                    SpenAccessibilityDelegateListener spenAccessibilityDelegateListener2 = accessibilityDelegateImpl.mListener;
                    Triple<Editable, Integer, Integer> editable = spenAccessibilityDelegateListener2 != null ? spenAccessibilityDelegateListener2.getEditable(((SpenObjectTextBox) objectByNativeId).getRuntimeHandle(), nodeInfo.getPageIndex()) : null;
                    if (editable != null) {
                        if (editable.getSecond().intValue() < 0 || editable.getThird().intValue() < 0) {
                            node.setText(editable.getFirst());
                        } else {
                            Editable first = editable.getFirst();
                            node.setText(first != null ? first.subSequence(editable.getSecond().intValue(), editable.getThird().intValue()) : null);
                        }
                        node.setTextSelection(Selection.getSelectionStart(editable.getFirst()), Selection.getSelectionEnd(editable.getFirst()));
                    }
                }
            }
            node.setImportantForAccessibility(true);
            node.setContentDescription(nodeInfo.getDescription() != null ? nodeInfo.getDescription() : "");
            node.setRoleDescription(nodeInfo.getRoleDescription() != null ? nodeInfo.getRoleDescription() : "");
            node.setStateDescription(nodeInfo.getStateDescription() != null ? nodeInfo.getStateDescription() : "");
            node.setBoundsInParent(bound);
            node.setEnabled(true);
            node.setFocusable(true);
            node.setCheckable((nodeInfo.getPropertyFlag() & 1) == 1);
            node.setChecked((nodeInfo.getPropertyFlag() & 2) == 2);
            node.setClickable((nodeInfo.getPropertyFlag() & 32) == 32);
            node.setLongClickable((nodeInfo.getPropertyFlag() & 64) == 64);
            node.setEditable((nodeInfo.getPropertyFlag() & 4096) == 4096);
            if (node.isEditable()) {
                node.setClassName(AndroidComposeViewAccessibilityDelegateCompat.TextFieldClassName);
                node.setMovementGranularities(15);
                node.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COPY);
                node.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CUT);
                node.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_PASTE);
                node.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_SELECTION);
                node.setFocused(nodeInfo.getIsFocused());
            }
            if (node.isClickable()) {
                node.addAction(node.isEditable() ? new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, this.this$0.mContext.getString(C7932R.string.voice_assistant_editbox_click_action_label)) : AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            }
            if (node.isLongClickable()) {
                node.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_LONG_CLICK);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(@NotNull ViewGroup host, @NotNull View child, @NotNull AccessibilityEvent event) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(child, "child");
            Intrinsics.checkNotNullParameter(event, "event");
            return super.onRequestSendAccessibilityEvent(host, child, event);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(@NotNull View host, int action, @Nullable Bundle args) {
            AccessibilityDelegateImpl accessibilityDelegateImpl;
            int nextNodeId;
            AccessibilityDelegateImpl accessibilityDelegateImpl2;
            int prevNodeId;
            int i;
            Intrinsics.checkNotNullParameter(host, "host");
            if (super.performAccessibilityAction(host, action, args)) {
                return true;
            }
            if (action == 4096) {
                this.this$0.mCurrentCursorPos = -1;
                SpenAccessibilityDelegate spenAccessibilityDelegate = this.this$0.mDelegate;
                if (spenAccessibilityDelegate == null || (nextNodeId = (accessibilityDelegateImpl = this.this$0).getNextNodeId(spenAccessibilityDelegate.getAccessibilityFocusedVirtualViewId())) <= 0) {
                    return false;
                }
                accessibilityDelegateImpl.scroll(accessibilityDelegateImpl.moveBottom(nextNodeId));
                SpenAccessibilityHandler spenAccessibilityHandler = accessibilityDelegateImpl.mInvalidateHandler;
                if (spenAccessibilityHandler != null) {
                    spenAccessibilityHandler.setFocusAtInterval(nextNodeId);
                }
                return true;
            }
            if (action == 8192) {
                this.this$0.mCurrentCursorPos = -1;
                SpenAccessibilityDelegate spenAccessibilityDelegate2 = this.this$0.mDelegate;
                if (spenAccessibilityDelegate2 == null || (prevNodeId = (accessibilityDelegateImpl2 = this.this$0).getPrevNodeId(spenAccessibilityDelegate2.getAccessibilityFocusedVirtualViewId())) <= 0) {
                    return false;
                }
                accessibilityDelegateImpl2.scroll(accessibilityDelegateImpl2.moveTop(prevNodeId));
                SpenAccessibilityHandler spenAccessibilityHandler2 = accessibilityDelegateImpl2.mInvalidateHandler;
                if (spenAccessibilityHandler2 != null) {
                    spenAccessibilityHandler2.setFocusAtInterval(prevNodeId);
                }
                return true;
            }
            if (action == 4194304) {
                AccessibilityDelegateImpl accessibilityDelegateImpl3 = this.this$0;
                if (args != null) {
                    accessibilityDelegateImpl3.mAutoscrollDistanceGap = 9.8f / (args.getInt("auto_scroll_speed_level_count", 15) - 1);
                    i = args.getInt("auto_scroll_speed_level", 8) - 1;
                } else {
                    i = 7;
                }
                accessibilityDelegateImpl3.mAutoscrollDistance = (accessibilityDelegateImpl3.mAutoscrollDistanceGap * i) + 0.5f;
                TimeAnimator timeAnimator = accessibilityDelegateImpl3.mScrollAnimator;
                if (timeAnimator != null) {
                    timeAnimator.start();
                    return true;
                }
                AccessibilityDelegateImpl accessibilityDelegateImpl4 = this.this$0;
                if (accessibilityDelegateImpl4.mAutoscrollDistance - accessibilityDelegateImpl4.mAutoscrollDistanceGap >= 0.5f) {
                    accessibilityDelegateImpl4.mAutoscrollDistance -= accessibilityDelegateImpl4.mAutoscrollDistanceGap;
                }
                return true;
            }
            if (action == 8388608) {
                TimeAnimator timeAnimator2 = this.this$0.mScrollAnimator;
                if (timeAnimator2 == null) {
                    return false;
                }
                timeAnimator2.cancel();
                return true;
            }
            if (action == 67108864) {
                SpenAccessibilityDelegateListener spenAccessibilityDelegateListener = this.this$0.mListener;
                if (spenAccessibilityDelegateListener == null) {
                    return false;
                }
                spenAccessibilityDelegateListener.onMove(0.0f);
                return true;
            }
            if (action == 268435456) {
                if (this.this$0.mAutoscrollDistanceGap + this.this$0.mAutoscrollDistance <= AccessibilityDelegateImpl.AUTOSCROLL_MAX_DISTANCE) {
                    AccessibilityDelegateImpl accessibilityDelegateImpl5 = this.this$0;
                    accessibilityDelegateImpl5.mAutoscrollDistance = this.this$0.mAutoscrollDistanceGap + accessibilityDelegateImpl5.mAutoscrollDistance;
                }
                return true;
            }
            if (action != 536870912) {
                return false;
            }
            if (this.this$0.mAutoscrollDistance - this.this$0.mAutoscrollDistanceGap >= 0.5f) {
                this.this$0.mAutoscrollDistance -= this.this$0.mAutoscrollDistanceGap;
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\tJ\b\u0010\u0011\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/view/accessibility/AccessibilityDelegateImpl$SpenAccessibilityHandler;", "Landroid/os/Handler;", "<init>", "(Lcom/samsung/android/sdk/composer/view/accessibility/AccessibilityDelegateImpl;)V", "mFocusId", "", "mIsPending", "", "handleMessage", "", "msg", "Landroid/os/Message;", "invalidateRoot", "delay", "setFocusAtInterval", "focusId", "close", "reset", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class SpenAccessibilityHandler extends Handler {
        private int mFocusId;
        private boolean mIsPending;

        public SpenAccessibilityHandler() {
            reset();
        }

        private final void reset() {
            this.mFocusId = -1;
            this.mIsPending = false;
        }

        public final void close() {
            reset();
            removeMessages(1);
            removeMessages(2);
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            int i = msg.what;
            if (i == 1) {
                AccessibilityDelegateImpl.this.invalidateRoot();
            } else if (i == 2) {
                if (AccessibilityDelegateImpl.this.isInScreen(this.mFocusId)) {
                    AccessibilityDelegateImpl.this.setFocus(this.mFocusId);
                }
                reset();
            }
            super.handleMessage(msg);
        }

        public final void invalidateRoot(int delay) {
            removeMessages(1);
            sendEmptyMessageDelayed(1, delay);
        }

        public final void setFocusAtInterval(int focusId) {
            this.mFocusId = focusId;
            if (this.mIsPending) {
                return;
            }
            sendEmptyMessageDelayed(2, 100L);
            this.mIsPending = true;
        }
    }

    public AccessibilityDelegateImpl(@NotNull View host, @Nullable SpenAccessibilityDelegateListener spenAccessibilityDelegateListener) {
        Intrinsics.checkNotNullParameter(host, "host");
        this.mTextNodeNativeId = -1;
        this.mMovementPos = -1;
        this.mCurrentCursorPos = -1;
        final Handler handler = new Handler();
        this.mHandler = handler;
        AccessibilityContentObserver accessibilityContentObserver = new AccessibilityContentObserver(handler) { // from class: com.samsung.android.sdk.composer.view.accessibility.AccessibilityDelegateImpl$mAccessibilityContentResolver$1
            @Override // com.samsung.android.sdk.composer.view.accessibility.AccessibilityContentObserver, android.database.ContentObserver
            public void onChange(boolean selfChange, Uri uri) {
                this.this$0.setEnabled();
            }
        };
        this.mAccessibilityContentResolver = accessibilityContentObserver;
        this.mDelegate = new SpenAccessibilityDelegate(this, host);
        this.mListener = spenAccessibilityDelegateListener;
        this.mContext = host.getContext();
        this.mHost = host;
        this.mInvalidateHandler = new SpenAccessibilityHandler();
        setEnabled();
        ContentResolver contentResolver = this.mContext.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        accessibilityContentObserver.register(contentResolver);
        ViewCompat.setAccessibilityDelegate(host, this.mDelegate);
        this.mStateChangeListener = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: com.samsung.android.sdk.composer.view.accessibility.a
            @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
            public final void onAccessibilityStateChanged(boolean z) {
                AccessibilityDelegateImpl._init_$lambda$2(this.f4865a, z);
            }
        };
        Object systemService = this.mContext.getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
        this.mAccessibilityManager = accessibilityManager;
        accessibilityManager.addAccessibilityStateChangeListener(this.mStateChangeListener);
        TimeAnimator timeAnimator = new TimeAnimator();
        this.mScrollAnimator = timeAnimator;
        timeAnimator.setTimeListener(new TimeAnimator.TimeListener() { // from class: com.samsung.android.sdk.composer.view.accessibility.b
            @Override // android.animation.TimeAnimator.TimeListener
            public final void onTimeUpdate(TimeAnimator timeAnimator2, long j, long j2) {
                AccessibilityDelegateImpl._init_$lambda$3(this.f4866a, timeAnimator2, j, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(AccessibilityDelegateImpl accessibilityDelegateImpl, boolean z) {
        SpenAccessibilityDelegateListener spenAccessibilityDelegateListener = accessibilityDelegateImpl.mListener;
        if (spenAccessibilityDelegateListener != null) {
            spenAccessibilityDelegateListener.onAccessibilityStateChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(AccessibilityDelegateImpl accessibilityDelegateImpl, TimeAnimator timeAnimator, long j, long j2) {
        SpenAccessibilityDelegateListener spenAccessibilityDelegateListener = accessibilityDelegateImpl.mListener;
        if (spenAccessibilityDelegateListener != null) {
            spenAccessibilityDelegateListener.onScroll(0.0f, accessibilityDelegateImpl.mAutoscrollDistance);
        }
    }

    private final boolean beamBeats(int direction, Rect source, Rect rect1, Rect rect2) {
        boolean zBeamsOverlap = beamsOverlap(direction, source, rect1);
        if (beamsOverlap(direction, source, rect2) || !zBeamsOverlap) {
            return false;
        }
        return !isToDirectionOf(direction, source, rect2) || direction == 17 || direction == 66 || majorAxisDistance(direction, source, rect1) < majorAxisDistanceToFarEdge(direction, source, rect2);
    }

    private final boolean beamsOverlap(int direction, Rect rect1, Rect rect2) {
        if (direction != 17) {
            if (direction != 33) {
                if (direction != 66) {
                    if (direction != 130) {
                        return false;
                    }
                }
            }
            return rect2.right >= rect1.left && rect2.left <= rect1.right;
        }
        return rect2.bottom >= rect1.top && rect2.top <= rect1.bottom;
    }

    private final void clearCache() {
        HashMap<Integer, SpenAccessibilityNodeInfo> map = this.mHashMap;
        if (map != null) {
            map.clear();
        }
        this.mHashMap = null;
        List<SpenAccessibilityNodeInfo> list = this.mNodeList;
        if (list != null) {
            list.clear();
        }
        this.mNodeList = null;
    }

    private final boolean clickKeyboardFocusedVirtualView() {
        SpenAccessibilityNodeInfo nodeInfo;
        SpenAccessibilityDelegate spenAccessibilityDelegate = this.mDelegate;
        if (spenAccessibilityDelegate == null) {
            return false;
        }
        int keyboardFocusedVirtualViewId = spenAccessibilityDelegate.getKeyboardFocusedVirtualViewId();
        View view = this.mHost;
        if (view == null || keyboardFocusedVirtualViewId == Integer.MIN_VALUE || (nodeInfo = getNodeInfo(keyboardFocusedVirtualViewId)) == null) {
            return false;
        }
        AccessibilityNodeProviderCompat accessibilityNodeProvider = spenAccessibilityDelegate.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            accessibilityNodeProvider.performAction(keyboardFocusedVirtualViewId, 16, null);
        }
        SpenAccessibilityDelegateListener spenAccessibilityDelegateListener = this.mListener;
        if (spenAccessibilityDelegateListener == null) {
            return true;
        }
        spenAccessibilityDelegateListener.onClick(nodeInfo.getNativeId());
        return true;
    }

    private final boolean doExtendSelection(SpenObjectTextBox objectTextBox, boolean isNext, int granularity, SpenAccessibilityNodeInfo nodeInfo) {
        int i;
        int i2;
        if (objectTextBox != null) {
            int selectedStart = objectTextBox.getSelectedStart();
            int selectedEnd = objectTextBox.getSelectedEnd();
            int cursorPosition = objectTextBox.getCursorPosition();
            if (selectedStart >= 0 || selectedEnd >= 0 || cursorPosition < 0) {
                i = selectedStart;
                i2 = selectedEnd;
            } else {
                i = cursorPosition;
                i2 = i;
            }
            int i4 = this.mMovementPos;
            if (i4 != i && i4 != i2) {
                this.mMovementPos = -1;
            }
            if (i >= 0 && i2 >= 0) {
                if (this.mMovementPos == -1) {
                    this.mMovementPos = i2;
                }
                int[] newCursorPosition = getNewCursorPosition(isNext, granularity, nodeInfo.getNativeId(), objectTextBox, this.mMovementPos);
                if (newCursorPosition == null) {
                    return false;
                }
                int i5 = this.mMovementPos;
                if (i5 == i) {
                    i = isNext ? newCursorPosition[1] : newCursorPosition[0];
                    this.mMovementPos = i;
                } else if (i5 == i2) {
                    i2 = isNext ? newCursorPosition[1] : newCursorPosition[0];
                    this.mMovementPos = i2;
                }
                if (i > i2) {
                    int i6 = i2;
                    i2 = i;
                    i = i6;
                }
                objectTextBox.setSelection(i, i2);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean doMoveCursor(SpenObjectTextBox objectTextBox, boolean isNext, int granularity, SpenAccessibilityNodeInfo nodeInfo, boolean isFocused) {
        String text;
        int cursorPosition;
        int i;
        if (objectTextBox == null || (text = objectTextBox.getText()) == null) {
            return false;
        }
        if (!isFocused) {
            cursorPosition = this.mCurrentCursorPos;
            if (cursorPosition < 0) {
                if (isNext) {
                    i = 0;
                } else {
                    cursorPosition = text.length();
                }
            }
            if (i >= 0) {
                return false;
            }
            int[] newCursorPosition = getNewCursorPosition(isNext, granularity, nodeInfo.getNativeId(), objectTextBox, i);
            if (newCursorPosition == null) {
                this.mCurrentCursorPos = -1;
                return false;
            }
            if (isNext) {
                this.mCurrentCursorPos = newCursorPosition[1];
            } else {
                this.mCurrentCursorPos = newCursorPosition[0];
            }
            if (isFocused) {
                objectTextBox.setCursorPosition(this.mCurrentCursorPos);
            }
            View view = this.mHost;
            if (view != null) {
                view.sendAccessibilityEvent(8192);
            }
            sendViewTextTraversedAtGranularityEvent(isNext ? 256 : 512, granularity, newCursorPosition[0], newCursorPosition[1]);
            return true;
        }
        cursorPosition = objectTextBox.getCursorPosition();
        if (cursorPosition < 0) {
            cursorPosition = !isNext ? objectTextBox.getSelectedStart() : objectTextBox.getSelectedEnd();
        }
        i = cursorPosition;
        if (i >= 0) {
        }
    }

    private final SpenAccessibilityNodeInfo findNextFocusByDirection(int offsetY) {
        if (this.mNodeList != null) {
            return offsetY <= 0 ? getFirstNodeInScreen(0) : getLastNodeInScreen(r0.size() - 1);
        }
        return null;
    }

    private final SpenAccessibilityNodeInfo findNextFocusByIndex(int index) {
        SpenAccessibilityNodeInfo spenAccessibilityNodeInfo;
        List<SpenAccessibilityNodeInfo> list = this.mNodeList;
        if (list != null && list != null && (spenAccessibilityNodeInfo = list.get(index)) != null) {
            Rect rect = new Rect();
            View view = this.mHost;
            if (view != null) {
                view.getLocalVisibleRect(rect);
            }
            Rect bound = spenAccessibilityNodeInfo.getBound();
            if (bound != null && Rect.intersects(rect, bound)) {
                return spenAccessibilityNodeInfo;
            }
            Rect bound2 = spenAccessibilityNodeInfo.getBound();
            if (bound2 != null) {
                return bound2.bottom <= rect.top ? getFirstNodeInScreen(index) : getLastNodeInScreen(index);
            }
        }
        return null;
    }

    private final int getDownNodeId(int id) {
        int nodeIndex;
        SpenAccessibilityNodeInfo spenAccessibilityNodeInfo;
        SpenAccessibilityNodeInfo spenAccessibilityNodeInfo2;
        Rect bound;
        List<SpenAccessibilityNodeInfo> list = this.mNodeList;
        if (list == null || (nodeIndex = getNodeIndex(id)) < 0 || nodeIndex >= list.size() - 1 || (spenAccessibilityNodeInfo = list.get(nodeIndex)) == null) {
            return -1;
        }
        Rect bound2 = spenAccessibilityNodeInfo.getBound();
        int i = nodeIndex + 1;
        SpenAccessibilityNodeInfo spenAccessibilityNodeInfo3 = list.get(i);
        Rect rect = new Rect(spenAccessibilityNodeInfo3 != null ? spenAccessibilityNodeInfo3.getBound() : null);
        int iHashCode = spenAccessibilityNodeInfo3 != null ? spenAccessibilityNodeInfo3.hashCode() : 0;
        int size = list.size();
        while (i < size) {
            SpenAccessibilityNodeInfo spenAccessibilityNodeInfo4 = list.get(i);
            if (bound2 != null && (spenAccessibilityNodeInfo2 = spenAccessibilityNodeInfo4) != null && (bound = spenAccessibilityNodeInfo2.getBound()) != null && isBetterCandidate(130, bound2, bound, rect)) {
                rect.set(bound);
                iHashCode = spenAccessibilityNodeInfo2.hashCode();
            }
            i++;
        }
        return iHashCode;
    }

    private final SpenAccessibilityNodeInfo getFirstNodeInScreen(int from) {
        View view;
        Rect bound;
        List<SpenAccessibilityNodeInfo> list = this.mNodeList;
        SpenAccessibilityNodeInfo spenAccessibilityNodeInfo = null;
        if (list != null && (view = this.mHost) != null) {
            Rect rect = new Rect();
            view.getLocalVisibleRect(rect);
            int size = list.size();
            if (from <= 0) {
                from = 0;
            }
            while (from < size) {
                spenAccessibilityNodeInfo = list.get(from);
                if (spenAccessibilityNodeInfo != null && (bound = spenAccessibilityNodeInfo.getBound()) != null && Rect.intersects(rect, bound)) {
                    return spenAccessibilityNodeInfo;
                }
                from++;
            }
        }
        return spenAccessibilityNodeInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getId(int x, int y2) {
        Rect bound;
        List<SpenAccessibilityNodeInfo> list = this.mNodeList;
        if (list != null) {
            for (int size = list.size() - 1; -1 < size; size--) {
                SpenAccessibilityNodeInfo spenAccessibilityNodeInfo = list.get(size);
                if (spenAccessibilityNodeInfo != null && (bound = spenAccessibilityNodeInfo.getBound()) != null && bound.contains(x, y2)) {
                    return spenAccessibilityNodeInfo.hashCode();
                }
            }
        }
        return -1;
    }

    private final SpenAccessibilityNodeInfo getLastNodeInScreen(int from) {
        View view;
        Rect bound;
        List<SpenAccessibilityNodeInfo> list = this.mNodeList;
        SpenAccessibilityNodeInfo spenAccessibilityNodeInfo = null;
        if (list != null && (view = this.mHost) != null) {
            Rect rect = new Rect();
            view.getLocalVisibleRect(rect);
            int size = list.size();
            if (from >= size) {
                from = size - 1;
            }
            while (-1 < from) {
                spenAccessibilityNodeInfo = list.get(from);
                if (spenAccessibilityNodeInfo != null && (bound = spenAccessibilityNodeInfo.getBound()) != null && Rect.intersects(rect, bound)) {
                    return spenAccessibilityNodeInfo;
                }
                from--;
            }
        }
        return spenAccessibilityNodeInfo;
    }

    private static /* synthetic */ void getMHandler$annotations() {
    }

    private final int[] getNewCursorPosition(boolean isNext, int granularity, int nativeId, SpenObjectTextBox objectTextBox, int currentPos) {
        SpenAccessibilityDelegateListener spenAccessibilityDelegateListener;
        String text;
        if (objectTextBox != null && (text = objectTextBox.getText()) != null && isNext && currentPos >= text.length()) {
            return null;
        }
        if ((isNext || currentPos != 0) && (spenAccessibilityDelegateListener = this.mListener) != null) {
            return spenAccessibilityDelegateListener.getCursorPos(nativeId, currentPos, isNext, granularity);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getNextNodeId(int id) {
        int nodeIndex;
        List<SpenAccessibilityNodeInfo> list = this.mNodeList;
        if (list == null || (nodeIndex = getNodeIndex(id)) < 0 || nodeIndex >= list.size() - 1) {
            return -1;
        }
        SpenAccessibilityNodeInfo spenAccessibilityNodeInfo = list.get(nodeIndex + 1);
        if (spenAccessibilityNodeInfo != null) {
            return spenAccessibilityNodeInfo.hashCode();
        }
        return 0;
    }

    private final int getNodeIndex(int id) {
        List<SpenAccessibilityNodeInfo> list = this.mNodeList;
        if (list == null || id <= 0) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            SpenAccessibilityNodeInfo spenAccessibilityNodeInfo = list.get(i);
            if ((spenAccessibilityNodeInfo != null ? spenAccessibilityNodeInfo.hashCode() : 0) == id) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SpenAccessibilityNodeInfo getNodeInfo(int id) {
        return getNodeInfo(id, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getNodeList(List<Integer> ids) {
        SpenAccessibilityDelegateListener spenAccessibilityDelegateListener = this.mListener;
        if (spenAccessibilityDelegateListener == null) {
            return;
        }
        setNodeListWithCache(spenAccessibilityDelegateListener.getNodeList());
        List<SpenAccessibilityNodeInfo> list = this.mNodeList;
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<SpenAccessibilityNodeInfo> it = list.iterator();
        while (true) {
            int iHashCode = 0;
            if (!it.hasNext()) {
                updateFocus(0);
                return;
            }
            SpenAccessibilityNodeInfo next = it.next();
            if (next != null) {
                iHashCode = next.hashCode();
            }
            ids.add(Integer.valueOf(iHashCode));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getPrevNodeId(int id) {
        int nodeIndex;
        List<SpenAccessibilityNodeInfo> list = this.mNodeList;
        if (list == null || (nodeIndex = getNodeIndex(id)) <= 0 || nodeIndex >= list.size()) {
            return -1;
        }
        SpenAccessibilityNodeInfo spenAccessibilityNodeInfo = list.get(nodeIndex - 1);
        if (spenAccessibilityNodeInfo != null) {
            return spenAccessibilityNodeInfo.hashCode();
        }
        return 0;
    }

    private final int getUpNodeId(int id) {
        int nodeIndex;
        SpenAccessibilityNodeInfo spenAccessibilityNodeInfo;
        SpenAccessibilityNodeInfo spenAccessibilityNodeInfo2;
        Rect bound;
        List<SpenAccessibilityNodeInfo> list = this.mNodeList;
        if (list == null || (nodeIndex = getNodeIndex(id)) <= 0 || nodeIndex >= list.size() || (spenAccessibilityNodeInfo = list.get(nodeIndex)) == null) {
            return -1;
        }
        Rect bound2 = spenAccessibilityNodeInfo.getBound();
        int i = nodeIndex - 1;
        SpenAccessibilityNodeInfo spenAccessibilityNodeInfo3 = list.get(i);
        Rect rect = new Rect(spenAccessibilityNodeInfo3 != null ? spenAccessibilityNodeInfo3.getBound() : null);
        int iHashCode = spenAccessibilityNodeInfo3 != null ? spenAccessibilityNodeInfo3.hashCode() : 0;
        while (-1 < i) {
            SpenAccessibilityNodeInfo spenAccessibilityNodeInfo4 = list.get(i);
            if (bound2 != null && (spenAccessibilityNodeInfo2 = spenAccessibilityNodeInfo4) != null && (bound = spenAccessibilityNodeInfo2.getBound()) != null && isBetterCandidate(33, bound2, bound, rect)) {
                rect.set(bound);
                iHashCode = spenAccessibilityNodeInfo2.hashCode();
            }
            i--;
        }
        return iHashCode;
    }

    private final int getWeightedDistanceFor(int majorAxisDistance, int minorAxisDistance) {
        return (minorAxisDistance * minorAxisDistance) + (majorAxisDistance * 13 * majorAxisDistance);
    }

    private final boolean hasFocus() {
        SpenAccessibilityDelegate spenAccessibilityDelegate = this.mDelegate;
        if (spenAccessibilityDelegate != null && spenAccessibilityDelegate.getAccessibilityFocusedVirtualViewId() >= 0) {
            return true;
        }
        View view = this.mHost;
        if (view != null) {
            return view.isAccessibilityFocused();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateRoot() {
        SpenAccessibilityDelegate spenAccessibilityDelegate = this.mDelegate;
        if (spenAccessibilityDelegate != null) {
            spenAccessibilityDelegate.invalidateRoot();
        }
    }

    private final void invalidateVirtualView(int id) {
        SpenAccessibilityDelegate spenAccessibilityDelegate = this.mDelegate;
        if (spenAccessibilityDelegate != null) {
            spenAccessibilityDelegate.invalidateVirtualView(id);
        }
    }

    private final boolean isBetterCandidate(int direction, Rect source, Rect candidate, Rect currentBest) {
        if (!isCandidate(source, candidate, direction)) {
            return false;
        }
        if (isCandidate(source, currentBest, direction) && !beamBeats(direction, source, candidate, currentBest)) {
            return !beamBeats(direction, source, currentBest, candidate) && getWeightedDistanceFor(majorAxisDistance(direction, source, candidate), minorAxisDistance(direction, source, candidate)) < getWeightedDistanceFor(majorAxisDistance(direction, source, currentBest), minorAxisDistance(direction, source, currentBest));
        }
        return true;
    }

    private final boolean isCandidate(Rect srcRect, Rect destRect, int direction) {
        if (direction == 17) {
            return srcRect.right > destRect.right && srcRect.left > destRect.left;
        }
        if (direction == 33) {
            return srcRect.bottom > destRect.bottom && srcRect.top > destRect.top;
        }
        if (direction == 66) {
            return srcRect.left < destRect.left && srcRect.right < destRect.right;
        }
        if (direction == 130) {
            return srcRect.top < destRect.top && srcRect.bottom < destRect.bottom;
        }
        Log.e(TAG, "isCandidate - direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        return false;
    }

    private final boolean isFocusInScreen() {
        int accessibilityFocusedVirtualViewId;
        SpenAccessibilityNodeInfo nodeInfo;
        Rect bound;
        SpenAccessibilityDelegate spenAccessibilityDelegate = this.mDelegate;
        if (spenAccessibilityDelegate != null && (accessibilityFocusedVirtualViewId = spenAccessibilityDelegate.getAccessibilityFocusedVirtualViewId()) >= 0 && (nodeInfo = getNodeInfo(accessibilityFocusedVirtualViewId, false)) != null) {
            Rect rect = new Rect();
            View view = this.mHost;
            if (view != null && view.getLocalVisibleRect(rect) && (bound = nodeInfo.getBound()) != null) {
                return Rect.intersects(rect, bound);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isInScreen(int id) {
        SpenAccessibilityNodeInfo nodeInfo;
        Rect bound;
        if (id >= 0 && (nodeInfo = getNodeInfo(id, false)) != null) {
            Rect rect = new Rect();
            View view = this.mHost;
            if (view != null && view.getLocalVisibleRect(rect) && (bound = nodeInfo.getBound()) != null) {
                return Rect.intersects(rect, bound);
            }
        }
        return false;
    }

    private final boolean isToDirectionOf(int direction, Rect src, Rect dest) {
        return direction != 17 ? direction != 33 ? direction != 66 ? direction == 130 && src.bottom <= dest.top : src.right <= dest.left : src.top >= dest.bottom : src.left >= dest.right;
    }

    private final int keyToDirection(int keyCode) {
        switch (keyCode) {
        }
        return 130;
    }

    private final int majorAxisDistance(int direction, Rect source, Rect dest) {
        return Math.max(0, majorAxisDistanceRaw(direction, source, dest));
    }

    private final int majorAxisDistanceRaw(int direction, Rect source, Rect dest) {
        int i;
        int i2;
        if (direction == 17) {
            i = source.left;
            i2 = dest.right;
        } else if (direction == 33) {
            i = source.top;
            i2 = dest.bottom;
        } else if (direction == 66) {
            i = dest.left;
            i2 = source.right;
        } else {
            if (direction != 130) {
                return -1;
            }
            i = dest.top;
            i2 = source.bottom;
        }
        return i - i2;
    }

    private final int majorAxisDistanceToFarEdge(int direction, Rect source, Rect dest) {
        return Math.max(1, majorAxisDistanceToFarEdgeRaw(direction, source, dest));
    }

    private final int majorAxisDistanceToFarEdgeRaw(int direction, Rect source, Rect dest) {
        int i;
        int i2;
        if (direction == 17) {
            i = source.left;
            i2 = dest.left;
        } else if (direction == 33) {
            i = source.top;
            i2 = dest.top;
        } else if (direction == 66) {
            i = dest.right;
            i2 = source.right;
        } else {
            if (direction != 130) {
                return -1;
            }
            i = dest.bottom;
            i2 = source.bottom;
        }
        return i - i2;
    }

    private final int minorAxisDistance(int direction, Rect source, Rect dest) {
        if (direction != 17) {
            if (direction != 33) {
                if (direction != 66) {
                    if (direction != 130) {
                        return -1;
                    }
                }
            }
            return Math.abs(((source.width() / 2) + source.left) - ((dest.width() / 2) + dest.left));
        }
        return Math.abs(((source.height() / 2) + source.top) - ((dest.height() / 2) + dest.top));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int moveBottom(int id) {
        Rect bound;
        Rect rect = new Rect();
        View view = this.mHost;
        if (view != null) {
            view.getLocalVisibleRect(rect);
        }
        SpenAccessibilityNodeInfo nodeInfo = getNodeInfo(id, false);
        if (nodeInfo == null || (bound = nodeInfo.getBound()) == null) {
            return 0;
        }
        return (rect.bottom - bound.bottom) - 10;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean moveKeyFocus(int direction) {
        int prevNodeId;
        SpenAccessibilityDelegate spenAccessibilityDelegate = this.mDelegate;
        if (spenAccessibilityDelegate == null) {
            return false;
        }
        int keyboardFocusedVirtualViewId = spenAccessibilityDelegate.getKeyboardFocusedVirtualViewId();
        if (keyboardFocusedVirtualViewId <= 0) {
            SpenAccessibilityNodeInfo firstNodeInScreen = getFirstNodeInScreen(0);
            if (firstNodeInScreen == null) {
                return false;
            }
            keyboardFocusedVirtualViewId = firstNodeInScreen.hashCode();
        }
        if (direction == 1) {
            prevNodeId = getPrevNodeId(keyboardFocusedVirtualViewId);
            if (!isInScreen(prevNodeId)) {
                scroll(moveTop(prevNodeId));
            }
        } else if (direction == 2) {
            prevNodeId = getNextNodeId(keyboardFocusedVirtualViewId);
            if (!isInScreen(prevNodeId)) {
                scroll(moveBottom(prevNodeId));
            }
        } else if (direction != 17) {
            if (direction == 33) {
                prevNodeId = getUpNodeId(keyboardFocusedVirtualViewId);
                if (!isInScreen(prevNodeId)) {
                    scroll(moveTop(prevNodeId));
                }
            } else if (direction != 66) {
                if (direction != 130) {
                    Log.e(TAG, "direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    prevNodeId = Integer.MIN_VALUE;
                } else {
                    prevNodeId = getDownNodeId(keyboardFocusedVirtualViewId);
                    if (!isInScreen(prevNodeId)) {
                        scroll(moveBottom(prevNodeId));
                    }
                }
            }
        }
        if (prevNodeId < 0) {
            return false;
        }
        return spenAccessibilityDelegate.requestKeyboardFocusForVirtualView(prevNodeId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int moveTop(int id) {
        Rect bound;
        Rect rect = new Rect();
        View view = this.mHost;
        if (view != null) {
            view.getLocalVisibleRect(rect);
        }
        SpenAccessibilityNodeInfo nodeInfo = getNodeInfo(id, false);
        if (nodeInfo == null || (bound = nodeInfo.getBound()) == null) {
            return 0;
        }
        return (rect.top - bound.top) + 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean performActionForTextContent(int action, Bundle arguments, SpenAccessibilityNodeInfo nodeInfo) {
        SpenAccessibilityDelegateListener spenAccessibilityDelegateListener;
        SpenObjectBase objectByNativeId;
        if (nodeInfo == null || (spenAccessibilityDelegateListener = this.mListener) == null || (objectByNativeId = spenAccessibilityDelegateListener.getObjectByNativeId(nodeInfo.getNativeId())) == null || !(objectByNativeId instanceof SpenObjectTextBox)) {
            return false;
        }
        SpenObjectTextBox spenObjectTextBox = (SpenObjectTextBox) objectByNativeId;
        this.mSpenObjectTextBox = spenObjectTextBox;
        if (spenObjectTextBox.getText() == null) {
            return false;
        }
        this.mTextNodeNativeId = nodeInfo.getNativeId();
        boolean zIsNodeInfoFocused = spenAccessibilityDelegateListener.isNodeInfoFocused(nodeInfo.getNativeId());
        if (action == 256) {
            return performMovementAction(arguments, nodeInfo, this.mSpenObjectTextBox, true, zIsNodeInfoFocused);
        }
        if (action == 512) {
            return performMovementAction(arguments, nodeInfo, this.mSpenObjectTextBox, false, zIsNodeInfoFocused);
        }
        if (action != 16384) {
            if (action == 32768) {
                if (zIsNodeInfoFocused) {
                    return spenAccessibilityDelegateListener.onPerformContextMenuAction(R.id.paste);
                }
                return false;
            }
            if (action != 65536) {
                if (action == 131072 && zIsNodeInfoFocused) {
                    return performSetSelectAction(arguments, this.mSpenObjectTextBox);
                }
                return false;
            }
        }
        if (zIsNodeInfoFocused) {
            return performCopyAction(action, this.mSpenObjectTextBox);
        }
        return false;
    }

    private final boolean performCopyAction(int action, SpenObjectTextBox objectTextBox) {
        SpenAccessibilityDelegateListener spenAccessibilityDelegateListener;
        if ((objectTextBox != null ? objectTextBox.getText() : null) != null && (spenAccessibilityDelegateListener = this.mListener) != null && objectTextBox.getSelectedStart() != -1 && objectTextBox.getSelectedEnd() != -1) {
            if (action == 16384) {
                return spenAccessibilityDelegateListener.onPerformContextMenuAction(R.id.copy);
            }
            if (action == 65536) {
                return spenAccessibilityDelegateListener.onPerformContextMenuAction(R.id.cut);
            }
        }
        return false;
    }

    private final boolean performMovementAction(Bundle arguments, SpenAccessibilityNodeInfo nodeInfo, SpenObjectTextBox objectTextBox, boolean isNext, boolean isNodeFocused) {
        if (arguments == null) {
            return false;
        }
        int i = arguments.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT);
        if (!arguments.getBoolean(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN)) {
            return doMoveCursor(objectTextBox, isNext, i, nodeInfo, isNodeFocused);
        }
        if (isNodeFocused) {
            return doExtendSelection(objectTextBox, isNext, i, nodeInfo);
        }
        return false;
    }

    private final boolean performSetSelectAction(Bundle arguments, SpenObjectTextBox objectTextBox) {
        String text;
        if (arguments == null) {
            return false;
        }
        int i = arguments.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT);
        int length = arguments.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT);
        if ((i == -1 && length == -1) || objectTextBox == null || (text = objectTextBox.getText()) == null) {
            return false;
        }
        if (i == length) {
            if (i < 0 || i > text.length()) {
                return true;
            }
            objectTextBox.setCursorPosition(i);
            return true;
        }
        int i2 = i >= 0 ? i : 0;
        if (length > text.length()) {
            length = text.length();
        }
        objectTextBox.setSelection(i2, length);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scroll(int dy) {
        SpenAccessibilityDelegateListener spenAccessibilityDelegateListener = this.mListener;
        if (spenAccessibilityDelegateListener != null) {
            spenAccessibilityDelegateListener.onScroll(0.0f, dy);
        }
    }

    private final void sendViewTextTraversedAtGranularityEvent(int action, int granularity, int fromIndex, int toIndex) {
        View view = this.mHost;
        if (view != null) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(131072);
            view.onInitializeAccessibilityEvent(accessibilityEventObtain);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain);
            accessibilityEventObtain.setFromIndex(fromIndex);
            accessibilityEventObtain.setToIndex(toIndex);
            accessibilityEventObtain.setAction(action);
            accessibilityEventObtain.setMovementGranularity(granularity);
            view.getParent().requestSendAccessibilityEvent(view, accessibilityEventObtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setEnabled() {
        boolean zIsAccessibilityEnabled = SpenComposerUtil.isAccessibilityEnabled(this.mContext);
        if (zIsAccessibilityEnabled != this.isEnabled) {
            clearCache();
            this.isEnabled = zIsAccessibilityEnabled;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setFocus(int focusId) {
        SpenAccessibilityDelegate spenAccessibilityDelegate;
        AccessibilityNodeProviderCompat accessibilityNodeProvider;
        View view = this.mHost;
        if (view == null || (spenAccessibilityDelegate = this.mDelegate) == null || (accessibilityNodeProvider = spenAccessibilityDelegate.getAccessibilityNodeProvider(view)) == null) {
            return;
        }
        accessibilityNodeProvider.performAction(focusId, 64, null);
    }

    private final void setNodeListWithCache(List<SpenAccessibilityNodeInfo> list) {
        if (list != null) {
            if (this.mHashMap == null) {
                this.mHashMap = new HashMap<>();
            }
            HashMap<Integer, SpenAccessibilityNodeInfo> map = new HashMap<>();
            ArrayList arrayList = new ArrayList();
            List<SpenAccessibilityNodeInfo> list2 = this.mNodeList;
            if (list2 != null) {
                for (SpenAccessibilityNodeInfo spenAccessibilityNodeInfo : list2) {
                    if (spenAccessibilityNodeInfo != null) {
                        map.put(Integer.valueOf(spenAccessibilityNodeInfo.getNativeId()), spenAccessibilityNodeInfo);
                    }
                }
            }
            for (SpenAccessibilityNodeInfo spenAccessibilityNodeInfo2 : list) {
                HashMap<Integer, SpenAccessibilityNodeInfo> map2 = this.mHashMap;
                SpenAccessibilityNodeInfo spenAccessibilityNodeInfo3 = map2 != null ? map2.get(Integer.valueOf(spenAccessibilityNodeInfo2.getNativeId())) : null;
                if (spenAccessibilityNodeInfo3 != null) {
                    spenAccessibilityNodeInfo3.setBound(spenAccessibilityNodeInfo2.getBound());
                    spenAccessibilityNodeInfo3.setDescription(spenAccessibilityNodeInfo2.getDescription());
                    spenAccessibilityNodeInfo3.setRoleDescription(spenAccessibilityNodeInfo2.getRoleDescription());
                    spenAccessibilityNodeInfo3.setStateDescription(spenAccessibilityNodeInfo2.getStateDescription());
                    spenAccessibilityNodeInfo3.setText(spenAccessibilityNodeInfo2.getText());
                    spenAccessibilityNodeInfo3.setPropertyFlag(spenAccessibilityNodeInfo2.getPropertyFlag());
                    spenAccessibilityNodeInfo3.setFocused(spenAccessibilityNodeInfo2.getIsFocused());
                    spenAccessibilityNodeInfo3.setPageIndex(spenAccessibilityNodeInfo2.getPageIndex());
                    spenAccessibilityNodeInfo2 = spenAccessibilityNodeInfo3;
                }
                arrayList.add(spenAccessibilityNodeInfo2);
                map.put(Integer.valueOf(spenAccessibilityNodeInfo2.getNativeId()), spenAccessibilityNodeInfo2);
            }
            HashMap<Integer, SpenAccessibilityNodeInfo> map3 = this.mHashMap;
            if (map3 != null) {
                map3.clear();
            }
            this.mHashMap = map;
            List<SpenAccessibilityNodeInfo> list3 = this.mNodeList;
            if (list3 != null) {
                list3.clear();
            }
            this.mNodeList = arrayList;
        }
    }

    private final void updateFocus(int offsetY) {
        SpenAccessibilityDelegate spenAccessibilityDelegate;
        if (this.mHost == null || this.mNodeList == null || !hasFocus() || (spenAccessibilityDelegate = this.mDelegate) == null) {
            return;
        }
        if (isFocusInScreen()) {
            invalidateVirtualView(spenAccessibilityDelegate.getAccessibilityFocusedVirtualViewId());
            return;
        }
        int nodeIndex = getNodeIndex(spenAccessibilityDelegate.getAccessibilityFocusedVirtualViewId());
        SpenAccessibilityNodeInfo spenAccessibilityNodeInfoFindNextFocusByDirection = nodeIndex < 0 ? findNextFocusByDirection(offsetY) : findNextFocusByIndex(nodeIndex);
        if (spenAccessibilityNodeInfoFindNextFocusByDirection != null) {
            setFocus(spenAccessibilityNodeInfoFindNextFocusByDirection.hashCode());
        }
    }

    public final void close() {
        Object systemService = this.mContext.getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
        this.mAccessibilityManager = accessibilityManager;
        accessibilityManager.removeAccessibilityStateChangeListener(this.mStateChangeListener);
        View view = this.mHost;
        if (view != null) {
            ViewCompat.setAccessibilityDelegate(view, null);
        }
        AccessibilityContentObserver accessibilityContentObserver = this.mAccessibilityContentResolver;
        ContentResolver contentResolver = this.mContext.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        accessibilityContentObserver.unregister(contentResolver);
        SpenAccessibilityHandler spenAccessibilityHandler = this.mInvalidateHandler;
        if (spenAccessibilityHandler != null) {
            spenAccessibilityHandler.close();
        }
        this.mInvalidateHandler = null;
        TimeAnimator timeAnimator = this.mScrollAnimator;
        if (timeAnimator != null) {
            if (timeAnimator.isRunning() || timeAnimator.isStarted()) {
                timeAnimator.cancel();
            }
            timeAnimator.setTimeListener(null);
            timeAnimator.removeAllListeners();
            this.mScrollAnimator = null;
        }
        clearCache();
        this.mHost = null;
        this.mListener = null;
        this.mDelegate = null;
        this.isEnabled = false;
    }

    public final boolean dispatchHoverEvent(@NotNull MotionEvent event) {
        SpenAccessibilityDelegate spenAccessibilityDelegate;
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.isEnabled && (spenAccessibilityDelegate = this.mDelegate) != null) {
            return spenAccessibilityDelegate.dispatchHoverEvent(event);
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean dispatchKeyEvent(@NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int i = 0;
        if (this.isEnabled && hasFocus() && event.getAction() != 1) {
            int keyCode = event.getKeyCode();
            if (keyCode != 61) {
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            if (event.hasNoModifiers()) {
                                int iKeyToDirection = keyToDirection(keyCode);
                                int repeatCount = event.getRepeatCount() + 1;
                                boolean z = false;
                                while (i < repeatCount && moveKeyFocus(iKeyToDirection)) {
                                    i++;
                                    z = true;
                                }
                                return z;
                            }
                            break;
                        case 23:
                            if (event.hasNoModifiers() && event.getRepeatCount() == 0) {
                                clickKeyboardFocusedVirtualView();
                                return true;
                            }
                            break;
                    }
                }
            } else {
                if (event.hasNoModifiers()) {
                    return moveKeyFocus(2);
                }
                if (event.hasModifiers(1)) {
                    return moveKeyFocus(1);
                }
            }
        }
        return false;
    }

    @NotNull
    public final CharSequence getAccessibilityClassName() {
        String name = ScrollView.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }

    /* JADX INFO: renamed from: isEnabled, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    public final void onFocusChanged(boolean gainFocus, int direction, @Nullable Rect previouslyFocusedRect) {
        SpenAccessibilityDelegate spenAccessibilityDelegate;
        if (this.isEnabled && (spenAccessibilityDelegate = this.mDelegate) != null) {
            spenAccessibilityDelegate.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        }
    }

    public final void onScrollChanged(int dy) {
        SpenAccessibilityHandler spenAccessibilityHandler;
        if (!this.isEnabled || (spenAccessibilityHandler = this.mInvalidateHandler) == null) {
            return;
        }
        spenAccessibilityHandler.invalidateRoot(0);
    }

    private final SpenAccessibilityNodeInfo getNodeInfo(int id, boolean extend) {
        if (id >= 0) {
            List<SpenAccessibilityNodeInfo> list = this.mNodeList;
            if (list != null) {
                Iterator<SpenAccessibilityNodeInfo> it = list.iterator();
                while (it.hasNext()) {
                    SpenAccessibilityNodeInfo next = it.next();
                    if ((next != null ? next.hashCode() : 0) == id) {
                        return next;
                    }
                }
            }
            if (extend) {
                HashMap<Integer, SpenAccessibilityNodeInfo> map = this.mHashMap;
                if (map != null) {
                    Iterator<Map.Entry<Integer, SpenAccessibilityNodeInfo>> it2 = map.entrySet().iterator();
                    while (it2.hasNext()) {
                        SpenAccessibilityNodeInfo value = it2.next().getValue();
                        if ((value != null ? value.hashCode() : 0) == id) {
                            return value;
                        }
                    }
                }
                List<SpenAccessibilityNodeInfo> list2 = this.mNodeList;
                if (list2 != null && id < list2.size()) {
                    return list2.get(id);
                }
            }
        }
        AbstractC0541b.m758D(id, "getNodeInfo null = id:", TAG);
        return null;
    }
}
