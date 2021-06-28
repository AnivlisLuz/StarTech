/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.data;

import Persistencia.Persistencia;
import Persistencia.PersistenciaSaver;
import app.startech.login.UserSaver;
import app.startech.login.Usuario;

import java.util.ArrayList;

/**
 * @author luzch
 */
public class DataController {

    final public static DataController instance = new DataController();
    public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private Usuario usuarioActual = null;
    public DataController() {
        load();
        persistenciaUsuario();
    }
    
    private void persistenciaUsuario(){
        PersistenciaSaver persis = new PersistenciaSaver();
        ArrayList<Persistencia> persistencia = persis.lectura();
        for(Usuario user : usuarios){
           String id = user.getId();
           for(int i= 0; i<persistencia.size(); i++){
               if(id.equals(persistencia.get(i).getIdUsuario())){
                   gestionarUser(user, persistencia.get(i));
               }
           }
        }
    }
    private void gestionarUser(Usuario user, Persistencia persistencia){
        int category = Integer.parseInt(persistencia.getIdCategory());
        int level = Integer.parseInt(persistencia.getLevel());
        user.category.getAllCategories()[category-1].setActive();
        if(category != 8){
            for(int i=0; i<level; i++){
                user.category.getAllCategories()[category-1].getLevels()[i].setActive();
            }
        }
    }

    private void load() {
        UserSaver userSaver = new UserSaver();
        usuarios = userSaver.lectura();
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;

    }

    public void setUsuarioActual(int index) {
        usuarioActual = usuarios.get(index);
    }

}
