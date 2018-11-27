package containersearch.jaked.containersearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ContainerSearchFragment extends Fragment {

    private static final String CONTAINER_NUMBER = "CONTAINER_NUMBER";
    private boolean mTrackAnyway = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_container_search,container,false);
        final Button btSubmit = v.findViewById(R.id.btSubmit);
        final EditText etContainerNumber = v.findViewById(R.id.etContainerNumber);
        final TextView tvInvalidContainerPrompt = v.findViewById(R.id.tvInvalidContainerPrompt);


        etContainerNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mTrackAnyway = false;
                tvInvalidContainerPrompt.setVisibility(View.INVISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ContainerNumber containerNumber = new ContainerNumber(etContainerNumber.getText().toString());
                // Only search if the container number is valid, or if the user has been notified
                // That their container number is invalid
                if(containerNumber.isValid() || mTrackAnyway ){
                    mTrackAnyway = false;
                    tvInvalidContainerPrompt.setVisibility(View.INVISIBLE);
                    DisplaySearchOptions(containerNumber.getContainerNumber());
                }
                else{
                    tvInvalidContainerPrompt.setVisibility(View.VISIBLE);
                    mTrackAnyway = true;
                }
            }
        });

        return v;
    }

    // Add Fragment containing list of container services
    private void DisplaySearchOptions(String containerNumber){
        Intent intent = new Intent(getActivity(), SearchChoiceActivity.class);
        intent.putExtra(CONTAINER_NUMBER, containerNumber);
        startActivity(intent);

    }
}
