package org.hg.shiro.configuration.session;


import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author hg
 * @Date 2019/4/8 11:51
 * @Desc
 * @Version 1.0
 **/
public class ShiroSessionListener implements SessionListener {
    private static final AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void onStart(Session session) {
        counter.incrementAndGet();
    }

    @Override
    public void onStop(Session session) {
        counter.decrementAndGet();
    }

    @Override
    public void onExpiration(Session session) {
        counter.decrementAndGet();
    }

    public static int getCount() {
        return counter.get();
    }
}
