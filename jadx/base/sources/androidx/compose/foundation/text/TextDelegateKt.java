package androidx.compose.foundation.text;

import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.Placeholder;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.text.font.FontFamily;
import androidx.compose.p109ui.text.style.TextOverflow;
import androidx.compose.p109ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001av\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\f\u0010\u0018\u001a\u00020\u0010*\u00020\u0019H\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, m13886d2 = {"updateTextDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "current", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "updateTextDelegate-rm0N8CA", "(Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;ZIIILjava/util/List;)Landroidx/compose/foundation/text/TextDelegate;", "ceilToIntPx", "", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextDelegate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextDelegate.kt\nandroidx/compose/foundation/text/TextDelegateKt\n+ 2 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n*L\n1#1,349:1\n26#2:350\n*S KotlinDebug\n*F\n+ 1 TextDelegate.kt\nandroidx/compose/foundation/text/TextDelegateKt\n*L\n304#1:350\n*E\n"})
public final class TextDelegateKt {
    public static final int ceilToIntPx(float f) {
        return Math.round((float) Math.ceil(f));
    }

    @NotNull
    /* JADX INFO: renamed from: updateTextDelegate-rm0N8CA, reason: not valid java name */
    public static final TextDelegate m16228updateTextDelegaterm0N8CA(@NotNull TextDelegate textDelegate, @NotNull AnnotatedString annotatedString, @NotNull TextStyle textStyle, @NotNull Density density, @NotNull FontFamily.Resolver resolver, boolean z, int i, int i2, int i4, @NotNull List<AnnotatedString.Range<Placeholder>> list) {
        FontFamily.Resolver resolver2;
        boolean z2;
        int i5;
        int i6;
        int i7;
        List<AnnotatedString.Range<Placeholder>> list2;
        if (Intrinsics.areEqual(textDelegate.getText(), annotatedString) && Intrinsics.areEqual(textDelegate.getStyle(), textStyle)) {
            z2 = z;
            if (textDelegate.getSoftWrap() == z2) {
                i5 = i;
                if (!TextOverflow.m20899equalsimpl0(textDelegate.getOverflow(), i5)) {
                    resolver2 = resolver;
                    i6 = i2;
                    i7 = i4;
                    list2 = list;
                    return new TextDelegate(annotatedString, textStyle, i6, i7, z2, i5, density, resolver2, list2, null);
                }
                i6 = i2;
                if (textDelegate.getMaxLines() != i6) {
                    resolver2 = resolver;
                    i7 = i4;
                    list2 = list;
                    return new TextDelegate(annotatedString, textStyle, i6, i7, z2, i5, density, resolver2, list2, null);
                }
                i7 = i4;
                if (textDelegate.getMinLines() != i7 || !Intrinsics.areEqual(textDelegate.getDensity(), density)) {
                    resolver2 = resolver;
                    list2 = list;
                    return new TextDelegate(annotatedString, textStyle, i6, i7, z2, i5, density, resolver2, list2, null);
                }
                list2 = list;
                if (Intrinsics.areEqual(textDelegate.getPlaceholders(), list2)) {
                    resolver2 = resolver;
                    if (textDelegate.getFontFamilyResolver() == resolver2) {
                        return textDelegate;
                    }
                } else {
                    resolver2 = resolver;
                }
                return new TextDelegate(annotatedString, textStyle, i6, i7, z2, i5, density, resolver2, list2, null);
            }
            resolver2 = resolver;
        } else {
            resolver2 = resolver;
            z2 = z;
        }
        i5 = i;
        i6 = i2;
        i7 = i4;
        list2 = list;
        return new TextDelegate(annotatedString, textStyle, i6, i7, z2, i5, density, resolver2, list2, null);
    }

    /* JADX INFO: renamed from: updateTextDelegate-rm0N8CA$default, reason: not valid java name */
    public static /* synthetic */ TextDelegate m16229updateTextDelegaterm0N8CA$default(TextDelegate textDelegate, AnnotatedString annotatedString, TextStyle textStyle, Density density, FontFamily.Resolver resolver, boolean z, int i, int i2, int i4, List list, int i5, Object obj) {
        if ((i5 & 32) != 0) {
            z = true;
        }
        if ((i5 & 64) != 0) {
            i = TextOverflow.INSTANCE.m20906getClipgIe3tQ8();
        }
        if ((i5 & 128) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        if ((i5 & 256) != 0) {
            i4 = 1;
        }
        return m16228updateTextDelegaterm0N8CA(textDelegate, annotatedString, textStyle, density, resolver, z, i, i2, i4, list);
    }
}
