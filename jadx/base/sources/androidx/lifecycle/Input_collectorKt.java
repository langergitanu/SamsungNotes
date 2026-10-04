package androidx.lifecycle;

import androidx.lifecycle.model.InputModel;
import androidx.lifecycle.model.LifecycleObserverInfo;
import com.google.auto.common.MoreElements;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, m13886d2 = {"collectAndVerifyInput", "Landroidx/lifecycle/model/InputModel;", "processingEnv", "Ljavax/annotation/processing/ProcessingEnvironment;", "roundEnv", "Ljavax/annotation/processing/RoundEnvironment;", "lifecycle-compiler"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\ninput_collector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 input_collector.kt\nandroidx/lifecycle/Input_collectorKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,183:1\n1549#2:184\n1620#2,3:185\n1855#2,2:188\n1603#2,9:190\n1855#2:199\n1856#2:202\n1612#2:203\n1#3:200\n1#3:201\n*S KotlinDebug\n*F\n+ 1 input_collector.kt\nandroidx/lifecycle/Input_collectorKt\n*L\n45#1:184\n45#1:185,3\n58#1:188,2\n61#1:190,9\n61#1:199\n61#1:202\n61#1:203\n61#1:201\n*E\n"})
public final class Input_collectorKt {
    @NotNull
    public static final InputModel collectAndVerifyInput(@NotNull ProcessingEnvironment processingEnv, @NotNull RoundEnvironment roundEnv) {
        Intrinsics.checkNotNullParameter(processingEnv, "processingEnv");
        Intrinsics.checkNotNullParameter(roundEnv, "roundEnv");
        Validator validator = new Validator(processingEnv);
        ObserversCollector observersCollector = new ObserversCollector(processingEnv);
        Set elementsAnnotatedWith = roundEnv.getElementsAnnotatedWith(OnLifecycleEvent.class);
        Intrinsics.checkNotNullExpressionValue(elementsAnnotatedWith, "roundEnv.getElementsAnno…fecycleEvent::class.java)");
        Set set = elementsAnnotatedWith;
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(set));
        Iterator it = set.iterator();
        while (true) {
            TypeElement typeElementAsType = null;
            if (!it.hasNext()) {
                break;
            }
            Element elem = (Element) it.next();
            if (elem.getKind() != ElementKind.METHOD) {
                Intrinsics.checkNotNullExpressionValue(elem, "elem");
                validator.printErrorMessage(ErrorMessages.INVALID_ANNOTATED_ELEMENT, elem);
            } else {
                Element enclosingElement = elem.getEnclosingElement();
                Intrinsics.checkNotNullExpressionValue(enclosingElement, "enclosingElement");
                if (validator.validateClass(enclosingElement)) {
                    typeElementAsType = MoreElements.asType(enclosingElement);
                }
            }
            arrayList.add(typeElementAsType);
        }
        Set set2 = CollectionsKt.toSet(CollectionsKt.filterNotNull(arrayList));
        Iterator it2 = set2.iterator();
        while (it2.hasNext()) {
            observersCollector.collect((TypeElement) it2.next());
        }
        Map<TypeElement, LifecycleObserverInfo> observers = observersCollector.getObservers();
        Set<TypeElement> setKeySet = observersCollector.getObservers().keySet();
        ArrayList arrayList2 = new ArrayList();
        for (TypeElement typeElement : setKeySet) {
            List<ExecutableElement> listGeneratedAdapterInfoFor = observersCollector.generatedAdapterInfoFor(typeElement);
            Pair pairM13893to = listGeneratedAdapterInfoFor != null ? TuplesKt.m13893to(typeElement, listGeneratedAdapterInfoFor) : null;
            if (pairM13893to != null) {
                arrayList2.add(pairM13893to);
            }
        }
        return new InputModel(set2, observers, MapsKt.toMap(arrayList2));
    }
}
