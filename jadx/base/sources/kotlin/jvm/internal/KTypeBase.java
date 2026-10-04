package kotlin.jvm.internal;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.reflect.KType;
import org.apache.xmlbeans.XmlOptions;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@SinceKotlin(version = XmlOptions.GENERATE_JAVA_14)
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"Lkotlin/jvm/internal/KTypeBase;", "Lkotlin/reflect/KType;", "javaType", "Ljava/lang/reflect/Type;", "getJavaType", "()Ljava/lang/reflect/Type;", "kotlin-stdlib"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface KTypeBase extends KType {
    @Nullable
    Type getJavaType();
}
