package org.apache.commons.lang3.concurrent;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class EventCountCircuitBreaker extends AbstractCircuitBreaker<Integer> {
    private static final Map<AbstractCircuitBreaker.State, AbstractStateStrategy> STRATEGY_MAP = createStrategyMap();
    private final AtomicReference<CheckIntervalData> checkIntervalData;
    private final long closingInterval;
    private final int closingThreshold;
    private final long openingInterval;
    private final int openingThreshold;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class AbstractStateStrategy {
        private AbstractStateStrategy() {
        }

        public abstract long fetchCheckInterval(EventCountCircuitBreaker eventCountCircuitBreaker);

        public boolean isCheckIntervalFinished(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, long j) {
            return j - checkIntervalData.getCheckIntervalStart() > fetchCheckInterval(eventCountCircuitBreaker);
        }

        public abstract boolean isStateTransition(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CheckIntervalData {
        private final long checkIntervalStart;
        private final int eventCount;

        public CheckIntervalData(int i, long j) {
            this.eventCount = i;
            this.checkIntervalStart = j;
        }

        public long getCheckIntervalStart() {
            return this.checkIntervalStart;
        }

        public int getEventCount() {
            return this.eventCount;
        }

        public CheckIntervalData increment(int i) {
            return i == 0 ? this : new CheckIntervalData(getEventCount() + i, getCheckIntervalStart());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class StateStrategyClosed extends AbstractStateStrategy {
        private StateStrategyClosed() {
            super();
        }

        @Override // org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.AbstractStateStrategy
        public long fetchCheckInterval(EventCountCircuitBreaker eventCountCircuitBreaker) {
            return eventCountCircuitBreaker.getOpeningInterval();
        }

        @Override // org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.AbstractStateStrategy
        public boolean isStateTransition(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2) {
            return checkIntervalData2.getEventCount() > eventCountCircuitBreaker.getOpeningThreshold();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class StateStrategyOpen extends AbstractStateStrategy {
        private StateStrategyOpen() {
            super();
        }

        @Override // org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.AbstractStateStrategy
        public long fetchCheckInterval(EventCountCircuitBreaker eventCountCircuitBreaker) {
            return eventCountCircuitBreaker.getClosingInterval();
        }

        @Override // org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.AbstractStateStrategy
        public boolean isStateTransition(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2) {
            return checkIntervalData2.getCheckIntervalStart() != checkIntervalData.getCheckIntervalStart() && checkIntervalData.getEventCount() < eventCountCircuitBreaker.getClosingThreshold();
        }
    }

    public EventCountCircuitBreaker(int i, long j, TimeUnit timeUnit) {
        this(i, j, timeUnit, i);
    }

    private void changeStateAndStartNewCheckInterval(AbstractCircuitBreaker.State state) {
        changeState(state);
        this.checkIntervalData.set(new CheckIntervalData(0, nanoTime()));
    }

    private static Map<AbstractCircuitBreaker.State, AbstractStateStrategy> createStrategyMap() {
        EnumMap enumMap = new EnumMap(AbstractCircuitBreaker.State.class);
        enumMap.put(AbstractCircuitBreaker.State.CLOSED, new StateStrategyClosed());
        enumMap.put(AbstractCircuitBreaker.State.OPEN, new StateStrategyOpen());
        return enumMap;
    }

    private CheckIntervalData nextCheckIntervalData(int i, CheckIntervalData checkIntervalData, AbstractCircuitBreaker.State state, long j) {
        return stateStrategy(state).isCheckIntervalFinished(this, checkIntervalData, j) ? new CheckIntervalData(i, j) : checkIntervalData.increment(i);
    }

    private boolean performStateCheck(int i) {
        AbstractCircuitBreaker.State stateOppositeState;
        CheckIntervalData checkIntervalData;
        CheckIntervalData checkIntervalDataNextCheckIntervalData;
        while (true) {
            long jNanoTime = nanoTime();
            stateOppositeState = this.state.get();
            checkIntervalData = this.checkIntervalData.get();
            int i2 = i;
            checkIntervalDataNextCheckIntervalData = nextCheckIntervalData(i2, checkIntervalData, stateOppositeState, jNanoTime);
            if (updateCheckIntervalData(checkIntervalData, checkIntervalDataNextCheckIntervalData)) {
                break;
            }
            i = i2;
        }
        if (stateStrategy(stateOppositeState).isStateTransition(this, checkIntervalData, checkIntervalDataNextCheckIntervalData)) {
            stateOppositeState = stateOppositeState.oppositeState();
            changeStateAndStartNewCheckInterval(stateOppositeState);
        }
        return !AbstractCircuitBreaker.isOpen(stateOppositeState);
    }

    private static AbstractStateStrategy stateStrategy(AbstractCircuitBreaker.State state) {
        return STRATEGY_MAP.get(state);
    }

    private boolean updateCheckIntervalData(CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2) {
        if (checkIntervalData == checkIntervalData2) {
            return true;
        }
        AtomicReference<CheckIntervalData> atomicReference = this.checkIntervalData;
        while (!atomicReference.compareAndSet(checkIntervalData, checkIntervalData2)) {
            if (atomicReference.get() != checkIntervalData) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public boolean checkState() {
        return performStateCheck(0);
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public void close() {
        super.close();
        this.checkIntervalData.set(new CheckIntervalData(0, nanoTime()));
    }

    public long getClosingInterval() {
        return this.closingInterval;
    }

    public int getClosingThreshold() {
        return this.closingThreshold;
    }

    public long getOpeningInterval() {
        return this.openingInterval;
    }

    public int getOpeningThreshold() {
        return this.openingThreshold;
    }

    public long nanoTime() {
        return System.nanoTime();
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public void open() {
        super.open();
        this.checkIntervalData.set(new CheckIntervalData(0, nanoTime()));
    }

    public EventCountCircuitBreaker(int i, long j, TimeUnit timeUnit, int i2) {
        this(i, j, timeUnit, i2, j, timeUnit);
    }

    public boolean incrementAndCheckState() {
        return incrementAndCheckState((Integer) 1);
    }

    public EventCountCircuitBreaker(int i, long j, TimeUnit timeUnit, int i2, long j2, TimeUnit timeUnit2) {
        this.checkIntervalData = new AtomicReference<>(new CheckIntervalData(0, 0L));
        this.openingThreshold = i;
        this.openingInterval = timeUnit.toNanos(j);
        this.closingThreshold = i2;
        this.closingInterval = timeUnit2.toNanos(j2);
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public boolean incrementAndCheckState(Integer num) {
        return performStateCheck(num.intValue());
    }
}
