package javax.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Repeatable(Resources.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Resource {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum AuthenticationType {
        CONTAINER,
        APPLICATION
    }

    AuthenticationType authenticationType() default AuthenticationType.CONTAINER;

    String description() default "";

    String lookup() default "";

    String mappedName() default "";

    String name() default "";

    boolean shareable() default true;

    Class<?> type() default Object.class;
}
