package com.example.tally.arena.control;


import android.content.res.Configuration;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.tally.arena.R;
import com.example.tally.arena.Utils.JSONParser;
import com.example.tally.arena.Utils.MaskDate;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import static com.example.tally.arena.Utils.PHP_URL.TAG_MENSAGEM;
import static com.example.tally.arena.Utils.PHP_URL.TAG_SUCCESS;
import static com.example.tally.arena.Utils.PHP_URL.URL_ADD_ARENA;
import static com.example.tally.arena.Utils.PHP_URL.URL_ADD_USUARIO;


public class CadastrarUser extends Fragment {
       public CadastrarUser() {
        // Required empty public constructor
    }

    int success;
    String mensagem = null;

    LinearLayout ls, l1, l2;
    EditText nome, login, senha, senha2, email, nasc, telefone, codigo;
    Button cad;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_cadastrar_user, container, false);
            Configuration configuration = getResources().getConfiguration();
            ls = (LinearLayout) view.findViewById(R.id.layout_switch);
            l1 = (LinearLayout) view.findViewById(R.id.layout1);
            l2 = (LinearLayout) view.findViewById(R.id.layout2);
            if(ls != null){
                if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
                    ls.setOrientation(LinearLayout.HORIZONTAL);
                    l1.setGravity(Gravity.CENTER);
                    l2.setGravity(Gravity.CENTER);
                }else{
                    ls.setOrientation(LinearLayout.VERTICAL);
                    l1.setGravity(Gravity.BOTTOM);
                    l2.setGravity(Gravity.TOP);
                }
            }

            nome    = (EditText) view.findViewById(R.id.text_cadNome);
            login   = (EditText) view.findViewById(R.id.text_cadLogin);
            senha   = (EditText) view.findViewById(R.id.text_cadKey);
            senha2  = (EditText) view.findViewById(R.id.text_cadKey2);
            email   = (EditText) view.findViewById(R.id.text_cadEmail);
            nasc    = (EditText) view.findViewById(R.id.text_cadNasc);
            telefone= (EditText) view.findViewById(R.id.text_cadTelefone);
            codigo  = (EditText) view.findViewById(R.id.text_cadCodigo);

            cad     = (Button)   view.findViewById(R.id.button_cadButton);

            nasc.addTextChangedListener(MaskDate.insert("##/##/####", nasc));
            telefone.addTextChangedListener(MaskDate.insert("## #####-####", telefone));

            cad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(!senha.getText().toString().equals(senha2.getText().toString())){
                        Toast.makeText(getContext(), "Senhas não Conferem", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(nome.getText().toString().equals("") || login.getText().toString().equals("") ||
                            senha.getText().toString().equals("") || senha2.getText().toString().equals("") ||
                            email.getText().toString().equals("") || nasc.getText().toString().equals("") ||
                            telefone.getText().toString().equals("") || codigo.getText().toString().equals("")){
                        Toast.makeText(getContext(), "Complete os Dados", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    //TODO validar data e telefone;

                    try {
                        new CADASTRAR_USUARIO().execute().get();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if(success == 1){
                        Toast.makeText(getContext(), mensagem, Toast.LENGTH_SHORT).show();
                        //TODO direcionar para login
                    }else{
                        Toast.makeText(getContext(), mensagem, Toast.LENGTH_SHORT).show();
                    }

                }
            });




            return view;

    }

    class CADASTRAR_USUARIO extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... strings) {

            String nomeS, loginS, senhaS, emailS, dataNascS, telefoneS, codigoS;

            nomeS       = nome.getText().toString();
            loginS      = login.getText().toString();
            senhaS      = senha.getText().toString();
            emailS      = email.getText().toString();
            dataNascS   = MaskDate.unmask(nasc.getText().toString());
            telefoneS   = MaskDate.unmask(telefone.getText().toString());
            codigoS     = codigo.getText().toString();

            HashMap<String, String> params = new HashMap<>();
            params.put("nome", nomeS);
            params.put("login", loginS);
            params.put("senha", senhaS);
            params.put("email", emailS);
            params.put("dataNasc", dataNascS);
            params.put("telefone", telefoneS);
            params.put("codigo", codigoS);

            JSONParser jsonParser = new JSONParser();
            JSONObject json = jsonParser.makeHttpRequest(URL_ADD_USUARIO, "POST", params);
            Log.d("Create Response", json.toString());

            try {
                success = json.getInt(TAG_SUCCESS);
                mensagem = json.getString(TAG_MENSAGEM);
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;
        }
    }

}
