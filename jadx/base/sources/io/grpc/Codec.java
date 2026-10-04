package io.grpc;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
public interface Codec extends Compressor, Decompressor {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Gzip implements Codec {
        @Override // io.grpc.Compressor
        public OutputStream compress(OutputStream outputStream) {
            return new GZIPOutputStream(outputStream);
        }

        @Override // io.grpc.Decompressor
        public InputStream decompress(InputStream inputStream) {
            return new GZIPInputStream(inputStream);
        }

        @Override // io.grpc.Compressor, io.grpc.Decompressor
        public String getMessageEncoding() {
            return "gzip";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Identity implements Codec {
        public static final Codec NONE = new Identity();

        private Identity() {
        }

        @Override // io.grpc.Compressor
        public OutputStream compress(OutputStream outputStream) {
            return outputStream;
        }

        @Override // io.grpc.Decompressor
        public InputStream decompress(InputStream inputStream) {
            return inputStream;
        }

        @Override // io.grpc.Compressor, io.grpc.Decompressor
        public String getMessageEncoding() {
            return "identity";
        }
    }
}
