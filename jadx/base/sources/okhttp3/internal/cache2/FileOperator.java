package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import okio.Buffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel fileChannel) {
        this.fileChannel = fileChannel;
    }

    public void read(long j, Buffer buffer, long j2) throws IOException {
        if (j2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        long j3 = j;
        long j5 = j2;
        while (j5 > 0) {
            long jTransferTo = this.fileChannel.transferTo(j3, j5, buffer);
            j3 += jTransferTo;
            j5 -= jTransferTo;
        }
    }

    public void write(long j, Buffer buffer, long j2) throws IOException {
        if (j2 < 0 || j2 > buffer.size()) {
            throw new IndexOutOfBoundsException();
        }
        long j3 = j;
        long j5 = j2;
        while (j5 > 0) {
            long jTransferFrom = this.fileChannel.transferFrom(buffer, j3, j5);
            j3 += jTransferFrom;
            j5 -= jTransferFrom;
        }
    }
}
