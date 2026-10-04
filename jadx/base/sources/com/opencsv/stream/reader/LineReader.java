package com.opencsv.stream.reader;

import java.io.BufferedReader;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class LineReader {
    private final boolean keepCarriageReturns;
    private final BufferedReader reader;

    public LineReader(BufferedReader bufferedReader, boolean z) {
        this.reader = bufferedReader;
        this.keepCarriageReturns = z;
    }

    private String readUntilNewline() throws IOException {
        StringBuilder sb = new StringBuilder(1024);
        while (true) {
            int i = this.reader.read();
            if (i <= -1 || i == 10) {
                break;
            }
            sb.append((char) i);
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public String readLine() {
        return this.keepCarriageReturns ? readUntilNewline() : this.reader.readLine();
    }
}
