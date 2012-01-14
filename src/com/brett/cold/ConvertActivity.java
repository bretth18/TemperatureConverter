package com.brett.cold;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

public class ConvertActivity extends FragmentActivity {
		
	private Menu mMenu;
	private InfoFragment mInfoFrag;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_base);		
		addFragment(new TempFragment(), false);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		mMenu = menu;
	    return super.onCreateOptionsMenu(menu);
	}
	
	public void addFragment(Fragment frag, boolean backstack) {
		FragmentManager mFragmentManager = getSupportFragmentManager();
		FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
		
		if(backstack) {
			mFragmentTransaction.addToBackStack(null);
		}
		
		mFragmentTransaction.add(R.id.base, frag);			
		mFragmentTransaction.commit();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	        	getActionBar().setDisplayHomeAsUpEnabled(false);
	        	getActionBar().setHomeButtonEnabled(false);
	    		FragmentManager mFragmentManager = getSupportFragmentManager();
	    		FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
	    		mFragmentTransaction.remove(mInfoFrag);
	    		mFragmentTransaction.commit();
	        	return true;
	            
	        case R.id.menu_info:
	        	mInfoFrag = new InfoFragment();
	        	addFragment(mInfoFrag, true);
	        	return true;
	        	
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	@Override
	public void onResume() {
		super.onResume();
		if(mMenu != null) {
			(mMenu.findItem(R.id.menu_info)).setVisible(true);			
		}
	}
}