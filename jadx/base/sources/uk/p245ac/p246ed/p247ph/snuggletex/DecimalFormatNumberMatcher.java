package uk.p245ac.p246ed.p247ph.snuggletex;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParsePosition;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class DecimalFormatNumberMatcher implements NumberMatcher {
    private static final int READAHEAD_INCREMENT = 4;
    private DecimalFormat decimalFormat;

    public DecimalFormatNumberMatcher() {
        this(Locale.getDefault());
    }

    public DecimalFormat getDecimalFormat() {
        return this.decimalFormat;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.NumberMatcher
    public int getNumberEnd(InputContext inputContext, int i) {
        ParsePosition parsePosition;
        this.decimalFormat.setParseBigDecimal(true);
        int length = inputContext.length() - i;
        int iMin = Math.min(4, length);
        if (iMin <= 0) {
            return -1;
        }
        while (true) {
            String string = inputContext.extract(i, i + iMin).toString();
            parsePosition = new ParsePosition(0);
            BigDecimal bigDecimal = (BigDecimal) this.decimalFormat.parse(string, parsePosition);
            if (bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) < 0) {
                return -1;
            }
            if (parsePosition.getIndex() != iMin || iMin >= length) {
                break;
            }
            iMin = Math.min(iMin + 4, length);
        }
        return parsePosition.getIndex() + i;
    }

    public void setDecimalFormat(DecimalFormat decimalFormat) {
        this.decimalFormat = decimalFormat;
    }

    public DecimalFormatNumberMatcher(Locale locale) {
        DecimalFormat decimalFormat = new DecimalFormat();
        this.decimalFormat = decimalFormat;
        decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(locale));
        this.decimalFormat.setGroupingUsed(false);
    }

    public DecimalFormatNumberMatcher(DecimalFormat decimalFormat) {
        this.decimalFormat = decimalFormat;
    }
}
