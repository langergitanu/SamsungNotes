package org.apache.commons.text.lookup;

import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class FileStringLookup extends AbstractPathFencedLookup {
    static final AbstractStringLookup INSTANCE = new FileStringLookup(null);

    public FileStringLookup(Path... pathArr) {
        super(pathArr);
    }

    @Override // org.apache.commons.text.lookup.StringLookup
    public String lookup(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(String.valueOf(':'));
        if (strArrSplit.length < 2) {
            throw IllegalArgumentExceptions.format("Bad file key format [%s], expected format is CharsetName:DocumentPath.", str);
        }
        String str2 = strArrSplit[0];
        String strSubstringAfter = StringUtils.substringAfter(str, 58);
        try {
            return new String(Files.readAllBytes(getPath(strSubstringAfter)), str2);
        } catch (Exception e) {
            throw IllegalArgumentExceptions.format(e, "Error looking up file [%s] with charset [%s].", strSubstringAfter, str2);
        }
    }
}
