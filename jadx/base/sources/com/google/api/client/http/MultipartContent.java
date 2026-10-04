package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StreamingContent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class MultipartContent extends AbstractHttpContent {
    static final String NEWLINE = "\r\n";
    private static final String TWO_DASHES = "--";
    private ArrayList<Part> parts;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Part {
        HttpContent content;
        HttpEncoding encoding;
        HttpHeaders headers;

        public Part() {
            this(null);
        }

        public HttpContent getContent() {
            return this.content;
        }

        public HttpEncoding getEncoding() {
            return this.encoding;
        }

        public HttpHeaders getHeaders() {
            return this.headers;
        }

        public Part setContent(HttpContent httpContent) {
            this.content = httpContent;
            return this;
        }

        public Part setEncoding(HttpEncoding httpEncoding) {
            this.encoding = httpEncoding;
            return this;
        }

        public Part setHeaders(HttpHeaders httpHeaders) {
            this.headers = httpHeaders;
            return this;
        }

        public Part(HttpContent httpContent) {
            this(null, httpContent);
        }

        public Part(HttpHeaders httpHeaders, HttpContent httpContent) {
            setHeaders(httpHeaders);
            setContent(httpContent);
        }
    }

    public MultipartContent() {
        super(new HttpMediaType("multipart/related").setParameter("boundary", "__END_OF_PART__"));
        this.parts = new ArrayList<>();
    }

    public MultipartContent addPart(Part part) {
        this.parts.add((Part) Preconditions.checkNotNull(part));
        return this;
    }

    public final String getBoundary() {
        return getMediaType().getParameter("boundary");
    }

    public final Collection<Part> getParts() {
        return Collections.unmodifiableCollection(this.parts);
    }

    @Override // com.google.api.client.http.AbstractHttpContent, com.google.api.client.http.HttpContent
    public boolean retrySupported() {
        Iterator<Part> it = this.parts.iterator();
        while (it.hasNext()) {
            if (!it.next().content.retrySupported()) {
                return false;
            }
        }
        return true;
    }

    public MultipartContent setBoundary(String str) {
        getMediaType().setParameter("boundary", (String) Preconditions.checkNotNull(str));
        return this;
    }

    public MultipartContent setContentParts(Collection<? extends HttpContent> collection) {
        this.parts = new ArrayList<>(collection.size());
        Iterator<? extends HttpContent> it = collection.iterator();
        while (it.hasNext()) {
            addPart(new Part(it.next()));
        }
        return this;
    }

    public MultipartContent setParts(Collection<Part> collection) {
        this.parts = new ArrayList<>(collection);
        return this;
    }

    @Override // com.google.api.client.http.HttpContent, com.google.api.client.util.StreamingContent
    public void writeTo(OutputStream outputStream) throws IOException {
        StreamingContent streamingContent;
        StreamingContent streamingContent2;
        long length;
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, getCharset());
        String boundary = getBoundary();
        for (Part part : this.parts) {
            HttpHeaders acceptEncoding = new HttpHeaders().setAcceptEncoding(null);
            HttpHeaders httpHeaders = part.headers;
            if (httpHeaders != null) {
                acceptEncoding.fromHttpHeaders(httpHeaders);
            }
            acceptEncoding.setContentEncoding(null).setUserAgent(null).setContentType(null).setContentLength(null).set("Content-Transfer-Encoding", (Object) null);
            HttpContent httpContent = part.content;
            if (httpContent != null) {
                acceptEncoding.set("Content-Transfer-Encoding", (Object) Arrays.asList("binary"));
                acceptEncoding.setContentType(httpContent.getType());
                HttpEncoding httpEncoding = part.encoding;
                if (httpEncoding == null) {
                    length = httpContent.getLength();
                    streamingContent2 = httpContent;
                } else {
                    acceptEncoding.setContentEncoding(httpEncoding.getName());
                    HttpEncodingStreamingContent httpEncodingStreamingContent = new HttpEncodingStreamingContent(httpContent, httpEncoding);
                    long jComputeLength = AbstractHttpContent.computeLength(httpContent);
                    streamingContent2 = httpEncodingStreamingContent;
                    length = jComputeLength;
                }
                streamingContent = streamingContent2;
                if (length != -1) {
                    acceptEncoding.setContentLength(Long.valueOf(length));
                    streamingContent = streamingContent2;
                }
            } else {
                streamingContent = null;
            }
            outputStreamWriter.write(TWO_DASHES);
            outputStreamWriter.write(boundary);
            outputStreamWriter.write("\r\n");
            HttpHeaders.serializeHeadersForMultipartRequests(acceptEncoding, null, null, outputStreamWriter);
            if (streamingContent != null) {
                outputStreamWriter.write("\r\n");
                outputStreamWriter.flush();
                streamingContent.writeTo(outputStream);
            }
            outputStreamWriter.write("\r\n");
        }
        outputStreamWriter.write(TWO_DASHES);
        outputStreamWriter.write(boundary);
        outputStreamWriter.write(TWO_DASHES);
        outputStreamWriter.write("\r\n");
        outputStreamWriter.flush();
    }

    @Override // com.google.api.client.http.AbstractHttpContent
    public MultipartContent setMediaType(HttpMediaType httpMediaType) {
        super.setMediaType(httpMediaType);
        return this;
    }
}
