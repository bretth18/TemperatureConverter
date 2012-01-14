package com.brett.cold;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

public class InfoFragment extends Fragment {

	private View mView;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	super.onCreateView(inflater, container, savedInstanceState);
    	super.setHasOptionsMenu(true);
    	
    	mView = inflater.inflate(R.layout.info, null, false);
    	return mView;
    }
    
    @Override
    public void onActivityCreated(Bundle bundle) {
    	super.onActivityCreated(bundle);
    	super.getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
    }
    
    @Override
    public void onCreateOptionsMenu (Menu menu, MenuInflater inflater) {
    	menu.findItem(R.id.menu_info).setVisible(false);
    	super.onCreateOptionsMenu(menu, inflater);
    }
	
}
