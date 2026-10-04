package com.google.android.datatransport.runtime;

import androidx.glance.AbstractC2821a;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class AutoProtoEncoderDoNotUseEncoder implements Configurator {
    public static final int CODEGEN_VERSION = 2;
    public static final Configurator CONFIG = new AutoProtoEncoderDoNotUseEncoder();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ClientMetricsEncoder implements ObjectEncoder<ClientMetrics> {
        static final ClientMetricsEncoder INSTANCE = new ClientMetricsEncoder();
        private static final FieldDescriptor WINDOW_DESCRIPTOR = AbstractC2821a.m2216g(1, FieldDescriptor.builder("window"));
        private static final FieldDescriptor LOGSOURCEMETRICS_DESCRIPTOR = AbstractC2821a.m2216g(2, FieldDescriptor.builder("logSourceMetrics"));
        private static final FieldDescriptor GLOBALMETRICS_DESCRIPTOR = AbstractC2821a.m2216g(3, FieldDescriptor.builder("globalMetrics"));
        private static final FieldDescriptor APPNAMESPACE_DESCRIPTOR = AbstractC2821a.m2216g(4, FieldDescriptor.builder("appNamespace"));

        private ClientMetricsEncoder() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public void encode(ClientMetrics clientMetrics, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(WINDOW_DESCRIPTOR, clientMetrics.getWindowInternal());
            objectEncoderContext.add(LOGSOURCEMETRICS_DESCRIPTOR, clientMetrics.getLogSourceMetricsList());
            objectEncoderContext.add(GLOBALMETRICS_DESCRIPTOR, clientMetrics.getGlobalMetricsInternal());
            objectEncoderContext.add(APPNAMESPACE_DESCRIPTOR, clientMetrics.getAppNamespace());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class GlobalMetricsEncoder implements ObjectEncoder<GlobalMetrics> {
        static final GlobalMetricsEncoder INSTANCE = new GlobalMetricsEncoder();
        private static final FieldDescriptor STORAGEMETRICS_DESCRIPTOR = AbstractC2821a.m2216g(1, FieldDescriptor.builder("storageMetrics"));

        private GlobalMetricsEncoder() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public void encode(GlobalMetrics globalMetrics, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(STORAGEMETRICS_DESCRIPTOR, globalMetrics.getStorageMetricsInternal());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class LogEventDroppedEncoder implements ObjectEncoder<LogEventDropped> {
        static final LogEventDroppedEncoder INSTANCE = new LogEventDroppedEncoder();
        private static final FieldDescriptor EVENTSDROPPEDCOUNT_DESCRIPTOR = AbstractC2821a.m2216g(1, FieldDescriptor.builder("eventsDroppedCount"));
        private static final FieldDescriptor REASON_DESCRIPTOR = AbstractC2821a.m2216g(3, FieldDescriptor.builder("reason"));

        private LogEventDroppedEncoder() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public void encode(LogEventDropped logEventDropped, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(EVENTSDROPPEDCOUNT_DESCRIPTOR, logEventDropped.getEventsDroppedCount());
            objectEncoderContext.add(REASON_DESCRIPTOR, logEventDropped.getReason());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class LogSourceMetricsEncoder implements ObjectEncoder<LogSourceMetrics> {
        static final LogSourceMetricsEncoder INSTANCE = new LogSourceMetricsEncoder();
        private static final FieldDescriptor LOGSOURCE_DESCRIPTOR = AbstractC2821a.m2216g(1, FieldDescriptor.builder("logSource"));
        private static final FieldDescriptor LOGEVENTDROPPED_DESCRIPTOR = AbstractC2821a.m2216g(2, FieldDescriptor.builder("logEventDropped"));

        private LogSourceMetricsEncoder() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public void encode(LogSourceMetrics logSourceMetrics, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(LOGSOURCE_DESCRIPTOR, logSourceMetrics.getLogSource());
            objectEncoderContext.add(LOGEVENTDROPPED_DESCRIPTOR, logSourceMetrics.getLogEventDroppedList());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ProtoEncoderDoNotUseEncoder implements ObjectEncoder<ProtoEncoderDoNotUse> {
        static final ProtoEncoderDoNotUseEncoder INSTANCE = new ProtoEncoderDoNotUseEncoder();
        private static final FieldDescriptor CLIENTMETRICS_DESCRIPTOR = FieldDescriptor.m4562of("clientMetrics");

        private ProtoEncoderDoNotUseEncoder() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public void encode(ProtoEncoderDoNotUse protoEncoderDoNotUse, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(CLIENTMETRICS_DESCRIPTOR, protoEncoderDoNotUse.getClientMetrics());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class StorageMetricsEncoder implements ObjectEncoder<StorageMetrics> {
        static final StorageMetricsEncoder INSTANCE = new StorageMetricsEncoder();
        private static final FieldDescriptor CURRENTCACHESIZEBYTES_DESCRIPTOR = AbstractC2821a.m2216g(1, FieldDescriptor.builder("currentCacheSizeBytes"));
        private static final FieldDescriptor MAXCACHESIZEBYTES_DESCRIPTOR = AbstractC2821a.m2216g(2, FieldDescriptor.builder("maxCacheSizeBytes"));

        private StorageMetricsEncoder() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public void encode(StorageMetrics storageMetrics, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(CURRENTCACHESIZEBYTES_DESCRIPTOR, storageMetrics.getCurrentCacheSizeBytes());
            objectEncoderContext.add(MAXCACHESIZEBYTES_DESCRIPTOR, storageMetrics.getMaxCacheSizeBytes());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TimeWindowEncoder implements ObjectEncoder<TimeWindow> {
        static final TimeWindowEncoder INSTANCE = new TimeWindowEncoder();
        private static final FieldDescriptor STARTMS_DESCRIPTOR = AbstractC2821a.m2216g(1, FieldDescriptor.builder("startMs"));
        private static final FieldDescriptor ENDMS_DESCRIPTOR = AbstractC2821a.m2216g(2, FieldDescriptor.builder("endMs"));

        private TimeWindowEncoder() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public void encode(TimeWindow timeWindow, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(STARTMS_DESCRIPTOR, timeWindow.getStartMs());
            objectEncoderContext.add(ENDMS_DESCRIPTOR, timeWindow.getEndMs());
        }
    }

    private AutoProtoEncoderDoNotUseEncoder() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig<?> encoderConfig) {
        encoderConfig.registerEncoder(ProtoEncoderDoNotUse.class, ProtoEncoderDoNotUseEncoder.INSTANCE);
        encoderConfig.registerEncoder(ClientMetrics.class, ClientMetricsEncoder.INSTANCE);
        encoderConfig.registerEncoder(TimeWindow.class, TimeWindowEncoder.INSTANCE);
        encoderConfig.registerEncoder(LogSourceMetrics.class, LogSourceMetricsEncoder.INSTANCE);
        encoderConfig.registerEncoder(LogEventDropped.class, LogEventDroppedEncoder.INSTANCE);
        encoderConfig.registerEncoder(GlobalMetrics.class, GlobalMetricsEncoder.INSTANCE);
        encoderConfig.registerEncoder(StorageMetrics.class, StorageMetricsEncoder.INSTANCE);
    }
}
