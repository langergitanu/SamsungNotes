package org.hamcrest;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class StringDescription extends BaseDescription {
    private final Appendable out;

    public StringDescription() {
        this(new StringBuilder());
    }

    public static String asString(SelfDescribing selfDescribing) {
        return toString(selfDescribing);
    }

    public static String toString(SelfDescribing selfDescribing) {
        return new StringDescription().appendDescriptionOf(selfDescribing).toString();
    }

    @Override // org.hamcrest.BaseDescription
    public void append(String str) {
        try {
            this.out.append(str);
        } catch (IOException e) {
            throw new RuntimeException("Could not write description", e);
        }
    }

    public StringDescription(Appendable appendable) {
        this.out = appendable;
    }

    public String toString() {
        return this.out.toString();
    }

    @Override // org.hamcrest.BaseDescription
    public void append(char c) {
        try {
            this.out.append(c);
        } catch (IOException e) {
            throw new RuntimeException("Could not write description", e);
        }
    }
}
