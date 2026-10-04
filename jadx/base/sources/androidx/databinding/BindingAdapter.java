package androidx.databinding;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Target({ElementType.METHOD})
public @interface BindingAdapter {
    boolean requireAll() default true;

    String[] value();
}
