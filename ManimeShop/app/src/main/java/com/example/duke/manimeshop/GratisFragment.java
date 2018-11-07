package com.example.duke.manimeshop;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GratisFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GratisFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GratisFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public GratisFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GratisFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GratisFragment newInstance(String param1, String param2) {
        GratisFragment fragment = new GratisFragment();
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

    String []animes={"One Piece","Shingeki no Kyojin","Black Clover"};
    String []onePieceEp={"One Piece - 841","One Piece - 842","One Piece - 843","One Piece - 844","One Piece - 845","One Piece - 846","One Piece - 847"};
    String []KyojinEp={"Shingeki No Kyojin - 1","Shingeki No Kyojin - 2","Shingeki No Kyojin - 3","Shingeki No Kyojin - 4","Shingeki No Kyojin - 5"};
    String []CloverEp={"Black Clover - 1","Black Clover - 2","Black Clover - 3"};
    ListView lis;
    Spinner spi;
    Button btn;
    ImageView imagen;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_gratis, container, false);
        View v =inflater.inflate(R.layout.fragment_gratis, container, false);
        lis=(ListView)v.findViewById(R.id.lista);
        spi=(Spinner)v.findViewById(R.id.gira);
        btn=(Button)v.findViewById(R.id.btn);
        imagen=(ImageView)v.findViewById(R.id.imagen);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.spinner_item_gratis, animes);
        // ArrayAdapter<String> adapterone = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, onePieceEp);
        // ArrayAdapter<String> adapterkyojin = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, KyojinEp);
        // ArrayAdapter<String> adapterclover = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, CloverEp);

        spi.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String select=spi.getSelectedItem().toString();
                if(select.equals("One Piece")){
                    imagen.setImageResource(R.drawable.piece);
                    ArrayAdapter<String> adapterone = new ArrayAdapter<String>(getActivity(),R.layout.list_item_gratis, onePieceEp);
                    lis.setAdapter(adapterone);
                    lis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                            if(i==0){
                                Intent b = new Intent(Intent.ACTION_VIEW);
                                String url = "https://www.animeyt.tv/descargar/29253";
                                b.setData(Uri.parse(url));
                                startActivity(b);
                            }
                            else if(i==1){
                                Intent b = new Intent(Intent.ACTION_VIEW);
                                String url = "https://www.animeyt.tv/descargar/29313";
                                b.setData(Uri.parse(url));
                                startActivity(b);
                            }
                            else if(i==2){
                                Intent b = new Intent(Intent.ACTION_VIEW);
                                String url = "https://www.animeyt.tv/descargar/29383";
                                b.setData(Uri.parse(url));
                                startActivity(b);
                            }
                            else if(i==3){
                                Intent b = new Intent(Intent.ACTION_VIEW);
                                String url = "https://www.animeyt.tv/ver/one-piece-844-sub-espanol";
                                b.setData(Uri.parse(url));
                                startActivity(b);
                            }
                            else if(i==4){
                                Intent b = new Intent(Intent.ACTION_VIEW);
                                String url = "https://www.animeyt.tv/descargar/29514";
                                b.setData(Uri.parse(url));
                                startActivity(b);
                            }
                            else if(i==5){
                                Intent b = new Intent(Intent.ACTION_VIEW);
                                String url = "https://www.animeyt.tv/descargar/29583";
                                b.setData(Uri.parse(url));
                                startActivity(b);
                            }
                            else if(i==5){
                                Intent b = new Intent(Intent.ACTION_VIEW);
                                String url = "https://www.animeyt.tv/descargar/29647";
                                b.setData(Uri.parse(url));
                                startActivity(b);
                            }
                        }
                    });

                }
                if(select.equals("Shingeki no Kyojin")){
                    imagen.setImageResource(R.drawable.a);
                    ArrayAdapter<String> adapterone = new ArrayAdapter<String>(getActivity(),R.layout.list_item_gratis, KyojinEp);
                    lis.setAdapter(adapterone);
                    lis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                            if(i==0){
                                Intent b = new Intent(Intent.ACTION_VIEW);
                                String url = "https://www.animeyt.tv/descargar/6044";
                                b.setData(Uri.parse(url));
                                startActivity(b);
                            }
                            else if(i==1){
                                Intent b = new Intent(Intent.ACTION_VIEW);
                                String url = "https://www.animeyt.tv/descargar/6046";
                                b.setData(Uri.parse(url));
                                startActivity(b);
                            }
                            else if(i==2){
                                Intent b = new Intent(Intent.ACTION_VIEW);
                                String url = "https://www.animeyt.tv/descargar/6047";
                                b.setData(Uri.parse(url));
                                startActivity(b);
                            }
                            else if(i==3){
                                Intent b = new Intent(Intent.ACTION_VIEW);
                                String url = "https://www.animeyt.tv/descargar/6049";
                                b.setData(Uri.parse(url));
                                startActivity(b);
                            }
                            else if(i==4){
                                Intent b = new Intent(Intent.ACTION_VIEW);
                                String url = "https://www.animeyt.tv/descargar/6051";
                                b.setData(Uri.parse(url));
                                startActivity(b);
                            }
                        }
                    });

                }
                if(select.equals("Black Clover")){
                    imagen.setImageResource(R.drawable.thum);
                    ArrayAdapter<String> adapterone = new ArrayAdapter<String>(getActivity(),R.layout.list_item_gratis, CloverEp);
                    lis.setAdapter(adapterone);
                    lis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                            if(i==0){
                                Intent b = new Intent(Intent.ACTION_VIEW);
                                String url = "https://www.animeyt.tv/descargar/27092";
                                b.setData(Uri.parse(url));
                                startActivity(b);
                            }
                            else if(i==1){
                                Intent b = new Intent(Intent.ACTION_VIEW);
                                String url = "https://www.animeyt.tv/descargar/27176";
                                b.setData(Uri.parse(url));
                                startActivity(b);
                            }
                            else if(i==2){
                                Intent b = new Intent(Intent.ACTION_VIEW);
                                String url = "https://www.animeyt.tv/descargar/27234";
                                b.setData(Uri.parse(url));
                                startActivity(b);
                            }

                        }
                    });
                }
            }
        });







        return v;
    }


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
