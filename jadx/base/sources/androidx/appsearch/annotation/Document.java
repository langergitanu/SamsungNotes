package androidx.appsearch.annotation;

import androidx.appsearch.app.LongSerializer;
import androidx.appsearch.app.StringSerializer;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface Document {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Target({ElementType.FIELD, ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface BooleanProperty {
        String name() default "";

        boolean required() default false;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Target({ElementType.METHOD, ElementType.TYPE})
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface BuilderProducer {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Target({ElementType.FIELD, ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface BytesProperty {
        String name() default "";

        boolean required() default false;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Target({ElementType.FIELD, ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface CreationTimestampMillis {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Target({ElementType.FIELD, ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface DocumentProperty {
        boolean indexNestedProperties() default false;

        String[] indexableNestedPropertiesList() default {};

        boolean inheritIndexableNestedPropertiesFromSuperclass() default false;

        String name() default "";

        boolean required() default false;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Target({ElementType.FIELD, ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface DoubleProperty {
        String name() default "";

        boolean required() default false;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Target({ElementType.FIELD, ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface EmbeddingProperty {
        int indexingType() default 0;

        String name() default "";

        boolean required() default false;
    }

    /* JADX INFO: renamed from: androidx.appsearch.annotation.Document$Id */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Target({ElementType.FIELD, ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface InterfaceC0555Id {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Target({ElementType.FIELD, ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface LongProperty {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class DefaultSerializer implements LongSerializer<Long> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.appsearch.app.LongSerializer
            public Long deserialize(long j) {
                return Long.valueOf(j);
            }

            @Override // androidx.appsearch.app.LongSerializer
            public long serialize(Long l) {
                return l.longValue();
            }
        }

        int indexingType() default 0;

        String name() default "";

        boolean required() default false;

        Class<? extends LongSerializer<?>> serializer() default DefaultSerializer.class;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Target({ElementType.FIELD, ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface Namespace {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Target({ElementType.FIELD, ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface Score {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Target({ElementType.FIELD, ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface StringProperty {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class DefaultSerializer implements StringSerializer<String> {
            @Override // androidx.appsearch.app.StringSerializer
            public String deserialize(String str) {
                return str;
            }

            @Override // androidx.appsearch.app.StringSerializer
            public String serialize(String str) {
                return str;
            }
        }

        int indexingType() default 0;

        int joinableValueType() default 0;

        String name() default "";

        boolean required() default false;

        Class<? extends StringSerializer<?>> serializer() default DefaultSerializer.class;

        int tokenizerType() default 1;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Target({ElementType.FIELD, ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface TtlMillis {
    }

    String name() default "";

    Class<?>[] parent() default {};
}
