package opennlp.tools.formats.brat;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class AnnotatorNoteAnnotation extends BratAnnotation {
    private final String attachedId;

    public AnnotatorNoteAnnotation(String str, String str2, String str3) {
        super(str, "#AnnotationNote");
        this.attachedId = str2;
        setNote(str3);
    }

    public String getAttachedId() {
        return this.attachedId;
    }
}
