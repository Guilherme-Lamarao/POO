/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplicacao;

import Login.CadastroFrame;
import Login.LoginFrame;
import dao.BookDAO;
import dao.BookDAOJDBC;
import dao.DAOFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Book;
import dao.DAOGenerico;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
        

public class LibraryMain extends javax.swing.JFrame {

   private DefaultTableModel modelo;
    private BookDAO bookDAO;
    private String usuarioLogado;

    public LibraryMain(String usuarioLogado) {
        initComponents();
        this.usuarioLogado = usuarioLogado;
        User.setText(usuarioLogado); // Nome do usuário logado no JLabel
        bookDAO = new BookDAOJDBC();
        modelo = (DefaultTableModel) TableBook.getModel();
        preencherTabela();
    }

  private void preencherTabela() {
    List<Book> books = bookDAO.listar();

    // Verifica a seleção no ComboBox
    String criterio = (String) Boxclassificar.getSelectedItem();

    // Ordenar com base no critério
    switch (criterio) {
        case "Ultimos":
            books.sort((b1, b2) -> Integer.compare(b2.getCodigo(), b1.getCodigo())); // Ordena pelo código (ID) do livro
            break;
        case "Lançamento":
            books.sort((b1, b2) -> Integer.compare(b2.getAno(), b1.getAno())); // Ordena pelo ano de lançamento
            break;
        case "Usuario":
            books.sort((b1, b2) -> b1.getUsuario().compareTo(b2.getUsuario())); // Ordena alfabeticamente pelo nome do usuário que cadastrou
            break;
        case "Alfabetico":
            books.sort((b1, b2) -> b1.getTitle().compareTo(b2.getTitle())); // Ordena alfabeticamente pelo título do livro
           break;
        case "Genero":
            books.sort((b1, b2) -> b1.getGenre().compareToIgnoreCase(b2.getGenre()));
            break;
        default:
            break;
    }

    modelo.setRowCount(0); // Limpa a tabela antes de preencher

    for (Book book : books) {
        int PLidas = book.getPaglidas();
        int PTotais = book.getPagtotais();
        Float progress = PTotais > 0 ? ((float) PLidas / PTotais) * 100 : 0;

        modelo.addRow(new Object[]{
            book.getCodigo(),
            book.getTitle(),
            book.getAuthor(),
            book.getAno(),
            book.getGenre(),
            book.getEditora(),
            String.format("%.2f%%", progress), 
            book.getUsuario() // Mostra o nome do usuário que cadastrou o livro
        });
    }
}

    @SuppressWarnings("unchecked")
    
    
    
    
   

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableBook = new javax.swing.JTable();
        Sair = new javax.swing.JButton();
        JbtnApagar = new javax.swing.JButton();
        JBtnEditar = new javax.swing.JButton();
        jBtnNovo = new javax.swing.JButton();
        Deslogar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        User = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Boxclassificar = new javax.swing.JComboBox<>();
        refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));

        TableBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Code", "Titulo", "Autor", "Ano", "Genero", "Editora", "Progresso", "Usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableBook.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TableBookFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(TableBook);

        Sair.setText("Fechar");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });

        JbtnApagar.setText("Apagar");
        JbtnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnApagarActionPerformed(evt);
            }
        });

        JBtnEditar.setText("Editar");
        JBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBtnEditarActionPerformed(evt);
            }
        });

        jBtnNovo.setText("Novo");
        jBtnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoActionPerformed(evt);
            }
        });

        Deslogar.setText("Sair");
        Deslogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeslogarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ink Free", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setLabelFor(User);
        jLabel1.setText("Usuario:");
        jLabel1.setToolTipText("");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        User.setFont(new java.awt.Font("Ink Free", 0, 48)); // NOI18N
        User.setForeground(new java.awt.Color(255, 255, 255));
        User.setText("null");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Classificar como");

        Boxclassificar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ultimos", "Lançamento", "Usuario", "Alfabetico", "Genero" }));
        Boxclassificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxclassificarActionPerformed(evt);
            }
        });

        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JbtnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Boxclassificar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Deslogar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Deslogar)
                        .addComponent(jLabel4)
                        .addComponent(Boxclassificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Sair)
                        .addComponent(JbtnApagar)
                        .addComponent(JBtnEditar)
                        .addComponent(jBtnNovo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    private void JbtnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnApagarActionPerformed
       try {
           apagar();
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(LibraryMain.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(LibraryMain.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_JbtnApagarActionPerformed

    private void JBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtnEditarActionPerformed
        editar();
    }//GEN-LAST:event_JBtnEditarActionPerformed

    private void jBtnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoActionPerformed
        NewBook nb = new NewBook(null, usuarioLogado );
        nb.setVisible(true);
    }//GEN-LAST:event_jBtnNovoActionPerformed

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
System.exit(0);    }//GEN-LAST:event_SairActionPerformed

    private void TableBookFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TableBookFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_TableBookFocusLost

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
      preencherTabela();
    }//GEN-LAST:event_formWindowGainedFocus

    private void DeslogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeslogarActionPerformed
 try {
            LoginFrame loginScreen = new LoginFrame();
            loginScreen.setVisible(true);
            this.dispose(); // Fecha essa tela
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastroFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Erro ao abrir a tela de login");
        }
    }//GEN-LAST:event_DeslogarActionPerformed

    private void BoxclassificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxclassificarActionPerformed
        preencherTabela();
    }//GEN-LAST:event_BoxclassificarActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed

        preencherTabela();

    }//GEN-LAST:event_refreshActionPerformed

    
                                   

    private void apagar() throws ClassNotFoundException, SQLException {
        int selectedRow = TableBook.getSelectedRow();
        if (selectedRow >= 0) {
            int codigo = (int) TableBook.getValueAt(selectedRow, 0);
            String usuarioDoLivro = (String) TableBook.getValueAt(selectedRow, 7);

             if (usuarioLogado.equals(usuarioDoLivro) || usuarioLogado.equals("admin")) {
                bookDAO.apagar(codigo);
                preencherTabela();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Você só pode apagar livros que você cadastrou.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um livro para apagar.");
        }
    }
     
     private void editar() {
        int selectedRow = TableBook.getSelectedRow();
        if (selectedRow >= 0) {
            int codigo = (int) TableBook.getValueAt(selectedRow, 0);
            String usuarioDoLivro = (String) TableBook.getValueAt(selectedRow, 7);

           if (usuarioLogado.equals(usuarioDoLivro) || usuarioLogado.equals("admin")) {
                Book book = bookDAO.buscar(codigo);
                NewBook nb = new NewBook(book, usuarioLogado);
                nb.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Você só pode editar livros que você cadastrou.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um livro para editar.");
        }
    }


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(LibraryMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 new LibraryMain("UsuarioTest").setVisible(true);
            }
        });
    }

   

    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Boxclassificar;
    private javax.swing.JButton Deslogar;
    private javax.swing.JButton JBtnEditar;
    private javax.swing.JButton JbtnApagar;
    private javax.swing.JButton Sair;
    private javax.swing.JTable TableBook;
    private javax.swing.JLabel User;
    private javax.swing.JButton jBtnNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refresh;
    // End of variables declaration//GEN-END:variables
}
