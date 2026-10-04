package opennlp.tools.p217ml.model;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Event {
    private final String[] context;
    private final String outcome;
    private final float[] values;

    public Event(String str, CharSequence[] charSequenceArr) {
        this(str, charSequenceArr, (float[]) null);
    }

    public String[] getContext() {
        return this.context;
    }

    public String getOutcome() {
        return this.outcome;
    }

    public float[] getValues() {
        return this.values;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.outcome);
        sb.append(" [");
        String[] strArr = this.context;
        if (strArr.length > 0) {
            sb.append(strArr[0]);
            if (this.values != null) {
                sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                sb.append(this.values[0]);
            }
        }
        for (int i = 1; i < this.context.length; i++) {
            sb.append(" ");
            sb.append(this.context[i]);
            if (this.values != null) {
                sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                sb.append(this.values[i]);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public Event(String str, String[] strArr, float[] fArr) {
        Objects.requireNonNull(str, "outcome must not be null");
        this.outcome = str;
        Objects.requireNonNull(strArr, "context must not be null");
        this.context = strArr;
        this.values = fArr;
    }

    public Event(String str, CharSequence[] charSequenceArr, float[] fArr) {
        Objects.requireNonNull(str, "outcome must not be null");
        this.outcome = str;
        String[] strArr = new String[charSequenceArr.length];
        for (int i = 0; i < charSequenceArr.length; i++) {
            strArr[i] = charSequenceArr[i].toString();
        }
        this.context = strArr;
        this.values = fArr;
    }
}
