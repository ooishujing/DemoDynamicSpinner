package sg.edu.rp.c346.demodynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner spn1=findViewById(R.id.spinner1);
        final Spinner spn2=findViewById(R.id.spinner2);
        Button btnUpd=findViewById(R.id.buttonUpdate);
        //Initialise the ArrayList
        final ArrayList<String> alNumbers=new ArrayList<>();
        alNumbers.add("2");
        alNumbers.add("4");
        alNumbers.add("6");

        //Create an ArrayAdapter using the default Spinner layout and the ArrayList
        final ArrayAdapter<String>aaNumbers=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,alNumbers);
        //Bind the ArrayAdapter to the Spinner
         //spn2.setAdapter(aaNumbers);

         //Get the string-array and store as an Array
        //String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
         //Convert Array to List and add to the ArrayList
        //alNumbers.addAll(Arrays.asList(strNumbers));

        //Implement the button onClick() method
        //to load the correct number list when it is clicked
        /*
        btnUpd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();
                //Apply either of the two approaches
                //to load the correct number lis based on the selection of spn1
                if(pos==0){
                    //Get the string-array and store as an Array
                    String[] evenNumbers = getResources().getStringArray(R.array.even_numbers);
                    //Convert Array to List and add to the ArrayList
                    alNumbers.addAll(Arrays.asList(evenNumbers));
                    spn2.setAdapter(aaNumbers);
                }else if(pos==1){
                    //Get the string-array and store as an Array
                    String[] oddNumbers = getResources().getStringArray(R.array.odd_numbers);
                    //Convert Array to List and add to the ArrayList
                    alNumbers.addAll(Arrays.asList(oddNumbers));
                    spn2.setAdapter(aaNumbers);
                }
            }
        });
        */
        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        alNumbers.clear();
                        String[] evenNumbers = getResources().getStringArray(R.array.even_numbers);
                        alNumbers.addAll(Arrays.asList(evenNumbers));
                        spn2.setSelection(2);
                        break;
                    case 1:
                        alNumbers.clear();
                        String[] oddNumbers = getResources().getStringArray(R.array.odd_numbers);
                        alNumbers.addAll(Arrays.asList(oddNumbers));
                        spn2.setSelection(1);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
