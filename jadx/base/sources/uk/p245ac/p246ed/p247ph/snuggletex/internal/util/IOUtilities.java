package uk.p245ac.p246ed.p247ph.snuggletex.internal.util;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class IOUtilities {
    public static final int BUFFER_SIZE = 32768;
    public static final int MAX_TEXT_STREAM_SIZE = 1048576;

    public static void ensureClose(Closeable... closeableArr) throws IOException {
        IOException e = null;
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e2) {
                    e = e2;
                }
            }
        }
        if (e != null) {
            throw e;
        }
    }

    public static File ensureDirectoryCreated(File file) throws IOException {
        if (file.isDirectory() || file.mkdirs()) {
            return file;
        }
        throw new IOException(AbstractC2322a.m1617g(file, "Could not create directory "));
    }

    public static File ensureFileCreated(File file) throws IOException {
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            ensureDirectoryCreated(parentFile);
        }
        if (file.isFile() || file.createNewFile()) {
            return file;
        }
        throw new IOException(AbstractC2322a.m1617g(file, "Could not create file "));
    }

    public static String readCharacterStream(Reader reader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        int iM2212c = 0;
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                return sb.toString();
            }
            iM2212c = AbstractC2821a.m2212c(1, iM2212c, line);
            if (iM2212c > 1048576) {
                throw new IOException("String data exceeds current maximum safe size (1048576)");
            }
            sb.append(line);
            sb.append("\n");
        }
    }

    public static String readUnicodeFile(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return readUnicodeStream(fileInputStream);
        } finally {
            fileInputStream.close();
        }
    }

    public static String readUnicodeStream(InputStream inputStream) {
        return readCharacterStream(new InputStreamReader(inputStream, "UTF-8"));
    }

    public static void transfer(InputStream inputStream, OutputStream outputStream) throws IOException {
        if ((inputStream instanceof FileInputStream) && (outputStream instanceof FileOutputStream)) {
            transfer((FileInputStream) inputStream, (FileOutputStream) outputStream);
        } else {
            transfer(inputStream, outputStream, true);
        }
    }

    public static void transfer(FileInputStream fileInputStream, FileOutputStream fileOutputStream) throws IOException {
        FileChannel channel = fileInputStream.getChannel();
        FileChannel channel2 = fileOutputStream.getChannel();
        long size = channel.size();
        try {
            if (channel.transferTo(0L, size, channel2) == size) {
                ensureClose(channel, channel2);
                return;
            }
            throw new IOException("transfer() did not complete");
        } catch (Throwable th) {
            ensureClose(channel, channel2);
            throw th;
        }
    }

    public static void transfer(InputStream inputStream, OutputStream outputStream, boolean z) throws IOException {
        transfer(inputStream, outputStream, true, z);
    }

    public static void transfer(InputStream inputStream, OutputStream outputStream, boolean z, boolean z2) throws IOException {
        byte[] bArr = new byte[32768];
        while (true) {
            try {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    break;
                } else {
                    outputStream.write(bArr, 0, i);
                }
            } finally {
                if (z) {
                    inputStream.close();
                }
                if (z2) {
                    outputStream.close();
                } else {
                    outputStream.flush();
                }
            }
        }
    }
}
