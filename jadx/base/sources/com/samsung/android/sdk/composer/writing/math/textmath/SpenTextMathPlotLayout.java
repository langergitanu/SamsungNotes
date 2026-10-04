package com.samsung.android.sdk.composer.writing.math.textmath;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Size;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.recogengine.hme.SpenHmeRenderer;
import com.samsung.android.sdk.pen.recogengine.hme.SpenHmeRendererSettings;
import com.samsung.android.sdk.pen.recoguifeature.math.SpenMathResourceExtractor;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001;B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010/\u001a\u000200J\u0018\u00101\u001a\u0002002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0014J\u0010\u00106\u001a\u0002002\b\u00107\u001a\u0004\u0018\u00010.J\u001c\u00108\u001a\u0004\u0018\u00010%2\u0006\u00109\u001a\u00020\n2\b\u0010:\u001a\u0004\u0018\u00010\nH\u0002R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/writing/math/textmath/SpenTextMathPlotLayout;", "Landroid/widget/LinearLayout;", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "setMContext", SearchConstants.TargetContents.TAG, "", "mResultLayout", "Landroid/widget/FrameLayout;", "getMResultLayout", "()Landroid/widget/FrameLayout;", "setMResultLayout", "(Landroid/widget/FrameLayout;)V", "mGraphButton", "getMGraphButton", "()Landroid/widget/LinearLayout;", "setMGraphButton", "(Landroid/widget/LinearLayout;)V", "mResultButton", "Landroid/widget/ImageView;", "getMResultButton", "()Landroid/widget/ImageView;", "setMResultButton", "(Landroid/widget/ImageView;)V", "mResultContent", "getMResultContent", "setMResultContent", "mFontPath", "getMFontPath", "()Ljava/lang/String;", "setMFontPath", "(Ljava/lang/String;)V", "mLatexBitmap", "Landroid/graphics/Bitmap;", "getMLatexBitmap", "()Landroid/graphics/Bitmap;", "setMLatexBitmap", "(Landroid/graphics/Bitmap;)V", "mLatex", "getMLatex", "setMLatex", "mListener", "Lcom/samsung/android/sdk/composer/writing/math/textmath/SpenTextMathPlotLayout$OnClickedListener;", "close", "", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "", "setOnClickedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "render", "latexContent", "fontPath", "OnClickedListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenTextMathPlotLayout extends LinearLayout {

    @NotNull
    private final String TAG;

    @Nullable
    private Context mContext;

    @Nullable
    private String mFontPath;

    @NotNull
    private LinearLayout mGraphButton;

    @Nullable
    private String mLatex;

    @Nullable
    private Bitmap mLatexBitmap;

    @Nullable
    private OnClickedListener mListener;

    @NotNull
    private ImageView mResultButton;

    @NotNull
    private ImageView mResultContent;

    @NotNull
    private FrameLayout mResultLayout;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/writing/math/textmath/SpenTextMathPlotLayout$OnClickedListener;", "", "onGraphButtonClicked", "", "onGetResultLatex", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnClickedListener {
        @Nullable
        String onGetResultLatex();

        void onGraphButtonClicked();
    }

    public SpenTextMathPlotLayout(@Nullable Context context) {
        super(context);
        this.mContext = context;
        this.TAG = "SpenTextMathGraphLayout";
        Object systemService = context != null ? context.getSystemService("layout_inflater") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ((LayoutInflater) systemService).inflate(C7932R.layout.text_math_plot_menu_layout, (ViewGroup) this, true);
        FrameLayout frameLayout = (FrameLayout) findViewById(C7932R.id.text_math_result_layout);
        this.mResultLayout = frameLayout;
        frameLayout.setVisibility(4);
        this.mResultContent = (ImageView) findViewById(C7932R.id.text_math_result_content);
        this.mFontPath = SpenMathResourceExtractor.copyOtfFontsFromAssets(this.mContext);
        LinearLayout linearLayout = (LinearLayout) findViewById(C7932R.id.text_math_graph_button);
        this.mGraphButton = linearLayout;
        final int i = 0;
        linearLayout.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.composer.writing.math.textmath.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenTextMathPlotLayout f4869b;

            {
                this.f4869b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        SpenTextMathPlotLayout._init_$lambda$0(this.f4869b, view);
                        break;
                    default:
                        SpenTextMathPlotLayout._init_$lambda$1(this.f4869b, view);
                        break;
                }
            }
        });
        ImageView imageView = (ImageView) findViewById(C7932R.id.text_math_result_button);
        this.mResultButton = imageView;
        final int i2 = 1;
        imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.composer.writing.math.textmath.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenTextMathPlotLayout f4869b;

            {
                this.f4869b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        SpenTextMathPlotLayout._init_$lambda$0(this.f4869b, view);
                        break;
                    default:
                        SpenTextMathPlotLayout._init_$lambda$1(this.f4869b, view);
                        break;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(SpenTextMathPlotLayout spenTextMathPlotLayout, View view) {
        Log.d(spenTextMathPlotLayout.TAG, "mGraphButton click");
        OnClickedListener onClickedListener = spenTextMathPlotLayout.mListener;
        if (onClickedListener == null || onClickedListener == null) {
            return;
        }
        onClickedListener.onGraphButtonClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(SpenTextMathPlotLayout spenTextMathPlotLayout, View view) {
        String strOnGetResultLatex;
        String str;
        Log.d(spenTextMathPlotLayout.TAG, "mResultButton click");
        OnClickedListener onClickedListener = spenTextMathPlotLayout.mListener;
        if (onClickedListener == null || onClickedListener == null || (strOnGetResultLatex = onClickedListener.onGetResultLatex()) == null) {
            return;
        }
        if (spenTextMathPlotLayout.mResultLayout.getVisibility() == 0) {
            spenTextMathPlotLayout.mResultLayout.setVisibility(4);
            return;
        }
        if (spenTextMathPlotLayout.mLatexBitmap == null || (str = spenTextMathPlotLayout.mLatex) == null || str.compareTo(strOnGetResultLatex) != 0) {
            spenTextMathPlotLayout.mLatexBitmap = spenTextMathPlotLayout.render(strOnGetResultLatex, spenTextMathPlotLayout.mFontPath);
            spenTextMathPlotLayout.mLatex = strOnGetResultLatex;
        }
        spenTextMathPlotLayout.mResultContent.setImageBitmap(spenTextMathPlotLayout.mLatexBitmap);
        spenTextMathPlotLayout.mResultLayout.setVisibility(0);
    }

    private final Bitmap render(String latexContent, String fontPath) {
        Resources resources;
        AbstractC2322a.m1609C("render# latexContent ", latexContent, this.TAG);
        Context context = this.mContext;
        DisplayMetrics displayMetrics = null;
        if (context == null || fontPath == null) {
            return null;
        }
        if (context != null && (resources = context.getResources()) != null) {
            displayMetrics = resources.getDisplayMetrics();
        }
        float fApplyDimension = TypedValue.applyDimension(2, 6.0f, displayMetrics);
        SpenHmeRendererSettings spenHmeRendererSettings = new SpenHmeRendererSettings();
        spenHmeRendererSettings.setTextColor(-16777216);
        spenHmeRendererSettings.setBgColor(0);
        SpenHmeRenderer spenHmeRenderer = new SpenHmeRenderer(fontPath, fApplyDimension, 160.0f, spenHmeRendererSettings);
        Size sizeLayout = spenHmeRenderer.layout(latexContent);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(sizeLayout.getWidth(), sizeLayout.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        spenHmeRenderer.render(bitmapCreateBitmap, new PointF(), 1.0f);
        spenHmeRenderer.close();
        return bitmapCreateBitmap;
    }

    public final void close() {
        this.mContext = null;
        this.mFontPath = null;
        Bitmap bitmap = this.mLatexBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.mLatexBitmap = null;
        this.mLatex = null;
        this.mListener = null;
    }

    @Nullable
    public final Context getMContext() {
        return this.mContext;
    }

    @Nullable
    public final String getMFontPath() {
        return this.mFontPath;
    }

    @NotNull
    public final LinearLayout getMGraphButton() {
        return this.mGraphButton;
    }

    @Nullable
    public final String getMLatex() {
        return this.mLatex;
    }

    @Nullable
    public final Bitmap getMLatexBitmap() {
        return this.mLatexBitmap;
    }

    @NotNull
    public final ImageView getMResultButton() {
        return this.mResultButton;
    }

    @NotNull
    public final ImageView getMResultContent() {
        return this.mResultContent;
    }

    @NotNull
    public final FrameLayout getMResultLayout() {
        return this.mResultLayout;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NotNull View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == 4) {
            this.mResultLayout.setVisibility(4);
        }
    }

    public final void setMContext(@Nullable Context context) {
        this.mContext = context;
    }

    public final void setMFontPath(@Nullable String str) {
        this.mFontPath = str;
    }

    public final void setMGraphButton(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.mGraphButton = linearLayout;
    }

    public final void setMLatex(@Nullable String str) {
        this.mLatex = str;
    }

    public final void setMLatexBitmap(@Nullable Bitmap bitmap) {
        this.mLatexBitmap = bitmap;
    }

    public final void setMResultButton(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.mResultButton = imageView;
    }

    public final void setMResultContent(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.mResultContent = imageView;
    }

    public final void setMResultLayout(@NotNull FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.mResultLayout = frameLayout;
    }

    public final void setOnClickedListener(@Nullable OnClickedListener listener) {
        this.mListener = listener;
    }
}
