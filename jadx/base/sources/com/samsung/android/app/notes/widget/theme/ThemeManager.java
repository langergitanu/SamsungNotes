package com.samsung.android.app.notes.widget.theme;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenForegroundColorSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001e\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/theme/ThemeManager;", "", "<init>", "()V", "applyFontColor", "", "context", "Landroid/content/Context;", "text", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "info", "Lcom/samsung/android/app/notes/widget/theme/ThemeInfo;", "applyThemeToBodyText", "srcBodyText", "applyThemeToPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "srcPage", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ThemeManager {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static ThemeManager mInstance;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/theme/ThemeManager$Companion;", "", "<init>", "()V", "mInstance", "Lcom/samsung/android/app/notes/widget/theme/ThemeManager;", "instance", "getInstance", "()Lcom/samsung/android/app/notes/widget/theme/ThemeManager;", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final ThemeManager getInstance() {
            if (ThemeManager.mInstance == null) {
                ThemeManager.mInstance = new ThemeManager();
            }
            return ThemeManager.mInstance;
        }

        private Companion() {
        }
    }

    private final void applyFontColor(Context context, SpenObjectTextBox text, ThemeInfo info) {
        int color = ResourceUtils.getColor(context, C11391R.color.widget_white_theme_text_color);
        ArrayList<SpenTextSpanBase> textSpan = text.getTextSpan();
        if (textSpan == null || textSpan.isEmpty()) {
            return;
        }
        Iterator<SpenTextSpanBase> it = textSpan.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenTextSpanBase next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SpenTextSpanBase spenTextSpanBase = next;
            if (spenTextSpanBase.getType() == 1) {
                SpenForegroundColorSpan spenForegroundColorSpan = (SpenForegroundColorSpan) spenTextSpanBase;
                if (spenForegroundColorSpan.getColor() == color) {
                    spenForegroundColorSpan.setColor(ResourceUtils.getColor(context, info.getTextColor()));
                }
            }
        }
        text.setTextSpan(textSpan);
    }

    @NotNull
    public final SpenObjectTextBox applyThemeToBodyText(@NotNull Context context, @NotNull SpenObjectTextBox srcBodyText, @NotNull ThemeInfo info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(srcBodyText, "srcBodyText");
        Intrinsics.checkNotNullParameter(info, "info");
        applyFontColor(context, srcBodyText, info);
        return srcBodyText;
    }

    @NotNull
    public final SpenWPage applyThemeToPage(@NotNull Context context, @NotNull SpenWPage srcPage, @NotNull ThemeInfo info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(srcPage, "srcPage");
        Intrinsics.checkNotNullParameter(info, "info");
        srcPage.setBackgroundColor(0);
        for (SpenObjectBase spenObjectBase : srcPage.getObjectList()) {
            int type = spenObjectBase.getType();
            if (type == 1) {
                int strokeColor = info.getStrokeColor();
                if (strokeColor != -1) {
                    Intrinsics.checkNotNull(spenObjectBase, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectStroke");
                    ((SpenObjectStroke) spenObjectBase).setColor(ResourceUtils.getColor(context, strokeColor));
                }
            } else if (type == 2) {
                Intrinsics.checkNotNull(spenObjectBase, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectTextBox");
                applyFontColor(context, (SpenObjectTextBox) spenObjectBase, info);
            }
        }
        return srcPage;
    }
}
