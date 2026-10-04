package opennlp.tools.lemmatizer;

import java.util.ArrayList;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LemmaSampleStream extends FilterObjectStream<String, LemmaSample> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) LemmaSampleStream.class);

    public LemmaSampleStream(ObjectStream<String> objectStream) {
        super(objectStream);
    }

    @Override // opennlp.tools.util.ObjectStream
    public LemmaSample read() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        while (true) {
            String str = (String) this.samples.read();
            if (str == null || str.isEmpty()) {
                break;
            }
            String[] strArrSplit = str.split("\t");
            if (strArrSplit.length != 3) {
                logger.warn("Skipping corrupt line: {}", str);
            } else {
                arrayList.add(strArrSplit[0]);
                arrayList2.add(strArrSplit[1]);
                arrayList3.add(strArrSplit[2]);
            }
        }
        if (arrayList.size() > 0) {
            return new LemmaSample((String[]) arrayList.toArray(new String[0]), (String[]) arrayList2.toArray(new String[0]), (String[]) arrayList3.toArray(new String[0]));
        }
        return null;
    }
}
