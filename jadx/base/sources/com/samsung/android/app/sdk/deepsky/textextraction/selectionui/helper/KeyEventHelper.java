package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.helper;

import android.content.Context;
import android.view.KeyEvent;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.util.ClipboardUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J \u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/helper/KeyEventHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isHardwareKeyboardEvent", "", "event", "Landroid/view/KeyEvent;", "onKey", "keyCode", "", "drawHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper;", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class KeyEventHelper {

    @NotNull
    private static final String TAG = "KeyMapHelper";

    @NotNull
    private final Context context;

    public KeyEventHelper(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    private final boolean isHardwareKeyboardEvent(KeyEvent event) {
        return (event.getFlags() & 2) != 2;
    }

    public final boolean onKey(int keyCode, @Nullable KeyEvent event, @NotNull TextExtractionDrawHelper drawHelper) {
        Intrinsics.checkNotNullParameter(drawHelper, "drawHelper");
        if (event == null || !isHardwareKeyboardEvent(event) || !event.isCtrlPressed()) {
            return false;
        }
        if (keyCode == 29) {
            drawHelper.selectAll();
            return true;
        }
        if (keyCode != 31) {
            return true;
        }
        String selectedText = drawHelper.getSelectedText();
        if (selectedText.length() <= 0) {
            return true;
        }
        ClipboardUtil.INSTANCE.copyClipboard(this.context, selectedText);
        drawHelper.dismissPopupMenu();
        drawHelper.clearAllSelection();
        return true;
    }
}
