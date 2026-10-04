package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.actionmode;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Rect;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewParent;
import android.view.textclassifier.TextClassification;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.textclassification.TextClassificationHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015JL\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00182\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!J\n\u0010#\u001a\u0004\u0018\u00010\fH\u0002J\u0006\u0010$\u001a\u00020\u0010R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/actionmode/TextExtractionActionModeHelper;", "", "context", "Landroid/content/Context;", "teView", "Landroid/view/View;", "textClassificationHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/textclassification/TextClassificationHelper;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/actionmode/ActionModeListener;", "(Landroid/content/Context;Landroid/view/View;Lcom/samsung/android/app/sdk/deepsky/textextraction/textclassification/TextClassificationHelper;Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/actionmode/ActionModeListener;)V", "actionMode", "Landroid/view/ActionMode;", "textActionModeCallback", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/actionmode/TextActionModeCallback;", "setOnToolbarMenuClickListener", "", "onToolbarMenuClickListener", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$OnToolbarMenuClickListener;", "setPendingIntent", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "startActionMode", "selectedText", "", "selectedTextForTextClassification", "leftText", "rightText", "languageTags", "visibleWordsRect", "", "Landroid/graphics/Rect;", "isVertical", "", "isAllTextSelected", "startActionModeInternal", "stopActionMode", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TextExtractionActionModeHelper {

    @NotNull
    private static final String TAG = "TextExtractionActionModeHelper";

    @Nullable
    private ActionMode actionMode;

    @NotNull
    private final View teView;

    @NotNull
    private final TextActionModeCallback textActionModeCallback;

    @NotNull
    private final TextClassificationHelper textClassificationHelper;

    public TextExtractionActionModeHelper(@NotNull Context context, @NotNull View teView, @NotNull TextClassificationHelper textClassificationHelper, @NotNull ActionModeListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(teView, "teView");
        Intrinsics.checkNotNullParameter(textClassificationHelper, "textClassificationHelper");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.teView = teView;
        this.textClassificationHelper = textClassificationHelper;
        this.textActionModeCallback = new TextActionModeCallback(context, teView, listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActionMode startActionModeInternal() {
        ViewParent parent = this.teView.getParent();
        if (parent == null || !this.teView.isAttachedToWindow()) {
            return null;
        }
        try {
            return parent.startActionModeForChild(this.teView, this.textActionModeCallback, 99);
        } catch (AbstractMethodError unused) {
            return parent.startActionModeForChild(this.teView, this.textActionModeCallback);
        } catch (Exception unused2) {
            LibLogger.m5430e(TAG, "startActionMode exception");
            return null;
        }
    }

    public final void setOnToolbarMenuClickListener(@NotNull TextExtractionDrawHelper.OnToolbarMenuClickListener onToolbarMenuClickListener) {
        Intrinsics.checkNotNullParameter(onToolbarMenuClickListener, "onToolbarMenuClickListener");
        this.textActionModeCallback.setOnToolbarMenuClickListener(onToolbarMenuClickListener);
    }

    public final void setPendingIntent(@Nullable PendingIntent pendingIntent) {
        this.textActionModeCallback.setPendingIntent(pendingIntent);
    }

    public final void startActionMode(@NotNull String selectedText, @NotNull String selectedTextForTextClassification, @NotNull String leftText, @NotNull String rightText, @NotNull String languageTags, @NotNull List<Rect> visibleWordsRect, boolean isVertical, boolean isAllTextSelected) {
        Intrinsics.checkNotNullParameter(selectedText, "selectedText");
        Intrinsics.checkNotNullParameter(selectedTextForTextClassification, "selectedTextForTextClassification");
        Intrinsics.checkNotNullParameter(leftText, "leftText");
        Intrinsics.checkNotNullParameter(rightText, "rightText");
        Intrinsics.checkNotNullParameter(languageTags, "languageTags");
        Intrinsics.checkNotNullParameter(visibleWordsRect, "visibleWordsRect");
        this.textActionModeCallback.setSelectedTextInformation(selectedText, visibleWordsRect, isVertical, isAllTextSelected);
        TextClassificationHelper.classifyTextAsync$default(this.textClassificationHelper, selectedTextForTextClassification, leftText, rightText, languageTags, false, new Function1<TextClassification, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.actionmode.TextExtractionActionModeHelper.startActionMode.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextClassification textClassification) {
                invoke2(textClassification);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable TextClassification textClassification) {
                TextExtractionActionModeHelper.this.textActionModeCallback.setTextClassification(textClassification);
                TextExtractionActionModeHelper textExtractionActionModeHelper = TextExtractionActionModeHelper.this;
                textExtractionActionModeHelper.actionMode = textExtractionActionModeHelper.startActionModeInternal();
            }
        }, 16, null);
    }

    public final void stopActionMode() {
        this.textClassificationHelper.cancelAsyncTask();
        ActionMode actionMode = this.actionMode;
        if (actionMode != null) {
            actionMode.hide(-1L);
        }
        ActionMode actionMode2 = this.actionMode;
        if (actionMode2 != null) {
            actionMode2.finish();
        }
        this.actionMode = null;
    }
}
