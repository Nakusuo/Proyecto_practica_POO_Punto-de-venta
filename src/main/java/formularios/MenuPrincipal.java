package formularios;

import modelos.ProductoConDescuento;

public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();
        
        ProductoConDescuento producto = new ProductoConDescuento(1, "Galletas", 0.50, 100, 10); 

        lblDescuento.setText(producto.obtenerMensajeDescuento());
        
        this.setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenu13 = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();
        jMenu15 = new javax.swing.JMenu();
        jMenu16 = new javax.swing.JMenu();
        dpFormularios = new javax.swing.JDesktopPane();
        lbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblDescuento = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        jMenuBar2.setBackground(new java.awt.Color(204, 204, 255));

        jMenu9.setText("Vender");
        jMenu9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu9MouseClicked(evt);
            }
        });
        jMenu9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu9ActionPerformed(evt);
            }
        });
        jMenuBar2.add(jMenu9);

        jMenu10.setText("Administración");

        jMenu11.setText("Clientes");
        jMenu11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu11MouseClicked(evt);
            }
        });
        jMenu10.add(jMenu11);

        jMenu12.setText("Productos");
        jMenu12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu12MouseClicked(evt);
            }
        });
        jMenu10.add(jMenu12);

        jMenuBar2.add(jMenu10);

        jMenu13.setText("Reportes");

        jMenu14.setText("Consultar comprobante");
        jMenu14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu14MouseClicked(evt);
            }
        });
        jMenu13.add(jMenu14);

        jMenu15.setText("Consultar por Fecha");
        jMenu15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu15MouseClicked(evt);
            }
        });
        jMenu13.add(jMenu15);

        jMenuBar2.add(jMenu13);

        jMenu16.setText("Salir");
        jMenu16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu16MouseClicked(evt);
            }
        });
        jMenuBar2.add(jMenu16);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dpFormularios.setBackground(new java.awt.Color(209, 130, 79));

        lbl.setFont(new java.awt.Font("Roboto Black", 1, 60)); // NOI18N
        lbl.setText("Punto de Venta Kofe");

        jLabel1.setFont(new java.awt.Font("MS PGothic", 3, 18)); // NOI18N
        jLabel1.setText("Interfaz para control de la cafeteria Kofe");

        lblDescuento.setText("----");

        dpFormularios.setLayer(lbl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dpFormularios.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dpFormularios.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dpFormularios.setLayer(lblDescuento, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dpFormularios.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dpFormularios.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dpFormularios.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dpFormularios.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dpFormulariosLayout = new javax.swing.GroupLayout(dpFormularios);
        dpFormularios.setLayout(dpFormulariosLayout);
        dpFormulariosLayout.setHorizontalGroup(
            dpFormulariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dpFormulariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dpFormulariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dpFormulariosLayout.createSequentialGroup()
                        .addGroup(dpFormulariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescuento)
                            .addComponent(jLabel3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dpFormulariosLayout.createSequentialGroup()
                        .addGap(0, 137, Short.MAX_VALUE)
                        .addGroup(dpFormulariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGroup(dpFormulariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dpFormulariosLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addGroup(dpFormulariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl)
                                    .addGroup(dpFormulariosLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6))))
                            .addGroup(dpFormulariosLayout.createSequentialGroup()
                                .addGap(226, 226, 226)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(233, 233, 233))))
        );
        dpFormulariosLayout.setVerticalGroup(
            dpFormulariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dpFormulariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDescuento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(dpFormulariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dpFormulariosLayout.createSequentialGroup()
                        .addGroup(dpFormulariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(168, 168, 168)
                        .addComponent(jLabel5)
                        .addGap(227, 227, 227))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dpFormulariosLayout.createSequentialGroup()
                        .addGroup(dpFormulariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dpFormulariosLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel6))
                            .addGroup(dpFormulariosLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel2)))
                        .addGap(325, 325, 325))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dpFormulariosLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap())))
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 255));

        jMenu1.setText("Vender");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Administración");

        jMenu5.setText("Clientes");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenu2.add(jMenu5);

        jMenu6.setText("Productos");
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        jMenu2.add(jMenu6);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Reportes");

        jMenu7.setText("Consultar comprobante");
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        jMenu3.add(jMenu7);

        jMenu8.setText("Consultar por Fecha");
        jMenu8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu8MouseClicked(evt);
            }
        });
        jMenu3.add(jMenu8);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Salir");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpFormularios, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dpFormularios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
            formularios.FormVentas objetoFormularioVenta = new formularios.FormVentas();
       dpFormularios.add(objetoFormularioVenta);
       objetoFormularioVenta.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
           formularios.FormClientes objetoFormularioCliente = new formularios.FormClientes();
       dpFormularios.add(objetoFormularioCliente);
       objetoFormularioCliente.setVisible(true);
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
           formularios.FormProducto objetoFormularioProducto = new formularios.FormProducto();
       dpFormularios.add(objetoFormularioProducto);
       objetoFormularioProducto.setVisible(true);    }//GEN-LAST:event_jMenu6MouseClicked

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
         formularios.FormConsultarComprobante objetoConsultarComprobante = new formularios.FormConsultarComprobante();
       dpFormularios.add(objetoConsultarComprobante);
       objetoConsultarComprobante.setVisible(true);    }//GEN-LAST:event_jMenu7MouseClicked

    private void jMenu8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu8MouseClicked
           formularios.FormReporteFechas objetoReporteFechas = new formularios.FormReporteFechas();
       dpFormularios.add(objetoReporteFechas);
       objetoReporteFechas.setVisible(true);     }//GEN-LAST:event_jMenu8MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu9MouseClicked
        formularios.FormVentas objetoFormularioVenta = new formularios.FormVentas();
        dpFormularios.add(objetoFormularioVenta);
        objetoFormularioVenta.setVisible(true);
    }//GEN-LAST:event_jMenu9MouseClicked

    private void jMenu9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu9ActionPerformed

    }//GEN-LAST:event_jMenu9ActionPerformed

    private void jMenu11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu11MouseClicked
        formularios.FormClientes objetoFormularioCliente = new formularios.FormClientes();
        dpFormularios.add(objetoFormularioCliente);
        objetoFormularioCliente.setVisible(true);
    }//GEN-LAST:event_jMenu11MouseClicked

    private void jMenu12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu12MouseClicked
        formularios.FormProducto objetoFormularioProducto = new formularios.FormProducto();
        dpFormularios.add(objetoFormularioProducto);
    }//GEN-LAST:event_jMenu12MouseClicked

    private void jMenu14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu14MouseClicked
        formularios.FormConsultarComprobante objetoConsultarComprobante = new formularios.FormConsultarComprobante();
        dpFormularios.add(objetoConsultarComprobante);
    }//GEN-LAST:event_jMenu14MouseClicked

    private void jMenu15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu15MouseClicked
        formularios.FormReporteFechas objetoReporteFechas = new formularios.FormReporteFechas();
        dpFormularios.add(objetoReporteFechas);
    }//GEN-LAST:event_jMenu15MouseClicked

    private void jMenu16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu16MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jMenu16MouseClicked


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dpFormularios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblDescuento;
    // End of variables declaration//GEN-END:variables
}
