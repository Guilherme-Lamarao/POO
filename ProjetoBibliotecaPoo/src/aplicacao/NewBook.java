package aplicacao;

import dao.BookDAO;
import dao.DAOFactory;
import javax.swing.JOptionPane;
import modelo.Book;

public class NewBook extends javax.swing.JFrame {

    Book book;
    BookDAO bookDAO = DAOFactory.criarBookDAO();
    
    public NewBook(Book book) {
        initComponents();
        
        this.book = book;
        if (this.book != null) {
            btnOk.setText("Editar");
            txtTitle.setText(this.book.getTitle());
            txtAuthor.setText(this.book.getAuthor());          
            BoxListaGenero.setSelectedItem(this.book.getGenre());            
        } else {
            btnOk.setText("Inserir");
        }
    }

 
   
     
    @SuppressWarnings("unchecked")


private void inserir() {
    Book bookNew = new Book();
    bookNew.setTitle(txtTitle.getText());
    bookNew.setAuthor(txtAuthor.getText());
    bookNew.setGenre(BoxListaGenero.getSelectedItem().toString());

    int linha = bookDAO.inserir(bookNew);
    if (linha > 0) {
        JOptionPane.showMessageDialog(this, "Livro inserido com sucesso!");
    } else {
        JOptionPane.showMessageDialog(this, "Erro ao inserir livro.");
    }
}

private void editar() {
    Book bookEditado = new Book();
    bookEditado.setCodigo(book.getCodigo());
    bookEditado.setTitle(txtTitle.getText());
    bookEditado.setAuthor(txtAuthor.getText());
    bookEditado.setGenre(BoxListaGenero.getSelectedItem().toString());

    int linha = bookDAO.editar(bookEditado);
    if (linha > 0) {
        JOptionPane.showMessageDialog(this, "Livro editado com sucesso!");
    } else {
        JOptionPane.showMessageDialog(this, "Erro ao editar livro.");
    }
}


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jOptionPane2 = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        txtTitle = new javax.swing.JTextField();
        txtAuthor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        BoxListaGenero = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitleActionPerformed(evt);
            }
        });

        jLabel1.setText("Titulo");

        jLabel2.setText("Autor");

        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        BoxListaGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Outro", "Terror", "Ficçao Cientifica", "Aventura", "Suspense", "Fantasia", "Romance", "Poesia", "Nao-Ficçao", "Comedia", "Distopia", "Informativo" }));
        BoxListaGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxListaGeneroActionPerformed(evt);
            }
        });

        jLabel4.setText("Genero");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(BoxListaGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(BoxListaGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancelar)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
      private void cancelar() {
        Object[] opcao = {"Não", "Sim"};
        int opcaoSelecionada = JOptionPane.showOptionDialog(this, "Deseja realmente sair?", "Aviso",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opcao, opcao[0]);
        if (opcaoSelecionada == 1) {
            this.dispose();
        }
    }


    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
     if (this.book != null) {
            editar();
        } else {
            inserir();
        }
        this.dispose();
    }//GEN-LAST:event_btnOkActionPerformed

    private void txtTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitleActionPerformed

    private void BoxListaGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxListaGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxListaGeneroActionPerformed

   
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(NewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewBook(null).setVisible(true);
            }
        });
    }

      
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxListaGenero;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JOptionPane jOptionPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
