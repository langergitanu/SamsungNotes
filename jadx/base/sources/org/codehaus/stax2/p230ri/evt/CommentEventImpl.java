package org.codehaus.stax2.p230ri.evt;

import java.io.IOException;
import java.io.Writer;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.events.Comment;
import org.codehaus.stax2.XMLStreamWriter2;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class CommentEventImpl extends BaseEventImpl implements Comment {
    final String mContent;

    public CommentEventImpl(Location location, String str) {
        super(location);
        this.mContent = str;
    }

    @Override // org.codehaus.stax2.p230ri.evt.BaseEventImpl
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof Comment)) {
            return this.mContent.equals(((Comment) obj).getText());
        }
        return false;
    }

    @Override // org.codehaus.stax2.p230ri.evt.BaseEventImpl, org.apache.poi.javax.xml.stream.events.XMLEvent
    public int getEventType() {
        return 5;
    }

    @Override // org.apache.poi.javax.xml.stream.events.Comment
    public String getText() {
        return this.mContent;
    }

    @Override // org.codehaus.stax2.p230ri.evt.BaseEventImpl
    public int hashCode() {
        return this.mContent.hashCode();
    }

    @Override // org.codehaus.stax2.p230ri.evt.BaseEventImpl, org.apache.poi.javax.xml.stream.events.XMLEvent
    public void writeAsEncodedUnicode(Writer writer) throws XMLStreamException {
        try {
            writer.write("<!--");
            writer.write(this.mContent);
            writer.write("-->");
        } catch (IOException e) {
            throwFromIOE(e);
        }
    }

    @Override // org.codehaus.stax2.p230ri.evt.BaseEventImpl, org.codehaus.stax2.evt.XMLEvent2
    public void writeUsing(XMLStreamWriter2 xMLStreamWriter2) {
        xMLStreamWriter2.writeComment(this.mContent);
    }
}
