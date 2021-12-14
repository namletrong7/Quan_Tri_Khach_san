/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject.view;

import com.opencsv.exceptions.CsvValidationException;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.text.ParseException;
import java.util.ArrayList;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import testproject.model.DocGhiFile;
import testproject.model.DatPhong;
import testproject.model.KhachHang;
import testproject.model.Phong;

/**
 *
 * @author phuon
 */
public class DatPhongView extends javax.swing.JFrame {

    /**
     * Creates new form DatPhong
     */
    DefaultTableModel tableModel;
    int id = 0;

    private List<DatPhong> listDP = new ArrayList<>();
    private List<Phong> listP = new ArrayList<>();
    private List<KhachHang> listKH = new ArrayList<>();
    DocGhiFile docGhiFile = new DocGhiFile();
    private static final String curentDir = System.getProperty("user.dir");
    private static final String separator = File.separator;
    private static final String PATH_FILE_CSV_DatPhong = curentDir + separator + "data" + separator + "DatPhong.csv";
    private static final String PATH_FILE_CSV_PHONG = curentDir + separator + "data" + separator + "Phong.csv";
    private static File fileDP = new File(PATH_FILE_CSV_DatPhong);
    private static File fileP = new File(PATH_FILE_CSV_PHONG);
    private static final String PATH_FILE_CSV_KhachHang = curentDir + separator + "data" + separator + "KhachHang.csv";
    private static File fileKH = new File(PATH_FILE_CSV_KhachHang);
    private SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public DatPhongView() {
        this.dispose();
        System.out.println(PATH_FILE_CSV_DatPhong);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Nhập thông tin đặt phòng");
        tableModel = (DefaultTableModel) tblDatPhong.getModel();

        if (fileDP.exists()) {
            try {
                listDP = docGhiFile.docFileDatPhong();
                if (listDP.size() == 0) {
                    fileDP.delete();
                    DatPhongView dp = new DatPhongView();
                    dp.setVisible(true);
                } else {
                    String ma = listDP.get(listDP.size() - 1).getMaDatPhong();
                    id = Integer.parseInt(ma.substring(2)) + 1;
                    hienTHi(listDP);
                }
            } catch (CsvValidationException ex) {
                Logger.getLogger(DatPhongView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(DatPhongView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (fileKH.exists()) {
            try {
                listKH = docGhiFile.docFileKhachHang();
            } catch (CsvValidationException ex) {
                Logger.getLogger(DatPhongView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (fileP.exists()) {
            try {
                listP = docGhiFile.docFilePhong();
            } catch (CsvValidationException ex) {
                Logger.getLogger(DatPhongView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void hienTHi(List<DatPhong> DatPhong) {
        tableModel.setRowCount(0);

        for (DatPhong item : DatPhong) {
            String maDatPhong = item.getMaDatPhong();
            String maPhong = item.getMaPhong();
            String maKhachHang = item.getMaKhachHang();
            Date ngayDat = item.getNgayDat();
            Date ngayTra = item.getNgayTra();
            double thanhToan = item.getTongTien();

            tableModel.addRow(new Object[]{maDatPhong, maPhong, maKhachHang, df.format(ngayDat), df.format(ngayTra), thanhToan});
        }
    }

    public double ThanhToan(Date ngayDat, Date ngayTra, double giaPhong) {
        long getDate = ngayTra.getTime() - ngayDat.getTime();
        long Days = TimeUnit.MILLISECONDS.toDays(getDate);

        return giaPhong * (double) Days;
    }

    public void reset() {
        txtMaPhong.setText("");
        txtMaKhachHang.setText("");
        Date date = java.util.Calendar.getInstance().getTime();
        txtNgayDat.setDate(date);
        txtNgayTra.setDate(date);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnQuayLaij = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMaKhachHang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnDatPhong = new javax.swing.JButton();
        chinhSua = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSort = new javax.swing.JButton();
        btnFinding = new javax.swing.JButton();
        txtFind = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDatPhong = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();
        txtSort = new javax.swing.JComboBox<>();
        txtNgayDat = new com.toedter.calendar.JDateChooser();
        txtNgayTra = new com.toedter.calendar.JDateChooser();
        btnThanhToan = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(190, 220, 227));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đặt Phòng Khách Sạn");

        btnQuayLaij.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/view/icon/iconBaack.png"))); // NOI18N
        btnQuayLaij.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaijActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnQuayLaij)
                .addGap(377, 377, 377)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(585, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnQuayLaij)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 138, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 51));
        jLabel3.setText("Mã Phòng: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, -1, -1));

        txtMaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhongActionPerformed(evt);
            }
        });
        getContentPane().add(txtMaPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 240, 33));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setText("Mã Khách Hàng: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, -1, -1));

        txtMaKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKhachHangActionPerformed(evt);
            }
        });
        getContentPane().add(txtMaKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 240, 33));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 0, 0));
        jLabel5.setText("Ngày đặt:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 0));
        jLabel6.setText("Ngày trả:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 170, -1, -1));

        btnDatPhong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/view/icon/sign-add-icon.png"))); // NOI18N
        btnDatPhong.setText("Đặt Phòng");
        btnDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatPhongActionPerformed(evt);
            }
        });
        getContentPane().add(btnDatPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 311, -1, -1));

        chinhSua.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chinhSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/view/icon/icons8-pencil-48.png"))); // NOI18N
        chinhSua.setText("Chỉnh sửa ");
        chinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chinhSuaActionPerformed(evt);
            }
        });
        getContentPane().add(chinhSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 311, -1, -1));

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/view/icon/icons8-trash-48.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 311, -1, -1));

        btnSort.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/view/icon/icon-sapxep.png"))); // NOI18N
        btnSort.setText("Sắp xếp");
        btnSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortActionPerformed(evt);
            }
        });
        getContentPane().add(btnSort, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 310, -1, -1));

        btnFinding.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnFinding.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/view/icon/iconTimKiem.png"))); // NOI18N
        btnFinding.setText("Tìm kiếm");
        btnFinding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindingActionPerformed(evt);
            }
        });
        getContentPane().add(btnFinding, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 311, -1, -1));

        txtFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindActionPerformed(evt);
            }
        });
        getContentPane().add(txtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 220, 220, 32));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 0, 0));
        jLabel7.setText("Tìm kiếm: ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 230, -1, -1));

        tblDatPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Đặt Phòng", "Mã Phòng", "Mã Khách Hàng", "Ngày Đặt", "Ngày Trả", "Tổng Tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDatPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatPhongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDatPhong);
        if (tblDatPhong.getColumnModel().getColumnCount() > 0) {
            tblDatPhong.getColumnModel().getColumn(0).setMinWidth(100);
            tblDatPhong.getColumnModel().getColumn(0).setMaxWidth(50);
            tblDatPhong.getColumnModel().getColumn(1).setMinWidth(100);
            tblDatPhong.getColumnModel().getColumn(1).setMaxWidth(50);
            tblDatPhong.getColumnModel().getColumn(2).setMinWidth(100);
            tblDatPhong.getColumnModel().getColumn(2).setMaxWidth(50);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 1230, 380));

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/view/icon/iconLamMoi.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(749, 311, -1, -1));

        txtSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ma Phong", "Ma Khach Hang", "Tong Tien" }));
        txtSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSortActionPerformed(evt);
            }
        });
        getContentPane().add(txtSort, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 270, -1, 31));

        txtNgayDat.setDateFormatString("dd-MM-yyyy HH:mm:ss");
        getContentPane().add(txtNgayDat, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 96, -1, 40));

        txtNgayTra.setDateFormatString("dd-MM-yyyy HH:mm:ss");
        getContentPane().add(txtNgayTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 156, -1, 40));

        btnThanhToan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/view/icon/icons8-cash-in-hand-96.png"))); // NOI18N
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });
        getContentPane().add(btnThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 310, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/view/icon/background-thien-nhien-dep-nhat_110344000.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1280, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPhongActionPerformed

    private void txtMaKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKhachHangActionPerformed

    private void chinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chinhSuaActionPerformed
        int selectedRow = tblDatPhong.getSelectedRow();
        if (selectedRow >= 0) {
            String maDatPhong = (String) tblDatPhong.getValueAt(selectedRow, 0);
            for (DatPhong item : listDP) {
                if (maDatPhong.equals(item.getMaDatPhong())) {
                    item.setMaPhong(txtMaPhong.getText());
                    item.setMaKhachHang(txtMaKhachHang.getText());
                    item.setNgayDat(txtNgayDat.getDate());
                    item.setNgayTra(txtNgayTra.getDate());
                    break;
                }
            }
            fileDP.delete();
            docGhiFile.ghiFileDatPhong(listDP);
            hienTHi(listDP);
            reset();
        }
    }//GEN-LAST:event_chinhSuaActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = tblDatPhong.getSelectedRow();
        if (selectedRow >= 0) {
            String maDatPhong = (String) tblDatPhong.getValueAt(selectedRow, 0);
            for (DatPhong item : listDP) {
                if (maDatPhong.equals(item.getMaDatPhong())) {
                    listDP.remove(item);
                    break;
                }
            }
            String maPhong = (String) tblDatPhong.getValueAt(selectedRow, 1);
            for (Phong item : listP) {
                if (item.getMaPhong().equals(maPhong)) {
                    item.setTrangThai("Con Trong");
                    break;
                }
            }
            fileP.delete();
            docGhiFile.ghiFilePhong(listP);
            fileDP.delete();
            docGhiFile.ghiFileDatPhong(listDP);
            hienTHi(listDP);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortActionPerformed
        if (txtSort.getSelectedItem().equals("Ma Phong")) {
            Collections.sort(listDP, new Comparator<DatPhong>() {
                @Override
                public int compare(DatPhong o1, DatPhong o2) {
                    int item1 = Integer.parseInt(o1.getMaPhong().substring(2));
                    int item2 = Integer.parseInt(o2.getMaPhong().substring(2));
                    return item1 > item2 ? 1 : -1;
                }

            });
        } else if (txtSort.getSelectedItem().equals("Ma Khach Hang")) {
            Collections.sort(listDP, new Comparator<DatPhong>() {
                @Override
                public int compare(DatPhong o1, DatPhong o2) {
                    int item1 = Integer.parseInt(o1.getMaKhachHang().substring(2));
                    int item2 = Integer.parseInt(o2.getMaKhachHang().substring(2));
                    return item1 > item2 ? 1 : -1;
                }
            });
        } else if (txtSort.getSelectedItem().equals("Tong Tien")) {
            Collections.sort(listDP, new Comparator<DatPhong>() {
                @Override
                public int compare(DatPhong o1, DatPhong o2) {
                    return o1.getTongTien() > o2.getTongTien() ? 1 : -1;
                }
            });
        }
        hienTHi(listDP);
    }//GEN-LAST:event_btnSortActionPerformed

    private void btnFindingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindingActionPerformed
        String textFinding = txtFind.getText();
        tableModel.setRowCount(0);
        boolean flagFinding = false;
        for (DatPhong item : listDP) {
            if (item.getMaDatPhong().equals(textFinding)) {
                String maDatPhong = item.getMaDatPhong();
                String maPhong = item.getMaPhong();
                String maKhachHang = item.getMaKhachHang();
                Date ngayDat = item.getNgayDat();
                Date ngayTra = item.getNgayTra();
                double thanhToan = item.getTongTien();
                flagFinding = true;

                tableModel.addRow(new Object[]{maDatPhong, maPhong, maKhachHang, ngayDat, ngayTra, thanhToan});
            } else if (item.getMaPhong().equals(textFinding)) {
                String maDatPhong = item.getMaDatPhong();
                String maPhong = item.getMaPhong();
                String maKhachHang = item.getMaKhachHang();
                Date ngayDat = item.getNgayDat();
                Date ngayTra = item.getNgayTra();
                double thanhToan = item.getTongTien();
                flagFinding = true;

                tableModel.addRow(new Object[]{maDatPhong, maPhong, maKhachHang, ngayDat, ngayTra, thanhToan});
            } else if (item.getMaKhachHang().equals(textFinding)) {
                String maDatPhong = item.getMaDatPhong();
                String maPhong = item.getMaPhong();
                String maKhachHang = item.getMaKhachHang();
                Date ngayDat = item.getNgayDat();
                Date ngayTra = item.getNgayTra();
                double thanhToan = item.getTongTien();
                flagFinding = true;

                tableModel.addRow(new Object[]{maDatPhong, maPhong, maKhachHang, ngayDat, ngayTra, thanhToan});
            }
        }
        if (flagFinding == false) {
            JOptionPane.showMessageDialog(rootPane, "Không tìm thấy thông tin đặt phòng");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFindingActionPerformed
    public boolean checkMaKH(String text) {
        for (KhachHang x : listKH) {
            if (x.getMaKhachHang().equalsIgnoreCase(text)) {
                return true;
            }
        }
        return false;
    }

    public boolean kiemTraMaKhachHang() {
        boolean flag = false;
        for (KhachHang item : listKH) {
            if (item.getMaKhachHang().equals(txtMaKhachHang.getText())) {
                flag = true;
                System.out.println(item.getMaKhachHang());
            }
        }
        if (flag == false) {
            return false;
        } else {
            return true;
        }
    }

    public double tinhTongTien(double thoiGian, double giaPhong) {
        double tongTien = 0;
        if (thoiGian < 24) {
            System.out.println("a");
            System.out.println(tongTien);
            if (thoiGian > 0 && thoiGian <= 2) {
                tongTien = giaPhong * 15 / 100;
            } else if (thoiGian > 2 && thoiGian <= 5) {
                tongTien = giaPhong * 25 / 100;
            } else if (thoiGian > 5) {
                tongTien = giaPhong * thoiGian * 10 / 100;
            }
        } else if (thoiGian >= 24) {
            System.out.println(tongTien);
            System.out.println("b");
            int a = (int) (thoiGian / 24);
            double b = thoiGian - (double) 24 * a;
            System.out.println(a);
            if (b > 0 && b <= 2) {
                tongTien = giaPhong * 15 / 100 + giaPhong * a;
            } else if (b > 2 && b <= 5) {
                tongTien = giaPhong * 25 / 100 + giaPhong * a;
            } else if (b > 5) {
                tongTien = giaPhong * 10 / 100 * b + giaPhong * a;
            } else if (b == 0) {
                tongTien = giaPhong * a;
            }
        }
        return tongTien;
    }
    private void btnDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatPhongActionPerformed
        StringBuilder sb = new StringBuilder();
        if (txtMaKhachHang.getText().equals("")) {
            sb.append("Mã khách hàng không được để trống\n");
        }
        if (txtMaPhong.getText().equals("")) {
            sb.append("Mã phòng không được để trống\n");
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(rootPane,
                    sb.toString(), "Backup problem", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (kiemTraMaKhachHang() == false) {
            JOptionPane.showMessageDialog(rootPane,
                    "Thông tin Khách hàng không tồn tại!!! Hãy nhập thông tin khách hàng ở bên thông tin khách hàng", "Backup problem", JOptionPane.WARNING_MESSAGE);
            txtMaKhachHang.requestFocus();
            return;
        }

        String maPhong = txtMaPhong.getText();
        boolean flag = false;
        String maKhachHang = txtMaKhachHang.getText();
        for (Phong item : listP) {
            if (item.getMaPhong().equals(maPhong) && item.getTrangThai().equals("Con Trong")) {
                Date ngayDat = txtNgayDat.getDate();
                Date ngayTra = txtNgayTra.getDate();
                System.out.println("ngay dat" + ngayDat);
                System.out.println("ngay dat" + ngayTra);
                String maDatPhong = "DP" + id++;
                item.setTrangThai("Da dat");
                double giaPhong = item.getGiaPhong();
                long a = (ngayTra.getTime()) - (ngayDat.getTime());
                double phut = a / (60 * 1000) % 60;
                double gio = a / (60 * 60 * 1000);
                double thoiGian = phut / 60 + gio;
                System.out.println(thoiGian);
                Double TongTien = tinhTongTien(thoiGian, giaPhong);
                DatPhong dp = new DatPhong(maDatPhong, maPhong, maKhachHang, ngayDat, ngayTra, TongTien);
                listDP.add(dp);
                tableModel.addRow(new Object[]{maDatPhong, maPhong, maKhachHang, ngayDat, ngayTra, TongTien});
                fileDP.delete();
                docGhiFile.ghiFileDatPhong(listDP);
                fileP.delete();
                docGhiFile.ghiFilePhong(listP);
                hienTHi(listDP);
                flag = true;
                reset();
                break;

            }
        }
        if (flag == false) {
            JOptionPane.showMessageDialog(rootPane, "Mã phòng không tồn tại hoặc đã được đặt \n xin vui lòng check lại thông tin");
        }

//        Xử lý set trạng thái phòng tương ứng với mã phòng

    }//GEN-LAST:event_btnDatPhongActionPerformed

    private void txtFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFindActionPerformed

    private void tblDatPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatPhongMouseClicked
        int selectedRow = tblDatPhong.getSelectedRow();
        if (selectedRow >= 0) {
            String maDatPhong = (String) tblDatPhong.getValueAt(selectedRow, 0);
            for (DatPhong item : listDP) {
                if (maDatPhong.equals(item.getMaDatPhong())) {
                    txtMaPhong.setText(item.getMaPhong());
                    txtMaKhachHang.setText(item.getMaKhachHang());
                    txtNgayDat.setDate(item.getNgayDat());
                    txtNgayTra.setDate(item.getNgayTra());
                    break;
                }
            }
        }
    }//GEN-LAST:event_tblDatPhongMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtMaKhachHang.setText("");
        txtMaPhong.setText("");
        txtFind.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSortActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int selectedRow = tblDatPhong.getSelectedRow();
        if (selectedRow >= 0) {
            String maDatPhong = (String) tblDatPhong.getValueAt(selectedRow, 0);
            String maPhong = (String) tblDatPhong.getValueAt(selectedRow, 1);
            for (DatPhong item : listDP) {
                if (maDatPhong.equals(item.getMaDatPhong())) {
                    listDP.remove(item);
                    JOptionPane.showConfirmDialog(null, "Đã thanh toán thành công\nXin cảm ơn", "Thông báo", JOptionPane.CLOSED_OPTION);
                    for (Phong item1 : listP) {
                        if (item1.getMaPhong().equals(maPhong)) {
                            item1.setTrangThai("Con Trong");
                        }
                    }
                    break;
                }
            }
            fileP.delete();
            docGhiFile.ghiFilePhong(listP);
            fileDP.delete();
            docGhiFile.ghiFileDatPhong(listDP);
            hienTHi(listDP);
        }

    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnQuayLaijActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaijActionPerformed
        // TODO  close()add your handling code here:
        close();
        new Menu().setVisible(true);
    }//GEN-LAST:event_btnQuayLaijActionPerformed
    public void close() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    /**
     * @param args the command line arguments
     */
    public static void main() {
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
            java.util.logging.Logger.getLogger(DatPhongView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatPhongView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatPhongView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatPhongView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatPhongView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatPhong;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFinding;
    private javax.swing.JButton btnQuayLaij;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSort;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton chinhSua;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDatPhong;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtMaPhong;
    private com.toedter.calendar.JDateChooser txtNgayDat;
    private com.toedter.calendar.JDateChooser txtNgayTra;
    private javax.swing.JComboBox<String> txtSort;
    // End of variables declaration//GEN-END:variables
}
