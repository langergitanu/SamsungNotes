package kotlin.coroutines.jvm.internal;

import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.JvmName;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Target({ElementType.TYPE})
@SinceKotlin(version = "1.3")
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0011\b\u0081\u0002\u0018\u00002\u00020\u0001B\\\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t8G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t8G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\f\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\r\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011¨\u0006\u001a"}, m13886d2 = {"Lkotlin/coroutines/jvm/internal/DebugMetadata;", "", "version", "", "sourceFile", "", "lineNumbers", "", "localNames", "", "spilled", "indexToLabel", "methodName", SearchIndexablesContract.BaseColumns.COLUMN_CLASS_NAME, VPathDataCmd.RCurveTo, "()I", "f", "()Ljava/lang/String;", "l", "()[I", "n", "()[Ljava/lang/String;", "s", "i", "m", "c", "kotlin-stdlib"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.RUNTIME)
public @interface DebugMetadata {
    @JvmName(name = "c")
    /* JADX INFO: renamed from: c */
    String m14020c() default "";

    @JvmName(name = "f")
    /* JADX INFO: renamed from: f */
    String m14021f() default "";

    @JvmName(name = "i")
    /* JADX INFO: renamed from: i */
    int[] m14022i() default {};

    @JvmName(name = "l")
    /* JADX INFO: renamed from: l */
    int[] m14023l() default {};

    @JvmName(name = "m")
    /* JADX INFO: renamed from: m */
    String m14024m() default "";

    @JvmName(name = "n")
    /* JADX INFO: renamed from: n */
    String[] m14025n() default {};

    @JvmName(name = "s")
    /* JADX INFO: renamed from: s */
    String[] m14026s() default {};

    @JvmName(name = VPathDataCmd.RCurveTo)
    /* JADX INFO: renamed from: v */
    int m14027v() default 1;
}
