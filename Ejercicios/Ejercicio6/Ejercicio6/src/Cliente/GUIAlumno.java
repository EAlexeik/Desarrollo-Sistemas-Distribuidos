/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Modelo.Alumno;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexeik
 */
public class GUIAlumno extends javax.swing.JFrame {
    Alumno alumno;
    /**
     * Creates new form GUIAlumno
     */
    public GUIAlumno() {
        initComponents();
    }

    GUIAlumno(Alumno alumno) {
        initComponents();
        this.alumno=alumno;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Alumno");

        jButton1.setText("Cerrar Sesion");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Boleta:");

        jButton2.setText("Presentar Examen");

        jButton3.setText("Checar Calificacion");

        jLabel4.setText("Materias:");

        jButton4.setText("Inscribir Materias");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id Materia", "Grupo", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(407, 407, 407)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addGap(9, 9, 9)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void getStudents() {
        AlumnoRequest cliente;
        cliente = new AlumnoRequest(this, alumno, 'l');
        Thread peticion = new Thread(cliente);
        peticion.start();
    }

    public void listStudents(ArrayList<Alumno> alumnos) {
        Object[][] students = new Object[alumnos.size()][11];
        String[] columns = {"idAlumno", "Nombre", "Apellido Paterno", "Apellido Materno", "Email", "Calle", "Numero", "Colonia", "Delegacion", "Entidad", "Telefono"};

        for (int i = 0, j = 0; i < alumnos.size(); i++) {
            students[i][j] = "" + alumnos.get(i).getIdAlumno();
            students[i][j + 1] = "" + alumnos.get(i).getNombre();
            students[i][j + 2] = "" + alumnos.get(i).getApellidoPaterno();
            students[i][j + 3] = "" + alumnos.get(i).getApellidoMaterno();
            students[i][j + 4] = "" + alumnos.get(i).getMail();
            students[i][j + 5] = "" + alumnos.get(i).getCalle();
            students[i][j + 6] = "" + alumnos.get(i).getNumero();
            students[i][j + 7] = "" + alumnos.get(i).getColonia();
            students[i][j + 8] = "" + alumnos.get(i).getDelegación();
            students[i][j + 9] = "" + alumnos.get(i).getEntidad();
            students[i][j + 10] = "" + alumnos.get(i).getTelefono();

        }
        tblShowTable.setModel(new DefaultTableModel(students, columns));
    }

    public void setValuesSearched(Alumno alumno) {
        txtNombreAlumno.setText("" + alumno.getNombre());
        txtApellidoP.setText(alumno.getApellidoPaterno());
        txtApellidoM.setText(alumno.getApellidoMaterno());
        txtEmail.setText(alumno.getMail());
        txtCalle.setText(alumno.getCalle());
        txtNumero.setText(alumno.getNumero());
        txtColonia.setText(alumno.getColonia());
        txtDelegacion.setText(alumno.getDelegación());
        txtEntidad.setText(alumno.getEntidad());
        txtTelefono.setText(alumno.getTelefono());

    }

    public Alumno buscarAlumno() {
        AlumnoRequest cliente;
        Alumno alumno = new Alumno();
       // int idAlumno = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nombre del Alumno ", "Buscar alumno", JOptionPane.QUESTION_MESSAGE));
        int i = tblShowTable.getSelectedRow();
        int idAlumno = Integer.parseInt(tblShowTable.getValueAt(i, 0)+"");
        alumno.setIdAlumno(idAlumno);
        cliente = new AlumnoRequest(this, alumno, 'b');
        Thread peticion = new Thread(cliente);
        peticion.start();
        return alumno;
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
            java.util.logging.Logger.getLogger(GUIAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIAlumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
