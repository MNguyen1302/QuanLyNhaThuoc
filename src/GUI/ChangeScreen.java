/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import DTO.Item;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mynguyen
 */
public class ChangeScreen {
    private JPanel root;
    private String kindSelected = "";
    
    private ArrayList<Item> listItem = null;

    public ChangeScreen(JPanel jpn) {
        this.root = jpn;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem) throws Exception {
        kindSelected = "Home";
        
        jpnItem.setBackground(new Color(144,144,248));
        jlbItem.setBackground(new Color(144,144,248));
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new SanPham());
        root.validate();
        root.repaint();
    }
    
    public void setEvent(ArrayList<Item> listItem) {
        this.listItem = listItem;
        
        for (Item item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    
    class LabelEvent implements MouseListener {
        private JPanel node;
        private String kind;
        
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        @Override
        public void mouseClicked(MouseEvent me) {
            try {
                switch (kind) {
                    case "SanPham":
                        node = new SanPham();
                        break;
                    case "PhieuNhap":
                        node = new PhieuNhap();
                        break;
                    case "KhuyenMai":
                        node = new KhuyenMai();
                        break;
                    case "HoaDon":
                        node = new HoaDon();
                        break;
                    case "KhachHang":
                        node = new KhachHang();
                        break;
                    case "NhanVien":
                        node = new NhanVien();
                        break;
                    case "NhaCungCap":
                        node = new NhaCungCap();
                        break;
                    case "ThongKe":
                        node = new ThongKe();
                        break;
                    default:
                        node = new SanPham();
                }
                
                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(node);
                root.validate();
                root.repaint();
                setChangeBackground(this.kind);
            } catch (Exception ex) {
                Logger.getLogger(ChangeScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(144,144,248));
            jlbItem.setBackground(new Color(144,144,248));
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            jpnItem.setBackground(new Color(144,144,248));
            jlbItem.setBackground(new Color(144,144,248));
        }

        @Override
        public void mouseExited(MouseEvent me) {
            if (!kindSelected.equalsIgnoreCase(this.kind)) {
                jpnItem.setBackground(new Color(177,177,249));
                jlbItem.setBackground(new Color(177,177,249));
            }
        }
        
        public void setChangeBackground(String kind) {
            for (Item item : listItem) {
                if (item.getKind().equalsIgnoreCase(this.kind)) {
                    item.getJpn().setBackground(new Color(144,144,248));
                    item.getJlb().setBackground(new Color(144,144,248));
                } else {
                    item.getJpn().setBackground(new Color(177,177,249));
                    item.getJlb().setBackground(new Color(177,177,249));
                }
            }
        }
    }
}
