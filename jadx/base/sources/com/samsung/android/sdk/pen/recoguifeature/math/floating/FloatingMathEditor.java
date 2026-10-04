package com.samsung.android.sdk.pen.recoguifeature.math.floating;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.widget.glance.single.setting.view.ViewOnTouchListenerC7005f;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.pen.document.SpenObjectFormula;
import com.samsung.android.sdk.pen.recoguifeature.math.floating.FloatingMathEditor;
import com.samsung.android.sdk.pen.util.color.SpenColorThemeUtil;
import com.samsung.android.sdk.pen.view.SpenConfiguration;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 <2\u00020\u0001:\u0003:;<B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dJ\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0006\u0010 \u001a\u00020\u001bJ,\u0010!\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u00192\u001a\u0010#\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010%0$j\n\u0012\u0006\u0012\u0004\u0018\u00010%`&J\u001a\u0010'\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010\u00142\b\u0010)\u001a\u0004\u0018\u00010\u0014J\u0010\u0010*\u001a\u00020\u001b2\b\u0010+\u001a\u0004\u0018\u00010\u0012J0\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\nH\u0014J\b\u00102\u001a\u00020\u001bH\u0002J@\u00103\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u00192\u001a\u0010#\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010%0$j\n\u0012\u0006\u0012\u0004\u0018\u00010%`&2\b\u0010(\u001a\u0004\u0018\u00010\u00142\b\u0010)\u001a\u0004\u0018\u00010\u0014J\u000e\u00106\u001a\u00020\u001b2\u0006\u00107\u001a\u00020\u001dJ\u0006\u00108\u001a\u00020\u001bJ\u0010\u00109\u001a\u00020\u001b2\u0006\u00107\u001a\u00020\u001dH\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00104\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b4\u00105¨\u0006="}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/math/floating/FloatingMathEditor;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mContext", "mInnerView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mResultEditText", "Landroid/widget/EditText;", "mActionListener", "Lcom/samsung/android/sdk/pen/recoguifeature/math/floating/FloatingMathEditor$ActionListener;", "mWindowRect", "Landroid/graphics/RectF;", "mFrameRect", "colorThemeUtil", "Lcom/samsung/android/sdk/pen/util/color/SpenColorThemeUtil;", "mCurObjectFormula", "Lcom/samsung/android/sdk/pen/document/SpenObjectFormula;", "construct", "", "isDarkModeGUI", "", "isDarkModeStroke", "updateLayout", "close", "setText", "objectFormula", TextConst.KEY_PARAM_STRING_LIST, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "setRect", "frameRect", "windowRect", "setListener", "l", "onLayout", "changed", "left", "top", "right", "bottom", "setInParent", "showPreview", "isTextFocused", "()Z", "requestTextFocus", "enable", "clearSpan", "showKeyboard", "ActionListener", "ResultEditText", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFloatingMathEditor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatingMathEditor.kt\ncom/samsung/android/sdk/pen/recoguifeature/math/floating/FloatingMathEditor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,400:1\n1#2:401\n*E\n"})
public final class FloatingMathEditor extends RelativeLayout {

    @NotNull
    private SpenColorThemeUtil colorThemeUtil;

    @Nullable
    private ActionListener mActionListener;

    @Nullable
    private Context mContext;

    @Nullable
    private SpenObjectFormula mCurObjectFormula;

    @Nullable
    private RectF mFrameRect;

    @Nullable
    private ConstraintLayout mInnerView;

    @Nullable
    private EditText mResultEditText;

    @Nullable
    private RectF mWindowRect;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_TEXT_LENGTH = 3000;
    private static final int MAX_LINE_COUNT = 50;

    @NotNull
    private static final String TAG = "FloatingMathEditor";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\bH&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/math/floating/FloatingMathEditor$ActionListener;", "", "onConvert", "", "objectFormula", "Lcom/samsung/android/sdk/pen/document/SpenObjectFormula;", TextConst.KEY_PARAM_STRING_LIST, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "onCopy", "formulaResult", "onClose", "onSetting", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ActionListener {
        void onClose();

        void onConvert(@Nullable SpenObjectFormula objectFormula, @Nullable ArrayList<String> stringList);

        void onCopy(@Nullable String formulaResult);

        void onSetting();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/math/floating/FloatingMathEditor$Companion;", "", "<init>", "()V", "MAX_TEXT_LENGTH", "", "getMAX_TEXT_LENGTH", "()I", "MAX_LINE_COUNT", "getMAX_LINE_COUNT", SearchConstants.TargetContents.TAG, "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getMAX_LINE_COUNT() {
            return FloatingMathEditor.MAX_LINE_COUNT;
        }

        public final int getMAX_TEXT_LENGTH() {
            return FloatingMathEditor.MAX_TEXT_LENGTH;
        }

        private Companion() {
        }
    }

    public FloatingMathEditor(@Nullable Context context) {
        super(context);
        this.mContext = context;
        this.colorThemeUtil = new SpenColorThemeUtil(this.mContext);
    }

    private final void setInParent() {
        Object parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        int height = ((View) parent).getHeight();
        float y2 = getY();
        if (getHeight() + y2 > height) {
            setY(height - getHeight());
        }
        if (y2 < 0.0f) {
            setY(0.0f);
        }
    }

    private final void showKeyboard(boolean enable) {
        Context context = this.mContext;
        Object systemService = context != null ? context.getSystemService("input_method") : null;
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (enable) {
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.mResultEditText, 1);
            }
        } else {
            if (enable || inputMethodManager == null || !inputMethodManager.isActive()) {
                return;
            }
            inputMethodManager.toggleSoftInput(1, 0);
        }
    }

    private final void updateLayout(boolean isDarkModeGUI, boolean isDarkModeStroke) {
        Resources resources;
        Resources resources2;
        Resources resources3;
        Resources resources4;
        this.colorThemeUtil.setColorTheme(isDarkModeStroke ? 1 : 0);
        View viewInflate = View.inflate(this.mContext, C7932R.layout.sdk_floating_math_editor, null);
        ConstraintLayout constraintLayout = viewInflate instanceof ConstraintLayout ? (ConstraintLayout) viewInflate : null;
        this.mInnerView = constraintLayout;
        int dimensionPixelSize = 0;
        if (constraintLayout != null) {
            addView(constraintLayout);
            Context context = this.mContext;
            if (context != null) {
                SpenConfiguration.Companion companion = SpenConfiguration.INSTANCE;
                Intrinsics.checkNotNull(context);
                if (companion.isTabletDevice(context)) {
                    Context context2 = this.mContext;
                    Integer numValueOf = (context2 == null || (resources4 = context2.getResources()) == null) ? null : Integer.valueOf(resources4.getDimensionPixelSize(C7932R.dimen.sdk_floating_convert_text_view_max_width));
                    constraintLayout.setLayoutParams(new RelativeLayout.LayoutParams(numValueOf != null ? numValueOf.intValue() : 0, -2));
                }
            }
            constraintLayout.setOnTouchListener(new ViewOnTouchListenerC7005f(4));
            constraintLayout.setOnHoverListener(new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.recoguifeature.math.floating.FloatingMathEditor$updateLayout$1$2
                @Override // android.view.View.OnHoverListener
                public boolean onHover(View v, MotionEvent event) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    Intrinsics.checkNotNullParameter(event, "event");
                    return true;
                }
            });
        }
        Context context3 = this.mContext;
        final ResultEditText resultEditText = context3 != null ? new ResultEditText(this, context3) : null;
        this.mResultEditText = resultEditText;
        if (resultEditText != null) {
            resultEditText.setBackground(null);
            resultEditText.setTypeface(Typeface.create("sec-roboto-light", 0));
            resultEditText.setGravity(3);
            resultEditText.setOverScrollMode(0);
            resultEditText.setScrollBarFadeDuration(0);
            resultEditText.setScrollBarStyle(16777216);
            resultEditText.setVerticalScrollBarEnabled(true);
            Context context4 = this.mContext;
            resultEditText.setTextSize((context4 == null || (resources3 = context4.getResources()) == null) ? 0.0f : resources3.getDimension(C7932R.dimen.sdk_floating_convert_text_textview_font_size));
            resultEditText.setPrivateImeOptions("disableDirectWriting=true;");
            Context context5 = this.mContext;
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, (context5 == null || (resources2 = context5.getResources()) == null) ? 0 : resources2.getDimensionPixelSize(C7932R.dimen.sdk_floating_convert_text_textview_height));
            layoutParams.endToStart = C7932R.id.preview_close_btn;
            layoutParams.topToBottom = C7932R.id.preview_setting_btn;
            Context context6 = this.mContext;
            if (context6 != null && (resources = context6.getResources()) != null) {
                dimensionPixelSize = resources.getDimensionPixelSize(C7932R.dimen.sdk_floating_convert_text_setting_btn_margin_bottom);
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = dimensionPixelSize;
            resultEditText.setLayoutParams(layoutParams);
            ConstraintLayout constraintLayout2 = this.mInnerView;
            View viewFindViewById = constraintLayout2 != null ? constraintLayout2.findViewById(C7932R.id.top_constraint) : null;
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            ((ConstraintLayout) viewFindViewById).addView(this.mResultEditText, 2);
            resultEditText.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "hme/fonts/MathJax_AMS-Regular.otf"));
            ConstraintLayout constraintLayout3 = this.mInnerView;
            Button button = constraintLayout3 != null ? (Button) constraintLayout3.findViewById(C7932R.id.preview_convert_btn) : null;
            if (button != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.recoguifeature.math.floating.FloatingMathEditor$updateLayout$3$1
                    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
                    /* JADX WARN: Removed duplicated region for block: B:30:0x0090 A[LOOP:1: B:29:0x008e->B:30:0x0090, LOOP_END] */
                    /* JADX WARN: Removed duplicated region for block: B:33:0x00b5  */
                    @Override // android.view.View.OnClickListener
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void onClick(View v) {
                        FloatingMathEditor.ActionListener actionListener;
                        List listM13999t;
                        List listEmptyList;
                        Intrinsics.checkNotNullParameter(v, "v");
                        Log.d(FloatingMathEditor.TAG, "FloatingMathEditor::onClick() Convert btn clicked. mCurObjectFormula : " + this.this$0.mCurObjectFormula);
                        if (this.this$0.mActionListener != null && this.this$0.mCurObjectFormula != null) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            Editable text = resultEditText.getText();
                            String string = text != null ? text.toString() : null;
                            if (string == null || (listM13999t = AbstractC12991c.m13999t(0, "\n", string)) == null) {
                                String[] strArr = new String[0];
                                for (String str : strArr) {
                                    Log.d(FloatingMathEditor.TAG, "FloatingMathEditor::onClick() Result : " + str);
                                    arrayList.add(str);
                                }
                                actionListener = this.this$0.mActionListener;
                                if (actionListener != null) {
                                    actionListener.onConvert(this.this$0.mCurObjectFormula, arrayList);
                                }
                            } else if (listM13999t.isEmpty()) {
                                listEmptyList = CollectionsKt.emptyList();
                                if (listEmptyList != null) {
                                    String[] strArr2 = new String[0];
                                    while (i < r3) {
                                    }
                                    actionListener = this.this$0.mActionListener;
                                    if (actionListener != null) {
                                    }
                                }
                            } else {
                                ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
                                while (listIterator.hasPrevious()) {
                                    if (((String) listIterator.previous()).length() != 0) {
                                        listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                                        break;
                                    }
                                }
                                listEmptyList = CollectionsKt.emptyList();
                                if (listEmptyList != null || (strArr2 = (String[]) listEmptyList.toArray(new String[0])) == null) {
                                }
                                while (i < r3) {
                                }
                                actionListener = this.this$0.mActionListener;
                                if (actionListener != null) {
                                }
                            }
                        }
                        this.this$0.mCurObjectFormula = null;
                    }
                });
            }
        }
        ConstraintLayout constraintLayout4 = this.mInnerView;
        Button button2 = constraintLayout4 != null ? (Button) constraintLayout4.findViewById(C7932R.id.preview_copy_btn) : null;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.recoguifeature.math.floating.FloatingMathEditor.updateLayout.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    Editable text;
                    Intrinsics.checkNotNullParameter(v, "v");
                    Log.d(FloatingMathEditor.TAG, "FloatingMathEditor::onClick() Copy btn clicked.");
                    ActionListener actionListener = FloatingMathEditor.this.mActionListener;
                    if (actionListener != null) {
                        EditText editText = FloatingMathEditor.this.mResultEditText;
                        actionListener.onCopy((editText == null || (text = editText.getText()) == null) ? null : text.toString());
                    }
                }
            });
        }
        ConstraintLayout constraintLayout5 = this.mInnerView;
        ImageButton imageButton = constraintLayout5 != null ? (ImageButton) constraintLayout5.findViewById(C7932R.id.preview_close_btn) : null;
        if (imageButton != null) {
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.recoguifeature.math.floating.FloatingMathEditor.updateLayout.5
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    Log.d(FloatingMathEditor.TAG, "FloatingMathEditor::onClick() Close btn clicked.");
                    FloatingMathEditor.this.mCurObjectFormula = null;
                    ActionListener actionListener = FloatingMathEditor.this.mActionListener;
                    if (actionListener != null) {
                        actionListener.onClose();
                    }
                }
            });
        }
        ConstraintLayout constraintLayout6 = this.mInnerView;
        ImageButton imageButton2 = constraintLayout6 != null ? (ImageButton) constraintLayout6.findViewById(C7932R.id.preview_setting_btn) : null;
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.recoguifeature.math.floating.FloatingMathEditor.updateLayout.6
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    Log.d(FloatingMathEditor.TAG, "FloatingMathEditor::onClick() Setting btn clicked.");
                    ActionListener actionListener = FloatingMathEditor.this.mActionListener;
                    if (actionListener != null) {
                        actionListener.onSetting();
                    }
                    FloatingMathEditor.this.requestTextFocus(false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateLayout$lambda$1$lambda$0(View view, MotionEvent motionEvent) {
        return true;
    }

    public final void clearSpan() {
        Log.d(TAG, "FloatingMathEditor::clearSpan");
        ResultEditText resultEditText = (ResultEditText) this.mResultEditText;
        if (resultEditText != null) {
            resultEditText.resetCursor();
        }
    }

    public final void close() {
        this.mCurObjectFormula = null;
        removeAllViews();
    }

    public final void construct(boolean isDarkModeGUI, boolean isDarkModeStroke) {
        updateLayout(isDarkModeGUI, isDarkModeStroke);
    }

    public final boolean isTextFocused() {
        EditText editText = this.mResultEditText;
        if (editText != null) {
            return editText.isFocused();
        }
        return false;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        float fHeight;
        super.onLayout(changed, left, top, right, bottom);
        int i = bottom - top;
        Object parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        int width = ((View) parent).getWidth();
        String str = TAG;
        int i2 = right - left;
        Object parent2 = getParent();
        Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.View");
        int height = ((View) parent2).getHeight();
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i2, i, "FloatingMathEditor::onLayout w: ", ", h:", ", parentWidth:");
        sbM1173s.append(width);
        sbM1173s.append(", parentHeight:");
        sbM1173s.append(height);
        Log.i(str, sbM1173s.toString());
        float width2 = (width - getWidth()) / 2.0f;
        if (width2 <= 0.0f) {
            width2 = 0.0f;
        }
        setX(width2);
        if (this.mWindowRect != null && this.mFrameRect != null) {
            RectF rectF = new RectF(this.mWindowRect);
            RectF rectF2 = new RectF(this.mFrameRect);
            float f = rectF2.left;
            if (f < 0.0f) {
                f = 0.0f;
            }
            rectF2.left = f;
            float f4 = rectF2.top;
            if (f4 < 0.0f) {
                f4 = 0.0f;
            }
            rectF2.top = f4;
            float f5 = rectF2.right;
            float f6 = rectF.right;
            if (f5 > f6) {
                f5 = f6;
            }
            rectF2.right = f5;
            float f7 = rectF2.bottom;
            float f8 = rectF.bottom;
            if (f7 > f8) {
                f7 = f8;
            }
            rectF2.bottom = f7;
            Log.d(str, "FloatingMathEditor::onLayout frameRect: " + rectF2 + ", windowRect:" + rectF);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(C7932R.dimen.sdk_floating_convert_text_preview_horizontal_margin);
            float f9 = rectF2.top - rectF.top;
            float f10 = rectF.bottom - rectF2.bottom;
            Log.i(str, "FloatingMathEditor::onLayout topDiff: " + f9 + ", bottomDiff:" + f10);
            float f11 = (float) ((dimensionPixelSize * 2) + i);
            if (f9 >= f11 || f10 >= f11) {
                fHeight = f9 > f10 ? (rectF2.top - i) - dimensionPixelSize : rectF2.bottom + dimensionPixelSize;
                Log.d(str, "FloatingMathEditor::onLayout 1. Out of frame : y = " + fHeight);
            } else if ((rectF.height() - f9) - f10 >= f11) {
                fHeight = f9 > f10 ? rectF2.top + dimensionPixelSize : (rectF2.bottom - i) - dimensionPixelSize;
                Log.d(str, "FloatingMathEditor::onLayout 2. In frame frame : y = " + fHeight);
            } else {
                fHeight = f9 > f10 ? dimensionPixelSize : (rectF.height() - i) - dimensionPixelSize;
                Log.d(str, "FloatingMathEditor::onLayout 3. Top or Bot on window : y = " + fHeight);
            }
            setY(fHeight > 0.0f ? fHeight : 0.0f);
        }
        setInParent();
    }

    public final void requestTextFocus(boolean enable) {
        EditText editText = this.mResultEditText;
        if (editText != null) {
            AbstractC6670b.m4759t("FloatingMathEditor::requestTextFocus : ", TAG, enable);
            if (!enable) {
                editText.clearFocus();
                return;
            }
            editText.clearFocus();
            editText.requestFocus();
            showKeyboard(true);
        }
    }

    public final void setListener(@Nullable ActionListener l) {
        this.mActionListener = l;
    }

    public final void setRect(@Nullable RectF frameRect, @Nullable RectF windowRect) {
        RectF rectF;
        Log.i(TAG, "FloatingMathEditor::setRect frameRect: " + frameRect + ", windowRect:" + windowRect);
        RectF rectF2 = this.mWindowRect;
        if (rectF2 == null) {
            rectF2 = new RectF();
        }
        this.mWindowRect = rectF2;
        if (windowRect == null) {
            Object parent = getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            int height = ((View) parent).getHeight();
            Object parent2 = getParent();
            Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.View");
            int width = ((View) parent2).getWidth();
            RectF rectF3 = this.mWindowRect;
            if (rectF3 != null) {
                rectF3.set(0.0f, 0.0f, width, height);
            }
        } else {
            this.mWindowRect = windowRect;
        }
        RectF rectF4 = this.mWindowRect;
        if (rectF4 != null && !rectF4.isEmpty()) {
            RectF rectF5 = this.mWindowRect;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(rectF5 != null ? (int) rectF5.width() : 0, -2);
            ConstraintLayout constraintLayout = this.mInnerView;
            if (constraintLayout != null) {
                constraintLayout.setLayoutParams(layoutParams);
            }
        }
        RectF rectF6 = this.mFrameRect;
        if (rectF6 == null) {
            rectF6 = new RectF();
        }
        this.mFrameRect = rectF6;
        if (frameRect != null) {
            this.mFrameRect = frameRect;
            return;
        }
        ConstraintLayout constraintLayout2 = this.mInnerView;
        Integer numValueOf = constraintLayout2 != null ? Integer.valueOf(constraintLayout2.getHeight()) : null;
        Object parent3 = getParent();
        Intrinsics.checkNotNull(parent3, "null cannot be cast to non-null type android.view.View");
        int width2 = ((View) parent3).getWidth();
        if (numValueOf == null || (rectF = this.mFrameRect) == null) {
            return;
        }
        rectF.set(0.0f, 0.0f, numValueOf.intValue(), width2);
    }

    public final void setText(@Nullable SpenObjectFormula objectFormula, @NotNull ArrayList<String> stringList) {
        EditText editText;
        Intrinsics.checkNotNullParameter(stringList, "stringList");
        this.mCurObjectFormula = objectFormula;
        EditText editText2 = this.mResultEditText;
        if (editText2 != null) {
            editText2.setText("");
        }
        int size = stringList.size();
        for (int i = 0; i < size; i++) {
            String str = stringList.get(i);
            String str2 = TAG;
            AbstractC2322a.m1609C("setText : ", str, str2);
            if (str == null || str.length() == 0) {
                EditText editText3 = this.mResultEditText;
                if (editText3 != null) {
                    editText3.scrollTo(0, 0);
                }
                Log.d(str2, "FloatingMathEditor::setText() text is empty");
                return;
            }
            EditText editText4 = this.mResultEditText;
            if (editText4 != null) {
                editText4.append(str);
            }
            if (i < size - 1 && (editText = this.mResultEditText) != null) {
                editText.append("\n");
            }
        }
    }

    public final void showPreview(@Nullable SpenObjectFormula objectFormula, @NotNull ArrayList<String> stringList, @Nullable RectF frameRect, @Nullable RectF windowRect) {
        Intrinsics.checkNotNullParameter(stringList, "stringList");
        setText(objectFormula, stringList);
        setRect(frameRect, windowRect);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0006\u0010\u0015\u001a\u00020\u000fR\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/math/floating/FloatingMathEditor$ResultEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "<init>", "(Lcom/samsung/android/sdk/pen/recoguifeature/math/floating/FloatingMathEditor;Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Lcom/samsung/android/sdk/pen/recoguifeature/math/floating/FloatingMathEditor;Landroid/content/Context;Landroid/util/AttributeSet;)V", "mContext", "cursorIndex", "", "textWatcher", "Landroid/text/TextWatcher;", "onAttachedToWindow", "", "onDetachedFromWindow", "dispatchKeyEventPreIme", "", "event", "Landroid/view/KeyEvent;", "resetCursor", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class ResultEditText extends AppCompatEditText {
        private int cursorIndex;

        @NotNull
        private Context mContext;

        @NotNull
        private final TextWatcher textWatcher;
        final /* synthetic */ FloatingMathEditor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResultEditText(@NotNull final FloatingMathEditor floatingMathEditor, Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = floatingMathEditor;
            this.textWatcher = new TextWatcher() { // from class: com.samsung.android.sdk.pen.recoguifeature.math.floating.FloatingMathEditor$ResultEditText$textWatcher$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    Editable text;
                    Editable text2;
                    Intrinsics.checkNotNullParameter(s, "s");
                    EditText editText = floatingMathEditor.mResultEditText;
                    Layout layout = editText != null ? editText.getLayout() : null;
                    if (layout != null) {
                        int lineCount = layout.getLineCount();
                        FloatingMathEditor.Companion companion = FloatingMathEditor.INSTANCE;
                        if (lineCount > companion.getMAX_LINE_COUNT()) {
                            Log.d(FloatingMathEditor.TAG, "FloatingMathEditor::mTextView.afterTextChanged Overflow (BEFORE lineCount : " + layout.getLineCount() + ")");
                            int lineEnd = layout.getLineEnd(companion.getMAX_LINE_COUNT() + (-1));
                            EditText editText2 = floatingMathEditor.mResultEditText;
                            if (editText2 != null && (text2 = editText2.getText()) != null) {
                                EditText editText3 = floatingMathEditor.mResultEditText;
                                text2.delete(lineEnd, editText3 != null ? editText3.length() : 0);
                            }
                            Log.d(FloatingMathEditor.TAG, "FloatingMathEditor::mResultEditText.afterTextChanged Overflow (AFTER lineCount : " + layout.getLineCount() + ")");
                            return;
                        }
                    }
                    int length = s.length();
                    FloatingMathEditor.Companion companion2 = FloatingMathEditor.INSTANCE;
                    if (length > companion2.getMAX_TEXT_LENGTH()) {
                        Log.d(FloatingMathEditor.TAG, "FloatingMathEditor::mResultEditText.afterTextChanged Overflow (BEFORE length : " + s.length() + ")");
                        EditText editText4 = floatingMathEditor.mResultEditText;
                        if (editText4 != null && (text = editText4.getText()) != null) {
                            int max_text_length = companion2.getMAX_TEXT_LENGTH();
                            EditText editText5 = floatingMathEditor.mResultEditText;
                            text.delete(max_text_length, editText5 != null ? editText5.length() : 0);
                        }
                        Log.d(FloatingMathEditor.TAG, "FloatingMathEditor::mResultEditText.afterTextChanged Overflow (AFTER length : " + s.length() + ")");
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    Intrinsics.checkNotNullParameter(s, "s");
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    Intrinsics.checkNotNullParameter(s, "s");
                }
            };
            this.mContext = context;
        }

        @Override // android.view.View
        public boolean dispatchKeyEventPreIme(@NotNull KeyEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getKeyCode() != 4) {
                return super.dispatchKeyEventPreIme(event);
            }
            EditText editText = this.this$0.mResultEditText;
            if (editText == null) {
                return true;
            }
            editText.clearFocus();
            return true;
        }

        @Override // android.widget.TextView, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            addTextChangedListener(this.textWatcher);
            final FloatingMathEditor floatingMathEditor = this.this$0;
            setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.samsung.android.sdk.pen.recoguifeature.math.floating.FloatingMathEditor$ResultEditText$onAttachedToWindow$1
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean hasFocus) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (!hasFocus && (view instanceof EditText)) {
                        this.this$0.cursorIndex = ((EditText) view).getSelectionStart();
                        return;
                    }
                    if (this.this$0.cursorIndex != 0) {
                        ((EditText) view).setSelection(this.this$0.cursorIndex, this.this$0.cursorIndex);
                        return;
                    }
                    EditText editText = floatingMathEditor.mResultEditText;
                    if (editText != null) {
                        EditText editText2 = floatingMathEditor.mResultEditText;
                        editText.setSelection(editText2 != null ? editText2.length() : 0);
                    }
                }
            });
        }

        @Override // androidx.appcompat.widget.AppCompatEditText, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            removeTextChangedListener(this.textWatcher);
        }

        public final void resetCursor() {
            this.cursorIndex = 0;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResultEditText(@NotNull final FloatingMathEditor floatingMathEditor, @Nullable Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = floatingMathEditor;
            this.textWatcher = new TextWatcher() { // from class: com.samsung.android.sdk.pen.recoguifeature.math.floating.FloatingMathEditor$ResultEditText$textWatcher$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    Editable text;
                    Editable text2;
                    Intrinsics.checkNotNullParameter(s, "s");
                    EditText editText = floatingMathEditor.mResultEditText;
                    Layout layout = editText != null ? editText.getLayout() : null;
                    if (layout != null) {
                        int lineCount = layout.getLineCount();
                        FloatingMathEditor.Companion companion = FloatingMathEditor.INSTANCE;
                        if (lineCount > companion.getMAX_LINE_COUNT()) {
                            Log.d(FloatingMathEditor.TAG, "FloatingMathEditor::mTextView.afterTextChanged Overflow (BEFORE lineCount : " + layout.getLineCount() + ")");
                            int lineEnd = layout.getLineEnd(companion.getMAX_LINE_COUNT() + (-1));
                            EditText editText2 = floatingMathEditor.mResultEditText;
                            if (editText2 != null && (text2 = editText2.getText()) != null) {
                                EditText editText3 = floatingMathEditor.mResultEditText;
                                text2.delete(lineEnd, editText3 != null ? editText3.length() : 0);
                            }
                            Log.d(FloatingMathEditor.TAG, "FloatingMathEditor::mResultEditText.afterTextChanged Overflow (AFTER lineCount : " + layout.getLineCount() + ")");
                            return;
                        }
                    }
                    int length = s.length();
                    FloatingMathEditor.Companion companion2 = FloatingMathEditor.INSTANCE;
                    if (length > companion2.getMAX_TEXT_LENGTH()) {
                        Log.d(FloatingMathEditor.TAG, "FloatingMathEditor::mResultEditText.afterTextChanged Overflow (BEFORE length : " + s.length() + ")");
                        EditText editText4 = floatingMathEditor.mResultEditText;
                        if (editText4 != null && (text = editText4.getText()) != null) {
                            int max_text_length = companion2.getMAX_TEXT_LENGTH();
                            EditText editText5 = floatingMathEditor.mResultEditText;
                            text.delete(max_text_length, editText5 != null ? editText5.length() : 0);
                        }
                        Log.d(FloatingMathEditor.TAG, "FloatingMathEditor::mResultEditText.afterTextChanged Overflow (AFTER length : " + s.length() + ")");
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    Intrinsics.checkNotNullParameter(s, "s");
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    Intrinsics.checkNotNullParameter(s, "s");
                }
            };
            this.mContext = context;
        }
    }

    public FloatingMathEditor(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.colorThemeUtil = new SpenColorThemeUtil(this.mContext);
    }

    public FloatingMathEditor(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        this.colorThemeUtil = new SpenColorThemeUtil(this.mContext);
    }
}
