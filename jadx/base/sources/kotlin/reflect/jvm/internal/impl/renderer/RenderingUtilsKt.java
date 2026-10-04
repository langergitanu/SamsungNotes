package kotlin.reflect.jvm.internal.impl.renderer;

import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@SourceDebugExtension({"SMAP\nRenderingUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RenderingUtils.kt\norg/jetbrains/kotlin/renderer/RenderingUtilsKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,78:1\n1088#2,2:79\n*S KotlinDebug\n*F\n+ 1 RenderingUtils.kt\norg/jetbrains/kotlin/renderer/RenderingUtilsKt\n*L\n30#1:79,2\n*E\n"})
public final class RenderingUtilsKt {
    @NotNull
    public static final String render(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "<this>");
        if (!shouldBeEscaped(name)) {
            String strAsString = name.asString();
            Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
            return strAsString;
        }
        StringBuilder sb = new StringBuilder();
        String strAsString2 = name.asString();
        Intrinsics.checkNotNullExpressionValue(strAsString2, "asString(...)");
        sb.append("`" + strAsString2);
        sb.append('`');
        return sb.toString();
    }

    @NotNull
    public static final String renderFqName(@NotNull List<Name> pathSegments) {
        Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        StringBuilder sb = new StringBuilder();
        for (Name name : pathSegments) {
            if (sb.length() > 0) {
                sb.append(Extension.DOT);
            }
            sb.append(render(name));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Nullable
    public static final String replacePrefixesInTypeRepresentations(@NotNull String lowerRendered, @NotNull String lowerPrefix, @NotNull String upperRendered, @NotNull String upperPrefix, @NotNull String foldedPrefix) {
        Intrinsics.checkNotNullParameter(lowerRendered, "lowerRendered");
        Intrinsics.checkNotNullParameter(lowerPrefix, "lowerPrefix");
        Intrinsics.checkNotNullParameter(upperRendered, "upperRendered");
        Intrinsics.checkNotNullParameter(upperPrefix, "upperPrefix");
        Intrinsics.checkNotNullParameter(foldedPrefix, "foldedPrefix");
        if (!StringsKt.m14145S(lowerRendered, lowerPrefix) || !StringsKt.m14145S(upperRendered, upperPrefix)) {
            return null;
        }
        String strSubstring = lowerRendered.substring(lowerPrefix.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String strSubstring2 = upperRendered.substring(upperPrefix.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        String strM756B = AbstractC0541b.m756B(foldedPrefix, strSubstring);
        if (Intrinsics.areEqual(strSubstring, strSubstring2)) {
            return strM756B;
        }
        if (!typeStringsDifferOnlyInNullability(strSubstring, strSubstring2)) {
            return null;
        }
        return strM756B + '!';
    }

    private static final boolean shouldBeEscaped(Name name) {
        String strAsString = name.asString();
        Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        if (KeywordStringsGenerated.KEYWORDS.contains(strAsString)) {
            return true;
        }
        for (int i = 0; i < strAsString.length(); i++) {
            char cCharAt = strAsString.charAt(i);
            if (!Character.isLetterOrDigit(cCharAt) && cCharAt != '_') {
                return true;
            }
        }
        return strAsString.length() == 0 || !Character.isJavaIdentifierStart(strAsString.codePointAt(0));
    }

    public static final boolean typeStringsDifferOnlyInNullability(@NotNull String lower, @NotNull String upper) {
        Intrinsics.checkNotNullParameter(lower, "lower");
        Intrinsics.checkNotNullParameter(upper, "upper");
        if (Intrinsics.areEqual(lower, StringsKt.m14139M(upper, MsalUtils.QUERY_STRING_SYMBOL, ""))) {
            return true;
        }
        if (StringsKt.m14167w(upper, MsalUtils.QUERY_STRING_SYMBOL)) {
            if (Intrinsics.areEqual(lower + '?', upper)) {
                return true;
            }
        }
        StringBuilder sb = new StringBuilder("(");
        sb.append(lower);
        sb.append(")?");
        return Intrinsics.areEqual(sb.toString(), upper);
    }

    @NotNull
    public static final String render(@NotNull FqNameUnsafe fqNameUnsafe) {
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "<this>");
        List<Name> listPathSegments = fqNameUnsafe.pathSegments();
        Intrinsics.checkNotNullExpressionValue(listPathSegments, "pathSegments(...)");
        return renderFqName(listPathSegments);
    }
}
