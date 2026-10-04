package org.slf4j.helpers;

import java.io.PrintStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class Reporter {
    static final String SLF4J_ERROR_PREFIX = "SLF4J(E): ";
    static final String SLF4J_INFO_PREFIX = "SLF4J(I): ";
    public static final String SLF4J_INTERNAL_REPORT_STREAM_KEY = "slf4j.internal.report.stream";
    public static final String SLF4J_INTERNAL_VERBOSITY_KEY = "slf4j.internal.verbosity";
    static final String SLF4J_WARN_PREFIX = "SLF4J(W): ";
    private static final String[] SYSOUT_KEYS = {"System.out", "stdout", "sysout"};
    private static final TargetChoice TARGET_CHOICE = initTargetChoice();
    private static final Level INTERNAL_VERBOSITY = initVerbosity();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Level {
        INFO(1),
        WARN(2),
        ERROR(3);

        int levelInt;

        Level(int i) {
            this.levelInt = i;
        }

        private int getLevelInt() {
            return this.levelInt;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum TargetChoice {
        Stderr,
        Stdout
    }

    public static final void error(String str, Throwable th) {
        getTarget().println(SLF4J_ERROR_PREFIX + str);
        getTarget().println("SLF4J(E): Reported exception:");
        th.printStackTrace(getTarget());
    }

    private static PrintStream getTarget() {
        return TARGET_CHOICE.ordinal() != 1 ? System.err : System.out;
    }

    public static void info(String str) {
        if (isEnabledFor(Level.INFO)) {
            getTarget().println(SLF4J_INFO_PREFIX + str);
        }
    }

    private static TargetChoice initTargetChoice() {
        String property = System.getProperty(SLF4J_INTERNAL_REPORT_STREAM_KEY);
        if (property == null || property.isEmpty()) {
            return TargetChoice.Stderr;
        }
        for (String str : SYSOUT_KEYS) {
            if (str.equalsIgnoreCase(property)) {
                return TargetChoice.Stdout;
            }
        }
        return TargetChoice.Stderr;
    }

    private static Level initVerbosity() {
        String property = System.getProperty(SLF4J_INTERNAL_VERBOSITY_KEY);
        return (property == null || property.isEmpty()) ? Level.INFO : property.equalsIgnoreCase("ERROR") ? Level.ERROR : property.equalsIgnoreCase("WARN") ? Level.WARN : Level.INFO;
    }

    public static boolean isEnabledFor(Level level) {
        return level.levelInt >= INTERNAL_VERBOSITY.levelInt;
    }

    public static final void warn(String str) {
        if (isEnabledFor(Level.WARN)) {
            getTarget().println(SLF4J_WARN_PREFIX + str);
        }
    }

    public static final void error(String str) {
        getTarget().println(SLF4J_ERROR_PREFIX + str);
    }
}
