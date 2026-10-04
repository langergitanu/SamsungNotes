package androidx.compose.p109ui.contentcapture;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.LongSparseArray;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.translation.TranslationRequestValue;
import android.view.translation.TranslationResponseValue;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArraySet;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.p109ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.node.LayoutNode;
import androidx.compose.p109ui.node.Owner;
import androidx.compose.p109ui.platform.AndroidComposeView;
import androidx.compose.p109ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.compose.p109ui.platform.SemanticsNodeCopy;
import androidx.compose.p109ui.platform.SemanticsNodeWithAdjustedBounds;
import androidx.compose.p109ui.platform.SemanticsUtils_androidKt;
import androidx.compose.p109ui.platform.coreshims.AutofillIdCompat;
import androidx.compose.p109ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.p109ui.platform.coreshims.ViewCompatShims;
import androidx.compose.p109ui.platform.coreshims.ViewStructureCompat;
import androidx.compose.p109ui.semantics.AccessibilityAction;
import androidx.compose.p109ui.semantics.Role;
import androidx.compose.p109ui.semantics.SemanticsActions;
import androidx.compose.p109ui.semantics.SemanticsConfiguration;
import androidx.compose.p109ui.semantics.SemanticsConfigurationKt;
import androidx.compose.p109ui.semantics.SemanticsNode;
import androidx.compose.p109ui.semantics.SemanticsProperties;
import androidx.compose.p109ui.semantics.SemanticsPropertyKey;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.TextLayoutInput;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.unit.TextUnit;
import androidx.compose.p109ui.util.ListUtilsKt;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.util.LongSparseArrayKt;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.LongIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p004A2.RunnableC0015b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002~\u007fB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010>\u001a\u00020\u000eH\u0080@¢\u0006\u0004\b?\u0010@J\u001a\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010E\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020CH\u0002J\u0016\u0010F\u001a\u00020\u000e2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\b\u0010H\u001a\u00020\u000eH\u0002J\b\u0010I\u001a\u00020\u000eH\u0002J\b\u0010J\u001a\u00020\u000eH\u0002J\u0010\u0010K\u001a\u00020\u000e2\u0006\u0010L\u001a\u000209H\u0002J\r\u0010M\u001a\u00020\u000eH\u0000¢\u0006\u0002\bNJ-\u0010O\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020S2\u000e\u0010T\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010V0UH\u0001¢\u0006\u0002\bWJ\r\u0010X\u001a\u00020\u000eH\u0000¢\u0006\u0002\bYJ\u0015\u0010Z\u001a\u00020\u000e2\u0006\u0010L\u001a\u000209H\u0000¢\u0006\u0002\b[J\r\u0010\\\u001a\u00020\u000eH\u0000¢\u0006\u0002\b]J\r\u0010^\u001a\u00020\u000eH\u0000¢\u0006\u0002\b_J\u0010\u0010`\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020bH\u0016J\u0010\u0010c\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020bH\u0016J\u0010\u0010d\u001a\u00020\u000e2\u0006\u0010e\u001a\u00020fH\u0016J\u0010\u0010g\u001a\u00020\u000e2\u0006\u0010e\u001a\u00020fH\u0016J%\u0010h\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00002\u000e\u0010j\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010l0kH\u0001¢\u0006\u0002\bmJ\u0018\u0010n\u001a\u00020\u000e2\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u000205H\u0002J\u0018\u0010r\u001a\u00020\u000e2\u0006\u0010s\u001a\u00020C2\u0006\u0010t\u001a\u00020uH\u0002J\u0018\u0010v\u001a\u00020\u000e2\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u000205H\u0002J\b\u0010w\u001a\u00020\u000eH\u0002J\u0010\u0010x\u001a\u00020\u000e2\u0006\u0010y\u001a\u00020pH\u0002J\u0010\u0010z\u001a\u00020\u000e2\u0006\u0010y\u001a\u00020pH\u0002J\b\u0010{\u001a\u00020\u000eH\u0002J\u0010\u0010|\u001a\u00020\u000e2\u0006\u0010y\u001a\u00020pH\u0002J\u000e\u0010}\u001a\u0004\u0018\u00010\u0011*\u00020pH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 8@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020)X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u00158@X\u0080\u0004¢\u0006\f\u0012\u0004\b-\u0010\u001a\u001a\u0004\b.\u0010/R\"\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u00104\u001a\b\u0012\u0004\u0012\u0002050\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020908X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=¨\u0006\u0080\u0001"}, m13886d2 = {"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "Landroidx/compose/ui/contentcapture/ContentCaptureManager;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroid/view/View$OnAttachStateChangeListener;", "view", "Landroidx/compose/ui/platform/AndroidComposeView;", "onContentCaptureSession", "Lkotlin/Function0;", "Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "(Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function0;)V", "SendRecurringContentCaptureEventsIntervalMillis", "", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "", "bufferedAppearedNodes", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/platform/coreshims/ViewStructureCompat;", "bufferedDisappearedNodes", "Landroidx/collection/MutableIntSet;", "checkingForSemanticsChanges", "", "contentCaptureChangeChecker", "Ljava/lang/Runnable;", "contentCaptureSession", "getContentCaptureSession$ui_release$annotations", "()V", "getContentCaptureSession$ui_release", "()Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "setContentCaptureSession$ui_release", "(Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;)V", "currentSemanticsNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "getCurrentSemanticsNodes$ui_release", "()Landroidx/collection/IntObjectMap;", "setCurrentSemanticsNodes$ui_release", "(Landroidx/collection/IntObjectMap;)V", "currentSemanticsNodesInvalidated", "currentSemanticsNodesSnapshotTimestampMillis", "handler", "Landroid/os/Handler;", "getHandler$ui_release", "()Landroid/os/Handler;", "isEnabled", "isEnabled$ui_release$annotations", "isEnabled$ui_release", "()Z", "getOnContentCaptureSession", "()Lkotlin/jvm/functions/Function0;", "setOnContentCaptureSession", "(Lkotlin/jvm/functions/Function0;)V", "previousSemanticsNodes", "Landroidx/compose/ui/platform/SemanticsNodeCopy;", "previousSemanticsRoot", "subtreeChangedLayoutNodes", "Landroidx/collection/ArraySet;", "Landroidx/compose/ui/node/LayoutNode;", "translateStatus", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$TranslateStatus;", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "boundsUpdatesEventLoop", "boundsUpdatesEventLoop$ui_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bufferContentCaptureViewAppeared", "virtualId", "", "viewStructure", "bufferContentCaptureViewDisappeared", "checkForContentCapturePropertyChanges", "newSemanticsNodes", "clearTranslatedText", "hideTranslatedText", "notifyContentCaptureChanges", "notifySubtreeStateChangeIfNeeded", "layoutNode", "onClearTranslation", "onClearTranslation$ui_release", "onCreateVirtualViewTranslationRequests", "virtualIds", "", "supportedFormats", "", "requestsCollector", "Ljava/util/function/Consumer;", "Landroid/view/translation/ViewTranslationRequest;", "onCreateVirtualViewTranslationRequests$ui_release", "onHideTranslation", "onHideTranslation$ui_release", "onLayoutChange", "onLayoutChange$ui_release", "onSemanticsChange", "onSemanticsChange$ui_release", "onShowTranslation", "onShowTranslation$ui_release", "onStart", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStop", "onViewAttachedToWindow", VPathDataCmd.RCurveTo, "Landroid/view/View;", "onViewDetachedFromWindow", "onVirtualViewTranslationResponses", "contentCaptureManager", "response", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "onVirtualViewTranslationResponses$ui_release", "sendContentCaptureStructureChangeEvents", "newNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "oldNode", "sendContentCaptureTextUpdateEvent", "id", "newText", "", "sendSemanticsStructureChangeEvents", "showTranslatedText", "updateBuffersOnAppeared", "node", "updateBuffersOnDisappeared", "updateSemanticsCopy", "updateTranslationOnAppeared", "toViewStructure", "TranslateStatus", "ViewTranslationHelperMethods", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAndroidContentCaptureManager.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidContentCaptureManager.android.kt\nandroidx/compose/ui/contentcapture/AndroidContentCaptureManager\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 3 IntSet.kt\nandroidx/collection/IntSet\n+ 4 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 5 InlineClassHelper.kt\nandroidx/compose/ui/internal/InlineClassHelperKt\n+ 6 IntObjectMap.kt\nandroidx/collection/IntObjectMap\n*L\n1#1,650:1\n33#2,6:651\n33#2,4:684\n38#2:697\n33#2,6:698\n33#2,4:729\n38#2:742\n151#2,3:837\n33#2,4:840\n154#2,2:844\n38#2:846\n156#2:847\n151#2,3:875\n33#2,4:878\n154#2,2:882\n38#2:884\n156#2:885\n33#2,6:886\n33#2,6:892\n262#3,4:657\n232#3,7:661\n243#3,3:669\n246#3,2:673\n266#3,2:675\n249#3,6:677\n268#3:683\n262#3,4:848\n232#3,7:852\n243#3,3:860\n246#3,2:864\n266#3,2:866\n249#3,6:868\n268#3:874\n1810#4:668\n1672#4:672\n1810#4:713\n1672#4:717\n1810#4:752\n1672#4:756\n1810#4:796\n1672#4:800\n1810#4:821\n1672#4:825\n1810#4:859\n1672#4:863\n1810#4:907\n1672#4:911\n1810#4:932\n1672#4:936\n1810#4:957\n1672#4:961\n66#5,9:688\n66#5,9:733\n66#5,9:760\n66#5,9:777\n396#6,3:704\n354#6,6:707\n364#6,3:714\n367#6,2:718\n399#6,2:720\n370#6,6:722\n401#6:728\n396#6,3:743\n354#6,6:746\n364#6,3:753\n367#6,2:757\n399#6:759\n400#6:769\n370#6,6:770\n401#6:776\n382#6,4:786\n354#6,6:790\n364#6,3:797\n367#6,2:801\n387#6,2:803\n370#6,6:805\n389#6:811\n408#6,3:812\n354#6,6:815\n364#6,3:822\n367#6,2:826\n412#6,2:828\n370#6,6:830\n414#6:836\n408#6,3:898\n354#6,6:901\n364#6,3:908\n367#6,2:912\n412#6,2:914\n370#6,6:916\n414#6:922\n408#6,3:923\n354#6,6:926\n364#6,3:933\n367#6,2:937\n412#6,2:939\n370#6,6:941\n414#6:947\n408#6,3:948\n354#6,6:951\n364#6,3:958\n367#6,2:962\n412#6,2:964\n370#6,6:966\n414#6:972\n*S KotlinDebug\n*F\n+ 1 AndroidContentCaptureManager.android.kt\nandroidx/compose/ui/contentcapture/AndroidContentCaptureManager\n*L\n235#1:651,6\n253#1:684,4\n253#1:697\n268#1:698,6\n281#1:729,4\n281#1:742\n458#1:837,3\n458#1:840,4\n458#1:844,2\n458#1:846\n458#1:847\n466#1:875,3\n466#1:878,4\n466#1:882,2\n466#1:884\n466#1:885\n480#1:886,6\n488#1:892,6\n246#1:657,4\n246#1:661,7\n246#1:669,3\n246#1:673,2\n246#1:675,2\n246#1:677,6\n246#1:683\n464#1:848,4\n464#1:852,7\n464#1:860,3\n464#1:864,2\n464#1:866,2\n464#1:868,6\n464#1:874\n246#1:668\n246#1:672\n275#1:713\n275#1:717\n296#1:752\n296#1:756\n345#1:796\n345#1:800\n456#1:821\n456#1:825\n464#1:859\n464#1:863\n526#1:907\n526#1:911\n537#1:932\n537#1:936\n548#1:957\n548#1:961\n255#1:688,9\n284#1:733,9\n300#1:760,9\n338#1:777,9\n275#1:704,3\n275#1:707,6\n275#1:714,3\n275#1:718,2\n275#1:720,2\n275#1:722,6\n275#1:728\n296#1:743,3\n296#1:746,6\n296#1:753,3\n296#1:757,2\n296#1:759\n296#1:769\n296#1:770,6\n296#1:776\n345#1:786,4\n345#1:790,6\n345#1:797,3\n345#1:801,2\n345#1:803,2\n345#1:805,6\n345#1:811\n456#1:812,3\n456#1:815,6\n456#1:822,3\n456#1:826,2\n456#1:828,2\n456#1:830,6\n456#1:836\n526#1:898,3\n526#1:901,6\n526#1:908,3\n526#1:912,2\n526#1:914,2\n526#1:916,6\n526#1:922\n537#1:923,3\n537#1:926,6\n537#1:933,3\n537#1:937,2\n537#1:939,2\n537#1:941,6\n537#1:947\n548#1:948,3\n548#1:951,6\n548#1:958,3\n548#1:962,2\n548#1:964,2\n548#1:966,6\n548#1:972\n*E\n"})
public final class AndroidContentCaptureManager implements ContentCaptureManager, DefaultLifecycleObserver, View.OnAttachStateChangeListener {
    public static final int $stable = 8;

    @NotNull
    private final MutableIntObjectMap<ViewStructureCompat> bufferedAppearedNodes;

    @NotNull
    private final MutableIntSet bufferedDisappearedNodes;
    private boolean checkingForSemanticsChanges;

    @Nullable
    private ContentCaptureSessionCompat contentCaptureSession;
    private long currentSemanticsNodesSnapshotTimestampMillis;

    @NotNull
    private Function0<? extends ContentCaptureSessionCompat> onContentCaptureSession;

    @NotNull
    private SemanticsNodeCopy previousSemanticsRoot;

    @NotNull
    private final ArraySet<LayoutNode> subtreeChangedLayoutNodes;

    @NotNull
    private final AndroidComposeView view;
    private long SendRecurringContentCaptureEventsIntervalMillis = 100;

    @NotNull
    private TranslateStatus translateStatus = TranslateStatus.SHOW_ORIGINAL;
    private boolean currentSemanticsNodesInvalidated = true;

    @NotNull
    private final Channel<Unit> boundsUpdateChannel = ChannelKt.Channel$default(1, null, null, 6, null);

    @NotNull
    private final Handler handler = new Handler(Looper.getMainLooper());

    @NotNull
    private IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes = IntObjectMapKt.intObjectMapOf();

    @NotNull
    private MutableIntObjectMap<SemanticsNodeCopy> previousSemanticsNodes = IntObjectMapKt.mutableIntObjectMapOf();

    @NotNull
    private final Runnable contentCaptureChangeChecker = new RunnableC0015b(this, 19);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m13886d2 = {"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$TranslateStatus;", "", "(Ljava/lang/String;I)V", "SHOW_ORIGINAL", "SHOW_TRANSLATED", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public enum TranslateStatus {
        SHOW_ORIGINAL,
        SHOW_TRANSLATED
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0002J0\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010H\u0007J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0007¨\u0006\u0013"}, m13886d2 = {"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$ViewTranslationHelperMethods;", "", "()V", "doTranslation", "", "contentCaptureManager", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "response", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "onCreateVirtualViewTranslationRequests", "virtualIds", "", "supportedFormats", "", "requestsCollector", "Ljava/util/function/Consumer;", "Landroid/view/translation/ViewTranslationRequest;", "onVirtualViewTranslationResponses", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @RequiresApi(31)
    @SourceDebugExtension({"SMAP\nAndroidContentCaptureManager.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidContentCaptureManager.android.kt\nandroidx/compose/ui/contentcapture/AndroidContentCaptureManager$ViewTranslationHelperMethods\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,650:1\n13607#2,2:651\n*S KotlinDebug\n*F\n+ 1 AndroidContentCaptureManager.android.kt\nandroidx/compose/ui/contentcapture/AndroidContentCaptureManager$ViewTranslationHelperMethods\n*L\n568#1:651,2\n*E\n"})
    public static final class ViewTranslationHelperMethods {

        @NotNull
        public static final ViewTranslationHelperMethods INSTANCE = new ViewTranslationHelperMethods();

        private ViewTranslationHelperMethods() {
        }

        private final void doTranslation(AndroidContentCaptureManager contentCaptureManager, LongSparseArray<ViewTranslationResponse> response) {
            TranslationResponseValue value;
            CharSequence text;
            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds;
            SemanticsNode semanticsNode;
            AccessibilityAction accessibilityAction;
            Function1 function1;
            LongIterator longIteratorKeyIterator = LongSparseArrayKt.keyIterator(response);
            while (longIteratorKeyIterator.hasNext()) {
                long jNextLong = longIteratorKeyIterator.nextLong();
                ViewTranslationResponse viewTranslationResponseM1361r = AbstractC2027a.m1361r(response.get(jNextLong));
                if (viewTranslationResponseM1361r != null && (value = viewTranslationResponseM1361r.getValue("android:text")) != null && (text = value.getText()) != null && (semanticsNodeWithAdjustedBounds = contentCaptureManager.getCurrentSemanticsNodes$ui_release().get((int) jNextLong)) != null && (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) != null && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetTextSubstitution())) != null && (function1 = (Function1) accessibilityAction.getAction()) != null) {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onVirtualViewTranslationResponses$lambda$1(AndroidContentCaptureManager androidContentCaptureManager, LongSparseArray longSparseArray) {
            INSTANCE.doTranslation(androidContentCaptureManager, longSparseArray);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0070  */
        @DoNotInline
        @RequiresApi(31)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onCreateVirtualViewTranslationRequests(@NotNull AndroidContentCaptureManager contentCaptureManager, @NotNull long[] virtualIds, @NotNull int[] supportedFormats, @NotNull Consumer<ViewTranslationRequest> requestsCollector) {
            SemanticsNode semanticsNode;
            String strFastJoinToString$default;
            for (long j : virtualIds) {
                SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = contentCaptureManager.getCurrentSemanticsNodes$ui_release().get((int) j);
                if (semanticsNodeWithAdjustedBounds != null && (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) != null) {
                    AbstractC2027a.m1363t();
                    ViewTranslationRequest.Builder builderM1359p = AbstractC2027a.m1359p(contentCaptureManager.getView().getAutofillId(), semanticsNode.getId());
                    List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getText());
                    if (list != null && (strFastJoinToString$default = ListUtilsKt.fastJoinToString$default(list, "\n", null, null, 0, null, null, 62, null)) != null) {
                        builderM1359p.setValue("android:text", TranslationRequestValue.forText(new AnnotatedString(strFastJoinToString$default, null, null, 6, null)));
                        requestsCollector.accept(builderM1359p.build());
                    }
                }
            }
        }

        @DoNotInline
        @RequiresApi(31)
        public final void onVirtualViewTranslationResponses(@NotNull final AndroidContentCaptureManager contentCaptureManager, @NotNull final LongSparseArray<ViewTranslationResponse> response) {
            if (Build.VERSION.SDK_INT < 31) {
                return;
            }
            if (Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
                doTranslation(contentCaptureManager, response);
            } else {
                contentCaptureManager.getView().post(new Runnable() { // from class: androidx.compose.ui.contentcapture.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        AndroidContentCaptureManager.ViewTranslationHelperMethods.onVirtualViewTranslationResponses$lambda$1(contentCaptureManager, response);
                    }
                });
            }
        }
    }

    public AndroidContentCaptureManager(@NotNull AndroidComposeView androidComposeView, @NotNull Function0<? extends ContentCaptureSessionCompat> function0) {
        this.view = androidComposeView;
        this.onContentCaptureSession = function0;
        int i = 0;
        int i2 = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.bufferedAppearedNodes = new MutableIntObjectMap<>(i, i2, defaultConstructorMarker);
        this.bufferedDisappearedNodes = new MutableIntSet(i, i2, defaultConstructorMarker);
        this.subtreeChangedLayoutNodes = new ArraySet<>(i, i2, defaultConstructorMarker);
        this.previousSemanticsRoot = new SemanticsNodeCopy(androidComposeView.getSemanticsOwner().getUnmergedRootSemanticsNode(), IntObjectMapKt.intObjectMapOf());
    }

    private final void bufferContentCaptureViewAppeared(int virtualId, ViewStructureCompat viewStructure) {
        if (viewStructure == null) {
            return;
        }
        if (this.bufferedDisappearedNodes.contains(virtualId)) {
            this.bufferedDisappearedNodes.remove(virtualId);
        } else {
            this.bufferedAppearedNodes.set(virtualId, viewStructure);
        }
    }

    private final void bufferContentCaptureViewDisappeared(int virtualId) {
        if (this.bufferedAppearedNodes.containsKey(virtualId)) {
            this.bufferedAppearedNodes.remove(virtualId);
        } else {
            this.bufferedDisappearedNodes.add(virtualId);
        }
    }

    private final void checkForContentCapturePropertyChanges(IntObjectMap<SemanticsNodeWithAdjustedBounds> newSemanticsNodes) {
        int[] iArr = newSemanticsNodes.keys;
        long[] jArr = newSemanticsNodes.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8;
                int i4 = 8 - ((~(i - length)) >>> 31);
                int i5 = 0;
                while (i5 < i4) {
                    if ((255 & j) < 128) {
                        int i6 = iArr[(i << 3) + i5];
                        SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(i6);
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = newSemanticsNodes.get(i6);
                        SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
                        if (semanticsNode == null) {
                            throw AbstractC1974b.m1327t("no value for specified key");
                        }
                        if (semanticsNodeCopy == null) {
                            Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> it = semanticsNode.getUnmergedConfig().iterator();
                            while (it.hasNext()) {
                                SemanticsPropertyKey<?> key = it.next().getKey();
                                SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
                                if (Intrinsics.areEqual(key, semanticsProperties.getText())) {
                                    List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsProperties.getText());
                                    sendContentCaptureTextUpdateEvent(semanticsNode.getId(), String.valueOf(list != null ? (AnnotatedString) CollectionsKt.firstOrNull(list) : null));
                                }
                            }
                        } else {
                            Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> it2 = semanticsNode.getUnmergedConfig().iterator();
                            while (it2.hasNext()) {
                                SemanticsPropertyKey<?> key2 = it2.next().getKey();
                                SemanticsProperties semanticsProperties2 = SemanticsProperties.INSTANCE;
                                if (Intrinsics.areEqual(key2, semanticsProperties2.getText())) {
                                    List list2 = (List) SemanticsConfigurationKt.getOrNull(semanticsNodeCopy.getUnmergedConfig(), semanticsProperties2.getText());
                                    AnnotatedString annotatedString = list2 != null ? (AnnotatedString) CollectionsKt.firstOrNull(list2) : null;
                                    int i7 = i2;
                                    List list3 = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsProperties2.getText());
                                    AnnotatedString annotatedString2 = list3 != null ? (AnnotatedString) CollectionsKt.firstOrNull(list3) : null;
                                    if (!Intrinsics.areEqual(annotatedString, annotatedString2)) {
                                        sendContentCaptureTextUpdateEvent(semanticsNode.getId(), String.valueOf(annotatedString2));
                                    }
                                    i2 = i7;
                                }
                            }
                        }
                    }
                    int i8 = i2;
                    j >>= i8;
                    i5++;
                    i2 = i8;
                }
                if (i4 != i2) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    private final void clearTranslatedText() {
        AccessibilityAction accessibilityAction;
        Function0 function0;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes$ui_release = getCurrentSemanticsNodes$ui_release();
        Object[] objArr = currentSemanticsNodes$ui_release.values;
        long[] jArr = currentSemanticsNodes$ui_release.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i2; i4++) {
                    if ((255 & j) < 128) {
                        SemanticsConfiguration unmergedConfig$ui_release = ((SemanticsNodeWithAdjustedBounds) objArr[(i << 3) + i4]).getSemanticsNode().getUnmergedConfig();
                        if (SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution()) != null && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsActions.INSTANCE.getClearTextSubstitution())) != null && (function0 = (Function0) accessibilityAction.getAction()) != null) {
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void contentCaptureChangeChecker$lambda$0(AndroidContentCaptureManager androidContentCaptureManager) {
        if (androidContentCaptureManager.isEnabled$ui_release()) {
            Owner.measureAndLayout$default(androidContentCaptureManager.view, false, 1, null);
            androidContentCaptureManager.sendSemanticsStructureChangeEvents(androidContentCaptureManager.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), androidContentCaptureManager.previousSemanticsRoot);
            androidContentCaptureManager.sendContentCaptureStructureChangeEvents(androidContentCaptureManager.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), androidContentCaptureManager.previousSemanticsRoot);
            androidContentCaptureManager.checkForContentCapturePropertyChanges(androidContentCaptureManager.getCurrentSemanticsNodes$ui_release());
            androidContentCaptureManager.updateSemanticsCopy();
            androidContentCaptureManager.checkingForSemanticsChanges = false;
        }
    }

    private final void hideTranslatedText() {
        AccessibilityAction accessibilityAction;
        Function1 function1;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes$ui_release = getCurrentSemanticsNodes$ui_release();
        Object[] objArr = currentSemanticsNodes$ui_release.values;
        long[] jArr = currentSemanticsNodes$ui_release.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i2; i4++) {
                    if ((255 & j) < 128) {
                        SemanticsConfiguration unmergedConfig$ui_release = ((SemanticsNodeWithAdjustedBounds) objArr[(i << 3) + i4]).getSemanticsNode().getUnmergedConfig();
                        if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution()), Boolean.TRUE) && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsActions.INSTANCE.getShowTextSubstitution())) != null && (function1 = (Function1) accessibilityAction.getAction()) != null) {
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void notifyContentCaptureChanges() {
        char c;
        long j;
        long j2;
        char c2;
        ContentCaptureSessionCompat contentCaptureSessionCompat = this.contentCaptureSession;
        if (contentCaptureSessionCompat != null && Build.VERSION.SDK_INT >= 29) {
            char c4 = 7;
            if (this.bufferedAppearedNodes.isNotEmpty()) {
                ArrayList arrayList = new ArrayList();
                MutableIntObjectMap<ViewStructureCompat> mutableIntObjectMap = this.bufferedAppearedNodes;
                Object[] objArr = mutableIntObjectMap.values;
                long[] jArr = mutableIntObjectMap.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    j = 128;
                    while (true) {
                        long j3 = jArr[i];
                        j2 = 255;
                        if ((((~j3) << c4) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            int i4 = 0;
                            while (i4 < i2) {
                                if ((j3 & 255) < 128) {
                                    c2 = c4;
                                    arrayList.add((ViewStructureCompat) objArr[(i << 3) + i4]);
                                } else {
                                    c2 = c4;
                                }
                                j3 >>= 8;
                                i4++;
                                c4 = c2;
                            }
                            c = c4;
                            if (i2 != 8) {
                                break;
                            }
                        } else {
                            c = c4;
                        }
                        if (i == length) {
                            break;
                        }
                        i++;
                        c4 = c;
                    }
                } else {
                    c = 7;
                    j = 128;
                    j2 = 255;
                }
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    arrayList2.add(((ViewStructureCompat) arrayList.get(i5)).toViewStructure());
                }
                contentCaptureSessionCompat.notifyViewsAppeared(arrayList2);
                this.bufferedAppearedNodes.clear();
            } else {
                c = 7;
                j = 128;
                j2 = 255;
            }
            if (this.bufferedDisappearedNodes.isNotEmpty()) {
                ArrayList arrayList3 = new ArrayList();
                MutableIntSet mutableIntSet = this.bufferedDisappearedNodes;
                int[] iArr = mutableIntSet.elements;
                long[] jArr2 = mutableIntSet.metadata;
                int length2 = jArr2.length - 2;
                if (length2 >= 0) {
                    int i6 = 0;
                    while (true) {
                        long j5 = jArr2[i6];
                        if ((((~j5) << c) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i7 = 8 - ((~(i6 - length2)) >>> 31);
                            for (int i8 = 0; i8 < i7; i8++) {
                                if ((j5 & j2) < j) {
                                    arrayList3.add(Integer.valueOf(iArr[(i6 << 3) + i8]));
                                }
                                j5 >>= 8;
                            }
                            if (i7 != 8) {
                                break;
                            } else if (i6 == length2) {
                                break;
                            } else {
                                i6++;
                            }
                        }
                    }
                }
                ArrayList arrayList4 = new ArrayList(arrayList3.size());
                int size2 = arrayList3.size();
                for (int i9 = 0; i9 < size2; i9++) {
                    arrayList4.add(Long.valueOf(((Number) arrayList3.get(i9)).intValue()));
                }
                contentCaptureSessionCompat.notifyViewsDisappeared(CollectionsKt.toLongArray(arrayList4));
                this.bufferedDisappearedNodes.clear();
            }
        }
    }

    private final void notifySubtreeStateChangeIfNeeded(LayoutNode layoutNode) {
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.mo23705trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void sendContentCaptureStructureChangeEvents(SemanticsNode newNode, SemanticsNodeCopy oldNode) {
        List<SemanticsNode> replacedChildren$ui_release = newNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int i = 0; i < size; i++) {
            SemanticsNode semanticsNode = replacedChildren$ui_release.get(i);
            if (getCurrentSemanticsNodes$ui_release().contains(semanticsNode.getId()) && !oldNode.getChildren().contains(semanticsNode.getId())) {
                updateBuffersOnAppeared(semanticsNode);
            }
        }
        MutableIntObjectMap<SemanticsNodeCopy> mutableIntObjectMap = this.previousSemanticsNodes;
        int[] iArr = mutableIntObjectMap.keys;
        long[] jArr = mutableIntObjectMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((255 & j) < 128) {
                            int i6 = iArr[(i2 << 3) + i5];
                            if (!getCurrentSemanticsNodes$ui_release().contains(i6)) {
                                bufferContentCaptureViewDisappeared(i6);
                            }
                        }
                        j >>= 8;
                    }
                    if (i4 != 8) {
                        break;
                    } else if (i2 == length) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        List<SemanticsNode> replacedChildren$ui_release2 = newNode.getReplacedChildren$ui_release();
        int size2 = replacedChildren$ui_release2.size();
        for (int i7 = 0; i7 < size2; i7++) {
            SemanticsNode semanticsNode2 = replacedChildren$ui_release2.get(i7);
            if (getCurrentSemanticsNodes$ui_release().contains(semanticsNode2.getId()) && this.previousSemanticsNodes.contains(semanticsNode2.getId())) {
                SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(semanticsNode2.getId());
                if (semanticsNodeCopy == null) {
                    throw AbstractC1974b.m1327t("node not present in pruned tree before this change");
                }
                sendContentCaptureStructureChangeEvents(semanticsNode2, semanticsNodeCopy);
            }
        }
    }

    private final void sendContentCaptureTextUpdateEvent(int id, String newText) {
        ContentCaptureSessionCompat contentCaptureSessionCompat;
        if (Build.VERSION.SDK_INT >= 29 && (contentCaptureSessionCompat = this.contentCaptureSession) != null) {
            AutofillId autofillIdNewAutofillId = contentCaptureSessionCompat.newAutofillId(id);
            if (autofillIdNewAutofillId == null) {
                throw AbstractC1974b.m1327t("Invalid content capture ID");
            }
            contentCaptureSessionCompat.notifyViewTextChanged(autofillIdNewAutofillId, newText);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void sendSemanticsStructureChangeEvents(SemanticsNode newNode, SemanticsNodeCopy oldNode) {
        int i = 0;
        MutableIntSet mutableIntSet = new MutableIntSet(i, 1, null);
        List<SemanticsNode> replacedChildren$ui_release = newNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int i2 = 0; i2 < size; i2++) {
            SemanticsNode semanticsNode = replacedChildren$ui_release.get(i2);
            if (getCurrentSemanticsNodes$ui_release().contains(semanticsNode.getId())) {
                if (!oldNode.getChildren().contains(semanticsNode.getId())) {
                    notifySubtreeStateChangeIfNeeded(newNode.getLayoutNode());
                    return;
                }
                mutableIntSet.add(semanticsNode.getId());
            }
        }
        MutableIntSet children = oldNode.getChildren();
        int[] iArr = children.elements;
        long[] jArr = children.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i4 = 0;
            while (true) {
                long j = jArr[i4];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8 - ((~(i4 - length)) >>> 31);
                    for (int i6 = 0; i6 < i5; i6++) {
                        if ((255 & j) < 128 && !mutableIntSet.contains(iArr[(i4 << 3) + i6])) {
                            notifySubtreeStateChangeIfNeeded(newNode.getLayoutNode());
                            return;
                        }
                        j >>= 8;
                    }
                    if (i5 != 8) {
                        break;
                    } else if (i4 == length) {
                        break;
                    } else {
                        i4++;
                    }
                }
            }
        }
        List<SemanticsNode> replacedChildren$ui_release2 = newNode.getReplacedChildren$ui_release();
        int size2 = replacedChildren$ui_release2.size();
        while (i < size2) {
            SemanticsNode semanticsNode2 = replacedChildren$ui_release2.get(i);
            if (getCurrentSemanticsNodes$ui_release().contains(semanticsNode2.getId())) {
                SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(semanticsNode2.getId());
                if (semanticsNodeCopy == null) {
                    throw AbstractC1974b.m1327t("node not present in pruned tree before this change");
                }
                sendSemanticsStructureChangeEvents(semanticsNode2, semanticsNodeCopy);
            }
            i++;
        }
    }

    private final void showTranslatedText() {
        AccessibilityAction accessibilityAction;
        Function1 function1;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes$ui_release = getCurrentSemanticsNodes$ui_release();
        Object[] objArr = currentSemanticsNodes$ui_release.values;
        long[] jArr = currentSemanticsNodes$ui_release.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i2; i4++) {
                    if ((255 & j) < 128) {
                        SemanticsConfiguration unmergedConfig$ui_release = ((SemanticsNodeWithAdjustedBounds) objArr[(i << 3) + i4]).getSemanticsNode().getUnmergedConfig();
                        if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution()), Boolean.FALSE) && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsActions.INSTANCE.getShowTextSubstitution())) != null && (function1 = (Function1) accessibilityAction.getAction()) != null) {
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    private final ViewStructureCompat toViewStructure(SemanticsNode semanticsNode) {
        AutofillIdCompat autofillId;
        AutofillId autofillId2;
        String strM20241toLegacyClassNameV4PA4sw;
        ContentCaptureSessionCompat contentCaptureSessionCompat = this.contentCaptureSession;
        if (contentCaptureSessionCompat == null || Build.VERSION.SDK_INT < 29 || (autofillId = ViewCompatShims.getAutofillId(this.view)) == null) {
            return null;
        }
        if (semanticsNode.getParent() != null) {
            autofillId2 = contentCaptureSessionCompat.newAutofillId(r4.getId());
            if (autofillId2 == null) {
                return null;
            }
        } else {
            autofillId2 = autofillId.toAutofillId();
        }
        ViewStructureCompat viewStructureCompatNewVirtualViewStructure = contentCaptureSessionCompat.newVirtualViewStructure(autofillId2, semanticsNode.getId());
        if (viewStructureCompatNewVirtualViewStructure == null) {
            return null;
        }
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        if (unmergedConfig$ui_release.contains(semanticsProperties.getPassword())) {
            return null;
        }
        Bundle extras = viewStructureCompatNewVirtualViewStructure.getExtras();
        if (extras != null) {
            extras.putLong("android.view.contentcapture.EventTimestamp", this.currentSemanticsNodesSnapshotTimestampMillis);
        }
        String str = (String) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, semanticsProperties.getTestTag());
        if (str != null) {
            viewStructureCompatNewVirtualViewStructure.setId(semanticsNode.getId(), null, null, str);
        }
        List list = (List) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, semanticsProperties.getText());
        if (list != null) {
            viewStructureCompatNewVirtualViewStructure.setClassName(AndroidComposeViewAccessibilityDelegateCompat.TextClassName);
            viewStructureCompatNewVirtualViewStructure.setText(ListUtilsKt.fastJoinToString$default(list, "\n", null, null, 0, null, null, 62, null));
        }
        AnnotatedString annotatedString = (AnnotatedString) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, semanticsProperties.getEditableText());
        if (annotatedString != null) {
            viewStructureCompatNewVirtualViewStructure.setClassName(AndroidComposeViewAccessibilityDelegateCompat.TextFieldClassName);
            viewStructureCompatNewVirtualViewStructure.setText(annotatedString);
        }
        List list2 = (List) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, semanticsProperties.getContentDescription());
        if (list2 != null) {
            viewStructureCompatNewVirtualViewStructure.setContentDescription(ListUtilsKt.fastJoinToString$default(list2, "\n", null, null, 0, null, null, 62, null));
        }
        Role role = (Role) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, semanticsProperties.getRole());
        if (role != null && (strM20241toLegacyClassNameV4PA4sw = SemanticsUtils_androidKt.m20241toLegacyClassNameV4PA4sw(role.getValue())) != null) {
            viewStructureCompatNewVirtualViewStructure.setClassName(strM20241toLegacyClassNameV4PA4sw);
        }
        TextLayoutResult textLayoutResult = SemanticsUtils_androidKt.getTextLayoutResult(unmergedConfig$ui_release);
        if (textLayoutResult != null) {
            TextLayoutInput layoutInput = textLayoutResult.getLayoutInput();
            viewStructureCompatNewVirtualViewStructure.setTextStyle(layoutInput.getDensity().getFontScale() * layoutInput.getDensity().getDensity() * TextUnit.m21161getValueimpl(layoutInput.getStyle().m20487getFontSizeXSAIIZE()), 0, 0, 0);
        }
        Rect boundsInParent$ui_release = semanticsNode.getBoundsInParent$ui_release();
        viewStructureCompatNewVirtualViewStructure.setDimens((int) boundsInParent$ui_release.getLeft(), (int) boundsInParent$ui_release.getTop(), 0, 0, (int) boundsInParent$ui_release.getWidth(), (int) boundsInParent$ui_release.getHeight());
        return viewStructureCompatNewVirtualViewStructure;
    }

    private final void updateBuffersOnAppeared(SemanticsNode node) {
        if (isEnabled$ui_release()) {
            updateTranslationOnAppeared(node);
            bufferContentCaptureViewAppeared(node.getId(), toViewStructure(node));
            List<SemanticsNode> replacedChildren$ui_release = node.getReplacedChildren$ui_release();
            int size = replacedChildren$ui_release.size();
            for (int i = 0; i < size; i++) {
                updateBuffersOnAppeared(replacedChildren$ui_release.get(i));
            }
        }
    }

    private final void updateBuffersOnDisappeared(SemanticsNode node) {
        if (isEnabled$ui_release()) {
            bufferContentCaptureViewDisappeared(node.getId());
            List<SemanticsNode> replacedChildren$ui_release = node.getReplacedChildren$ui_release();
            int size = replacedChildren$ui_release.size();
            for (int i = 0; i < size; i++) {
                updateBuffersOnDisappeared(replacedChildren$ui_release.get(i));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateSemanticsCopy() {
        this.previousSemanticsNodes.clear();
        IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes$ui_release = getCurrentSemanticsNodes$ui_release();
        int[] iArr = currentSemanticsNodes$ui_release.keys;
        Object[] objArr = currentSemanticsNodes$ui_release.values;
        long[] jArr = currentSemanticsNodes$ui_release.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i2; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i << 3) + i4;
                            this.previousSemanticsNodes.set(iArr[i5], new SemanticsNodeCopy(((SemanticsNodeWithAdjustedBounds) objArr[i5]).getSemanticsNode(), getCurrentSemanticsNodes$ui_release()));
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    } else if (i == length) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), getCurrentSemanticsNodes$ui_release());
    }

    private final void updateTranslationOnAppeared(SemanticsNode node) {
        AccessibilityAction accessibilityAction;
        Function1 function1;
        Function1 function12;
        SemanticsConfiguration unmergedConfig$ui_release = node.getUnmergedConfig();
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution());
        if (this.translateStatus == TranslateStatus.SHOW_ORIGINAL && Intrinsics.areEqual(bool, Boolean.TRUE)) {
            AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsActions.INSTANCE.getShowTextSubstitution());
            if (accessibilityAction2 == null || (function12 = (Function1) accessibilityAction2.getAction()) == null) {
                return;
            }
            return;
        }
        if (this.translateStatus != TranslateStatus.SHOW_TRANSLATED || !Intrinsics.areEqual(bool, Boolean.FALSE) || (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsActions.INSTANCE.getShowTextSubstitution())) == null || (function1 = (Function1) accessibilityAction.getAction()) == null) {
            return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0098, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r6, r0) == r1) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006e A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:13:0x0030, B:25:0x0056, B:29:0x0066, B:31:0x006e, B:33:0x0077, B:34:0x007a, B:36:0x007e, B:37:0x0087, B:20:0x0048), top: B:48:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0098 -> B:14:0x0033). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object boundsUpdatesEventLoop$ui_release(@NotNull Continuation<? super Unit> continuation) {
        AndroidContentCaptureManager$boundsUpdatesEventLoop$1 androidContentCaptureManager$boundsUpdatesEventLoop$1;
        AndroidContentCaptureManager androidContentCaptureManager;
        ChannelIterator<Unit> it;
        ChannelIterator<Unit> channelIterator;
        Object objHasNext;
        if (continuation instanceof AndroidContentCaptureManager$boundsUpdatesEventLoop$1) {
            androidContentCaptureManager$boundsUpdatesEventLoop$1 = (AndroidContentCaptureManager$boundsUpdatesEventLoop$1) continuation;
            int i = androidContentCaptureManager$boundsUpdatesEventLoop$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                androidContentCaptureManager$boundsUpdatesEventLoop$1.label = i - Integer.MIN_VALUE;
            } else {
                androidContentCaptureManager$boundsUpdatesEventLoop$1 = new AndroidContentCaptureManager$boundsUpdatesEventLoop$1(this, continuation);
            }
        }
        Object obj = androidContentCaptureManager$boundsUpdatesEventLoop$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = androidContentCaptureManager$boundsUpdatesEventLoop$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    it = this.boundsUpdateChannel.iterator();
                    androidContentCaptureManager = this;
                    androidContentCaptureManager$boundsUpdatesEventLoop$1.L$0 = androidContentCaptureManager;
                    androidContentCaptureManager$boundsUpdatesEventLoop$1.L$1 = it;
                    androidContentCaptureManager$boundsUpdatesEventLoop$1.label = 1;
                    objHasNext = it.hasNext(androidContentCaptureManager$boundsUpdatesEventLoop$1);
                    if (objHasNext != coroutine_suspended) {
                    }
                } catch (Throwable th) {
                    th = th;
                    androidContentCaptureManager = this;
                    androidContentCaptureManager.subtreeChangedLayoutNodes.clear();
                    throw th;
                }
            } else if (i2 == 1) {
                channelIterator = (ChannelIterator) androidContentCaptureManager$boundsUpdatesEventLoop$1.L$1;
                androidContentCaptureManager = (AndroidContentCaptureManager) androidContentCaptureManager$boundsUpdatesEventLoop$1.L$0;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                }
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelIterator = (ChannelIterator) androidContentCaptureManager$boundsUpdatesEventLoop$1.L$1;
                androidContentCaptureManager = (AndroidContentCaptureManager) androidContentCaptureManager$boundsUpdatesEventLoop$1.L$0;
                ResultKt.throwOnFailure(obj);
                it = channelIterator;
                androidContentCaptureManager$boundsUpdatesEventLoop$1.L$0 = androidContentCaptureManager;
                androidContentCaptureManager$boundsUpdatesEventLoop$1.L$1 = it;
                androidContentCaptureManager$boundsUpdatesEventLoop$1.label = 1;
                objHasNext = it.hasNext(androidContentCaptureManager$boundsUpdatesEventLoop$1);
                if (objHasNext != coroutine_suspended) {
                    return coroutine_suspended;
                }
                channelIterator = it;
                obj = objHasNext;
                if (((Boolean) obj).booleanValue()) {
                    androidContentCaptureManager.subtreeChangedLayoutNodes.clear();
                    return Unit.INSTANCE;
                }
                channelIterator.next();
                if (androidContentCaptureManager.isEnabled$ui_release()) {
                    androidContentCaptureManager.notifyContentCaptureChanges();
                }
                if (!androidContentCaptureManager.checkingForSemanticsChanges) {
                    androidContentCaptureManager.checkingForSemanticsChanges = true;
                    androidContentCaptureManager.handler.post(androidContentCaptureManager.contentCaptureChangeChecker);
                }
                androidContentCaptureManager.subtreeChangedLayoutNodes.clear();
                long j = androidContentCaptureManager.SendRecurringContentCaptureEventsIntervalMillis;
                androidContentCaptureManager$boundsUpdatesEventLoop$1.L$0 = androidContentCaptureManager;
                androidContentCaptureManager$boundsUpdatesEventLoop$1.L$1 = channelIterator;
                androidContentCaptureManager$boundsUpdatesEventLoop$1.label = 2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: getContentCaptureSession$ui_release, reason: from getter */
    public final ContentCaptureSessionCompat getContentCaptureSession() {
        return this.contentCaptureSession;
    }

    @NotNull
    public final IntObjectMap<SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes$ui_release() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            this.currentSemanticsNodes = SemanticsUtils_androidKt.getAllUncoveredSemanticsNodesToIntObjectMap(this.view.getSemanticsOwner());
            this.currentSemanticsNodesSnapshotTimestampMillis = System.currentTimeMillis();
        }
        return this.currentSemanticsNodes;
    }

    @NotNull
    /* JADX INFO: renamed from: getHandler$ui_release, reason: from getter */
    public final Handler getHandler() {
        return this.handler;
    }

    @NotNull
    public final Function0<ContentCaptureSessionCompat> getOnContentCaptureSession() {
        return this.onContentCaptureSession;
    }

    @NotNull
    public final AndroidComposeView getView() {
        return this.view;
    }

    public final boolean isEnabled$ui_release() {
        return ContentCaptureManager.INSTANCE.isEnabled() && this.contentCaptureSession != null;
    }

    public final void onClearTranslation$ui_release() {
        this.translateStatus = TranslateStatus.SHOW_ORIGINAL;
        clearTranslatedText();
    }

    @RequiresApi(31)
    public final void onCreateVirtualViewTranslationRequests$ui_release(@NotNull long[] virtualIds, @NotNull int[] supportedFormats, @NotNull Consumer<ViewTranslationRequest> requestsCollector) {
        ViewTranslationHelperMethods.INSTANCE.onCreateVirtualViewTranslationRequests(this, virtualIds, supportedFormats, requestsCollector);
    }

    public final void onHideTranslation$ui_release() {
        this.translateStatus = TranslateStatus.SHOW_ORIGINAL;
        hideTranslatedText();
    }

    public final void onLayoutChange$ui_release(@NotNull LayoutNode layoutNode) {
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled$ui_release()) {
            notifySubtreeStateChangeIfNeeded(layoutNode);
        }
    }

    public final void onSemanticsChange$ui_release() {
        this.currentSemanticsNodesInvalidated = true;
        if (!isEnabled$ui_release() || this.checkingForSemanticsChanges) {
            return;
        }
        this.checkingForSemanticsChanges = true;
        this.handler.post(this.contentCaptureChangeChecker);
    }

    public final void onShowTranslation$ui_release() {
        this.translateStatus = TranslateStatus.SHOW_TRANSLATED;
        showTranslatedText();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(@NotNull LifecycleOwner owner) {
        this.contentCaptureSession = this.onContentCaptureSession.invoke();
        updateBuffersOnAppeared(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode());
        notifyContentCaptureChanges();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(@NotNull LifecycleOwner owner) {
        updateBuffersOnDisappeared(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode());
        notifyContentCaptureChanges();
        this.contentCaptureSession = null;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NotNull View v) {
        this.handler.removeCallbacks(this.contentCaptureChangeChecker);
        this.contentCaptureSession = null;
    }

    @RequiresApi(31)
    public final void onVirtualViewTranslationResponses$ui_release(@NotNull AndroidContentCaptureManager contentCaptureManager, @NotNull LongSparseArray<ViewTranslationResponse> response) {
        ViewTranslationHelperMethods.INSTANCE.onVirtualViewTranslationResponses(contentCaptureManager, response);
    }

    public final void setContentCaptureSession$ui_release(@Nullable ContentCaptureSessionCompat contentCaptureSessionCompat) {
        this.contentCaptureSession = contentCaptureSessionCompat;
    }

    public final void setCurrentSemanticsNodes$ui_release(@NotNull IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap) {
        this.currentSemanticsNodes = intObjectMap;
    }

    public final void setOnContentCaptureSession(@NotNull Function0<? extends ContentCaptureSessionCompat> function0) {
        this.onContentCaptureSession = function0;
    }

    @VisibleForTesting
    public static /* synthetic */ void getContentCaptureSession$ui_release$annotations() {
    }

    public static /* synthetic */ void isEnabled$ui_release$annotations() {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NotNull View v) {
    }
}
