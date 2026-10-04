package com.vladsch.flexmark.util.sequence.mappers;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface CharMapper {
    public static final CharMapper IDENTITY = new C11887b();

    static CharMapper identity() {
        return IDENTITY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default char lambda$andThen$2(CharMapper charMapper, char c) {
        return charMapper.map(map(c));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default char lambda$compose$1(CharMapper charMapper, char c) {
        return map(charMapper.map(c));
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ char lambda$static$0(char c) {
        return c;
    }

    default CharMapper andThen(CharMapper charMapper) {
        Objects.requireNonNull(charMapper);
        return charMapper == IDENTITY ? this : new C11886a(this, charMapper, 1);
    }

    default CharMapper compose(CharMapper charMapper) {
        Objects.requireNonNull(charMapper);
        return charMapper == IDENTITY ? this : new C11886a(this, charMapper, 0);
    }

    char map(char c);
}
