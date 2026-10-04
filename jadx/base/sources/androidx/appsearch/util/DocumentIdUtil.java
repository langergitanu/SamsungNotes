package androidx.appsearch.util;

import androidx.appsearch.app.GenericDocument;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public class DocumentIdUtil {
    private static final String NAMESPACE_DELIMITER = "#";
    private static final String NAMESPACE_DELIMITER_REPLACEMENT_REGEX = "\\\\#";

    private DocumentIdUtil() {
    }

    public static String createQualifiedId(String str, String str2, GenericDocument genericDocument) {
        return createQualifiedId(str, str2, genericDocument.getNamespace(), genericDocument.getId());
    }

    private static String escapeNsDelimiters(String str) {
        return str.replaceAll("\\\\", "\\\\\\\\").replaceAll("#", NAMESPACE_DELIMITER_REPLACEMENT_REGEX);
    }

    public static String createQualifiedId(String str, String str2, String str3, String str4) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        Preconditions.checkNotNull(str3);
        Preconditions.checkNotNull(str4);
        return escapeNsDelimiters(str) + '$' + escapeNsDelimiters(str2) + '/' + escapeNsDelimiters(str3) + "#" + escapeNsDelimiters(str4);
    }
}
