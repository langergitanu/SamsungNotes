package difflib.myers;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class DiffNode extends PathNode {
    public DiffNode(int i, int i2, PathNode pathNode) {
        super(i, i2, pathNode == null ? null : pathNode.previousSnake());
    }

    @Override // difflib.myers.PathNode
    public boolean isSnake() {
        return false;
    }
}
