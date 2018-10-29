package containersearch.jaked.containersearch;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import containersearch.jaked.containersearch.database.RecordSaver;

public class EraseHistoryDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.clear_history_prompt)
                .setPositiveButton(R.string.clear_history_erase_all, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        RecordSaver recordSaver = new RecordSaver();
                        recordSaver.clearDatabase(getContext());
                    }
                })
                .setNegativeButton(R.string.clear_history_cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
