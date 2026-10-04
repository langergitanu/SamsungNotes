package com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.engine.SpenTouchListener;
import com.samsung.android.sdk.pen.engine.writingview.SpenWritingView;
import com.samsung.android.sdk.pen.setting.common.SpenShowButtonShapeText;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001<B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u001bH\u0016J0\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000bH\u0014J\u0012\u0010,\u001a\u00020$2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\u0006\u0010/\u001a\u00020$J\u000e\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020\u000bJ\u000e\u00102\u001a\u00020$2\u0006\u00103\u001a\u00020\u0010J\u000e\u00104\u001a\u00020$2\u0006\u00105\u001a\u00020 J\u0010\u00106\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u00107\u001a\u00020$H\u0002J\u0010\u00108\u001a\u00020$2\u0006\u00109\u001a\u00020\u001eH\u0002J\u0010\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020\u001eH\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/crowdhwrdata/SpenCrowdHwrView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mManager", "Lcom/samsung/android/sdk/pen/recoguifeature/crowdhwrdata/SpenCrowdHwrManager;", "mSentenceStr", "", "mWritingView", "Lcom/samsung/android/sdk/pen/engine/writingview/SpenWritingView;", "mTvSentence", "Landroid/widget/TextView;", "mHintTextView", "Landroid/widget/EditText;", "mNextBtn", "Lcom/samsung/android/sdk/pen/setting/common/SpenShowButtonShapeText;", "mSubmitBtn", "mUndoBtn", "Landroid/view/View;", "mResetBtn", "mIsHintTextEnable", "", "mCrowdHwrListener", "Lcom/samsung/android/sdk/pen/recoguifeature/crowdhwrdata/SpenCrowdHwrListener;", "mCrowdHwrManagerListener", "Lcom/samsung/android/sdk/pen/recoguifeature/crowdhwrdata/SpenCrowdHwrManagerListener;", "onClick", "", VPathDataCmd.RCurveTo, "onLayout", "changed", "left", "top", "right", "bottom", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "close", "setToolType", "toolType", "setAccountId", "accountId", "setListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "initialize", "initWritingView", "setHintTextEnable", "enabled", "updateButtonState", "isEmpty", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenCrowdHwrView extends FrameLayout implements View.OnClickListener {
    private static final float LAYOUT_SIDE_MARGIN = 10.0f;

    @NotNull
    private static final String TAG = "SpenCrowdHwrView";

    @Nullable
    private SpenCrowdHwrListener mCrowdHwrListener;

    @NotNull
    private final SpenCrowdHwrManagerListener mCrowdHwrManagerListener;

    @Nullable
    private EditText mHintTextView;
    private boolean mIsHintTextEnable;

    @Nullable
    private SpenCrowdHwrManager mManager;

    @Nullable
    private SpenShowButtonShapeText mNextBtn;

    @Nullable
    private View mResetBtn;

    @NotNull
    private String mSentenceStr;

    @Nullable
    private SpenShowButtonShapeText mSubmitBtn;

    @Nullable
    private TextView mTvSentence;

    @Nullable
    private View mUndoBtn;

    @Nullable
    private SpenWritingView mWritingView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenCrowdHwrView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSentenceStr = "";
        this.mCrowdHwrManagerListener = new SpenCrowdHwrManagerListener() { // from class: com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.SpenCrowdHwrView$mCrowdHwrManagerListener$1
            @Override // com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.SpenCrowdHwrManagerListener
            public String getSentence() {
                return this.this$0.mSentenceStr;
            }

            @Override // com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.SpenCrowdHwrManagerListener
            public void onClearAll() {
            }

            @Override // com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.SpenCrowdHwrManagerListener
            public void onHandwritingUpdated(boolean isEmpty) {
                this.this$0.updateButtonState(isEmpty);
            }

            @Override // com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.SpenCrowdHwrManagerListener
            public void onSentenceChanged(String sentence) {
                Intrinsics.checkNotNullParameter(sentence, "sentence");
                this.this$0.mSentenceStr = sentence;
                this.this$0.setHintTextEnable(true);
                TextView textView = this.this$0.mTvSentence;
                if (textView != null) {
                    textView.setText(this.this$0.mSentenceStr);
                }
            }

            @Override // com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.SpenCrowdHwrManagerListener
            public void onSubmitted(ArrayList<String> listFile) {
                this.this$0.setHintTextEnable(true);
                SpenCrowdHwrListener spenCrowdHwrListener = this.this$0.mCrowdHwrListener;
                if (spenCrowdHwrListener != null) {
                    spenCrowdHwrListener.onSubmitted(listFile);
                }
            }

            @Override // com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.SpenCrowdHwrManagerListener
            public void onUndo() {
            }
        };
        initialize(context);
    }

    private final void initWritingView() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(C7932R.id.spen_writing_view_layout);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        SpenWritingView spenWritingView = new SpenWritingView(context);
        this.mWritingView = spenWritingView;
        relativeLayout.addView(spenWritingView);
        SpenWritingView spenWritingView2 = this.mWritingView;
        if (spenWritingView2 != null) {
            spenWritingView2.setBackgroundResource(C7932R.drawable.sdk_crowd_hwr_writing_shape);
        }
        SpenWritingView spenWritingView3 = this.mWritingView;
        if (spenWritingView3 != null) {
            spenWritingView3.setToolTypeAction(1, 0);
        }
        SpenWritingView spenWritingView4 = this.mWritingView;
        if (spenWritingView4 != null) {
            spenWritingView4.setToolTypeAction(2, 0);
        }
        SpenWritingView spenWritingView5 = this.mWritingView;
        if (spenWritingView5 != null) {
            spenWritingView5.setToolTypeAction(5, 0);
        }
        SpenWritingView spenWritingView6 = this.mWritingView;
        if (spenWritingView6 != null) {
            spenWritingView6.setToolTypeAction(6, 0);
        }
        SpenWritingView spenWritingView7 = this.mWritingView;
        if (spenWritingView7 != null) {
            spenWritingView7.setZoomable(false);
        }
        SpenWritingView spenWritingView8 = this.mWritingView;
        if (spenWritingView8 != null) {
            spenWritingView8.setScrollable(false);
        }
        SpenWritingView spenWritingView9 = this.mWritingView;
        if (spenWritingView9 != null) {
            SpenCrowdHwrManager spenCrowdHwrManager = this.mManager;
            spenWritingView9.setDocument(spenCrowdHwrManager != null ? spenCrowdHwrManager.getWritingDocument() : null);
        }
        SpenSettingUIPenInfo spenSettingUIPenInfo = new SpenSettingUIPenInfo();
        SpenWritingView spenWritingView10 = this.mWritingView;
        if (spenWritingView10 != null) {
            spenWritingView10.setPenSettingInfo(spenSettingUIPenInfo);
        }
        SpenTouchListener spenTouchListener = new SpenTouchListener() { // from class: com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.SpenCrowdHwrView$initWritingView$touchListener$1
            @Override // com.samsung.android.sdk.pen.engine.SpenTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                Integer numValueOf = event != null ? Integer.valueOf(event.getAction()) : null;
                if (numValueOf != null && numValueOf.intValue() == 0) {
                    this.this$0.mIsHintTextEnable = false;
                    this.this$0.setHintTextEnable(false);
                } else if ((numValueOf != null && numValueOf.intValue() == 1) || (numValueOf != null && numValueOf.intValue() == 3)) {
                    this.this$0.mIsHintTextEnable = true;
                }
                SpenCrowdHwrManager spenCrowdHwrManager2 = this.this$0.mManager;
                if (spenCrowdHwrManager2 != null) {
                    spenCrowdHwrManager2.onTouchEvent(event);
                }
                return false;
            }
        };
        SpenWritingView spenWritingView11 = this.mWritingView;
        if (spenWritingView11 != null) {
            spenWritingView11.setPreTouchListener(spenTouchListener);
        }
    }

    private final void initialize(Context context) {
        LayoutInflater.from(context).inflate(C7932R.layout.setting_crowd_hwr_layout, (ViewGroup) this, true);
        setBackgroundColor(getResources().getColor(C7932R.color.setting_bg_color, null));
        this.mManager = new SpenCrowdHwrManager(context);
        int i = getResources().getConfiguration().orientation;
        SpenCrowdHwrManager spenCrowdHwrManager = this.mManager;
        if (spenCrowdHwrManager != null) {
            spenCrowdHwrManager.setOrientation(i);
        }
        SpenCrowdHwrManager spenCrowdHwrManager2 = this.mManager;
        if (spenCrowdHwrManager2 != null) {
            spenCrowdHwrManager2.setCrowdHwrManagerListener(this.mCrowdHwrManagerListener);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(C7932R.id.crowd_hwr_container);
        SpenShowButtonShapeText spenShowButtonShapeText = (SpenShowButtonShapeText) findViewById(C7932R.id.btn_next_sentence);
        this.mNextBtn = spenShowButtonShapeText;
        if (spenShowButtonShapeText != null) {
            spenShowButtonShapeText.setButtonShapeEnabled(true);
        }
        SpenShowButtonShapeText spenShowButtonShapeText2 = this.mNextBtn;
        if (spenShowButtonShapeText2 != null) {
            spenShowButtonShapeText2.setOnClickListener(this);
        }
        addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC7473a(this, constraintLayout, 0));
        View viewFindViewById = findViewById(C7932R.id.btn_undo);
        this.mUndoBtn = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(this);
        }
        View viewFindViewById2 = findViewById(C7932R.id.btn_clear_all);
        this.mResetBtn = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(this);
        }
        SpenShowButtonShapeText spenShowButtonShapeText3 = (SpenShowButtonShapeText) findViewById(C7932R.id.btn_submit);
        this.mSubmitBtn = spenShowButtonShapeText3;
        if (spenShowButtonShapeText3 != null) {
            spenShowButtonShapeText3.setButtonShapeEnabled(true);
        }
        SpenShowButtonShapeText spenShowButtonShapeText4 = this.mSubmitBtn;
        if (spenShowButtonShapeText4 != null) {
            spenShowButtonShapeText4.setOnClickListener(this);
        }
        TextView textView = (TextView) findViewById(C7932R.id.tv_sentence);
        this.mTvSentence = textView;
        if (textView != null) {
            textView.setText(this.mSentenceStr);
        }
        initWritingView();
        SpenCrowdHwrManager spenCrowdHwrManager3 = this.mManager;
        updateButtonState(spenCrowdHwrManager3 != null && spenCrowdHwrManager3.isEmpty());
        this.mHintTextView = (EditText) findViewById(C7932R.id.hint_text_view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initialize$lambda$2(SpenCrowdHwrView spenCrowdHwrView, ConstraintLayout constraintLayout, View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        int width = (int) (spenCrowdHwrView.getWidth() * 0.1f);
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.setMarginStart(width);
            marginLayoutParams.setMarginEnd(width);
            constraintLayout.setLayoutParams(marginLayoutParams);
        }
        SpenShowButtonShapeText spenShowButtonShapeText = spenCrowdHwrView.mNextBtn;
        ViewGroup.LayoutParams layoutParams2 = spenShowButtonShapeText != null ? spenShowButtonShapeText.getLayoutParams() : null;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
        if (marginLayoutParams2 != null) {
            marginLayoutParams2.setMarginStart(width);
            marginLayoutParams2.setMarginEnd(width);
            SpenShowButtonShapeText spenShowButtonShapeText2 = spenCrowdHwrView.mNextBtn;
            if (spenShowButtonShapeText2 != null) {
                spenShowButtonShapeText2.setLayoutParams(marginLayoutParams2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setHintTextEnable(boolean enabled) {
        if (enabled && this.mIsHintTextEnable) {
            EditText editText = this.mHintTextView;
            if (editText != null) {
                editText.setVisibility(0);
                return;
            }
            return;
        }
        EditText editText2 = this.mHintTextView;
        if (editText2 != null) {
            editText2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateButtonState(boolean isEmpty) {
        View view = this.mUndoBtn;
        if (view != null) {
            view.setEnabled(!isEmpty);
        }
        View view2 = this.mResetBtn;
        if (view2 != null) {
            view2.setEnabled(!isEmpty);
        }
        SpenShowButtonShapeText spenShowButtonShapeText = this.mSubmitBtn;
        if (spenShowButtonShapeText != null) {
            spenShowButtonShapeText.setEnabled(!isEmpty);
        }
    }

    public final void close() {
        SpenWritingView spenWritingView = this.mWritingView;
        if (spenWritingView != null) {
            spenWritingView.setDocument(null);
        }
        SpenCrowdHwrManager spenCrowdHwrManager = this.mManager;
        if (spenCrowdHwrManager != null) {
            spenCrowdHwrManager.close();
        }
        this.mManager = null;
        SpenWritingView spenWritingView2 = this.mWritingView;
        if (spenWritingView2 != null) {
            spenWritingView2.close();
        }
        this.mWritingView = null;
        this.mTvSentence = null;
        this.mCrowdHwrListener = null;
        this.mHintTextView = null;
        this.mNextBtn = null;
        this.mSubmitBtn = null;
        this.mUndoBtn = null;
        this.mResetBtn = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v) {
        SpenCrowdHwrManager spenCrowdHwrManager;
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = C7932R.id.btn_next_sentence;
        if (numValueOf != null && numValueOf.intValue() == i) {
            SpenCrowdHwrManager spenCrowdHwrManager2 = this.mManager;
            if (spenCrowdHwrManager2 != null) {
                spenCrowdHwrManager2.onNextSentenceClicked();
                return;
            }
            return;
        }
        int i2 = C7932R.id.btn_submit;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            SpenCrowdHwrManager spenCrowdHwrManager3 = this.mManager;
            if (spenCrowdHwrManager3 != null) {
                spenCrowdHwrManager3.onSubmitClicked();
                return;
            }
            return;
        }
        int i4 = C7932R.id.btn_clear_all;
        if (numValueOf != null && numValueOf.intValue() == i4) {
            SpenCrowdHwrManager spenCrowdHwrManager4 = this.mManager;
            if (spenCrowdHwrManager4 != null) {
                spenCrowdHwrManager4.onClearAllClicked();
                return;
            }
            return;
        }
        int i5 = C7932R.id.btn_undo;
        if (numValueOf == null || numValueOf.intValue() != i5 || (spenCrowdHwrManager = this.mManager) == null) {
            return;
        }
        spenCrowdHwrManager.onUndoClicked();
    }

    @Override // android.view.View
    public void onConfigurationChanged(@Nullable Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        SpenCrowdHwrManager spenCrowdHwrManager = this.mManager;
        if (spenCrowdHwrManager != null) {
            spenCrowdHwrManager.onConfigurationChanged(newConfig);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        SpenCrowdHwrManager spenCrowdHwrManager = this.mManager;
        if (spenCrowdHwrManager != null) {
            spenCrowdHwrManager.onLayout(changed, left, top, right, bottom);
        }
    }

    public final void setAccountId(@NotNull String accountId) {
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        SpenCrowdHwrManager spenCrowdHwrManager = this.mManager;
        if (spenCrowdHwrManager != null) {
            spenCrowdHwrManager.setAccountId(accountId);
        }
    }

    public final void setListener(@NotNull SpenCrowdHwrListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mCrowdHwrListener = listener;
    }

    public final void setToolType(int toolType) {
        SpenWritingView spenWritingView = this.mWritingView;
        if (spenWritingView != null) {
            spenWritingView.setToolTypeAction(1, 0);
        }
        SpenWritingView spenWritingView2 = this.mWritingView;
        if (spenWritingView2 != null) {
            spenWritingView2.setToolTypeAction(2, 0);
        }
        SpenWritingView spenWritingView3 = this.mWritingView;
        if (spenWritingView3 != null) {
            spenWritingView3.setToolTypeAction(toolType, 2);
        }
        SpenCrowdHwrManager spenCrowdHwrManager = this.mManager;
        if (spenCrowdHwrManager != null) {
            spenCrowdHwrManager.setToolType(toolType);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenCrowdHwrView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSentenceStr = "";
        this.mCrowdHwrManagerListener = new SpenCrowdHwrManagerListener() { // from class: com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.SpenCrowdHwrView$mCrowdHwrManagerListener$1
            @Override // com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.SpenCrowdHwrManagerListener
            public String getSentence() {
                return this.this$0.mSentenceStr;
            }

            @Override // com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.SpenCrowdHwrManagerListener
            public void onClearAll() {
            }

            @Override // com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.SpenCrowdHwrManagerListener
            public void onHandwritingUpdated(boolean isEmpty) {
                this.this$0.updateButtonState(isEmpty);
            }

            @Override // com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.SpenCrowdHwrManagerListener
            public void onSentenceChanged(String sentence) {
                Intrinsics.checkNotNullParameter(sentence, "sentence");
                this.this$0.mSentenceStr = sentence;
                this.this$0.setHintTextEnable(true);
                TextView textView = this.this$0.mTvSentence;
                if (textView != null) {
                    textView.setText(this.this$0.mSentenceStr);
                }
            }

            @Override // com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.SpenCrowdHwrManagerListener
            public void onSubmitted(ArrayList<String> listFile) {
                this.this$0.setHintTextEnable(true);
                SpenCrowdHwrListener spenCrowdHwrListener = this.this$0.mCrowdHwrListener;
                if (spenCrowdHwrListener != null) {
                    spenCrowdHwrListener.onSubmitted(listFile);
                }
            }

            @Override // com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.SpenCrowdHwrManagerListener
            public void onUndo() {
            }
        };
        initialize(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenCrowdHwrView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSentenceStr = "";
        this.mCrowdHwrManagerListener = new SpenCrowdHwrManagerListener() { // from class: com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.SpenCrowdHwrView$mCrowdHwrManagerListener$1
            @Override // com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.SpenCrowdHwrManagerListener
            public String getSentence() {
                return this.this$0.mSentenceStr;
            }

            @Override // com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.SpenCrowdHwrManagerListener
            public void onClearAll() {
            }

            @Override // com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.SpenCrowdHwrManagerListener
            public void onHandwritingUpdated(boolean isEmpty) {
                this.this$0.updateButtonState(isEmpty);
            }

            @Override // com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.SpenCrowdHwrManagerListener
            public void onSentenceChanged(String sentence) {
                Intrinsics.checkNotNullParameter(sentence, "sentence");
                this.this$0.mSentenceStr = sentence;
                this.this$0.setHintTextEnable(true);
                TextView textView = this.this$0.mTvSentence;
                if (textView != null) {
                    textView.setText(this.this$0.mSentenceStr);
                }
            }

            @Override // com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.SpenCrowdHwrManagerListener
            public void onSubmitted(ArrayList<String> listFile) {
                this.this$0.setHintTextEnable(true);
                SpenCrowdHwrListener spenCrowdHwrListener = this.this$0.mCrowdHwrListener;
                if (spenCrowdHwrListener != null) {
                    spenCrowdHwrListener.onSubmitted(listFile);
                }
            }

            @Override // com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.SpenCrowdHwrManagerListener
            public void onUndo() {
            }
        };
        initialize(context);
    }
}
