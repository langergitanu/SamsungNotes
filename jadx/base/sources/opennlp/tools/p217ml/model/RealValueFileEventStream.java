package opennlp.tools.p217ml.model;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class RealValueFileEventStream extends FileEventStream {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) RealValueFileEventStream.class);

    public RealValueFileEventStream(String str) {
        super(str);
    }

    public static float[] parseContexts(String[] strArr) {
        int i;
        float[] fArr = new float[strArr.length];
        boolean z = false;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            int iLastIndexOf = strArr[i2].lastIndexOf(MarketingConstants.REFERRER_DELIMITER_U003D);
            if (iLastIndexOf <= 0 || (i = iLastIndexOf + 1) >= strArr[i2].length()) {
                fArr[i2] = 1.0f;
            } else {
                try {
                    float f = Float.parseFloat(strArr[i2].substring(i));
                    fArr[i2] = f;
                    if (f < 0.0f) {
                        throw new RuntimeException(AbstractC0541b.m772n("Negative values are not allowed: ", strArr[i2]));
                    }
                    strArr[i2] = strArr[i2].substring(0, iLastIndexOf);
                    z = true;
                } catch (NumberFormatException unused) {
                    logger.error("Unable to determine value in context: {}", strArr[i2]);
                    fArr[i2] = 1.0f;
                }
            }
        }
        if (z) {
            return fArr;
        }
        return null;
    }

    public RealValueFileEventStream(String str, String str2) {
        super(str, str2);
    }

    @Override // opennlp.tools.p217ml.model.FileEventStream, opennlp.tools.util.ObjectStream
    public Event read() throws IOException {
        String line = this.reader.readLine();
        if (line == null) {
            return null;
        }
        int iIndexOf = line.indexOf(32);
        String strSubstring = line.substring(0, iIndexOf);
        String[] strArrSplit = line.substring(iIndexOf + 1).split("\\s+");
        return new Event(strSubstring, strArrSplit, parseContexts(strArrSplit));
    }

    public RealValueFileEventStream(File file) {
        super(file);
    }

    public RealValueFileEventStream(Reader reader) {
        super(reader);
    }
}
