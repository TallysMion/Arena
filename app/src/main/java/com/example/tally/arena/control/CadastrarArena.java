package com.example.tally.arena.control;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tally.arena.MainActivity;
import com.example.tally.arena.R;
import com.example.tally.arena.Utils.Codigo;
import com.example.tally.arena.Utils.JSONParser;
import com.example.tally.arena.model.Enum.HR;
import com.example.tally.arena.model.Enum.MIN;
import com.example.tally.arena.model.Enum.Semana;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import static com.example.tally.arena.Utils.PHP_URL.TAG_CODIGO;
import static com.example.tally.arena.Utils.PHP_URL.TAG_ID;
import static com.example.tally.arena.Utils.PHP_URL.TAG_IGREJA;
import static com.example.tally.arena.Utils.PHP_URL.TAG_MENSAGEM;
import static com.example.tally.arena.Utils.PHP_URL.TAG_NOME;
import static com.example.tally.arena.Utils.PHP_URL.TAG_SUCCESS;
import static com.example.tally.arena.Utils.PHP_URL.URL_ADD_ARENA;
import static com.example.tally.arena.Utils.PHP_URL.URL_DEL_CODIGO;
import static com.example.tally.arena.Utils.PHP_URL.URL_GET_CODIGO;


public class CadastrarArena extends Fragment {

    String mensagem = null;

    Spinner spnSemana, spnHR, spnMIN;
    HR hr = null;
    MIN min = null;
    Semana diaSemana = null;
    TextView nome, codigo, igreja, endereco;
    Button cadArena;

    Codigo cd = null;

    public CadastrarArena() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Intent intent = getActivity().getIntent();
        cd = (Codigo) intent.getSerializableExtra("Codigo");

        if (cd == null) {
            final View view = inflater.inflate(R.layout.fragment_cadastrar_arena, container, false);
            nome = view.findViewById(R.id.text_nomeArena);
            codigo = view.findViewById(R.id.text_codArena);
            cadArena = view.findViewById(R.id.button_cadArena);

            cadArena.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        new GET_CODIGO().execute().get();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (cd != null) {
                        Intent it = new Intent(view.getContext(), MainActivity.class);
                        it.putExtra("Codigo", cd);
                        startActivity(it);
                    }else{
                        if(mensagem!=null){
                            Toast.makeText(getContext(), mensagem, Toast.LENGTH_SHORT).show();
                            mensagem = null;
                        }
                    }
                }
            });

            return view;
        } else {
            final View view = inflater.inflate(R.layout.fragment_cadastrar_arena2, container, false);

            nome = view.findViewById(R.id.text_cadArena_nome);
            codigo = view.findViewById(R.id.text_cadArena_Codigo);
            endereco = view.findViewById(R.id.text_cadArena_Endereco);
            igreja = view.findViewById(R.id.text_cadArena_igrejaMae);

            spnHR = (Spinner) view.findViewById(R.id.spinner_Hr);
            spnMIN = (Spinner) view.findViewById(R.id.spinner_Min);
            spnSemana = (Spinner) view.findViewById(R.id.spinner_Semana);

            nome.setText(cd.getNome());
            codigo.setText(cd.getCodigo());

            ArrayAdapter<String> adapter;

            adapter = new ArrayAdapter<>(view.getContext(), R.layout.support_simple_spinner_dropdown_item, HR.getList());
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spnHR.setAdapter(adapter);
            spnHR.setSelection(0);
            spnHR.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    hr = HR.byString(parent.getItemAtPosition(position).toString());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    hr = HR.h0;
                }
            });

            adapter = new ArrayAdapter<>(view.getContext(), R.layout.support_simple_spinner_dropdown_item, MIN.getList());
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spnMIN.setAdapter(adapter);
            spnMIN.setSelection(0);
            spnMIN.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    min = MIN.byString(parent.getItemAtPosition(position).toString());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    min = MIN.h0;
                }
            });

            adapter = new ArrayAdapter<>(view.getContext(), R.layout.support_simple_spinner_dropdown_item, Semana.getList());
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spnSemana.setAdapter(adapter);
            spnSemana.setSelection(0);
            spnSemana.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    diaSemana = Semana.byString(parent.getItemAtPosition(position).toString());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    diaSemana = null;
                }
            });

            cadArena = view.findViewById(R.id.button_cadArena);
            cadArena.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {
                        new INSERT_ARENA().execute().get();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (cd == null) {
                        Toast.makeText(getContext(), mensagem, Toast.LENGTH_SHORT).show();
                        mensagem = null;
                        Intent it = new Intent(view.getContext(), MainActivity.class);
                        it.removeExtra("Codigo");
                        startActivity(it);
                    }else{
                        if(mensagem!=null){
                            Toast.makeText(getContext(), mensagem, Toast.LENGTH_SHORT).show();
                            mensagem = null;
                        }
                    }

                }
            });


            return view;
        }


    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }


    class GET_CODIGO extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            String nomeS, codigoS;
            nomeS = nome.getText().toString();
            codigoS = codigo.getText().toString();

            HashMap<String,String> params = new HashMap<>();
            params.put("nome_proj", nomeS);
            params.put("cod_proj", codigoS);

            JSONParser jsonParser = new JSONParser();
            JSONObject json = jsonParser.makeHttpRequest(URL_GET_CODIGO, "POST", params);

            Log.d("Create Response", json.toString());

            try {
                int success = json.getInt(TAG_SUCCESS);
                if (success == 1){
                    JSONObject cod = json.getJSONObject(TAG_CODIGO);
                    int id = cod.getInt(TAG_ID);
                    String nome = cod.getString(TAG_NOME);
                    String igreja = cod.getString(TAG_IGREJA);
                    String codigo = cod.getString(TAG_CODIGO);

                    cd = new Codigo(id, nome, igreja, codigo);
                }else{
                    cd = null;
                    mensagem = json.getString(TAG_MENSAGEM);
                }
            }catch (JSONException e){
                System.err.println(e.getMessage());
            }

            return null;
        }
    }

    class INSERT_ARENA extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... strings) {
            String nomeS, igrejaS, enderecoS, codigoS;

            nomeS   = nome.getText().toString();
            igrejaS = igreja.getText().toString();
            enderecoS = endereco.getText().toString();
            codigoS = codigo.getText().toString();

            if(nomeS.equals("") || igrejaS.equals("") || enderecoS.equals("") || codigoS.equals("")){
               mensagem = "Erro, Confira as Informaões";
               return null;
            }else {

                HashMap<String, String> params = new HashMap<>();
                params.put("nome_proj", nomeS);
                params.put("cod_proj", codigoS);
                params.put("igreja_proj", igrejaS);
                params.put("endereco_proj", enderecoS);
                params.put("hr_proj", hr.ordinal() + "");
                params.put("min_proj", min.ordinal() + "");
                params.put("dia_proj", diaSemana.ordinal() + "");

                JSONParser jsonParser = new JSONParser();
                JSONObject json = jsonParser.makeHttpRequest(URL_ADD_ARENA, "POST", params);
                Log.d("Create Response", json.toString());

                try {
                    int success = json.getInt(TAG_SUCCESS);
                    if(success == 0){
                        mensagem = json.getString(TAG_MENSAGEM);
                        return null;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                params = new HashMap<>();
                params.put("id", cd.getId()+"");

                jsonParser = new JSONParser();
                json = jsonParser.makeHttpRequest(URL_DEL_CODIGO, "POST", params);

                try {
                    int success = json.getInt(TAG_SUCCESS);
                    if(success == 0){
                        mensagem = json.getString(TAG_MENSAGEM);
                        return null;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                cd = null;
                mensagem = "Cadastro Efetuado, Utilize o codigo para criar seu usuario";
            }
            return null;
        }
    }

}