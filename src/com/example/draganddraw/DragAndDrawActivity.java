package com.example.draganddraw;

import android.support.v4.app.Fragment;

public class DragAndDrawActivity extends SingleFragmentActtivity {

	@Override
	protected Fragment createFragment() {
		return new DragAndDrawFragment();
	}

}
