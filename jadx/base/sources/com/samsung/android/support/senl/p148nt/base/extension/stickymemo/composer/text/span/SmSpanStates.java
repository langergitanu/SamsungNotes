package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.text.span;

import com.samsung.android.support.senl.p148nt.base.composer.text.span.Bold;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.FontBgColor;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Indent;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Italic;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Strikethrough;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Task;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.TextFormat;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Underline;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/span/SmSpanStates;", "Lcom/samsung/android/support/senl/nt/base/composer/text/span/SpanStates;", "<init>", "()V", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmSpanStates extends SpanStates {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String DEFAULT_PREF_NAME = "StickyMemo";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/span/SmSpanStates$Companion;", "", "<init>", "()V", "DEFAULT_PREF_NAME", "", "getDEFAULT_PREF_NAME", "()Ljava/lang/String;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getDEFAULT_PREF_NAME() {
            return SmSpanStates.DEFAULT_PREF_NAME;
        }

        private Companion() {
        }
    }

    public SmSpanStates() {
        setBodyTextFontSize(new SmFontSize(DEFAULT_PREF_NAME, "StickyMemo_FontSize"));
        setFontBgColor(new FontBgColor());
        setStrikethrough(new Strikethrough());
        setUnderline(new Underline());
        setBold(new Bold());
        setItalic(new Italic());
        setTask(new Task());
        setIndent(new Indent(-1));
        setTextFormat(new TextFormat());
    }
}
