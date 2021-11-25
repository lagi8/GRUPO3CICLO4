package co.edu.unab.micalculadora.repository;

import co.edu.unab.micalculadora.Callback;
import co.edu.unab.micalculadora.model.Personas;

public interface UsuariosRepository {
    public void create(Personas persona, Callback callback);
   // public void createWithoutID(Personas persona, Callback callback);
}


