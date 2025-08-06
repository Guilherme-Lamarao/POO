
package aplicacao;

import dao.BookDAO;
import dao.DAOFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Book;
import dao.DAOGenerico;
        


public class LibraryMain extends javax.swing.JFrame {

    BookDAO bookDAO = DAOFactory.criarBookDAO();
    DefaultTableModel modelo = null;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public LibraryMain() {
        initComponents();
        modelo = (DefaultTableModel) TableBook.getModel();
        preencherTabela();
    }

 private void preencherTabela() {
        modelo.getDataVector().clear();
        try {
            for (Book book : bookDAO.listar()) { 
                modelo.addRow(new Object[]{
                    book.getCodigo(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getGenre(), 
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao preencher a tabela.");
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        TableBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Code", "Titulo", "Autor", "Genero"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        Sair.setText("Sair");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 150, Short.MAX_VALUE)
                .addComponent(jBtnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JbtnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sair)
                    .addComponent(JbtnApagar)
                    .addComponent(JBtnEditar)
                    .addComponent(jBtnNovo)))
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
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    private void JbtnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnApagarActionPerformed
       apagar();
    }//GEN-LAST:event_JbtnApagarActionPerformed

    private void JBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtnEditarActionPerformed
        editar();
    }//GEN-LAST:event_JBtnEditarActionPerformed

    private void jBtnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoActionPerformed
        NewBook nb = new NewBook(null);
        nb.setVisible(true);
    }//GEN-LAST:event_jBtnNovoActionPerformed

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
System.exit(0);    }//GEN-LAST:event_SairActionPerformed

    private void TableBookFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TableBookFocusLost
        
    }//GEN-LAST:event_TableBookFocusLost

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
      preencherTabela();
    }//GEN-LAST:event_formWindowGainedFocus

    
                                   

    private void apagar() {
        try {
            int selectedRow = TableBook.getSelectedRow();
            if (selectedRow >= 0) {
                Integer codigo = (Integer) modelo.getValueAt(selectedRow, 0);

                int linha = bookDAO.apagar(codigo);
                if (linha > 0) {
                    modelo.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(this, "Item excluído com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, selecione uma linha.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao tentar apagar o item.");
        }
    }
     
     private void editar() {
        try {
            int selectedRow = TableBook.getSelectedRow();
            if (selectedRow >= 0) {
                
                String title = (String) modelo.getValueAt(selectedRow, 1);
                String author = (String) modelo.getValueAt(selectedRow, 2);
                String genero = (String) modelo.getValueAt(selectedRow, 3);                
                Integer codigo = (Integer) modelo.getValueAt(selectedRow, 0);
                
                Book book = new Book();
                book.setCodigo(codigo);
                book.setTitle(title);
                book.setAuthor(author);
                book.setGenre(genero);

                new NewBook(book).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, selecione uma linha.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao tentar editar o item.");
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
                new LibraryMain().setVisible(true);
            }
        });
    }

   

    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBtnEditar;
    private javax.swing.JButton JbtnApagar;
    private javax.swing.JButton Sair;
    private javax.swing.JTable TableBook;
    private javax.swing.JButton jBtnNovo;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
