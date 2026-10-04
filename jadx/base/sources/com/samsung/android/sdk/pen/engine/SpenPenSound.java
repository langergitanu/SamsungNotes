package com.samsung.android.sdk.pen.engine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.content.ContextCompat;
import com.samsung.android.sdk.pen.pen.SpenPenUtil;
import com.samsung.android.spen.libwrapper.MotionEventWrapper;
import com.samsung.audio.SmpsManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p027F3.RunnableC0101a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 M2\u00020\u0001:\u0002LMB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020*H\u0002J\u0006\u0010,\u001a\u00020*J\u0012\u0010-\u001a\u00020*2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\b\u00100\u001a\u00020*H\u0002J\b\u00101\u001a\u00020*H\u0002J\b\u00102\u001a\u00020*H\u0002J\b\u00103\u001a\u00020*H\u0002J\u0006\u00104\u001a\u00020*J\b\u00105\u001a\u00020*H\u0002J\b\u00106\u001a\u00020*H\u0002J\u0010\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u000bH\u0002J\u0018\u00109\u001a\u00020*2\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020\u0011J\u0018\u0010=\u001a\u00020*2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0011H\u0002J\u0010\u0010>\u001a\u00020?2\u0006\u0010:\u001a\u00020;H\u0002J\u000e\u0010@\u001a\u00020*2\u0006\u0010<\u001a\u00020\u0011J\u000e\u0010A\u001a\u00020*2\u0006\u0010<\u001a\u00020\u0011J\u0016\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020D2\u0006\u00108\u001a\u00020\u000bJ\u0010\u0010E\u001a\u00020*2\u0006\u0010C\u001a\u00020DH\u0002J\u0018\u0010F\u001a\u00020*2\u0006\u0010C\u001a\u00020D2\u0006\u00108\u001a\u00020\u000bH\u0002J\u0010\u0010G\u001a\u00020*2\u0006\u00108\u001a\u00020\u000bH\u0002J\u0018\u0010H\u001a\u00020*2\u0006\u0010C\u001a\u00020D2\u0006\u00108\u001a\u00020\u000bH\u0002J\u0006\u0010I\u001a\u00020*J\b\u0010J\u001a\u00020*H\u0002J\u0006\u0010K\u001a\u00020\u0007R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenPenSound;", "", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mIsSupportPenSound", "", "mSmpsManager", "Lcom/samsung/audio/SmpsManager;", "mIndexPencil", "", "mIndexMarker", "mIndexBrush", "mIndexEraser", "mActivePen", "mPenSize", "", "mEraserSize", "mRemoverSize", "isEnabled", "()Z", "setEnabled", "(Z)V", "mIsPlaySound", "mLastSoundPlayedTime", "", "mExecutor", "Ljava/util/concurrent/ExecutorService;", "mTouchCount", "mIsStrokeRemover", "mAudioManager", "Landroid/media/AudioManager;", "mVolume", "mVolumeChangedReceiver", "Landroid/content/BroadcastReceiver;", "mRingerModeChangedReceiver", "mVolumeChangedIntentFilter", "Landroid/content/IntentFilter;", "mModeChangedIntentFilter", "mIsRegistered", "close", "", "destroyExecutor", "registerPenSoundSolution", "setDisablePenSound", "throwable", "", "createSmpsManager", "cacheSystemVolume", "initReceiver", "registerReceiver", "unregisterPenSoundSolution", "destroySmpsManager", "unregisterReceiver", "isActionNeedSound", "toolTypeAction", "setPenStyle", "penStyle", "", "size", "setPenThickness", "getPenStyle", "Lcom/samsung/android/sdk/pen/engine/SpenPenSound$PenStyle;", "setEraserSize", "setRemoverSize", "onTouch", "event", "Landroid/view/MotionEvent;", "convertMotionEvent", "touchParallel", "initSmpsManagerActivePen", "generateSoundByTouch", "playPenSound", "onPlayPenSound", "isPenSoundEnabled", "PenStyle", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPenSound {
    private static final int MINIMUM_TIME_TO_PLAY_SOUND = 7;
    private static final int MINIMUM_TOUCH_COUNT_TO_PLAY_SOUND = 2;

    @NotNull
    private static final String PEN_NAME_AIR_BRUSH_PEN = "com.samsung.android.sdk.pen.pen.preload.AirBrushPen";

    @NotNull
    private static final String PEN_NAME_BRUSH = "com.samsung.android.sdk.pen.pen.preload.Brush";

    @NotNull
    private static final String PEN_NAME_BRUSH_PEN = "com.samsung.android.sdk.pen.pen.preload.BrushPen";

    @NotNull
    private static final String PEN_NAME_CHINESE_BRUSH = "com.samsung.android.sdk.pen.pen.preload.ChineseBrush";

    @NotNull
    private static final String PEN_NAME_COLORED_PENCIL = "com.samsung.android.sdk.pen.pen.preload.ColoredPencil";

    @NotNull
    private static final String PEN_NAME_CRAYON = "com.samsung.android.sdk.pen.pen.preload.Crayon";

    @NotNull
    private static final String PEN_NAME_ERASER = "com.samsung.android.sdk.pen.pen.preload.Eraser";

    @NotNull
    private static final String PEN_NAME_FOUNTAIN_PEN = "com.samsung.android.sdk.pen.pen.preload.FountainPen";

    @NotNull
    private static final String PEN_NAME_INK_PEN = "com.samsung.android.sdk.pen.pen.preload.InkPen";

    @NotNull
    private static final String PEN_NAME_MAGIC_PEN = "com.samsung.android.sdk.pen.pen.preload.MagicPen";

    @NotNull
    private static final String PEN_NAME_MARKER = "com.samsung.android.sdk.pen.pen.preload.Marker";

    @NotNull
    private static final String PEN_NAME_MOSAIC_PEN = "com.samsung.android.sdk.pen.pen.preload.MosaicPen";

    @NotNull
    private static final String PEN_NAME_OBLIQUE_PEN = "com.samsung.android.sdk.pen.pen.preload.ObliquePen";

    @NotNull
    private static final String PEN_NAME_OIL_BRUSH = "com.samsung.android.sdk.pen.pen.preload.OilBrush";

    @NotNull
    private static final String PEN_NAME_PENCIL = "com.samsung.android.sdk.pen.pen.preload.Pencil";

    @NotNull
    private static final String PEN_NAME_PREFIX = "com.samsung.android.sdk.pen.pen.preload.";

    @NotNull
    private static final String PEN_NAME_SMUDGE = "com.samsung.android.sdk.pen.pen.preload.Smudge";

    @NotNull
    private static final String PEN_NAME_STRAIGHT_HIGHLIGHTER = "com.samsung.android.sdk.pen.pen.preload.StraightHighlighter";

    @NotNull
    private static final String PEN_NAME_STRAIGHT_MARKER = "com.samsung.android.sdk.pen.pen.preload.StraightMarker";

    @NotNull
    private static final String PEN_NAME_WATER_COLOR_BRUSH = "com.samsung.android.sdk.pen.pen.preload.WaterColorBrush";
    private static final float REMOVER_MAX_SIZE = 10.0f;

    @NotNull
    private static final String TAG = "SpenPenSound";

    @Nullable
    private AudioManager mAudioManager;

    @Nullable
    private Context mContext;
    private float mEraserSize;

    @Nullable
    private ExecutorService mExecutor;
    private boolean mIsPlaySound;
    private boolean mIsRegistered;
    private boolean mIsStrokeRemover;
    private boolean mIsSupportPenSound;
    private long mLastSoundPlayedTime;

    @Nullable
    private IntentFilter mModeChangedIntentFilter;
    private float mPenSize;
    private float mRemoverSize;

    @Nullable
    private BroadcastReceiver mRingerModeChangedReceiver;

    @Nullable
    private SmpsManager mSmpsManager;
    private int mTouchCount;
    private int mVolume;

    @Nullable
    private IntentFilter mVolumeChangedIntentFilter;

    @Nullable
    private BroadcastReceiver mVolumeChangedReceiver;
    private int mIndexPencil = -1;
    private int mIndexMarker = -1;
    private int mIndexBrush = -1;
    private int mIndexEraser = -1;
    private int mActivePen = -1;
    private boolean isEnabled = true;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenPenSound$PenStyle;", "", "<init>", "(Ljava/lang/String;I)V", "INK", "BRUSH", "MARKER", "INVALID", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class PenStyle {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PenStyle[] $VALUES;
        public static final PenStyle INK = new PenStyle("INK", 0);
        public static final PenStyle BRUSH = new PenStyle("BRUSH", 1);
        public static final PenStyle MARKER = new PenStyle("MARKER", 2);
        public static final PenStyle INVALID = new PenStyle("INVALID", 3);

        private static final /* synthetic */ PenStyle[] $values() {
            return new PenStyle[]{INK, BRUSH, MARKER, INVALID};
        }

        static {
            PenStyle[] penStyleArr$values = $values();
            $VALUES = penStyleArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(penStyleArr$values);
        }

        private PenStyle(String str, int i) {
        }

        @NotNull
        public static EnumEntries<PenStyle> getEntries() {
            return $ENTRIES;
        }

        public static PenStyle valueOf(String str) {
            return (PenStyle) Enum.valueOf(PenStyle.class, str);
        }

        public static PenStyle[] values() {
            return (PenStyle[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PenStyle.values().length];
            try {
                iArr[PenStyle.INK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PenStyle.BRUSH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PenStyle.MARKER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PenStyle.INVALID.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SpenPenSound(@Nullable Context context) {
        this.mContext = context;
        createSmpsManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cacheSystemVolume() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            this.mVolume = audioManager.getStreamVolume(1);
        } else {
            Log.e(TAG, "cacheSystemVolume() failed. mAudioManager is null.");
        }
    }

    private final void convertMotionEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == MotionEventWrapper.ACTION_PEN_DOWN) {
            event.setAction(0);
            return;
        }
        if (action == MotionEventWrapper.ACTION_PEN_MOVE) {
            event.setAction(2);
        } else if (action == MotionEventWrapper.ACTION_PEN_UP) {
            event.setAction(1);
        } else if (action == MotionEventWrapper.ACTION_PEN_CANCEL) {
            event.setAction(3);
        }
    }

    private final void destroyExecutor() {
        ExecutorService executorService = this.mExecutor;
        if (executorService != null) {
            executorService.shutdownNow();
            this.mExecutor = null;
        }
    }

    private final void destroySmpsManager() {
        SmpsManager smpsManager = this.mSmpsManager;
        if (smpsManager != null) {
            Log.i(TAG, "destroySmpsManager() - Start");
            smpsManager.onDestroy();
            this.mSmpsManager = null;
            Log.i(TAG, "destroySmpsManager() - End");
        }
    }

    private final synchronized void generateSoundByTouch(MotionEvent event, int toolTypeAction) {
        if (this.mSmpsManager != null && this.isEnabled && this.mIsPlaySound && this.mIsSupportPenSound && isActionNeedSound(toolTypeAction)) {
            if (System.currentTimeMillis() - this.mLastSoundPlayedTime < 7) {
                return;
            }
            if (this.mVolume <= 0) {
                return;
            }
            this.mIsPlaySound = false;
            this.mLastSoundPlayedTime = System.currentTimeMillis();
            SmpsManager smpsManager = this.mSmpsManager;
            if (smpsManager != null) {
                smpsManager.generateSound(event);
            }
            return;
        }
        Log.i(TAG, "generateSoundByTouch mIsPlaySound : " + this.mIsPlaySound + ", isActionNeedSound(toolTypeAction) : " + isActionNeedSound(toolTypeAction) + ", toolTypeAction : " + toolTypeAction);
    }

    private final PenStyle getPenStyle(String penStyle) {
        return (StringsKt.m14145S(penStyle, "com.samsung.android.sdk.pen.pen.preload.InkPen") || StringsKt.m14145S(penStyle, "com.samsung.android.sdk.pen.pen.preload.Pencil") || StringsKt.m14145S(penStyle, "com.samsung.android.sdk.pen.pen.preload.FountainPen") || StringsKt.m14145S(penStyle, "com.samsung.android.sdk.pen.pen.preload.ObliquePen") || StringsKt.m14145S(penStyle, "com.samsung.android.sdk.pen.pen.preload.Crayon") || StringsKt.m14145S(penStyle, "com.samsung.android.sdk.pen.pen.preload.Eraser") || StringsKt.m14145S(penStyle, "com.samsung.android.sdk.pen.pen.preload.MosaicPen") || StringsKt.m14145S(penStyle, "com.samsung.android.sdk.pen.pen.preload.ColoredPencil")) ? PenStyle.INK : (StringsKt.m14145S(penStyle, "com.samsung.android.sdk.pen.pen.preload.Brush") || StringsKt.m14145S(penStyle, "com.samsung.android.sdk.pen.pen.preload.ChineseBrush") || StringsKt.m14145S(penStyle, "com.samsung.android.sdk.pen.pen.preload.WaterColorBrush") || StringsKt.m14145S(penStyle, PEN_NAME_OIL_BRUSH) || StringsKt.m14145S(penStyle, "com.samsung.android.sdk.pen.pen.preload.BrushPen") || StringsKt.m14145S(penStyle, "com.samsung.android.sdk.pen.pen.preload.AirBrushPen") || StringsKt.m14145S(penStyle, "com.samsung.android.sdk.pen.pen.preload.Smudge")) ? PenStyle.BRUSH : (StringsKt.m14145S(penStyle, "com.samsung.android.sdk.pen.pen.preload.Marker") || StringsKt.m14145S(penStyle, "com.samsung.android.sdk.pen.pen.preload.MagicPen") || StringsKt.m14145S(penStyle, "com.samsung.android.sdk.pen.pen.preload.StraightHighlighter") || StringsKt.m14145S(penStyle, "com.samsung.android.sdk.pen.pen.preload.StraightMarker")) ? PenStyle.MARKER : PenStyle.INVALID;
    }

    private final void initReceiver() {
        if (!this.mIsSupportPenSound || this.mContext == null) {
            return;
        }
        Log.i(TAG, "initReceiver()");
        Context context = this.mContext;
        this.mAudioManager = (AudioManager) (context != null ? context.getSystemService("audio") : null);
        this.mVolumeChangedReceiver = new BroadcastReceiver() { // from class: com.samsung.android.sdk.pen.engine.SpenPenSound.initReceiver.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 1) {
                    SpenPenSound.this.cacheSystemVolume();
                    AbstractC0541b.m755A(SpenPenSound.this.mVolume, "System volume change received, volume : ", SpenPenSound.TAG);
                }
            }
        };
        this.mRingerModeChangedReceiver = new BroadcastReceiver() { // from class: com.samsung.android.sdk.pen.engine.SpenPenSound.initReceiver.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                SpenPenSound.this.cacheSystemVolume();
                AudioManager audioManager = SpenPenSound.this.mAudioManager;
                AbstractC0541b.m755A(audioManager != null ? audioManager.getRingerMode() : -1, "Ringer mode change received, ringer mode : ", SpenPenSound.TAG);
            }
        };
        this.mVolumeChangedIntentFilter = new IntentFilter("android.media.VOLUME_CHANGED_ACTION");
        this.mModeChangedIntentFilter = new IntentFilter("android.media.RINGER_MODE_CHANGED");
    }

    private final synchronized void initSmpsManagerActivePen(int toolTypeAction) {
        try {
            SmpsManager smpsManager = this.mSmpsManager;
            if (smpsManager != null && this.isEnabled && this.mIsSupportPenSound && this.mContext != null) {
                if (smpsManager != null) {
                    if (toolTypeAction == 7) {
                        smpsManager.setActivePen(this.mIndexPencil);
                        float f = this.mEraserSize;
                        Intrinsics.checkNotNull(this.mContext);
                        smpsManager.setThickness(f / SpenPenUtil.getMaximumPenSize(r0, "com.samsung.android.sdk.pen.pen.preload.Eraser"));
                    } else if (toolTypeAction == 8 || this.mIsStrokeRemover) {
                        smpsManager.setActivePen(this.mIndexEraser);
                        smpsManager.setThickness(this.mRemoverSize / 10.0f);
                    } else {
                        smpsManager.setActivePen(this.mActivePen);
                        smpsManager.setThickness(this.mPenSize);
                    }
                }
                return;
            }
            Log.i(TAG, "initSmpsManagerActivePen mSmpsManager : " + smpsManager + ", mIsEnabled : " + this.isEnabled + ", mIsSupportPenSound : " + this.mIsSupportPenSound);
        } catch (Throwable th) {
            throw th;
        }
    }

    private final boolean isActionNeedSound(int toolTypeAction) {
        return toolTypeAction == 2 || toolTypeAction == 12 || toolTypeAction == 7 || toolTypeAction == 8 || toolTypeAction == 3 || toolTypeAction == 4 || toolTypeAction == 5 || toolTypeAction == 16 || toolTypeAction == 18 || toolTypeAction == 19 || this.mIsStrokeRemover;
    }

    private final void onPlayPenSound() {
        playPenSound();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTouch$lambda$6(SpenPenSound spenPenSound, MotionEvent motionEvent, int i) {
        try {
            Intrinsics.checkNotNull(motionEvent);
            spenPenSound.touchParallel(motionEvent, i);
        } finally {
            motionEvent.recycle();
        }
    }

    private final void registerReceiver() {
        Context context;
        if (this.mIsSupportPenSound && (context = this.mContext) != null) {
            Log.i(TAG, "registerReceiver()");
            context.registerReceiver(this.mVolumeChangedReceiver, this.mVolumeChangedIntentFilter);
            context.registerReceiver(this.mRingerModeChangedReceiver, this.mModeChangedIntentFilter);
        }
    }

    private final void setDisablePenSound(Throwable throwable) {
        if (throwable != null) {
            Log.e(TAG, "Smps is disabled in this model by ".concat(throwable.getClass().getSimpleName()));
        }
        this.mIsSupportPenSound = false;
    }

    private final void setPenThickness(String penStyle, float size) {
        SmpsManager smpsManager;
        Context context = this.mContext;
        if (context == null || (smpsManager = this.mSmpsManager) == null) {
            return;
        }
        float minimumPenSize = SpenPenUtil.getMinimumPenSize(context, penStyle);
        float maximumPenSize = SpenPenUtil.getMaximumPenSize(context, penStyle);
        if (StringsKt.m14145S(penStyle, "com.samsung.android.sdk.pen.pen.preload.ColoredPencil")) {
            smpsManager.setThickness(size);
            return;
        }
        if (size == minimumPenSize) {
            this.mPenSize = 0.0f;
            smpsManager.setThickness(0.0f);
        } else {
            float f = (size - minimumPenSize) / (maximumPenSize - minimumPenSize);
            this.mPenSize = f;
            smpsManager.setThickness(f);
        }
    }

    private final void touchParallel(MotionEvent event, int toolTypeAction) {
        SmpsManager smpsManager = this.mSmpsManager;
        if (smpsManager == null || !this.isEnabled || !this.mIsSupportPenSound) {
            boolean z = this.isEnabled;
            boolean z2 = this.mIsSupportPenSound;
            StringBuilder sb = new StringBuilder("touchParallel mSmpsManager : ");
            sb.append(smpsManager);
            sb.append(", mIsEnabled : ");
            sb.append(z);
            sb.append(", mIsSupportPenSound : ");
            AbstractC0000a.m27x(sb, z2, TAG);
            return;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.mTouchCount = 0;
            int i = this.mActivePen;
            boolean zIsActionNeedSound = isActionNeedSound(toolTypeAction);
            boolean z3 = this.mIsStrokeRemover;
            StringBuilder sbM1173s = AbstractC0622a.m1173s(toolTypeAction, i, "touchParallel toolTypeAction=", ", mActivePen=", ", isActionNeedSound(toolTypeAction) : ");
            sbM1173s.append(zIsActionNeedSound);
            sbM1173s.append(", mIsStrokeRemover=");
            sbM1173s.append(z3);
            Log.i(TAG, sbM1173s.toString());
        }
        if (actionMasked == 2) {
            this.mTouchCount++;
        }
        if (this.mTouchCount == 2) {
            initSmpsManagerActivePen(toolTypeAction);
            event.setAction(0);
        }
        if (this.mTouchCount >= 2) {
            generateSoundByTouch(event, toolTypeAction);
        }
    }

    private final void unregisterReceiver() {
        Log.i(TAG, "unregisterReceiver()");
        try {
            Context context = this.mContext;
            if (context != null) {
                context.unregisterReceiver(this.mVolumeChangedReceiver);
            }
            Context context2 = this.mContext;
            if (context2 != null) {
                context2.unregisterReceiver(this.mRingerModeChangedReceiver);
            }
        } catch (Exception e) {
            AbstractC2322a.m1636z("unregisterReceiver() failed. ", e.getMessage(), TAG);
        }
        this.mAudioManager = null;
        this.mVolumeChangedIntentFilter = null;
        this.mModeChangedIntentFilter = null;
        this.mVolumeChangedReceiver = null;
        this.mRingerModeChangedReceiver = null;
    }

    public final synchronized void close() {
        try {
            if (this.mIsRegistered) {
                unregisterReceiver();
                this.mIsRegistered = false;
                Log.d(TAG, "Pen sound solution unregistered during close");
            }
            destroyExecutor();
            destroySmpsManager();
            this.mContext = null;
            Log.d(TAG, "SpenPenSound closed successfully");
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: isEnabled, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    public final boolean isPenSoundEnabled() {
        return this.mContext != null && this.mSmpsManager != null && this.mIsSupportPenSound && this.isEnabled;
    }

    public final void onTouch(@NotNull MotionEvent event, int toolTypeAction) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.mExecutor == null) {
            this.mExecutor = Executors.newSingleThreadExecutor();
        }
        int action = event.getAction();
        if (action == MotionEventWrapper.ACTION_PEN_DOWN) {
            this.mIsStrokeRemover = true;
        } else if (action == 0) {
            this.mIsStrokeRemover = false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(event);
        Intrinsics.checkNotNull(motionEventObtain);
        convertMotionEvent(motionEventObtain);
        ExecutorService executorService = this.mExecutor;
        if (executorService != null) {
            executorService.execute(new RunnableC0101a(this, motionEventObtain, toolTypeAction, 7));
        }
    }

    public final void playPenSound() {
        this.mIsPlaySound = true;
    }

    public final synchronized void registerPenSoundSolution() {
        if (this.mIsRegistered) {
            Log.w(TAG, "Pen sound solution already registered, skipping...");
            return;
        }
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT <= 30 && ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH") == -1) {
            Log.e(TAG, "Smps is disabled in this model - Application do not have BLUETOOTH permission.");
            setDisablePenSound(null);
            destroySmpsManager();
            return;
        }
        try {
            boolean z = SmpsManager.isSupport;
            this.mIsSupportPenSound = z;
            if (!z) {
                Log.e(TAG, "Smps is disabled in this model by SmpsManager.isSupport=" + SmpsManager.isSupport);
                return;
            }
            initReceiver();
            registerReceiver();
            cacheSystemVolume();
            this.mIsRegistered = true;
            Log.d(TAG, "Pen sound solution registered successfully");
            Log.d(TAG, "Current system volume : " + this.mVolume);
        } catch (Error e) {
            setDisablePenSound(e);
        }
    }

    public final void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public final void setEraserSize(float size) {
        this.mEraserSize = size;
    }

    public final synchronized void setPenStyle(@Nullable String penStyle, float size) {
        int i;
        try {
            if (this.mIsSupportPenSound && this.mSmpsManager != null && penStyle != null) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[getPenStyle(penStyle).ordinal()];
                if (i2 == 1) {
                    i = this.mIndexPencil;
                } else if (i2 == 2) {
                    i = this.mIndexBrush;
                } else if (i2 == 3) {
                    i = this.mIndexMarker;
                } else {
                    if (i2 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i = -1;
                }
                this.mActivePen = i;
                SmpsManager smpsManager = this.mSmpsManager;
                if (smpsManager != null) {
                    smpsManager.setActivePen(i);
                }
                setPenThickness(penStyle, size);
            }
        } finally {
        }
    }

    public final void setRemoverSize(float size) {
        this.mRemoverSize = size;
    }

    public final synchronized void unregisterPenSoundSolution() {
        if (!this.mIsRegistered) {
            Log.w(TAG, "Pen sound solution not registered, skipping...");
            return;
        }
        unregisterReceiver();
        this.mIsRegistered = false;
        Log.d(TAG, "Pen sound solution unregistered successfully");
    }

    private final void createSmpsManager() {
    }
}
