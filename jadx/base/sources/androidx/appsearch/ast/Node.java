package androidx.appsearch.ast;

import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalAppSearchApi
@FlaggedApi(Flags.FLAG_ENABLE_ABSTRACT_SYNTAX_TREES)
public interface Node {
    default List<Node> getChildren() {
        return Collections.EMPTY_LIST;
    }
}
