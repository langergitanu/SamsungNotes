package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class HpackHeaderField {
    static final int HEADER_ENTRY_OVERHEAD = 32;
    final CharSequence name;
    final CharSequence value;

    public HpackHeaderField(CharSequence charSequence, CharSequence charSequence2) {
        this.name = (CharSequence) ObjectUtil.checkNotNull(charSequence, "name");
        this.value = (CharSequence) ObjectUtil.checkNotNull(charSequence2, "value");
    }

    public static long sizeOf(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence2.length() + charSequence.length() + 32;
    }

    public final boolean equalsForTest(HpackHeaderField hpackHeaderField) {
        return HpackUtil.equalsVariableTime(this.name, hpackHeaderField.name) && HpackUtil.equalsVariableTime(this.value, hpackHeaderField.value);
    }

    public final int size() {
        return this.value.length() + this.name.length() + 32;
    }

    public String toString() {
        return ((Object) this.name) + ": " + ((Object) this.value);
    }
}
