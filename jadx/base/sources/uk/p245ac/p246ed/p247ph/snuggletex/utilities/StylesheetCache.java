package uk.p245ac.p246ed.p247ph.snuggletex.utilities;

import javax.xml.transform.Templates;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public interface StylesheetCache {
    Templates getStylesheet(String str);

    void putStylesheet(String str, Templates templates);
}
