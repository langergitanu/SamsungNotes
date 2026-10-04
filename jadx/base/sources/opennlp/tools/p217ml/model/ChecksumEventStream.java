package opennlp.tools.p217ml.model;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbstractC9718n;
import java.nio.charset.StandardCharsets;
import java.util.zip.Checksum;
import opennlp.tools.util.AbstractObjectStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ChecksumEventStream extends AbstractObjectStream<Event> {
    private final Checksum checksum;

    public ChecksumEventStream(ObjectStream<Event> objectStream) {
        super(objectStream);
        this.checksum = AbstractC9718n.m10137e();
    }

    public long calculateChecksum() {
        return this.checksum.getValue();
    }

    @Override // opennlp.tools.util.AbstractObjectStream, opennlp.tools.util.ObjectStream
    public Event read() {
        Event event = (Event) super.read();
        if (event != null) {
            this.checksum.update(event.toString().getBytes(StandardCharsets.UTF_8));
        }
        return event;
    }
}
