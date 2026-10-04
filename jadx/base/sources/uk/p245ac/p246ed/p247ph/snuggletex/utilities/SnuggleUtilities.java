package uk.p245ac.p246ed.p247ph.snuggletex.utilities;

import java.util.regex.Pattern;
import org.w3c.dom.Element;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class SnuggleUtilities {
    private static final Pattern charsToVerbPattern = Pattern.compile("([\\\\^~<>|]+)");
    private static final Pattern charsToBackslashPattern = Pattern.compile("([%#_$&\\{\\}])");

    public static String extractSnuggleTeXAnnotation(Element element) {
        return MathMLUtilities.extractAnnotationString(element, "SnuggleTeX");
    }

    public static String quoteTextForInput(String str) {
        return charsToBackslashPattern.matcher(charsToVerbPattern.matcher(str).replaceAll("\\\\verb-$1-")).replaceAll("\\\\$1");
    }
}
