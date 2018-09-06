package containersearch.jaked.containersearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ContainerSearchFragment extends Fragment {

    private static final String CONTAINER_NUMBER = "CONTAINER_NUMBER";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_container_search,container,false);
        final Button btSubmit = v.findViewById(R.id.btSubmit);
        final EditText etContainerNumber = v.findViewById(R.id.etContainerNumber);


        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ContainerNumber containerNumber = new ContainerNumber(etContainerNumber.getText().toString());
                if(containerNumber.isValid()){
                    DisplaySearchOptions(containerNumber.getContainerNumber());
                }
                else{
                    System.out.println("INVALD CONTAINER NUMBER");
                }

            }
        });

        return v;
    }

    private void DisplaySearchOptions(String containerNumber){

        Intent intent = new Intent(getActivity(), SearchChoiceActivity.class);
        intent.putExtra(CONTAINER_NUMBER, containerNumber);
        startActivity(intent);

    }
}
