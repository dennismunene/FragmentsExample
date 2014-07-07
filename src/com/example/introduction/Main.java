package com.example.introduction;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;

import com.example.introduction.FragThree.FragThreeClicksListener;


public class Main extends FragmentActivity implements TabListener,
		OnPageChangeListener, FragThreeClicksListener {
	ViewPager viewPager;
	Adapter adapter;
	public static final String TAB_COUNT = "tabs";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setTabCount(3);
		initialise();

	}

	private void setTabCount(int i) {
		// TODO Auto-generated method stub
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(Main.this);
		Editor editor = prefs.edit();
		editor.putInt(TAB_COUNT, i);
		editor.commit();
	}

	private void initialise() {
		// TODO Auto-generated method stub
		viewPager = (ViewPager) findViewById(R.id.main_viewPager);
		adapter = new Adapter(getSupportFragmentManager());
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(this);

		// Add Tabs
		getActionBar().addTab(getActionBar().newTab().setTabListener(this));
		getActionBar().addTab(getActionBar().newTab().setTabListener(this));
		getActionBar().addTab(getActionBar().newTab().setTabListener(this));
		getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
	}

	// onTabReselected
	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

	// onTabSelected
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction transaction) {
		// TODO Auto-generated method stub
		// viewPager.setCurrentItem(tab.getPosition());
	}

	// onTabUnselected
	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

	// onPageScrollStateChanged
	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	// onPageScrolled
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	// onPageSelected
	@Override
	public void onPageSelected(int position) {
		// TODO Auto-generated method stub
		// getActionBar().setSelectedNavigationItem(position);
	}

	// Remove the last fragment - if users clicks the Begin button
	@Override
	public void removeFrag() {
		// TODO Auto-generated method stub

		viewPager.setCurrentItem(1);
		setTabCount(2);
		adapter.notifyDataSetChanged();
		viewPager.setAdapter(adapter);
		Log.i("Fragments", "Removing");
	}

	// Create a Inner Class to handle the PagerAdapter
	class Adapter extends FragmentStatePagerAdapter {

		// Constructor
		public Adapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub

		}

		@Override
		public Fragment getItem(int position) {
			// TODO Auto-generated method stub

			// Access the preferences to determine the number of tabs to
			// populate
			SharedPreferences prefs = PreferenceManager
					.getDefaultSharedPreferences(Main.this);
			int count = prefs.getInt(TAB_COUNT, 3);

			// Populate two tabs
			if (count == 2) {
				switch (position) {
				case 0:
					return new FragOne();

				case 1:
					return new FragTwo();
				}
			}

			// Populate 3 tabs
			if (count == 3) {
				switch (position) {
				case 0:
					return new FragOne();

				case 1:
					return new FragTwo();

				case 2:
					return new FragThree();

				}
			}

			return null;
		}

		// Get the number of tabs
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			SharedPreferences prefs = PreferenceManager
					.getDefaultSharedPreferences(Main.this);

			return prefs.getInt(TAB_COUNT, 3);
		}

		// Get Item Position
		@Override
		public int getItemPosition(Object object) {
			// TODO Auto-generated method stub
			return PagerAdapter.POSITION_NONE;
		}
	}

}
