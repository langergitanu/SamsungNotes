package com.samsung.android.sdk.pen.recoguifeature.converttotext.floating;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.widget.glance.single.setting.view.ViewOnTouchListenerC7005f;
import com.samsung.android.sdk.pen.document.textspan.SpenForegroundColorSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.FloatingTextResult;
import com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.ResultEditText;
import com.samsung.android.sdk.pen.setting.common.SpenShowButtonShapeText;
import com.samsung.android.sdk.pen.util.color.SpenColorThemeUtil;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b#\u0018\u0000 ]2\u00020\u0001:\u0002\\]B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\nH\u0002J\u000e\u0010.\u001a\u00020,2\u0006\u0010-\u001a\u00020\nJ \u0010/\u001a\u00020,2\u0006\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020#H\u0002J\u001e\u00103\u001a\u00020,2\u0006\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020#J\u0006\u00104\u001a\u00020,J\u0010\u00105\u001a\u00020\u00152\u0006\u00106\u001a\u00020#H\u0002J\u0006\u00107\u001a\u00020,J(\u00108\u001a\u00020,2\b\u00109\u001a\u0004\u0018\u00010\u00172\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u00020;0\u001bj\b\u0012\u0004\u0012\u00020;`\u001dJ^\u0010<\u001a\u00020,2\u0006\u0010=\u001a\u00020#2\u001a\u0010>\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001d2\u001a\u0010?\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001d2\u0016\u0010@\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001dJ\u0010\u0010A\u001a\u00020,2\u0006\u0010B\u001a\u00020\nH\u0016J\u0010\u0010C\u001a\u00020,2\b\u0010D\u001a\u0004\u0018\u00010\u0019J\b\u0010E\u001a\u00020,H\u0002J0\u0010F\u001a\u00020,2\u0006\u0010G\u001a\u00020#2\u0006\u0010H\u001a\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020\n2\u0006\u0010K\u001a\u00020\nH\u0014J\u0080\u0001\u0010L\u001a\u00020,2\u0006\u0010=\u001a\u00020#2\b\u00109\u001a\u0004\u0018\u00010\u00172\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u00020;0\u001bj\b\u0012\u0004\u0012\u00020;`\u001d2\u001a\u0010>\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001d2\u001a\u0010?\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001d2\u0016\u0010@\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001dJ\u000e\u0010M\u001a\u00020,2\u0006\u0010N\u001a\u00020#J\u000e\u0010O\u001a\u00020,2\u0006\u0010P\u001a\u00020#J\u0006\u0010Q\u001a\u00020,J \u0010R\u001a\u00020\n2\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\nH\u0002J\u0010\u0010V\u001a\u00020,2\u0006\u0010P\u001a\u00020#H\u0002J \u0010W\u001a\u00020#2\u0016\u0010X\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001dH\u0002J(\u0010Y\u001a\u00020,2\u0006\u0010Z\u001a\u00020\u00172\u0016\u0010X\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001dH\u0002J\u0010\u0010[\u001a\u00020,2\u0006\u0010P\u001a\u00020#H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\"\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b\"\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006^"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/floating/FloatingTextResult;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mContext", "mGuideLayout", "mGuideView", "mInnerView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mFrameConstraintLayout", "mResultEditText", "Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/floating/ResultEditText;", "mOriginalSpannableStringBuilder", "Landroid/text/SpannableStringBuilder;", "mOriginalText", "", "mActionListener", "Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/floating/FloatingTextResult$ActionListener;", "mResultRectList", "Ljava/util/ArrayList;", "Landroid/graphics/RectF;", "Lkotlin/collections/ArrayList;", "getMResultRectList", "()Ljava/util/ArrayList;", "mResultViewRectList", "mMaxViewRectList", "isTextFocused", "", "()Z", "colorThemeUtil", "Lcom/samsung/android/sdk/pen/util/color/SpenColorThemeUtil;", "mCopyBtn", "Lcom/samsung/android/sdk/pen/setting/common/SpenShowButtonShapeText;", "mIsCenterAlign", "mIsEditTextEmpty", "setSolidColor", "", "bgColor", "setBgColorDarkMode", "updateLayout", "isDarkModeGUI", "isDarkTransparentBackground", "isDarkBackground", "construct", "removeParentView", "getCurrentSpannableStringBuilder", "isLightModeColor", "close", "setText", "text", "originalSpanList", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextSpanBase;", "setRect", "isCenterAlign", "resultRectList", "resultViewRectList", "maxViewRectList", "setLayoutDirection", "layoutDirection", "setListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setInParent", "onLayout", "changed", "left", "top", "right", "bottom", "showPreview", "showGuideView", Constants.IntentExtraValue.SHOW, "requestTextFocus", "enable", "clearSpan", "clamp", "value", VElementFormulasCmd.FMIN, VElementFormulasCmd.FMAX, "showKeyboard", "isHorizontalMultiPage", "rectList", "printRectList", "prefix", "setButtonEnable", "ActionListener", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFloatingTextResult.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatingTextResult.kt\ncom/samsung/android/sdk/pen/recoguifeature/converttotext/floating/FloatingTextResult\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,506:1\n1#2:507\n*E\n"})
public final class FloatingTextResult extends RelativeLayout {
    public static final int MAX_LINE_COUNT = 50;
    public static final int MAX_TEXT_LENGTH = 3000;

    @NotNull
    private static final String TAG = "FloatingTextResult";

    @NotNull
    private SpenColorThemeUtil colorThemeUtil;

    @Nullable
    private ActionListener mActionListener;

    @Nullable
    private Context mContext;

    @Nullable
    private SpenShowButtonShapeText mCopyBtn;

    @Nullable
    private ConstraintLayout mFrameConstraintLayout;

    @Nullable
    private RelativeLayout mGuideLayout;

    @Nullable
    private RelativeLayout mGuideView;

    @Nullable
    private ConstraintLayout mInnerView;
    private boolean mIsCenterAlign;
    private boolean mIsEditTextEmpty;

    @NotNull
    private final ArrayList<RectF> mMaxViewRectList;

    @Nullable
    private SpannableStringBuilder mOriginalSpannableStringBuilder;

    @Nullable
    private String mOriginalText;

    @Nullable
    private ResultEditText mResultEditText;

    @NotNull
    private final ArrayList<RectF> mResultRectList;

    @NotNull
    private final ArrayList<RectF> mResultViewRectList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/floating/FloatingTextResult$ActionListener;", "", "onConvert", "", "spannableStringBuilder", "Landroid/text/SpannableStringBuilder;", "rect", "Landroid/graphics/RectF;", "onCopy", "text", "", "onEditTextOverflow", "isLine", "", "onClose", "onSetting", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ActionListener {
        void onClose();

        void onConvert(@Nullable SpannableStringBuilder spannableStringBuilder, @Nullable RectF rect);

        void onCopy(@Nullable CharSequence text);

        void onEditTextOverflow(boolean isLine);

        void onSetting();
    }

    public FloatingTextResult(@Nullable Context context) {
        super(context);
        this.mResultRectList = new ArrayList<>();
        this.mResultViewRectList = new ArrayList<>();
        this.mMaxViewRectList = new ArrayList<>();
        this.mIsEditTextEmpty = true;
        this.mContext = context;
        this.colorThemeUtil = new SpenColorThemeUtil(this.mContext);
    }

    private final int clamp(int value, int min, int max) {
        return value < min ? min : value > max ? max : value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SpannableStringBuilder getCurrentSpannableStringBuilder(boolean isLightModeColor) {
        ForegroundColorSpan[] foregroundColorSpanArr;
        Editable text;
        Editable text2;
        Editable text3;
        Editable text4;
        ResultEditText resultEditText = this.mResultEditText;
        UnderlineSpan[] underlineSpanArr = null;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(resultEditText != null ? resultEditText.getText() : null);
        ResultEditText resultEditText2 = this.mResultEditText;
        if (resultEditText2 == null || (text4 = resultEditText2.getText()) == null) {
            foregroundColorSpanArr = null;
        } else {
            ResultEditText resultEditText3 = this.mResultEditText;
            foregroundColorSpanArr = (ForegroundColorSpan[]) text4.getSpans(0, resultEditText3 != null ? resultEditText3.length() : 0, ForegroundColorSpan.class);
        }
        if (foregroundColorSpanArr != null) {
            for (ForegroundColorSpan foregroundColorSpan : foregroundColorSpanArr) {
                ResultEditText resultEditText4 = this.mResultEditText;
                Integer numValueOf = (resultEditText4 == null || (text3 = resultEditText4.getText()) == null) ? null : Integer.valueOf(text3.getSpanStart(foregroundColorSpan));
                ResultEditText resultEditText5 = this.mResultEditText;
                Integer numValueOf2 = (resultEditText5 == null || (text2 = resultEditText5.getText()) == null) ? null : Integer.valueOf(text2.getSpanEnd(foregroundColorSpan));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(isLightModeColor ? this.colorThemeUtil.getColor(foregroundColorSpan.getForegroundColor()) : foregroundColorSpan.getForegroundColor()), numValueOf != null ? numValueOf.intValue() : 0, numValueOf2 != null ? numValueOf2.intValue() : 0, 34);
            }
        }
        ResultEditText resultEditText6 = this.mResultEditText;
        if (resultEditText6 != null && (text = resultEditText6.getText()) != null) {
            ResultEditText resultEditText7 = this.mResultEditText;
            underlineSpanArr = (UnderlineSpan[]) text.getSpans(0, resultEditText7 != null ? resultEditText7.length() : 0, UnderlineSpan.class);
        }
        if (underlineSpanArr != null) {
            for (UnderlineSpan underlineSpan : underlineSpanArr) {
                spannableStringBuilder.removeSpan(underlineSpan);
            }
        }
        return spannableStringBuilder;
    }

    private final boolean isHorizontalMultiPage(ArrayList<RectF> rectList) {
        if (rectList.size() <= 1) {
            return false;
        }
        int size = rectList.size();
        for (int i = 0; i < size; i++) {
            int size2 = rectList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                if (i != i2) {
                    if (rectList.get(i).left > rectList.get(i2).left && rectList.get(i).right > rectList.get(i2).right) {
                        return true;
                    }
                    if (rectList.get(i).left < rectList.get(i2).left && rectList.get(i).right < rectList.get(i2).right) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final void printRectList(String prefix, ArrayList<RectF> rectList) {
        int size = rectList.size();
        for (int i = 0; i < size; i++) {
            Log.d(TAG, prefix + "[" + i + "] (l:" + rectList.get(i).left + ", t:" + rectList.get(i).top + ", r:" + rectList.get(i).right + ", b:" + rectList.get(i).bottom + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setButtonEnable(boolean enable) {
        this.mIsEditTextEmpty = !enable;
        SpenShowButtonShapeText spenShowButtonShapeText = this.mCopyBtn;
        if (spenShowButtonShapeText != null) {
            spenShowButtonShapeText.setEnabled(enable);
        }
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

    private final void setSolidColor(int bgColor) {
        ConstraintLayout constraintLayout = this.mFrameConstraintLayout;
        Drawable background = constraintLayout != null ? constraintLayout.getBackground() : null;
        if (background instanceof ShapeDrawable) {
            ((ShapeDrawable) background).getPaint().setColor(bgColor);
        } else if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(bgColor);
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable) background).setColor(bgColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showGuideView$lambda$16(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showGuideView$lambda$17(View view, MotionEvent motionEvent) {
        return true;
    }

    private final void showKeyboard(boolean enable) {
        Context context = this.mContext;
        Object systemService = context != null ? context.getSystemService("input_method") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        if (enable) {
            inputMethodManager.showSoftInput(this.mResultEditText, 1);
            return;
        }
        ResultEditText resultEditText = this.mResultEditText;
        inputMethodManager.hideSoftInputFromWindow(resultEditText != null ? resultEditText.getWindowToken() : null, 0);
        if (this.mResultEditText == null) {
            inputMethodManager.toggleSoftInput(1, 0);
        }
    }

    private final void updateLayout(boolean isDarkModeGUI, boolean isDarkTransparentBackground, boolean isDarkBackground) {
        Resources resources;
        Resources resources2;
        Resources resources3;
        Resources resources4;
        Resources resources5;
        AbstractC0000a.m27x(AbstractC2821a.m2230u("FloatingTextResult::updateLayout isDarkModeGUI : ", ", isDarkModeStroke  : ", ", isDarkBackground : ", isDarkModeGUI, isDarkTransparentBackground), isDarkBackground, TAG);
        this.colorThemeUtil.setColorTheme(isDarkTransparentBackground ? 1 : 0);
        View viewInflate = View.inflate(this.mContext, (isDarkModeGUI && (isDarkTransparentBackground || isDarkBackground)) ? C7932R.layout.sdk_handwriting_floating_text_result_dark : C7932R.layout.sdk_handwriting_floating_text_result, null);
        ConstraintLayout constraintLayout = viewInflate instanceof ConstraintLayout ? (ConstraintLayout) viewInflate : null;
        this.mInnerView = constraintLayout;
        if (constraintLayout != null) {
            addView(constraintLayout);
            constraintLayout.setOnTouchListener(new ViewOnTouchListenerC7005f(2));
            constraintLayout.setOnHoverListener(new ViewOnHoverListenerC7469a(1));
        }
        ConstraintLayout constraintLayout2 = this.mInnerView;
        final ResultEditText resultEditText = constraintLayout2 != null ? (ResultEditText) constraintLayout2.findViewById(C7932R.id.result_edit_text) : null;
        this.mResultEditText = resultEditText;
        if (resultEditText != null) {
            resultEditText.setBackground(null);
            resultEditText.setTypeface(Typeface.create("sec-roboto-light", 0));
            resultEditText.setGravity(8388611);
            resultEditText.setTextDirection(2);
            Context context = this.mContext;
            if (context != null && (resources5 = context.getResources()) != null) {
                resultEditText.setTextSize(resources5.getDimension(C7932R.dimen.sdk_floating_convert_text_textview_font_size));
            }
            resultEditText.setPrivateImeOptions("disableDirectWriting=true;disableImage=true;disableLiveMessage=true;disableGifKeyboard=true;disableSticker=true;disableVoiceInput=true");
            resultEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.b
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    FloatingTextResult.updateLayout$lambda$5$lambda$4(resultEditText, this, view, z);
                }
            });
            resultEditText.setTextChangedListener(new ResultEditText.TextChangedListener() { // from class: com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.FloatingTextResult$updateLayout$2$3
                @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.ResultEditText.TextChangedListener
                public void onChanged(int textLength) {
                    boolean z = textLength == 0;
                    if (z != this.this$0.mIsEditTextEmpty) {
                        this.this$0.setButtonEnable(!z);
                    }
                }

                @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.ResultEditText.TextChangedListener
                public void onOverflow(boolean isLine) {
                    FloatingTextResult.ActionListener actionListener = this.this$0.mActionListener;
                    if (actionListener != null) {
                        actionListener.onEditTextOverflow(isLine);
                    }
                }
            });
        }
        ConstraintLayout constraintLayout3 = this.mInnerView;
        SpenShowButtonShapeText spenShowButtonShapeText = constraintLayout3 != null ? (SpenShowButtonShapeText) constraintLayout3.findViewById(C7932R.id.preview_convert_btn) : null;
        if (spenShowButtonShapeText != null) {
            spenShowButtonShapeText.setButtonShapeEnabled(true);
            Context context2 = this.mContext;
            String string = (context2 == null || (resources4 = context2.getResources()) == null) ? null : resources4.getString(C7932R.string.handwriting_convert_text_convert);
            Context context3 = this.mContext;
            spenShowButtonShapeText.setContentDescription(string + " " + ((context3 == null || (resources3 = context3.getResources()) == null) ? null : resources3.getString(C7932R.string.pen_string_button)));
            spenShowButtonShapeText.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.FloatingTextResult$updateLayout$3$1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    if (this.this$0.mActionListener == null || this.this$0.mOriginalSpannableStringBuilder == null) {
                        return;
                    }
                    SpannableStringBuilder currentSpannableStringBuilder = this.this$0.getCurrentSpannableStringBuilder(true);
                    RectF rectF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
                    Iterator<RectF> it = this.this$0.getMResultRectList().iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (it.hasNext()) {
                        rectF.union(it.next());
                    }
                    float f = rectF.left;
                    float f4 = rectF.top;
                    Log.d("FloatingTextResult", AbstractC1038a.m1216q(AbstractC0622a.m1176v("FloatingTextResult::onClick resultRect(l:", f, ", t:", f4, ", r:"), rectF.right, ", b:", rectF.bottom, ")"));
                    FloatingTextResult.ActionListener actionListener = this.this$0.mActionListener;
                    if (actionListener != null) {
                        actionListener.onConvert(currentSpannableStringBuilder, rectF);
                    }
                }
            });
        }
        ConstraintLayout constraintLayout4 = this.mInnerView;
        SpenShowButtonShapeText spenShowButtonShapeText2 = constraintLayout4 != null ? (SpenShowButtonShapeText) constraintLayout4.findViewById(C7932R.id.preview_copy_btn) : null;
        this.mCopyBtn = spenShowButtonShapeText2;
        if (spenShowButtonShapeText2 != null) {
            spenShowButtonShapeText2.setButtonShapeEnabled(true);
            Context context4 = this.mContext;
            String string2 = (context4 == null || (resources2 = context4.getResources()) == null) ? null : resources2.getString(C7932R.string.handwriting_convert_text_copy);
            Context context5 = this.mContext;
            spenShowButtonShapeText2.setContentDescription(string2 + " " + ((context5 == null || (resources = context5.getResources()) == null) ? null : resources.getString(C7932R.string.pen_string_button)));
            final int i = 0;
            spenShowButtonShapeText2.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.c

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ FloatingTextResult f4993b;

                {
                    this.f4993b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i) {
                        case 0:
                            FloatingTextResult.updateLayout$lambda$8$lambda$7(this.f4993b, view);
                            break;
                        case 1:
                            FloatingTextResult.updateLayout$lambda$9(this.f4993b, view);
                            break;
                        default:
                            FloatingTextResult.updateLayout$lambda$10(this.f4993b, view);
                            break;
                    }
                }
            });
        }
        ConstraintLayout constraintLayout5 = this.mInnerView;
        ImageButton imageButton = constraintLayout5 != null ? (ImageButton) constraintLayout5.findViewById(C7932R.id.preview_close_btn) : null;
        if (imageButton != null) {
            final int i2 = 1;
            imageButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.c

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ FloatingTextResult f4993b;

                {
                    this.f4993b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i2) {
                        case 0:
                            FloatingTextResult.updateLayout$lambda$8$lambda$7(this.f4993b, view);
                            break;
                        case 1:
                            FloatingTextResult.updateLayout$lambda$9(this.f4993b, view);
                            break;
                        default:
                            FloatingTextResult.updateLayout$lambda$10(this.f4993b, view);
                            break;
                    }
                }
            });
        }
        ConstraintLayout constraintLayout6 = this.mInnerView;
        ImageButton imageButton2 = constraintLayout6 != null ? (ImageButton) constraintLayout6.findViewById(C7932R.id.preview_setting_btn) : null;
        if (imageButton2 != null) {
            final int i4 = 2;
            imageButton2.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.c

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ FloatingTextResult f4993b;

                {
                    this.f4993b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i4) {
                        case 0:
                            FloatingTextResult.updateLayout$lambda$8$lambda$7(this.f4993b, view);
                            break;
                        case 1:
                            FloatingTextResult.updateLayout$lambda$9(this.f4993b, view);
                            break;
                        default:
                            FloatingTextResult.updateLayout$lambda$10(this.f4993b, view);
                            break;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateLayout$lambda$10(FloatingTextResult floatingTextResult, View view) {
        Log.d(TAG, "Extract Setting btn clicked.");
        ActionListener actionListener = floatingTextResult.mActionListener;
        if (actionListener != null) {
            actionListener.onSetting();
        }
        floatingTextResult.requestTextFocus(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateLayout$lambda$2$lambda$0(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateLayout$lambda$2$lambda$1(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateLayout$lambda$5$lambda$4(ResultEditText resultEditText, FloatingTextResult floatingTextResult, View view, boolean z) {
        int cursorIndex = resultEditText.getCursorIndex();
        if (!z && (view instanceof EditText)) {
            resultEditText.setCursorIndex(((EditText) view).getSelectionStart());
            if (floatingTextResult.mOriginalSpannableStringBuilder != null) {
                floatingTextResult.mOriginalSpannableStringBuilder = floatingTextResult.getCurrentSpannableStringBuilder(true);
            }
            floatingTextResult.showKeyboard(false);
            return;
        }
        if (cursorIndex == 0) {
            resultEditText.setSelection(resultEditText.length());
        } else {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.EditText");
            ((EditText) view).setSelection(cursorIndex, cursorIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateLayout$lambda$8$lambda$7(FloatingTextResult floatingTextResult, View view) {
        Log.d(TAG, "FloatingTextResult::Extract Copy btn clicked.");
        ActionListener actionListener = floatingTextResult.mActionListener;
        if (actionListener == null || floatingTextResult.mOriginalSpannableStringBuilder == null || actionListener == null) {
            return;
        }
        actionListener.onCopy(floatingTextResult.getCurrentSpannableStringBuilder(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateLayout$lambda$9(FloatingTextResult floatingTextResult, View view) {
        Log.d(TAG, "FloatingTextResult::Extract Close btn clicked.");
        ActionListener actionListener = floatingTextResult.mActionListener;
        if (actionListener != null) {
            actionListener.onClose();
        }
    }

    public final void clearSpan() {
        Log.d(TAG, "FloatingTextResult::clearSpan");
        SpannableStringBuilder spannableStringBuilder = this.mOriginalSpannableStringBuilder;
        if (spannableStringBuilder != null) {
            spannableStringBuilder.clear();
        }
        this.mOriginalSpannableStringBuilder = null;
        this.mOriginalText = null;
        ResultEditText resultEditText = this.mResultEditText;
        if (resultEditText != null) {
            resultEditText.setCursorIndex(0);
        }
    }

    public final void close() {
        removeAllViews();
        this.mContext = null;
    }

    public final void construct(boolean isDarkModeGUI, boolean isDarkTransparentBackground, boolean isDarkBackground) {
        updateLayout(isDarkModeGUI, isDarkTransparentBackground, isDarkBackground);
    }

    @NotNull
    public final ArrayList<RectF> getMResultRectList() {
        return this.mResultRectList;
    }

    public final boolean isTextFocused() {
        ResultEditText resultEditText = this.mResultEditText;
        if (resultEditText != null) {
            return resultEditText.isFocused();
        }
        return false;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        float f;
        float f4;
        float width;
        float f5;
        super.onLayout(changed, left, top, right, bottom);
        int i = bottom - top;
        Object parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        int width2 = ((View) parent).getWidth();
        int i2 = right - left;
        Object parent2 = getParent();
        Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.View");
        int height = ((View) parent2).getHeight();
        boolean z = this.mIsCenterAlign;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i2, i, "FloatingTextResult::onLayout w: ", ", h:", ", parentWidth:");
        AbstractC2821a.m2235z(sbM1173s, width2, height, ", parentHeight:", ", mIsCenterAlign:");
        AbstractC0000a.m27x(sbM1173s, z, TAG);
        if (this.mResultViewRectList.size() > 0 && this.mMaxViewRectList.size() > 0) {
            int size = this.mResultViewRectList.size();
            int i4 = Integer.MAX_VALUE;
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                if (!this.mResultViewRectList.get(i6).isEmpty()) {
                    if (i6 < i4) {
                        i4 = i6;
                    }
                    if (i6 > i5) {
                        i5 = i6;
                    }
                }
            }
            int dimensionPixelSize = (int) (getContext().getResources().getDimensionPixelSize(C7932R.dimen.sdk_convert_text_handle_height) / 2.0f);
            float f6 = (dimensionPixelSize * 2) + i;
            if (this.mMaxViewRectList.get(i5).bottom - this.mResultViewRectList.get(i5).bottom >= f6) {
                width = this.mResultViewRectList.get(i5).left;
                f5 = this.mResultViewRectList.get(i5).bottom + dimensionPixelSize;
                Log.i(TAG, AbstractC0541b.m770l("FloatingTextResult::onLayout 1. below the last handle x(", width, "), y(", f5, ")"));
            } else if (this.mResultViewRectList.get(i5).bottom - this.mResultViewRectList.get(i5).top >= f6) {
                float f7 = this.mResultViewRectList.get(i5).left;
                f5 = (this.mResultViewRectList.get(i5).bottom - i) - dimensionPixelSize;
                Log.i(TAG, AbstractC0541b.m770l("FloatingTextResult::onLayout 2. on the last handle x(", f7, "), y(", f5, ")"));
                width = f7;
            } else {
                if (this.mResultViewRectList.get(i4).top - this.mMaxViewRectList.get(i4).top >= f6) {
                    f = this.mResultViewRectList.get(i4).left;
                    f4 = (this.mResultViewRectList.get(i4).top - i) - dimensionPixelSize;
                    Log.i(TAG, AbstractC0541b.m770l("FloatingTextResult::onLayout 3. on the first handle x(", f, "), y(", f4, ")"));
                } else {
                    f = this.mResultViewRectList.get(i4).left;
                    f4 = (this.mResultViewRectList.get(i4).bottom - i) - dimensionPixelSize;
                    Log.i(TAG, AbstractC0541b.m770l("FloatingTextResult::onLayout 4. below the first handle x(", f, "), y(", f4, ")"));
                }
                width = f;
                f5 = f4;
            }
            if (this.mIsCenterAlign) {
                width = (width2 - getWidth()) / 2.0f;
            }
            if (width <= 0.0f) {
                width = 0.0f;
            }
            setX(width);
            if (f5 <= 0.0f) {
                f5 = 0.0f;
            }
            setY(f5);
        }
        setInParent();
    }

    public final void removeParentView() {
        if (getParent() == null || !(getParent() instanceof ViewGroup)) {
            Log.w(TAG, "FloatingTextResult::removeParentView getParent() == null || !(getParent() instanceof ViewGroup)");
            return;
        }
        ViewParent parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).removeView(this);
    }

    public final void requestTextFocus(boolean enable) {
        AbstractC6670b.m4759t("FloatingTextResult::requestTextFocus : ", TAG, enable);
        if (!enable) {
            ResultEditText resultEditText = this.mResultEditText;
            if (resultEditText != null) {
                resultEditText.clearFocus();
                return;
            }
            return;
        }
        ResultEditText resultEditText2 = this.mResultEditText;
        if (resultEditText2 == null || resultEditText2.isFocused()) {
            return;
        }
        ResultEditText resultEditText3 = this.mResultEditText;
        if (resultEditText3 != null) {
            resultEditText3.requestFocus();
        }
        showKeyboard(true);
    }

    public final void setBgColorDarkMode(int bgColor) {
        ConstraintLayout constraintLayout = this.mInnerView;
        this.mFrameConstraintLayout = constraintLayout != null ? (ConstraintLayout) constraintLayout.findViewById(C7932R.id.frame_constraint) : null;
        setSolidColor(bgColor);
    }

    @Override // android.view.View
    public void setLayoutDirection(int layoutDirection) {
        if (this.mResultEditText == null) {
            Log.e(TAG, "FloatingTextResult::mResultEditText is empty");
            return;
        }
        int i = layoutDirection == 1 ? 4 : 3;
        AbstractC6670b.m4744e(layoutDirection, i, "FloatingTextResult::setLayoutDirection layoutDirection :", ", textDirection :", TAG);
        ResultEditText resultEditText = this.mResultEditText;
        if (resultEditText != null) {
            resultEditText.setTextDirection(i);
        }
        ResultEditText resultEditText2 = this.mResultEditText;
        if (resultEditText2 != null) {
            resultEditText2.invalidate();
        }
    }

    public final void setListener(@Nullable ActionListener listener) {
        this.mActionListener = listener;
    }

    public final void setRect(boolean isCenterAlign, @Nullable ArrayList<RectF> resultRectList, @Nullable ArrayList<RectF> resultViewRectList, @NotNull ArrayList<RectF> maxViewRectList) {
        Intrinsics.checkNotNullParameter(maxViewRectList, "maxViewRectList");
        this.mIsCenterAlign = isCenterAlign || !isHorizontalMultiPage(maxViewRectList);
        this.mResultRectList.clear();
        if (resultRectList != null) {
            this.mResultRectList.addAll(resultRectList);
        }
        this.mResultViewRectList.clear();
        if (resultViewRectList != null) {
            this.mResultViewRectList.addAll(resultViewRectList);
        }
        this.mMaxViewRectList.clear();
        this.mMaxViewRectList.addAll(maxViewRectList);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void setText(@Nullable String text, @NotNull ArrayList<SpenTextSpanBase> originalSpanList) {
        SpannableStringBuilder spannableStringBuilder;
        Intrinsics.checkNotNullParameter(originalSpanList, "originalSpanList");
        if (text == null || text.length() == 0) {
            setButtonEnable(false);
            ResultEditText resultEditText = this.mResultEditText;
            if (resultEditText != null) {
                resultEditText.scrollTo(0, 0);
            }
            Log.e(TAG, "FloatingTextResult::text is empty");
            return;
        }
        AbstractC2322a.m1631u(text.length(), "FloatingTextResult::setText : ", TAG);
        String str = this.mOriginalText;
        if (str != null && !Intrinsics.areEqual(text, str)) {
            clearSpan();
        }
        if (this.mOriginalSpannableStringBuilder == null) {
            setButtonEnable(true);
            this.mOriginalSpannableStringBuilder = new SpannableStringBuilder(text);
            Iterator<SpenTextSpanBase> it = originalSpanList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                SpenTextSpanBase next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                SpenTextSpanBase spenTextSpanBase = next;
                if (spenTextSpanBase.getType() == 1 && (spannableStringBuilder = this.mOriginalSpannableStringBuilder) != null) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(((SpenForegroundColorSpan) spenTextSpanBase).getColor()), spenTextSpanBase.getStart(), spenTextSpanBase.getEnd(), 34);
                }
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.mOriginalSpannableStringBuilder);
            Iterator it2 = ArrayIteratorKt.iterator((ForegroundColorSpan[]) spannableStringBuilder2.getSpans(0, spannableStringBuilder2.length(), ForegroundColorSpan.class));
            while (it2.hasNext()) {
                ForegroundColorSpan foregroundColorSpan = (ForegroundColorSpan) it2.next();
                spannableStringBuilder2.setSpan(new ForegroundColorSpan(this.colorThemeUtil.getColor(foregroundColorSpan.getForegroundColor())), spannableStringBuilder2.getSpanStart(foregroundColorSpan), spannableStringBuilder2.getSpanEnd(foregroundColorSpan), 34);
            }
            ResultEditText resultEditText2 = this.mResultEditText;
            if (resultEditText2 != null) {
                resultEditText2.setText(spannableStringBuilder2);
            }
            this.mOriginalText = text;
        } else {
            setButtonEnable(!this.mIsEditTextEmpty);
        }
        showGuideView(false);
    }

    public final void showGuideView(boolean show) {
        if (!show) {
            RelativeLayout relativeLayout = this.mGuideView;
            if (relativeLayout != null) {
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                removeView(this.mGuideView);
                this.mGuideLayout = null;
                this.mGuideView = null;
            }
            ConstraintLayout constraintLayout = this.mInnerView;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
                return;
            }
            return;
        }
        if (this.mGuideView == null) {
            View viewInflate = View.inflate(getContext(), C7932R.layout.sdk_floating_convert_text_guide_view, null);
            RelativeLayout relativeLayout2 = viewInflate instanceof RelativeLayout ? (RelativeLayout) viewInflate : null;
            this.mGuideView = relativeLayout2;
            if (relativeLayout2 != null) {
                relativeLayout2.setOnTouchListener(new ViewOnTouchListenerC7005f(1));
            }
            RelativeLayout relativeLayout3 = this.mGuideView;
            if (relativeLayout3 != null) {
                relativeLayout3.setOnHoverListener(new ViewOnHoverListenerC7469a(0));
            }
            addView(this.mGuideView);
        }
        if (this.mGuideLayout == null) {
            RelativeLayout relativeLayout4 = this.mGuideView;
            this.mGuideLayout = relativeLayout4 != null ? (RelativeLayout) relativeLayout4.findViewById(C7932R.id.guide_view) : null;
        }
        if (getParent() != null) {
            Object parent = getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(((View) parent).getWidth(), -2);
            RelativeLayout relativeLayout5 = this.mGuideLayout;
            if (relativeLayout5 != null) {
                relativeLayout5.setLayoutParams(layoutParams);
            }
        }
        RelativeLayout relativeLayout6 = this.mGuideView;
        if (relativeLayout6 != null) {
            relativeLayout6.setVisibility(0);
        }
        ConstraintLayout constraintLayout2 = this.mInnerView;
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(8);
        }
    }

    public final void showPreview(boolean isCenterAlign, @Nullable String text, @NotNull ArrayList<SpenTextSpanBase> originalSpanList, @Nullable ArrayList<RectF> resultRectList, @Nullable ArrayList<RectF> resultViewRectList, @NotNull ArrayList<RectF> maxViewRectList) {
        Context context;
        Resources resources;
        int iWidth;
        Intrinsics.checkNotNullParameter(originalSpanList, "originalSpanList");
        Intrinsics.checkNotNullParameter(maxViewRectList, "maxViewRectList");
        setRect(isCenterAlign, resultRectList, resultViewRectList, maxViewRectList);
        setText(text, originalSpanList);
        if (this.mMaxViewRectList.size() == 0 || (context = this.mContext) == null || (resources = context.getResources()) == null) {
            return;
        }
        if (this.mIsCenterAlign) {
            Object parent = getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            iWidth = ((View) parent).getWidth();
        } else {
            iWidth = (int) this.mMaxViewRectList.get(0).width();
        }
        int iClamp = clamp(iWidth, resources.getDimensionPixelSize(C7932R.dimen.sdk_floating_convert_text_view_min_width), resources.getDimensionPixelSize(C7932R.dimen.sdk_floating_convert_text_view_max_width));
        ConstraintLayout constraintLayout = this.mInnerView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) (constraintLayout != null ? constraintLayout.getLayoutParams() : null);
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(iClamp, -2);
        } else {
            layoutParams.width = iClamp;
            layoutParams.height = -2;
        }
        ConstraintLayout constraintLayout2 = this.mInnerView;
        if (constraintLayout2 != null) {
            constraintLayout2.setLayoutParams(layoutParams);
        }
    }

    public FloatingTextResult(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mResultRectList = new ArrayList<>();
        this.mResultViewRectList = new ArrayList<>();
        this.mMaxViewRectList = new ArrayList<>();
        this.mIsEditTextEmpty = true;
        this.mContext = context;
        this.colorThemeUtil = new SpenColorThemeUtil(this.mContext);
    }

    public FloatingTextResult(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mResultRectList = new ArrayList<>();
        this.mResultViewRectList = new ArrayList<>();
        this.mMaxViewRectList = new ArrayList<>();
        this.mIsEditTextEmpty = true;
        this.mContext = context;
        this.colorThemeUtil = new SpenColorThemeUtil(this.mContext);
    }
}
