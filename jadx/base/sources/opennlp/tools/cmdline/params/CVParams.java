package opennlp.tools.cmdline.params;

import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolSA;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.commons.Internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public interface CVParams {
    @ArgumentParser.OptionalParameter(defaultValue = QuickToolSA.DETAIL_QT_FIRST_BEHAVIOR_CLOSE_BY_TAPPING)
    @ArgumentParser.ParameterDescription(description = "number of folds, default is 10.", valueName = "num")
    Integer getFolds();

    @ArgumentParser.OptionalParameter(defaultValue = "false")
    @ArgumentParser.ParameterDescription(description = "if true will print false negatives and false positives.", valueName = "true|false")
    Boolean getMisclassified();
}
