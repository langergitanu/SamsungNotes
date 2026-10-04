package com.samsung.android.support.senl.p148nt.composer.main.base.external.scrapbook.decoder;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class UnicodeEscaper extends CodePointTranslator {
    private final int above;
    private final int below;
    private final boolean between;

    public UnicodeEscaper() {
        this(0, Integer.MAX_VALUE, true);
    }

    public static UnicodeEscaper above(int i) {
        return outsideOf(0, i);
    }

    public static UnicodeEscaper below(int i) {
        return outsideOf(i, Integer.MAX_VALUE);
    }

    public static UnicodeEscaper between(int i, int i2) {
        return new UnicodeEscaper(i, i2, true);
    }

    public static UnicodeEscaper outsideOf(int i, int i2) {
        return new UnicodeEscaper(i, i2, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.external.scrapbook.decoder.CodePointTranslator
    public boolean translate(int i, Writer writer) throws IOException {
        if (this.between) {
            if (i < this.below || i > this.above) {
                return false;
            }
        } else if (i >= this.below && i <= this.above) {
            return false;
        }
        if (i > 65535) {
            writer.write("\\u" + CharSequenceTranslator.hex(i));
            return true;
        }
        if (i > 4095) {
            writer.write("\\u" + CharSequenceTranslator.hex(i));
            return true;
        }
        if (i > 255) {
            writer.write("\\u0" + CharSequenceTranslator.hex(i));
            return true;
        }
        if (i > 15) {
            writer.write("\\u00" + CharSequenceTranslator.hex(i));
            return true;
        }
        writer.write("\\u000" + CharSequenceTranslator.hex(i));
        return true;
    }

    private UnicodeEscaper(int i, int i2, boolean z) {
        this.below = i;
        this.above = i2;
        this.between = z;
    }
}
