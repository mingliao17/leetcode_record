package xyz.mingliao.else_java_basic.juc.lock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {

    private double x,y;
    private final StampedLock sl = new StampedLock();

    void move(double deltaX,double deltaY){
        long stamp = sl.writeLock();//使用写锁-独占操作
        try{
            x += deltaX;
            y += deltaY;
        }finally {
            sl.unlockWrite(stamp);
        }
    }

    double distanceFormOrigin(){
        long stamp = sl.tryOptimisticRead();
        double currentX = x,currentY = y;
        if(!sl.validate(stamp)){
            stamp = sl.readLock();
            try{
                currentX = x;
                currentY = y;
            }finally {
                sl.unlockWrite(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}
