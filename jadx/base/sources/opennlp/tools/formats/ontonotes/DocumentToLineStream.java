package opennlp.tools.formats.ontonotes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import opennlp.tools.formats.brat.SegmenterObjectStream;
import opennlp.tools.util.ObjectStream;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DocumentToLineStream extends SegmenterObjectStream<String, String> {
    public DocumentToLineStream(ObjectStream<String> objectStream) {
        super(objectStream);
    }

    @Override // opennlp.tools.formats.brat.SegmenterObjectStream
    public List<String> read(String str) {
        List<String> listAsList = Arrays.asList(str.split("\n"));
        if (((String) AbstractC0000a.m10g(listAsList, 1)).trim().isEmpty()) {
            return listAsList;
        }
        ArrayList arrayList = new ArrayList(listAsList);
        arrayList.add("");
        return arrayList;
    }
}
