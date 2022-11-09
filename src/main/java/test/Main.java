package test;

import com.iudigital.crud.controller.FuncionarioController;
import com.iudigital.crud.dominio.Funcionario;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JFrame {

    private final FuncionarioController funcionarioController;
    private static final String[] COLUMNS = {"ID", "NOMBRE", "APELLIDO", "SEXO", "TIPO DE IDENTIFICACIÓN", "ESTADO CIVIL",
        "DIRECCION", "TELEFONO", "FECHA DE NACIMIENTO"};
    private static final String SELECCIONE = "--SELECCIONE--";

    public Main() {
        initComponents();
        txtFuncionarioId.setEditable(false);
        funcionarioController = new FuncionarioController();
        listFuncionarios();
        addListener();
    }

    private void listFuncionarios() {
        cbxFuncionarios.removeAllItems();

        Funcionario funcionario1 = new Funcionario();
        funcionario1.setNombre(SELECCIONE);
        funcionario1.setApellido("");
        cbxFuncionarios.addItem(funcionario1);
        tblFuncionarios.removeAll();

        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN : COLUMNS) {
            defaultTableModel.addColumn(COLUMN);
        }
        tblFuncionarios.setModel(defaultTableModel);

        try {
            List<Funcionario> funcionarios = funcionarioController.obtenerFuncionarios();

            if (funcionarios.isEmpty()) {
                return;
            }
            defaultTableModel.setRowCount(funcionarios.size());
            int row = 0;
            for (Funcionario funcionario : funcionarios) {
                defaultTableModel.setValueAt(funcionario.getIdFuncionario(), row, 0);
                defaultTableModel.setValueAt(funcionario.getNombre(), row, 1);
                defaultTableModel.setValueAt(funcionario.getApellido(), row, 2);
                defaultTableModel.setValueAt(funcionario.getSexo(), row, 3);
                defaultTableModel.setValueAt(funcionario.getIdentificacion(), row, 4);
                defaultTableModel.setValueAt(funcionario.getEstadoCivil(), row, 5);
                defaultTableModel.setValueAt(funcionario.getDireccion(), row, 6);
                defaultTableModel.setValueAt(funcionario.getTelefono(), row, 7);
                defaultTableModel.setValueAt(funcionario.getFechaNacimiento(), row, 8);
                row++;
                cbxFuncionarios.addItem(funcionario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private void addListener() {
        cbxFuncionarios.addItemListener(event -> {
            Funcionario selectedFuncionario = (Funcionario) event.getItem();
            if (selectedFuncionario.getNombre().equals(SELECCIONE)) {
                txtFuncionarioId.setText("");
                txtNombreEdit.setText("");
                txtApellidoEdit.setText("");
                txtSexoEdit.setText("");
                txtTipoIdentificacionEdit.setText("");
                txtEstadoCivilEdit.setText("");
                txtDireccionEdit.setText("");
                txtTelefonoEdit.setText("");
                txtFechaNacimientoEdit.setText("");
            } else {
                txtFuncionarioId.setText(String.valueOf(selectedFuncionario.getIdFuncionario()));
                txtNombreEdit.setText(selectedFuncionario.getNombre());
                txtApellidoEdit.setText(selectedFuncionario.getApellido());
                txtSexoEdit.setText(selectedFuncionario.getSexo());
                txtTipoIdentificacionEdit.setText(String.valueOf(selectedFuncionario.getIdentificacionId()));
                txtEstadoCivilEdit.setText(String.valueOf(selectedFuncionario.getEstadoCivilId()));
                txtDireccionEdit.setText(selectedFuncionario.getDireccion());
                txtTelefonoEdit.setText(selectedFuncionario.getTelefono());
                txtFechaNacimientoEdit.setText(selectedFuncionario.getFechaNacimiento());
            }
            System.out.println("selectedFuncionario = " + selectedFuncionario);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTPanels = new javax.swing.JTabbedPane();
        jPFuncionario = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblFechaNacimiento = new javax.swing.JLabel();
        txtFechaNacimiento = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtSexo = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        lblTipo = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPFuncionario1 = new javax.swing.JPanel();
        jPEdit = new javax.swing.JPanel();
        lblFuncionarios = new javax.swing.JLabel();
        cbxFuncionarios = new javax.swing.JComboBox<>();
        lblFuncionarioId = new javax.swing.JLabel();
        lblNombreEdit = new javax.swing.JLabel();
        lblApellidoEdit = new javax.swing.JLabel();
        lblSexoEdit = new javax.swing.JLabel();
        lblDireccionEdit = new javax.swing.JLabel();
        lblTelefonoEdit = new javax.swing.JLabel();
        lblFechaNacimientoEdit = new javax.swing.JLabel();
        txtFuncionarioId = new javax.swing.JTextField();
        txtNombreEdit = new javax.swing.JTextField();
        txtApellidoEdit = new javax.swing.JTextField();
        txtSexoEdit = new javax.swing.JTextField();
        txtDireccionEdit = new javax.swing.JTextField();
        txtTelefonoEdit = new javax.swing.JTextField();
        txtFechaNacimientoEdit = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblTipoIdentificacionEdit = new javax.swing.JLabel();
        lblEstadoCivilEdit = new javax.swing.JLabel();
        txtEstadoCivilEdit = new javax.swing.JTextField();
        txtTipoIdentificacionEdit = new javax.swing.JTextField();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Funcionarios");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("GESTION DE FUNCIONARIOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, -1, -1));

        jPFuncionario.setBorder(javax.swing.BorderFactory.createTitledBorder("Digite los siguientes datos:"));

        jLabel3.setText("NOMBRE");

        jLabel4.setText("APELLIDO");

        lblSexo.setText("SEXO");

        lblDireccion.setText("DIRECCION");

        lblTelefono.setText("TELEFONO");

        lblFechaNacimiento.setText("FECHA DE NACIMIENTO");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblTipo.setText("ID TIPO DE IDENTIFICACION");

        lblEstado.setText("ID ESTADO CIVIL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(646, 646, 646)
                        .addComponent(btnGuardar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFechaNacimiento)
                                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblEstado))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTipo)
                                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTelefono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(lblEstado)
                    .addComponent(lblFechaNacimiento)
                    .addComponent(lblDireccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addContainerGap())
        );

        tblFuncionarios.setBackground(new java.awt.Color(204, 255, 153));
        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblFuncionarios);

        javax.swing.GroupLayout jPFuncionarioLayout = new javax.swing.GroupLayout(jPFuncionario);
        jPFuncionario.setLayout(jPFuncionarioLayout);
        jPFuncionarioLayout.setHorizontalGroup(
            jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPFuncionarioLayout.setVerticalGroup(
            jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncionarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTPanels.addTab("Crear Funcionario", jPFuncionario);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jPFuncionario1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPEdit.setBackground(new java.awt.Color(204, 204, 255));

        lblFuncionarios.setText("FUNCIONARIOS");

        lblFuncionarioId.setText("ID");

        lblNombreEdit.setText("NOMBRE");

        lblApellidoEdit.setText("APELLIDO");

        lblSexoEdit.setText("SEXO");

        lblDireccionEdit.setText("DIRECCION");

        lblTelefonoEdit.setText("TELEFONO");

        lblFechaNacimientoEdit.setText("FECHA DE NACIMIENTO");

        txtTelefonoEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoEditActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(0, 153, 153));
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(0, 153, 153));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblTipoIdentificacionEdit.setText("ID TIPO IDENTIFICACION");

        lblEstadoCivilEdit.setText("ID ESTADO CIVIL");

        javax.swing.GroupLayout jPEditLayout = new javax.swing.GroupLayout(jPEdit);
        jPEdit.setLayout(jPEditLayout);
        jPEditLayout.setHorizontalGroup(
            jPEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEditLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPEditLayout.createSequentialGroup()
                        .addGroup(jPEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPEditLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(txtNombreEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtApellidoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSexoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPEditLayout.createSequentialGroup()
                                .addComponent(lblFuncionarioId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNombreEdit)
                                .addGap(44, 44, 44)
                                .addComponent(lblApellidoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(lblSexoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTipoIdentificacionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipoIdentificacionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPEditLayout.createSequentialGroup()
                                .addComponent(lblEstadoCivilEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTelefonoEdit)
                                .addGap(18, 18, 18)
                                .addComponent(lblDireccionEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(lblFechaNacimientoEdit))
                            .addGroup(jPEditLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtEstadoCivilEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTelefonoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDireccionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtFechaNacimientoEdit))))
                    .addComponent(lblFuncionarios)
                    .addComponent(cbxFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPEditLayout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(btnActualizar)
                        .addGap(32, 32, 32)
                        .addComponent(btnEliminar)))
                .addContainerGap())
            .addGroup(jPEditLayout.createSequentialGroup()
                .addComponent(txtFuncionarioId, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPEditLayout.setVerticalGroup(
            jPEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEditLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblFuncionarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncionarioId)
                    .addComponent(lblNombreEdit)
                    .addComponent(lblApellidoEdit)
                    .addComponent(lblSexoEdit)
                    .addComponent(lblTelefonoEdit)
                    .addComponent(lblTipoIdentificacionEdit)
                    .addComponent(lblEstadoCivilEdit)
                    .addComponent(lblDireccionEdit)
                    .addComponent(lblFechaNacimientoEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFuncionarioId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSexoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefonoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstadoCivilEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoIdentificacionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaNacimientoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106)
                .addGroup(jPEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addContainerGap(123, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPFuncionario1Layout = new javax.swing.GroupLayout(jPFuncionario1);
        jPFuncionario1.setLayout(jPFuncionario1Layout);
        jPFuncionario1Layout.setHorizontalGroup(
            jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncionario1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPFuncionario1Layout.setVerticalGroup(
            jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncionario1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPFuncionario1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPFuncionario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jTPanels.addTab("Editar Funcionario", jPanel2);

        getContentPane().add(jTPanels, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 890, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoEditActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (txtNombre.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, " Digite el nombre");
            txtNombre.requestFocus();
            return;
        }

        if (txtApellido.getText().trim().length() == 0) { //trim para que no nos deje espacios dentro del campo 
            JOptionPane.showMessageDialog(null, "Ditite el apellido");
            txtApellido.requestFocus();//deja el cursos sobre el campor que está vacío
            return;
        }

        if (txtSexo.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el sexo");
            txtSexo.requestFocus();
            return;
        }
        if (txtTipo.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el tipo");
            txtTipo.requestFocus();
            return;
        }
        if (txtEstado.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el estado");
            txtEstado.requestFocus();
            return;
        }

        if (txtDireccion.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite la dirección");
            txtDireccion.requestFocus();
            return;
        }

        if (txtTelefono.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el telefono");
            txtTelefono.requestFocus();
            return;
        }

        if (txtFechaNacimiento.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite la fecha de nacimiento");
            txtFechaNacimiento.requestFocus();
            return;
        }

        Funcionario funcionario = new Funcionario();
        funcionario.setNombre(txtNombre.getText().trim());
        funcionario.setApellido(txtApellido.getText().trim());
        funcionario.setSexo(txtSexo.getText().trim());
        funcionario.setIdentificacionId(Integer.parseInt(txtTipo.getText().trim()));
        funcionario.setEstadoCivilId(Integer.parseInt(txtEstado.getText().trim()));
        funcionario.setDireccion(txtDireccion.getText().trim());
        funcionario.setTelefono(txtTelefono.getText().trim());
        funcionario.setFechaNacimiento(txtFechaNacimiento.getText().trim());

        try {
            funcionarioController.crear(funcionario);
            txtNombre.setText("");
            txtApellido.setText("");
            txtSexo.setText("");
            txtTipo.setText("");
            txtEstado.setText("");
            txtDireccion.setText("");
            txtTelefono.setText("");
            txtFechaNacimiento.setText("");
            listFuncionarios();
            JOptionPane.showMessageDialog(null, "El funcionario fue creado con exito");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            JOptionPane.showMessageDialog(null, "El funcionario no pudo ser creado");
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        if (txtFuncionarioId.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un funcionario de la lista");
            txtFuncionarioId.requestFocus();
            return;
        }

        if (txtNombreEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el nombre");
            txtNombreEdit.requestFocus();
            return;
        }

        if (txtApellidoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar el apellido");
            txtApellidoEdit.requestFocus();
            return;
        }

        if (txtSexoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el sexo");
            txtSexoEdit.requestFocus();
            return;
        }

        if (txtTipoIdentificacionEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el id de identificacion");
            txtTipoIdentificacionEdit.requestFocus();
            return;
        }
        if (txtEstadoCivilEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el id de estado civil");
            txtEstadoCivilEdit.requestFocus();
            return;
        }

        if (txtDireccionEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite la dirección");
            txtDireccionEdit.requestFocus();
            return;
        }

        if (txtTelefonoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el telefono");
            txtTelefonoEdit.requestFocus();
            return;
        }

        if (txtFechaNacimientoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite la fecha de nacimiento");
            txtFechaNacimientoEdit.requestFocus();
            return;
        }

        Funcionario funcionario = new Funcionario();
        funcionario.setNombre(txtNombreEdit.getText().trim());
        funcionario.setApellido(txtApellidoEdit.getText().trim());
        funcionario.setSexo(txtSexoEdit.getText().trim());
        funcionario.setIdentificacionId(Integer.parseInt(txtTipoIdentificacionEdit.getText().trim()));
        funcionario.setEstadoCivilId(Integer.parseInt(txtEstadoCivilEdit.getText().trim()));
        funcionario.setDireccion(txtDireccionEdit.getText().trim());
        funcionario.setTelefono(txtTelefonoEdit.getText().trim());
        funcionario.setFechaNacimiento(txtFechaNacimientoEdit.getText().trim());

        int opt = JOptionPane.showConfirmDialog(null, "Desea actualizar el funcionario", "Confirmar salida",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (opt == 0) {
            try {
                funcionarioController.actualizarFuncionario(Integer.parseInt(txtFuncionarioId.getText()), funcionario);
                txtFuncionarioId.setText("");
                txtNombreEdit.setText("");
                txtApellidoEdit.setText("");
                txtSexoEdit.setText("");
                txtTipoIdentificacionEdit.setText("");
                txtEstadoCivilEdit.setText("");
                txtDireccionEdit.setText("");
                txtTelefonoEdit.setText("");
                txtFechaNacimiento.setText("");
                listFuncionarios();

                JOptionPane.showMessageDialog(null, "Se ha actualizado el funcionario con exito");
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                JOptionPane.showMessageDialog(null, "No fue posible actualizar el funcionario");
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        if (txtFuncionarioId.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un funcionario");
            txtFuncionarioId.requestFocus();
            return;
        }

        int opt = JOptionPane.showConfirmDialog(null, "Está seguro de eliminar este registro",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opt == 0) {
            try {
                funcionarioController.eliminarFuncionario(Integer.parseInt(txtFuncionarioId.getText()));
                txtFuncionarioId.setText("");
                txtNombreEdit.setText("");
                txtApellidoEdit.setText("");
                txtSexoEdit.setText("");
                txtTipoIdentificacionEdit.setText("");
                txtEstadoCivilEdit.setText("");
                txtDireccionEdit.setText("");
                txtTelefonoEdit.setText("");
                txtFechaNacimientoEdit.setText("");
                listFuncionarios();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro");

            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Funcionario> cbxFuncionarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPEdit;
    private javax.swing.JPanel jPFuncionario;
    private javax.swing.JPanel jPFuncionario1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTPanels;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblApellidoEdit;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDireccionEdit;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblEstadoCivilEdit;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblFechaNacimientoEdit;
    private javax.swing.JLabel lblFuncionarioId;
    private javax.swing.JLabel lblFuncionarios;
    private javax.swing.JLabel lblNombreEdit;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblSexoEdit;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefonoEdit;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTipoIdentificacionEdit;
    private javax.swing.JTable tblFuncionarios;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellidoEdit;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccionEdit;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtEstadoCivilEdit;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtFechaNacimientoEdit;
    private javax.swing.JTextField txtFuncionarioId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreEdit;
    private javax.swing.JTextField txtSexo;
    private javax.swing.JTextField txtSexoEdit;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefonoEdit;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtTipoIdentificacionEdit;
    // End of variables declaration//GEN-END:variables
}
