package com.samsung.android.sdk.composer.writing;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingChangeStyleInfo;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.engine.SpenColorPickerListener;
import com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration;
import com.samsung.android.sdk.pen.engine.SpenPenSound;
import com.samsung.android.sdk.pen.engine.SpenRecentColorListener;
import com.samsung.android.sdk.pen.engine.SpenRemoverListener;
import com.samsung.android.sdk.pen.engine.SpenSelectionChangeListener;
import com.samsung.android.sdk.pen.engine.SpenToastActionListener;
import com.samsung.android.sdk.pen.engine.SpenViewCore;
import com.samsung.android.sdk.pen.engine.fbrDrawPad.SpenFbrDrawPad;
import com.samsung.android.sdk.pen.pen.SpenPenUtil;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.app.sync.cloudsettings.callee.NotesSyncRpcProvider;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0018\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0086\u00012\u00020\u0001:\u0002\u0086\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u00107\u001a\u000208H\u0016J\u0012\u00109\u001a\u00020\u00112\b\u0010:\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010;\u001a\u000208H\u0002J\u0010\u0010<\u001a\u0002082\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010=\u001a\u00020\u00112\u0006\u0010>\u001a\u00020\u0011H\u0016J\u001c\u0010?\u001a\u00020\u00112\u0006\u0010>\u001a\u00020\u00112\n\u0010@\u001a\u00020A\"\u00020\u0011H\u0016J\b\u0010B\u001a\u000208H\u0016J\u001c\u0010C\u001a\u0002082\u0006\u0010D\u001a\u00020\u00112\n\u0010@\u001a\u00020A\"\u00020\u0011H\u0016J0\u0010E\u001a\u0002082\u0006\u0010F\u001a\u00020\u00112\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020H2\u0006\u0010K\u001a\u00020HH\u0016J\u0018\u0010L\u001a\u0002082\u0006\u0010M\u001a\u00020H2\u0006\u0010N\u001a\u00020HH\u0016J\u0010\u0010O\u001a\u00020H2\u0006\u0010M\u001a\u00020HH\u0016J\u0010\u0010P\u001a\u0002082\u0006\u0010Q\u001a\u00020HH\u0016J\u0010\u0010R\u001a\u0002082\u0006\u0010Q\u001a\u00020HH\u0016J\u0010\u0010S\u001a\u0002082\u0006\u0010T\u001a\u00020HH\u0016J,\u0010U\u001a\u0002082\u0006\u0010V\u001a\u00020W2\u001a\u0010X\u001a\u0016\u0012\u0004\u0012\u00020H\u0018\u00010Yj\n\u0012\u0004\u0012\u00020H\u0018\u0001`ZH\u0016J4\u0010U\u001a\u0002082\u0006\u0010V\u001a\u00020W2\u001a\u0010X\u001a\u0016\u0012\u0004\u0012\u00020H\u0018\u00010Yj\n\u0012\u0004\u0012\u00020H\u0018\u0001`Z2\u0006\u0010[\u001a\u00020\u0011H\u0016J\b\u0010\\\u001a\u000208H\u0016J\u0010\u0010]\u001a\u0002082\u0006\u0010^\u001a\u00020\u0011H\u0016J\u0010\u0010_\u001a\u0002082\u0006\u0010`\u001a\u00020\u0011H\u0016J\u0010\u0010a\u001a\u0002082\u0006\u0010b\u001a\u00020\u0011H\u0016J\u0010\u0010c\u001a\u0002082\u0006\u0010D\u001a\u00020\u0011H\u0016J\u0010\u0010d\u001a\u0002082\u0006\u0010D\u001a\u00020\u0011H\u0016J(\u0010e\u001a\u0002082\u0006\u0010G\u001a\u00020W2\u0006\u0010I\u001a\u00020W2\u0006\u0010J\u001a\u00020W2\u0006\u0010K\u001a\u00020WH\u0016J\u0010\u0010f\u001a\u0002082\u0006\u0010g\u001a\u00020WH\u0016J\b\u0010h\u001a\u000208H\u0016J\b\u0010i\u001a\u000208H\u0016J\u0012\u0010j\u001a\u0002082\b\u0010+\u001a\u0004\u0018\u00010kH\u0017J\u0012\u0010j\u001a\u0002082\b\u0010+\u001a\u0004\u0018\u00010lH\u0016J\b\u0010m\u001a\u000208H\u0016J\u0010\u0010n\u001a\u0002082\u0006\u0010o\u001a\u00020\u0011H\u0016J\u0012\u0010p\u001a\u0002082\b\u0010q\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010r\u001a\u0002082\b\u0010s\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010t\u001a\u0002082\b\u0010u\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010v\u001a\u0002082\b\u0010w\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010x\u001a\u0002082\b\u0010y\u001a\u0004\u0018\u00010\u0015H\u0016J \u0010z\u001a\u0002082\u0006\u0010{\u001a\u00020H2\u0006\u0010|\u001a\u00020W2\u0006\u0010}\u001a\u00020WH\u0002J\u0010\u0010~\u001a\u0002082\u0006\u0010{\u001a\u00020HH\u0002J\u0010\u0010\u007f\u001a\u0002082\u0006\u0010{\u001a\u00020HH\u0002J\u0013\u0010\u0080\u0001\u001a\u0002082\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0002J\u0012\u0010\u0083\u0001\u001a\u0002082\u0007\u0010\u0084\u0001\u001a\u00020HH\u0002J\t\u0010\u0085\u0001\u001a\u000208H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010'R\u001e\u0010*\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0011@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R(\u0010,\u001a\u0004\u0018\u00010\u001b2\b\u0010+\u001a\u0004\u0018\u00010\u001b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R(\u00102\u001a\u0004\u0018\u0001012\b\u0010+\u001a\u0004\u0018\u0001018V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006\u0087\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/writing/SpenNoteWritingViewManager;", "Lcom/samsung/android/sdk/composer/writing/ISpenNoteWritingViewManager;", "mContext", "Landroid/content/Context;", "mView", "Landroid/view/View;", "nativeNoteWritingView", "", "mDisplay", "Lcom/samsung/android/sdk/pen/view/SpenDisplay;", "mPenSound", "Lcom/samsung/android/sdk/pen/engine/SpenPenSound;", "<init>", "(Landroid/content/Context;Landroid/view/View;JLcom/samsung/android/sdk/pen/view/SpenDisplay;Lcom/samsung/android/sdk/pen/engine/SpenPenSound;)V", "mViewCore", "Lcom/samsung/android/sdk/pen/engine/SpenViewCore;", "mIsFbrSupportedFeature", "", "mToastActionListener", "Lcom/samsung/android/sdk/pen/engine/SpenToastActionListener;", "mRemoverListener", "Lcom/samsung/android/sdk/pen/engine/SpenRemoverListener;", "mFbrDrawPad", "Lcom/samsung/android/sdk/pen/engine/fbrDrawPad/SpenFbrDrawPad;", "mDocument", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "mPenInfo", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "spenLatencyConfiguration", "Lcom/samsung/android/sdk/pen/engine/SpenLatencyConfiguration;", "getSpenLatencyConfiguration", "()Lcom/samsung/android/sdk/pen/engine/SpenLatencyConfiguration;", "mColorPickerListener", "Lcom/samsung/android/sdk/pen/engine/SpenColorPickerListener;", "mRecentColorListener", "Lcom/samsung/android/sdk/pen/engine/SpenRecentColorListener;", "mSelectionChangeListener", "Lcom/samsung/android/sdk/pen/engine/SpenSelectionChangeListener;", "isFbrDrawPadEnabled", "()Z", "isFbrDrawPadSupported", "value", "isPredictionEnabled", "info", "penSettingInfo", "getPenSettingInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "setPenSettingInfo", "(Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;)V", "Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "removerSettingInfo", "getRemoverSettingInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "setRemoverSettingInfo", "(Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;)V", "close", "", "setDocument", "doc", "finalizeFbrDrawPad", "setIsFbrSupportedFeature", "setAnimationLayerEnabled", "enabled", "setFrontBufferRenderingEnabled", NotesSyncRpcProvider.FORCE_SYNC, "", "onAttachedToWindow", "setPredictionEnabled", "enable", "onLayout", "changed", "left", "", "top", "right", "bottom", "setToolTypeAction", "toolType", "action", "getToolTypeAction", "setSelectionType", "type", "setSelectionObjectType", "setSelectionLayer", "layer", "setSelectionPenStyle", "size", "", "colorList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isSolidPen", "setSelectionPenStyleAsDefault", "setIntersectSelection", "intersect", "setConnectedSelection", "isConnected", "setNearByTimeSelection", "isNearByTime", "setFreeAreaSelection", "setLimitedAreaSelection", "setLimitedAreaPosition", "setMinZoomScale", WiggleAnimationConfig.KEY_SCALE, "pauseVectorCacheUpdate", "resumeVectorCacheUpdate", "setChangeStyleSettingInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "Lcom/samsung/android/sdk/pen/SpenSettingChangeStyleInfo;", "requestReadyForSave", "setFocusSelectedObjects", "focus", "setColorPickerListener", "colorPickerListener", "setRecentColorListener", "recentColorListener", "setSelectionChangeListener", "selectionChangeListener", "setToastActionListener", "toastActionListener", "setRemoverListener", "removerListener", "onColorPicked", "color", "x", "y", "onStrokeAdded", "onStrokeStyleChanged", "onSelectionPositionUpdated", "rect", "Landroid/graphics/RectF;", "onMaxStrokeCountIsOverflowed", "maxStrokeCount", "onHighlighterRemoverTouchesNormalStroke", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenNoteWritingViewManager implements ISpenNoteWritingViewManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenNoteWritingViewMgr";
    private boolean isPredictionEnabled;

    @Nullable
    private SpenColorPickerListener mColorPickerListener;

    @Nullable
    private Context mContext;

    @Nullable
    private final SpenDisplay mDisplay;

    @Nullable
    private SpenWNote mDocument;

    @Nullable
    private SpenFbrDrawPad mFbrDrawPad;
    private boolean mIsFbrSupportedFeature = true;

    @NotNull
    private final SpenSettingPenInfo mPenInfo = new SpenSettingPenInfo();

    @Nullable
    private SpenPenSound mPenSound;

    @Nullable
    private SpenRecentColorListener mRecentColorListener;

    @Nullable
    private SpenRemoverListener mRemoverListener;

    @Nullable
    private SpenSelectionChangeListener mSelectionChangeListener;

    @Nullable
    private SpenToastActionListener mToastActionListener;

    @Nullable
    private View mView;

    @Nullable
    private final SpenViewCore mViewCore;
    private long nativeNoteWritingView;

    @NotNull
    private final SpenLatencyConfiguration spenLatencyConfiguration;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\u0011\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\u0019\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0083 J\u0019\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0083 J\u0019\u0010\u0015\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0083 J\u0019\u0010\u0016\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0014H\u0083 J=\u0010\u0018\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u001a\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001cj\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u001d2\u0006\u0010\u001e\u001a\u00020\u000eH\u0083 J\u0011\u0010\u001f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\u0019\u0010 \u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000eH\u0083 J\u0019\u0010\"\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000eH\u0083 J\u0019\u0010$\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000eH\u0083 J\u0019\u0010&\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000eH\u0083 J\u0019\u0010(\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000eH\u0083 J\u0019\u0010)\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000eH\u0083 J1\u0010*\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u001aH\u0083 J\u0019\u0010/\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u001aH\u0083 J\u0011\u00101\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\u0011\u00102\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0083 J)\u00103\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u0002042\u0006\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u00020\u0014H\u0083 J\u0019\u00107\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000bH\u0083 J\u0019\u00109\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u000eH\u0083 J\u0019\u0010;\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0083 J\u0019\u0010<\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000eH\u0083 J\u0011\u0010=\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0083 J1\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020\u00142\u0006\u0010A\u001a\u00020\u00142\u0006\u0010B\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\u0014H\u0083 J1\u0010D\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020\u00142\u0006\u0010A\u001a\u00020\u00142\u0006\u0010B\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\u0014H\u0083 J\u0019\u0010E\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020\u000eH\u0083 J!\u0010G\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u001aH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006J"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/writing/SpenNoteWritingViewManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_init", "", "noteWritingViewManager", "Lcom/samsung/android/sdk/composer/writing/SpenNoteWritingViewManager;", "nativeNoteWritingView", "", "Native_getViewCore", "Native_isHapticSoundNeeded", "", "Native_setRemoverSettingInfo", "info", "Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "Native_setSelectionType", "type", "", "Native_setSelectionObjectType", "Native_setSelectionLayer", "layer", "Native_setSelectionPenStyle", "size", "", "colorList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "_isSolidPen", "Native_setSelectionPenStyleAsDefault", "Native_setIntersectSelection", "intersect", "Native_setConnectedSelection", "isConnected", "Native_setNearByTimeSelection", "isNearByTime", "Native_setObjectSelection", "enable", "Native_setFreeAreaSelection", "Native_setLimitedAreaSelection", "Native_setLimitedAreaPosition", "l", "t", "r", "b", "Native_setMinZoomScale", "minZoomScale", "Native_pauseVectorCacheUpdate", "Native_resumeVectorCacheUpdate", "Native_setChangeStyleSetting", "Lcom/samsung/android/sdk/pen/SpenSettingChangeStyleInfo;", "canvasWidth", "canvasHeight", "Native_setFbrDrawPad", "nativeDrawPad", "Native_setAnimationLayerEnabled", "enabled", "Native_setPredictionType", "Native_setPredictionEnabled", "Native_requestReadyForSave", "Native_setVisibleViewRect", "nativeView", "left", "top", "right", "bottom", "Native_setVisibleScreenRect", "Native_setFocusSelectedObjects", "focus", "Native_storeHighlighterInfo", "penName", "penSize", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getViewCore(long nativeNoteWritingView) {
            return SpenNoteWritingViewManager.Native_getViewCore(nativeNoteWritingView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_init(SpenNoteWritingViewManager noteWritingViewManager, long nativeNoteWritingView) {
            SpenNoteWritingViewManager.Native_init(noteWritingViewManager, nativeNoteWritingView);
        }

        @JvmStatic
        private final boolean Native_isHapticSoundNeeded(long nativeNoteWritingView) {
            return SpenNoteWritingViewManager.Native_isHapticSoundNeeded(nativeNoteWritingView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_pauseVectorCacheUpdate(long nativeNoteWritingView) {
            SpenNoteWritingViewManager.Native_pauseVectorCacheUpdate(nativeNoteWritingView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_requestReadyForSave(long nativeNoteWritingView) {
            SpenNoteWritingViewManager.Native_requestReadyForSave(nativeNoteWritingView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_resumeVectorCacheUpdate(long nativeNoteWritingView) {
            SpenNoteWritingViewManager.Native_resumeVectorCacheUpdate(nativeNoteWritingView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setAnimationLayerEnabled(long nativeNoteWritingView, boolean enabled) {
            SpenNoteWritingViewManager.Native_setAnimationLayerEnabled(nativeNoteWritingView, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setChangeStyleSetting(long nativeNoteWritingView, SpenSettingChangeStyleInfo info, int canvasWidth, int canvasHeight) {
            SpenNoteWritingViewManager.Native_setChangeStyleSetting(nativeNoteWritingView, info, canvasWidth, canvasHeight);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setConnectedSelection(long nativeNoteWritingView, boolean isConnected) {
            SpenNoteWritingViewManager.Native_setConnectedSelection(nativeNoteWritingView, isConnected);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setFbrDrawPad(long nativeNoteWritingView, long nativeDrawPad) {
            SpenNoteWritingViewManager.Native_setFbrDrawPad(nativeNoteWritingView, nativeDrawPad);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setFocusSelectedObjects(long nativeView, boolean focus) {
            SpenNoteWritingViewManager.Native_setFocusSelectedObjects(nativeView, focus);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setFreeAreaSelection(long nativeNoteWritingView, boolean enable) {
            SpenNoteWritingViewManager.Native_setFreeAreaSelection(nativeNoteWritingView, enable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setIntersectSelection(long nativeNoteWritingView, boolean intersect) {
            SpenNoteWritingViewManager.Native_setIntersectSelection(nativeNoteWritingView, intersect);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setLimitedAreaPosition(long nativeNoteWritingView, float l, float t, float r, float b) {
            SpenNoteWritingViewManager.Native_setLimitedAreaPosition(nativeNoteWritingView, l, t, r, b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setLimitedAreaSelection(long nativeNoteWritingView, boolean enable) {
            SpenNoteWritingViewManager.Native_setLimitedAreaSelection(nativeNoteWritingView, enable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setMinZoomScale(long nativeNoteWritingView, float minZoomScale) {
            SpenNoteWritingViewManager.Native_setMinZoomScale(nativeNoteWritingView, minZoomScale);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setNearByTimeSelection(long nativeNoteWritingView, boolean isNearByTime) {
            SpenNoteWritingViewManager.Native_setNearByTimeSelection(nativeNoteWritingView, isNearByTime);
        }

        @JvmStatic
        private final void Native_setObjectSelection(long nativeNoteWritingView, boolean enable) {
            SpenNoteWritingViewManager.Native_setObjectSelection(nativeNoteWritingView, enable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setPredictionEnabled(long nativeNoteWritingView, boolean enable) {
            SpenNoteWritingViewManager.Native_setPredictionEnabled(nativeNoteWritingView, enable);
        }

        @JvmStatic
        private final void Native_setPredictionType(long nativeNoteWritingView, int type) {
            SpenNoteWritingViewManager.Native_setPredictionType(nativeNoteWritingView, type);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setRemoverSettingInfo(long nativeNoteWritingView, SpenSettingRemoverInfo info) {
            SpenNoteWritingViewManager.Native_setRemoverSettingInfo(nativeNoteWritingView, info);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setSelectionLayer(long nativeNoteWritingView, int layer) {
            SpenNoteWritingViewManager.Native_setSelectionLayer(nativeNoteWritingView, layer);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setSelectionObjectType(long nativeNoteWritingView, int type) {
            SpenNoteWritingViewManager.Native_setSelectionObjectType(nativeNoteWritingView, type);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setSelectionPenStyle(long nativeNoteWritingView, float size, ArrayList<Integer> colorList, boolean _isSolidPen) {
            SpenNoteWritingViewManager.Native_setSelectionPenStyle(nativeNoteWritingView, size, colorList, _isSolidPen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setSelectionPenStyleAsDefault(long nativeNoteWritingView) {
            SpenNoteWritingViewManager.Native_setSelectionPenStyleAsDefault(nativeNoteWritingView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setSelectionType(long nativeNoteWritingView, int type) {
            SpenNoteWritingViewManager.Native_setSelectionType(nativeNoteWritingView, type);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setVisibleScreenRect(long nativeView, int left, int top, int right, int bottom) {
            SpenNoteWritingViewManager.Native_setVisibleScreenRect(nativeView, left, top, right, bottom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setVisibleViewRect(long nativeView, int left, int top, int right, int bottom) {
            SpenNoteWritingViewManager.Native_setVisibleViewRect(nativeView, left, top, right, bottom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_storeHighlighterInfo(long nativeView, String penName, float penSize) {
            SpenNoteWritingViewManager.Native_storeHighlighterInfo(nativeView, penName, penSize);
        }

        private Companion() {
        }
    }

    public SpenNoteWritingViewManager(@Nullable Context context, @Nullable View view, long j, @Nullable SpenDisplay spenDisplay, @Nullable SpenPenSound spenPenSound) {
        this.mContext = context;
        this.mView = view;
        this.nativeNoteWritingView = j;
        this.mDisplay = spenDisplay;
        this.mPenSound = spenPenSound;
        Companion companion = INSTANCE;
        companion.Native_init(this, this.nativeNoteWritingView);
        this.mViewCore = new SpenViewCore(this.mContext, companion.Native_getViewCore(this.nativeNoteWritingView));
        this.spenLatencyConfiguration = new SpenLatencyConfiguration(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getViewCore(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_init(SpenNoteWritingViewManager spenNoteWritingViewManager, long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isHapticSoundNeeded(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_pauseVectorCacheUpdate(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_requestReadyForSave(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_resumeVectorCacheUpdate(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setAnimationLayerEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setChangeStyleSetting(long j, SpenSettingChangeStyleInfo spenSettingChangeStyleInfo, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setConnectedSelection(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setFbrDrawPad(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setFocusSelectedObjects(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setFreeAreaSelection(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setIntersectSelection(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setLimitedAreaPosition(long j, float f, float f4, float f5, float f6);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setLimitedAreaSelection(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setMinZoomScale(long j, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setNearByTimeSelection(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setObjectSelection(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setPredictionEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setPredictionType(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setRemoverSettingInfo(long j, SpenSettingRemoverInfo spenSettingRemoverInfo);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setSelectionLayer(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setSelectionObjectType(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setSelectionPenStyle(long j, float f, ArrayList<Integer> arrayList, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setSelectionPenStyleAsDefault(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setSelectionType(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setVisibleScreenRect(long j, int i, int i2, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setVisibleViewRect(long j, int i, int i2, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_storeHighlighterInfo(long j, String str, float f);

    private final void finalizeFbrDrawPad() {
        if (this.mFbrDrawPad != null) {
            long j = this.nativeNoteWritingView;
            if (j != 0) {
                INSTANCE.Native_setFbrDrawPad(j, 0L);
            }
            View view = this.mView;
            ViewGroup viewGroup = (ViewGroup) (view != null ? view.getParent() : null);
            SpenFbrDrawPad spenFbrDrawPad = this.mFbrDrawPad;
            if ((spenFbrDrawPad != null ? spenFbrDrawPad.getParent() : null) != null && viewGroup != null) {
                viewGroup.removeView(this.mFbrDrawPad);
            }
            SpenFbrDrawPad spenFbrDrawPad2 = this.mFbrDrawPad;
            if (spenFbrDrawPad2 != null) {
                spenFbrDrawPad2.close();
            }
            this.mFbrDrawPad = null;
        }
    }

    private final void onColorPicked(int color, float x, float y2) {
        StringBuilder sbM1628r = AbstractC2322a.m1628r("onColorPicked color = ", color, ", x = ", x, ", y = ");
        sbM1628r.append(y2);
        Log.d(TAG, sbM1628r.toString());
        int i = (color >> 24) & 255;
        int i2 = (color >> 16) & 255;
        int i4 = (color >> 8) & 255;
        int i5 = color & 255;
        SpenColorPickerListener spenColorPickerListener = this.mColorPickerListener;
        if (spenColorPickerListener != null) {
            spenColorPickerListener.onColorPicked(Color.argb(i, i5, i4, i2), x, y2);
        }
    }

    private final void onHighlighterRemoverTouchesNormalStroke() {
        SpenRemoverListener spenRemoverListener = this.mRemoverListener;
        if (spenRemoverListener != null) {
            spenRemoverListener.onHighlighterRemoverTouchesNormalStroke();
        }
    }

    private final void onMaxStrokeCountIsOverflowed(int maxStrokeCount) {
        SpenToastActionListener spenToastActionListener;
        AbstractC0541b.m755A(maxStrokeCount, "onMaxStrokeCountIsOverflowed maxStrokeCount = ", TAG);
        if (maxStrokeCount <= 0 || (spenToastActionListener = this.mToastActionListener) == null) {
            return;
        }
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        spenToastActionListener.show(context.getResources().getString(C7932R.string.pen_string_unable_to_erase_heavy_lines), 0);
    }

    private final void onSelectionPositionUpdated(RectF rect) {
        Log.d(TAG, "onSelectionPositionUpdated " + rect);
        SpenSelectionChangeListener spenSelectionChangeListener = this.mSelectionChangeListener;
        if (spenSelectionChangeListener != null) {
            spenSelectionChangeListener.onPositionUpdated(rect);
        }
    }

    private final void onStrokeAdded(int color) {
        AbstractC0541b.m755A(color, "onStrokeAdded color = ", TAG);
        SpenRecentColorListener spenRecentColorListener = this.mRecentColorListener;
        if (spenRecentColorListener != null) {
            spenRecentColorListener.onAddStroke(color);
        }
    }

    private final void onStrokeStyleChanged(int color) {
        AbstractC0541b.m755A(color, "onStrokeStyleChanged color = ", TAG);
        SpenRecentColorListener spenRecentColorListener = this.mRecentColorListener;
        if (spenRecentColorListener != null) {
            spenRecentColorListener.onChangeStyle(color);
        }
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void close() {
        this.spenLatencyConfiguration.close();
        this.mToastActionListener = null;
        finalizeFbrDrawPad();
        SpenViewCore spenViewCore = this.mViewCore;
        if (spenViewCore != null) {
            spenViewCore.close();
        }
        this.mContext = null;
        this.mView = null;
        this.mDocument = null;
        this.nativeNoteWritingView = 0L;
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    @Nullable
    public SpenSettingPenInfo getPenSettingInfo() {
        Unit unit;
        SpenViewCore spenViewCore = this.mViewCore;
        if (spenViewCore != null) {
            String penStyle = spenViewCore.getPenStyle();
            if (penStyle != null) {
                this.mPenInfo.name = penStyle;
            }
            this.mPenInfo.size = spenViewCore.getPenSize();
            this.mPenInfo.color = spenViewCore.getPenColor();
            this.mPenInfo.isCurvable = spenViewCore.isPenCurveEnabled();
            String advancedPenSetting = spenViewCore.getAdvancedPenSetting();
            if (advancedPenSetting != null) {
                this.mPenInfo.advancedSetting = advancedPenSetting;
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return new SpenSettingPenInfo(this.mPenInfo);
            }
        }
        return null;
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    @Nullable
    public SpenSettingRemoverInfo getRemoverSettingInfo() {
        if (this.mViewCore != null) {
            return new SpenSettingRemoverInfo();
        }
        return null;
    }

    @NotNull
    public final SpenLatencyConfiguration getSpenLatencyConfiguration() {
        return this.spenLatencyConfiguration;
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public int getToolTypeAction(int toolType) {
        SpenViewCore spenViewCore = this.mViewCore;
        if (spenViewCore != null) {
            return spenViewCore.getToolTypeAction(toolType);
        }
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public boolean isFbrDrawPadEnabled() {
        return this.mFbrDrawPad != null;
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public boolean isFbrDrawPadSupported() {
        return this.spenLatencyConfiguration.isFrontBufferRenderingSupported();
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    /* JADX INFO: renamed from: isPredictionEnabled, reason: from getter */
    public boolean getIsPredictionEnabled() {
        return this.isPredictionEnabled;
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void onAttachedToWindow() {
        View view = this.mView;
        ViewGroup viewGroup = (ViewGroup) (view != null ? view.getParent() : null);
        SpenFbrDrawPad spenFbrDrawPad = this.mFbrDrawPad;
        if (spenFbrDrawPad != null) {
            if (spenFbrDrawPad.getParent() != null) {
                ViewParent parent = spenFbrDrawPad.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(spenFbrDrawPad);
            }
            if (spenFbrDrawPad.getParent() == null) {
                spenFbrDrawPad.setVisibility(4);
                spenFbrDrawPad.setZOrderOnTop(true);
                if (viewGroup != null) {
                    viewGroup.addView(spenFbrDrawPad);
                } else {
                    Log.i(TAG, "onAttachedToWindow parentLayout == null");
                }
            }
        }
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        Pair<Rect, Rect> visibleRects = this.spenLatencyConfiguration.getVisibleRects(this.mView, this.mDisplay);
        int i = bottom - top;
        if (((Rect) visibleRects.first).width() < right - left || ((Rect) visibleRects.first).height() < i) {
            Log.i(TAG, AbstractC2322a.m1625o(AbstractC0622a.m1173s(left, top, "onLayout visibleViewRect (", SQLKeyword.COMMA, SQLKeyword.COMMA), right, bottom, SQLKeyword.COMMA, ")"));
            INSTANCE.Native_setVisibleViewRect(this.nativeNoteWritingView, left, top, right, bottom);
        } else {
            Companion companion = INSTANCE;
            long j = this.nativeNoteWritingView;
            Object obj = visibleRects.first;
            companion.Native_setVisibleViewRect(j, ((Rect) obj).left, ((Rect) obj).top, ((Rect) obj).right, ((Rect) obj).bottom);
        }
        Companion companion2 = INSTANCE;
        long j2 = this.nativeNoteWritingView;
        Object obj2 = visibleRects.second;
        companion2.Native_setVisibleScreenRect(j2, ((Rect) obj2).left, ((Rect) obj2).top, ((Rect) obj2).right, ((Rect) obj2).bottom);
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void pauseVectorCacheUpdate() {
        long j = this.nativeNoteWritingView;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_pauseVectorCacheUpdate(j);
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void requestReadyForSave() {
        long j = this.nativeNoteWritingView;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_requestReadyForSave(j);
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void resumeVectorCacheUpdate() {
        long j = this.nativeNoteWritingView;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_resumeVectorCacheUpdate(j);
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public boolean setAnimationLayerEnabled(boolean enabled) {
        Log.d(TAG, "setAnimationLayerEnabled() called");
        long j = this.nativeNoteWritingView;
        if (j == 0) {
            return false;
        }
        INSTANCE.Native_setAnimationLayerEnabled(j, enabled);
        return true;
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    @Deprecated(message = "")
    public void setChangeStyleSettingInfo(@Nullable SpenSettingUIPenInfo info) {
        SpenWNote spenWNote;
        if (info == null) {
            return;
        }
        long j = this.nativeNoteWritingView;
        if (j == 0 || (spenWNote = this.mDocument) == null) {
            return;
        }
        SpenSettingChangeStyleInfo spenSettingChangeStyleInfo = new SpenSettingChangeStyleInfo();
        spenSettingChangeStyleInfo.color = info.color;
        spenSettingChangeStyleInfo.sizeLevel = info.sizeLevel;
        INSTANCE.Native_setChangeStyleSetting(j, spenSettingChangeStyleInfo, spenWNote.getWidth(), spenWNote.getHeight());
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setColorPickerListener(@Nullable SpenColorPickerListener colorPickerListener) {
        this.mColorPickerListener = colorPickerListener;
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setConnectedSelection(boolean isConnected) {
        long j = this.nativeNoteWritingView;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setConnectedSelection(j, isConnected);
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public boolean setDocument(@Nullable SpenWNote doc) {
        if (doc == this.mDocument) {
            Log.i(TAG, "setDocument : same document");
            return false;
        }
        this.mDocument = doc;
        return true;
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setFocusSelectedObjects(boolean focus) {
        long j = this.nativeNoteWritingView;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setFocusSelectedObjects(j, focus);
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setFreeAreaSelection(boolean enable) {
        long j = this.nativeNoteWritingView;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setFreeAreaSelection(j, enable);
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public boolean setFrontBufferRenderingEnabled(boolean enabled, @NotNull boolean... force) {
        Intrinsics.checkNotNullParameter(force, "force");
        this.spenLatencyConfiguration.setForcedWithoutStylusSupport(force.length > 0 ? force[0] : false);
        if (!this.mIsFbrSupportedFeature && enabled) {
            Log.d(TAG, "setFrontBufferRenderingEnabled false. not supported feature running");
            return false;
        }
        if (this.nativeNoteWritingView == 0) {
            return false;
        }
        AbstractC6670b.m4759t("setFrontBufferRenderingEnabled enabled = ", TAG, enabled);
        if (!enabled) {
            finalizeFbrDrawPad();
            return true;
        }
        if (this.mFbrDrawPad == null && this.spenLatencyConfiguration.isFrontBufferRenderingSupported()) {
            SpenFbrDrawPad spenFbrDrawPad = new SpenFbrDrawPad(this.mContext, this.spenLatencyConfiguration.getIsChromeOS(), SpenFbrDrawPad.DefaultMode);
            this.mFbrDrawPad = spenFbrDrawPad;
            Companion companion = INSTANCE;
            long j = this.nativeNoteWritingView;
            Intrinsics.checkNotNull(spenFbrDrawPad);
            companion.Native_setFbrDrawPad(j, spenFbrDrawPad.getHandle());
            View view = this.mView;
            ViewGroup viewGroup = (ViewGroup) (view != null ? view.getParent() : null);
            if (viewGroup != null) {
                viewGroup.addView(this.mFbrDrawPad);
                SpenFbrDrawPad spenFbrDrawPad2 = this.mFbrDrawPad;
                if (spenFbrDrawPad2 != null) {
                    spenFbrDrawPad2.setVisibility(4);
                }
                SpenFbrDrawPad spenFbrDrawPad3 = this.mFbrDrawPad;
                if (spenFbrDrawPad3 != null) {
                    spenFbrDrawPad3.setZOrderOnTop(true);
                }
            }
            this.spenLatencyConfiguration.updateHWInfo(this.mFbrDrawPad);
        }
        AbstractC6670b.m4759t("setFrontBufferRenderingEnabled return ", TAG, this.mFbrDrawPad != null);
        return this.mFbrDrawPad != null;
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setIntersectSelection(boolean intersect) {
        long j = this.nativeNoteWritingView;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setIntersectSelection(j, intersect);
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setIsFbrSupportedFeature(boolean mIsFbrSupportedFeature) {
        this.mIsFbrSupportedFeature = mIsFbrSupportedFeature;
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setLimitedAreaPosition(float left, float top, float right, float bottom) {
        long j = this.nativeNoteWritingView;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setLimitedAreaPosition(j, left, top, right, bottom);
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setLimitedAreaSelection(boolean enable) {
        long j = this.nativeNoteWritingView;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setLimitedAreaSelection(j, enable);
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setMinZoomScale(float scale) {
        long j = this.nativeNoteWritingView;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setMinZoomScale(j, scale);
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setNearByTimeSelection(boolean isNearByTime) {
        long j = this.nativeNoteWritingView;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setNearByTimeSelection(j, isNearByTime);
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setPenSettingInfo(@Nullable SpenSettingPenInfo spenSettingPenInfo) {
        SpenViewCore spenViewCore;
        SpenWNote spenWNote;
        if (spenSettingPenInfo == null || (spenViewCore = this.mViewCore) == null) {
            return;
        }
        Log.i(TAG, "<<=== setPenSettingInfo =====");
        AbstractC6670b.m4756q("setPenSettingInfo name=", spenSettingPenInfo.name, TAG);
        AbstractC4539a.m3205o("setPenSettingInfo size=", TAG, spenSettingPenInfo.size);
        AbstractC2322a.m1631u(spenSettingPenInfo.sizeLevel, "setPenSettingInfo sizeLevel=", TAG);
        AbstractC2322a.m1631u(spenSettingPenInfo.color, "setPenSettingInfo color=", TAG);
        int i = spenSettingPenInfo.sizeLevel;
        if (i != 0 && (spenWNote = this.mDocument) != null) {
            if (spenSettingPenInfo.isDpSize) {
                Context context = this.mContext;
                if (context != null) {
                    Intrinsics.checkNotNull(context);
                    spenSettingPenInfo.size = SpenPenUtil.convertSizeLevelToDpSize(context, spenSettingPenInfo.name, spenSettingPenInfo.sizeLevel);
                }
            } else {
                String str = spenSettingPenInfo.name;
                Intrinsics.checkNotNull(spenWNote);
                int width = spenWNote.getWidth();
                SpenWNote spenWNote2 = this.mDocument;
                Intrinsics.checkNotNull(spenWNote2);
                spenSettingPenInfo.size = SpenPenUtil.convertSizeLevelToPxSize(str, i, width, spenWNote2.getHeight());
            }
            AbstractC4539a.m3205o("setPenSettingInfo size2=", TAG, spenSettingPenInfo.size);
        }
        Log.i(TAG, "===== setPenSettingInfo ===>>");
        SpenSettingPenInfo spenSettingPenInfo2 = this.mPenInfo;
        spenSettingPenInfo2.name = spenSettingPenInfo.name;
        spenSettingPenInfo2.size = spenSettingPenInfo.size;
        spenSettingPenInfo2.sizeLevel = spenSettingPenInfo.sizeLevel;
        spenSettingPenInfo2.color = spenSettingPenInfo.color;
        spenSettingPenInfo2.isCurvable = spenSettingPenInfo.isCurvable;
        spenSettingPenInfo2.isEraserEnabled = spenSettingPenInfo.isEraserEnabled;
        spenSettingPenInfo2.advancedSetting = spenSettingPenInfo.advancedSetting;
        spenSettingPenInfo2.particleDensity = spenSettingPenInfo.particleDensity;
        spenSettingPenInfo2.particleSize = spenSettingPenInfo.particleSize;
        spenSettingPenInfo2.isFixedWidth = spenSettingPenInfo.isFixedWidth;
        spenViewCore.setPenSettingInfo(spenSettingPenInfo, this.mDisplay);
        Companion companion = INSTANCE;
        long j = this.nativeNoteWritingView;
        SpenSettingPenInfo spenSettingPenInfo3 = this.mPenInfo;
        companion.Native_storeHighlighterInfo(j, spenSettingPenInfo3.name, spenSettingPenInfo3.size);
        SpenPenSound spenPenSound = this.mPenSound;
        if (spenPenSound != null) {
            spenPenSound.setPenStyle(spenSettingPenInfo.name, spenViewCore.getPenSize());
        }
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setPredictionEnabled(boolean enable, @NotNull boolean... force) {
        Intrinsics.checkNotNullParameter(force, "force");
        if (force.length > 0 ? force[0] : false) {
            this.spenLatencyConfiguration.setForcedWithoutStylusSupport(true);
            this.spenLatencyConfiguration.executeTouchAnalysis();
        }
        this.isPredictionEnabled = enable;
        long j = this.nativeNoteWritingView;
        if (j != 0) {
            INSTANCE.Native_setPredictionEnabled(j, getIsPredictionEnabled());
        }
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setRecentColorListener(@Nullable SpenRecentColorListener recentColorListener) {
        this.mRecentColorListener = recentColorListener;
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setRemoverListener(@Nullable SpenRemoverListener removerListener) {
        this.mRemoverListener = removerListener;
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setRemoverSettingInfo(@Nullable SpenSettingRemoverInfo spenSettingRemoverInfo) {
        if (spenSettingRemoverInfo == null || this.mViewCore == null) {
            return;
        }
        INSTANCE.Native_setRemoverSettingInfo(this.nativeNoteWritingView, spenSettingRemoverInfo);
        SpenPenSound spenPenSound = this.mPenSound;
        if (spenPenSound != null) {
            spenPenSound.setRemoverSize(spenSettingRemoverInfo.size);
        }
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setSelectionChangeListener(@Nullable SpenSelectionChangeListener selectionChangeListener) {
        this.mSelectionChangeListener = selectionChangeListener;
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setSelectionLayer(int layer) {
        long j = this.nativeNoteWritingView;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setSelectionLayer(j, layer);
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setSelectionObjectType(int type) {
        long j = this.nativeNoteWritingView;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setSelectionObjectType(j, type);
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setSelectionPenStyle(float size, @Nullable ArrayList<Integer> colorList) {
        setSelectionPenStyle(size, colorList, false);
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setSelectionPenStyleAsDefault() {
        long j = this.nativeNoteWritingView;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setSelectionPenStyleAsDefault(j);
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setSelectionType(int type) {
        long j = this.nativeNoteWritingView;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setSelectionType(j, type);
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setToastActionListener(@Nullable SpenToastActionListener toastActionListener) {
        this.mToastActionListener = toastActionListener;
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setToolTypeAction(int toolType, int action) {
        SpenViewCore spenViewCore = this.mViewCore;
        if (spenViewCore != null) {
            spenViewCore.setToolTypeAction(toolType, action);
        }
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setSelectionPenStyle(float size, @Nullable ArrayList<Integer> colorList, boolean isSolidPen) {
        long j = this.nativeNoteWritingView;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setSelectionPenStyle(j, size, colorList, isSolidPen);
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setChangeStyleSettingInfo(@Nullable SpenSettingChangeStyleInfo info) {
        SpenWNote spenWNote;
        if (info == null) {
            return;
        }
        long j = this.nativeNoteWritingView;
        if (j == 0 || (spenWNote = this.mDocument) == null) {
            return;
        }
        INSTANCE.Native_setChangeStyleSetting(j, info, spenWNote.getWidth(), spenWNote.getHeight());
    }
}
