package co.edu.unab.micalculadora.repository;

import co.edu.unab.micalculadora.Callback;
import co.edu.unab.micalculadora.model.Personas;

public interface PersonaRepository {
    public void update(Personas persona, Callback callback);
    public void delete(Personas persona, Callback callback);
   // public void findAll(Callback callback);
   // public void findByName(String nombre, Callback callback);
}
