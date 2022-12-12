
package Formularios;

import Clases.Conexion;
import Clases.Tiquete;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.VirtualEarthTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.WaypointPainter;
import table.TableCustom;
import waypoint.EventWaypoint;
import waypoint.MyWaypoint;
import waypoint.WaypointRender;

public class frmClientes extends javax.swing.JFrame {

    private final Set<MyWaypoint> waypoints = new HashSet<>();
    private EventWaypoint event;
    
    Conexion cnx = new Conexion();
    ArrayList<Tiquete> tiquete = new ArrayList<>();
    DefaultTableModel tabla;
    String [] ticket = new String [10];
    int idTiquete;
    public frmClientes(int id) {
        initComponents();
        extender();
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        tabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        tabla.addColumn("ID");
        tabla.addColumn("Origen");
        tabla.addColumn("Destino");
        tabla.addColumn("Duración");
        tabla.addColumn("Costo");
        tabla.addColumn("Fecha Compra");
        tabla.addColumn("ID Bus");
        tblTiquetes.setModel(tabla);
        idTiquete = id;
        init();
        llenarTabla();
        lbNombre.setText(cnx.consultarNombre(id));
        
    }
    
    private void init() {
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapViewer1.setTileFactory(tileFactory);
        GeoPosition geo = new GeoPosition(11.221501, -74.180751);
        jXMapViewer1.setAddressLocation(geo);
        jXMapViewer1.setZoom(9);

        //  Create event mouse move
        MouseInputListener mm = new PanMouseInputListener(jXMapViewer1);
        jXMapViewer1.addMouseListener(mm);
        jXMapViewer1.addMouseMotionListener(mm);
        jXMapViewer1.addMouseWheelListener(new ZoomMouseWheelListenerCenter(jXMapViewer1));
        event = getEvent();
    }
    
    private void addWaypoint(MyWaypoint waypoint) {
        for (MyWaypoint d : waypoints) {
            jXMapViewer1.remove(d.getButton());
        }
        waypoints.add(waypoint);
        initWaypoint();
    }

    private void initWaypoint() {
        WaypointPainter<MyWaypoint> wp = new WaypointRender();
        wp.setWaypoints(waypoints);
        jXMapViewer1.setOverlayPainter(wp);
        for (MyWaypoint d : waypoints) {
            jXMapViewer1.add(d.getButton());
        }
    }

    private void clearWaypoint() {
        for (MyWaypoint d : waypoints) {
            jXMapViewer1.remove(d.getButton());
        }
        waypoints.clear();
        initWaypoint();
    }

    private EventWaypoint getEvent() {
        return new EventWaypoint() {
            @Override
            public void selected(MyWaypoint waypoint) {
                JOptionPane.showMessageDialog(frmClientes.this, waypoint.getName());
            }
        };
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jXMapViewer1 = new org.jxmapviewer.JXMapViewer();
        cbTipoMapa = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTiquetes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lbNombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(486486, 45546));
        setMinimumSize(new java.awt.Dimension(750, 450));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(750, 450));

        jXMapViewer1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        cbTipoMapa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Básico", "Híbrido", "Satelital" }));
        cbTipoMapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoMapaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXMapViewer1Layout = new javax.swing.GroupLayout(jXMapViewer1);
        jXMapViewer1.setLayout(jXMapViewer1Layout);
        jXMapViewer1Layout.setHorizontalGroup(
            jXMapViewer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXMapViewer1Layout.createSequentialGroup()
                .addContainerGap(190, Short.MAX_VALUE)
                .addComponent(cbTipoMapa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jXMapViewer1Layout.setVerticalGroup(
            jXMapViewer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXMapViewer1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbTipoMapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblTiquetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTiquetes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblTiquetes.setMaximumSize(new java.awt.Dimension(2147483647, 156514));
        tblTiquetes.getTableHeader().setResizingAllowed(false);
        tblTiquetes.getTableHeader().setReorderingAllowed(false);
        tblTiquetes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTiquetesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTiquetes);
        if (tblTiquetes.getColumnModel().getColumnCount() > 0) {
            tblTiquetes.getColumnModel().getColumn(0).setResizable(false);
            tblTiquetes.getColumnModel().getColumn(1).setResizable(false);
            tblTiquetes.getColumnModel().getColumn(2).setResizable(false);
            tblTiquetes.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel2.setBackground(new java.awt.Color(50, 103, 137));
        jPanel2.setMaximumSize(new java.awt.Dimension(446, 100));
        jPanel2.setMinimumSize(new java.awt.Dimension(446, 100));
        jPanel2.setPreferredSize(new java.awt.Dimension(446, 100));

        lbNombre.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        lbNombre.setForeground(new java.awt.Color(255, 255, 255));
        lbNombre.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bienvenido/a,");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addComponent(lbNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNombre)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jXMapViewer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 36, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jXMapViewer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        frmLogin Login = new frmLogin();
        String botones[] = {"Aceptar","Cancelar"};
        int Decision = JOptionPane.showOptionDialog (null, " ¿Estas Seguro que quieres cerrar La App?", "Seguro", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, botones[0]);
        
        if (Decision == 1)
        {
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            
        }
        else 
        {
             Login.setVisible(true);
             this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void cbTipoMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoMapaActionPerformed
        TileFactoryInfo info = null;
        int indice = cbTipoMapa.getSelectedIndex();
        switch(indice){
            case 0:
                info = new OSMTileFactoryInfo();
                break;
            case 1:
                info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.MAP);
                break;
            case 2:
                info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.HYBRID);
                break;
            case 3:
                info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.SATELLITE);
                break;
        }
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapViewer1.setTileFactory(tileFactory);
    }//GEN-LAST:event_cbTipoMapaActionPerformed

    private void tblTiquetesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTiquetesMouseClicked
        int indice = tblTiquetes.getSelectedRow();
        clearWaypoint();
        if (tabla.getValueAt(indice, 1).toString().equals("Santa Marta") && tabla.getValueAt(indice, 2).toString().equals("Barranquilla")) {
            ruta1();
        }else if (tabla.getValueAt(indice, 1).toString().equals("Santa Marta") && tabla.getValueAt(indice, 2).toString().equals("Cartagena")) {
            ruta2();
        }else if (tabla.getValueAt(indice, 1).toString().equals("Santa Marta") && tabla.getValueAt(indice, 2).toString().equals("Valledupar")) {
            ruta3();
        }else if (tabla.getValueAt(indice, 1).toString().equals("Barranquilla") && tabla.getValueAt(indice, 2).toString().equals("Santa Marta")) {
            ruta1();
        }else if (tabla.getValueAt(indice, 1).toString().equals("Cartagena") && tabla.getValueAt(indice, 2).toString().equals("Santa Marta")) {
            ruta2();
        }else if (tabla.getValueAt(indice, 1).toString().equals("Valledupar") && tabla.getValueAt(indice, 2).toString().equals("Santa Marta")) {
            ruta3();
        }else{
            rutaDefault();
        }
    }//GEN-LAST:event_tblTiquetesMouseClicked
    
    public void ruta1(){
        addWaypoint(new MyWaypoint("Terminal de transporte de Santa Marta", event, new GeoPosition(11.221501, -74.180751)));
        addWaypoint(new MyWaypoint("Terminal de transporte de Barranquilla", event, new GeoPosition(10.909220, -74.793109)));
        GeoPosition geo = new GeoPosition(11.034974, -74.487922);
        jXMapViewer1.setAddressLocation(geo);
        jXMapViewer1.setZoom(9);
    }
    
    public void ruta2(){
        addWaypoint(new MyWaypoint("Terminal de transporte de Santa Marta", event, new GeoPosition(11.221501, -74.180751)));
        addWaypoint(new MyWaypoint("Terminal de transporte de Cartagena", event, new GeoPosition(10.401130, -75.458477)));
        GeoPosition geo = new GeoPosition(10.801912, -74.850229);
        jXMapViewer1.setAddressLocation(geo);
        jXMapViewer1.setZoom(10);
    }
    
    public void ruta3(){
        addWaypoint(new MyWaypoint("Terminal de transporte de Santa Marta", event, new GeoPosition(11.221501, -74.180751)));
        addWaypoint(new MyWaypoint("Terminal de transporte de Valledupar", event, new GeoPosition(10.445337, -73.242955)));
        GeoPosition geo = new GeoPosition(10.643527, -73.735476);
        jXMapViewer1.setAddressLocation(geo);
        jXMapViewer1.setZoom(10);
    }
    
    public void rutaDefault(){
        clearWaypoint();
        GeoPosition geo = new GeoPosition(11.221501, -74.180751);
        jXMapViewer1.setAddressLocation(geo);
        jXMapViewer1.setZoom(3);
    }
    
    public void llenarTabla(){
        cnx.conectar();
        tiquete.addAll(cnx.consultarTiquetes(idTiquete));
        for (int i = 0; i < tiquete.size(); i++) {
            ticket[0] = "" + tiquete.get(i).getId_tiquete();
            ticket[1] = tiquete.get(i).getOrigen();
            ticket[2] = tiquete.get(i).getDestino();
            ticket[3] = "" + tiquete.get(i).getTiempoAproximado();
            ticket[4] = tiquete.get(i).getCosto();
            ticket[5] = "" + tiquete.get(i).getFechaCompra();
            ticket[6] = "" + tiquete.get(i).getFechaViaje();
            ticket[7] = "" + tiquete.get(i).getHoraViaje();
            ticket[8] = "" + tiquete.get(i).getId_bus();
            ticket[8] = "" + tiquete.get(i).getId_Cliente();
            tabla.addRow(ticket);
        }
        
    }
    
    public void extender(){
        GraphicsEnvironment env =
        GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.setMaximizedBounds(env.getMaximumWindowBounds());
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmClientes(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbTipoMapa;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jxmapviewer.JXMapViewer jXMapViewer1;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JTable tblTiquetes;
    // End of variables declaration//GEN-END:variables
}
