package io.netty.handler.timeout;

import androidx.compose.foundation.layout.AbstractC1038a;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class IdleStateEvent {
    public static final IdleStateEvent ALL_IDLE_STATE_EVENT;
    public static final IdleStateEvent FIRST_ALL_IDLE_STATE_EVENT;
    public static final IdleStateEvent FIRST_READER_IDLE_STATE_EVENT;
    public static final IdleStateEvent FIRST_WRITER_IDLE_STATE_EVENT;
    public static final IdleStateEvent READER_IDLE_STATE_EVENT;
    public static final IdleStateEvent WRITER_IDLE_STATE_EVENT;
    private final boolean first;
    private final IdleState state;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class DefaultIdleStateEvent extends IdleStateEvent {
        private final String representation;

        public DefaultIdleStateEvent(IdleState idleState, boolean z) {
            super(idleState, z);
            StringBuilder sb = new StringBuilder("IdleStateEvent(");
            sb.append(idleState);
            this.representation = AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, z ? ", first" : "", sb);
        }

        @Override // io.netty.handler.timeout.IdleStateEvent
        public String toString() {
            return this.representation;
        }
    }

    static {
        IdleState idleState = IdleState.READER_IDLE;
        FIRST_READER_IDLE_STATE_EVENT = new DefaultIdleStateEvent(idleState, true);
        READER_IDLE_STATE_EVENT = new DefaultIdleStateEvent(idleState, false);
        IdleState idleState2 = IdleState.WRITER_IDLE;
        FIRST_WRITER_IDLE_STATE_EVENT = new DefaultIdleStateEvent(idleState2, true);
        WRITER_IDLE_STATE_EVENT = new DefaultIdleStateEvent(idleState2, false);
        IdleState idleState3 = IdleState.ALL_IDLE;
        FIRST_ALL_IDLE_STATE_EVENT = new DefaultIdleStateEvent(idleState3, true);
        ALL_IDLE_STATE_EVENT = new DefaultIdleStateEvent(idleState3, false);
    }

    public IdleStateEvent(IdleState idleState, boolean z) {
        this.state = (IdleState) ObjectUtil.checkNotNull(idleState, "state");
        this.first = z;
    }

    public boolean isFirst() {
        return this.first;
    }

    public IdleState state() {
        return this.state;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        sb.append(PropertyUtils.MAPPED_DELIM);
        sb.append(this.state);
        return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.first ? ", first" : "", sb);
    }
}
