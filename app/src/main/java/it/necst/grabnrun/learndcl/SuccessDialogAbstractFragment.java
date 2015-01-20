package it.necst.grabnrun.learndcl;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public abstract class SuccessDialogAbstractFragment extends DialogFragment {

	@Override
    public abstract Dialog onCreateDialog(Bundle savedInstanceState);
	
}
