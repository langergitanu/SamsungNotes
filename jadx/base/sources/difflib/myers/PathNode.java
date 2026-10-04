package difflib.myers;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class PathNode {

    /* JADX INFO: renamed from: i */
    public final int f8548i;

    /* JADX INFO: renamed from: j */
    public final int f8549j;
    public final PathNode prev;

    public PathNode(int i, int i2, PathNode pathNode) {
        this.f8548i = i;
        this.f8549j = i2;
        this.prev = pathNode;
    }

    public boolean isBootstrap() {
        return this.f8548i < 0 || this.f8549j < 0;
    }

    public abstract boolean isSnake();

    public final PathNode previousSnake() {
        PathNode pathNode;
        if (isBootstrap()) {
            return null;
        }
        return (isSnake() || (pathNode = this.prev) == null) ? this : pathNode.previousSnake();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[");
        for (PathNode pathNode = this; pathNode != null; pathNode = pathNode.prev) {
            stringBuffer.append("(");
            stringBuffer.append(Integer.toString(pathNode.f8548i));
            stringBuffer.append(",");
            stringBuffer.append(Integer.toString(pathNode.f8549j));
            stringBuffer.append(")");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
