package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.renderer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.samsung.android.app.sdk.deepsky.textextraction.C7039R;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data.SelectableBarcode;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data.SelectableCharacter;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/renderer/SelectionRenderer;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "selectionPaint", "Landroid/graphics/Paint;", "drawSelection", "", "canvas", "Landroid/graphics/Canvas;", "selectedCharacters", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableCharacter;", "selectedBarcodes", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableBarcode;", "setColor", "color", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SelectionRenderer {

    @NotNull
    private final Context context;

    @NotNull
    private final Paint selectionPaint;

    public SelectionRenderer(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Paint paint = new Paint();
        paint.setFlags(1);
        paint.setColor(context.getColor(C7039R.color.textextraction_selection_area_color));
        paint.setStyle(Paint.Style.FILL);
        this.selectionPaint = paint;
    }

    public final void drawSelection(@NotNull Canvas canvas, @NotNull List<SelectableCharacter> selectedCharacters, @NotNull List<SelectableBarcode> selectedBarcodes) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(selectedCharacters, "selectedCharacters");
        Intrinsics.checkNotNullParameter(selectedBarcodes, "selectedBarcodes");
        Iterator<SelectableCharacter> it = selectedCharacters.iterator();
        while (it.hasNext()) {
            canvas.drawPath(it.next().getPath(), this.selectionPaint);
        }
        Iterator<SelectableBarcode> it2 = selectedBarcodes.iterator();
        while (it2.hasNext()) {
            canvas.drawPath(it2.next().getPath(), this.selectionPaint);
        }
    }

    public final void setColor(int color) {
        this.selectionPaint.setColor(color);
    }
}
