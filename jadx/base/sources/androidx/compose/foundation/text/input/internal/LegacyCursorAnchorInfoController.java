package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.p109ui.graphics.Matrix;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.text.input.OffsetMapping;
import androidx.compose.p109ui.text.input.TextFieldValue;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010 \u001a\u00020\u0005J6\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010J\b\u0010$\u001a\u00020\u0005H\u0002J.\u0010%\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/LegacyCursorAnchorInfoController;", "", "localToScreen", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Matrix;", "", "inputMethodManager", "Landroidx/compose/foundation/text/input/internal/InputMethodManager;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/input/internal/InputMethodManager;)V", "androidMatrix", "Landroid/graphics/Matrix;", "builder", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "decorationBoxBounds", "Landroidx/compose/ui/geometry/Rect;", "hasPendingImmediateRequest", "", "includeCharacterBounds", "includeEditorBounds", "includeInsertionMarker", "includeLineBounds", "innerTextFieldBounds", "lock", "matrix", "[F", "monitorEnabled", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "invalidate", "requestUpdate", "immediate", "monitor", "updateCursorAnchorInfo", "updateTextLayoutResult", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class LegacyCursorAnchorInfoController {
    public static final int $stable = 8;

    @Nullable
    private Rect decorationBoxBounds;
    private boolean hasPendingImmediateRequest;
    private boolean includeCharacterBounds;
    private boolean includeEditorBounds;
    private boolean includeInsertionMarker;
    private boolean includeLineBounds;

    @Nullable
    private Rect innerTextFieldBounds;

    @NotNull
    private final InputMethodManager inputMethodManager;

    @NotNull
    private final Function1<Matrix, Unit> localToScreen;
    private boolean monitorEnabled;

    @Nullable
    private OffsetMapping offsetMapping;

    @Nullable
    private TextFieldValue textFieldValue;

    @Nullable
    private TextLayoutResult textLayoutResult;

    @NotNull
    private final Object lock = new Object();

    @NotNull
    private final CursorAnchorInfo.Builder builder = new CursorAnchorInfo.Builder();

    @NotNull
    private final float[] matrix = Matrix.m18756constructorimpl$default(null, 1, null);

    @NotNull
    private final android.graphics.Matrix androidMatrix = new android.graphics.Matrix();

    /* JADX WARN: Multi-variable type inference failed */
    public LegacyCursorAnchorInfoController(@NotNull Function1<? super Matrix, Unit> function1, @NotNull InputMethodManager inputMethodManager) {
        this.localToScreen = function1;
        this.inputMethodManager = inputMethodManager;
    }

    private final void updateCursorAnchorInfo() {
        if (!this.inputMethodManager.isActive() || this.textFieldValue == null || this.offsetMapping == null || this.textLayoutResult == null || this.innerTextFieldBounds == null || this.decorationBoxBounds == null) {
            return;
        }
        Matrix.m18765resetimpl(this.matrix);
        this.localToScreen.invoke(Matrix.m18754boximpl(this.matrix));
        float[] fArr = this.matrix;
        Rect rect = this.decorationBoxBounds;
        Intrinsics.checkNotNull(rect);
        float f = -rect.getLeft();
        Rect rect2 = this.decorationBoxBounds;
        Intrinsics.checkNotNull(rect2);
        Matrix.m18775translateimpl(fArr, f, -rect2.getTop(), 0.0f);
        AndroidMatrixConversions_androidKt.m18395setFromEL8BTi8(this.androidMatrix, this.matrix);
        InputMethodManager inputMethodManager = this.inputMethodManager;
        CursorAnchorInfo.Builder builder = this.builder;
        TextFieldValue textFieldValue = this.textFieldValue;
        Intrinsics.checkNotNull(textFieldValue);
        OffsetMapping offsetMapping = this.offsetMapping;
        Intrinsics.checkNotNull(offsetMapping);
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        Intrinsics.checkNotNull(textLayoutResult);
        android.graphics.Matrix matrix = this.androidMatrix;
        Rect rect3 = this.innerTextFieldBounds;
        Intrinsics.checkNotNull(rect3);
        Rect rect4 = this.decorationBoxBounds;
        Intrinsics.checkNotNull(rect4);
        inputMethodManager.updateCursorAnchorInfo(LegacyCursorAnchorInfoBuilder_androidKt.build(builder, textFieldValue, offsetMapping, textLayoutResult, matrix, rect3, rect4, this.includeInsertionMarker, this.includeCharacterBounds, this.includeEditorBounds, this.includeLineBounds));
        this.hasPendingImmediateRequest = false;
    }

    public final void invalidate() {
        synchronized (this.lock) {
            this.textFieldValue = null;
            this.offsetMapping = null;
            this.textLayoutResult = null;
            this.innerTextFieldBounds = null;
            this.decorationBoxBounds = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void requestUpdate(boolean immediate, boolean monitor, boolean includeInsertionMarker, boolean includeCharacterBounds, boolean includeEditorBounds, boolean includeLineBounds) {
        synchronized (this.lock) {
            try {
                this.includeInsertionMarker = includeInsertionMarker;
                this.includeCharacterBounds = includeCharacterBounds;
                this.includeEditorBounds = includeEditorBounds;
                this.includeLineBounds = includeLineBounds;
                if (immediate) {
                    this.hasPendingImmediateRequest = true;
                    if (this.textFieldValue != null) {
                        updateCursorAnchorInfo();
                    }
                }
                this.monitorEnabled = monitor;
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void updateTextLayoutResult(@NotNull TextFieldValue textFieldValue, @NotNull OffsetMapping offsetMapping, @NotNull TextLayoutResult textLayoutResult, @NotNull Rect innerTextFieldBounds, @NotNull Rect decorationBoxBounds) {
        synchronized (this.lock) {
            try {
                this.textFieldValue = textFieldValue;
                this.offsetMapping = offsetMapping;
                this.textLayoutResult = textLayoutResult;
                this.innerTextFieldBounds = innerTextFieldBounds;
                this.decorationBoxBounds = decorationBoxBounds;
                if (this.hasPendingImmediateRequest || this.monitorEnabled) {
                    updateCursorAnchorInfo();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
