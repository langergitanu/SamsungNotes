package com.vladsch.flexmark.ast.util;

import com.opencsv.bean.C6618c;
import com.vladsch.flexmark.ast.ImageRef;
import com.vladsch.flexmark.ast.LinkRef;
import com.vladsch.flexmark.ast.RefNode;
import com.vladsch.flexmark.ast.Reference;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.KeepType;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.NodeRepository;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.DataKey;
import com.vladsch.flexmark.util.sequence.Escaping;
import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ReferenceRepository extends NodeRepository<Reference> {
    public ReferenceRepository(DataHolder dataHolder) {
        super(Parser.REFERENCES_KEEP.get(dataHolder));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getReferencedElements$0(HashSet hashSet, Node node) {
        Reference referenceNode;
        if (!(node instanceof RefNode) || (referenceNode = ((RefNode) node).getReferenceNode(this)) == null) {
            return;
        }
        hashSet.add(referenceNode);
    }

    @Override // com.vladsch.flexmark.util.ast.NodeRepository
    @NotNull
    public DataKey<? extends NodeRepository<Reference>> getDataKey() {
        return Parser.REFERENCES;
    }

    @Override // com.vladsch.flexmark.util.ast.NodeRepository
    @NotNull
    public DataKey<KeepType> getKeepDataKey() {
        return Parser.REFERENCES_KEEP;
    }

    @Override // com.vladsch.flexmark.util.ast.NodeRepository
    @NotNull
    public Set<Reference> getReferencedElements(Node node) {
        HashSet hashSet = new HashSet();
        visitNodes(node, new C6618c(this, hashSet, 8), LinkRef.class, ImageRef.class);
        return hashSet;
    }

    @Override // com.vladsch.flexmark.util.ast.NodeRepository
    @NotNull
    public String normalizeKey(@NotNull CharSequence charSequence) {
        return Escaping.normalizeReference(charSequence, true);
    }
}
