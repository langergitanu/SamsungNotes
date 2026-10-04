package difflib.myers;

import difflib.ChangeDelta;
import difflib.Chunk;
import difflib.DeleteDelta;
import difflib.DiffAlgorithm;
import difflib.InsertDelta;
import difflib.Patch;
import java.lang.reflect.Array;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class MyersDiff implements DiffAlgorithm {
    public static PathNode buildPath(Object[] objArr, Object[] objArr2) throws DifferentiationFailedException {
        PathNode pathNode;
        int i;
        PathNode pathNode2;
        if (objArr == null) {
            throw new IllegalArgumentException("original sequence is null");
        }
        if (objArr2 == null) {
            throw new IllegalArgumentException("revised sequence is null");
        }
        int length = objArr.length;
        int length2 = objArr2.length;
        int i2 = length + length2 + 1;
        int i4 = (i2 * 2) + 1;
        int i5 = i4 / 2;
        PathNode[] pathNodeArr = new PathNode[i4];
        PathNode pathNode3 = null;
        pathNodeArr[i5 + 1] = new Snake(0, -1, null);
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = -i6;
            int i8 = i7;
            while (i8 <= i6) {
                int i9 = i5 + i8;
                int i10 = i9 + 1;
                int i11 = i9 - 1;
                if (i8 == i7 || (i8 != i6 && pathNodeArr[i11].f8548i < pathNodeArr[i10].f8548i)) {
                    pathNode = pathNodeArr[i10];
                    i = pathNode.f8548i;
                } else {
                    pathNode = pathNodeArr[i11];
                    i = pathNode.f8548i + 1;
                }
                pathNodeArr[i11] = pathNode3;
                int i12 = i - i8;
                PathNode diffNode = new DiffNode(i, i12, pathNode);
                while (i < length && i12 < length2) {
                    pathNode2 = pathNode3;
                    if (!objArr[i].equals(objArr2[i12])) {
                        break;
                    }
                    i++;
                    i12++;
                    pathNode3 = pathNode2;
                }
                pathNode2 = pathNode3;
                if (i > diffNode.f8548i) {
                    diffNode = new Snake(i, i12, diffNode);
                }
                pathNodeArr[i9] = diffNode;
                if (i >= length && i12 >= length2) {
                    return diffNode;
                }
                i8 += 2;
                pathNode3 = pathNode2;
            }
            pathNodeArr[(i5 + i6) - 1] = pathNode3;
        }
        throw new DifferentiationFailedException("could not find a diff path");
    }

    public static Patch buildRevision(PathNode pathNode, Object[] objArr, Object[] objArr2) {
        if (pathNode == null) {
            throw new IllegalArgumentException("path is null");
        }
        if (objArr == null) {
            throw new IllegalArgumentException("original sequence is null");
        }
        if (objArr2 == null) {
            throw new IllegalArgumentException("revised sequence is null");
        }
        Patch patch = new Patch();
        if (pathNode.isSnake()) {
            pathNode = pathNode.prev;
        }
        while (pathNode != null) {
            PathNode pathNode2 = pathNode.prev;
            if (pathNode2 == null || pathNode2.f8549j < 0) {
                break;
            }
            if (pathNode.isSnake()) {
                throw new IllegalStateException("bad diffpath: found snake when looking for diff");
            }
            int i = pathNode.f8548i;
            int i2 = pathNode.f8549j;
            pathNode = pathNode.prev;
            int i4 = pathNode.f8548i;
            int i5 = pathNode.f8549j;
            Chunk chunk = new Chunk(i4, copyOfRange(objArr, i4, i));
            Chunk chunk2 = new Chunk(i5, copyOfRange(objArr2, i5, i2));
            patch.addDelta((chunk.size() != 0 || chunk2.size() == 0) ? (chunk.size() <= 0 || chunk2.size() != 0) ? new ChangeDelta(chunk, chunk2) : new DeleteDelta(chunk, chunk2) : new InsertDelta(chunk, chunk2));
            if (pathNode.isSnake()) {
                pathNode = pathNode.prev;
            }
        }
        return patch;
    }

    public static <T> T[] copyOfRange(T[] tArr, int i, int i2) {
        return (T[]) copyOfRange(tArr, i, i2, tArr.getClass());
    }

    @Override // difflib.DiffAlgorithm
    public Patch diff(List<?> list, List<?> list2) {
        return diff(list.toArray(), list2.toArray());
    }

    public static <T, U> T[] copyOfRange(U[] uArr, int i, int i2, Class<? extends T[]> cls) {
        int i4 = i2 - i;
        if (i4 >= 0) {
            T[] tArr = cls == Object[].class ? (T[]) new Object[i4] : (T[]) ((Object[]) Array.newInstance(cls.getComponentType(), i4));
            System.arraycopy(uArr, i, tArr, 0, Math.min(uArr.length - i, i4));
            return tArr;
        }
        throw new IllegalArgumentException(i + " > " + i2);
    }

    @Override // difflib.DiffAlgorithm
    public Patch diff(Object[] objArr, Object[] objArr2) {
        try {
            return buildRevision(buildPath(objArr, objArr2), objArr, objArr2);
        } catch (DifferentiationFailedException e) {
            e.printStackTrace();
            return new Patch();
        }
    }
}
