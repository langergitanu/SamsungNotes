package com.samsung.scsp.framework.core.network.base;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.C4512a;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.error.Logger;
import com.samsung.scsp.framework.core.listeners.ProgressListener;
import com.samsung.scsp.framework.core.network.ByteBufferWriter;
import com.samsung.scsp.framework.core.network.visitor.FileInputStreamPayloadWriter;
import com.samsung.scsp.framework.core.network.visitor.FilePayloadWriter;
import com.samsung.scsp.framework.core.network.visitor.PayloadWriterVisitor;
import com.samsung.scsp.framework.core.network.visitor.StringPayloadWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PayloadWriterVisitorImpl implements PayloadWriterVisitor<OutputStream> {
    private final Logger logger = Logger.get("PayloadWriterVisitorImpl");

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$visit$0(PayloadWriterVisitor.Payload payload) {
        return (String) payload.content;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$visit$1(PayloadWriterVisitor.Payload payload, ProgressListener progressListener, long j, long j2) {
        long j3 = payload.transferred + j2;
        payload.transferred = j3;
        progressListener.onProgress(j3, j);
    }

    @Override // com.samsung.scsp.framework.core.network.visitor.PayloadWriterVisitor
    public void visit(final PayloadWriterVisitor.Payload<OutputStream> payload, StringPayloadWriter stringPayloadWriter) throws IOException {
        this.logger.m12931d(new Supplier() { // from class: com.samsung.scsp.framework.core.network.base.j
            @Override // java.util.function.Supplier
            public final Object get() {
                return PayloadWriterVisitorImpl.lambda$visit$0(payload);
            }
        });
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(payload.output, StandardCharsets.UTF_8));
        bufferedWriter.write((String) payload.content);
        bufferedWriter.flush();
    }

    @Override // com.samsung.scsp.framework.core.network.visitor.PayloadWriterVisitor
    public void visit(PayloadWriterVisitor.Payload<OutputStream> payload, FilePayloadWriter filePayloadWriter) throws IOException {
        FileInputStream fileInputStream = new FileInputStream((File) payload.content);
        try {
            visit(payload, fileInputStream, true);
            fileInputStream.close();
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // com.samsung.scsp.framework.core.network.visitor.PayloadWriterVisitor
    public void visit(PayloadWriterVisitor.Payload<OutputStream> payload, FileInputStreamPayloadWriter fileInputStreamPayloadWriter) throws IOException {
        visit(payload, (FileInputStream) payload.content, false);
    }

    private void visit(PayloadWriterVisitor.Payload<OutputStream> payload, FileInputStream fileInputStream, boolean z) throws IOException {
        long jAvailable = fileInputStream.available();
        fileInputStream.skip(payload.transferred);
        try {
            ProgressListener progressListener = payload.httpRequest.getProgressListener();
            ByteBufferWriter.write(payload.output, fileInputStream, progressListener != null ? new C4512a(payload, progressListener, jAvailable) : null, payload.length);
            if (z) {
                FaultBarrier.run(new C11679i(fileInputStream, 2), true);
            }
        } catch (Throwable th) {
            if (z) {
                FaultBarrier.run(new C11679i(fileInputStream, 2), true);
            }
            throw th;
        }
    }
}
