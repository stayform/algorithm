package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * AuThor：StAY_
 * Create:2020/4/7
 */
public class MyLock implements Lock {
    Helper helper = new Helper();
    @Override
    public void lock() {
        helper.acquire(1);//acquire中调用了tryAcquire(),方法里的逻辑是如果tryAcquire返回false，则将线程加入到等待队列里
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        helper.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return helper.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return helper.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        helper.release(1);
    }

    @Override
    public Condition newCondition() {
        return helper.newCondition();
    }

    private class Helper extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            int state =getState();//对象是否被上锁的标志
            if(state==0){
                if(compareAndSetState(0,arg)){//CAS对state值进行替换
                    setExclusiveOwnerThread(Thread.currentThread());//替换成功，则锁归当前线程所有
                    return true;
                }
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if(Thread.currentThread()!=getExclusiveOwnerThread()){
                throw new RuntimeException();
            }
            int state =getState()-arg;
            setState(state);
            if(state==0){
                setExclusiveOwnerThread(null);
                return true;
            }
            return false;
        }

        Condition newCondition(){//Condition是AQS的内部类，用来唤醒当前线程的下一个节点对应的线程 await()/signal()
            return new ConditionObject();
        }
    }
}
