package com.vladsch.flexmark.util.sequence.mappers;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ChangeCase {
    public static final CharMapper toUpperCase = new ToUpperCase();
    public static final CharMapper toLowerCase = new ToLowerCase();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ToLowerCase implements CharMapper {
        @Override // com.vladsch.flexmark.util.sequence.mappers.CharMapper
        public char map(char c) {
            return Character.isUpperCase(c) ? Character.toLowerCase(c) : c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ToUpperCase implements CharMapper {
        @Override // com.vladsch.flexmark.util.sequence.mappers.CharMapper
        public char map(char c) {
            return Character.isLowerCase(c) ? Character.toUpperCase(c) : c;
        }
    }
}
