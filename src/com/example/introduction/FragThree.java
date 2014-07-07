package com.example.introduction;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class FragThree extends Fragment {
	Button btRemoveFrag;
	FragThreeClicksListener fragThreeClicksListener;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.frag_three, container, false);
		btRemoveFrag = (Button) view.findViewById(R.id.button_remove_frag);
		btRemoveFrag.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				fragThreeClicksListener.removeFrag();
			}
		});
		return view;
	}

	@Override
	public View getView() {
		// TODO Auto-generated method stub
		return super.getView();
	}

	//Handle view clicks on the Fragments implementing Activity
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		try {
			fragThreeClicksListener = (FragThreeClicksListener) getActivity();
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		super.onAttach(activity);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	//Interface to handle the fragment views clicks
	interface FragThreeClicksListener {
		public void removeFrag();
	}
}
