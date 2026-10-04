package com.samsung.android.sdk.pen.engine;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.view.gesture.SpenGesture;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 .2\u00020\u0001:\u0003,-.B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001eH\u0002J\u0012\u0010%\u001a\u00020\u001e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010&\u001a\u00020\u001eH\u0002J\b\u0010'\u001a\u00020\u001eH\u0002J\b\u0010(\u001a\u00020\u001eH\u0002J\b\u0010)\u001a\u00020\u001eH\u0002J\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\u001eH\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenWritingOptionView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "frontBufferRenderingState", "Lcom/samsung/android/sdk/pen/engine/SpenWritingOptionView$WritingOptionState;", "predictionState", "dvfsState", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/engine/SpenWritingOptionView$Listener;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/engine/SpenWritingOptionView$WritingOptionState;Lcom/samsung/android/sdk/pen/engine/SpenWritingOptionView$WritingOptionState;Lcom/samsung/android/sdk/pen/engine/SpenWritingOptionView$WritingOptionState;Lcom/samsung/android/sdk/pen/engine/SpenWritingOptionView$Listener;)V", "mListener", "mFrontBufferRenderingButton", "Landroid/widget/Button;", "mPredictionButton", "mMeasureButton", "mDVFSButton", "mPalmRejectionButton", "mTouchOffsetButton", "mFrontBufferRenderingState", "mPredictionState", "mDVFSState", "mIsGestureEnable", "", "mPalmRejectionEnabled", "mTouchOffset", "Landroid/graphics/Point;", "mPreTouchPosition", "setParent", "", "view", "Landroid/view/View;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "showTouchOffsetDialog", "inflateViews", "setFrontBufferRenderingButtonText", "setPredictionButtonText", "setDVFSButtonText", "setMeasureButtonText", "setPalmRejectionButtonText", "setTouchOffsetButtonText", "Listener", "WritingOptionState", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenWritingOptionView extends LinearLayout {

    @NotNull
    private static final String TAG = "SpenWritingOptionView";

    @NotNull
    private final Button mDVFSButton;

    @NotNull
    private WritingOptionState mDVFSState;

    @NotNull
    private final Button mFrontBufferRenderingButton;

    @NotNull
    private WritingOptionState mFrontBufferRenderingState;
    private boolean mIsGestureEnable;

    @Nullable
    private Listener mListener;

    @NotNull
    private final Button mMeasureButton;

    @NotNull
    private final Button mPalmRejectionButton;
    private boolean mPalmRejectionEnabled;

    @NotNull
    private final Point mPreTouchPosition;

    @NotNull
    private final Button mPredictionButton;

    @NotNull
    private WritingOptionState mPredictionState;

    @NotNull
    private final Point mTouchOffset;

    @NotNull
    private final Button mTouchOffsetButton;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenWritingOptionView$Listener;", "", "onFrontBufferRenderingEnabled", "", "enabled", "", "onPredictionEnabled", "onDVFSEnabled", "onMeasureMode", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface Listener {
        void onDVFSEnabled(boolean enabled);

        void onFrontBufferRenderingEnabled(boolean enabled);

        void onMeasureMode(boolean enabled);

        void onPredictionEnabled(boolean enabled);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WritingOptionState.values().length];
            try {
                iArr[WritingOptionState.f4951On.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WritingOptionState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WritingOptionState.Unsupported.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenWritingOptionView$WritingOptionState;", "", "<init>", "(Ljava/lang/String;I)V", "On", "Off", RtspHeaders.Names.UNSUPPORTED, "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class WritingOptionState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ WritingOptionState[] $VALUES;

        /* JADX INFO: renamed from: On */
        public static final WritingOptionState f4951On = new WritingOptionState("On", 0);
        public static final WritingOptionState Off = new WritingOptionState("Off", 1);
        public static final WritingOptionState Unsupported = new WritingOptionState(RtspHeaders.Names.UNSUPPORTED, 2);

        private static final /* synthetic */ WritingOptionState[] $values() {
            return new WritingOptionState[]{f4951On, Off, Unsupported};
        }

        static {
            WritingOptionState[] writingOptionStateArr$values = $values();
            $VALUES = writingOptionStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(writingOptionStateArr$values);
        }

        private WritingOptionState(String str, int i) {
        }

        @NotNull
        public static EnumEntries<WritingOptionState> getEntries() {
            return $ENTRIES;
        }

        public static WritingOptionState valueOf(String str) {
            return (WritingOptionState) Enum.valueOf(WritingOptionState.class, str);
        }

        public static WritingOptionState[] values() {
            return (WritingOptionState[]) $VALUES.clone();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenWritingOptionView(@Nullable Context context, @NotNull WritingOptionState frontBufferRenderingState, @NotNull WritingOptionState predictionState, @NotNull WritingOptionState dvfsState, @Nullable Listener listener) {
        super(context);
        Intrinsics.checkNotNullParameter(frontBufferRenderingState, "frontBufferRenderingState");
        Intrinsics.checkNotNullParameter(predictionState, "predictionState");
        Intrinsics.checkNotNullParameter(dvfsState, "dvfsState");
        this.mIsGestureEnable = true;
        this.mPalmRejectionEnabled = true;
        this.mTouchOffset = new Point();
        this.mPreTouchPosition = new Point();
        this.mListener = listener;
        inflateViews(context);
        View viewFindViewById = findViewById(C7932R.id.writingoption_fbr_button);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.Button");
        Button button = (Button) viewFindViewById;
        this.mFrontBufferRenderingButton = button;
        View viewFindViewById2 = findViewById(C7932R.id.writingoption_prediction_button);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.Button");
        Button button2 = (Button) viewFindViewById2;
        this.mPredictionButton = button2;
        View viewFindViewById3 = findViewById(C7932R.id.writingoption_dvfs_button);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.Button");
        Button button3 = (Button) viewFindViewById3;
        this.mDVFSButton = button3;
        View viewFindViewById4 = findViewById(C7932R.id.writingoption_measure_button);
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.Button");
        Button button4 = (Button) viewFindViewById4;
        this.mMeasureButton = button4;
        Button button5 = (Button) findViewById(C7932R.id.writingoption_palm_rejection_button);
        this.mPalmRejectionButton = button5;
        Button button6 = (Button) findViewById(C7932R.id.writingoption_offset_button);
        this.mTouchOffsetButton = button6;
        this.mFrontBufferRenderingState = frontBufferRenderingState;
        this.mPredictionState = predictionState;
        this.mDVFSState = dvfsState;
        setFrontBufferRenderingButtonText();
        setDVFSButtonText();
        setMeasureButtonText();
        setPalmRejectionButtonText();
        setTouchOffsetButtonText();
        WritingOptionState writingOptionState = this.mFrontBufferRenderingState;
        WritingOptionState writingOptionState2 = WritingOptionState.Unsupported;
        if (writingOptionState == writingOptionState2) {
            button.setEnabled(false);
        } else {
            button.setEnabled(true);
            final int i = 0;
            button.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.engine.c

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SpenWritingOptionView f4957b;

                {
                    this.f4957b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i) {
                        case 0:
                            SpenWritingOptionView._init_$lambda$0(this.f4957b, view);
                            break;
                        case 1:
                            SpenWritingOptionView._init_$lambda$1(this.f4957b, view);
                            break;
                        case 2:
                            SpenWritingOptionView._init_$lambda$2(this.f4957b, view);
                            break;
                        case 3:
                            SpenWritingOptionView._init_$lambda$3(this.f4957b, view);
                            break;
                        case 4:
                            SpenWritingOptionView._init_$lambda$4(this.f4957b, view);
                            break;
                        case 5:
                            this.f4957b.showTouchOffsetDialog();
                            break;
                        default:
                            SpenWritingOptionView._init_$lambda$6(this.f4957b, view);
                            break;
                    }
                }
            });
        }
        if (this.mPredictionState == writingOptionState2) {
            button2.setEnabled(false);
        } else {
            button2.setEnabled(true);
            final int i2 = 1;
            button2.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.engine.c

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SpenWritingOptionView f4957b;

                {
                    this.f4957b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i2) {
                        case 0:
                            SpenWritingOptionView._init_$lambda$0(this.f4957b, view);
                            break;
                        case 1:
                            SpenWritingOptionView._init_$lambda$1(this.f4957b, view);
                            break;
                        case 2:
                            SpenWritingOptionView._init_$lambda$2(this.f4957b, view);
                            break;
                        case 3:
                            SpenWritingOptionView._init_$lambda$3(this.f4957b, view);
                            break;
                        case 4:
                            SpenWritingOptionView._init_$lambda$4(this.f4957b, view);
                            break;
                        case 5:
                            this.f4957b.showTouchOffsetDialog();
                            break;
                        default:
                            SpenWritingOptionView._init_$lambda$6(this.f4957b, view);
                            break;
                    }
                }
            });
        }
        if (this.mDVFSState == writingOptionState2) {
            button3.setEnabled(false);
        } else {
            button3.setEnabled(true);
            final int i4 = 2;
            button3.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.engine.c

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SpenWritingOptionView f4957b;

                {
                    this.f4957b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i4) {
                        case 0:
                            SpenWritingOptionView._init_$lambda$0(this.f4957b, view);
                            break;
                        case 1:
                            SpenWritingOptionView._init_$lambda$1(this.f4957b, view);
                            break;
                        case 2:
                            SpenWritingOptionView._init_$lambda$2(this.f4957b, view);
                            break;
                        case 3:
                            SpenWritingOptionView._init_$lambda$3(this.f4957b, view);
                            break;
                        case 4:
                            SpenWritingOptionView._init_$lambda$4(this.f4957b, view);
                            break;
                        case 5:
                            this.f4957b.showTouchOffsetDialog();
                            break;
                        default:
                            SpenWritingOptionView._init_$lambda$6(this.f4957b, view);
                            break;
                    }
                }
            });
        }
        final int i5 = 3;
        button4.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.engine.c

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenWritingOptionView f4957b;

            {
                this.f4957b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i5) {
                    case 0:
                        SpenWritingOptionView._init_$lambda$0(this.f4957b, view);
                        break;
                    case 1:
                        SpenWritingOptionView._init_$lambda$1(this.f4957b, view);
                        break;
                    case 2:
                        SpenWritingOptionView._init_$lambda$2(this.f4957b, view);
                        break;
                    case 3:
                        SpenWritingOptionView._init_$lambda$3(this.f4957b, view);
                        break;
                    case 4:
                        SpenWritingOptionView._init_$lambda$4(this.f4957b, view);
                        break;
                    case 5:
                        this.f4957b.showTouchOffsetDialog();
                        break;
                    default:
                        SpenWritingOptionView._init_$lambda$6(this.f4957b, view);
                        break;
                }
            }
        });
        final int i6 = 4;
        button5.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.engine.c

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenWritingOptionView f4957b;

            {
                this.f4957b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i6) {
                    case 0:
                        SpenWritingOptionView._init_$lambda$0(this.f4957b, view);
                        break;
                    case 1:
                        SpenWritingOptionView._init_$lambda$1(this.f4957b, view);
                        break;
                    case 2:
                        SpenWritingOptionView._init_$lambda$2(this.f4957b, view);
                        break;
                    case 3:
                        SpenWritingOptionView._init_$lambda$3(this.f4957b, view);
                        break;
                    case 4:
                        SpenWritingOptionView._init_$lambda$4(this.f4957b, view);
                        break;
                    case 5:
                        this.f4957b.showTouchOffsetDialog();
                        break;
                    default:
                        SpenWritingOptionView._init_$lambda$6(this.f4957b, view);
                        break;
                }
            }
        });
        final int i7 = 5;
        button6.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.engine.c

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenWritingOptionView f4957b;

            {
                this.f4957b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i7) {
                    case 0:
                        SpenWritingOptionView._init_$lambda$0(this.f4957b, view);
                        break;
                    case 1:
                        SpenWritingOptionView._init_$lambda$1(this.f4957b, view);
                        break;
                    case 2:
                        SpenWritingOptionView._init_$lambda$2(this.f4957b, view);
                        break;
                    case 3:
                        SpenWritingOptionView._init_$lambda$3(this.f4957b, view);
                        break;
                    case 4:
                        SpenWritingOptionView._init_$lambda$4(this.f4957b, view);
                        break;
                    case 5:
                        this.f4957b.showTouchOffsetDialog();
                        break;
                    default:
                        SpenWritingOptionView._init_$lambda$6(this.f4957b, view);
                        break;
                }
            }
        });
        View viewFindViewById5 = findViewById(C7932R.id.writingoption_close_button);
        Intrinsics.checkNotNull(viewFindViewById5, "null cannot be cast to non-null type android.widget.Button");
        final int i8 = 6;
        ((Button) viewFindViewById5).setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.engine.c

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenWritingOptionView f4957b;

            {
                this.f4957b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i8) {
                    case 0:
                        SpenWritingOptionView._init_$lambda$0(this.f4957b, view);
                        break;
                    case 1:
                        SpenWritingOptionView._init_$lambda$1(this.f4957b, view);
                        break;
                    case 2:
                        SpenWritingOptionView._init_$lambda$2(this.f4957b, view);
                        break;
                    case 3:
                        SpenWritingOptionView._init_$lambda$3(this.f4957b, view);
                        break;
                    case 4:
                        SpenWritingOptionView._init_$lambda$4(this.f4957b, view);
                        break;
                    case 5:
                        this.f4957b.showTouchOffsetDialog();
                        break;
                    default:
                        SpenWritingOptionView._init_$lambda$6(this.f4957b, view);
                        break;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(SpenWritingOptionView spenWritingOptionView, View view) {
        WritingOptionState writingOptionState = spenWritingOptionView.mFrontBufferRenderingState;
        WritingOptionState writingOptionState2 = WritingOptionState.f4951On;
        spenWritingOptionView.mFrontBufferRenderingState = writingOptionState == writingOptionState2 ? WritingOptionState.Off : writingOptionState2;
        spenWritingOptionView.setFrontBufferRenderingButtonText();
        Listener listener = spenWritingOptionView.mListener;
        if (listener != null) {
            listener.onFrontBufferRenderingEnabled(spenWritingOptionView.mFrontBufferRenderingState == writingOptionState2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(SpenWritingOptionView spenWritingOptionView, View view) {
        WritingOptionState writingOptionState = spenWritingOptionView.mPredictionState;
        WritingOptionState writingOptionState2 = WritingOptionState.f4951On;
        spenWritingOptionView.mPredictionState = writingOptionState == writingOptionState2 ? WritingOptionState.Off : writingOptionState2;
        spenWritingOptionView.setPredictionButtonText();
        Listener listener = spenWritingOptionView.mListener;
        if (listener != null) {
            listener.onPredictionEnabled(spenWritingOptionView.mPredictionState == writingOptionState2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(SpenWritingOptionView spenWritingOptionView, View view) {
        WritingOptionState writingOptionState = spenWritingOptionView.mDVFSState;
        WritingOptionState writingOptionState2 = WritingOptionState.f4951On;
        spenWritingOptionView.mDVFSState = writingOptionState == writingOptionState2 ? WritingOptionState.Off : writingOptionState2;
        spenWritingOptionView.setDVFSButtonText();
        Listener listener = spenWritingOptionView.mListener;
        if (listener != null) {
            listener.onDVFSEnabled(spenWritingOptionView.mDVFSState == writingOptionState2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(SpenWritingOptionView spenWritingOptionView, View view) {
        spenWritingOptionView.mIsGestureEnable = !spenWritingOptionView.mIsGestureEnable;
        spenWritingOptionView.setMeasureButtonText();
        SpenGesture.INSTANCE.setGestureEnabled(spenWritingOptionView.mIsGestureEnable);
        Listener listener = spenWritingOptionView.mListener;
        if (listener != null) {
            listener.onMeasureMode(spenWritingOptionView.mIsGestureEnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4(SpenWritingOptionView spenWritingOptionView, View view) {
        spenWritingOptionView.mPalmRejectionEnabled = !spenWritingOptionView.mPalmRejectionEnabled;
        spenWritingOptionView.setPalmRejectionButtonText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$6(LinearLayout linearLayout, View view) {
        ViewParent parent = linearLayout.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).removeView(linearLayout);
    }

    private final void inflateViews(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater) (context != null ? context.getSystemService("layout_inflater") : null);
        if (layoutInflater != null) {
            layoutInflater.inflate(C7932R.layout.writing_option_view, this);
        }
    }

    private final void setDVFSButtonText() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.mDVFSState.ordinal()];
        if (i == 1) {
            this.mDVFSButton.setText("DVFS ON");
        } else if (i == 2) {
            this.mDVFSButton.setText("DVFS OFF");
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            this.mDVFSButton.setText("DVFS is Unsupported");
        }
    }

    private final void setFrontBufferRenderingButtonText() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.mFrontBufferRenderingState.ordinal()];
        if (i == 1) {
            this.mFrontBufferRenderingButton.setText("Front Buffer Rendering ON");
        } else if (i == 2) {
            this.mFrontBufferRenderingButton.setText("Front Buffer Rendering OFF");
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            this.mFrontBufferRenderingButton.setText("Front Buffer Rendering is Unsupported");
        }
    }

    private final void setMeasureButtonText() {
        this.mMeasureButton.setText(this.mIsGestureEnable ? "Measure mode off" : "Measure mode on");
    }

    private final void setPalmRejectionButtonText() {
        this.mPalmRejectionButton.setText(this.mPalmRejectionEnabled ? "Palm rejection on" : "Palm rejection off");
    }

    private final void setPredictionButtonText() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.mPredictionState.ordinal()];
        if (i == 1) {
            this.mPredictionButton.setText("Prediction ON");
        } else if (i == 2) {
            this.mPredictionButton.setText("Prediction OFF");
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            this.mPredictionButton.setText("Prediction is Unsupported");
        }
    }

    private final void setTouchOffsetButtonText() {
        this.mTouchOffsetButton.setText("Adjust touch offset");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showTouchOffsetDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Input offset X and Y");
        final C7444a c7444a = new C7444a();
        View viewInflate = LayoutInflater.from(getContext()).inflate(C7932R.layout.writing_option_touchoffset, (ViewGroup) null);
        final NumberPicker numberPicker = (NumberPicker) viewInflate.findViewById(C7932R.id.offsetX);
        numberPicker.setFormatter(c7444a);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(20);
        numberPicker.setWrapSelectorWheel(true);
        numberPicker.setValue(this.mPreTouchPosition.x);
        final NumberPicker numberPicker2 = (NumberPicker) viewInflate.findViewById(C7932R.id.offsetY);
        numberPicker2.setFormatter(c7444a);
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(20);
        numberPicker2.setWrapSelectorWheel(true);
        numberPicker2.setValue(this.mPreTouchPosition.y);
        builder.setView(viewInflate);
        builder.setPositiveButton(CoeditServiceConstants.ServerResponseCode.SERVER_RESPONSE_CODE_OK, new DialogInterface.OnClickListener() { // from class: com.samsung.android.sdk.pen.engine.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SpenWritingOptionView.showTouchOffsetDialog$lambda$8(this.f4952a, numberPicker, numberPicker2, c7444a, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String showTouchOffsetDialog$lambda$7(int i) {
        if (i > 10) {
            i -= 21;
        }
        return String.valueOf(i * 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTouchOffsetDialog$lambda$8(SpenWritingOptionView spenWritingOptionView, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker.Formatter formatter, DialogInterface dialogInterface, int i) {
        spenWritingOptionView.mPreTouchPosition.set(numberPicker.getValue(), numberPicker2.getValue());
        Point point = spenWritingOptionView.mTouchOffset;
        String str = formatter.format(numberPicker.getValue());
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        int i2 = Integer.parseInt(str);
        String str2 = formatter.format(numberPicker2.getValue());
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        point.set(i2, Integer.parseInt(str2));
        Log.i(TAG, "TouchOffset : " + spenWritingOptionView.mTouchOffset + ", PreTouchPosition : " + spenWritingOptionView.mPreTouchPosition);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Point point = this.mTouchOffset;
        if (point.x == 0 && point.y == 0) {
            return false;
        }
        Log.i(TAG, "It just use to measure latency!!!!!");
        Point point2 = this.mTouchOffset;
        event.offsetLocation(point2.x, point2.y);
        return true;
    }

    public final void setParent(@Nullable View view) {
        ViewGroup viewGroup = (ViewGroup) (view != null ? view.getParent() : null);
        if (viewGroup != null) {
            viewGroup.addView(this);
        }
    }
}
