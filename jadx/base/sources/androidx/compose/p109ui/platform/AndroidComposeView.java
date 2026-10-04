package androidx.compose.p109ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.SystemClock;
import android.os.Trace;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.ScrollCaptureTarget;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.SessionMutex;
import androidx.compose.p109ui.autofill.AndroidAutofill;
import androidx.compose.p109ui.autofill.AndroidAutofill_androidKt;
import androidx.compose.p109ui.autofill.Autofill;
import androidx.compose.p109ui.autofill.AutofillCallback;
import androidx.compose.p109ui.autofill.AutofillTree;
import androidx.compose.p109ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.p109ui.draganddrop.ComposeDragShadowBuilder;
import androidx.compose.p109ui.draganddrop.DragAndDropManager;
import androidx.compose.p109ui.draganddrop.DragAndDropTransferData;
import androidx.compose.p109ui.focus.FocusDirection;
import androidx.compose.p109ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.p109ui.focus.FocusOwner;
import androidx.compose.p109ui.focus.FocusOwnerImpl;
import androidx.compose.p109ui.focus.FocusOwnerImplKt;
import androidx.compose.p109ui.focus.FocusTargetNode;
import androidx.compose.p109ui.focus.FocusTransactionsKt;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.graphics.AndroidGraphicsContext_androidKt;
import androidx.compose.p109ui.graphics.Canvas;
import androidx.compose.p109ui.graphics.CanvasHolder;
import androidx.compose.p109ui.graphics.GraphicsContext;
import androidx.compose.p109ui.graphics.Matrix;
import androidx.compose.p109ui.graphics.RectHelper_androidKt;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.graphics.layer.GraphicsLayer;
import androidx.compose.p109ui.hapticfeedback.HapticFeedback;
import androidx.compose.p109ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.p109ui.input.InputMode;
import androidx.compose.p109ui.input.InputModeManager;
import androidx.compose.p109ui.input.InputModeManagerImpl;
import androidx.compose.p109ui.input.key.Key;
import androidx.compose.p109ui.input.key.KeyEvent;
import androidx.compose.p109ui.input.key.KeyEventType;
import androidx.compose.p109ui.input.key.KeyEvent_androidKt;
import androidx.compose.p109ui.input.key.KeyInputModifierKt;
import androidx.compose.p109ui.input.pointer.MotionEventAdapter;
import androidx.compose.p109ui.input.pointer.PointerIcon;
import androidx.compose.p109ui.input.pointer.PointerIconService;
import androidx.compose.p109ui.input.pointer.PointerInputEvent;
import androidx.compose.p109ui.input.pointer.PointerInputEventData;
import androidx.compose.p109ui.input.pointer.PointerInputEventProcessor;
import androidx.compose.p109ui.input.pointer.PointerInputEventProcessorKt;
import androidx.compose.p109ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.p109ui.input.pointer.PositionCalculator;
import androidx.compose.p109ui.input.pointer.ProcessResult;
import androidx.compose.p109ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.p109ui.input.rotary.RotaryInputModifierKt;
import androidx.compose.p109ui.input.rotary.RotaryScrollEvent;
import androidx.compose.p109ui.internal.InlineClassHelperKt;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.layout.PlaceableKt;
import androidx.compose.p109ui.layout.RootMeasurePolicy;
import androidx.compose.p109ui.modifier.ModifierLocalManager;
import androidx.compose.p109ui.node.DelegatableNode;
import androidx.compose.p109ui.node.DelegatableNodeKt;
import androidx.compose.p109ui.node.DelegatingNode;
import androidx.compose.p109ui.node.LayoutNode;
import androidx.compose.p109ui.node.LayoutNodeDrawScope;
import androidx.compose.p109ui.node.MeasureAndLayoutDelegate;
import androidx.compose.p109ui.node.NestedVectorStack;
import androidx.compose.p109ui.node.NodeKind;
import androidx.compose.p109ui.node.OwnedLayer;
import androidx.compose.p109ui.node.Owner;
import androidx.compose.p109ui.node.OwnerSnapshotObserver;
import androidx.compose.p109ui.node.PointerInputModifierNode;
import androidx.compose.p109ui.node.RootForTest;
import androidx.compose.p109ui.platform.AndroidComposeView;
import androidx.compose.p109ui.platform.ViewLayer;
import androidx.compose.p109ui.scrollcapture.ScrollCapture;
import androidx.compose.p109ui.semantics.EmptySemanticsElement;
import androidx.compose.p109ui.semantics.EmptySemanticsModifier;
import androidx.compose.p109ui.semantics.SemanticsNodeKt;
import androidx.compose.p109ui.semantics.SemanticsOwner;
import androidx.compose.p109ui.text.font.Font;
import androidx.compose.p109ui.text.font.FontFamily;
import androidx.compose.p109ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.p109ui.text.input.TextInputService;
import androidx.compose.p109ui.text.input.TextInputServiceAndroid;
import androidx.compose.p109ui.unit.AndroidDensity_androidKt;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.DensityKt;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntOffsetKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.p109ui.viewinterop.AndroidViewHolder;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u009e\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b*\u0002¾\u0001\b\u0000\u0018\u0000 \u0088\u00042\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004\u0088\u0004\u0089\u0004B\u0015\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001b\u0010\u0097\u0002\u001a\u0002062\b\u0010þ\u0001\u001a\u00030\u0098\u00022\b\u0010\u0099\u0002\u001a\u00030Á\u0001J&\u0010\u009a\u0002\u001a\u0002062\u0007\u0010\u009b\u0002\u001a\u00020G2\b\u0010\u009c\u0002\u001a\u00030\u009d\u00022\b\u0010\u009e\u0002\u001a\u00030\u009f\u0002H\u0002J\u0015\u0010 \u0002\u001a\u0002062\n\u0010¡\u0002\u001a\u0005\u0018\u00010ÿ\u0001H\u0016J!\u0010 \u0002\u001a\u0002062\n\u0010¡\u0002\u001a\u0005\u0018\u00010ÿ\u00012\n\u0010¢\u0002\u001a\u0005\u0018\u00010£\u0002H\u0016J\u001e\u0010 \u0002\u001a\u0002062\n\u0010¡\u0002\u001a\u0005\u0018\u00010ÿ\u00012\u0007\u0010¤\u0002\u001a\u00020GH\u0016J*\u0010 \u0002\u001a\u0002062\n\u0010¡\u0002\u001a\u0005\u0018\u00010ÿ\u00012\u0007\u0010¤\u0002\u001a\u00020G2\n\u0010¢\u0002\u001a\u0005\u0018\u00010£\u0002H\u0016J'\u0010 \u0002\u001a\u0002062\n\u0010¡\u0002\u001a\u0005\u0018\u00010ÿ\u00012\u0007\u0010¥\u0002\u001a\u00020G2\u0007\u0010¦\u0002\u001a\u00020GH\u0016J\u0019\u0010#\u001a\u0002062\u000f\u0010§\u0002\u001a\n\u0012\u0005\u0012\u00030©\u00020¨\u0002H\u0016J\t\u0010ª\u0002\u001a\u00020mH\u0002J\u0010\u0010«\u0002\u001a\u000206H\u0086@¢\u0006\u0003\u0010¬\u0002J\u0010\u0010\u00ad\u0002\u001a\u000206H\u0086@¢\u0006\u0003\u0010¬\u0002J \u0010®\u0002\u001a\u00030\u008b\u00012\b\u0010¯\u0002\u001a\u00030\u008b\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b°\u0002\u0010±\u0002J \u0010²\u0002\u001a\u00030\u008b\u00012\b\u0010³\u0002\u001a\u00030\u008b\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b´\u0002\u0010±\u0002J\u0012\u0010µ\u0002\u001a\u00020m2\u0007\u0010¶\u0002\u001a\u00020GH\u0016J\u0012\u0010·\u0002\u001a\u00020m2\u0007\u0010¶\u0002\u001a\u00020GH\u0016J\u0012\u0010¸\u0002\u001a\u0002062\u0007\u0010¹\u0002\u001a\u00020\u0001H\u0002J\"\u0010º\u0002\u001a\u00030»\u00022\u0007\u0010¼\u0002\u001a\u00020GH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b½\u0002\u0010¾\u0002Jh\u0010¿\u0002\u001a\u00020Q2B\u0010À\u0002\u001a=\u0012\u0017\u0012\u00150Â\u0002¢\u0006\u000f\bÃ\u0002\u0012\n\bÄ\u0002\u0012\u0005\b\b(Å\u0002\u0012\u0019\u0012\u0017\u0018\u00010Æ\u0002¢\u0006\u000f\bÃ\u0002\u0012\n\bÄ\u0002\u0012\u0005\b\b(Ç\u0002\u0012\u0004\u0012\u0002060Á\u00022\r\u0010È\u0002\u001a\b\u0012\u0004\u0012\u0002060Z2\n\u0010É\u0002\u001a\u0005\u0018\u00010Æ\u0002H\u0016J\u0013\u0010Ê\u0002\u001a\u0002062\b\u0010Å\u0002\u001a\u00030Ë\u0002H\u0014J\u0013\u0010Ì\u0002\u001a\u00020m2\b\u0010Í\u0002\u001a\u00030º\u0001H\u0016J\u0013\u0010Î\u0002\u001a\u00020m2\b\u0010Ï\u0002\u001a\u00030º\u0001H\u0016J\u0013\u0010Ð\u0002\u001a\u00020m2\b\u0010Ï\u0002\u001a\u00030Ñ\u0002H\u0016J\u0013\u0010Ò\u0002\u001a\u00020m2\b\u0010Ï\u0002\u001a\u00030Ñ\u0002H\u0016J\t\u0010Ó\u0002\u001a\u000206H\u0002J\u0013\u0010Ô\u0002\u001a\u0002062\b\u0010Õ\u0002\u001a\u00030Ö\u0002H\u0016J\u0013\u0010×\u0002\u001a\u00020m2\b\u0010Í\u0002\u001a\u00030º\u0001H\u0016J\u001b\u0010Ø\u0002\u001a\u0002062\b\u0010þ\u0001\u001a\u00030\u0098\u00022\b\u0010Å\u0002\u001a\u00030Ë\u0002J\u0015\u0010Ù\u0002\u001a\u0005\u0018\u00010ÿ\u00012\u0007\u0010¶\u0002\u001a\u00020GH\u0002J\u001f\u0010Ú\u0002\u001a\u0005\u0018\u00010ÿ\u00012\u0007\u0010Û\u0002\u001a\u00020G2\b\u0010Ü\u0002\u001a\u00030ÿ\u0001H\u0002J\u0013\u0010Ý\u0002\u001a\u0005\u0018\u00010ÿ\u00012\u0007\u0010Û\u0002\u001a\u00020GJ!\u0010Þ\u0002\u001a\u0005\u0018\u00010ÿ\u00012\n\u0010ß\u0002\u001a\u0005\u0018\u00010ÿ\u00012\u0007\u0010¶\u0002\u001a\u00020GH\u0016J\u0012\u0010à\u0002\u001a\u0002062\u0007\u0010á\u0002\u001a\u00020mH\u0016J\u001c\u0010â\u0002\u001a\u0002062\b\u0010\u0099\u0002\u001a\u00030Á\u00012\u0007\u0010ã\u0002\u001a\u00020mH\u0016J\"\u0010ä\u0002\u001a\u0005\u0018\u00010å\u00022\b\u0010æ\u0002\u001a\u00030ç\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\bè\u0002\u0010é\u0002J\u0013\u0010ê\u0002\u001a\u0002062\b\u0010ë\u0002\u001a\u00030ì\u0002H\u0016J#\u0010í\u0002\u001a\u00030î\u00022\b\u0010Í\u0002\u001a\u00030º\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bï\u0002\u0010ð\u0002J\u0013\u0010ñ\u0002\u001a\u00020m2\b\u0010Ï\u0002\u001a\u00030º\u0001H\u0002J\u001d\u0010ò\u0002\u001a\u00020m2\b\u0010Ï\u0002\u001a\u00030º\u00012\b\u0010ó\u0002\u001a\u00030º\u0001H\u0002J\t\u0010ô\u0002\u001a\u000206H\u0016J\u0013\u0010õ\u0002\u001a\u0002062\b\u0010ö\u0002\u001a\u00030Á\u0001H\u0002J\u0013\u0010÷\u0002\u001a\u0002062\b\u0010ö\u0002\u001a\u00030Á\u0001H\u0002J\u0013\u0010ø\u0002\u001a\u00020m2\b\u0010Ï\u0002\u001a\u00030º\u0001H\u0002J\u0013\u0010ù\u0002\u001a\u00020m2\b\u0010Ï\u0002\u001a\u00030º\u0001H\u0002J\u0013\u0010ú\u0002\u001a\u00020m2\b\u0010Í\u0002\u001a\u00030º\u0001H\u0002J\u0013\u0010û\u0002\u001a\u00020m2\b\u0010Ï\u0002\u001a\u00030º\u0001H\u0002J \u0010ü\u0002\u001a\u00030\u008b\u00012\b\u0010³\u0002\u001a\u00030\u008b\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bý\u0002\u0010±\u0002J\u001f\u0010ü\u0002\u001a\u0002062\b\u0010þ\u0002\u001a\u00030ø\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÿ\u0002\u0010\u0080\u0003J)\u0010\u0081\u0003\u001a\u0002062\b\u0010\u0099\u0002\u001a\u00030Á\u00012\b\u0010\u0082\u0003\u001a\u00030¬\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0083\u0003\u0010\u0084\u0003J\u0012\u0010\u0081\u0003\u001a\u0002062\u0007\u0010\u0085\u0003\u001a\u00020mH\u0016J\t\u0010\u0086\u0003\u001a\u000206H\u0016J!\u0010\u0087\u0003\u001a\u0002062\u0007\u0010\u0088\u0003\u001a\u00020Q2\u0007\u0010\u0089\u0003\u001a\u00020mH\u0000¢\u0006\u0003\b\u008a\u0003J\u0013\u0010\u008b\u0003\u001a\u0002062\b\u0010ö\u0002\u001a\u00030Á\u0001H\u0016J\t\u0010\u008c\u0003\u001a\u000206H\u0014J\t\u0010\u008d\u0003\u001a\u00020mH\u0016J\t\u0010\u008e\u0003\u001a\u000206H\u0002J\u0012\u0010\u008f\u0003\u001a\u0002062\u0007\u0010\u0090\u0003\u001a\u000205H\u0014J\u0016\u0010\u0091\u0003\u001a\u0005\u0018\u00010\u0092\u00032\b\u0010\u0093\u0003\u001a\u00030\u0094\u0003H\u0016J0\u0010\u0095\u0003\u001a\u0002062\b\u0010\u0096\u0003\u001a\u00030\u0097\u00032\b\u0010\u0098\u0003\u001a\u00030û\u00012\u0011\u0010\u0099\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u009b\u00030\u009a\u0003H\u0017J\u0013\u0010\u009c\u0003\u001a\u0002062\b\u0010ö\u0002\u001a\u00030Á\u0001H\u0016J\t\u0010\u009d\u0003\u001a\u000206H\u0014J\u0013\u0010\u009e\u0003\u001a\u0002062\b\u0010Å\u0002\u001a\u00030Ë\u0002H\u0014J\t\u0010\u009f\u0003\u001a\u000206H\u0016J\f\u0010 \u0003\u001a\u0005\u0018\u00010¡\u0003H\u0002J'\u0010¢\u0003\u001a\u0002062\u0007\u0010£\u0003\u001a\u00020m2\u0007\u0010¶\u0002\u001a\u00020G2\n\u0010¤\u0003\u001a\u0005\u0018\u00010ì\u0002H\u0014J\u0018\u0010¥\u0003\u001a\u0002062\r\u0010þ\u0001\u001a\b0ÿ\u0001j\u0003`¦\u0003H\u0016J6\u0010§\u0003\u001a\u0002062\u0007\u0010¨\u0003\u001a\u00020m2\u0007\u0010©\u0003\u001a\u00020G2\u0007\u0010ª\u0003\u001a\u00020G2\u0007\u0010«\u0003\u001a\u00020G2\u0007\u0010¬\u0003\u001a\u00020GH\u0014J\u0013\u0010\u00ad\u0003\u001a\u0002062\b\u0010\u0099\u0002\u001a\u00030Á\u0001H\u0016J\u001b\u0010®\u0003\u001a\u0002062\u0007\u0010¯\u0003\u001a\u00020G2\u0007\u0010°\u0003\u001a\u00020GH\u0014J\u001f\u0010±\u0003\u001a\u00020m2\b\u0010²\u0003\u001a\u00030å\u0002H\u0002ø\u0001\u0000¢\u0006\u0006\b³\u0003\u0010´\u0003J\u001e\u0010µ\u0003\u001a\u0002062\n\u0010Õ\u0002\u001a\u0005\u0018\u00010Ö\u00022\u0007\u0010¶\u0003\u001a\u00020GH\u0016J*\u0010·\u0003\u001a\u00020m2\n\u0010²\u0003\u001a\u0005\u0018\u00010å\u00022\n\u0010¤\u0003\u001a\u0005\u0018\u00010¡\u0003H\u0002ø\u0001\u0000¢\u0006\u0003\b¸\u0003J.\u0010¹\u0003\u001a\u0002062\b\u0010\u0099\u0002\u001a\u00030Á\u00012\u0007\u0010ã\u0002\u001a\u00020m2\u0007\u0010º\u0003\u001a\u00020m2\u0007\u0010»\u0003\u001a\u00020mH\u0016J%\u0010¼\u0003\u001a\u0002062\b\u0010\u0099\u0002\u001a\u00030Á\u00012\u0007\u0010ã\u0002\u001a\u00020m2\u0007\u0010º\u0003\u001a\u00020mH\u0016J\u0013\u0010½\u0003\u001a\u0002062\b\u0010¾\u0003\u001a\u00030¿\u0003H\u0016J\u0012\u0010À\u0003\u001a\u0002062\u0007\u0010\u0096\u0001\u001a\u00020GH\u0016J.\u0010Á\u0003\u001a\u0002062\b\u0010Â\u0003\u001a\u00030ì\u00022\b\u0010Ã\u0003\u001a\u00030Ä\u00032\u000f\u0010Å\u0003\u001a\n\u0012\u0005\u0012\u00030Æ\u00030\u009a\u0003H\u0016J\t\u0010Ç\u0003\u001a\u000206H\u0016J\u001c\u0010È\u0003\u001a\u0002062\u0011\u0010É\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010Ë\u00030Ê\u0003H\u0017J\u0012\u0010Ì\u0003\u001a\u0002062\u0007\u0010Í\u0003\u001a\u00020mH\u0016J+\u0010Î\u0003\u001a\u00030»\u00022\u0007\u0010Ï\u0003\u001a\u00020G2\u0007\u0010¬\u0003\u001a\u00020GH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÐ\u0003\u0010Ñ\u0003J\t\u0010Ò\u0003\u001a\u000206H\u0002J\u0013\u0010Ò\u0003\u001a\u0002062\b\u0010Í\u0002\u001a\u00030º\u0001H\u0002J\t\u0010Ó\u0003\u001a\u000206H\u0002J\u0018\u0010Ô\u0003\u001a\u00020m2\u0007\u0010\u0088\u0003\u001a\u00020QH\u0000¢\u0006\u0003\bÕ\u0003J\u0018\u0010Ö\u0003\u001a\u0002062\r\u0010×\u0003\u001a\b\u0012\u0004\u0012\u0002060ZH\u0016J\u0013\u0010Ø\u0003\u001a\u0002062\b\u0010×\u0003\u001a\u00030Ù\u0003H\u0016J\u0011\u0010Ú\u0003\u001a\u0002062\b\u0010þ\u0001\u001a\u00030\u0098\u0002J\u0007\u0010Û\u0003\u001a\u000206J\u001e\u0010Ü\u0003\u001a\u00020m2\u0007\u0010¶\u0002\u001a\u00020G2\n\u0010¤\u0003\u001a\u0005\u0018\u00010ì\u0002H\u0016J\u0013\u0010Ý\u0003\u001a\u0002062\b\u0010\u0099\u0002\u001a\u00030Á\u0001H\u0016J\u0017\u0010»\u0003\u001a\u0002062\f\b\u0002\u0010Þ\u0003\u001a\u0005\u0018\u00010Á\u0001H\u0002J \u0010ß\u0003\u001a\u00030\u008b\u00012\b\u0010à\u0003\u001a\u00030\u008b\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bá\u0003\u0010±\u0002J\u001f\u0010â\u0003\u001a\u00020m2\b\u0010æ\u0002\u001a\u00030ç\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\bã\u0003\u0010ä\u0003J#\u0010å\u0003\u001a\u00030î\u00022\b\u0010Í\u0002\u001a\u00030º\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bæ\u0003\u0010ð\u0002J1\u0010ç\u0003\u001a\u0002062\b\u0010Í\u0002\u001a\u00030º\u00012\u0007\u0010è\u0003\u001a\u00020G2\b\u0010é\u0003\u001a\u00030\u008d\u00012\t\b\u0002\u0010ê\u0003\u001a\u00020mH\u0002J\u0013\u0010ë\u0003\u001a\u0002062\b\u0010ì\u0003\u001a\u00030\u008d\u0001H\u0016J\u001c\u0010í\u0003\u001a\u0002062\u0013\u0010î\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020604J\t\u0010ï\u0003\u001a\u00020mH\u0016JE\u0010ð\u0003\u001a\u00020m2\b\u0010ñ\u0003\u001a\u00030ò\u00032\b\u0010ó\u0003\u001a\u00030ô\u00032\u001a\u0010õ\u0003\u001a\u0015\u0012\u0005\u0012\u00030ö\u0003\u0012\u0004\u0012\u00020604¢\u0006\u0003\b÷\u0003H\u0002ø\u0001\u0000¢\u0006\u0006\bø\u0003\u0010ù\u0003JA\u0010ú\u0003\u001a\u00030û\u00032.\u0010ü\u0003\u001a)\b\u0001\u0012\u0005\u0012\u00030ý\u0003\u0012\f\u0012\n\u0012\u0005\u0012\u00030û\u00030þ\u0003\u0012\u0007\u0012\u0005\u0018\u00010ÿ\u00030Á\u0002¢\u0006\u0003\b÷\u0003H\u0096@¢\u0006\u0003\u0010\u0080\u0004J\t\u0010\u0081\u0004\u001a\u000206H\u0002J\u000e\u0010\u0082\u0004\u001a\u00020m*\u00030Á\u0001H\u0002J\u001b\u0010\u0083\u0004\u001a\u00020G*\u00030»\u0002H\u0082\nø\u0001\u0000¢\u0006\u0006\b\u0084\u0004\u0010\u0085\u0004J\u001b\u0010\u0086\u0004\u001a\u00020G*\u00030»\u0002H\u0082\nø\u0001\u0000¢\u0006\u0006\b\u0087\u0004\u0010\u0085\u0004R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R&\u00103\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020604X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020<X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010\b\u001a\u00020\t2\u0006\u0010A\u001a\u00020\t@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u000e\u0010F\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010I\u001a\u00020H2\u0006\u0010\u0011\u001a\u00020H8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bN\u0010\u0019\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0014\u0010O\u001a\b\u0012\u0004\u0012\u00020Q0PX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010R\u001a\u00020SX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u000e\u0010V\u001a\u00020WX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010X\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000206\u0018\u00010Z0YX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010[\u001a\u00020\\X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R+\u0010`\u001a\u00020_2\u0006\u0010\u0011\u001a\u00020_8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\be\u0010\u0019\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001c\u0010f\u001a\u00020g8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u000e\u0010l\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020oX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010p\u001a\u00020qX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010rR\u0014\u0010s\u001a\u00020tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u0014\u0010w\u001a\u00020xX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010zR\u0014\u0010{\u001a\u00020m8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b|\u0010}R\u000e\u0010~\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u007f\u001a\u00030\u0080\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u000f\u0010\u0083\u0001\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0084\u0001\u001a\u00020m8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010}R\u000f\u0010\u0085\u0001\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0087\u0001\u001a\u00030\u0088\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u008a\u0001\u001a\u00030\u008b\u0001X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010rR+\u0010\u008c\u0001\u001a\u00030\u008d\u00018\u0000@\u0000X\u0081\u000e¢\u0006\u0019\n\u0000\u0012\u0005\b\u008e\u0001\u0010i\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0016\u0010\u0093\u0001\u001a\t\u0012\u0004\u0012\u00020Q0\u0094\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R3\u0010\u0096\u0001\u001a\u00030\u0095\u00012\u0007\u0010\u0011\u001a\u00030\u0095\u00018V@RX\u0096\u008e\u0002¢\u0006\u0017\n\u0005\b\u009b\u0001\u0010\u0019\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0010\u0010\u009c\u0001\u001a\u00030\u009d\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u009e\u0001\u001a\u00030\u009f\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u0001\u001a\u00030¡\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010¢\u0001\u001a\u00030\u008d\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b£\u0001\u0010\u0090\u0001R\u0018\u0010¤\u0001\u001a\u00030¥\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b¦\u0001\u0010§\u0001R\u0010\u0010¨\u0001\u001a\u00030©\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010ª\u0001\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u001d\u0010\u00ad\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u000206\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010®\u0001\u001a\u00030¯\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b°\u0001\u0010±\u0001R\u0018\u0010²\u0001\u001a\u00030³\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b´\u0001\u0010µ\u0001R\u0010\u0010¶\u0001\u001a\u00030·\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010¸\u0001\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¹\u0001\u001a\u0005\u0018\u00010º\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010»\u0001\u001a\u00030\u008d\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010¼\u0001\u001a\b\u0012\u0004\u0012\u0002060ZX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010½\u0001\u001a\u00030¾\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010¿\u0001R\u0018\u0010À\u0001\u001a\u00030Á\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÂ\u0001\u0010Ã\u0001R\u0018\u0010Ä\u0001\u001a\u00030Å\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÆ\u0001\u0010Ç\u0001R\u0010\u0010È\u0001\u001a\u00030É\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ê\u0001\u001a\u00030\u0088\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010Ë\u0001\u001a\u0005\u0018\u00010Ì\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010Í\u0001\u001a\u00020m8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bÎ\u0001\u0010}R\u0010\u0010Ï\u0001\u001a\u00030Ð\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ñ\u0001\u001a\u00030Ò\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010Ó\u0001\u001a\u00030Ô\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÕ\u0001\u0010Ö\u0001R\u0010\u0010×\u0001\u001a\u00030Ø\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010Ù\u0001\u001a\u00030Ú\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÛ\u0001\u0010Ü\u0001R%\u0010Ý\u0001\u001a\u00020mX\u0096\u000e¢\u0006\u0018\n\u0000\u0012\u0005\bÞ\u0001\u0010i\u001a\u0005\bß\u0001\u0010}\"\u0006\bà\u0001\u0010á\u0001R\u0018\u0010â\u0001\u001a\u00030ã\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bä\u0001\u0010å\u0001R\u0018\u0010æ\u0001\u001a\u00030ç\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bè\u0001\u0010é\u0001R\u000f\u0010ê\u0001\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010ë\u0001\u001a\u00030ì\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bí\u0001\u0010î\u0001R \u0010ï\u0001\u001a\n\u0012\u0005\u0012\u00030ñ\u00010ð\u0001X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010ò\u0001R\u0018\u0010ó\u0001\u001a\u00030ô\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bõ\u0001\u0010ö\u0001R\u0019\u0010÷\u0001\u001a\u00030ø\u0001X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010ù\u0001R\u0010\u0010ú\u0001\u001a\u00030û\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010ü\u0001\u001a\u00030ý\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010þ\u0001\u001a\u00030ÿ\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0080\u0002\u0010\u0081\u0002R\u0018\u0010\u0082\u0002\u001a\u00030\u0083\u0002X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0084\u0002\u0010\u0085\u0002R\u0012\u0010\u0086\u0002\u001a\u0005\u0018\u00010\u0087\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0088\u0002\u001a\u00030ø\u0001X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010ù\u0001R!\u0010\u0089\u0002\u001a\u0004\u0018\u00010\u00128FX\u0086\u0084\u0002¢\u0006\u000f\n\u0006\b\u008b\u0002\u0010\u008c\u0002\u001a\u0005\b\u008a\u0002\u0010\u0015R\u000f\u0010\u008d\u0002\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u008e\u0002\u001a\u00030\u008f\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0090\u0002\u0010\u0091\u0002R\u0018\u0010\u0092\u0002\u001a\u00030\u008b\u0001X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010rR\u0019\u0010\u0093\u0002\u001a\u00030ø\u0001X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010ù\u0001R\u001b\u0010\u0094\u0002\u001a\u00020G*\u0002058BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0095\u0002\u0010\u0096\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u008a\u0004"}, m13886d2 = {"Landroidx/compose/ui/platform/AndroidComposeView;", "Landroid/view/ViewGroup;", "Landroidx/compose/ui/node/Owner;", "Landroidx/compose/ui/platform/ViewRootForTest;", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "context", "Landroid/content/Context;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;)V", "_androidViewsHandler", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "_autofill", "Landroidx/compose/ui/autofill/AndroidAutofill;", "_inputModeManager", "Landroidx/compose/ui/input/InputModeManagerImpl;", "<set-?>", "Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "_viewTreeOwners", "get_viewTreeOwners", "()Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "set_viewTreeOwners", "(Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;)V", "_viewTreeOwners$delegate", "Landroidx/compose/runtime/MutableState;", "_windowInfo", "Landroidx/compose/ui/platform/WindowInfoImpl;", "accessibilityManager", "Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "getAccessibilityManager", "()Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "androidViewsHandler", "getAndroidViewsHandler$ui_release", "()Landroidx/compose/ui/platform/AndroidViewsHandler;", "autofill", "Landroidx/compose/ui/autofill/Autofill;", "getAutofill", "()Landroidx/compose/ui/autofill/Autofill;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipboardManager", "Landroidx/compose/ui/platform/AndroidClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/AndroidClipboardManager;", "composeAccessibilityDelegate", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "configurationChangeObserver", "Lkotlin/Function1;", "Landroid/content/res/Configuration;", "", "getConfigurationChangeObserver", "()Lkotlin/jvm/functions/Function1;", "setConfigurationChangeObserver", "(Lkotlin/jvm/functions/Function1;)V", "contentCaptureManager", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "getContentCaptureManager$ui_release", "()Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "setContentCaptureManager$ui_release", "(Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;)V", "value", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "setCoroutineContext", "(Lkotlin/coroutines/CoroutineContext;)V", "currentFontWeightAdjustment", "", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "density$delegate", "dirtyLayers", "", "Landroidx/compose/ui/node/OwnedLayer;", "dragAndDropManager", "Landroidx/compose/ui/draganddrop/DragAndDropManager;", "getDragAndDropManager", "()Landroidx/compose/ui/draganddrop/DragAndDropManager;", "dragAndDropModifierOnDragListener", "Landroidx/compose/ui/platform/DragAndDropModifierOnDragListener;", "endApplyChangesListeners", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function0;", "focusOwner", "Landroidx/compose/ui/focus/FocusOwner;", "getFocusOwner", "()Landroidx/compose/ui/focus/FocusOwner;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "setFontFamilyResolver", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "fontFamilyResolver$delegate", "fontLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader$annotations", "()V", "getFontLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "forceUseMatrixCache", "", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "globalPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "getGraphicsContext", "()Landroidx/compose/ui/graphics/GraphicsContext;", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "hasPendingMeasureOrLayout", "getHasPendingMeasureOrLayout", "()Z", "hoverExitReceived", "inputModeManager", "Landroidx/compose/ui/input/InputModeManager;", "getInputModeManager", "()Landroidx/compose/ui/input/InputModeManager;", "isDrawingContent", "isLifecycleInResumedState", "isPendingInteropViewLayoutChangeDispatch", "isRenderNodeCompatible", "keyInputModifier", "Landroidx/compose/ui/Modifier;", "keyboardModifiersRequireUpdate", "lastDownPointerPosition", "Landroidx/compose/ui/geometry/Offset;", "lastMatrixRecalculationAnimationTime", "", "getLastMatrixRecalculationAnimationTime$ui_release$annotations", "getLastMatrixRecalculationAnimationTime$ui_release", "()J", "setLastMatrixRecalculationAnimationTime$ui_release", "(J)V", "layerCache", "Landroidx/compose/ui/platform/WeakCache;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutDirection$delegate", "legacyTextInputServiceAndroid", "Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "matrixToWindow", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "measureAndLayoutDelegate", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "measureIteration", "getMeasureIteration", "modifierLocalManager", "Landroidx/compose/ui/modifier/ModifierLocalManager;", "getModifierLocalManager", "()Landroidx/compose/ui/modifier/ModifierLocalManager;", "motionEventAdapter", "Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "observationClearRequested", "onMeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "onViewTreeOwnersAvailable", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "pointerIconService", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "pointerInputEventProcessor", "Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "postponedDirtyLayers", "previousMotionEvent", "Landroid/view/MotionEvent;", "relayoutTime", "resendMotionEventOnLayout", "resendMotionEventRunnable", "androidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1", "Landroidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1;", "root", "Landroidx/compose/ui/node/LayoutNode;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "rootForTest", "Landroidx/compose/ui/node/RootForTest;", "getRootForTest", "()Landroidx/compose/ui/node/RootForTest;", "rootSemanticsNode", "Landroidx/compose/ui/semantics/EmptySemanticsModifier;", "rotaryInputModifier", "scrollCapture", "Landroidx/compose/ui/scrollcapture/ScrollCapture;", "scrollCaptureInProgress", "getScrollCaptureInProgress$ui_release", "scrollChangedListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "semanticsModifier", "Landroidx/compose/ui/semantics/EmptySemanticsElement;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "getSemanticsOwner", "()Landroidx/compose/ui/semantics/SemanticsOwner;", "sendHoverExitEvent", "Ljava/lang/Runnable;", "sharedDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getSharedDrawScope", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "softwareKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "getSoftwareKeyboardController", "()Landroidx/compose/ui/platform/SoftwareKeyboardController;", "superclassInitComplete", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "textInputSessionMutex", "Landroidx/compose/ui/SessionMutex;", "Landroidx/compose/ui/platform/AndroidPlatformTextInputSession;", "Ljava/util/concurrent/atomic/AtomicReference;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "tmpPositionArray", "", "touchModeChangeListener", "Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "viewLayersContainer", "Landroidx/compose/ui/platform/DrawChildContainer;", "viewToWindowMatrix", "viewTreeOwners", "getViewTreeOwners", "viewTreeOwners$delegate", "Landroidx/compose/runtime/State;", "wasMeasuredWithMultipleConstraints", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "getWindowInfo", "()Landroidx/compose/ui/platform/WindowInfo;", "windowPosition", "windowToViewMatrix", "fontWeightAdjustmentCompat", "getFontWeightAdjustmentCompat", "(Landroid/content/res/Configuration;)I", "addAndroidView", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "layoutNode", "addExtraDataToAccessibilityNodeInfoHelper", "virtualViewId", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "", "addView", "child", ActionHandler.PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "index", "width", "height", "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "autofillSupported", "boundsUpdatesAccessibilityEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "boundsUpdatesContentCaptureEventLoop", "calculateLocalPosition", "positionInWindow", "calculateLocalPosition-MK-Hz9U", "(J)J", "calculatePositionInWindow", "localPosition", "calculatePositionInWindow-MK-Hz9U", "canScrollHorizontally", "direction", "canScrollVertically", "clearChildInvalidObservations", "viewGroup", "convertMeasureSpec", "Lkotlin/ULong;", "measureSpec", "convertMeasureSpec-I7RO_PI", "(I)J", "createLayer", "drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ParameterName;", "name", "canvas", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentLayer", "invalidateParentLayer", "explicitLayer", "dispatchDraw", "Landroid/graphics/Canvas;", "dispatchGenericMotionEvent", "motionEvent", "dispatchHoverEvent", "event", "dispatchKeyEvent", "Landroid/view/KeyEvent;", "dispatchKeyEventPreIme", "dispatchPendingInteropLayoutCallbacks", "dispatchProvideStructure", "structure", "Landroid/view/ViewStructure;", "dispatchTouchEvent", "drawAndroidView", "findNextNonChildView", "findViewByAccessibilityIdRootedAtCurrentView", "accessibilityId", "currentView", "findViewByAccessibilityIdTraversal", "focusSearch", "focused", "forceAccessibilityForTesting", "enable", "forceMeasureTheSubtree", "affectsLookahead", "getFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "getFocusDirection-P8AzH3I", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/focus/FocusDirection;", "getFocusedRect", "rect", "Landroid/graphics/Rect;", "handleMotionEvent", "Landroidx/compose/ui/input/pointer/ProcessResult;", "handleMotionEvent-8iAsVTc", "(Landroid/view/MotionEvent;)I", "handleRotaryEvent", "hasChangedDevices", "lastEvent", "invalidateDescendants", "invalidateLayers", "node", "invalidateLayoutNodeMeasurement", "isBadMotionEvent", "isDevicePressEvent", "isInBounds", "isPositionChanged", "localToScreen", "localToScreen-MK-Hz9U", "localTransform", "localToScreen-58bKbWc", "([F)V", "measureAndLayout", "constraints", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "sendPointerUpdate", "measureAndLayoutForTest", "notifyLayerIsDirty", "layer", "isDirty", "notifyLayerIsDirty$ui_release", "onAttach", "onAttachedToWindow", "onCheckIsTextEditor", "onClearFocusForOwner", "onConfigurationChanged", "newConfig", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onCreateVirtualViewTranslationRequests", "virtualIds", "", "supportedFormats", "requestsCollector", "Ljava/util/function/Consumer;", "Landroid/view/translation/ViewTranslationRequest;", "onDetach", "onDetachedFromWindow", "onDraw", "onEndApplyChanges", "onFetchFocusRect", "Landroidx/compose/ui/geometry/Rect;", "onFocusChanged", "gainFocus", "previouslyFocusedRect", "onInteropViewLayoutChange", "Landroidx/compose/ui/viewinterop/InteropView;", "onLayout", "changed", "l", "t", "r", "b", "onLayoutChange", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onMoveFocusInChildren", "focusDirection", "onMoveFocusInChildren-3ESFkO8", "(I)Z", "onProvideAutofillVirtualStructure", "flags", "onRequestFocusForOwner", "onRequestFocusForOwner-7o62pno", "onRequestMeasure", "forceRequest", "scheduleMeasureAndLayout", "onRequestRelayout", "onResume", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onRtlPropertiesChanged", "onScrollCaptureSearch", "localVisibleRect", "windowOffset", "Landroid/graphics/Point;", "targets", "Landroid/view/ScrollCaptureTarget;", "onSemanticsChange", "onVirtualViewTranslationResponses", "response", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "onWindowFocusChanged", "hasWindowFocus", "pack", "a", "pack-ZIaKswc", "(II)J", "recalculateWindowPosition", "recalculateWindowViewTransforms", "recycle", "recycle$ui_release", "registerOnEndApplyChangesListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "registerOnLayoutCompletedListener", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "removeAndroidView", "requestClearInvalidObservations", "requestFocus", "requestOnPositionedCallback", "nodeToRemeasure", "screenToLocal", "positionOnScreen", "screenToLocal-MK-Hz9U", "sendKeyEvent", "sendKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "sendMotionEvent", "sendMotionEvent-8iAsVTc", "sendSimulatedEvent", "action", "eventTime", "forceHover", "setAccessibilityEventBatchIntervalMillis", "intervalMillis", "setOnViewTreeOwnersAvailable", Profile.PhoneNumberData.TYPE_CALLBACK, "shouldDelayChildPressedState", "startDrag", "transferData", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "decorationSize", "Landroidx/compose/ui/geometry/Size;", "drawDragDecoration", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "startDrag-12SF9DM", "(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)Z", "textInputSession", "", "session", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePositionCacheAndDispatch", "childSizeCanAffectParentSize", "component1", "component1-VKZWuLQ", "(J)I", "component2", "component2-VKZWuLQ", "Companion", "ViewTreeOwners", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAndroidComposeView.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidComposeView.android.kt\nandroidx/compose/ui/platform/AndroidComposeView\n+ 2 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 3 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 4 NodeKind.kt\nandroidx/compose/ui/node/Nodes\n+ 5 DelegatableNode.kt\nandroidx/compose/ui/node/DelegatableNodeKt\n+ 6 InlineClassHelper.kt\nandroidx/compose/ui/internal/InlineClassHelperKt\n+ 7 Modifier.kt\nandroidx/compose/ui/Modifier$Node\n+ 8 DelegatingNode.kt\nandroidx/compose/ui/node/DelegatingNode\n+ 9 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 10 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n+ 11 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 12 AndroidTrace.android.kt\nandroidx/compose/ui/util/AndroidTrace_androidKt\n+ 13 IntOffset.kt\nandroidx/compose/ui/unit/IntOffset\n+ 14 AndroidCanvas.android.kt\nandroidx/compose/ui/graphics/CanvasHolder\n+ 15 LayoutNode.kt\nandroidx/compose/ui/node/LayoutNode\n+ 16 DebugUtils.kt\nandroidx/compose/ui/platform/DebugUtilsKt\n+ 17 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,2770:1\n1383#1,4:2884\n1383#1,4:2888\n1208#2:2771\n1187#2,2:2772\n1208#2:2822\n1187#2,2:2823\n81#3:2774\n107#3,2:2775\n81#3:2854\n107#3,2:2855\n81#3:2857\n81#3:2858\n107#3,2:2859\n81#3:2861\n107#3,2:2862\n84#4:2777\n292#5:2778\n104#5:2779\n105#5,15:2787\n432#5,6:2802\n442#5,2:2809\n444#5,8:2814\n452#5,9:2825\n461#5,8:2837\n121#5,8:2845\n42#6,7:2780\n66#6,9:2928\n66#6,9:2937\n249#7:2808\n245#8,3:2811\n248#8,3:2834\n1#9:2853\n26#10:2864\n26#10:2865\n26#10:2866\n26#10:2867\n523#11:2868\n728#11,2:2869\n460#11,11:2903\n460#11,11:2915\n26#12,5:2871\n26#12,5:2876\n26#12,3:2881\n30#12:2892\n26#12,5:2948\n58#13,4:2893\n47#14,5:2897\n202#15:2902\n202#15:2914\n20#16,2:2926\n20#16,2:2946\n217#17,6:2953\n*S KotlinDebug\n*F\n+ 1 AndroidComposeView.android.kt\nandroidx/compose/ui/platform/AndroidComposeView\n*L\n1351#1:2884,4\n1352#1:2888,4\n692#1:2771\n692#1:2772,2\n286#1:2822\n286#1:2823,2\n251#1:2774\n251#1:2775,2\n541#1:2854\n541#1:2855,2\n550#1:2857\n612#1:2858\n612#1:2859,2\n626#1:2861\n626#1:2862,2\n286#1:2777\n286#1:2778\n286#1:2779\n286#1:2787,15\n286#1:2802,6\n286#1:2809,2\n286#1:2814,8\n286#1:2825,9\n286#1:2837,8\n286#1:2845,8\n286#1:2780,7\n1713#1:2928,9\n1730#1:2937,9\n286#1:2808\n286#1:2811,3\n286#1:2834,3\n802#1:2864\n803#1:2865\n804#1:2866\n805#1:2867\n1010#1:2868\n1023#1:2869,2\n1647#1:2903,11\n1655#1:2915,11\n1266#1:2871,5\n1279#1:2876,5\n1347#1:2881,3\n1347#1:2892\n1856#1:2948,5\n1425#1:2893,4\n1563#1:2897,5\n1647#1:2902\n1655#1:2914\n1668#1:2926,2\n1735#1:2946,2\n1990#1:2953,6\n*E\n"})
public final class AndroidComposeView extends ViewGroup implements Owner, ViewRootForTest, PositionCalculator, DefaultLifecycleObserver {

    @Nullable
    private static Method getBooleanMethod;

    @Nullable
    private static Class<?> systemPropertiesClass;

    @Nullable
    private AndroidViewsHandler _androidViewsHandler;

    @Nullable
    private final AndroidAutofill _autofill;

    @NotNull
    private final InputModeManagerImpl _inputModeManager;

    /* JADX INFO: renamed from: _viewTreeOwners$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState _viewTreeOwners;

    @NotNull
    private final WindowInfoImpl _windowInfo;

    @NotNull
    private final AndroidAccessibilityManager accessibilityManager;

    @NotNull
    private final AutofillTree autofillTree;

    @NotNull
    private final CanvasHolder canvasHolder;

    @NotNull
    private final AndroidClipboardManager clipboardManager;

    @NotNull
    private final AndroidComposeViewAccessibilityDelegateCompat composeAccessibilityDelegate;

    @NotNull
    private Function1<? super Configuration, Unit> configurationChangeObserver;

    @NotNull
    private AndroidContentCaptureManager contentCaptureManager;

    @NotNull
    private CoroutineContext coroutineContext;
    private int currentFontWeightAdjustment;

    /* JADX INFO: renamed from: density$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState density;

    @NotNull
    private final List<OwnedLayer> dirtyLayers;

    @NotNull
    private final DragAndDropManager dragAndDropManager;

    @NotNull
    private final DragAndDropModifierOnDragListener dragAndDropModifierOnDragListener;

    @NotNull
    private final MutableVector<Function0<Unit>> endApplyChangesListeners;

    @NotNull
    private final FocusOwner focusOwner;

    /* JADX INFO: renamed from: fontFamilyResolver$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState fontFamilyResolver;

    @NotNull
    private final Font.ResourceLoader fontLoader;
    private boolean forceUseMatrixCache;

    @NotNull
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private long globalPosition;

    @NotNull
    private final GraphicsContext graphicsContext;

    @NotNull
    private final HapticFeedback hapticFeedBack;
    private boolean hoverExitReceived;
    private boolean isDrawingContent;
    private boolean isPendingInteropViewLayoutChangeDispatch;
    private boolean isRenderNodeCompatible;

    @NotNull
    private final Modifier keyInputModifier;
    private boolean keyboardModifiersRequireUpdate;
    private long lastDownPointerPosition;
    private long lastMatrixRecalculationAnimationTime;

    @NotNull
    private final WeakCache<OwnedLayer> layerCache;

    /* JADX INFO: renamed from: layoutDirection$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState layoutDirection;

    @NotNull
    private final TextInputServiceAndroid legacyTextInputServiceAndroid;

    @NotNull
    private final CalculateMatrixToWindow matrixToWindow;

    @NotNull
    private final MeasureAndLayoutDelegate measureAndLayoutDelegate;

    @NotNull
    private final ModifierLocalManager modifierLocalManager;

    @NotNull
    private final MotionEventAdapter motionEventAdapter;
    private boolean observationClearRequested;

    @Nullable
    private Constraints onMeasureConstraints;

    @Nullable
    private Function1<? super ViewTreeOwners, Unit> onViewTreeOwnersAvailable;

    @NotNull
    private final PointerIconService pointerIconService;

    @NotNull
    private final PointerInputEventProcessor pointerInputEventProcessor;

    @Nullable
    private List<OwnedLayer> postponedDirtyLayers;

    @Nullable
    private MotionEvent previousMotionEvent;
    private long relayoutTime;

    @NotNull
    private final Function0<Unit> resendMotionEventOnLayout;

    @NotNull
    private final AndroidComposeView$resendMotionEventRunnable$1 resendMotionEventRunnable;

    @NotNull
    private final LayoutNode root;

    @NotNull
    private final RootForTest rootForTest;

    @NotNull
    private final EmptySemanticsModifier rootSemanticsNode;

    @NotNull
    private final Modifier rotaryInputModifier;

    @Nullable
    private final ScrollCapture scrollCapture;

    @NotNull
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;

    @NotNull
    private final EmptySemanticsElement semanticsModifier;

    @NotNull
    private final SemanticsOwner semanticsOwner;

    @NotNull
    private final Runnable sendHoverExitEvent;

    @NotNull
    private final LayoutNodeDrawScope sharedDrawScope;
    private boolean showLayoutBounds;

    @NotNull
    private final OwnerSnapshotObserver snapshotObserver;

    @NotNull
    private final SoftwareKeyboardController softwareKeyboardController;
    private boolean superclassInitComplete;

    @NotNull
    private final TextInputService textInputService;

    @NotNull
    private final AtomicReference textInputSessionMutex;

    @NotNull
    private final TextToolbar textToolbar;

    @NotNull
    private final float[] tmpMatrix;

    @NotNull
    private final int[] tmpPositionArray;

    @NotNull
    private final ViewTreeObserver.OnTouchModeChangeListener touchModeChangeListener;

    @NotNull
    private final ViewConfiguration viewConfiguration;

    @Nullable
    private DrawChildContainer viewLayersContainer;

    @NotNull
    private final float[] viewToWindowMatrix;

    /* JADX INFO: renamed from: viewTreeOwners$delegate, reason: from kotlin metadata */
    @NotNull
    private final State viewTreeOwners;
    private boolean wasMeasuredWithMultipleConstraints;
    private long windowPosition;

    @NotNull
    private final float[] windowToViewMatrix;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$Companion;", "", "()V", "getBooleanMethod", "Ljava/lang/reflect/Method;", "systemPropertiesClass", "Ljava/lang/Class;", "getIsShowingLayoutBounds", "", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getIsShowingLayoutBounds() {
            try {
                if (AndroidComposeView.systemPropertiesClass == null) {
                    AndroidComposeView.systemPropertiesClass = Class.forName("android.os.SystemProperties");
                    Class cls = AndroidComposeView.systemPropertiesClass;
                    AndroidComposeView.getBooleanMethod = cls != null ? cls.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE) : null;
                }
                Method method = AndroidComposeView.getBooleanMethod;
                Object objInvoke = method != null ? method.invoke(null, "debug.layout", Boolean.FALSE) : null;
                Boolean bool = objInvoke instanceof Boolean ? (Boolean) objInvoke : null;
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 0)
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class ViewTreeOwners {
        public static final int $stable = 8;

        @NotNull
        private final LifecycleOwner lifecycleOwner;

        @NotNull
        private final SavedStateRegistryOwner savedStateRegistryOwner;

        public ViewTreeOwners(@NotNull LifecycleOwner lifecycleOwner, @NotNull SavedStateRegistryOwner savedStateRegistryOwner) {
            this.lifecycleOwner = lifecycleOwner;
            this.savedStateRegistryOwner = savedStateRegistryOwner;
        }

        @NotNull
        public final LifecycleOwner getLifecycleOwner() {
            return this.lifecycleOwner;
        }

        @NotNull
        public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
            return this.savedStateRegistryOwner;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.platform.AndroidComposeView$textInputSession$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.ui.platform.AndroidComposeView", m14021f = "AndroidComposeView.android.kt", m14022i = {}, m14023l = {592}, m14024m = "textInputSession", m14025n = {}, m14026s = {})
    public static final class C21381 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C21381(Continuation<? super C21381> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidComposeView.this.textInputSession(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v13, types: [androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1] */
    public AndroidComposeView(@NotNull Context context, @NotNull CoroutineContext coroutineContext) {
        super(context);
        Offset.Companion companion = Offset.INSTANCE;
        this.lastDownPointerPosition = companion.m18299getUnspecifiedF1C5BW0();
        this.superclassInitComplete = true;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        this.sharedDrawScope = new LayoutNodeDrawScope(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0);
        this.density = SnapshotStateKt.mutableStateOf(AndroidDensity_androidKt.Density(context), SnapshotStateKt.referentialEqualityPolicy());
        EmptySemanticsModifier emptySemanticsModifier = new EmptySemanticsModifier();
        this.rootSemanticsNode = emptySemanticsModifier;
        EmptySemanticsElement emptySemanticsElement = new EmptySemanticsElement(emptySemanticsModifier);
        this.semanticsModifier = emptySemanticsElement;
        this.focusOwner = new FocusOwnerImpl(new AndroidComposeView$focusOwner$1(this), new AndroidComposeView$focusOwner$2(this), new AndroidComposeView$focusOwner$3(this), new AndroidComposeView$focusOwner$4(this), new AndroidComposeView$focusOwner$5(this), new MutablePropertyReference0Impl(this) { // from class: androidx.compose.ui.platform.AndroidComposeView$focusOwner$6
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            @Nullable
            public Object get() {
                return ((AndroidComposeView) this.receiver).getLayoutDirection();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(@Nullable Object obj) {
                ((AndroidComposeView) this.receiver).setLayoutDirection((LayoutDirection) obj);
            }
        });
        DragAndDropModifierOnDragListener dragAndDropModifierOnDragListener = new DragAndDropModifierOnDragListener(new AndroidComposeView$dragAndDropModifierOnDragListener$1(this));
        this.dragAndDropModifierOnDragListener = dragAndDropModifierOnDragListener;
        this.coroutineContext = coroutineContext;
        this.dragAndDropManager = dragAndDropModifierOnDragListener;
        this._windowInfo = new WindowInfoImpl();
        Modifier.Companion companion2 = Modifier.INSTANCE;
        Modifier modifierOnKeyEvent = KeyInputModifierKt.onKeyEvent(companion2, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m20180invokeZmokQxo(keyEvent.m19573unboximpl());
            }

            @NotNull
            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m20180invokeZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
                final FocusDirection focusDirectionMo20145getFocusDirectionP8AzH3I = this.this$0.mo20145getFocusDirectionP8AzH3I(keyEvent);
                if (focusDirectionMo20145getFocusDirectionP8AzH3I == null || !KeyEventType.m19577equalsimpl0(KeyEvent_androidKt.m19585getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m19581getKeyDownCS__XNY())) {
                    return Boolean.FALSE;
                }
                Rect rectOnFetchFocusRect = this.this$0.onFetchFocusRect();
                Boolean boolMo18216focusSearchULY8qGw = this.this$0.getFocusOwner().mo18216focusSearchULY8qGw(focusDirectionMo20145getFocusDirectionP8AzH3I.getValue(), rectOnFetchFocusRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1$focusWasMovedOrCancelled$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull FocusTargetNode focusTargetNode) {
                        Boolean boolM18235requestFocusMxy_nc0 = FocusTransactionsKt.m18235requestFocusMxy_nc0(focusTargetNode, focusDirectionMo20145getFocusDirectionP8AzH3I.getValue());
                        return Boolean.valueOf(boolM18235requestFocusMxy_nc0 != null ? boolM18235requestFocusMxy_nc0.booleanValue() : true);
                    }
                });
                if (boolMo18216focusSearchULY8qGw != null ? boolMo18216focusSearchULY8qGw.booleanValue() : true) {
                    return Boolean.TRUE;
                }
                if (!FocusOwnerImplKt.m18222is1dFocusSearch3ESFkO8(focusDirectionMo20145getFocusDirectionP8AzH3I.getValue())) {
                    return Boolean.FALSE;
                }
                Integer numM18210toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m18210toAndroidFocusDirection3ESFkO8(focusDirectionMo20145getFocusDirectionP8AzH3I.getValue());
                if (numM18210toAndroidFocusDirection3ESFkO8 == null) {
                    throw new IllegalStateException("Invalid focus direction");
                }
                int iIntValue = numM18210toAndroidFocusDirection3ESFkO8.intValue();
                android.graphics.Rect androidRect = rectOnFetchFocusRect != null ? RectHelper_androidKt.toAndroidRect(rectOnFetchFocusRect) : null;
                if (androidRect == null) {
                    throw new IllegalStateException("Invalid rect");
                }
                View viewFindNextNonChildView = this.this$0.findNextNonChildView(iIntValue);
                if (Intrinsics.areEqual(viewFindNextNonChildView, this.this$0)) {
                    viewFindNextNonChildView = null;
                }
                if (viewFindNextNonChildView != null && FocusInteropUtils_androidKt.requestInteropFocus(viewFindNextNonChildView, Integer.valueOf(iIntValue), androidRect)) {
                    return Boolean.TRUE;
                }
                if (!this.this$0.getFocusOwner().mo18213clearFocusI7lrPNg(false, true, false, focusDirectionMo20145getFocusDirectionP8AzH3I.getValue())) {
                    return Boolean.TRUE;
                }
                Boolean boolMo18216focusSearchULY8qGw2 = this.this$0.getFocusOwner().mo18216focusSearchULY8qGw(focusDirectionMo20145getFocusDirectionP8AzH3I.getValue(), null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull FocusTargetNode focusTargetNode) {
                        Boolean boolM18235requestFocusMxy_nc0 = FocusTransactionsKt.m18235requestFocusMxy_nc0(focusTargetNode, focusDirectionMo20145getFocusDirectionP8AzH3I.getValue());
                        return Boolean.valueOf(boolM18235requestFocusMxy_nc0 != null ? boolM18235requestFocusMxy_nc0.booleanValue() : true);
                    }
                });
                return Boolean.valueOf(boolMo18216focusSearchULY8qGw2 != null ? boolMo18216focusSearchULY8qGw2.booleanValue() : true);
            }
        });
        this.keyInputModifier = modifierOnKeyEvent;
        Modifier modifierOnRotaryScrollEvent = RotaryInputModifierKt.onRotaryScrollEvent(companion2, new Function1<RotaryScrollEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$rotaryInputModifier$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull RotaryScrollEvent rotaryScrollEvent) {
                return Boolean.FALSE;
            }
        });
        this.rotaryInputModifier = modifierOnRotaryScrollEvent;
        this.canvasHolder = new CanvasHolder();
        LayoutNode layoutNode = new LayoutNode(false, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        layoutNode.setMeasurePolicy(RootMeasurePolicy.INSTANCE);
        layoutNode.setDensity(getDensity());
        layoutNode.setModifier(companion2.then(emptySemanticsElement).then(modifierOnRotaryScrollEvent).then(modifierOnKeyEvent).then(getFocusOwner().getModifier()).then(dragAndDropModifierOnDragListener.getModifier()));
        this.root = layoutNode;
        this.rootForTest = this;
        this.semanticsOwner = new SemanticsOwner(getRoot(), emptySemanticsModifier);
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = new AndroidComposeViewAccessibilityDelegateCompat(this);
        this.composeAccessibilityDelegate = androidComposeViewAccessibilityDelegateCompat;
        this.contentCaptureManager = new AndroidContentCaptureManager(this, new AndroidComposeView$contentCaptureManager$1(this));
        this.accessibilityManager = new AndroidAccessibilityManager(context);
        this.graphicsContext = AndroidGraphicsContext_androidKt.GraphicsContext(this);
        this.autofillTree = new AutofillTree();
        this.dirtyLayers = new ArrayList();
        this.motionEventAdapter = new MotionEventAdapter();
        this.pointerInputEventProcessor = new PointerInputEventProcessor(getRoot());
        this.configurationChangeObserver = new Function1<Configuration, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$configurationChangeObserver$1
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Configuration configuration) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Configuration configuration) {
                invoke2(configuration);
                return Unit.INSTANCE;
            }
        };
        this._autofill = autofillSupported() ? new AndroidAutofill(this, getAutofillTree()) : null;
        this.clipboardManager = new AndroidClipboardManager(context);
        this.snapshotObserver = new OwnerSnapshotObserver(new AndroidComposeView$snapshotObserver$1(this));
        this.measureAndLayoutDelegate = new MeasureAndLayoutDelegate(getRoot());
        this.viewConfiguration = new AndroidViewConfiguration(ViewConfiguration.get(context));
        this.globalPosition = IntOffsetKt.IntOffset(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.tmpPositionArray = new int[]{0, 0};
        float[] fArrM18756constructorimpl$default = Matrix.m18756constructorimpl$default(null, 1, null);
        this.tmpMatrix = fArrM18756constructorimpl$default;
        this.viewToWindowMatrix = Matrix.m18756constructorimpl$default(null, 1, null);
        this.windowToViewMatrix = Matrix.m18756constructorimpl$default(null, 1, null);
        this.lastMatrixRecalculationAnimationTime = -1L;
        this.windowPosition = companion.m18298getInfiniteF1C5BW0();
        this.isRenderNodeCompatible = true;
        this._viewTreeOwners = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.viewTreeOwners = SnapshotStateKt.derivedStateOf(new Function0<ViewTreeOwners>() { // from class: androidx.compose.ui.platform.AndroidComposeView$viewTreeOwners$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final AndroidComposeView.ViewTreeOwners invoke() {
                return this.this$0.get_viewTreeOwners();
            }
        });
        this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.compose.ui.platform.a
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f1181a.updatePositionCacheAndDispatch();
            }
        };
        this.scrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: androidx.compose.ui.platform.b
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                this.f1183a.updatePositionCacheAndDispatch();
            }
        };
        this.touchModeChangeListener = new ViewTreeObserver.OnTouchModeChangeListener() { // from class: androidx.compose.ui.platform.c
            @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
            public final void onTouchModeChanged(boolean z) {
                AndroidComposeView.touchModeChangeListener$lambda$6(this.f1184a, z);
            }
        };
        TextInputServiceAndroid textInputServiceAndroid = new TextInputServiceAndroid(getView(), this);
        this.legacyTextInputServiceAndroid = textInputServiceAndroid;
        this.textInputService = new TextInputService(AndroidComposeView_androidKt.getPlatformTextInputServiceInterceptor().invoke(textInputServiceAndroid));
        this.textInputSessionMutex = SessionMutex.m18133constructorimpl();
        this.softwareKeyboardController = new DelegatingSoftwareKeyboardController(getTextInputService());
        this.fontLoader = new AndroidFontResourceLoader(context);
        this.fontFamilyResolver = SnapshotStateKt.mutableStateOf(FontFamilyResolver_androidKt.createFontFamilyResolver(context), SnapshotStateKt.referentialEqualityPolicy());
        this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(context.getResources().getConfiguration());
        LayoutDirection layoutDirection = FocusInteropUtils_androidKt.toLayoutDirection(context.getResources().getConfiguration().getLayoutDirection());
        this.layoutDirection = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(layoutDirection == null ? LayoutDirection.Ltr : layoutDirection, null, 2, null);
        this.hapticFeedBack = new PlatformHapticFeedback(this);
        this._inputModeManager = new InputModeManagerImpl(isInTouchMode() ? InputMode.INSTANCE.m19267getTouchaOaMEAU() : InputMode.INSTANCE.m19266getKeyboardaOaMEAU(), new Function1<InputMode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$_inputModeManager$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(InputMode inputMode) {
                return m20176invokeiuPiT84(inputMode.getValue());
            }

            @NotNull
            /* JADX INFO: renamed from: invoke-iuPiT84, reason: not valid java name */
            public final Boolean m20176invokeiuPiT84(int i) {
                InputMode.Companion companion3 = InputMode.INSTANCE;
                return Boolean.valueOf(InputMode.m19262equalsimpl0(i, companion3.m19267getTouchaOaMEAU()) ? this.this$0.isInTouchMode() : InputMode.m19262equalsimpl0(i, companion3.m19266getKeyboardaOaMEAU()) ? this.this$0.isInTouchMode() ? this.this$0.requestFocusFromTouch() : true : false);
            }
        }, objArr2 == true ? 1 : 0);
        this.modifierLocalManager = new ModifierLocalManager(this);
        this.textToolbar = new AndroidTextToolbar(this);
        this.layerCache = new WeakCache<>();
        this.endApplyChangesListeners = new MutableVector<>(new Function0[16], 0);
        this.resendMotionEventRunnable = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                this.this$0.removeCallbacks(this);
                MotionEvent motionEvent = this.this$0.previousMotionEvent;
                if (motionEvent != null) {
                    boolean z = motionEvent.getToolType(0) == 3;
                    int actionMasked = motionEvent.getActionMasked();
                    if (z) {
                        if (actionMasked == 10 || actionMasked == 1) {
                            return;
                        }
                    } else if (actionMasked == 1) {
                        return;
                    }
                    int i = 7;
                    if (actionMasked != 7 && actionMasked != 9) {
                        i = 2;
                    }
                    AndroidComposeView androidComposeView = this.this$0;
                    androidComposeView.sendSimulatedEvent(motionEvent, i, androidComposeView.relayoutTime, false);
                }
            }
        };
        this.sendHoverExitEvent = new RunnableC2204d(this, 1);
        this.resendMotionEventOnLayout = new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventOnLayout$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MotionEvent motionEvent = this.this$0.previousMotionEvent;
                if (motionEvent != null) {
                    int actionMasked = motionEvent.getActionMasked();
                    if (actionMasked == 7 || actionMasked == 9) {
                        this.this$0.relayoutTime = SystemClock.uptimeMillis();
                        AndroidComposeView androidComposeView = this.this$0;
                        androidComposeView.post(androidComposeView.resendMotionEventRunnable);
                    }
                }
            }
        };
        int i = Build.VERSION.SDK_INT;
        this.matrixToWindow = i < 29 ? new CalculateMatrixToWindowApi21(fArrM18756constructorimpl$default, objArr == true ? 1 : 0) : new CalculateMatrixToWindowApi29();
        addOnAttachStateChangeListener(this.contentCaptureManager);
        setWillNotDraw(false);
        setFocusable(true);
        AndroidComposeViewVerificationHelperMethodsO.INSTANCE.focusable(this, 1, false);
        setFocusableInTouchMode(true);
        setClipChildren(false);
        ViewCompat.setAccessibilityDelegate(this, androidComposeViewAccessibilityDelegateCompat);
        Function1<ViewRootForTest, Unit> onViewCreatedCallback = ViewRootForTest.INSTANCE.getOnViewCreatedCallback();
        if (onViewCreatedCallback != null) {
            onViewCreatedCallback.invoke(this);
        }
        setOnDragListener(dragAndDropModifierOnDragListener);
        getRoot().attach$ui_release(this);
        if (i >= 29) {
            AndroidComposeViewForceDarkModeQ.INSTANCE.disallowForceDark(this);
        }
        this.scrollCapture = i >= 31 ? new ScrollCapture() : null;
        this.pointerIconService = new PointerIconService() { // from class: androidx.compose.ui.platform.AndroidComposeView$pointerIconService$1

            @NotNull
            private PointerIcon currentIcon = PointerIcon.INSTANCE.getDefault();

            @Override // androidx.compose.p109ui.input.pointer.PointerIconService
            @NotNull
            /* JADX INFO: renamed from: getIcon, reason: from getter */
            public PointerIcon getCurrentIcon() {
                return this.currentIcon;
            }

            @Override // androidx.compose.p109ui.input.pointer.PointerIconService
            public void setIcon(@Nullable PointerIcon value) {
                if (value == null) {
                    value = PointerIcon.INSTANCE.getDefault();
                }
                this.currentIcon = value;
                AndroidComposeViewVerificationHelperMethodsN.INSTANCE.setPointerIcon(this.this$0, value);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int virtualViewId, AccessibilityNodeInfo info, String extraDataKey) {
        int orDefault;
        if (Intrinsics.areEqual(extraDataKey, this.composeAccessibilityDelegate.getExtraDataTestTraversalBeforeVal())) {
            int orDefault2 = this.composeAccessibilityDelegate.getIdToBeforeMap().getOrDefault(virtualViewId, -1);
            if (orDefault2 != -1) {
                info.getExtras().putInt(extraDataKey, orDefault2);
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(extraDataKey, this.composeAccessibilityDelegate.getExtraDataTestTraversalAfterVal()) || (orDefault = this.composeAccessibilityDelegate.getIdToAfterMap().getOrDefault(virtualViewId, -1)) == -1) {
            return;
        }
        info.getExtras().putInt(extraDataKey, orDefault);
    }

    private final boolean autofillSupported() {
        return true;
    }

    private final boolean childSizeCanAffectParentSize(LayoutNode layoutNode) {
        if (this.wasMeasuredWithMultipleConstraints) {
            return true;
        }
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        return (parent$ui_release == null || parent$ui_release.getHasFixedInnerContentConstraints$ui_release()) ? false : true;
    }

    private final void clearChildInvalidObservations(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof AndroidComposeView) {
                ((AndroidComposeView) childAt).onEndApplyChanges();
            } else if (childAt instanceof ViewGroup) {
                clearChildInvalidObservations((ViewGroup) childAt);
            }
        }
    }

    /* JADX INFO: renamed from: component1-VKZWuLQ, reason: not valid java name */
    private final int m20167component1VKZWuLQ(long j) {
        return (int) ULong.m22389constructorimpl(j >>> 32);
    }

    /* JADX INFO: renamed from: component2-VKZWuLQ, reason: not valid java name */
    private final int m20168component2VKZWuLQ(long j) {
        return (int) ULong.m22389constructorimpl(j & 4294967295L);
    }

    /* JADX INFO: renamed from: convertMeasureSpec-I7RO_PI, reason: not valid java name */
    private final long m20169convertMeasureSpecI7RO_PI(int measureSpec) {
        int mode = View.MeasureSpec.getMode(measureSpec);
        int size = View.MeasureSpec.getSize(measureSpec);
        if (mode == Integer.MIN_VALUE) {
            return m20173packZIaKswc(0, size);
        }
        if (mode == 0) {
            return m20173packZIaKswc(0, Integer.MAX_VALUE);
        }
        if (mode == 1073741824) {
            return m20173packZIaKswc(size, size);
        }
        throw new IllegalStateException();
    }

    private final void dispatchPendingInteropLayoutCallbacks() {
        if (this.isPendingInteropViewLayoutChangeDispatch) {
            getViewTreeObserver().dispatchOnGlobalLayout();
            this.isPendingInteropViewLayoutChangeDispatch = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View findNextNonChildView(int direction) {
        View viewFindNextFocus = this;
        while (viewFindNextFocus != null) {
            FocusFinder focusFinder = FocusFinder.getInstance();
            View rootView = getRootView();
            Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            viewFindNextFocus = focusFinder.findNextFocus((ViewGroup) rootView, viewFindNextFocus, direction);
            if (viewFindNextFocus != null && !AndroidComposeView_androidKt.containsDescendant(this, viewFindNextFocus)) {
                return viewFindNextFocus;
            }
        }
        return null;
    }

    private final View findViewByAccessibilityIdRootedAtCurrentView(int accessibilityId, View currentView) throws NoSuchMethodException {
        if (Build.VERSION.SDK_INT < 29) {
            Method declaredMethod = View.class.getDeclaredMethod("getAccessibilityViewId", null);
            declaredMethod.setAccessible(true);
            if (Intrinsics.areEqual(declaredMethod.invoke(currentView, null), Integer.valueOf(accessibilityId))) {
                return currentView;
            }
            if (currentView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) currentView;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View viewFindViewByAccessibilityIdRootedAtCurrentView = findViewByAccessibilityIdRootedAtCurrentView(accessibilityId, viewGroup.getChildAt(i));
                    if (viewFindViewByAccessibilityIdRootedAtCurrentView != null) {
                        return viewFindViewByAccessibilityIdRootedAtCurrentView;
                    }
                }
            }
        }
        return null;
    }

    private final int getFontWeightAdjustmentCompat(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            return configuration.fontWeightAdjustment;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ViewTreeOwners get_viewTreeOwners() {
        return (ViewTreeOwners) this._viewTreeOwners.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
    /* JADX INFO: renamed from: handleMotionEvent-8iAsVTc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int m20170handleMotionEvent8iAsVTc(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        AndroidComposeView androidComposeView;
        int i;
        removeCallbacks(this.resendMotionEventRunnable);
        try {
            recalculateWindowPosition(motionEvent);
            boolean z = true;
            this.forceUseMatrixCache = true;
            measureAndLayout(false);
            Trace.beginSection("AndroidOwner:onTouch");
            try {
                int actionMasked = motionEvent.getActionMasked();
                MotionEvent motionEvent3 = this.previousMotionEvent;
                boolean z2 = motionEvent3 != null && motionEvent3.getToolType(0) == 3;
                if (motionEvent3 != null) {
                    try {
                        if (hasChangedDevices(motionEvent, motionEvent3)) {
                            if (isDevicePressEvent(motionEvent3)) {
                                this.pointerInputEventProcessor.processCancel();
                            } else if (motionEvent3.getActionMasked() != 10 && z2) {
                                sendSimulatedEvent$default(this, motionEvent3, 10, motionEvent3.getEventTime(), false, 8, null);
                                motionEvent2 = motionEvent3;
                            }
                            motionEvent2 = motionEvent3;
                        } else {
                            motionEvent2 = motionEvent3;
                        }
                    } catch (Throwable th) {
                        th = th;
                        Trace.endSection();
                        throw th;
                    }
                }
                boolean z3 = motionEvent.getToolType(0) == 3;
                if (z2 || !z3 || actionMasked == 3 || actionMasked == 9 || !isInBounds(motionEvent)) {
                    androidComposeView = this;
                    i = 9;
                } else {
                    i = 9;
                    androidComposeView = this;
                    sendSimulatedEvent$default(androidComposeView, motionEvent, 9, motionEvent.getEventTime(), false, 8, null);
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                MotionEvent motionEvent4 = androidComposeView.previousMotionEvent;
                if (motionEvent4 != null && motionEvent4.getAction() == 10) {
                    MotionEvent motionEvent5 = androidComposeView.previousMotionEvent;
                    int pointerId = motionEvent5 != null ? motionEvent5.getPointerId(0) : -1;
                    if (motionEvent.getAction() == i && motionEvent.getHistorySize() == 0) {
                        if (pointerId >= 0) {
                            androidComposeView.motionEventAdapter.endStream(pointerId);
                        }
                    } else if (motionEvent.getAction() == 0 && motionEvent.getHistorySize() == 0) {
                        MotionEvent motionEvent6 = androidComposeView.previousMotionEvent;
                        float x = motionEvent6 != null ? motionEvent6.getX() : Float.NaN;
                        MotionEvent motionEvent7 = androidComposeView.previousMotionEvent;
                        boolean z4 = (x == motionEvent.getX() && (motionEvent7 != null ? motionEvent7.getY() : Float.NaN) == motionEvent.getY()) ? false : true;
                        MotionEvent motionEvent8 = androidComposeView.previousMotionEvent;
                        if ((motionEvent8 != null ? motionEvent8.getEventTime() : -1L) == motionEvent.getEventTime()) {
                            z = false;
                        }
                        if (z4 || z) {
                            if (pointerId >= 0) {
                                androidComposeView.motionEventAdapter.endStream(pointerId);
                            }
                            androidComposeView.pointerInputEventProcessor.clearPreviouslyHitModifierNodes();
                        }
                    }
                }
                androidComposeView.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                int iM20174sendMotionEvent8iAsVTc = m20174sendMotionEvent8iAsVTc(motionEvent);
                Trace.endSection();
                androidComposeView.forceUseMatrixCache = false;
                return iM20174sendMotionEvent8iAsVTc;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            this.forceUseMatrixCache = false;
            throw th3;
        }
    }

    private final boolean handleRotaryEvent(MotionEvent event) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        float f = -event.getAxisValue(26);
        return getFocusOwner().dispatchRotaryEvent(new RotaryScrollEvent(ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, getContext()) * f, ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, getContext()) * f, event.getEventTime(), event.getDeviceId()));
    }

    private final boolean hasChangedDevices(MotionEvent event, MotionEvent lastEvent) {
        return (lastEvent.getSource() == event.getSource() && lastEvent.getToolType(0) == event.getToolType(0)) ? false : true;
    }

    private final void invalidateLayers(LayoutNode node) {
        node.invalidateLayers$ui_release();
        MutableVector<LayoutNode> mutableVector = node.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                invalidateLayers(content[i]);
                i++;
            } while (i < size);
        }
    }

    private final void invalidateLayoutNodeMeasurement(LayoutNode node) {
        int i = 0;
        MeasureAndLayoutDelegate.requestRemeasure$default(this.measureAndLayoutDelegate, node, false, 2, null);
        MutableVector<LayoutNode> mutableVector = node.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            do {
                invalidateLayoutNodeMeasurement(content[i]);
                i++;
            } while (i < size);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0082 A[LOOP:0: B:22:0x004c->B:39:0x0082, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0085 A[EDGE_INSN: B:41:0x0085->B:40:0x0085 BREAK  A[LOOP:0: B:22:0x004c->B:39:0x0082], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isBadMotionEvent(MotionEvent event) {
        boolean z;
        float x = event.getX();
        if (Float.isInfinite(x) || Float.isNaN(x)) {
            z = true;
        } else {
            float y2 = event.getY();
            if (!Float.isInfinite(y2) && !Float.isNaN(y2)) {
                float rawX = event.getRawX();
                if (!Float.isInfinite(rawX) && !Float.isNaN(rawX)) {
                    float rawY = event.getRawY();
                    if (!Float.isInfinite(rawY) && !Float.isNaN(rawY)) {
                        z = false;
                    }
                }
            }
        }
        if (!z) {
            int pointerCount = event.getPointerCount();
            for (int i = 1; i < pointerCount; i++) {
                float x2 = event.getX(i);
                if (Float.isInfinite(x2) || Float.isNaN(x2)) {
                    z = true;
                    if (!z) {
                        break;
                    }
                } else {
                    float y3 = event.getY(i);
                    if (!Float.isInfinite(y3) && !Float.isNaN(y3) && (Build.VERSION.SDK_INT < 29 || MotionEventVerifierApi29.INSTANCE.isValidMotionEvent(event, i))) {
                        z = false;
                    }
                    if (!z) {
                    }
                }
            }
        }
        return z;
    }

    private final boolean isDevicePressEvent(MotionEvent event) {
        int actionMasked;
        return event.getButtonState() != 0 || (actionMasked = event.getActionMasked()) == 0 || actionMasked == 2 || actionMasked == 6;
    }

    private final boolean isInBounds(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y2 = motionEvent.getY();
        return 0.0f <= x && x <= ((float) getWidth()) && 0.0f <= y2 && y2 <= ((float) getHeight());
    }

    private final boolean isPositionChanged(MotionEvent event) {
        MotionEvent motionEvent;
        return (event.getPointerCount() == 1 && (motionEvent = this.previousMotionEvent) != null && motionEvent.getPointerCount() == event.getPointerCount() && event.getRawX() == motionEvent.getRawX() && event.getRawY() == motionEvent.getRawY()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClearFocusForOwner() {
        if (isFocused() || hasFocus()) {
            clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect onFetchFocusRect() {
        if (isFocused()) {
            return getFocusOwner().getFocusRect();
        }
        View viewFindFocus = findFocus();
        if (viewFindFocus != null) {
            return FocusInteropUtils_androidKt.calculateBoundingRect(viewFindFocus);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onMoveFocusInChildren-3ESFkO8, reason: not valid java name */
    public final boolean m20171onMoveFocusInChildren3ESFkO8(int focusDirection) {
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m18196equalsimpl0(focusDirection, companion.m18203getEnterdhqQ8s()) || FocusDirection.m18196equalsimpl0(focusDirection, companion.m18204getExitdhqQ8s())) {
            return false;
        }
        Integer numM18210toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m18210toAndroidFocusDirection3ESFkO8(focusDirection);
        if (numM18210toAndroidFocusDirection3ESFkO8 == null) {
            throw new IllegalStateException("Invalid focus direction");
        }
        int iIntValue = numM18210toAndroidFocusDirection3ESFkO8.intValue();
        Rect rectOnFetchFocusRect = onFetchFocusRect();
        android.graphics.Rect androidRect = rectOnFetchFocusRect != null ? RectHelper_androidKt.toAndroidRect(rectOnFetchFocusRect) : null;
        FocusFinder focusFinder = FocusFinder.getInstance();
        View viewFindNextFocus = androidRect == null ? focusFinder.findNextFocus(this, findFocus(), iIntValue) : focusFinder.findNextFocusFromRect(this, androidRect, iIntValue);
        if (viewFindNextFocus != null) {
            return FocusInteropUtils_androidKt.requestInteropFocus(viewFindNextFocus, Integer.valueOf(iIntValue), androidRect);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onRequestFocusForOwner-7o62pno, reason: not valid java name */
    public final boolean m20172onRequestFocusForOwner7o62pno(FocusDirection focusDirection, Rect previouslyFocusedRect) {
        Integer numM18210toAndroidFocusDirection3ESFkO8;
        if (isFocused() || hasFocus()) {
            return true;
        }
        return super.requestFocus((focusDirection == null || (numM18210toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m18210toAndroidFocusDirection3ESFkO8(focusDirection.getValue())) == null) ? 130 : numM18210toAndroidFocusDirection3ESFkO8.intValue(), previouslyFocusedRect != null ? RectHelper_androidKt.toAndroidRect(previouslyFocusedRect) : null);
    }

    /* JADX INFO: renamed from: pack-ZIaKswc, reason: not valid java name */
    private final long m20173packZIaKswc(int a, int b) {
        return ULong.m22389constructorimpl(ULong.m22389constructorimpl(b) | ULong.m22389constructorimpl(ULong.m22389constructorimpl(a) << 32));
    }

    private final void recalculateWindowPosition() {
        if (this.forceUseMatrixCache) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (jCurrentAnimationTimeMillis != this.lastMatrixRecalculationAnimationTime) {
            this.lastMatrixRecalculationAnimationTime = jCurrentAnimationTimeMillis;
            recalculateWindowViewTransforms();
            ViewParent parent = getParent();
            View view = this;
            while (parent instanceof ViewGroup) {
                view = (View) parent;
                parent = ((ViewGroup) view).getParent();
            }
            view.getLocationOnScreen(this.tmpPositionArray);
            int[] iArr = this.tmpPositionArray;
            float f = iArr[0];
            float f4 = iArr[1];
            view.getLocationInWindow(iArr);
            int[] iArr2 = this.tmpPositionArray;
            this.windowPosition = OffsetKt.Offset(f - iArr2[0], f4 - iArr2[1]);
        }
    }

    private final void recalculateWindowViewTransforms() {
        this.matrixToWindow.mo20188calculateMatrixToWindowEL8BTi8(this, this.viewToWindowMatrix);
        InvertMatrixKt.m20214invertToJiSxe2E(this.viewToWindowMatrix, this.windowToViewMatrix);
    }

    private final void scheduleMeasureAndLayout(LayoutNode nodeToRemeasure) {
        if (isLayoutRequested() || !isAttachedToWindow()) {
            return;
        }
        if (nodeToRemeasure != null) {
            while (nodeToRemeasure != null && nodeToRemeasure.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock && childSizeCanAffectParentSize(nodeToRemeasure)) {
                nodeToRemeasure = nodeToRemeasure.getParent$ui_release();
            }
            if (nodeToRemeasure == getRoot()) {
                requestLayout();
                return;
            }
        }
        if (getWidth() == 0 || getHeight() == 0) {
            requestLayout();
        } else {
            invalidate();
        }
    }

    public static /* synthetic */ void scheduleMeasureAndLayout$default(AndroidComposeView androidComposeView, LayoutNode layoutNode, int i, Object obj) {
        if ((i & 1) != 0) {
            layoutNode = null;
        }
        androidComposeView.scheduleMeasureAndLayout(layoutNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendHoverExitEvent$lambda$8(AndroidComposeView androidComposeView) {
        androidComposeView.hoverExitReceived = false;
        MotionEvent motionEvent = androidComposeView.previousMotionEvent;
        Intrinsics.checkNotNull(motionEvent);
        if (motionEvent.getActionMasked() != 10) {
            throw new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.");
        }
        androidComposeView.m20174sendMotionEvent8iAsVTc(motionEvent);
    }

    /* JADX INFO: renamed from: sendMotionEvent-8iAsVTc, reason: not valid java name */
    private final int m20174sendMotionEvent8iAsVTc(MotionEvent motionEvent) {
        PointerInputEventData pointerInputEventData;
        if (this.keyboardModifiersRequireUpdate) {
            this.keyboardModifiersRequireUpdate = false;
            this._windowInfo.m20248setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m19789constructorimpl(motionEvent.getMetaState()));
        }
        PointerInputEvent pointerInputEventConvertToPointerInputEvent$ui_release = this.motionEventAdapter.convertToPointerInputEvent$ui_release(motionEvent, this);
        if (pointerInputEventConvertToPointerInputEvent$ui_release == null) {
            this.pointerInputEventProcessor.processCancel();
            return PointerInputEventProcessorKt.ProcessResult(false, false);
        }
        List<PointerInputEventData> pointers = pointerInputEventConvertToPointerInputEvent$ui_release.getPointers();
        int size = pointers.size() - 1;
        if (size >= 0) {
            while (true) {
                int i = size - 1;
                pointerInputEventData = pointers.get(size);
                if (pointerInputEventData.getDown()) {
                    break;
                }
                if (i < 0) {
                    break;
                }
                size = i;
            }
            pointerInputEventData = null;
        } else {
            pointerInputEventData = null;
        }
        PointerInputEventData pointerInputEventData2 = pointerInputEventData;
        if (pointerInputEventData2 != null) {
            this.lastDownPointerPosition = pointerInputEventData2.m19743getPositionF1C5BW0();
        }
        int iM19748processBIzXfog = this.pointerInputEventProcessor.m19748processBIzXfog(pointerInputEventConvertToPointerInputEvent$ui_release, this, isInBounds(motionEvent));
        int actionMasked = motionEvent.getActionMasked();
        if ((actionMasked == 0 || actionMasked == 5) && !ProcessResult.m19815getDispatchedToAPointerInputModifierimpl(iM19748processBIzXfog)) {
            this.motionEventAdapter.endStream(motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return iM19748processBIzXfog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendSimulatedEvent(MotionEvent motionEvent, int action, long eventTime, boolean forceHover) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = -1;
        if (actionMasked != 1) {
            if (actionMasked == 6) {
                actionIndex = motionEvent.getActionIndex();
            }
        } else if (action != 9 && action != 10) {
            actionIndex = 0;
        }
        int pointerCount = motionEvent.getPointerCount() - (actionIndex >= 0 ? 1 : 0);
        if (pointerCount == 0) {
            return;
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        for (int i = 0; i < pointerCount; i++) {
            pointerPropertiesArr[i] = new MotionEvent.PointerProperties();
        }
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i2 = 0; i2 < pointerCount; i2++) {
            pointerCoordsArr[i2] = new MotionEvent.PointerCoords();
        }
        int i4 = 0;
        while (i4 < pointerCount) {
            int i5 = ((actionIndex < 0 || i4 < actionIndex) ? 0 : 1) + i4;
            motionEvent.getPointerProperties(i5, pointerPropertiesArr[i4]);
            MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[i4];
            motionEvent.getPointerCoords(i5, pointerCoords);
            long jMo19808localToScreenMKHz9U = mo19808localToScreenMKHz9U(OffsetKt.Offset(pointerCoords.x, pointerCoords.y));
            pointerCoords.x = Offset.m18284getXimpl(jMo19808localToScreenMKHz9U);
            pointerCoords.y = Offset.m18285getYimpl(jMo19808localToScreenMKHz9U);
            i4++;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent.getDownTime() == motionEvent.getEventTime() ? eventTime : motionEvent.getDownTime(), eventTime, action, pointerCount, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), forceHover ? 0 : motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        PointerInputEvent pointerInputEventConvertToPointerInputEvent$ui_release = this.motionEventAdapter.convertToPointerInputEvent$ui_release(motionEventObtain, this);
        Intrinsics.checkNotNull(pointerInputEventConvertToPointerInputEvent$ui_release);
        this.pointerInputEventProcessor.m19748processBIzXfog(pointerInputEventConvertToPointerInputEvent$ui_release, this, true);
        motionEventObtain.recycle();
    }

    public static /* synthetic */ void sendSimulatedEvent$default(AndroidComposeView androidComposeView, MotionEvent motionEvent, int i, long j, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = true;
        }
        androidComposeView.sendSimulatedEvent(motionEvent, i, j, z);
    }

    private void setDensity(Density density) {
        this.density.setValue(density);
    }

    private void setFontFamilyResolver(FontFamily.Resolver resolver) {
        this.fontFamilyResolver.setValue(resolver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection.setValue(layoutDirection);
    }

    private final void set_viewTreeOwners(ViewTreeOwners viewTreeOwners) {
        this._viewTreeOwners.setValue(viewTreeOwners);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startDrag-12SF9DM, reason: not valid java name */
    public final boolean m20175startDrag12SF9DM(DragAndDropTransferData transferData, long decorationSize, Function1<? super DrawScope, Unit> drawDragDecoration) {
        Resources resources = getContext().getResources();
        return AndroidComposeViewStartDragAndDropN.INSTANCE.startDragAndDrop(this, transferData, new ComposeDragShadowBuilder(DensityKt.Density(resources.getDisplayMetrics().density, resources.getConfiguration().fontScale), decorationSize, drawDragDecoration, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void touchModeChangeListener$lambda$6(AndroidComposeView androidComposeView, boolean z) {
        androidComposeView._inputModeManager.m19270setInputModeiuPiT84(z ? InputMode.INSTANCE.m19267getTouchaOaMEAU() : InputMode.INSTANCE.m19266getKeyboardaOaMEAU());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePositionCacheAndDispatch() {
        getLocationOnScreen(this.tmpPositionArray);
        long j = this.globalPosition;
        int iM21096getXimpl = IntOffset.m21096getXimpl(j);
        int iM21097getYimpl = IntOffset.m21097getYimpl(j);
        int[] iArr = this.tmpPositionArray;
        boolean z = false;
        int i = iArr[0];
        if (iM21096getXimpl != i || iM21097getYimpl != iArr[1]) {
            this.globalPosition = IntOffsetKt.IntOffset(i, iArr[1]);
            if (iM21096getXimpl != Integer.MAX_VALUE && iM21097getYimpl != Integer.MAX_VALUE) {
                getRoot().getLayoutDelegate().getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
                z = true;
            }
        }
        this.measureAndLayoutDelegate.dispatchOnPositionedCallbacks(z);
    }

    public final void addAndroidView(@NotNull AndroidViewHolder view, @NotNull final LayoutNode layoutNode) {
        getAndroidViewsHandler$ui_release().getHolderToLayoutNode().put(view, layoutNode);
        getAndroidViewsHandler$ui_release().addView(view);
        getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().put(layoutNode, view);
        view.setImportantForAccessibility(1);
        ViewCompat.setAccessibilityDelegate(view, new AccessibilityDelegateCompat() { // from class: androidx.compose.ui.platform.AndroidComposeView.addAndroidView.1
            /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
            @Override // androidx.core.view.AccessibilityDelegateCompat
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onInitializeAccessibilityNodeInfo(@NotNull View host, @NotNull AccessibilityNodeInfoCompat info) {
                super.onInitializeAccessibilityNodeInfo(host, info);
                if (AndroidComposeView.this.composeAccessibilityDelegate.isEnabled$ui_release()) {
                    info.setVisibleToUser(false);
                }
                LayoutNode layoutNodeFindClosestParentNode = SemanticsNodeKt.findClosestParentNode(layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull LayoutNode layoutNode2) {
                        return Boolean.valueOf(layoutNode2.getNodes().m20051hasH91voCI$ui_release(NodeKind.m20090constructorimpl(8)));
                    }
                });
                Integer numValueOf = layoutNodeFindClosestParentNode != null ? Integer.valueOf(layoutNodeFindClosestParentNode.getSemanticsId()) : null;
                if (numValueOf != null) {
                    if (numValueOf.intValue() == AndroidComposeView.this.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
                        numValueOf = -1;
                    }
                }
                info.setParent(this, numValueOf.intValue());
                int semanticsId = layoutNode.getSemanticsId();
                int orDefault = AndroidComposeView.this.composeAccessibilityDelegate.getIdToBeforeMap().getOrDefault(semanticsId, -1);
                if (orDefault != -1) {
                    View viewSemanticsIdToView = SemanticsUtils_androidKt.semanticsIdToView(AndroidComposeView.this.getAndroidViewsHandler$ui_release(), orDefault);
                    if (viewSemanticsIdToView != null) {
                        info.setTraversalBefore(viewSemanticsIdToView);
                    } else {
                        info.setTraversalBefore(this, orDefault);
                    }
                    AndroidComposeView.this.addExtraDataToAccessibilityNodeInfoHelper(semanticsId, info.unwrap(), AndroidComposeView.this.composeAccessibilityDelegate.getExtraDataTestTraversalBeforeVal());
                }
                int orDefault2 = AndroidComposeView.this.composeAccessibilityDelegate.getIdToAfterMap().getOrDefault(semanticsId, -1);
                if (orDefault2 != -1) {
                    View viewSemanticsIdToView2 = SemanticsUtils_androidKt.semanticsIdToView(AndroidComposeView.this.getAndroidViewsHandler$ui_release(), orDefault2);
                    if (viewSemanticsIdToView2 != null) {
                        info.setTraversalAfter(viewSemanticsIdToView2);
                    } else {
                        info.setTraversalAfter(this, orDefault2);
                    }
                    AndroidComposeView.this.addExtraDataToAccessibilityNodeInfoHelper(semanticsId, info.unwrap(), AndroidComposeView.this.composeAccessibilityDelegate.getExtraDataTestTraversalAfterVal());
                }
            }
        });
    }

    @Override // android.view.ViewGroup
    public void addView(@Nullable View child) {
        addView(child, -1);
    }

    @Override // android.view.View
    public void autofill(@NotNull SparseArray<AutofillValue> values) {
        AndroidAutofill androidAutofill;
        if (!autofillSupported() || (androidAutofill = this._autofill) == null) {
            return;
        }
        AndroidAutofill_androidKt.performAutofill(androidAutofill, values);
    }

    @Nullable
    public final Object boundsUpdatesAccessibilityEventLoop(@NotNull Continuation<? super Unit> continuation) throws Throwable {
        Object objBoundsUpdatesEventLoop$ui_release = this.composeAccessibilityDelegate.boundsUpdatesEventLoop$ui_release(continuation);
        return objBoundsUpdatesEventLoop$ui_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objBoundsUpdatesEventLoop$ui_release : Unit.INSTANCE;
    }

    @Nullable
    public final Object boundsUpdatesContentCaptureEventLoop(@NotNull Continuation<? super Unit> continuation) {
        Object objBoundsUpdatesEventLoop$ui_release = this.contentCaptureManager.boundsUpdatesEventLoop$ui_release(continuation);
        return objBoundsUpdatesEventLoop$ui_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objBoundsUpdatesEventLoop$ui_release : Unit.INSTANCE;
    }

    @Override // androidx.compose.p109ui.node.Owner
    /* JADX INFO: renamed from: calculateLocalPosition-MK-Hz9U */
    public long mo20143calculateLocalPositionMKHz9U(long positionInWindow) {
        recalculateWindowPosition();
        return Matrix.m18762mapMKHz9U(this.windowToViewMatrix, positionInWindow);
    }

    @Override // androidx.compose.p109ui.node.Owner
    /* JADX INFO: renamed from: calculatePositionInWindow-MK-Hz9U */
    public long mo20144calculatePositionInWindowMKHz9U(long localPosition) {
        recalculateWindowPosition();
        return Matrix.m18762mapMKHz9U(this.viewToWindowMatrix, localPosition);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int direction) {
        return this.composeAccessibilityDelegate.m20182canScroll0AR0LA0$ui_release(false, direction, this.lastDownPointerPosition);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int direction) {
        return this.composeAccessibilityDelegate.m20182canScroll0AR0LA0$ui_release(true, direction, this.lastDownPointerPosition);
    }

    @Override // androidx.compose.p109ui.node.Owner
    @NotNull
    public OwnedLayer createLayer(@NotNull Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock, @NotNull Function0<Unit> invalidateParentLayer, @Nullable GraphicsLayer explicitLayer) {
        if (explicitLayer != null) {
            return new GraphicsLayerOwnerLayer(explicitLayer, null, this, drawBlock, invalidateParentLayer);
        }
        OwnedLayer ownedLayerPop = this.layerCache.pop();
        if (ownedLayerPop != null) {
            ownedLayerPop.reuseLayer(drawBlock, invalidateParentLayer);
            return ownedLayerPop;
        }
        if (isHardwareAccelerated() && Build.VERSION.SDK_INT != 28) {
            return new GraphicsLayerOwnerLayer(getGraphicsContext().createGraphicsLayer(), getGraphicsContext(), this, drawBlock, invalidateParentLayer);
        }
        if (isHardwareAccelerated() && this.isRenderNodeCompatible) {
            try {
                return new RenderNodeLayer(this, drawBlock, invalidateParentLayer);
            } catch (Throwable unused) {
                this.isRenderNodeCompatible = false;
            }
        }
        if (this.viewLayersContainer == null) {
            ViewLayer.Companion companion = ViewLayer.INSTANCE;
            if (!companion.getHasRetrievedMethod()) {
                companion.updateDisplayList(new View(getContext()));
            }
            DrawChildContainer drawChildContainer = companion.getShouldUseDispatchDraw() ? new DrawChildContainer(getContext()) : new ViewLayerContainer(getContext());
            this.viewLayersContainer = drawChildContainer;
            addView(drawChildContainer);
        }
        DrawChildContainer drawChildContainer2 = this.viewLayersContainer;
        Intrinsics.checkNotNull(drawChildContainer2);
        return new ViewLayer(this, drawChildContainer2, drawBlock, invalidateParentLayer);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NotNull android.graphics.Canvas canvas) {
        if (!isAttachedToWindow()) {
            invalidateLayers(getRoot());
        }
        Owner.measureAndLayout$default(this, false, 1, null);
        Snapshot.INSTANCE.sendApplyNotifications();
        this.isDrawingContent = true;
        CanvasHolder canvasHolder = this.canvasHolder;
        android.graphics.Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas(canvas);
        getRoot().draw$ui_release(canvasHolder.getAndroidCanvas(), null);
        canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
        if (!this.dirtyLayers.isEmpty()) {
            int size = this.dirtyLayers.size();
            for (int i = 0; i < size; i++) {
                this.dirtyLayers.get(i).updateDisplayList();
            }
        }
        if (ViewLayer.INSTANCE.getShouldUseDispatchDraw()) {
            int iSave = canvas.save();
            canvas.clipRect(0.0f, 0.0f, 0.0f, 0.0f);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(iSave);
        }
        this.dirtyLayers.clear();
        this.isDrawingContent = false;
        List<OwnedLayer> list = this.postponedDirtyLayers;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            this.dirtyLayers.addAll(list);
            list.clear();
        }
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(@NotNull MotionEvent motionEvent) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            if (motionEvent.getActionMasked() == 8) {
                this.hoverExitReceived = false;
            } else {
                this.sendHoverExitEvent.run();
            }
        }
        return motionEvent.getActionMasked() == 8 ? (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) ? super.dispatchGenericMotionEvent(motionEvent) : motionEvent.isFromSource(4194304) ? handleRotaryEvent(motionEvent) : ProcessResult.m19815getDispatchedToAPointerInputModifierimpl(m20170handleMotionEvent8iAsVTc(motionEvent)) : super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(@NotNull MotionEvent event) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            this.sendHoverExitEvent.run();
        }
        if (isBadMotionEvent(event) || !isAttachedToWindow()) {
            return false;
        }
        this.composeAccessibilityDelegate.dispatchHoverEvent$ui_release(event);
        int actionMasked = event.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10 && isInBounds(event)) {
                if (event.getToolType(0) == 3 && event.getButtonState() != 0) {
                    return false;
                }
                MotionEvent motionEvent = this.previousMotionEvent;
                if (motionEvent != null) {
                    motionEvent.recycle();
                }
                this.previousMotionEvent = MotionEvent.obtainNoHistory(event);
                this.hoverExitReceived = true;
                postDelayed(this.sendHoverExitEvent, 8L);
                return false;
            }
        } else if (!isPositionChanged(event)) {
            return false;
        }
        return ProcessResult.m19815getDispatchedToAPointerInputModifierimpl(m20170handleMotionEvent8iAsVTc(event));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(@NotNull final android.view.KeyEvent event) {
        if (!isFocused()) {
            return getFocusOwner().mo18215dispatchKeyEventYhN2O0w(KeyEvent.m19568constructorimpl(event), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView.dispatchKeyEvent.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Boolean invoke() {
                    return Boolean.valueOf(AndroidComposeView.super.dispatchKeyEvent(event));
                }
            });
        }
        this._windowInfo.m20248setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m19789constructorimpl(event.getMetaState()));
        return FocusOwner.m18212dispatchKeyEventYhN2O0w$default(getFocusOwner(), KeyEvent.m19568constructorimpl(event), null, 2, null) || super.dispatchKeyEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(@NotNull android.view.KeyEvent event) {
        return (isFocused() && getFocusOwner().mo18214dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent.m19568constructorimpl(event))) || super.dispatchKeyEventPreIme(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideStructure(@NotNull ViewStructure structure) {
        if (Build.VERSION.SDK_INT < 28) {
            AndroidComposeViewAssistHelperMethodsO.INSTANCE.setClassName(structure, getView());
        } else {
            super.dispatchProvideStructure(structure);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent motionEvent) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            MotionEvent motionEvent2 = this.previousMotionEvent;
            Intrinsics.checkNotNull(motionEvent2);
            if (motionEvent.getActionMasked() != 0 || hasChangedDevices(motionEvent, motionEvent2)) {
                this.sendHoverExitEvent.run();
            } else {
                this.hoverExitReceived = false;
            }
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return false;
        }
        if (motionEvent.getActionMasked() == 2 && !isPositionChanged(motionEvent)) {
            return false;
        }
        int iM20170handleMotionEvent8iAsVTc = m20170handleMotionEvent8iAsVTc(motionEvent);
        if (ProcessResult.m19814getAnyMovementConsumedimpl(iM20170handleMotionEvent8iAsVTc)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return ProcessResult.m19815getDispatchedToAPointerInputModifierimpl(iM20170handleMotionEvent8iAsVTc);
    }

    public final void drawAndroidView(@NotNull AndroidViewHolder view, @NotNull android.graphics.Canvas canvas) {
        getAndroidViewsHandler$ui_release().drawView(view, canvas);
    }

    @Nullable
    public final View findViewByAccessibilityIdTraversal(int accessibilityId) throws IllegalAccessException, InvocationTargetException {
        try {
            if (Build.VERSION.SDK_INT < 29) {
                return findViewByAccessibilityIdRootedAtCurrentView(accessibilityId, this);
            }
            Method declaredMethod = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(this, Integer.valueOf(accessibilityId));
            if (objInvoke instanceof View) {
                return (View) objInvoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    @Nullable
    public View focusSearch(@Nullable View focused, int direction) {
        if (focused != null) {
            Rect rectCalculateBoundingRect = FocusInteropUtils_androidKt.calculateBoundingRect(focused);
            FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(direction);
            if (Intrinsics.areEqual(getFocusOwner().mo18216focusSearchULY8qGw(focusDirection != null ? focusDirection.getValue() : FocusDirection.INSTANCE.m18202getDowndhqQ8s(), rectCalculateBoundingRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView.focusSearch.1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull FocusTargetNode focusTargetNode) {
                    return Boolean.TRUE;
                }
            }), Boolean.TRUE)) {
                return this;
            }
        }
        return super.focusSearch(focused, direction);
    }

    @Override // androidx.compose.p109ui.node.RootForTest
    public void forceAccessibilityForTesting(boolean enable) {
        this.composeAccessibilityDelegate.setAccessibilityForceEnabledForTesting$ui_release(enable);
    }

    @Override // androidx.compose.p109ui.node.Owner
    public void forceMeasureTheSubtree(@NotNull LayoutNode layoutNode, boolean affectsLookahead) {
        this.measureAndLayoutDelegate.forceMeasureTheSubtree(layoutNode, affectsLookahead);
    }

    @NotNull
    public final AndroidViewsHandler getAndroidViewsHandler$ui_release() {
        if (this._androidViewsHandler == null) {
            AndroidViewsHandler androidViewsHandler = new AndroidViewsHandler(getContext());
            this._androidViewsHandler = androidViewsHandler;
            addView(androidViewsHandler);
            requestLayout();
        }
        AndroidViewsHandler androidViewsHandler2 = this._androidViewsHandler;
        Intrinsics.checkNotNull(androidViewsHandler2);
        return androidViewsHandler2;
    }

    @Override // androidx.compose.p109ui.node.Owner
    @Nullable
    public Autofill getAutofill() {
        return this._autofill;
    }

    @Override // androidx.compose.p109ui.node.Owner
    @NotNull
    public AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    @NotNull
    public final Function1<Configuration, Unit> getConfigurationChangeObserver() {
        return this.configurationChangeObserver;
    }

    @NotNull
    /* JADX INFO: renamed from: getContentCaptureManager$ui_release, reason: from getter */
    public final AndroidContentCaptureManager getContentCaptureManager() {
        return this.contentCaptureManager;
    }

    @Override // androidx.compose.p109ui.node.Owner
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.compose.p109ui.node.Owner, androidx.compose.p109ui.node.RootForTest
    @NotNull
    public Density getDensity() {
        return (Density) this.density.getValue();
    }

    @Override // androidx.compose.p109ui.node.Owner
    @NotNull
    public DragAndDropManager getDragAndDropManager() {
        return this.dragAndDropManager;
    }

    @Override // androidx.compose.p109ui.node.Owner
    @Nullable
    /* JADX INFO: renamed from: getFocusDirection-P8AzH3I */
    public FocusDirection mo20145getFocusDirectionP8AzH3I(@NotNull android.view.KeyEvent keyEvent) {
        long jM19584getKeyZmokQxo = KeyEvent_androidKt.m19584getKeyZmokQxo(keyEvent);
        Key.Companion companion = Key.INSTANCE;
        if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo, companion.m19512getTabEK5gGoQ())) {
            return FocusDirection.m18193boximpl(KeyEvent_androidKt.m19590isShiftPressedZmokQxo(keyEvent) ? FocusDirection.INSTANCE.m18207getPreviousdhqQ8s() : FocusDirection.INSTANCE.m18206getNextdhqQ8s());
        }
        if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo, companion.m19353getDirectionRightEK5gGoQ())) {
            return FocusDirection.m18193boximpl(FocusDirection.INSTANCE.m18208getRightdhqQ8s());
        }
        if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo, companion.m19352getDirectionLeftEK5gGoQ())) {
            return FocusDirection.m18193boximpl(FocusDirection.INSTANCE.m18205getLeftdhqQ8s());
        }
        if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo, companion.m19354getDirectionUpEK5gGoQ()) ? true : Key.m19276equalsimpl0(jM19584getKeyZmokQxo, companion.m19465getPageUpEK5gGoQ())) {
            return FocusDirection.m18193boximpl(FocusDirection.INSTANCE.m18209getUpdhqQ8s());
        }
        if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo, companion.m19349getDirectionDownEK5gGoQ()) ? true : Key.m19276equalsimpl0(jM19584getKeyZmokQxo, companion.m19464getPageDownEK5gGoQ())) {
            return FocusDirection.m18193boximpl(FocusDirection.INSTANCE.m18202getDowndhqQ8s());
        }
        if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo, companion.m19348getDirectionCenterEK5gGoQ()) ? true : Key.m19276equalsimpl0(jM19584getKeyZmokQxo, companion.m19362getEnterEK5gGoQ()) ? true : Key.m19276equalsimpl0(jM19584getKeyZmokQxo, companion.m19454getNumPadEnterEK5gGoQ())) {
            return FocusDirection.m18193boximpl(FocusDirection.INSTANCE.m18203getEnterdhqQ8s());
        }
        if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo, companion.m19291getBackEK5gGoQ()) ? true : Key.m19276equalsimpl0(jM19584getKeyZmokQxo, companion.m19365getEscapeEK5gGoQ())) {
            return FocusDirection.m18193boximpl(FocusDirection.INSTANCE.m18204getExitdhqQ8s());
        }
        return null;
    }

    @Override // androidx.compose.p109ui.node.Owner
    @NotNull
    public FocusOwner getFocusOwner() {
        return this.focusOwner;
    }

    @Override // android.view.View
    public void getFocusedRect(@NotNull android.graphics.Rect rect) {
        Unit unit;
        Rect rectOnFetchFocusRect = onFetchFocusRect();
        if (rectOnFetchFocusRect != null) {
            rect.left = Math.round(rectOnFetchFocusRect.getLeft());
            rect.top = Math.round(rectOnFetchFocusRect.getTop());
            rect.right = Math.round(rectOnFetchFocusRect.getRight());
            rect.bottom = Math.round(rectOnFetchFocusRect.getBottom());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.getFocusedRect(rect);
        }
    }

    @Override // androidx.compose.p109ui.node.Owner
    @NotNull
    public FontFamily.Resolver getFontFamilyResolver() {
        return (FontFamily.Resolver) this.fontFamilyResolver.getValue();
    }

    @Override // androidx.compose.p109ui.node.Owner
    @NotNull
    public Font.ResourceLoader getFontLoader() {
        return this.fontLoader;
    }

    @Override // androidx.compose.p109ui.node.Owner
    @NotNull
    public GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    @Override // androidx.compose.p109ui.node.Owner
    @NotNull
    public HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    @Override // androidx.compose.p109ui.platform.ViewRootForTest
    public boolean getHasPendingMeasureOrLayout() {
        return this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout();
    }

    @Override // androidx.compose.p109ui.node.Owner
    @NotNull
    public InputModeManager getInputModeManager() {
        return this._inputModeManager;
    }

    /* JADX INFO: renamed from: getLastMatrixRecalculationAnimationTime$ui_release, reason: from getter */
    public final long getLastMatrixRecalculationAnimationTime() {
        return this.lastMatrixRecalculationAnimationTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View, android.view.ViewParent, androidx.compose.p109ui.node.Owner
    @NotNull
    public LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection.getValue();
    }

    @Override // androidx.compose.p109ui.node.Owner
    public long getMeasureIteration() {
        return this.measureAndLayoutDelegate.getMeasureIteration();
    }

    @Override // androidx.compose.p109ui.node.Owner
    @NotNull
    public ModifierLocalManager getModifierLocalManager() {
        return this.modifierLocalManager;
    }

    @Override // androidx.compose.p109ui.node.Owner
    @NotNull
    public Placeable.PlacementScope getPlacementScope() {
        return PlaceableKt.PlacementScope(this);
    }

    @Override // androidx.compose.p109ui.node.Owner
    @NotNull
    public PointerIconService getPointerIconService() {
        return this.pointerIconService;
    }

    @Override // androidx.compose.p109ui.node.Owner
    @NotNull
    public LayoutNode getRoot() {
        return this.root;
    }

    @Override // androidx.compose.p109ui.node.Owner
    @NotNull
    public RootForTest getRootForTest() {
        return this.rootForTest;
    }

    public final boolean getScrollCaptureInProgress$ui_release() {
        ScrollCapture scrollCapture;
        if (Build.VERSION.SDK_INT < 31 || (scrollCapture = this.scrollCapture) == null) {
            return false;
        }
        return scrollCapture.getScrollCaptureInProgress();
    }

    @Override // androidx.compose.p109ui.node.RootForTest
    @NotNull
    public SemanticsOwner getSemanticsOwner() {
        return this.semanticsOwner;
    }

    @Override // androidx.compose.p109ui.node.Owner
    @NotNull
    public LayoutNodeDrawScope getSharedDrawScope() {
        return this.sharedDrawScope;
    }

    @Override // androidx.compose.p109ui.node.Owner
    public boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    @Override // androidx.compose.p109ui.node.Owner
    @NotNull
    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.snapshotObserver;
    }

    @Override // androidx.compose.p109ui.node.Owner
    @NotNull
    public SoftwareKeyboardController getSoftwareKeyboardController() {
        return this.softwareKeyboardController;
    }

    @Override // androidx.compose.p109ui.node.Owner, androidx.compose.p109ui.node.RootForTest
    @NotNull
    public TextInputService getTextInputService() {
        return this.textInputService;
    }

    @Override // androidx.compose.p109ui.node.Owner
    @NotNull
    public TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    @Override // androidx.compose.p109ui.node.Owner
    @NotNull
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    @Nullable
    public final ViewTreeOwners getViewTreeOwners() {
        return (ViewTreeOwners) this.viewTreeOwners.getValue();
    }

    @Override // androidx.compose.p109ui.node.Owner
    @NotNull
    public WindowInfo getWindowInfo() {
        return this._windowInfo;
    }

    @Override // androidx.compose.p109ui.platform.ViewRootForTest
    public void invalidateDescendants() {
        invalidateLayers(getRoot());
    }

    @Override // androidx.compose.p109ui.platform.ViewRootForTest
    public boolean isLifecycleInResumedState() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        return ((viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) ? null : lifecycle.getState()) == Lifecycle.State.RESUMED;
    }

    @Override // androidx.compose.p109ui.input.pointer.PositionCalculator
    /* JADX INFO: renamed from: localToScreen-58bKbWc */
    public void mo19807localToScreen58bKbWc(@NotNull float[] localTransform) {
        recalculateWindowPosition();
        Matrix.m18773timesAssign58bKbWc(localTransform, this.viewToWindowMatrix);
        AndroidComposeView_androidKt.m20187preTranslatecG2Xzmc(localTransform, Offset.m18284getXimpl(this.windowPosition), Offset.m18285getYimpl(this.windowPosition), this.tmpMatrix);
    }

    @Override // androidx.compose.p109ui.input.pointer.PositionCalculator
    /* JADX INFO: renamed from: localToScreen-MK-Hz9U */
    public long mo19808localToScreenMKHz9U(long localPosition) {
        recalculateWindowPosition();
        long jM18762mapMKHz9U = Matrix.m18762mapMKHz9U(this.viewToWindowMatrix, localPosition);
        return OffsetKt.Offset(Offset.m18284getXimpl(this.windowPosition) + Offset.m18284getXimpl(jM18762mapMKHz9U), Offset.m18285getYimpl(this.windowPosition) + Offset.m18285getYimpl(jM18762mapMKHz9U));
    }

    @Override // androidx.compose.p109ui.node.Owner
    public void measureAndLayout(boolean sendPointerUpdate) {
        Function0<Unit> function0;
        if (this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout() || this.measureAndLayoutDelegate.getHasPendingOnPositionedCallbacks()) {
            Trace.beginSection("AndroidOwner:measureAndLayout");
            if (sendPointerUpdate) {
                try {
                    function0 = this.resendMotionEventOnLayout;
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            } else {
                function0 = null;
            }
            if (this.measureAndLayoutDelegate.measureAndLayout(function0)) {
                requestLayout();
            }
            MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
            dispatchPendingInteropLayoutCallbacks();
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
        }
    }

    @Override // androidx.compose.p109ui.node.Owner
    /* JADX INFO: renamed from: measureAndLayout-0kLqBqw */
    public void mo20146measureAndLayout0kLqBqw(@NotNull LayoutNode layoutNode, long constraints) {
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            this.measureAndLayoutDelegate.m20044measureAndLayout0kLqBqw(layoutNode, constraints);
            if (!this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout()) {
                MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
                dispatchPendingInteropLayoutCallbacks();
            }
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // androidx.compose.p109ui.node.RootForTest
    public void measureAndLayoutForTest() {
        Owner.measureAndLayout$default(this, false, 1, null);
    }

    public final void notifyLayerIsDirty$ui_release(@NotNull OwnedLayer layer, boolean isDirty) {
        if (!isDirty) {
            if (this.isDrawingContent) {
                return;
            }
            this.dirtyLayers.remove(layer);
            List<OwnedLayer> list = this.postponedDirtyLayers;
            if (list != null) {
                list.remove(layer);
                return;
            }
            return;
        }
        if (!this.isDrawingContent) {
            this.dirtyLayers.add(layer);
            return;
        }
        List arrayList = this.postponedDirtyLayers;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.postponedDirtyLayers = arrayList;
        }
        arrayList.add(layer);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        LifecycleOwner lifecycleOwner2;
        AndroidAutofill androidAutofill;
        super.onAttachedToWindow();
        this._windowInfo.setWindowFocused(hasWindowFocus());
        invalidateLayoutNodeMeasurement(getRoot());
        invalidateLayers(getRoot());
        getSnapshotObserver().startObserving$ui_release();
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.register(androidAutofill);
        }
        LifecycleOwner lifecycleOwner3 = ViewTreeLifecycleOwner.get(this);
        SavedStateRegistryOwner savedStateRegistryOwner = ViewTreeSavedStateRegistryOwner.get(this);
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        Lifecycle lifecycle2 = null;
        if (viewTreeOwners == null || (lifecycleOwner3 != null && savedStateRegistryOwner != null && (lifecycleOwner3 != viewTreeOwners.getLifecycleOwner() || savedStateRegistryOwner != viewTreeOwners.getLifecycleOwner()))) {
            if (lifecycleOwner3 == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
            }
            if (savedStateRegistryOwner == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
            }
            if (viewTreeOwners != null && (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                lifecycle.removeObserver(this);
            }
            lifecycleOwner3.getLifecycle().addObserver(this);
            ViewTreeOwners viewTreeOwners2 = new ViewTreeOwners(lifecycleOwner3, savedStateRegistryOwner);
            set_viewTreeOwners(viewTreeOwners2);
            Function1<? super ViewTreeOwners, Unit> function1 = this.onViewTreeOwnersAvailable;
            if (function1 != null) {
                function1.invoke(viewTreeOwners2);
            }
            this.onViewTreeOwnersAvailable = null;
        }
        this._inputModeManager.m19270setInputModeiuPiT84(isInTouchMode() ? InputMode.INSTANCE.m19267getTouchaOaMEAU() : InputMode.INSTANCE.m19266getKeyboardaOaMEAU());
        ViewTreeOwners viewTreeOwners3 = getViewTreeOwners();
        if (viewTreeOwners3 != null && (lifecycleOwner2 = viewTreeOwners3.getLifecycleOwner()) != null) {
            lifecycle2 = lifecycleOwner2.getLifecycle();
        }
        if (lifecycle2 == null) {
            throw AbstractC1974b.m1327t("No lifecycle owner exists");
        }
        lifecycle2.addObserver(this);
        lifecycle2.addObserver(this.contentCaptureManager);
        getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().addOnTouchModeChangeListener(this.touchModeChangeListener);
        if (Build.VERSION.SDK_INT >= 31) {
            AndroidComposeViewTranslationCallbackS.INSTANCE.setViewTranslationCallback(this);
        }
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) SessionMutex.m18137getCurrentSessionimpl(this.textInputSessionMutex);
        return androidPlatformTextInputSession == null ? this.legacyTextInputServiceAndroid.getEditorHasFocus() : androidPlatformTextInputSession.isReadyForConnection();
    }

    @Override // android.view.View
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setDensity(AndroidDensity_androidKt.Density(getContext()));
        if (getFontWeightAdjustmentCompat(newConfig) != this.currentFontWeightAdjustment) {
            this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(newConfig);
            setFontFamilyResolver(FontFamilyResolver_androidKt.createFontFamilyResolver(getContext()));
        }
        this.configurationChangeObserver.invoke(newConfig);
    }

    @Override // android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NotNull EditorInfo outAttrs) {
        AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) SessionMutex.m18137getCurrentSessionimpl(this.textInputSessionMutex);
        return androidPlatformTextInputSession == null ? this.legacyTextInputServiceAndroid.createInputConnection(outAttrs) : androidPlatformTextInputSession.createInputConnection(outAttrs);
    }

    @Override // android.view.View
    @RequiresApi(31)
    public void onCreateVirtualViewTranslationRequests(@NotNull long[] virtualIds, @NotNull int[] supportedFormats, @NotNull Consumer<ViewTranslationRequest> requestsCollector) {
        this.contentCaptureManager.onCreateVirtualViewTranslationRequests$ui_release(virtualIds, supportedFormats, requestsCollector);
    }

    @Override // androidx.compose.p109ui.node.Owner
    public void onDetach(@NotNull LayoutNode node) {
        this.measureAndLayoutDelegate.onNodeDetached(node);
        requestClearInvalidObservations();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        AndroidAutofill androidAutofill;
        LifecycleOwner lifecycleOwner;
        super.onDetachedFromWindow();
        getSnapshotObserver().stopObserving$ui_release();
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        Lifecycle lifecycle = (viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null) ? null : lifecycleOwner.getLifecycle();
        if (lifecycle == null) {
            throw AbstractC1974b.m1327t("No lifecycle owner exists");
        }
        lifecycle.removeObserver(this.contentCaptureManager);
        lifecycle.removeObserver(this);
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.unregister(androidAutofill);
        }
        getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().removeOnTouchModeChangeListener(this.touchModeChangeListener);
        if (Build.VERSION.SDK_INT >= 31) {
            AndroidComposeViewTranslationCallbackS.INSTANCE.clearViewTranslationCallback(this);
        }
    }

    @Override // androidx.compose.p109ui.node.Owner
    public void onEndApplyChanges() {
        if (this.observationClearRequested) {
            getSnapshotObserver().clearInvalidObservations$ui_release();
            this.observationClearRequested = false;
        }
        AndroidViewsHandler androidViewsHandler = this._androidViewsHandler;
        if (androidViewsHandler != null) {
            clearChildInvalidObservations(androidViewsHandler);
        }
        while (this.endApplyChangesListeners.isNotEmpty()) {
            int size = this.endApplyChangesListeners.getSize();
            for (int i = 0; i < size; i++) {
                Function0<Unit> function0 = this.endApplyChangesListeners.getContent()[i];
                this.endApplyChangesListeners.set(i, null);
                if (function0 != null) {
                    function0.invoke();
                }
            }
            this.endApplyChangesListeners.removeRange(0, size);
        }
    }

    @Override // android.view.View
    public void onFocusChanged(boolean gainFocus, int direction, @Nullable android.graphics.Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if (gainFocus || hasFocus()) {
            return;
        }
        getFocusOwner().releaseFocus();
    }

    @Override // androidx.compose.p109ui.node.Owner
    public void onInteropViewLayoutChange(@NotNull View view) {
        this.isPendingInteropViewLayoutChangeDispatch = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b) throws Throwable {
        this.measureAndLayoutDelegate.measureAndLayout(this.resendMotionEventOnLayout);
        this.onMeasureConstraints = null;
        updatePositionCacheAndDispatch();
        if (this._androidViewsHandler != null) {
            getAndroidViewsHandler$ui_release().layout(0, 0, r - l, b - t);
        }
    }

    @Override // androidx.compose.p109ui.node.Owner
    public void onLayoutChange(@NotNull LayoutNode layoutNode) {
        this.composeAccessibilityDelegate.onLayoutChange$ui_release(layoutNode);
        this.contentCaptureManager.onLayoutChange$ui_release(layoutNode);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                invalidateLayoutNodeMeasurement(getRoot());
            }
            long jM20169convertMeasureSpecI7RO_PI = m20169convertMeasureSpecI7RO_PI(widthMeasureSpec);
            int iM22389constructorimpl = (int) ULong.m22389constructorimpl(jM20169convertMeasureSpecI7RO_PI >>> 32);
            int iM22389constructorimpl2 = (int) ULong.m22389constructorimpl(jM20169convertMeasureSpecI7RO_PI & 4294967295L);
            long jM20169convertMeasureSpecI7RO_PI2 = m20169convertMeasureSpecI7RO_PI(heightMeasureSpec);
            long jM20929fitPrioritizingHeightZbe2FdA = Constraints.INSTANCE.m20929fitPrioritizingHeightZbe2FdA(iM22389constructorimpl, iM22389constructorimpl2, (int) ULong.m22389constructorimpl(jM20169convertMeasureSpecI7RO_PI2 >>> 32), (int) ULong.m22389constructorimpl(4294967295L & jM20169convertMeasureSpecI7RO_PI2));
            Constraints constraints = this.onMeasureConstraints;
            boolean zM20914equalsimpl0 = false;
            if (constraints == null) {
                this.onMeasureConstraints = Constraints.m20909boximpl(jM20929fitPrioritizingHeightZbe2FdA);
                this.wasMeasuredWithMultipleConstraints = false;
            } else {
                if (constraints != null) {
                    zM20914equalsimpl0 = Constraints.m20914equalsimpl0(constraints.getValue(), jM20929fitPrioritizingHeightZbe2FdA);
                }
                if (!zM20914equalsimpl0) {
                    this.wasMeasuredWithMultipleConstraints = true;
                }
            }
            this.measureAndLayoutDelegate.m20045updateRootConstraintsBRTryo0(jM20929fitPrioritizingHeightZbe2FdA);
            this.measureAndLayoutDelegate.measureOnly();
            setMeasuredDimension(getRoot().getWidth(), getRoot().getHeight());
            if (this._androidViewsHandler != null) {
                getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(getRoot().getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getRoot().getHeight(), 1073741824));
            }
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(@Nullable ViewStructure structure, int flags) {
        AndroidAutofill androidAutofill;
        if (!autofillSupported() || structure == null || (androidAutofill = this._autofill) == null) {
            return;
        }
        AndroidAutofill_androidKt.populateViewStructure(androidAutofill, structure);
    }

    @Override // androidx.compose.p109ui.node.Owner
    public void onRequestMeasure(@NotNull LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest, boolean scheduleMeasureAndLayout) {
        if (affectsLookahead) {
            if (this.measureAndLayoutDelegate.requestLookaheadRemeasure(layoutNode, forceRequest) && scheduleMeasureAndLayout) {
                scheduleMeasureAndLayout(layoutNode);
                return;
            }
            return;
        }
        if (this.measureAndLayoutDelegate.requestRemeasure(layoutNode, forceRequest) && scheduleMeasureAndLayout) {
            scheduleMeasureAndLayout(layoutNode);
        }
    }

    @Override // androidx.compose.p109ui.node.Owner
    public void onRequestRelayout(@NotNull LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest) {
        if (affectsLookahead) {
            if (this.measureAndLayoutDelegate.requestLookaheadRelayout(layoutNode, forceRequest)) {
                scheduleMeasureAndLayout$default(this, null, 1, null);
            }
        } else if (this.measureAndLayoutDelegate.requestRelayout(layoutNode, forceRequest)) {
            scheduleMeasureAndLayout$default(this, null, 1, null);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(@NotNull LifecycleOwner owner) {
        setShowLayoutBounds(INSTANCE.getIsShowingLayoutBounds());
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        if (this.superclassInitComplete) {
            LayoutDirection layoutDirection2 = FocusInteropUtils_androidKt.toLayoutDirection(layoutDirection);
            if (layoutDirection2 == null) {
                layoutDirection2 = LayoutDirection.Ltr;
            }
            setLayoutDirection(layoutDirection2);
        }
    }

    @Override // android.view.View
    public void onScrollCaptureSearch(@NotNull android.graphics.Rect localVisibleRect, @NotNull Point windowOffset, @NotNull Consumer<ScrollCaptureTarget> targets) {
        ScrollCapture scrollCapture;
        if (Build.VERSION.SDK_INT < 31 || (scrollCapture = this.scrollCapture) == null) {
            return;
        }
        scrollCapture.onScrollCaptureSearch(this, getSemanticsOwner(), getCoroutineContext(), targets);
    }

    @Override // androidx.compose.p109ui.node.Owner
    public void onSemanticsChange() {
        this.composeAccessibilityDelegate.onSemanticsChange$ui_release();
        this.contentCaptureManager.onSemanticsChange$ui_release();
    }

    @Override // android.view.View
    @RequiresApi(31)
    public void onVirtualViewTranslationResponses(@NotNull LongSparseArray<ViewTranslationResponse> response) {
        AndroidContentCaptureManager androidContentCaptureManager = this.contentCaptureManager;
        androidContentCaptureManager.onVirtualViewTranslationResponses$ui_release(androidContentCaptureManager, response);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        boolean isShowingLayoutBounds;
        this._windowInfo.setWindowFocused(hasWindowFocus);
        this.keyboardModifiersRequireUpdate = true;
        super.onWindowFocusChanged(hasWindowFocus);
        if (!hasWindowFocus || getShowLayoutBounds() == (isShowingLayoutBounds = INSTANCE.getIsShowingLayoutBounds())) {
            return;
        }
        setShowLayoutBounds(isShowingLayoutBounds);
        invalidateDescendants();
    }

    public final boolean recycle$ui_release(@NotNull OwnedLayer layer) {
        if (this.viewLayersContainer != null) {
            ViewLayer.INSTANCE.getShouldUseDispatchDraw();
        }
        this.layerCache.push(layer);
        return true;
    }

    @Override // androidx.compose.p109ui.node.Owner
    public void registerOnEndApplyChangesListener(@NotNull Function0<Unit> listener) {
        if (this.endApplyChangesListeners.contains(listener)) {
            return;
        }
        this.endApplyChangesListeners.add(listener);
    }

    @Override // androidx.compose.p109ui.node.Owner
    public void registerOnLayoutCompletedListener(@NotNull Owner.OnLayoutCompletedListener listener) {
        this.measureAndLayoutDelegate.registerOnLayoutCompletedListener(listener);
        scheduleMeasureAndLayout$default(this, null, 1, null);
    }

    public final void removeAndroidView(@NotNull final AndroidViewHolder view) {
        registerOnEndApplyChangesListener(new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView.removeAndroidView.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AndroidComposeView.this.getAndroidViewsHandler$ui_release().removeViewInLayout(view);
                HashMap<LayoutNode, AndroidViewHolder> layoutNodeToHolder = AndroidComposeView.this.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder();
                TypeIntrinsics.asMutableMap(layoutNodeToHolder).remove(AndroidComposeView.this.getAndroidViewsHandler$ui_release().getHolderToLayoutNode().remove(view));
                view.setImportantForAccessibility(0);
            }
        });
    }

    public final void requestClearInvalidObservations() {
        this.observationClearRequested = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int direction, @Nullable android.graphics.Rect previouslyFocusedRect) {
        if (isFocused()) {
            return true;
        }
        if (getFocusOwner().getRootState().getHasFocus()) {
            return super.requestFocus(direction, previouslyFocusedRect);
        }
        FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(direction);
        final int value = focusDirection != null ? focusDirection.getValue() : FocusDirection.INSTANCE.m18203getEnterdhqQ8s();
        Boolean boolMo18216focusSearchULY8qGw = getFocusOwner().mo18216focusSearchULY8qGw(value, previouslyFocusedRect != null ? RectHelper_androidKt.toComposeRect(previouslyFocusedRect) : null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView.requestFocus.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull FocusTargetNode focusTargetNode) {
                Boolean boolM18235requestFocusMxy_nc0 = FocusTransactionsKt.m18235requestFocusMxy_nc0(focusTargetNode, value);
                return Boolean.valueOf(boolM18235requestFocusMxy_nc0 != null ? boolM18235requestFocusMxy_nc0.booleanValue() : false);
            }
        });
        if (boolMo18216focusSearchULY8qGw != null) {
            return boolMo18216focusSearchULY8qGw.booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.p109ui.node.Owner
    public void requestOnPositionedCallback(@NotNull LayoutNode layoutNode) {
        this.measureAndLayoutDelegate.requestOnPositionedCallback(layoutNode);
        scheduleMeasureAndLayout$default(this, null, 1, null);
    }

    @Override // androidx.compose.p109ui.input.pointer.PositionCalculator
    /* JADX INFO: renamed from: screenToLocal-MK-Hz9U */
    public long mo19809screenToLocalMKHz9U(long positionOnScreen) {
        recalculateWindowPosition();
        return Matrix.m18762mapMKHz9U(this.windowToViewMatrix, OffsetKt.Offset(Offset.m18284getXimpl(positionOnScreen) - Offset.m18284getXimpl(this.windowPosition), Offset.m18285getYimpl(positionOnScreen) - Offset.m18285getYimpl(this.windowPosition)));
    }

    @Override // androidx.compose.p109ui.node.RootForTest
    /* JADX INFO: renamed from: sendKeyEvent-ZmokQxo */
    public boolean mo20147sendKeyEventZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
        return getFocusOwner().mo18214dispatchInterceptedSoftKeyboardEventZmokQxo(keyEvent) || FocusOwner.m18212dispatchKeyEventYhN2O0w$default(getFocusOwner(), keyEvent, null, 2, null);
    }

    @Override // androidx.compose.p109ui.node.RootForTest
    public void setAccessibilityEventBatchIntervalMillis(long intervalMillis) {
        this.composeAccessibilityDelegate.setSendRecurringAccessibilityEventsIntervalMillis$ui_release(intervalMillis);
    }

    public final void setConfigurationChangeObserver(@NotNull Function1<? super Configuration, Unit> function1) {
        this.configurationChangeObserver = function1;
    }

    public final void setContentCaptureManager$ui_release(@NotNull AndroidContentCaptureManager androidContentCaptureManager) {
        this.contentCaptureManager = androidContentCaptureManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    public void setCoroutineContext(@NotNull CoroutineContext coroutineContext) {
        this.coroutineContext = coroutineContext;
        DelegatableNode head = getRoot().getNodes().getHead();
        if (head instanceof SuspendingPointerInputModifierNode) {
            ((SuspendingPointerInputModifierNode) head).resetPointerInputHandler();
        }
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(16);
        if (!head.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtree called on an unattached node");
        }
        Modifier.Node child$ui_release = head.getNode().getChild();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(head);
        NestedVectorStack nestedVectorStack = new NestedVectorStack();
        while (layoutNodeRequireLayoutNode != null) {
            if (child$ui_release == null) {
                child$ui_release = layoutNodeRequireLayoutNode.getNodes().getHead();
            }
            if ((child$ui_release.getAggregateChildKindSet() & iM20090constructorimpl) != 0) {
                while (child$ui_release != null) {
                    if ((child$ui_release.getKindSet() & iM20090constructorimpl) != 0) {
                        Modifier.Node nodePop = child$ui_release;
                        MutableVector mutableVector = null;
                        while (nodePop != 0) {
                            if (nodePop instanceof PointerInputModifierNode) {
                                PointerInputModifierNode pointerInputModifierNode = (PointerInputModifierNode) nodePop;
                                if (pointerInputModifierNode instanceof SuspendingPointerInputModifierNode) {
                                    ((SuspendingPointerInputModifierNode) pointerInputModifierNode).resetPointerInputHandler();
                                }
                            } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate();
                                int i = 0;
                                nodePop = nodePop;
                                while (delegate$ui_release != null) {
                                    if ((delegate$ui_release.getKindSet() & iM20090constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            nodePop = delegate$ui_release;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != 0) {
                                                mutableVector.add(nodePop);
                                                nodePop = 0;
                                            }
                                            mutableVector.add(delegate$ui_release);
                                        }
                                    }
                                    delegate$ui_release = delegate$ui_release.getChild();
                                    nodePop = nodePop;
                                }
                                if (i == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    child$ui_release = child$ui_release.getChild();
                }
            }
            nestedVectorStack.push(layoutNodeRequireLayoutNode.get_children$ui_release());
            layoutNodeRequireLayoutNode = nestedVectorStack.isNotEmpty() ? (LayoutNode) nestedVectorStack.pop() : null;
            child$ui_release = null;
        }
    }

    public final void setLastMatrixRecalculationAnimationTime$ui_release(long j) {
        this.lastMatrixRecalculationAnimationTime = j;
    }

    public final void setOnViewTreeOwnersAvailable(@NotNull Function1<? super ViewTreeOwners, Unit> callback) {
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            callback.invoke(viewTreeOwners);
        }
        if (isAttachedToWindow()) {
            return;
        }
        this.onViewTreeOwnersAvailable = callback;
    }

    @Override // androidx.compose.p109ui.node.Owner
    public void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.p109ui.node.Owner
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object textInputSession(@NotNull Function2<? super PlatformTextInputSessionScope, ? super Continuation<?>, ? extends Object> function2, @NotNull Continuation<?> continuation) {
        C21381 c21381;
        if (continuation instanceof C21381) {
            c21381 = (C21381) continuation;
            int i = c21381.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c21381.label = i - Integer.MIN_VALUE;
            } else {
                c21381 = new C21381(continuation);
            }
        }
        Object obj = c21381.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c21381.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            AtomicReference atomicReference = this.textInputSessionMutex;
            Function1<CoroutineScope, AndroidPlatformTextInputSession> function1 = new Function1<CoroutineScope, AndroidPlatformTextInputSession>() { // from class: androidx.compose.ui.platform.AndroidComposeView.textInputSession.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final AndroidPlatformTextInputSession invoke(@NotNull CoroutineScope coroutineScope) {
                    AndroidComposeView androidComposeView = AndroidComposeView.this;
                    return new AndroidPlatformTextInputSession(androidComposeView, androidComposeView.getTextInputService(), coroutineScope);
                }
            };
            c21381.label = 1;
            if (SessionMutex.m18140withSessionCancellingPreviousimpl(atomicReference, function1, function2, c21381) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    @Override // android.view.ViewGroup
    public void addView(@Nullable View child, int index) {
        Intrinsics.checkNotNull(child);
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        addView(child, index, layoutParams);
    }

    @Override // androidx.compose.p109ui.node.Owner
    @NotNull
    public AndroidAccessibilityManager getAccessibilityManager() {
        return this.accessibilityManager;
    }

    @Override // androidx.compose.p109ui.node.Owner
    @NotNull
    public AndroidClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    @Override // android.view.ViewGroup
    public void addView(@Nullable View child, int width, int height) {
        ViewGroup.LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        layoutParamsGenerateDefaultLayoutParams.width = width;
        layoutParamsGenerateDefaultLayoutParams.height = height;
        Unit unit = Unit.INSTANCE;
        addView(child, -1, layoutParamsGenerateDefaultLayoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(@Nullable View child, @Nullable ViewGroup.LayoutParams params) {
        addView(child, -1, params);
    }

    @Override // android.view.ViewGroup
    public void addView(@Nullable View child, int index, @Nullable ViewGroup.LayoutParams params) {
        addViewInLayout(child, index, params, true);
    }

    @Deprecated(message = "fontLoader is deprecated, use fontFamilyResolver", replaceWith = @ReplaceWith(expression = "fontFamilyResolver", imports = {}))
    public static /* synthetic */ void getFontLoader$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    @Override // androidx.compose.p109ui.platform.ViewRootForTest
    @NotNull
    public View getView() {
        return this;
    }

    private final void recalculateWindowPosition(MotionEvent motionEvent) {
        this.lastMatrixRecalculationAnimationTime = AnimationUtils.currentAnimationTimeMillis();
        recalculateWindowViewTransforms();
        long jM18762mapMKHz9U = Matrix.m18762mapMKHz9U(this.viewToWindowMatrix, OffsetKt.Offset(motionEvent.getX(), motionEvent.getY()));
        this.windowPosition = OffsetKt.Offset(motionEvent.getRawX() - Offset.m18284getXimpl(jM18762mapMKHz9U), motionEvent.getRawY() - Offset.m18285getYimpl(jM18762mapMKHz9U));
    }

    @Override // androidx.compose.p109ui.node.Owner
    public void onAttach(@NotNull LayoutNode node) {
    }

    @Override // android.view.View
    public void onDraw(@NotNull android.graphics.Canvas canvas) {
    }
}
