package io.opentelemetry.api;

import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterBuilder;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.TracerBuilder;
import io.opentelemetry.api.trace.TracerProvider;
import io.opentelemetry.context.propagation.ContextPropagators;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class GlobalOpenTelemetry {

    @Nullable
    private static volatile ObfuscatedOpenTelemetry globalOpenTelemetry;
    private static final Logger logger = Logger.getLogger(GlobalOpenTelemetry.class.getName());
    private static final Object mutex = new Object();

    @Nullable
    private static Throwable setGlobalCaller;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @ThreadSafe
    public static class ObfuscatedOpenTelemetry implements OpenTelemetry {
        private final OpenTelemetry delegate;

        public ObfuscatedOpenTelemetry(OpenTelemetry openTelemetry) {
            this.delegate = openTelemetry;
        }

        @Override // io.opentelemetry.api.OpenTelemetry
        public MeterProvider getMeterProvider() {
            return this.delegate.getMeterProvider();
        }

        @Override // io.opentelemetry.api.OpenTelemetry
        public ContextPropagators getPropagators() {
            return this.delegate.getPropagators();
        }

        @Override // io.opentelemetry.api.OpenTelemetry
        public TracerProvider getTracerProvider() {
            return this.delegate.getTracerProvider();
        }

        @Override // io.opentelemetry.api.OpenTelemetry
        public TracerBuilder tracerBuilder(String str) {
            return this.delegate.tracerBuilder(str);
        }
    }

    private GlobalOpenTelemetry() {
    }

    public static OpenTelemetry get() {
        ObfuscatedOpenTelemetry obfuscatedOpenTelemetry = globalOpenTelemetry;
        if (obfuscatedOpenTelemetry != null) {
            return obfuscatedOpenTelemetry;
        }
        synchronized (mutex) {
            try {
                ObfuscatedOpenTelemetry obfuscatedOpenTelemetry2 = globalOpenTelemetry;
                if (obfuscatedOpenTelemetry2 != null) {
                    return obfuscatedOpenTelemetry2;
                }
                OpenTelemetry openTelemetryMaybeAutoConfigureAndSetGlobal = maybeAutoConfigureAndSetGlobal();
                if (openTelemetryMaybeAutoConfigureAndSetGlobal != null) {
                    return openTelemetryMaybeAutoConfigureAndSetGlobal;
                }
                set(OpenTelemetry.noop());
                return OpenTelemetry.noop();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Meter getMeter(String str) {
        return get().getMeter(str);
    }

    public static MeterProvider getMeterProvider() {
        return get().getMeterProvider();
    }

    public static ContextPropagators getPropagators() {
        return get().getPropagators();
    }

    public static Tracer getTracer(String str) {
        return get().getTracer(str);
    }

    public static TracerProvider getTracerProvider() {
        return get().getTracerProvider();
    }

    @Nullable
    private static OpenTelemetry maybeAutoConfigureAndSetGlobal() {
        try {
            Class<?> cls = Class.forName("io.opentelemetry.sdk.autoconfigure.AutoConfiguredOpenTelemetrySdk");
            try {
                return (OpenTelemetry) cls.getMethod("getOpenTelemetrySdk", null).invoke(cls.getMethod("initialize", null).invoke(null, null), null);
            } catch (IllegalAccessException | NoSuchMethodException e) {
                throw new IllegalStateException("OpenTelemetrySdkAutoConfiguration detected on classpath but could not invoke initialize method. This is a bug in OpenTelemetry.", e);
            } catch (InvocationTargetException e2) {
                logger.log(Level.SEVERE, "Error automatically configuring OpenTelemetry SDK. OpenTelemetry will not be enabled.", e2.getTargetException());
                return null;
            }
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static MeterBuilder meterBuilder(String str) {
        return get().meterBuilder(str);
    }

    public static void resetForTest() {
        globalOpenTelemetry = null;
    }

    public static void set(OpenTelemetry openTelemetry) {
        synchronized (mutex) {
            try {
                if (globalOpenTelemetry != null) {
                    throw new IllegalStateException("GlobalOpenTelemetry.set has already been called. GlobalOpenTelemetry.set must be called only once before any calls to GlobalOpenTelemetry.get. If you are using the OpenTelemetrySdk, use OpenTelemetrySdkBuilder.buildAndRegisterGlobal instead. Previous invocation set to cause of this exception.", setGlobalCaller);
                }
                globalOpenTelemetry = new ObfuscatedOpenTelemetry(openTelemetry);
                setGlobalCaller = new Throwable();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static TracerBuilder tracerBuilder(String str) {
        return get().tracerBuilder(str);
    }

    public static Tracer getTracer(String str, String str2) {
        return get().getTracer(str, str2);
    }
}
