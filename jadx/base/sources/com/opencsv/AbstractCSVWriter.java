package com.opencsv;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.ResultSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractCSVWriter implements ICSVWriter {
    protected volatile IOException exception;
    private final String lineEnd;
    private ResultSetHelper resultService;
    private final Writer writer;

    public AbstractCSVWriter(Writer writer, String str) {
        this.writer = writer;
        this.lineEnd = str;
    }

    @Override // com.opencsv.ICSVWriter
    public boolean checkError() {
        Writer writer = this.writer;
        if (writer instanceof PrintWriter) {
            return ((PrintWriter) writer).checkError();
        }
        if (this.exception != null) {
            flushQuietly();
        } else {
            try {
                flush();
            } catch (IOException e) {
                this.exception = e;
            }
        }
        return this.exception != null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
        this.writer.close();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.writer.flush();
    }

    @Override // com.opencsv.ICSVWriter
    public IOException getException() {
        return this.exception;
    }

    public final String getLineEnd() {
        return this.lineEnd;
    }

    public final Writer getWriter() {
        return this.writer;
    }

    @Override // com.opencsv.ICSVWriter
    public void resetError() {
        this.exception = null;
    }

    public ResultSetHelper resultService() {
        if (this.resultService == null) {
            this.resultService = new ResultSetHelperService();
        }
        return this.resultService;
    }

    @Override // com.opencsv.ICSVWriter
    public void setResultService(ResultSetHelper resultSetHelper) {
        this.resultService = resultSetHelper;
    }

    @Override // com.opencsv.ICSVWriter
    public void writeAll(Iterable<String[]> iterable, boolean z) {
        StringBuilder sb = new StringBuilder(1024);
        try {
            Iterator<String[]> it = iterable.iterator();
            while (it.hasNext()) {
                writeNext(it.next(), z, sb);
                sb.setLength(0);
            }
        } catch (IOException e) {
            this.exception = e;
        }
    }

    public void writeColumnNames(ResultSet resultSet, boolean z) {
        writeNext(resultService().getColumnNames(resultSet), z);
    }

    @Override // com.opencsv.ICSVWriter
    public void writeNext(String[] strArr, boolean z) {
        try {
            writeNext(strArr, z, new StringBuilder(1024));
        } catch (IOException e) {
            this.exception = e;
        }
    }

    public abstract void writeNext(String[] strArr, boolean z, Appendable appendable);

    @Override // com.opencsv.ICSVWriter
    public int writeAll(ResultSet resultSet, boolean z, boolean z2, boolean z3) {
        int i;
        if (z) {
            writeColumnNames(resultSet, z3);
            i = 1;
        } else {
            i = 0;
        }
        while (resultSet.next()) {
            writeNext(resultService().getColumnValues(resultSet, z2), z3);
            i++;
        }
        return i;
    }
}
