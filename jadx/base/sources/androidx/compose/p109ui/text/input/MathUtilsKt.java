package androidx.compose.p109ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\b\u001a#\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\b¨\u0006\u0006"}, m13886d2 = {"addExactOrElse", "", "right", "defaultValue", "Lkotlin/Function0;", "subtractExactOrElse", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class MathUtilsKt {
    public static final int addExactOrElse(int i, int i2, @NotNull Function0<Integer> function0) {
        int i4 = i + i2;
        return ((i ^ i4) & (i2 ^ i4)) < 0 ? function0.invoke().intValue() : i4;
    }

    public static final int subtractExactOrElse(int i, int i2, @NotNull Function0<Integer> function0) {
        int i4 = i - i2;
        return ((i ^ i4) & (i2 ^ i)) < 0 ? function0.invoke().intValue() : i4;
    }
}
