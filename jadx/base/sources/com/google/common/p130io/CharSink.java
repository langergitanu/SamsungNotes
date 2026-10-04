package com.google.common.p130io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedWriter;
import java.io.Writer;
import java.util.Iterator;
import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
public abstract class CharSink {
    public Writer openBufferedStream() {
        Writer writerOpenStream = openStream();
        return writerOpenStream instanceof BufferedWriter ? (BufferedWriter) writerOpenStream : new BufferedWriter(writerOpenStream);
    }

    public abstract Writer openStream();

    public void write(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        try {
            Writer writer = (Writer) Closer.create().register(openStream());
            writer.append(charSequence);
            writer.flush();
        } finally {
        }
    }

    @CanIgnoreReturnValue
    public long writeFrom(Readable readable) {
        Preconditions.checkNotNull(readable);
        try {
            Writer writer = (Writer) Closer.create().register(openStream());
            long jCopy = CharStreams.copy(readable, writer);
            writer.flush();
            return jCopy;
        } finally {
        }
    }

    public void writeLines(Iterable<? extends CharSequence> iterable) {
        writeLines(iterable, System.getProperty(SystemProperties.LINE_SEPARATOR));
    }

    public void writeLines(Iterable<? extends CharSequence> iterable, String str) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(str);
        try {
            Writer writer = (Writer) Closer.create().register(openBufferedStream());
            Iterator<? extends CharSequence> it = iterable.iterator();
            while (it.hasNext()) {
                writer.append(it.next()).append((CharSequence) str);
            }
            writer.flush();
        } finally {
        }
    }
}
