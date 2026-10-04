package opennlp.tools.formats.brat;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class AttributeAnnotation extends BratAnnotation {
    private final String attachedTo;
    private final String value;

    public AttributeAnnotation(String str, String str2, String str3, String str4) {
        super(str, str2);
        this.attachedTo = str3;
        this.value = str4;
    }

    public String getAttachedTo() {
        return this.attachedTo;
    }

    public String getValue() {
        return this.value;
    }

    @Override // opennlp.tools.formats.brat.BratAnnotation
    public String toString() {
        String string = super.toString();
        String str = this.attachedTo;
        String str2 = this.value;
        return AbstractC2821a.m2221l(string, " ", str, str2 != null ? AbstractC0541b.m772n(" ", str2) : "");
    }
}
