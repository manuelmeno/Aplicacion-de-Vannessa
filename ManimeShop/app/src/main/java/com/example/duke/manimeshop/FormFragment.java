package com.example.duke.manimeshop;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FormFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FormFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FormFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    //variables de edittext
    /*
    private EditText usuario;
    private EditText contrasena;
    private Button iniciarsesion;
    */
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private MenuItem item;

    public FormFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FormFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FormFragment newInstance(String param1, String param2) {
        FormFragment fragment = new FormFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    EditText usuario;
    EditText contrasena;
    Button iniciarsesion,reg;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ///
        View v= inflater.inflate(R.layout.fragment_form, container, false);

        usuario=(EditText)v.findViewById(R.id.usuario);
        contrasena=(EditText) v.findViewById(R.id.contrasena);
        iniciarsesion=(Button) v.findViewById(R.id.iniciobutton);
        reg=(Button) v.findViewById(R.id.registrarse);
        iniciarsesion.setEnabled(false);
        usuario.addTextChangedListener(valores);
        contrasena.addTextChangedListener(valores);

        /////
        // Inflate the layout for this fragment
        iniciarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usuario.getText().toString().equals("admin")){
                    if(contrasena.getText().toString().equals("admin")){
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_main,new adminFragment()).commit();
                    }
                }
                else {



                    Intent intent = new Intent(getActivity(),MainActivity.class);
                    intent.putExtra("dato", usuario.getText().toString());
                    startActivity(intent);
                    Toast.makeText(getActivity(),"Inicio de Sesion Exitosa", Toast.LENGTH_SHORT).show();
                }

            }
        });


        //return inflater.inflate(R.layout.fragment_form, container, false);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_main,new registroFragment()).commit();


            }
        });





        return v;
    }
/*
    public void onClick(View v)
    {

        MenuItem item = (MenuItem) v.findViewById(R.id.action_settings);
        item.setTitle("juan");

    }
*/
/*

    public void inicio(View view) {

        MenuItem item = (MenuItem) view.findViewById(R.id.action_settings);
        item.setTitle("juan");


    }
*/
    /*
public boolean onCreateOptionsMenu(MenuItem menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    menu.setTitle("jjj");
    return true;
}
*/
    /*
    public boolean onCreateOption(MenuItem item)
    {
        return super.onCreateOption(item);
    }
    */

/*
    public void setItem(MenuItem item) {
        item.setTitle("hola");

    }
*/






    //Manera para que no utilice el boton mientras no pongas ningun valor
    private TextWatcher valores= new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String valor1=usuario.getText().toString().trim();
            String valor2=contrasena.getText().toString().trim();

            iniciarsesion.setEnabled(!valor1.isEmpty()&& !valor2.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    //////////////
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
