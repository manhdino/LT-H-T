
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class UI extends JFrame {
    private JPanel panel;
    private JLabel nameLabel;
    private JLabel phoneLabel;
    private JLabel startYearLabel;
    private JLabel majorLabel;
    private JLabel teachTimeLabel;
    private JLabel basicPayLabel;
    private JTextField phoneField;
    private JTextField nameField;
    private JTextField startYearField;
    private JTextField majorField;
    private JTextField teachTimeField;
    private JTextField basicPayField;
    private JRadioButton longTermselection;
    private JRadioButton shortTermselection;
    private JButton addBtn;
    private JButton searchBtn;
    private JTextField searchText;
    private JButton filterBySalaryBtn;
    private JTextField filterBySalaryText;
    private JScrollPane teacherScrollpane;
    private JTable teacherTable;
    //định nghĩa các cột của bảng
    private String [] columnNames = new String [] {
            "Tên", "Số điện thoại", "Năm về trường", "đơn vị", "Hệ số lương","Số giờ dạy","Lương tháng"};

    public UI(){
        super("Quản lý giáo viên");
        gui();
    }

    private void gui() {
        panel = new JPanel();
        // các panel
        nameLabel = new JLabel("Tên");
        phoneLabel= new JLabel("Số");
        startYearLabel= new JLabel("Năm về trường");
        majorLabel= new JLabel("Bộ môn");
        teachTimeLabel= new JLabel("số giờ dạy");
        basicPayLabel= new JLabel("hệ số lương");
        // các text filed
        nameField = new JTextField(20);
        phoneField = new JTextField(20);
        startYearField = new JTextField(20);
        teachTimeField = new JTextField(20);
        basicPayField = new JTextField(20);
        majorField = new JTextField(20);

        SpringLayout layout = new SpringLayout();
        panel.setSize(800, 600);
        panel.setLayout(layout);
        panel.add(nameLabel);
        panel.add(phoneLabel);
        panel.add(startYearLabel);
        panel.add(majorLabel);
        panel.add(basicPayLabel);
        panel.add(teachTimeLabel);
        panel.add(nameField);
        panel.add(phoneField);
        panel.add(startYearField);
        panel.add(majorField);
        panel.add(basicPayField);
        panel.add(teachTimeField);
        layout.putConstraint(SpringLayout.WEST, nameLabel, 10 ,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 10 ,SpringLayout.NORTH,panel);
        layout.putConstraint(SpringLayout.WEST, nameField, 100 ,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 10 ,SpringLayout.NORTH,panel);
        layout.putConstraint(SpringLayout.WEST, phoneLabel, 10 ,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH, phoneLabel, 40 ,SpringLayout.NORTH,panel);
        layout.putConstraint(SpringLayout.WEST, phoneField, 100 ,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH, phoneField, 40 ,SpringLayout.NORTH,panel);
        layout.putConstraint(SpringLayout.WEST, startYearLabel, 10 ,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH, startYearLabel, 80 ,SpringLayout.NORTH,panel);
        layout.putConstraint(SpringLayout.WEST, startYearField, 100 ,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH, startYearField, 80 ,SpringLayout.NORTH,panel);
        layout.putConstraint(SpringLayout.WEST, majorLabel, 10 ,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH, majorLabel, 120 ,SpringLayout.NORTH,panel);
        layout.putConstraint(SpringLayout.WEST, majorField, 100 ,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH, majorField, 120 ,SpringLayout.NORTH,panel);
        layout.putConstraint(SpringLayout.WEST, basicPayLabel, 10 ,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH, basicPayLabel, 160 ,SpringLayout.NORTH,panel);
        layout.putConstraint(SpringLayout.WEST, basicPayField, 100 ,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH, basicPayField, 160 ,SpringLayout.NORTH,panel);
        layout.putConstraint(SpringLayout.WEST, teachTimeLabel, 10 ,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH, teachTimeLabel, 200 ,SpringLayout.NORTH,panel);
        layout.putConstraint(SpringLayout.WEST, teachTimeField, 100 ,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH, teachTimeField, 200 ,SpringLayout.NORTH,panel);

        //Tạo 2 button để chọn nhập giáo viên mời giảng hay biên chế
        longTermselection = new JRadioButton();
        shortTermselection = new JRadioButton();
        panel.add(longTermselection);
        panel.add(shortTermselection);
        //đặt các radio button
        layout.putConstraint(SpringLayout.WEST, longTermselection, 325 ,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH, longTermselection, 160 ,SpringLayout.NORTH,panel);
        layout.putConstraint(SpringLayout.WEST, shortTermselection, 325 ,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,shortTermselection, 200 ,SpringLayout.NORTH,panel);
        //thiết lập chức năng cho radio button
        kindSelectionSetup();
        //cài đặt các button thêm và tìm kiếm
        addBtn = new JButton("Thêm");
        searchBtn = new JButton("Tìm kiếm");
        searchText = new JTextField("Tìm kiếm theo tên hoặc đơn vị chuyên môn",17);
        searchText.setPreferredSize(searchBtn.getPreferredSize());
        filterBySalaryBtn = new JButton("Lọc");
        filterBySalaryText = new JTextField("Lọc giáo viên theo lương!", 17);
        filterBySalaryText.setPreferredSize(searchBtn.getPreferredSize());
        panel.add(searchBtn);
        panel.add(searchText);
        panel.add(addBtn);
        panel.add(filterBySalaryBtn);
        panel.add(filterBySalaryText);
        //đặt các nút này vào vị trí.
        layout.putConstraint(SpringLayout.WEST, addBtn, 10 , SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH, addBtn, 240 , SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.WEST, searchBtn, 200 , SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH, searchBtn, 280 , SpringLayout.NORTH,panel);
        layout.putConstraint(SpringLayout.WEST, searchText, 10 , SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH, searchText, 280 , SpringLayout.NORTH,panel);
        layout.putConstraint(SpringLayout.WEST, filterBySalaryText, 10 , SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH, filterBySalaryText, 320 , SpringLayout.NORTH,panel);
        layout.putConstraint(SpringLayout.WEST, filterBySalaryBtn, 200 , SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,filterBySalaryBtn, 320 , SpringLayout.NORTH,panel);

        // cài đặt cho bảng hiển thị thông tin.

        this.add(panel);
        this.setSize(1200,600);
    }

    private void kindSelectionSetup(){
        basicPayLabel.setEnabled(false);
        basicPayField.setEnabled(false);
        teachTimeField.setEnabled(false);
        teachTimeLabel.setEnabled(false);
        //thiết lập chức năng cho radio button
        longTermselection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                basicPayLabel.setEnabled(true);
                basicPayField.setEnabled(true);
                teachTimeField.setEnabled(false);
                teachTimeLabel.setEnabled(false);
                shortTermselection.setSelected(false);
            }
        });
        shortTermselection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                basicPayLabel.setEnabled(false);
                basicPayField.setEnabled(false);
                teachTimeField.setEnabled(true);
                teachTimeLabel.setEnabled(true);
                longTermselection.setSelected(false);
            }
        });
    }


}