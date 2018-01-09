package com.demo.test.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bob.bop
 * @version $Id:MyActivityManager.java 上午10:49:27 bob.bop$
 * @created on 2015-8-1
 */
public class MyActivityManager {
    private List<Activity> activityList = new ArrayList<Activity>();
    private static MyActivityManager instance;

    private MyActivityManager() {

    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public static MyActivityManager getInstance() {
        if (null == instance) {
            instance = new MyActivityManager();
        }
        return instance;

    }

    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public void removeActivity(Activity activity) {
        for (int i = activityList.size() - 1; i >= 0; i--) {
            if (activity.equals(activityList.get(i))) {
                activityList.remove(i);
                break;
            }
        }
    }

    public void exit() {
        for (Activity activity : activityList) {
            if (activity != null) {
                activity.finish();
            }
        }
    }

}
