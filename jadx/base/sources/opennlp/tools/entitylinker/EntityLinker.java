package opennlp.tools.entitylinker;

import java.util.List;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface EntityLinker<T extends Span> {
    List<T> find(String str, Span[] spanArr, Span[][] spanArr2, Span[][] spanArr3);

    List<T> find(String str, Span[] spanArr, Span[][] spanArr2, Span[][] spanArr3, int i);

    void init(EntityLinkerProperties entityLinkerProperties);
}
