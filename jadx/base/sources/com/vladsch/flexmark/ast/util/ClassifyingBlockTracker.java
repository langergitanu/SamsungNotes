package com.vladsch.flexmark.ast.util;

import com.vladsch.flexmark.parser.block.BlockParser;
import com.vladsch.flexmark.parser.block.BlockParserTracker;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.BlockTracker;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.NodeClassifier;
import com.vladsch.flexmark.util.collection.ClassificationBag;
import com.vladsch.flexmark.util.collection.CollectionHost;
import com.vladsch.flexmark.util.collection.OrderedMultiMap;
import com.vladsch.flexmark.util.collection.OrderedSet;
import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterable;
import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
import com.vladsch.flexmark.util.misc.Paired;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ClassifyingBlockTracker implements BlockTracker, BlockParserTracker {
    protected final ClassificationBag<Class<?>, Node> nodeClassifier = new ClassificationBag<>(NodeClassifier.INSTANCE);
    protected final OrderedMultiMap<BlockParser, Block> allBlockParsersMap = new OrderedMultiMap<>(new CollectionHost<Paired<BlockParser, Block>>() { // from class: com.vladsch.flexmark.ast.util.ClassifyingBlockTracker.1
        @Override // com.vladsch.flexmark.util.collection.CollectionHost
        public void addingNulls(int i) {
        }

        @Override // com.vladsch.flexmark.util.collection.CollectionHost
        public void clearing() {
            ClassifyingBlockTracker.this.nodeClassifier.clear();
        }

        @Override // com.vladsch.flexmark.util.collection.CollectionHost
        public int getIteratorModificationCount() {
            return ClassifyingBlockTracker.this.allBlockParsersMap.getModificationCount();
        }

        @Override // com.vladsch.flexmark.util.collection.CollectionHost
        public boolean skipHostUpdate() {
            return false;
        }

        @Override // com.vladsch.flexmark.util.collection.CollectionHost
        public void adding(int i, @Nullable Paired<BlockParser, Block> paired, @Nullable Object obj) {
            Block second = paired.getSecond();
            if (second != null) {
                ClassifyingBlockTracker.this.nodeClassifier.add(second);
            }
        }

        @Override // com.vladsch.flexmark.util.collection.CollectionHost
        public Object removing(int i, @Nullable Paired<BlockParser, Block> paired) {
            Block second = paired.getSecond();
            if (second != null) {
                ClassifyingBlockTracker.this.nodeClassifier.remove(second);
            }
            return paired;
        }
    });

    private void addBlocks(ReversiblePeekingIterable<Node> reversiblePeekingIterable) {
        ReversiblePeekingIterator<Node> it = reversiblePeekingIterable.iterator();
        while (it.hasNext()) {
            Node next = it.next();
            if (next instanceof Block) {
                this.allBlockParsersMap.putValueKey((Block) next, null);
            }
        }
    }

    private void removeBlocks(ReversiblePeekingIterable<Node> reversiblePeekingIterable) {
        ReversiblePeekingIterator<Node> it = reversiblePeekingIterable.iterator();
        while (it.hasNext()) {
            Node next = it.next();
            if (next instanceof Block) {
                this.allBlockParsersMap.removeValue(next);
            }
        }
    }

    private void validateLinked(Node node) {
        if (node.getNext() == null && node.getParent() == null) {
            throw new IllegalStateException("Added block " + node + " is not linked into the AST");
        }
    }

    private void validateUnlinked(Node node) {
        if (node.getNext() == null && node.getParent() == null) {
            return;
        }
        throw new IllegalStateException("Removed block " + node + " is still linked in the AST");
    }

    public OrderedSet<BlockParser> allBlockParsers() {
        return this.allBlockParsersMap.keySet();
    }

    public OrderedSet<Block> allBlocks() {
        return this.allBlockParsersMap.valueSet();
    }

    @Override // com.vladsch.flexmark.util.ast.BlockTracker
    public void blockAdded(@NotNull Block block) {
        validateLinked(block);
        this.allBlockParsersMap.putValueKey(block, null);
    }

    @Override // com.vladsch.flexmark.util.ast.BlockTracker
    public void blockAddedWithChildren(@NotNull Block block) {
        validateLinked(block);
        this.allBlockParsersMap.putValueKey(block, null);
        addBlocks(block.getChildren());
    }

    @Override // com.vladsch.flexmark.util.ast.BlockTracker
    public void blockAddedWithDescendants(@NotNull Block block) {
        validateLinked(block);
        this.allBlockParsersMap.putValueKey(block, null);
        addBlocks(block.getDescendants());
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParserTracker
    public void blockParserAdded(BlockParser blockParser) {
        this.allBlockParsersMap.putKeyValue(blockParser, blockParser.getBlock());
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParserTracker
    public void blockParserRemoved(BlockParser blockParser) {
        this.allBlockParsersMap.removeKey(blockParser);
    }

    @Override // com.vladsch.flexmark.util.ast.BlockTracker
    public void blockRemoved(@NotNull Block block) {
        validateUnlinked(block);
        this.allBlockParsersMap.removeValue(block);
    }

    @Override // com.vladsch.flexmark.util.ast.BlockTracker
    public void blockRemovedWithChildren(@NotNull Block block) {
        validateUnlinked(block);
        this.allBlockParsersMap.removeValue(block);
        removeBlocks(block.getChildren());
    }

    @Override // com.vladsch.flexmark.util.ast.BlockTracker
    public void blockRemovedWithDescendants(@NotNull Block block) {
        validateUnlinked(block);
        this.allBlockParsersMap.removeValue(block);
        removeBlocks(block.getDescendants());
    }

    public boolean containsKey(BlockParser blockParser) {
        return this.allBlockParsersMap.containsKey(blockParser);
    }

    public boolean containsValue(Block block) {
        return this.allBlockParsersMap.containsValue(block);
    }

    public BlockParser getKey(Block block) {
        return this.allBlockParsersMap.getValueKey(block);
    }

    public ClassificationBag<Class<?>, Node> getNodeClassifier() {
        return this.nodeClassifier;
    }

    public Block getValue(BlockParser blockParser) {
        return this.allBlockParsersMap.getKeyValue(blockParser);
    }
}
