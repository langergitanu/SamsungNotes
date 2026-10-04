package uk.p245ac.p246ed.p247ph.snuggletex;

import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class SimpleNumberMatcher implements NumberMatcher {
    private final char decimalChar;

    public SimpleNumberMatcher() {
        this(Locale.getDefault());
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.NumberMatcher
    public int getNumberEnd(InputContext inputContext, int i) {
        boolean z;
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            int iCharAt = inputContext.charAt(i);
            if (iCharAt < 48 || iCharAt > 57) {
                break;
            }
            i++;
            z3 = true;
        }
        if (inputContext.charAt(i) == this.decimalChar) {
            i++;
            z = true;
        } else {
            z = false;
        }
        if (!z3 && !z) {
            return -1;
        }
        while (true) {
            int iCharAt2 = inputContext.charAt(i);
            if (iCharAt2 < 48 || iCharAt2 > 57) {
                break;
            }
            i++;
            z2 = true;
        }
        if (z3 || z2) {
            return i;
        }
        return -1;
    }

    public SimpleNumberMatcher(Locale locale) {
        this.decimalChar = new DecimalFormatSymbols(locale).getDecimalSeparator();
    }
}
