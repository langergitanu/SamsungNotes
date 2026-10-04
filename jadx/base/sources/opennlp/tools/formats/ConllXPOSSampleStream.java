package opennlp.tools.formats;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import opennlp.tools.commons.Internal;
import opennlp.tools.postag.POSSample;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.ParagraphStream;
import opennlp.tools.util.PlainTextByLineStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class ConllXPOSSampleStream extends FilterObjectStream<String, POSSample> {
    public ConllXPOSSampleStream(ObjectStream<String> objectStream) {
        super(new ParagraphStream(objectStream));
    }

    public ConllXPOSSampleStream(InputStreamFactory inputStreamFactory, Charset charset) {
        super(new ParagraphStream(new PlainTextByLineStream(inputStreamFactory, charset)));
    }

    @Override // opennlp.tools.util.ObjectStream
    public POSSample read() throws IOException {
        String str = (String) this.samples.read();
        if (str == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
        ArrayList arrayList = new ArrayList(100);
        ArrayList arrayList2 = new ArrayList(100);
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                if (arrayList.size() == 0) {
                    read();
                }
                return new POSSample((String[]) arrayList.toArray(new String[0]), (String[]) arrayList2.toArray(new String[0]));
            }
            String[] strArrSplit = line.split("\t");
            if (strArrSplit.length < 5) {
                throw new InvalidFormatException(AbstractC0541b.m773o("Every non-empty line must have at least 5 fields: '", line, "'!"));
            }
            arrayList.add(strArrSplit[1]);
            arrayList2.add(strArrSplit[4]);
        }
    }
}
