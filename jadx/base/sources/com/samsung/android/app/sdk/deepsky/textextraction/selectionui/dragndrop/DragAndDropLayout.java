package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.dragndrop;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.samsung.android.app.sdk.deepsky.textextraction.C7039R;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\bJ\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/dragndrop/DragAndDropLayout;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "dragAndDropLayout", "Landroid/widget/LinearLayout;", "tv", "Landroid/widget/TextView;", "getLayout", "setLayout", "Landroid/widget/LinearLayout$LayoutParams;", "teView", "Landroid/view/View;", "selectedText", "", ImageConst.ImageUpscaleConst.KEY_SCALE_FACTOR, "", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class DragAndDropLayout {
    private static final float DRAG_TEXT_SCALE_DEFAULT = 1.0f;
    private static final int MAX_LINES = 4;
    private static final float MAX_TEXT_SIZE = 37.5f;
    private static final int MAX_WIDTH_RATIO = 2;
    private static final float MIN_TEXT_SIZE = 16.5f;
    private static final int PADDING_RATIO = 20;
    private static final float SCALE_FACTOR_ZOOM_THRESHOLD = 3.0f;
    private static final float SCALE_TEXT_SIZE_FACTOR_DEFAULT = 1.0f;

    @NotNull
    private final Context context;

    @NotNull
    private LinearLayout dragAndDropLayout;

    @NotNull
    private TextView tv;

    public DragAndDropLayout(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.tv = new TextView(context);
        this.dragAndDropLayout = new LinearLayout(context);
        this.tv.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout = this.dragAndDropLayout;
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundDrawable(linearLayout.getContext().getResources().getDrawable(C7039R.drawable.drag_drop_background));
        linearLayout.addView(this.tv);
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    /* JADX INFO: renamed from: getLayout, reason: from getter */
    public final LinearLayout getDragAndDropLayout() {
        return this.dragAndDropLayout;
    }

    @NotNull
    public final LinearLayout.LayoutParams setLayout(@NotNull View teView, @NotNull String selectedText, float scaleFactor) {
        Intrinsics.checkNotNullParameter(teView, "teView");
        Intrinsics.checkNotNullParameter(selectedText, "selectedText");
        LinearLayout linearLayout = this.dragAndDropLayout;
        int i = (int) (20 / scaleFactor);
        linearLayout.setPadding(i, i, i, i);
        linearLayout.setVisibility(4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        teView.getLocationOnScreen(new int[2]);
        TextView textView = this.tv;
        float dimension = textView.getContext().getResources().getDimension(C7039R.dimen.drag_drop_text_size);
        textView.setMaxWidth(teView.getWidth() / 2);
        textView.setMaxLines(4);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(8388611);
        textView.setText(StringsKt__StringsKt.removeSuffix(selectedText, (CharSequence) "\n"));
        textView.setTextColor(textView.getContext().getResources().getColor(C7039R.color.drag_and_drop_text_color));
        Context context = textView.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        ((Activity) context).isInMultiWindowMode();
        textView.setTextSize(2, Math.max(dimension, MIN_TEXT_SIZE) * (scaleFactor > 3.0f ? scaleFactor / 3 : 1.0f));
        return layoutParams;
    }
}
