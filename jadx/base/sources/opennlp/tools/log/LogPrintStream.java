package opennlp.tools.log;

import java.io.PrintStream;
import java.util.Objects;
import opennlp.tools.commons.Internal;
import org.slf4j.Logger;
import org.slf4j.event.Level;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class LogPrintStream extends PrintStream {
    private final Level level;
    private final Logger logger;

    /* JADX INFO: renamed from: opennlp.tools.log.LogPrintStream$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C136361 {
        static final /* synthetic */ int[] $SwitchMap$org$slf4j$event$Level;

        static {
            int[] iArr = new int[Level.values().length];
            $SwitchMap$org$slf4j$event$Level = iArr;
            try {
                iArr[Level.TRACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$slf4j$event$Level[Level.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$slf4j$event$Level[Level.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$slf4j$event$Level[Level.WARN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$slf4j$event$Level[Level.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public LogPrintStream(Logger logger) {
        this(logger, Level.INFO);
    }

    private void log(String str) {
        int i = C136361.$SwitchMap$org$slf4j$event$Level[this.level.ordinal()];
        if (i == 1) {
            this.logger.trace(str);
            return;
        }
        if (i == 2) {
            this.logger.debug(str);
            return;
        }
        if (i == 3) {
            this.logger.info(str);
        } else if (i == 4) {
            this.logger.warn(str);
        } else {
            if (i != 5) {
                return;
            }
            this.logger.error(str);
        }
    }

    @Override // java.io.PrintStream
    public PrintStream printf(String str, Object... objArr) {
        log(String.format(str, objArr));
        return this;
    }

    @Override // java.io.PrintStream
    public void println(String str) {
        log(str);
    }

    public LogPrintStream(Logger logger, Level level) {
        super(PrintStream.nullOutputStream());
        Objects.requireNonNull(logger, "logger must not be NULL.");
        Objects.requireNonNull(level, "log level must not be NULL.");
        this.logger = logger;
        this.level = level;
    }
}
