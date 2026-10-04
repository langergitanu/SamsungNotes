package opennlp.tools.parser;

import java.util.ArrayList;
import java.util.List;
import opennlp.tools.chunker.ChunkSample;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ChunkSampleStream extends FilterObjectStream<Parse, ChunkSample> {
    public ChunkSampleStream(ObjectStream<Parse> objectStream) {
        super(objectStream);
    }

    private static void getInitialChunks(Parse parse, List<Parse> list) {
        if (parse.isPosTag()) {
            list.add(parse);
            return;
        }
        Parse[] children = parse.getChildren();
        for (Parse parse2 : children) {
            if (!parse2.isPosTag()) {
                for (Parse parse3 : children) {
                    getInitialChunks(parse3, list);
                }
                return;
            }
        }
        list.add(parse);
    }

    @Override // opennlp.tools.util.ObjectStream
    public ChunkSample read() {
        Parse parse = (Parse) this.samples.read();
        if (parse == null) {
            return null;
        }
        Parse[] initialChunks = getInitialChunks(parse);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Parse parse2 : initialChunks) {
            if (parse2.isPosTag()) {
                arrayList.add(parse2.getCoveredText());
                arrayList2.add(parse2.getType());
                arrayList3.add("O");
            } else {
                String type = parse2.getType();
                boolean z = true;
                for (Parse parse3 : parse2.getChildren()) {
                    arrayList.add(parse3.getCoveredText());
                    arrayList2.add(parse3.getType());
                    if (z) {
                        arrayList3.add(AbstractBottomUpParser.START + type);
                        z = false;
                    } else {
                        arrayList3.add(AbstractBottomUpParser.CONT + type);
                    }
                }
            }
        }
        return new ChunkSample((String[]) arrayList.toArray(new String[0]), (String[]) arrayList2.toArray(new String[0]), (String[]) arrayList3.toArray(new String[0]));
    }

    public static Parse[] getInitialChunks(Parse parse) {
        ArrayList arrayList = new ArrayList();
        getInitialChunks(parse, arrayList);
        return (Parse[]) arrayList.toArray(new Parse[0]);
    }
}
