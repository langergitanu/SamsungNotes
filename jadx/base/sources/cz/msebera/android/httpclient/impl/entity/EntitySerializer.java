package cz.msebera.android.httpclient.impl.entity;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.impl.p171io.ChunkedOutputStream;
import cz.msebera.android.httpclient.impl.p171io.ContentLengthOutputStream;
import cz.msebera.android.httpclient.impl.p171io.IdentityOutputStream;
import cz.msebera.android.httpclient.p172io.SessionOutputBuffer;
import cz.msebera.android.httpclient.util.Args;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
@Deprecated
public class EntitySerializer {
    private final ContentLengthStrategy lenStrategy;

    public EntitySerializer(ContentLengthStrategy contentLengthStrategy) {
        this.lenStrategy = (ContentLengthStrategy) Args.notNull(contentLengthStrategy, "Content length strategy");
    }

    public OutputStream doSerialize(SessionOutputBuffer sessionOutputBuffer, HttpMessage httpMessage) {
        long jDetermineLength = this.lenStrategy.determineLength(httpMessage);
        return jDetermineLength == -2 ? new ChunkedOutputStream(sessionOutputBuffer) : jDetermineLength == -1 ? new IdentityOutputStream(sessionOutputBuffer) : new ContentLengthOutputStream(sessionOutputBuffer, jDetermineLength);
    }

    public void serialize(SessionOutputBuffer sessionOutputBuffer, HttpMessage httpMessage, HttpEntity httpEntity) {
        Args.notNull(sessionOutputBuffer, "Session output buffer");
        Args.notNull(httpMessage, "HTTP message");
        Args.notNull(httpEntity, "HTTP entity");
        OutputStream outputStreamDoSerialize = doSerialize(sessionOutputBuffer, httpMessage);
        httpEntity.writeTo(outputStreamDoSerialize);
        outputStreamDoSerialize.close();
    }
}
