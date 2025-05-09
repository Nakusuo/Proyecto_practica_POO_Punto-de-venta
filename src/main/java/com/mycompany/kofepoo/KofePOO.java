
package com.mycompany.kofepoo;

import configuracion.CConexion;

public class KofePOO {

    public static void main(String[] args) {
      CConexion objetoConexion = new CConexion();
      objetoConexion.estableceConexion();
       
       formularios.MenuPrincipal objetoMenuPrincipal = new formularios.MenuPrincipal ();
       objetoMenuPrincipal.setVisible(true);
    }
}
