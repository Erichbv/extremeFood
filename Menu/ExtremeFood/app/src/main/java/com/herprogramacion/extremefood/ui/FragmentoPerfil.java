package com.herprogramacion.extremefood.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import helper.SQLiteHandler;
import helper.SessionManager;

import com.herprogramacion.extremefood.R;

import java.util.HashMap;

/**
 * Fragmento para la pestaña "PERFIL" De la sección "Mi Cuenta"
 */
public class FragmentoPerfil extends Fragment{
    private TextView name,email;

    private SQLiteHandler db;
    private SessionManager session;

    public FragmentoPerfil() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragmento_perfil, container, false);
        name = (TextView) v.findViewById(R.id.texto_nombre);
        email = (TextView) v.findViewById(R.id.texto_email);
        // SqLite database handler
        db = new SQLiteHandler(v.getContext());

        // session manager
        session = new SessionManager(v.getContext());
        HashMap<String, String> user = db.getUserDetails();
        String name_u = user.get("name");
        String email_u = user.get("email");

        name.setText(name_u);
        email.setText(email_u);
        return v;
    }

}
