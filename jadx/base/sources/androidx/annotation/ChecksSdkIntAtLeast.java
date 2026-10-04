package androidx.annotation;

import com.sec.android.diagmonagent.log.provider.utils.BundleContract;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import uk.p245ac.p246ed.p247ph.snuggletex.utilities.MathMLUtilities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.FIELD, ElementType.METHOD})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.FIELD})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
@MustBeDocumented
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087\u0002\u0018\u00002\u00020\u0001B2\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\tR\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\nR\u000f\u0010\b\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000f\u0010\u0007\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u000f\u0010\u0006\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0006\u0010\t¨\u0006\u000b"}, m13886d2 = {"Landroidx/annotation/ChecksSdkIntAtLeast;", "", "api", "", "codename", "", "parameter", "lambda", BundleContract.EXTRA_DATA, "()I", "()Ljava/lang/String;", MathMLUtilities.ANNOTATION_LOCAL_NAME}, m13887k = 1, m13888mv = {1, 7, 0}, m13890xi = 48)
@Documented
public @interface ChecksSdkIntAtLeast {
    int api() default -1;

    String codename() default "";

    int extension() default 0;

    int lambda() default -1;

    int parameter() default -1;
}
