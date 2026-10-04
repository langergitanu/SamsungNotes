package com.opencsv;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface ICSVWriter extends Closeable, Flushable {
    public static final char DEFAULT_ESCAPE_CHARACTER = '\"';
    public static final String DEFAULT_LINE_END = "\n";
    public static final char DEFAULT_QUOTE_CHARACTER = '\"';
    public static final char DEFAULT_SEPARATOR = ',';
    public static final int INITIAL_STRING_SIZE = 1024;
    public static final char NO_ESCAPE_CHARACTER = 0;
    public static final char NO_QUOTE_CHARACTER = 0;
    public static final String RFC4180_LINE_END = "\r\n";

    boolean checkError();

    default void flushQuietly() {
        try {
            flush();
        } catch (IOException unused) {
        }
    }

    IOException getException();

    void resetError();

    void setResultService(ResultSetHelper resultSetHelper);

    int writeAll(ResultSet resultSet, boolean z, boolean z2, boolean z3);

    void writeAll(Iterable<String[]> iterable, boolean z);

    default void writeAll(List<String[]> list, boolean z) {
        writeAll((Iterable<String[]>) list, z);
    }

    default void writeNext(String[] strArr) {
        writeNext(strArr, true);
    }

    void writeNext(String[] strArr, boolean z);

    default void writeAll(Iterable<String[]> iterable) {
        writeAll(iterable, true);
    }

    default void writeAll(List<String[]> list) {
        writeAll((Iterable<String[]>) list);
    }

    default int writeAll(ResultSet resultSet, boolean z) {
        return writeAll(resultSet, z, false, true);
    }

    default int writeAll(ResultSet resultSet, boolean z, boolean z2) {
        return writeAll(resultSet, z, z2, true);
    }
}
