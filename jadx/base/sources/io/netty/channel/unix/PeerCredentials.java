package io.netty.channel.unix;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import io.netty.util.internal.EmptyArrays;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class PeerCredentials {
    private final int[] gids;
    private final int pid;
    private final int uid;

    public PeerCredentials(int i, int i2, int... iArr) {
        this.pid = i;
        this.uid = i2;
        this.gids = iArr == null ? EmptyArrays.EMPTY_INTS : iArr;
    }

    public int[] gids() {
        return (int[]) this.gids.clone();
    }

    public int pid() {
        return this.pid;
    }

    public String toString() {
        StringBuilder sbM1627q = AbstractC2322a.m1627q(128, "UserCredentials[pid=");
        sbM1627q.append(this.pid);
        sbM1627q.append("; uid=");
        sbM1627q.append(this.uid);
        sbM1627q.append("; gids=[");
        int[] iArr = this.gids;
        if (iArr.length > 0) {
            sbM1627q.append(iArr[0]);
            for (int i = 1; i < this.gids.length; i++) {
                sbM1627q.append(SQLKeyword.COMMA);
                sbM1627q.append(this.gids[i]);
            }
        }
        sbM1627q.append(PropertyUtils.INDEXED_DELIM2);
        return sbM1627q.toString();
    }

    public int uid() {
        return this.uid;
    }
}
