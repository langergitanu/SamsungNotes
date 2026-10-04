package javax.annotation.sql;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Target({ElementType.TYPE})
@Repeatable(DataSourceDefinitions.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSourceDefinition {
    String className();

    String databaseName() default "";

    String description() default "";

    int initialPoolSize() default -1;

    int isolationLevel() default -1;

    int loginTimeout() default 0;

    int maxIdleTime() default -1;

    int maxPoolSize() default -1;

    int maxStatements() default -1;

    int minPoolSize() default -1;

    String name();

    String password() default "";

    int portNumber() default -1;

    String[] properties() default {};

    String serverName() default "localhost";

    boolean transactional() default true;

    String url() default "";

    String user() default "";
}
