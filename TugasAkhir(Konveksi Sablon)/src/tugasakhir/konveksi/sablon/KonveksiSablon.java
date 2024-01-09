/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tugasakhir.konveksi.sablon;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Daffa Lintang
 */
public class KonveksiSablon extends javax.swing.JFrame {
Koneksi koneksi = new Koneksi();
String Tanggal;
private DefaultTableModel model;
private DefaultTableModel modelCst;
private DefaultTableModel modelKasir;
private DefaultTableModel modelPSA;

private void autoNumberBarang() {   
    try{
        Connection c = koneksi.getKoneksi();
        java.sql.Statement s = c.createStatement();
        String sql = "SELECT * FROM `inputbarang` ORDER BY Kode_Barang DESC";
        ResultSet r = s.executeQuery(sql);
        if(r.next()){
        String NoFaktur = r.getString("Kode_Barang").substring(2);
        String BR = "" +(Integer.parseInt(NoFaktur)+1);
        String Nol = "";
        
        if (BR.length() ==1){
            Nol = "00";
        } else if (BR.length() ==2){
            Nol = "0";
        } else if (BR.length() == 3){
            Nol = "";
        }
        txtKodebarang.setText("B"+Nol+BR);
        } else {
            txtKodebarang.setText("B001");
        }
        r.close();
        s.close();
    } catch(Exception e){
        System.out.println("autonumber error");
    }
}

private void autoNumberCustomer() {
    try{
        Connection c = koneksi.getKoneksi();
        java.sql.Statement s = c.createStatement();
        String sql = "SELECT * FROM `inputCustomer` ORDER BY ID_Customer DESC";
        ResultSet r = s.executeQuery(sql);
        if(r.next()){
        String NoFaktur = r.getString("ID_Customer").substring(2);
        String BR = "" +(Integer.parseInt(NoFaktur)+1);
        String Nol = "";
        
        if (BR.length() ==1){
            Nol = "00";
        } else if (BR.length() ==2){
            Nol = "0";
        } else if (BR.length() == 3){
            Nol = "";
        }
        txtIdCustomer.setText("C"+Nol+BR);
        } else {
            txtIdCustomer.setText("C001");
        }
        r.close();
        s.close();
    } catch(Exception e){
        System.out.println(e);
    }
}

public void clear(){
    txtNamaBarang.setText("");
    txtHargaBeli.setText("");
    txtHargaJual.setText("");
    txtNamaCustomer.setText("");
    txtNomorHp.setText("");
    txTotalBayar.setText("0");
    txBayar.setText("0");
    txKembalian.setText("0");
}
public void clear2(){
    txIDBarang.setText("");
    txHarga.setText("");
    txJumlah.setText("");
}

public void loadDataBarang(){
    model.getDataVector().removeAllElements();
    model.fireTableDataChanged();
    
    try{
        Connection c = koneksi.getKoneksi();
        java.sql.Statement s = c.createStatement();
        
        String sql = "SELECT * FROM InputBarang";
        ResultSet r = s.executeQuery(sql);
        
        while(r.next()){
            Object[] obj = new Object[6];
            obj [0] = r.getString("Kode_Barang");
            obj [1] = r.getString("Nama_Barang");
            obj [2] = r.getString("Jenis_Barang");
            obj [3] = r.getString("Ukuran");
            obj [4] = r.getString("Harga_Beli");
            obj [5] = r.getString("Harga_Jual");
            
            model.addRow(obj);
        }
        r.close();
        s.close();
    }catch(Exception e){
        System.out.println("load data error");
    }
}

public void loadDataPSA(){
    modelPSA.getDataVector().removeAllElements();
    modelPSA.fireTableDataChanged();
    
    try{
        Connection c = koneksi.getKoneksi();
        java.sql.Statement s = c.createStatement();
        
        String sql = "SELECT * FROM psa";
        ResultSet r = s.executeQuery(sql);
        
        while(r.next()){
            Object[] obj = new Object[8];
            obj [0] = r.getString("No_Transaksi");
            obj [1] = r.getString("Nama_Customer");
            obj [2] = r.getString("No_HP");
            obj [3] = r.getString("Kode_Barang");
            obj [4] = r.getString("Jumlah");
            obj [5] = r.getString("Deadline");
            obj [6] = r.getString("Status");
            obj [7] = r.getString("Last_Update");            
            modelPSA.addRow(obj);
        }
        r.close();
        s.close();
    }catch(Exception e){
        System.out.println(e);
    }
}

public void loadDataCustomer(){
    modelCst.getDataVector().removeAllElements();
    modelCst.fireTableDataChanged();
    
    try{
        Connection c = koneksi.getKoneksi();
        java.sql.Statement s = c.createStatement();
        
        String sql = "SELECT * FROM InputCustomer";
        ResultSet r = s.executeQuery(sql);
        
        while(r.next()){
            Object[] obj = new Object[3];
            obj [0] = r.getString("Id_Customer");
            obj [1] = r.getString("Nama_Customer");
            obj [2] = r.getString("No_Hp");
            
            modelCst.addRow(obj);
        }
        r.close();
        s.close();
    }catch(Exception e){
        System.out.println("load data error");
    }
}

public void cariDataBarang(){
    DefaultTableModel tabel = new DefaultTableModel();
    tabel.addColumn("Kode_Barang");
    tabel.addColumn("Nama_Barang");
    tabel.addColumn("Jenis_Barang");
    tabel.addColumn("Ukuran");
    tabel.addColumn("Harga_Beli");
    tabel.addColumn("Harga_Jual");
    
    try{
        Connection c = koneksi.getKoneksi();
        String sql = "SELECT * FROM InputBarang WHERE Kode_Barang LIKE '%" + txtCariData.getText() + "%' OR Nama_Barang LIKE '%" + txtCariData.getText() + "%'";
        java.sql.Statement s = c.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while(rs.next()){
            tabel.addRow(new Object[]{
               rs.getString(1),
               rs.getString(2),
               rs.getString(3),
               rs.getString(4),
               rs.getString(5),
               rs.getString(6),
            });
        }
        tabelInputBarang.setModel(tabel);
        loadDataBarang();
    }catch(Exception e){
        System.out.println(e);
    }finally{
    }
}

public void cariDataCustomer(){
    DefaultTableModel tabel = new DefaultTableModel();
    tabel.addColumn("ID_Customer");
    tabel.addColumn("Nama");
    tabel.addColumn("Nomor_Hp");
    
    try{
        Connection c = koneksi.getKoneksi();
        String sql = "SELECT * FROM InputCustomer WHERE ID_Customer LIKE '%" + txtCariCustomer.getText() + "%' OR Nama_Customer LIKE '%" + txtCariCustomer.getText() + "%'";
        java.sql.Statement s = c.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while(rs.next()){
            tabel.addRow(new Object[]{
               rs.getString(1),
               rs.getString(2),
               rs.getString(3),
            });
        }
        tabelCustomer.setModel(tabel);
        loadDataCustomer();
    }catch(Exception e){
        System.out.println(e);
    }finally{
    }
}


public void totalBiaya(){
    int jumlahBaris = jTabel1.getRowCount();
    int totalBiaya = 0;
    int jumlahBarang, hargaBarang;
    for (int i = 0; i < jumlahBaris; i++){
        jumlahBarang = Integer.parseInt(jTabel1.getValueAt(i, 3).toString());
        hargaBarang = Integer.parseInt(jTabel1.getValueAt(i, 4).toString());
        totalBiaya = totalBiaya + (jumlahBarang * hargaBarang);
    }
    txTotalBayar.setText(String.valueOf(totalBiaya));
    txTampil.setText("Rp "+ totalBiaya +",00");
}

private void autoNumberKasir(){
    try {
        Connection c = koneksi.getKoneksi();
        java.sql.Statement s = c.createStatement();
        String sql = "SELECT * FROM kasir ORDER BY No_Transaksi DESC";
        ResultSet r = s.executeQuery(sql);
        if (r.next()){
            String No_Transaksi = r.getString("No_Transaksi").substring(2);
            String TR = "" +(Integer.parseInt(No_Transaksi)+1);
            String No1 = "";
            
            if(TR.length()==1)
            {No1 = "000";}
            else if (TR.length()==2)
            {No1 = "00"; }
            else if (TR.length()==3)
            {No1 = "0"; }
            else if (TR.length()==3)
            {No1 = ""; 
            txTransaksi.setText("TR" + No1 + TR);
            } else {
                txTransaksi.setText("TR001");
            }
            r.close();
            s.close();
        }
    } catch (Exception e){ 
        System.out.println(e);
}
}
//    /**
//     * Creates new form KonveksiSablon
//     */

public void loadData(){
    DefaultTableModel modelKasir = (DefaultTableModel) jTabel1.getModel();
    modelKasir.addRow(new Object[]{
        txTransaksi.getText(),
        txIDBarang.getText(),
        txNamaCustomer.getText(),
        txJumlah.getText(),
        txHarga.getText(),
        txTotalBayar.getText(),
        txProses.getText(),
        txDeadline.getText()
    });
}

public void kosong(){
    DefaultTableModel modelKasir = (DefaultTableModel) jTabel1.getModel();
    
    while (modelKasir.getRowCount()>0){
        modelKasir.removeRow(0);
    }
} 
public void utama(){
    txTransaksi.setText("");
        txIDBarang.setText("");
        txNamaCustomer.setText("");
        txJumlah.setText("");
        txHarga.setText("");
        txTotalBayar.setText("");
        txProses.setText("");
        txDeadline.setText("");
        autoNumberKasir();
}
public void tambahTransaksi(){
    int jumlah, harga, total;
    
    jumlah = Integer.valueOf(txJumlah.getText());
    harga = Integer.valueOf(txHarga.getText());
    total = jumlah * harga;
    
    txTotalBayar.setText(String.valueOf(total));
    
    loadData();
    totalBiaya();
    clear2();
    txIDBarang.requestFocus();
    
   
}

    public KonveksiSablon() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        modelPSA = new DefaultTableModel();
        modelKasir = new DefaultTableModel();
        model = new DefaultTableModel();
        modelCst = new DefaultTableModel();
        
        
        tabelInputBarang.setModel(model);
        tabelCustomer.setModel(modelCst);
        jTabel1.setModel(modelKasir);
        tabelPSA.setModel(modelPSA);
        
        //Kasir
        modelKasir.addColumn("No_Transaksi");
        modelKasir.addColumn("IDBarang");
        modelKasir.addColumn("Tanggal_Proses");
        modelKasir.addColumn("Tanggal_Deadline");
        modelKasir.addColumn("Jumlah");
        modelKasir.addColumn("Harga");
        modelKasir.addColumn("Total");
        
         utama();
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        
        txProses.setText(s.format(date));
        txDeadline.setText(s.format(date));
        txTotalBayar.setText("0");
        txBayar.setText("0");
        txKembalian.setText("0");
        txNamaCustomer.requestFocus();
        
       //PSA
      modelPSA.addColumn("No Transaksi");
      modelPSA.addColumn("Nama");
      modelPSA.addColumn("No HP");
      modelPSA.addColumn("Kode Barang");
      modelPSA.addColumn("Jumlah");
      modelPSA.addColumn("Deadline");
      modelPSA.addColumn("Status");
      modelPSA.addColumn("Last Updated"); 
      modelPSA.addColumn("Edit");  
      loadDataPSA();
     
        
        //InputBarang
        model.addColumn("Kode_Barang");
        model.addColumn("Nama_Barang");
        model.addColumn("Jenis_Barang");
        model.addColumn("Ukuran");
        model.addColumn("Harga_Beli");
        model.addColumn("Harga_Jual");
        
        loadDataBarang();
        autoNumberBarang();
        btnHapus.setEnabled(false);
        
        // InputCustomer
        modelCst.addColumn("Id_Customer");
        modelCst.addColumn("Nama");
        modelCst.addColumn("Nomor_Hp");
        loadDataCustomer();
        autoNumberCustomer();
        btnHapusCustomer.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new RoundedPanel(10);
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txTransaksi = new RoundedJTextField(15);
        txProses = new RoundedJTextField(15);
        txDeadline = new RoundedJTextField(15);
        txNamaCustomer = new RoundedJTextField(15);
        jButton6 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabel1 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        txTampil = new RoundedJTextField(15);
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txTotalBayar = new RoundedJTextField(15);
        txBayar = new RoundedJTextField(15);
        txKembalian = new RoundedJTextField(15);
        jLabel14 = new javax.swing.JLabel();
        txIDBarang = new RoundedJTextField(15);
        jButton10 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txHarga = new RoundedJTextField(15);
        jLabel16 = new javax.swing.JLabel();
        txJumlah = new RoundedJTextField(15);
        PSA = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelPSA = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new RoundedPanel(10);
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtKodebarang = new RoundedJTextField(15);
        txtHargaBeli = new RoundedJTextField(15);
        txtHargaJual = new RoundedJTextField(15);
        txtNamaBarang = new RoundedJTextField(15);
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtCariData = new RoundedJTextField(15);
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        cmbUkuran = new javax.swing.JComboBox<>();
        cmbJenisBarang = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelInputBarang = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel9 = new RoundedPanel(10);
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCariCustomer = new RoundedJTextField(15);
        txtNomorHp = new RoundedJTextField(15);
        txtIdCustomer = new RoundedJTextField(15);
        txtNamaCustomer = new RoundedJTextField(15);
        jLabel32 = new javax.swing.JLabel();
        btnHapusCustomer = new javax.swing.JButton();
        btnTambahCustomer = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelCustomer = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(37, 37, 37));
        jPanel1.setForeground(new java.awt.Color(37, 37, 37));

        jButton1.setBackground(new java.awt.Color(37, 37, 37));
        jButton1.setForeground(new java.awt.Color(37, 37, 37));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1 putih (3).png"))); // NOI18N
        jButton1.setOpaque(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(37, 37, 37));
        jButton2.setForeground(new java.awt.Color(37, 37, 37));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/3 putih.png"))); // NOI18N
        jButton2.setOpaque(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(37, 37, 37));
        jButton3.setForeground(new java.awt.Color(37, 37, 37));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/4 putih.png"))); // NOI18N
        jButton3.setOpaque(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(37, 37, 37));
        jButton4.setForeground(new java.awt.Color(37, 37, 37));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/2 putih.png"))); // NOI18N
        jButton4.setOpaque(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(37, 37, 37));
        jButton5.setForeground(new java.awt.Color(37, 37, 37));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/5 putih.png"))); // NOI18N
        jButton5.setOpaque(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton4)
                                .addComponent(jButton2)
                                .addComponent(jButton3))
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(303, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 570));

        jPanel2.setBackground(new java.awt.Color(17, 17, 17));
        jPanel2.setForeground(new java.awt.Color(17, 17, 17));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Kasir");

        PSA.setOpaque(false);
        jPanel7.setBackground(new java.awt.Color(37, 37, 37));
        jPanel7.setForeground(new java.awt.Color(37, 37, 37));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nama Customer");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tanggal Proses");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tanggal Deadline");

        txTransaksi.setForeground(new java.awt.Color(37, 37, 37));

        txProses.setForeground(new java.awt.Color(37, 37, 37));
        txProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txProsesActionPerformed(evt);
            }
        });

        txDeadline.setForeground(new java.awt.Color(37, 37, 37));

        txNamaCustomer.setForeground(new java.awt.Color(37, 37, 37));

        jButton6.setBackground(new java.awt.Color(97, 97, 97));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Cari");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("No Transaksi");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10))
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txNamaCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(37, 37, 37)
                        .addComponent(txProses, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(92, 92, 92))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txProses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel9)
                        .addComponent(txDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txNamaCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTabel1.setForeground(new java.awt.Color(37, 37, 37));
        jTabel1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No_Transaksi", "Nama_Customer", "Tanggal_Proses", "Tanggal_Deadline", "Kode_Barang", "Jumlah", "Harga", "Total"
            }
        ));
        jTabel1.setSelectionForeground(new java.awt.Color(37, 37, 37));
        jScrollPane1.setViewportView(jTabel1);

        jButton7.setBackground(new java.awt.Color(97, 97, 97));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Hapus");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(97, 97, 97));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Tambah");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(97, 97, 97));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton9.setText("SIMPAN");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        txTampil.setForeground(new java.awt.Color(37, 37, 37));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Total Bayar");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Bayar");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Kembalian");

        txTotalBayar.setForeground(new java.awt.Color(37, 37, 37));
        txTotalBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txTotalBayarActionPerformed(evt);
            }
        });

        txBayar.setForeground(new java.awt.Color(37, 37, 37));
        txBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txBayarActionPerformed(evt);
            }
        });

        txKembalian.setForeground(new java.awt.Color(37, 37, 37));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Kode Barang");

        txIDBarang.setForeground(new java.awt.Color(37, 37, 37));

        jButton10.setBackground(new java.awt.Color(97, 97, 97));
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Cari");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Harga");

        txHarga.setForeground(new java.awt.Color(37, 37, 37));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Jumlah");

        txJumlah.setForeground(new java.awt.Color(37, 37, 37));
        txJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txJumlahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(357, 357, 357)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addGap(388, 388, 388))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txTampil, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(120, 120, 120))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txIDBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel14))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(txHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txIDBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txTampil, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))))
                .addGap(23, 23, 23))
        );

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel13.setBackground(new java.awt.Color(17, 17, 17));
        jPanel13.setForeground(new java.awt.Color(17, 17, 17));

        jPanel14.setBackground(new java.awt.Color(17, 17, 17));
        jPanel14.setForeground(new java.awt.Color(17, 17, 17));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Proses Status Admin");

        jScrollPane4.setBackground(new java.awt.Color(37, 37, 37));
        jScrollPane4.setForeground(new java.awt.Color(37, 37, 37));

        tabelPSA.setForeground(new java.awt.Color(37, 37, 37));
        tabelPSA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Transaksi", "Nama", "No HP", "Kode Barang", "Jumlah", "Deadline", "Status", "Last Updated", "Edit"
            }
        ));
        tabelPSA.setSelectionForeground(new java.awt.Color(37, 37, 37));
        jScrollPane4.setViewportView(tabelPSA);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 575, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout PSALayout = new javax.swing.GroupLayout(PSA);
        PSA.setLayout(PSALayout);
        PSALayout.setHorizontalGroup(
            PSALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PSALayout.setVerticalGroup(
            PSALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", PSA);

        jPanel4.setBackground(new java.awt.Color(17, 17, 17));
        jPanel4.setForeground(new java.awt.Color(17, 17, 17));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Histori");

        jScrollPane2.setBackground(new java.awt.Color(37, 37, 37));
        jScrollPane2.setForeground(new java.awt.Color(37, 37, 37));

        jTable2.setBackground(new java.awt.Color(37, 37, 37));
        jTable2.setForeground(new java.awt.Color(37, 37, 37));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Transaksi", "txtNamaCustomer Customer", "Nomor HP", "Kode Barang", "Kode Barang", "Jumlah", "Deadline", "Status", "Harga", "Total"
            }
        ));
        jTable2.setSelectionForeground(new java.awt.Color(37, 37, 37));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(392, 392, 392)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", jPanel4);

        jPanel8.setBackground(new java.awt.Color(17, 17, 17));
        jPanel8.setForeground(new java.awt.Color(17, 17, 17));

        PSA.setOpaque(false);
        jPanel10.setBackground(new java.awt.Color(37, 37, 37));
        jPanel10.setForeground(new java.awt.Color(37, 37, 37));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Nama Barang");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Harga Jual");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Harga Beli");

        txtKodebarang.setForeground(new java.awt.Color(37, 37, 37));

        txtHargaBeli.setForeground(new java.awt.Color(37, 37, 37));
        txtHargaBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaBeliActionPerformed(evt);
            }
        });

        txtHargaJual.setForeground(new java.awt.Color(37, 37, 37));

        txtNamaBarang.setForeground(new java.awt.Color(37, 37, 37));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Kode Barang");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Ukuran");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Jenis Barang");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Cari Data");

        txtCariData.setForeground(new java.awt.Color(37, 37, 37));
        txtCariData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariDataActionPerformed(evt);
            }
        });
        txtCariData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariDataKeyTyped(evt);
            }
        });

        btnSimpan.setBackground(new java.awt.Color(97, 97, 97));
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(97, 97, 97));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        cmbUkuran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "M", "L", "XL", "XXL", "XXXL", "-" }));

        cmbJenisBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baju", "Aksesoris", "Banner" }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(23, 23, 23)
                        .addComponent(txtNamaBarang))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(28, 28, 28))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel23))
                                .addGap(30, 30, 30)))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKodebarang, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(cmbJenisBarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbUkuran, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(37, 37, 37)
                        .addComponent(txtCariData, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addComponent(btnSimpan)
                .addGap(18, 18, 18)
                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKodebarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtCariData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(cmbJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(cmbUkuran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Input Barang");

        tabelInputBarang.setForeground(new java.awt.Color(37, 37, 37));
        tabelInputBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Barang", "Nama Barang", "Jenis Barang", "Ukuran", "Harga Beli", "Harga Jual"
            }
        ));
        tabelInputBarang.setSelectionForeground(new java.awt.Color(37, 37, 37));
        tabelInputBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelInputBarangMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabelInputBarang);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane5)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(405, 405, 405)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", jPanel5);

        jPanel12.setBackground(new java.awt.Color(17, 17, 17));
        jPanel12.setForeground(new java.awt.Color(17, 17, 17));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Input Customer");

        PSA.setOpaque(false);
        jPanel9.setBackground(new java.awt.Color(37, 37, 37));
        jPanel9.setForeground(new java.awt.Color(37, 37, 37));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Nama");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Nomor_HP");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Id_Customer");

        txtCariCustomer.setForeground(new java.awt.Color(37, 37, 37));
        txtCariCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariCustomerActionPerformed(evt);
            }
        });
        txtCariCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariCustomerKeyTyped(evt);
            }
        });

        txtNomorHp.setForeground(new java.awt.Color(37, 37, 37));
        txtNomorHp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomorHpActionPerformed(evt);
            }
        });

        txtIdCustomer.setForeground(new java.awt.Color(37, 37, 37));

        txtNamaCustomer.setForeground(new java.awt.Color(37, 37, 37));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Cari Data");

        btnHapusCustomer.setBackground(new java.awt.Color(97, 97, 97));
        btnHapusCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnHapusCustomer.setText("Hapus");
        btnHapusCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusCustomerActionPerformed(evt);
            }
        });

        btnTambahCustomer.setBackground(new java.awt.Color(97, 97, 97));
        btnTambahCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnTambahCustomer.setText("Tambah");
        btnTambahCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(btnTambahCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapusCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addGap(47, 47, 47)
                                .addComponent(txtCariCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtIdCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel30)
                        .addGap(47, 47, 47)
                        .addComponent(txtNamaCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(txtNomorHp, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(txtCariCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel32)))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtIdCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(txtNamaCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(txtNomorHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapusCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambahCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tabelCustomer.setForeground(new java.awt.Color(37, 37, 37));
        tabelCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id_Customer", "Nama", "Nomor_Hp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelCustomer.setSelectionForeground(new java.awt.Color(37, 37, 37));
        tabelCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelCustomerMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelCustomer);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addGap(339, 339, 339))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab5", jPanel6);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, -40, 900, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton1MouseClicked

    private void txProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txProsesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txProsesActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelKasir = (DefaultTableModel)jTabel1.getModel();
        int row = jTabel1.getSelectedRow();
        model.removeRow(row);
        totalBiaya();
        txBayar.setText("0");
        txKembalian.setText("0");
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        tambahTransaksi();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txtNomorHpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomorHpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomorHpActionPerformed

    private void btnHapusCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusCustomerActionPerformed
        // TODO add your handling code here:
       int i = tabelCustomer.getSelectedRow();
        if (i == -1){
            return;
        }
        
        String id = (String) modelCst.getValueAt(i,0);
        int pernyataan = JOptionPane.showConfirmDialog(null, "Yakin Ingin Menghapus Data", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(pernyataan == JOptionPane.OK_OPTION){
            try{
               Connection c = koneksi.getKoneksi();
               String sql = "DELETE FROM InputCustomer Where ID_Customer = ?";
                java.sql.PreparedStatement p = c.prepareStatement(sql);
               p.setString(1, id);
               p.executeUpdate();
               p.close();
               JOptionPane.showMessageDialog(null, "Data Terhapus");
            
            }catch(Exception e){
        System.out.println(e);
        } finally{
                btnTambahCustomer.setEnabled(true);
                btnHapusCustomer.setEnabled(false);
                loadDataCustomer();
                autoNumberCustomer();
                clear();
            }
     } 
        else if(pernyataan == JOptionPane.CANCEL_OPTION){
            
        }
    }//GEN-LAST:event_btnHapusCustomerActionPerformed

    private void btnTambahCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahCustomerActionPerformed
        // TODO add your handling code here:
        String IdCustomer = txtIdCustomer.getText();
        String nama = txtNamaCustomer.getText();
        String NomorHp = txtNomorHp.getText();
      
        
        try{
            Connection c = koneksi.getKoneksi();
            String sql = "INSERT INTO InputCustomer VALUES (?,?,?)";
            java.sql.PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, IdCustomer);
            p.setString(2, nama);
            p.setString(3, NomorHp);
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data Tersimpan");
            loadDataCustomer();
        }catch(Exception e){
        System.out.println(e);
        } finally{
            autoNumberCustomer();
            clear();
        }
    }//GEN-LAST:event_btnTambahCustomerActionPerformed

    private void txtHargaBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaBeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaBeliActionPerformed

    private void txtCariDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariDataActionPerformed
        // TODO add your handling code here:
        cariDataBarang();
    }//GEN-LAST:event_txtCariDataActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        String kodeBarang = txtKodebarang.getText();
        String nama = txtNamaBarang.getText();
        String jenis = (String)cmbJenisBarang.getSelectedItem();
        String ukuran = (String)cmbUkuran.getSelectedItem();
        String hargaBeli = txtHargaBeli.getText();
        String hargaJual = txtHargaJual.getText();
        
        try{
            Connection c = koneksi.getKoneksi();
            String sql = "INSERT INTO InputBarang VALUES (?,?,?,?,?,?)";
            java.sql.PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, kodeBarang);
            p.setString(2, nama);
            p.setString(3, jenis);
            p.setString(4, ukuran);
            p.setString(5, hargaBeli);
            p.setString(6, hargaJual);
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data Tersimpan");
            loadDataBarang();
        }catch(Exception e){
        System.out.println(e);
        } finally{
            autoNumberBarang();
            clear();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int i = tabelInputBarang.getSelectedRow();
        if (i == -1){
            return;
        }
        
        String id = (String) model.getValueAt(i,0);
        int pernyataan = JOptionPane.showConfirmDialog(null, "Yakin Ingin Menghapus Data", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(pernyataan == JOptionPane.OK_OPTION){
            try{
               Connection c = koneksi.getKoneksi();
               String sql = "DELETE FROM InputBarang Where Kode_Barang = ?";
                java.sql.PreparedStatement p = c.prepareStatement(sql);
               p.setString(1, id);
               p.executeUpdate();
               p.close();
               JOptionPane.showMessageDialog(null, "Data Terhapus");
            }catch(Exception e){
        System.out.println(e);
        } finally{
                btnSimpan.setEnabled(true);
                btnHapus.setEnabled(false);
                loadDataBarang();
                autoNumberBarang();
                clear();
            }
     } 
        else if(pernyataan == JOptionPane.CANCEL_OPTION){
            
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tabelInputBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelInputBarangMouseClicked
        // TODO add your handling code here:
//        btnSimpan.setEnabled(false);
        btnHapus.setEnabled(true);
        
        int i = tabelInputBarang.getSelectedRow();
        if(i == -1){
            return;
        }
        
        String kodeBarang = (String) model.getValueAt(i, 0);
        String namaBarang = (String) model.getValueAt(i, 1);
        String jenis = (String) model.getValueAt(i, 2);
        String ukuran = (String) model.getValueAt(i, 3);
        String hargaBeli = (String) model.getValueAt(i, 4);
        String hargaJual = (String) model.getValueAt(i, 5);
        
        txtKodebarang.setText(kodeBarang);
        txtNamaBarang.setText(namaBarang);
        cmbJenisBarang.setSelectedItem(jenis);
        cmbUkuran.setSelectedItem(ukuran);
        txtHargaBeli.setText(hargaBeli);
        txtHargaJual.setText(hargaJual);
    }//GEN-LAST:event_tabelInputBarangMouseClicked

    private void txtCariDataKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariDataKeyTyped
        // TODO add your handling code here:
        cariDataBarang();
    }//GEN-LAST:event_txtCariDataKeyTyped

    private void tabelCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelCustomerMouseClicked
        // TODO add your handling code here:
//        btnTambahCustomer.setEnabled(false);
        btnHapusCustomer.setEnabled(true);
        
        int i = tabelInputBarang.getSelectedRow();
        if(i == -1){
            return;
        }
        
        String idCustomer = (String) model.getValueAt(i, 0);
        String namaCustomer = (String) model.getValueAt(i, 1);
        String nomorHp = (String) model.getValueAt(i, 2);
       
        
        txtIdCustomer.setText(idCustomer);
        txtNamaCustomer.setText(namaCustomer);
        txtNomorHp.setText(nomorHp);
       
    }//GEN-LAST:event_tabelCustomerMouseClicked

    private void txtCariCustomerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariCustomerKeyTyped
        // TODO add your handling code here:
        cariDataCustomer();
    }//GEN-LAST:event_txtCariCustomerKeyTyped

    private void txtCariCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariCustomerActionPerformed
        // TODO add your handling code here:
        cariDataCustomer();
    }//GEN-LAST:event_txtCariCustomerActionPerformed

    private void txJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txJumlahActionPerformed
        // TODO add your handling code here:
        tambahTransaksi();
    }//GEN-LAST:event_txJumlahActionPerformed

    private void txBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txBayarActionPerformed
        // TODO add your handling code here:
        int total, bayar, kembalian;
        
        total = Integer.valueOf(txTotalBayar.getText());
        bayar = Integer.valueOf(txBayar.getText());
        
        if (total > bayar){
            JOptionPane.showMessageDialog(null,"Uang tidak cukup untuk melakukan pembayaran");
        } else {
            kembalian = bayar - total;
            txKembalian.setText(String.valueOf(kembalian));
        }
    }//GEN-LAST:event_txBayarActionPerformed
    
    private void txTotalBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTotalBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txTotalBayarActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelKasir = (DefaultTableModel)jTabel1.getModel();
        
        String No_Transaksi = txTransaksi.getText();
        String Tanggal_Proses = txProses.getText();
        String Tanggal_Deadline = txDeadline.getText();
        String Nama_Customer = txNamaCustomer.getText();
        String KodeBarang = txIDBarang.getText();
        String Harga = txHarga.getText();
        String Jumlah = txHarga.getText();
        String Total = txTotalBayar.getText();
        
        try {
            Connection c = koneksi.getKoneksi();
            String sql = "INSERT INTO Kasir VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            java.sql.PreparedStatement p = c.prepareStatement(sql);
            p.setString(1,No_Transaksi);
            p.setString(2, Tanggal_Proses);
            p.setString(3, Tanggal_Deadline);
            p.setString(4, Nama_Customer);
            p.setString(5, KodeBarang);
            p.setString(6, Harga);
            p.setString(7, Jumlah);
            p.setString(8, Total);
            p.close();
        } catch (Exception e){
            
            System.out.println("simpan kasir error");      
        }
//        try {
//            Connection c = koneksi.getKoneksi();
//            int baris = jTabel1.getRowCount();
//            
//            for (int i = 0; i < baris; i++){
////                String sql = "INSERT INTO psa(No_Transaksi, Nama_Customer, No_HP, Kode_Barang, Jumlah, Deadline, Status, Last_Update) VALUES('" + jTabel1.getValueAt(i,0, NORMAL)+"','"+jTabel1.getValueAt(i,1, NORMAL)+"','"+jTabel1.getValueAt(i,2, NORMAL)+"','"+jTabel1.getValueAt(i,3, NORMAL)+"','"+jTabel1.getValueAt(i,4, NORMAL)+"','"+jTabel1.getValueAt(i,5, NORMAL)+"','";
//            }
//        }
    }//GEN-LAST:event_jButton9ActionPerformed
    
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
            java.util.logging.Logger.getLogger(KonveksiSablon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KonveksiSablon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KonveksiSablon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KonveksiSablon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 JFrame rm=new KonveksiSablon();
                //code dibawah ini yang harus ditambahkan sebelum pemanggilan form.
//                rm.setExtendedState(JFrame.MAXIMIZED_BOTH);
                rm.setVisible(true);
              

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PSA;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnHapusCustomer;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambahCustomer;
    private javax.swing.JComboBox<String> cmbJenisBarang;
    private javax.swing.JComboBox<String> cmbUkuran;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabel1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tabelCustomer;
    private javax.swing.JTable tabelInputBarang;
    private javax.swing.JTable tabelPSA;
    private javax.swing.JTextField txBayar;
    private javax.swing.JTextField txDeadline;
    private javax.swing.JTextField txHarga;
    private javax.swing.JTextField txIDBarang;
    private javax.swing.JTextField txJumlah;
    private javax.swing.JTextField txKembalian;
    private javax.swing.JTextField txNamaCustomer;
    private javax.swing.JTextField txProses;
    private javax.swing.JTextField txTampil;
    public javax.swing.JTextField txTotalBayar;
    private javax.swing.JTextField txTransaksi;
    private javax.swing.JTextField txtCariCustomer;
    private javax.swing.JTextField txtCariData;
    private javax.swing.JTextField txtHargaBeli;
    private javax.swing.JTextField txtHargaJual;
    private javax.swing.JTextField txtIdCustomer;
    public javax.swing.JTextField txtKodebarang;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtNamaCustomer;
    private javax.swing.JTextField txtNomorHp;
    // End of variables declaration//GEN-END:variables
class RoundedPanel extends JPanel
    {
        private Color backgroundColor;
        private int cornerRadius = 15;

        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;
        }
        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
        }
    }
class RoundedJTextField extends JTextField {
   private Shape shape;
   public RoundedJTextField(int size) {
   super(size);
   setOpaque(false);
}
protected void paintComponent(Graphics g) {
   g.setColor(getBackground());
   g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
   super.paintComponent(g);
}
protected void paintBorder(Graphics g) {
   g.setColor(getForeground());
   g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
}
public boolean contains(int x, int y) {
   if (shape == null || !shape.getBounds().equals(getBounds())) {
      shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
   }
   return shape.contains(x, y);
   }
  }
}
