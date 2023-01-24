package com.sarthi.myapplication.abstracts;

import android.app.Activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class FragmentHandler {
    private static FragmentHandler fragmentHandler;
    private static FragmentManager fragmentManager;

    /**
     * Class constructor
     */
    private FragmentHandler() {
    }

    /**
     * Method to get the class object
     *
     * @return - active object of the class
     */
    public static FragmentHandler getInstance() {
        if (fragmentHandler == null) {
            fragmentHandler = new FragmentHandler();
        }
        if (fragmentManager == null) {
            fragmentManager = getFragmentManager();
        }
        return fragmentHandler;
    }

    private static FragmentManager getFragmentManager() {
        return fragmentManager;
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        FragmentHandler.fragmentManager = fragmentManager;
    }


    public void addFragmentToBackStack(Activity activity, Fragment fragment, String tag, int containerID) {
        fragmentManager.beginTransaction().setCustomAnimations(0, 0, 0, 0)
                .add(containerID, fragment, tag).addToBackStack(tag).commitAllowingStateLoss();
    }

    public void addFragment(Fragment fragment, int containerID) {
        fragmentManager.beginTransaction().setCustomAnimations(0, 0, 0, 0)
                .add(containerID, fragment).commitAllowingStateLoss();
    }


    public void replaceFragment(Fragment fragment, int containerID) {
        fragmentManager.beginTransaction()
                .replace(containerID, fragment).commitAllowingStateLoss();
    }


    /***
     * finding Fragment by ID
     * @param
     * @return
     * */
    public Fragment findFragmentId(int id) {
        return fragmentManager.findFragmentById(id);
    }

    /***
     * finding Fragment by Tag
     * @param tag fragment tag
     * @return instanse
     */
    public Fragment findFragmentByTag(String tag) {
        return fragmentManager.findFragmentByTag(tag);
    }

    public Fragment getCurrentFragment(int containerID) {
        return fragmentManager.findFragmentById(containerID);
    }

    public boolean isStackEmpty() {
        return fragmentManager.getBackStackEntryCount() == 0;
    }

    public int getBackStackEntryCount() {
        return fragmentManager.getBackStackEntryCount();
    }

    public FragmentManager getCurrentFragmentManager() {
        return fragmentManager;
    }
}
