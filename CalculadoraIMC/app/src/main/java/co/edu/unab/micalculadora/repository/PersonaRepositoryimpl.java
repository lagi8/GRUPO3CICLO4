package co.edu.unab.micalculadora.repository;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import co.edu.unab.micalculadora.Callback;
import co.edu.unab.micalculadora.model.Personas;


public class PersonaRepositoryimpl implements PersonaRepository, UsuariosRepository {

    final String COLLECTION = "personas";
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    public void create(Personas persona, Callback callback) {
        db.collection(COLLECTION)
                .document(persona.getIdentificacion() + "")
                .set(persona.getMapa())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        callback.onSuccess(persona);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                callback.onFailure(e);
            }
        });
    }

    @Override
    public void update(Personas persona, Callback callback) {
        db.collection(COLLECTION)
                .document(persona.getIdentificacion() + "")
                .update(persona.getMapa())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        callback.onSuccess(persona);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                callback.onFailure(e);
            }
        });
    }

    @Override
    public void delete(Personas persona, Callback callback) {
        db.collection(COLLECTION)
                .document(persona.getIdentificacion() + "").delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        callback.onSuccess(null);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                callback.onFailure(e);
            }
        });

    }
}
/*
    //Para lectura
    @Override
    public void findAll(Callback callback) {
        db.collection(COLLECTION).get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            callback.onSuccess(task.getResult());
                        } else {
                            callback.onFailure(null);
                        }
                    }
                });

    }

    @Override
    public void findByName(String nombre, Callback callback) {
        db.collection(COLLECTION).whereEqualTo("nombre", nombre).get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        callback.onSuccess(task.getResult());
                    }
                });

    }


    @Override
    public void createWithoutID(Personas persona, Callback callback) {
        db.collection(COLLECTION)
                .add(persona.getMapa())
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        callback.onSuccess(documentReference);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                callback.onFailure(e);
            }
        });
    }*/

